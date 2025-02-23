package org.spongycastle.crypto.modes;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.GCMUtil;
import org.spongycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class GCMBlockCipher implements AEADBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f6161a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6162a;

    /* renamed from: a  reason: collision with other field name */
    public final GCMMultiplier f6163a;

    /* renamed from: a  reason: collision with other field name */
    public Tables1kGCMExponentiator f6164a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6165a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6166a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f6167b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f6168b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6169b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public long f6170c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6171c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public byte[] f6172d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;

    public GCMBlockCipher(BlockCipher blockCipher) {
        if (blockCipher.c() == 16) {
            Tables8kGCMMultiplier tables8kGCMMultiplier = new Tables8kGCMMultiplier();
            this.f6162a = blockCipher;
            this.f6163a = tables8kGCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        this.f6165a = z;
        this.g = null;
        this.f6168b = true;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.b;
            this.f6171c = aEADParameters.f6227a;
            int i3 = aEADParameters.c;
            if (i3 < 32 || i3 > 128 || i3 % 8 != 0) {
                throw new IllegalArgumentException(lf.h("Invalid value for MAC size: ", i3));
            }
            this.a = i3 / 8;
            keyParameter = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.f6233a;
            this.f6171c = null;
            this.a = 16;
            keyParameter = (KeyParameter) parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        if (z) {
            i2 = 16;
        } else {
            i2 = this.a + 16;
        }
        this.f = new byte[i2];
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && (bArr2 = this.f6169b) != null && Arrays.a(bArr2, bArr)) {
            if (keyParameter != null) {
                byte[] bArr3 = this.f6166a;
                if (bArr3 != null && Arrays.a(bArr3, keyParameter.a)) {
                    throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
                }
            } else {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.f6169b = bArr;
        if (keyParameter != null) {
            this.f6166a = keyParameter.a;
        }
        GCMMultiplier gCMMultiplier = this.f6163a;
        if (keyParameter != null) {
            BlockCipher blockCipher = this.f6162a;
            blockCipher.a(true, keyParameter);
            byte[] bArr4 = new byte[16];
            this.f6172d = bArr4;
            blockCipher.e(0, 0, bArr4, bArr4);
            gCMMultiplier.b(this.f6172d);
            this.f6164a = null;
        } else if (this.f6172d == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr5 = new byte[16];
        this.e = bArr5;
        byte[] bArr6 = this.f6169b;
        if (bArr6.length == 12) {
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
            this.e[15] = 1;
        } else {
            int length = bArr6.length;
            for (int i4 = 0; i4 < length; i4 += 16) {
                int min = Math.min(length - i4, 16);
                int[] iArr = GCMUtil.a;
                while (true) {
                    min--;
                    if (min < 0) {
                        break;
                    }
                    bArr5[min] = (byte) (bArr5[min] ^ bArr6[i4 + min]);
                }
                gCMMultiplier.a(bArr5);
            }
            byte[] bArr7 = new byte[16];
            Pack.j(((long) this.f6169b.length) * 8, bArr7, 8);
            byte[] bArr8 = this.e;
            GCMUtil.e(bArr8, bArr7);
            gCMMultiplier.a(bArr8);
        }
        this.h = new byte[16];
        this.i = new byte[16];
        this.j = new byte[16];
        this.l = new byte[16];
        this.d = 0;
        this.f6167b = 0;
        this.f6170c = 0;
        this.k = Arrays.c(this.e);
        this.b = -2;
        this.c = 0;
        this.f6161a = 0;
        byte[] bArr9 = this.f6171c;
        if (bArr9 != null) {
            i(0, bArr9, bArr9.length);
        }
    }

    public final void b() {
        if (this.f6168b) {
            return;
        }
        if (this.f6165a) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    public final int c(int i2, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        b();
        if (this.f6161a == 0) {
            k();
        }
        int i3 = this.c;
        if (!this.f6165a) {
            int i4 = this.a;
            if (i3 >= i4) {
                i3 -= i4;
                if (bArr.length < i2 + i3) {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else if (bArr.length < i2 + i3 + this.a) {
            throw new OutputLengthException("Output buffer too short");
        }
        GCMMultiplier gCMMultiplier = this.f6163a;
        if (i3 > 0) {
            byte[] bArr2 = this.f;
            byte[] j2 = j();
            int[] iArr = GCMUtil.a;
            int i5 = i3;
            while (true) {
                i5--;
                if (i5 < 0) {
                    break;
                }
                j2[i5] = (byte) (j2[i5] ^ bArr2[0 + i5]);
            }
            System.arraycopy(j2, 0, bArr, i2, i3);
            byte[] bArr3 = this.h;
            if (this.f6165a) {
                bArr2 = j2;
            }
            int[] iArr2 = GCMUtil.a;
            int i6 = i3;
            while (true) {
                i6--;
                if (i6 < 0) {
                    break;
                }
                bArr3[i6] = (byte) (bArr3[i6] ^ bArr2[0 + i6]);
            }
            gCMMultiplier.a(bArr3);
            this.f6161a += (long) i3;
        }
        long j3 = this.f6167b;
        int i7 = this.d;
        long j4 = j3 + ((long) i7);
        this.f6167b = j4;
        if (j4 > this.f6170c) {
            if (i7 > 0) {
                byte[] bArr4 = this.i;
                byte[] bArr5 = this.l;
                int[] iArr3 = GCMUtil.a;
                while (true) {
                    i7--;
                    if (i7 < 0) {
                        break;
                    }
                    bArr4[i7] = (byte) (bArr4[i7] ^ bArr5[0 + i7]);
                }
                gCMMultiplier.a(bArr4);
            }
            if (this.f6170c > 0) {
                GCMUtil.e(this.i, this.j);
            }
            long j5 = ((this.f6161a * 8) + 127) >>> 7;
            byte[] bArr6 = new byte[16];
            if (this.f6164a == null) {
                Tables1kGCMExponentiator tables1kGCMExponentiator = new Tables1kGCMExponentiator();
                this.f6164a = tables1kGCMExponentiator;
                tables1kGCMExponentiator.b(this.f6172d);
            }
            this.f6164a.a(bArr6, j5);
            byte[] bArr7 = this.i;
            int[] a2 = GCMUtil.a(bArr7);
            GCMUtil.b(a2, GCMUtil.a(bArr6));
            Pack.d(bArr7, a2);
            GCMUtil.e(this.h, this.i);
        }
        byte[] bArr8 = new byte[16];
        Pack.j(this.f6167b * 8, bArr8, 0);
        Pack.j(this.f6161a * 8, bArr8, 8);
        byte[] bArr9 = this.h;
        GCMUtil.e(bArr9, bArr8);
        gCMMultiplier.a(bArr9);
        byte[] bArr10 = new byte[16];
        this.f6162a.e(0, 0, this.e, bArr10);
        GCMUtil.e(bArr10, this.h);
        int i8 = this.a;
        byte[] bArr11 = new byte[i8];
        this.g = bArr11;
        System.arraycopy(bArr10, 0, bArr11, 0, i8);
        if (this.f6165a) {
            System.arraycopy(this.g, 0, bArr, i2 + this.c, this.a);
            i3 += this.a;
        } else {
            int i9 = this.a;
            byte[] bArr12 = new byte[i9];
            System.arraycopy(this.f, i3, bArr12, 0, i9);
            if (!Arrays.l(this.g, bArr12)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        l(false);
        return i3;
    }

    public final int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        b();
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = this.f;
                int i7 = this.c;
                bArr3[i7] = bArr[i2 + i6];
                int i8 = i7 + 1;
                this.c = i8;
                if (i8 == bArr3.length) {
                    int i9 = i4 + i5;
                    if (bArr2.length >= i9 + 16) {
                        if (this.f6161a == 0) {
                            k();
                        }
                        byte[] bArr4 = this.f;
                        byte[] j2 = j();
                        GCMUtil.e(j2, bArr4);
                        System.arraycopy(j2, 0, bArr2, i9, 16);
                        byte[] bArr5 = this.h;
                        if (this.f6165a) {
                            bArr4 = j2;
                        }
                        GCMUtil.e(bArr5, bArr4);
                        this.f6163a.a(bArr5);
                        this.f6161a += 16;
                        if (this.f6165a) {
                            this.c = 0;
                        } else {
                            byte[] bArr6 = this.f;
                            System.arraycopy(bArr6, 16, bArr6, 0, this.a);
                            this.c = this.a;
                        }
                        i5 += 16;
                    } else {
                        throw new OutputLengthException("Output buffer too short");
                    }
                }
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public final int e(int i2) {
        int i3 = i2 + this.c;
        if (this.f6165a) {
            return i3 + this.a;
        }
        int i4 = this.a;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    public final int f(int i2) {
        int i3 = i2 + this.c;
        if (!this.f6165a) {
            int i4 = this.a;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % 16);
    }

    public final BlockCipher g() {
        return this.f6162a;
    }

    public final byte[] h() {
        byte[] bArr = this.g;
        if (bArr == null) {
            return new byte[this.a];
        }
        return Arrays.c(bArr);
    }

    public final void i(int i2, byte[] bArr, int i3) {
        b();
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.l;
            int i5 = this.d;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.d = i6;
            if (i6 == 16) {
                byte[] bArr3 = this.i;
                GCMUtil.e(bArr3, bArr2);
                this.f6163a.a(bArr3);
                this.d = 0;
                this.f6167b += 16;
            }
        }
    }

    public final byte[] j() {
        int i2 = this.b;
        if (i2 != 0) {
            this.b = i2 - 1;
            byte[] bArr = this.k;
            int i3 = (bArr[15] & UnsignedBytes.MAX_VALUE) + 1;
            bArr[15] = (byte) i3;
            int i4 = (i3 >>> 8) + (bArr[14] & UnsignedBytes.MAX_VALUE);
            bArr[14] = (byte) i4;
            int i5 = (i4 >>> 8) + (bArr[13] & UnsignedBytes.MAX_VALUE);
            bArr[13] = (byte) i5;
            bArr[12] = (byte) ((i5 >>> 8) + (bArr[12] & UnsignedBytes.MAX_VALUE));
            byte[] bArr2 = new byte[16];
            this.f6162a.e(0, 0, bArr, bArr2);
            return bArr2;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    public final void k() {
        if (this.f6167b > 0) {
            System.arraycopy(this.i, 0, this.j, 0, 16);
            this.f6170c = this.f6167b;
        }
        int i2 = this.d;
        if (i2 > 0) {
            byte[] bArr = this.j;
            byte[] bArr2 = this.l;
            int[] iArr = GCMUtil.a;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[0 + i2]);
            }
            this.f6163a.a(bArr);
            this.f6170c += (long) this.d;
        }
        if (this.f6170c > 0) {
            System.arraycopy(this.j, 0, this.h, 0, 16);
        }
    }

    public final void l(boolean z) {
        this.f6162a.reset();
        this.h = new byte[16];
        this.i = new byte[16];
        this.j = new byte[16];
        this.l = new byte[16];
        this.d = 0;
        this.f6167b = 0;
        this.f6170c = 0;
        this.k = Arrays.c(this.e);
        this.b = -2;
        this.c = 0;
        this.f6161a = 0;
        byte[] bArr = this.f;
        if (bArr != null) {
            Arrays.p(bArr, (byte) 0);
        }
        if (z) {
            this.g = null;
        }
        if (this.f6165a) {
            this.f6168b = false;
            return;
        }
        byte[] bArr2 = this.f6171c;
        if (bArr2 != null) {
            i(0, bArr2, bArr2.length);
        }
    }
}
