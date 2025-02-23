package defpackage;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.a;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
/* renamed from: rd  reason: default package and case insensitive filesystem */
/* compiled from: FragmentPagerAdapter */
public abstract class C0318rd extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public C0318rd(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.getClass();
            this.mCurTransaction = new a(fragmentManager);
        }
        this.mCurTransaction.f(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    fragmentTransaction.e();
                    this.mExecutingFinishUpdate = false;
                } catch (Throwable th) {
                    this.mExecutingFinishUpdate = false;
                    throw th;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.getClass();
            this.mCurTransaction = new a(fragmentManager);
        }
        long itemId = getItemId(i);
        Fragment C = this.mFragmentManager.C(makeFragmentName(viewGroup.getId(), itemId));
        if (C != null) {
            FragmentTransaction fragmentTransaction = this.mCurTransaction;
            fragmentTransaction.getClass();
            fragmentTransaction.b(new FragmentTransaction.a(C, 7));
        } else {
            C = getItem(i);
            this.mCurTransaction.g(viewGroup.getId(), C, makeFragmentName(viewGroup.getId(), itemId), 1);
        }
        if (C != this.mCurrentPrimaryItem) {
            C.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.h(C, Lifecycle.State.STARTED);
            } else {
                C.setUserVisibleHint(false);
            }
        }
        return C;
    }

    public boolean isViewFromObject(View view, Object obj) {
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        FragmentManager fragmentManager = this.mFragmentManager;
                        fragmentManager.getClass();
                        this.mCurTransaction = new a(fragmentManager);
                    }
                    this.mCurTransaction.h(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    FragmentManager fragmentManager2 = this.mFragmentManager;
                    fragmentManager2.getClass();
                    this.mCurTransaction = new a(fragmentManager2);
                }
                this.mCurTransaction.h(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public C0318rd(FragmentManager fragmentManager, int i) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
