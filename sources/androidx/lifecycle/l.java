package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;

/* compiled from: SavedStateHandleSupport.kt */
public final class l {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2210a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final c f2211a = new c();

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class a {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class b {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class c {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class d extends C0595Mh implements Function1<CreationExtras, Vu> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        public final Object invoke(Object obj) {
            C1177ig.f((CreationExtras) obj, "$this$initializer");
            return new Vu();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (r5.isEmpty() == true) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.lifecycle.k a(androidx.lifecycle.viewmodel.a r7) {
        /*
            androidx.lifecycle.l$b r0 = f2210a
            java.util.LinkedHashMap r7 = r7.a
            java.lang.Object r0 = r7.get(r0)
            Xu r0 = (defpackage.Xu) r0
            if (r0 == 0) goto L_0x0090
            androidx.lifecycle.l$c r1 = f2211a
            java.lang.Object r1 = r7.get(r1)
            AC r1 = (defpackage.AC) r1
            if (r1 == 0) goto L_0x0088
            androidx.lifecycle.l$a r2 = a
            java.lang.Object r2 = r7.get(r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            androidx.lifecycle.p r3 = androidx.lifecycle.p.a
            java.lang.Object r7 = r7.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0080
            androidx.savedstate.SavedStateRegistry r0 = r0.getSavedStateRegistry()
            androidx.savedstate.SavedStateRegistry$b r0 = r0.b()
            boolean r3 = r0 instanceof defpackage.Uu
            r4 = 0
            if (r3 == 0) goto L_0x0038
            Uu r0 = (defpackage.Uu) r0
            goto L_0x0039
        L_0x0038:
            r0 = r4
        L_0x0039:
            if (r0 == 0) goto L_0x0078
            Vu r1 = b(r1)
            java.util.LinkedHashMap r1 = r1.a
            java.lang.Object r3 = r1.get(r7)
            androidx.lifecycle.k r3 = (androidx.lifecycle.k) r3
            if (r3 != 0) goto L_0x0077
            java.lang.Class<? extends java.lang.Object>[] r3 = androidx.lifecycle.k.a
            r0.c()
            android.os.Bundle r3 = r0.f581a
            if (r3 == 0) goto L_0x0057
            android.os.Bundle r3 = r3.getBundle(r7)
            goto L_0x0058
        L_0x0057:
            r3 = r4
        L_0x0058:
            android.os.Bundle r5 = r0.f581a
            if (r5 == 0) goto L_0x005f
            r5.remove(r7)
        L_0x005f:
            android.os.Bundle r5 = r0.f581a
            if (r5 == 0) goto L_0x006b
            boolean r5 = r5.isEmpty()
            r6 = 1
            if (r5 != r6) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 == 0) goto L_0x0070
            r0.f581a = r4
        L_0x0070:
            androidx.lifecycle.k r3 = androidx.lifecycle.k.a.a(r3, r2)
            r1.put(r7, r3)
        L_0x0077:
            return r3
        L_0x0078:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call"
            r7.<init>(r0)
            throw r7
        L_0x0080:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `VIEW_MODEL_KEY`"
            r7.<init>(r0)
            throw r7
        L_0x0088:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`"
            r7.<init>(r0)
            throw r7
        L_0x0090:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.l.a(androidx.lifecycle.viewmodel.a):androidx.lifecycle.k");
    }

    public static final Vu b(AC ac) {
        CreationExtras creationExtras;
        C1177ig.f(ac, "<this>");
        ArrayList arrayList = new ArrayList();
        Class<Vu> cls = Vu.class;
        C1318p5 a2 = C0584Ls.a(cls);
        d dVar = d.a;
        C1177ig.f(dVar, "initializer");
        Class<?> a3 = a2.a();
        C1177ig.d(a3, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new C0421zC(a3, dVar));
        C0421zC[] zCVarArr = (C0421zC[]) arrayList.toArray(new C0421zC[0]);
        Uf uf = new Uf((C0421zC[]) Arrays.copyOf(zCVarArr, zCVarArr.length));
        ViewModelStore viewModelStore = ac.getViewModelStore();
        if (ac instanceof c) {
            creationExtras = ((c) ac).getDefaultViewModelCreationExtras();
        } else {
            creationExtras = CreationExtras.a.a;
        }
        return (Vu) new ViewModelProvider(viewModelStore, uf, creationExtras).b(cls, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
