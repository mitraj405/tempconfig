package org.spongycastle.pqc.crypto.newhope;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import org.spongycastle.crypto.digests.SHA3Digest;

public class NHAgreement {
    public NHPrivateKeyParameters a;

    public final byte[] a(NHPublicKeyParameters nHPublicKeyParameters) {
        byte[] bArr = new byte[32];
        short[] sArr = this.a.a;
        byte[] bArr2 = nHPublicKeyParameters.a;
        short[] sArr2 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        short[] sArr3 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.b(bArr2, sArr2);
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            byte b = bArr2[i + 1792] & UnsignedBytes.MAX_VALUE;
            sArr3[i2 + 0] = (short) (b & 3);
            sArr3[i2 + 1] = (short) ((b >>> 2) & 3);
            sArr3[i2 + 2] = (short) ((b >>> 4) & 3);
            sArr3[i2 + 3] = (short) (b >>> 6);
        }
        short[] sArr4 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.f(sArr, sArr2, sArr4);
        Poly.c(sArr4);
        ErrorCorrection.c(bArr, sArr4, sArr3);
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.i(0, bArr, 32);
        sHA3Digest.c(0, bArr);
        return bArr;
    }
}
