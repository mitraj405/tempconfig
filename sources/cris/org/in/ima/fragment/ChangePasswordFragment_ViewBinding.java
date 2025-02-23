package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ChangePasswordFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ChangePasswordFragment f4514a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a implements View.OnFocusChangeListener {
        public final /* synthetic */ ChangePasswordFragment a;

        public a(ChangePasswordFragment changePasswordFragment) {
            this.a = changePasswordFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.passwordval(view);
        }
    }

    public class b implements View.OnFocusChangeListener {
        public final /* synthetic */ ChangePasswordFragment a;

        public b(ChangePasswordFragment changePasswordFragment) {
            this.a = changePasswordFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.cnfPasswordval(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChangePasswordFragment a;

        public c(ChangePasswordFragment changePasswordFragment) {
            this.a = changePasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ChangePasswordFragment a;

        public d(ChangePasswordFragment changePasswordFragment) {
            this.a = changePasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide1();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ChangePasswordFragment a;

        public e(ChangePasswordFragment changePasswordFragment) {
            this.a = changePasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide2();
        }
    }

    public ChangePasswordFragment_ViewBinding(ChangePasswordFragment changePasswordFragment, View view) {
        this.f4514a = changePasswordFragment;
        Class cls = EditText.class;
        changePasswordFragment.oldPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.old_Password, "field 'oldPassword'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.new_Password, "field 'newPassword' and method 'passwordval'");
        changePasswordFragment.newPassword = (EditText) Utils.castView(findRequiredView, R.id.new_Password, "field 'newPassword'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnFocusChangeListener(new a(changePasswordFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_confirm_password, "field 'confirmPassword' and method 'cnfPasswordval'");
        changePasswordFragment.confirmPassword = (EditText) Utils.castView(findRequiredView2, R.id.et_confirm_password, "field 'confirmPassword'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new b(changePasswordFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_pwd_show_hide, "field 'tv_pwd_show_hide' and method 'pwdShowHide'");
        Class cls2 = TextView.class;
        changePasswordFragment.tv_pwd_show_hide = (TextView) Utils.castView(findRequiredView3, R.id.tv_pwd_show_hide, "field 'tv_pwd_show_hide'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(changePasswordFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.newPass_Visibi, "field 'newPass_Visibi' and method 'pwdShowHide1'");
        changePasswordFragment.newPass_Visibi = (TextView) Utils.castView(findRequiredView4, R.id.newPass_Visibi, "field 'newPass_Visibi'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(changePasswordFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.conPass_Visibi, "field 'conPassVisibi' and method 'pwdShowHide2'");
        changePasswordFragment.conPassVisibi = (TextView) Utils.castView(findRequiredView5, R.id.conPass_Visibi, "field 'conPassVisibi'", cls2);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(changePasswordFragment));
        changePasswordFragment.mPublisherAdview = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mPublisherAdview'", AdManagerAdView.class);
    }

    public final void unbind() {
        ChangePasswordFragment changePasswordFragment = this.f4514a;
        if (changePasswordFragment != null) {
            this.f4514a = null;
            changePasswordFragment.oldPassword = null;
            changePasswordFragment.newPassword = null;
            changePasswordFragment.confirmPassword = null;
            changePasswordFragment.tv_pwd_show_hide = null;
            changePasswordFragment.newPass_Visibi = null;
            changePasswordFragment.conPassVisibi = null;
            changePasswordFragment.mPublisherAdview = null;
            this.a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.a = null;
            this.b.setOnFocusChangeListener((View.OnFocusChangeListener) null);
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
