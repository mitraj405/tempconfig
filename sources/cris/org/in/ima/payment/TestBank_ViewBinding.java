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

public class TestBank_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TestBank f5361a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TestBank a;

        public a(TestBank testBank) {
            this.a = testBank;
        }

        public final void doClick(View view) {
            this.a.sbiBuddyLoginOnClick(view);
        }
    }

    public TestBank_ViewBinding(TestBank testBank, View view) {
        this.f5361a = testBank;
        Class cls = TextView.class;
        testBank.pinLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin, "field 'pinLabel'", cls);
        testBank.pinUnderline = Utils.findRequiredView(view, R.id.view_pin_underline, "field 'pinUnderline'");
        Class cls2 = EditText.class;
        testBank.mobileNo = (EditText) Utils.findRequiredViewAsType(view, R.id.et_sbiBuddyMobile, "field 'mobileNo'", cls2);
        Class cls3 = LinearLayout.class;
        testBank.rlMobilePin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sbiBuddyOtpText_layout, "field 'rlMobilePin'", cls3);
        testBank.llHint = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.hint_layout, "field 'llHint'", cls3);
        testBank.pin = (EditText) Utils.findRequiredViewAsType(view, R.id.et_sbiBuddyPin, "field 'pin'", cls2);
        testBank.titleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'titleTv'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_login, "field 'loginButton' and method 'sbiBuddyLoginOnClick'");
        testBank.loginButton = (TextView) Utils.castView(findRequiredView, R.id.tv_login, "field 'loginButton'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(testBank));
        testBank.fareAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.amount, "field 'fareAmount'", cls);
        testBank.paymentImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.payment_mode_image, "field 'paymentImage'", ImageView.class);
        testBank.pgTxnMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.pgTxnMsg, "field 'pgTxnMsg'", cls);
    }

    public final void unbind() {
        TestBank testBank = this.f5361a;
        if (testBank != null) {
            this.f5361a = null;
            testBank.pinLabel = null;
            testBank.pinUnderline = null;
            testBank.mobileNo = null;
            testBank.rlMobilePin = null;
            testBank.llHint = null;
            testBank.pin = null;
            testBank.titleTv = null;
            testBank.loginButton = null;
            testBank.fareAmount = null;
            testBank.paymentImage = null;
            testBank.pgTxnMsg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
