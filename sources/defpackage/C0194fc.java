package defpackage;

/* renamed from: fc  reason: default package and case insensitive filesystem */
/* compiled from: FieldType */
public enum C0194fc {
    DOUBLE_LIST_PACKED(35, 3, r18),
    SINT64_LIST_PACKED(48, 3, r3);
    

    /* renamed from: a  reason: collision with other field name */
    public static final C0194fc[] f2937a = null;
    public final int c;

    /* access modifiers changed from: public */
    static {
        int i;
        C0194fc[] values = values();
        f2937a = new C0194fc[values.length];
        for (C0194fc fcVar : values) {
            f2937a[fcVar.c] = fcVar;
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int, java.lang.Object] */
    /* access modifiers changed from: public */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C0194fc(int r3, java.lang.Object r4, defpackage.Jg r5) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.c = r3
            if (r4 == 0) goto L_0x001d
            int r1 = r4 + -1
            r2 = 1
            if (r1 == r2) goto L_0x0014
            r3 = 3
            if (r1 == r3) goto L_0x0010
            goto L_0x0017
        L_0x0010:
            r5.getClass()
            goto L_0x0017
        L_0x0014:
            r5.getClass()
        L_0x0017:
            if (r4 != r2) goto L_0x001c
            r5.ordinal()
        L_0x001c:
            return
        L_0x001d:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0194fc.<init>(java.lang.String, int, int, int, Jg):void");
    }

    public final int a() {
        return this.c;
    }
}
