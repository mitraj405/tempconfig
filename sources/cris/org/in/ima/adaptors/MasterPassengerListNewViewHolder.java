package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.model.MasterPassengerModel;
import cris.org.in.prs.ima.R;
import defpackage.C1426uk;
import java.util.ArrayList;

public class MasterPassengerListNewViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(MasterPassengerListNewViewHolder.class);
    MasterPassengerListNewViewHolderListener listNewViewHolderListener;
    private Context mContext;
    private ArrayList<MasterPassengerModel> masterPassengerModels;

    public interface MasterPassengerListNewViewHolderListener {
        void onEditClick(MasterPassengerModel masterPassengerModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362137)
        LinearLayout card_type_ll;
        @BindView(2131362370)
        TextView dateOfBirth;
        @BindView(2131362482)
        TextView editPsgnDetail;
        @BindView(2131362812)
        TextView idVerifyDetails;
        MasterPassengerModel itemPassengerDetail;
        @BindView(2131363247)
        TextView psgnDeatils;
        @BindView(2131363251)
        TextView psgnName;
        @BindView(2131364328)
        TextView tv_card_number;
        @BindView(2131364717)
        TextView tv_valid_date;
        @BindView(2131364805)
        LinearLayout valid_date_ll;
        @BindView(2131364718)
        TextView verifyStatus;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362482})
        public void onEditClick(View view) {
            MasterPassengerListNewViewHolderListener masterPassengerListNewViewHolderListener = MasterPassengerListNewViewHolder.this.listNewViewHolderListener;
            if (masterPassengerListNewViewHolderListener != null) {
                masterPassengerListNewViewHolderListener.onEditClick(this.itemPassengerDetail);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a02b2;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.psgnDeatils = (TextView) Utils.findRequiredViewAsType(view, R.id.mp_details, "field 'psgnDeatils'", cls);
            viewHolder.idVerifyDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.id_verify_details, "field 'idVerifyDetails'", cls);
            viewHolder.psgnName = (TextView) Utils.findRequiredViewAsType(view, R.id.mp_name, "field 'psgnName'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.edit_psgn, "field 'editPsgnDetail' and method 'onEditClick'");
            viewHolder.editPsgnDetail = (TextView) Utils.castView(findRequiredView, R.id.edit_psgn, "field 'editPsgnDetail'", cls);
            this.view7f0a02b2 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onEditClick(view);
                }
            });
            viewHolder.verifyStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_verified_psgn, "field 'verifyStatus'", cls);
            viewHolder.dateOfBirth = (TextView) Utils.findRequiredViewAsType(view, R.id.date_of_birth, "field 'dateOfBirth'", cls);
            viewHolder.tv_card_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_card_number, "field 'tv_card_number'", cls);
            viewHolder.tv_valid_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_valid_date, "field 'tv_valid_date'", cls);
            Class cls2 = LinearLayout.class;
            viewHolder.card_type_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.card_type_ll, "field 'card_type_ll'", cls2);
            viewHolder.valid_date_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.valid_date_ll, "field 'valid_date_ll'", cls2);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.psgnDeatils = null;
                viewHolder.idVerifyDetails = null;
                viewHolder.psgnName = null;
                viewHolder.editPsgnDetail = null;
                viewHolder.verifyStatus = null;
                viewHolder.dateOfBirth = null;
                viewHolder.tv_card_number = null;
                viewHolder.tv_valid_date = null;
                viewHolder.card_type_ll = null;
                viewHolder.valid_date_ll = null;
                this.view7f0a02b2.setOnClickListener((View.OnClickListener) null);
                this.view7f0a02b2 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MasterPassengerListNewViewHolder(Context context, ArrayList<MasterPassengerModel> arrayList, MasterPassengerListNewViewHolderListener masterPassengerListNewViewHolderListener) {
        this.mContext = context;
        this.masterPassengerModels = arrayList;
        this.listNewViewHolderListener = masterPassengerListNewViewHolderListener;
    }

    public int getItemCount() {
        ArrayList<MasterPassengerModel> arrayList = this.masterPassengerModels;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_master_passenger_new, (ViewGroup) null);
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        String str2;
        String str3;
        C1426uk.a aVar = this.masterPassengerModels.get(i).a;
        viewHolder.itemPassengerDetail = this.masterPassengerModels.get(i);
        viewHolder.psgnName.setText(aVar.getMasterPassengerName());
        viewHolder.editPsgnDetail.setTag(Integer.valueOf(i));
        viewHolder.dateOfBirth.setText(C0535I5.j(aVar.getDateOfBirth()));
        if (aVar.getUserType() == null || (!aVar.getUserType().equals(C0515Ga.FARE_ONLY) && !aVar.getUserType().equals(C0515Ga.FARE_AVLBLTY))) {
            viewHolder.card_type_ll.setVisibility(8);
            viewHolder.valid_date_ll.setVisibility(8);
        } else {
            viewHolder.card_type_ll.setVisibility(0);
            viewHolder.valid_date_ll.setVisibility(0);
            if (aVar.getRailwayIsuedCardNo() != null) {
                viewHolder.tv_card_number.setText(aVar.getRailwayIsuedCardNo());
            }
            if (aVar.getDateValid() != null) {
                viewHolder.tv_valid_date.setText(C0535I5.j(aVar.getDateValid()));
            }
        }
        String valueOf = String.valueOf(aVar.getAge());
        if (valueOf != null) {
            StringBuilder n = lf.n(valueOf, " ");
            n.append(this.mContext.getString(R.string.yrs));
            valueOf = n.toString();
        }
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            str = aVar.getGender().trim().equals("M") ? "एम" : "एफ";
        } else {
            str = aVar.getGender().trim();
        }
        StringBuilder J = xx.J(valueOf);
        if (valueOf != null) {
            J.append(", ");
        }
        J.append(str);
        String sb = J.toString();
        if (aVar.getBerthPreference() != null && !aVar.getBerthPreference().equals("")) {
            String trim = aVar.getBerthPreference().trim();
            StringBuilder J2 = xx.J(sb);
            if (sb != null) {
                J2.append(", ");
            }
            J2.append(trim);
            sb = J2.toString();
        }
        if (aVar.getSrCtznConc() != null && !aVar.getSrCtznConc().equals("")) {
            aVar.getSrCtznConc();
            int g = xx.g(aVar.getSrCtznConc());
            if (g != 0) {
                str3 = xx.t(g);
            } else {
                str3 = aVar.getSrCtznConc();
            }
            StringBuilder J3 = xx.J(sb);
            if (sb != null) {
                J3.append(", ");
            }
            J3.append(str3);
            sb = J3.toString();
        }
        if (aVar.getFoodPreference() != null && !aVar.getFoodPreference().equals("")) {
            String foodPreference = aVar.getFoodPreference();
            if (sb == null) {
                sb = C1058d.z(sb, foodPreference);
            } else {
                sb = xx.D(sb, ", ", foodPreference);
            }
        }
        if (aVar.getIdCardType() == null || aVar.getIdCardNumber() == null || aVar.getIdCardType().trim().equals("")) {
            viewHolder.verifyStatus.setVisibility(8);
            str2 = null;
        } else {
            String str4 = K9.a(aVar.getIdCardType().trim()).f3678c;
            String trim2 = aVar.getIdCardNumber().trim();
            if (str4.equalsIgnoreCase("Aadhaar ID/Virtual ID")) {
                StringBuilder n2 = lf.n(str4, " | (");
                n2.append(C0535I5.c0(trim2));
                n2.append(")");
                str2 = n2.toString();
            } else {
                str2 = str4 + " | (" + trim2 + ")";
            }
            if (aVar.getVerificationStatusString() == null || aVar.getVerificationStatusString().trim().equals("") || aVar.getVerificationStatusString().trim().equals("Not Applicable")) {
                viewHolder.verifyStatus.setVisibility(8);
            } else {
                viewHolder.verifyStatus.setVisibility(0);
                viewHolder.verifyStatus.setText(" " + aVar.getVerificationStatusString().trim());
                if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("Verified")) {
                    viewHolder.verifyStatus.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.verified, 0);
                } else if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("Not Verified")) {
                    viewHolder.verifyStatus.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_radio, 0);
                    for (Drawable drawable : viewHolder.verifyStatus.getCompoundDrawables()) {
                        if (drawable != null) {
                            drawable.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN));
                        }
                    }
                } else if (aVar.getVerificationStatusString().trim().equalsIgnoreCase("pending")) {
                    viewHolder.verifyStatus.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_orange_radio, 0);
                } else {
                    viewHolder.verifyStatus.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_white_arrow_right, 0);
                }
            }
        }
        viewHolder.psgnDeatils.setText(sb);
        if (str2 != null) {
            viewHolder.idVerifyDetails.setVisibility(0);
            viewHolder.idVerifyDetails.setText(str2);
            return;
        }
        viewHolder.idVerifyDetails.setVisibility(8);
    }
}
