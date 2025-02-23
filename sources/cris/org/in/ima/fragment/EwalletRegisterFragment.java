package cris.org.in.ima.fragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;

public class EwalletRegisterFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4615a;
    @BindView(2131362586)
    EditText confirmPassword;
    @BindView(2131364705)
    TextView confirmPasswordShowHide;
    @BindView(2131364740)
    EditText password;
    @BindView(2131364707)
    TextView passwordShowHide;
    @BindView(2131364398)
    TextView tv_ewallet_reg_verification_msg;

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r18) {
            /*
                r17 = this;
                r0 = r17
                cris.org.in.ima.fragment.EwalletRegisterFragment r1 = cris.org.in.ima.fragment.EwalletRegisterFragment.this
                androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
                android.view.View r3 = r1.getView()
                defpackage.C0535I5.H(r2, r3)
                android.widget.EditText r2 = r1.password
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                r3 = 2131953334(0x7f1306b6, float:1.9543136E38)
                r4 = 2131952688(0x7f130430, float:1.9541826E38)
                if (r2 == 0) goto L_0x0043
                r2 = 2131952658(0x7f130412, float:1.9541765E38)
                java.lang.String r7 = r1.getString(r2)
                android.widget.EditText r2 = r1.password
                r2.requestFocus()
                android.content.Context r5 = r1.getContext()
                r6 = 0
                java.lang.String r8 = r1.getString(r4)
                java.lang.String r9 = r1.getString(r3)
                r10 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r5, r6, r7, r8, r9, r10)
                r1.show()
                return
            L_0x0043:
                android.widget.EditText r2 = r1.confirmPassword
                android.text.Editable r2 = r2.getText()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                r5 = 2131952657(0x7f130411, float:1.9541763E38)
                if (r2 == 0) goto L_0x006c
                java.lang.String r8 = r1.getString(r5)
                android.content.Context r6 = r1.getContext()
                r7 = 0
                java.lang.String r9 = r1.getString(r4)
                java.lang.String r10 = r1.getString(r3)
                r11 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)
                r1.show()
                return
            L_0x006c:
                android.widget.EditText r2 = r1.password
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                int r6 = r2.length()
                java.lang.String r7 = "ok"
                if (r6 == 0) goto L_0x0090
                java.lang.String r6 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$"
                boolean r2 = r2.matches(r6)
                if (r2 == 0) goto L_0x0088
                r10 = r7
                goto L_0x0095
            L_0x0088:
                r2 = 2131952447(0x7f13033f, float:1.9541337E38)
                java.lang.String r2 = r1.getString(r2)
                goto L_0x0094
            L_0x0090:
                java.lang.String r2 = r1.getString(r5)
            L_0x0094:
                r10 = r2
            L_0x0095:
                android.widget.EditText r2 = r1.password
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                android.widget.EditText r6 = r1.confirmPassword
                android.text.Editable r6 = r6.getText()
                java.lang.String r6 = r6.toString()
                if (r6 == 0) goto L_0x00c1
                int r8 = r6.length()
                if (r8 <= 0) goto L_0x00c1
                boolean r2 = r2.equals(r6)
                if (r2 == 0) goto L_0x00b9
                r13 = r7
                goto L_0x00c6
            L_0x00b9:
                r2 = 2131953269(0x7f130675, float:1.9543004E38)
                java.lang.String r2 = r1.getString(r2)
                goto L_0x00c5
            L_0x00c1:
                java.lang.String r2 = r1.getString(r5)
            L_0x00c5:
                r13 = r2
            L_0x00c6:
                boolean r2 = r10.equals(r7)
                if (r2 != 0) goto L_0x00e2
                android.content.Context r8 = r1.getContext()
                r9 = 0
                java.lang.String r11 = r1.getString(r4)
                java.lang.String r12 = r1.getString(r3)
                r13 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r8, r9, r10, r11, r12, r13)
                r1.show()
                return
            L_0x00e2:
                boolean r2 = r13.equals(r7)
                if (r2 != 0) goto L_0x00ff
                android.content.Context r11 = r1.getContext()
                r12 = 0
                java.lang.String r14 = r1.getString(r4)
                java.lang.String r15 = r1.getString(r3)
                r16 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r11, r12, r13, r14, r15, r16)
                r1.show()
                return
            L_0x00ff:
                kb r2 = new kb
                r2.<init>()
                kp r3 = new kp
                r3.<init>()
                android.widget.EditText r4 = r1.password
                android.text.Editable r4 = r4.getText()
                java.lang.String r4 = r4.toString()
                java.lang.String r4 = r4.trim()
                r2.setTxnPassword(r4)
                r2.setPaymentDetailDTO(r3)
                android.widget.EditText r3 = r1.confirmPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                java.lang.String r3 = r3.trim()
                r2.setTxnPasswordConfirm(r3)
                androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
                r4 = 2131953039(0x7f13058f, float:1.9542538E38)
                java.lang.String r4 = r1.getString(r4)
                r5 = 2131953495(0x7f130757, float:1.9543463E38)
                java.lang.String r5 = r1.getString(r5)
                android.app.ProgressDialog r3 = android.app.ProgressDialog.show(r3, r4, r5)
                b1 r4 = defpackage.C0793b1.a
                kn r4 = r4.f3912a
                java.lang.Object r4 = defpackage.C0657Qt.c(r4)
                Om r4 = (defpackage.Om) r4
                java.lang.String r5 = defpackage.C0657Qt.g()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                java.lang.String r5 = "ewalletRegWithNoPayment"
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                rx.Observable r2 = r4.w(r5, r2)
                Lm r4 = defpackage.C1181iv.a()
                rx.Observable r2 = r2.c(r4)
                Yi r4 = defpackage.E0.a()
                rx.Observable r2 = r2.a(r4)
                mb r4 = new mb
                r4.<init>(r1, r3)
                r2.b(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.EwalletRegisterFragment.a.onClick(android.view.View):void");
        }
    }

    static {
        C1354qp.R(EwalletRegisterFragment.class);
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
        View inflate = layoutInflater.inflate(R.layout.ewallet_register, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        this.f4615a = getActivity();
        HomeActivity.G(getString(R.string.submit));
        HomeActivity.f4190d.setOnClickListener(new a());
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131364707})
    public void pwdShowHide1() {
        f(this.password, this.passwordShowHide);
    }

    @OnClick({2131364705})
    public void pwdShowHide2() {
        f(this.confirmPassword, this.confirmPasswordShowHide);
    }
}
