package defpackage;

/* renamed from: Ih  reason: default package */
/* compiled from: KotlinVersion.kt */
public final class Ih implements Comparable<Ih> {
    public static final Ih a = new Ih();
    public final int c = 1;
    public final int d = 8;
    public final int e = 22;
    public final int f;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1 != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Ih() {
        /*
            r6 = this;
            r6.<init>()
            r0 = 1
            r6.c = r0
            r1 = 8
            r6.d = r1
            r2 = 22
            r6.e = r2
            fg r3 = new fg
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            r3.<init>(r4, r5)
            int r3 = r3.d
            if (r0 > r3) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r4
        L_0x001d:
            if (r3 == 0) goto L_0x003c
            fg r3 = new fg
            r3.<init>(r4, r5)
            int r3 = r3.d
            if (r1 > r3) goto L_0x002a
            r1 = r0
            goto L_0x002b
        L_0x002a:
            r1 = r4
        L_0x002b:
            if (r1 == 0) goto L_0x003c
            fg r1 = new fg
            r1.<init>(r4, r5)
            int r1 = r1.d
            if (r2 > r1) goto L_0x0038
            r1 = r0
            goto L_0x0039
        L_0x0038:
            r1 = r4
        L_0x0039:
            if (r1 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = r4
        L_0x003d:
            if (r0 == 0) goto L_0x0045
            r0 = 67606(0x10816, float:9.4736E-41)
            r6.f = r0
            return
        L_0x0045:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Version components are out of range: 1.8.22"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ih.<init>():void");
    }

    public final int compareTo(Object obj) {
        Ih ih = (Ih) obj;
        C1177ig.f(ih, "other");
        return this.f - ih.f;
    }

    public final boolean equals(Object obj) {
        Ih ih;
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ih) {
            ih = (Ih) obj;
        } else {
            ih = null;
        }
        if (ih == null) {
            return false;
        }
        if (this.f == ih.f) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append('.');
        sb.append(this.d);
        sb.append('.');
        sb.append(this.e);
        return sb.toString();
    }
}
