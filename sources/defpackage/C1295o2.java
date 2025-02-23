package defpackage;

import com.google.common.base.Ascii;
import com.google.firebase.perf.util.Constants;
import defpackage.C1493y2;

/* renamed from: o2  reason: default package and case insensitive filesystem */
/* compiled from: Base64 */
public final class C1295o2 extends C1493y2 {
    public static final byte[] c = {Ascii.CR, 10};
    public static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] e = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    public static final byte[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    public final byte[] a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f5608b;

    /* renamed from: c  reason: collision with other field name */
    public final int f5609c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002b A[LOOP:0: B:7:0x0010->B:18:0x002b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x002e A[EDGE_INSN: B:42:0x002e->B:19:0x002e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1295o2(byte[] r10, int r11, boolean r12) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0006
        L_0x0005:
            int r1 = r10.length
        L_0x0006:
            r9.<init>(r11, r1)
            r1 = 1
            r2 = 4
            r3 = 0
            if (r10 == 0) goto L_0x0065
            int r4 = r10.length
            r5 = r0
        L_0x0010:
            if (r5 >= r4) goto L_0x0030
            byte r6 = r10[r5]
            r7 = 61
            if (r7 == r6) goto L_0x002e
            if (r6 < 0) goto L_0x0027
            byte[] r7 = f
            r8 = 123(0x7b, float:1.72E-43)
            if (r6 >= r8) goto L_0x0027
            byte r6 = r7[r6]
            r7 = -1
            if (r6 == r7) goto L_0x0027
            r6 = r1
            goto L_0x0028
        L_0x0027:
            r6 = r0
        L_0x0028:
            if (r6 == 0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            int r5 = r5 + 1
            goto L_0x0010
        L_0x002e:
            r4 = r1
            goto L_0x0031
        L_0x0030:
            r4 = r0
        L_0x0031:
            if (r4 != 0) goto L_0x0048
            if (r11 <= 0) goto L_0x0043
            int r11 = r10.length
            int r11 = r11 + r2
            r9.f5609c = r11
            int r11 = r10.length
            byte[] r11 = new byte[r11]
            r9.f5608b = r11
            int r2 = r10.length
            java.lang.System.arraycopy(r10, r0, r11, r0, r2)
            goto L_0x0069
        L_0x0043:
            r9.f5609c = r2
            r9.f5608b = r3
            goto L_0x0069
        L_0x0048:
            java.lang.String r11 = "UTF-8"
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x005d }
            r12.<init>(r10, r11)     // Catch:{ UnsupportedEncodingException -> 0x005d }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "lineSeparator must not contain base64 characters: ["
            java.lang.String r0 = "]"
            java.lang.String r11 = defpackage.lf.j(r11, r12, r0)
            r10.<init>(r11)
            throw r10
        L_0x005d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Unknown or unsupported character set name: UTF-8"
            r10.<init>(r11)
            throw r10
        L_0x0065:
            r9.f5609c = r2
            r9.f5608b = r3
        L_0x0069:
            int r10 = r9.f5609c
            int r10 = r10 - r1
            r9.b = r10
            if (r12 == 0) goto L_0x0073
            byte[] r10 = e
            goto L_0x0075
        L_0x0073:
            byte[] r10 = d
        L_0x0075:
            r9.a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1295o2.<init>(byte[], int, boolean):void");
    }

    public final void a(byte[] bArr, int i, C1493y2.a aVar) {
        int i2;
        byte b2;
        if (!aVar.f7070a) {
            if (i < 0) {
                aVar.f7070a = true;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.b;
                if (i3 >= i) {
                    break;
                }
                byte[] e2 = C1493y2.e(i2, aVar);
                int i5 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 == 61) {
                    aVar.f7070a = true;
                    break;
                }
                if (b3 >= 0 && b3 < 123 && (b2 = f[b3]) >= 0) {
                    int i6 = (aVar.e + 1) % 4;
                    aVar.e = i6;
                    int i7 = (aVar.a << 6) + b2;
                    aVar.a = i7;
                    if (i6 == 0) {
                        int i8 = aVar.b;
                        int i9 = i8 + 1;
                        e2[i8] = (byte) ((i7 >> 16) & Constants.MAX_HOST_LENGTH);
                        int i10 = i9 + 1;
                        e2[i9] = (byte) ((i7 >> 8) & Constants.MAX_HOST_LENGTH);
                        aVar.b = i10 + 1;
                        e2[i10] = (byte) (i7 & Constants.MAX_HOST_LENGTH);
                    }
                }
                i3++;
                i4 = i5;
            }
            if (aVar.f7070a && aVar.e != 0) {
                byte[] e3 = C1493y2.e(i2, aVar);
                int i11 = aVar.e;
                if (i11 == 1) {
                    return;
                }
                if (i11 == 2) {
                    int i12 = aVar.a >> 4;
                    aVar.a = i12;
                    int i13 = aVar.b;
                    aVar.b = i13 + 1;
                    e3[i13] = (byte) (i12 & Constants.MAX_HOST_LENGTH);
                } else if (i11 == 3) {
                    int i14 = aVar.a >> 2;
                    aVar.a = i14;
                    int i15 = aVar.b;
                    int i16 = i15 + 1;
                    e3[i15] = (byte) ((i14 >> 8) & Constants.MAX_HOST_LENGTH);
                    aVar.b = i16 + 1;
                    e3[i16] = (byte) (i14 & Constants.MAX_HOST_LENGTH);
                } else {
                    throw new IllegalStateException("Impossible modulus " + aVar.e);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(byte[] r17, int r18, defpackage.C1493y2.a r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r19
            boolean r3 = r2.f7070a
            if (r3 == 0) goto L_0x000b
            return
        L_0x000b:
            r3 = 1
            r4 = 0
            int r5 = r0.f5609c
            byte[] r6 = r0.a
            int r7 = r0.a
            byte[] r8 = r0.f5608b
            if (r1 >= 0) goto L_0x00b0
            r2.f7070a = r3
            int r1 = r2.e
            if (r1 != 0) goto L_0x0020
            if (r7 != 0) goto L_0x0020
            return
        L_0x0020:
            byte[] r1 = defpackage.C1493y2.e(r5, r2)
            int r5 = r2.b
            int r9 = r2.e
            if (r9 == 0) goto L_0x0098
            byte[] r10 = d
            r11 = 61
            if (r9 == r3) goto L_0x0074
            r3 = 2
            if (r9 != r3) goto L_0x005e
            int r9 = r5 + 1
            int r12 = r2.a
            int r13 = r12 >> 10
            r13 = r13 & 63
            byte r13 = r6[r13]
            r1[r5] = r13
            int r13 = r9 + 1
            int r14 = r12 >> 4
            r14 = r14 & 63
            byte r14 = r6[r14]
            r1[r9] = r14
            int r9 = r13 + 1
            r2.b = r9
            int r3 = r12 << 2
            r3 = r3 & 63
            byte r3 = r6[r3]
            r1[r13] = r3
            if (r6 != r10) goto L_0x0098
            int r3 = r9 + 1
            r2.b = r3
            r1[r9] = r11
            goto L_0x0098
        L_0x005e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Impossible modulus "
            r3.<init>(r4)
            int r2 = r2.e
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0074:
            int r3 = r5 + 1
            int r9 = r2.a
            int r12 = r9 >> 2
            r12 = r12 & 63
            byte r12 = r6[r12]
            r1[r5] = r12
            int r12 = r3 + 1
            r2.b = r12
            int r9 = r9 << 4
            r9 = r9 & 63
            byte r9 = r6[r9]
            r1[r3] = r9
            if (r6 != r10) goto L_0x0098
            int r3 = r12 + 1
            r1[r12] = r11
            int r6 = r3 + 1
            r2.b = r6
            r1[r3] = r11
        L_0x0098:
            int r3 = r2.d
            int r6 = r2.b
            int r5 = r6 - r5
            int r5 = r5 + r3
            r2.d = r5
            if (r7 <= 0) goto L_0x0114
            if (r5 <= 0) goto L_0x0114
            int r3 = r8.length
            java.lang.System.arraycopy(r8, r4, r1, r6, r3)
            int r1 = r2.b
            int r3 = r8.length
            int r1 = r1 + r3
            r2.b = r1
            goto L_0x0114
        L_0x00b0:
            r9 = r4
            r10 = r9
        L_0x00b2:
            if (r9 >= r1) goto L_0x0114
            byte[] r11 = defpackage.C1493y2.e(r5, r2)
            int r12 = r2.e
            int r12 = r12 + r3
            int r12 = r12 % 3
            r2.e = r12
            int r13 = r10 + 1
            byte r10 = r17[r10]
            if (r10 >= 0) goto L_0x00c7
            int r10 = r10 + 256
        L_0x00c7:
            int r14 = r2.a
            int r14 = r14 << 8
            int r14 = r14 + r10
            r2.a = r14
            if (r12 != 0) goto L_0x0110
            int r10 = r2.b
            int r12 = r10 + 1
            int r15 = r14 >> 18
            r15 = r15 & 63
            byte r15 = r6[r15]
            r11[r10] = r15
            int r10 = r12 + 1
            int r15 = r14 >> 12
            r15 = r15 & 63
            byte r15 = r6[r15]
            r11[r12] = r15
            int r12 = r10 + 1
            int r15 = r14 >> 6
            r15 = r15 & 63
            byte r15 = r6[r15]
            r11[r10] = r15
            int r10 = r12 + 1
            r2.b = r10
            r14 = r14 & 63
            byte r14 = r6[r14]
            r11[r12] = r14
            int r12 = r2.d
            int r12 = r12 + 4
            r2.d = r12
            if (r7 <= 0) goto L_0x0110
            if (r7 > r12) goto L_0x0110
            int r12 = r8.length
            java.lang.System.arraycopy(r8, r4, r11, r10, r12)
            int r10 = r2.b
            int r11 = r8.length
            int r10 = r10 + r11
            r2.b = r10
            r2.d = r4
        L_0x0110:
            int r9 = r9 + 1
            r10 = r13
            goto L_0x00b2
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1295o2.c(byte[], int, y2$a):void");
    }
}
