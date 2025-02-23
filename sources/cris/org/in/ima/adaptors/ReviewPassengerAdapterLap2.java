package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public class ReviewPassengerAdapterLap2 extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(ReviewPassengerAdapterLap2.class);
    private Context mContext = this.mContext;
    private ArrayList<PassengerDetailDTO> passengerList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView psgnDetail;
        TextView psgnName;
        TextView psgn_idnumber;
        TextView tv_psgn_food;
        TextView tv_soft_userid;
        TextView tv_sr_msg;

        public ViewHolder(View view) {
            super(view);
            this.psgn_idnumber = (TextView) view.findViewById(R.id.tv_psgn_idnum);
            this.tv_soft_userid = (TextView) view.findViewById(R.id.tv_soft_userid);
            this.psgnName = (TextView) view.findViewById(R.id.tv_psgn_name);
            this.psgnDetail = (TextView) view.findViewById(R.id.tv_psgn_detail);
            this.tv_sr_msg = (TextView) view.findViewById(R.id.tv_sr_msg);
            this.tv_psgn_food = (TextView) view.findViewById(R.id.tv_psgn_food);
        }
    }

    public ReviewPassengerAdapterLap2(Context context, ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public int getItemCount() {
        return this.passengerList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.item_passenger_review_lap2, (ViewGroup) null, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        PassengerDetailDTO passengerDetailDTO = this.passengerList.get(i);
        viewHolder.psgnName.setText(passengerDetailDTO.getPassengerSerialNumber() + ") " + passengerDetailDTO.getPassengerName());
        String str2 = "";
        if (passengerDetailDTO.getPassengerFoodChoice() != null && !passengerDetailDTO.getPassengerFoodChoice().equals(str2)) {
            J9.i(passengerDetailDTO.getPassengerFoodChoice().charAt(0)).f();
        }
        if (passengerDetailDTO.getPassengerFoodChoice() != null && !passengerDetailDTO.getPassengerFoodChoice().equals(str2)) {
            if (passengerDetailDTO.getPassengerFoodChoice().equals("N")) {
                viewHolder.tv_psgn_food.setText("," + this.mContext.getResources().getString(R.string.NON_VEG));
                viewHolder.tv_psgn_food.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_non_veg, 0);
            } else if (passengerDetailDTO.getPassengerFoodChoice().equals("V")) {
                viewHolder.tv_psgn_food.setText("," + this.mContext.getResources().getString(R.string.VEG));
                viewHolder.tv_psgn_food.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_veg, 0);
            } else {
                viewHolder.tv_psgn_food.setText("," + this.mContext.getResources().getString(R.string.NO_FOOD));
                viewHolder.tv_psgn_food.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        if (passengerDetailDTO.getPassengerCardType() == null || passengerDetailDTO.getPassengerCardType().equalsIgnoreCase("null")) {
            str = null;
        } else {
            str = passengerDetailDTO.getPassengerCardType() + ":";
        }
        if (passengerDetailDTO.getPassengerCardNumber() != null) {
            if (passengerDetailDTO.getPassengerCardType().equalsIgnoreCase("Aadhaar ID") || passengerDetailDTO.getPassengerCardType().equalsIgnoreCase("UNIQUE_ICARD")) {
                StringBuilder J = xx.J(str);
                J.append(C0535I5.c0(passengerDetailDTO.getPassengerCardNumber()));
                str = J.toString();
            } else {
                StringBuilder J2 = xx.J(str);
                J2.append(passengerDetailDTO.getPassengerCardNumber());
                str = J2.toString();
            }
        }
        if (passengerDetailDTO.getSoftMemberId() != null) {
            viewHolder.tv_soft_userid.setVisibility(0);
            viewHolder.tv_soft_userid.setText(String.valueOf("," + this.mContext.getResources().getString(R.string.Loyalty_No) + passengerDetailDTO.getSoftMemberId()));
        } else {
            viewHolder.tv_soft_userid.setVisibility(8);
        }
        if (passengerDetailDTO.getPassengerBerthChoice() != null && !passengerDetailDTO.getPassengerBerthChoice().equals(str2)) {
            passengerDetailDTO.getPassengerBerthChoice();
            I9 j = I9.j(passengerDetailDTO.getPassengerBerthChoice().trim());
            if (j != null) {
                str2 = ", " + j.f3658c;
            }
        }
        if (this.passengerList.get(i).getPassengerFoodChoice() == null || this.passengerList.get(i).getPassengerFoodChoice().equalsIgnoreCase("null")) {
            viewHolder.psgnDetail.setText(this.passengerList.get(i).getPassengerAge() + " " + this.passengerList.get(i).getPassengerGender());
            viewHolder.psgnDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            viewHolder.psgnDetail.setText(this.passengerList.get(i).getPassengerAge() + " " + this.passengerList.get(i).getPassengerGender() + " | " + this.passengerList.get(i).getPassengerFoodChoice());
            if (!this.passengerList.get(i).getPassengerFoodChoice().equals("N") && !this.passengerList.get(i).getPassengerFoodChoice().equals("V")) {
                viewHolder.psgnDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        short shortValue = passengerDetailDTO.getPassengerAge().shortValue();
        viewHolder.psgnDetail.setText(shortValue + " yrs, " + passengerDetailDTO.getPassengerGender() + str2);
        if (passengerDetailDTO.getConcessionOpted() != null && passengerDetailDTO.getConcessionOpted().booleanValue()) {
            viewHolder.psgnDetail.setText(shortValue + " yrs, " + passengerDetailDTO.getPassengerGender() + str2 + ", Sr. Citizen");
        }
        viewHolder.psgnDetail.setText(shortValue + " yrs, " + passengerDetailDTO.getPassengerGender() + str2);
        if (passengerDetailDTO.getPassengerCardNumber() != null) {
            viewHolder.psgn_idnumber.setText(str);
            viewHolder.psgn_idnumber.setVisibility(0);
        } else {
            viewHolder.psgn_idnumber.setVisibility(8);
        }
        if (passengerDetailDTO.getConcessionOpted() != null && passengerDetailDTO.getForGoConcessionOpted() != null) {
            if (passengerDetailDTO.getConcessionOpted().booleanValue() && !passengerDetailDTO.getForGoConcessionOpted().booleanValue()) {
                xx.P(this.mContext, R.string.availed_Concession, viewHolder.tv_sr_msg);
            } else if (passengerDetailDTO.getConcessionOpted().booleanValue() && passengerDetailDTO.getForGoConcessionOpted().booleanValue()) {
                xx.P(this.mContext, R.string.Forgo_concession, viewHolder.tv_sr_msg);
            }
        }
    }
}
