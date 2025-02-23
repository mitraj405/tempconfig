package cris.org.in.ima.adaptors;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.InformationMessageDTO;
import java.util.Iterator;
import java.util.List;

public class FareBreakupAdapter extends RecyclerView.Adapter<FareBreakupItemHolder> {
    private static final String TAG = C1354qp.R(FareBreakupAdapter.class);
    List<AvlFareResponseDTO> avlFareResponseDTOList;
    Integer grandTotal = 0;
    Context mContext;
    List<TrainBtwnStnsModel> trainBtwnStnsModelList;

    public class FareBreakupItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131362145)
        RelativeLayout CateringCharges;
        @BindView(2131362464)
        RelativeLayout Dynamiccharges;
        @BindView(2131362742)
        RelativeLayout Gst;
        @BindView(2131363681)
        RelativeLayout ReservationCharges;
        @BindView(2131364043)
        RelativeLayout Superfasrcharges;
        @BindView(2131364067)
        RelativeLayout TatkalCharges;
        @BindView(2131362024)
        RelativeLayout basefare;
        @BindView(2131364310)
        TextView basicPay;
        @BindView(2131364332)
        TextView cateringCharges;
        @BindView(2131364389)
        TextView dynamicCharges;
        @BindView(2131362496)
        TextView enqClass;
        @BindView(2131362636)
        TextView fareLableMessage;
        @BindView(2131364430)
        TextView grandTotal;
        @BindView(2131364457)
        TextView lapHeading;
        @BindView(2131362941)
        RelativeLayout lapHeadingLayout;
        @BindView(2131363032)
        RelativeLayout llGrandTotal;
        @BindView(2131363212)
        LinearLayout messageLable;
        @BindView(2131364498)
        TextView netpayCharges;
        @BindView(2131364518)
        TextView otherCharges;
        @BindView(2131363394)
        RelativeLayout othercharge;
        @BindView(2131364569)
        TextView reservationCharges;
        @BindView(2131364598)
        TextView serviceCharges;
        @BindView(2131364625)
        TextView superfastCharges;
        @BindView(2131364656)
        TextView tatkalCharges;
        @BindView(2131364814)
        View view1;
        @BindView(2131364816)
        View view2;
        @BindView(2131364817)
        View view3;
        @BindView(2131364818)
        View view4;
        @BindView(2131364819)
        View view5;
        @BindView(2131364820)
        View view6;
        @BindView(2131364822)
        View view7;
        @BindView(2131364823)
        View view8;
        @BindView(2131364824)
        View view9;

        public FareBreakupItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class FareBreakupItemHolder_ViewBinding implements Unbinder {
        private FareBreakupItemHolder target;

        public FareBreakupItemHolder_ViewBinding(FareBreakupItemHolder fareBreakupItemHolder, View view) {
            this.target = fareBreakupItemHolder;
            Class cls = TextView.class;
            fareBreakupItemHolder.basicPay = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_basic_pay, "field 'basicPay'", cls);
            fareBreakupItemHolder.reservationCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reservation_charges, "field 'reservationCharges'", cls);
            fareBreakupItemHolder.superfastCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_superfast_charges, "field 'superfastCharges'", cls);
            fareBreakupItemHolder.tatkalCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tatkal_charges, "field 'tatkalCharges'", cls);
            fareBreakupItemHolder.dynamicCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dynamic_charges, "field 'dynamicCharges'", cls);
            fareBreakupItemHolder.serviceCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_service_charges, "field 'serviceCharges'", cls);
            fareBreakupItemHolder.cateringCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_catering_charges, "field 'cateringCharges'", cls);
            fareBreakupItemHolder.netpayCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_netpay_charges, "field 'netpayCharges'", cls);
            fareBreakupItemHolder.otherCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_other_charges, "field 'otherCharges'", cls);
            fareBreakupItemHolder.fareLableMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.fare_lable_message, "field 'fareLableMessage'", cls);
            fareBreakupItemHolder.messageLable = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.message_lable, "field 'messageLable'", LinearLayout.class);
            Class cls2 = RelativeLayout.class;
            fareBreakupItemHolder.lapHeadingLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.lap_heading, "field 'lapHeadingLayout'", cls2);
            fareBreakupItemHolder.lapHeading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lap_heading, "field 'lapHeading'", cls);
            fareBreakupItemHolder.llGrandTotal = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_grand_total, "field 'llGrandTotal'", cls2);
            fareBreakupItemHolder.grandTotal = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_grand_total, "field 'grandTotal'", cls);
            fareBreakupItemHolder.enqClass = (TextView) Utils.findRequiredViewAsType(view, R.id.enqClass, "field 'enqClass'", cls);
            fareBreakupItemHolder.basefare = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.base_fare, "field 'basefare'", cls2);
            fareBreakupItemHolder.TatkalCharges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tatkalcharge_ll, "field 'TatkalCharges'", cls2);
            fareBreakupItemHolder.ReservationCharges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.reservation_ll, "field 'ReservationCharges'", cls2);
            fareBreakupItemHolder.view3 = Utils.findRequiredView(view, R.id.view3, "field 'view3'");
            fareBreakupItemHolder.CateringCharges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cateringcharge_ll, "field 'CateringCharges'", cls2);
            fareBreakupItemHolder.view7 = Utils.findRequiredView(view, R.id.view7, "field 'view7'");
            fareBreakupItemHolder.Gst = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.gst_detail_ll, "field 'Gst'", cls2);
            fareBreakupItemHolder.view6 = Utils.findRequiredView(view, R.id.view6, "field 'view6'");
            fareBreakupItemHolder.Superfasrcharges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.super_fast_charge_ll, "field 'Superfasrcharges'", cls2);
            fareBreakupItemHolder.view2 = Utils.findRequiredView(view, R.id.view2, "field 'view2'");
            fareBreakupItemHolder.view1 = Utils.findRequiredView(view, R.id.view1, "field 'view1'");
            fareBreakupItemHolder.view4 = Utils.findRequiredView(view, R.id.view4, "field 'view4'");
            fareBreakupItemHolder.view5 = Utils.findRequiredView(view, R.id.view5, "field 'view5'");
            fareBreakupItemHolder.view8 = Utils.findRequiredView(view, R.id.view8, "field 'view8'");
            fareBreakupItemHolder.view9 = Utils.findRequiredView(view, R.id.view9, "field 'view9'");
            fareBreakupItemHolder.Dynamiccharges = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.dynamiccharge_ll, "field 'Dynamiccharges'", cls2);
            fareBreakupItemHolder.othercharge = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.othercharge_ll, "field 'othercharge'", cls2);
        }

        public void unbind() {
            FareBreakupItemHolder fareBreakupItemHolder = this.target;
            if (fareBreakupItemHolder != null) {
                this.target = null;
                fareBreakupItemHolder.basicPay = null;
                fareBreakupItemHolder.reservationCharges = null;
                fareBreakupItemHolder.superfastCharges = null;
                fareBreakupItemHolder.tatkalCharges = null;
                fareBreakupItemHolder.dynamicCharges = null;
                fareBreakupItemHolder.serviceCharges = null;
                fareBreakupItemHolder.cateringCharges = null;
                fareBreakupItemHolder.netpayCharges = null;
                fareBreakupItemHolder.otherCharges = null;
                fareBreakupItemHolder.fareLableMessage = null;
                fareBreakupItemHolder.messageLable = null;
                fareBreakupItemHolder.lapHeadingLayout = null;
                fareBreakupItemHolder.lapHeading = null;
                fareBreakupItemHolder.llGrandTotal = null;
                fareBreakupItemHolder.grandTotal = null;
                fareBreakupItemHolder.enqClass = null;
                fareBreakupItemHolder.basefare = null;
                fareBreakupItemHolder.TatkalCharges = null;
                fareBreakupItemHolder.ReservationCharges = null;
                fareBreakupItemHolder.view3 = null;
                fareBreakupItemHolder.CateringCharges = null;
                fareBreakupItemHolder.view7 = null;
                fareBreakupItemHolder.Gst = null;
                fareBreakupItemHolder.view6 = null;
                fareBreakupItemHolder.Superfasrcharges = null;
                fareBreakupItemHolder.view2 = null;
                fareBreakupItemHolder.view1 = null;
                fareBreakupItemHolder.view4 = null;
                fareBreakupItemHolder.view5 = null;
                fareBreakupItemHolder.view8 = null;
                fareBreakupItemHolder.view9 = null;
                fareBreakupItemHolder.Dynamiccharges = null;
                fareBreakupItemHolder.othercharge = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public FareBreakupAdapter(Context context, List<AvlFareResponseDTO> list, List<TrainBtwnStnsModel> list2) {
        this.avlFareResponseDTOList = list;
        this.mContext = context;
        this.trainBtwnStnsModelList = list2;
    }

    public int getItemCount() {
        return this.avlFareResponseDTOList.size();
    }

    public FareBreakupItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FareBreakupItemHolder(C1058d.s(viewGroup, R.layout.item_fare_breakup, viewGroup, false));
    }

    public void onBindViewHolder(FareBreakupItemHolder fareBreakupItemHolder, int i) {
        AvlFareResponseDTO avlFareResponseDTO = this.avlFareResponseDTOList.get(i);
        if (avlFareResponseDTO != null && avlFareResponseDTO.getBaseFare() != null) {
            avlFareResponseDTO.getOtherCharge();
            this.grandTotal = Integer.valueOf(avlFareResponseDTO.getTotalFare().intValue() + this.grandTotal.intValue());
            if (avlFareResponseDTO.getBaseFare().intValue() != 0 || avlFareResponseDTO.getBaseFare() == null) {
                fareBreakupItemHolder.basefare.setVisibility(0);
            } else {
                fareBreakupItemHolder.basefare.setVisibility(8);
            }
            if (avlFareResponseDTO.getReservationCharge().intValue() != 0 || avlFareResponseDTO.getReservationCharge() == null) {
                fareBreakupItemHolder.reservationCharges.setVisibility(0);
            } else {
                fareBreakupItemHolder.reservationCharges.setVisibility(8);
            }
            if (avlFareResponseDTO.getSuperfastCharge().intValue() != 0 || avlFareResponseDTO.getSuperfastCharge() == null) {
                fareBreakupItemHolder.Superfasrcharges.setVisibility(0);
            } else {
                fareBreakupItemHolder.Superfasrcharges.setVisibility(8);
                fareBreakupItemHolder.view2.setVisibility(8);
            }
            if (avlFareResponseDTO.getTatkalFare().intValue() != 0 || avlFareResponseDTO.getTatkalFare() == null) {
                fareBreakupItemHolder.TatkalCharges.setVisibility(0);
            } else {
                fareBreakupItemHolder.TatkalCharges.setVisibility(8);
                fareBreakupItemHolder.view3.setVisibility(8);
            }
            if (avlFareResponseDTO.getCateringCharge().intValue() != 0 || avlFareResponseDTO.getCateringCharge() == null) {
                fareBreakupItemHolder.CateringCharges.setVisibility(0);
            } else {
                fareBreakupItemHolder.CateringCharges.setVisibility(8);
                fareBreakupItemHolder.view7.setVisibility(8);
            }
            if (avlFareResponseDTO.getServiceTax().floatValue() != 0.0f || avlFareResponseDTO.getServiceTax() == null) {
                fareBreakupItemHolder.Gst.setVisibility(0);
            } else {
                fareBreakupItemHolder.Gst.setVisibility(8);
                fareBreakupItemHolder.view6.setVisibility(8);
            }
            if (avlFareResponseDTO.getDynamicFare().intValue() != 0 || avlFareResponseDTO.getDynamicFare() == null) {
                fareBreakupItemHolder.Dynamiccharges.setVisibility(0);
            } else {
                fareBreakupItemHolder.Dynamiccharges.setVisibility(8);
                fareBreakupItemHolder.view4.setVisibility(8);
            }
            fareBreakupItemHolder.lapHeadingLayout.setVisibility(0);
            TrainBtwnStnsModel trainBtwnStnsModel = this.trainBtwnStnsModelList.get(i);
            TextView textView = fareBreakupItemHolder.lapHeading;
            textView.setText("Lap " + (i + 1) + " " + trainBtwnStnsModel.f5342a.getTrainName() + "(" + trainBtwnStnsModel.f5342a.getTrainNumber() + ")");
            fareBreakupItemHolder.enqClass.setText(avlFareResponseDTO.getEnqClass());
            TextView textView2 = fareBreakupItemHolder.basicPay;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mContext.getResources().getString(R.string.rupees));
            sb.append(avlFareResponseDTO.getBaseFare().toString());
            textView2.setText(sb.toString());
            TextView textView3 = fareBreakupItemHolder.reservationCharges;
            textView3.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getReservationCharge().toString());
            TextView textView4 = fareBreakupItemHolder.superfastCharges;
            textView4.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getSuperfastCharge().toString());
            TextView textView5 = fareBreakupItemHolder.tatkalCharges;
            textView5.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getTatkalFare().toString());
            if (avlFareResponseDTO.getServiceTax().intValue() == ((int) Math.ceil((double) avlFareResponseDTO.getServiceTax().floatValue()))) {
                TextView textView6 = fareBreakupItemHolder.serviceCharges;
                textView6.setText(this.mContext.getResources().getString(R.string.rupees) + ((int) Math.ceil((double) avlFareResponseDTO.getServiceTax().floatValue())));
            } else {
                TextView textView7 = fareBreakupItemHolder.serviceCharges;
                textView7.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getServiceTax());
            }
            TextView textView8 = fareBreakupItemHolder.cateringCharges;
            textView8.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getCateringCharge().toString());
            TextView textView9 = fareBreakupItemHolder.netpayCharges;
            textView9.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getTotalFare().toString());
            TextView textView10 = fareBreakupItemHolder.dynamicCharges;
            textView10.setText(this.mContext.getResources().getString(R.string.rupees) + avlFareResponseDTO.getDynamicFare().toString());
            Iterator<InformationMessageDTO> it = avlFareResponseDTO.getInformationMessage().iterator();
            String str = "";
            String str2 = str;
            while (it.hasNext()) {
                InformationMessageDTO next = it.next();
                if (next.getParamName().equalsIgnoreCase("FARE_BREAKUP")) {
                    if (next.getPopup().booleanValue()) {
                        str2 = next.getMessage();
                    } else {
                        str = next.getMessage();
                    }
                }
            }
            if (!str.trim().equals("")) {
                fareBreakupItemHolder.messageLable.setVisibility(0);
                fareBreakupItemHolder.fareLableMessage.setText(str.replace("Rs.", this.mContext.getResources().getString(R.string.rupees)));
            }
            if (!str2.trim().equals("")) {
                C0535I5.o(this.mContext, str2, "OK", (DialogInterface.OnClickListener) null).show();
            }
            if (i == this.avlFareResponseDTOList.size() - 1) {
                fareBreakupItemHolder.llGrandTotal.setVisibility(0);
                TextView textView11 = fareBreakupItemHolder.grandTotal;
                textView11.setText(this.mContext.getResources().getString(R.string.rupees) + this.grandTotal);
                return;
            }
            fareBreakupItemHolder.llGrandTotal.setVisibility(8);
        }
    }
}
