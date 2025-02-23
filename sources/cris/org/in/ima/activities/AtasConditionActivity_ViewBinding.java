package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class AtasConditionActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public AtasConditionActivity f4148a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AtasConditionActivity a;

        public a(AtasConditionActivity atasConditionActivity) {
            this.a = atasConditionActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public AtasConditionActivity_ViewBinding(AtasConditionActivity atasConditionActivity, View view) {
        this.f4148a = atasConditionActivity;
        atasConditionActivity.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_tAndC, "field 'mWebView'", WebView.class);
        atasConditionActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(atasConditionActivity));
    }

    public final void unbind() {
        AtasConditionActivity atasConditionActivity = this.f4148a;
        if (atasConditionActivity != null) {
            this.f4148a = null;
            atasConditionActivity.mWebView = null;
            atasConditionActivity.titleName = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
