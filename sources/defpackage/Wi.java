package defpackage;

/* renamed from: Wi  reason: default package */
/* compiled from: PrimitiveRanges.kt */
public final class Wi extends Ui {
    static {
        new Wi(1, 0);
    }

    public Wi(long j, long j2) {
        super(j, j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r0 == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof defpackage.Wi
            r1 = 0
            if (r0 == 0) goto L_0x0032
            long r2 = r11.a
            long r4 = r11.b
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r6 = 1
            if (r0 <= 0) goto L_0x0010
            r0 = r6
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0023
            r0 = r12
            Wi r0 = (defpackage.Wi) r0
            long r7 = r0.a
            long r9 = r0.b
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0020
            r0 = r6
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            if (r0 != 0) goto L_0x0031
        L_0x0023:
            Wi r12 = (defpackage.Wi) r12
            long r7 = r12.a
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0032
            long r2 = r12.b
            int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0032
        L_0x0031:
            r1 = r6
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Wi.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        boolean z;
        long j = this.a;
        long j2 = this.b;
        if (j > j2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return -1;
        }
        return (int) ((((long) 31) * (j ^ (j >>> 32))) + ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        return this.a + ".." + this.b;
    }
}
