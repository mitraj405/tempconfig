package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;

public class NTRUEngine implements AsymmetricBlockCipher {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public NTRUEncryptionParameters f6709a;

    /* renamed from: a  reason: collision with other field name */
    public NTRUEncryptionPrivateKeyParameters f6710a;

    /* renamed from: a  reason: collision with other field name */
    public NTRUEncryptionPublicKeyParameters f6711a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6712a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6712a = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.a = parametersWithRandom.a;
                this.f6711a = (NTRUEncryptionPublicKeyParameters) parametersWithRandom.f6234a;
            } else {
                this.a = new SecureRandom();
                this.f6711a = (NTRUEncryptionPublicKeyParameters) cipherParameters;
            }
            this.f6711a.getClass();
            this.f6709a = null;
            return;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) cipherParameters;
        this.f6710a = nTRUEncryptionPrivateKeyParameters;
        nTRUEncryptionPrivateKeyParameters.getClass();
        this.f6709a = null;
    }

    public final int b() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.f6709a;
        int i = nTRUEncryptionParameters.c;
        if (nTRUEncryptionParameters.d == 2048) {
            return ((i * 11) + 7) / 8;
        }
        throw new IllegalStateException("log2 not fully implemented");
    }

    public final byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException {
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.f6712a) {
            this.f6711a.getClass();
            NTRUEncryptionParameters nTRUEncryptionParameters = this.f6709a;
            int i4 = nTRUEncryptionParameters.c;
            int i5 = nTRUEncryptionParameters.o;
            int i6 = nTRUEncryptionParameters.q;
            if (i5 > 255) {
                throw new IllegalArgumentException("llen values bigger than 1 are not supported");
            } else if (i2 <= i5) {
                int i7 = nTRUEncryptionParameters.p / 8;
                byte[] bArr3 = new byte[i7];
                this.a.nextBytes(bArr3);
                int i8 = (i5 + 1) - i2;
                int i9 = i6 / 8;
                byte[] bArr4 = new byte[i9];
                System.arraycopy(bArr3, 0, bArr4, 0, i7);
                bArr4[i7] = (byte) i2;
                int i10 = i7 + 1;
                System.arraycopy(bArr2, 0, bArr4, i10, i2);
                System.arraycopy(new byte[i8], 0, bArr4, i10 + i2, i8);
                int[] iArr = new int[i4];
                int i11 = 0;
                while (i3 < i9 * 8) {
                    int i12 = i3 + 1;
                    int i13 = i12 + 1;
                    int i14 = i13 + 1;
                    int a2 = (ArrayEncoder.a(i12, bArr4) * 2) + (ArrayEncoder.a(i3, bArr4) * 4) + ArrayEncoder.a(i13, bArr4);
                    int i15 = i11 + 1;
                    iArr[i11] = ArrayEncoder.a[a2];
                    i11 = i15 + 1;
                    iArr[i15] = ArrayEncoder.b[a2];
                    if (i11 > i4 - 2) {
                        break;
                    }
                    i3 = i14;
                }
                throw null;
            } else {
                throw new DataLengthException(lf.i("Message too long: ", i2, ">", i5));
            }
        } else {
            this.f6710a.getClass();
            NTRUEncryptionParameters nTRUEncryptionParameters2 = this.f6709a;
            int i16 = nTRUEncryptionParameters2.c;
            if (nTRUEncryptionParameters2.o <= 255) {
                int i17 = nTRUEncryptionParameters2.p / 8;
                int[] iArr2 = new int[i16];
                int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(nTRUEncryptionParameters2.d);
                int i18 = i16 * numberOfLeadingZeros;
                int i19 = 0;
                while (i3 < i18) {
                    if (i3 > 0 && i3 % numberOfLeadingZeros == 0) {
                        i19++;
                    }
                    iArr2[i19] = iArr2[i19] + (ArrayEncoder.a(i3, bArr2) << (i3 % numberOfLeadingZeros));
                    i3++;
                }
                if (this.f6709a.f6708c) {
                    throw null;
                }
                throw null;
            }
            throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
        }
    }

    public final int d() {
        return this.f6709a.o;
    }
}
