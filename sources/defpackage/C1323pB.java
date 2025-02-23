package defpackage;

import java.security.Key;

/* renamed from: pB  reason: default package and case insensitive filesystem */
/* compiled from: UnsecuredNoneAlgorithm */
public final class C1323pB extends C1379s0 implements C0783ah {
    public C1323pB() {
        this.f6950a = "none";
    }

    public final boolean b() {
        return true;
    }

    public final void f(Key key) throws C1259mg {
        if (key != null) {
            throw new C1259mg("JWS Plaintext (alg=none) must not use a key.");
        }
    }

    public final byte[] i(C0480D7 d7, byte[] bArr) {
        return C1354qp.f6923b;
    }

    public final C0480D7 j(Key key, Nq nq) throws C0626Og {
        if (key == null) {
            return null;
        }
        throw new C1259mg("JWS Plaintext (alg=none) must not use a key.");
    }
}
