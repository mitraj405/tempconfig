package defpackage;

import defpackage.V4;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* renamed from: K6  reason: default package */
/* compiled from: ConflatedBufferedChannel.kt */
public final class K6<E> extends C1296o3<E> {
    public final int d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public K6(int r4, java.lang.Object r5, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r6) {
        /*
            r3 = this;
            r3.<init>(r4, r6)
            r3.d = r5
            r6 = 1
            r0 = 0
            if (r5 == r6) goto L_0x000b
            r5 = r6
            goto L_0x000c
        L_0x000b:
            r5 = r0
        L_0x000c:
            if (r5 != 0) goto L_0x00d2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "This implementation does not support suspension for senders, use "
            r4.<init>(r5)
            java.lang.Class<o3> r5 = defpackage.C1296o3.class
            p5 r5 = defpackage.C0584Ls.a(r5)
            java.lang.String r0 = "jClass"
            java.lang.Class<?> r5 = r5.f6887a
            defpackage.C1177ig.f(r5, r0)
            boolean r0 = r5.isAnonymousClass()
            r1 = 0
            if (r0 != 0) goto L_0x00c2
            boolean r0 = r5.isLocalClass()
            if (r0 == 0) goto L_0x0089
            java.lang.String r1 = r5.getSimpleName()
            java.lang.reflect.Method r0 = r5.getEnclosingMethod()
            r2 = 36
            if (r0 != 0) goto L_0x0071
            java.lang.reflect.Constructor r5 = r5.getEnclosingConstructor()
            if (r5 != 0) goto L_0x0059
            int r5 = defpackage.C1337py.X0(r1, r2)
            r0 = -1
            if (r5 != r0) goto L_0x004a
            goto L_0x00c2
        L_0x004a:
            int r5 = r5 + r6
            int r6 = r1.length()
            java.lang.String r1 = r1.substring(r5, r6)
            java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
            defpackage.C1177ig.e(r1, r5)
            goto L_0x00c2
        L_0x0059:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r5 = r5.getName()
            r6.append(r5)
            r6.append(r2)
            java.lang.String r5 = r6.toString()
            java.lang.String r1 = defpackage.C1337py.a1(r1, r5)
            goto L_0x00c2
        L_0x0071:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.getName()
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = defpackage.C1337py.a1(r1, r5)
            goto L_0x00c2
        L_0x0089:
            boolean r6 = r5.isArray()
            java.util.LinkedHashMap r0 = defpackage.C1318p5.a
            if (r6 == 0) goto L_0x00b1
            java.lang.Class r5 = r5.getComponentType()
            boolean r6 = r5.isPrimitive()
            java.lang.String r2 = "Array"
            if (r6 == 0) goto L_0x00ad
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r0.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00ad
            java.lang.String r1 = r5.concat(r2)
        L_0x00ad:
            if (r1 != 0) goto L_0x00c2
            r1 = r2
            goto L_0x00c2
        L_0x00b1:
            java.lang.String r6 = r5.getName()
            java.lang.Object r6 = r0.get(r6)
            r1 = r6
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x00c2
            java.lang.String r1 = r5.getSimpleName()
        L_0x00c2:
            java.lang.String r5 = " instead"
            java.lang.String r4 = defpackage.C0709Uj.j(r4, r1, r5)
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L_0x00d2:
            if (r4 < r6) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r6 = r0
        L_0x00d6:
            if (r6 == 0) goto L_0x00d9
            return
        L_0x00d9:
            java.lang.String r5 = "Buffered channel capacity must be at least 1, but "
            java.lang.String r6 = " was specified"
            java.lang.String r4 = defpackage.C1058d.y(r5, r4, r6)
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.K6.<init>(int, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return kotlin.Unit.a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ee A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object K(E r20, boolean r21) {
        /*
            r19 = this;
            r8 = r19
            int r0 = r8.d
            r9 = 0
            r10 = 3
            r11 = 1
            if (r0 != r10) goto L_0x002c
            java.lang.Object r0 = super.d(r20)
            boolean r1 = r0 instanceof defpackage.V4.b
            r1 = r1 ^ r11
            if (r1 != 0) goto L_0x00f3
            boolean r1 = r0 instanceof defpackage.V4.a
            if (r1 == 0) goto L_0x0018
            goto L_0x00f3
        L_0x0018:
            if (r21 == 0) goto L_0x0028
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r8.f5614a
            if (r0 == 0) goto L_0x0028
            r12 = r20
            cA r0 = defpackage.r1.i(r0, r12, r9)
            if (r0 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            kotlin.Unit r0 = kotlin.Unit.a
            goto L_0x00f3
        L_0x002c:
            r12 = r20
            zD r13 = defpackage.C1361r3.f6940a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.C1296o3.f5610a
            java.lang.Object r0 = r0.get(r8)
            W4 r0 = (defpackage.W4) r0
        L_0x0038:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = defpackage.C1296o3.a
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r14 = r1 & r3
            r3 = 0
            boolean r16 = r8.w(r1, r3)
            int r7 = defpackage.C1361r3.a
            long r4 = (long) r7
            long r1 = r14 / r4
            long r9 = r14 % r4
            int r9 = (int) r9
            long r11 = r0.f3758a
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0074
            W4 r1 = defpackage.C1296o3.a(r8, r1, r0)
            if (r1 != 0) goto L_0x0072
            if (r16 == 0) goto L_0x006c
            java.lang.Throwable r0 = r19.t()
            V4$a r1 = new V4$a
            r1.<init>(r0)
        L_0x0069:
            r0 = r1
            goto L_0x00f3
        L_0x006c:
            r12 = r20
            r9 = 0
            r10 = 3
            r11 = 1
            goto L_0x0038
        L_0x0072:
            r11 = r1
            goto L_0x0075
        L_0x0074:
            r11 = r0
        L_0x0075:
            r0 = r19
            r1 = r11
            r2 = r9
            r3 = r20
            r17 = r4
            r4 = r14
            r6 = r13
            r12 = r7
            r7 = r16
            int r0 = defpackage.C1296o3.b(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00ee
            r1 = 1
            if (r0 == r1) goto L_0x00f1
            r2 = 2
            if (r0 == r2) goto L_0x00c3
            r2 = 3
            if (r0 == r2) goto L_0x00b7
            r3 = 4
            if (r0 == r3) goto L_0x00a2
            r3 = 5
            if (r0 == r3) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            r11.a()
        L_0x009b:
            r12 = r20
            r10 = r2
            r0 = r11
            r9 = 0
            r11 = r1
            goto L_0x0038
        L_0x00a2:
            long r0 = r19.r()
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ad
            r11.a()
        L_0x00ad:
            java.lang.Throwable r0 = r19.t()
            V4$a r1 = new V4$a
            r1.<init>(r0)
            goto L_0x0069
        L_0x00b7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c3:
            if (r16 == 0) goto L_0x00d2
            r11.h()
            java.lang.Throwable r0 = r19.t()
            V4$a r1 = new V4$a
            r1.<init>(r0)
            goto L_0x0069
        L_0x00d2:
            boolean r0 = r13 instanceof defpackage.C1256mD
            if (r0 == 0) goto L_0x00da
            r0 = r13
            mD r0 = (defpackage.C1256mD) r0
            goto L_0x00db
        L_0x00da:
            r0 = 0
        L_0x00db:
            if (r0 == 0) goto L_0x00e2
            int r7 = r9 + r12
            r0.b(r11, r7)
        L_0x00e2:
            long r0 = r11.f3758a
            long r0 = r0 * r17
            long r2 = (long) r9
            long r0 = r0 + r2
            r8.j(r0)
            kotlin.Unit r0 = kotlin.Unit.a
            goto L_0x00f3
        L_0x00ee:
            r11.a()
        L_0x00f1:
            kotlin.Unit r0 = kotlin.Unit.a
        L_0x00f3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.K6.K(java.lang.Object, boolean):java.lang.Object");
    }

    public final Object d(E e) {
        return K(e, false);
    }

    public final Object s(E e, Continuation<? super Unit> continuation) {
        C0155cA i;
        Object K = K(e, true);
        boolean z = K instanceof V4.a;
        if (!z) {
            return Unit.a;
        }
        if (z) {
            V4.a aVar = (V4.a) K;
        }
        Function1<E, Unit> function1 = this.f5614a;
        if (function1 == null || (i = r1.i(function1, e, (C0155cA) null)) == null) {
            throw t();
        }
        C1354qp.g(i, t());
        throw i;
    }

    public final boolean y() {
        if (this.d == 2) {
            return true;
        }
        return false;
    }
}
