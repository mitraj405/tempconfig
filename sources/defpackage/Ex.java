package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* renamed from: Ex  reason: default package */
/* compiled from: SplineSet */
public abstract class Ex {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public H7 f166a;

    /* renamed from: a  reason: collision with other field name */
    public String f167a;

    /* renamed from: a  reason: collision with other field name */
    public float[] f168a = new float[10];

    /* renamed from: a  reason: collision with other field name */
    public int[] f169a = new int[10];

    public final float a(float f) {
        return (float) this.f166a.b((double) f);
    }

    public void b(float f, int i) {
        int[] iArr = this.f169a;
        if (iArr.length < this.a + 1) {
            this.f169a = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f168a;
            this.f168a = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f169a;
        int i2 = this.a;
        iArr2[i2] = i;
        this.f168a[i2] = f;
        this.a = i2 + 1;
    }

    public void c(int i) {
        int i2 = this.a;
        if (i2 != 0) {
            int[] iArr = this.f169a;
            float[] fArr = this.f168a;
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i2 - 1;
            iArr2[1] = 0;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int i7 = iArr[i6];
                    int i8 = i5;
                    int i9 = i8;
                    while (i8 < i6) {
                        int i10 = iArr[i8];
                        if (i10 <= i7) {
                            int i11 = iArr[i9];
                            iArr[i9] = i10;
                            iArr[i8] = i11;
                            float f = fArr[i9];
                            fArr[i9] = fArr[i8];
                            fArr[i8] = f;
                            i9++;
                        }
                        i8++;
                    }
                    int i12 = iArr[i9];
                    iArr[i9] = iArr[i6];
                    iArr[i6] = i12;
                    float f2 = fArr[i9];
                    fArr[i9] = fArr[i6];
                    fArr[i6] = f2;
                    int i13 = i3 + 1;
                    iArr2[i3] = i9 - 1;
                    int i14 = i13 + 1;
                    iArr2[i13] = i5;
                    int i15 = i14 + 1;
                    iArr2[i14] = i6;
                    i3 = i15 + 1;
                    iArr2[i15] = i9 + 1;
                }
            }
            int i16 = 1;
            for (int i17 = 1; i17 < this.a; i17++) {
                int[] iArr3 = this.f169a;
                if (iArr3[i17 - 1] != iArr3[i17]) {
                    i16++;
                }
            }
            double[] dArr = new double[i16];
            int[] iArr4 = new int[2];
            iArr4[1] = 1;
            iArr4[0] = i16;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr4);
            int i18 = 0;
            for (int i19 = 0; i19 < this.a; i19++) {
                if (i19 > 0) {
                    int[] iArr5 = this.f169a;
                    if (iArr5[i19] == iArr5[i19 - 1]) {
                    }
                }
                dArr[i18] = ((double) this.f169a[i19]) * 0.01d;
                dArr2[i18][0] = (double) this.f168a[i19];
                i18++;
            }
            this.f166a = H7.a(i, dArr, dArr2);
        }
    }

    public final String toString() {
        String str = this.f167a;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.a; i++) {
            StringBuilder n = lf.n(str, "[");
            n.append(this.f169a[i]);
            n.append(" , ");
            n.append(decimalFormat.format((double) this.f168a[i]));
            n.append("] ");
            str = n.toString();
        }
        return str;
    }
}
