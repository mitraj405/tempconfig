package cris.org.in.ima.adaptors;

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
import com.google.android.gms.ads.RequestConfiguration;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public class CancelTicketPassengerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(CancelTicketPassengerAdapter.class);
    private static boolean cantegency = false;
    CancelTicketDetailsFragment f;
    private Fragment pFragment;
    private ArrayList<PassengerDetailDTO> psgnList;
    /* access modifiers changed from: private */
    public ArrayList<Boolean> selectedPassengers = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363551)
        TextView ageGenderFood;
        @BindView(2131362029)
        TextView berth;
        @BindView(2131362037)
        TextView berthType;
        @BindView(2131362040)
        TextView bkgStatus;
        @BindView(2131362272)
        TextView coach;
        @BindView(2131362332)
        TextView currentStatus;
        @BindView(2131363295)
        TextView psgnName;
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
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.bkgStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.bkg_status, "field 'bkgStatus'", cls);
            viewHolder.coach = (TextView) Utils.findRequiredViewAsType(view, R.id.coach, "field 'coach'", cls);
            viewHolder.berth = (TextView) Utils.findRequiredViewAsType(view, R.id.berth, "field 'berth'", cls);
            viewHolder.berthType = (TextView) Utils.findRequiredViewAsType(view, R.id.berth_type, "field 'berthType'", cls);
            viewHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'psgnName'", cls);
            viewHolder.ageGenderFood = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_age_gender, "field 'ageGenderFood'", cls);
            viewHolder.selection = (CheckBox) Utils.findRequiredViewAsType(view, R.id.selection, "field 'selection'", CheckBox.class);
            viewHolder.psgn_selection = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.psgn_selection, "field 'psgn_selection'", LinearLayout.class);
            viewHolder.currentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.current_status, "field 'currentStatus'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.bkgStatus = null;
                viewHolder.coach = null;
                viewHolder.berth = null;
                viewHolder.berthType = null;
                viewHolder.psgnName = null;
                viewHolder.ageGenderFood = null;
                viewHolder.selection = null;
                viewHolder.psgn_selection = null;
                viewHolder.currentStatus = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CancelTicketPassengerAdapter(Fragment fragment, ArrayList<PassengerDetailDTO> arrayList) {
        this.pFragment = fragment;
        this.psgnList = arrayList;
        this.f = (CancelTicketDetailsFragment) fragment;
        for (int i = 0; i < this.psgnList.size(); i++) {
            this.selectedPassengers.add(i, Boolean.FALSE);
        }
    }

    public int getItemCount() {
        return this.psgnList.size();
    }

    public String getPassengerToken() {
        StringBuilder sb = new StringBuilder("NNNNNN");
        for (int i = 0; i < this.selectedPassengers.size(); i++) {
            if (this.selectedPassengers.get(i).booleanValue()) {
                sb.setCharAt(i, 'Y');
            }
        }
        return sb.toString();
    }

    public ArrayList<Boolean> getSelectedPassengerList() {
        return this.selectedPassengers;
    }

    public boolean isAllPassengersSelected() {
        if (this.psgnList == null) {
            return false;
        }
        for (int i = 0; i < this.psgnList.size(); i++) {
            if (!this.selectedPassengers.get(i).booleanValue() && !this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                return false;
            }
        }
        return true;
    }

    public boolean isCantegency() {
        return cantegency;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_cancel_ticket_passenger_info, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void setCantegency(boolean z) {
        cantegency = z;
    }

    public void setSelectAll(boolean z) {
        if (z) {
            this.f.g(true);
        }
        if (this.psgnList != null) {
            for (int i = 0; i < this.psgnList.size(); i++) {
                if (!this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                    this.selectedPassengers.set(i, Boolean.valueOf(z));
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setSelectAllMpPass(boolean z) {
        if (this.psgnList != null) {
            for (int i = 0; i < this.psgnList.size(); i++) {
                if (!this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                    this.selectedPassengers.set(i, Boolean.valueOf(z));
                }
                if (!this.f.f4485a && this.psgnList.get(i).getPassengerConcession() != null && this.psgnList.get(i).getPassengerConcession().equalsIgnoreCase("MPSPOS")) {
                    this.selectedPassengers.set(i, Boolean.FALSE);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        String str;
        final PassengerDetailDTO passengerDetailDTO = this.psgnList.get(i);
        ArrayList arrayList = new ArrayList();
        if (passengerDetailDTO.getPassengerGender().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
            str = "Transgender";
        } else {
            str = passengerDetailDTO.getPassengerGender().equalsIgnoreCase("F") ? "Female" : "Male";
        }
        arrayList.add(str);
        arrayList.add(passengerDetailDTO.getPassengerAge().toString() + " " + this.pFragment.getString(R.string.yrs));
        if (passengerDetailDTO.getBookingBerthCode() != null && I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())) != null) {
            arrayList.add(I9.j(String.valueOf(passengerDetailDTO.getBookingBerthCode())).a());
        } else if (passengerDetailDTO.getBookingBerthCode() != null) {
            arrayList.add(passengerDetailDTO.getBookingBerthCode());
        }
        arrayList.add(passengerDetailDTO.getFoodChoice());
        viewHolder.ageGenderFood.setText(C0535I5.r0(arrayList));
        viewHolder.psgnName.setText(this.psgnList.get(i).getPassengerName());
        if (!this.selectedPassengers.get(i).booleanValue() || this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
            viewHolder.selection.setChecked(false);
        } else {
            viewHolder.selection.setChecked(true);
        }
        viewHolder.psgn_selection.setEnabled(true);
        viewHolder.selection.setEnabled(true);
        if (C1450w1.f7024c) {
            if (this.selectedPassengers.get(i).booleanValue() && !this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can") && passengerDetailDTO.getPassengerConcession() != null && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS")) {
                viewHolder.psgn_selection.setEnabled(false);
                viewHolder.selection.setEnabled(false);
            } else if (this.selectedPassengers.size() > 1 && this.selectedPassengers.get(0).booleanValue() && !this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can") && passengerDetailDTO.getPassengerConcession() != null && passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPSPOS")) {
                viewHolder.psgn_selection.setEnabled(false);
                viewHolder.selection.setEnabled(false);
            }
        }
        viewHolder.currentStatus.setText(this.psgnList.get(i).getCurrentStatusDetails());
        viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
        viewHolder.selection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C1450w1.f7024c) {
                    boolean booleanValue = ((Boolean) CancelTicketPassengerAdapter.this.selectedPassengers.get(i)).booleanValue();
                    if (!booleanValue) {
                        if (passengerDetailDTO.getPassengerConcession() == null || !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS")) {
                            CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                            viewHolder.selection.setChecked(!booleanValue);
                            if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                                CancelTicketPassengerAdapter.this.f.g(true);
                            } else {
                                CancelTicketPassengerAdapter.this.f.g(false);
                            }
                        } else {
                            CancelTicketPassengerAdapter.this.setSelectAllMpPass(true);
                        }
                    } else if (passengerDetailDTO.getPassengerConcession() == null || !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS")) {
                        CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                        viewHolder.selection.setChecked(!booleanValue);
                        if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                            CancelTicketPassengerAdapter.this.f.g(true);
                        } else {
                            CancelTicketPassengerAdapter.this.f.g(false);
                        }
                    } else {
                        CancelTicketPassengerAdapter.this.setSelectAllMpPass(false);
                    }
                } else {
                    boolean booleanValue2 = ((Boolean) CancelTicketPassengerAdapter.this.selectedPassengers.get(i)).booleanValue();
                    CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue2));
                    viewHolder.selection.setChecked(!booleanValue2);
                    if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                        CancelTicketPassengerAdapter.this.f.g(true);
                    } else {
                        CancelTicketPassengerAdapter.this.f.g(false);
                    }
                }
            }
        });
        viewHolder.psgn_selection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C1450w1.f7024c) {
                    boolean booleanValue = ((Boolean) CancelTicketPassengerAdapter.this.selectedPassengers.get(i)).booleanValue();
                    if (!booleanValue) {
                        if (passengerDetailDTO.getPassengerConcession() == null || (!passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS") && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPCOMP"))) {
                            CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                            viewHolder.selection.setChecked(!booleanValue);
                            if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                                CancelTicketPassengerAdapter.this.f.g(true);
                            } else {
                                CancelTicketPassengerAdapter.this.f.g(false);
                            }
                        } else {
                            CancelTicketPassengerAdapter.this.setSelectAllMpPass(true);
                        }
                    } else if (passengerDetailDTO.getPassengerConcession() == null || (!passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS") && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPCOMP"))) {
                        CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                        viewHolder.selection.setChecked(!booleanValue);
                        if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                            CancelTicketPassengerAdapter.this.f.g(true);
                        } else {
                            CancelTicketPassengerAdapter.this.f.g(false);
                        }
                    } else {
                        CancelTicketPassengerAdapter.this.setSelectAllMpPass(false);
                    }
                } else {
                    boolean booleanValue2 = ((Boolean) CancelTicketPassengerAdapter.this.selectedPassengers.get(i)).booleanValue();
                    CancelTicketPassengerAdapter.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue2));
                    viewHolder.selection.setChecked(!booleanValue2);
                    if (CancelTicketPassengerAdapter.this.isAllPassengersSelected()) {
                        CancelTicketPassengerAdapter.this.f.g(true);
                    } else {
                        CancelTicketPassengerAdapter.this.f.g(false);
                    }
                }
            }
        });
        if (this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can") || this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("REL") || this.psgnList.get(i).getCurrentStatusDetails().contains("Can")) {
            this.selectedPassengers.set(i, Boolean.FALSE);
            viewHolder.selection.setVisibility(4);
        } else if (this.psgnList.get(i).getCurrentStatusDetails().contains("RAC")) {
            viewHolder.selection.setVisibility(0);
        } else if (this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("CNF")) {
            viewHolder.selection.setVisibility(0);
        } else if (this.psgnList.get(i).getCurrentStatusDetails().contains("WL")) {
            viewHolder.selection.setVisibility(0);
        } else {
            viewHolder.selection.setVisibility(0);
        }
        if (this.psgnList.get(i).getBookingStatusDetails() != null && this.psgnList.get(i).getBookingStatusDetails().equalsIgnoreCase("CNF")) {
            viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
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
