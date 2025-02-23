package defpackage;

import java.util.Arrays;

/* renamed from: no  reason: default package */
/* compiled from: Oscillator */
public final class no {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Ql f3117a;

    /* renamed from: a  reason: collision with other field name */
    public double[] f3118a = new double[0];

    /* renamed from: a  reason: collision with other field name */
    public float[] f3119a = new float[0];
    public double[] b;

    public final void a(double d, float f) {
        int length = this.f3119a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f3118a, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f3118a = Arrays.copyOf(this.f3118a, length);
        this.f3119a = Arrays.copyOf(this.f3119a, length);
        this.b = new double[length];
        double[] dArr = this.f3118a;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f3118a[binarySearch] = d;
        this.f3119a[binarySearch] = f;
    }

    public final double b(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f3118a, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.f3119a;
        float f = fArr[i];
        int i2 = i - 1;
        float f2 = fArr[i2];
        double d2 = (double) (f - f2);
        double[] dArr = this.f3118a;
        double d3 = dArr[i];
        double d4 = dArr[i2];
        double d5 = d2 / (d3 - d4);
        return ((((d * d) - (d4 * d4)) * d5) / 2.0d) + ((d - d4) * (((double) f2) - (d5 * d4))) + this.b[i2];
    }

    public final double c(double d, double d2) {
        double d3;
        double b2 = b(d) + d2;
        switch (this.a) {
            case 1:
                return Math.signum(0.5d - (b2 % 1.0d));
            case 2:
                d3 = Math.abs((((b2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((b2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                d3 = ((b2 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d2 + b2) * 6.283185307179586d);
            case 6:
                double abs = 1.0d - Math.abs(((b2 * 4.0d) % 4.0d) - 2.0d);
                d3 = abs * abs;
                break;
            case 7:
                return this.f3117a.b(b2 % 1.0d);
            default:
                return Math.sin(b2 * 6.283185307179586d);
        }
        return 1.0d - d3;
    }

    public final String toString() {
        return "pos =" + Arrays.toString(this.f3118a) + " period=" + Arrays.toString(this.f3119a);
    }
}
