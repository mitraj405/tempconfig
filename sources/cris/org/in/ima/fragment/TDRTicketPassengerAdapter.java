package cris.org.in.ima.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public final class TDRTicketPassengerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final TDRTicketDetailsFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f5145a;
    public final ArrayList<Boolean> b = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364311)
        TextView berth;
        @BindView(2131364316)
        TextView berthType;
        @BindView(2131364318)
        TextView bkgStatus;
        @BindView(2131364344)
        TextView coach;
        @BindView(2131362332)
        TextView currentStatus;
        @BindView(2131363557)
        TextView name;
        @BindView(2131363551)
        TextView psgnAgeGender;
        @BindView(2131363559)
        LinearLayout psgn_selection;
        @BindView(2131363940)
        CheckBox selection;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.selection = (CheckBox) Utils.findRequiredViewAsType(view, R.id.selection, "field 'selection'", CheckBox.class);
            viewHolder.psgn_selection = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.psgn_selection, "field 'psgn_selection'", LinearLayout.class);
            Class cls = TextView.class;
            viewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_name, "field 'name'", cls);
            viewHolder.psgnAgeGender = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_age_gender, "field 'psgnAgeGender'", cls);
            viewHolder.bkgStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bkg_status, "field 'bkgStatus'", cls);
            viewHolder.coach = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_coach, "field 'coach'", cls);
            viewHolder.berth = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_berth, "field 'berth'", cls);
            viewHolder.berthType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_berth_type, "field 'berthType'", cls);
            viewHolder.currentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.current_status, "field 'currentStatus'", cls);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.selection = null;
                viewHolder.psgn_selection = null;
                viewHolder.name = null;
                viewHolder.psgnAgeGender = null;
                viewHolder.bkgStatus = null;
                viewHolder.coach = null;
                viewHolder.berth = null;
                viewHolder.berthType = null;
                viewHolder.currentStatus = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(TDRTicketPassengerAdapter.class);
    }

    public TDRTicketPassengerAdapter(Fragment fragment, ArrayList<PassengerDetailDTO> arrayList) {
        this.f5145a = arrayList;
        this.a = (TDRTicketDetailsFragment) fragment;
        for (int i = 0; i < this.f5145a.size(); i++) {
            this.b.add(i, Boolean.FALSE);
        }
    }

    public final int getItemCount() {
        return this.f5145a.size();
    }

    public final String getPassengerToken() {
        StringBuilder sb = new StringBuilder("NNNNNN");
        int i = 0;
        while (true) {
            ArrayList<Boolean> arrayList = this.b;
            if (i >= arrayList.size()) {
                return sb.toString();
            }
            if (arrayList.get(i).booleanValue()) {
                sb.setCharAt(i, 'Y');
            }
            i++;
        }
    }

    public final boolean isAllPassengersSelected() {
        ArrayList<PassengerDetailDTO> arrayList = this.f5145a;
        if (arrayList == null) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (!this.b.get(i).booleanValue() && !arrayList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                return false;
            }
        }
        return true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        String str;
        String str2;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ArrayList<PassengerDetailDTO> arrayList = this.f5145a;
        PassengerDetailDTO passengerDetailDTO = arrayList.get(i);
        if (arrayList.get(i).getPassengerGender().equalsIgnoreCase("M")) {
            i2 = R.string.male;
        } else {
            i2 = R.string.female;
        }
        TDRTicketDetailsFragment tDRTicketDetailsFragment = this.a;
        String string = tDRTicketDetailsFragment.getString(i2);
        viewHolder2.name.setText(arrayList.get(i).getPassengerName());
        if (TicketHistoryUtil.f5370a == TicketHistoryUtil.SortFor.TDR_HISTORY) {
            viewHolder2.selection.setVisibility(8);
        }
        ArrayList<Boolean> arrayList2 = this.b;
        if (!arrayList2.get(i).booleanValue() || arrayList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
            viewHolder2.selection.setChecked(false);
        } else {
            viewHolder2.selection.setChecked(true);
        }
        if (passengerDetailDTO.getPassengerFoodChoice() != null) {
            str = ", " + passengerDetailDTO.getPassengerFoodChoice();
        } else {
            str = "";
        }
        if (passengerDetailDTO.getBookingBerthCode() == null || I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) == null) {
            str2 = "";
        } else {
            str2 = I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a();
        }
        if (!str2.equalsIgnoreCase("")) {
            str2 = ", ".concat(str2);
        }
        TextView textView = viewHolder2.psgnAgeGender;
        StringBuilder n = lf.n(string, ", ");
        n.append(passengerDetailDTO.getPassengerAge());
        n.append(" ");
        n.append(tDRTicketDetailsFragment.getString(R.string.yrs));
        n.append(str2);
        n.append(str);
        textView.setText(n.toString());
        viewHolder2.selection.setOnCheckedChangeListener(new u0(this, i));
        viewHolder2.psgn_selection.setOnClickListener(new v0(this, i, viewHolder2));
        if (arrayList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
            arrayList2.set(i, Boolean.FALSE);
            viewHolder2.selection.setVisibility(4);
            viewHolder2.selection.setVisibility(0);
        }
        viewHolder2.bkgStatus.setText(arrayList.get(i).getBookingStatusDetails());
        viewHolder2.currentStatus.setText(arrayList.get(i).getCurrentStatusDetails());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_ticket_passenger_info, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
