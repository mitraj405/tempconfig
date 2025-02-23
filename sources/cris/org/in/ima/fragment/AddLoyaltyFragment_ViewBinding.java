package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class AddLoyaltyFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public AddLoyaltyFragment f4405a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AddLoyaltyFragment a;

        public a(AddLoyaltyFragment addLoyaltyFragment) {
            this.a = addLoyaltyFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyaltyNumberClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ AddLoyaltyFragment a;

        public b(AddLoyaltyFragment addLoyaltyFragment) {
            this.a = addLoyaltyFragment;
        }

        public final void doClick(View view) {
            this.a.OtpLayoutClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ AddLoyaltyFragment a;

        public c(AddLoyaltyFragment addLoyaltyFragment) {
            this.a = addLoyaltyFragment;
        }

        public final void doClick(View view) {
            this.a.onResendOtpClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ AddLoyaltyFragment a;

        public d(AddLoyaltyFragment addLoyaltyFragment) {
            this.a = addLoyaltyFragment;
        }

        public final void doClick(View view) {
            this.a.VerifyButtonClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ AddLoyaltyFragment a;

        public e(AddLoyaltyFragment addLoyaltyFragment) {
            this.a = addLoyaltyFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyaltyBankClick(view);
        }
    }

    public AddLoyaltyFragment_ViewBinding(AddLoyaltyFragment addLoyaltyFragment, View view) {
        this.f4405a = addLoyaltyFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_loyalty_number, "field 'loyaltyNumber' and method 'onLoyaltyNumberClick'");
        Class cls = EditText.class;
        addLoyaltyFragment.loyaltyNumber = (EditText) Utils.castView(findRequiredView, R.id.et_loyalty_number, "field 'loyaltyNumber'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(addLoyaltyFragment));
        addLoyaltyFragment.otpNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_otp, "field 'otpNumber'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.otp_ll, "field 'otpLayout' and method 'OtpLayoutClick'");
        addLoyaltyFragment.otpLayout = (RelativeLayout) Utils.castView(findRequiredView2, R.id.otp_ll, "field 'otpLayout'", RelativeLayout.class);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(addLoyaltyFragment));
        addLoyaltyFragment.loyalty_bank = (TextView) Utils.findRequiredViewAsType(view, R.id.loyalty_bank, "field 'loyalty_bank'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_resend_otp, "method 'onResendOtpClick'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(addLoyaltyFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.verify_otp, "method 'VerifyButtonClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(addLoyaltyFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.loayalty_bank_rl, "method 'onLoyaltyBankClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(addLoyaltyFragment));
    }

    public final void unbind() {
        AddLoyaltyFragment addLoyaltyFragment = this.f4405a;
        if (addLoyaltyFragment != null) {
            this.f4405a = null;
            addLoyaltyFragment.loyaltyNumber = null;
            addLoyaltyFragment.otpNumber = null;
            addLoyaltyFragment.otpLayout = null;
            addLoyaltyFragment.loyalty_bank = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
