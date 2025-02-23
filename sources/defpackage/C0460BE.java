package defpackage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cris.org.in.ima.activities.ZaakpayActivity;

/* renamed from: BE  reason: default package and case insensitive filesystem */
/* compiled from: ZaakpayActivity */
public final class C0460BE extends WebViewClient {
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ZaakpayActivity f3530a;

    public C0460BE(ZaakpayActivity zaakpayActivity) {
        this.f3530a = zaakpayActivity;
    }

    public final void onPageFinished(WebView webView, String str) {
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ZaakpayActivity zaakpayActivity = this.f3530a;
        if (!zaakpayActivity.f4374a) {
            this.a = ProgressDialog.show(zaakpayActivity, (CharSequence) null, "loading, please wait...");
        }
        super.onPageStarted(webView, str, bitmap);
        zaakpayActivity.f4374a = true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
