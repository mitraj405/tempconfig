package cris.org.in.ima;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class FeedbackActivity_ViewBinding implements Unbinder {
    public FeedbackActivity a;

    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.a = feedbackActivity;
        Class cls = TextView.class;
        feedbackActivity.tv_submit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit, "field 'tv_submit'", cls);
        feedbackActivity.tv_skip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_skip, "field 'tv_skip'", cls);
        feedbackActivity.back_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.back, "field 'back_btn'", ImageView.class);
        feedbackActivity.criteria = (TextView) Utils.findRequiredViewAsType(view, R.id.criteria_Rating, "field 'criteria'", cls);
        feedbackActivity.tv_remarks = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_remarks, "field 'tv_remarks'", cls);
    }

    public final void unbind() {
        FeedbackActivity feedbackActivity = this.a;
        if (feedbackActivity != null) {
            this.a = null;
            feedbackActivity.tv_submit = null;
            feedbackActivity.tv_skip = null;
            feedbackActivity.back_btn = null;
            feedbackActivity.criteria = null;
            feedbackActivity.tv_remarks = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
