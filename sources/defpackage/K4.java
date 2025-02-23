package defpackage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cris.org.in.ima.payment.CashOnDeliveryActivity;

/* renamed from: K4  reason: default package */
/* compiled from: CashOnDeliveryActivity */
public final class K4 extends WebViewClient {
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CashOnDeliveryActivity f3672a;

    public K4(CashOnDeliveryActivity cashOnDeliveryActivity) {
        this.f3672a = cashOnDeliveryActivity;
    }

    public final void onLoadResource(WebView webView, String str) {
        CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.a;
        this.a.dismiss();
        super.onLoadResource(webView, str);
    }

    public final void onPageFinished(WebView webView, String str) {
        CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.a;
        this.a.dismiss();
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.a;
        CashOnDeliveryActivity cashOnDeliveryActivity2 = this.f3672a;
        if (!cashOnDeliveryActivity2.f5356a) {
            this.a = ProgressDialog.show(cashOnDeliveryActivity2, (CharSequence) null, "loading, please wait...");
        }
        super.onPageStarted(webView, str, bitmap);
        cashOnDeliveryActivity2.f5356a = true;
    }
}
