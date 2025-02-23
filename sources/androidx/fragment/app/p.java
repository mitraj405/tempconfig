package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.f;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: FragmentStateManager */
public final class p {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final Fragment f2158a;

    /* renamed from: a  reason: collision with other field name */
    public final n f2159a;

    /* renamed from: a  reason: collision with other field name */
    public final q f2160a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2161a = false;

    public p(n nVar, q qVar, Fragment fragment) {
        this.f2159a = nVar;
        this.f2160a = qVar;
        this.f2158a = fragment;
    }

    public final void a() {
        View view;
        View view2;
        q qVar = this.f2160a;
        qVar.getClass();
        Fragment fragment = this.f2158a;
        ViewGroup viewGroup = fragment.mContainer;
        int i = -1;
        if (viewGroup != null) {
            ArrayList<Fragment> arrayList = qVar.f2162a;
            int indexOf = arrayList.indexOf(fragment);
            int i2 = indexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = arrayList.get(indexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = arrayList.get(i2);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, i);
    }

    public final void b() {
        boolean K = FragmentManager.K(3);
        Fragment fragment = this.f2158a;
        if (K) {
            Objects.toString(fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        p pVar = null;
        q qVar = this.f2160a;
        if (fragment2 != null) {
            p pVar2 = qVar.f2163a.get(fragment2.mWho);
            if (pVar2 != null) {
                fragment.mTargetWho = fragment.mTarget.mWho;
                fragment.mTarget = null;
                pVar = pVar2;
            } else {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (pVar = qVar.f2163a.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(C0709Uj.j(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (pVar != null) {
            pVar.j();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.f2073a;
        fragment.mParentFragment = fragmentManager.f2071a;
        n nVar = this.f2159a;
        nVar.g(fragment, false);
        fragment.performAttach();
        nVar.b(fragment, false);
    }

    /* JADX WARNING: type inference failed for: r2v16, types: [androidx.fragment.app.s$d$b] */
    /* JADX WARNING: type inference failed for: r10v4, types: [androidx.fragment.app.s$d$b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c() {
        /*
            r13 = this;
            androidx.fragment.app.Fragment r0 = r13.f2158a
            androidx.fragment.app.FragmentManager r1 = r0.mFragmentManager
            if (r1 != 0) goto L_0x0009
            int r0 = r0.mState
            return r0
        L_0x0009:
            int r1 = r13.a
            androidx.lifecycle.Lifecycle$State r2 = r0.mMaxState
            int r2 = r2.ordinal()
            r3 = -1
            r4 = 5
            r5 = 3
            r6 = 4
            r7 = 2
            r8 = 1
            if (r2 == r8) goto L_0x002e
            if (r2 == r7) goto L_0x0029
            if (r2 == r5) goto L_0x0024
            if (r2 == r6) goto L_0x0033
            int r1 = java.lang.Math.min(r1, r3)
            goto L_0x0033
        L_0x0024:
            int r1 = java.lang.Math.min(r1, r4)
            goto L_0x0033
        L_0x0029:
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x0033
        L_0x002e:
            r2 = 0
            int r1 = java.lang.Math.min(r1, r2)
        L_0x0033:
            boolean r2 = r0.mFromLayout
            if (r2 == 0) goto L_0x005f
            boolean r2 = r0.mInLayout
            if (r2 == 0) goto L_0x0050
            int r1 = r13.a
            int r1 = java.lang.Math.max(r1, r7)
            android.view.View r2 = r0.mView
            if (r2 == 0) goto L_0x005f
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x005f
            int r1 = java.lang.Math.min(r1, r7)
            goto L_0x005f
        L_0x0050:
            int r2 = r13.a
            if (r2 >= r6) goto L_0x005b
            int r2 = r0.mState
            int r1 = java.lang.Math.min(r1, r2)
            goto L_0x005f
        L_0x005b:
            int r1 = java.lang.Math.min(r1, r8)
        L_0x005f:
            boolean r2 = r0.mAdded
            if (r2 != 0) goto L_0x0067
            int r1 = java.lang.Math.min(r1, r8)
        L_0x0067:
            android.view.ViewGroup r2 = r0.mContainer
            r9 = 0
            if (r2 == 0) goto L_0x00ad
            androidx.fragment.app.FragmentManager r10 = r0.getParentFragmentManager()
            androidx.fragment.app.s r2 = androidx.fragment.app.s.g(r2, r10)
            r2.getClass()
            androidx.fragment.app.s$d r10 = r2.d(r0)
            if (r10 == 0) goto L_0x0080
            androidx.fragment.app.s$d$b r10 = r10.f2170a
            goto L_0x0081
        L_0x0080:
            r10 = r9
        L_0x0081:
            java.util.ArrayList<androidx.fragment.app.s$d> r2 = r2.b
            java.util.Iterator r2 = r2.iterator()
        L_0x0087:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x00a0
            java.lang.Object r11 = r2.next()
            androidx.fragment.app.s$d r11 = (androidx.fragment.app.s.d) r11
            androidx.fragment.app.Fragment r12 = r11.a
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x0087
            boolean r12 = r11.f2174a
            if (r12 != 0) goto L_0x0087
            r9 = r11
        L_0x00a0:
            if (r9 == 0) goto L_0x00ac
            if (r10 == 0) goto L_0x00a8
            androidx.fragment.app.s$d$b r2 = androidx.fragment.app.s.d.b.NONE
            if (r10 != r2) goto L_0x00ac
        L_0x00a8:
            androidx.fragment.app.s$d$b r2 = r9.f2170a
            r9 = r2
            goto L_0x00ad
        L_0x00ac:
            r9 = r10
        L_0x00ad:
            androidx.fragment.app.s$d$b r2 = androidx.fragment.app.s.d.b.ADDING
            if (r9 != r2) goto L_0x00b7
            r2 = 6
            int r1 = java.lang.Math.min(r1, r2)
            goto L_0x00d3
        L_0x00b7:
            androidx.fragment.app.s$d$b r2 = androidx.fragment.app.s.d.b.REMOVING
            if (r9 != r2) goto L_0x00c0
            int r1 = java.lang.Math.max(r1, r5)
            goto L_0x00d3
        L_0x00c0:
            boolean r2 = r0.mRemoving
            if (r2 == 0) goto L_0x00d3
            boolean r2 = r0.isInBackStack()
            if (r2 == 0) goto L_0x00cf
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00d3
        L_0x00cf:
            int r1 = java.lang.Math.min(r1, r3)
        L_0x00d3:
            boolean r2 = r0.mDeferStart
            if (r2 == 0) goto L_0x00df
            int r2 = r0.mState
            if (r2 >= r4) goto L_0x00df
            int r1 = java.lang.Math.min(r1, r6)
        L_0x00df:
            boolean r2 = androidx.fragment.app.FragmentManager.K(r7)
            if (r2 == 0) goto L_0x00e8
            java.util.Objects.toString(r0)
        L_0x00e8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.c():int");
    }

    public final void d() {
        boolean K = FragmentManager.K(3);
        Fragment fragment = this.f2158a;
        if (K) {
            Objects.toString(fragment);
        }
        if (!fragment.mIsCreated) {
            Bundle bundle = fragment.mSavedFragmentState;
            n nVar = this.f2159a;
            nVar.h(fragment, bundle, false);
            fragment.performCreate(fragment.mSavedFragmentState);
            nVar.c(fragment, fragment.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        fragment.mState = 1;
    }

    public final void e() {
        String str;
        Fragment fragment = this.f2158a;
        if (!fragment.mFromLayout) {
            if (FragmentManager.K(3)) {
                Objects.toString(fragment);
            }
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = fragment.mContainer;
            if (viewGroup == null) {
                int i = fragment.mContainerId;
                if (i == 0) {
                    viewGroup = null;
                } else if (i != -1) {
                    viewGroup = (ViewGroup) fragment.mFragmentManager.f2072a.b(i);
                    if (viewGroup == null && !fragment.mRestored) {
                        try {
                            str = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                    }
                } else {
                    throw new IllegalArgumentException(xx.C("Cannot create fragment ", fragment, " for a container view with no id"));
                }
            }
            fragment.mContainer = viewGroup;
            fragment.performCreateView(performGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(Lr.fragment_container_view_tag, fragment);
                if (viewGroup != null) {
                    a();
                }
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                View view2 = fragment.mView;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                if (view2.isAttachedToWindow()) {
                    f.c.c(fragment.mView);
                } else {
                    View view3 = fragment.mView;
                    view3.addOnAttachStateChangeListener(new a(view3));
                }
                fragment.performViewCreated();
                this.f2159a.m(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                int visibility = fragment.mView.getVisibility();
                fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
                if (fragment.mContainer != null && visibility == 0) {
                    View findFocus = fragment.mView.findFocus();
                    if (findFocus != null) {
                        fragment.setFocusedView(findFocus);
                        if (FragmentManager.K(2)) {
                            findFocus.toString();
                            Objects.toString(fragment);
                        }
                    }
                    fragment.mView.setAlpha(0.0f);
                }
            }
            fragment.mState = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r9 = this;
            r0 = 3
            boolean r1 = androidx.fragment.app.FragmentManager.K(r0)
            androidx.fragment.app.Fragment r2 = r9.f2158a
            if (r1 == 0) goto L_0x000c
            java.util.Objects.toString(r2)
        L_0x000c:
            boolean r1 = r2.mRemoving
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001a
            boolean r1 = r2.isInBackStack()
            if (r1 != 0) goto L_0x001a
            r1 = r3
            goto L_0x001b
        L_0x001a:
            r1 = r4
        L_0x001b:
            androidx.fragment.app.q r5 = r9.f2160a
            if (r1 != 0) goto L_0x0038
            androidx.fragment.app.o r6 = r5.a
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r7 = r6.b
            java.lang.String r8 = r2.mWho
            boolean r7 = r7.containsKey(r8)
            if (r7 != 0) goto L_0x002d
        L_0x002b:
            r6 = r3
            goto L_0x0033
        L_0x002d:
            boolean r7 = r6.f2155b
            if (r7 == 0) goto L_0x002b
            boolean r6 = r6.f2156c
        L_0x0033:
            if (r6 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r6 = r4
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            if (r6 == 0) goto L_0x00cb
            androidx.fragment.app.FragmentHostCallback<?> r6 = r2.mHost
            boolean r7 = r6 instanceof defpackage.AC
            if (r7 == 0) goto L_0x0046
            androidx.fragment.app.o r3 = r5.a
            boolean r3 = r3.f2156c
            goto L_0x0053
        L_0x0046:
            android.content.Context r6 = r6.f2066a
            boolean r7 = r6 instanceof android.app.Activity
            if (r7 == 0) goto L_0x0053
            android.app.Activity r6 = (android.app.Activity) r6
            boolean r6 = r6.isChangingConfigurations()
            r3 = r3 ^ r6
        L_0x0053:
            if (r1 != 0) goto L_0x0057
            if (r3 == 0) goto L_0x008d
        L_0x0057:
            androidx.fragment.app.o r1 = r5.a
            r1.getClass()
            boolean r0 = androidx.fragment.app.FragmentManager.K(r0)
            if (r0 == 0) goto L_0x0065
            java.util.Objects.toString(r2)
        L_0x0065:
            java.util.HashMap<java.lang.String, androidx.fragment.app.o> r0 = r1.c
            java.lang.String r3 = r2.mWho
            java.lang.Object r3 = r0.get(r3)
            androidx.fragment.app.o r3 = (androidx.fragment.app.o) r3
            if (r3 == 0) goto L_0x0079
            r3.b()
            java.lang.String r3 = r2.mWho
            r0.remove(r3)
        L_0x0079:
            java.util.HashMap<java.lang.String, androidx.lifecycle.ViewModelStore> r0 = r1.d
            java.lang.String r1 = r2.mWho
            java.lang.Object r1 = r0.get(r1)
            androidx.lifecycle.ViewModelStore r1 = (androidx.lifecycle.ViewModelStore) r1
            if (r1 == 0) goto L_0x008d
            r1.a()
            java.lang.String r1 = r2.mWho
            r0.remove(r1)
        L_0x008d:
            r2.performDestroy()
            androidx.fragment.app.n r0 = r9.f2159a
            r0.d(r2, r4)
            java.util.ArrayList r0 = r5.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x009d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.p r1 = (androidx.fragment.app.p) r1
            if (r1 == 0) goto L_0x009d
            java.lang.String r3 = r2.mWho
            androidx.fragment.app.Fragment r1 = r1.f2158a
            java.lang.String r4 = r1.mTargetWho
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x009d
            r1.mTarget = r2
            r3 = 0
            r1.mTargetWho = r3
            goto L_0x009d
        L_0x00bd:
            java.lang.String r0 = r2.mTargetWho
            if (r0 == 0) goto L_0x00c7
            androidx.fragment.app.Fragment r0 = r5.b(r0)
            r2.mTarget = r0
        L_0x00c7:
            r5.h(r9)
            goto L_0x00dd
        L_0x00cb:
            java.lang.String r0 = r2.mTargetWho
            if (r0 == 0) goto L_0x00db
            androidx.fragment.app.Fragment r0 = r5.b(r0)
            if (r0 == 0) goto L_0x00db
            boolean r1 = r0.mRetainInstance
            if (r1 == 0) goto L_0x00db
            r2.mTarget = r0
        L_0x00db:
            r2.mState = r4
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.f():void");
    }

    public final void g() {
        View view;
        boolean K = FragmentManager.K(3);
        Fragment fragment = this.f2158a;
        if (K) {
            Objects.toString(fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f2159a.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.i(null);
        fragment.mInLayout = false;
    }

    public final void h() {
        boolean K = FragmentManager.K(3);
        Fragment fragment = this.f2158a;
        if (K) {
            Objects.toString(fragment);
        }
        fragment.performDetach();
        boolean z = false;
        this.f2159a.e(fragment, false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        boolean z2 = true;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (!z) {
            o oVar = this.f2160a.a;
            if (oVar.b.containsKey(fragment.mWho) && oVar.f2155b) {
                z2 = oVar.f2156c;
            }
            if (!z2) {
                return;
            }
        }
        if (FragmentManager.K(3)) {
            Objects.toString(fragment);
        }
        fragment.initState();
    }

    public final void i() {
        Fragment fragment = this.f2158a;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.K(3)) {
                Objects.toString(fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), (ViewGroup) null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(Lr.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f2159a.m(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                fragment.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.f2161a;
        Fragment fragment = this.f2158a;
        if (!z) {
            boolean z2 = true;
            z2 = false;
            try {
                while (true) {
                    int c = c();
                    int i = fragment.mState;
                    if (c != i) {
                        n nVar = this.f2159a;
                        if (c <= i) {
                            switch (i - 1) {
                                case -1:
                                    h();
                                    break;
                                case 0:
                                    f();
                                    break;
                                case 1:
                                    g();
                                    fragment.mState = z2 ? 1 : 0;
                                    break;
                                case 2:
                                    fragment.mInLayout = z2;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.K(3)) {
                                        Objects.toString(fragment);
                                    }
                                    if (fragment.mView != null && fragment.mSavedViewState == null) {
                                        m();
                                    }
                                    if (!(fragment.mView == null || (viewGroup2 = fragment.mContainer) == null)) {
                                        s g = s.g(viewGroup2, fragment.getParentFragmentManager());
                                        g.getClass();
                                        if (FragmentManager.K(2)) {
                                            Objects.toString(fragment);
                                        }
                                        g.a(s.d.c.REMOVED, s.d.b.REMOVING, this);
                                    }
                                    fragment.mState = 3;
                                    break;
                                case 4:
                                    if (FragmentManager.K(3)) {
                                        Objects.toString(fragment);
                                    }
                                    fragment.performStop();
                                    nVar.l(fragment, z2);
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    if (FragmentManager.K(3)) {
                                        Objects.toString(fragment);
                                    }
                                    fragment.performPause();
                                    nVar.f(fragment, z2);
                                    break;
                            }
                        } else {
                            switch (i + 1) {
                                case 0:
                                    b();
                                    break;
                                case 1:
                                    d();
                                    break;
                                case 2:
                                    i();
                                    e();
                                    break;
                                case 3:
                                    if (FragmentManager.K(3)) {
                                        Objects.toString(fragment);
                                    }
                                    fragment.performActivityCreated(fragment.mSavedFragmentState);
                                    nVar.a(fragment, fragment.mSavedFragmentState, z2);
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        s g2 = s.g(viewGroup3, fragment.getParentFragmentManager());
                                        s.d.c f = s.d.c.f(fragment.mView.getVisibility());
                                        g2.getClass();
                                        if (FragmentManager.K(2)) {
                                            Objects.toString(fragment);
                                        }
                                        g2.a(f, s.d.b.ADDING, this);
                                    }
                                    fragment.mState = 4;
                                    break;
                                case 5:
                                    if (FragmentManager.K(3)) {
                                        Objects.toString(fragment);
                                    }
                                    fragment.performStart();
                                    nVar.k(fragment, z2);
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    l();
                                    break;
                            }
                        }
                    } else {
                        if (fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                s g3 = s.g(viewGroup, fragment.getParentFragmentManager());
                                boolean z3 = fragment.mHidden;
                                s.d.b bVar = s.d.b.NONE;
                                if (z3) {
                                    g3.getClass();
                                    if (FragmentManager.K(2)) {
                                        Objects.toString(fragment);
                                    }
                                    g3.a(s.d.c.GONE, bVar, this);
                                } else {
                                    g3.getClass();
                                    if (FragmentManager.K(2)) {
                                        Objects.toString(fragment);
                                    }
                                    g3.a(s.d.c.VISIBLE, bVar, this);
                                }
                            }
                            FragmentManager fragmentManager = fragment.mFragmentManager;
                            if (fragmentManager != null && fragment.mAdded && FragmentManager.L(fragment)) {
                                fragmentManager.f2091b = z2;
                            }
                            fragment.mHiddenChanged = z2;
                            fragment.onHiddenChanged(fragment.mHidden);
                        }
                        this.f2161a = z2;
                        return;
                    }
                }
            } finally {
                this.f2161a = z2;
            }
        } else if (FragmentManager.K(2)) {
            Objects.toString(fragment);
        }
    }

    public final void k(ClassLoader classLoader) {
        Fragment fragment = this.f2158a;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
            fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
            if (fragment.mTargetWho != null) {
                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Boolean bool = fragment.mSavedUserVisibleHint;
            if (bool != null) {
                fragment.mUserVisibleHint = bool.booleanValue();
                fragment.mSavedUserVisibleHint = null;
            } else {
                fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            if (!fragment.mUserVisibleHint) {
                fragment.mDeferStart = true;
            }
        }
    }

    public final void l() {
        boolean K = FragmentManager.K(3);
        Fragment fragment = this.f2158a;
        if (K) {
            Objects.toString(fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            boolean z = true;
            if (focusedView != fragment.mView) {
                ViewParent parent = focusedView.getParent();
                while (true) {
                    if (parent == null) {
                        z = false;
                        break;
                    } else if (parent == fragment.mView) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            if (z) {
                focusedView.requestFocus();
                if (FragmentManager.K(2)) {
                    focusedView.toString();
                    Objects.toString(fragment);
                    Objects.toString(fragment.mView.findFocus());
                }
            }
        }
        fragment.setFocusedView((View) null);
        fragment.performResume();
        this.f2159a.i(fragment, false);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void m() {
        Fragment fragment = this.f2158a;
        if (fragment.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            fragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                fragment.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            fragment.mViewLifecycleOwner.f2131a.c(bundle);
            if (!bundle.isEmpty()) {
                fragment.mSavedViewRegistryState = bundle;
            }
        }
    }

    public p(n nVar, q qVar, ClassLoader classLoader, l lVar, FragmentState fragmentState) {
        this.f2159a = nVar;
        this.f2160a = qVar;
        Fragment instantiate = Fragment.instantiate(FragmentManager.this.f2073a.f2066a, fragmentState.f2105c, (Bundle) null);
        this.f2158a = instantiate;
        Bundle bundle = fragmentState.a;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle);
        instantiate.mWho = fragmentState.f2107d;
        instantiate.mFromLayout = fragmentState.f2103a;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.c;
        instantiate.mContainerId = fragmentState.d;
        instantiate.mTag = fragmentState.f2109e;
        instantiate.mRetainInstance = fragmentState.f2104b;
        instantiate.mRemoving = fragmentState.f2106c;
        instantiate.mDetached = fragmentState.f2108d;
        instantiate.mHidden = fragmentState.f2110e;
        instantiate.mMaxState = Lifecycle.State.values()[fragmentState.e];
        Bundle bundle2 = fragmentState.b;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.K(2)) {
            Objects.toString(instantiate);
        }
    }

    /* compiled from: FragmentStateManager */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        public final void onViewAttachedToWindow(View view) {
            View view2 = this.a;
            view2.removeOnAttachStateChangeListener(this);
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.c.c(view2);
        }

        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public p(n nVar, q qVar, Fragment fragment, FragmentState fragmentState) {
        this.f2159a = nVar;
        this.f2160a = qVar;
        this.f2158a = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.b;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
