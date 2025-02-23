package org.spongycastle.jcajce.provider.asymmetric.gost;

import com.google.android.gms.ads.AdRequest;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.generators.GOST3410ParametersGenerator;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public abstract class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    public int a = UserMetadata.MAX_ATTRIBUTE_SIZE;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6445a;

    public final AlgorithmParameters engineGenerateParameters() {
        GOST3410Parameters gOST3410Parameters;
        BigInteger[] bigIntegerArr;
        BigInteger add;
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger add2;
        String str;
        GOST3410ParametersGenerator gOST3410ParametersGenerator = new GOST3410ParametersGenerator();
        SecureRandom secureRandom = this.f6445a;
        if (secureRandom != null) {
            gOST3410ParametersGenerator.f6084a = this.a;
            gOST3410ParametersGenerator.f6086b = 2;
            gOST3410ParametersGenerator.f6085a = secureRandom;
        } else {
            int i = this.a;
            SecureRandom secureRandom2 = new SecureRandom();
            gOST3410ParametersGenerator.f6084a = i;
            gOST3410ParametersGenerator.f6086b = 2;
            gOST3410ParametersGenerator.f6085a = secureRandom2;
        }
        BigInteger[] bigIntegerArr3 = new BigInteger[2];
        int i2 = gOST3410ParametersGenerator.f6086b;
        BigInteger bigInteger3 = GOST3410ParametersGenerator.a;
        BigInteger bigInteger4 = GOST3410ParametersGenerator.b;
        int i3 = 0;
        String str2 = "0";
        if (i2 == 1) {
            int nextInt = gOST3410ParametersGenerator.f6085a.nextInt();
            int nextInt2 = gOST3410ParametersGenerator.f6085a.nextInt();
            int i4 = gOST3410ParametersGenerator.f6084a;
            if (i4 == 512) {
                gOST3410ParametersGenerator.a(nextInt, nextInt2, bigIntegerArr3, AdRequest.MAX_CONTENT_URL_LENGTH);
            } else if (i4 == 1024) {
                while (true) {
                    if (nextInt >= 0 && nextInt <= 65536) {
                        break;
                    }
                    nextInt = gOST3410ParametersGenerator.f6085a.nextInt() / 32768;
                    str2 = str2;
                    i3 = 0;
                }
                while (true) {
                    if (nextInt2 >= 0 && nextInt2 <= 65536 && nextInt2 / 2 != 0) {
                        break;
                    }
                    nextInt2 = (gOST3410ParametersGenerator.f6085a.nextInt() / 32768) + 1;
                    str2 = str2;
                    i3 = 0;
                }
                BigInteger[] bigIntegerArr4 = new BigInteger[2];
                BigInteger bigInteger5 = new BigInteger(Integer.toString(nextInt2));
                BigInteger bigInteger6 = new BigInteger("19381");
                int a2 = gOST3410ParametersGenerator.a(nextInt, nextInt2, bigIntegerArr4, 256);
                BigInteger bigInteger7 = bigIntegerArr4[i3];
                int a3 = gOST3410ParametersGenerator.a(a2, nextInt2, bigIntegerArr4, AdRequest.MAX_CONTENT_URL_LENGTH);
                BigInteger bigInteger8 = bigIntegerArr4[i3];
                BigInteger[] bigIntegerArr5 = new BigInteger[65];
                bigIntegerArr5[i3] = new BigInteger(Integer.toString(a3));
                loop2:
                while (true) {
                    int i5 = i3;
                    while (i5 < 64) {
                        int i6 = i5 + 1;
                        bigIntegerArr5[i6] = bigIntegerArr5[i5].multiply(bigInteger6).add(bigInteger5).mod(bigInteger4.pow(16));
                        i5 = i6;
                    }
                    BigInteger bigInteger9 = new BigInteger(str2);
                    for (int i7 = i3; i7 < 64; i7++) {
                        bigInteger9 = bigInteger9.add(bigIntegerArr5[i7].multiply(bigInteger4.pow(i7 * 16)));
                    }
                    bigIntegerArr5[0] = bigIntegerArr5[64];
                    BigInteger add3 = bigInteger4.pow(1023).divide(bigInteger7.multiply(bigInteger8)).add(bigInteger4.pow(1023).multiply(bigInteger9).divide(bigInteger7.multiply(bigInteger8).multiply(bigInteger4.pow(UserMetadata.MAX_ATTRIBUTE_SIZE))));
                    if (add3.mod(bigInteger4).compareTo(bigInteger3) == 0) {
                        add3 = add3.add(bigInteger3);
                    }
                    BigInteger bigInteger10 = add3;
                    int i8 = 0;
                    while (true) {
                        bigIntegerArr2 = bigIntegerArr5;
                        bigInteger = bigInteger5;
                        long j = (long) i8;
                        bigInteger2 = bigInteger6;
                        add2 = bigInteger7.multiply(bigInteger8).multiply(bigInteger10.add(BigInteger.valueOf(j))).add(bigInteger3);
                        str = str2;
                        if (add2.compareTo(bigInteger4.pow(UserMetadata.MAX_ATTRIBUTE_SIZE)) != 1) {
                            if (bigInteger4.modPow(bigInteger7.multiply(bigInteger8).multiply(bigInteger10.add(BigInteger.valueOf(j))), add2).compareTo(bigInteger3) == 0 && bigInteger4.modPow(bigInteger7.multiply(bigInteger10.add(BigInteger.valueOf(j))), add2).compareTo(bigInteger3) != 0) {
                                break loop2;
                            }
                            i8 += 2;
                            bigInteger5 = bigInteger;
                            bigIntegerArr5 = bigIntegerArr2;
                            bigInteger6 = bigInteger2;
                            str2 = str;
                        } else {
                            break;
                        }
                    }
                    bigInteger5 = bigInteger;
                    bigIntegerArr5 = bigIntegerArr2;
                    bigInteger6 = bigInteger2;
                    str2 = str;
                    i3 = 0;
                }
                bigIntegerArr3[0] = add2;
                bigIntegerArr3[1] = bigInteger7;
            } else {
                throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger11 = bigIntegerArr3[0];
            BigInteger bigInteger12 = bigIntegerArr3[1];
            gOST3410Parameters = new GOST3410Parameters(bigInteger11, bigInteger12, gOST3410ParametersGenerator.c(bigInteger11, bigInteger12), 0);
        } else {
            String str3 = str2;
            long nextLong = gOST3410ParametersGenerator.f6085a.nextLong();
            long nextLong2 = gOST3410ParametersGenerator.f6085a.nextLong();
            int i9 = gOST3410ParametersGenerator.f6084a;
            if (i9 == 512) {
                bigIntegerArr = bigIntegerArr3;
                gOST3410ParametersGenerator.b(nextLong, nextLong2, bigIntegerArr, AdRequest.MAX_CONTENT_URL_LENGTH);
            } else if (i9 == 1024) {
                while (true) {
                    if (nextLong >= 0 && nextLong <= 4294967296L) {
                        break;
                    }
                    String str4 = str3;
                    BigInteger[] bigIntegerArr6 = bigIntegerArr3;
                    String str5 = str4;
                    nextLong = (long) (gOST3410ParametersGenerator.f6085a.nextInt() * 2);
                    BigInteger[] bigIntegerArr7 = bigIntegerArr6;
                    str3 = str5;
                    bigIntegerArr3 = bigIntegerArr7;
                }
                while (true) {
                    if (nextLong2 >= 0 && nextLong2 <= 4294967296L && nextLong2 / 2 != 0) {
                        break;
                    }
                    String str6 = str3;
                    BigInteger[] bigIntegerArr8 = bigIntegerArr3;
                    String str7 = str6;
                    nextLong2 = (long) ((gOST3410ParametersGenerator.f6085a.nextInt() * 2) + 1);
                    BigInteger[] bigIntegerArr9 = bigIntegerArr8;
                    str3 = str7;
                    bigIntegerArr3 = bigIntegerArr9;
                }
                BigInteger[] bigIntegerArr10 = new BigInteger[2];
                BigInteger bigInteger13 = new BigInteger(Long.toString(nextLong2));
                GOST3410ParametersGenerator gOST3410ParametersGenerator2 = gOST3410ParametersGenerator;
                long j2 = nextLong2;
                BigInteger[] bigIntegerArr11 = bigIntegerArr10;
                BigInteger bigInteger14 = new BigInteger("97781173");
                String str8 = str3;
                bigIntegerArr = bigIntegerArr3;
                String str9 = str8;
                long b = gOST3410ParametersGenerator2.b(nextLong, j2, bigIntegerArr11, 256);
                BigInteger bigInteger15 = bigIntegerArr10[0];
                long b2 = gOST3410ParametersGenerator2.b(b, j2, bigIntegerArr11, AdRequest.MAX_CONTENT_URL_LENGTH);
                BigInteger bigInteger16 = bigIntegerArr10[0];
                BigInteger[] bigIntegerArr12 = new BigInteger[33];
                bigIntegerArr12[0] = new BigInteger(Long.toString(b2));
                loop8:
                while (true) {
                    int i10 = 0;
                    while (i10 < 32) {
                        int i11 = i10 + 1;
                        bigIntegerArr12[i11] = bigIntegerArr12[i10].multiply(bigInteger14).add(bigInteger13).mod(bigInteger4.pow(32));
                        i10 = i11;
                    }
                    BigInteger bigInteger17 = new BigInteger(str9);
                    for (int i12 = 0; i12 < 32; i12++) {
                        bigInteger17 = bigInteger17.add(bigIntegerArr12[i12].multiply(bigInteger4.pow(i12 * 32)));
                    }
                    bigIntegerArr12[0] = bigIntegerArr12[32];
                    BigInteger add4 = bigInteger4.pow(1023).divide(bigInteger15.multiply(bigInteger16)).add(bigInteger4.pow(1023).multiply(bigInteger17).divide(bigInteger15.multiply(bigInteger16).multiply(bigInteger4.pow(UserMetadata.MAX_ATTRIBUTE_SIZE))));
                    if (add4.mod(bigInteger4).compareTo(bigInteger3) == 0) {
                        add4 = add4.add(bigInteger3);
                    }
                    int i13 = 0;
                    while (true) {
                        long j3 = (long) i13;
                        add = bigInteger15.multiply(bigInteger16).multiply(add4.add(BigInteger.valueOf(j3))).add(bigInteger3);
                        if (add.compareTo(bigInteger4.pow(UserMetadata.MAX_ATTRIBUTE_SIZE)) != 1) {
                            if (bigInteger4.modPow(bigInteger15.multiply(bigInteger16).multiply(add4.add(BigInteger.valueOf(j3))), add).compareTo(bigInteger3) == 0 && bigInteger4.modPow(bigInteger15.multiply(add4.add(BigInteger.valueOf(j3))), add).compareTo(bigInteger3) != 0) {
                                break loop8;
                            }
                            i13 += 2;
                        }
                    }
                }
                bigIntegerArr[0] = add;
                bigIntegerArr[1] = bigInteger15;
            } else {
                throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger18 = bigIntegerArr[0];
            BigInteger bigInteger19 = bigIntegerArr[1];
            gOST3410Parameters = new GOST3410Parameters(bigInteger18, bigInteger19, gOST3410ParametersGenerator.c(bigInteger18, bigInteger19), 0);
        }
        try {
            AlgorithmParameters b3 = this.a.b("GOST3410");
            b3.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410Parameters.a, gOST3410Parameters.b, gOST3410Parameters.c)));
            return b3;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final void engineInit(int i, SecureRandom secureRandom) {
        this.a = i;
        this.f6445a = secureRandom;
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}
