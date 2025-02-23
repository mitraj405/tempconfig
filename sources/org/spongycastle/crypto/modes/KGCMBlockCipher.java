package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class KGCMBlockCipher implements AEADBlockCipher {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);
    public static final BigInteger c = new BigInteger("340282366920938463463374607431768211456", 10);
    public static final BigInteger d = new BigInteger("340282366920938463463374607431768211455", 10);
    public static final BigInteger e = new BigInteger("135", 10);
    public static final BigInteger f = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936", 10);
    public static final BigInteger g = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639935", 10);
    public static final BigInteger h = new BigInteger("1061", 10);
    public static final BigInteger i = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096", 10);
    public static final BigInteger j = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084095", 10);
    public static final BigInteger k = new BigInteger("293", 10);

    /* renamed from: a  reason: collision with other field name */
    public int f6187a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6188a;

    /* renamed from: a  reason: collision with other field name */
    public final BufferedBlockCipher f6189a;

    /* renamed from: a  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6190a = new ExposedByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6191a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6192a;

    /* renamed from: b  reason: collision with other field name */
    public int f6193b;

    /* renamed from: b  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6194b = new ExposedByteArrayOutputStream();

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6195b;

    /* renamed from: c  reason: collision with other field name */
    public int f6196c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6197c;

    /* renamed from: d  reason: collision with other field name */
    public byte[] f6198d;

    /* renamed from: e  reason: collision with other field name */
    public byte[] f6199e;

    /* renamed from: f  reason: collision with other field name */
    public byte[] f6200f;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public final byte[] a() {
            return this.buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.f6188a = blockCipher;
        this.f6189a = new BufferedBlockCipher(new KCTRBlockCipher(blockCipher));
        this.f6187a = 0;
        this.f6192a = new byte[blockCipher.c()];
        this.f6197c = new byte[blockCipher.c()];
        this.f6198d = new byte[blockCipher.c()];
        this.f6199e = new byte[blockCipher.c()];
        this.f6200f = new byte[blockCipher.c()];
        this.f6196c = 0;
        this.f6193b = 0;
        this.f6195b = null;
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.f6191a = z;
        boolean z2 = cipherParameters instanceof AEADParameters;
        BlockCipher blockCipher = this.f6188a;
        byte[] bArr = this.f6197c;
        if (z2) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] bArr2 = aEADParameters.b;
            Arrays.p(bArr, (byte) 0);
            System.arraycopy(bArr2, 0, bArr, bArr.length - bArr2.length, bArr2.length);
            this.f6192a = aEADParameters.f6227a;
            int i2 = aEADParameters.c;
            if (i2 < 64 || i2 > blockCipher.c() * 8 || i2 % 8 != 0) {
                throw new IllegalArgumentException(lf.h("Invalid value for MAC size: ", i2));
            }
            this.f6187a = i2 / 8;
            byte[] bArr3 = this.f6192a;
            if (bArr3 != null) {
                i(0, bArr3, bArr3.length);
            }
            keyParameter = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr4 = parametersWithIV.f6233a;
            Arrays.p(bArr, (byte) 0);
            System.arraycopy(bArr4, 0, bArr, bArr.length - bArr4.length, bArr4.length);
            this.f6192a = null;
            this.f6187a = blockCipher.c();
            keyParameter = (KeyParameter) parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.f6195b = new byte[blockCipher.c()];
        this.f6189a.e(true, new ParametersWithIV(keyParameter, bArr));
        blockCipher.a(true, keyParameter);
    }

    public final void b(int i2, byte[] bArr, int i3) {
        BlockCipher blockCipher = this.f6188a;
        this.f6195b = new byte[blockCipher.c()];
        while (i3 > 0) {
            for (int i4 = 0; i4 < blockCipher.c(); i4++) {
                byte[] bArr2 = this.f6199e;
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr[i4 + i2]);
            }
            j(blockCipher.c() * 8, this.f6199e, this.f6198d, this.f6200f);
            byte[] y = Arrays.y(this.f6200f);
            this.f6200f = y;
            System.arraycopy(y, 0, this.f6199e, 0, blockCipher.c());
            i3 -= blockCipher.c();
            i2 += blockCipher.c();
        }
        Arrays.p(this.f6200f, (byte) 0);
        int i5 = this.f6193b;
        byte[] bArr3 = this.f6200f;
        bArr3[3] = (byte) (i5 >> 24);
        bArr3[2] = (byte) (i5 >> 16);
        bArr3[1] = (byte) (i5 >> 8);
        bArr3[0] = (byte) i5;
        int i6 = this.f6196c;
        int c2 = blockCipher.c() / 2;
        bArr3[c2 + 3] = (byte) (i6 >> 24);
        bArr3[c2 + 2] = (byte) (i6 >> 16);
        bArr3[c2 + 1] = (byte) (i6 >> 8);
        bArr3[c2] = (byte) i6;
        for (int i7 = 0; i7 < blockCipher.c(); i7++) {
            byte[] bArr4 = this.f6199e;
            bArr4[i7] = (byte) (bArr4[i7] ^ this.f6200f[i7]);
        }
        blockCipher.e(0, 0, this.f6199e, this.f6195b);
    }

    public final int c(int i2, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        int i3;
        int i4 = i2;
        byte[] bArr2 = bArr;
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = this.f6194b;
        int size = exposedByteArrayOutputStream.size();
        ExposedByteArrayOutputStream exposedByteArrayOutputStream2 = this.f6190a;
        if (exposedByteArrayOutputStream2.size() > 0) {
            byte[] a2 = exposedByteArrayOutputStream2.a();
            int size2 = exposedByteArrayOutputStream2.size();
            this.f6193b = size2 * 8;
            byte[] bArr3 = this.f6198d;
            BlockCipher blockCipher = this.f6188a;
            blockCipher.e(0, 0, bArr3, bArr3);
            int i5 = 0;
            while (size2 > 0) {
                for (int i6 = 0; i6 < blockCipher.c(); i6++) {
                    byte[] bArr4 = this.f6199e;
                    bArr4[i6] = (byte) (bArr4[i6] ^ a2[i5 + i6]);
                }
                j(blockCipher.c() * 8, this.f6199e, this.f6198d, this.f6200f);
                byte[] y = Arrays.y(this.f6200f);
                this.f6200f = y;
                System.arraycopy(y, 0, this.f6199e, 0, blockCipher.c());
                size2 -= blockCipher.c();
                i5 += blockCipher.c();
            }
        }
        boolean z = this.f6191a;
        BufferedBlockCipher bufferedBlockCipher = this.f6189a;
        if (!z) {
            this.f6196c = (size - this.f6187a) * 8;
            b(0, exposedByteArrayOutputStream.a(), size - this.f6187a);
            int f2 = bufferedBlockCipher.f(exposedByteArrayOutputStream.a(), 0, size - this.f6187a, bArr, i2);
            i3 = bufferedBlockCipher.a(i4 + f2, bArr2) + f2;
        } else if (bArr2.length - i4 >= this.f6187a + size) {
            this.f6196c = size * 8;
            int f3 = bufferedBlockCipher.f(exposedByteArrayOutputStream.a(), 0, size, bArr, i2);
            i3 = bufferedBlockCipher.a(i4 + f3, bArr2) + f3;
            b(i2, bArr2, size);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
        int i7 = i4 + i3;
        byte[] bArr5 = this.f6195b;
        if (bArr5 == null) {
            throw new IllegalStateException("mac is not calculated");
        } else if (this.f6191a) {
            System.arraycopy(bArr5, 0, bArr2, i7, this.f6187a);
            k();
            return i3 + this.f6187a;
        } else {
            byte[] bArr6 = new byte[this.f6187a];
            System.arraycopy(exposedByteArrayOutputStream.a(), i3, bArr6, 0, this.f6187a);
            int i8 = this.f6187a;
            byte[] bArr7 = new byte[i8];
            System.arraycopy(this.f6195b, 0, bArr7, 0, i8);
            if (Arrays.l(bArr6, bArr7)) {
                k();
                return i3;
            }
            throw new InvalidCipherTextException("mac verification failed");
        }
    }

    public final int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i2 + i3) {
            this.f6194b.write(bArr, i2, i3);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public final int e(int i2) {
        if (this.f6191a) {
            return i2;
        }
        return i2 + this.f6187a;
    }

    public final BlockCipher g() {
        return this.f6188a;
    }

    public final byte[] h() {
        int i2 = this.f6187a;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f6195b, 0, bArr, 0, i2);
        return bArr;
    }

    public final void i(int i2, byte[] bArr, int i3) {
        this.f6190a.write(bArr, i2, i3);
    }

    public final void j(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        BlockCipher blockCipher = this.f6188a;
        byte[] bArr4 = new byte[blockCipher.c()];
        byte[] bArr5 = new byte[blockCipher.c()];
        System.arraycopy(bArr, 0, bArr4, 0, blockCipher.c());
        System.arraycopy(bArr2, 0, bArr5, 0, blockCipher.c());
        byte[] y = Arrays.y(bArr4);
        byte[] y2 = Arrays.y(bArr5);
        BigInteger bigInteger = e;
        BigInteger bigInteger2 = d;
        BigInteger bigInteger3 = c;
        if (i2 != 128) {
            if (i2 == 256) {
                bigInteger3 = f;
                bigInteger2 = g;
                bigInteger = h;
            } else if (i2 == 512) {
                bigInteger3 = i;
                bigInteger2 = j;
                bigInteger = k;
            }
        }
        BigInteger bigInteger4 = new BigInteger(1, y);
        BigInteger bigInteger5 = a;
        BigInteger bigInteger6 = bigInteger5;
        for (BigInteger bigInteger7 = new BigInteger(1, y2); !bigInteger7.equals(bigInteger5); bigInteger7 = bigInteger7.shiftRight(1)) {
            BigInteger bigInteger8 = b;
            if (bigInteger7.and(bigInteger8).equals(bigInteger8)) {
                bigInteger6 = bigInteger6.xor(bigInteger4);
            }
            bigInteger4 = bigInteger4.shiftLeft(1);
            if (!bigInteger4.and(bigInteger3).equals(bigInteger5)) {
                bigInteger4 = bigInteger4.xor(bigInteger);
            }
        }
        byte[] b2 = BigIntegers.b(bigInteger6.and(bigInteger2));
        Arrays.p(bArr3, (byte) 0);
        System.arraycopy(b2, 0, bArr3, 0, b2.length);
    }

    public final void k() {
        BlockCipher blockCipher = this.f6188a;
        this.f6198d = new byte[blockCipher.c()];
        this.f6199e = new byte[blockCipher.c()];
        this.f6200f = new byte[blockCipher.c()];
        this.f6196c = 0;
        this.f6193b = 0;
        blockCipher.reset();
        this.f6194b.reset();
        this.f6190a.reset();
        byte[] bArr = this.f6192a;
        if (bArr != null) {
            i(0, bArr, bArr.length);
        }
    }

    public final int f(int i2) {
        return i2;
    }
}
