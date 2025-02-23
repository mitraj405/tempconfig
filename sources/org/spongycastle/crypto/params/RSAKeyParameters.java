package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class RSAKeyParameters extends AsymmetricKeyParameter {
    public static final BigInteger c = BigInteger.valueOf(1);
    public final BigInteger a;
    public final BigInteger b;

    public RSAKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        super(z);
        if (!z && (bigInteger2.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA publicExponent is even");
        } else if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        } else if (bigInteger.gcd(new BigInteger("1451887755777639901511587432083070202422614380984889313550570919659315177065956574359078912654149167643992684236991305777574330831666511589145701059710742276692757882915756220901998212975756543223550490431013061082131040808010565293748926901442915057819663730454818359472391642885328171302299245556663073719855")).equals(c)) {
            this.a = bigInteger;
            this.b = bigInteger2;
        } else {
            throw new IllegalArgumentException("RSA modulus has a small prime factor");
        }
    }
}
