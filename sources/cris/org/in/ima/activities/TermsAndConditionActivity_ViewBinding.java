package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class TermsAndConditionActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TermsAndConditionActivity f4365a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TermsAndConditionActivity a;

        public a(TermsAndConditionActivity termsAndConditionActivity) {
            this.a = termsAndConditionActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public TermsAndConditionActivity_ViewBinding(TermsAndConditionActivity termsAndConditionActivity, View view) {
        this.f4365a = termsAndConditionActivity;
        termsAndConditionActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", TextView.class);
        termsAndConditionActivity.header = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.header, "field 'header'", RelativeLayout.class);
        termsAndConditionActivity.tNcWebview = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_tAndC, "field 'tNcWebview'", WebView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(termsAndConditionActivity));
    }

    public final void unbind() {
        TermsAndConditionActivity termsAndConditionActivity = this.f4365a;
        if (termsAndConditionActivity != null) {
            this.f4365a = null;
            termsAndConditionActivity.titleName = null;
            termsAndConditionActivity.header = null;
            termsAndConditionActivity.tNcWebview = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
