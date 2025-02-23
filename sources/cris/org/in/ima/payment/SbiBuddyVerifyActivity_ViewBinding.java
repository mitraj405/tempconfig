package cris.org.in.ima.payment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class SbiBuddyVerifyActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public SbiBuddyVerifyActivity f5358a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SbiBuddyVerifyActivity a;

        public a(SbiBuddyVerifyActivity sbiBuddyVerifyActivity) {
            this.a = sbiBuddyVerifyActivity;
        }

        public final void doClick(View view) {
            this.a.onclickVerify(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SbiBuddyVerifyActivity a;

        public b(SbiBuddyVerifyActivity sbiBuddyVerifyActivity) {
            this.a = sbiBuddyVerifyActivity;
        }

        public final void doClick(View view) {
            this.a.onResendOtpClick(view);
        }
    }

    public SbiBuddyVerifyActivity_ViewBinding(SbiBuddyVerifyActivity sbiBuddyVerifyActivity, View view) {
        this.f5358a = sbiBuddyVerifyActivity;
        sbiBuddyVerifyActivity.otpText = (EditText) Utils.findRequiredViewAsType(view, R.id.sbiBuddyOtpText, "field 'otpText'", EditText.class);
        Class cls = TextView.class;
        sbiBuddyVerifyActivity.amountTv = (TextView) Utils.findRequiredViewAsType(view, R.id.amount, "field 'amountTv'", cls);
        sbiBuddyVerifyActivity.paymentImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.payment_mode_image, "field 'paymentImage'", ImageView.class);
        sbiBuddyVerifyActivity.titleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'titleTv'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.sbiBuddyOtpVerify, "field 'paymentButton' and method 'onclickVerify'");
        sbiBuddyVerifyActivity.paymentButton = (TextView) Utils.castView(findRequiredView, R.id.sbiBuddyOtpVerify, "field 'paymentButton'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(sbiBuddyVerifyActivity));
        sbiBuddyVerifyActivity.pgTxnMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.pgTxnMsg, "field 'pgTxnMsg'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_resend_otp, "field 'resendOtp' and method 'onResendOtpClick'");
        sbiBuddyVerifyActivity.resendOtp = (TextView) Utils.castView(findRequiredView2, R.id.tv_resend_otp, "field 'resendOtp'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(sbiBuddyVerifyActivity));
    }

    public final void unbind() {
        SbiBuddyVerifyActivity sbiBuddyVerifyActivity = this.f5358a;
        if (sbiBuddyVerifyActivity != null) {
            this.f5358a = null;
            sbiBuddyVerifyActivity.otpText = null;
            sbiBuddyVerifyActivity.amountTv = null;
            sbiBuddyVerifyActivity.paymentImage = null;
            sbiBuddyVerifyActivity.titleTv = null;
            sbiBuddyVerifyActivity.paymentButton = null;
            sbiBuddyVerifyActivity.pgTxnMsg = null;
            sbiBuddyVerifyActivity.resendOtp = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
