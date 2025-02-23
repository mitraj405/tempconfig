package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.util.BigIntegers;

public class ElGamalParametersGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6082a;
    public int b;

    public final ElGamalParameters a() {
        BigInteger modPow;
        BigInteger bigInteger = DHParametersHelper.a(this.a, this.b, this.f6082a)[0];
        SecureRandom secureRandom = this.f6082a;
        BigInteger bigInteger2 = DHParametersHelper.b;
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        do {
            modPow = BigIntegers.c(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
        } while (modPow.equals(DHParametersHelper.a));
        return new ElGamalParameters(0, bigInteger, modPow);
    }
}
