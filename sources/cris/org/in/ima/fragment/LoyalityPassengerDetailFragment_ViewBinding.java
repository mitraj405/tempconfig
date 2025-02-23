package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class LoyalityPassengerDetailFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LoyalityPassengerDetailFragment f4753a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public a(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.addMore();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public b(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.removeEditBox();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public c(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAccuralBtnClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public d(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onRedemptionBtnClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public e(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onSkipBtnClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public f(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onClicfundadutymsg(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public g(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onClick();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityPassengerDetailFragment a;

        public h(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment) {
            this.a = loyalityPassengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyaltyBankClick(view);
        }
    }

    public LoyalityPassengerDetailFragment_ViewBinding(LoyalityPassengerDetailFragment loyalityPassengerDetailFragment, View view) {
        this.f4753a = loyalityPassengerDetailFragment;
        Class cls = TextView.class;
        loyalityPassengerDetailFragment.loyalityNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loyality_number, "field 'loyalityNumber'", cls);
        loyalityPassengerDetailFragment.totalAvlPts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_point, "field 'totalAvlPts'", cls);
        loyalityPassengerDetailFragment.totalRedeemPts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_Redem_point, "field 'totalRedeemPts'", cls);
        loyalityPassengerDetailFragment.sbiRewardPts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sbi_Reward_point, "field 'sbiRewardPts'", cls);
        loyalityPassengerDetailFragment.tatalSbiPts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sbi_point, "field 'tatalSbiPts'", cls);
        loyalityPassengerDetailFragment.totalPurchasePts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_irctc_purchase_point, "field 'totalPurchasePts'", cls);
        Class cls2 = LinearLayout.class;
        loyalityPassengerDetailFragment.heading_loyaltyno_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.heading_loyaltyno_ll, "field 'heading_loyaltyno_ll'", cls2);
        loyalityPassengerDetailFragment.linear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linearLayoutMain, "field 'linear'", cls2);
        loyalityPassengerDetailFragment.linear1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linearLayout1, "field 'linear1'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_addmore_link, "field 'addLink' and method 'addMore'");
        loyalityPassengerDetailFragment.addLink = (TextView) Utils.castView(findRequiredView, R.id.tv_addmore_link, "field 'addLink'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(loyalityPassengerDetailFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_remove_link, "field 'removeLink' and method 'removeEditBox'");
        loyalityPassengerDetailFragment.removeLink = (TextView) Utils.castView(findRequiredView2, R.id.tv_remove_link, "field 'removeLink'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(loyalityPassengerDetailFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_accural, "field 'accural' and method 'onAccuralBtnClick'");
        Class cls3 = RadioButton.class;
        loyalityPassengerDetailFragment.accural = (RadioButton) Utils.castView(findRequiredView3, R.id.tv_accural, "field 'accural'", cls3);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(loyalityPassengerDetailFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_redemption, "field 'redemption' and method 'onRedemptionBtnClick'");
        loyalityPassengerDetailFragment.redemption = (RadioButton) Utils.castView(findRequiredView4, R.id.tv_redemption, "field 'redemption'", cls3);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(loyalityPassengerDetailFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_skip, "field 'skip' and method 'onSkipBtnClick'");
        loyalityPassengerDetailFragment.skip = (TextView) Utils.castView(findRequiredView5, R.id.tv_skip, "field 'skip'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(loyalityPassengerDetailFragment));
        loyalityPassengerDetailFragment.radioGroup = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.radiogroup_points, "field 'radioGroup'", RadioGroup.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.contact_detail_rl, "field 'contact_detail_rl' and method 'onClicfundadutymsg'");
        Class cls4 = RelativeLayout.class;
        loyalityPassengerDetailFragment.contact_detail_rl = (RelativeLayout) Utils.castView(findRequiredView6, R.id.contact_detail_rl, "field 'contact_detail_rl'", cls4);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(loyalityPassengerDetailFragment));
        loyalityPassengerDetailFragment.contact_detail = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.contact_detail, "field 'contact_detail'", cls2);
        loyalityPassengerDetailFragment.loyalty_bank = (TextView) Utils.findRequiredViewAsType(view, R.id.loyalty_bank, "field 'loyalty_bank'", cls);
        loyalityPassengerDetailFragment.loyalty_membership_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loyalty_membership_detail_ll, "field 'loyalty_membership_detail_ll'", cls2);
        loyalityPassengerDetailFragment.ll_radiogroup = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_radiogroup, "field 'll_radiogroup'", cls2);
        loyalityPassengerDetailFragment.addremove_loyaltyid_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.addremove_loyaltyid_rl, "field 'addremove_loyaltyid_rl'", cls4);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.journey_detail, "method 'onClick'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new g(loyalityPassengerDetailFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.loayalty_bank_rl, "method 'onLoyaltyBankClick'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new h(loyalityPassengerDetailFragment));
    }

    public final void unbind() {
        LoyalityPassengerDetailFragment loyalityPassengerDetailFragment = this.f4753a;
        if (loyalityPassengerDetailFragment != null) {
            this.f4753a = null;
            loyalityPassengerDetailFragment.loyalityNumber = null;
            loyalityPassengerDetailFragment.totalAvlPts = null;
            loyalityPassengerDetailFragment.totalRedeemPts = null;
            loyalityPassengerDetailFragment.sbiRewardPts = null;
            loyalityPassengerDetailFragment.tatalSbiPts = null;
            loyalityPassengerDetailFragment.totalPurchasePts = null;
            loyalityPassengerDetailFragment.heading_loyaltyno_ll = null;
            loyalityPassengerDetailFragment.linear = null;
            loyalityPassengerDetailFragment.linear1 = null;
            loyalityPassengerDetailFragment.addLink = null;
            loyalityPassengerDetailFragment.removeLink = null;
            loyalityPassengerDetailFragment.accural = null;
            loyalityPassengerDetailFragment.redemption = null;
            loyalityPassengerDetailFragment.skip = null;
            loyalityPassengerDetailFragment.radioGroup = null;
            loyalityPassengerDetailFragment.contact_detail_rl = null;
            loyalityPassengerDetailFragment.contact_detail = null;
            loyalityPassengerDetailFragment.loyalty_bank = null;
            loyalityPassengerDetailFragment.loyalty_membership_detail_ll = null;
            loyalityPassengerDetailFragment.ll_radiogroup = null;
            loyalityPassengerDetailFragment.addremove_loyaltyid_rl = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
