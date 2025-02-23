package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class MyAccountFragment_ViewBinding implements Unbinder {
    public View A;
    public View B;
    public View C;
    public View D;
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MyAccountFragment f4830a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    public class A extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public A(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletDepositHistoryClick(view);
        }
    }

    public class B extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public B(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletAccTransactionClick(view);
        }
    }

    public class C extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public C(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletRefundStatusClick(view);
        }
    }

    public class D extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public D(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletAccStatementClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.MyAccountFragment_ViewBinding$a  reason: case insensitive filesystem */
    public class C0914a extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public C0914a(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletAccRegisterClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.MyAccountFragment_ViewBinding$b  reason: case insensitive filesystem */
    public class C0915b extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public C0915b(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletAccRenewalClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.MyAccountFragment_ViewBinding$c  reason: case insensitive filesystem */
    public class C0916c extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public C0916c(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityLayoutClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.MyAccountFragment_ViewBinding$d  reason: case insensitive filesystem */
    public class C0917d extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public C0917d(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityTxnClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public e(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityTxnClickBOB(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public f(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.addLoyaltyAccountClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public g(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onPurchaseLoyaltyPointsClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public h(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onChangeTxnPasswordClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public i(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onForgotTxnPasswordClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public j(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalitySbiCardLinkClick(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public k(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public l(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityLayoutSBIClick(view);
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public m(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityLayoutBOBClick(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public n(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityLayoutHDFCClick(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public o(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onMyProfileClick(view);
        }
    }

    public class p extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public p(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onChangePasswordClick(view);
        }
    }

    public class q extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public q(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onAadharKYC(view);
        }
    }

    public class r extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public r(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEditPsgnClick(view);
        }
    }

    public class s extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public s(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onTermsAndConditionsClick(view);
        }
    }

    public class t extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public t(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalitySbiLinkClick(view);
        }
    }

    public class u extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public u(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onAboutIrctcBobClick(view);
        }
    }

    public class v extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public v(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletAboutClick(view);
        }
    }

    public class w extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public w(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onLogoutClick(view);
        }
    }

    public class x extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public x(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletUserGuideClick(view);
        }
    }

    public class y extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public y(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletForgotPwdClick(view);
        }
    }

    public class z extends DebouncingOnClickListener {
        public final /* synthetic */ MyAccountFragment a;

        public z(MyAccountFragment myAccountFragment) {
            this.a = myAccountFragment;
        }

        public final void doClick(View view) {
            this.a.onEwalletDepositClick(view);
        }
    }

    public MyAccountFragment_ViewBinding(MyAccountFragment myAccountFragment, View view) {
        this.f4830a = myAccountFragment;
        Class cls = TextView.class;
        myAccountFragment.userFullName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'userFullName'", cls);
        myAccountFragment.useremail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_update_profile, "field 'useremail'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.rl_ewallet, "field 'rl_ewallet' and method 'onEwalletClick'");
        Class cls2 = RelativeLayout.class;
        myAccountFragment.rl_ewallet = (RelativeLayout) Utils.castView(findRequiredView, R.id.rl_ewallet, "field 'rl_ewallet'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new k(myAccountFragment));
        Class cls3 = ImageView.class;
        myAccountFragment.ewallet_dropdown_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.ewallet_dropdown_img, "field 'ewallet_dropdown_img'", cls3);
        Class cls4 = LinearLayout.class;
        myAccountFragment.ll_ewallet_menu = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_ewallet_menu, "field 'll_ewallet_menu'", cls4);
        myAccountFragment.ewallet_about_view = Utils.findRequiredView(view, R.id.ewallet_about_view, "field 'ewallet_about_view'");
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ewallet_about_rl, "field 'ewallet_about_rl' and method 'onEwalletAboutClick'");
        myAccountFragment.ewallet_about_rl = (RelativeLayout) Utils.castView(findRequiredView2, R.id.ewallet_about_rl, "field 'ewallet_about_rl'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new v(myAccountFragment));
        myAccountFragment.ewallet_user_guide_view = Utils.findRequiredView(view, R.id.ewallet_user_guide_view, "field 'ewallet_user_guide_view'");
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ewallet_user_guide_rl, "field 'ewallet_user_guide_rl' and method 'onEwalletUserGuideClick'");
        myAccountFragment.ewallet_user_guide_rl = (RelativeLayout) Utils.castView(findRequiredView3, R.id.ewallet_user_guide_rl, "field 'ewallet_user_guide_rl'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new x(myAccountFragment));
        myAccountFragment.ewallet_forgot_pwd_view = Utils.findRequiredView(view, R.id.ewallet_forgot_pwd_view, "field 'ewallet_forgot_pwd_view'");
        View findRequiredView4 = Utils.findRequiredView(view, R.id.ewallet_forgot_pwd_rl, "field 'ewallet_forgot_pwd_rl' and method 'onEwalletForgotPwdClick'");
        myAccountFragment.ewallet_forgot_pwd_rl = (RelativeLayout) Utils.castView(findRequiredView4, R.id.ewallet_forgot_pwd_rl, "field 'ewallet_forgot_pwd_rl'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new y(myAccountFragment));
        myAccountFragment.ewallet_deposit_view = Utils.findRequiredView(view, R.id.ewallet_deposit_view, "field 'ewallet_deposit_view'");
        View findRequiredView5 = Utils.findRequiredView(view, R.id.ewallet_deposit_rl, "field 'ewallet_deposit_rl' and method 'onEwalletDepositClick'");
        myAccountFragment.ewallet_deposit_rl = (RelativeLayout) Utils.castView(findRequiredView5, R.id.ewallet_deposit_rl, "field 'ewallet_deposit_rl'", cls2);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new z(myAccountFragment));
        myAccountFragment.ewallet_deposit_history_view = Utils.findRequiredView(view, R.id.ewallet_deposit_history_view, "field 'ewallet_deposit_history_view'");
        View findRequiredView6 = Utils.findRequiredView(view, R.id.ewallet_deposit_history_rl, "field 'ewallet_deposit_history_rl' and method 'onEwalletDepositHistoryClick'");
        myAccountFragment.ewallet_deposit_history_rl = (RelativeLayout) Utils.castView(findRequiredView6, R.id.ewallet_deposit_history_rl, "field 'ewallet_deposit_history_rl'", cls2);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new A(myAccountFragment));
        myAccountFragment.ewallet_acc_transaction_view = Utils.findRequiredView(view, R.id.ewallet_acc_transaction_view, "field 'ewallet_acc_transaction_view'");
        View findRequiredView7 = Utils.findRequiredView(view, R.id.ewallet_acc_transaction_rl, "field 'ewallet_acc_transaction_rl' and method 'onEwalletAccTransactionClick'");
        myAccountFragment.ewallet_acc_transaction_rl = (RelativeLayout) Utils.castView(findRequiredView7, R.id.ewallet_acc_transaction_rl, "field 'ewallet_acc_transaction_rl'", cls2);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new B(myAccountFragment));
        myAccountFragment.ewallet_refund_status_view = Utils.findRequiredView(view, R.id.ewallet_refund_status_view, "field 'ewallet_refund_status_view'");
        View findRequiredView8 = Utils.findRequiredView(view, R.id.ewallet_refund_status_rl, "field 'ewallet_refund_status_rl' and method 'onEwalletRefundStatusClick'");
        myAccountFragment.ewallet_refund_status_rl = (RelativeLayout) Utils.castView(findRequiredView8, R.id.ewallet_refund_status_rl, "field 'ewallet_refund_status_rl'", cls2);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new C(myAccountFragment));
        myAccountFragment.ewallet_acc_statement_view = Utils.findRequiredView(view, R.id.ewallet_acc_statement_view, "field 'ewallet_acc_statement_view'");
        View findRequiredView9 = Utils.findRequiredView(view, R.id.ewallet_acc_statement_rl, "field 'ewallet_acc_statement_rl' and method 'onEwalletAccStatementClick'");
        myAccountFragment.ewallet_acc_statement_rl = (RelativeLayout) Utils.castView(findRequiredView9, R.id.ewallet_acc_statement_rl, "field 'ewallet_acc_statement_rl'", cls2);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new D(myAccountFragment));
        myAccountFragment.ewallet_acc_register_view = Utils.findRequiredView(view, R.id.ewallet_acc_register_view, "field 'ewallet_acc_register_view'");
        View findRequiredView10 = Utils.findRequiredView(view, R.id.ewallet_acc_register_rl, "field 'ewallet_acc_register_rl' and method 'onEwalletAccRegisterClick'");
        myAccountFragment.ewallet_acc_register_rl = (RelativeLayout) Utils.castView(findRequiredView10, R.id.ewallet_acc_register_rl, "field 'ewallet_acc_register_rl'", cls2);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new C0914a(myAccountFragment));
        myAccountFragment.ewallet_acc_renewal_view = Utils.findRequiredView(view, R.id.ewallet_acc_renewal_view, "field 'ewallet_acc_renewal_view'");
        View findRequiredView11 = Utils.findRequiredView(view, R.id.ewallet_acc_renewal_rl, "field 'ewallet_acc_renewal_rl' and method 'onEwalletAccRenewalClick'");
        myAccountFragment.ewallet_acc_renewal_rl = (RelativeLayout) Utils.castView(findRequiredView11, R.id.ewallet_acc_renewal_rl, "field 'ewallet_acc_renewal_rl'", cls2);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new C0915b(myAccountFragment));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.rl_loyalty, "field 'loyaltyLayout' and method 'onLoyalityLayoutClick'");
        myAccountFragment.loyaltyLayout = (RelativeLayout) Utils.castView(findRequiredView12, R.id.rl_loyalty, "field 'loyaltyLayout'", cls2);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new C0916c(myAccountFragment));
        myAccountFragment.loyaltyDropdownImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.loyalty_dropdown_img, "field 'loyaltyDropdownImg'", cls3);
        myAccountFragment.viewLine = Utils.findRequiredView(view, R.id.view1, "field 'viewLine'");
        myAccountFragment.viewLine2 = Utils.findRequiredView(view, R.id.view2, "field 'viewLine2'");
        View findRequiredView13 = Utils.findRequiredView(view, R.id.rl_loyalty_txn, "field 'loyaltyTxnHistory' and method 'onLoyalityTxnClick'");
        myAccountFragment.loyaltyTxnHistory = (RelativeLayout) Utils.castView(findRequiredView13, R.id.rl_loyalty_txn, "field 'loyaltyTxnHistory'", cls2);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new C0917d(myAccountFragment));
        View findRequiredView14 = Utils.findRequiredView(view, R.id.rl_loyalty_txn_bob, "field 'bobLoyaltyTxnHistory' and method 'onLoyalityTxnClickBOB'");
        myAccountFragment.bobLoyaltyTxnHistory = (RelativeLayout) Utils.castView(findRequiredView14, R.id.rl_loyalty_txn_bob, "field 'bobLoyaltyTxnHistory'", cls2);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(myAccountFragment));
        myAccountFragment.loyaltyaccount_view = Utils.findRequiredView(view, R.id.loyaltyaccount_view, "field 'loyaltyaccount_view'");
        myAccountFragment.irctc_sbiview = Utils.findRequiredView(view, R.id.irctc_sbiview, "field 'irctc_sbiview'");
        myAccountFragment.add_loyalty = Utils.findRequiredView(view, R.id.add_loyalty, "field 'add_loyalty'");
        myAccountFragment.my_loyalty_account = Utils.findRequiredView(view, R.id.my_loyalty_account, "field 'my_loyalty_account'");
        myAccountFragment.purchase_pointview = Utils.findRequiredView(view, R.id.purchase_pointview, "field 'purchase_pointview'");
        myAccountFragment.LoyaltyShowHide = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_Loyalty_show_hide, "field 'LoyaltyShowHide'", cls4);
        myAccountFragment.LoyaltyCurrentBalanceLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_loyalty_current_balance, "field 'LoyaltyCurrentBalanceLayout'", cls2);
        myAccountFragment.LoyaltyCurrentBalanceLayoutBob = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_loyalty_current_balance_bob, "field 'LoyaltyCurrentBalanceLayoutBob'", cls2);
        myAccountFragment.LoyaltyCurrentBalanceLayoutHdfc = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_loyalty_current_balance_hdfc, "field 'LoyaltyCurrentBalanceLayoutHdfc'", cls2);
        myAccountFragment.LoyaltyCurrentBalance = (TextView) Utils.findRequiredViewAsType(view, R.id.loyalty_current_balance, "field 'LoyaltyCurrentBalance'", cls);
        View findRequiredView15 = Utils.findRequiredView(view, R.id.rl_add_loyalty_account, "field 'addLoyaltyAccount' and method 'addLoyaltyAccountClick'");
        myAccountFragment.addLoyaltyAccount = (RelativeLayout) Utils.castView(findRequiredView15, R.id.rl_add_loyalty_account, "field 'addLoyaltyAccount'", cls2);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new f(myAccountFragment));
        View findRequiredView16 = Utils.findRequiredView(view, R.id.purchase_loyalty_points_ll, "field 'purchaseLoyaltyPoints' and method 'onPurchaseLoyaltyPointsClick'");
        myAccountFragment.purchaseLoyaltyPoints = (RelativeLayout) Utils.castView(findRequiredView16, R.id.purchase_loyalty_points_ll, "field 'purchaseLoyaltyPoints'", cls2);
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new g(myAccountFragment));
        myAccountFragment.view_change_txn_pwd = Utils.findRequiredView(view, R.id.view_change_txn_pwd, "field 'view_change_txn_pwd'");
        View findRequiredView17 = Utils.findRequiredView(view, R.id.rl_change_txn_pwd, "field 'rl_change_txn_pwd' and method 'onChangeTxnPasswordClick'");
        myAccountFragment.rl_change_txn_pwd = (RelativeLayout) Utils.castView(findRequiredView17, R.id.rl_change_txn_pwd, "field 'rl_change_txn_pwd'", cls2);
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new h(myAccountFragment));
        myAccountFragment.view_forgot_txn_pwd = Utils.findRequiredView(view, R.id.view_forgot_txn_pwd, "field 'view_forgot_txn_pwd'");
        View findRequiredView18 = Utils.findRequiredView(view, R.id.rl_forgot_txn_pwd, "field 'rl_forgot_txn_pwd' and method 'onForgotTxnPasswordClick'");
        myAccountFragment.rl_forgot_txn_pwd = (RelativeLayout) Utils.castView(findRequiredView18, R.id.rl_forgot_txn_pwd, "field 'rl_forgot_txn_pwd'", cls2);
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new i(myAccountFragment));
        myAccountFragment.myaccount_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.myaccount_ads, "field 'myaccount_ads'", AdManagerAdView.class);
        View findRequiredView19 = Utils.findRequiredView(view, R.id.rl_loyalty_sbi_card_link, "field 'rl_loyalty_sbi_card_link' and method 'onLoyalitySbiCardLinkClick'");
        myAccountFragment.rl_loyalty_sbi_card_link = (RelativeLayout) Utils.castView(findRequiredView19, R.id.rl_loyalty_sbi_card_link, "field 'rl_loyalty_sbi_card_link'", cls2);
        this.s = findRequiredView19;
        findRequiredView19.setOnClickListener(new j(myAccountFragment));
        myAccountFragment.rl_loyalty_bob_card_link = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_loyalty_bob_card_link, "field 'rl_loyalty_bob_card_link'", cls2);
        View findRequiredView20 = Utils.findRequiredView(view, R.id.rl_sbi_link, "field 'rl_sbi_link' and method 'onLoyalityLayoutSBIClick'");
        myAccountFragment.rl_sbi_link = (RelativeLayout) Utils.castView(findRequiredView20, R.id.rl_sbi_link, "field 'rl_sbi_link'", cls2);
        this.t = findRequiredView20;
        findRequiredView20.setOnClickListener(new l(myAccountFragment));
        myAccountFragment.ll_sbi_link = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_sbi_link, "field 'll_sbi_link'", cls4);
        myAccountFragment.rl_bob_link = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_bob_link, "field 'rl_bob_link'", cls2);
        myAccountFragment.ll_Loyalty_show_hide_bob = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_Loyalty_show_hide_bob, "field 'll_Loyalty_show_hide_bob'", cls4);
        View findRequiredView21 = Utils.findRequiredView(view, R.id.ll_bob_link, "field 'll_bob_link' and method 'onLoyalityLayoutBOBClick'");
        myAccountFragment.ll_bob_link = (LinearLayout) Utils.castView(findRequiredView21, R.id.ll_bob_link, "field 'll_bob_link'", cls4);
        this.u = findRequiredView21;
        findRequiredView21.setOnClickListener(new m(myAccountFragment));
        myAccountFragment.ll_hdfc_link = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_hdfc_link, "field 'll_hdfc_link'", cls4);
        myAccountFragment.loyalty_current_balance_bob = (TextView) Utils.findRequiredViewAsType(view, R.id.loyalty_current_balance_bob, "field 'loyalty_current_balance_bob'", cls);
        View findRequiredView22 = Utils.findRequiredView(view, R.id.rl_hdfc_link, "field 'rl_hdfc_link' and method 'onLoyalityLayoutHDFCClick'");
        myAccountFragment.rl_hdfc_link = (RelativeLayout) Utils.castView(findRequiredView22, R.id.rl_hdfc_link, "field 'rl_hdfc_link'", cls2);
        this.v = findRequiredView22;
        findRequiredView22.setOnClickListener(new n(myAccountFragment));
        myAccountFragment.ll_Loyalty_show_hide_hdfc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_Loyalty_show_hide_hdfc, "field 'll_Loyalty_show_hide_hdfc'", cls4);
        myAccountFragment.loyalty_current_balance_hdfc = (TextView) Utils.findRequiredViewAsType(view, R.id.loyalty_current_balance_hdfc, "field 'loyalty_current_balance_hdfc'", cls);
        View findRequiredView23 = Utils.findRequiredView(view, R.id.myprofile_ll, "method 'onMyProfileClick'");
        this.w = findRequiredView23;
        findRequiredView23.setOnClickListener(new o(myAccountFragment));
        View findRequiredView24 = Utils.findRequiredView(view, R.id.rl_change_pwd, "method 'onChangePasswordClick'");
        this.x = findRequiredView24;
        findRequiredView24.setOnClickListener(new p(myAccountFragment));
        View findRequiredView25 = Utils.findRequiredView(view, R.id.aadharkyc_ll, "method 'onAadharKYC'");
        this.y = findRequiredView25;
        findRequiredView25.setOnClickListener(new q(myAccountFragment));
        View findRequiredView26 = Utils.findRequiredView(view, R.id.rl_masterlist, "method 'onEditPsgnClick'");
        this.z = findRequiredView26;
        findRequiredView26.setOnClickListener(new r(myAccountFragment));
        View findRequiredView27 = Utils.findRequiredView(view, R.id.tv_terms_conditions, "method 'onTermsAndConditionsClick'");
        this.A = findRequiredView27;
        findRequiredView27.setOnClickListener(new s(myAccountFragment));
        View findRequiredView28 = Utils.findRequiredView(view, R.id.rl_loyalty_sbi_link, "method 'onLoyalitySbiLinkClick'");
        this.B = findRequiredView28;
        findRequiredView28.setOnClickListener(new t(myAccountFragment));
        View findRequiredView29 = Utils.findRequiredView(view, R.id.rl_loyalty_sbi_link_bob, "method 'onAboutIrctcBobClick'");
        this.C = findRequiredView29;
        findRequiredView29.setOnClickListener(new u(myAccountFragment));
        View findRequiredView30 = Utils.findRequiredView(view, R.id.rl_logout, "method 'onLogoutClick'");
        this.D = findRequiredView30;
        findRequiredView30.setOnClickListener(new w(myAccountFragment));
    }

    public final void unbind() {
        MyAccountFragment myAccountFragment = this.f4830a;
        if (myAccountFragment != null) {
            this.f4830a = null;
            myAccountFragment.userFullName = null;
            myAccountFragment.useremail = null;
            myAccountFragment.rl_ewallet = null;
            myAccountFragment.ewallet_dropdown_img = null;
            myAccountFragment.ll_ewallet_menu = null;
            myAccountFragment.ewallet_about_view = null;
            myAccountFragment.ewallet_about_rl = null;
            myAccountFragment.ewallet_user_guide_view = null;
            myAccountFragment.ewallet_user_guide_rl = null;
            myAccountFragment.ewallet_forgot_pwd_view = null;
            myAccountFragment.ewallet_forgot_pwd_rl = null;
            myAccountFragment.ewallet_deposit_view = null;
            myAccountFragment.ewallet_deposit_rl = null;
            myAccountFragment.ewallet_deposit_history_view = null;
            myAccountFragment.ewallet_deposit_history_rl = null;
            myAccountFragment.ewallet_acc_transaction_view = null;
            myAccountFragment.ewallet_acc_transaction_rl = null;
            myAccountFragment.ewallet_refund_status_view = null;
            myAccountFragment.ewallet_refund_status_rl = null;
            myAccountFragment.ewallet_acc_statement_view = null;
            myAccountFragment.ewallet_acc_statement_rl = null;
            myAccountFragment.ewallet_acc_register_view = null;
            myAccountFragment.ewallet_acc_register_rl = null;
            myAccountFragment.ewallet_acc_renewal_view = null;
            myAccountFragment.ewallet_acc_renewal_rl = null;
            myAccountFragment.loyaltyLayout = null;
            myAccountFragment.loyaltyDropdownImg = null;
            myAccountFragment.viewLine = null;
            myAccountFragment.viewLine2 = null;
            myAccountFragment.loyaltyTxnHistory = null;
            myAccountFragment.bobLoyaltyTxnHistory = null;
            myAccountFragment.loyaltyaccount_view = null;
            myAccountFragment.irctc_sbiview = null;
            myAccountFragment.add_loyalty = null;
            myAccountFragment.my_loyalty_account = null;
            myAccountFragment.purchase_pointview = null;
            myAccountFragment.LoyaltyShowHide = null;
            myAccountFragment.LoyaltyCurrentBalanceLayout = null;
            myAccountFragment.LoyaltyCurrentBalanceLayoutBob = null;
            myAccountFragment.LoyaltyCurrentBalanceLayoutHdfc = null;
            myAccountFragment.LoyaltyCurrentBalance = null;
            myAccountFragment.addLoyaltyAccount = null;
            myAccountFragment.purchaseLoyaltyPoints = null;
            myAccountFragment.view_change_txn_pwd = null;
            myAccountFragment.rl_change_txn_pwd = null;
            myAccountFragment.view_forgot_txn_pwd = null;
            myAccountFragment.rl_forgot_txn_pwd = null;
            myAccountFragment.myaccount_ads = null;
            myAccountFragment.rl_loyalty_sbi_card_link = null;
            myAccountFragment.rl_loyalty_bob_card_link = null;
            myAccountFragment.rl_sbi_link = null;
            myAccountFragment.ll_sbi_link = null;
            myAccountFragment.rl_bob_link = null;
            myAccountFragment.ll_Loyalty_show_hide_bob = null;
            myAccountFragment.ll_bob_link = null;
            myAccountFragment.ll_hdfc_link = null;
            myAccountFragment.loyalty_current_balance_bob = null;
            myAccountFragment.rl_hdfc_link = null;
            myAccountFragment.ll_Loyalty_show_hide_hdfc = null;
            myAccountFragment.loyalty_current_balance_hdfc = null;
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
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
            this.o.setOnClickListener((View.OnClickListener) null);
            this.o = null;
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
            this.s.setOnClickListener((View.OnClickListener) null);
            this.s = null;
            this.t.setOnClickListener((View.OnClickListener) null);
            this.t = null;
            this.u.setOnClickListener((View.OnClickListener) null);
            this.u = null;
            this.v.setOnClickListener((View.OnClickListener) null);
            this.v = null;
            this.w.setOnClickListener((View.OnClickListener) null);
            this.w = null;
            this.x.setOnClickListener((View.OnClickListener) null);
            this.x = null;
            this.y.setOnClickListener((View.OnClickListener) null);
            this.y = null;
            this.z.setOnClickListener((View.OnClickListener) null);
            this.z = null;
            this.A.setOnClickListener((View.OnClickListener) null);
            this.A = null;
            this.B.setOnClickListener((View.OnClickListener) null);
            this.B = null;
            this.C.setOnClickListener((View.OnClickListener) null);
            this.C = null;
            this.D.setOnClickListener((View.OnClickListener) null);
            this.D = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
