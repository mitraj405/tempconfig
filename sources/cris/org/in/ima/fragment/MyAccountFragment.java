package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import in.juspay.hyper.core.JuspayCoreLib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;

public class MyAccountFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    @BindView(2131363115)
    TextView LoyaltyCurrentBalance;
    @BindView(2131363741)
    RelativeLayout LoyaltyCurrentBalanceLayout;
    @BindView(2131363742)
    RelativeLayout LoyaltyCurrentBalanceLayoutBob;
    @BindView(2131363743)
    RelativeLayout LoyaltyCurrentBalanceLayoutHdfc;
    @BindView(2131363002)
    LinearLayout LoyaltyShowHide;
    public C0574LB a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4823a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4824a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f4825a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletProfileDTO f4826a;

    /* renamed from: a  reason: collision with other field name */
    public C1311ox f4827a = null;
    @BindView(2131363707)
    RelativeLayout addLoyaltyAccount;
    @BindView(2131361899)
    View add_loyalty;
    public C1311ox b = null;
    @BindView(2131363750)
    RelativeLayout bobLoyaltyTxnHistory;

    /* renamed from: c  reason: collision with other field name */
    public String f4828c = "";
    @BindView(2131362594)
    RelativeLayout ewallet_about_rl;
    @BindView(2131362595)
    View ewallet_about_view;
    @BindView(2131362596)
    RelativeLayout ewallet_acc_register_rl;
    @BindView(2131362597)
    View ewallet_acc_register_view;
    @BindView(2131362598)
    RelativeLayout ewallet_acc_renewal_rl;
    @BindView(2131362599)
    View ewallet_acc_renewal_view;
    @BindView(2131362600)
    RelativeLayout ewallet_acc_statement_rl;
    @BindView(2131362601)
    View ewallet_acc_statement_view;
    @BindView(2131362602)
    RelativeLayout ewallet_acc_transaction_rl;
    @BindView(2131362603)
    View ewallet_acc_transaction_view;
    @BindView(2131362605)
    RelativeLayout ewallet_deposit_history_rl;
    @BindView(2131362606)
    View ewallet_deposit_history_view;
    @BindView(2131362607)
    RelativeLayout ewallet_deposit_rl;
    @BindView(2131362608)
    View ewallet_deposit_view;
    @BindView(2131362609)
    ImageView ewallet_dropdown_img;
    @BindView(2131362610)
    RelativeLayout ewallet_forgot_pwd_rl;
    @BindView(2131362611)
    View ewallet_forgot_pwd_view;
    @BindView(2131362613)
    RelativeLayout ewallet_refund_status_rl;
    @BindView(2131362614)
    View ewallet_refund_status_view;
    @BindView(2131362617)
    RelativeLayout ewallet_user_guide_rl;
    @BindView(2131362618)
    View ewallet_user_guide_view;
    @BindView(2131362864)
    View irctc_sbiview;
    @BindView(2131363003)
    LinearLayout ll_Loyalty_show_hide_bob;
    @BindView(2131363004)
    LinearLayout ll_Loyalty_show_hide_hdfc;
    @BindView(2131363008)
    LinearLayout ll_bob_link;
    @BindView(2131363023)
    LinearLayout ll_ewallet_menu;
    @BindView(2131363034)
    LinearLayout ll_hdfc_link;
    @BindView(2131363059)
    LinearLayout ll_sbi_link;
    @BindView(2131363118)
    ImageView loyaltyDropdownImg;
    @BindView(2131363739)
    RelativeLayout loyaltyLayout;
    @BindView(2131363749)
    RelativeLayout loyaltyTxnHistory;
    @BindView(2131363116)
    TextView loyalty_current_balance_bob;
    @BindView(2131363117)
    TextView loyalty_current_balance_hdfc;
    @BindView(2131363121)
    View loyaltyaccount_view;
    @BindView(2131363287)
    View my_loyalty_account;
    @BindView(2131363291)
    AdManagerAdView myaccount_ads;
    @BindView(2131363565)
    RelativeLayout purchaseLoyaltyPoints;
    @BindView(2131363566)
    View purchase_pointview;
    @BindView(2131363713)
    RelativeLayout rl_bob_link;
    @BindView(2131363720)
    RelativeLayout rl_change_txn_pwd;
    @BindView(2131363723)
    RelativeLayout rl_ewallet;
    @BindView(2131363729)
    RelativeLayout rl_forgot_txn_pwd;
    @BindView(2131363732)
    RelativeLayout rl_hdfc_link;
    @BindView(2131363740)
    RelativeLayout rl_loyalty_bob_card_link;
    @BindView(2131363746)
    RelativeLayout rl_loyalty_sbi_card_link;
    @BindView(2131363763)
    RelativeLayout rl_sbi_link;
    @BindView(2131364714)
    TextView userFullName;
    @BindView(2131364711)
    TextView useremail;
    @BindView(2131364814)
    View viewLine;
    @BindView(2131364816)
    View viewLine2;
    @BindView(2131364825)
    View view_change_txn_pwd;
    @BindView(2131364829)
    View view_forgot_txn_pwd;

    public class b implements DialogInterface.OnClickListener {

        public class a extends Subscriber<Boolean> {
            public a(ProgressDialog progressDialog) {
            }

            public final void onCompleted() {
                int i = MyAccountFragment.c;
                b bVar = b.this;
                MyAccountFragment.this.getClass();
                MyAccountFragment myAccountFragment = MyAccountFragment.this;
                myAccountFragment.getClass();
                C0535I5.Z(myAccountFragment.f4824a, (InterstitialAd) null, true);
            }

            public final void onError(Throwable th) {
                int i = MyAccountFragment.c;
                th.getMessage();
                MyAccountFragment.this.getClass();
            }

            public final void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                int i = MyAccountFragment.c;
            }
        }

        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            TicketHistoryUtil.c();
            MyAccountFragment myAccountFragment = MyAccountFragment.this;
            ProgressDialog show = ProgressDialog.show(myAccountFragment.f4824a, myAccountFragment.getString(R.string.logout_loading), myAccountFragment.getString(R.string.please_wait_text));
            String f = C0657Qt.f();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).t0(f + "logout").c(C1181iv.a()).a(E0.a()).b(new a(show));
        }
    }

    public class e extends Subscriber<C0561KB> {
        public final /* synthetic */ ProgressDialog a;

        public e(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = MyAccountFragment.c;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = MyAccountFragment.c;
            th.getClass();
            th.getMessage();
            ProgressDialog progressDialog = this.a;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            C0561KB kb = (C0561KB) obj;
            int i = MyAccountFragment.c;
            ProgressDialog progressDialog = this.a;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            if (kb.getError() == null) {
                MyAccountFragment myAccountFragment = MyAccountFragment.this;
                String str = myAccountFragment.f4828c;
                C1218kf kfVar = C1218kf.MY_PROFILE;
                if (!str.equals(kfVar)) {
                    HomeActivity.B(myAccountFragment.getActivity());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("updateProfile", kb);
                    kb.toString();
                    MyProfileFragment myProfileFragment = new MyProfileFragment();
                    myProfileFragment.setArguments(bundle);
                    HomeActivity.n((AppCompatActivity) myAccountFragment.getActivity(), myProfileFragment, kfVar.a(), Boolean.TRUE, Boolean.FALSE);
                }
            }
        }
    }

    public class g extends Subscriber<C1358qx> {
        public g() {
        }

        public final void onCompleted() {
            int i = MyAccountFragment.c;
        }

        public final void onError(Throwable th) {
            MyAccountFragment.this.f4823a.dismiss();
            int i = MyAccountFragment.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            C1358qx qxVar = (C1358qx) obj;
            MyAccountFragment myAccountFragment = MyAccountFragment.this;
            myAccountFragment.f4823a.dismiss();
            if (qxVar.getSoftAccountSummaryDTO() != null) {
                for (C1311ox next : qxVar.getSoftAccountSummaryDTO()) {
                    if (next.getBankName().contains(myAccountFragment.getString(R.string.sbi_bank))) {
                        if (next.getError() == null) {
                            myAccountFragment.f4827a = next;
                            C1408tl tlVar = C1450w1.f7012a;
                            try {
                                C0657Qt.h().writeValueAsString(qxVar.getSoftAccountSummaryDTO());
                                int i = MyAccountFragment.c;
                            } catch (JsonProcessingException e) {
                                int i2 = MyAccountFragment.c;
                                e.getMessage();
                            }
                            String valueOf = String.valueOf(next.getTotalPointsAvailable().toString());
                            myAccountFragment.LoyaltyCurrentBalance.setText(String.format(myAccountFragment.getString(R.string.Current_Points_Balance), new Object[]{Double.valueOf(valueOf)}));
                        } else {
                            C0535I5.m(myAccountFragment.f4824a, false, next.getError(), myAccountFragment.getString(R.string.error), myAccountFragment.f4824a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                    }
                    if (next.getBankName().contains(myAccountFragment.getString(R.string.bob_bank))) {
                        if (next.getError() == null) {
                            myAccountFragment.b = next;
                            C1408tl tlVar2 = C1450w1.f7012a;
                            try {
                                C0657Qt.h().writeValueAsString(qxVar.getSoftAccountSummaryDTO());
                                int i3 = MyAccountFragment.c;
                            } catch (JsonProcessingException e2) {
                                int i4 = MyAccountFragment.c;
                                e2.getMessage();
                            }
                        } else {
                            C0535I5.m(myAccountFragment.f4824a, false, next.getError(), myAccountFragment.getString(R.string.error), myAccountFragment.f4824a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                    }
                }
                return;
            }
            FragmentActivity fragmentActivity = myAccountFragment.f4824a;
            C0535I5.m(fragmentActivity, false, fragmentActivity.getResources().getString(R.string.unable_process_message), myAccountFragment.getString(R.string.error), myAccountFragment.f4824a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    static {
        C1354qp.R(MyAccountFragment.class);
    }

    @OnClick({2131363707})
    public void addLoyaltyAccountClick(View view) {
        HomeActivity.B(getActivity());
        HomeActivity.n((AppCompatActivity) getActivity(), new AddLoyaltyFragment(), C1218kf.ADD_LOYALITY.a(), Boolean.TRUE, Boolean.FALSE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -2122697333(0xffffffff817a358b, float:-4.5956163E-38)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L_0x002d
            r1 = 108960(0x1a9a0, float:1.52685E-40)
            if (r0 == r1) goto L_0x0022
            r1 = 3387192(0x33af38, float:4.746467E-39)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "none"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0020
            goto L_0x0035
        L_0x0020:
            r6 = r2
            goto L_0x0038
        L_0x0022:
            java.lang.String r0 = "new"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x002b
            goto L_0x0035
        L_0x002b:
            r6 = r3
            goto L_0x0038
        L_0x002d:
            java.lang.String r0 = "existing"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0037
        L_0x0035:
            r6 = -1
            goto L_0x0038
        L_0x0037:
            r6 = r4
        L_0x0038:
            r0 = 8
            if (r6 == 0) goto L_0x00e5
            if (r6 == r3) goto L_0x0094
            if (r6 == r2) goto L_0x0042
            goto L_0x0121
        L_0x0042:
            android.view.View r6 = r5.ewallet_forgot_pwd_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_forgot_pwd_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_deposit_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_deposit_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_deposit_history_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_deposit_history_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_transaction_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_transaction_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_refund_status_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_refund_status_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_statement_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_statement_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_register_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_register_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_renewal_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_renewal_rl
            r6.setVisibility(r0)
            goto L_0x0121
        L_0x0094:
            android.view.View r6 = r5.ewallet_forgot_pwd_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_forgot_pwd_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_deposit_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_deposit_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_deposit_history_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_deposit_history_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_transaction_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_transaction_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_refund_status_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_refund_status_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_statement_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_statement_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_register_view
            r6.setVisibility(r4)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_register_rl
            r6.setVisibility(r4)
            android.view.View r6 = r5.ewallet_acc_renewal_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_renewal_rl
            r6.setVisibility(r0)
            goto L_0x0121
        L_0x00e5:
            android.view.View r6 = r5.ewallet_deposit_history_view
            r6.setVisibility(r4)
            android.widget.RelativeLayout r6 = r5.ewallet_deposit_history_rl
            r6.setVisibility(r4)
            android.view.View r6 = r5.ewallet_acc_transaction_view
            r6.setVisibility(r4)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_transaction_rl
            r6.setVisibility(r4)
            android.view.View r6 = r5.ewallet_refund_status_view
            r6.setVisibility(r4)
            android.widget.RelativeLayout r6 = r5.ewallet_refund_status_rl
            r6.setVisibility(r4)
            android.view.View r6 = r5.ewallet_acc_statement_view
            r6.setVisibility(r4)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_statement_rl
            r6.setVisibility(r4)
            android.view.View r6 = r5.ewallet_acc_register_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_register_rl
            r6.setVisibility(r0)
            android.view.View r6 = r5.ewallet_acc_renewal_view
            r6.setVisibility(r0)
            android.widget.RelativeLayout r6 = r5.ewallet_acc_renewal_rl
            r6.setVisibility(r0)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.MyAccountFragment.f(java.lang.String):void");
    }

    public final void g() {
        this.a.setUser_loginid(Bw.e(JuspayCoreLib.getApplicationContext()).h());
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4824a)) {
            new Handler().postDelayed(new d(), 5000);
            return;
        }
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).R0(C1058d.z(C0657Qt.f(), "getUserProfile"), this.a).c(C1181iv.a()).a(E0.a()).b(new e(ProgressDialog.show(getActivity(), getString(R.string.loading), getString(R.string.please_wait_text))));
    }

    public final void h() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new f(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            ProgressDialog progressDialog = this.f4823a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f4823a.dismiss();
            }
            this.f4823a = ProgressDialog.show(getActivity(), getString(R.string.getting_loyaty_detail), getString(R.string.please_wait_text));
            String i = C0657Qt.i();
            ((Om) C0657Qt.c(b1Var.f3912a)).h1(i + "accountDetails").c(C1181iv.a()).a(E0.a()).b(new g());
        }
    }

    public final void i() {
        Bw e2 = Bw.e(getContext());
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        if (e2.g() == null) {
            this.userFullName.setText(e2.d());
        } else {
            TextView textView = this.userFullName;
            textView.setText(e2.d() + " " + e2.g());
        }
        this.useremail.setText(C0535I5.d0(e2.j()));
        C0535I5.Y(getActivity(), this.myaccount_ads, googleAdParamDTO);
        if (C0535I5.R()) {
            C0494EB eb = C1450w1.f7006a;
            eb.f3576a = true;
            eb.toString();
            if (eb.a < 1 || !eb.f3576a) {
                f("new");
            } else {
                f("existing");
            }
        } else {
            f("none");
        }
        this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
        this.loyaltyDropdownImg.setRotation(90.0f);
    }

    @OnClick({2131361823})
    public void onAadharKYC(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new AadhaarKYCFragment(), C1218kf.AUTHENTICATE_USER.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363748})
    public void onAboutIrctcBobClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/AboutBOBCobrandCard.pdf")));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363719})
    public void onChangePasswordClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new ChangePasswordFragment(), C1218kf.CHANGE_PASSWORD.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363720})
    public void onChangeTxnPasswordClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new ChangeTxnPasswordFragment(), C1218kf.CHANGE_TXN_PASSWORD.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0494EB eb;
        View inflate = layoutInflater.inflate(R.layout.fragment_my_account, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        C0535I5.I(getActivity());
        this.f4823a = new ProgressDialog(getContext());
        this.f4824a = getActivity();
        HomeActivity.p();
        HomeActivity.o();
        HomeActivity.J();
        HomeActivity.z();
        this.f4825a = getFragmentManager();
        this.viewLine.setVisibility(8);
        this.viewLine2.setVisibility(8);
        i();
        this.a = new C0574LB();
        if (C0535I5.o) {
            C0535I5.o = false;
            g();
        }
        ArrayList<C0471CB> arrayList = C1450w1.f7017b;
        if ((arrayList == null || arrayList.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) && ((eb = C1450w1.f7006a) == null || eb.a != 2)) {
            this.view_change_txn_pwd.setVisibility(8);
            this.rl_change_txn_pwd.setVisibility(8);
            this.view_forgot_txn_pwd.setVisibility(8);
            this.rl_forgot_txn_pwd.setVisibility(8);
        } else {
            this.view_change_txn_pwd.setVisibility(0);
            this.rl_change_txn_pwd.setVisibility(0);
            this.view_forgot_txn_pwd.setVisibility(0);
            this.rl_forgot_txn_pwd.setVisibility(0);
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4823a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4823a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363751})
    public void onEditPsgnClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new MasterPassengerListNewFragment(), C1218kf.MASTER_PSGN_LIST.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131362594})
    public void onEwalletAboutClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.ewallet_viewer2) + "https://contents.irctc.co.in/en/AboutEwallet.pdf")));
    }

    @OnClick({2131362596})
    public void onEwalletAccRegisterClick(View view) {
        C0494EB eb = C1450w1.f7006a;
        eb.f3576a = true;
        int i = eb.a;
        if (i == 1) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("ewalletProfileDTO", this.f4826a);
            EwalletRegisterFragment ewalletRegisterFragment = new EwalletRegisterFragment();
            ewalletRegisterFragment.setArguments(bundle);
            HomeActivity.B(getActivity());
            HomeActivity.n((AppCompatActivity) getActivity(), ewalletRegisterFragment, C1218kf.EWALLET_REGISTER.a(), Boolean.TRUE, Boolean.FALSE);
        } else if (i == 0) {
            AadhaarKYCFragment aadhaarKYCFragment = new AadhaarKYCFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("type", "ewallet");
            aadhaarKYCFragment.setArguments(bundle2);
            HomeActivity.n((AppCompatActivity) getActivity(), aadhaarKYCFragment, C1218kf.AUTHENTICATE_USER.a(), Boolean.TRUE, Boolean.FALSE);
            FragmentManager fragmentManager = this.f4825a;
            fragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
            aVar.n(this);
            aVar.c();
        }
    }

    @OnClick({2131362598})
    public void onEwalletAccRenewalClick(View view) {
        C0535I5.t0(getActivity(), "eWallet Account Renewal - Coming Soon");
    }

    @OnClick({2131362600})
    public void onEwalletAccStatementClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new EwalletStatementFragment(), C1218kf.EWALLET_STMT.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131362602})
    public void onEwalletAccTransactionClick(View view) {
        TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.EWALLET_TXN;
        HomeActivity.n((AppCompatActivity) getActivity(), new MyBookingFragment(), C1218kf.EWALLET_TXNS.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131363723})
    public void onEwalletClick(View view) {
        if (this.ll_ewallet_menu.getVisibility() == 8) {
            this.ewallet_dropdown_img.setRotation(180.0f);
            this.ll_ewallet_menu.setVisibility(0);
            C0494EB eb = C1450w1.f7006a;
            eb.f3576a = true;
            int i = eb.a;
            if ((i == 0 || i == 1) && this.f4826a == null) {
                ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.loading), getString(R.string.please_wait_text));
                String g2 = C0657Qt.g();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).a0(g2 + "ewalletRegisterNow").c(C1181iv.a()).a(E0.a()).b(new W(this, show));
                return;
            }
            return;
        }
        this.ewallet_dropdown_img.setRotation(90.0f);
        this.ll_ewallet_menu.setVisibility(8);
    }

    @OnClick({2131362607})
    public void onEwalletDepositClick(View view) {
        C0535I5.t0(getActivity(), getString(R.string.ewallet_deposit_coming_soon));
    }

    @OnClick({2131362605})
    public void onEwalletDepositHistoryClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new EwalletDepositHistoryFragment(), C1218kf.EWALLET_DEPOSIT_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131362610})
    public void onEwalletForgotPwdClick(View view) {
        C0535I5.t0(getActivity(), getString(R.string.ewallet_forgot_transaction_password_coming_soon));
    }

    @OnClick({2131362613})
    public void onEwalletRefundStatusClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new EwalletRefundStatusFragment(), C1218kf.EWALLET_REFUND_STATUS.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131362617})
    public void onEwalletUserGuideClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.ewallet_viewer2) + "https://contents.irctc.co.in/en/EwalletUserGuide.pdf")));
    }

    @OnClick({2131363729})
    public void onForgotTxnPasswordClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new ForgotTxnPasswordFragment(), C1218kf.FORGOT_TXN_PASSWORD.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363738})
    public void onLogoutClick(View view) {
        try {
            C0535I5.r(getActivity(), getString(R.string.logout_message), getString(R.string.exit_alert), getString(R.string.yes), new b(), getString(R.string.no), new c(), getString(R.string.alert_logout_ads)).show();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363008})
    public void onLoyalityLayoutBOBClick(View view) {
        if (this.LoyaltyShowHide.getVisibility() == 0 || this.ll_Loyalty_show_hide_hdfc.getVisibility() == 0) {
            this.LoyaltyShowHide.setVisibility(8);
            this.ll_Loyalty_show_hide_hdfc.setVisibility(8);
            ArrayList<C0471CB> arrayList = C1450w1.f7017b;
            if (arrayList == null || arrayList.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
                this.bobLoyaltyTxnHistory.setVisibility(8);
                this.loyaltyaccount_view.setVisibility(8);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(8);
                this.my_loyalty_account.setVisibility(8);
                this.LoyaltyCurrentBalanceLayoutBob.setVisibility(8);
                this.purchaseLoyaltyPoints.setVisibility(8);
            } else {
                this.bobLoyaltyTxnHistory.setVisibility(0);
                this.loyaltyaccount_view.setVisibility(0);
                this.my_loyalty_account.setVisibility(0);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(0);
                this.LoyaltyCurrentBalanceLayoutBob.setVisibility(0);
                this.purchaseLoyaltyPoints.setVisibility(0);
            }
            if (this.ll_Loyalty_show_hide_bob.getVisibility() == 8) {
                this.ll_Loyalty_show_hide_bob.setVisibility(0);
                this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
                this.loyaltyDropdownImg.setRotation(0.0f);
                if (this.b != null) {
                    this.bobLoyaltyTxnHistory.setVisibility(0);
                    this.LoyaltyCurrentBalanceLayoutBob.setVisibility(0);
                    return;
                }
                this.LoyaltyCurrentBalanceLayoutBob.setVisibility(8);
                this.bobLoyaltyTxnHistory.setVisibility(8);
                return;
            }
            this.ll_Loyalty_show_hide_bob.setVisibility(8);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
            this.loyaltyDropdownImg.setRotation(90.0f);
            return;
        }
        ArrayList<C0471CB> arrayList2 = C1450w1.f7017b;
        if (arrayList2 == null || arrayList2.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
            this.bobLoyaltyTxnHistory.setVisibility(8);
            this.loyaltyaccount_view.setVisibility(8);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(8);
            this.purchase_pointview.setVisibility(4);
            this.my_loyalty_account.setVisibility(8);
            this.LoyaltyCurrentBalanceLayoutBob.setVisibility(8);
            this.purchaseLoyaltyPoints.setVisibility(8);
        } else {
            this.bobLoyaltyTxnHistory.setVisibility(0);
            this.loyaltyaccount_view.setVisibility(0);
            this.my_loyalty_account.setVisibility(0);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(0);
            this.LoyaltyCurrentBalanceLayoutBob.setVisibility(0);
            this.purchaseLoyaltyPoints.setVisibility(0);
        }
        if (this.ll_Loyalty_show_hide_bob.getVisibility() == 8) {
            this.ll_Loyalty_show_hide_bob.setVisibility(0);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
            this.loyaltyDropdownImg.setRotation(0.0f);
            if (this.b != null) {
                this.bobLoyaltyTxnHistory.setVisibility(0);
                this.LoyaltyCurrentBalanceLayoutBob.setVisibility(0);
                return;
            }
            this.bobLoyaltyTxnHistory.setVisibility(8);
            this.LoyaltyCurrentBalanceLayoutBob.setVisibility(8);
            return;
        }
        this.ll_Loyalty_show_hide_bob.setVisibility(8);
        this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
        this.loyaltyDropdownImg.setRotation(90.0f);
    }

    @OnClick({2131363739})
    public void onLoyalityLayoutClick(View view) {
        if (this.addLoyaltyAccount.getVisibility() == 0 || this.LoyaltyShowHide.getVisibility() == 0 || this.ll_Loyalty_show_hide_bob.getVisibility() == 0 || this.ll_Loyalty_show_hide_hdfc.getVisibility() == 0) {
            this.addLoyaltyAccount.setVisibility(8);
            this.LoyaltyShowHide.setVisibility(8);
            this.ll_Loyalty_show_hide_bob.setVisibility(8);
            this.ll_Loyalty_show_hide_hdfc.setVisibility(8);
        } else {
            this.addLoyaltyAccount.setVisibility(0);
        }
        this.viewLine.setVisibility(8);
        this.viewLine2.setVisibility(8);
        if (this.ll_sbi_link.getVisibility() == 0 || this.ll_bob_link.getVisibility() == 0 || this.ll_hdfc_link.getVisibility() == 0) {
            Iterator<C1187j2> it = C1450w1.f7022c.iterator();
            while (it.hasNext()) {
                C1187j2 next = it.next();
                if (String.valueOf(next.getBankId()).equals("101")) {
                    this.ll_sbi_link.setVisibility(8);
                } else if (String.valueOf(next.getBankId()).equals("102")) {
                    this.ll_bob_link.setVisibility(8);
                } else if (String.valueOf(next.getBankId()).equals("103")) {
                    this.ll_hdfc_link.setVisibility(8);
                }
            }
            return;
        }
        this.viewLine.setVisibility(0);
        this.viewLine2.setVisibility(0);
        Iterator<C1187j2> it2 = C1450w1.f7022c.iterator();
        while (it2.hasNext()) {
            C1187j2 next2 = it2.next();
            if (String.valueOf(next2.getBankId()).equals("101")) {
                this.ll_sbi_link.setVisibility(0);
                if (next2.getPaymentModeName() != null && !next2.getPaymentModeName().isEmpty()) {
                    this.rl_loyalty_sbi_card_link.setVisibility(8);
                }
            } else if (String.valueOf(next2.getBankId()).equals("102")) {
                this.ll_bob_link.setVisibility(0);
                if (next2.getPaymentModeName() != null && !next2.getPaymentModeName().isEmpty()) {
                    this.rl_loyalty_bob_card_link.setVisibility(8);
                }
            }
            this.ll_hdfc_link.setVisibility(8);
        }
        Iterator<C0471CB> it3 = C1450w1.f7017b.iterator();
        boolean z = false;
        while (it3.hasNext()) {
            C0471CB next3 = it3.next();
            if (next3.getSoftAccountSummaryDTO() != null && next3.getSoftAccountSummaryDTO().getBankName().contains(getString(R.string.sbi))) {
                this.LoyaltyCurrentBalance.setText(String.format(getString(R.string.Current_Points_Balance), new Object[]{Double.valueOf(String.valueOf(next3.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString()))}));
            } else if (next3.getSoftAccountSummaryDTO() != null && next3.getSoftAccountSummaryDTO().getBankName().contains(getString(R.string.bob))) {
                this.loyalty_current_balance_bob.setText(String.format(getString(R.string.Current_Points_Balance), new Object[]{Double.valueOf(String.valueOf(next3.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString()))}));
            }
            z = true;
        }
        if (z) {
            h();
        }
    }

    @OnClick({2131363732})
    public void onLoyalityLayoutHDFCClick(View view) {
        if (this.ll_Loyalty_show_hide_bob.getVisibility() == 0 || this.LoyaltyShowHide.getVisibility() == 0) {
            this.LoyaltyShowHide.setVisibility(8);
            this.ll_Loyalty_show_hide_bob.setVisibility(8);
            ArrayList<C0471CB> arrayList = C1450w1.f7017b;
            if (arrayList == null || arrayList.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
                this.loyaltyTxnHistory.setVisibility(8);
                this.loyaltyaccount_view.setVisibility(8);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(8);
                this.my_loyalty_account.setVisibility(8);
                this.LoyaltyCurrentBalanceLayoutHdfc.setVisibility(8);
                this.purchaseLoyaltyPoints.setVisibility(8);
            } else {
                this.loyaltyTxnHistory.setVisibility(0);
                this.loyaltyaccount_view.setVisibility(0);
                this.my_loyalty_account.setVisibility(0);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(0);
                this.LoyaltyCurrentBalanceLayoutHdfc.setVisibility(0);
                this.purchaseLoyaltyPoints.setVisibility(0);
            }
            if (this.ll_Loyalty_show_hide_hdfc.getVisibility() == 8) {
                this.ll_Loyalty_show_hide_hdfc.setVisibility(0);
                this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
                this.loyaltyDropdownImg.setRotation(0.0f);
                ArrayList<C0471CB> arrayList2 = C1450w1.f7017b;
                if (arrayList2 != null) {
                    Iterator<C0471CB> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C0471CB next = it.next();
                        if (next.getSoftAccountSummaryDTO() == null || !next.getSoftAccountSummaryDTO().getBankName().contains("HDFC")) {
                            h();
                        } else {
                            String valueOf = String.valueOf(next.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString());
                            this.loyalty_current_balance_hdfc.setText(String.format(getString(R.string.Current_Points_Balance), new Object[]{Double.valueOf(valueOf)}));
                        }
                    }
                    return;
                }
                return;
            }
            this.ll_Loyalty_show_hide_hdfc.setVisibility(8);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
            this.loyaltyDropdownImg.setRotation(90.0f);
            return;
        }
        ArrayList<C0471CB> arrayList3 = C1450w1.f7017b;
        if (arrayList3 == null || arrayList3.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
            this.loyaltyTxnHistory.setVisibility(8);
            this.loyaltyaccount_view.setVisibility(8);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(8);
            this.my_loyalty_account.setVisibility(8);
            this.LoyaltyCurrentBalanceLayoutHdfc.setVisibility(8);
            this.purchaseLoyaltyPoints.setVisibility(8);
        } else {
            this.loyaltyTxnHistory.setVisibility(0);
            this.loyaltyaccount_view.setVisibility(0);
            this.my_loyalty_account.setVisibility(0);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(0);
            this.LoyaltyCurrentBalanceLayoutHdfc.setVisibility(0);
            this.purchaseLoyaltyPoints.setVisibility(0);
        }
        if (this.ll_Loyalty_show_hide_hdfc.getVisibility() == 8) {
            this.ll_Loyalty_show_hide_hdfc.setVisibility(0);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
            this.loyaltyDropdownImg.setRotation(0.0f);
            ArrayList<C0471CB> arrayList4 = C1450w1.f7017b;
            if (arrayList4 != null) {
                Iterator<C0471CB> it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    C0471CB next2 = it2.next();
                    if (next2.getSoftAccountSummaryDTO() == null || !next2.getSoftAccountSummaryDTO().getBankName().contains("HDFC")) {
                        h();
                    } else {
                        String valueOf2 = String.valueOf(next2.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString());
                        this.loyalty_current_balance_hdfc.setText(String.format(getString(R.string.Current_Points_Balance), new Object[]{Double.valueOf(valueOf2)}));
                    }
                }
                return;
            }
            return;
        }
        this.ll_Loyalty_show_hide_hdfc.setVisibility(8);
        this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
        this.loyaltyDropdownImg.setRotation(90.0f);
    }

    @OnClick({2131363763})
    public void onLoyalityLayoutSBIClick(View view) {
        if (this.ll_Loyalty_show_hide_bob.getVisibility() == 0 || this.ll_Loyalty_show_hide_hdfc.getVisibility() == 0) {
            this.ll_Loyalty_show_hide_bob.setVisibility(8);
            this.ll_Loyalty_show_hide_hdfc.setVisibility(8);
            ArrayList<C0471CB> arrayList = C1450w1.f7017b;
            if (arrayList == null || arrayList.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
                this.loyaltyTxnHistory.setVisibility(8);
                this.loyaltyaccount_view.setVisibility(8);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(8);
                this.my_loyalty_account.setVisibility(8);
                this.LoyaltyCurrentBalanceLayout.setVisibility(8);
                this.purchaseLoyaltyPoints.setVisibility(8);
            } else {
                this.loyaltyTxnHistory.setVisibility(0);
                this.loyaltyaccount_view.setVisibility(0);
                this.my_loyalty_account.setVisibility(0);
                this.irctc_sbiview.setVisibility(0);
                this.add_loyalty.setVisibility(0);
                this.purchase_pointview.setVisibility(0);
                this.LoyaltyCurrentBalanceLayout.setVisibility(0);
                this.purchaseLoyaltyPoints.setVisibility(0);
            }
            if (this.LoyaltyShowHide.getVisibility() == 8) {
                this.LoyaltyShowHide.setVisibility(0);
                this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
                this.loyaltyDropdownImg.setRotation(0.0f);
                if (this.f4827a != null) {
                    this.loyaltyTxnHistory.setVisibility(0);
                    this.LoyaltyCurrentBalanceLayout.setVisibility(0);
                    return;
                }
                this.loyaltyTxnHistory.setVisibility(8);
                this.LoyaltyCurrentBalanceLayout.setVisibility(8);
                return;
            }
            this.LoyaltyShowHide.setVisibility(8);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
            this.loyaltyDropdownImg.setRotation(90.0f);
            return;
        }
        ArrayList<C0471CB> arrayList2 = C1450w1.f7017b;
        if (arrayList2 == null || arrayList2.size() <= 0 || !C1450w1.f7017b.get(0).getSoftUser().booleanValue()) {
            this.loyaltyTxnHistory.setVisibility(8);
            this.loyaltyaccount_view.setVisibility(8);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(8);
            this.my_loyalty_account.setVisibility(8);
            this.LoyaltyCurrentBalanceLayout.setVisibility(8);
            this.purchaseLoyaltyPoints.setVisibility(8);
        } else {
            this.loyaltyTxnHistory.setVisibility(0);
            this.loyaltyaccount_view.setVisibility(0);
            this.my_loyalty_account.setVisibility(0);
            this.irctc_sbiview.setVisibility(0);
            this.add_loyalty.setVisibility(0);
            this.purchase_pointview.setVisibility(0);
            this.LoyaltyCurrentBalanceLayout.setVisibility(0);
            this.purchaseLoyaltyPoints.setVisibility(0);
        }
        if (this.LoyaltyShowHide.getVisibility() == 8) {
            this.LoyaltyShowHide.setVisibility(0);
            this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_downwards));
            this.loyaltyDropdownImg.setRotation(0.0f);
            if (this.f4827a != null) {
                this.LoyaltyCurrentBalanceLayout.setVisibility(0);
                this.loyaltyTxnHistory.setVisibility(0);
                return;
            }
            this.loyaltyTxnHistory.setVisibility(8);
            this.LoyaltyCurrentBalanceLayout.setVisibility(8);
            return;
        }
        this.LoyaltyShowHide.setVisibility(8);
        this.loyaltyDropdownImg.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.spinner_upwards));
        this.loyaltyDropdownImg.setRotation(90.0f);
    }

    @OnClick({2131363746})
    public void onLoyalitySbiCardLinkClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.sbicard.com/en/eapply/campaign.page?path=personal/credit-cards/travel/irctc-sbi-platinum-card.dcr&GEMID1=dis_irctc_ban_loy-tab-oth_acq_SEP_sbicard_e-apply&GEMID2=irctc")));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363747})
    public void onLoyalitySbiLinkClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/AboutSBICobrandCard.pdf")));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363749})
    public void onLoyalityTxnClick(View view) {
        LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = new LoyalityTxnHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("softAccountSummary", this.f4827a);
        loyalityTxnHistoryFragment.setArguments(bundle);
        HomeActivity.n((AppCompatActivity) getActivity(), loyalityTxnHistoryFragment, C1218kf.LOYALITY_TRANSACTION.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363750})
    public void onLoyalityTxnClickBOB(View view) {
        LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = new LoyalityTxnHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("softAccountSummary", this.b);
        loyalityTxnHistoryFragment.setArguments(bundle);
        HomeActivity.n((AppCompatActivity) getActivity(), loyalityTxnHistoryFragment, C1218kf.LOYALITY_TRANSACTION.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4825a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363294})
    public void onMyProfileClick(View view) {
        this.f4828c = "";
        try {
            List<Fragment> I = getActivity().getSupportFragmentManager().I();
            if (I != null && I.size() > 0) {
                int size = I.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        Fragment fragment = I.get(size);
                        if (fragment != null) {
                            this.f4828c = fragment.getTag();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            this.f4828c = "";
        }
        g();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4823a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4823a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363565})
    public void onPurchaseLoyaltyPointsClick(View view) {
        HomeActivity.B(getActivity());
        HomeActivity.n((AppCompatActivity) getActivity(), new PurchaseLoyaltyPointsFragment(), C1218kf.PURCHASE_LOYALTY_POINTS.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void onResume() {
        super.onResume();
        i();
        HomeActivity.p();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4823a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4823a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364658})
    public void onTermsAndConditionsClick(View view) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getActivity())) {
            new Handler().postDelayed(new a(), 5000);
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.tnc_general))));
        }
    }

    public class a implements Runnable {
        public final void run() {
        }
    }

    public class d implements Runnable {
        public final void run() {
        }
    }

    public class f implements Runnable {
        public final void run() {
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
