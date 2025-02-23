package defpackage;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;

/* renamed from: A2  reason: default package */
/* compiled from: BaseSignatureAlgorithm */
public abstract class A2 extends C1379s0 implements C0783ah {
    public AlgorithmParameterSpec a;
    public final Bi b = C0473Ci.d(getClass());

    public A2(String str, String str2) {
        this.f6950a = str;
        this.b = str2;
    }

    public static String k(Key key) {
        String str;
        if (key == null) {
            str = "key is null";
        } else {
            str = "algorithm=" + key.getAlgorithm();
        }
        return lf.j("The given key (", str, ") is not valid ");
    }

    public boolean b() {
        try {
            if (l(new Nq()) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            this.b.b(this.f6950a + " via " + this.b + " is NOT available from the underlying JCE (" + C1354qp.J0(e) + ").");
            return false;
        }
    }

    public final void f(Key key) throws C1259mg {
        if (key != null) {
            try {
                m((PrivateKey) key);
            } catch (ClassCastException e) {
                throw new C1259mg(k(key) + "(not a private key or is the wrong type of key) for " + this.b + " / " + this.f6950a + " " + e);
            }
        } else {
            throw new C1259mg("Key cannot be null");
        }
    }

    public byte[] i(C0480D7 d7, byte[] bArr) throws C0626Og {
        Signature signature = d7.a;
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (SignatureException e) {
            throw new C0626Og("Problem creating signature.", e);
        }
    }

    public final C0480D7 j(Key key, Nq nq) throws C0626Og {
        Signature l = l(nq);
        try {
            l.initSign((PrivateKey) key);
            return new C0480D7(l, (Mac) null);
        } catch (InvalidKeyException e) {
            throw new C1259mg(k(key) + "for " + this.b, e);
        }
    }

    public final Signature l(Nq nq) throws C0626Og {
        Bi bi = this.b;
        nq.a.getClass();
        String str = this.b;
        try {
            Signature instance = Signature.getInstance(str);
            AlgorithmParameterSpec algorithmParameterSpec = this.a;
            if (algorithmParameterSpec != null) {
                try {
                    instance.setParameter(algorithmParameterSpec);
                } catch (UnsupportedOperationException e) {
                    if (bi.d()) {
                        bi.f("Unable to set algorithm parameter spec on Signature (java algorithm name: " + str + ") so ignoring the UnsupportedOperationException and relying on the default parameters.", e);
                    }
                }
            }
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            throw new C0626Og(C0709Uj.i("Unable to get an implementation of algorithm name: ", str), e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new C0626Og("Invalid algorithm parameter (" + this.a + ") for: " + str, e3);
        } catch (NoSuchProviderException e4) {
            throw new C0626Og(lf.j("Unable to get an implementation of ", str, " for provider null"), e4);
        }
    }

    public abstract void m(PrivateKey privateKey) throws C1259mg;
}
