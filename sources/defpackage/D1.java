package defpackage;

import java.util.Arrays;

/* renamed from: D1  reason: default package */
/* compiled from: ArcCurveFit */
public final class D1 extends H7 {
    public final double[] a;

    /* renamed from: a  reason: collision with other field name */
    public final a[] f100a;

    /* renamed from: D1$a */
    /* compiled from: ArcCurveFit */
    public static class a {
        public static final double[] b = new double[91];
        public double a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f101a;

        /* renamed from: a  reason: collision with other field name */
        public final double[] f102a;

        /* renamed from: b  reason: collision with other field name */
        public final double f103b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f104b = false;
        public final double c;
        public final double d;
        public final double e;
        public final double f;
        public final double g;
        public final double h;
        public final double i;
        public final double j;
        public final double k;
        public final double l;
        public final double m;
        public double n;
        public double o;

        public a(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i3;
            double d8;
            double[] dArr;
            int i4 = i2;
            double d9 = d2;
            double d10 = d3;
            double d11 = d4;
            double d12 = d5;
            double d13 = d6;
            double d14 = d7;
            boolean z = false;
            int i5 = 1;
            z = i4 == 1 ? true : z;
            this.f101a = z;
            this.f103b = d9;
            this.c = d10;
            double d15 = 1.0d / (d10 - d9);
            this.h = d15;
            if (3 == i4) {
                this.f104b = true;
            }
            double d16 = d13 - d11;
            double d17 = d15;
            double d18 = d14 - d12;
            if (this.f104b || Math.abs(d16) < 0.001d || Math.abs(d18) < 0.001d) {
                this.f104b = true;
                this.d = d11;
                this.e = d6;
                this.f = d12;
                this.g = d14;
                double d19 = d16;
                double hypot = Math.hypot(d18, d19);
                this.a = hypot;
                this.m = hypot * d17;
                this.k = d19 / (d3 - d2);
                this.l = d18 / (d3 - d2);
                return;
            }
            this.f102a = new double[101];
            this.i = ((double) (z ? -1 : i5)) * d16;
            if (z) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.j = d18 * ((double) i3);
            this.k = z ? d6 : d11;
            if (z) {
                d8 = d12;
            } else {
                d8 = d14;
            }
            this.l = d8;
            double d20 = d12 - d14;
            int i6 = 0;
            double d21 = 0.0d;
            double d22 = 0.0d;
            double d23 = 0.0d;
            while (true) {
                dArr = b;
                if (i6 >= 91) {
                    break;
                }
                double d24 = d16;
                double radians = Math.toRadians((((double) i6) * 90.0d) / ((double) 90));
                double sin = Math.sin(radians) * d24;
                double cos = Math.cos(radians) * d20;
                if (i6 > 0) {
                    d21 += Math.hypot(sin - d22, cos - d23);
                    dArr[i6] = d21;
                }
                i6++;
                d23 = cos;
                d22 = sin;
                d16 = d24;
            }
            this.a = d21;
            for (int i7 = 0; i7 < 91; i7++) {
                dArr[i7] = dArr[i7] / d21;
            }
            int i8 = 0;
            while (true) {
                double[] dArr2 = this.f102a;
                if (i8 < dArr2.length) {
                    double length = ((double) i8) / ((double) (dArr2.length - 1));
                    int binarySearch = Arrays.binarySearch(dArr, length);
                    if (binarySearch >= 0) {
                        dArr2[i8] = ((double) binarySearch) / ((double) 90);
                    } else if (binarySearch == -1) {
                        dArr2[i8] = 0.0d;
                    } else {
                        int i9 = -binarySearch;
                        int i10 = i9 - 2;
                        double d25 = dArr[i10];
                        dArr2[i8] = (((length - d25) / (dArr[i9 - 1] - d25)) + ((double) i10)) / ((double) 90);
                    }
                    i8++;
                } else {
                    this.m = this.a * this.h;
                    return;
                }
            }
        }

        public final double a() {
            double d2 = this.i * this.o;
            double hypot = this.m / Math.hypot(d2, (-this.j) * this.n);
            if (this.f101a) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        public final double b() {
            double d2 = this.i * this.o;
            double d3 = (-this.j) * this.n;
            double hypot = this.m / Math.hypot(d2, d3);
            if (this.f101a) {
                return (-d3) * hypot;
            }
            return d3 * hypot;
        }

        public final double c(double d2) {
            double d3 = (d2 - this.f103b) * this.h;
            double d4 = this.e;
            double d5 = this.d;
            return ((d4 - d5) * d3) + d5;
        }

        public final double d(double d2) {
            double d3 = (d2 - this.f103b) * this.h;
            double d4 = this.g;
            double d5 = this.f;
            return ((d4 - d5) * d3) + d5;
        }

        public final double e() {
            return (this.i * this.n) + this.k;
        }

        public final double f() {
            return (this.j * this.o) + this.l;
        }

        public final void g(double d2) {
            double d3;
            if (this.f101a) {
                d3 = this.c - d2;
            } else {
                d3 = d2 - this.f103b;
            }
            double d4 = d3 * this.h;
            double d5 = 0.0d;
            if (d4 > 0.0d) {
                d5 = 1.0d;
                if (d4 < 1.0d) {
                    double[] dArr = this.f102a;
                    double length = d4 * ((double) (dArr.length - 1));
                    int i2 = (int) length;
                    double d6 = dArr[i2];
                    d5 = ((dArr[i2 + 1] - d6) * (length - ((double) i2))) + d6;
                }
            }
            double d7 = d5 * 1.5707963267948966d;
            this.n = Math.sin(d7);
            this.o = Math.cos(d7);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r5 == 1) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public D1(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r0.a = r1
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            D1$a[] r2 = new defpackage.D1.a[r2]
            r0.f100a = r2
            r2 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x0014:
            D1$a[] r7 = r0.f100a
            int r8 = r7.length
            if (r4 >= r8) goto L_0x004d
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L_0x002d
            if (r8 == r3) goto L_0x002a
            r10 = 2
            if (r8 == r10) goto L_0x0028
            if (r8 == r9) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            if (r5 != r3) goto L_0x002a
        L_0x0028:
            r5 = r10
            goto L_0x002b
        L_0x002a:
            r5 = r3
        L_0x002b:
            r6 = r5
            goto L_0x002e
        L_0x002d:
            r6 = r9
        L_0x002e:
            D1$a r22 = new D1$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r2]
            r16 = r8[r3]
            r8 = r27[r23]
            r18 = r8[r2]
            r20 = r8[r3]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L_0x0014
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.D1.<init>(int[], double[], double[][]):void");
    }

    public final double b(double d) {
        a[] aVarArr = this.f100a;
        int i = 0;
        a aVar = aVarArr[0];
        double d2 = aVar.f103b;
        if (d < d2) {
            double d3 = d - d2;
            if (aVar.f104b) {
                return (d3 * aVarArr[0].k) + aVar.c(d2);
            }
            aVar.g(d2);
            return (aVarArr[0].a() * d3) + aVarArr[0].e();
        } else if (d > aVarArr[aVarArr.length - 1].c) {
            double d4 = aVarArr[aVarArr.length - 1].c;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            return (d5 * aVarArr[length].k) + aVarArr[length].c(d4);
        } else {
            while (i < aVarArr.length) {
                a aVar2 = aVarArr[i];
                if (d > aVar2.c) {
                    i++;
                } else if (aVar2.f104b) {
                    return aVar2.c(d);
                } else {
                    aVar2.g(d);
                    return aVarArr[i].e();
                }
            }
            return Double.NaN;
        }
    }

    public final void c(double d, double[] dArr) {
        a[] aVarArr = this.f100a;
        a aVar = aVarArr[0];
        double d2 = aVar.f103b;
        if (d < d2) {
            double d3 = d - d2;
            if (aVar.f104b) {
                double c = aVar.c(d2);
                a aVar2 = aVarArr[0];
                dArr[0] = (aVar2.k * d3) + c;
                dArr[1] = (d3 * aVarArr[0].l) + aVar2.d(d2);
                return;
            }
            aVar.g(d2);
            dArr[0] = (aVarArr[0].a() * d3) + aVarArr[0].e();
            dArr[1] = (aVarArr[0].b() * d3) + aVarArr[0].f();
        } else if (d > aVarArr[aVarArr.length - 1].c) {
            double d4 = aVarArr[aVarArr.length - 1].c;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            a aVar3 = aVarArr[length];
            if (aVar3.f104b) {
                double c2 = aVar3.c(d4);
                a aVar4 = aVarArr[length];
                dArr[0] = (aVar4.k * d5) + c2;
                dArr[1] = (d5 * aVarArr[length].l) + aVar4.d(d4);
                return;
            }
            aVar3.g(d);
            dArr[0] = (aVarArr[length].a() * d5) + aVarArr[length].e();
            dArr[1] = (aVarArr[length].b() * d5) + aVarArr[length].f();
        } else {
            int i = 0;
            while (i < aVarArr.length) {
                a aVar5 = aVarArr[i];
                if (d > aVar5.c) {
                    i++;
                } else if (aVar5.f104b) {
                    dArr[0] = aVar5.c(d);
                    dArr[1] = aVarArr[i].d(d);
                    return;
                } else {
                    aVar5.g(d);
                    dArr[0] = aVarArr[i].e();
                    dArr[1] = aVarArr[i].f();
                    return;
                }
            }
        }
    }

    public final void d(double d, float[] fArr) {
        a[] aVarArr = this.f100a;
        a aVar = aVarArr[0];
        double d2 = aVar.f103b;
        if (d < d2) {
            double d3 = d - d2;
            if (aVar.f104b) {
                double c = aVar.c(d2);
                a aVar2 = aVarArr[0];
                fArr[0] = (float) ((aVar2.k * d3) + c);
                fArr[1] = (float) ((d3 * aVarArr[0].l) + aVar2.d(d2));
                return;
            }
            aVar.g(d2);
            fArr[0] = (float) ((aVarArr[0].a() * d3) + aVarArr[0].e());
            fArr[1] = (float) ((aVarArr[0].b() * d3) + aVarArr[0].f());
        } else if (d > aVarArr[aVarArr.length - 1].c) {
            double d4 = aVarArr[aVarArr.length - 1].c;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            a aVar3 = aVarArr[length];
            if (aVar3.f104b) {
                double c2 = aVar3.c(d4);
                a aVar4 = aVarArr[length];
                fArr[0] = (float) ((aVar4.k * d5) + c2);
                fArr[1] = (float) ((d5 * aVarArr[length].l) + aVar4.d(d4));
                return;
            }
            aVar3.g(d);
            fArr[0] = (float) aVarArr[length].e();
            fArr[1] = (float) aVarArr[length].f();
        } else {
            int i = 0;
            while (i < aVarArr.length) {
                a aVar5 = aVarArr[i];
                if (d > aVar5.c) {
                    i++;
                } else if (aVar5.f104b) {
                    fArr[0] = (float) aVar5.c(d);
                    fArr[1] = (float) aVarArr[i].d(d);
                    return;
                } else {
                    aVar5.g(d);
                    fArr[0] = (float) aVarArr[i].e();
                    fArr[1] = (float) aVarArr[i].f();
                    return;
                }
            }
        }
    }

    public final double e(double d) {
        a[] aVarArr = this.f100a;
        int i = 0;
        double d2 = aVarArr[0].f103b;
        if (d < d2) {
            d = d2;
        }
        if (d > aVarArr[aVarArr.length - 1].c) {
            d = aVarArr[aVarArr.length - 1].c;
        }
        while (i < aVarArr.length) {
            a aVar = aVarArr[i];
            if (d > aVar.c) {
                i++;
            } else if (aVar.f104b) {
                return aVar.k;
            } else {
                aVar.g(d);
                return aVarArr[i].a();
            }
        }
        return Double.NaN;
    }

    public final void f(double d, double[] dArr) {
        a[] aVarArr = this.f100a;
        double d2 = aVarArr[0].f103b;
        if (d < d2) {
            d = d2;
        } else if (d > aVarArr[aVarArr.length - 1].c) {
            d = aVarArr[aVarArr.length - 1].c;
        }
        int i = 0;
        while (i < aVarArr.length) {
            a aVar = aVarArr[i];
            if (d > aVar.c) {
                i++;
            } else if (aVar.f104b) {
                dArr[0] = aVar.k;
                dArr[1] = aVar.l;
                return;
            } else {
                aVar.g(d);
                dArr[0] = aVarArr[i].a();
                dArr[1] = aVarArr[i].b();
                return;
            }
        }
    }

    public final double[] g() {
        return this.a;
    }
}
