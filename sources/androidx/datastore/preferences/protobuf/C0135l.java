package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0135l.a;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.p;
import androidx.datastore.preferences.protobuf.r;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.l  reason: case insensitive filesystem */
/* compiled from: FieldSet */
public final class C0135l<T extends a<T>> {
    public static final C0135l a = new C0135l(0);

    /* renamed from: a  reason: collision with other field name */
    public final J<T, Object> f1931a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1932a;
    public boolean b;

    /* renamed from: androidx.datastore.preferences.protobuf.l$a */
    /* compiled from: FieldSet */
    public interface a<T extends a<T>> extends Comparable<T> {
        void b();

        HD c();

        void d();

        void e();

        void g();

        n.a k(A.a aVar, A a);
    }

    public C0135l() {
        int i = J.d;
        this.f1931a = new I(16);
    }

    public static int b(GD gd, int i, Object obj) {
        int v = s5.v(i);
        if (gd == GD.f229a) {
            v *= 2;
        }
        return c(gd, obj) + v;
    }

    public static int c(GD gd, Object obj) {
        switch (gd.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                Logger logger = s5.a;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                Logger logger2 = s5.a;
                return 4;
            case 2:
                return s5.z(((Long) obj).longValue());
            case 3:
                return s5.z(((Long) obj).longValue());
            case 4:
                return s5.m(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                Logger logger3 = s5.a;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                Logger logger4 = s5.a;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                Logger logger5 = s5.a;
                return 1;
            case 8:
                if (!(obj instanceof x3)) {
                    return s5.u((String) obj);
                }
                Logger logger6 = s5.a;
                int size = ((x3) obj).size();
                return s5.x(size) + size;
            case 9:
                Logger logger7 = s5.a;
                return ((A) obj).getSerializedSize();
            case 10:
                if (obj instanceof r) {
                    return s5.o((r) obj);
                }
                Logger logger8 = s5.a;
                int serializedSize = ((A) obj).getSerializedSize();
                return s5.x(serializedSize) + serializedSize;
            case 11:
                if (obj instanceof x3) {
                    Logger logger9 = s5.a;
                    int size2 = ((x3) obj).size();
                    return s5.x(size2) + size2;
                }
                Logger logger10 = s5.a;
                int length = ((byte[]) obj).length;
                return s5.x(length) + length;
            case 12:
                return s5.x(((Integer) obj).intValue());
            case 13:
                if (obj instanceof p.a) {
                    return s5.m(((p.a) obj).getNumber());
                }
                return s5.m(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger11 = s5.a;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger12 = s5.a;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return s5.x((intValue >> 31) ^ (intValue << 1));
            case 17:
                long longValue = ((Long) obj).longValue();
                return s5.z((longValue >> 63) ^ (longValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(a<?> aVar, Object obj) {
        aVar.d();
        aVar.g();
        aVar.b();
        return b((GD) null, 0, obj);
    }

    public static int f(Map.Entry entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (aVar.c() != HD.MESSAGE) {
            return d(aVar, value);
        }
        aVar.b();
        aVar.e();
        if (value instanceof r) {
            ((a) entry.getKey()).g();
            return s5.o((r) value) + s5.v(3) + s5.w(2, 0) + (s5.v(1) * 2);
        }
        ((a) entry.getKey()).g();
        int w = s5.w(2, 0) + (s5.v(1) * 2);
        int v = s5.v(3);
        int serializedSize = ((A) value).getSerializedSize();
        return s5.x(serializedSize) + serializedSize + v + w;
    }

    public static <T extends a<T>> boolean j(Map.Entry<T, Object> entry) {
        a aVar = (a) entry.getKey();
        if (aVar.c() == HD.MESSAGE) {
            aVar.b();
            Object value = entry.getValue();
            if (value instanceof A) {
                if (!((A) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof r) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if ((r2 instanceof byte[]) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if ((r2 instanceof androidx.datastore.preferences.protobuf.r) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if ((r2 instanceof androidx.datastore.preferences.protobuf.p.a) == false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void n(defpackage.GD r1, java.lang.Object r2) {
        /*
            java.nio.charset.Charset r0 = androidx.datastore.preferences.protobuf.p.a
            r2.getClass()
            HD r1 = r1.f232a
            int r1 = r1.ordinal()
            r0 = 0
            switch(r1) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0039;
                case 2: goto L_0x0036;
                case 3: goto L_0x0033;
                case 4: goto L_0x0030;
                case 5: goto L_0x002d;
                case 6: goto L_0x0022;
                case 7: goto L_0x0019;
                case 8: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x003e
        L_0x0010:
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.A
            if (r1 != 0) goto L_0x002a
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.r
            if (r1 == 0) goto L_0x003e
            goto L_0x002a
        L_0x0019:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x002a
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.p.a
            if (r1 == 0) goto L_0x003e
            goto L_0x002a
        L_0x0022:
            boolean r1 = r2 instanceof defpackage.x3
            if (r1 != 0) goto L_0x002a
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L_0x003e
        L_0x002a:
            r1 = 1
            r0 = r1
            goto L_0x003e
        L_0x002d:
            boolean r0 = r2 instanceof java.lang.String
            goto L_0x003e
        L_0x0030:
            boolean r0 = r2 instanceof java.lang.Boolean
            goto L_0x003e
        L_0x0033:
            boolean r0 = r2 instanceof java.lang.Double
            goto L_0x003e
        L_0x0036:
            boolean r0 = r2 instanceof java.lang.Float
            goto L_0x003e
        L_0x0039:
            boolean r0 = r2 instanceof java.lang.Long
            goto L_0x003e
        L_0x003c:
            boolean r0 = r2 instanceof java.lang.Integer
        L_0x003e:
            if (r0 == 0) goto L_0x0041
            return
        L_0x0041:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0135l.n(GD, java.lang.Object):void");
    }

    public static void o(s5 s5Var, GD gd, int i, Object obj) throws IOException {
        if (gd == GD.f229a) {
            s5Var.S(i, 3);
            ((A) obj).e(s5Var);
            s5Var.S(i, 4);
            return;
        }
        s5Var.S(i, gd.c);
        switch (gd.ordinal()) {
            case 0:
                s5Var.J(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                s5Var.H(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                s5Var.W(((Long) obj).longValue());
                return;
            case 3:
                s5Var.W(((Long) obj).longValue());
                return;
            case 4:
                s5Var.L(((Integer) obj).intValue());
                return;
            case 5:
                s5Var.J(((Long) obj).longValue());
                return;
            case 6:
                s5Var.H(((Integer) obj).intValue());
                return;
            case 7:
                s5Var.B(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (obj instanceof x3) {
                    s5Var.F((x3) obj);
                    return;
                } else {
                    s5Var.R((String) obj);
                    return;
                }
            case 9:
                ((A) obj).e(s5Var);
                return;
            case 10:
                s5Var.N((A) obj);
                return;
            case 11:
                if (obj instanceof x3) {
                    s5Var.F((x3) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                s5Var.D(bArr, bArr.length);
                return;
            case 12:
                s5Var.U(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof p.a) {
                    s5Var.L(((p.a) obj).getNumber());
                    return;
                } else {
                    s5Var.L(((Integer) obj).intValue());
                    return;
                }
            case 14:
                s5Var.H(((Integer) obj).intValue());
                return;
            case 15:
                s5Var.J(((Long) obj).longValue());
                return;
            case 16:
                int intValue = ((Integer) obj).intValue();
                s5Var.U((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) obj).longValue();
                s5Var.W((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final C0135l<T> clone() {
        J<T, Object> j;
        C0135l<T> lVar = new C0135l<>();
        int i = 0;
        while (true) {
            j = this.f1931a;
            if (i >= j.d()) {
                break;
            }
            Map.Entry<T, Object> c = j.c(i);
            lVar.m((a) c.getKey(), c.getValue());
            i++;
        }
        for (Map.Entry next : j.e()) {
            lVar.m((a) next.getKey(), next.getValue());
        }
        lVar.b = this.b;
        return lVar;
    }

    public final Object e(T t) {
        Object obj = this.f1931a.get(t);
        if (obj instanceof r) {
            return ((r) obj).a((A) null);
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0135l)) {
            return false;
        }
        return this.f1931a.equals(((C0135l) obj).f1931a);
    }

    public final int g() {
        J<T, Object> j;
        int i = 0;
        int i2 = 0;
        while (true) {
            j = this.f1931a;
            if (i >= j.d()) {
                break;
            }
            Map.Entry<T, Object> c = j.c(i);
            i2 += d((a) c.getKey(), c.getValue());
            i++;
        }
        for (Map.Entry next : j.e()) {
            i2 += d((a) next.getKey(), next.getValue());
        }
        return i2;
    }

    public final boolean h() {
        return this.f1931a.isEmpty();
    }

    public final int hashCode() {
        return this.f1931a.hashCode();
    }

    public final boolean i() {
        int i = 0;
        while (true) {
            J<T, Object> j = this.f1931a;
            if (i >= j.d()) {
                for (Map.Entry<T, Object> j2 : j.e()) {
                    if (!j(j2)) {
                        return false;
                    }
                }
                return true;
            } else if (!j(j.c(i))) {
                return false;
            } else {
                i++;
            }
        }
    }

    public final Iterator<Map.Entry<T, Object>> k() {
        boolean z = this.b;
        J<T, Object> j = this.f1931a;
        if (z) {
            return new r.b(j.entrySet().iterator());
        }
        return j.entrySet().iterator();
    }

    public final void l(Map.Entry<T, Object> entry) {
        a aVar = (a) entry.getKey();
        byte[] value = entry.getValue();
        if (value instanceof r) {
            value = ((r) value).a((A) null);
        }
        aVar.b();
        HD c = aVar.c();
        HD hd = HD.MESSAGE;
        J<T, Object> j = this.f1931a;
        if (c == hd) {
            Object e = e(aVar);
            if (e == null) {
                if (value instanceof byte[]) {
                    byte[] bArr = (byte[]) value;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    value = bArr2;
                }
                j.put(aVar, value);
                return;
            }
            j.put(aVar, aVar.k(((A) e).c(), (A) value).f());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr3 = (byte[]) value;
            byte[] bArr4 = new byte[bArr3.length];
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            value = bArr4;
        }
        j.put(aVar, value);
    }

    public final void m(T t, Object obj) {
        t.b();
        t.d();
        n((GD) null, obj);
        if (obj instanceof r) {
            this.b = true;
        }
        this.f1931a.put(t, obj);
    }

    public C0135l(int i) {
        int i2 = J.d;
        I i3 = new I(0);
        this.f1931a = i3;
        if (!this.f1932a) {
            i3.g();
            this.f1932a = true;
        }
        if (!this.f1932a) {
            i3.g();
            this.f1932a = true;
        }
    }
}
