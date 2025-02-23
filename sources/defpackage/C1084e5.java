package defpackage;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;

/* renamed from: e5  reason: default package and case insensitive filesystem */
/* compiled from: CipherStrengthSupport */
public final class C1084e5 {
    public static final Bi a = C0473Ci.d(C1084e5.class);

    public static boolean a(int i, String str) {
        boolean z;
        Bi bi = a;
        int l = C1354qp.l(i);
        try {
            int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(str);
            if (l <= maxAllowedKeyLength) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                bi.a(str, "max allowed key length for {} is {}", Integer.valueOf(maxAllowedKeyLength));
            }
            return z;
        } catch (NoSuchAlgorithmException e) {
            bi.a(str, "Unknown/unsupported algorithm, {} {}", e);
            return false;
        }
    }
}
