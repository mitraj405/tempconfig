package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel */
public final class o extends C0404yC {
    public static final a a = new a();
    public final HashMap<String, Fragment> b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    public final boolean f2155b;
    public final HashMap<String, o> c = new HashMap<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f2156c = false;
    public final HashMap<String, ViewModelStore> d = new HashMap<>();

    /* renamed from: d  reason: collision with other field name */
    public boolean f2157d = false;

    /* compiled from: FragmentManagerViewModel */
    public class a implements ViewModelProvider.Factory {
        public final <T extends C0404yC> T b(Class<T> cls) {
            return new o(true);
        }
    }

    public o(boolean z) {
        this.f2155b = z;
    }

    public final void b() {
        if (FragmentManager.K(3)) {
            toString();
        }
        this.f2156c = true;
    }

    public final void c(Fragment fragment) {
        if (this.f2157d) {
            FragmentManager.K(2);
            return;
        }
        HashMap<String, Fragment> hashMap = this.b;
        if (!hashMap.containsKey(fragment.mWho)) {
            hashMap.put(fragment.mWho, fragment);
            if (FragmentManager.K(2)) {
                fragment.toString();
            }
        }
    }

    public final void d(Fragment fragment) {
        boolean z;
        if (this.f2157d) {
            FragmentManager.K(2);
            return;
        }
        if (this.b.remove(fragment.mWho) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && FragmentManager.K(2)) {
            fragment.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.b.equals(oVar.b) || !this.c.equals(oVar.c) || !this.d.equals(oVar.d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = this.c.hashCode();
        return this.d.hashCode() + ((hashCode + (this.b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
