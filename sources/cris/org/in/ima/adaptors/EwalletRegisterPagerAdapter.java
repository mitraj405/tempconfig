package cris.org.in.ima.adaptors;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cris.org.in.ima.fragment.AadharRegistraionFragment;
import cris.org.in.ima.fragment.PanRegistrationFragment;
import cris.prs.webservices.dto.EwalletProfileDTO;

public class EwalletRegisterPagerAdapter extends C0318rd {
    private static final int AADHAR_REGISTER = 1;
    private static final int NUMBER_OF_TABS = 2;
    private static final int PAN_REGISTER = 0;
    private static final String TAG = C1354qp.R(EwalletRegisterPagerAdapter.class);
    private EwalletProfileDTO ewalletProfileDTO;

    public EwalletRegisterPagerAdapter(FragmentManager fragmentManager, EwalletProfileDTO ewalletProfileDTO2) {
        super(fragmentManager);
        this.ewalletProfileDTO = ewalletProfileDTO2;
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int i) {
        Fragment fragment;
        Bundle bundle = new Bundle();
        if (i == 0) {
            fragment = new PanRegistrationFragment();
        } else if (i != 1) {
            fragment = null;
        } else {
            fragment = new AadharRegistraionFragment();
        }
        if (fragment != null) {
            bundle.putSerializable("ewallet", this.ewalletProfileDTO);
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
