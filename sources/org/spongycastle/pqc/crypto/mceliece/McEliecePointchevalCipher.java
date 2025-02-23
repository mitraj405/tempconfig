package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;

public class McEliecePointchevalCipher implements MessageEncryptor {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6695a;

    /* renamed from: a  reason: collision with other field name */
    public Digest f6696a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceCCA2KeyParameters f6697a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6698a;
    public int b;
    public int c;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6698a = z;
        if (!z) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.f6697a = mcElieceCCA2PrivateKeyParameters;
            this.f6696a = Utils.a(mcElieceCCA2PrivateKeyParameters.c);
            this.a = mcElieceCCA2PrivateKeyParameters.c;
            this.b = mcElieceCCA2PrivateKeyParameters.d;
            int[] iArr = mcElieceCCA2PrivateKeyParameters.f6678a.f6852a;
            int i = -1;
            int length = iArr.length - 1;
            if (iArr[length] != 0) {
                i = length;
            }
            this.c = i;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f6695a = parametersWithRandom.a;
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.f6234a;
            this.f6697a = mcElieceCCA2PublicKeyParameters;
            b(mcElieceCCA2PublicKeyParameters);
        } else {
            this.f6695a = new SecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.f6697a = mcElieceCCA2PublicKeyParameters2;
            b(mcElieceCCA2PublicKeyParameters2);
        }
    }

    public final void b(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        SecureRandom secureRandom = this.f6695a;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.f6695a = secureRandom;
        this.f6696a = Utils.a(mcElieceCCA2PublicKeyParameters.c);
        this.a = mcElieceCCA2PublicKeyParameters.c;
        this.b = mcElieceCCA2PublicKeyParameters.a.a;
        this.c = mcElieceCCA2PublicKeyParameters.d;
    }

    public final byte[] c(byte[] bArr) throws InvalidCipherTextException {
        if (!this.f6698a) {
            int i = (this.a + 7) >> 3;
            int length = bArr.length - i;
            byte[][] b2 = ByteUtils.b(i, bArr);
            byte[] bArr2 = b2[0];
            byte[] bArr3 = b2[1];
            GF2Vector[] a2 = McElieceCCA2Primitives.a((McElieceCCA2PrivateKeyParameters) this.f6697a, GF2Vector.a(this.a, bArr2));
            byte[] d = a2[0].d();
            GF2Vector gF2Vector = a2[1];
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.a(d);
            byte[] bArr4 = new byte[length];
            digestRandomGenerator.c(bArr4, length);
            for (int i2 = 0; i2 < length; i2++) {
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr3[i2]);
            }
            this.f6696a.update(bArr4, 0, length);
            byte[] bArr5 = new byte[this.f6696a.f()];
            this.f6696a.c(0, bArr5);
            if (Conversions.a(this.a, bArr5, this.c).equals(gF2Vector)) {
                return ByteUtils.b(length - (this.b >> 3), bArr4)[0];
            }
            throw new InvalidCipherTextException("Bad Padding: Invalid ciphertext.");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public final byte[] d(byte[] bArr) {
        if (this.f6698a) {
            int i = this.b >> 3;
            byte[] bArr2 = new byte[i];
            this.f6695a.nextBytes(bArr2);
            GF2Vector gF2Vector = new GF2Vector(this.b, this.f6695a);
            byte[] d = gF2Vector.d();
            byte[] a2 = ByteUtils.a(bArr, bArr2);
            this.f6696a.update(a2, 0, a2.length);
            byte[] bArr3 = new byte[this.f6696a.f()];
            this.f6696a.c(0, bArr3);
            byte[] d2 = McElieceCCA2Primitives.b((McElieceCCA2PublicKeyParameters) this.f6697a, gF2Vector, Conversions.a(this.a, bArr3, this.c)).d();
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.a(d);
            int length = bArr.length + i;
            byte[] bArr4 = new byte[length];
            digestRandomGenerator.c(bArr4, length);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr[i2]);
            }
            for (int i3 = 0; i3 < i; i3++) {
                int length2 = bArr.length + i3;
                bArr4[length2] = (byte) (bArr4[length2] ^ bArr2[i3]);
            }
            return ByteUtils.a(d2, bArr4);
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
