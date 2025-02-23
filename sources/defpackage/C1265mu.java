package defpackage;

import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

/* renamed from: mu  reason: default package and case insensitive filesystem */
/* compiled from: RsaKeyUtil */
public final class C1265mu extends C1406th {
    public C1265mu() {
        super((String) null, (SecureRandom) null);
    }

    public final String a() {
        return "RSA";
    }

    public final RSAPrivateKey d(RSAPrivateKeySpec rSAPrivateKeySpec) throws C0626Og {
        try {
            return (RSAPrivateKey) b().generatePrivate(rSAPrivateKeySpec);
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }
}
