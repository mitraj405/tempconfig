package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ChangeTxnPasswordFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ChangeTxnPasswordFragment f4517a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeTxnPasswordFragment a;

        public a(ChangeTxnPasswordFragment changeTxnPasswordFragment) {
            this.a = changeTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeTxnPasswordFragment a;

        public b(ChangeTxnPasswordFragment changeTxnPasswordFragment) {
            this.a = changeTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide1();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeTxnPasswordFragment a;

        public c(ChangeTxnPasswordFragment changeTxnPasswordFragment) {
            this.a = changeTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide2();
        }
    }

    public ChangeTxnPasswordFragment_ViewBinding(ChangeTxnPasswordFragment changeTxnPasswordFragment, View view) {
        this.f4517a = changeTxnPasswordFragment;
        Class cls = EditText.class;
        changeTxnPasswordFragment.oldPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.old_Password, "field 'oldPassword'", cls);
        changeTxnPasswordFragment.newPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.new_Password, "field 'newPassword'", cls);
        changeTxnPasswordFragment.confirmPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.et_confirm_password, "field 'confirmPassword'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_pwd_show_hide, "field 'tv_pwd_show_hide' and method 'pwdShowHide'");
        Class cls2 = TextView.class;
        changeTxnPasswordFragment.tv_pwd_show_hide = (TextView) Utils.castView(findRequiredView, R.id.tv_pwd_show_hide, "field 'tv_pwd_show_hide'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(changeTxnPasswordFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.newPass_Visibi, "field 'newPass_Visibi' and method 'pwdShowHide1'");
        changeTxnPasswordFragment.newPass_Visibi = (TextView) Utils.castView(findRequiredView2, R.id.newPass_Visibi, "field 'newPass_Visibi'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(changeTxnPasswordFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.conPass_Visibi, "field 'conPassVisibi' and method 'pwdShowHide2'");
        changeTxnPasswordFragment.conPassVisibi = (TextView) Utils.castView(findRequiredView3, R.id.conPass_Visibi, "field 'conPassVisibi'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(changeTxnPasswordFragment));
        changeTxnPasswordFragment.mPublisherAdview = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mPublisherAdview'", AdManagerAdView.class);
    }

    public final void unbind() {
        ChangeTxnPasswordFragment changeTxnPasswordFragment = this.f4517a;
        if (changeTxnPasswordFragment != null) {
            this.f4517a = null;
            changeTxnPasswordFragment.oldPassword = null;
            changeTxnPasswordFragment.newPassword = null;
            changeTxnPasswordFragment.confirmPassword = null;
            changeTxnPasswordFragment.tv_pwd_show_hide = null;
            changeTxnPasswordFragment.newPass_Visibi = null;
            changeTxnPasswordFragment.conPassVisibi = null;
            changeTxnPasswordFragment.mPublisherAdview = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
