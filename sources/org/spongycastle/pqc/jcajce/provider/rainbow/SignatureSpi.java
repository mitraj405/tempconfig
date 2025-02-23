package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowSigner;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
import org.spongycastle.util.Arrays;

public class SignatureSpi extends java.security.SignatureSpi {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6823a;

    /* renamed from: a  reason: collision with other field name */
    public final RainbowSigner f6824a;

    public static class withSha224 extends SignatureSpi {
        public withSha224() {
            super(new SHA224Digest(), new RainbowSigner());
        }
    }

    public static class withSha256 extends SignatureSpi {
        public withSha256() {
            super(new SHA256Digest(), new RainbowSigner());
        }
    }

    public static class withSha384 extends SignatureSpi {
        public withSha384() {
            super(new SHA384Digest(), new RainbowSigner());
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), new RainbowSigner());
        }
    }

    public SignatureSpi(Digest digest, RainbowSigner rainbowSigner) {
        this.f6823a = digest;
        this.f6824a = rainbowSigner;
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [org.spongycastle.crypto.params.ParametersWithRandom] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void engineInitSign(java.security.PrivateKey r9) throws java.security.InvalidKeyException {
        /*
            r8 = this;
            boolean r0 = r9 instanceof org.spongycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey
            if (r0 == 0) goto L_0x002e
            org.spongycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey r9 = (org.spongycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey) r9
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r7 = new org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters
            short[][] r1 = r9.f6818a
            short[] r2 = r9.f6817a
            short[][] r3 = r9.f6819b
            short[] r4 = r9.b
            int[] r5 = r9.a
            org.spongycastle.pqc.crypto.rainbow.Layer[] r6 = r9.f6816a
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.security.SecureRandom r9 = r8.a
            if (r9 == 0) goto L_0x0022
            org.spongycastle.crypto.params.ParametersWithRandom r0 = new org.spongycastle.crypto.params.ParametersWithRandom
            r0.<init>(r7, r9)
            r7 = r0
        L_0x0022:
            org.spongycastle.crypto.Digest r9 = r8.f6823a
            r9.reset()
            org.spongycastle.pqc.crypto.rainbow.RainbowSigner r9 = r8.f6824a
            r0 = 1
            r9.a(r0, r7)
            return
        L_0x002e:
            java.security.InvalidKeyException r9 = new java.security.InvalidKeyException
            java.lang.String r0 = "can't identify Rainbow private key."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi.engineInitSign(java.security.PrivateKey):void");
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCRainbowPublicKey) {
            BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) publicKey;
            RainbowPublicKeyParameters rainbowPublicKeyParameters = new RainbowPublicKeyParameters(bCRainbowPublicKey.c, bCRainbowPublicKey.f6820a, bCRainbowPublicKey.a(), Arrays.g(bCRainbowPublicKey.a));
            this.f6823a.reset();
            this.f6824a.a(false, rainbowPublicKeyParameters);
            return;
        }
        throw new InvalidKeyException("can't identify Rainbow public key: ".concat(publicKey.getClass().getName()));
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[SYNTHETIC, Splitter:B:43:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] engineSign() throws java.security.SignatureException {
        /*
            r16 = this;
            r1 = r16
            org.spongycastle.crypto.Digest r0 = r1.f6823a
            int r2 = r0.f()
            byte[] r3 = new byte[r2]
            r4 = 0
            r0.c(r4, r3)
            org.spongycastle.pqc.crypto.rainbow.RainbowSigner r0 = r1.f6824a     // Catch:{ Exception -> 0x00ca }
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r5 = r0.f6740a     // Catch:{ Exception -> 0x00ca }
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r5 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r5     // Catch:{ Exception -> 0x00ca }
            org.spongycastle.pqc.crypto.rainbow.Layer[] r6 = r5.f6734a     // Catch:{ Exception -> 0x00ca }
            int r7 = r6.length     // Catch:{ Exception -> 0x00ca }
            short[][] r5 = r5.f6737b     // Catch:{ Exception -> 0x00ca }
            int r5 = r5.length     // Catch:{ Exception -> 0x00ca }
            short[] r5 = new short[r5]     // Catch:{ Exception -> 0x00ca }
            r0.f6742a = r5     // Catch:{ Exception -> 0x00ca }
            int r5 = r7 + -1
            r5 = r6[r5]     // Catch:{ Exception -> 0x00ca }
            int r5 = r5.b     // Catch:{ Exception -> 0x00ca }
            byte[] r8 = new byte[r5]     // Catch:{ Exception -> 0x00ca }
            int r9 = r0.a     // Catch:{ Exception -> 0x00ca }
            short[] r10 = new short[r9]     // Catch:{ Exception -> 0x00ca }
            r11 = r4
            r12 = r11
        L_0x002c:
            if (r11 < r2) goto L_0x002f
            goto L_0x003f
        L_0x002f:
            byte r13 = r3[r12]     // Catch:{ Exception -> 0x00ca }
            short r13 = (short) r13     // Catch:{ Exception -> 0x00ca }
            r10[r11] = r13     // Catch:{ Exception -> 0x00ca }
            r13 = r13 & 255(0xff, float:3.57E-43)
            short r13 = (short) r13     // Catch:{ Exception -> 0x00ca }
            r10[r11] = r13     // Catch:{ Exception -> 0x00ca }
            int r12 = r12 + 1
            int r11 = r11 + 1
            if (r11 < r9) goto L_0x002c
        L_0x003f:
            r2 = r4
        L_0x0040:
            short[] r3 = r0.b(r6, r10)     // Catch:{ Exception -> 0x00b3 }
            r9 = r4
            r11 = r9
        L_0x0046:
            org.spongycastle.pqc.crypto.rainbow.util.ComputeInField r12 = r0.f6741a     // Catch:{ Exception -> 0x00ca }
            if (r9 >= r7) goto L_0x008d
            r13 = r6[r9]     // Catch:{ Exception -> 0x00b3 }
            int r13 = r13.c     // Catch:{ Exception -> 0x00b3 }
            short[] r14 = new short[r13]     // Catch:{ Exception -> 0x00b3 }
            short[] r13 = new short[r13]     // Catch:{ Exception -> 0x00b3 }
            r13 = r4
        L_0x0053:
            r15 = r6[r9]     // Catch:{ Exception -> 0x00b3 }
            int r4 = r15.c     // Catch:{ Exception -> 0x00b3 }
            if (r13 >= r4) goto L_0x0063
            short r4 = r3[r11]     // Catch:{ Exception -> 0x00b3 }
            r14[r13] = r4     // Catch:{ Exception -> 0x00b3 }
            int r11 = r11 + 1
            int r13 = r13 + 1
            r4 = 0
            goto L_0x0053
        L_0x0063:
            short[] r4 = r0.f6742a     // Catch:{ Exception -> 0x00b3 }
            short[][] r4 = r15.a(r4)     // Catch:{ Exception -> 0x00b3 }
            short[] r4 = r12.i(r4, r14)     // Catch:{ Exception -> 0x00b3 }
            if (r4 == 0) goto L_0x0085
            r12 = 0
        L_0x0070:
            int r13 = r4.length     // Catch:{ Exception -> 0x00b3 }
            if (r12 >= r13) goto L_0x0081
            short[] r13 = r0.f6742a     // Catch:{ Exception -> 0x00b3 }
            r14 = r6[r9]     // Catch:{ Exception -> 0x00b3 }
            int r14 = r14.a     // Catch:{ Exception -> 0x00b3 }
            int r14 = r14 + r12
            short r15 = r4[r12]     // Catch:{ Exception -> 0x00b3 }
            r13[r14] = r15     // Catch:{ Exception -> 0x00b3 }
            int r12 = r12 + 1
            goto L_0x0070
        L_0x0081:
            int r9 = r9 + 1
            r4 = 0
            goto L_0x0046
        L_0x0085:
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r4 = "LES is not solveable!"
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b3 }
            throw r3     // Catch:{ Exception -> 0x00b3 }
        L_0x008d:
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r3 = r0.f6740a     // Catch:{ Exception -> 0x00b3 }
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r3 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r3     // Catch:{ Exception -> 0x00b3 }
            short[] r3 = r3.b     // Catch:{ Exception -> 0x00b3 }
            short[] r4 = r0.f6742a     // Catch:{ Exception -> 0x00b3 }
            r12.getClass()     // Catch:{ Exception -> 0x00b3 }
            short[] r3 = org.spongycastle.pqc.crypto.rainbow.util.ComputeInField.b(r3, r4)     // Catch:{ Exception -> 0x00b3 }
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r4 = r0.f6740a     // Catch:{ Exception -> 0x00b3 }
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r4 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r4     // Catch:{ Exception -> 0x00b3 }
            short[][] r4 = r4.f6737b     // Catch:{ Exception -> 0x00b3 }
            short[] r3 = org.spongycastle.pqc.crypto.rainbow.util.ComputeInField.h(r4, r3)     // Catch:{ Exception -> 0x00b3 }
            r4 = 0
        L_0x00a7:
            if (r4 >= r5) goto L_0x00b1
            short r9 = r3[r4]     // Catch:{ Exception -> 0x00b3 }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x00b3 }
            r8[r4] = r9     // Catch:{ Exception -> 0x00b3 }
            int r4 = r4 + 1
            goto L_0x00a7
        L_0x00b1:
            r3 = 1
            goto L_0x00b4
        L_0x00b3:
            r3 = 0
        L_0x00b4:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r3 != 0) goto L_0x00bf
            int r2 = r2 + 1
            if (r2 < r4) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r4 = 0
            goto L_0x0040
        L_0x00bf:
            if (r2 == r4) goto L_0x00c2
            return r8
        L_0x00c2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = "unable to generate signature - LES not solvable"
            r0.<init>(r2)     // Catch:{ Exception -> 0x00ca }
            throw r0     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            r0 = move-exception
            java.security.SignatureException r2 = new java.security.SignatureException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi.engineSign():byte[]");
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6823a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = bArr;
        Digest digest = this.f6823a;
        int f = digest.f();
        byte[] bArr3 = new byte[f];
        int i = 0;
        digest.c(0, bArr3);
        RainbowSigner rainbowSigner = this.f6824a;
        rainbowSigner.getClass();
        short[] sArr = new short[bArr2.length];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            sArr[i2] = (short) (((short) bArr2[i2]) & 255);
        }
        int i3 = rainbowSigner.a;
        short[] sArr2 = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (i4 < f) {
            short s = (short) bArr3[i5];
            sArr2[i4] = s;
            sArr2[i4] = (short) (s & 255);
            i5++;
            i4++;
            if (i4 >= i3) {
                break;
            }
        }
        RainbowPublicKeyParameters rainbowPublicKeyParameters = (RainbowPublicKeyParameters) rainbowSigner.f6740a;
        short[][] sArr3 = rainbowPublicKeyParameters.f6738a;
        int length = sArr3.length;
        short[] sArr4 = new short[length];
        short[][] sArr5 = rainbowPublicKeyParameters.b;
        int length2 = sArr5[0].length;
        int i6 = 0;
        while (i6 < sArr3.length) {
            int i7 = i;
            int i8 = i7;
            while (i7 < length2) {
                int i9 = i7;
                while (i9 < length2) {
                    sArr4[i6] = (short) (GF2Field.b(sArr3[i6][i8], GF2Field.b(sArr[i7], sArr[i9])) ^ sArr4[i6]);
                    i8++;
                    i9++;
                }
                sArr4[i6] = (short) (GF2Field.b(sArr5[i6][i7], sArr[i7]) ^ sArr4[i6]);
                i7++;
            }
            sArr4[i6] = (short) (sArr4[i6] ^ rainbowPublicKeyParameters.a[i6]);
            i6++;
            i = 0;
        }
        if (i3 != length) {
            return false;
        }
        boolean z = true;
        for (int i10 = 0; i10 < i3; i10++) {
            if (!z || sArr2[i10] != sArr4[i10]) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6823a.update(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.a = secureRandom;
        engineInitSign(privateKey);
    }
}
