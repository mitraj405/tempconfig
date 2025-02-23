package defpackage;

/* renamed from: H7  reason: default package */
/* compiled from: CurveFit */
public abstract class H7 {

    /* renamed from: H7$a */
    /* compiled from: CurveFit */
    public static class a extends H7 {
        public final double a;

        /* renamed from: a  reason: collision with other field name */
        public final double[] f244a;

        public a(double d, double[] dArr) {
            this.a = d;
            this.f244a = dArr;
        }

        public final double b(double d) {
            return this.f244a[0];
        }

        public final void c(double d, double[] dArr) {
            double[] dArr2 = this.f244a;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public final void d(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.f244a;
                if (i < dArr.length) {
                    fArr[i] = (float) dArr[i];
                    i++;
                } else {
                    return;
                }
            }
        }

        public final double e(double d) {
            return 0.0d;
        }

        public final void f(double d, double[] dArr) {
            for (int i = 0; i < this.f244a.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        public final double[] g() {
            return new double[]{this.a};
        }
    }

    public static H7 a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i == 0) {
            return new Ql(dArr, dArr2);
        }
        if (i != 2) {
            return new ci(dArr, dArr2);
        }
        return new a(dArr[0], dArr2[0]);
    }

    public abstract double b(double d);

    public abstract void c(double d, double[] dArr);

    public abstract void d(double d, float[] fArr);

    public abstract double e(double d);

    public abstract void f(double d, double[] dArr);

    public abstract double[] g();
}
