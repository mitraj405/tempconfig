package defpackage;

import android.graphics.Color;
import android.graphics.PointF;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: xe  reason: default package */
/* compiled from: GradientColorParser */
public final class xe implements XB, C1448vz {
    public int a;

    public /* synthetic */ xe(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public Object d(Tg tg, float f) throws IOException {
        boolean z;
        int i;
        ue ueVar;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        if (tg.r() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            tg.a();
        }
        while (tg.j()) {
            arrayList.add(Float.valueOf((float) tg.m()));
        }
        int i7 = 4;
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.a = 2;
        }
        if (z) {
            tg.c();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i8 = this.a;
        float[] fArr = new float[i8];
        int[] iArr = new int[i8];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i = this.a * i7;
            if (i9 >= i) {
                break;
            }
            int i12 = i9 / 4;
            double floatValue = (double) ((Float) arrayList.get(i9)).floatValue();
            int i13 = i9 % 4;
            if (i13 == 0) {
                if (i12 > 0) {
                    float f3 = (float) floatValue;
                    if (fArr[i12 - 1] >= f3) {
                        fArr[i12] = f3 + 0.01f;
                    }
                }
                fArr[i12] = (float) floatValue;
            } else if (i13 == i6) {
                i10 = (int) (floatValue * 255.0d);
            } else if (i13 == 2) {
                i11 = (int) (floatValue * 255.0d);
            } else if (i13 == 3) {
                iArr[i12] = Color.argb(Constants.MAX_HOST_LENGTH, i10, i11, (int) (floatValue * 255.0d));
            }
            i9++;
            i6 = 1;
            i7 = 4;
        }
        ue ueVar2 = new ue(iArr, fArr);
        if (arrayList.size() <= i) {
            return ueVar2;
        }
        int size = (arrayList.size() - i) / 2;
        float[] fArr2 = new float[size];
        float[] fArr3 = new float[size];
        int i14 = 0;
        while (i < arrayList.size()) {
            if (i % 2 == 0) {
                fArr2[i14] = ((Float) arrayList.get(i)).floatValue();
            } else {
                fArr3[i14] = ((Float) arrayList.get(i)).floatValue();
                i14++;
            }
            i++;
        }
        float[] fArr4 = ueVar2.a;
        if (fArr4.length == 0) {
            fArr4 = fArr2;
        } else if (size != 0) {
            int length = fArr4.length + size;
            float[] fArr5 = new float[length];
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < length; i18++) {
                float f4 = Float.NaN;
                if (i16 < fArr4.length) {
                    f2 = fArr4[i16];
                } else {
                    f2 = Float.NaN;
                }
                if (i17 < size) {
                    f4 = fArr2[i17];
                }
                if (Float.isNaN(f4) || f2 < f4) {
                    fArr5[i18] = f2;
                    i16++;
                } else if (Float.isNaN(f2) || f4 < f2) {
                    fArr5[i18] = f4;
                    i17++;
                } else {
                    fArr5[i18] = f2;
                    i16++;
                    i17++;
                    i15++;
                }
            }
            if (i15 == 0) {
                fArr4 = fArr5;
            } else {
                fArr4 = Arrays.copyOf(fArr5, length - i15);
            }
        }
        int length2 = fArr4.length;
        int[] iArr2 = new int[length2];
        int i19 = 0;
        while (i19 < length2) {
            float f5 = fArr4[i19];
            int binarySearch = Arrays.binarySearch(fArr, f5);
            int binarySearch2 = Arrays.binarySearch(fArr2, f5);
            int[] iArr3 = ueVar2.f3317a;
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                float f6 = fArr3[binarySearch2];
                if (iArr3.length < 2 || f5 == fArr[0]) {
                    i2 = i8;
                    ueVar = ueVar2;
                    i3 = iArr3[0];
                } else {
                    int i20 = 1;
                    while (i20 < i8) {
                        float f7 = fArr[i20];
                        if (f7 >= f5 || i20 == i8 - 1) {
                            int i21 = i20 - 1;
                            float f8 = fArr[i21];
                            float f9 = (f5 - f8) / (f7 - f8);
                            int i22 = iArr3[i20];
                            int i23 = iArr3[i21];
                            int red = Color.red(i23);
                            int red2 = Color.red(i22);
                            PointF pointF = C0308ql.a;
                            i2 = i8;
                            int i24 = (int) ((((float) (red2 - red)) * f9) + ((float) red));
                            int green = Color.green(i23);
                            ueVar = ueVar2;
                            int green2 = (int) ((((float) (Color.green(i22) - green)) * f9) + ((float) green));
                            int blue = Color.blue(i23);
                            i3 = Color.argb((int) (f6 * 255.0f), i24, green2, (int) ((f9 * ((float) (Color.blue(i22) - blue))) + ((float) blue)));
                        } else {
                            i20++;
                        }
                    }
                    throw new IllegalArgumentException("Unreachable code.");
                }
                iArr2[i19] = i3;
            } else {
                int i25 = iArr3[binarySearch];
                if (size < 2 || f5 <= fArr2[0]) {
                    i4 = Color.argb((int) (fArr3[0] * 255.0f), Color.red(i25), Color.green(i25), Color.blue(i25));
                } else {
                    int i26 = 1;
                    while (i26 < size) {
                        float f10 = fArr2[i26];
                        int i27 = (f10 > f5 ? 1 : (f10 == f5 ? 0 : -1));
                        if (i27 >= 0 || i26 == size - 1) {
                            if (i27 <= 0) {
                                i5 = (int) (fArr3[i26] * 255.0f);
                            } else {
                                int i28 = i26 - 1;
                                float f11 = fArr2[i28];
                                float f12 = (f5 - f11) / (f10 - f11);
                                float f13 = fArr3[i28];
                                float f14 = fArr3[i26];
                                PointF pointF2 = C0308ql.a;
                                i5 = (int) ((((f14 - f13) * f12) + f13) * 255.0f);
                            }
                            i4 = Color.argb(i5, Color.red(i25), Color.green(i25), Color.blue(i25));
                        } else {
                            i26++;
                        }
                    }
                    throw new IllegalArgumentException("Unreachable code.");
                }
                iArr2[i19] = i4;
                i2 = i8;
                ueVar = ueVar2;
            }
            i19++;
            ueVar2 = ueVar;
            i8 = i2;
        }
        return new ue(iArr2, fArr4);
    }

    public void a() {
    }
}
