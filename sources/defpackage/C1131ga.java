package defpackage;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ga  reason: default package and case insensitive filesystem */
/* compiled from: EllipticCurveJsonWebKey */
public final class C1131ga extends Oq {
    public final String j;

    public C1131ga() throws C0626Og {
        throw null;
    }

    public C1131ga(ECPublicKey eCPublicKey) {
        super((PublicKey) eCPublicKey);
        this.j = C1153ha.b(eCPublicKey.getParams().getCurve());
    }

    public final String b() {
        return "EC";
    }

    public final void j(LinkedHashMap linkedHashMap) {
        ECPoint w = ((ECPublicKey) this.a).getW();
        HashMap hashMap = C1153ha.f5474a;
        String str = this.j;
        int ceil = (int) Math.ceil(((double) ((ECParameterSpec) hashMap.get(str)).getCurve().getField().getFieldSize()) / 8.0d);
        Oq.m(linkedHashMap, "x", w.getAffineX(), ceil);
        Oq.m(linkedHashMap, "y", w.getAffineY(), ceil);
        linkedHashMap.put("crv", str);
    }

    public C1131ga(Map map) throws C0626Og {
        super(map);
        String d = Yg.d("crv", map, true);
        this.j = d;
        ECParameterSpec eCParameterSpec = (ECParameterSpec) C1153ha.f5474a.get(d);
        if (eCParameterSpec != null) {
            BigInteger k = Oq.k("x", map, true);
            BigInteger k2 = Oq.k("y", map, true);
            C0745X9 x9 = new C0745X9((String) null, (SecureRandom) null);
            try {
                this.a = (ECPublicKey) x9.b().generatePublic(new ECPublicKeySpec(new ECPoint(k, k2), eCParameterSpec));
                i();
                if (map.containsKey("d")) {
                    try {
                        this.a = (ECPrivateKey) x9.b().generatePrivate(new ECPrivateKeySpec(Oq.k("d", map, false), eCParameterSpec));
                    } catch (InvalidKeySpecException e) {
                        throw new C0626Og("Invalid key spec: " + e, e);
                    }
                }
                f("crv", "x", "y", "d");
            } catch (InvalidKeySpecException e2) {
                throw new C0626Og("Invalid key spec: " + e2, e2);
            }
        } else {
            throw new C1259mg(lf.j("\"", d, "\" is an unknown or unsupported value for the \"crv\" parameter."));
        }
    }
}
