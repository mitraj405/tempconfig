package defpackage;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.XECPublicKey;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.KeyAgreement;

/* renamed from: Y9  reason: default package and case insensitive filesystem */
/* compiled from: EcdhKeyAgreementAlgorithm */
public final class C0754Y9 extends C1379s0 implements C1387sh {
    public final String c;

    public C0754Y9() {
        this.c = "enc";
        this.f6950a = "ECDH-ES";
        this.b = "ECDH";
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        boolean z;
        if (!(key instanceof ECPublicKey)) {
            BigInteger bigInteger = C1476xE.a;
            try {
                z = key instanceof XECPublicKey;
            } catch (NoClassDefFoundError unused) {
                z = false;
            }
            if (!z) {
                throw new C1259mg("Encrypting with ECDH expects ECPublicKey or XECPublicKey but was given " + key);
            }
        }
    }

    public final boolean b() {
        boolean z;
        boolean z2;
        Set<String> algorithms = Security.getAlgorithms("KeyFactory");
        if (!Security.getAlgorithms("KeyPairGenerator").contains("EC") || !algorithms.contains("EC")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String str = this.b;
            Bi bi = C1294o0.a;
            Set<String> algorithms2 = Security.getAlgorithms("KeyAgreement");
            Iterator<String> it = algorithms2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equalsIgnoreCase(str)) {
                        z2 = true;
                        break;
                    }
                } else {
                    C1294o0.a.c("{} is NOT available for {}. Algorithms available from underlying JCE: {}", str, "KeyAgreement", algorithms2);
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        Oq oq;
        String str;
        C1354qp.p(e(), bArr);
        nq.a().getClass();
        if (key instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (!"secp256k1".equals(C1153ha.b(eCPublicKey.getParams().getCurve()))) {
                oq = C0733W9.a(eCPublicKey.getParams(), (String) null, (SecureRandom) null);
            } else {
                throw new C1259mg("Use of the secp256k1 curve is not defined for ECDH-ES key agreement with JOSE.");
            }
        } else if (C1476xE.i(key)) {
            oq = C0452An.a(((XECPublicKey) key).getParams().getName());
        } else {
            throw new C1259mg("Inappropriate key for ECDH: " + key);
        }
        pe.getClass();
        pe.b(oq.g(), "epk");
        PrivateKey privateKey = oq.a;
        PublicKey publicKey = (PublicKey) key;
        nq.a.getClass();
        if (privateKey instanceof ECPrivateKey) {
            str = this.b;
        } else {
            str = "XDH";
        }
        try {
            KeyAgreement instance = KeyAgreement.getInstance(str);
            try {
                instance.init(privateKey);
                instance.doPhase(publicKey, true);
                byte[] generateSecret = instance.generateSecret();
                nq.b.getClass();
                ng ngVar = new ng(0);
                int l = C1354qp.l(qp.b);
                String a = pe.a(this.c);
                String a2 = pe.a("apu");
                String a3 = pe.a("apv");
                return new ng(((C1363r6) ngVar.b).a(generateSecret, l, C1354qp.A(ng.b(r1.v(a)), ngVar.a(a2), ngVar.a(a3), C1354qp.L(l), C1354qp.f6923b)), (byte[]) null);
            } catch (InvalidKeyException e) {
                throw new C1259mg("Invalid Key for " + this.b + " key agreement - " + e, e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new V5(lf.j("No ", str, " KeyAgreement available."), e2);
        } catch (NoSuchProviderException e3) {
            throw new C0626Og(lf.j("Cannot get ", str, " KeyAgreement with provider null"), e3);
        }
    }

    public C0754Y9(int i) {
        this();
        this.c = "alg";
    }
}
