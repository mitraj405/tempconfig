package cris.org.in.ima.activities;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import cris.org.in.ima.activities.ZaakpayActivity;

/* compiled from: ZaakpayActivity */
public final class Q implements ZaakpayActivity.c {
    public final /* synthetic */ ZaakpayActivity a;

    public Q(ZaakpayActivity zaakpayActivity) {
        this.a = zaakpayActivity;
    }

    @JavascriptInterface
    public void onPaymentDone(String str) {
        ZaakpayActivity zaakpayActivity = ZaakpayActivity.a;
        Intent intent = new Intent();
        intent.putExtra("bankresponse", str);
        int bankId = C1480xl.f7038a.f7042a.getBankId();
        ZaakpayActivity zaakpayActivity2 = this.a;
        zaakpayActivity2.setResult(bankId, intent);
        zaakpayActivity2.finish();
    }
}
