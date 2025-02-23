package defpackage;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: Mw  reason: default package and case insensitive filesystem */
/* compiled from: SimpleAeadCipher */
public final class C0600Mw {

    /* renamed from: Mw$a */
    /* compiled from: SimpleAeadCipher */
    public static class a {
        public byte[] a;
        public byte[] b;
    }

    public final a a(Key key, byte[] bArr, byte[] bArr2, byte[] bArr3) throws C0626Og {
        Cipher M = C1354qp.M("AES/GCM/NoPadding");
        try {
            M.init(1, key, new GCMParameterSpec(C1354qp.l(16), bArr));
            if (bArr3 != null && bArr3.length > 0) {
                M.updateAAD(bArr3);
            }
            try {
                byte[] doFinal = M.doFinal(bArr2);
                a aVar = new a();
                int length = doFinal.length - 16;
                aVar.a = C1354qp.z0(doFinal, 0, length);
                aVar.b = C1354qp.z0(doFinal, length, 16);
                return aVar;
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new C0626Og(e.toString(), e);
            }
        } catch (InvalidKeyException e2) {
            throw new C0626Og("Invalid key for AES/GCM/NoPadding", e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new C0626Og(e3.toString(), e3);
        }
    }

    public final boolean b(Bi bi, int i, String str) {
        if (!C1084e5.a(i, "AES/GCM/NoPadding")) {
            return false;
        }
        byte[] bArr = {112, 108, 97, 105, 110, 116, 101, 120, 116};
        byte[] bArr2 = {97, 97, 100};
        byte[] k0 = C1354qp.k0(i);
        try {
            a(new C1167i0(k0, 0), C1354qp.k0(12), bArr, bArr2);
            return true;
        } catch (Throwable th) {
            bi.a(str, "{} is not available ({}).", C1354qp.J0(th));
            return false;
        }
    }
}
