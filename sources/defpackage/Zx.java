package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: Zx  reason: default package */
/* compiled from: StepCurve */
public final class Zx extends T9 {
    public final Ql a;

    public Zx(String str) {
        String str2 = str;
        this.f545a = str2;
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str2.indexOf(40) + 1;
        int indexOf2 = str2.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str2.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str2.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str2.substring(indexOf, str2.indexOf(41, indexOf)).trim());
        double[] copyOf = Arrays.copyOf(dArr, i + 1);
        int length = (copyOf.length * 3) - 2;
        int length2 = copyOf.length - 1;
        double d = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr3 = new double[length];
        for (int i2 = 0; i2 < copyOf.length; i2++) {
            double d2 = copyOf[i2];
            int i3 = i2 + length2;
            dArr2[i3][0] = d2;
            double d3 = ((double) i2) * d;
            dArr3[i3] = d3;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr2[i4][0] = d2 + 1.0d;
                dArr3[i4] = d3 + 1.0d;
                int i5 = i2 - 1;
                dArr2[i5][0] = (d2 - 1.0d) - d;
                dArr3[i5] = (d3 - 4.0d) - d;
            }
        }
        Ql ql = new Ql(dArr3, dArr2);
        System.out.println(" 0 " + ql.b(0.0d));
        System.out.println(" 1 " + ql.b(1.0d));
        this.a = ql;
    }

    public final double a(double d) {
        return this.a.b(d);
    }

    public final double b(double d) {
        return this.a.e(d);
    }
}
