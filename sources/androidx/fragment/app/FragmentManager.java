package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public U f2069a;

    /* renamed from: a  reason: collision with other field name */
    public OnBackPressedDispatcher f2070a;

    /* renamed from: a  reason: collision with other field name */
    public Fragment f2071a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentContainer f2072a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentHostCallback<?> f2073a;

    /* renamed from: a  reason: collision with other field name */
    public final c f2074a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final e f2075a;

    /* renamed from: a  reason: collision with other field name */
    public final f f2076a;

    /* renamed from: a  reason: collision with other field name */
    public final g f2077a;

    /* renamed from: a  reason: collision with other field name */
    public final m f2078a = new m(this);

    /* renamed from: a  reason: collision with other field name */
    public final n f2079a;

    /* renamed from: a  reason: collision with other field name */
    public o f2080a;

    /* renamed from: a  reason: collision with other field name */
    public final q f2081a = new q();

    /* renamed from: a  reason: collision with other field name */
    public ArrayDeque<LaunchedFragmentInfo> f2082a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<m> f2083a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Bundle> f2084a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with other field name */
    public final CopyOnWriteArrayList<C0305qd> f2085a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f2086a = new AtomicInteger();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2087a;
    public U b;

    /* renamed from: b  reason: collision with other field name */
    public Fragment f2088b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<a> f2089b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<String, Object> f2090b = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with other field name */
    public boolean f2091b;
    public U c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<Fragment> f2092c;

    /* renamed from: c  reason: collision with other field name */
    public final Map<Fragment, HashSet<A4>> f2093c = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with other field name */
    public boolean f2094c;
    public ArrayList<a> d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2095d;
    public ArrayList<Boolean> e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f2096e;
    public ArrayList<Fragment> f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f2097f;

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.f {
        public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
            if (aVar == Lifecycle.a.ON_START) {
                throw null;
            } else if (aVar == Lifecycle.a.ON_DESTROY) {
                throw null;
            }
        }
    }

    public class a implements ActivityResultCallback<ActivityResult> {
        public a() {
        }

        public final void a(Object obj) {
            Fragment c;
            ActivityResult activityResult = (ActivityResult) obj;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.f2082a.pollFirst();
            if (pollFirst != null && (c = fragmentManager.f2081a.c(pollFirst.f2098c)) != null) {
                c.onActivityResult(pollFirst.c, activityResult.c, activityResult.a);
            }
        }
    }

    public class b implements ActivityResultCallback<Map<String, Boolean>> {
        public b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public final void a(Object obj) {
            Fragment c;
            int i;
            Map map = (Map) obj;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Boolean) arrayList.get(i2)).booleanValue()) {
                    i = 0;
                } else {
                    i = -1;
                }
                iArr[i2] = i;
            }
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.f2082a.pollFirst();
            if (pollFirst != null && (c = fragmentManager.f2081a.c(pollFirst.f2098c)) != null) {
                c.onRequestPermissionsResult(pollFirst.c, strArr, iArr);
            }
        }
    }

    public class c extends Bn {
        public c() {
            super(false);
        }

        public final void handleOnBackPressed() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.w(true);
            if (fragmentManager.f2074a.isEnabled()) {
                fragmentManager.R();
            } else {
                fragmentManager.f2070a.c();
            }
        }
    }

    public class d {
        public d(FragmentManager fragmentManager) {
        }
    }

    public class e extends l {
        public e() {
        }
    }

    public class f implements Dx {
    }

    public class g implements Runnable {
        public g() {
        }

        public final void run() {
            FragmentManager.this.w(true);
        }
    }

    public class h implements C0305qd {
        public final /* synthetic */ Fragment a;

        public h(Fragment fragment) {
            this.a = fragment;
        }

        public final void a(Fragment fragment) {
            this.a.onAttachFragment(fragment);
        }
    }

    public class i implements ActivityResultCallback<ActivityResult> {
        public i() {
        }

        public final void a(Object obj) {
            Fragment c;
            ActivityResult activityResult = (ActivityResult) obj;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.f2082a.pollFirst();
            if (pollFirst != null && (c = fragmentManager.f2081a.c(pollFirst.f2098c)) != null) {
                c.onActivityResult(pollFirst.c, activityResult.c, activityResult.a);
            }
        }
    }

    public interface j {
        String getName();
    }

    public static class k extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public final Intent a(ComponentActivity componentActivity, Object obj) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest.a;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSender intentSender = intentSenderRequest.f830a;
                    C1177ig.f(intentSender, "intentSender");
                    intentSenderRequest = new IntentSenderRequest(intentSender, (Intent) null, intentSenderRequest.c, intentSenderRequest.d);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.K(2)) {
                intent.toString();
            }
            return intent;
        }

        public final Object c(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public interface m {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class n implements m {
        public final int a;
        public final int b;

        public n(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f2088b;
            if (fragment != null && this.a < 0 && fragment.getChildFragmentManager().R()) {
                return false;
            }
            return FragmentManager.this.T(arrayList, arrayList2, (String) null, this.a, this.b);
        }
    }

    public FragmentManager() {
        new d(this);
        this.f2079a = new n(this);
        this.f2085a = new CopyOnWriteArrayList<>();
        this.a = -1;
        this.f2075a = new e();
        this.f2076a = new f();
        this.f2082a = new ArrayDeque<>();
        this.f2077a = new g();
    }

    public static boolean K(int i2) {
        if (Log.isLoggable("FragmentManager", i2)) {
            return true;
        }
        return false;
    }

    public static boolean L(Fragment fragment) {
        boolean z;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        Iterator it = fragment.mChildFragmentManager.f2081a.e().iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z2 = L(fragment2);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public static boolean M(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.f2088b) || !M(fragmentManager.f2071a)) {
            return false;
        }
        return true;
    }

    public final Fragment A(String str) {
        return this.f2081a.b(str);
    }

    public final Fragment B(int i2) {
        q qVar = this.f2081a;
        ArrayList<Fragment> arrayList = qVar.f2162a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = arrayList.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (p next : qVar.f2163a.values()) {
                    if (next != null) {
                        Fragment fragment2 = next.f2158a;
                        if (fragment2.mFragmentId == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public final Fragment C(String str) {
        q qVar = this.f2081a;
        if (str != null) {
            ArrayList<Fragment> arrayList = qVar.f2162a;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (p next : qVar.f2163a.values()) {
                if (next != null) {
                    Fragment fragment2 = next.f2158a;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        } else {
            qVar.getClass();
        }
        return null;
    }

    public final void D() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.f2167b) {
                sVar.f2167b = false;
                sVar.c();
            }
        }
    }

    public final j E(int i2) {
        return this.f2089b.get(i2);
    }

    public final int F() {
        ArrayList<a> arrayList = this.f2089b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final ViewGroup G(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2072a.c()) {
            View b2 = this.f2072a.b(fragment.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    public final l H() {
        Fragment fragment = this.f2071a;
        if (fragment != null) {
            return fragment.mFragmentManager.H();
        }
        return this.f2075a;
    }

    public final List<Fragment> I() {
        return this.f2081a.f();
    }

    public final Dx J() {
        Fragment fragment = this.f2071a;
        if (fragment != null) {
            return fragment.mFragmentManager.J();
        }
        return this.f2076a;
    }

    public final boolean N() {
        if (this.f2094c || this.f2095d) {
            return true;
        }
        return false;
    }

    public final void O(int i2, boolean z) {
        HashMap<String, p> hashMap;
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.f2073a == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i2 != this.a) {
            this.a = i2;
            q qVar = this.f2081a;
            Iterator<Fragment> it = qVar.f2162a.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                hashMap = qVar.f2163a;
                if (!hasNext) {
                    break;
                }
                p pVar = hashMap.get(it.next().mWho);
                if (pVar != null) {
                    pVar.j();
                }
            }
            Iterator<p> it2 = hashMap.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                p next = it2.next();
                if (next != null) {
                    next.j();
                    Fragment fragment = next.f2158a;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z2 = true;
                    }
                    if (z2) {
                        qVar.h(next);
                    }
                }
            }
            d0();
            if (this.f2091b && (fragmentHostCallback = this.f2073a) != null && this.a == 7) {
                fragmentHostCallback.h();
                this.f2091b = false;
            }
        }
    }

    public final void P() {
        if (this.f2073a != null) {
            this.f2094c = false;
            this.f2095d = false;
            this.f2080a.f2157d = false;
            for (Fragment next : this.f2081a.f()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    public final void Q() {
        u(new n(-1, 0), false);
    }

    public final boolean R() {
        return S((String) null);
    }

    public final boolean S(String str) {
        w(false);
        v(true);
        Fragment fragment = this.f2088b;
        if (fragment != null && str == null && fragment.getChildFragmentManager().S((String) null)) {
            return true;
        }
        boolean T = T(this.d, this.e, str, -1, 0);
        if (T) {
            this.f2087a = true;
            try {
                V(this.d, this.e);
            } finally {
                d();
            }
        }
        e0();
        if (this.f2097f) {
            this.f2097f = false;
            d0();
        }
        this.f2081a.f2163a.values().removeAll(Collections.singleton((Object) null));
        return T;
    }

    public final boolean T(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f2089b;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2089b.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f2089b.get(size2);
                    if ((str != null && str.equals(aVar.f2117a)) || (i2 >= 0 && i2 == aVar.h)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f2089b.get(size2);
                        if ((str == null || !str.equals(aVar2.f2117a)) && (i2 < 0 || i2 != aVar2.h)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f2089b.size() - 1) {
                return false;
            }
            for (int size3 = this.f2089b.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f2089b.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final void U(Fragment fragment) {
        if (K(2)) {
            Objects.toString(fragment);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            q qVar = this.f2081a;
            synchronized (qVar.f2162a) {
                qVar.f2162a.remove(fragment);
            }
            fragment.mAdded = false;
            if (L(fragment)) {
                this.f2091b = true;
            }
            fragment.mRemoving = true;
            c0(fragment);
        }
    }

    public final void V(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).f2124c) {
                        if (i3 != i2) {
                            y(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).f2124c) {
                                i3++;
                            }
                        }
                        y(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    y(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void W(Parcelable parcelable) {
        n nVar;
        int i2;
        p pVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                q qVar = this.f2081a;
                qVar.f2163a.clear();
                Iterator<FragmentState> it = fragmentManagerState.a.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    nVar = this.f2079a;
                    if (!hasNext) {
                        break;
                    }
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment fragment = this.f2080a.b.get(next.f2107d);
                        if (fragment != null) {
                            if (K(2)) {
                                fragment.toString();
                            }
                            pVar = new p(nVar, qVar, fragment, next);
                        } else {
                            pVar = new p(this.f2079a, this.f2081a, this.f2073a.f2066a.getClassLoader(), H(), next);
                        }
                        Fragment fragment2 = pVar.f2158a;
                        fragment2.mFragmentManager = this;
                        if (K(2)) {
                            fragment2.toString();
                        }
                        pVar.k(this.f2073a.f2066a.getClassLoader());
                        qVar.g(pVar);
                        pVar.a = this.a;
                    }
                }
                o oVar = this.f2080a;
                oVar.getClass();
                Iterator it2 = new ArrayList(oVar.b.values()).iterator();
                while (true) {
                    i2 = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Fragment fragment3 = (Fragment) it2.next();
                    if (qVar.f2163a.get(fragment3.mWho) != null) {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        if (K(2)) {
                            fragment3.toString();
                            Objects.toString(fragmentManagerState.a);
                        }
                        this.f2080a.d(fragment3);
                        fragment3.mFragmentManager = this;
                        p pVar2 = new p(nVar, qVar, fragment3);
                        pVar2.a = 1;
                        pVar2.j();
                        fragment3.mRemoving = true;
                        pVar2.j();
                    }
                }
                ArrayList<String> arrayList = fragmentManagerState.b;
                qVar.f2162a.clear();
                if (arrayList != null) {
                    for (String next2 : arrayList) {
                        Fragment b2 = qVar.b(next2);
                        if (b2 != null) {
                            if (K(2)) {
                                b2.toString();
                            }
                            qVar.a(b2);
                        } else {
                            throw new IllegalStateException(lf.j("No instantiated fragment for (", next2, ")"));
                        }
                    }
                }
                if (fragmentManagerState.f2100a != null) {
                    this.f2089b = new ArrayList<>(fragmentManagerState.f2100a.length);
                    int i3 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f2100a;
                        if (i3 >= backStackStateArr.length) {
                            break;
                        }
                        BackStackState backStackState = backStackStateArr[i3];
                        backStackState.getClass();
                        a aVar = new a(this);
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            int[] iArr = backStackState.f2034a;
                            if (i4 >= iArr.length) {
                                break;
                            }
                            FragmentTransaction.a aVar2 = new FragmentTransaction.a();
                            int i6 = i4 + 1;
                            aVar2.a = iArr[i4];
                            if (K(2)) {
                                aVar.toString();
                                int i7 = iArr[i6];
                            }
                            String str = backStackState.f2032a.get(i5);
                            if (str != null) {
                                aVar2.f2125a = A(str);
                            } else {
                                aVar2.f2125a = null;
                            }
                            aVar2.f2126a = Lifecycle.State.values()[backStackState.f2036b[i5]];
                            aVar2.f2127b = Lifecycle.State.values()[backStackState.f2039c[i5]];
                            int i8 = i6 + 1;
                            int i9 = iArr[i6];
                            aVar2.b = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr[i8];
                            aVar2.c = i11;
                            int i12 = i10 + 1;
                            int i13 = iArr[i10];
                            aVar2.d = i13;
                            int i14 = iArr[i12];
                            aVar2.e = i14;
                            aVar.a = i9;
                            aVar.b = i11;
                            aVar.c = i13;
                            aVar.d = i14;
                            aVar.b(aVar2);
                            i5++;
                            i4 = i12 + 1;
                        }
                        aVar.e = backStackState.c;
                        aVar.f2117a = backStackState.f2037c;
                        aVar.h = backStackState.d;
                        aVar.f2119a = true;
                        aVar.f = backStackState.e;
                        aVar.f2116a = backStackState.a;
                        aVar.g = backStackState.f;
                        aVar.f2120b = backStackState.b;
                        aVar.f2121b = backStackState.f2035b;
                        aVar.f2123c = backStackState.f2038c;
                        aVar.f2124c = backStackState.f2033a;
                        aVar.i(1);
                        if (K(2)) {
                            aVar.toString();
                            PrintWriter printWriter = new PrintWriter(new C0396xi());
                            aVar.k("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2089b.add(aVar);
                        i3++;
                    }
                } else {
                    this.f2089b = null;
                }
                this.f2086a.set(fragmentManagerState.c);
                String str2 = fragmentManagerState.f2101c;
                if (str2 != null) {
                    Fragment A = A(str2);
                    this.f2088b = A;
                    p(A);
                }
                ArrayList<String> arrayList2 = fragmentManagerState.f2102c;
                if (arrayList2 != null) {
                    while (i2 < arrayList2.size()) {
                        Bundle bundle = fragmentManagerState.d.get(i2);
                        bundle.setClassLoader(this.f2073a.f2066a.getClassLoader());
                        this.f2084a.put(arrayList2.get(i2), bundle);
                        i2++;
                    }
                }
                this.f2082a = new ArrayDeque<>(fragmentManagerState.e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: androidx.fragment.app.BackStackState[]} */
    /* JADX WARNING: type inference failed for: r4v9, types: [android.os.BaseBundle] */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable X() {
        /*
            r10 = this;
            r10.D()
            java.util.HashSet r0 = r10.e()
            java.util.Iterator r0 = r0.iterator()
        L_0x000b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.s r1 = (androidx.fragment.app.s) r1
            r1.e()
            goto L_0x000b
        L_0x001b:
            r0 = 1
            r10.w(r0)
            r10.f2094c = r0
            androidx.fragment.app.o r1 = r10.f2080a
            r1.f2157d = r0
            androidx.fragment.app.q r0 = r10.f2081a
            r0.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.HashMap<java.lang.String, androidx.fragment.app.p> r0 = r0.f2163a
            int r2 = r0.size()
            r1.<init>(r2)
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x003d:
            boolean r2 = r0.hasNext()
            r3 = 0
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L_0x00ee
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.p r2 = (androidx.fragment.app.p) r2
            if (r2 == 0) goto L_0x003d
            androidx.fragment.app.FragmentState r6 = new androidx.fragment.app.FragmentState
            androidx.fragment.app.Fragment r7 = r2.f2158a
            r6.<init>((androidx.fragment.app.Fragment) r7)
            int r8 = r7.mState
            r9 = -1
            if (r8 <= r9) goto L_0x00d7
            android.os.Bundle r8 = r6.b
            if (r8 != 0) goto L_0x00d7
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            r7.performSaveInstanceState(r8)
            androidx.fragment.app.n r9 = r2.f2159a
            r9.j(r7, r8, r3)
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r4 = r8
        L_0x0073:
            android.view.View r3 = r7.mView
            if (r3 == 0) goto L_0x007a
            r2.m()
        L_0x007a:
            android.util.SparseArray<android.os.Parcelable> r2 = r7.mSavedViewState
            if (r2 == 0) goto L_0x008d
            if (r4 != 0) goto L_0x0086
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r4 = r2
        L_0x0086:
            java.lang.String r2 = "android:view_state"
            android.util.SparseArray<android.os.Parcelable> r3 = r7.mSavedViewState
            r4.putSparseParcelableArray(r2, r3)
        L_0x008d:
            android.os.Bundle r2 = r7.mSavedViewRegistryState
            if (r2 == 0) goto L_0x00a0
            if (r4 != 0) goto L_0x0099
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r4 = r2
        L_0x0099:
            java.lang.String r2 = "android:view_registry_state"
            android.os.Bundle r3 = r7.mSavedViewRegistryState
            r4.putBundle(r2, r3)
        L_0x00a0:
            boolean r2 = r7.mUserVisibleHint
            if (r2 != 0) goto L_0x00b3
            if (r4 != 0) goto L_0x00ac
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r4 = r2
        L_0x00ac:
            java.lang.String r2 = "android:user_visible_hint"
            boolean r3 = r7.mUserVisibleHint
            r4.putBoolean(r2, r3)
        L_0x00b3:
            r6.b = r4
            java.lang.String r2 = r7.mTargetWho
            if (r2 == 0) goto L_0x00db
            if (r4 != 0) goto L_0x00c2
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r6.b = r2
        L_0x00c2:
            android.os.Bundle r2 = r6.b
            java.lang.String r3 = "android:target_state"
            java.lang.String r4 = r7.mTargetWho
            r2.putString(r3, r4)
            int r2 = r7.mTargetRequestCode
            if (r2 == 0) goto L_0x00db
            android.os.Bundle r3 = r6.b
            java.lang.String r4 = "android:target_req_state"
            r3.putInt(r4, r2)
            goto L_0x00db
        L_0x00d7:
            android.os.Bundle r2 = r7.mSavedFragmentState
            r6.b = r2
        L_0x00db:
            r1.add(r6)
            boolean r2 = K(r5)
            if (r2 == 0) goto L_0x003d
            java.util.Objects.toString(r7)
            android.os.Bundle r2 = r6.b
            java.util.Objects.toString(r2)
            goto L_0x003d
        L_0x00ee:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x00f8
            K(r5)
            return r4
        L_0x00f8:
            androidx.fragment.app.q r0 = r10.f2081a
            java.util.ArrayList<androidx.fragment.app.Fragment> r2 = r0.f2162a
            monitor-enter(r2)
            java.util.ArrayList<androidx.fragment.app.Fragment> r6 = r0.f2162a     // Catch:{ all -> 0x019f }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x019f }
            if (r6 == 0) goto L_0x0108
            monitor-exit(r2)     // Catch:{ all -> 0x019f }
            r6 = r4
            goto L_0x0135
        L_0x0108:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x019f }
            java.util.ArrayList<androidx.fragment.app.Fragment> r7 = r0.f2162a     // Catch:{ all -> 0x019f }
            int r7 = r7.size()     // Catch:{ all -> 0x019f }
            r6.<init>(r7)     // Catch:{ all -> 0x019f }
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r0.f2162a     // Catch:{ all -> 0x019f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x019f }
        L_0x0119:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x019f }
            if (r7 == 0) goto L_0x0134
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x019f }
            androidx.fragment.app.Fragment r7 = (androidx.fragment.app.Fragment) r7     // Catch:{ all -> 0x019f }
            java.lang.String r8 = r7.mWho     // Catch:{ all -> 0x019f }
            r6.add(r8)     // Catch:{ all -> 0x019f }
            boolean r8 = K(r5)     // Catch:{ all -> 0x019f }
            if (r8 == 0) goto L_0x0119
            r7.toString()     // Catch:{ all -> 0x019f }
            goto L_0x0119
        L_0x0134:
            monitor-exit(r2)     // Catch:{ all -> 0x019f }
        L_0x0135:
            java.util.ArrayList<androidx.fragment.app.a> r0 = r10.f2089b
            if (r0 == 0) goto L_0x0164
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0164
            androidx.fragment.app.BackStackState[] r4 = new androidx.fragment.app.BackStackState[r0]
        L_0x0141:
            if (r3 >= r0) goto L_0x0164
            androidx.fragment.app.BackStackState r2 = new androidx.fragment.app.BackStackState
            java.util.ArrayList<androidx.fragment.app.a> r7 = r10.f2089b
            java.lang.Object r7 = r7.get(r3)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            r2.<init>((androidx.fragment.app.a) r7)
            r4[r3] = r2
            boolean r2 = K(r5)
            if (r2 == 0) goto L_0x0161
            java.util.ArrayList<androidx.fragment.app.a> r2 = r10.f2089b
            java.lang.Object r2 = r2.get(r3)
            java.util.Objects.toString(r2)
        L_0x0161:
            int r3 = r3 + 1
            goto L_0x0141
        L_0x0164:
            androidx.fragment.app.FragmentManagerState r0 = new androidx.fragment.app.FragmentManagerState
            r0.<init>()
            r0.a = r1
            r0.b = r6
            r0.f2100a = r4
            java.util.concurrent.atomic.AtomicInteger r1 = r10.f2086a
            int r1 = r1.get()
            r0.c = r1
            androidx.fragment.app.Fragment r1 = r10.f2088b
            if (r1 == 0) goto L_0x017f
            java.lang.String r1 = r1.mWho
            r0.f2101c = r1
        L_0x017f:
            java.util.ArrayList<java.lang.String> r1 = r0.f2102c
            java.util.Map<java.lang.String, android.os.Bundle> r2 = r10.f2084a
            java.util.Set r2 = r2.keySet()
            r1.addAll(r2)
            java.util.ArrayList<android.os.Bundle> r1 = r0.d
            java.util.Map<java.lang.String, android.os.Bundle> r2 = r10.f2084a
            java.util.Collection r2 = r2.values()
            r1.addAll(r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.ArrayDeque<androidx.fragment.app.FragmentManager$LaunchedFragmentInfo> r2 = r10.f2082a
            r1.<init>(r2)
            r0.e = r1
            return r0
        L_0x019f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x019f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.X():android.os.Parcelable");
    }

    public final void Y() {
        synchronized (this.f2083a) {
            boolean z = true;
            if (this.f2083a.size() != 1) {
                z = false;
            }
            if (z) {
                this.f2073a.f2067a.removeCallbacks(this.f2077a);
                this.f2073a.f2067a.post(this.f2077a);
                e0();
            }
        }
    }

    public final void Z(Fragment fragment, boolean z) {
        ViewGroup G = G(fragment);
        if (G != null && (G instanceof FragmentContainerView)) {
            ((FragmentContainerView) G).setDrawDisappearingViewsLast(!z);
        }
    }

    public final p a(Fragment fragment) {
        if (K(2)) {
            Objects.toString(fragment);
        }
        p f2 = f(fragment);
        fragment.mFragmentManager = this;
        q qVar = this.f2081a;
        qVar.g(f2);
        if (!fragment.mDetached) {
            qVar.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (L(fragment)) {
                this.f2091b = true;
            }
        }
        return f2;
    }

    public final void a0(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(A(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: Kn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.fragment.app.FragmentHostCallback<?> r3, androidx.fragment.app.FragmentContainer r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r2.f2073a
            if (r0 != 0) goto L_0x00f7
            r2.f2073a = r3
            r2.f2072a = r4
            r2.f2071a = r5
            java.util.concurrent.CopyOnWriteArrayList<qd> r4 = r2.f2085a
            if (r5 == 0) goto L_0x0017
            androidx.fragment.app.FragmentManager$h r0 = new androidx.fragment.app.FragmentManager$h
            r0.<init>(r5)
            r4.add(r0)
            goto L_0x0021
        L_0x0017:
            boolean r0 = r3 instanceof defpackage.C0305qd
            if (r0 == 0) goto L_0x0021
            r0 = r3
            qd r0 = (defpackage.C0305qd) r0
            r4.add(r0)
        L_0x0021:
            androidx.fragment.app.Fragment r4 = r2.f2071a
            if (r4 == 0) goto L_0x0028
            r2.e0()
        L_0x0028:
            boolean r4 = r3 instanceof defpackage.Kn
            if (r4 == 0) goto L_0x003d
            r4 = r3
            Kn r4 = (defpackage.Kn) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2070a = r0
            if (r5 == 0) goto L_0x0038
            r4 = r5
        L_0x0038:
            androidx.fragment.app.FragmentManager$c r1 = r2.f2074a
            r0.a(r4, r1)
        L_0x003d:
            if (r5 == 0) goto L_0x005e
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.o r3 = r3.f2080a
            java.util.HashMap<java.lang.String, androidx.fragment.app.o> r4 = r3.c
            java.lang.String r0 = r5.mWho
            java.lang.Object r0 = r4.get(r0)
            androidx.fragment.app.o r0 = (androidx.fragment.app.o) r0
            if (r0 != 0) goto L_0x005b
            androidx.fragment.app.o r0 = new androidx.fragment.app.o
            boolean r3 = r3.f2155b
            r0.<init>(r3)
            java.lang.String r3 = r5.mWho
            r4.put(r3, r0)
        L_0x005b:
            r2.f2080a = r0
            goto L_0x0082
        L_0x005e:
            boolean r4 = r3 instanceof defpackage.AC
            if (r4 == 0) goto L_0x007a
            AC r3 = (defpackage.AC) r3
            androidx.lifecycle.ViewModelStore r3 = r3.getViewModelStore()
            androidx.lifecycle.ViewModelProvider r4 = new androidx.lifecycle.ViewModelProvider
            androidx.fragment.app.o$a r0 = androidx.fragment.app.o.a
            r4.<init>(r3, r0)
            java.lang.Class<androidx.fragment.app.o> r3 = androidx.fragment.app.o.class
            yC r3 = r4.a(r3)
            androidx.fragment.app.o r3 = (androidx.fragment.app.o) r3
            r2.f2080a = r3
            goto L_0x0082
        L_0x007a:
            androidx.fragment.app.o r3 = new androidx.fragment.app.o
            r4 = 0
            r3.<init>(r4)
            r2.f2080a = r3
        L_0x0082:
            androidx.fragment.app.o r3 = r2.f2080a
            boolean r4 = r2.N()
            r3.f2157d = r4
            androidx.fragment.app.o r3 = r2.f2080a
            androidx.fragment.app.q r4 = r2.f2081a
            r4.a = r3
            androidx.fragment.app.FragmentHostCallback<?> r3 = r2.f2073a
            boolean r4 = r3 instanceof defpackage.V
            if (r4 == 0) goto L_0x00f6
            V r3 = (defpackage.V) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x00ac
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            java.lang.String r0 = ":"
            java.lang.String r4 = defpackage.C0709Uj.j(r4, r5, r0)
            goto L_0x00ae
        L_0x00ac:
            java.lang.String r4 = ""
        L_0x00ae:
            java.lang.String r5 = "FragmentManager:"
            java.lang.String r4 = defpackage.C0709Uj.i(r5, r4)
            java.lang.String r5 = "StartActivityForResult"
            java.lang.String r5 = defpackage.C1058d.z(r4, r5)
            S r0 = new S
            r0.<init>()
            androidx.fragment.app.FragmentManager$i r1 = new androidx.fragment.app.FragmentManager$i
            r1.<init>()
            U r5 = r3.d(r5, r0, r1)
            r2.f2069a = r5
            java.lang.String r5 = "StartIntentSenderForResult"
            java.lang.String r5 = defpackage.C1058d.z(r4, r5)
            androidx.fragment.app.FragmentManager$k r0 = new androidx.fragment.app.FragmentManager$k
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            U r5 = r3.d(r5, r0, r1)
            r2.b = r5
            java.lang.String r5 = "RequestPermissions"
            java.lang.String r4 = defpackage.C1058d.z(r4, r5)
            androidx.activity.result.contract.a r5 = new androidx.activity.result.contract.a
            r5.<init>()
            androidx.fragment.app.FragmentManager$b r0 = new androidx.fragment.app.FragmentManager$b
            r0.<init>()
            U r3 = r3.d(r4, r5, r0)
            r2.c = r3
        L_0x00f6:
            return
        L_0x00f7:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.b(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    public final void b0(Fragment fragment) {
        if (fragment == null || (fragment.equals(A(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2088b;
            this.f2088b = fragment;
            p(fragment2);
            p(this.f2088b);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void c(Fragment fragment) {
        if (K(2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2081a.a(fragment);
                if (K(2)) {
                    fragment.toString();
                }
                if (L(fragment)) {
                    this.f2091b = true;
                }
            }
        }
    }

    public final void c0(Fragment fragment) {
        ViewGroup G = G(fragment);
        if (G != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                int i2 = Lr.visible_removing_fragment_view_tag;
                if (G.getTag(i2) == null) {
                    G.setTag(i2, fragment);
                }
                ((Fragment) G.getTag(i2)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void d() {
        this.f2087a = false;
        this.e.clear();
        this.d.clear();
    }

    public final void d0() {
        Iterator it = this.f2081a.d().iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            Fragment fragment = pVar.f2158a;
            if (fragment.mDeferStart) {
                if (this.f2087a) {
                    this.f2097f = true;
                } else {
                    fragment.mDeferStart = false;
                    pVar.j();
                }
            }
        }
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2081a.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((p) it.next()).f2158a.mContainer;
            if (viewGroup != null) {
                hashSet.add(s.f(viewGroup, J()));
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (F() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (M(r3.f2071a) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f2074a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e0() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r0 = r3.f2083a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r1 = r3.f2083a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.fragment.app.FragmentManager$c r1 = r3.f2074a     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.fragment.app.FragmentManager$c r0 = r3.f2074a
            int r1 = r3.F()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f2071a
            boolean r1 = M(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.e0():void");
    }

    public final p f(Fragment fragment) {
        String str = fragment.mWho;
        q qVar = this.f2081a;
        p pVar = qVar.f2163a.get(str);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this.f2079a, qVar, fragment);
        pVar2.k(this.f2073a.f2066a.getClassLoader());
        pVar2.a = this.a;
        return pVar2;
    }

    public final void g(Fragment fragment) {
        if (K(2)) {
            Objects.toString(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (K(2)) {
                    fragment.toString();
                }
                q qVar = this.f2081a;
                synchronized (qVar.f2162a) {
                    qVar.f2162a.remove(fragment);
                }
                fragment.mAdded = false;
                if (L(fragment)) {
                    this.f2091b = true;
                }
                c0(fragment);
            }
        }
    }

    public final void h(Configuration configuration) {
        for (Fragment next : this.f2081a.f()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.a < 1) {
            return false;
        }
        for (Fragment next : this.f2081a.f()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.a < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment next : this.f2081a.f()) {
            if (next != null && next.isMenuVisible() && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z = true;
            }
        }
        if (this.f2092c != null) {
            for (int i2 = 0; i2 < this.f2092c.size(); i2++) {
                Fragment fragment = this.f2092c.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f2092c = arrayList;
        return z;
    }

    public final void k() {
        this.f2096e = true;
        w(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((s) it.next()).e();
        }
        s(-1);
        this.f2073a = null;
        this.f2072a = null;
        this.f2071a = null;
        if (this.f2070a != null) {
            this.f2074a.remove();
            this.f2070a = null;
        }
        U u = this.f2069a;
        if (u != null) {
            u.b();
            this.b.b();
            this.c.b();
        }
    }

    public final void l() {
        for (Fragment next : this.f2081a.f()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    public final void m(boolean z) {
        for (Fragment next : this.f2081a.f()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z);
            }
        }
    }

    public final boolean n(MenuItem menuItem) {
        if (this.a < 1) {
            return false;
        }
        for (Fragment next : this.f2081a.f()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void o(Menu menu) {
        if (this.a >= 1) {
            for (Fragment next : this.f2081a.f()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void p(Fragment fragment) {
        if (fragment != null && fragment.equals(A(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public final void q(boolean z) {
        for (Fragment next : this.f2081a.f()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final boolean r(Menu menu) {
        boolean z = false;
        if (this.a < 1) {
            return false;
        }
        for (Fragment next : this.f2081a.f()) {
            if (next != null && next.isMenuVisible() && next.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    public final void s(int i2) {
        try {
            this.f2087a = true;
            for (p next : this.f2081a.f2163a.values()) {
                if (next != null) {
                    next.a = i2;
                }
            }
            O(i2, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((s) it.next()).e();
            }
            this.f2087a = false;
            w(true);
        } catch (Throwable th) {
            this.f2087a = false;
            throw th;
        }
    }

    public final void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String z = C1058d.z(str, "    ");
        q qVar = this.f2081a;
        qVar.getClass();
        String str2 = str + "    ";
        HashMap<String, p> hashMap = qVar.f2163a;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p next : hashMap.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment fragment = next.f2158a;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList<Fragment> arrayList = qVar.f2162a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(arrayList.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList2 = this.f2092c;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f2092c.get(i3).toString());
            }
        }
        ArrayList<a> arrayList3 = this.f2089b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f2089b.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.k(z, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2086a.get());
        synchronized (this.f2083a) {
            int size4 = this.f2083a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(this.f2083a.get(i5));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2073a);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2072a);
        if (this.f2071a != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2071a);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.a);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2094c);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2095d);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2096e);
        if (this.f2091b) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2091b);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2071a;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2071a)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.f2073a;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f2073a)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(m mVar, boolean z) {
        if (!z) {
            if (this.f2073a == null) {
                if (this.f2096e) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (N()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2083a) {
            if (this.f2073a != null) {
                this.f2083a.add(mVar);
                Y();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void v(boolean z) {
        if (this.f2087a) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2073a == null) {
            if (this.f2096e) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.f2073a.f2067a.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z || !N()) {
            if (this.d == null) {
                this.d = new ArrayList<>();
                this.e = new ArrayList<>();
            }
            this.f2087a = false;
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean w(boolean z) {
        boolean z2;
        v(z);
        boolean z3 = false;
        while (true) {
            ArrayList<a> arrayList = this.d;
            ArrayList<Boolean> arrayList2 = this.e;
            synchronized (this.f2083a) {
                if (this.f2083a.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.f2083a.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z2 |= this.f2083a.get(i2).a(arrayList, arrayList2);
                    }
                    this.f2083a.clear();
                    this.f2073a.f2067a.removeCallbacks(this.f2077a);
                }
            }
            if (z2) {
                z3 = true;
                this.f2087a = true;
                try {
                    V(this.d, this.e);
                } finally {
                    d();
                }
            } else {
                e0();
                if (this.f2097f) {
                    this.f2097f = false;
                    d0();
                }
                this.f2081a.f2163a.values().removeAll(Collections.singleton((Object) null));
                return z3;
            }
        }
        while (true) {
        }
    }

    public final void x(m mVar, boolean z) {
        if (!z || (this.f2073a != null && !this.f2096e)) {
            v(z);
            if (mVar.a(this.d, this.e)) {
                this.f2087a = true;
                try {
                    V(this.d, this.e);
                } finally {
                    d();
                }
            }
            e0();
            if (this.f2097f) {
                this.f2097f = false;
                d0();
            }
            this.f2081a.f2163a.values().removeAll(Collections.singleton((Object) null));
        }
    }

    public final void y(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        q qVar;
        q qVar2;
        q qVar3;
        int i4;
        ArrayList<a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z = arrayList3.get(i5).f2124c;
        ArrayList<Fragment> arrayList5 = this.f;
        if (arrayList5 == null) {
            this.f = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        ArrayList<Fragment> arrayList6 = this.f;
        q qVar4 = this.f2081a;
        arrayList6.addAll(qVar4.f());
        Fragment fragment = this.f2088b;
        int i7 = i5;
        boolean z2 = false;
        while (true) {
            int i8 = 1;
            if (i7 < i6) {
                a aVar = arrayList3.get(i7);
                if (!arrayList4.get(i7).booleanValue()) {
                    ArrayList<Fragment> arrayList7 = this.f;
                    int i9 = 0;
                    while (true) {
                        ArrayList<FragmentTransaction.a> arrayList8 = aVar.f2118a;
                        if (i9 < arrayList8.size()) {
                            FragmentTransaction.a aVar2 = arrayList8.get(i9);
                            int i10 = aVar2.a;
                            if (i10 != i8) {
                                if (i10 != 2) {
                                    if (i10 == 3 || i10 == 6) {
                                        arrayList7.remove(aVar2.f2125a);
                                        Fragment fragment2 = aVar2.f2125a;
                                        if (fragment2 == fragment) {
                                            arrayList8.add(i9, new FragmentTransaction.a(fragment2, 9));
                                            i9++;
                                            qVar3 = qVar4;
                                            i4 = 1;
                                            fragment = null;
                                        }
                                    } else if (i10 == 7) {
                                        qVar3 = qVar4;
                                        i4 = 1;
                                    } else if (i10 == 8) {
                                        arrayList8.add(i9, new FragmentTransaction.a(fragment, 9));
                                        i9++;
                                        fragment = aVar2.f2125a;
                                    }
                                    qVar3 = qVar4;
                                    i4 = 1;
                                } else {
                                    Fragment fragment3 = aVar2.f2125a;
                                    int i11 = fragment3.mContainerId;
                                    int size = arrayList7.size() - 1;
                                    boolean z3 = false;
                                    while (size >= 0) {
                                        q qVar5 = qVar4;
                                        Fragment fragment4 = arrayList7.get(size);
                                        if (fragment4.mContainerId == i11) {
                                            if (fragment4 == fragment3) {
                                                z3 = true;
                                            } else {
                                                if (fragment4 == fragment) {
                                                    arrayList8.add(i9, new FragmentTransaction.a(fragment4, 9));
                                                    i9++;
                                                    fragment = null;
                                                }
                                                FragmentTransaction.a aVar3 = new FragmentTransaction.a(fragment4, 3);
                                                aVar3.b = aVar2.b;
                                                aVar3.d = aVar2.d;
                                                aVar3.c = aVar2.c;
                                                aVar3.e = aVar2.e;
                                                arrayList8.add(i9, aVar3);
                                                arrayList7.remove(fragment4);
                                                i9++;
                                                fragment = fragment;
                                            }
                                        }
                                        size--;
                                        ArrayList<a> arrayList9 = arrayList;
                                        qVar4 = qVar5;
                                    }
                                    qVar3 = qVar4;
                                    i4 = 1;
                                    if (z3) {
                                        arrayList8.remove(i9);
                                        i9--;
                                    } else {
                                        aVar2.a = 1;
                                        arrayList7.add(fragment3);
                                    }
                                }
                                i9 += i4;
                                ArrayList<Boolean> arrayList10 = arrayList2;
                                int i12 = i2;
                                i8 = i4;
                                qVar4 = qVar3;
                                ArrayList<a> arrayList11 = arrayList;
                            } else {
                                qVar3 = qVar4;
                                i4 = i8;
                            }
                            arrayList7.add(aVar2.f2125a);
                            i9 += i4;
                            ArrayList<Boolean> arrayList102 = arrayList2;
                            int i122 = i2;
                            i8 = i4;
                            qVar4 = qVar3;
                            ArrayList<a> arrayList112 = arrayList;
                        } else {
                            qVar2 = qVar4;
                        }
                    }
                } else {
                    qVar2 = qVar4;
                    int i13 = 1;
                    ArrayList<Fragment> arrayList12 = this.f;
                    ArrayList<FragmentTransaction.a> arrayList13 = aVar.f2118a;
                    int size2 = arrayList13.size() - 1;
                    while (size2 >= 0) {
                        FragmentTransaction.a aVar4 = arrayList13.get(size2);
                        int i14 = aVar4.a;
                        if (i14 != i13) {
                            if (i14 != 3) {
                                switch (i14) {
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar4.f2125a;
                                        break;
                                    case 10:
                                        aVar4.f2127b = aVar4.f2126a;
                                        break;
                                }
                            }
                            arrayList12.add(aVar4.f2125a);
                            size2--;
                            i13 = 1;
                        }
                        arrayList12.remove(aVar4.f2125a);
                        size2--;
                        i13 = 1;
                    }
                }
                if (z2 || aVar.f2119a) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i7++;
                arrayList3 = arrayList;
                arrayList4 = arrayList2;
                int i15 = i2;
                qVar4 = qVar2;
            } else {
                q qVar6 = qVar4;
                this.f.clear();
                if (!z && this.a >= 1) {
                    for (int i16 = i2; i16 < i6; i16++) {
                        Iterator<FragmentTransaction.a> it = arrayList.get(i16).f2118a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment5 = it.next().f2125a;
                            if (fragment5 == null || fragment5.mFragmentManager == null) {
                                qVar = qVar6;
                            } else {
                                qVar = qVar6;
                                qVar.g(f(fragment5));
                            }
                            qVar6 = qVar;
                        }
                        q qVar7 = qVar6;
                    }
                }
                ArrayList<a> arrayList14 = arrayList;
                for (int i17 = i2; i17 < i6; i17++) {
                    a aVar5 = arrayList14.get(i17);
                    if (arrayList2.get(i17).booleanValue()) {
                        aVar5.i(-1);
                        aVar5.m();
                    } else {
                        aVar5.i(1);
                        aVar5.l();
                    }
                }
                ArrayList<Boolean> arrayList15 = arrayList2;
                boolean booleanValue = arrayList15.get(i6 - 1).booleanValue();
                for (int i18 = i2; i18 < i6; i18++) {
                    a aVar6 = arrayList14.get(i18);
                    if (booleanValue) {
                        for (int size3 = aVar6.f2118a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = aVar6.f2118a.get(size3).f2125a;
                            if (fragment6 != null) {
                                f(fragment6).j();
                            }
                        }
                    } else {
                        Iterator<FragmentTransaction.a> it2 = aVar6.f2118a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = it2.next().f2125a;
                            if (fragment7 != null) {
                                f(fragment7).j();
                            }
                        }
                    }
                }
                O(this.a, true);
                HashSet hashSet = new HashSet();
                for (int i19 = i2; i19 < i6; i19++) {
                    Iterator<FragmentTransaction.a> it3 = arrayList14.get(i19).f2118a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = it3.next().f2125a;
                        if (!(fragment8 == null || (viewGroup = fragment8.mContainer) == null)) {
                            hashSet.add(s.f(viewGroup, J()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    s sVar = (s) it4.next();
                    sVar.f2166a = booleanValue;
                    sVar.h();
                    sVar.c();
                }
                for (int i20 = i2; i20 < i6; i20++) {
                    a aVar7 = arrayList14.get(i20);
                    if (arrayList15.get(i20).booleanValue() && aVar7.h >= 0) {
                        aVar7.h = -1;
                    }
                    aVar7.getClass();
                }
                return;
            }
        }
    }

    public final void z() {
        w(true);
        D();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        public final int c;

        /* renamed from: c  reason: collision with other field name */
        public final String f2098c;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            public final Object createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            public final Object[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        public LaunchedFragmentInfo(String str, int i) {
            this.f2098c = str;
            this.c = i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2098c);
            parcel.writeInt(this.c);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f2098c = parcel.readString();
            this.c = parcel.readInt();
        }
    }

    public static abstract class l {
        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }
    }
}
