package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class AdhaarKYCUpdateFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public AdhaarKYCUpdateFragment f4407a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AdhaarKYCUpdateFragment a;

        public a(AdhaarKYCUpdateFragment adhaarKYCUpdateFragment) {
            this.a = adhaarKYCUpdateFragment;
        }

        public final void doClick(View view) {
            this.a.onOkClick();
        }
    }

    public AdhaarKYCUpdateFragment_ViewBinding(AdhaarKYCUpdateFragment adhaarKYCUpdateFragment, View view) {
        this.f4407a = adhaarKYCUpdateFragment;
        Class cls = TextView.class;
        adhaarKYCUpdateFragment.name = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'name'", cls);
        adhaarKYCUpdateFragment.aadharNo = (TextView) Utils.findRequiredViewAsType(view, R.id.aadhar_no, "field 'aadharNo'", cls);
        adhaarKYCUpdateFragment.user_name_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name_tv, "field 'user_name_tv'", cls);
        adhaarKYCUpdateFragment.user_num_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.user_num_tv, "field 'user_num_tv'", cls);
        adhaarKYCUpdateFragment.gender = (TextView) Utils.findRequiredViewAsType(view, R.id.gender, "field 'gender'", cls);
        adhaarKYCUpdateFragment.dob = (TextView) Utils.findRequiredViewAsType(view, R.id.dob, "field 'dob'", cls);
        adhaarKYCUpdateFragment.address = (TextView) Utils.findRequiredViewAsType(view, R.id.address, "field 'address'", cls);
        adhaarKYCUpdateFragment.colony = (TextView) Utils.findRequiredViewAsType(view, R.id.colony, "field 'colony'", cls);
        adhaarKYCUpdateFragment.district = (TextView) Utils.findRequiredViewAsType(view, R.id.district, "field 'district'", cls);
        adhaarKYCUpdateFragment.state = (TextView) Utils.findRequiredViewAsType(view, R.id.state, "field 'state'", cls);
        adhaarKYCUpdateFragment.pinCode = (TextView) Utils.findRequiredViewAsType(view, R.id.pin_code, "field 'pinCode'", cls);
        adhaarKYCUpdateFragment.status_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.status_msg, "field 'status_msg'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.ok_btn, "method 'onOkClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(adhaarKYCUpdateFragment));
    }

    public final void unbind() {
        AdhaarKYCUpdateFragment adhaarKYCUpdateFragment = this.f4407a;
        if (adhaarKYCUpdateFragment != null) {
            this.f4407a = null;
            adhaarKYCUpdateFragment.name = null;
            adhaarKYCUpdateFragment.aadharNo = null;
            adhaarKYCUpdateFragment.user_name_tv = null;
            adhaarKYCUpdateFragment.user_num_tv = null;
            adhaarKYCUpdateFragment.gender = null;
            adhaarKYCUpdateFragment.dob = null;
            adhaarKYCUpdateFragment.address = null;
            adhaarKYCUpdateFragment.colony = null;
            adhaarKYCUpdateFragment.district = null;
            adhaarKYCUpdateFragment.state = null;
            adhaarKYCUpdateFragment.pinCode = null;
            adhaarKYCUpdateFragment.status_msg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
