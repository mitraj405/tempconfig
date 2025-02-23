package defpackage;

import java.util.List;
import java.util.Locale;

/* renamed from: Sh  reason: default package */
/* compiled from: Layer */
public final class Sh {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f519a;

    /* renamed from: a  reason: collision with other field name */
    public final long f520a;

    /* renamed from: a  reason: collision with other field name */
    public final B9 f521a;

    /* renamed from: a  reason: collision with other field name */
    public final H0 f522a;

    /* renamed from: a  reason: collision with other field name */
    public final M0 f523a;

    /* renamed from: a  reason: collision with other field name */
    public final N0 f524a;

    /* renamed from: a  reason: collision with other field name */
    public final P0 f525a;

    /* renamed from: a  reason: collision with other field name */
    public final C0181ej f526a;

    /* renamed from: a  reason: collision with other field name */
    public final String f527a;

    /* renamed from: a  reason: collision with other field name */
    public final List<Z6> f528a;

    /* renamed from: a  reason: collision with other field name */
    public final nh f529a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f530a;
    public final float b;

    /* renamed from: b  reason: collision with other field name */
    public final int f531b;

    /* renamed from: b  reason: collision with other field name */
    public final long f532b;

    /* renamed from: b  reason: collision with other field name */
    public final String f533b;

    /* renamed from: b  reason: collision with other field name */
    public final List<C0331sk> f534b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final List<Bh<Float>> f535c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX WARNING: type inference failed for: r1v4, types: [int] */
    /* JADX WARNING: type inference failed for: r1v19, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Sh(java.util.List<defpackage.Z6> r4, defpackage.C0181ej r5, java.lang.String r6, long r7, java.lang.Object r9, long r10, java.lang.String r12, java.util.List<defpackage.C0331sk> r13, defpackage.P0 r14, int r15, int r16, int r17, float r18, float r19, int r20, int r21, defpackage.M0 r22, defpackage.N0 r23, java.util.List<defpackage.Bh<java.lang.Float>> r24, java.lang.Object r25, defpackage.H0 r26, boolean r27, defpackage.nh r28, defpackage.B9 r29) {
        /*
            r3 = this;
            r0 = r3
            r3.<init>()
            r1 = r4
            r0.f528a = r1
            r1 = r5
            r0.f526a = r1
            r1 = r6
            r0.f527a = r1
            r1 = r7
            r0.f520a = r1
            r1 = r9
            r0.f519a = r1
            r1 = r10
            r0.f532b = r1
            r1 = r12
            r0.f533b = r1
            r1 = r13
            r0.f534b = r1
            r1 = r14
            r0.f525a = r1
            r1 = r15
            r0.f531b = r1
            r1 = r16
            r0.c = r1
            r1 = r17
            r0.d = r1
            r1 = r18
            r0.a = r1
            r1 = r19
            r0.b = r1
            r1 = r20
            r0.e = r1
            r1 = r21
            r0.f = r1
            r1 = r22
            r0.f523a = r1
            r1 = r23
            r0.f524a = r1
            r1 = r24
            r0.f535c = r1
            r1 = r25
            r0.g = r1
            r1 = r26
            r0.f522a = r1
            r1 = r27
            r0.f530a = r1
            r1 = r28
            r0.f529a = r1
            r1 = r29
            r0.f521a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Sh.<init>(java.util.List, ej, java.lang.String, long, int, long, java.lang.String, java.util.List, P0, int, int, int, float, float, int, int, M0, N0, java.util.List, int, H0, boolean, nh, B9):void");
    }

    public final String a(String str) {
        int i;
        StringBuilder J = xx.J(str);
        J.append(this.f527a);
        J.append("\n");
        C0181ej ejVar = this.f526a;
        Sh sh = (Sh) ejVar.f2900a.d(this.f532b, (Long) null);
        if (sh != null) {
            J.append("\t\tParents: ");
            J.append(sh.f527a);
            for (Sh sh2 = (Sh) ejVar.f2900a.d(sh.f532b, (Long) null); sh2 != null; sh2 = (Sh) ejVar.f2900a.d(sh2.f532b, (Long) null)) {
                J.append("->");
                J.append(sh2.f527a);
            }
            J.append(str);
            J.append("\n");
        }
        List<C0331sk> list = this.f534b;
        if (!list.isEmpty()) {
            J.append(str);
            J.append("\tMasks: ");
            J.append(list.size());
            J.append("\n");
        }
        int i2 = this.f531b;
        if (!(i2 == 0 || (i = this.c) == 0)) {
            J.append(str);
            J.append("\tBackground: ");
            J.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.d)}));
        }
        List<Z6> list2 = this.f528a;
        if (!list2.isEmpty()) {
            J.append(str);
            J.append("\tShapes:\n");
            for (Z6 next : list2) {
                J.append(str);
                J.append("\t\t");
                J.append(next);
                J.append("\n");
            }
        }
        return J.toString();
    }

    public final String toString() {
        return a("");
    }
}
