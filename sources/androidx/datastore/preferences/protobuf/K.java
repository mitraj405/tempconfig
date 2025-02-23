package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: UnknownFieldSchema */
public abstract class K<T, B> {
    public abstract void a(B b, int i, int i2);

    public abstract void b(B b, int i, long j);

    public abstract void c(B b, int i, T t);

    public abstract void d(B b, int i, x3 x3Var);

    public abstract void e(B b, int i, long j);

    public abstract L f(Object obj);

    public abstract L g(Object obj);

    public abstract int h(T t);

    public abstract int i(T t);

    public abstract void j(Object obj);

    public abstract L k(Object obj, Object obj2);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[LOOP:0: B:16:0x0032->B:19:0x003f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(B r7, androidx.datastore.preferences.protobuf.G r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.getTag()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0067
            if (r0 == r2) goto L_0x005f
            r3 = 2
            if (r0 == r3) goto L_0x0057
            r3 = 3
            r4 = 4
            if (r0 == r3) goto L_0x002b
            if (r0 == r4) goto L_0x0029
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.readFixed32()
            r6.a(r7, r1, r8)
            return r2
        L_0x0021:
            int r7 = androidx.datastore.preferences.protobuf.q.c
            androidx.datastore.preferences.protobuf.q$a r7 = new androidx.datastore.preferences.protobuf.q$a
            r7.<init>()
            throw r7
        L_0x0029:
            r7 = 0
            return r7
        L_0x002b:
            androidx.datastore.preferences.protobuf.L r0 = r6.m()
            int r3 = r1 << 3
            r3 = r3 | r4
        L_0x0032:
            int r4 = r8.getFieldNumber()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0041
            boolean r4 = r6.l(r0, r8)
            if (r4 != 0) goto L_0x0032
        L_0x0041:
            int r8 = r8.getTag()
            if (r3 != r8) goto L_0x004f
            androidx.datastore.preferences.protobuf.L r8 = r6.q(r0)
            r6.c(r7, r1, r8)
            return r2
        L_0x004f:
            androidx.datastore.preferences.protobuf.q r7 = new androidx.datastore.preferences.protobuf.q
            java.lang.String r8 = "Protocol message end-group tag did not match expected tag."
            r7.<init>(r8)
            throw r7
        L_0x0057:
            x3 r8 = r8.b()
            r6.d(r7, r1, r8)
            return r2
        L_0x005f:
            long r3 = r8.readFixed64()
            r6.b(r7, r1, r3)
            return r2
        L_0x0067:
            long r3 = r8.readInt64()
            r6.e(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.l(java.lang.Object, androidx.datastore.preferences.protobuf.G):boolean");
    }

    public abstract L m();

    public abstract void n(Object obj, B b);

    public abstract void o(Object obj, T t);

    public abstract void p();

    public abstract L q(Object obj);

    public abstract void r(Object obj, C0130g gVar) throws IOException;

    public abstract void s(Object obj, C0130g gVar) throws IOException;
}
