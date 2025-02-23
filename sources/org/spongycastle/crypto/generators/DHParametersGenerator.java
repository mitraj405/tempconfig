package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.BigIntegers;

public class DHParametersGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6075a;
    public int b;

    static {
        BigInteger.valueOf(2);
    }

    public final DHParameters a() {
        BigInteger modPow;
        BigInteger[] a2 = DHParametersHelper.a(this.a, this.b, this.f6075a);
        BigInteger bigInteger = a2[0];
        BigInteger bigInteger2 = a2[1];
        SecureRandom secureRandom = this.f6075a;
        BigInteger bigInteger3 = DHParametersHelper.b;
        BigInteger subtract = bigInteger.subtract(bigInteger3);
        do {
            modPow = BigIntegers.c(bigInteger3, subtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (modPow.equals(DHParametersHelper.a));
        return new DHParameters(bigInteger, modPow, bigInteger2);
    }
}
