package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.savedstate.Recreator;
import defpackage.Nu;
import java.util.Iterator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* compiled from: SavedStateRegistry.kt */
public final class SavedStateRegistry {
    public final Nu<String, b> a = new Nu<>();

    /* renamed from: a  reason: collision with other field name */
    public Bundle f2410a;

    /* renamed from: a  reason: collision with other field name */
    public Recreator.a f2411a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2412a;
    public boolean b;
    public boolean c = true;

    /* compiled from: SavedStateRegistry.kt */
    public interface a {
        void a(Xu xu);
    }

    /* compiled from: SavedStateRegistry.kt */
    public interface b {
        Bundle a();
    }

    public final Bundle a(String str) {
        boolean z;
        if (this.b) {
            Bundle bundle = this.f2410a;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f2410a;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f2410a;
            if (bundle4 == null || bundle4.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.f2410a = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final b b() {
        Map.Entry entry;
        b bVar;
        Iterator<Map.Entry<String, b>> it = this.a.iterator();
        do {
            Nu.e eVar = (Nu.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            entry = (Map.Entry) eVar.next();
            C1177ig.e(entry, "components");
            bVar = (b) entry.getValue();
        } while (!C1177ig.a((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return bVar;
    }

    public final void c(String str, b bVar) {
        boolean z;
        C1177ig.f(str, "key");
        C1177ig.f(bVar, "provider");
        if (this.a.b(str, bVar) == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() {
        Class<d.a> cls = d.a.class;
        if (this.c) {
            Recreator.a aVar = this.f2411a;
            if (aVar == null) {
                aVar = new Recreator.a(this);
            }
            this.f2411a = aVar;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar2 = this.f2411a;
                if (aVar2 != null) {
                    aVar2.a.add(cls.getName());
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}
