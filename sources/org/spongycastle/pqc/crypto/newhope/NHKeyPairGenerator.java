package org.spongycastle.pqc.crypto.newhope;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;

public class NHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public SecureRandom a;

    public final AsymmetricCipherKeyPair a() {
        byte[] bArr = new byte[1824];
        short[] sArr = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        SecureRandom secureRandom = this.a;
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        short[] sArr2 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        NewHope.a(bArr2, sArr2);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        Poly.d(sArr, bArr3, (byte) 0);
        short[] sArr3 = Precomp.c;
        for (int i = 0; i < 1024; i++) {
            sArr[i] = Reduce.a((sArr[i] & 65535) * (65535 & sArr3[i]));
        }
        short[] sArr4 = Precomp.a;
        NTT.a(sArr, sArr4);
        short[] sArr5 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.d(sArr5, bArr3, (byte) 1);
        for (int i2 = 0; i2 < 1024; i2++) {
            sArr5[i2] = Reduce.a((sArr5[i2] & 65535) * (sArr3[i2] & 65535));
        }
        NTT.a(sArr5, sArr4);
        short[] sArr6 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.f(sArr2, sArr, sArr6);
        short[] sArr7 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.a(sArr6, sArr5, sArr7);
        Poly.g(bArr, sArr7);
        System.arraycopy(bArr2, 0, bArr, 1792, 32);
        return new AsymmetricCipherKeyPair(new NHPublicKeyParameters(bArr), new NHPrivateKeyParameters(sArr));
    }
}
