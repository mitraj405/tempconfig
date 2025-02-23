package com.momagic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class DATBWebViewActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public WebView a;

    /* renamed from: c  reason: collision with other field name */
    public String f4013c;

    public class a extends WebViewClient {
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }
    }

    public final void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("WEB_URL")) {
            this.f4013c = extras.getString("WEB_URL");
        }
        WebView webView = (WebView) findViewById(C0487Dr.webView);
        this.a = webView;
        WebSettings settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLoadsImagesAutomatically(true);
        this.a.setWebChromeClient(new WebChromeClient());
        this.a.setVerticalScrollBarEnabled(false);
        this.a.setHorizontalScrollBarEnabled(false);
        this.a.setWebViewClient(new a());
        this.a.loadUrl(this.f4013c);
    }

    public final void onBackPressed() {
        if (this.a.canGoBack()) {
            this.a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0683Sr.activity_webview);
        l();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        l();
    }
}
