package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.Nu;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: LifecycleRegistry.kt */
public final class LifecycleRegistry extends Lifecycle {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Vb<Yh, a> f2180a = new Vb<>();

    /* renamed from: a  reason: collision with other field name */
    public Lifecycle.State f2181a = Lifecycle.State.INITIALIZED;

    /* renamed from: a  reason: collision with other field name */
    public final WeakReference<LifecycleOwner> f2182a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<Lifecycle.State> f2183a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2184a = true;
    public boolean b;
    public boolean c;

    /* compiled from: LifecycleRegistry.kt */
    public static final class a {
        public Lifecycle.State a;

        /* renamed from: a  reason: collision with other field name */
        public final f f2185a;

        public a(Yh yh, Lifecycle.State state) {
            f fVar;
            C1177ig.c(yh);
            HashMap hashMap = C0121ai.a;
            boolean z = yh instanceof f;
            boolean z2 = yh instanceof t8;
            if (z && z2) {
                fVar = new DefaultLifecycleObserverAdapter((t8) yh, (f) yh);
            } else if (z2) {
                fVar = new DefaultLifecycleObserverAdapter((t8) yh, (f) null);
            } else if (z) {
                fVar = (f) yh;
            } else {
                Class<?> cls = yh.getClass();
                if (C0121ai.b(cls) == 2) {
                    Object obj = C0121ai.b.get(cls);
                    C1177ig.c(obj);
                    List list = (List) obj;
                    if (list.size() == 1) {
                        fVar = new SingleGeneratedAdapterObserver(C0121ai.a((Constructor) list.get(0), yh));
                    } else {
                        int size = list.size();
                        b[] bVarArr = new b[size];
                        for (int i = 0; i < size; i++) {
                            bVarArr[i] = C0121ai.a((Constructor) list.get(i), yh);
                        }
                        fVar = new CompositeGeneratedAdaptersObserver(bVarArr);
                    }
                } else {
                    fVar = new ReflectiveGenericLifecycleObserver(yh);
                }
            }
            this.f2185a = fVar;
            this.a = state;
        }

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
            Lifecycle.State a2 = aVar.a();
            Lifecycle.State state = this.a;
            C1177ig.f(state, "state1");
            if (a2.compareTo(state) < 0) {
                state = a2;
            }
            this.a = state;
            this.f2185a.b(lifecycleOwner, aVar);
            this.a = a2;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        C1177ig.f(lifecycleOwner, "provider");
        this.f2182a = new WeakReference<>(lifecycleOwner);
    }

    public final void a(Yh yh) {
        LifecycleOwner lifecycleOwner;
        boolean z;
        C1177ig.f(yh, "observer");
        e("addObserver");
        Lifecycle.State state = this.f2181a;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(yh, state2);
        if (this.f2180a.b(yh, aVar) == null && (lifecycleOwner = this.f2182a.get()) != null) {
            if (this.a != 0 || this.b) {
                z = true;
            } else {
                z = false;
            }
            Lifecycle.State d = d(yh);
            this.a++;
            while (aVar.a.compareTo(d) < 0 && this.f2180a.a.containsKey(yh)) {
                Lifecycle.State state3 = aVar.a;
                ArrayList<Lifecycle.State> arrayList = this.f2183a;
                arrayList.add(state3);
                Lifecycle.a.C0020a aVar2 = Lifecycle.a.Companion;
                Lifecycle.State state4 = aVar.a;
                aVar2.getClass();
                Lifecycle.a b2 = Lifecycle.a.C0020a.b(state4);
                if (b2 != null) {
                    aVar.a(lifecycleOwner, b2);
                    arrayList.remove(arrayList.size() - 1);
                    d = d(yh);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.a);
                }
            }
            if (!z) {
                i();
            }
            this.a--;
        }
    }

    public final Lifecycle.State b() {
        return this.f2181a;
    }

    public final void c(Yh yh) {
        C1177ig.f(yh, "observer");
        e("removeObserver");
        this.f2180a.c(yh);
    }

    public final Lifecycle.State d(Yh yh) {
        Nu.c<K, V> cVar;
        Lifecycle.State state;
        a aVar;
        Vb<Yh, a> vb = this.f2180a;
        Lifecycle.State state2 = null;
        if (vb.a.containsKey(yh)) {
            cVar = vb.a.get(yh).b;
        } else {
            cVar = null;
        }
        if (cVar == null || (aVar = (a) cVar.f455b) == null) {
            state = null;
        } else {
            state = aVar.a;
        }
        ArrayList<Lifecycle.State> arrayList = this.f2183a;
        if (!arrayList.isEmpty()) {
            state2 = arrayList.get(arrayList.size() - 1);
        }
        Lifecycle.State state3 = this.f2181a;
        C1177ig.f(state3, "state1");
        if (state == null || state.compareTo(state3) >= 0) {
            state = state3;
        }
        if (state2 == null || state2.compareTo(state) >= 0) {
            return state;
        }
        return state2;
    }

    @SuppressLint({"RestrictedApi"})
    public final void e(String str) {
        boolean z;
        if (this.f2184a) {
            G1.d().f226a.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(lf.j("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(Lifecycle.a aVar) {
        C1177ig.f(aVar, "event");
        e("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(Lifecycle.State state) {
        boolean z;
        Lifecycle.State state2 = this.f2181a;
        if (state2 != state) {
            Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
            Lifecycle.State state4 = Lifecycle.State.DESTROYED;
            if (state2 == state3 && state == state4) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.f2181a = state;
                if (this.b || this.a != 0) {
                    this.c = true;
                    return;
                }
                this.b = true;
                i();
                this.b = false;
                if (this.f2181a == state4) {
                    this.f2180a = new Vb<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.f2181a + " in component " + this.f2182a.get()).toString());
        }
    }

    public final void h(Lifecycle.State state) {
        C1177ig.f(state, RemoteConfigConstants.ResponseFieldKey.STATE);
        e("setCurrentState");
        g(state);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0162 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r7 = this;
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> r0 = r7.f2182a
            java.lang.Object r0 = r0.get()
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            if (r0 == 0) goto L_0x0165
        L_0x000a:
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r1 = r7.f2180a
            int r2 = r1.c
            r3 = 0
            if (r2 != 0) goto L_0x0012
            goto L_0x0030
        L_0x0012:
            Nu$c<K, V> r1 = r1.a
            defpackage.C1177ig.c(r1)
            V r1 = r1.f455b
            androidx.lifecycle.LifecycleRegistry$a r1 = (androidx.lifecycle.LifecycleRegistry.a) r1
            androidx.lifecycle.Lifecycle$State r1 = r1.a
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r2 = r7.f2180a
            Nu$c<K, V> r2 = r2.b
            defpackage.C1177ig.c(r2)
            V r2 = r2.f455b
            androidx.lifecycle.LifecycleRegistry$a r2 = (androidx.lifecycle.LifecycleRegistry.a) r2
            androidx.lifecycle.Lifecycle$State r2 = r2.a
            if (r1 != r2) goto L_0x0032
            androidx.lifecycle.Lifecycle$State r1 = r7.f2181a
            if (r1 != r2) goto L_0x0032
        L_0x0030:
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = r3
        L_0x0033:
            if (r1 != 0) goto L_0x0162
            r7.c = r3
            androidx.lifecycle.Lifecycle$State r1 = r7.f2181a
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r2 = r7.f2180a
            Nu$c<K, V> r2 = r2.a
            defpackage.C1177ig.c(r2)
            V r2 = r2.f455b
            androidx.lifecycle.LifecycleRegistry$a r2 = (androidx.lifecycle.LifecycleRegistry.a) r2
            androidx.lifecycle.Lifecycle$State r2 = r2.a
            int r1 = r1.compareTo(r2)
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r2 = r7.f2183a
            if (r1 >= 0) goto L_0x00d0
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r1 = r7.f2180a
            Nu$b r3 = new Nu$b
            Nu$c<K, V> r4 = r1.b
            Nu$c<K, V> r5 = r1.a
            r3.<init>(r4, r5)
            java.util.WeakHashMap<Nu$f<K, V>, java.lang.Boolean> r1 = r1.f453a
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r1.put(r3, r4)
        L_0x0060:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x00d0
            boolean r1 = r7.c
            if (r1 != 0) goto L_0x00d0
            java.lang.Object r1 = r3.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.String r4 = "next()"
            defpackage.C1177ig.e(r1, r4)
            java.lang.Object r4 = r1.getKey()
            Yh r4 = (defpackage.Yh) r4
            java.lang.Object r1 = r1.getValue()
            androidx.lifecycle.LifecycleRegistry$a r1 = (androidx.lifecycle.LifecycleRegistry.a) r1
        L_0x0081:
            androidx.lifecycle.Lifecycle$State r5 = r1.a
            androidx.lifecycle.Lifecycle$State r6 = r7.f2181a
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto L_0x0060
            boolean r5 = r7.c
            if (r5 != 0) goto L_0x0060
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r5 = r7.f2180a
            java.util.HashMap<K, Nu$c<K, V>> r5 = r5.a
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x0060
            androidx.lifecycle.Lifecycle$a$a r5 = androidx.lifecycle.Lifecycle.a.Companion
            androidx.lifecycle.Lifecycle$State r6 = r1.a
            r5.getClass()
            androidx.lifecycle.Lifecycle$a r5 = androidx.lifecycle.Lifecycle.a.C0020a.a(r6)
            if (r5 == 0) goto L_0x00ba
            androidx.lifecycle.Lifecycle$State r6 = r5.a()
            r2.add(r6)
            r1.a(r0, r5)
            int r5 = r2.size()
            int r5 = r5 + -1
            r2.remove(r5)
            goto L_0x0081
        L_0x00ba:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "no event down from "
            r2.<init>(r3)
            androidx.lifecycle.Lifecycle$State r1 = r1.a
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d0:
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r1 = r7.f2180a
            Nu$c<K, V> r1 = r1.b
            boolean r3 = r7.c
            if (r3 != 0) goto L_0x000a
            if (r1 == 0) goto L_0x000a
            androidx.lifecycle.Lifecycle$State r3 = r7.f2181a
            V r1 = r1.f455b
            androidx.lifecycle.LifecycleRegistry$a r1 = (androidx.lifecycle.LifecycleRegistry.a) r1
            androidx.lifecycle.Lifecycle$State r1 = r1.a
            int r1 = r3.compareTo(r1)
            if (r1 <= 0) goto L_0x000a
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r1 = r7.f2180a
            r1.getClass()
            Nu$d r3 = new Nu$d
            r3.<init>()
            java.util.WeakHashMap<Nu$f<K, V>, java.lang.Boolean> r1 = r1.f453a
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r1.put(r3, r4)
        L_0x00f9:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x000a
            boolean r1 = r7.c
            if (r1 != 0) goto L_0x000a
            java.lang.Object r1 = r3.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            Yh r4 = (defpackage.Yh) r4
            java.lang.Object r1 = r1.getValue()
            androidx.lifecycle.LifecycleRegistry$a r1 = (androidx.lifecycle.LifecycleRegistry.a) r1
        L_0x0115:
            androidx.lifecycle.Lifecycle$State r5 = r1.a
            androidx.lifecycle.Lifecycle$State r6 = r7.f2181a
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L_0x00f9
            boolean r5 = r7.c
            if (r5 != 0) goto L_0x00f9
            Vb<Yh, androidx.lifecycle.LifecycleRegistry$a> r5 = r7.f2180a
            java.util.HashMap<K, Nu$c<K, V>> r5 = r5.a
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x00f9
            androidx.lifecycle.Lifecycle$State r5 = r1.a
            r2.add(r5)
            androidx.lifecycle.Lifecycle$a$a r5 = androidx.lifecycle.Lifecycle.a.Companion
            androidx.lifecycle.Lifecycle$State r6 = r1.a
            r5.getClass()
            androidx.lifecycle.Lifecycle$a r5 = androidx.lifecycle.Lifecycle.a.C0020a.b(r6)
            if (r5 == 0) goto L_0x014c
            r1.a(r0, r5)
            int r5 = r2.size()
            int r5 = r5 + -1
            r2.remove(r5)
            goto L_0x0115
        L_0x014c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "no event up from "
            r2.<init>(r3)
            androidx.lifecycle.Lifecycle$State r1 = r1.a
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0162:
            r7.c = r3
            return
        L_0x0165:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.i():void");
    }
}
