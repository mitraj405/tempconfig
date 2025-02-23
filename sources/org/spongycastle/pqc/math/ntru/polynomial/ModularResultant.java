package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;

public class ModularResultant extends Resultant {
    public final BigInteger a;

    public ModularResultant(BigIntPolynomial bigIntPolynomial, BigInteger bigInteger, BigInteger bigInteger2) {
        super(bigIntPolynomial, bigInteger);
        this.a = bigInteger2;
    }

    public static ModularResultant a(ModularResultant modularResultant, ModularResultant modularResultant2) {
        BigInteger bigInteger = modularResultant.a;
        BigInteger bigInteger2 = modularResultant2.a;
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        BigIntEuclidean a2 = BigIntEuclidean.a(bigInteger2, bigInteger);
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) modularResultant.a.clone();
        BigInteger multiply2 = a2.a.multiply(bigInteger2);
        int i = 0;
        int i2 = 0;
        while (true) {
            BigInteger[] bigIntegerArr = bigIntPolynomial.a;
            if (i2 >= bigIntegerArr.length) {
                break;
            }
            bigIntegerArr[i2] = bigIntegerArr[i2].multiply(multiply2);
            i2++;
        }
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) modularResultant2.a.clone();
        BigInteger multiply3 = a2.b.multiply(bigInteger);
        int i3 = 0;
        while (true) {
            BigInteger[] bigIntegerArr2 = bigIntPolynomial2.a;
            if (i3 >= bigIntegerArr2.length) {
                break;
            }
            bigIntegerArr2[i3] = bigIntegerArr2[i3].multiply(multiply3);
            i3++;
        }
        bigIntPolynomial.a(bigIntPolynomial2);
        while (true) {
            BigInteger[] bigIntegerArr3 = bigIntPolynomial.a;
            if (i >= bigIntegerArr3.length) {
                return new ModularResultant(bigIntPolynomial, (BigInteger) null, multiply);
            }
            bigIntegerArr3[i] = bigIntegerArr3[i].mod(multiply);
            i++;
        }
    }
}
