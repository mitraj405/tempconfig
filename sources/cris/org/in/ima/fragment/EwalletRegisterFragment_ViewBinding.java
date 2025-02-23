package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class EwalletRegisterFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletRegisterFragment f4616a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRegisterFragment a;

        public a(EwalletRegisterFragment ewalletRegisterFragment) {
            this.a = ewalletRegisterFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide1();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRegisterFragment a;

        public b(EwalletRegisterFragment ewalletRegisterFragment) {
            this.a = ewalletRegisterFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide2();
        }
    }

    public EwalletRegisterFragment_ViewBinding(EwalletRegisterFragment ewalletRegisterFragment, View view) {
        this.f4616a = ewalletRegisterFragment;
        Class cls = TextView.class;
        ewalletRegisterFragment.tv_ewallet_reg_verification_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ewallet_reg_verification_msg, "field 'tv_ewallet_reg_verification_msg'", cls);
        Class cls2 = EditText.class;
        ewalletRegisterFragment.password = (EditText) Utils.findRequiredViewAsType(view, R.id.txn_password, "field 'password'", cls2);
        ewalletRegisterFragment.confirmPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.et_txn_confirm_password, "field 'confirmPassword'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_txn_password_show, "field 'passwordShowHide' and method 'pwdShowHide1'");
        ewalletRegisterFragment.passwordShowHide = (TextView) Utils.castView(findRequiredView, R.id.tv_txn_password_show, "field 'passwordShowHide'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(ewalletRegisterFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_txn_confirm_password_show, "field 'confirmPasswordShowHide' and method 'pwdShowHide2'");
        ewalletRegisterFragment.confirmPasswordShowHide = (TextView) Utils.castView(findRequiredView2, R.id.tv_txn_confirm_password_show, "field 'confirmPasswordShowHide'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(ewalletRegisterFragment));
    }

    public final void unbind() {
        EwalletRegisterFragment ewalletRegisterFragment = this.f4616a;
        if (ewalletRegisterFragment != null) {
            this.f4616a = null;
            ewalletRegisterFragment.tv_ewallet_reg_verification_msg = null;
            ewalletRegisterFragment.password = null;
            ewalletRegisterFragment.confirmPassword = null;
            ewalletRegisterFragment.passwordShowHide = null;
            ewalletRegisterFragment.confirmPasswordShowHide = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
