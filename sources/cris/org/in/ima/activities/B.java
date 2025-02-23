package cris.org.in.ima.activities;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import cris.org.in.ima.activities.PgWebViewActivity;

/* compiled from: PgWebViewActivity */
public final class B implements PgWebViewActivity.c {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PgWebViewActivity f4149a;

    public B(PgWebViewActivity pgWebViewActivity, int i) {
        this.f4149a = pgWebViewActivity;
        this.a = i;
    }

    @JavascriptInterface
    public void onPaymentDone(String str) {
        PgWebViewActivity pgWebViewActivity = PgWebViewActivity.a;
        Intent intent = new Intent();
        intent.putExtra("bankresponse", str);
        int i = this.a;
        PgWebViewActivity pgWebViewActivity2 = this.f4149a;
        pgWebViewActivity2.setResult(i, intent);
        pgWebViewActivity2.finish();
    }
}
