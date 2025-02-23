package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;

public class TermsAndConditionActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f4364c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    @BindView(2131362758)
    RelativeLayout header;
    public String i;
    public String j;
    @BindView(2131364917)
    WebView tNcWebview;
    @BindView(2131364663)
    TextView titleName;

    public class a extends WebViewClient {
        public a() {
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean startsWith = str.startsWith("upi:");
            TermsAndConditionActivity termsAndConditionActivity = TermsAndConditionActivity.this;
            if (!startsWith) {
                termsAndConditionActivity.tNcWebview.loadUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
            new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
            int i = TermsAndConditionActivity.c;
            termsAndConditionActivity.getClass();
            throw null;
        }
    }

    static {
        C1354qp.R(TermsAndConditionActivity.class);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    public final void init() {
        String str = this.f4364c;
        if (str == null || !str.equalsIgnoreCase("RefundStatusZonal")) {
            String str2 = this.d;
            if (str2 == null || !str2.equals("true")) {
                String str3 = this.e;
                if (str3 == null || !str3.equals("Ewallet")) {
                    String str4 = this.f;
                    if (str4 == null || !str4.equals("Magazine")) {
                        String str5 = this.h;
                        if (str5 == null || !str5.equals("AskDisha")) {
                            String str6 = this.j;
                            if (str6 == null || !str6.equals("Zee5")) {
                                String str7 = this.i;
                                if (str7 == null || !str7.equals("pledge")) {
                                    this.titleName.setText(C1218kf.TERM_AND_CONDITIONS.a());
                                    return;
                                }
                                this.titleName.setText(C1218kf.Integrity_Pledge.a());
                                this.header.setVisibility(8);
                                return;
                            }
                            this.titleName.setText(C1218kf.ZEE5.a());
                            this.header.setVisibility(8);
                            return;
                        }
                        this.header.setVisibility(8);
                        return;
                    }
                    this.titleName.setText(C1218kf.DIGITAL_MAGZINE.a());
                    return;
                }
                this.titleName.setText(C1218kf.EWALLET_HELP_LINK.a());
                return;
            }
            this.titleName.setText("Insurance Policy");
            return;
        }
        this.titleName.setText(C1218kf.TDR_REFUND_STATUS.a());
    }

    @OnClick({2131362879})
    public void onBackArrowClick() {
        onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_terms_and_conditions);
        ButterKnife.bind((Activity) this);
        Intent intent = getIntent();
        this.g = intent.getStringExtra("term&condition");
        this.f4364c = intent.getStringExtra("url");
        this.d = intent.getStringExtra("isInsuranceOpted");
        this.e = intent.getStringExtra("ewalletIrctc");
        intent.getStringExtra("menusection");
        intent.getStringExtra("pnr");
        this.f = intent.getStringExtra("Magazine");
        this.h = intent.getStringExtra("AskDisha");
        this.j = intent.getStringExtra("Zee5");
        this.i = intent.getStringExtra("pledge");
        String str = this.f4364c;
        if (str == null || !str.equalsIgnoreCase("RefundStatusZonal")) {
            String str2 = this.d;
            if (str2 == null || !str2.equals("true")) {
                String str3 = this.e;
                if (str3 == null || !str3.equals("Ewallet")) {
                    String str4 = this.i;
                    if (str4 == null || !str4.equals("pledge")) {
                        String str5 = this.g;
                        if (str5 == null || !str5.equals("term&condition")) {
                            String str6 = this.f;
                            if (str6 == null || !str6.equals("Magazine")) {
                                String str7 = this.h;
                                if (str7 == null || !str7.equalsIgnoreCase("AskDisha")) {
                                    String str8 = this.j;
                                    if (str8 == null || !str8.equalsIgnoreCase("Zee5")) {
                                        this.tNcWebview.getSettings().setJavaScriptEnabled(true);
                                        this.tNcWebview.loadUrl("https://docs.google.com/gview?embedded=true&url=https://contents.irctc.co.in/en/Terms%20and%20conditions.pdf");
                                    } else {
                                        this.tNcWebview.getSettings().setJavaScriptEnabled(true);
                                        this.tNcWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                                        this.tNcWebview.getSettings().setDomStorageEnabled(true);
                                        this.tNcWebview.loadUrl("https://b2bapi.zee5.com/cl/premium-packs.php?code=ATCJS8DK0SJ320LK&name=IRCTC&utm_source=irctc_cl&utm_medium=irctc&utm_campaign=android_irctc_app");
                                    }
                                } else {
                                    this.tNcWebview.setLayerType(2, (Paint) null);
                                    this.tNcWebview.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.61 Mobile Safari/537.36");
                                    this.tNcWebview.getSettings().setJavaScriptEnabled(true);
                                    this.tNcWebview.getSettings().setDomStorageEnabled(true);
                                    this.tNcWebview.getSettings().setDatabaseEnabled(true);
                                    CookieManager.getInstance().setAcceptThirdPartyCookies(this.tNcWebview, true);
                                    this.tNcWebview.setWebViewClient(new a());
                                    this.tNcWebview.loadUrl("https://askdisha.irctc.co.in/eticket/#app");
                                }
                            } else {
                                WebSettings settings = this.tNcWebview.getSettings();
                                this.tNcWebview.setWebChromeClient(new WebChromeClient());
                                this.tNcWebview.setWebViewClient(new WebViewClient());
                                this.tNcWebview.setScrollContainer(false);
                                this.tNcWebview.setVerticalScrollBarEnabled(false);
                                this.tNcWebview.setHorizontalScrollBarEnabled(false);
                                settings.setBuiltInZoomControls(true);
                                settings.setSupportZoom(true);
                                settings.setDisplayZoomControls(false);
                                settings.setLoadWithOverviewMode(true);
                                settings.setUseWideViewPort(true);
                                this.tNcWebview.clearCache(true);
                                this.tNcWebview.setOverScrollMode(2);
                                this.tNcWebview.loadUrl(getResources().getString(R.string.digital_magzine_url));
                            }
                        } else {
                            this.tNcWebview.loadUrl("https://docs.google.com/gview?embedded=true&url=https://contents.irctc.co.in/en/Terms%20and%20conditions.pdf");
                        }
                    } else {
                        this.tNcWebview.getSettings().setJavaScriptEnabled(true);
                        this.tNcWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                        this.tNcWebview.getSettings().setDomStorageEnabled(true);
                        this.tNcWebview.getSettings().setLoadsImagesAutomatically(true);
                        this.tNcWebview.loadUrl("https://pledge.cvc.nic.in/");
                    }
                } else {
                    this.tNcWebview.loadUrl("https://contents.irctc.co.in/en/AboutEwalletMob.html");
                }
            } else {
                this.tNcWebview.loadUrl("https://docs.google.com/gview?embedded=true&url=https://contents.irctc.co.in/en/InsuranceTermCondition.pdf");
            }
        } else {
            this.tNcWebview.loadUrl("https://www.refunds.indianrail.gov.in/refund/refund.ref_status");
        }
        this.tNcWebview.getSettings().setJavaScriptEnabled(true);
        this.tNcWebview.setWebViewClient(new WebViewClient());
        init();
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.tNcWebview.canGoBack()) {
            this.tNcWebview.goBack();
            return true;
        }
        finish();
        return true;
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }
}
