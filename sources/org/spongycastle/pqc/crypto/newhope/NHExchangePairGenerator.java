package org.spongycastle.pqc.crypto.newhope;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.SecureRandom;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.pqc.crypto.ExchangePair;
import org.spongycastle.pqc.crypto.ExchangePairGenerator;

public class NHExchangePairGenerator implements ExchangePairGenerator {
    public final SecureRandom a;

    public NHExchangePairGenerator(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    public final ExchangePair a(NHPublicKeyParameters nHPublicKeyParameters) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = nHPublicKeyParameters.a;
        short[] sArr = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        byte[] bArr4 = new byte[32];
        Poly.b(bArr3, sArr);
        int i = 0;
        System.arraycopy(bArr3, 1792, bArr4, 0, 32);
        short[] sArr2 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        NewHope.a(bArr4, sArr2);
        byte[] bArr5 = new byte[32];
        this.a.nextBytes(bArr5);
        short[] sArr3 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.d(sArr3, bArr5, (byte) 0);
        short[] sArr4 = Precomp.c;
        for (int i2 = 0; i2 < 1024; i2++) {
            sArr3[i2] = Reduce.a((sArr3[i2] & 65535) * (65535 & sArr4[i2]));
        }
        short[] sArr5 = Precomp.a;
        NTT.a(sArr3, sArr5);
        short[] sArr6 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        int i3 = 1;
        Poly.d(sArr6, bArr5, (byte) 1);
        for (int i4 = 0; i4 < 1024; i4++) {
            sArr6[i4] = Reduce.a((sArr6[i4] & 65535) * (sArr4[i4] & 65535));
        }
        NTT.a(sArr6, sArr5);
        short[] sArr7 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.f(sArr2, sArr3, sArr7);
        Poly.a(sArr7, sArr6, sArr7);
        short[] sArr8 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.f(sArr, sArr3, sArr8);
        Poly.c(sArr8);
        short[] sArr9 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        Poly.d(sArr9, bArr5, (byte) 2);
        Poly.a(sArr8, sArr9, sArr8);
        short[] sArr10 = new short[UserMetadata.MAX_ATTRIBUTE_SIZE];
        byte[] bArr6 = new byte[8];
        bArr6[0] = 3;
        byte[] bArr7 = new byte[32];
        ChaCha20.a(32, bArr5, bArr6, bArr7);
        int[] iArr = new int[8];
        int i5 = 0;
        while (i5 < 256) {
            int i6 = i5 + 0;
            int i7 = ((bArr7[i5 >>> 3] >>> (i5 & 7)) & i3) * 4;
            int i8 = i5 + 256;
            int a2 = ErrorCorrection.a(i, 4, (sArr8[i6] * 8) + i7, iArr) + ErrorCorrection.a(i3, 5, (sArr8[i8] * 8) + i7, iArr);
            int i9 = i5 + AdRequest.MAX_CONTENT_URL_LENGTH;
            int i10 = i5 + ViewUtils.EDGE_TO_EDGE_FLAGS;
            int a3 = (24577 - ((a2 + ErrorCorrection.a(2, 6, (sArr8[i9] * 8) + i7, iArr)) + ErrorCorrection.a(3, 7, (sArr8[i10] * 8) + i7, iArr))) >> 31;
            int i11 = ~a3;
            int i12 = (i11 & iArr[0]) ^ (iArr[4] & a3);
            int i13 = (iArr[1] & i11) ^ (iArr[5] & a3);
            int i14 = (iArr[7] & a3) ^ (i11 & iArr[3]);
            sArr10[i6] = (short) ((i12 - i14) & 3);
            sArr10[i8] = (short) ((i13 - i14) & 3);
            sArr10[i9] = (short) ((((iArr[2] & i11) ^ (iArr[6] & a3)) - i14) & 3);
            sArr10[i10] = (short) (((i14 * 2) + (-a3)) & 3);
            i5++;
            i3 = 1;
            i = 0;
        }
        Poly.g(bArr2, sArr7);
        for (int i15 = 0; i15 < 256; i15++) {
            int i16 = i15 * 4;
            bArr2[i15 + 1792] = (byte) ((sArr10[i16 + 3] << 6) | sArr10[i16] | (sArr10[i16 + 1] << 2) | (sArr10[i16 + 2] << 4));
        }
        ErrorCorrection.c(bArr, sArr8, sArr10);
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.i(0, bArr, 32);
        sHA3Digest.c(0, bArr);
        return new ExchangePair(new NHPublicKeyParameters(bArr2), bArr);
    }
}
