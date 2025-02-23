package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final BigInteger g = BigInteger.valueOf(1);
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public RSAKeyGenerationParameters f6087a;

    public final AsymmetricCipherKeyPair a() {
        BigInteger b;
        int i;
        int i2;
        BigInteger multiply;
        BigInteger bigInteger;
        BigInteger b2;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        int i3 = rSAKeyPairGenerator.f6087a.c;
        int i4 = (i3 + 1) / 2;
        int i5 = i3 - i4;
        int i6 = i3 / 2;
        int i7 = i6 - 100;
        int i8 = i3 / 3;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = i3 >> 2;
        BigInteger pow = BigInteger.valueOf(2).pow(i6);
        BigInteger bigInteger2 = g;
        BigInteger shiftLeft = bigInteger2.shiftLeft(i3 - 1);
        BigInteger shiftLeft2 = bigInteger2.shiftLeft(i7);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        boolean z = false;
        while (!z) {
            BigInteger bigInteger3 = rSAKeyPairGenerator.f6087a.a;
            BigInteger b3 = rSAKeyPairGenerator.b(i4, bigInteger3, shiftLeft);
            while (true) {
                b = rSAKeyPairGenerator.b(i5, bigInteger3, shiftLeft);
                BigInteger abs = b.subtract(b3).abs();
                i = i5;
                if (abs.bitLength() < i7 || abs.compareTo(shiftLeft2) <= 0) {
                    rSAKeyPairGenerator = this;
                    i2 = i;
                    i3 = i3;
                } else {
                    multiply = b3.multiply(b);
                    if (multiply.bitLength() == i3) {
                        if (WNafUtil.c(multiply) >= i9) {
                            break;
                        }
                        b2 = rSAKeyPairGenerator.b(i4, bigInteger3, shiftLeft);
                    } else {
                        b2 = b3.max(b);
                    }
                    b3 = b2;
                    i2 = i;
                }
            }
            if (b3.compareTo(b) < 0) {
                bigInteger = b;
                b = b3;
            } else {
                bigInteger = b3;
            }
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            BigInteger subtract2 = b.subtract(bigInteger2);
            int i10 = i3;
            BigInteger modInverse = bigInteger3.modInverse(subtract.divide(subtract.gcd(subtract2)).multiply(subtract2));
            if (modInverse.compareTo(pow) <= 0) {
                rSAKeyPairGenerator = this;
                i5 = i;
                i3 = i10;
            } else {
                BigInteger remainder = modInverse.remainder(subtract);
                BigInteger remainder2 = modInverse.remainder(subtract2);
                BigInteger modInverse2 = b.modInverse(bigInteger);
                RSAKeyParameters rSAKeyParameters = new RSAKeyParameters(multiply, bigInteger3, false);
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = r14;
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters2 = new RSAPrivateCrtKeyParameters(multiply, bigInteger3, modInverse, bigInteger, b, remainder, remainder2, modInverse2);
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair(rSAKeyParameters, rSAPrivateCrtKeyParameters);
                z = true;
                i5 = i;
                i3 = i10;
                rSAKeyPairGenerator = this;
            }
        }
        return asymmetricCipherKeyPair;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0208, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.math.BigInteger b(int r18, java.math.BigInteger r19, java.math.BigInteger r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 0
            r4 = r3
        L_0x0008:
            int r5 = r1 * 5
            if (r4 == r5) goto L_0x0247
            java.math.BigInteger r5 = new java.math.BigInteger
            org.spongycastle.crypto.params.RSAKeyGenerationParameters r6 = r0.f6087a
            java.security.SecureRandom r6 = r6.a
            r7 = 1
            r5.<init>(r1, r7, r6)
            java.math.BigInteger r6 = r5.mod(r2)
            java.math.BigInteger r8 = g
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0026
            r9 = r20
            goto L_0x023d
        L_0x0026:
            java.math.BigInteger r6 = r5.multiply(r5)
            r9 = r20
            int r6 = r6.compareTo(r9)
            if (r6 >= 0) goto L_0x0034
            goto L_0x023d
        L_0x0034:
            org.spongycastle.math.Primes.a(r5)
            r6 = 223092870(0xd4c2086, float:6.29015E-31)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 2
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 3
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 5
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 7
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 11
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 13
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 17
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 19
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 23
            if (r6 != 0) goto L_0x006d
            goto L_0x01a5
        L_0x006d:
            r6 = 58642669(0x37ed0ed, float:7.4883726E-37)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 29
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 31
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 37
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 41
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 43
            if (r6 != 0) goto L_0x0093
            goto L_0x01a5
        L_0x0093:
            r6 = 600662303(0x23cd611f, float:2.2267277E-17)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 47
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 53
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 59
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 61
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 67
            if (r6 != 0) goto L_0x00b9
            goto L_0x01a5
        L_0x00b9:
            r6 = 33984931(0x20691a3, float:9.886561E-38)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 71
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 73
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 79
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 83
            if (r6 != 0) goto L_0x00db
            goto L_0x01a5
        L_0x00db:
            r6 = 89809099(0x55a60cb, float:1.0268089E-35)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 89
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 97
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 101
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 103
            if (r6 != 0) goto L_0x00fd
            goto L_0x01a5
        L_0x00fd:
            r6 = 167375713(0x9f9f361, float:6.0173442E-33)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 107
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 109
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 113
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 127
            if (r6 != 0) goto L_0x011f
            goto L_0x01a5
        L_0x011f:
            r6 = 371700317(0x1627b25d, float:1.3546434E-25)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 131
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 137
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 139
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 149
            if (r6 != 0) goto L_0x0140
            goto L_0x01a5
        L_0x0140:
            r6 = 645328247(0x2676ed77, float:8.567022E-16)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 151
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 157
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 163
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 167
            if (r6 != 0) goto L_0x0161
            goto L_0x01a5
        L_0x0161:
            r6 = 1070560157(0x3fcf739d, float:1.6207157)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 173
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 179
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 181
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 191
            if (r6 != 0) goto L_0x0182
            goto L_0x01a5
        L_0x0182:
            r6 = 1596463769(0x5f281a99, float:1.2113162E19)
            long r10 = (long) r6
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)
            java.math.BigInteger r6 = r5.mod(r6)
            int r6 = r6.intValue()
            int r10 = r6 % 193
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 197
            if (r10 == 0) goto L_0x01a5
            int r10 = r6 % 199
            if (r10 == 0) goto L_0x01a5
            int r6 = r6 % 211
            if (r6 != 0) goto L_0x01a3
            goto L_0x01a5
        L_0x01a3:
            r6 = r3
            goto L_0x01a6
        L_0x01a5:
            r6 = r7
        L_0x01a6:
            if (r6 != 0) goto L_0x022b
            org.spongycastle.crypto.params.RSAKeyGenerationParameters r6 = r0.f6087a
            java.security.SecureRandom r6 = r6.a
            int r10 = r0.a
            org.spongycastle.math.Primes.a(r5)
            if (r6 == 0) goto L_0x0223
            if (r10 < r7) goto L_0x021b
            int r11 = r5.bitLength()
            r12 = 2
            if (r11 != r12) goto L_0x01bd
            goto L_0x0216
        L_0x01bd:
            boolean r11 = r5.testBit(r3)
            if (r11 != 0) goto L_0x01c4
            goto L_0x020d
        L_0x01c4:
            java.math.BigInteger r11 = org.spongycastle.math.Primes.a
            java.math.BigInteger r12 = r5.subtract(r11)
            java.math.BigInteger r13 = org.spongycastle.math.Primes.b
            java.math.BigInteger r14 = r5.subtract(r13)
            int r15 = r12.getLowestSetBit()
            java.math.BigInteger r3 = r12.shiftRight(r15)
            r7 = 0
        L_0x01d9:
            if (r7 >= r10) goto L_0x0216
            java.math.BigInteger r0 = org.spongycastle.util.BigIntegers.c(r13, r14, r6)
            java.math.BigInteger r0 = r0.modPow(r3, r5)
            boolean r16 = r0.equals(r11)
            if (r16 != 0) goto L_0x020a
            boolean r16 = r0.equals(r12)
            if (r16 == 0) goto L_0x01f0
            goto L_0x020a
        L_0x01f0:
            r1 = 1
        L_0x01f1:
            if (r1 >= r15) goto L_0x0208
            java.math.BigInteger r0 = r0.modPow(r13, r5)
            boolean r16 = r0.equals(r12)
            if (r16 == 0) goto L_0x01fe
            goto L_0x020a
        L_0x01fe:
            boolean r16 = r0.equals(r11)
            if (r16 == 0) goto L_0x0205
            goto L_0x0208
        L_0x0205:
            int r1 = r1 + 1
            goto L_0x01f1
        L_0x0208:
            r0 = 0
            goto L_0x020b
        L_0x020a:
            r0 = 1
        L_0x020b:
            if (r0 != 0) goto L_0x020f
        L_0x020d:
            r0 = 0
            goto L_0x0217
        L_0x020f:
            int r7 = r7 + 1
            r0 = r17
            r1 = r18
            goto L_0x01d9
        L_0x0216:
            r0 = 1
        L_0x0217:
            if (r0 == 0) goto L_0x022b
            r7 = 1
            goto L_0x022c
        L_0x021b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'iterations' must be > 0"
            r0.<init>(r1)
            throw r0
        L_0x0223:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'random' cannot be null"
            r0.<init>(r1)
            throw r0
        L_0x022b:
            r7 = 0
        L_0x022c:
            if (r7 != 0) goto L_0x022f
            goto L_0x023d
        L_0x022f:
            java.math.BigInteger r0 = r5.subtract(r8)
            java.math.BigInteger r0 = r2.gcd(r0)
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0246
        L_0x023d:
            int r4 = r4 + 1
            r0 = r17
            r1 = r18
            r3 = 0
            goto L_0x0008
        L_0x0246:
            return r5
        L_0x0247:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unable to generate prime number for RSA key"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.RSAKeyPairGenerator.b(int, java.math.BigInteger, java.math.BigInteger):java.math.BigInteger");
    }

    public final void c(KeyGenerationParameters keyGenerationParameters) {
        int i;
        int i2;
        RSAKeyGenerationParameters rSAKeyGenerationParameters = (RSAKeyGenerationParameters) keyGenerationParameters;
        this.f6087a = rSAKeyGenerationParameters;
        int i3 = rSAKeyGenerationParameters.c;
        int i4 = rSAKeyGenerationParameters.d;
        int i5 = 4;
        if (i3 < 1536) {
            if (i3 < 1024) {
                if (i3 < 512) {
                    i2 = 40;
                    if (i4 > 80) {
                        i = ((i4 - 80) + 1) / 2;
                        i5 = i + i2;
                    }
                } else if (i4 > 80) {
                    i2 = 7;
                    if (i4 > 100) {
                        i = ((i4 - 100) + 1) / 2;
                        i5 = i + i2;
                    }
                }
                i5 = i2;
            } else if (i4 > 100) {
                if (i4 > 112) {
                    i5 = (((i4 - 112) + 1) / 2) + 5;
                }
            }
            i5 = 5;
        } else if (i4 <= 100) {
            i5 = 3;
        } else if (i4 > 128) {
            i5 = 4 + (((i4 - 128) + 1) / 2);
        }
        this.a = i5;
    }
}
