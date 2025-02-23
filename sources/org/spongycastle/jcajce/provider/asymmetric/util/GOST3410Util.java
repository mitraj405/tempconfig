package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class GOST3410Util {
    public static GOST3410PrivateKeyParameters a(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof GOST3410PrivateKey) {
            GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) privateKey;
            GOST3410PublicKeyParameterSetSpec a = gOST3410PrivateKey.a().a();
            return new GOST3410PrivateKeyParameters(gOST3410PrivateKey.getX(), new GOST3410Parameters(a.a, a.b, a.c));
        }
        throw new InvalidKeyException("can't identify GOST3410 private key.");
    }

    public static GOST3410PublicKeyParameters b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof GOST3410PublicKey) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) publicKey;
            GOST3410PublicKeyParameterSetSpec a = gOST3410PublicKey.a().a();
            return new GOST3410PublicKeyParameters(gOST3410PublicKey.getY(), new GOST3410Parameters(a.a, a.b, a.c));
        }
        throw new InvalidKeyException("can't identify GOST3410 public key: ".concat(publicKey.getClass().getName()));
    }
}
