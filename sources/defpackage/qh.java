package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: qh  reason: default package */
/* compiled from: KeyCycleOscillator */
public abstract class qh {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f3193a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f3194a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public a f3195a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public String f3196b = null;

    /* renamed from: qh$a */
    /* compiled from: KeyCycleOscillator */
    public static class a {
        public H7 a;

        /* renamed from: a  reason: collision with other field name */
        public final no f3197a;

        /* renamed from: a  reason: collision with other field name */
        public final double[] f3198a;

        /* renamed from: a  reason: collision with other field name */
        public final float[] f3199a;
        public double[] b;

        /* renamed from: b  reason: collision with other field name */
        public final float[] f3200b;
        public double[] c;

        /* renamed from: c  reason: collision with other field name */
        public final float[] f3201c;
        public final float[] d;

        public a(int i, int i2, String str) {
            char c2;
            long j;
            int i3 = i2;
            String str2 = str;
            no noVar = new no();
            this.f3197a = noVar;
            noVar.a = i;
            if (str2 != null) {
                double[] dArr = new double[(str.length() / 2)];
                int indexOf = str2.indexOf(40) + 1;
                int indexOf2 = str2.indexOf(44, indexOf);
                char c3 = 0;
                int i4 = 0;
                while (indexOf2 != -1) {
                    dArr[i4] = Double.parseDouble(str2.substring(indexOf, indexOf2).trim());
                    indexOf = indexOf2 + 1;
                    indexOf2 = str2.indexOf(44, indexOf);
                    i4++;
                }
                dArr[i4] = Double.parseDouble(str2.substring(indexOf, str2.indexOf(41, indexOf)).trim());
                double[] copyOf = Arrays.copyOf(dArr, i4 + 1);
                int length = (copyOf.length * 3) - 2;
                int length2 = copyOf.length - 1;
                double d2 = 1.0d / ((double) length2);
                int[] iArr = new int[2];
                iArr[1] = 1;
                iArr[0] = length;
                double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
                double[] dArr3 = new double[length];
                int i5 = 0;
                while (i5 < copyOf.length) {
                    double d3 = copyOf[i5];
                    int i6 = i5 + length2;
                    dArr2[i6][c3] = d3;
                    double d4 = ((double) i5) * d2;
                    dArr3[i6] = d4;
                    if (i5 > 0) {
                        int i7 = (length2 * 2) + i5;
                        j = 4607182418800017408L;
                        c2 = 0;
                        dArr2[i7][0] = d3 + 1.0d;
                        dArr3[i7] = d4 + 1.0d;
                        int i8 = i5 - 1;
                        dArr2[i8][0] = (d3 - 1.0d) - d2;
                        dArr3[i8] = (d4 - 4.0d) - d2;
                    } else {
                        j = 4607182418800017408L;
                        c2 = 0;
                    }
                    i5++;
                    long j2 = j;
                    c3 = c2;
                }
                noVar.f3117a = new Ql(dArr3, dArr2);
            }
            this.f3199a = new float[i3];
            this.f3198a = new double[i3];
            this.f3200b = new float[i3];
            this.f3201c = new float[i3];
            this.d = new float[i3];
            float[] fArr = new float[i3];
        }
    }

    /* renamed from: qh$b */
    /* compiled from: KeyCycleOscillator */
    public static class b {
        public final float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f3202a;
        public final float b;
        public final float c;
        public final float d;

        public b(float f, float f2, float f3, float f4, int i) {
            this.f3202a = i;
            this.a = f4;
            this.b = f2;
            this.c = f;
            this.d = f3;
        }
    }

    public final float a(float f) {
        a aVar = this.f3195a;
        H7 h7 = aVar.a;
        if (h7 != null) {
            h7.c((double) f, aVar.b);
        } else {
            double[] dArr = aVar.b;
            dArr[0] = (double) aVar.f3201c[0];
            dArr[1] = (double) aVar.d[0];
            dArr[2] = (double) aVar.f3199a[0];
        }
        double[] dArr2 = aVar.b;
        return (float) ((aVar.f3197a.c((double) f, dArr2[1]) * aVar.b[2]) + dArr2[0]);
    }

    public final float b(float f) {
        double d;
        double d2;
        double d3;
        double d4;
        float f2 = f;
        a aVar = this.f3195a;
        H7 h7 = aVar.a;
        if (h7 != null) {
            double d5 = (double) f2;
            h7.f(d5, aVar.c);
            aVar.a.c(d5, aVar.b);
        } else {
            double[] dArr = aVar.c;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d6 = (double) f2;
        double d7 = aVar.b[1];
        no noVar = aVar.f3197a;
        double c = noVar.c(d6, d7);
        double d8 = aVar.b[1];
        double d9 = aVar.c[1];
        double b2 = noVar.b(d6) + d8;
        if (d6 <= 0.0d) {
            d6 = 1.0E-5d;
        } else if (d6 >= 1.0d) {
            d6 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(noVar.f3118a, d6);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = noVar.f3119a;
            float f3 = fArr[i];
            int i2 = i - 1;
            float f4 = fArr[i2];
            double[] dArr2 = noVar.f3118a;
            double d10 = dArr2[i];
            double d11 = dArr2[i2];
            double d12 = ((double) (f3 - f4)) / (d10 - d11);
            d = (((double) f4) - (d12 * d11)) + (d6 * d12);
        } else {
            d = 0.0d;
        }
        double d13 = d + d9;
        switch (noVar.a) {
            case 1:
                d2 = 0.0d;
                break;
            case 2:
                d3 = d13 * 4.0d;
                d4 = Math.signum((((b2 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                d2 = d13 * 2.0d;
                break;
            case 4:
                d2 = (-d13) * 2.0d;
                break;
            case 5:
                d3 = d13 * -6.283185307179586d;
                d4 = Math.sin(b2 * 6.283185307179586d);
                break;
            case 6:
                d2 = ((((b2 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * d13 * 4.0d;
                break;
            case 7:
                d2 = noVar.f3117a.e(b2 % 1.0d);
                break;
            default:
                d3 = d13 * 6.283185307179586d;
                d4 = Math.cos(b2 * 6.283185307179586d);
                break;
        }
        d2 = d4 * d3;
        double[] dArr3 = aVar.c;
        return (float) ((d2 * aVar.b[2]) + (c * dArr3[2]) + dArr3[0]);
    }

    public final void d() {
        int i;
        ArrayList<b> arrayList = this.f3194a;
        int size = arrayList.size();
        if (size != 0) {
            Collections.sort(arrayList, new ph());
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            char c = 0;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.f3195a = new a(this.a, size, this.f3196b);
            Iterator<b> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                b next = it.next();
                float f = next.c;
                dArr[i2] = ((double) f) * 0.01d;
                double[] dArr3 = dArr2[i2];
                float f2 = next.a;
                dArr3[c] = (double) f2;
                float f3 = next.b;
                dArr3[1] = (double) f3;
                float f4 = next.d;
                dArr3[2] = (double) f4;
                a aVar = this.f3195a;
                aVar.f3198a[i2] = ((double) next.f3202a) / 100.0d;
                aVar.f3200b[i2] = f;
                aVar.f3201c[i2] = f3;
                aVar.d[i2] = f4;
                aVar.f3199a[i2] = f2;
                i2++;
                c = 0;
            }
            a aVar2 = this.f3195a;
            double[] dArr4 = aVar2.f3198a;
            int length = dArr4.length;
            int[] iArr2 = new int[2];
            iArr2[1] = 3;
            iArr2[0] = length;
            double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            float[] fArr = aVar2.f3199a;
            aVar2.b = new double[(fArr.length + 2)];
            aVar2.c = new double[(fArr.length + 2)];
            int i3 = (dArr4[0] > 0.0d ? 1 : (dArr4[0] == 0.0d ? 0 : -1));
            float[] fArr2 = aVar2.f3200b;
            no noVar = aVar2.f3197a;
            if (i3 > 0) {
                noVar.a(0.0d, fArr2[0]);
            }
            int length2 = dArr4.length - 1;
            if (dArr4[length2] < 1.0d) {
                noVar.a(1.0d, fArr2[length2]);
            }
            for (int i4 = 0; i4 < dArr5.length; i4++) {
                double[] dArr6 = dArr5[i4];
                dArr6[0] = (double) aVar2.f3201c[i4];
                dArr6[1] = (double) aVar2.d[i4];
                dArr6[2] = (double) fArr[i4];
                noVar.a(dArr4[i4], fArr2[i4]);
            }
            int i5 = 0;
            double d = 0.0d;
            while (true) {
                float[] fArr3 = noVar.f3119a;
                if (i5 >= fArr3.length) {
                    break;
                }
                d += (double) fArr3[i5];
                i5++;
            }
            int i6 = 1;
            double d2 = 0.0d;
            while (true) {
                float[] fArr4 = noVar.f3119a;
                if (i6 >= fArr4.length) {
                    break;
                }
                int i7 = i6 - 1;
                float f5 = (fArr4[i7] + fArr4[i6]) / 2.0f;
                double[] dArr7 = noVar.f3118a;
                d2 = ((dArr7[i6] - dArr7[i7]) * ((double) f5)) + d2;
                i6++;
            }
            int i8 = 0;
            while (true) {
                float[] fArr5 = noVar.f3119a;
                if (i8 >= fArr5.length) {
                    break;
                }
                fArr5[i8] = (float) (((double) fArr5[i8]) * (d / d2));
                i8++;
                dArr5 = dArr5;
            }
            double[][] dArr8 = dArr5;
            noVar.b[0] = 0.0d;
            int i9 = 1;
            while (true) {
                float[] fArr6 = noVar.f3119a;
                if (i9 >= fArr6.length) {
                    break;
                }
                int i10 = i9 - 1;
                double[] dArr9 = noVar.f3118a;
                double d3 = dArr9[i9] - dArr9[i10];
                double[] dArr10 = noVar.b;
                dArr10[i9] = (d3 * ((double) ((fArr6[i10] + fArr6[i9]) / 2.0f))) + dArr10[i10];
                i9++;
            }
            if (dArr4.length > 1) {
                i = 0;
                aVar2.a = H7.a(0, dArr4, dArr8);
            } else {
                i = 0;
                aVar2.a = null;
            }
            H7.a(i, dArr, dArr2);
        }
    }

    public final String toString() {
        String str = this.f3193a;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<b> it = this.f3194a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            StringBuilder n = lf.n(str, "[");
            n.append(next.f3202a);
            n.append(" , ");
            n.append(decimalFormat.format((double) next.a));
            n.append("] ");
            str = n.toString();
        }
        return str;
    }

    public void c(O6 o6) {
    }
}
