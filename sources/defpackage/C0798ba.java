package defpackage;

import java.security.PrivateKey;
import java.security.interfaces.EdECPrivateKey;

/* renamed from: ba  reason: default package and case insensitive filesystem */
/* compiled from: EdDsaAlgorithm */
public final class C0798ba extends A2 {
    public C0798ba() {
        super("EdDSA", "EdDSA");
    }

    public final void m(PrivateKey privateKey) throws C1259mg {
        C1354qp.o(privateKey, EdECPrivateKey.class);
    }
}
