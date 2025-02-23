package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class PgWebViewActivity_ViewBinding implements Unbinder {
    public PgWebViewActivity a;

    public PgWebViewActivity_ViewBinding(PgWebViewActivity pgWebViewActivity, View view) {
        this.a = pgWebViewActivity;
        pgWebViewActivity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_payment, "field 'webView'", WebView.class);
    }

    public final void unbind() {
        PgWebViewActivity pgWebViewActivity = this.a;
        if (pgWebViewActivity != null) {
            this.a = null;
            pgWebViewActivity.webView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
