package cris.org.in.ima.payment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class SbiBuddy_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public SbiBuddy f5359a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SbiBuddy a;

        public a(SbiBuddy sbiBuddy) {
            this.a = sbiBuddy;
        }

        public final void doClick(View view) {
            this.a.sbiBuddyLoginOnClick(view);
        }
    }

    public SbiBuddy_ViewBinding(SbiBuddy sbiBuddy, View view) {
        this.f5359a = sbiBuddy;
        Class cls = TextView.class;
        sbiBuddy.pinLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin, "field 'pinLabel'", cls);
        sbiBuddy.pinUnderline = Utils.findRequiredView(view, R.id.view_pin_underline, "field 'pinUnderline'");
        Class cls2 = EditText.class;
        sbiBuddy.mobileNo = (EditText) Utils.findRequiredViewAsType(view, R.id.et_sbiBuddyMobile, "field 'mobileNo'", cls2);
        sbiBuddy.pin = (EditText) Utils.findRequiredViewAsType(view, R.id.et_sbiBuddyPin, "field 'pin'", cls2);
        sbiBuddy.titleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'titleTv'", cls);
        sbiBuddy.otpMsgInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_otp_msg_info, "field 'otpMsgInfo'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_login, "field 'loginButton' and method 'sbiBuddyLoginOnClick'");
        sbiBuddy.loginButton = (TextView) Utils.castView(findRequiredView, R.id.tv_login, "field 'loginButton'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(sbiBuddy));
        sbiBuddy.paymentImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.payment_mode_image, "field 'paymentImage'", ImageView.class);
        sbiBuddy.fareAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.amount, "field 'fareAmount'", cls);
        sbiBuddy.pgTxnMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.pgTxnMsg, "field 'pgTxnMsg'", cls);
    }

    public final void unbind() {
        SbiBuddy sbiBuddy = this.f5359a;
        if (sbiBuddy != null) {
            this.f5359a = null;
            sbiBuddy.pinLabel = null;
            sbiBuddy.pinUnderline = null;
            sbiBuddy.mobileNo = null;
            sbiBuddy.pin = null;
            sbiBuddy.titleTv = null;
            sbiBuddy.otpMsgInfo = null;
            sbiBuddy.loginButton = null;
            sbiBuddy.paymentImage = null;
            sbiBuddy.fareAmount = null;
            sbiBuddy.pgTxnMsg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
