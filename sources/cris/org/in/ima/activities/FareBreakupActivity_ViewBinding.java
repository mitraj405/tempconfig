package cris.org.in.ima.activities;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class FareBreakupActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public FareBreakupActivity f4167a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ FareBreakupActivity a;

        public a(FareBreakupActivity fareBreakupActivity) {
            this.a = fareBreakupActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public FareBreakupActivity_ViewBinding(FareBreakupActivity fareBreakupActivity, View view) {
        this.f4167a = fareBreakupActivity;
        Class cls = TextView.class;
        fareBreakupActivity.basicPay = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_basic_pay, "field 'basicPay'", cls);
        fareBreakupActivity.reservationCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reservation_charges, "field 'reservationCharges'", cls);
        fareBreakupActivity.superfastCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_superfast_charges, "field 'superfastCharges'", cls);
        fareBreakupActivity.tatkalCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tatkal_charges, "field 'tatkalCharges'", cls);
        fareBreakupActivity.dynamicCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dynamic_charges, "field 'dynamicCharges'", cls);
        fareBreakupActivity.serviceCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_service_charges, "field 'serviceCharges'", cls);
        fareBreakupActivity.cateringCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_catering_charges, "field 'cateringCharges'", cls);
        fareBreakupActivity.netpayCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_netpay_charges, "field 'netpayCharges'", cls);
        fareBreakupActivity.otherCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_other_charges, "field 'otherCharges'", cls);
        fareBreakupActivity.fareLableMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.fare_lable_message, "field 'fareLableMessage'", cls);
        fareBreakupActivity.messageLable = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.message_lable, "field 'messageLable'", LinearLayout.class);
        fareBreakupActivity.tv_sub_title_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sub_title_name, "field 'tv_sub_title_name'", cls);
        fareBreakupActivity.rvFareBackup = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_fare_backup, "field 'rvFareBackup'", RecyclerView.class);
        Class cls2 = ScrollView.class;
        fareBreakupActivity.scrollViewDirect = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_direct, "field 'scrollViewDirect'", cls2);
        fareBreakupActivity.scrollViewInDirect = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_indirect, "field 'scrollViewInDirect'", cls2);
        fareBreakupActivity.base_fare = (TextView) Utils.findRequiredViewAsType(view, R.id.base_fare, "field 'base_fare'", cls);
        Class cls3 = RelativeLayout.class;
        fareBreakupActivity.reservationll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.reservation_ll, "field 'reservationll'", cls3);
        fareBreakupActivity.super_fast_charge_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.super_fast_charge_ll, "field 'super_fast_charge_ll'", cls3);
        fareBreakupActivity.tatkalcharge_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tatkalcharge_ll, "field 'tatkalcharge_ll'", cls3);
        fareBreakupActivity.dynamiccharge_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.dynamiccharge_ll, "field 'dynamiccharge_ll'", cls3);
        fareBreakupActivity.otherCharge_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.othercharge_ll, "field 'otherCharge_ll'", cls3);
        fareBreakupActivity.cateringcharge_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cateringcharge_ll, "field 'cateringcharge_ll'", cls3);
        fareBreakupActivity.view1 = Utils.findRequiredView(view, R.id.view1, "field 'view1'");
        fareBreakupActivity.view2 = Utils.findRequiredView(view, R.id.view2, "field 'view2'");
        fareBreakupActivity.view3 = Utils.findRequiredView(view, R.id.view3, "field 'view3'");
        fareBreakupActivity.view4 = Utils.findRequiredView(view, R.id.view4, "field 'view4'");
        fareBreakupActivity.view5 = Utils.findRequiredView(view, R.id.view5, "field 'view5'");
        fareBreakupActivity.view6 = Utils.findRequiredView(view, R.id.view6, "field 'view6'");
        fareBreakupActivity.Basefare1 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.base_fare1, "field 'Basefare1'", cls3);
        fareBreakupActivity.view11 = Utils.findRequiredView(view, R.id.view11, "field 'view11'");
        fareBreakupActivity.train_no = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'train_no'", cls);
        fareBreakupActivity.enqClass = (TextView) Utils.findRequiredViewAsType(view, R.id.enqClass, "field 'enqClass'", cls);
        fareBreakupActivity.service_charges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.service_charges, "field 'service_charges'", cls3);
        fareBreakupActivity.view66 = Utils.findRequiredView(view, R.id.view66, "field 'view66'");
        View findRequiredView = Utils.findRequiredView(view, R.id.back, "method 'onBackArrowClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(fareBreakupActivity));
    }

    public final void unbind() {
        FareBreakupActivity fareBreakupActivity = this.f4167a;
        if (fareBreakupActivity != null) {
            this.f4167a = null;
            fareBreakupActivity.basicPay = null;
            fareBreakupActivity.reservationCharges = null;
            fareBreakupActivity.superfastCharges = null;
            fareBreakupActivity.tatkalCharges = null;
            fareBreakupActivity.dynamicCharges = null;
            fareBreakupActivity.serviceCharges = null;
            fareBreakupActivity.cateringCharges = null;
            fareBreakupActivity.netpayCharges = null;
            fareBreakupActivity.otherCharges = null;
            fareBreakupActivity.fareLableMessage = null;
            fareBreakupActivity.messageLable = null;
            fareBreakupActivity.tv_sub_title_name = null;
            fareBreakupActivity.rvFareBackup = null;
            fareBreakupActivity.scrollViewDirect = null;
            fareBreakupActivity.scrollViewInDirect = null;
            fareBreakupActivity.base_fare = null;
            fareBreakupActivity.reservationll = null;
            fareBreakupActivity.super_fast_charge_ll = null;
            fareBreakupActivity.tatkalcharge_ll = null;
            fareBreakupActivity.dynamiccharge_ll = null;
            fareBreakupActivity.otherCharge_ll = null;
            fareBreakupActivity.cateringcharge_ll = null;
            fareBreakupActivity.view1 = null;
            fareBreakupActivity.view2 = null;
            fareBreakupActivity.view3 = null;
            fareBreakupActivity.view4 = null;
            fareBreakupActivity.view5 = null;
            fareBreakupActivity.view6 = null;
            fareBreakupActivity.Basefare1 = null;
            fareBreakupActivity.view11 = null;
            fareBreakupActivity.train_no = null;
            fareBreakupActivity.enqClass = null;
            fareBreakupActivity.service_charges = null;
            fareBreakupActivity.view66 = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
