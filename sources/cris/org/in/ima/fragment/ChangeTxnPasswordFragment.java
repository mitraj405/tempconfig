package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

public class ChangeTxnPasswordFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public final Xo a = new Xo();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4515a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4516a;
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
        C1354qp.R(ChangeTxnPasswordFragment.class);
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragmnet_change_password, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        C0535I5.a(this.newPassword, 15);
        C0535I5.a(this.confirmPassword, 15);
        HomeActivity.G(getString(R.string.save));
        this.f4516a = getContext();
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
                ChangeTxnPasswordFragment.this.f4515a.dismiss();
                int i = ChangeTxnPasswordFragment.c;
            }

            public final void onError(Throwable th) {
                int i = ChangeTxnPasswordFragment.c;
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
                                    ChangeTxnPasswordFragment changeTxnPasswordFragment = ChangeTxnPasswordFragment.this;
                                    ChangeTxnPasswordFragment changeTxnPasswordFragment2 = ChangeTxnPasswordFragment.this;
                                    C0535I5.p(changeTxnPasswordFragment.getActivity(), false, statusDTO.getStatus() + "", changeTxnPasswordFragment2.getString(R.string.change_txn_password), changeTxnPasswordFragment2.getString(R.string.OK), new F(this), (String) null, (DialogInterface.OnClickListener) null).show();
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
                            Toast.makeText(ChangeTxnPasswordFragment.this.getContext(), str, 1).show();
                        } else {
                            ChangeTxnPasswordFragment changeTxnPasswordFragment3 = ChangeTxnPasswordFragment.this;
                            ChangeTxnPasswordFragment changeTxnPasswordFragment4 = ChangeTxnPasswordFragment.this;
                            C0535I5.m(changeTxnPasswordFragment3.getActivity(), false, statusDTO.getError(), changeTxnPasswordFragment4.getString(R.string.error), changeTxnPasswordFragment4.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                        ChangeTxnPasswordFragment.this.f4515a.dismiss();
                    } catch (Exception e) {
                        ChangeTxnPasswordFragment.this.f4515a.dismiss();
                        int i2 = ChangeTxnPasswordFragment.c;
                        e.getMessage();
                    }
                    int i3 = ChangeTxnPasswordFragment.c;
                    statusDTO.toString();
                }
            }
        }

        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0118  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r18) {
            /*
                r17 = this;
                r0 = r17
                cris.org.in.ima.fragment.ChangeTxnPasswordFragment r1 = cris.org.in.ima.fragment.ChangeTxnPasswordFragment.this
                android.widget.EditText r2 = r1.oldPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                r3 = 2131953334(0x7f1306b6, float:1.9543136E38)
                r4 = 2131952688(0x7f130430, float:1.9541826E38)
                if (r2 == 0) goto L_0x004c
                android.widget.EditText r2 = r1.newPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x004c
                android.widget.EditText r2 = r1.confirmPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x004c
                r2 = 2131953467(0x7f13073b, float:1.9543406E38)
                java.lang.String r7 = r1.getString(r2)
                android.content.Context r5 = r1.getContext()
                r6 = 0
                java.lang.String r8 = r1.getString(r4)
                java.lang.String r9 = r1.getString(r3)
                r10 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r5, r6, r7, r8, r9, r10)
                r1.show()
                goto L_0x01e8
            L_0x004c:
                android.widget.EditText r2 = r1.oldPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x0066
                r2 = 2131951996(0x7f13017c, float:1.9540422E38)
                java.lang.String r2 = r1.getString(r2)
                android.widget.EditText r1 = r1.oldPassword
                r1.setError(r2)
                goto L_0x01e8
            L_0x0066:
                android.widget.EditText r2 = r1.newPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x0085
                r2 = 2131951995(0x7f13017b, float:1.954042E38)
                java.lang.String r2 = r1.getString(r2)
                android.widget.EditText r3 = r1.newPassword
                r3.setError(r2)
                android.widget.EditText r1 = r1.newPassword
                r1.requestFocus()
                goto L_0x01e8
            L_0x0085:
                android.widget.EditText r2 = r1.confirmPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                r5 = 2131951991(0x7f130177, float:1.9540412E38)
                if (r2 == 0) goto L_0x009f
                java.lang.String r2 = r1.getString(r5)
                android.widget.EditText r1 = r1.confirmPassword
                r1.setError(r2)
                goto L_0x01e8
            L_0x009f:
                android.widget.EditText r2 = r1.newPassword
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                int r6 = r2.length()
                java.lang.String r7 = "ok"
                if (r6 == 0) goto L_0x00c3
                java.lang.String r6 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$"
                boolean r2 = r2.matches(r6)
                if (r2 == 0) goto L_0x00bb
                r10 = r7
                goto L_0x00cb
            L_0x00bb:
                r2 = 2131952447(0x7f13033f, float:1.9541337E38)
                java.lang.String r2 = r1.getString(r2)
                goto L_0x00ca
            L_0x00c3:
                r2 = 2131952666(0x7f13041a, float:1.9541781E38)
                java.lang.String r2 = r1.getString(r2)
            L_0x00ca:
                r10 = r2
            L_0x00cb:
                android.widget.EditText r2 = r1.newPassword
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                android.widget.EditText r6 = r1.confirmPassword
                android.text.Editable r6 = r6.getText()
                java.lang.String r6 = r6.toString()
                if (r6 == 0) goto L_0x00f7
                int r8 = r6.length()
                if (r8 <= 0) goto L_0x00f7
                boolean r2 = r2.equals(r6)
                if (r2 == 0) goto L_0x00ef
                r13 = r7
                goto L_0x00fc
            L_0x00ef:
                r2 = 2131953268(0x7f130674, float:1.9543002E38)
                java.lang.String r2 = r1.getString(r2)
                goto L_0x00fb
            L_0x00f7:
                java.lang.String r2 = r1.getString(r5)
            L_0x00fb:
                r13 = r2
            L_0x00fc:
                boolean r2 = r10.equals(r7)
                if (r2 != 0) goto L_0x0118
                android.content.Context r8 = r1.getContext()
                r9 = 0
                java.lang.String r11 = r1.getString(r4)
                java.lang.String r12 = r1.getString(r3)
                r13 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r8, r9, r10, r11, r12, r13)
                r1.show()
                return
            L_0x0118:
                boolean r2 = r13.equals(r7)
                if (r2 != 0) goto L_0x0135
                android.content.Context r11 = r1.getContext()
                r12 = 0
                java.lang.String r14 = r1.getString(r4)
                java.lang.String r15 = r1.getString(r3)
                r16 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r11, r12, r13, r14, r15, r16)
                r1.show()
                return
            L_0x0135:
                android.content.Context r2 = r1.getContext()
                r3 = 2131951697(0x7f130051, float:1.9539816E38)
                java.lang.String r3 = r1.getString(r3)
                r4 = 2131953494(0x7f130756, float:1.954346E38)
                java.lang.String r4 = r1.getString(r4)
                android.app.ProgressDialog r2 = android.app.ProgressDialog.show(r2, r3, r4)
                r1.f4515a = r2
                b1 r2 = defpackage.C0793b1.a
                kn r3 = r2.f3912a
                if (r3 == 0) goto L_0x01e3
                androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
                java.lang.String r4 = "connectivity"
                java.lang.Object r3 = r3.getSystemService(r4)
                android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
                android.content.Context r4 = r1.getContext()
                boolean r3 = defpackage.C0535I5.O(r3, r4)
                if (r3 != 0) goto L_0x0179
                android.os.Handler r1 = new android.os.Handler
                r1.<init>()
                cris.org.in.ima.fragment.ChangeTxnPasswordFragment$a$a r2 = new cris.org.in.ima.fragment.ChangeTxnPasswordFragment$a$a
                r2.<init>()
                r3 = 5000(0x1388, double:2.4703E-320)
                r1.postDelayed(r2, r3)
                return
            L_0x0179:
                kn r2 = r2.f3912a
                java.lang.Object r2 = defpackage.C0657Qt.c(r2)
                Om r2 = (defpackage.Om) r2
                r3 = 4
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                Xo r4 = r1.a
                r4.setSource(r3)
                android.widget.EditText r3 = r1.oldPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r4.setOldPassword(r3)
                android.widget.EditText r3 = r1.newPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r4.setNewPassword(r3)
                android.widget.EditText r3 = r1.confirmPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r4.setConfPassword(r3)
                java.lang.String r3 = defpackage.C0657Qt.g()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r3)
                java.lang.String r3 = "changeTxnPassword"
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                rx.Observable r2 = r2.k0(r3, r4)
                Lm r3 = defpackage.C1181iv.a()
                rx.Observable r2 = r2.c(r3)
                Yi r3 = defpackage.E0.a()
                rx.Observable r2 = r2.a(r3)
                cris.org.in.ima.fragment.ChangeTxnPasswordFragment$a$b r3 = new cris.org.in.ima.fragment.ChangeTxnPasswordFragment$a$b
                r3.<init>()
                r2.b(r3)
            L_0x01e3:
                android.app.ProgressDialog r1 = r1.f4515a
                r1.dismiss()
            L_0x01e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ChangeTxnPasswordFragment.a.onClick(android.view.View):void");
        }

        /* renamed from: cris.org.in.ima.fragment.ChangeTxnPasswordFragment$a$a  reason: collision with other inner class name */
        public class C0061a implements Runnable {
            public final void run() {
            }
        }
    }
}
