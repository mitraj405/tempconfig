package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* renamed from: Su  reason: default package */
/* compiled from: SavedCardPagerAdapter */
public final class Su extends C0318rd {
    public final List<Fragment> a;

    public Su(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Fragment getItem(int i) {
        return this.a.get(i);
    }

    public final float getPageWidth(int i) {
        List<Fragment> list = this.a;
        if (list == null || list.size() != 1) {
            return 0.93f;
        }
        return 1.0f;
    }
}
