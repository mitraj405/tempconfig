package defpackage;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ku  reason: default package and case insensitive filesystem */
/* compiled from: RsaJsonWebKey */
public final class C1227ku extends Oq {
    public C1227ku(RSAPublicKey rSAPublicKey) {
        super((PublicKey) rSAPublicKey);
    }

    public final String b() {
        return "RSA";
    }

    public final void j(LinkedHashMap linkedHashMap) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) this.a;
        Oq.l(linkedHashMap, "n", rSAPublicKey.getModulus());
        Oq.l(linkedHashMap, "e", rSAPublicKey.getPublicExponent());
    }

    public C1227ku(Map map) throws C0626Og {
        super(map);
        BigInteger k = Oq.k("n", map, true);
        BigInteger k2 = Oq.k("e", map, true);
        C1265mu muVar = new C1265mu();
        try {
            this.a = (RSAPublicKey) muVar.b().generatePublic(new RSAPublicKeySpec(k, k2));
            i();
            if (map.containsKey("d")) {
                BigInteger k3 = Oq.k("d", map, false);
                if (map.containsKey("p")) {
                    this.a = muVar.d(new RSAPrivateCrtKeySpec(k, k2, k3, Oq.k("p", map, false), Oq.k("q", map, false), Oq.k("dp", map, false), Oq.k("dq", map, false), Oq.k("qi", map, false)));
                } else {
                    this.a = muVar.d(new RSAPrivateKeySpec(k, k3));
                }
            }
            f("n", "e", "d", "p", "q", "dp", "dq", "qi");
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }
}
