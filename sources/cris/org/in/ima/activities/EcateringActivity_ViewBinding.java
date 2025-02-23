package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class EcateringActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public EcateringActivity f4165a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ EcateringActivity a;

        public a(EcateringActivity ecateringActivity) {
            this.a = ecateringActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public EcateringActivity_ViewBinding(EcateringActivity ecateringActivity, View view) {
        this.f4165a = ecateringActivity;
        ecateringActivity.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.e_catering_view, "field 'mWebView'", WebView.class);
        ecateringActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(ecateringActivity));
    }

    public final void unbind() {
        EcateringActivity ecateringActivity = this.f4165a;
        if (ecateringActivity != null) {
            this.f4165a = null;
            ecateringActivity.mWebView = null;
            ecateringActivity.titleName = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
