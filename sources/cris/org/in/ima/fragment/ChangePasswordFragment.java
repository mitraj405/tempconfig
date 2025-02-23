package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

public class ChangePasswordFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public final Xo a = new Xo();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4512a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4513a;
    @BindView(2131362280)
    TextView conPassVisibi;
    @BindView(2131362523)
    EditText confirmPassword;
    @BindView(2131363277)
    AdManagerAdView mPublisherAdview;
    @BindView(2131363313)
    TextView newPass_Visibi;
    @BindView(2131363314)
    EditText newPassword;
    @BindView(2131363362)
    EditText oldPassword;
    @BindView(2131364547)
    TextView tv_pwd_show_hide;

    static {
        C1354qp.R(ChangePasswordFragment.class);
    }

    @OnFocusChange({2131362523})
    public void cnfPasswordval(View view) {
        if (this.confirmPassword.hasFocus()) {
            this.confirmPassword.setVisibility(0);
            return;
        }
        String g = g(this.newPassword.getText().toString(), this.confirmPassword.getText().toString());
        if (!g.equalsIgnoreCase("ok")) {
            this.confirmPassword.setError(g);
            C0535I5.t0(view.getContext(), g);
            return;
        }
        this.confirmPassword.setError((CharSequence) null);
    }

    public final void f(EditText editText, TextView textView) {
        if (editText.getInputType() == 145) {
            editText.setInputType(129);
            editText.setSelection(editText.getText().length());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
            return;
        }
        editText.setInputType(145);
        editText.setSelection(editText.getText().length());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getActivity().getResources().getColor(R.color.black_90_opa), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final String g(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return getString(R.string.Please_confirm_password);
        }
        if (str.equals(str2)) {
            return "ok";
        }
        return getString(R.string.new_Confirm_mismatch);
    }

    public final String h(String str) {
        if (str.length() == 0) {
            return getString(R.string.enter_password);
        }
        if (str.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$")) {
            return "ok";
        }
        return getString(R.string.characters_long_capital_small_numeric);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragmnet_change_password, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        C0535I5.a(this.newPassword, 15);
        C0535I5.a(this.confirmPassword, 15);
        HomeActivity.G(getString(R.string.save));
        this.f4513a = getContext();
        this.oldPassword.setInputType(129);
        this.newPassword.setInputType(129);
        this.confirmPassword.setInputType(129);
        C0535I5.H(getActivity(), getView());
        HomeActivity.f4190d.setOnClickListener(new a());
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.mPublisherAdview, googleAdParamDTO);
        return inflate;
    }

    @OnFocusChange({2131363314})
    public void passwordval(View view) {
        if (this.newPassword.hasFocus()) {
            this.newPassword.setVisibility(0);
            return;
        }
        String h = h(this.newPassword.getText().toString());
        if (!h.equalsIgnoreCase("ok")) {
            this.newPassword.setError(h);
        } else {
            this.newPassword.setError((CharSequence) null);
        }
    }

    @OnClick({2131364547})
    public void pwdShowHide() {
        f(this.oldPassword, this.tv_pwd_show_hide);
    }

    @OnClick({2131363313})
    public void pwdShowHide1() {
        f(this.newPassword, this.newPass_Visibi);
    }

    @OnClick({2131362280})
    public void pwdShowHide2() {
        f(this.confirmPassword, this.conPassVisibi);
    }

    public class a implements View.OnClickListener {

        public class b extends Subscriber<StatusDTO> {
            public b() {
            }

            public final void onCompleted() {
                ChangePasswordFragment.this.f4512a.dismiss();
                int i = ChangePasswordFragment.c;
            }

            public final void onError(Throwable th) {
                int i = ChangePasswordFragment.c;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                StatusDTO statusDTO = (StatusDTO) obj;
                a aVar = a.this;
                if (statusDTO != null) {
                    C0657Qt.h();
                    try {
                        if (statusDTO.getError() == null || statusDTO.getError().length() <= 0) {
                            if (statusDTO.getStatus() != null) {
                                if (statusDTO.getStatus().indexOf("=") == -1) {
                                    ChangePasswordFragment changePasswordFragment = ChangePasswordFragment.this;
                                    ChangePasswordFragment changePasswordFragment2 = ChangePasswordFragment.this;
                                    C0535I5.p(changePasswordFragment.getActivity(), false, statusDTO.getStatus() + "\n" + changePasswordFragment2.getString(R.string.redirecting), changePasswordFragment2.getString(R.string.change_password), changePasswordFragment2.getString(R.string.OK), new E(this), (String) null, (DialogInterface.OnClickListener) null).show();
                                }
                            }
                            String[] split = statusDTO.getStatus().split(",");
                            String str = "";
                            for (int i = 0; i < split.length; i++) {
                                String[] split2 = split[i].split("=");
                                if (i == 0) {
                                    str = str + split2[1].replace("}", "");
                                } else {
                                    str = str + "\n" + split2[1].replace("}", "");
                                }
                            }
                            Toast.makeText(ChangePasswordFragment.this.getContext(), str, 1).show();
                        } else {
                            ChangePasswordFragment changePasswordFragment3 = ChangePasswordFragment.this;
                            ChangePasswordFragment changePasswordFragment4 = ChangePasswordFragment.this;
                            C0535I5.m(changePasswordFragment3.getActivity(), false, statusDTO.getError(), changePasswordFragment4.getString(R.string.error), changePasswordFragment4.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                        ChangePasswordFragment.this.f4512a.dismiss();
                    } catch (Exception e) {
                        ChangePasswordFragment.this.f4512a.dismiss();
                        int i2 = ChangePasswordFragment.c;
                        e.getMessage();
                    }
                    int i3 = ChangePasswordFragment.c;
                    statusDTO.toString();
                }
            }
        }

        public a() {
        }

        public final void onClick(View view) {
            ChangePasswordFragment changePasswordFragment = ChangePasswordFragment.this;
            C0535I5.H(changePasswordFragment.getActivity(), changePasswordFragment.getView());
            if (TextUtils.isEmpty(changePasswordFragment.oldPassword.getText()) && TextUtils.isEmpty(changePasswordFragment.newPassword.getText()) && TextUtils.isEmpty(changePasswordFragment.confirmPassword.getText())) {
                C0535I5.m(changePasswordFragment.getContext(), false, changePasswordFragment.getString(R.string.please_enter_old_new_confirm_password), changePasswordFragment.getString(R.string.error), changePasswordFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (TextUtils.isEmpty(changePasswordFragment.oldPassword.getText())) {
                changePasswordFragment.oldPassword.setError(changePasswordFragment.getString(R.string.Please_old_password));
            } else if (TextUtils.isEmpty(changePasswordFragment.newPassword.getText())) {
                changePasswordFragment.newPassword.setError(changePasswordFragment.getString(R.string.Please_new_password));
                changePasswordFragment.newPassword.requestFocus();
            } else if (TextUtils.isEmpty(changePasswordFragment.confirmPassword.getText())) {
                changePasswordFragment.confirmPassword.setError(changePasswordFragment.getString(R.string.Please_confirm_password));
            } else {
                String h = changePasswordFragment.h(changePasswordFragment.newPassword.getText().toString());
                String g = changePasswordFragment.g(changePasswordFragment.newPassword.getText().toString(), changePasswordFragment.confirmPassword.getText().toString());
                if (!h.equals("ok")) {
                    C0535I5.m(changePasswordFragment.getContext(), false, h, changePasswordFragment.getString(R.string.error), changePasswordFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else if (!g.equals("ok")) {
                    C0535I5.m(changePasswordFragment.getContext(), false, g, changePasswordFragment.getString(R.string.error), changePasswordFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else {
                    changePasswordFragment.f4512a = ProgressDialog.show(changePasswordFragment.getContext(), changePasswordFragment.getString(R.string.Changing_Password), changePasswordFragment.getString(R.string.please_wait));
                    C0793b1 b1Var = C0793b1.a;
                    if (b1Var.f3912a != null) {
                        if (!C0535I5.O((ConnectivityManager) changePasswordFragment.getActivity().getSystemService("connectivity"), changePasswordFragment.getContext())) {
                            new Handler().postDelayed(new C0060a(), 5000);
                            return;
                        }
                        Xo xo = changePasswordFragment.a;
                        xo.setSource(4);
                        xo.setOldPassword(changePasswordFragment.oldPassword.getText().toString());
                        xo.setNewPassword(changePasswordFragment.newPassword.getText().toString());
                        xo.setConfPassword(changePasswordFragment.confirmPassword.getText().toString());
                        String f = C0657Qt.f();
                        ((Om) C0657Qt.c(b1Var.f3912a)).O(f + "userpasswordchange", xo).c(C1181iv.a()).a(E0.a()).b(new b());
                    }
                    changePasswordFragment.f4512a.dismiss();
                }
            }
        }

        /* renamed from: cris.org.in.ima.fragment.ChangePasswordFragment$a$a  reason: collision with other inner class name */
        public class C0060a implements Runnable {
            public final void run() {
            }
        }
    }
}
