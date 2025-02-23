package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;

public class Salsa20Engine implements SkippingStreamCipher {
    public static final int[] c;
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6045a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6046a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f6047a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f6048b;

    /* renamed from: c  reason: collision with other field name */
    public int f6049c;
    public int d;
    public int e;

    static {
        byte[] d2 = Strings.d("expand 16-byte kexpand 32-byte k");
        int[] iArr = new int[8];
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = Pack.f(i, d2);
            i += 4;
        }
        c = iArr;
        Strings.d("expand 32-byte k");
        Strings.d("expand 16-byte k");
    }

    public Salsa20Engine() {
        this(20);
    }

    public static void g(int i, int[] iArr) {
        int i2 = (i - 16) / 4;
        int[] iArr2 = c;
        iArr[0] = iArr2[i2];
        iArr[1] = iArr2[i2 + 1];
        iArr[2] = iArr2[i2 + 2];
        iArr[3] = iArr2[i2 + 3];
    }

    public static void i(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            int i2 = iArr3[0];
            int i3 = iArr3[1];
            int i4 = iArr3[2];
            int i5 = iArr3[3];
            int i6 = iArr3[4];
            int i7 = iArr3[5];
            int i8 = iArr3[6];
            int i9 = iArr3[7];
            int i10 = iArr3[8];
            int i11 = iArr3[9];
            int i12 = iArr3[10];
            int i13 = iArr3[11];
            int i14 = iArr3[12];
            int i15 = iArr3[13];
            int i16 = iArr3[14];
            int i17 = iArr3[15];
            int i18 = i16;
            int i19 = i15;
            int i20 = i14;
            int i21 = i13;
            int i22 = i12;
            int i23 = i11;
            int i24 = i10;
            int i25 = i9;
            int i26 = i8;
            int i27 = i7;
            int i28 = i6;
            int i29 = i5;
            int i30 = i4;
            int i31 = i3;
            int i32 = i2;
            for (int i33 = i; i33 > 0; i33 -= 2) {
                int i34 = i32 + i20;
                int i35 = i28 ^ ((i34 >>> -7) | (i34 << 7));
                int i36 = i35 + i32;
                int i37 = i24 ^ ((i36 >>> -9) | (i36 << 9));
                int i38 = i37 + i35;
                int i39 = i20 ^ ((i38 >>> -13) | (i38 << 13));
                int i40 = i39 + i37;
                int i41 = i32 ^ ((i40 >>> -18) | (i40 << 18));
                int i42 = i27 + i31;
                int i43 = i23 ^ ((i42 >>> -7) | (i42 << 7));
                int i44 = i43 + i27;
                int i45 = i19 ^ ((i44 >>> -9) | (i44 << 9));
                int i46 = i45 + i43;
                int i47 = i31 ^ ((i46 >>> -13) | (i46 << 13));
                int i48 = i47 + i45;
                int i49 = i27 ^ ((i48 >>> -18) | (i48 << 18));
                int i50 = i22 + i26;
                int i51 = i18 ^ ((i50 >>> -7) | (i50 << 7));
                int i52 = i51 + i22;
                int i53 = i30 ^ ((i52 >>> -9) | (i52 << 9));
                int i54 = i53 + i51;
                int i55 = i26 ^ ((i54 >>> -13) | (i54 << 13));
                int i56 = i55 + i53;
                int i57 = i22 ^ ((i56 >>> -18) | (i56 << 18));
                int i58 = i17 + i21;
                int i59 = i29 ^ ((i58 >>> -7) | (i58 << 7));
                int i60 = i59 + i17;
                int i61 = i25 ^ ((i60 >>> -9) | (i60 << 9));
                int i62 = i61 + i59;
                int i63 = i21 ^ ((i62 >>> -13) | (i62 << 13));
                int i64 = i63 + i61;
                int i65 = i17 ^ ((i64 >>> -18) | (i64 << 18));
                int i66 = i41 + i59;
                i31 = i47 ^ ((i66 >>> -7) | (i66 << 7));
                int i67 = i31 + i41;
                i30 = i53 ^ ((i67 >>> -9) | (i67 << 9));
                int i68 = i30 + i31;
                i29 = i59 ^ ((i68 >>> -13) | (i68 << 13));
                int i69 = i29 + i30;
                i32 = i41 ^ ((i69 >>> -18) | (i69 << 18));
                int i70 = i49 + i35;
                i26 = i55 ^ ((i70 >>> -7) | (i70 << 7));
                int i71 = i26 + i49;
                i25 = i61 ^ ((i71 >>> -9) | (i71 << 9));
                int i72 = i25 + i26;
                i28 = i35 ^ ((i72 >>> -13) | (i72 << 13));
                int i73 = i28 + i25;
                i27 = i49 ^ ((i73 >>> -18) | (i73 << 18));
                int i74 = i57 + i43;
                i21 = i63 ^ ((i74 >>> -7) | (i74 << 7));
                int i75 = i21 + i57;
                i24 = i37 ^ ((i75 >>> -9) | (i75 << 9));
                int i76 = i24 + i21;
                i23 = i43 ^ ((i76 >>> -13) | (i76 << 13));
                int i77 = i23 + i24;
                i22 = i57 ^ ((i77 >>> -18) | (i77 << 18));
                int i78 = i65 + i51;
                i20 = i39 ^ ((i78 >>> -7) | (i78 << 7));
                int i79 = i20 + i65;
                i19 = i45 ^ ((i79 >>> -9) | (i79 << 9));
                int i80 = i19 + i20;
                i18 = i51 ^ ((i80 >>> -13) | (i80 << 13));
                int i81 = i18 + i19;
                i17 = i65 ^ ((i81 >>> -18) | (i81 << 18));
            }
            iArr4[0] = i32 + iArr3[0];
            iArr4[1] = i31 + iArr3[1];
            iArr4[2] = i30 + iArr3[2];
            iArr4[3] = i29 + iArr3[3];
            iArr4[4] = i28 + iArr3[4];
            iArr4[5] = i27 + iArr3[5];
            iArr4[6] = i26 + iArr3[6];
            iArr4[7] = i25 + iArr3[7];
            iArr4[8] = i24 + iArr3[8];
            iArr4[9] = i23 + iArr3[9];
            iArr4[10] = i22 + iArr3[10];
            iArr4[11] = i21 + iArr3[11];
            iArr4[12] = i20 + iArr3[12];
            iArr4[13] = i19 + iArr3[13];
            iArr4[14] = i18 + iArr3[14];
            iArr4[15] = i17 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            if (bArr == null || bArr.length != f()) {
                throw new IllegalArgumentException(b() + " requires exactly " + f() + " bytes of IV");
            }
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 == null) {
                if (this.f6045a) {
                    j((byte[]) null, bArr);
                } else {
                    throw new IllegalStateException(b() + " KeyParameter can not be null for first initialisation");
                }
            } else if (cipherParameters2 instanceof KeyParameter) {
                j(((KeyParameter) cipherParameters2).a, bArr);
            } else {
                throw new IllegalArgumentException(b() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            reset();
            this.f6045a = true;
            return;
        }
        throw new IllegalArgumentException(b() + " Init parameters must include an IV");
    }

    public String b() {
        int i = this.a;
        if (i == 20) {
            return "Salsa20";
        }
        return "Salsa20/" + i;
    }

    public void c() {
        int[] iArr = this.f6047a;
        int i = iArr[8] + 1;
        iArr[8] = i;
        if (i == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[LOOP:0: B:16:0x002e->B:20:0x004d, LOOP_START, PHI: r1 
      PHI: (r1v3 int) = (r1v2 int), (r1v4 int) binds: [B:15:0x002c, B:20:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(byte[] r8, int r9, int r10, byte[] r11, int r12) {
        /*
            r7 = this;
            boolean r0 = r7.f6045a
            if (r0 == 0) goto L_0x0069
            int r0 = r9 + r10
            int r1 = r8.length
            if (r0 > r1) goto L_0x0061
            int r0 = r12 + r10
            int r1 = r11.length
            if (r0 > r1) goto L_0x0059
            int r0 = r7.f6049c
            int r0 = r0 + r10
            r7.f6049c = r0
            r1 = 0
            r2 = 1
            if (r0 >= r10) goto L_0x002b
            if (r0 < 0) goto L_0x002b
            int r0 = r7.d
            int r0 = r0 + r2
            r7.d = r0
            if (r0 != 0) goto L_0x002b
            int r0 = r7.e
            int r0 = r0 + r2
            r7.e = r0
            r0 = r0 & 32
            if (r0 == 0) goto L_0x002b
            r0 = r2
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            if (r0 != 0) goto L_0x0051
        L_0x002e:
            if (r1 >= r10) goto L_0x0050
            int r0 = r1 + r12
            int r3 = r7.b
            byte[] r4 = r7.f6046a
            byte r5 = r4[r3]
            int r6 = r1 + r9
            byte r6 = r8[r6]
            r5 = r5 ^ r6
            byte r5 = (byte) r5
            r11[r0] = r5
            int r3 = r3 + r2
            r0 = r3 & 63
            r7.b = r0
            if (r0 != 0) goto L_0x004d
            r7.c()
            r7.e(r4)
        L_0x004d:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0050:
            return r10
        L_0x0051:
            org.spongycastle.crypto.MaxBytesExceededException r8 = new org.spongycastle.crypto.MaxBytesExceededException
            java.lang.String r9 = "2^70 byte limit per IV would be exceeded; Change IV"
            r8.<init>(r9)
            throw r8
        L_0x0059:
            org.spongycastle.crypto.OutputLengthException r8 = new org.spongycastle.crypto.OutputLengthException
            java.lang.String r9 = "output buffer too short"
            r8.<init>(r9)
            throw r8
        L_0x0061:
            org.spongycastle.crypto.DataLengthException r8 = new org.spongycastle.crypto.DataLengthException
            java.lang.String r9 = "input buffer too short"
            r8.<init>(r9)
            throw r8
        L_0x0069:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.b()
            r9.append(r10)
            java.lang.String r10 = " not initialised"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.Salsa20Engine.d(byte[], int, int, byte[], int):int");
    }

    public void e(byte[] bArr) {
        int[] iArr = this.f6047a;
        int i = this.a;
        int[] iArr2 = this.f6048b;
        i(iArr, i, iArr2);
        int i2 = 0;
        for (int e2 : iArr2) {
            Pack.e(e2, bArr, i2);
            i2 += 4;
        }
    }

    public int f() {
        return 8;
    }

    public void h() {
        int[] iArr = this.f6047a;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    public void j(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.f6047a;
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                int length = (bArr.length - 16) / 4;
                int[] iArr2 = c;
                iArr[0] = iArr2[length];
                iArr[5] = iArr2[length + 1];
                iArr[10] = iArr2[length + 2];
                iArr[15] = iArr2[length + 3];
                Pack.g(bArr, 0, iArr, 1, 4);
                Pack.g(bArr, bArr.length - 16, iArr, 11, 4);
            } else {
                throw new IllegalArgumentException(b() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.g(bArr2, 0, iArr, 6, 2);
    }

    public final void reset() {
        this.b = 0;
        this.f6049c = 0;
        this.d = 0;
        this.e = 0;
        h();
        e(this.f6046a);
    }

    public Salsa20Engine(int i) {
        this.b = 0;
        this.f6047a = new int[16];
        this.f6048b = new int[16];
        this.f6046a = new byte[64];
        this.f6045a = false;
        if (i <= 0 || (i & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.a = i;
    }
}
