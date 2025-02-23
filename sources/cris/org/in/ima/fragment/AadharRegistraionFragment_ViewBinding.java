package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class AadharRegistraionFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public AadharRegistraionFragment f4396a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AadharRegistraionFragment a;

        public a(AadharRegistraionFragment aadharRegistraionFragment) {
            this.a = aadharRegistraionFragment;
        }

        public final void doClick(View view) {
            this.a.onSearchClick();
        }
    }

    public AadharRegistraionFragment_ViewBinding(AadharRegistraionFragment aadharRegistraionFragment, View view) {
        this.f4396a = aadharRegistraionFragment;
        Class cls = EditText.class;
        aadharRegistraionFragment.aadhaarNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_aadhar_number, "field 'aadhaarNumber'", cls);
        aadharRegistraionFragment.aadhaarName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_aadhar_name, "field 'aadhaarName'", cls);
        aadharRegistraionFragment.otp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_opt, "field 'otp'", cls);
        Class cls2 = TextView.class;
        aadharRegistraionFragment.status = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_status, "field 'status'", cls2);
        aadharRegistraionFragment.genderUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gender_uid, "field 'genderUid'", cls2);
        aadharRegistraionFragment.addressUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_address_uid, "field 'addressUid'", cls2);
        aadharRegistraionFragment.dobUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dob_uid, "field 'dobUid'", cls2);
        aadharRegistraionFragment.pinUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_uid, "field 'pinUid'", cls2);
        aadharRegistraionFragment.districtUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_District_uid, "field 'districtUid'", cls2);
        aadharRegistraionFragment.colonyUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_colony_uid, "field 'colonyUid'", cls2);
        aadharRegistraionFragment.stateUid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_state_uid, "field 'stateUid'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_save, "field 'sendOTP' and method 'onSearchClick'");
        aadharRegistraionFragment.sendOTP = (TextView) Utils.castView(findRequiredView, R.id.tv_save, "field 'sendOTP'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(aadharRegistraionFragment));
        aadharRegistraionFragment.uidNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_uid_number, "field 'uidNumber'", cls2);
        aadharRegistraionFragment.tAndcKYC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.select_tandc_kyc, "field 'tAndcKYC'", CheckBox.class);
        Class cls3 = LinearLayout.class;
        aadharRegistraionFragment.otpLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_opt_layout, "field 'otpLayout'", cls3);
        aadharRegistraionFragment.detailsLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_uid_layout, "field 'detailsLayout'", cls3);
        aadharRegistraionFragment.uidDisplay = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_uid_display, "field 'uidDisplay'", cls3);
        aadharRegistraionFragment.aadharLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_aadhaar_layout, "field 'aadharLayout'", cls3);
        aadharRegistraionFragment.tAndckycLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_select_kyc, "field 'tAndckycLayout'", cls3);
        aadharRegistraionFragment.botAdLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.bot_ad_layout, "field 'botAdLayout'", cls3);
    }

    public final void unbind() {
        AadharRegistraionFragment aadharRegistraionFragment = this.f4396a;
        if (aadharRegistraionFragment != null) {
            this.f4396a = null;
            aadharRegistraionFragment.aadhaarNumber = null;
            aadharRegistraionFragment.aadhaarName = null;
            aadharRegistraionFragment.otp = null;
            aadharRegistraionFragment.status = null;
            aadharRegistraionFragment.genderUid = null;
            aadharRegistraionFragment.addressUid = null;
            aadharRegistraionFragment.dobUid = null;
            aadharRegistraionFragment.pinUid = null;
            aadharRegistraionFragment.districtUid = null;
            aadharRegistraionFragment.colonyUid = null;
            aadharRegistraionFragment.stateUid = null;
            aadharRegistraionFragment.sendOTP = null;
            aadharRegistraionFragment.uidNumber = null;
            aadharRegistraionFragment.tAndcKYC = null;
            aadharRegistraionFragment.otpLayout = null;
            aadharRegistraionFragment.detailsLayout = null;
            aadharRegistraionFragment.uidDisplay = null;
            aadharRegistraionFragment.aadharLayout = null;
            aadharRegistraionFragment.tAndckycLayout = null;
            aadharRegistraionFragment.botAdLayout = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
