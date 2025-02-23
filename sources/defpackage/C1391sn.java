package defpackage;

import java.security.PublicKey;
import java.security.interfaces.EdECKey;
import java.security.interfaces.XECKey;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: sn  reason: default package and case insensitive filesystem */
/* compiled from: OctetKeyPairJsonWebKey */
public final class C1391sn extends Oq {
    public static final HashSet a = new HashSet(Arrays.asList(new String[]{"Ed448", "Ed25519", "EdDSA", "X25519", "X448", "XDH"}));
    public final String j;

    public C1391sn() throws C0626Og {
        throw null;
    }

    public C1391sn(PublicKey publicKey) {
        super(publicKey);
        if (C1476xE.i(publicKey)) {
            this.j = ((XECKey) publicKey).getParams().getName();
        } else if (C0818ca.i(publicKey)) {
            this.j = ((EdECKey) publicKey).getParams().getName();
        } else {
            throw new V5("Unable to determine OKP subtype from " + publicKey);
        }
    }

    public final String b() {
        return "OKP";
    }

    public final void j(LinkedHashMap linkedHashMap) {
        String str = this.f;
        String str2 = this.j;
        byte[] h = C1409tn.e(str2, str).h(this.a);
        linkedHashMap.put("crv", str2);
        linkedHashMap.put("x", new nh(3).e(h));
    }

    public C1391sn(Map map) throws C0626Og {
        super(map);
        String d = Yg.d("crv", map, true);
        this.j = d;
        try {
            C1409tn e = C1409tn.e(d, (String) null);
            if (e != null) {
                this.a = e.g(d, new nh(3).d(Yg.d("x", map, true)));
                i();
                if (map.containsKey("d")) {
                    this.a = e.f(d, new nh(3).d(Yg.d("d", map, false)));
                }
                f("crv", "x", "d");
                return;
            }
            throw new C1259mg("\"" + d + "\" is an unknown or unsupported subtype value for the \"crv\" parameter.");
        } catch (NoClassDefFoundError e2) {
            throw new C0626Og("Unable to instantiate key for OKP JWK with " + this.j + ". " + C1354qp.J0(e2));
        }
    }
}
