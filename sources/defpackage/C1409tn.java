package defpackage;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.NamedParameterSpec;

/* renamed from: tn  reason: default package and case insensitive filesystem */
/* compiled from: OctetKeyPairUtil */
public abstract class C1409tn extends C1406th {
    public C1409tn(String str) {
        super(str, (SecureRandom) null);
    }

    public static NamedParameterSpec d(String str) throws C0626Og {
        try {
            return new NamedParameterSpec(str);
        } catch (NoClassDefFoundError e) {
            StringBuilder n = lf.n(str, " NamedParameterSpec not available. ");
            n.append(C1354qp.J0(e));
            throw new C0626Og(n.toString());
        }
    }

    public static C1409tn e(String str, String str2) {
        if (str.equals("Ed25519") || str.equals("Ed448")) {
            return new C0818ca(str2);
        }
        if (str.equals("X25519") || str.equals("X448")) {
            return new C1476xE(str2);
        }
        return null;
    }

    public abstract PrivateKey f(String str, byte[] bArr) throws C0626Og;

    public abstract PublicKey g(String str, byte[] bArr) throws C0626Og;

    public abstract byte[] h(Key key);
}
