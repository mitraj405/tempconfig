package cris.org.in.ima.payment;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class CashOnDeliveryActivity_ViewBinding implements Unbinder {
    public CashOnDeliveryActivity a;

    public CashOnDeliveryActivity_ViewBinding(CashOnDeliveryActivity cashOnDeliveryActivity, View view) {
        this.a = cashOnDeliveryActivity;
        cashOnDeliveryActivity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_cod_payment, "field 'webView'", WebView.class);
    }

    public final void unbind() {
        CashOnDeliveryActivity cashOnDeliveryActivity = this.a;
        if (cashOnDeliveryActivity != null) {
            this.a = null;
            cashOnDeliveryActivity.webView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
