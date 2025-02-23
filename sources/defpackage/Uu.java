package defpackage;

import android.os.Bundle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* renamed from: Uu  reason: default package */
/* compiled from: SavedStateHandleSupport.kt */
public final class Uu implements SavedStateRegistry.b {
    public final C0715Uy a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f581a;

    /* renamed from: a  reason: collision with other field name */
    public final SavedStateRegistry f582a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f583a;

    /* renamed from: Uu$a */
    /* compiled from: SavedStateHandleSupport.kt */
    public static final class a extends C0595Mh implements Function0<Vu> {
        public final /* synthetic */ AC a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AC ac) {
            super(0);
            this.a = ac;
        }

        public final Object invoke() {
            return l.b(this.a);
        }
    }

    public Uu(SavedStateRegistry savedStateRegistry, AC ac) {
        C1177ig.f(savedStateRegistry, "savedStateRegistry");
        C1177ig.f(ac, "viewModelStoreOwner");
        this.f582a = savedStateRegistry;
        this.a = C1354qp.d0(new a(ac));
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f581a;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : b().a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a2 = ((k) entry.getValue()).f2208a.a();
            if (!C1177ig.a(a2, Bundle.EMPTY)) {
                bundle.putBundle(str, a2);
            }
        }
        this.f583a = false;
        return bundle;
    }

    public final Vu b() {
        return (Vu) this.a.getValue();
    }

    public final void c() {
        if (!this.f583a) {
            Bundle a2 = this.f582a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f581a;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (a2 != null) {
                bundle.putAll(a2);
            }
            this.f581a = bundle;
            this.f583a = true;
            b();
        }
    }
}
