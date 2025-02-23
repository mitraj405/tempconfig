package defpackage;

/* renamed from: fg  reason: default package and case insensitive filesystem */
/* compiled from: PrimitiveRanges.kt */
public final class C1112fg extends C1070dg {
    public static final C1112fg a = new C1112fg(1, 0);

    public C1112fg(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = (defpackage.C1112fg) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof defpackage.C1112fg
            if (r0 == 0) goto L_0x0023
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            fg r0 = (defpackage.C1112fg) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0021
        L_0x0013:
            fg r3 = (defpackage.C1112fg) r3
            int r0 = r3.c
            int r1 = r2.c
            if (r1 != r0) goto L_0x0023
            int r3 = r3.d
            int r0 = r2.d
            if (r0 != r3) goto L_0x0023
        L_0x0021:
            r3 = 1
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1112fg.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.c * 31) + this.d;
    }

    public final boolean isEmpty() {
        if (this.c > this.d) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.c + ".." + this.d;
    }
}
