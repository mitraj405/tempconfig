package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;

public class McElieceCipher implements MessageEncryptor {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6680a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceKeyParameters f6681a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6682a;
    public int b;
    public int c;
    public int d;
    public int e;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6682a = z;
        if (!z) {
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) cipherParameters;
            this.f6681a = mcEliecePrivateKeyParameters;
            int i = mcEliecePrivateKeyParameters.c;
            this.a = i;
            int i2 = mcEliecePrivateKeyParameters.d;
            this.b = i2;
            this.d = i2 >> 3;
            this.e = i >> 3;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f6680a = parametersWithRandom.a;
            McEliecePublicKeyParameters mcEliecePublicKeyParameters = (McEliecePublicKeyParameters) parametersWithRandom.f6234a;
            this.f6681a = mcEliecePublicKeyParameters;
            b(mcEliecePublicKeyParameters);
        } else {
            this.f6680a = new SecureRandom();
            McEliecePublicKeyParameters mcEliecePublicKeyParameters2 = (McEliecePublicKeyParameters) cipherParameters;
            this.f6681a = mcEliecePublicKeyParameters2;
            b(mcEliecePublicKeyParameters2);
        }
    }

    public final void b(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        SecureRandom secureRandom = this.f6680a;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.f6680a = secureRandom;
        int i = mcEliecePublicKeyParameters.c;
        this.a = i;
        int i2 = mcEliecePublicKeyParameters.a.a;
        this.b = i2;
        this.c = mcEliecePublicKeyParameters.d;
        this.e = i >> 3;
        this.d = i2 >> 3;
    }

    public final byte[] c(byte[] bArr) throws InvalidCipherTextException {
        int[] iArr;
        if (!this.f6682a) {
            GF2Vector a2 = GF2Vector.a(this.a, bArr);
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) this.f6681a;
            GF2mField gF2mField = mcEliecePrivateKeyParameters.f6699a;
            Permutation permutation = mcEliecePrivateKeyParameters.f6700a;
            permutation.getClass();
            Permutation permutation2 = mcEliecePrivateKeyParameters.f6703b;
            int length = permutation2.a.length;
            int[] iArr2 = permutation.a;
            if (length == iArr2.length) {
                Permutation permutation3 = new Permutation(iArr2.length);
                int length2 = iArr2.length;
                while (true) {
                    length2--;
                    iArr = permutation3.a;
                    if (length2 < 0) {
                        break;
                    }
                    iArr[length2] = iArr2[permutation2.a[length2]];
                }
                Permutation permutation4 = new Permutation(iArr.length);
                int length3 = iArr.length;
                while (true) {
                    length3--;
                    if (length3 < 0) {
                        break;
                    }
                    permutation4.a[iArr[length3]] = length3;
                }
                GF2Vector e2 = a2.e(permutation4);
                GF2Vector c2 = GoppaCode.c(mcEliecePrivateKeyParameters.b.h(e2), gF2mField, mcEliecePrivateKeyParameters.f6701a, mcEliecePrivateKeyParameters.f6702a);
                GF2Vector e3 = ((GF2Vector) e2.b(c2)).e(permutation);
                c2.e(permutation3);
                byte[] d2 = mcEliecePrivateKeyParameters.a.e(e3.c(this.b)).d();
                int length4 = d2.length - 1;
                while (length4 >= 0 && d2[length4] == 0) {
                    length4--;
                }
                if (length4 < 0 || d2[length4] != 1) {
                    throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
                }
                byte[] bArr2 = new byte[length4];
                System.arraycopy(d2, 0, bArr2, 0, length4);
                return bArr2;
            }
            throw new IllegalArgumentException("length mismatch");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public final byte[] d(byte[] bArr) {
        int i;
        if (this.f6682a) {
            int i2 = this.d;
            if ((this.b & 7) != 0) {
                i = 1;
            } else {
                i = 0;
            }
            byte[] bArr2 = new byte[(i2 + i)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = 1;
            return ((GF2Vector) ((McEliecePublicKeyParameters) this.f6681a).a.e(GF2Vector.a(this.b, bArr2)).b(new GF2Vector(this.a, this.c, this.f6680a))).d();
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
