package defpackage;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.EdECPublicKey;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPrivateKeySpec;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/* renamed from: ca  reason: default package and case insensitive filesystem */
/* compiled from: EdDsaKeyUtil */
public final class C0818ca extends C1409tn {
    public C0818ca(String str) {
        super(str);
    }

    public static boolean i(Key key) {
        try {
            return key instanceof EdECPublicKey;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public final String a() {
        return "EDDSA";
    }

    public final PrivateKey f(String str, byte[] bArr) throws C0626Og {
        try {
            return b().generatePrivate(new EdECPrivateKeySpec(C1409tn.d(str), bArr));
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }

    public final PublicKey g(String str, byte[] bArr) throws C0626Og {
        byte[] bArr2 = (byte[]) bArr.clone();
        boolean z = true;
        byte b = bArr2[bArr2.length - 1];
        int length = bArr2.length - 1;
        bArr2[length] = (byte) (bArr2[length] & Ascii.DEL);
        if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
            z = false;
        }
        try {
            return b().generatePublic(new EdECPublicKeySpec(C1409tn.d(str), new EdECPoint(z, r1.s(C1354qp.t0(bArr2)))));
        } catch (InvalidKeySpecException e) {
            throw new C0626Og("Invalid key spec: " + e, e);
        }
    }

    public final byte[] h(Key key) {
        int i;
        byte b;
        EdECPublicKey edECPublicKey = (EdECPublicKey) key;
        EdECPoint point = edECPublicKey.getPoint();
        byte[] t0 = C1354qp.t0(point.getY().toByteArray());
        if (edECPublicKey.getParams().getName().equals("Ed25519")) {
            i = 32;
        } else {
            i = 57;
        }
        if (t0.length != i) {
            t0 = Arrays.copyOf(t0, i);
        }
        if (point.isXOdd()) {
            b = UnsignedBytes.MAX_POWER_OF_TWO;
        } else {
            b = 0;
        }
        int length = t0.length - 1;
        t0[length] = (byte) (b | t0[length]);
        return t0;
    }
}
