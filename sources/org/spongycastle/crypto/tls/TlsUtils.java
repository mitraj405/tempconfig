package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.util.Arrays;

public class TlsUtils {
    static {
        int i = 0;
        byte[][] bArr = new byte[10][];
        while (i < 10) {
            int i2 = i + 1;
            byte[] bArr2 = new byte[i2];
            Arrays.p(bArr2, (byte) (i + 65));
            bArr[i] = bArr2;
            i = i2;
        }
    }

    public static Digest a(short s) {
        switch (s) {
            case 1:
                return new MD5Digest();
            case 2:
                return new SHA1Digest();
            case 3:
                return new SHA224Digest();
            case 4:
                return new SHA256Digest();
            case 5:
                return new SHA384Digest();
            case 6:
                return new SHA512Digest();
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static boolean b(TlsContext tlsContext) {
        return tlsContext.b().c();
    }

    public static boolean c(TlsContext tlsContext) {
        return ProtocolVersion.c.b(tlsContext.b().a());
    }
}
