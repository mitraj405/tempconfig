package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: BackStackRecord */
public final class a extends FragmentTransaction implements FragmentManager.j, FragmentManager.m {
    public final FragmentManager a;
    public boolean d;
    public int h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(FragmentManager fragmentManager) {
        super(0);
        fragmentManager.H();
        FragmentHostCallback<?> fragmentHostCallback = fragmentManager.f2073a;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.f2066a.getClassLoader();
        }
        this.h = -1;
        this.a = fragmentManager;
    }

    public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.K(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2119a) {
            return true;
        }
        FragmentManager fragmentManager = this.a;
        if (fragmentManager.f2089b == null) {
            fragmentManager.f2089b = new ArrayList<>();
        }
        fragmentManager.f2089b.add(this);
        return true;
    }

    public final int c() {
        return j(false);
    }

    public final int d() {
        return j(true);
    }

    public final void e() {
        if (!this.f2119a) {
            this.f2122b = false;
            this.a.x(this, true);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final void f(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.a) {
            super.f(fragment);
            return;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final void g(int i, Fragment fragment, String str, int i2) {
        super.g(i, fragment, str, i2);
        fragment.mFragmentManager = this.a;
    }

    public final String getName() {
        return this.f2117a;
    }

    public final void h(Fragment fragment, Lifecycle.State state) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        FragmentManager fragmentManager2 = this.a;
        if (fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + fragmentManager2);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            super.h(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public final void i(int i) {
        if (this.f2119a) {
            if (FragmentManager.K(2)) {
                toString();
            }
            ArrayList<FragmentTransaction.a> arrayList = this.f2118a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.a aVar = arrayList.get(i2);
                Fragment fragment = aVar.f2125a;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.K(2)) {
                        Objects.toString(aVar.f2125a);
                        int i3 = aVar.f2125a.mBackStackNesting;
                    }
                }
            }
        }
    }

    public final int j(boolean z) {
        if (!this.d) {
            if (FragmentManager.K(2)) {
                toString();
                PrintWriter printWriter = new PrintWriter(new C0396xi());
                k("  ", printWriter, true);
                printWriter.close();
            }
            this.d = true;
            boolean z2 = this.f2119a;
            FragmentManager fragmentManager = this.a;
            if (z2) {
                this.h = fragmentManager.f2086a.getAndIncrement();
            } else {
                this.h = -1;
            }
            fragmentManager.u(this, z);
            return this.h;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void k(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2117a);
            printWriter.print(" mIndex=");
            printWriter.print(this.h);
            printWriter.print(" mCommitted=");
            printWriter.println(this.d);
            if (this.e != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.e));
            }
            if (!(this.a == 0 && this.b == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.a));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.b));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.f == 0 && this.f2116a == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2116a);
            }
            if (!(this.g == 0 && this.f2120b == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2120b);
            }
        }
        ArrayList<FragmentTransaction.a> arrayList = this.f2118a;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.a aVar = arrayList.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2125a);
                if (z) {
                    if (!(aVar.b == 0 && aVar.c == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.b));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.c));
                    }
                    if (aVar.d != 0 || aVar.e != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.d));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.e));
                    }
                }
            }
        }
    }

    public final void l() {
        ArrayList<FragmentTransaction.a> arrayList = this.f2118a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.a aVar = arrayList.get(i);
            Fragment fragment = aVar.f2125a;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.e);
                fragment.setSharedElementNames(this.f2121b, this.f2123c);
            }
            int i2 = aVar.a;
            FragmentManager fragmentManager = this.a;
            switch (i2) {
                case 1:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, false);
                    fragmentManager.a(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.U(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.getClass();
                    if (FragmentManager.K(2)) {
                        Objects.toString(fragment);
                    }
                    if (fragment.mHidden) {
                        break;
                    } else {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        fragmentManager.c0(fragment);
                        break;
                    }
                case 5:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, false);
                    if (FragmentManager.K(2)) {
                        Objects.toString(fragment);
                    }
                    if (!fragment.mHidden) {
                        break;
                    } else {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                case 6:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.g(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, false);
                    fragmentManager.c(fragment);
                    break;
                case 8:
                    fragmentManager.b0(fragment);
                    break;
                case 9:
                    fragmentManager.b0((Fragment) null);
                    break;
                case 10:
                    fragmentManager.a0(fragment, aVar.f2127b);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
            }
        }
    }

    public final void m() {
        ArrayList<FragmentTransaction.a> arrayList = this.f2118a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = arrayList.get(size);
            Fragment fragment = aVar.f2125a;
            if (fragment != null) {
                fragment.setPopDirection(true);
                int i = this.e;
                int i2 = 8194;
                if (i != 4097) {
                    if (i == 4099) {
                        i2 = 4099;
                    } else if (i != 8194) {
                        i2 = 0;
                    } else {
                        i2 = 4097;
                    }
                }
                fragment.setNextTransition(i2);
                fragment.setSharedElementNames(this.f2123c, this.f2121b);
            }
            int i3 = aVar.a;
            FragmentManager fragmentManager = this.a;
            switch (i3) {
                case 1:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, true);
                    fragmentManager.U(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.a(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.getClass();
                    if (FragmentManager.K(2)) {
                        Objects.toString(fragment);
                    }
                    if (!fragment.mHidden) {
                        break;
                    } else {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                case 5:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, true);
                    if (FragmentManager.K(2)) {
                        Objects.toString(fragment);
                    }
                    if (fragment.mHidden) {
                        break;
                    } else {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        fragmentManager.c0(fragment);
                        break;
                    }
                case 6:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.c(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.b, aVar.c, aVar.d, aVar.e);
                    fragmentManager.Z(fragment, true);
                    fragmentManager.g(fragment);
                    break;
                case 8:
                    fragmentManager.b0((Fragment) null);
                    break;
                case 9:
                    fragmentManager.b0(fragment);
                    break;
                case 10:
                    fragmentManager.a0(fragment, aVar.f2126a);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
            }
        }
    }

    public final void n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.a) {
            b(new FragmentTransaction.a(fragment, 3));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.h >= 0) {
            sb.append(" #");
            sb.append(this.h);
        }
        if (this.f2117a != null) {
            sb.append(" ");
            sb.append(this.f2117a);
        }
        sb.append("}");
        return sb.toString();
    }
}
