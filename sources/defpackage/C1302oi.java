package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: oi  reason: default package and case insensitive filesystem */
/* compiled from: LockFreeLinkedList.kt */
public class C1302oi {
    public static final AtomicReferenceFieldUpdater a;
    public static final AtomicReferenceFieldUpdater b;
    public static final AtomicReferenceFieldUpdater c;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* renamed from: oi$a */
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends W1<C1302oi> {
        public final C1302oi a;
        public C1302oi b;

        public a(C1302oi oiVar) {
            this.a = oiVar;
        }

        public final void b(Object obj, Object obj2) {
            boolean z;
            C1302oi oiVar;
            C1302oi oiVar2 = (C1302oi) obj;
            boolean z2 = true;
            if (obj2 == null) {
                z = true;
            } else {
                z = false;
            }
            C1302oi oiVar3 = this.a;
            if (z) {
                oiVar = oiVar3;
            } else {
                oiVar = this.b;
            }
            if (oiVar != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1302oi.a;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(oiVar2, this, oiVar)) {
                        if (atomicReferenceFieldUpdater.get(oiVar2) != this) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z2 && z) {
                    C1302oi oiVar4 = this.b;
                    C1177ig.c(oiVar4);
                    oiVar3.e(oiVar4);
                }
            }
        }
    }

    /* renamed from: oi$b */
    /* compiled from: LockFreeLinkedList.kt */
    public /* synthetic */ class b extends C0509Fq {
        public b(Object obj) {
            super(obj);
        }

        public final String a() {
            return this.receiver.getClass().getSimpleName();
        }
    }

    static {
        Class<C1302oi> cls = C1302oi.class;
        Class<Object> cls2 = Object.class;
        a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        r6 = ((defpackage.C1374rt) r6).a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r5.compareAndSet(r4, r2, r6) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (r5.get(r4) == r2) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (r7 != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C1302oi d() {
        /*
            r11 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b
            java.lang.Object r1 = r0.get(r11)
            oi r1 = (defpackage.C1302oi) r1
            r2 = r1
        L_0x0009:
            r3 = 0
            r4 = r3
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a
            java.lang.Object r6 = r5.get(r2)
            r7 = 0
            r8 = 1
            if (r6 != r11) goto L_0x002a
            if (r1 != r2) goto L_0x0018
            return r2
        L_0x0018:
            boolean r3 = r0.compareAndSet(r11, r1, r2)
            if (r3 == 0) goto L_0x0020
            r7 = r8
            goto L_0x0026
        L_0x0020:
            java.lang.Object r3 = r0.get(r11)
            if (r3 == r1) goto L_0x0018
        L_0x0026:
            if (r7 != 0) goto L_0x0029
            goto L_0x0000
        L_0x0029:
            return r2
        L_0x002a:
            boolean r9 = r11.k()
            if (r9 == 0) goto L_0x0031
            return r3
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r9 = r6 instanceof defpackage.C1138go
            if (r9 == 0) goto L_0x003e
            go r6 = (defpackage.C1138go) r6
            r6.a(r2)
            goto L_0x0000
        L_0x003e:
            boolean r9 = r6 instanceof defpackage.C1374rt
            if (r9 == 0) goto L_0x0062
            if (r4 == 0) goto L_0x005b
            rt r6 = (defpackage.C1374rt) r6
            oi r6 = r6.a
        L_0x0048:
            boolean r3 = r5.compareAndSet(r4, r2, r6)
            if (r3 == 0) goto L_0x0050
            r7 = r8
            goto L_0x0056
        L_0x0050:
            java.lang.Object r3 = r5.get(r4)
            if (r3 == r2) goto L_0x0048
        L_0x0056:
            if (r7 != 0) goto L_0x0059
            goto L_0x0000
        L_0x0059:
            r2 = r4
            goto L_0x0009
        L_0x005b:
            java.lang.Object r2 = r0.get(r2)
            oi r2 = (defpackage.C1302oi) r2
            goto L_0x000b
        L_0x0062:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            defpackage.C1177ig.d(r6, r4)
            r4 = r6
            oi r4 = (defpackage.C1302oi) r4
            r10 = r4
            r4 = r2
            r2 = r10
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1302oi.d():oi");
    }

    public final void e(C1302oi oiVar) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            C1302oi oiVar2 = (C1302oi) atomicReferenceFieldUpdater.get(oiVar);
            if (g() == oiVar) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(oiVar, oiVar2, this)) {
                        if (atomicReferenceFieldUpdater.get(oiVar) != oiVar2) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z);
        if (k()) {
            oiVar.d();
        }
    }

    public final Object g() {
        while (true) {
            Object obj = a.get(this);
            if (!(obj instanceof C1138go)) {
                return obj;
            }
            ((C1138go) obj).a(this);
        }
    }

    public final C1302oi i() {
        C1374rt rtVar;
        C1302oi oiVar;
        Object g = g();
        if (g instanceof C1374rt) {
            rtVar = (C1374rt) g;
        } else {
            rtVar = null;
        }
        if (rtVar != null && (oiVar = rtVar.a) != null) {
            return oiVar;
        }
        C1177ig.d(g, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (C1302oi) g;
    }

    public final C1302oi j() {
        C1302oi d = d();
        if (d == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            while (true) {
                d = (C1302oi) obj;
                if (!d.k()) {
                    break;
                }
                obj = atomicReferenceFieldUpdater.get(d);
            }
        }
        return d;
    }

    public boolean k() {
        return g() instanceof C1374rt;
    }

    public String toString() {
        return new b(this) + '@' + C1149h8.a(this);
    }
}
