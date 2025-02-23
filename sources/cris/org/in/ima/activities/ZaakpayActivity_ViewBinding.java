package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class ZaakpayActivity_ViewBinding implements Unbinder {
    public ZaakpayActivity a;

    public ZaakpayActivity_ViewBinding(ZaakpayActivity zaakpayActivity, View view) {
        this.a = zaakpayActivity;
        zaakpayActivity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_zaakpay, "field 'webView'", WebView.class);
    }

    public final void unbind() {
        ZaakpayActivity zaakpayActivity = this.a;
        if (zaakpayActivity != null) {
            this.a = null;
            zaakpayActivity.webView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
