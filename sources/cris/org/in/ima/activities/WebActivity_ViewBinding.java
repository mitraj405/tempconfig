package cris.org.in.ima.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class WebActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public WebActivity f4372a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ WebActivity a;

        public a(WebActivity webActivity) {
            this.a = webActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public WebActivity_ViewBinding(WebActivity webActivity, View view) {
        this.f4372a = webActivity;
        webActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", TextView.class);
        webActivity.tNcWebview = (WebView) Utils.findRequiredViewAsType(view, R.id.web_view, "field 'tNcWebview'", WebView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(webActivity));
    }

    public final void unbind() {
        WebActivity webActivity = this.f4372a;
        if (webActivity != null) {
            this.f4372a = null;
            webActivity.titleName = null;
            webActivity.tNcWebview = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
