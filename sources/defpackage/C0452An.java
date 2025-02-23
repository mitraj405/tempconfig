package defpackage;

import defpackage.Oq;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.NamedParameterSpec;

/* renamed from: An  reason: default package and case insensitive filesystem */
/* compiled from: OkpJwkGenerator */
public final class C0452An {
    public static C1391sn a(String str) throws C0626Og {
        C1409tn e = C1409tn.e(str, (String) null);
        if (e != null) {
            KeyPairGenerator c = e.c();
            NamedParameterSpec d = C1409tn.d(str);
            try {
                SecureRandom secureRandom = e.f6966a;
                if (secureRandom == null) {
                    c.initialize(d);
                } else {
                    c.initialize(d, secureRandom);
                }
                KeyPair generateKeyPair = c.generateKeyPair();
                C1391sn snVar = (C1391sn) Oq.a.b(generateKeyPair.getPublic());
                snVar.a = generateKeyPair.getPrivate();
                return snVar;
            } catch (InvalidAlgorithmParameterException e2) {
                throw new C0626Og("Unable to create EdDSA key pair: " + e2, e2);
            }
        } else {
            throw new IllegalArgumentException(lf.j("Cannot create OKP JWK. The subtype/crv \"", str, "\" is unknown or unsupported."));
        }
    }
}
