package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.RequestConfiguration;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public final class CancelPassangerViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f5376a;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131361800)
        TextView Cancelled_Booking_Status_Label;
        @BindView(2131361801)
        TextView Cancelled_Current_Status_Label;
        @BindView(2131363552)
        TextView ageGenderFood;
        @BindView(2131362029)
        TextView berth;
        @BindView(2131362037)
        TextView berthType;
        @BindView(2131362040)
        TextView bkgStatus;
        @BindView(2131362272)
        TextView coach;
        @BindView(2131362324)
        TextView crnt_status;
        @BindView(2131363557)
        TextView psgnName;
        @BindView(2131364009)
        TextView srcConCode;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            Class cls = TextView.class;
            viewHolder.bkgStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.bkg_status, "field 'bkgStatus'", cls);
            viewHolder.coach = (TextView) Utils.findRequiredViewAsType(view, R.id.coach, "field 'coach'", cls);
            viewHolder.berth = (TextView) Utils.findRequiredViewAsType(view, R.id.berth, "field 'berth'", cls);
            viewHolder.berthType = (TextView) Utils.findRequiredViewAsType(view, R.id.berth_type, "field 'berthType'", cls);
            viewHolder.Cancelled_Current_Status_Label = (TextView) Utils.findRequiredViewAsType(view, R.id.Cancelled_Current_Status_Label, "field 'Cancelled_Current_Status_Label'", cls);
            viewHolder.Cancelled_Booking_Status_Label = (TextView) Utils.findRequiredViewAsType(view, R.id.Cancelled_Booking_Status_Label, "field 'Cancelled_Booking_Status_Label'", cls);
            viewHolder.crnt_status = (TextView) Utils.findRequiredViewAsType(view, R.id.crnt_status, "field 'crnt_status'", cls);
            viewHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_name, "field 'psgnName'", cls);
            viewHolder.ageGenderFood = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_age_gender_food, "field 'ageGenderFood'", cls);
            viewHolder.srcConCode = (TextView) Utils.findRequiredViewAsType(view, R.id.srctz_concession_msg, "field 'srcConCode'", cls);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.bkgStatus = null;
                viewHolder.coach = null;
                viewHolder.berth = null;
                viewHolder.berthType = null;
                viewHolder.Cancelled_Current_Status_Label = null;
                viewHolder.Cancelled_Booking_Status_Label = null;
                viewHolder.crnt_status = null;
                viewHolder.psgnName = null;
                viewHolder.ageGenderFood = null;
                viewHolder.srcConCode = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(CancelPassangerViewHolder.class);
    }

    public CancelPassangerViewHolder(Context context, ArrayList<PassengerDetailDTO> arrayList) {
        this.f5376a = arrayList;
        this.a = context;
    }

    public final int getItemCount() {
        ArrayList<PassengerDetailDTO> arrayList = this.f5376a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PassengerDetailDTO passengerDetailDTO = this.f5376a.get(i);
        if (passengerDetailDTO != null) {
            ArrayList arrayList = new ArrayList();
            Context context = this.a;
            String string = context.getString(R.string.male);
            if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                string = context.getString(R.string.transgender);
            } else if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase("F")) {
                string = context.getString(R.string.female);
            }
            arrayList.add(string);
            arrayList.add(passengerDetailDTO.getPassengerAge().toString() + " " + context.getResources().getString(R.string.yrs));
            if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                arrayList.add(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
            } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                arrayList.add(passengerDetailDTO.getBookingBerthCode());
            }
            arrayList.add(passengerDetailDTO.getFoodChoice());
            viewHolder2.ageGenderFood.setText(C0535I5.r0(arrayList));
            if (passengerDetailDTO.getBookingStatus() != null) {
                viewHolder2.bkgStatus.setText(passengerDetailDTO.getBookingStatus());
            } else {
                viewHolder2.bkgStatus.setText("--");
            }
            if (passengerDetailDTO.getCurrentStatus() != null) {
                viewHolder2.crnt_status.setText(passengerDetailDTO.getCurrentStatus());
            } else {
                viewHolder2.crnt_status.setText("--");
            }
            viewHolder2.psgnName.setText(passengerDetailDTO.getPassengerName());
            if (passengerDetailDTO.getPassengerConcession() != null) {
                TextView textView = viewHolder2.srcConCode;
                textView.setText("| " + passengerDetailDTO.getPassengerConcession());
                viewHolder2.srcConCode.setVisibility(0);
                return;
            }
            viewHolder2.srcConCode.setVisibility(8);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_passanger, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
