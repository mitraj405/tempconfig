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
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public final class PassangerViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f5409a;

    public class ViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(2131362325)
        TextView crntStatusLabel;
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
            viewHolder.crntStatusLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.crnt_status_label, "field 'crntStatusLabel'", cls);
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
                viewHolder.crntStatusLabel = null;
                viewHolder.psgnName = null;
                viewHolder.ageGenderFood = null;
                viewHolder.srcConCode = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(PassangerViewHolder.class);
    }

    public PassangerViewHolder(Context context, ArrayList<PassengerDetailDTO> arrayList) {
        this.f5409a = arrayList;
        this.a = context;
    }

    public final int getItemCount() {
        ArrayList<PassengerDetailDTO> arrayList = this.f5409a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PassengerDetailDTO passengerDetailDTO = this.f5409a.get(i);
        if (passengerDetailDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(passengerDetailDTO.getPassengerGender());
            arrayList.add(passengerDetailDTO.getPassengerAge().toString() + " yrs");
            if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                arrayList.add(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
            } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                arrayList.add(passengerDetailDTO.getBookingBerthCode());
            }
            arrayList.add(passengerDetailDTO.getFoodChoice());
            viewHolder2.psgnName.setText(passengerDetailDTO.getPassengerName());
            viewHolder2.ageGenderFood.setText(C0535I5.r0(arrayList));
            viewHolder2.bkgStatus.setText(passengerDetailDTO.getBookingStatusDetails());
            if (passengerDetailDTO.getBookingStatus().equalsIgnoreCase("CNF")) {
                viewHolder2.coach.setText(passengerDetailDTO.getBookingCoachId());
                viewHolder2.berth.setText(String.valueOf(passengerDetailDTO.getBookingBerthNo()));
                if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                    viewHolder2.berthType.setText(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                    viewHolder2.berthType.setText(passengerDetailDTO.getBookingBerthCode());
                }
            }
            if (passengerDetailDTO.getPassengerConcession() != null) {
                viewHolder2.srcConCode.setText("| " + passengerDetailDTO.getPassengerConcession());
                viewHolder2.srcConCode.setVisibility(0);
            } else {
                viewHolder2.srcConCode.setVisibility(8);
            }
            viewHolder2.crntStatusLabel.setVisibility(0);
            TextView textView = viewHolder2.crntStatusLabel;
            if (passengerDetailDTO.getPassengerCabinCoupe() == "" || passengerDetailDTO.getPassengerCabinCoupe() == null) {
                str = passengerDetailDTO.getCurrentStatusDetails();
            } else {
                str = passengerDetailDTO.getCurrentStatusDetails() + " (" + passengerDetailDTO.getPassengerCabinCoupe() + ")";
            }
            textView.setText(str);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.pnr_passanger, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
