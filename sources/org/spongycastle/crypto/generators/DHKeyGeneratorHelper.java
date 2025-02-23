package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

class DHKeyGeneratorHelper {
    public static final BigInteger a = BigInteger.valueOf(1);

    /* renamed from: a  reason: collision with other field name */
    public static final DHKeyGeneratorHelper f6074a = new DHKeyGeneratorHelper();
    public static final BigInteger b = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    public static BigInteger a(SecureRandom secureRandom, DHParameters dHParameters) {
        BigInteger bigInteger;
        BigInteger c;
        BigInteger bit;
        int i = dHParameters.d;
        if (i != 0) {
            int i2 = i >>> 2;
            do {
                bit = new BigInteger(i, secureRandom).setBit(i - 1);
            } while (WNafUtil.c(bit) < i2);
            return bit;
        }
        BigInteger bigInteger2 = b;
        int i3 = dHParameters.c;
        if (i3 != 0) {
            bigInteger = a.shiftLeft(i3 - 1);
        } else {
            bigInteger = bigInteger2;
        }
        BigInteger bigInteger3 = dHParameters.f6228c;
        if (bigInteger3 == null) {
            bigInteger3 = dHParameters.b;
        }
        BigInteger subtract = bigInteger3.subtract(bigInteger2);
        int bitLength = subtract.bitLength() >>> 2;
        do {
            c = BigIntegers.c(bigInteger, subtract, secureRandom);
        } while (WNafUtil.c(c) < bitLength);
        return c;
    }
}
