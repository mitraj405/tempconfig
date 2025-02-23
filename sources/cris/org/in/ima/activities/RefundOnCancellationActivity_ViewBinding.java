package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class RefundOnCancellationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public RefundOnCancellationActivity f4298a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RefundOnCancellationActivity a;

        public a(RefundOnCancellationActivity refundOnCancellationActivity) {
            this.a = refundOnCancellationActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public RefundOnCancellationActivity_ViewBinding(RefundOnCancellationActivity refundOnCancellationActivity, View view) {
        this.f4298a = refundOnCancellationActivity;
        refundOnCancellationActivity.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_tAndC, "field 'mWebView'", WebView.class);
        refundOnCancellationActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(refundOnCancellationActivity));
    }

    public final void unbind() {
        RefundOnCancellationActivity refundOnCancellationActivity = this.f4298a;
        if (refundOnCancellationActivity != null) {
            this.f4298a = null;
            refundOnCancellationActivity.mWebView = null;
            refundOnCancellationActivity.titleName = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
