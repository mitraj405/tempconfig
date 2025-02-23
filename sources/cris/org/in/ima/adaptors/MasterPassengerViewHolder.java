package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.ima.model.MasterPassengerModel;
import cris.org.in.prs.ima.R;
import defpackage.C1426uk;
import java.util.List;

public class MasterPassengerViewHolder extends RecyclerView.Adapter<MasterPassengerItemHolder> {
    private static int noOfMasterPsgnSelected;
    /* access modifiers changed from: private */
    public MasterPsgnHolderListener listener;
    /* access modifiers changed from: private */
    public Context mContext;
    private List<MasterPassengerModel> masterPassengerModelList;

    public class MasterPassengerItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131364313)
        TextView berthAndFood;
        MasterPassengerModel item;
        @BindView(2131363176)
        RelativeLayout passengerLayout;
        @BindView(2131364284)
        TextView psgnAge;
        @BindView(2131364497)
        TextView psgnName;
        @BindView(2131362902)
        CheckBox selectPsgn;
        @BindView(2131364715)
        TextView tv_usertype;
        @BindView(2131364808)
        ImageView verifyIcon;

        public MasterPassengerItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        private void selectMasterPassenger() {
            if (!this.selectPsgn.isChecked()) {
                MasterPassengerViewHolder.setNoOfMasterPsgnSelected(MasterPassengerViewHolder.getNoOfMasterPsgnSelected() - 1);
                this.item.f5338a = false;
                if (MasterPassengerViewHolder.getNoOfMasterPsgnSelected() == 0) {
                    PassengerDetailFragment.a.setTextColor(MasterPassengerViewHolder.this.mContext.getResources().getColor(R.color.colorAccent));
                    PassengerDetailFragment.a.setClickable(false);
                }
            } else if (MasterPassengerViewHolder.getNoOfMasterPsgnSelected() + PassengerDetailFragment.l < PassengerDetailFragment.m) {
                MasterPassengerViewHolder.setNoOfMasterPsgnSelected(MasterPassengerViewHolder.getNoOfMasterPsgnSelected() + 1);
                this.item.f5338a = true;
                PassengerDetailFragment.a.setTextColor(MasterPassengerViewHolder.this.mContext.getResources().getColor(R.color.white));
                PassengerDetailFragment.a.setClickable(true);
            } else {
                this.selectPsgn.setChecked(false);
                if (MasterPassengerViewHolder.this.listener != null) {
                    MasterPassengerViewHolder.this.listener.onMasterPsgnClick();
                }
            }
        }

        @OnClick({2131363176})
        public void paymentOptionClick(View view) {
            try {
                if (!C0535I5.f3638d || !this.item.a.getUserType().equals(C0515Ga.FARE_AVLBLTY)) {
                    if (C0535I5.f3641e && this.item.a.getUserType().equals(C0515Ga.FARE_ONLY)) {
                        this.passengerLayout.setClickable(false);
                        C0535I5.t0(MasterPassengerViewHolder.this.mContext, MasterPassengerViewHolder.this.mContext.getResources().getString(R.string.Passgeger_not_Allow_this_Concession));
                        return;
                    }
                    if (this.selectPsgn.isChecked()) {
                        this.selectPsgn.setChecked(false);
                    } else {
                        this.selectPsgn.setChecked(true);
                    }
                    selectMasterPassenger();
                    return;
                }
                this.passengerLayout.setClickable(false);
                C0535I5.t0(MasterPassengerViewHolder.this.mContext, MasterPassengerViewHolder.this.mContext.getResources().getString(R.string.Passgeger_not_Allow_this_Concession));
            } catch (Exception e) {
                e.getMessage();
            }
        }

        @OnClick({2131362902})
        public void profileIconClick(View view) {
            selectMasterPassenger();
        }
    }

    public class MasterPassengerItemHolder_ViewBinding implements Unbinder {
        private MasterPassengerItemHolder target;
        private View view7f0a0456;
        private View view7f0a0568;

        public MasterPassengerItemHolder_ViewBinding(final MasterPassengerItemHolder masterPassengerItemHolder, View view) {
            this.target = masterPassengerItemHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.master_passenger_layout, "field 'passengerLayout' and method 'paymentOptionClick'");
            masterPassengerItemHolder.passengerLayout = (RelativeLayout) Utils.castView(findRequiredView, R.id.master_passenger_layout, "field 'passengerLayout'", RelativeLayout.class);
            this.view7f0a0568 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    masterPassengerItemHolder.paymentOptionClick(view);
                }
            });
            Class cls = TextView.class;
            masterPassengerItemHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'psgnName'", cls);
            masterPassengerItemHolder.psgnAge = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_age_gender, "field 'psgnAge'", cls);
            masterPassengerItemHolder.berthAndFood = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_berth_pref_food, "field 'berthAndFood'", cls);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_profile_icon, "field 'selectPsgn' and method 'profileIconClick'");
            masterPassengerItemHolder.selectPsgn = (CheckBox) Utils.castView(findRequiredView2, R.id.iv_profile_icon, "field 'selectPsgn'", CheckBox.class);
            this.view7f0a0456 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    masterPassengerItemHolder.profileIconClick(view);
                }
            });
            masterPassengerItemHolder.verifyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.verifyIcon, "field 'verifyIcon'", ImageView.class);
            masterPassengerItemHolder.tv_usertype = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_type, "field 'tv_usertype'", cls);
        }

        public void unbind() {
            MasterPassengerItemHolder masterPassengerItemHolder = this.target;
            if (masterPassengerItemHolder != null) {
                this.target = null;
                masterPassengerItemHolder.passengerLayout = null;
                masterPassengerItemHolder.psgnName = null;
                masterPassengerItemHolder.psgnAge = null;
                masterPassengerItemHolder.berthAndFood = null;
                masterPassengerItemHolder.selectPsgn = null;
                masterPassengerItemHolder.verifyIcon = null;
                masterPassengerItemHolder.tv_usertype = null;
                this.view7f0a0568.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0568 = null;
                this.view7f0a0456.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0456 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface MasterPsgnHolderListener {
        void onMasterPsgnClick();
    }

    public MasterPassengerViewHolder(Context context, List<MasterPassengerModel> list, MasterPsgnHolderListener masterPsgnHolderListener) {
        this.mContext = context;
        this.listener = masterPsgnHolderListener;
        this.masterPassengerModelList = list;
    }

    public static int getNoOfMasterPsgnSelected() {
        return noOfMasterPsgnSelected;
    }

    public static void setNoOfMasterPsgnSelected(int i) {
        noOfMasterPsgnSelected = i;
    }

    public int getItemCount() {
        return this.masterPassengerModelList.size();
    }

    public MasterPassengerItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_master_passenger_list, (ViewGroup) null);
        MasterPassengerItemHolder masterPassengerItemHolder = new MasterPassengerItemHolder(r);
        xx.O(-1, -2, r);
        return masterPassengerItemHolder;
    }

    public void onBindViewHolder(MasterPassengerItemHolder masterPassengerItemHolder, int i) {
        MasterPassengerModel masterPassengerModel = this.masterPassengerModelList.get(i);
        masterPassengerItemHolder.item = masterPassengerModel;
        if (masterPassengerModel.f5338a) {
            masterPassengerItemHolder.selectPsgn.setChecked(true);
            masterPassengerItemHolder.selectPsgn.setEnabled(false);
            masterPassengerItemHolder.passengerLayout.setClickable(false);
        } else {
            masterPassengerItemHolder.selectPsgn.setChecked(false);
            masterPassengerItemHolder.selectPsgn.setEnabled(true);
            masterPassengerItemHolder.passengerLayout.setClickable(true);
        }
        masterPassengerItemHolder.psgnName.setText(masterPassengerModel.a.getName());
        try {
            if (masterPassengerModel.a.getUserType() == null || (!masterPassengerModel.a.getUserType().equals(C0515Ga.FARE_ONLY) && !masterPassengerModel.a.getUserType().equals(C0515Ga.FARE_AVLBLTY))) {
                masterPassengerItemHolder.tv_usertype.setText(masterPassengerModel.a.getSrCtznConc());
            } else {
                xx.t(xx.g(masterPassengerModel.a.getSrCtznConc()));
                masterPassengerItemHolder.tv_usertype.setText(xx.t(xx.g(masterPassengerModel.a.getSrCtznConc())));
            }
        } catch (Exception e) {
            e.getMessage();
            masterPassengerItemHolder.tv_usertype.setText(masterPassengerModel.a.getSrCtznConc());
        }
        TextView textView = masterPassengerItemHolder.psgnAge;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(masterPassengerModel.a.getAge() + " " + this.mContext.getResources().getString(R.string.years)));
        sb.append(", ");
        sb.append(masterPassengerModel.a.getGender());
        textView.setText(sb.toString());
        TextView textView2 = masterPassengerItemHolder.berthAndFood;
        textView2.setText(masterPassengerModel.a.getBerthPreference() + ", " + masterPassengerModel.a.getFoodPreference());
        C1426uk.a aVar = masterPassengerModel.a;
        if (aVar.getVerificationStatusString() == null || aVar.getVerificationStatusString().trim().equals("") || aVar.getVerificationStatusString().trim().equals("Not Applicable")) {
            masterPassengerItemHolder.verifyIcon.setVisibility(8);
            return;
        }
        masterPassengerItemHolder.verifyIcon.setVisibility(0);
        if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("Verified")) {
            masterPassengerItemHolder.verifyIcon.setImageResource(R.drawable.verified);
        } else if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("Not Verified")) {
            masterPassengerItemHolder.verifyIcon.setImageResource(R.drawable.ic_radio);
            masterPassengerItemHolder.verifyIcon.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN));
        } else if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("pending")) {
            masterPassengerItemHolder.verifyIcon.setImageResource(R.drawable.ic_orange_radio);
        } else {
            masterPassengerItemHolder.verifyIcon.setImageResource(R.drawable.ic_white_arrow_right);
        }
    }
}
