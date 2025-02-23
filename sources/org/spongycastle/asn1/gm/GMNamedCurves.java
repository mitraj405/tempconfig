package org.spongycastle.asn1.gm;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class GMNamedCurves {
    public static final Hashtable a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        AnonymousClass1 r0 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger a = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
                BigInteger a2 = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
                BigInteger a3 = GMNamedCurves.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
                BigInteger a4 = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
                BigInteger valueOf = BigInteger.valueOf(1);
                ECCurve.Fp fp = new ECCurve.Fp(a, a2, a3, a4, valueOf);
                return new X9ECParameters((ECCurve) fp, new X9ECPoint((ECCurve) fp, Hex.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), a4, valueOf, (byte[]) null);
            }
        };
        AnonymousClass2 r1 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger a = GMNamedCurves.a("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
                BigInteger a2 = GMNamedCurves.a("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
                BigInteger a3 = GMNamedCurves.a("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
                BigInteger a4 = GMNamedCurves.a("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
                BigInteger valueOf = BigInteger.valueOf(1);
                ECCurve.Fp fp = new ECCurve.Fp(a, a2, a3, a4, valueOf);
                return new X9ECParameters((ECCurve) fp, new X9ECPoint((ECCurve) fp, Hex.a("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), a4, valueOf, (byte[]) null);
            }
        };
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        b = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        c = hashtable3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = GMObjectIdentifiers.b;
        hashtable.put(Strings.e("wapip192v1"), aSN1ObjectIdentifier);
        hashtable3.put(aSN1ObjectIdentifier, "wapip192v1");
        hashtable2.put(aSN1ObjectIdentifier, r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = GMObjectIdentifiers.a;
        hashtable.put(Strings.e("sm2p256v1"), aSN1ObjectIdentifier2);
        hashtable3.put(aSN1ObjectIdentifier2, "sm2p256v1");
        hashtable2.put(aSN1ObjectIdentifier2, r0);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, Hex.a(str));
    }

    public static X9ECParameters b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) b.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.b();
    }
}
