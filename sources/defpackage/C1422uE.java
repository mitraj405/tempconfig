package defpackage;

import defpackage.Nq;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: uE  reason: default package and case insensitive filesystem */
/* compiled from: WrappingKeyManagementAlgorithm */
public abstract class C1422uE extends C1379s0 implements C1387sh {
    public AlgorithmParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6984a = true;
    public final Bi b = C0473Ci.d(getClass());

    public C1422uE(String str, String str2) {
        this.b = str;
        this.f6950a = str2;
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        Nq.a aVar;
        if (bArr == null) {
            bArr = C1354qp.k0(qp.b);
        }
        if (this.f6984a) {
            aVar = nq.a;
        } else {
            aVar = nq.b;
        }
        aVar.getClass();
        Cipher M = C1354qp.M(this.b);
        try {
            AlgorithmParameterSpec algorithmParameterSpec = this.a;
            if (algorithmParameterSpec == null) {
                M.init(3, key);
            } else {
                M.init(3, key, algorithmParameterSpec);
            }
            return new ng(bArr, M.wrap(new SecretKeySpec(bArr, (String) qp.f491a)));
        } catch (InvalidKeyException e) {
            throw new C1259mg("Unable to encrypt (" + M.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        } catch (InvalidAlgorithmParameterException | IllegalBlockSizeException e2) {
            throw new C0626Og("Unable to encrypt (" + M.getAlgorithm() + ") the Content Encryption Key: " + e2, e2);
        }
    }
}
