package defpackage;

/* renamed from: Zy  reason: default package */
/* compiled from: SystemIdInfo */
public final class Zy {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f785a;

    public Zy(String str, int i) {
        this.f785a = str;
        this.a = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r4 = (defpackage.Zy) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            if (r3 != r4) goto L_0x0004
            r4 = 1
            return r4
        L_0x0004:
            boolean r0 = r4 instanceof defpackage.Zy
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            Zy r4 = (defpackage.Zy) r4
            int r0 = r4.a
            int r2 = r3.a
            if (r2 == r0) goto L_0x0013
            return r1
        L_0x0013:
            java.lang.String r0 = r3.f785a
            java.lang.String r4 = r4.f785a
            boolean r4 = r0.equals(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Zy.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (this.f785a.hashCode() * 31) + this.a;
    }
}
