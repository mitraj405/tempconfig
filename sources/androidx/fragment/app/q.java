package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: FragmentStore */
public final class q {
    public o a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<Fragment> f2162a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, p> f2163a = new HashMap<>();

    public final void a(Fragment fragment) {
        if (!this.f2162a.contains(fragment)) {
            synchronized (this.f2162a) {
                this.f2162a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public final Fragment b(String str) {
        p pVar = this.f2163a.get(str);
        if (pVar != null) {
            return pVar.f2158a;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment findFragmentByWho;
        for (p next : this.f2163a.values()) {
            if (next != null && (findFragmentByWho = next.f2158a.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (p next : this.f2163a.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (p next : this.f2163a.values()) {
            if (next != null) {
                arrayList.add(next.f2158a);
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    public final List<Fragment> f() {
        ArrayList arrayList;
        if (this.f2162a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2162a) {
            arrayList = new ArrayList(this.f2162a);
        }
        return arrayList;
    }

    public final void g(p pVar) {
        boolean z;
        Fragment fragment = pVar.f2158a;
        String str = fragment.mWho;
        HashMap<String, p> hashMap = this.f2163a;
        if (hashMap.get(str) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            hashMap.put(fragment.mWho, pVar);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    this.a.c(fragment);
                } else {
                    this.a.d(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.K(2)) {
                fragment.toString();
            }
        }
    }

    public final void h(p pVar) {
        Fragment fragment = pVar.f2158a;
        if (fragment.mRetainInstance) {
            this.a.d(fragment);
        }
        if (this.f2163a.put(fragment.mWho, (Object) null) != null && FragmentManager.K(2)) {
            fragment.toString();
        }
    }
}
