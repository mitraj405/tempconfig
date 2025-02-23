package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class MyProfileFragment_ViewBinding implements Unbinder {
    public MyProfileFragment a;

    public MyProfileFragment_ViewBinding(MyProfileFragment myProfileFragment, View view) {
        this.a = myProfileFragment;
        Class cls = TextView.class;
        myProfileFragment.fullName = (TextView) Utils.findRequiredViewAsType(view, R.id.et_full_name, "field 'fullName'", cls);
        myProfileFragment.userName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_username, "field 'userName'", cls);
        myProfileFragment.dob = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dob, "field 'dob'", cls);
        myProfileFragment.gender = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gender, "field 'gender'", cls);
        myProfileFragment.ocupation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ocupation, "field 'ocupation'", cls);
        myProfileFragment.email = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_email, "field 'email'", cls);
        myProfileFragment.mobile = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mobile, "field 'mobile'", cls);
        myProfileFragment.address = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_address, "field 'address'", cls);
        myProfileFragment.country = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_country, "field 'country'", cls);
        myProfileFragment.myprofile_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.myprofile_ads, "field 'myprofile_ads'", AdManagerAdView.class);
    }

    public final void unbind() {
        MyProfileFragment myProfileFragment = this.a;
        if (myProfileFragment != null) {
            this.a = null;
            myProfileFragment.fullName = null;
            myProfileFragment.userName = null;
            myProfileFragment.dob = null;
            myProfileFragment.gender = null;
            myProfileFragment.ocupation = null;
            myProfileFragment.email = null;
            myProfileFragment.mobile = null;
            myProfileFragment.address = null;
            myProfileFragment.country = null;
            myProfileFragment.myprofile_ads = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
