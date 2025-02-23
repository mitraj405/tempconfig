package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.f  reason: case insensitive filesystem */
/* compiled from: CodedInputStreamReader */
public final class C0129f implements G {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final C0128e f1928a;
    public int b;
    public int c = 0;

    public C0129f(C0128e eVar) {
        Charset charset = p.a;
        if (eVar != null) {
            this.f1928a = eVar;
            eVar.f1926a = this;
            return;
        }
        throw new NullPointerException("input");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (skipField() != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        throw new androidx.datastore.preferences.protobuf.q("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void a(java.util.Map<K, V> r10, androidx.datastore.preferences.protobuf.w.a<K, V> r11, androidx.datastore.preferences.protobuf.C0132i r12) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 2
            r9.l(r0)
            androidx.datastore.preferences.protobuf.e r1 = r9.f1928a
            int r2 = r1.v()
            int r2 = r1.e(r2)
            K r3 = r11.f1939a
            V r4 = r11.f1940b
            r5 = r4
        L_0x0013:
            int r6 = r9.getFieldNumber()     // Catch:{ all -> 0x005e }
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L_0x0057
            boolean r7 = r1.c()     // Catch:{ all -> 0x005e }
            if (r7 == 0) goto L_0x0023
            goto L_0x0057
        L_0x0023:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L_0x0042
            if (r6 == r0) goto L_0x0037
            boolean r6 = r9.skipField()     // Catch:{ a -> 0x004a }
            if (r6 == 0) goto L_0x0031
            goto L_0x0013
        L_0x0031:
            androidx.datastore.preferences.protobuf.q r6 = new androidx.datastore.preferences.protobuf.q     // Catch:{ a -> 0x004a }
            r6.<init>(r8)     // Catch:{ a -> 0x004a }
            throw r6     // Catch:{ a -> 0x004a }
        L_0x0037:
            GD r6 = r11.b     // Catch:{ a -> 0x004a }
            java.lang.Class r7 = r4.getClass()     // Catch:{ a -> 0x004a }
            java.lang.Object r5 = r9.g(r6, r7, r12)     // Catch:{ a -> 0x004a }
            goto L_0x0013
        L_0x0042:
            GD r6 = r11.a     // Catch:{ a -> 0x004a }
            r7 = 0
            java.lang.Object r3 = r9.g(r6, r7, r7)     // Catch:{ a -> 0x004a }
            goto L_0x0013
        L_0x004a:
            boolean r6 = r9.skipField()     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x0051
            goto L_0x0013
        L_0x0051:
            androidx.datastore.preferences.protobuf.q r10 = new androidx.datastore.preferences.protobuf.q     // Catch:{ all -> 0x005e }
            r10.<init>(r8)     // Catch:{ all -> 0x005e }
            throw r10     // Catch:{ all -> 0x005e }
        L_0x0057:
            r10.put(r3, r5)     // Catch:{ all -> 0x005e }
            r1.d(r2)
            return
        L_0x005e:
            r10 = move-exception
            r1.d(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0129f.a(java.util.Map, androidx.datastore.preferences.protobuf.w$a, androidx.datastore.preferences.protobuf.i):void");
    }

    public final x3 b() throws IOException {
        l(2);
        return this.f1928a.g();
    }

    public final <T> T c(kv<T> kvVar, C0132i iVar) throws IOException {
        l(3);
        return h(kvVar, iVar);
    }

    public final <T> void d(List<T> list, kv<T> kvVar, C0132i iVar) throws IOException {
        int u;
        int i = this.a;
        if ((i & 7) == 2) {
            do {
                list.add(i(kvVar, iVar));
                C0128e eVar = this.f1928a;
                if (!eVar.c() && this.c == 0) {
                    u = eVar.u();
                } else {
                    return;
                }
            } while (u == i);
            this.c = u;
            return;
        }
        int i2 = q.c;
        throw new q.a();
    }

    public final <T> T e(kv<T> kvVar, C0132i iVar) throws IOException {
        l(2);
        return i(kvVar, iVar);
    }

    public final <T> void f(List<T> list, kv<T> kvVar, C0132i iVar) throws IOException {
        int u;
        int i = this.a;
        if ((i & 7) == 3) {
            do {
                list.add(h(kvVar, iVar));
                C0128e eVar = this.f1928a;
                if (!eVar.c() && this.c == 0) {
                    u = eVar.u();
                } else {
                    return;
                }
            } while (u == i);
            this.c = u;
            return;
        }
        int i2 = q.c;
        throw new q.a();
    }

    public final Object g(GD gd, Class<?> cls, C0132i iVar) throws IOException {
        switch (gd.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(readInt64());
            case 3:
                return Long.valueOf(readUInt64());
            case 4:
                return Integer.valueOf(readInt32());
            case 5:
                return Long.valueOf(readFixed64());
            case 6:
                return Integer.valueOf(readFixed32());
            case 7:
                return Boolean.valueOf(readBool());
            case 8:
                return readStringRequireUtf8();
            case 10:
                l(2);
                return i(Mq.a.a(cls), iVar);
            case 11:
                return b();
            case 12:
                return Integer.valueOf(readUInt32());
            case 13:
                return Integer.valueOf(readEnum());
            case 14:
                return Integer.valueOf(readSFixed32());
            case 15:
                return Long.valueOf(readSFixed64());
            case 16:
                return Integer.valueOf(readSInt32());
            case 17:
                return Long.valueOf(readSInt64());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    public final int getFieldNumber() throws IOException {
        int i = this.c;
        if (i != 0) {
            this.a = i;
            this.c = 0;
        } else {
            this.a = this.f1928a.u();
        }
        int i2 = this.a;
        if (i2 == 0 || i2 == this.b) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.a;
    }

    public final <T> T h(kv<T> kvVar, C0132i iVar) throws IOException {
        int i = this.b;
        this.b = ((this.a >>> 3) << 3) | 4;
        try {
            T newInstance = kvVar.newInstance();
            kvVar.a(newInstance, this, iVar);
            kvVar.makeImmutable(newInstance);
            if (this.a == this.b) {
                return newInstance;
            }
            throw q.e();
        } finally {
            this.b = i;
        }
    }

    public final <T> T i(kv<T> kvVar, C0132i iVar) throws IOException {
        C0128e eVar = this.f1928a;
        int v = eVar.v();
        if (eVar.a < eVar.b) {
            int e = eVar.e(v);
            T newInstance = kvVar.newInstance();
            eVar.a++;
            kvVar.a(newInstance, this, iVar);
            kvVar.makeImmutable(newInstance);
            eVar.a(0);
            eVar.a--;
            eVar.d(e);
            return newInstance;
        }
        throw new q("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final void j(List<String> list, boolean z) throws IOException {
        String str;
        int u;
        int u2;
        if ((this.a & 7) == 2) {
            boolean z2 = list instanceof Vh;
            C0128e eVar = this.f1928a;
            if (!z2 || z) {
                do {
                    if (z) {
                        str = readStringRequireUtf8();
                    } else {
                        str = readString();
                    }
                    list.add(str);
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
                return;
            }
            Vh vh = (Vh) list;
            do {
                vh.j(b());
                if (!eVar.c()) {
                    u2 = eVar.u();
                } else {
                    return;
                }
            } while (u2 == this.a);
            this.c = u2;
            return;
        }
        throw q.b();
    }

    public final void k(int i) throws IOException {
        if (this.f1928a.b() != i) {
            throw q.f();
        }
    }

    public final void l(int i) throws IOException {
        if ((this.a & 7) != i) {
            throw q.b();
        }
    }

    public final void m(int i) throws IOException {
        if ((i & 3) != 0) {
            throw q.e();
        }
    }

    public final void n(int i) throws IOException {
        if ((i & 7) != 0) {
            throw q.e();
        }
    }

    public final boolean readBool() throws IOException {
        l(0);
        return this.f1928a.f();
    }

    public final void readBoolList(List<Boolean> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof C0127d;
        C0128e eVar = this.f1928a;
        if (z) {
            C0127d dVar = (C0127d) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    dVar.addBoolean(eVar.f());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    dVar.addBoolean(eVar.f());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(eVar.f()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Boolean.valueOf(eVar.f()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final void readBytesList(List<x3> list) throws IOException {
        int u;
        if ((this.a & 7) == 2) {
            do {
                list.add(b());
                C0128e eVar = this.f1928a;
                if (!eVar.c()) {
                    u = eVar.u();
                } else {
                    return;
                }
            } while (u == this.a);
            this.c = u;
            return;
        }
        throw q.b();
    }

    public final double readDouble() throws IOException {
        l(1);
        return this.f1928a.h();
    }

    public final void readDoubleList(List<Double> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof C0131h;
        C0128e eVar = this.f1928a;
        if (z) {
            C0131h hVar = (C0131h) list;
            int i = this.a & 7;
            if (i == 1) {
                do {
                    hVar.addDouble(eVar.h());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int v = eVar.v();
                n(v);
                int b2 = eVar.b() + v;
                do {
                    hVar.addDouble(eVar.h());
                } while (eVar.b() < b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(eVar.h()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int v2 = eVar.v();
                n(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Double.valueOf(eVar.h()));
                } while (eVar.b() < b3);
            } else {
                throw q.b();
            }
        }
    }

    public final int readEnum() throws IOException {
        l(0);
        return this.f1928a.i();
    }

    public final void readEnumList(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    oVar.addInt(eVar.i());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    oVar.addInt(eVar.i());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.i()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Integer.valueOf(eVar.i()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final int readFixed32() throws IOException {
        l(5);
        return this.f1928a.j();
    }

    public final void readFixed32List(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 2) {
                int v = eVar.v();
                m(v);
                int b2 = eVar.b() + v;
                do {
                    oVar.addInt(eVar.j());
                } while (eVar.b() < b2);
            } else if (i == 5) {
                do {
                    oVar.addInt(eVar.j());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 2) {
                int v2 = eVar.v();
                m(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Integer.valueOf(eVar.j()));
                } while (eVar.b() < b3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(eVar.j()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else {
                throw q.b();
            }
        }
    }

    public final long readFixed64() throws IOException {
        l(1);
        return this.f1928a.k();
    }

    public final void readFixed64List(List<Long> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof v;
        C0128e eVar = this.f1928a;
        if (z) {
            v vVar = (v) list;
            int i = this.a & 7;
            if (i == 1) {
                do {
                    vVar.addLong(eVar.k());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int v = eVar.v();
                n(v);
                int b2 = eVar.b() + v;
                do {
                    vVar.addLong(eVar.k());
                } while (eVar.b() < b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(eVar.k()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int v2 = eVar.v();
                n(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Long.valueOf(eVar.k()));
                } while (eVar.b() < b3);
            } else {
                throw q.b();
            }
        }
    }

    public final float readFloat() throws IOException {
        l(5);
        return this.f1928a.l();
    }

    public final void readFloatList(List<Float> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof C0136m;
        C0128e eVar = this.f1928a;
        if (z) {
            C0136m mVar = (C0136m) list;
            int i = this.a & 7;
            if (i == 2) {
                int v = eVar.v();
                m(v);
                int b2 = eVar.b() + v;
                do {
                    mVar.addFloat(eVar.l());
                } while (eVar.b() < b2);
            } else if (i == 5) {
                do {
                    mVar.addFloat(eVar.l());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 2) {
                int v2 = eVar.v();
                m(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Float.valueOf(eVar.l()));
                } while (eVar.b() < b3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(eVar.l()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else {
                throw q.b();
            }
        }
    }

    public final int readInt32() throws IOException {
        l(0);
        return this.f1928a.m();
    }

    public final void readInt32List(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    oVar.addInt(eVar.m());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    oVar.addInt(eVar.m());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.m()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Integer.valueOf(eVar.m()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final long readInt64() throws IOException {
        l(0);
        return this.f1928a.n();
    }

    public final void readInt64List(List<Long> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof v;
        C0128e eVar = this.f1928a;
        if (z) {
            v vVar = (v) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    vVar.addLong(eVar.n());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    vVar.addLong(eVar.n());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(eVar.n()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Long.valueOf(eVar.n()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final int readSFixed32() throws IOException {
        l(5);
        return this.f1928a.o();
    }

    public final void readSFixed32List(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 2) {
                int v = eVar.v();
                m(v);
                int b2 = eVar.b() + v;
                do {
                    oVar.addInt(eVar.o());
                } while (eVar.b() < b2);
            } else if (i == 5) {
                do {
                    oVar.addInt(eVar.o());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 2) {
                int v2 = eVar.v();
                m(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Integer.valueOf(eVar.o()));
                } while (eVar.b() < b3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(eVar.o()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else {
                throw q.b();
            }
        }
    }

    public final long readSFixed64() throws IOException {
        l(1);
        return this.f1928a.p();
    }

    public final void readSFixed64List(List<Long> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof v;
        C0128e eVar = this.f1928a;
        if (z) {
            v vVar = (v) list;
            int i = this.a & 7;
            if (i == 1) {
                do {
                    vVar.addLong(eVar.p());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int v = eVar.v();
                n(v);
                int b2 = eVar.b() + v;
                do {
                    vVar.addLong(eVar.p());
                } while (eVar.b() < b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(eVar.p()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int v2 = eVar.v();
                n(v2);
                int b3 = eVar.b() + v2;
                do {
                    list.add(Long.valueOf(eVar.p()));
                } while (eVar.b() < b3);
            } else {
                throw q.b();
            }
        }
    }

    public final int readSInt32() throws IOException {
        l(0);
        return this.f1928a.q();
    }

    public final void readSInt32List(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    oVar.addInt(eVar.q());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    oVar.addInt(eVar.q());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.q()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Integer.valueOf(eVar.q()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final long readSInt64() throws IOException {
        l(0);
        return this.f1928a.r();
    }

    public final void readSInt64List(List<Long> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof v;
        C0128e eVar = this.f1928a;
        if (z) {
            v vVar = (v) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    vVar.addLong(eVar.r());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    vVar.addLong(eVar.r());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(eVar.r()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Long.valueOf(eVar.r()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final String readString() throws IOException {
        l(2);
        return this.f1928a.s();
    }

    public final void readStringList(List<String> list) throws IOException {
        j(list, false);
    }

    public final void readStringListRequireUtf8(List<String> list) throws IOException {
        j(list, true);
    }

    public final String readStringRequireUtf8() throws IOException {
        l(2);
        return this.f1928a.t();
    }

    public final int readUInt32() throws IOException {
        l(0);
        return this.f1928a.v();
    }

    public final void readUInt32List(List<Integer> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof o;
        C0128e eVar = this.f1928a;
        if (z) {
            o oVar = (o) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    oVar.addInt(eVar.v());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    oVar.addInt(eVar.v());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.v()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Integer.valueOf(eVar.v()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final long readUInt64() throws IOException {
        l(0);
        return this.f1928a.w();
    }

    public final void readUInt64List(List<Long> list) throws IOException {
        int u;
        int u2;
        boolean z = list instanceof v;
        C0128e eVar = this.f1928a;
        if (z) {
            v vVar = (v) list;
            int i = this.a & 7;
            if (i == 0) {
                do {
                    vVar.addLong(eVar.w());
                    if (!eVar.c()) {
                        u2 = eVar.u();
                    } else {
                        return;
                    }
                } while (u2 == this.a);
                this.c = u2;
            } else if (i == 2) {
                int b2 = eVar.b() + eVar.v();
                do {
                    vVar.addLong(eVar.w());
                } while (eVar.b() < b2);
                k(b2);
            } else {
                throw q.b();
            }
        } else {
            int i2 = this.a & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(eVar.w()));
                    if (!eVar.c()) {
                        u = eVar.u();
                    } else {
                        return;
                    }
                } while (u == this.a);
                this.c = u;
            } else if (i2 == 2) {
                int b3 = eVar.b() + eVar.v();
                do {
                    list.add(Long.valueOf(eVar.w()));
                } while (eVar.b() < b3);
                k(b3);
            } else {
                throw q.b();
            }
        }
    }

    public final boolean skipField() throws IOException {
        int i;
        C0128e eVar = this.f1928a;
        if (eVar.c() || (i = this.a) == this.b) {
            return false;
        }
        return eVar.x(i);
    }
}
