package in.juspay.hypersdk.safe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.utils.Utils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JuspayWebViewClient extends WebViewClient {
    private static final String LOG_TAG = "in.juspay.hypersdk.safe.JuspayWebViewClient";
    private WebViewClient delegate;
    private final Godel godelManager;
    private final JuspayWebView juspayWebView;
    public String latestStartUrl;

    public JuspayWebViewClient(Godel godel, JuspayWebView juspayWebView2) {
        this.godelManager = godel;
        this.juspayWebView = juspayWebView2;
        if (godel.getJuspayServices().getHyperCallback() != null) {
            this.delegate = godel.getJuspayServices().getHyperCallback().createJuspaySafeWebViewClient();
        }
    }

    private JSONArray getIntentUris() {
        return Utils.optJSONArray(this.godelManager.getJuspayServices().getSdkConfigService().getSdkConfig(), "intentURIs");
    }

    private void insertACS() {
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        FileProviderService fileProviderService = juspayServices.getFileProviderService();
        PaymentSessionInfo paymentSessionInfo = this.godelManager.getPaymentSessionInfo();
        if (paymentSessionInfo.isGodelEnabled()) {
            this.godelManager.getDuiInterface().setSessionAttribute(PaymentConstants.Category.CONFIG, this.godelManager.getConfig().toString());
            this.juspayWebView.addJsToWebView("window.juspayContext = {}; juspayContext['web_lab_rules'] = " + this.godelManager.getConfig().getJSONObject("weblab"));
        }
        if (paymentSessionInfo.isGodelEnabled()) {
            String readFromFile = fileProviderService.readFromFile(juspayServices.getContext(), PaymentConstants.ACS);
            this.juspayWebView.addJsToWebView(readFromFile);
            juspayServices.sdkDebug(LOG_TAG, "Tracking weblab rules in acs");
            this.juspayWebView.addJsToWebView("__juspay.trackWebLabRules();");
            if (paymentSessionInfo.getAcsJsHash() == null) {
                paymentSessionInfo.setAcsJsHash(EncryptionHelper.md5(readFromFile));
                juspayServices.getSdkTracker().trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JUSPAY_WEBVIEW_CLIENT, "hash_of_inserted_acs_min_script", paymentSessionInfo.getAcsJsHash());
                return;
            }
            return;
        }
        juspayServices.sdkDebug(LOG_TAG, "disabling_insertion_of_java_script_since_jb_is_disabled");
    }

    private boolean openIntentFromGodel(String str) {
        JSONArray intentUris = getIntentUris();
        int i = 0;
        while (i < intentUris.length()) {
            try {
                if (str.startsWith(intentUris.getString(i))) {
                    this.godelManager.getJuspayServices().getSdkTracker().trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JUSPAY_WEBVIEW_CLIENT, "intent_uri", str);
                    this.godelManager.getJuspayServices().startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), -1, (Bundle) null);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    this.godelManager.getAcsInterface().invoke("openIntentFromGodel", jSONObject.toString());
                    return true;
                }
                i++;
            } catch (Exception e) {
                this.godelManager.getJuspayServices().getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception in shouldOverrideUrlLoading", e);
            }
        }
        return false;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("title", webView.getTitle());
                this.godelManager.getAcsInterface().invoke("onPageFinished", jSONObject.toString());
            }
            CookieSyncManager.getInstance().sync();
            insertACS();
        } catch (JSONException e) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageFinished event", e);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        Godel godel = this.godelManager;
        godel.isRupaySupportedAdded = false;
        if (godel.isDuiLoaded()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
            } catch (JSONException e) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageStarted event", e);
            }
            this.godelManager.getAcsInterface().invoke("onPageStarted", jSONObject.toString());
        }
        this.latestStartUrl = str;
        juspayServices.getSessionInfo().set("currentUrl", str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
        try {
            List<String> allowedDeeplinkPackages = this.godelManager.getAllowedDeeplinkPackages();
            if (allowedDeeplinkPackages.size() != 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                List<ResolveInfo> queryIntentActivities = this.godelManager.getContext().getPackageManager().queryIntentActivities(intent, 65536);
                if (queryIntentActivities != null) {
                    String str2 = null;
                    for (ResolveInfo next : queryIntentActivities) {
                        JuspayLogger.d(LOG_TAG, next.activityInfo.packageName);
                        if (str2 == null && allowedDeeplinkPackages.contains(next.activityInfo.packageName)) {
                            str2 = next.activityInfo.packageName;
                        }
                    }
                    if (str2 == null && queryIntentActivities.size() > 1) {
                        JuspayLogger.e(LOG_TAG, "Too many activities");
                    } else if (queryIntentActivities.size() == 0) {
                    } else {
                        if (allowedDeeplinkPackages.contains(queryIntentActivities.get(0).activityInfo.packageName)) {
                            intent.setPackage(str2);
                            this.godelManager.getJuspayServices().startActivityForResult(intent, -1, (Bundle) null);
                            this.godelManager.getJuspayServices().addJsToWebView("if (window.onDeepLinkUrlAppOpen != null) { window.onDeepLinkUrlAppOpen('{}'); }");
                        }
                    }
                }
            }
        } catch (Exception e2) {
            sdkTracker.trackException(PaymentConstants.Category.GODEL, LogSubCategory.ApiCall.SDK, Labels.SDK.WEBVIEW_CLIENT, C0709Uj.i("Exception when trying to launch deeplink activity for ", str), e2);
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", i);
                this.godelManager.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                insertACS();
            }
        } catch (JSONException e) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @TargetApi(23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.delegate != null) {
            return onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        super.onScaleChanged(webView, f, f2);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f, f2);
        }
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse shouldInterceptRequest = this.godelManager.shouldInterceptRequest(webResourceRequest);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || shouldInterceptRequest != null) ? shouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        if (openIntentFromGodel(webResourceRequest.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", webResourceError.getErrorCode());
                this.godelManager.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                insertACS();
                CookieSyncManager.getInstance().sync();
            }
        } catch (JSONException e) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest = this.godelManager.shouldInterceptRequest(str);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || shouldInterceptRequest != null) ? shouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, str);
        }
        if (openIntentFromGodel(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
