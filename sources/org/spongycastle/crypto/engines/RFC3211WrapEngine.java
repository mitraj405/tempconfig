package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class RFC3211WrapEngine implements Wrapper {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final CBCBlockCipher f6016a;

    /* renamed from: a  reason: collision with other field name */
    public ParametersWithIV f6017a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6018a;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.f6016a = new CBCBlockCipher(blockCipher);
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6018a = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.a;
            this.f6017a = (ParametersWithIV) parametersWithRandom.f6234a;
            return;
        }
        if (z) {
            this.a = new SecureRandom();
        }
        this.f6017a = (ParametersWithIV) cipherParameters;
    }

    public final String b() {
        return this.f6016a.f6136a.b() + "/RFC3211Wrap";
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        if (!this.f6018a) {
            CBCBlockCipher cBCBlockCipher = this.f6016a;
            int c = cBCBlockCipher.c();
            if (i >= c * 2) {
                byte[] bArr2 = new byte[i];
                byte[] bArr3 = new byte[c];
                int i2 = 0;
                System.arraycopy(bArr, 0, bArr2, 0, i);
                System.arraycopy(bArr, 0, bArr3, 0, c);
                cBCBlockCipher.a(false, new ParametersWithIV(this.f6017a.a, bArr3, 0, c));
                for (int i3 = c; i3 < i; i3 += c) {
                    cBCBlockCipher.e(i3, i3, bArr2, bArr2);
                }
                System.arraycopy(bArr2, i - c, bArr3, 0, c);
                cBCBlockCipher.a(false, new ParametersWithIV(this.f6017a.a, bArr3, 0, c));
                cBCBlockCipher.e(0, 0, bArr2, bArr2);
                cBCBlockCipher.a(false, this.f6017a);
                for (int i4 = 0; i4 < i; i4 += c) {
                    cBCBlockCipher.e(i4, i4, bArr2, bArr2);
                }
                byte b = bArr2[0];
                int i5 = b & UnsignedBytes.MAX_VALUE;
                if (i5 <= i - 4) {
                    byte[] bArr4 = new byte[i5];
                    System.arraycopy(bArr2, 4, bArr4, 0, b);
                    byte b2 = 0;
                    while (i2 != 3) {
                        int i6 = i2 + 1;
                        b2 |= ((byte) (~bArr2[i6])) ^ bArr4[i2];
                        i2 = i6;
                    }
                    if (b2 == 0) {
                        return bArr4;
                    }
                    throw new InvalidCipherTextException("wrapped key fails checksum");
                }
                throw new InvalidCipherTextException("wrapped key corrupted");
            }
            throw new InvalidCipherTextException("input too short");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public final byte[] d(byte[] bArr, int i) {
        byte[] bArr2;
        int i2;
        if (this.f6018a) {
            ParametersWithIV parametersWithIV = this.f6017a;
            CBCBlockCipher cBCBlockCipher = this.f6016a;
            cBCBlockCipher.a(true, parametersWithIV);
            int c = cBCBlockCipher.c();
            int i3 = i + 4;
            int i4 = c * 2;
            if (i3 < i4) {
                bArr2 = new byte[i4];
            } else {
                if (i3 % c == 0) {
                    i2 = i3;
                } else {
                    i2 = ((i3 / c) + 1) * c;
                }
                bArr2 = new byte[i2];
            }
            bArr2[0] = (byte) i;
            bArr2[1] = (byte) (~bArr[0]);
            bArr2[2] = (byte) (~bArr[1]);
            bArr2[3] = (byte) (~bArr[2]);
            System.arraycopy(bArr, 0, bArr2, 4, i);
            int length = bArr2.length - i3;
            byte[] bArr3 = new byte[length];
            this.a.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i3, length);
            for (int i5 = 0; i5 < bArr2.length; i5 += c) {
                cBCBlockCipher.e(i5, i5, bArr2, bArr2);
            }
            for (int i6 = 0; i6 < bArr2.length; i6 += c) {
                cBCBlockCipher.e(i6, i6, bArr2, bArr2);
            }
            return bArr2;
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
