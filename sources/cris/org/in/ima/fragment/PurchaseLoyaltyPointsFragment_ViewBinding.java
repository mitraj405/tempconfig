package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class PurchaseLoyaltyPointsFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PurchaseLoyaltyPointsFragment f5058a;

    /* renamed from: a  reason: collision with other field name */
    public a f5059a;

    /* renamed from: a  reason: collision with other field name */
    public f f5060a;

    /* renamed from: a  reason: collision with other field name */
    public l f5061a;
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

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public b(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.onClickgst(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public c(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.onClickMin(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public d(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.onClickPlus(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public e(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.purchaseLoyaltyPointsClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public g(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.onClicfundadutymsg(view);
        }
    }

    public class h implements View.OnFocusChangeListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public h(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.flaDoorBlockVerify(view);
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public i(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.streetLaneVerify(view);
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public j(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.areaLocalityVerify(view);
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public k(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.pinCodeValidate(view);
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public m(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void doClick(View view) {
            this.a.onCityClick(view);
        }
    }

    public class n implements View.OnFocusChangeListener {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public n(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.gstinValidate(view);
        }
    }

    public PurchaseLoyaltyPointsFragment_ViewBinding(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment, View view) {
        this.f5058a = purchaseLoyaltyPointsFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_reward_point, "field 'rewardPoint' and method 'rewardPointTextChange'");
        Class cls = EditText.class;
        purchaseLoyaltyPointsFragment.rewardPoint = (EditText) Utils.castView(findRequiredView, R.id.et_reward_point, "field 'rewardPoint'", cls);
        this.a = findRequiredView;
        f fVar = new f(purchaseLoyaltyPointsFragment);
        this.f5060a = fVar;
        ((TextView) findRequiredView).addTextChangedListener(fVar);
        Class cls2 = TextView.class;
        purchaseLoyaltyPointsFragment.totalValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_value, "field 'totalValue'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.gstin_detail_ll, "field 'gstin_detail_ll' and method 'onClicfundadutymsg'");
        Class cls3 = LinearLayout.class;
        purchaseLoyaltyPointsFragment.gstin_detail_ll = (LinearLayout) Utils.castView(findRequiredView2, R.id.gstin_detail_ll, "field 'gstin_detail_ll'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new g(purchaseLoyaltyPointsFragment));
        purchaseLoyaltyPointsFragment.gstpassengerName = (EditText) Utils.findRequiredViewAsType(view, R.id.gst_passenger_name, "field 'gstpassengerName'", cls);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.flat_door_block, "field 'flatDoorBlock' and method 'flaDoorBlockVerify'");
        purchaseLoyaltyPointsFragment.flatDoorBlock = (EditText) Utils.castView(findRequiredView3, R.id.flat_door_block, "field 'flatDoorBlock'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnFocusChangeListener(new h(purchaseLoyaltyPointsFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.street_lane, "field 'streetLane' and method 'streetLaneVerify'");
        purchaseLoyaltyPointsFragment.streetLane = (EditText) Utils.castView(findRequiredView4, R.id.street_lane, "field 'streetLane'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnFocusChangeListener(new i(purchaseLoyaltyPointsFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.area_locality, "field 'areaLocality' and method 'areaLocalityVerify'");
        purchaseLoyaltyPointsFragment.areaLocality = (EditText) Utils.castView(findRequiredView5, R.id.area_locality, "field 'areaLocality'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnFocusChangeListener(new j(purchaseLoyaltyPointsFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.et_pincode, "field 'pinCode', method 'pinCodeValidate', and method 'onPinCodeTextChanged'");
        purchaseLoyaltyPointsFragment.pinCode = (EditText) Utils.castView(findRequiredView6, R.id.et_pincode, "field 'pinCode'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnFocusChangeListener(new k(purchaseLoyaltyPointsFragment));
        l lVar = new l(purchaseLoyaltyPointsFragment);
        this.f5061a = lVar;
        ((TextView) findRequiredView6).addTextChangedListener(lVar);
        purchaseLoyaltyPointsFragment.state = (TextView) Utils.findRequiredViewAsType(view, R.id.et_state_reg, "field 'state'", cls2);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.city_reg, "field 'city' and method 'onCityClick'");
        purchaseLoyaltyPointsFragment.city = (TextView) Utils.castView(findRequiredView7, R.id.city_reg, "field 'city'", cls2);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new m(purchaseLoyaltyPointsFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.gstin_number, "field 'gstinNumber', method 'gstinValidate', and method 'onGstinNumberTextChanged'");
        purchaseLoyaltyPointsFragment.gstinNumber = (EditText) Utils.castView(findRequiredView8, R.id.gstin_number, "field 'gstinNumber'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnFocusChangeListener(new n(purchaseLoyaltyPointsFragment));
        a aVar = new a(purchaseLoyaltyPointsFragment);
        this.f5059a = aVar;
        ((TextView) findRequiredView8).addTextChangedListener(aVar);
        purchaseLoyaltyPointsFragment.gst_rl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.gst_detail_ll, "field 'gst_rl'", cls3);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.gst_rl, "field 'gstcolumnShow' and method 'onClickgst'");
        purchaseLoyaltyPointsFragment.gstcolumnShow = (RelativeLayout) Utils.castView(findRequiredView9, R.id.gst_rl, "field 'gstcolumnShow'", RelativeLayout.class);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new b(purchaseLoyaltyPointsFragment));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.iv_min, "method 'onClickMin'");
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new c(purchaseLoyaltyPointsFragment));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.iv_plus, "method 'onClickPlus'");
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new d(purchaseLoyaltyPointsFragment));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.purchase_loyalty_points, "method 'purchaseLoyaltyPointsClick'");
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new e(purchaseLoyaltyPointsFragment));
    }

    public final void unbind() {
        PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment = this.f5058a;
        if (purchaseLoyaltyPointsFragment != null) {
            this.f5058a = null;
            purchaseLoyaltyPointsFragment.rewardPoint = null;
            purchaseLoyaltyPointsFragment.totalValue = null;
            purchaseLoyaltyPointsFragment.gstin_detail_ll = null;
            purchaseLoyaltyPointsFragment.gstpassengerName = null;
            purchaseLoyaltyPointsFragment.flatDoorBlock = null;
            purchaseLoyaltyPointsFragment.streetLane = null;
            purchaseLoyaltyPointsFragment.areaLocality = null;
            purchaseLoyaltyPointsFragment.pinCode = null;
            purchaseLoyaltyPointsFragment.state = null;
            purchaseLoyaltyPointsFragment.city = null;
            purchaseLoyaltyPointsFragment.gstinNumber = null;
            purchaseLoyaltyPointsFragment.gst_rl = null;
            purchaseLoyaltyPointsFragment.gstcolumnShow = null;
            ((TextView) this.a).removeTextChangedListener(this.f5060a);
            this.f5060a = null;
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.c = null;
            this.d.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.d = null;
            this.e.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.e = null;
            this.f.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.f).removeTextChangedListener(this.f5061a);
            this.f5061a = null;
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.h).removeTextChangedListener(this.f5059a);
            this.f5059a = null;
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class a implements TextWatcher {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public a(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onGstinNumberTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class f implements TextWatcher {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public f(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.rewardPointTextChange();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class l implements TextWatcher {
        public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

        public l(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
            this.a = purchaseLoyaltyPointsFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPinCodeTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
