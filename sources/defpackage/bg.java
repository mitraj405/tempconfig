package defpackage;

import android.graphics.Insets;

/* renamed from: bg  reason: default package */
/* compiled from: Insets */
public final class bg {
    public static final bg a = new bg(0, 0, 0, 0);

    /* renamed from: a  reason: collision with other field name */
    public final int f2741a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: bg$a */
    /* compiled from: Insets */
    public static class a {
        public static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    public bg(int i, int i2, int i3, int i4) {
        this.f2741a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static bg a(bg bgVar, bg bgVar2) {
        return b(Math.max(bgVar.f2741a, bgVar2.f2741a), Math.max(bgVar.b, bgVar2.b), Math.max(bgVar.c, bgVar2.c), Math.max(bgVar.d, bgVar2.d));
    }

    public static bg b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return a;
        }
        return new bg(i, i2, i3, i4);
    }

    public static bg c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return a.a(this.f2741a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bg.class != obj.getClass()) {
            return false;
        }
        bg bgVar = (bg) obj;
        if (this.d == bgVar.d && this.f2741a == bgVar.f2741a && this.c == bgVar.c && this.b == bgVar.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f2741a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "Insets{left=" + this.f2741a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
