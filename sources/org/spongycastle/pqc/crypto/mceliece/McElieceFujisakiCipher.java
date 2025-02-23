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

public class McElieceFujisakiCipher implements MessageEncryptor {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6683a;

    /* renamed from: a  reason: collision with other field name */
    public Digest f6684a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceCCA2KeyParameters f6685a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6686a;
    public int b;
    public int c;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6686a = z;
        if (!z) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.f6685a = mcElieceCCA2PrivateKeyParameters;
            this.f6684a = Utils.a(mcElieceCCA2PrivateKeyParameters.c);
            this.a = mcElieceCCA2PrivateKeyParameters.c;
            int[] iArr = mcElieceCCA2PrivateKeyParameters.f6678a.f6852a;
            int i = -1;
            int length = iArr.length - 1;
            if (iArr[length] != 0) {
                i = length;
            }
            this.c = i;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f6683a = parametersWithRandom.a;
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.f6234a;
            this.f6685a = mcElieceCCA2PublicKeyParameters;
            b(mcElieceCCA2PublicKeyParameters);
        } else {
            this.f6683a = new SecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.f6685a = mcElieceCCA2PublicKeyParameters2;
            b(mcElieceCCA2PublicKeyParameters2);
        }
    }

    public final void b(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        SecureRandom secureRandom = this.f6683a;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.f6683a = secureRandom;
        this.f6684a = Utils.a(mcElieceCCA2PublicKeyParameters.c);
        this.a = mcElieceCCA2PublicKeyParameters.c;
        this.b = mcElieceCCA2PublicKeyParameters.a.a;
        this.c = mcElieceCCA2PublicKeyParameters.d;
    }

    public final byte[] c(byte[] bArr) throws InvalidCipherTextException {
        if (!this.f6686a) {
            int i = (this.a + 7) >> 3;
            int length = bArr.length - i;
            byte[][] b2 = ByteUtils.b(i, bArr);
            byte[] bArr2 = b2[0];
            byte[] bArr3 = b2[1];
            GF2Vector[] a2 = McElieceCCA2Primitives.a((McElieceCCA2PrivateKeyParameters) this.f6685a, GF2Vector.a(this.a, bArr2));
            byte[] d = a2[0].d();
            GF2Vector gF2Vector = a2[1];
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.a(d);
            byte[] bArr4 = new byte[length];
            digestRandomGenerator.c(bArr4, length);
            for (int i2 = 0; i2 < length; i2++) {
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr3[i2]);
            }
            byte[] a3 = ByteUtils.a(d, bArr4);
            byte[] bArr5 = new byte[this.f6684a.f()];
            this.f6684a.update(a3, 0, a3.length);
            this.f6684a.c(0, bArr5);
            if (Conversions.a(this.a, bArr5, this.c).equals(gF2Vector)) {
                return bArr4;
            }
            throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public final byte[] d(byte[] bArr) {
        if (this.f6686a) {
            GF2Vector gF2Vector = new GF2Vector(this.b, this.f6683a);
            byte[] d = gF2Vector.d();
            byte[] a2 = ByteUtils.a(d, bArr);
            this.f6684a.update(a2, 0, a2.length);
            byte[] bArr2 = new byte[this.f6684a.f()];
            this.f6684a.c(0, bArr2);
            byte[] d2 = McElieceCCA2Primitives.b((McElieceCCA2PublicKeyParameters) this.f6685a, gF2Vector, Conversions.a(this.a, bArr2, this.c)).d();
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.a(d);
            int length = bArr.length;
            byte[] bArr3 = new byte[length];
            digestRandomGenerator.c(bArr3, length);
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr[i]);
            }
            return ByteUtils.a(d2, bArr3);
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
