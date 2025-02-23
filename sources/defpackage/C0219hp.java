package defpackage;

import android.graphics.Path;

/* renamed from: hp  reason: default package and case insensitive filesystem */
/* compiled from: PathParser */
public final class C0219hp {
    public static boolean a(a[] aVarArr, a[] aVarArr2) {
        if (aVarArr == null || aVarArr2 == null || aVarArr.length != aVarArr2.length) {
            return false;
        }
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            char c = aVar.a;
            a aVar2 = aVarArr2[i];
            if (c != aVar2.a || aVar.f3001a.length != aVar2.f3001a.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] b(float[] fArr, int i) {
        if (i >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int i2 = i - 0;
                int min = Math.min(i2, length - 0);
                float[] fArr2 = new float[i2];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r13 == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        r11 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093 A[Catch:{ NumberFormatException -> 0x00b8 }, LOOP:3: B:22:0x0068->B:42:0x0093, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0092 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.C0219hp.a[] c(java.lang.String r17) {
        /*
            r0 = r17
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = r3
            r3 = r2
        L_0x000b:
            int r5 = r17.length()
            if (r4 >= r5) goto L_0x00df
        L_0x0011:
            int r5 = r17.length()
            r6 = 69
            r7 = 101(0x65, float:1.42E-43)
            if (r4 >= r5) goto L_0x0035
            char r5 = r0.charAt(r4)
            int r8 = r5 + -65
            int r9 = r5 + -90
            int r9 = r9 * r8
            if (r9 <= 0) goto L_0x002d
            int r8 = r5 + -97
            int r9 = r5 + -122
            int r9 = r9 * r8
            if (r9 > 0) goto L_0x0032
        L_0x002d:
            if (r5 == r7) goto L_0x0032
            if (r5 == r6) goto L_0x0032
            goto L_0x0035
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0035:
            java.lang.String r2 = r0.substring(r2, r4)
            java.lang.String r2 = r2.trim()
            boolean r5 = r2.isEmpty()
            if (r5 != 0) goto L_0x00d5
            char r5 = r2.charAt(r3)
            r8 = 122(0x7a, float:1.71E-43)
            if (r5 == r8) goto L_0x00c7
            char r5 = r2.charAt(r3)
            r8 = 90
            if (r5 != r8) goto L_0x0055
            goto L_0x00c7
        L_0x0055:
            int r5 = r2.length()     // Catch:{ NumberFormatException -> 0x00b8 }
            float[] r5 = new float[r5]     // Catch:{ NumberFormatException -> 0x00b8 }
            int r8 = r2.length()     // Catch:{ NumberFormatException -> 0x00b8 }
            r9 = 1
            r10 = r9
            r9 = r3
        L_0x0062:
            if (r10 >= r8) goto L_0x00ad
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r10
        L_0x0068:
            int r15 = r2.length()     // Catch:{ NumberFormatException -> 0x00b8 }
            if (r14 >= r15) goto L_0x0096
            char r15 = r2.charAt(r14)     // Catch:{ NumberFormatException -> 0x00b8 }
            r7 = 32
            if (r15 == r7) goto L_0x008c
            r7 = 101(0x65, float:1.42E-43)
            if (r15 == r6) goto L_0x008a
            if (r15 == r7) goto L_0x008a
            switch(r15) {
                case 44: goto L_0x008e;
                case 45: goto L_0x0084;
                case 46: goto L_0x0080;
                default: goto L_0x007f;
            }     // Catch:{ NumberFormatException -> 0x00b8 }
        L_0x007f:
            goto L_0x008f
        L_0x0080:
            if (r12 != 0) goto L_0x0088
            r12 = 1
            goto L_0x008f
        L_0x0084:
            if (r14 == r10) goto L_0x008f
            if (r13 != 0) goto L_0x008f
        L_0x0088:
            r11 = 1
            goto L_0x008e
        L_0x008a:
            r13 = 1
            goto L_0x0090
        L_0x008c:
            r7 = 101(0x65, float:1.42E-43)
        L_0x008e:
            r9 = 1
        L_0x008f:
            r13 = 0
        L_0x0090:
            if (r9 == 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            int r14 = r14 + 1
            goto L_0x0068
        L_0x0096:
            if (r10 >= r14) goto L_0x00a5
            int r9 = r3 + 1
            java.lang.String r10 = r2.substring(r10, r14)     // Catch:{ NumberFormatException -> 0x00b8 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x00b8 }
            r5[r3] = r10     // Catch:{ NumberFormatException -> 0x00b8 }
            r3 = r9
        L_0x00a5:
            if (r11 == 0) goto L_0x00a8
            goto L_0x00aa
        L_0x00a8:
            int r14 = r14 + 1
        L_0x00aa:
            r10 = r14
            r9 = 0
            goto L_0x0062
        L_0x00ad:
            float[] r3 = b(r5, r3)     // Catch:{ NumberFormatException -> 0x00b8 }
            r5 = 0
            r16 = r5
            r5 = r3
            r3 = r16
            goto L_0x00c9
        L_0x00b8:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r3 = "error in parsing \""
            java.lang.String r4 = "\""
            java.lang.String r2 = defpackage.lf.j(r3, r2, r4)
            r1.<init>(r2, r0)
            throw r1
        L_0x00c7:
            float[] r5 = new float[r3]
        L_0x00c9:
            char r2 = r2.charAt(r3)
            hp$a r3 = new hp$a
            r3.<init>(r2, r5)
            r1.add(r3)
        L_0x00d5:
            int r2 = r4 + 1
            r3 = 0
            r16 = r4
            r4 = r2
            r2 = r16
            goto L_0x000b
        L_0x00df:
            int r4 = r4 - r2
            r3 = 1
            if (r4 != r3) goto L_0x00f9
            int r3 = r17.length()
            if (r2 >= r3) goto L_0x00f9
            char r0 = r0.charAt(r2)
            r2 = 0
            float[] r3 = new float[r2]
            hp$a r4 = new hp$a
            r4.<init>(r0, r3)
            r1.add(r4)
            goto L_0x00fa
        L_0x00f9:
            r2 = 0
        L_0x00fa:
            hp$a[] r0 = new defpackage.C0219hp.a[r2]
            java.lang.Object[] r0 = r1.toArray(r0)
            hp$a[] r0 = (defpackage.C0219hp.a[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0219hp.c(java.lang.String):hp$a[]");
    }

    public static Path d(String str) {
        Path path = new Path();
        try {
            a.b(c(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing ".concat(str), e);
        }
    }

    public static a[] e(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr2[i] = new a(aVarArr[i]);
        }
        return aVarArr2;
    }

    /* renamed from: hp$a */
    /* compiled from: PathParser */
    public static class a {
        public char a;

        /* renamed from: a  reason: collision with other field name */
        public final float[] f3001a;

        public a(char c, float[] fArr) {
            this.a = c;
            this.f3001a = fArr;
        }

        public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            boolean z3;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            boolean z4 = z2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f8;
            double d4 = (double) f2;
            double d5 = (d4 * sin) + (d3 * cos);
            double d6 = d3;
            double d7 = (double) f10;
            double d8 = d5 / d7;
            double d9 = radians;
            double d10 = (double) f6;
            double d11 = ((d4 * cos) + (((double) (-f8)) * sin)) / d10;
            double d12 = d4;
            double d13 = (double) f4;
            double d14 = ((d13 * sin) + (((double) f9) * cos)) / d7;
            double d15 = ((d13 * cos) + (((double) (-f9)) * sin)) / d10;
            double d16 = d8 - d14;
            double d17 = d11 - d15;
            double d18 = (d8 + d14) / 2.0d;
            double d19 = (d11 + d15) / 2.0d;
            double d20 = (d17 * d17) + (d16 * d16);
            if (d20 != 0.0d) {
                double d21 = (1.0d / d20) - 0.25d;
                if (d21 < 0.0d) {
                    float sqrt = (float) (Math.sqrt(d20) / 1.99999d);
                    a(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d21);
                double d22 = d16 * sqrt2;
                double d23 = sqrt2 * d17;
                if (z == z4) {
                    d2 = d18 - d23;
                    d = d19 + d22;
                } else {
                    d2 = d18 + d23;
                    d = d19 - d22;
                }
                double d24 = d11 - d;
                double d25 = sin;
                double atan2 = Math.atan2(d24, d8 - d2);
                double atan22 = Math.atan2(d15 - d, d14 - d2) - atan2;
                int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (i >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 != z3) {
                    if (i > 0) {
                        atan22 -= 6.283185307179586d;
                    } else {
                        atan22 += 6.283185307179586d;
                    }
                }
                double d26 = d2 * d7;
                double d27 = d * d10;
                double d28 = (d26 * cos) - (d27 * d25);
                double d29 = (d27 * cos) + (d26 * d25);
                int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
                double cos2 = Math.cos(d9);
                double sin2 = Math.sin(d9);
                double cos3 = Math.cos(atan2);
                double sin3 = Math.sin(atan2);
                double d30 = -d7;
                double d31 = d30 * cos2;
                double d32 = d10 * sin2;
                double d33 = (d31 * sin3) - (d32 * cos3);
                double d34 = d30 * sin2;
                double d35 = d10 * cos2;
                double d36 = (cos3 * d35) + (sin3 * d34);
                double d37 = d35;
                double d38 = atan22 / ((double) ceil);
                int i2 = 0;
                while (i2 < ceil) {
                    double d39 = atan2 + d38;
                    double sin4 = Math.sin(d39);
                    double cos4 = Math.cos(d39);
                    double d40 = d38;
                    double d41 = (((d7 * cos2) * cos4) + d28) - (d32 * sin4);
                    double d42 = d37;
                    double d43 = d28;
                    double d44 = (d42 * sin4) + (d7 * sin2 * cos4) + d29;
                    double d45 = (d31 * sin4) - (d32 * cos4);
                    double d46 = (cos4 * d42) + (sin4 * d34);
                    double d47 = d39 - atan2;
                    double tan = Math.tan(d47 / 2.0d);
                    double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
                    double d48 = (d33 * sqrt3) + d6;
                    double d49 = d39;
                    double d50 = (d36 * sqrt3) + d12;
                    double d51 = d34;
                    int i3 = ceil;
                    path.rLineTo(0.0f, 0.0f);
                    path.cubicTo((float) d48, (float) d50, (float) (d41 - (sqrt3 * d45)), (float) (d44 - (sqrt3 * d46)), (float) d41, (float) d44);
                    i2++;
                    atan2 = d49;
                    d34 = d51;
                    cos2 = cos2;
                    ceil = i3;
                    d36 = d46;
                    d7 = d7;
                    d33 = d45;
                    d6 = d41;
                    d12 = d44;
                    d28 = d43;
                    d38 = d40;
                    d37 = d42;
                }
            }
        }

        @Deprecated
        public static void b(a[] aVarArr, Path path) {
            int i;
            float f;
            a aVar;
            int i2;
            int i3;
            char c;
            int i4;
            int i5;
            char c2;
            int i6;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            float f2;
            float f3;
            float f4;
            int i7;
            char c3;
            float f5;
            float f6;
            float f7;
            float f8;
            int i8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            a[] aVarArr2 = aVarArr;
            Path path2 = path;
            float[] fArr = new float[6];
            int length = aVarArr2.length;
            int i9 = 0;
            int i10 = 0;
            char c4 = 'm';
            while (i10 < length) {
                a aVar2 = aVarArr2[i10];
                char c5 = aVar2.a;
                float f20 = fArr[i9];
                float f21 = fArr[1];
                float f22 = fArr[2];
                float f23 = fArr[3];
                float f24 = fArr[4];
                float f25 = fArr[5];
                switch (c5) {
                    case 'A':
                    case 'a':
                        i = 7;
                        break;
                    case 'C':
                    case 'c':
                        i = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path2.moveTo(f24, f25);
                        f20 = f24;
                        f22 = f20;
                        f21 = f25;
                        f23 = f21;
                        break;
                }
                i = 2;
                float f26 = f24;
                float f27 = f25;
                float f28 = f20;
                float f29 = f21;
                int i11 = i9;
                while (true) {
                    float[] fArr2 = aVar2.f3001a;
                    if (i11 < fArr2.length) {
                        if (c5 != 'A') {
                            if (c5 == 'C') {
                                float[] fArr3 = fArr2;
                                i4 = i11;
                                c = c5;
                                aVar = aVar2;
                                i3 = i10;
                                i2 = length;
                                int i12 = i4 + 2;
                                int i13 = i4 + 3;
                                int i14 = i4 + 4;
                                int i15 = i4 + 5;
                                path.cubicTo(fArr3[i4 + 0], fArr3[i4 + 1], fArr3[i12], fArr3[i13], fArr3[i14], fArr3[i15]);
                                float f30 = fArr3[i14];
                                f29 = fArr3[i15];
                                f28 = f30;
                                f22 = fArr3[i12];
                                f = fArr3[i13];
                            } else if (c5 == 'H') {
                                float[] fArr4 = fArr2;
                                i4 = i11;
                                c = c5;
                                aVar = aVar2;
                                i3 = i10;
                                i2 = length;
                                int i16 = i4 + 0;
                                path2.lineTo(fArr4[i16], f29);
                                f28 = fArr4[i16];
                            } else if (c5 == 'Q') {
                                float[] fArr5 = fArr2;
                                i4 = i11;
                                c = c5;
                                aVar = aVar2;
                                i3 = i10;
                                i2 = length;
                                int i17 = i4 + 0;
                                int i18 = i4 + 1;
                                int i19 = i4 + 2;
                                int i20 = i4 + 3;
                                path2.quadTo(fArr5[i17], fArr5[i18], fArr5[i19], fArr5[i20]);
                                float f31 = fArr5[i17];
                                float f32 = fArr5[i18];
                                f28 = fArr5[i19];
                                f29 = fArr5[i20];
                                f22 = f31;
                                f = f32;
                            } else if (c5 == 'V') {
                                float[] fArr6 = fArr2;
                                i4 = i11;
                                c = c5;
                                aVar = aVar2;
                                i3 = i10;
                                i2 = length;
                                int i21 = i4 + 0;
                                path2.lineTo(f28, fArr6[i21]);
                                f29 = fArr6[i21];
                            } else if (c5 != 'a') {
                                if (c5 != 'c') {
                                    if (c5 == 'h') {
                                        float[] fArr7 = fArr2;
                                        i4 = i11;
                                        c = c5;
                                        i2 = length;
                                        float f33 = f29;
                                        int i22 = i4 + 0;
                                        path2.rLineTo(fArr7[i22], 0.0f);
                                        f28 += fArr7[i22];
                                    } else if (c5 != 'q') {
                                        if (c5 != 'v') {
                                            if (c5 != 'L') {
                                                if (c5 == 'M') {
                                                    float[] fArr8 = fArr2;
                                                    i4 = i11;
                                                    c = c5;
                                                    i2 = length;
                                                    f12 = fArr8[i4 + 0];
                                                    f11 = fArr8[i4 + 1];
                                                    if (i4 > 0) {
                                                        path2.lineTo(f12, f11);
                                                    } else {
                                                        path2.moveTo(f12, f11);
                                                        f26 = f12;
                                                        f27 = f11;
                                                    }
                                                } else if (c5 == 'S') {
                                                    float[] fArr9 = fArr2;
                                                    i8 = i11;
                                                    c3 = c5;
                                                    i7 = length;
                                                    float f34 = f29;
                                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                        f13 = (f34 * 2.0f) - f;
                                                        f14 = (f28 * 2.0f) - f22;
                                                    } else {
                                                        f14 = f28;
                                                        f13 = f34;
                                                    }
                                                    int i23 = i8 + 0;
                                                    int i24 = i8 + 1;
                                                    int i25 = i8 + 2;
                                                    int i26 = i8 + 3;
                                                    path.cubicTo(f14, f13, fArr9[i23], fArr9[i24], fArr9[i25], fArr9[i26]);
                                                    f4 = fArr9[i23];
                                                    float f35 = fArr9[i24];
                                                    f3 = fArr9[i25];
                                                    f2 = fArr9[i26];
                                                    f = f35;
                                                    f28 = f3;
                                                    f29 = f2;
                                                    f22 = f4;
                                                } else if (c5 == 'T') {
                                                    float[] fArr10 = fArr2;
                                                    i4 = i11;
                                                    c = c5;
                                                    i2 = length;
                                                    float f36 = f29;
                                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                        f28 = (f28 * 2.0f) - f22;
                                                        f15 = (f36 * 2.0f) - f;
                                                    } else {
                                                        f15 = f36;
                                                    }
                                                    int i27 = i4 + 0;
                                                    int i28 = i4 + 1;
                                                    path2.quadTo(f28, f15, fArr10[i27], fArr10[i28]);
                                                    f = f15;
                                                    aVar = aVar2;
                                                    i3 = i10;
                                                    f22 = f28;
                                                    f28 = fArr10[i27];
                                                    f29 = fArr10[i28];
                                                } else if (c5 == 'l') {
                                                    float[] fArr11 = fArr2;
                                                    i4 = i11;
                                                    c = c5;
                                                    i2 = length;
                                                    f9 = f29;
                                                    int i29 = i4 + 0;
                                                    int i30 = i4 + 1;
                                                    path2.rLineTo(fArr11[i29], fArr11[i30]);
                                                    f28 += fArr11[i29];
                                                    f10 = fArr11[i30];
                                                } else if (c5 == 'm') {
                                                    float[] fArr12 = fArr2;
                                                    i4 = i11;
                                                    c = c5;
                                                    i2 = length;
                                                    float f37 = fArr12[i4 + 0];
                                                    f28 += f37;
                                                    float f38 = fArr12[i4 + 1];
                                                    f29 += f38;
                                                    if (i4 > 0) {
                                                        path2.rLineTo(f37, f38);
                                                    } else {
                                                        path2.rMoveTo(f37, f38);
                                                        f27 = f29;
                                                        f26 = f28;
                                                    }
                                                } else if (c5 != 's') {
                                                    if (c5 == 't') {
                                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                            f18 = f28 - f22;
                                                            f19 = f29 - f;
                                                        } else {
                                                            f19 = 0.0f;
                                                            f18 = 0;
                                                        }
                                                        int i31 = i11 + 0;
                                                        int i32 = i11 + 1;
                                                        path2.rQuadTo(f18, f19, fArr2[i31], fArr2[i32]);
                                                        float f39 = f18 + f28;
                                                        float f40 = f19 + f29;
                                                        f28 += fArr2[i31];
                                                        f29 += fArr2[i32];
                                                        f = f40;
                                                        f22 = f39;
                                                    }
                                                    i4 = i11;
                                                    c = c5;
                                                    i2 = length;
                                                } else {
                                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                        f17 = f28 - f22;
                                                        f16 = f29 - f;
                                                    } else {
                                                        f17 = 0.0f;
                                                        f16 = 0.0f;
                                                    }
                                                    int i33 = i11 + 0;
                                                    float f41 = fArr2[i33];
                                                    int i34 = i11 + 1;
                                                    float f42 = fArr2[i34];
                                                    int i35 = i11 + 2;
                                                    float f43 = fArr2[i35];
                                                    int i36 = i11 + 3;
                                                    float f44 = fArr2[i36];
                                                    float[] fArr13 = fArr2;
                                                    float f45 = f17;
                                                    i8 = i11;
                                                    i7 = length;
                                                    f5 = f29;
                                                    float f46 = f43;
                                                    c3 = c5;
                                                    path.rCubicTo(f45, f16, f41, f42, f46, f44);
                                                    f4 = fArr13[i33] + f28;
                                                    f8 = fArr13[i34] + f5;
                                                    f6 = f28 + fArr13[i35];
                                                    f7 = fArr13[i36];
                                                }
                                                f28 = f26;
                                                f29 = f27;
                                            } else {
                                                float[] fArr14 = fArr2;
                                                i4 = i11;
                                                c = c5;
                                                i2 = length;
                                                int i37 = i4 + 0;
                                                int i38 = i4 + 1;
                                                path2.lineTo(fArr14[i37], fArr14[i38]);
                                                f12 = fArr14[i37];
                                                f11 = fArr14[i38];
                                            }
                                            f28 = f12;
                                            f29 = f11;
                                        } else {
                                            float[] fArr15 = fArr2;
                                            i4 = i11;
                                            c = c5;
                                            i2 = length;
                                            f9 = f29;
                                            int i39 = i4 + 0;
                                            path2.rLineTo(0.0f, fArr15[i39]);
                                            f10 = fArr15[i39];
                                        }
                                        f29 = f9 + f10;
                                    } else {
                                        float[] fArr16 = fArr2;
                                        i8 = i11;
                                        c3 = c5;
                                        i7 = length;
                                        f5 = f29;
                                        int i40 = i8 + 0;
                                        int i41 = i8 + 1;
                                        int i42 = i8 + 2;
                                        int i43 = i8 + 3;
                                        path2.rQuadTo(fArr16[i40], fArr16[i41], fArr16[i42], fArr16[i43]);
                                        f4 = fArr16[i40] + f28;
                                        f8 = fArr16[i41] + f5;
                                        f6 = f28 + fArr16[i42];
                                        f7 = fArr16[i43];
                                    }
                                    aVar = aVar2;
                                    i3 = i10;
                                } else {
                                    float[] fArr17 = fArr2;
                                    i8 = i11;
                                    c3 = c5;
                                    i7 = length;
                                    f5 = f29;
                                    int i44 = i8 + 2;
                                    int i45 = i8 + 3;
                                    int i46 = i8 + 4;
                                    int i47 = i8 + 5;
                                    path.rCubicTo(fArr17[i8 + 0], fArr17[i8 + 1], fArr17[i44], fArr17[i45], fArr17[i46], fArr17[i47]);
                                    f4 = fArr17[i44] + f28;
                                    f8 = fArr17[i45] + f5;
                                    f6 = f28 + fArr17[i46];
                                    f7 = fArr17[i47];
                                }
                                f2 = f5 + f7;
                                f = f8;
                                f3 = f6;
                                f28 = f3;
                                f29 = f2;
                                f22 = f4;
                                aVar = aVar2;
                                i3 = i10;
                            } else {
                                float[] fArr18 = fArr2;
                                i5 = i11;
                                c2 = c5;
                                i6 = length;
                                float f47 = f29;
                                int i48 = i5 + 5;
                                float f48 = fArr18[i48] + f28;
                                int i49 = i5 + 6;
                                float f49 = fArr18[i49] + f47;
                                float f50 = fArr18[i5 + 0];
                                float f51 = fArr18[i5 + 1];
                                float f52 = fArr18[i5 + 2];
                                if (fArr18[i5 + 3] != 0.0f) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (fArr18[i5 + 4] != 0.0f) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                aVar = aVar2;
                                i3 = i10;
                                a(path, f28, f47, f48, f49, f50, f51, f52, z3, z4);
                                f28 += fArr18[i48];
                                f29 = f47 + fArr18[i49];
                            }
                            i11 = i4 + i;
                            a[] aVarArr3 = aVarArr;
                            c4 = c;
                            c5 = c4;
                            i10 = i3;
                            length = i2;
                            aVar2 = aVar;
                        } else {
                            float[] fArr19 = fArr2;
                            i5 = i11;
                            c2 = c5;
                            aVar = aVar2;
                            i3 = i10;
                            i6 = length;
                            float f53 = f29;
                            int i50 = i5 + 5;
                            float f54 = fArr19[i50];
                            int i51 = i5 + 6;
                            float f55 = fArr19[i51];
                            float f56 = fArr19[i5 + 0];
                            float f57 = fArr19[i5 + 1];
                            float f58 = fArr19[i5 + 2];
                            if (fArr19[i5 + 3] != 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (fArr19[i5 + 4] != 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            a(path, f28, f53, f54, f55, f56, f57, f58, z, z2);
                            f28 = fArr19[i50];
                            f29 = fArr19[i51];
                        }
                        f = f29;
                        f22 = f28;
                        i11 = i4 + i;
                        a[] aVarArr32 = aVarArr;
                        c4 = c;
                        c5 = c4;
                        i10 = i3;
                        length = i2;
                        aVar2 = aVar;
                    } else {
                        fArr[0] = f28;
                        fArr[1] = f29;
                        fArr[2] = f22;
                        fArr[3] = f;
                        fArr[4] = f26;
                        fArr[5] = f27;
                        c4 = aVar2.a;
                        i10++;
                        i9 = 0;
                        length = length;
                        aVarArr2 = aVarArr;
                    }
                }
            }
        }

        public a(a aVar) {
            this.a = aVar.a;
            float[] fArr = aVar.f3001a;
            this.f3001a = C0219hp.b(fArr, fArr.length);
        }
    }
}
