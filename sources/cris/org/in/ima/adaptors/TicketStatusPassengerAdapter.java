package cris.org.in.ima.adaptors;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public class TicketStatusPassengerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(TicketStatusPassengerAdapter.class);
    private Fragment pFragment;
    ArrayList<PassengerDetailDTO> psgnList;

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
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
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

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
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

    public TicketStatusPassengerAdapter(Fragment fragment, ArrayList<PassengerDetailDTO> arrayList) {
        this.pFragment = fragment;
        this.psgnList = arrayList;
    }

    public int getItemCount() {
        return this.psgnList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.r(viewGroup, R.layout.pnr_passanger, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PassengerDetailDTO passengerDetailDTO = this.psgnList.get(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(passengerDetailDTO.getPassengerGender());
        arrayList.add(passengerDetailDTO.getPassengerAge().toString() + " yrs");
        if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
            arrayList.add(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
        } else if (passengerDetailDTO.getBookingBerthCode() != null) {
            arrayList.add(passengerDetailDTO.getBookingBerthCode());
        }
        arrayList.add(passengerDetailDTO.getFoodChoice());
        viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
        if (this.psgnList.get(i).getCurrentStatus().equalsIgnoreCase("CNF")) {
            viewHolder.berth.setText(String.valueOf(this.psgnList.get(i).getBookingBerthNo()));
            if (this.psgnList.get(i).getBookingBerthCode() != null && I9.j(String.valueOf(this.psgnList.get(i).getBookingBerthCode())) != null) {
                viewHolder.berthType.setText(I9.j(String.valueOf(this.psgnList.get(i).getBookingBerthCode())).a());
            } else if (this.psgnList.get(i).getBookingBerthCode() != null) {
                viewHolder.berthType.setText(this.psgnList.get(i).getBookingBerthCode());
            }
        }
        viewHolder.ageGenderFood.setText(C0535I5.r0(arrayList));
        viewHolder.coach.setText(passengerDetailDTO.getBookingCoachId());
        if (passengerDetailDTO.getBookingBerthCode() == null || passengerDetailDTO.getBookingBerthCode().equals("-1")) {
            viewHolder.berthType.setText("");
        } else {
            viewHolder.berthType.setText(passengerDetailDTO.getBookingBerthCode());
        }
        viewHolder.psgnName.setText(passengerDetailDTO.getPassengerName());
        if (passengerDetailDTO.getPassengerConcession() != null) {
            TextView textView = viewHolder.srcConCode;
            textView.setText("| " + passengerDetailDTO.getPassengerConcession());
            viewHolder.srcConCode.setVisibility(0);
        } else {
            viewHolder.srcConCode.setVisibility(8);
        }
        if (passengerDetailDTO.getCurrentStatusDetails().equalsIgnoreCase("CAN")) {
            viewHolder.crntStatusLabel.setText("Cancelled");
        } else if (passengerDetailDTO.getCurrentStatus().equalsIgnoreCase("CNF")) {
            viewHolder.crntStatusLabel.setText(passengerDetailDTO.getCurrentStatusDetails());
        } else {
            viewHolder.crntStatusLabel.setText(passengerDetailDTO.getCurrentStatusDetails());
        }
        if (this.psgnList.get(i).getBookingStatus() != null && this.psgnList.get(i).getBookingStatus().equalsIgnoreCase("CNF")) {
            viewHolder.bkgStatus.setText(this.pFragment.getString(R.string.Confirmed));
            if (this.psgnList.get(i).getBookingCoachId() != null) {
                viewHolder.coach.setText(this.psgnList.get(i).getBookingCoachId());
                viewHolder.berth.setText(String.valueOf(this.psgnList.get(i).getBookingBerthNo()));
                if (this.psgnList.get(i).getBookingBerthCode() != null && I9.j(String.valueOf(this.psgnList.get(i).getBookingBerthCode())) != null) {
                    viewHolder.berthType.setText(I9.j(String.valueOf(this.psgnList.get(i).getBookingBerthCode())).a());
                } else if (this.psgnList.get(i).getBookingBerthCode() != null) {
                    viewHolder.berthType.setText(this.psgnList.get(i).getBookingBerthCode());
                }
            } else {
                viewHolder.coach.setText("");
                viewHolder.berth.setText("");
                viewHolder.berthType.setText("");
            }
        } else if (this.psgnList.get(i).getBookingStatusDetails() != null) {
            viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
            viewHolder.coach.setText("");
            viewHolder.berth.setText("");
            viewHolder.berthType.setText("");
        } else {
            viewHolder.bkgStatus.setText("");
            viewHolder.coach.setText("");
            viewHolder.berth.setText("");
            viewHolder.berthType.setText("");
        }
    }
}
