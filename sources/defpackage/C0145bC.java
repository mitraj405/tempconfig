package defpackage;

/* renamed from: bC  reason: default package and case insensitive filesystem */
/* compiled from: VelocityMatrix */
public final class C0145bC {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;

    public final void a(float f2, float f3, int i, int i2, float[] fArr) {
        int i3 = i;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.c;
        float f9 = f5 + this.d;
        float f10 = (this.a * f6) + f8;
        float f11 = (this.b * f7) + f9;
        float radians = (float) Math.toRadians((double) this.f);
        float radians2 = (float) Math.toRadians((double) this.e);
        double d2 = (double) radians;
        double sin = Math.sin(d2);
        double d3 = (double) (((float) i2) * f7);
        double cos = Math.cos(d2);
        fArr[0] = (((float) ((sin * ((double) (((float) (-i3)) * f6))) - (Math.cos(d2) * d3))) * radians2) + f10;
        fArr[1] = (radians2 * ((float) ((cos * ((double) (((float) i3) * f6))) - (Math.sin(d2) * d3)))) + f11;
    }
}
