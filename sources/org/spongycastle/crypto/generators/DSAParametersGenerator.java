package org.spongycastle.crypto.generators;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GeneralDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;

public class DSAParametersGenerator {
    public static final BigInteger a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);

    /* renamed from: a  reason: collision with other field name */
    public int f6076a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6077a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6078a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6079a;

    /* renamed from: b  reason: collision with other field name */
    public int f6080b;
    public int c;
    public int d;

    static {
        BigInteger.valueOf(0);
    }

    public DSAParametersGenerator() {
        this(new SHA1Digest());
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(a).divide(bigInteger2);
        BigInteger bigInteger3 = b;
        BigInteger subtract = bigInteger.subtract(bigInteger3);
        do {
            modPow = BigIntegers.c(bigInteger3, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    public static void c(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b2 = (byte) ((bArr[length] + 1) & Constants.MAX_HOST_LENGTH);
            bArr[length] = b2;
            if (b2 == 0) {
                length--;
            } else {
                return;
            }
        }
    }

    public final DSAParameters b() {
        BigInteger bigInteger;
        BigInteger subtract;
        DSAParameters dSAParameters;
        BigInteger bit;
        BigInteger subtract2;
        BigInteger bigInteger2;
        boolean z = this.f6079a;
        int i = 1;
        BigInteger bigInteger3 = a;
        Digest digest = this.f6078a;
        if (z) {
            int f = digest.f() * 8;
            int i2 = this.f6080b / 8;
            byte[] bArr = new byte[i2];
            int i3 = this.f6076a;
            int i4 = i3 - 1;
            int i5 = i4 / f;
            int i6 = i4 % f;
            int i7 = i3 / 8;
            byte[] bArr2 = new byte[i7];
            int f2 = digest.f();
            byte[] bArr3 = new byte[f2];
            loop0:
            while (true) {
                this.f6077a.nextBytes(bArr);
                digest.update(bArr, 0, i2);
                digest.c(0, bArr3);
                bit = new BigInteger(i, bArr3).mod(bigInteger3.shiftLeft(this.f6080b - i)).setBit(0).setBit(this.f6080b - i);
                if (bit.isProbablePrime(this.c)) {
                    byte[] c2 = Arrays.c(bArr);
                    int i8 = this.f6076a * 4;
                    int i9 = 0;
                    while (i9 < i8) {
                        while (i <= i5) {
                            c(c2);
                            digest.update(c2, 0, c2.length);
                            digest.c(i7 - (i * f2), bArr2);
                            i++;
                            i9 = i9;
                            i8 = i8;
                        }
                        int i10 = i8;
                        int i11 = i9;
                        int i12 = i7 - (i5 * f2);
                        c(c2);
                        digest.update(c2, 0, c2.length);
                        digest.c(0, bArr3);
                        System.arraycopy(bArr3, f2 - i12, bArr2, 0, i12);
                        bArr2[0] = (byte) (bArr2[0] | UnsignedBytes.MAX_POWER_OF_TWO);
                        BigInteger bigInteger4 = new BigInteger(1, bArr2);
                        subtract2 = bigInteger4.subtract(bigInteger4.mod(bit.shiftLeft(1)).subtract(bigInteger3));
                        if (subtract2.bitLength() == this.f6076a && subtract2.isProbablePrime(this.c)) {
                            break loop0;
                        }
                        i9 = i11 + 1;
                        i = 1;
                        i8 = i10;
                    }
                    continue;
                }
            }
            int i13 = this.d;
            if (i13 >= 0) {
                BigInteger divide = subtract2.subtract(bigInteger3).divide(bit);
                byte[] a2 = Hex.a("6767656E");
                int q = C1058d.q(a2.length, i2, 1, 2);
                byte[] bArr4 = new byte[q];
                System.arraycopy(bArr, 0, bArr4, 0, i2);
                System.arraycopy(a2, 0, bArr4, i2, a2.length);
                bArr4[q - 3] = (byte) i13;
                byte[] bArr5 = new byte[digest.f()];
                int i14 = 1;
                while (true) {
                    if (i14 >= 65536) {
                        bigInteger2 = null;
                        break;
                    }
                    c(bArr4);
                    digest.update(bArr4, 0, q);
                    digest.c(0, bArr5);
                    bigInteger2 = new BigInteger(1, bArr5).modPow(divide, subtract2);
                    if (bigInteger2.compareTo(b) >= 0) {
                        break;
                    }
                    i14++;
                }
                if (bigInteger2 != null) {
                    return new DSAParameters(subtract2, bit, bigInteger2, 0);
                }
            }
            dSAParameters = new DSAParameters(subtract2, bit, a(subtract2, bit, this.f6077a), 0);
        } else {
            int i15 = 20;
            byte[] bArr6 = new byte[20];
            byte[] bArr7 = new byte[20];
            byte[] bArr8 = new byte[20];
            byte[] bArr9 = new byte[20];
            int i16 = this.f6076a;
            int i17 = (i16 - 1) / 160;
            int i18 = i16 / 8;
            byte[] bArr10 = new byte[i18];
            if (digest instanceof SHA1Digest) {
                loop4:
                while (true) {
                    this.f6077a.nextBytes(bArr6);
                    digest.update(bArr6, 0, i15);
                    digest.c(0, bArr7);
                    System.arraycopy(bArr6, 0, bArr8, 0, i15);
                    c(bArr8);
                    digest.update(bArr8, 0, i15);
                    digest.c(0, bArr8);
                    for (int i19 = 0; i19 != i15; i19++) {
                        bArr9[i19] = (byte) (bArr7[i19] ^ bArr8[i19]);
                    }
                    bArr9[0] = (byte) (bArr9[0] | UnsignedBytes.MAX_POWER_OF_TWO);
                    bArr9[19] = (byte) (bArr9[19] | 1);
                    bigInteger = new BigInteger(1, bArr9);
                    if (bigInteger.isProbablePrime(this.c)) {
                        byte[] c3 = Arrays.c(bArr6);
                        c(c3);
                        int i20 = 0;
                        while (i20 < 4096) {
                            int i21 = 1;
                            while (i21 <= i17) {
                                c(c3);
                                digest.update(c3, 0, c3.length);
                                digest.c(i18 - (i21 * 20), bArr10);
                                i21++;
                                bArr6 = bArr6;
                            }
                            byte[] bArr11 = bArr6;
                            int i22 = i18 - (i17 * 20);
                            c(c3);
                            digest.update(c3, 0, c3.length);
                            digest.c(0, bArr7);
                            System.arraycopy(bArr7, 20 - i22, bArr10, 0, i22);
                            bArr10[0] = (byte) (bArr10[0] | UnsignedBytes.MAX_POWER_OF_TWO);
                            BigInteger bigInteger5 = new BigInteger(1, bArr10);
                            subtract = bigInteger5.subtract(bigInteger5.mod(bigInteger.shiftLeft(1)).subtract(bigInteger3));
                            if (subtract.bitLength() == this.f6076a && subtract.isProbablePrime(this.c)) {
                                break loop4;
                            }
                            i20++;
                            i15 = 20;
                            bArr6 = bArr11;
                        }
                        continue;
                    }
                }
                dSAParameters = new DSAParameters(subtract, bigInteger, a(subtract, bigInteger, this.f6077a), 0);
            } else {
                throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
            }
        }
        return dSAParameters;
    }

    public final void d(int i, int i2, SecureRandom secureRandom) {
        int i3;
        int i4;
        this.f6076a = i;
        if (i > 1024) {
            i3 = 256;
        } else {
            i3 = 160;
        }
        this.f6080b = i3;
        this.c = i2;
        if (i <= 1024) {
            i4 = 40;
        } else {
            i4 = (((i - 1) / UserMetadata.MAX_ATTRIBUTE_SIZE) * 8) + 48;
        }
        Math.max(i4, (i2 + 1) / 2);
        this.f6077a = secureRandom;
        this.f6079a = false;
        this.d = -1;
    }

    public final void e(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int i;
        int i2 = dSAParameterGenerationParameters.a;
        if (i2 < 1024 || i2 > 3072 || i2 % UserMetadata.MAX_ATTRIBUTE_SIZE != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        int i3 = dSAParameterGenerationParameters.b;
        if (i2 == 1024 && i3 != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        } else if (i2 == 2048 && i3 != 224 && i3 != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        } else if (i2 == 3072 && i3 != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        } else if (this.f6078a.f() * 8 >= i3) {
            this.f6076a = i2;
            this.f6080b = i3;
            int i4 = dSAParameterGenerationParameters.d;
            this.c = i4;
            if (i2 <= 1024) {
                i = 40;
            } else {
                i = (((i2 - 1) / UserMetadata.MAX_ATTRIBUTE_SIZE) * 8) + 48;
            }
            Math.max(i, (i4 + 1) / 2);
            this.f6077a = dSAParameterGenerationParameters.f6229a;
            this.f6079a = true;
            this.d = dSAParameterGenerationParameters.c;
        } else {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }

    public DSAParametersGenerator(GeneralDigest generalDigest) {
        this.f6078a = generalDigest;
    }
}
