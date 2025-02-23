package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;

public class GOST3410ParametersGenerator {
    public static final BigInteger a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);

    /* renamed from: a  reason: collision with other field name */
    public int f6084a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6085a;

    /* renamed from: b  reason: collision with other field name */
    public int f6086b;

    public final int a(int i, int i2, BigInteger[] bigIntegerArr, int i3) {
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int i4;
        int i5 = i;
        while (true) {
            if (i5 >= 0 && i5 <= 65536) {
                break;
            }
            i5 = this.f6085a.nextInt() / 32768;
        }
        int i6 = i2;
        while (true) {
            if (i6 >= 0 && i6 <= 65536 && i6 / 2 != 0) {
                break;
            }
            i6 = (this.f6085a.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger4 = new BigInteger(Integer.toString(i6));
        BigInteger bigInteger5 = new BigInteger("19381");
        BigInteger bigInteger6 = new BigInteger(Integer.toString(i5));
        int i7 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i3};
        int i8 = 0;
        while (iArr[i8] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            int i9 = i8 + 1;
            iArr[i9] = iArr[i8] / 2;
            i8 = i9;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i8 + 1)];
        int i10 = 16;
        bigIntegerArr4[i8] = new BigInteger("8003", 16);
        int i11 = i8 - 1;
        int i12 = 0;
        while (i12 < i8) {
            int i13 = iArr[i11] / i10;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i7, bigIntegerArr5, i7, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i13 + 1)];
                System.arraycopy(bigIntegerArr5, i7, bigIntegerArr2, i7, length2);
                int i14 = i7;
                while (true) {
                    bigInteger = b;
                    if (i14 >= i13) {
                        break;
                    }
                    int i15 = i14 + 1;
                    bigIntegerArr2[i15] = bigIntegerArr2[i14].multiply(bigInteger5).add(bigInteger4).mod(bigInteger.pow(i10));
                    i14 = i15;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i16 = i7; i16 < i13; i16++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i16].multiply(bigInteger.pow(i16 * 16)));
                }
                bigIntegerArr2[i7] = bigIntegerArr2[i13];
                int i17 = i11 + 1;
                BigInteger add = bigInteger.pow(iArr[i11] - 1).divide(bigIntegerArr4[i17]).add(bigInteger.pow(iArr[i11] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i17].multiply(bigInteger.pow(i13 * 16))));
                BigInteger mod = add.mod(bigInteger);
                BigInteger bigInteger8 = a;
                if (mod.compareTo(bigInteger8) == 0) {
                    add = add.add(bigInteger8);
                }
                int i18 = 0;
                while (true) {
                    bigInteger2 = bigInteger4;
                    bigInteger3 = bigInteger5;
                    long j = (long) i18;
                    i4 = i8;
                    BigInteger add2 = bigIntegerArr4[i17].multiply(add.add(BigInteger.valueOf(j))).add(bigInteger8);
                    bigIntegerArr4[i11] = add2;
                    if (add2.compareTo(bigInteger.pow(iArr[i11])) != 1) {
                        if (bigInteger.modPow(bigIntegerArr4[i17].multiply(add.add(BigInteger.valueOf(j))), bigIntegerArr4[i11]).compareTo(bigInteger8) == 0 && bigInteger.modPow(add.add(BigInteger.valueOf(j)), bigIntegerArr4[i11]).compareTo(bigInteger8) != 0) {
                            break;
                        }
                        i18 += 2;
                        i8 = i4;
                        bigInteger4 = bigInteger2;
                        bigInteger5 = bigInteger3;
                    } else {
                        break;
                    }
                }
                i8 = i4;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger4 = bigInteger2;
                bigInteger5 = bigInteger3;
                i7 = 0;
                i10 = 16;
            }
            i11--;
            if (i11 >= 0) {
                i12++;
                i8 = i4;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger4 = bigInteger2;
                bigInteger5 = bigInteger3;
                i7 = 0;
                i10 = 16;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].intValue();
            }
        }
        return bigIntegerArr3[i7].intValue();
    }

    public final long b(long j, long j2, BigInteger[] bigIntegerArr, int i) {
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int i2;
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.f6085a.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.f6085a.nextInt() * 2) + 1);
        }
        BigInteger bigInteger4 = new BigInteger(Long.toString(j4));
        BigInteger bigInteger5 = new BigInteger("97781173");
        BigInteger bigInteger6 = new BigInteger(Long.toString(j3));
        int i3 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i};
        int i4 = 0;
        while (iArr[i4] >= 33) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            int i5 = i4 + 1;
            iArr[i5] = iArr[i4] / 2;
            i4 = i5;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i4 + 1)];
        bigIntegerArr4[i4] = new BigInteger("8000000B", 16);
        int i6 = i4 - 1;
        int i7 = 0;
        while (i7 < i4) {
            int i8 = 32;
            int i9 = iArr[i6] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i3, bigIntegerArr5, i3, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i9 + 1)];
                System.arraycopy(bigIntegerArr5, i3, bigIntegerArr2, i3, length2);
                int i10 = i3;
                while (true) {
                    bigInteger = b;
                    if (i10 >= i9) {
                        break;
                    }
                    int i11 = i10 + 1;
                    bigIntegerArr2[i11] = bigIntegerArr2[i10].multiply(bigInteger5).add(bigInteger4).mod(bigInteger.pow(i8));
                    i10 = i11;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i12 = i3; i12 < i9; i12++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i12].multiply(bigInteger.pow(i12 * 32)));
                }
                bigIntegerArr2[i3] = bigIntegerArr2[i9];
                int i13 = i6 + 1;
                BigInteger add = bigInteger.pow(iArr[i6] - 1).divide(bigIntegerArr4[i13]).add(bigInteger.pow(iArr[i6] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i13].multiply(bigInteger.pow(i9 * 32))));
                BigInteger mod = add.mod(bigInteger);
                BigInteger bigInteger8 = a;
                if (mod.compareTo(bigInteger8) == 0) {
                    add = add.add(bigInteger8);
                }
                int i14 = 0;
                while (true) {
                    bigInteger2 = bigInteger4;
                    bigInteger3 = bigInteger5;
                    long j5 = (long) i14;
                    i2 = i4;
                    BigInteger add2 = bigIntegerArr4[i13].multiply(add.add(BigInteger.valueOf(j5))).add(bigInteger8);
                    bigIntegerArr4[i6] = add2;
                    if (add2.compareTo(bigInteger.pow(iArr[i6])) != 1) {
                        if (bigInteger.modPow(bigIntegerArr4[i13].multiply(add.add(BigInteger.valueOf(j5))), bigIntegerArr4[i6]).compareTo(bigInteger8) == 0 && bigInteger.modPow(add.add(BigInteger.valueOf(j5)), bigIntegerArr4[i6]).compareTo(bigInteger8) != 0) {
                            break;
                        }
                        i14 += 2;
                        bigInteger4 = bigInteger2;
                        i4 = i2;
                        bigInteger5 = bigInteger3;
                    } else {
                        break;
                    }
                }
                bigInteger4 = bigInteger2;
                i4 = i2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger5 = bigInteger3;
                i3 = 0;
                i8 = 32;
            }
            i6--;
            if (i6 >= 0) {
                i7++;
                bigInteger4 = bigInteger2;
                i4 = i2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger5 = bigInteger3;
                i3 = 0;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].longValue();
            }
        }
        return bigIntegerArr3[i3].longValue();
    }

    public final BigInteger c(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = a;
        BigInteger subtract = bigInteger.subtract(bigInteger3);
        BigInteger divide = subtract.divide(bigInteger2);
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigInteger4 = new BigInteger(bitLength, this.f6085a);
            if (bigInteger4.compareTo(bigInteger3) > 0 && bigInteger4.compareTo(subtract) < 0) {
                BigInteger modPow = bigInteger4.modPow(divide, bigInteger);
                if (modPow.compareTo(bigInteger3) != 0) {
                    return modPow;
                }
            }
        }
    }
}
