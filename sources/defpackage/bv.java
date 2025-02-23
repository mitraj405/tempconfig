package defpackage;

/* renamed from: bv  reason: default package */
/* compiled from: ScaleXY */
public final class bv {
    public float a;
    public float b;

    public bv(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final String toString() {
        return this.a + "x" + this.b;
    }

    public bv() {
        this(1.0f, 1.0f);
    }
}
