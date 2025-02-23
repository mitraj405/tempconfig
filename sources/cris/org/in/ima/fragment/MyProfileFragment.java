package cris.org.in.ima.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;

public class MyProfileFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public C0561KB a;
    @BindView(2131364282)
    TextView address;
    @BindView(2131364355)
    TextView country;
    @BindView(2131364377)
    TextView dob;
    @BindView(2131364392)
    TextView email;
    @BindView(2131362535)
    TextView fullName;
    @BindView(2131364427)
    TextView gender;
    @BindView(2131364488)
    TextView mobile;
    @BindView(2131363293)
    AdManagerAdView myprofile_ads;
    @BindView(2131364514)
    TextView ocupation;
    @BindView(2131364716)
    TextView userName;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle();
            MyProfileFragment myProfileFragment = MyProfileFragment.this;
            bundle.putSerializable("updateProfile", myProfileFragment.a);
            int i = MyProfileFragment.c;
            myProfileFragment.a.toString();
            UpdateProfileFragment updateProfileFragment = new UpdateProfileFragment();
            updateProfileFragment.setArguments(bundle);
            HomeActivity.n((AppCompatActivity) myProfileFragment.getActivity(), updateProfileFragment, C1218kf.UPDATE_PROFILE.a(), Boolean.TRUE, Boolean.FALSE);
        }
    }

    static {
        C1354qp.R(MyProfileFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.I();
        HomeActivity.o();
        HomeActivity.f4191e.setText(getString(R.string.edit));
        HomeActivity.f4191e.setOnClickListener(new a());
        C0561KB kb = (C0561KB) getArguments().getSerializable("updateProfile");
        this.a = kb;
        if (kb != null) {
            this.userName.setText(kb.getUserProfiles().getUser_loginid());
            if (this.a.getUserProfiles().getDate_of_birth() != null) {
                this.dob.setText(C0535I5.c(this.a.getUserProfiles().getDate_of_birth()));
            }
            if (this.a.getUserProfiles().getGender() != null && this.a.getUserProfiles().getGender().equals("M")) {
                this.gender.setText(getString(R.string.male));
            } else if (this.a.getUserProfiles().getGender() != null && this.a.getUserProfiles().getGender().equals("F")) {
                this.gender.setText(getString(R.string.female));
            } else if (this.a.getUserProfiles().getGender() != null && this.a.getUserProfiles().getGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                this.gender.setText(getString(R.string.transgender));
            }
            this.fullName.setText(this.a.getUserProfiles().getName());
            this.email.setText(this.a.getUserProfiles().getEmail());
            this.mobile.setText("+" + this.a.getUserProfiles().getIsd_code() + "-" + this.a.getUserProfiles().getMaskedMobileNo());
            if (this.a.getUserProfiles().getCountry_id().intValue() == 94) {
                this.country.setText("India");
            }
            String str4 = "";
            if (this.a.getUserProfiles().getAddress1() != null) {
                str = this.a.getUserProfiles().getAddress1() + ", ";
            } else {
                str = str4;
            }
            StringBuilder J = xx.J(str);
            if (this.a.getUserProfiles().getAddress2() != null) {
                str2 = this.a.getUserProfiles().getAddress2() + ", ";
            } else {
                str2 = str4;
            }
            J.append(str2);
            StringBuilder J2 = xx.J(J.toString());
            if (this.a.getUserProfiles().getCity() != null) {
                str3 = this.a.getUserProfiles().getCity() + ", ";
            } else {
                str3 = str4;
            }
            J2.append(str3);
            StringBuilder J3 = xx.J(J2.toString());
            if (this.a.getUserProfiles().getState_name() != null) {
                str4 = this.a.getUserProfiles().getState_name() + ", ";
            }
            J3.append(str4);
            this.address.setText(J3.toString());
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.myprofile_ads, googleAdParamDTO);
        HomeActivity.J();
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.I();
        HomeActivity.o();
    }

    public final void onStart() {
        super.onStart();
        HomeActivity.I();
        HomeActivity.o();
    }
}
