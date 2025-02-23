package org.spongycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class ANSSINamedCurves {
    public static final Hashtable a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        AnonymousClass1 r0 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                Hashtable hashtable = ANSSINamedCurves.a;
                BigInteger bigInteger = new BigInteger(1, Hex.a("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03"));
                BigInteger bigInteger2 = new BigInteger(1, Hex.a("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00"));
                BigInteger bigInteger3 = new BigInteger(1, Hex.a("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F"));
                BigInteger bigInteger4 = new BigInteger(1, Hex.a("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1"));
                BigInteger valueOf = BigInteger.valueOf(1);
                ECCurve.Fp fp = new ECCurve.Fp(bigInteger, bigInteger2, bigInteger3, bigInteger4, valueOf);
                return new X9ECParameters((ECCurve) fp, new X9ECPoint((ECCurve) fp, Hex.a("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), bigInteger4, valueOf, (byte[]) null);
            }
        };
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        b = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        c = hashtable3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ANSSIObjectIdentifiers.a;
        hashtable.put(Strings.e("FRP256v1"), aSN1ObjectIdentifier);
        hashtable3.put(aSN1ObjectIdentifier, "FRP256v1");
        hashtable2.put(aSN1ObjectIdentifier, r0);
    }

    public static X9ECParameters a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) b.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.b();
    }
}
