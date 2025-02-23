package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;

public class AddPassengerViewHolder extends RecyclerView.Adapter<AddPassengerItemHolder> {
    private static final String TAG = C1354qp.R(AddPassengerViewHolder.class);
    /* access modifiers changed from: private */
    public String lapIndex;
    /* access modifiers changed from: private */
    public AddPassengerHolderListener listener;
    private Context mContext;
    private ArrayList<PassengerDetailDTO> passengerDetailList;

    public interface AddPassengerHolderListener {
        void onDeleteClick(PassengerDetailDTO passengerDetailDTO, Integer num);

        void onEditClick(PassengerDetailDTO passengerDetailDTO, Integer num, String str);
    }

    public class AddPassengerItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131364312)
        TextView berthPref;
        @BindView(2131362194)
        TextView childBerthOpt;
        @BindView(2131362283)
        TextView concessionOpted;
        @BindView(2131362885)
        TextView deleteBtn;
        @BindView(2131363558)
        RelativeLayout editPsgnDetail;
        PassengerDetailDTO item;
        @BindView(2131362902)
        TextView profileIcon;
        @BindView(2131364284)
        TextView psgnAge;
        @BindView(2131363555)
        TextView psgnFood;
        @BindView(2131364497)
        TextView psgnName;
        @BindView(2131364603)
        TextView tv_soft_userid;
        @BindView(2131362912)
        ImageView verifyIcon;

        public AddPassengerItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362885})
        public void DeleteClick(View view) {
            if (AddPassengerViewHolder.this.listener != null) {
                AddPassengerViewHolder.this.listener.onDeleteClick(this.item, (Integer) view.getTag());
            }
        }

        @OnClick({2131363558})
        public void psgnEditClick(View view) {
            if (AddPassengerViewHolder.this.listener != null) {
                AddPassengerViewHolder.this.listener.onEditClick(this.item, (Integer) view.getTag(), AddPassengerViewHolder.this.lapIndex);
            }
        }
    }

    public class AddPassengerItemHolder_ViewBinding implements Unbinder {
        private AddPassengerItemHolder target;
        private View view7f0a0445;
        private View view7f0a06e6;

        public AddPassengerItemHolder_ViewBinding(final AddPassengerItemHolder addPassengerItemHolder, View view) {
            this.target = addPassengerItemHolder;
            Class cls = TextView.class;
            addPassengerItemHolder.profileIcon = (TextView) Utils.findRequiredViewAsType(view, R.id.iv_profile_icon, "field 'profileIcon'", cls);
            addPassengerItemHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'psgnName'", cls);
            addPassengerItemHolder.psgnAge = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_age_gender, "field 'psgnAge'", cls);
            addPassengerItemHolder.berthPref = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_berth_pref, "field 'berthPref'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.iv_delete, "field 'deleteBtn' and method 'DeleteClick'");
            addPassengerItemHolder.deleteBtn = (TextView) Utils.castView(findRequiredView, R.id.iv_delete, "field 'deleteBtn'", cls);
            this.view7f0a0445 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    addPassengerItemHolder.DeleteClick(view);
                }
            });
            addPassengerItemHolder.psgnFood = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_food, "field 'psgnFood'", cls);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.psgn_row, "field 'editPsgnDetail' and method 'psgnEditClick'");
            addPassengerItemHolder.editPsgnDetail = (RelativeLayout) Utils.castView(findRequiredView2, R.id.psgn_row, "field 'editPsgnDetail'", RelativeLayout.class);
            this.view7f0a06e6 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    addPassengerItemHolder.psgnEditClick(view);
                }
            });
            addPassengerItemHolder.concessionOpted = (TextView) Utils.findRequiredViewAsType(view, R.id.concession_opted, "field 'concessionOpted'", cls);
            addPassengerItemHolder.childBerthOpt = (TextView) Utils.findRequiredViewAsType(view, R.id.child_berth_opt, "field 'childBerthOpt'", cls);
            addPassengerItemHolder.verifyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_verify_icon, "field 'verifyIcon'", ImageView.class);
            addPassengerItemHolder.tv_soft_userid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_soft_userid, "field 'tv_soft_userid'", cls);
        }

        public void unbind() {
            AddPassengerItemHolder addPassengerItemHolder = this.target;
            if (addPassengerItemHolder != null) {
                this.target = null;
                addPassengerItemHolder.profileIcon = null;
                addPassengerItemHolder.psgnName = null;
                addPassengerItemHolder.psgnAge = null;
                addPassengerItemHolder.berthPref = null;
                addPassengerItemHolder.deleteBtn = null;
                addPassengerItemHolder.psgnFood = null;
                addPassengerItemHolder.editPsgnDetail = null;
                addPassengerItemHolder.concessionOpted = null;
                addPassengerItemHolder.childBerthOpt = null;
                addPassengerItemHolder.verifyIcon = null;
                addPassengerItemHolder.tv_soft_userid = null;
                this.view7f0a0445.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0445 = null;
                this.view7f0a06e6.setOnClickListener((View.OnClickListener) null);
                this.view7f0a06e6 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AddPassengerViewHolder(Context context, ArrayList<PassengerDetailDTO> arrayList, AddPassengerHolderListener addPassengerHolderListener, String str) {
        this.mContext = context;
        this.listener = addPassengerHolderListener;
        this.passengerDetailList = arrayList;
        this.lapIndex = str;
    }

    public static String valueOf(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public int getItemCount() {
        return this.passengerDetailList.size();
    }

    public AddPassengerItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_passenger, (ViewGroup) null);
        AddPassengerItemHolder addPassengerItemHolder = new AddPassengerItemHolder(r);
        xx.O(-1, -2, r);
        return addPassengerItemHolder;
    }

    public void onBindViewHolder(AddPassengerItemHolder addPassengerItemHolder, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AddPassengerItemHolder addPassengerItemHolder2 = addPassengerItemHolder;
        int i2 = i;
        PassengerDetailDTO passengerDetailDTO = this.passengerDetailList.get(i2);
        addPassengerItemHolder2.item = passengerDetailDTO;
        addPassengerItemHolder2.psgnName.setText(passengerDetailDTO.getPassengerName());
        addPassengerItemHolder2.psgnName.setTextColor(this.mContext.getResources().getColor(R.color.blue));
        if (passengerDetailDTO.getPassengerAge() != null) {
            str = passengerDetailDTO.getPassengerAge() + " ";
        } else {
            str = "";
        }
        TextView textView = addPassengerItemHolder2.psgnAge;
        StringBuilder J = xx.J(str);
        J.append(passengerDetailDTO.getPassengerGender());
        textView.setText(J.toString());
        boolean z = false;
        if (AllTrainListFragment.i) {
            if (passengerDetailDTO.getPassengerAge().shortValue() <= 4) {
                addPassengerItemHolder2.deleteBtn.setVisibility(0);
            } else {
                addPassengerItemHolder2.deleteBtn.setVisibility(8);
            }
        }
        if (passengerDetailDTO.getSoftMemberId() != null) {
            addPassengerItemHolder2.tv_soft_userid.setVisibility(0);
            addPassengerItemHolder2.tv_soft_userid.setText(String.valueOf(this.mContext.getResources().getString(R.string.Loyalty_No_passengerpage) + passengerDetailDTO.getSoftMemberId()));
        } else {
            addPassengerItemHolder2.tv_soft_userid.setVisibility(8);
        }
        addPassengerItemHolder2.deleteBtn.setTag(Integer.valueOf(i));
        addPassengerItemHolder2.editPsgnDetail.setTag(Integer.valueOf(i));
        C0794b3 b3Var = PassengerDetailFragment.f4886a;
        C0794b3 b3Var2 = PassengerDetailFragment.b;
        addPassengerItemHolder2.profileIcon.setText("" + (i2 + 1));
        if (!b3Var.isFoodChoiceEnabled() && !b3Var2.isFoodChoiceEnabled()) {
            addPassengerItemHolder2.psgnFood.setVisibility(8);
        } else if (passengerDetailDTO.getPassengerFoodChoice() == null || passengerDetailDTO.getPassengerFoodChoice().equals("")) {
            addPassengerItemHolder2.psgnFood.setVisibility(8);
        } else {
            addPassengerItemHolder2.psgnFood.setVisibility(0);
            addPassengerItemHolder2.psgnFood.setText(passengerDetailDTO.getPassengerFoodChoice());
            J9 i3 = J9.i(passengerDetailDTO.getPassengerFoodChoice().charAt(0));
            addPassengerItemHolder2.psgnFood.setText("| " + i3.f());
            C0535I5.h0(addPassengerItemHolder2.psgnFood, passengerDetailDTO.getPassengerFoodChoice());
        }
        if (C1450w1.f7024c || passengerDetailDTO.getPassengerAge().shortValue() >= PassengerDetailFragment.n || (passengerDetailDTO.getChildBerthFlag() != null && passengerDetailDTO.getChildBerthFlag().booleanValue() && passengerDetailDTO.getPassengerAge().shortValue() < PassengerDetailFragment.n)) {
            if (passengerDetailDTO.getPassengerBerthChoice() == null || passengerDetailDTO.getPassengerBerthChoice().equals("") || passengerDetailDTO.getPassengerBerthChoice().equalsIgnoreCase("NC")) {
                addPassengerItemHolder2.berthPref.setVisibility(8);
            } else {
                addPassengerItemHolder2.berthPref.setText("| " + passengerDetailDTO.getPassengerBerthChoice().trim());
                addPassengerItemHolder2.berthPref.setVisibility(0);
            }
            if (passengerDetailDTO.getConcessionOpted() == null || !passengerDetailDTO.getConcessionOpted().booleanValue()) {
                addPassengerItemHolder2.concessionOpted.setVisibility(8);
            } else {
                xx.P(this.mContext, R.string.Sr_Citizen, addPassengerItemHolder2.concessionOpted);
                addPassengerItemHolder2.concessionOpted.setVisibility(0);
            }
            if (passengerDetailDTO.getChildBerthFlag() == null || !passengerDetailDTO.getChildBerthFlag().booleanValue()) {
                addPassengerItemHolder2.childBerthOpt.setVisibility(8);
            } else {
                addPassengerItemHolder2.childBerthOpt.setVisibility(0);
            }
            if (PassengerDetailFragment.f4888b.containsKey(passengerDetailDTO.getPassengerSerialNumber())) {
                if (b3Var.isSeniorCitizenApplicable() && (((passengerDetailDTO.getPassengerGender().equals("M") && passengerDetailDTO.getPassengerAge().shortValue() >= b3Var.getSrctznAge()) || (passengerDetailDTO.getPassengerGender().equals("F") && passengerDetailDTO.getPassengerAge().shortValue() >= b3Var.getSrctnwAge())) && passengerDetailDTO.getConcessionOpted() == null)) {
                    z = true;
                }
                Boolean.toString(z);
                Boolean.toString(b3Var.isSeniorCitizenApplicable());
                Boolean.toString(passengerDetailDTO.getPassengerGender().equals("M"));
                Boolean.toString(passengerDetailDTO.getPassengerGender().equals("F"));
                valueOf(passengerDetailDTO.getConcessionOpted());
                valueOf(passengerDetailDTO.getForGoConcessionOpted());
                if (this.lapIndex.equalsIgnoreCase("lap1")) {
                    if ((!C1450w1.f7024c || passengerDetailDTO.getPassengerAge() != null) && !b3Var.isBedRollFlagEnabled() && ((!b3Var.isSeniorCitizenApplicable() || (((!passengerDetailDTO.getPassengerGender().equals("M") || passengerDetailDTO.getPassengerAge().shortValue() < b3Var.getSrctznAge()) && (!passengerDetailDTO.getPassengerGender().equals("F") || passengerDetailDTO.getPassengerAge().shortValue() < b3Var.getSrctnwAge())) || passengerDetailDTO.getConcessionOpted() != null)) && ((b3Var.isChildBerthMandatory() || passengerDetailDTO.getPassengerAge().shortValue() > b3Var.getMaxChildAge()) && ((passengerDetailDTO.getChildBerthFlag() == null || !passengerDetailDTO.getChildBerthFlag().booleanValue() || passengerDetailDTO.getPassengerAge().shortValue() >= b3Var.getMinPassengerAge()) && ((b3Var.getApplicableBerthTypes() != null || passengerDetailDTO.getBookingBerthCode() == null) && ((!b3Var.isFoodChoiceEnabled() || b3Var.getFoodDetails().size() != 3) && ((!b3Var.isFoodChoiceEnabled() || passengerDetailDTO.getPassengerFoodChoice() != null) && (((str4 = PassengerDetailFragment.S) == null || !str4.equalsIgnoreCase("Y")) && (((str5 = PassengerDetailFragment.P) == null || !str5.equalsIgnoreCase("HP")) && passengerDetailDTO.getPassengerNationality() != null && (!C1450w1.f7024c || passengerDetailDTO.getPsgnConcType() != null)))))))))) {
                        PassengerDetailFragment.f4888b.remove(passengerDetailDTO.getPassengerSerialNumber());
                        if (PassengerDetailFragment.f4888b.containsKey((short) 100)) {
                            PassengerDetailFragment.f4888b.put((short) 100, Short.valueOf((short) (PassengerDetailFragment.f4888b.get((short) 100).shortValue() - 1)));
                        }
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.vibrate_anim);
                        addPassengerItemHolder2.psgnName.setAnimation(loadAnimation);
                        addPassengerItemHolder2.psgnName.setTextColor(this.mContext.getResources().getColor(R.color.red));
                        loadAnimation.start();
                        PassengerDetailFragment.f4888b.put(passengerDetailDTO.getPassengerSerialNumber(), (short) 1);
                    }
                }
                if (C0535I5.f3647h) {
                    if ((!C1450w1.f7024c || passengerDetailDTO.getPassengerAge() != null) && !b3Var2.isBedRollFlagEnabled() && ((!b3Var2.isSeniorCitizenApplicable() || (((!passengerDetailDTO.getPassengerGender().equals("M") || passengerDetailDTO.getPassengerAge().shortValue() < b3Var2.getSrctznAge()) && (!passengerDetailDTO.getPassengerGender().equals("F") || passengerDetailDTO.getPassengerAge().shortValue() < b3Var2.getSrctnwAge())) || passengerDetailDTO.getConcessionOpted() != null)) && ((b3Var2.isChildBerthMandatory() || passengerDetailDTO.getPassengerAge().shortValue() > b3Var2.getMaxChildAge()) && ((passengerDetailDTO.getChildBerthFlag() == null || !passengerDetailDTO.getChildBerthFlag().booleanValue() || passengerDetailDTO.getPassengerAge().shortValue() >= b3Var2.getMinPassengerAge()) && ((!b3Var2.isFoodChoiceEnabled() || b3Var2.getFoodDetails().size() != 3) && ((!b3Var2.isFoodChoiceEnabled() || passengerDetailDTO.getPassengerFoodChoice() != null) && (((str2 = PassengerDetailFragment.S) == null || !str2.equalsIgnoreCase("Y")) && (((str3 = PassengerDetailFragment.P) == null || !str3.equalsIgnoreCase("HP")) && passengerDetailDTO.getPassengerNationality() != null && (!C1450w1.f7024c || passengerDetailDTO.getPsgnConcType() != null))))))))) {
                        PassengerDetailFragment.f4888b.remove(passengerDetailDTO.getPassengerSerialNumber());
                        if (PassengerDetailFragment.f4888b.containsKey((short) 100)) {
                            PassengerDetailFragment.f4888b.put((short) 100, Short.valueOf((short) (PassengerDetailFragment.f4888b.get((short) 100).shortValue() - 1)));
                        }
                    } else {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, R.anim.vibrate_anim);
                        addPassengerItemHolder2.psgnName.setAnimation(loadAnimation2);
                        addPassengerItemHolder2.psgnName.setTextColor(this.mContext.getResources().getColor(R.color.red));
                        loadAnimation2.start();
                        PassengerDetailFragment.f4888b.put(passengerDetailDTO.getPassengerSerialNumber(), (short) 1);
                    }
                }
            }
        } else {
            addPassengerItemHolder2.berthPref.setVisibility(8);
            addPassengerItemHolder2.concessionOpted.setVisibility(8);
            addPassengerItemHolder2.childBerthOpt.setVisibility(8);
            addPassengerItemHolder2.psgnFood.setVisibility(8);
        }
        if (passengerDetailDTO.getVerificationStatusString() == null || passengerDetailDTO.getVerificationStatusString().trim().equals("") || passengerDetailDTO.getVerificationStatusString().trim().equals("Not Applicable")) {
            addPassengerItemHolder2.verifyIcon.setVisibility(8);
            return;
        }
        addPassengerItemHolder2.verifyIcon.setVisibility(0);
        if (passengerDetailDTO.getVerificationStatusString().trim().equalsIgnoreCase("Verified")) {
            addPassengerItemHolder2.verifyIcon.setImageResource(R.drawable.verified);
        }
    }
}
