package defpackage;

import androidx.datastore.preferences.protobuf.q;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* renamed from: OB  reason: default package */
/* compiled from: Utf8 */
public final class OB {
    public static final b a;

    /* renamed from: OB$a */
    /* compiled from: Utf8 */
    public static class a {
        public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws q {
            if (!c(b2)) {
                if ((((b2 + 112) + (b << Ascii.FS)) >> 30) == 0 && !c(b3) && !c(b4)) {
                    byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & 63) << Ascii.FF) | ((b3 & 63) << 6) | (b4 & 63);
                    cArr[i] = (char) ((b5 >>> 10) + 55232);
                    cArr[i + 1] = (char) ((b5 & UnsignedBytes.MAX_VALUE) + Ascii.NUL);
                    return;
                }
            }
            throw q.a();
        }

        public static void b(byte b, byte b2, byte b3, char[] cArr, int i) throws q {
            if (c(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || c(b3)))) {
                throw q.a();
            }
            cArr[i] = (char) (((b & Ascii.SI) << Ascii.FF) | ((b2 & 63) << 6) | (b3 & 63));
        }

        public static boolean c(byte b) {
            if (b > -65) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: OB$b */
    /* compiled from: Utf8 */
    public static abstract class b {
        public abstract String a(byte[] bArr, int i, int i2) throws q;

        public abstract int b(CharSequence charSequence, byte[] bArr, int i, int i2);

        public abstract int c(byte[] bArr, int i, int i2);
    }

    /* renamed from: OB$c */
    /* compiled from: Utf8 */
    public static final class c extends b {
        public final String a(byte[] bArr, int i, int i2) throws q {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte b = bArr[r13];
                    if (b >= 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        break;
                    }
                    i = r13 + 1;
                    cArr[i4] = (char) b;
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte b2 = bArr[r13];
                    if (b2 >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b2;
                        r13 = i6;
                        while (true) {
                            i5 = i7;
                            if (r13 >= i3) {
                                break;
                            }
                            byte b3 = bArr[r13];
                            if (b3 >= 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                break;
                            }
                            r13++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b3;
                        }
                    } else {
                        if (b2 < -32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (b2 < -16) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    a.b(b2, bArr[i6], bArr[i8], cArr, i5);
                                    r13 = i8 + 1;
                                    i5++;
                                } else {
                                    throw q.a();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte b4 = bArr[i6];
                                int i10 = i9 + 1;
                                a.a(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                                i5 = i5 + 1 + 1;
                                r13 = i10 + 1;
                            } else {
                                throw q.a();
                            }
                        } else if (i6 < i3) {
                            int i11 = i6 + 1;
                            byte b5 = bArr[i6];
                            int i12 = i5 + 1;
                            if (b2 < -62 || a.c(b5)) {
                                throw q.a();
                            }
                            cArr[i5] = (char) (((b2 & Ascii.US) << 6) | (b5 & 63));
                            r13 = i11;
                            i5 = i12;
                        } else {
                            throw q.a();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public final int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i3 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i3 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new d(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new d(i7, length);
                }
                i8 = i3;
                i7++;
            }
            return i8;
        }

        public final int c(byte[] bArr, int i, int i2) {
            while (r7 < i2 && bArr[r7] >= 0) {
                i = r7 + 1;
            }
            if (r7 < i2) {
                while (r7 < i2) {
                    int i3 = r7 + 1;
                    byte b = bArr[r7];
                    if (b < 0) {
                        if (b < -32) {
                            if (i3 >= i2) {
                                return b;
                            }
                            if (b >= -62) {
                                r7 = i3 + 1;
                                if (bArr[i3] > -65) {
                                }
                            }
                        } else if (b < -16) {
                            if (i3 >= i2 - 1) {
                                return OB.a(bArr, i3, i2);
                            }
                            int i4 = i3 + 1;
                            byte b2 = bArr[i3];
                            if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                                r7 = i4 + 1;
                                if (bArr[i4] > -65) {
                                }
                            }
                        } else if (i3 >= i2 - 2) {
                            return OB.a(bArr, i3, i2);
                        } else {
                            int i5 = i3 + 1;
                            byte b3 = bArr[i3];
                            if (b3 <= -65) {
                                if ((((b3 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                                    int i6 = i5 + 1;
                                    if (bArr[i5] <= -65) {
                                        i3 = i6 + 1;
                                        if (bArr[i6] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    r7 = i3;
                }
            }
            return 0;
        }
    }

    /* renamed from: OB$d */
    /* compiled from: Utf8 */
    public static class d extends IllegalArgumentException {
        public d(int i, int i2) {
            super(lf.i("Unpaired surrogate at index ", i, " of ", i2));
        }
    }

    /* renamed from: OB$e */
    /* compiled from: Utf8 */
    public static final class e extends b {
        public static int d(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                b bVar = OB.a;
                if (i > -12) {
                    return -1;
                }
                return i;
            } else if (i2 == 1) {
                return OB.c(i, C0285oB.g(bArr, j));
            } else {
                if (i2 == 2) {
                    return OB.d(i, C0285oB.g(bArr, j), C0285oB.g(bArr, j + 1));
                }
                throw new AssertionError();
            }
        }

        public final String a(byte[] bArr, int i, int i2) throws q {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte g = C0285oB.g(bArr, (long) r13);
                    if (g >= 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        break;
                    }
                    i = r13 + 1;
                    cArr[i4] = (char) g;
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte g2 = C0285oB.g(bArr, (long) r13);
                    if (g2 >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) g2;
                        r13 = i6;
                        while (true) {
                            i5 = i7;
                            if (r13 >= i3) {
                                break;
                            }
                            byte g3 = C0285oB.g(bArr, (long) r13);
                            if (g3 >= 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                break;
                            }
                            r13++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) g3;
                        }
                    } else {
                        if (g2 < -32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (g2 < -16) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    a.b(g2, C0285oB.g(bArr, (long) i6), C0285oB.g(bArr, (long) i8), cArr, i5);
                                    r13 = i8 + 1;
                                    i5++;
                                } else {
                                    throw q.a();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte g4 = C0285oB.g(bArr, (long) i6);
                                int i10 = i9 + 1;
                                a.a(g2, g4, C0285oB.g(bArr, (long) i9), C0285oB.g(bArr, (long) i10), cArr, i5);
                                i5 = i5 + 1 + 1;
                                r13 = i10 + 1;
                            } else {
                                throw q.a();
                            }
                        } else if (i6 < i3) {
                            int i11 = i6 + 1;
                            byte g5 = C0285oB.g(bArr, (long) i6);
                            int i12 = i5 + 1;
                            if (g2 < -62 || a.c(g5)) {
                                throw q.a();
                            }
                            cArr[i5] = (char) (((g2 & Ascii.US) << 6) | (g5 & 63));
                            r13 = i11;
                            i5 = i12;
                        } else {
                            throw q.a();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int b(java.lang.CharSequence r22, byte[] r23, int r24, int r25) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                r2 = r24
                r3 = r25
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r22.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0141
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0141
                r2 = 0
            L_0x001a:
                r11 = 1
                r3 = 128(0x80, float:1.794E-43)
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                defpackage.C0285oB.p(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x013f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004a
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004a
                long r14 = r4 + r11
                byte r13 = (byte) r13
                defpackage.C0285oB.p(r1, r4, r13)
                r4 = r11
                r12 = r14
                r11 = r3
                goto L_0x00fc
            L_0x004a:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0074
                r14 = 2
                long r14 = r6 - r14
                int r14 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r14 > 0) goto L_0x0074
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                defpackage.C0285oB.p(r1, r4, r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                defpackage.C0285oB.p(r1, r14, r5)
                r19 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r19
                goto L_0x00fc
            L_0x0074:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007e
                if (r3 >= r13) goto L_0x00af
            L_0x007e:
                r15 = 3
                long r15 = r6 - r15
                int r15 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r15 > 0) goto L_0x00af
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                defpackage.C0285oB.p(r1, r4, r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                defpackage.C0285oB.p(r1, r14, r5)
                r14 = 1
                long r17 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                defpackage.C0285oB.p(r1, r3, r5)
                r12 = r17
                r4 = 1
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fc
            L_0x00af:
                r11 = 4
                long r11 = r6 - r11
                int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r11 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                defpackage.C0285oB.p(r1, r4, r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                defpackage.C0285oB.p(r1, r13, r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                defpackage.C0285oB.p(r1, r4, r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                defpackage.C0285oB.p(r1, r14, r2)
                r2 = r3
            L_0x00fc:
                int r2 = r2 + 1
                r3 = r11
                r19 = r4
                r4 = r12
                r11 = r19
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                OB$d r0 = new OB$d
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                OB$d r0 = new OB$d
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x013f:
                int r0 = (int) r4
                return r0
            L_0x0141:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.OB.e.b(java.lang.CharSequence, byte[], int, int):int");
        }

        public final int c(byte[] bArr, int i, int i2) {
            int i3;
            long j;
            if ((i | i2 | (bArr.length - i2)) >= 0) {
                long j2 = (long) i;
                int i4 = (int) (((long) i2) - j2);
                if (i4 >= 16) {
                    i3 = 0;
                    long j3 = j2;
                    while (true) {
                        if (i3 >= i4) {
                            i3 = i4;
                            break;
                        }
                        long j4 = j3 + 1;
                        if (C0285oB.g(bArr, j3) < 0) {
                            break;
                        }
                        i3++;
                        j3 = j4;
                    }
                } else {
                    i3 = 0;
                }
                int i5 = i4 - i3;
                long j5 = j2 + ((long) i3);
                while (true) {
                    byte b = 0;
                    while (true) {
                        if (i5 <= 0) {
                            break;
                        }
                        long j6 = j5 + 1;
                        b = C0285oB.g(bArr, j5);
                        if (b < 0) {
                            j5 = j6;
                            break;
                        }
                        i5--;
                        j5 = j6;
                    }
                    if (i5 == 0) {
                        return 0;
                    }
                    int i6 = i5 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i6 >= 3) {
                                i5 = i6 - 3;
                                long j7 = j5 + 1;
                                byte g = C0285oB.g(bArr, j5);
                                if (g > -65) {
                                    break;
                                }
                                if ((((g + 112) + (b << Ascii.FS)) >> 30) != 0) {
                                    break;
                                }
                                long j8 = j7 + 1;
                                if (C0285oB.g(bArr, j7) > -65) {
                                    break;
                                }
                                j = j8 + 1;
                                if (C0285oB.g(bArr, j8) > -65) {
                                    break;
                                }
                            } else {
                                return d(bArr, b, j5, i6);
                            }
                        } else if (i6 >= 2) {
                            i5 = i6 - 2;
                            long j9 = j5 + 1;
                            byte g2 = C0285oB.g(bArr, j5);
                            if (g2 > -65 || ((b == -32 && g2 < -96) || (b == -19 && g2 >= -96))) {
                                break;
                            }
                            j5 = j9 + 1;
                            if (C0285oB.g(bArr, j9) > -65) {
                                break;
                            }
                        } else {
                            return d(bArr, b, j5, i6);
                        }
                    } else if (i6 != 0) {
                        i5 = i6 - 1;
                        if (b < -62) {
                            break;
                        }
                        j = j5 + 1;
                        if (C0285oB.g(bArr, j5) > -65) {
                            break;
                        }
                    } else {
                        return b;
                    }
                    j5 = j;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
    }

    static {
        boolean z;
        b bVar;
        if (!C0285oB.b || !C0285oB.f3142a) {
            z = false;
        } else {
            z = true;
        }
        if (!z || A0.a()) {
            bVar = new c();
        } else {
            bVar = new e();
        }
        a = bVar;
    }

    public static int a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            return c(b2, bArr[i]);
        } else {
            if (i3 == 2) {
                return d(b2, bArr[i], bArr[i + 1]);
            }
            throw new AssertionError();
        }
    }

    public static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new d(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    public static int c(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int d(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }
}
