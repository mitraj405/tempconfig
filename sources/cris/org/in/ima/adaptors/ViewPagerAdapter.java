package cris.org.in.ima.adaptors;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends C0318rd {
    private final List<Fragment> mFragmentList = new ArrayList();
    private final List<String> mFragmentTitleList = new ArrayList();

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void addFrag(Fragment fragment, String str) {
        this.mFragmentList.add(fragment);
        this.mFragmentTitleList.add(str);
    }

    public int getCount() {
        return this.mFragmentList.size();
    }

    public Fragment getItem(int i) {
        return this.mFragmentList.get(i);
    }

    public CharSequence getPageTitle(int i) {
        return this.mFragmentTitleList.get(i);
    }
}
