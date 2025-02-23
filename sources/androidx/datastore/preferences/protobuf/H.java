package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0135l;
import androidx.datastore.preferences.protobuf.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* compiled from: SchemaUtil */
public final class H {
    public static final K<?, ?> a = A(false);

    /* renamed from: a  reason: collision with other field name */
    public static final M f1912a = new M();

    /* renamed from: a  reason: collision with other field name */
    public static final Class<?> f1913a;
    public static final K<?, ?> b = A(true);

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f1913a = cls;
    }

    public static K<?, ?> A(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (K) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends C0135l.a<FT>> void B(C0133j<FT> jVar, T t, T t2) {
        J<T, Object> j;
        C0135l<FT> c = jVar.c(t2);
        if (!c.h()) {
            C0135l<FT> d = jVar.d(t);
            d.getClass();
            int i = 0;
            while (true) {
                j = c.f1931a;
                if (i >= j.d()) {
                    break;
                }
                d.l(j.c(i));
                i++;
            }
            for (Map.Entry<T, Object> l : j.e()) {
                d.l(l);
            }
        }
    }

    public static boolean C(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static <UT, UB> UB D(int i, int i2, UB ub, K<UT, UB> k) {
        if (ub == null) {
            ub = k.m();
        }
        k.e(ub, i, (long) i2);
        return ub;
    }

    public static void E(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Boolean) list.get(i4)).booleanValue();
                    Logger logger = s5.a;
                    i3++;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.B(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.C(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public static void F(int i, List list, C0130g gVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            gVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                gVar.a.E(i, (x3) list.get(i2));
            }
        }
    }

    public static void G(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Double) list.get(i4)).doubleValue();
                    Logger logger = s5.a;
                    i3 += 8;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.J(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                double doubleValue = ((Double) list.get(i2)).doubleValue();
                s5Var.getClass();
                s5Var.I(i, Double.doubleToRawLongBits(doubleValue));
                i2++;
            }
        }
    }

    public static void H(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += s5.m(((Integer) list.get(i4)).intValue());
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.L(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.K(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public static void I(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Integer) list.get(i4)).intValue();
                    Logger logger = s5.a;
                    i3 += 4;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.H(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.G(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public static void J(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Long) list.get(i4)).longValue();
                    Logger logger = s5.a;
                    i3 += 8;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.J(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.I(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static void K(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Float) list.get(i4)).floatValue();
                    Logger logger = s5.a;
                    i3 += 4;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.H(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                float floatValue = ((Float) list.get(i2)).floatValue();
                s5Var.getClass();
                s5Var.G(i, Float.floatToRawIntBits(floatValue));
                i2++;
            }
        }
    }

    public static void L(int i, List list, C0130g gVar, kv kvVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            gVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                gVar.h(i, kvVar, list.get(i2));
            }
        }
    }

    public static void M(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += s5.m(((Integer) list.get(i4)).intValue());
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.L(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.K(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public static void N(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += s5.z(((Long) list.get(i4)).longValue());
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.W(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.V(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static void O(int i, List list, C0130g gVar, kv kvVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            gVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                gVar.k(i, kvVar, list.get(i2));
            }
        }
    }

    public static void P(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Integer) list.get(i4)).intValue();
                    Logger logger = s5.a;
                    i3 += 4;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.H(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.G(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public static void Q(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Long) list.get(i4)).longValue();
                    Logger logger = s5.a;
                    i3 += 8;
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.J(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.I(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static void R(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    int intValue = ((Integer) list.get(i4)).intValue();
                    i3 += s5.x((intValue >> 31) ^ (intValue << 1));
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    int intValue2 = ((Integer) list.get(i2)).intValue();
                    s5Var.U((intValue2 >> 31) ^ (intValue2 << 1));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                int intValue3 = ((Integer) list.get(i2)).intValue();
                s5Var.T(i, (intValue3 >> 31) ^ (intValue3 << 1));
                i2++;
            }
        }
    }

    public static void S(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    long longValue = ((Long) list.get(i4)).longValue();
                    i3 += s5.z((longValue >> 63) ^ (longValue << 1));
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    long longValue2 = ((Long) list.get(i2)).longValue();
                    s5Var.W((longValue2 >> 63) ^ (longValue2 << 1));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                s5Var.V(i, (longValue3 >> 63) ^ (longValue3 << 1));
                i2++;
            }
        }
    }

    public static void T(int i, List list, C0130g gVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            gVar.getClass();
            boolean z = list instanceof Vh;
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                Vh vh = (Vh) list;
                while (i2 < list.size()) {
                    Object raw = vh.getRaw(i2);
                    if (raw instanceof String) {
                        s5Var.Q(i, (String) raw);
                    } else {
                        s5Var.E(i, (x3) raw);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.Q(i, (String) list.get(i2));
                i2++;
            }
        }
    }

    public static void U(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += s5.x(((Integer) list.get(i4)).intValue());
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.U(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.T(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public static void V(int i, List list, C0130g gVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            s5 s5Var = gVar.a;
            int i2 = 0;
            if (z) {
                s5Var.S(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += s5.z(((Long) list.get(i4)).longValue());
                }
                s5Var.U(i3);
                while (i2 < list.size()) {
                    s5Var.W(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                s5Var.V(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return s5.d(i) * size;
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static int c(int i, List<x3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v = s5.v(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int size2 = list.get(i2).size();
            v += s5.x(size2) + size2;
        }
        return v;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + e(list);
    }

    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o) {
            o oVar = (o) list;
            i = 0;
            while (i2 < size) {
                oVar.b(i2);
                i += s5.m(oVar.a[i2]);
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + s5.m(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int f(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return s5.h(i) * size;
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return s5.i(i) * size;
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i, List<A> list, kv kvVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += s5.k(i, list.get(i3), kvVar);
        }
        return i2;
    }

    public static int k(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + l(list);
    }

    public static int l(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o) {
            o oVar = (o) list;
            i = 0;
            while (i2 < size) {
                oVar.b(i2);
                i += s5.m(oVar.a[i2]);
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + s5.m(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int m(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (s5.v(i) * list.size()) + n(list);
    }

    public static int n(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i = 0;
            while (i2 < size) {
                vVar.b(i2);
                i += s5.z(vVar.a[i2]);
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + s5.z(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int o(int i, kv kvVar, Object obj) {
        if (obj instanceof s) {
            return s5.o((s) obj) + s5.v(i);
        }
        int v = s5.v(i);
        int g = ((C0124a) ((A) obj)).g(kvVar);
        return s5.x(g) + g + v;
    }

    public static int p(int i, List<?> list, kv kvVar) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v = s5.v(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof s) {
                i2 = s5.o((s) obj);
            } else {
                int g = ((C0124a) ((A) obj)).g(kvVar);
                i2 = g + s5.x(g);
            }
            v += i2;
        }
        return v;
    }

    public static int q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + r(list);
    }

    public static int r(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o) {
            o oVar = (o) list;
            i = 0;
            while (i2 < size) {
                oVar.b(i2);
                int i3 = oVar.a[i2];
                i += s5.x((i3 >> 31) ^ (i3 << 1));
                i2++;
            }
        } else {
            int i4 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i4 = i + s5.x((intValue >> 31) ^ (intValue << 1));
                i2++;
            }
        }
        return i;
    }

    public static int s(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + t(list);
    }

    public static int t(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i = 0;
            while (i2 < size) {
                vVar.b(i2);
                long j = vVar.a[i2];
                i += s5.z((j >> 63) ^ (j << 1));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + s5.z((longValue >> 63) ^ (longValue << 1));
                i2++;
            }
        }
        return i;
    }

    public static int u(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int v = s5.v(i) * size;
        if (list instanceof Vh) {
            Vh vh = (Vh) list;
            while (i4 < size) {
                Object raw = vh.getRaw(i4);
                if (raw instanceof x3) {
                    int size2 = ((x3) raw).size();
                    i3 = s5.x(size2) + size2;
                } else {
                    i3 = s5.u((String) raw);
                }
                v += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof x3) {
                    int size3 = ((x3) obj).size();
                    i2 = s5.x(size3) + size3;
                } else {
                    i2 = s5.u((String) obj);
                }
                v += i2;
                i4++;
            }
        }
        return v;
    }

    public static int v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + w(list);
    }

    public static int w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o) {
            o oVar = (o) list;
            i = 0;
            while (i2 < size) {
                oVar.b(i2);
                i += s5.x(oVar.a[i2]);
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + s5.x(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (s5.v(i) * size) + y(list);
    }

    public static int y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i = 0;
            while (i2 < size) {
                vVar.b(i2);
                i += s5.z(vVar.a[i2]);
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + s5.z(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB z(int i, List<Integer> list, p.b bVar, UB ub, K<UT, UB> k) {
        if (bVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (bVar.a()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = D(i, intValue, ub, k);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!bVar.a()) {
                    ub = D(i, intValue2, ub, k);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
