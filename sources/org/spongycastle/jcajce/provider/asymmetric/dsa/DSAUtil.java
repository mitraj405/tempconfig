package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Fingerprint;

public class DSAUtil {
    public static final ASN1ObjectIdentifier[] a = {X9ObjectIdentifiers.T0, OIWObjectIdentifiers.g};

    public static String a(BigInteger bigInteger, DSAParams dSAParams) {
        return new Fingerprint(Arrays.k(bigInteger.toByteArray(), dSAParams.getP().toByteArray(), dSAParams.getQ().toByteArray(), dSAParams.getG().toByteArray())).toString();
    }

    public static DSAParameters b(DSAParams dSAParams) {
        if (dSAParams != null) {
            return new DSAParameters(dSAParams.getP(), dSAParams.getQ(), dSAParams.getG());
        }
        return null;
    }
}
