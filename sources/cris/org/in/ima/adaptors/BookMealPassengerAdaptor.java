package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.ima.fragment.BookMealFragment;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import cris.prs.webservices.dto.PostBookingRequestDTO;
import defpackage.d7;
import java.util.ArrayList;
import java.util.Iterator;

public class BookMealPassengerAdaptor extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(CancelTicketPassengerAdapter.class);
    private static boolean cantegency = false;
    /* access modifiers changed from: private */
    public CustomDialogFragment dialogFragment;
    BookMealFragment f;
    ArrayList<String> foodOptionSpinner = new ArrayList<>();
    /* access modifiers changed from: private */
    public Fragment pFragment;
    private PostBookingRequestDTO postBookingRequestDTO;
    private ArrayList<PassengerDetailDTO> postPassengerList;
    /* access modifiers changed from: private */
    public ArrayList<PassengerDetailDTO> psgnList;
    /* access modifiers changed from: private */
    public ArrayList<Boolean> selectedPassengers;
    /* access modifiers changed from: private */
    public PnrEnquiryResponseDTO tktDetail;
    private String txnid = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363551)
        TextView ageGenderFood;
        @BindView(2131362040)
        TextView bkgStatus;
        @BindView(2131362332)
        TextView currentStatus;
        @BindView(2131363295)
        TextView psgnName;
        @BindView(2131363559)
        LinearLayout psgn_selection;
        @BindView(2131363903)
        TextView selectMeal;
        @BindView(2131364331)
        TextView tv_cateringCharges;

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
            viewHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'psgnName'", cls);
            viewHolder.ageGenderFood = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_age_gender, "field 'ageGenderFood'", cls);
            viewHolder.psgn_selection = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.psgn_selection, "field 'psgn_selection'", LinearLayout.class);
            viewHolder.currentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.current_status, "field 'currentStatus'", cls);
            viewHolder.selectMeal = (TextView) Utils.findRequiredViewAsType(view, R.id.select_meal, "field 'selectMeal'", cls);
            viewHolder.tv_cateringCharges = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cateringCharges, "field 'tv_cateringCharges'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.bkgStatus = null;
                viewHolder.psgnName = null;
                viewHolder.ageGenderFood = null;
                viewHolder.psgn_selection = null;
                viewHolder.currentStatus = null;
                viewHolder.selectMeal = null;
                viewHolder.tv_cateringCharges = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public BookMealPassengerAdaptor(Fragment fragment, ArrayList<PassengerDetailDTO> arrayList, PnrEnquiryResponseDTO pnrEnquiryResponseDTO, String str) {
        this.pFragment = fragment;
        this.tktDetail = pnrEnquiryResponseDTO;
        this.psgnList = arrayList;
        this.txnid = str;
        this.f = (BookMealFragment) fragment;
        this.selectedPassengers = new ArrayList<>();
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
        View r = C1058d.r(viewGroup, R.layout.item_book_meal_passenger_info, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public PostBookingRequestDTO preparePostBookingRequestDto() {
        PostBookingRequestDTO postBookingRequestDTO2 = new PostBookingRequestDTO();
        postBookingRequestDTO2.setPnrNumber(this.tktDetail.getPnrNumber());
        postBookingRequestDTO2.setTxnId(this.txnid);
        Xp xp = new Xp();
        xp.setServiceId(1);
        ArrayList arrayList = new ArrayList();
        Iterator<PassengerDetailDTO> it = this.psgnList.iterator();
        while (it.hasNext()) {
            PassengerDetailDTO next = it.next();
            PassengerDetailDTO passengerDetailDTO = new PassengerDetailDTO();
            passengerDetailDTO.setPassengerSerialNumber(next.getPassengerSerialNumber());
            passengerDetailDTO.setPassengerName(next.getPassengerName());
            passengerDetailDTO.setPassengerAge(next.getPassengerAge());
            passengerDetailDTO.setPassengerGender(next.getPassengerGender());
            passengerDetailDTO.setPassengerFoodChoice(next.getFoodChoice());
            arrayList.add(passengerDetailDTO);
        }
        xp.setPassengerList(arrayList);
        postBookingRequestDTO2.setPostBookingServices(xp);
        return postBookingRequestDTO2;
    }

    public void setCantegency(boolean z) {
        cantegency = z;
    }

    public void setSelectAllMpPass(boolean z) {
        if (this.psgnList != null) {
            for (int i = 0; i < this.psgnList.size(); i++) {
                if (!this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                    this.selectedPassengers.set(i, Boolean.valueOf(z));
                }
                this.f.getClass();
                if (this.psgnList.get(i).getPassengerConcession() != null && this.psgnList.get(i).getPassengerConcession().equalsIgnoreCase("MPSPOS")) {
                    this.selectedPassengers.set(i, Boolean.FALSE);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final PassengerDetailDTO passengerDetailDTO = this.psgnList.get(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(passengerDetailDTO.getPassengerGender().toString());
        arrayList.add(passengerDetailDTO.getPassengerAge().toString() + " " + this.pFragment.getString(R.string.yrs));
        if (passengerDetailDTO.getFoodChoice().equalsIgnoreCase(String.valueOf('D'))) {
            viewHolder.selectMeal.setText(this.pFragment.getString(R.string.catering_service_option));
            TextView textView = viewHolder.selectMeal;
            Context context = this.pFragment.getContext();
            Object obj = d7.a;
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, d7.a.b(context, R.drawable.spinner_downwards), (Drawable) null);
            viewHolder.selectMeal.setBackground(d7.a.b(this.pFragment.getContext(), R.drawable.border_highlight_indicator));
            viewHolder.selectMeal.setClickable(true);
            TextView textView2 = viewHolder.tv_cateringCharges;
            textView2.setText(this.pFragment.getString(R.string.Catering_Charges) + ": ₹" + this.tktDetail.getCateringFare() + " " + this.pFragment.getString(R.string.per_Passenger));
        } else {
            TextView textView3 = viewHolder.selectMeal;
            Context context2 = this.pFragment.getContext();
            Object obj2 = d7.a;
            textView3.setBackground(d7.a.b(context2, R.drawable.border_shadow));
            viewHolder.selectMeal.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            viewHolder.selectMeal.setText(J9.i(passengerDetailDTO.getFoodChoice().charAt(0)).f());
            viewHolder.selectMeal.setTextColor(this.pFragment.getResources().getColor(R.color.lightdark));
            viewHolder.tv_cateringCharges.setVisibility(8);
            viewHolder.selectMeal.setClickable(false);
            viewHolder.selectMeal.setEnabled(false);
        }
        viewHolder.ageGenderFood.setText(C0535I5.r0(arrayList));
        viewHolder.psgnName.setText(this.psgnList.get(i).getPassengerName());
        if (this.selectedPassengers.get(i).booleanValue()) {
            this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can");
        }
        viewHolder.psgn_selection.setEnabled(true);
        if (C1450w1.f7024c) {
            if (this.selectedPassengers.get(i).booleanValue() && !this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can") && passengerDetailDTO.getPassengerConcession() != null && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS")) {
                viewHolder.psgn_selection.setEnabled(false);
            } else if (this.selectedPassengers.size() > 1 && this.selectedPassengers.get(0).booleanValue() && !this.psgnList.get(i).getCurrentStatusDetails().equalsIgnoreCase("can") && passengerDetailDTO.getPassengerConcession() != null && passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPSPOS")) {
                viewHolder.psgn_selection.setEnabled(false);
            }
        }
        viewHolder.currentStatus.setText(this.psgnList.get(i).getCurrentStatusDetails());
        viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
        viewHolder.selectMeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BookMealPassengerAdaptor.this.foodOptionSpinner.clear();
                for (int i = 0; i < BookMealPassengerAdaptor.this.tktDetail.getFoodDetails().size(); i++) {
                    BookMealPassengerAdaptor bookMealPassengerAdaptor = BookMealPassengerAdaptor.this;
                    bookMealPassengerAdaptor.foodOptionSpinner.add(J9.i(bookMealPassengerAdaptor.tktDetail.getFoodDetails().get(i).charAt(0)).f());
                }
                CustomDialogFragment unused = BookMealPassengerAdaptor.this.dialogFragment = new CustomDialogFragment();
                BookMealPassengerAdaptor.this.dialogFragment.setShowsDialog(true);
                BookMealPassengerAdaptor.this.dialogFragment.show(BookMealPassengerAdaptor.this.pFragment.getParentFragmentManager(), "");
                BookMealPassengerAdaptor.this.dialogFragment.setCancelable(true);
                BookMealPassengerAdaptor.this.pFragment.getParentFragmentManager().z();
                CustomAdapter customAdapter = new CustomAdapter(view.getContext(), BookMealPassengerAdaptor.this.foodOptionSpinner, new OnSelectionListener() {
                    public void onClick(String str) {
                        viewHolder.selectMeal.setText(str);
                        ((PassengerDetailDTO) BookMealPassengerAdaptor.this.psgnList.get(i)).setFoodChoice(String.valueOf(J9.j(str).f3664a));
                        BookMealPassengerAdaptor.this.dialogFragment.dismiss();
                    }
                });
                BookMealPassengerAdaptor.this.dialogFragment.g().setText(R.string.catering_service_option);
                BookMealPassengerAdaptor.this.dialogFragment.f().setAdapter(customAdapter);
            }
        });
        viewHolder.psgn_selection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C1450w1.f7024c) {
                    boolean booleanValue = ((Boolean) BookMealPassengerAdaptor.this.selectedPassengers.get(i)).booleanValue();
                    if (!booleanValue) {
                        if (passengerDetailDTO.getPassengerConcession() == null || (!passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS") && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPCOMP"))) {
                            BookMealPassengerAdaptor.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                        } else {
                            BookMealPassengerAdaptor.this.setSelectAllMpPass(true);
                        }
                    } else if (passengerDetailDTO.getPassengerConcession() == null || (!passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPPASS") && !passengerDetailDTO.getPassengerConcession().equalsIgnoreCase("MPCOMP"))) {
                        BookMealPassengerAdaptor.this.selectedPassengers.set(i, Boolean.valueOf(!booleanValue));
                    } else {
                        BookMealPassengerAdaptor.this.setSelectAllMpPass(false);
                    }
                } else {
                    BookMealPassengerAdaptor.this.selectedPassengers.set(i, Boolean.valueOf(!((Boolean) BookMealPassengerAdaptor.this.selectedPassengers.get(i)).booleanValue()));
                }
            }
        });
        if (this.psgnList.get(i).getBookingStatusDetails() != null && this.psgnList.get(i).getBookingStatusDetails().equalsIgnoreCase("CNF")) {
            viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
        } else if (this.psgnList.get(i).getBookingStatusDetails() != null) {
            viewHolder.bkgStatus.setText(this.psgnList.get(i).getBookingStatusDetails());
        } else {
            viewHolder.bkgStatus.setText("");
        }
    }
}
