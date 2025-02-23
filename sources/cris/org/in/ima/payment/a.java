package cris.org.in.ima.payment;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import cris.org.in.ima.payment.CashOnDeliveryActivity;

/* compiled from: CashOnDeliveryActivity */
public final class a implements CashOnDeliveryActivity.c {
    public final /* synthetic */ CashOnDeliveryActivity a;

    public a(CashOnDeliveryActivity cashOnDeliveryActivity) {
        this.a = cashOnDeliveryActivity;
    }

    @JavascriptInterface
    public void onPaymentDone(String str) {
        CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.a;
        Intent intent = new Intent();
        intent.putExtra("codresponse", str);
        int bankId = C1480xl.f7038a.f7042a.getBankId();
        CashOnDeliveryActivity cashOnDeliveryActivity2 = this.a;
        cashOnDeliveryActivity2.setResult(bankId, intent);
        cashOnDeliveryActivity2.finish();
    }
}
