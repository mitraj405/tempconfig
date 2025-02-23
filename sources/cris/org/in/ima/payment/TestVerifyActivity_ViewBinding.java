package cris.org.in.ima.payment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class TestVerifyActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TestVerifyActivity f5362a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TestVerifyActivity a;

        public a(TestVerifyActivity testVerifyActivity) {
            this.a = testVerifyActivity;
        }

        public final void doClick(View view) {
            this.a.onclickVerify(view);
        }
    }

    public TestVerifyActivity_ViewBinding(TestVerifyActivity testVerifyActivity, View view) {
        this.f5362a = testVerifyActivity;
        testVerifyActivity.otpText = (EditText) Utils.findRequiredViewAsType(view, R.id.sbiBuddyOtpText, "field 'otpText'", EditText.class);
        Class cls = LinearLayout.class;
        testVerifyActivity.hintLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.hint_layout, "field 'hintLayout'", cls);
        testVerifyActivity.rlMobilePin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sbiBuddyOtpText_layout, "field 'rlMobilePin'", cls);
        Class cls2 = TextView.class;
        testVerifyActivity.amountTv = (TextView) Utils.findRequiredViewAsType(view, R.id.amount, "field 'amountTv'", cls2);
        testVerifyActivity.paymentImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.payment_mode_image, "field 'paymentImage'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sbiBuddyOtpVerify, "field 'paymentButton' and method 'onclickVerify'");
        testVerifyActivity.paymentButton = (TextView) Utils.castView(findRequiredView, R.id.sbiBuddyOtpVerify, "field 'paymentButton'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(testVerifyActivity));
        testVerifyActivity.pgTxnMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.pgTxnMsg, "field 'pgTxnMsg'", cls2);
    }

    public final void unbind() {
        TestVerifyActivity testVerifyActivity = this.f5362a;
        if (testVerifyActivity != null) {
            this.f5362a = null;
            testVerifyActivity.otpText = null;
            testVerifyActivity.hintLayout = null;
            testVerifyActivity.rlMobilePin = null;
            testVerifyActivity.amountTv = null;
            testVerifyActivity.paymentImage = null;
            testVerifyActivity.paymentButton = null;
            testVerifyActivity.pgTxnMsg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
