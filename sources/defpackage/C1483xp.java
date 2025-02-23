package defpackage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cris.org.in.ima.activities.PgWebViewActivity;

/* renamed from: xp  reason: default package and case insensitive filesystem */
/* compiled from: PgWebViewActivity */
public final class C1483xp extends WebViewClient {
    public final /* synthetic */ PgWebViewActivity a;

    public C1483xp(PgWebViewActivity pgWebViewActivity) {
        this.a = pgWebViewActivity;
    }

    public final void onPageFinished(WebView webView, String str) {
        ProgressDialog progressDialog = this.a.f4269a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        PgWebViewActivity pgWebViewActivity = this.a;
        if (!pgWebViewActivity.f4271a) {
            pgWebViewActivity.f4269a = ProgressDialog.show(pgWebViewActivity, (CharSequence) null, "loading, please wait...");
        }
        super.onPageStarted(webView, str, bitmap);
        pgWebViewActivity.f4271a = true;
    }
}
