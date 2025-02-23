package defpackage;

import com.google.firebase.perf.util.Constants;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.XECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;
import java.security.spec.XECPrivateKeySpec;
import java.security.spec.XECPublicKeySpec;
import java.util.Arrays;

/* renamed from: xE  reason: default package and case insensitive filesystem */
/* compiled from: XDHKeyUtil */
public final class C1476xE extends C1409tn {
    public static final BigInteger a = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564819949");
    public static final BigInteger b = new BigInteger("726838724295606890549323807888004534353641360687318060281490199180612328166730772686396383698676545930088884461843637361053498018365439");

    public C1476xE(String str) {
        super(str);
    }

    public static boolean i(Key key) {
        try {
            return key instanceof XECPublicKey;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public final String a() {
        return "XDH";
    }

    public final PrivateKey f(String str, byte[] bArr) throws C0626Og {
        try {
            return b().generatePrivate(new XECPrivateKeySpec(C1409tn.d(str), bArr));
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }

    public final PublicKey g(String str, byte[] bArr) throws C0626Og {
        int i;
        NamedParameterSpec d = C1409tn.d(str);
        byte[] t0 = C1354qp.t0(bArr);
        if ("X25519".equals(str)) {
            i = Constants.MAX_HOST_LENGTH;
        } else {
            i = 448;
        }
        int i2 = i % 8;
        if (i2 != 0) {
            t0[0] = (byte) (((1 << i2) - 1) & t0[0]);
        }
        try {
            return b().generatePublic(new XECPublicKeySpec(d, new BigInteger(1, t0)));
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }

    public final byte[] h(Key key) {
        BigInteger bigInteger;
        int i;
        XECPublicKey xECPublicKey = (XECPublicKey) key;
        BigInteger u = xECPublicKey.getU();
        boolean equals = "X25519".equals(xECPublicKey.getParams().getName());
        if (equals) {
            bigInteger = a;
        } else {
            bigInteger = b;
        }
        byte[] t0 = C1354qp.t0(u.mod(bigInteger).toByteArray());
        if (equals) {
            i = 32;
        } else {
            i = 57;
        }
        if (t0.length != i) {
            return Arrays.copyOf(t0, i);
        }
        return t0;
    }
}
