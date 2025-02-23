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
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;
import java.util.List;

public final class TDRHistoryPassengerViewHolder extends RecyclerView.Adapter<ErsPassengerItemHolder> {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final List<PassengerDetailDTO> f5416a;

    public class ErsPassengerItemHolder extends RecyclerView.ViewHolder {
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
        TextView tap_currentStatus;
        @BindView(2131364347)
        TextView tv_comma;
        @BindView(2131364356)
        TextView tv_current_status;
        @BindView(2131364660)
        TextView tv_ticket_status;

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
            ersPassengerItemHolder.berthType = (TextView) Utils.findRequiredViewAsType(view, R.id.berth_type, "field 'berthType'", cls);
            ersPassengerItemHolder.concession = (TextView) Utils.findRequiredViewAsType(view, R.id.concession, "field 'concession'", cls);
            ersPassengerItemHolder.food_choice = (TextView) Utils.findRequiredViewAsType(view, R.id.food_choice, "field 'food_choice'", cls);
            ersPassengerItemHolder.passport_no = (TextView) Utils.findRequiredViewAsType(view, R.id.passport_no, "field 'passport_no'", cls);
            ersPassengerItemHolder.lap1_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1_heading, "field 'lap1_heading'", cls);
            ersPassengerItemHolder.tv_comma = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comma, "field 'tv_comma'", cls);
            ersPassengerItemHolder.tv_current_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_status, "field 'tv_current_status'", cls);
            ersPassengerItemHolder.tv_ticket_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ticket_status, "field 'tv_ticket_status'", cls);
            ersPassengerItemHolder.tap_currentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tap_currentStatus, "field 'tap_currentStatus'", cls);
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
                ersPassengerItemHolder.berthType = null;
                ersPassengerItemHolder.concession = null;
                ersPassengerItemHolder.food_choice = null;
                ersPassengerItemHolder.passport_no = null;
                ersPassengerItemHolder.lap1_heading = null;
                ersPassengerItemHolder.tv_comma = null;
                ersPassengerItemHolder.tv_current_status = null;
                ersPassengerItemHolder.tv_ticket_status = null;
                ersPassengerItemHolder.tap_currentStatus = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(TDRHistoryPassengerViewHolder.class);
    }

    public TDRHistoryPassengerViewHolder(Context context, ArrayList arrayList) {
        this.a = context;
        this.f5416a = arrayList;
    }

    public final int getItemCount() {
        return this.f5416a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        String str2;
        ErsPassengerItemHolder ersPassengerItemHolder = (ErsPassengerItemHolder) viewHolder;
        PassengerDetailDTO passengerDetailDTO = this.f5416a.get(i);
        ersPassengerItemHolder.getClass();
        if (passengerDetailDTO != null) {
            ersPassengerItemHolder.lap1_heading.setVisibility(8);
            ersPassengerItemHolder.psgnName.setText(passengerDetailDTO.getPassengerName());
            Context context = this.a;
            String string = context.getResources().getString(R.string.Male);
            if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                string = context.getResources().getString(R.string.Transgender);
            } else if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase("F")) {
                string = context.getResources().getString(R.string.Female);
            }
            TextView textView = ersPassengerItemHolder.psgnAgeGender;
            StringBuilder n = lf.n(string, "| ");
            n.append(passengerDetailDTO.getPassengerAge().toString());
            n.append(" ");
            n.append(context.getResources().getString(R.string.yrs));
            textView.setText(n.toString());
            ersPassengerItemHolder.currentStatus.setVisibility(8);
            ersPassengerItemHolder.tv_current_status.setVisibility(8);
            ersPassengerItemHolder.tap_currentStatus.setVisibility(8);
            if (passengerDetailDTO.getCurrentStatus() != null && passengerDetailDTO.getCurrentStatus().equalsIgnoreCase("CAN")) {
                xx.P(context, R.string.Cancelled, ersPassengerItemHolder.psgnStatus);
                C1058d.H(context, R.color.red, ersPassengerItemHolder.psgnStatus);
            } else if (passengerDetailDTO.getCurrentStatus() == null || !passengerDetailDTO.getCurrentStatus().equalsIgnoreCase("CNF")) {
                ersPassengerItemHolder.psgnStatus.setTextColor(context.getResources().getColor(R.color.dark));
                if (passengerDetailDTO.getCurrentStatus() != null) {
                    ersPassengerItemHolder.psgnStatus.setText(passengerDetailDTO.getCurrentStatus());
                }
                if (passengerDetailDTO.getCurrentBerthNo() != 0) {
                    TextView textView2 = ersPassengerItemHolder.psgnStatus;
                    textView2.setText(ersPassengerItemHolder.psgnStatus.getText() + RemoteSettings.FORWARD_SLASH_STRING + passengerDetailDTO.getCurrentBerthNo());
                }
                ersPassengerItemHolder.coachId.setText("");
                ersPassengerItemHolder.berthNo.setText("");
                ersPassengerItemHolder.berthType.setText("");
            } else {
                xx.P(context, R.string.Confirmed, ersPassengerItemHolder.psgnStatus);
                ersPassengerItemHolder.berthNo.setText("");
                ersPassengerItemHolder.psgnStatus.setTextColor(context.getResources().getColor(R.color.dark));
                if (passengerDetailDTO.getCurrentCoachId() == null || passengerDetailDTO.getCurrentCoachId().trim().equals("")) {
                    TextView textView3 = ersPassengerItemHolder.berthNo;
                    if (String.valueOf(passengerDetailDTO.getCurrentBerthNo()).equalsIgnoreCase("0")) {
                        str = "";
                    } else {
                        str = String.valueOf(passengerDetailDTO.getCurrentBerthNo());
                    }
                    textView3.setText(str);
                    if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                        ersPassengerItemHolder.berthType.setText(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                    } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                        ersPassengerItemHolder.berthType.setText(String.valueOf(passengerDetailDTO.getBookingBerthCode()));
                    }
                } else {
                    if (passengerDetailDTO.getBookingBerthCode() != null && !passengerDetailDTO.getBookingBerthCode().trim().equals("")) {
                        TextView textView4 = ersPassengerItemHolder.psgnAgeGender;
                        textView4.setText(ersPassengerItemHolder.psgnAgeGender.getText() + "| " + I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                    }
                    ersPassengerItemHolder.coachId.setText(passengerDetailDTO.getCurrentCoachId());
                    passengerDetailDTO.getCurrentBerthNo();
                    TextView textView5 = ersPassengerItemHolder.berthNo;
                    if (String.valueOf(passengerDetailDTO.getCurrentBerthNo()).equalsIgnoreCase("0")) {
                        str2 = "";
                    } else {
                        str2 = String.valueOf(passengerDetailDTO.getCurrentBerthNo());
                    }
                    textView5.setText(str2);
                    if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
                        ersPassengerItemHolder.berthType.setText(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
                    } else if (passengerDetailDTO.getBookingBerthCode() != null) {
                        ersPassengerItemHolder.berthType.setText(String.valueOf(passengerDetailDTO.getBookingBerthCode()));
                    }
                }
            }
            if (passengerDetailDTO.getPassengerConcession() != null && !passengerDetailDTO.getPassengerConcession().trim().equals("")) {
                TextView textView6 = ersPassengerItemHolder.concession;
                textView6.setText("| " + passengerDetailDTO.getPassengerConcession());
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
                return;
            }
            J9 i2 = J9.i(passengerDetailDTO.getFoodChoice().charAt(0));
            TextView textView7 = ersPassengerItemHolder.food_choice;
            textView7.setText("| " + i2.f());
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
