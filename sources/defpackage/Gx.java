package defpackage;

/* renamed from: Gx  reason: default package */
/* compiled from: SpringStopEngine */
public final class Gx implements ay {
    public double a = 0.5d;

    /* renamed from: a  reason: collision with other field name */
    public float f239a;

    /* renamed from: a  reason: collision with other field name */
    public int f240a = 0;
    public double b;

    /* renamed from: b  reason: collision with other field name */
    public float f241b;
    public double c;

    /* renamed from: c  reason: collision with other field name */
    public float f242c;
    public float d;
    public float e;

    public final boolean a() {
        double d2 = ((double) this.f241b) - this.c;
        double d3 = this.b;
        double d4 = (double) this.f242c;
        if (Math.sqrt((((d3 * d2) * d2) + ((d4 * d4) * ((double) this.d))) / d3) <= ((double) this.e)) {
            return true;
        }
        return false;
    }

    public final float b() {
        return 0.0f;
    }

    public final float getInterpolation(float f) {
        Gx gx = this;
        float f2 = f;
        double d2 = (double) (f2 - gx.f239a);
        double d3 = gx.b;
        double d4 = gx.a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d3 / ((double) gx.d)) * d2) * 4.0d)) + 1.0d);
        double d5 = d2 / ((double) sqrt);
        int i = 0;
        while (i < sqrt) {
            double d6 = (double) gx.f241b;
            double d7 = gx.c;
            int i2 = sqrt;
            int i3 = i;
            double d8 = (double) gx.f242c;
            double d9 = (double) gx.d;
            double d10 = ((((((-d3) * (d6 - d7)) - (d8 * d4)) / d9) * d5) / 2.0d) + d8;
            double d11 = ((((-((((d5 * d10) / 2.0d) + d6) - d7)) * d3) - (d10 * d4)) / d9) * d5;
            float f3 = (float) (d8 + d11);
            this.f242c = f3;
            float f4 = (float) ((((d11 / 2.0d) + d8) * d5) + d6);
            this.f241b = f4;
            int i4 = this.f240a;
            if (i4 > 0) {
                if (f4 < 0.0f && (i4 & 1) == 1) {
                    this.f241b = -f4;
                    this.f242c = -f3;
                }
                float f5 = this.f241b;
                if (f5 > 1.0f && (i4 & 2) == 2) {
                    this.f241b = 2.0f - f5;
                    this.f242c = -this.f242c;
                }
            }
            f2 = f;
            sqrt = i2;
            i = i3 + 1;
            gx = this;
        }
        Gx gx2 = gx;
        gx2.f239a = f2;
        return gx2.f241b;
    }
}
