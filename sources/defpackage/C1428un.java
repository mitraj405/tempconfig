package defpackage;

import defpackage.Yg;
import java.security.Key;
import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: un  reason: default package and case insensitive filesystem */
/* compiled from: OctetSequenceJsonWebKey */
public final class C1428un extends Yg {
    public final byte[] a;

    public C1428un(PublicKey publicKey) {
        super((Key) publicKey);
        this.a = publicKey.getEncoded();
    }

    public final void a(LinkedHashMap linkedHashMap) {
        if (Yg.b.INCLUDE_SYMMETRIC.compareTo(Yg.b.PUBLIC_ONLY) >= 0) {
            linkedHashMap.put("k", new nh(3).e(this.a));
        }
    }

    public final String b() {
        return "oct";
    }

    public C1428un(Map<String, Object> map) throws C0626Og {
        super(map);
        byte[] d = new nh(3).d(Yg.d("k", map, true));
        this.a = d;
        this.a = new SecretKeySpec(d, "AES");
        f("k");
    }
}
