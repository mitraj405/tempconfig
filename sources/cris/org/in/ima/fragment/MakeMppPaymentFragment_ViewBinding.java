package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class MakeMppPaymentFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MakeMppPaymentFragment f4765a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MakeMppPaymentFragment a;

        public a(MakeMppPaymentFragment makeMppPaymentFragment) {
            this.a = makeMppPaymentFragment;
        }

        public final void doClick(View view) {
            this.a.onClickValidilityCard();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MakeMppPaymentFragment a;

        public b(MakeMppPaymentFragment makeMppPaymentFragment) {
            this.a = makeMppPaymentFragment;
        }

        public final void doClick(View view) {
            this.a.onClickNetBanking();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MakeMppPaymentFragment a;

        public c(MakeMppPaymentFragment makeMppPaymentFragment) {
            this.a = makeMppPaymentFragment;
        }

        public final void doClick(View view) {
            this.a.onClickWallet();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MakeMppPaymentFragment a;

        public d(MakeMppPaymentFragment makeMppPaymentFragment) {
            this.a = makeMppPaymentFragment;
        }

        public final void doClick(View view) {
            this.a.onClickPayButton();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MakeMppPaymentFragment a;

        public e(MakeMppPaymentFragment makeMppPaymentFragment) {
            this.a = makeMppPaymentFragment;
        }

        public final void doClick(View view) {
            this.a.onCardClick();
        }
    }

    public MakeMppPaymentFragment_ViewBinding(MakeMppPaymentFragment makeMppPaymentFragment, View view) {
        this.f4765a = makeMppPaymentFragment;
        Class cls = EditText.class;
        makeMppPaymentFragment.nameOnCard = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name_on_card, "field 'nameOnCard'", cls);
        makeMppPaymentFragment.cardNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_card_number, "field 'cardNumber'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.et_card_validity, "field 'cardValidity' and method 'onClickValidilityCard'");
        Class cls2 = TextView.class;
        makeMppPaymentFragment.cardValidity = (TextView) Utils.castView(findRequiredView, R.id.et_card_validity, "field 'cardValidity'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(makeMppPaymentFragment));
        makeMppPaymentFragment.cvvNo = (EditText) Utils.findRequiredViewAsType(view, R.id.et_cvv, "field 'cvvNo'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ll_pg_option_netbanking, "field 'paymentOptionNetbanking' and method 'onClickNetBanking'");
        Class cls3 = RelativeLayout.class;
        makeMppPaymentFragment.paymentOptionNetbanking = (RelativeLayout) Utils.castView(findRequiredView2, R.id.ll_pg_option_netbanking, "field 'paymentOptionNetbanking'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(makeMppPaymentFragment));
        Class cls4 = LinearLayout.class;
        makeMppPaymentFragment.paymentOptionCards = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pg_option_cards, "field 'paymentOptionCards'", cls4);
        makeMppPaymentFragment.cardInputLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_card_input, "field 'cardInputLayout'", cls4);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_pg_option_wallet, "field 'paymentOptionWallet' and method 'onClickWallet'");
        makeMppPaymentFragment.paymentOptionWallet = (RelativeLayout) Utils.castView(findRequiredView3, R.id.ll_pg_option_wallet, "field 'paymentOptionWallet'", cls3);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(makeMppPaymentFragment));
        makeMppPaymentFragment.pgOptionWalletTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pg_option_wallet, "field 'pgOptionWalletTv'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.pay_now, "field 'payNowButton' and method 'onClickPayButton'");
        makeMppPaymentFragment.payNowButton = (TextView) Utils.castView(findRequiredView4, R.id.pay_now, "field 'payNowButton'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(makeMppPaymentFragment));
        makeMppPaymentFragment.totalFare = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_fare, "field 'totalFare'", cls2);
        makeMppPaymentFragment.llCardDetailsInput = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_card_details_input, "field 'llCardDetailsInput'", cls4);
        makeMppPaymentFragment.paymentoptionbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.payment_option_bottom, "field 'paymentoptionbottom'", AdManagerAdView.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rl_card_input, "method 'onCardClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(makeMppPaymentFragment));
    }

    public final void unbind() {
        MakeMppPaymentFragment makeMppPaymentFragment = this.f4765a;
        if (makeMppPaymentFragment != null) {
            this.f4765a = null;
            makeMppPaymentFragment.nameOnCard = null;
            makeMppPaymentFragment.cardNumber = null;
            makeMppPaymentFragment.cardValidity = null;
            makeMppPaymentFragment.cvvNo = null;
            makeMppPaymentFragment.paymentOptionNetbanking = null;
            makeMppPaymentFragment.paymentOptionCards = null;
            makeMppPaymentFragment.cardInputLayout = null;
            makeMppPaymentFragment.paymentOptionWallet = null;
            makeMppPaymentFragment.pgOptionWalletTv = null;
            makeMppPaymentFragment.payNowButton = null;
            makeMppPaymentFragment.totalFare = null;
            makeMppPaymentFragment.llCardDetailsInput = null;
            makeMppPaymentFragment.paymentoptionbottom = null;
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
