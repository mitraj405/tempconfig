package defpackage;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: Z0  reason: default package */
/* compiled from: ApiHelperForO */
public final class Z0 {
    public static PackageInfo a() {
        return WebView.getCurrentWebViewPackage();
    }

    public static boolean b(WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    public static WebChromeClient c(WebView webView) {
        return webView.getWebChromeClient();
    }

    public static WebViewClient d(WebView webView) {
        return webView.getWebViewClient();
    }

    public static void e(WebSettings webSettings, boolean z) {
        webSettings.setSafeBrowsingEnabled(z);
    }
}
