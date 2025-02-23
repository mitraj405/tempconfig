package defpackage;

import defpackage.L1;
import java.util.Arrays;

/* renamed from: K1  reason: default package */
/* compiled from: ArrayLinkedVariables */
public final class K1 implements L1.a {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final L1 f318a;

    /* renamed from: a  reason: collision with other field name */
    public final y3 f319a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f320a = false;

    /* renamed from: a  reason: collision with other field name */
    public float[] f321a = new float[8];

    /* renamed from: a  reason: collision with other field name */
    public int[] f322a = new int[8];
    public int b = 8;

    /* renamed from: b  reason: collision with other field name */
    public int[] f323b = new int[8];
    public int c = -1;
    public int d = -1;

    public K1(L1 l1, y3 y3Var) {
        this.f318a = l1;
        this.f319a = y3Var;
    }

    public final C0415yx a(int i) {
        int i2 = this.c;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (i3 == i) {
                return this.f319a.f3424a[this.f322a[i2]];
            }
            i2 = this.f323b[i2];
            i3++;
        }
        return null;
    }

    public final void b(float f) {
        int i = this.c;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            float[] fArr = this.f321a;
            fArr[i] = fArr[i] / f;
            i = this.f323b[i];
            i2++;
        }
    }

    public final float c(L1 l1, boolean z) {
        float e = e(l1.f379a);
        f(l1.f379a, z);
        L1.a aVar = l1.f377a;
        int g = aVar.g();
        for (int i = 0; i < g; i++) {
            C0415yx a2 = aVar.a(i);
            d(a2, aVar.e(a2) * e, z);
        }
        return e;
    }

    public final void clear() {
        int i = this.c;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            C0415yx yxVar = this.f319a.f3424a[this.f322a[i]];
            if (yxVar != null) {
                yxVar.f(this.f318a);
            }
            i = this.f323b[i];
            i2++;
        }
        this.c = -1;
        this.d = -1;
        this.f320a = false;
        this.a = 0;
    }

    public final void d(C0415yx yxVar, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.c;
            L1 l1 = this.f318a;
            if (i == -1) {
                this.c = 0;
                this.f321a[0] = f;
                this.f322a[0] = yxVar.c;
                this.f323b[0] = -1;
                yxVar.h++;
                yxVar.a(l1);
                this.a++;
                if (!this.f320a) {
                    int i2 = this.d + 1;
                    this.d = i2;
                    int[] iArr = this.f322a;
                    if (i2 >= iArr.length) {
                        this.f320a = true;
                        this.d = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i3 = 0;
            int i4 = -1;
            while (i != -1 && i3 < this.a) {
                int i5 = this.f322a[i];
                int i6 = yxVar.c;
                if (i5 == i6) {
                    float[] fArr = this.f321a;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 == 0.0f) {
                        if (i == this.c) {
                            this.c = this.f323b[i];
                        } else {
                            int[] iArr2 = this.f323b;
                            iArr2[i4] = iArr2[i];
                        }
                        if (z) {
                            yxVar.f(l1);
                        }
                        if (this.f320a) {
                            this.d = i;
                        }
                        yxVar.h--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (i5 < i6) {
                    i4 = i;
                }
                i = this.f323b[i];
                i3++;
            }
            int i7 = this.d;
            int i8 = i7 + 1;
            if (this.f320a) {
                int[] iArr3 = this.f322a;
                if (iArr3[i7] != -1) {
                    i7 = iArr3.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr4 = this.f322a;
            if (i7 >= iArr4.length && this.a < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.f322a;
                    if (i9 >= iArr5.length) {
                        break;
                    } else if (iArr5[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr6 = this.f322a;
            if (i7 >= iArr6.length) {
                i7 = iArr6.length;
                int i10 = this.b * 2;
                this.b = i10;
                this.f320a = false;
                this.d = i7 - 1;
                this.f321a = Arrays.copyOf(this.f321a, i10);
                this.f322a = Arrays.copyOf(this.f322a, this.b);
                this.f323b = Arrays.copyOf(this.f323b, this.b);
            }
            this.f322a[i7] = yxVar.c;
            this.f321a[i7] = f;
            if (i4 != -1) {
                int[] iArr7 = this.f323b;
                iArr7[i7] = iArr7[i4];
                iArr7[i4] = i7;
            } else {
                this.f323b[i7] = this.c;
                this.c = i7;
            }
            yxVar.h++;
            yxVar.a(l1);
            this.a++;
            if (!this.f320a) {
                this.d++;
            }
            int i11 = this.d;
            int[] iArr8 = this.f322a;
            if (i11 >= iArr8.length) {
                this.f320a = true;
                this.d = iArr8.length - 1;
            }
        }
    }

    public final float e(C0415yx yxVar) {
        int i = this.c;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            if (this.f322a[i] == yxVar.c) {
                return this.f321a[i];
            }
            i = this.f323b[i];
            i2++;
        }
        return 0.0f;
    }

    public final float f(C0415yx yxVar, boolean z) {
        int i = this.c;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            if (this.f322a[i] == yxVar.c) {
                if (i == this.c) {
                    this.c = this.f323b[i];
                } else {
                    int[] iArr = this.f323b;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    yxVar.f(this.f318a);
                }
                yxVar.h--;
                this.a--;
                this.f322a[i] = -1;
                if (this.f320a) {
                    this.d = i;
                }
                return this.f321a[i];
            }
            i2++;
            i3 = i;
            i = this.f323b[i];
        }
        return 0.0f;
    }

    public final int g() {
        return this.a;
    }

    public final void h() {
        int i = this.c;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            float[] fArr = this.f321a;
            fArr[i] = fArr[i] * -1.0f;
            i = this.f323b[i];
            i2++;
        }
    }

    public final boolean i(C0415yx yxVar) {
        int i = this.c;
        if (i == -1) {
            return false;
        }
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            if (this.f322a[i] == yxVar.c) {
                return true;
            }
            i = this.f323b[i];
            i2++;
        }
        return false;
    }

    public final void j(C0415yx yxVar, float f) {
        if (f == 0.0f) {
            f(yxVar, true);
            return;
        }
        int i = this.c;
        L1 l1 = this.f318a;
        if (i == -1) {
            this.c = 0;
            this.f321a[0] = f;
            this.f322a[0] = yxVar.c;
            this.f323b[0] = -1;
            yxVar.h++;
            yxVar.a(l1);
            this.a++;
            if (!this.f320a) {
                int i2 = this.d + 1;
                this.d = i2;
                int[] iArr = this.f322a;
                if (i2 >= iArr.length) {
                    this.f320a = true;
                    this.d = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = -1;
        int i4 = 0;
        while (i != -1 && i4 < this.a) {
            int i5 = this.f322a[i];
            int i6 = yxVar.c;
            if (i5 == i6) {
                this.f321a[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f323b[i];
            i4++;
        }
        int i7 = this.d;
        int i8 = i7 + 1;
        if (this.f320a) {
            int[] iArr2 = this.f322a;
            if (iArr2[i7] != -1) {
                i7 = iArr2.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr3 = this.f322a;
        if (i7 >= iArr3.length && this.a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f322a;
                if (i9 >= iArr4.length) {
                    break;
                } else if (iArr4[i9] == -1) {
                    i7 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr5 = this.f322a;
        if (i7 >= iArr5.length) {
            i7 = iArr5.length;
            int i10 = this.b * 2;
            this.b = i10;
            this.f320a = false;
            this.d = i7 - 1;
            this.f321a = Arrays.copyOf(this.f321a, i10);
            this.f322a = Arrays.copyOf(this.f322a, this.b);
            this.f323b = Arrays.copyOf(this.f323b, this.b);
        }
        this.f322a[i7] = yxVar.c;
        this.f321a[i7] = f;
        if (i3 != -1) {
            int[] iArr6 = this.f323b;
            iArr6[i7] = iArr6[i3];
            iArr6[i3] = i7;
        } else {
            this.f323b[i7] = this.c;
            this.c = i7;
        }
        yxVar.h++;
        yxVar.a(l1);
        int i11 = this.a + 1;
        this.a = i11;
        if (!this.f320a) {
            this.d++;
        }
        int[] iArr7 = this.f322a;
        if (i11 >= iArr7.length) {
            this.f320a = true;
        }
        if (this.d >= iArr7.length) {
            this.f320a = true;
            this.d = iArr7.length - 1;
        }
    }

    public final float k(int i) {
        int i2 = this.c;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (i3 == i) {
                return this.f321a[i2];
            }
            i2 = this.f323b[i2];
            i3++;
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.c;
        String str = "";
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            StringBuilder J = xx.J(C1058d.z(str, " -> "));
            J.append(this.f321a[i]);
            J.append(" : ");
            StringBuilder J2 = xx.J(J.toString());
            J2.append(this.f319a.f3424a[this.f322a[i]]);
            str = J2.toString();
            i = this.f323b[i];
            i2++;
        }
        return str;
    }
}
