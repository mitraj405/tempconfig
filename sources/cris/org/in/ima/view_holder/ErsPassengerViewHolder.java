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
import java.util.List;

public final class ErsPassengerViewHolder extends RecyclerView.Adapter<ErsPassengerItemHolder> {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5383a = "";

    /* renamed from: a  reason: collision with other field name */
    public final List<PassengerDetailDTO> f5384a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5385a;

    public class ErsPassengerItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131361996)
        TextView asterick;
        @BindView(2131362032)
        TextView berthNo;
        @BindView(2131362037)
        TextView berthType;
        @BindView(2131362273)
        TextView coachId;
        @BindView(2131362282)
        TextView concession;
        @BindView(2131362332)
        TextView currentStatus;
        @BindView(2131362327)
        TextView currentStatusDetails;
        @BindView(2131362690)
        TextView food_choice;
        @BindView(2131362935)
        TextView lap1_heading;
        @BindView(2131363461)
        TextView passport_no;
        @BindView(2131363551)
        TextView psgnAgeGender;
        @BindView(2131363557)
        TextView psgnName;
        @BindView(2131364161)
        TextView psgnStatus;
        @BindView(2131364066)
        TextView tapCurrrentStatus;
        @BindView(2131364347)
        TextView tv_comma;
        @BindView(2131364356)
        TextView tv_current_status;

        public ErsPassengerItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ErsPassengerItemHolder_ViewBinding implements Unbinder {
        public ErsPassengerItemHolder a;

        public ErsPassengerItemHolder_ViewBinding(ErsPassengerItemHolder ersPassengerItemHolder, View view) {
            this.a = ersPassengerItemHolder;
            Class cls = TextView.class;
            ersPassengerItemHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_name, "field 'psgnName'", cls);
            ersPassengerItemHolder.psgnAgeGender = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_age_gender, "field 'psgnAgeGender'", cls);
            ersPassengerItemHolder.psgnStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_status, "field 'psgnStatus'", cls);
            ersPassengerItemHolder.coachId = (TextView) Utils.findRequiredViewAsType(view, R.id.coach_id, "field 'coachId'", cls);
            ersPassengerItemHolder.berthNo = (TextView) Utils.findRequiredViewAsType(view, R.id.berth_no, "field 'berthNo'", cls);
            ersPassengerItemHolder.currentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.current_status, "field 'currentStatus'", cls);
            ersPassengerItemHolder.currentStatusDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.current_Status_Details, "field 'currentStatusDetails'", cls);
            ersPassengerItemHolder.berthType = (TextView) Utils.findRequiredViewAsType(view, R.id.berth_type, "field 'berthType'", cls);
            ersPassengerItemHolder.concession = (TextView) Utils.findRequiredViewAsType(view, R.id.concession, "field 'concession'", cls);
            ersPassengerItemHolder.food_choice = (TextView) Utils.findRequiredViewAsType(view, R.id.food_choice, "field 'food_choice'", cls);
            ersPassengerItemHolder.passport_no = (TextView) Utils.findRequiredViewAsType(view, R.id.passport_no, "field 'passport_no'", cls);
            ersPassengerItemHolder.lap1_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1_heading, "field 'lap1_heading'", cls);
            ersPassengerItemHolder.tv_comma = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comma, "field 'tv_comma'", cls);
            ersPassengerItemHolder.asterick = (TextView) Utils.findRequiredViewAsType(view, R.id.asterick, "field 'asterick'", cls);
            ersPassengerItemHolder.tapCurrrentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tap_currentStatus, "field 'tapCurrrentStatus'", cls);
            ersPassengerItemHolder.tv_current_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_status, "field 'tv_current_status'", cls);
        }

        public final void unbind() {
            ErsPassengerItemHolder ersPassengerItemHolder = this.a;
            if (ersPassengerItemHolder != null) {
                this.a = null;
                ersPassengerItemHolder.psgnName = null;
                ersPassengerItemHolder.psgnAgeGender = null;
                ersPassengerItemHolder.psgnStatus = null;
                ersPassengerItemHolder.coachId = null;
                ersPassengerItemHolder.berthNo = null;
                ersPassengerItemHolder.currentStatus = null;
                ersPassengerItemHolder.currentStatusDetails = null;
                ersPassengerItemHolder.berthType = null;
                ersPassengerItemHolder.concession = null;
                ersPassengerItemHolder.food_choice = null;
                ersPassengerItemHolder.passport_no = null;
                ersPassengerItemHolder.lap1_heading = null;
                ersPassengerItemHolder.tv_comma = null;
                ersPassengerItemHolder.asterick = null;
                ersPassengerItemHolder.tapCurrrentStatus = null;
                ersPassengerItemHolder.tv_current_status = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(ErsPassengerViewHolder.class);
    }

    public ErsPassengerViewHolder(Context context, ArrayList arrayList, String str, boolean z) {
        this.a = context;
        this.f5384a = arrayList;
        this.f5383a = str;
        this.f5385a = z;
    }

    public final int getItemCount() {
        return this.f5384a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        String str2;
        ErsPassengerItemHolder ersPassengerItemHolder = (ErsPassengerItemHolder) viewHolder;
        List<PassengerDetailDTO> list = this.f5384a;
        PassengerDetailDTO passengerDetailDTO = list.get(i);
        ersPassengerItemHolder.getClass();
        String passengerCancellationDate = passengerDetailDTO.getPassengerCancellationDate();
        Context context = this.a;
        if (!(passengerCancellationDate == null || passengerDetailDTO.getPassengerCancellationDate() == "" || passengerDetailDTO.getCurrentStatusDetails() == null || passengerDetailDTO.getCurrentStatusDetails() == "")) {
            TextView textView = ersPassengerItemHolder.tapCurrrentStatus;
            textView.setText(context.getResources().getString(R.string.current_status_fetched_time) + " " + passengerDetailDTO.getPassengerCancellationDate());
        }
        passengerDetailDTO.toString();
        if (!C0535I5.f3647h && !C0535I5.f3650k) {
            ersPassengerItemHolder.lap1_heading.setVisibility(8);
        } else if (i == 0) {
            ersPassengerItemHolder.lap1_heading.setVisibility(0);
            TextView textView2 = ersPassengerItemHolder.lap1_heading;
            textView2.setText(context.getResources().getString(R.string.Passenger_Information_For_Lap) + (i + 1) + " ");
        } else if (!C0535I5.f3650k || i != list.size() / 2) {
            String str3 = this.f5383a;
            if (str3 == null || str3.equals("") || i != list.size() / 2) {
                ersPassengerItemHolder.lap1_heading.setVisibility(8);
            } else {
                ersPassengerItemHolder.lap1_heading.setVisibility(0);
                TextView textView3 = ersPassengerItemHolder.lap1_heading;
                textView3.setText(context.getResources().getString(R.string.Passenger_Information_For_Lap) + "2 ");
            }
        } else {
            ersPassengerItemHolder.lap1_heading.setVisibility(0);
            TextView textView4 = ersPassengerItemHolder.lap1_heading;
            textView4.setText(context.getResources().getString(R.string.Passenger_Information_For_Lap) + "2 ");
        }
        ersPassengerItemHolder.psgnName.setText(passengerDetailDTO.getPassengerName());
        String string = context.getResources().getString(R.string.Male);
        if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
            string = context.getResources().getString(R.string.Transgender);
        } else if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase("F")) {
            string = context.getResources().getString(R.string.Female);
        }
        TextView textView5 = ersPassengerItemHolder.psgnAgeGender;
        StringBuilder n = lf.n(string, "| ");
        n.append(passengerDetailDTO.getPassengerAge().toString());
        n.append(" ");
        n.append(context.getResources().getString(R.string.yrs));
        textView5.setText(n.toString());
        if (passengerDetailDTO.getBookingStatusDetails() != null) {
            ersPassengerItemHolder.currentStatusDetails.setText(passengerDetailDTO.getCurrentStatusDetails());
        }
        if (passengerDetailDTO.getCurrentStatusDetails() != null && passengerDetailDTO.getCurrentStatusDetails().equalsIgnoreCase("CNF")) {
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatusDetails);
        } else if (passengerDetailDTO.getCurrentStatusDetails() != null && passengerDetailDTO.getCurrentStatusDetails().equalsIgnoreCase("CAN")) {
            C1058d.H(context, R.color.red, ersPassengerItemHolder.currentStatusDetails);
        } else if (passengerDetailDTO.getCurrentStatusDetails() != null && C0535I5.f3652m) {
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatusDetails);
        } else if (passengerDetailDTO.getCurrentStatusDetails() != null && passengerDetailDTO.getCurrentStatusDetails().equalsIgnoreCase("RAC")) {
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatusDetails);
        } else if (passengerDetailDTO.getCurrentStatusDetails() == null || !passengerDetailDTO.getCurrentStatusDetails().contains("WL")) {
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatusDetails);
            if (C0535I5.f3652m) {
                ersPassengerItemHolder.currentStatusDetails.setText(passengerDetailDTO.getCurrentStatusDetails());
            }
        } else {
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatusDetails);
        }
        String bookingStatusDetails = passengerDetailDTO.getBookingStatusDetails();
        boolean z = this.f5385a;
        if (bookingStatusDetails != null && passengerDetailDTO.getBookingStatusDetails().equalsIgnoreCase("CAN")) {
            ersPassengerItemHolder.psgnStatus.setText(passengerDetailDTO.getBookingStatusDetails());
            C1058d.H(context, R.color.red, ersPassengerItemHolder.psgnStatus);
            if (z) {
                xx.P(context, R.string.Cancelled, ersPassengerItemHolder.currentStatus);
                C1058d.H(context, R.color.red, ersPassengerItemHolder.currentStatus);
            }
        } else if (passengerDetailDTO.getBookingStatusDetails() == null || !passengerDetailDTO.getBookingStatusDetails().equalsIgnoreCase("CNF")) {
            ersPassengerItemHolder.psgnStatus.setTextColor(context.getResources().getColor(R.color.dark));
            if (passengerDetailDTO.getBookingStatusDetails() != null) {
                ersPassengerItemHolder.psgnStatus.setText(passengerDetailDTO.getBookingStatusDetails());
            }
            if (passengerDetailDTO.getCurrentBerthNo() != 0) {
                ersPassengerItemHolder.psgnStatus.setText(passengerDetailDTO.getBookingStatusDetails());
            }
            ersPassengerItemHolder.coachId.setText("");
            ersPassengerItemHolder.berthNo.setText("");
            ersPassengerItemHolder.berthType.setText("");
            if (z) {
                ersPassengerItemHolder.currentStatus.setVisibility(8);
                ersPassengerItemHolder.tv_current_status.setVisibility(8);
                ersPassengerItemHolder.asterick.setVisibility(8);
                ersPassengerItemHolder.tapCurrrentStatus.setVisibility(8);
                ersPassengerItemHolder.currentStatus.setText(ersPassengerItemHolder.psgnStatus.getText());
                C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatus);
            }
        } else {
            ersPassengerItemHolder.psgnStatus.setText(passengerDetailDTO.getBookingStatusDetails());
            ersPassengerItemHolder.berthNo.setText("");
            C1058d.H(context, R.color.dark, ersPassengerItemHolder.psgnStatus);
            if (z) {
                xx.P(context, R.string.Confirmed, ersPassengerItemHolder.currentStatus);
                C1058d.H(context, R.color.dark, ersPassengerItemHolder.currentStatus);
            }
            if (passengerDetailDTO.getCurrentCoachId() == null || passengerDetailDTO.getCurrentCoachId().trim().equals("")) {
                TextView textView6 = ersPassengerItemHolder.berthNo;
                if (String.valueOf(passengerDetailDTO.getCurrentBerthNo()).equalsIgnoreCase("0")) {
                    str = "";
                } else {
                    str = String.valueOf(passengerDetailDTO.getCurrentBerthNo());
                }
                textView6.setText(str);
                if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                    ersPassengerItemHolder.berthType.setText(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                    ersPassengerItemHolder.berthType.setText(String.valueOf(passengerDetailDTO.getBookingBerthCode()));
                }
            } else {
                if (passengerDetailDTO.getBookingBerthCode() != null && !passengerDetailDTO.getBookingBerthCode().trim().equals("")) {
                    TextView textView7 = ersPassengerItemHolder.psgnAgeGender;
                    textView7.setText(ersPassengerItemHolder.psgnAgeGender.getText() + "| " + I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                }
                ersPassengerItemHolder.coachId.setText(passengerDetailDTO.getCurrentCoachId());
                passengerDetailDTO.getCurrentBerthNo();
                TextView textView8 = ersPassengerItemHolder.berthNo;
                if (String.valueOf(passengerDetailDTO.getCurrentBerthNo()).equalsIgnoreCase("0")) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(passengerDetailDTO.getCurrentBerthNo());
                }
                textView8.setText(str2);
                if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                    ersPassengerItemHolder.berthType.setText(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                    ersPassengerItemHolder.berthType.setText(String.valueOf(passengerDetailDTO.getBookingBerthCode()));
                }
            }
        }
        if (passengerDetailDTO.getPassengerConcession() != null && !passengerDetailDTO.getPassengerConcession().trim().equals("")) {
            TextView textView9 = ersPassengerItemHolder.concession;
            textView9.setText("| " + passengerDetailDTO.getPassengerConcession());
        }
        if (passengerDetailDTO.getPassengerCardType() == null || (!passengerDetailDTO.getPassengerCardType().equalsIgnoreCase("Aadhaar ID") && !passengerDetailDTO.getPassengerCardType().equalsIgnoreCase("UNIQUE_ICARD"))) {
            if (passengerDetailDTO.getPassengerCardNumber() != null && !passengerDetailDTO.getPassengerCardNumber().trim().equals("")) {
                ersPassengerItemHolder.passport_no.setText(passengerDetailDTO.getPassengerCardNumber());
                ersPassengerItemHolder.passport_no.setVisibility(0);
                ersPassengerItemHolder.tv_comma.setVisibility(0);
            }
        } else if (passengerDetailDTO.getPassengerCardNumber() != null && !passengerDetailDTO.getPassengerCardNumber().trim().equals("")) {
            ersPassengerItemHolder.passport_no.setText(C0535I5.c0(passengerDetailDTO.getPassengerCardNumber()));
            ersPassengerItemHolder.passport_no.setVisibility(0);
            ersPassengerItemHolder.tv_comma.setVisibility(0);
        }
        if (passengerDetailDTO.getFoodChoice() == null || passengerDetailDTO.getFoodChoice().trim().equals("")) {
            ersPassengerItemHolder.food_choice.setText("");
        } else if (passengerDetailDTO.getFoodChoice().length() == 1) {
            J9 i2 = J9.i(passengerDetailDTO.getFoodChoice().charAt(0));
            TextView textView10 = ersPassengerItemHolder.food_choice;
            textView10.setText("| " + i2.f());
            C0535I5.h0(ersPassengerItemHolder.food_choice, passengerDetailDTO.getFoodChoice());
        } else {
            TextView textView11 = ersPassengerItemHolder.food_choice;
            textView11.setText("| " + passengerDetailDTO.getFoodChoice());
            C0535I5.h0(ersPassengerItemHolder.food_choice, passengerDetailDTO.getFoodChoice());
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.ers_psgn, (ViewGroup) null);
        ErsPassengerItemHolder ersPassengerItemHolder = new ErsPassengerItemHolder(r);
        xx.O(-1, -2, r);
        return ersPassengerItemHolder;
    }
}
