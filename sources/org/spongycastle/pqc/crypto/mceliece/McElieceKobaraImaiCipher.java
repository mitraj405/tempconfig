package org.spongycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
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
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;

public class McElieceKobaraImaiCipher implements MessageEncryptor {
    public static final byte[] a = "a predetermined public constant".getBytes();

    /* renamed from: a  reason: collision with other field name */
    public int f6690a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6691a;

    /* renamed from: a  reason: collision with other field name */
    public Digest f6692a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceCCA2KeyParameters f6693a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6694a;
    public int b;
    public int c;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6694a = z;
        if (!z) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.f6693a = mcElieceCCA2PrivateKeyParameters;
            this.f6692a = Utils.a(mcElieceCCA2PrivateKeyParameters.c);
            this.f6690a = mcElieceCCA2PrivateKeyParameters.c;
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
            this.f6691a = parametersWithRandom.a;
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.f6234a;
            this.f6693a = mcElieceCCA2PublicKeyParameters;
            this.f6692a = Utils.a(mcElieceCCA2PublicKeyParameters.c);
            this.f6690a = mcElieceCCA2PublicKeyParameters.c;
            this.b = mcElieceCCA2PublicKeyParameters.a.a;
            this.c = mcElieceCCA2PublicKeyParameters.d;
        } else {
            this.f6691a = new SecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.f6693a = mcElieceCCA2PublicKeyParameters2;
            this.f6692a = Utils.a(mcElieceCCA2PublicKeyParameters2.c);
            this.f6690a = mcElieceCCA2PublicKeyParameters2.c;
            this.b = mcElieceCCA2PublicKeyParameters2.a.a;
            this.c = mcElieceCCA2PublicKeyParameters2.d;
        }
    }

    public final byte[] b(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        int[] iArr;
        boolean z;
        if (!this.f6694a) {
            int i = this.f6690a >> 3;
            if (bArr.length >= i) {
                int f = this.f6692a.f();
                int i2 = this.b >> 3;
                int length = bArr.length - i;
                boolean z2 = false;
                if (length > 0) {
                    byte[][] b2 = ByteUtils.b(length, bArr);
                    bArr2 = b2[0];
                    bArr = b2[1];
                } else {
                    bArr2 = new byte[0];
                }
                GF2Vector[] a2 = McElieceCCA2Primitives.a((McElieceCCA2PrivateKeyParameters) this.f6693a, GF2Vector.a(this.f6690a, bArr));
                byte[] d = a2[0].d();
                GF2Vector gF2Vector = a2[1];
                if (d.length > i2) {
                    int i3 = i2 - 0;
                    byte[] bArr3 = new byte[i3];
                    System.arraycopy(d, 0, bArr3, 0, i3);
                    d = bArr3;
                }
                int i4 = this.f6690a;
                int i5 = this.c;
                BigInteger bigInteger = Conversions.a;
                if (gF2Vector.a == i4) {
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        iArr = gF2Vector.a;
                        if (i6 >= iArr.length) {
                            break;
                        }
                        int i8 = iArr[i6];
                        for (int i9 = 0; i9 < 32; i9++) {
                            if ((i8 & 1) != 0) {
                                i7++;
                            }
                            i8 >>>= 1;
                        }
                        i6++;
                    }
                    if (i7 == i5) {
                        BigInteger a3 = IntegerFunctions.a(i4, i5);
                        BigInteger bigInteger2 = Conversions.a;
                        int i10 = i4;
                        for (int i11 = 0; i11 < i4; i11++) {
                            a3 = a3.multiply(BigInteger.valueOf((long) (i10 - i5))).divide(BigInteger.valueOf((long) i10));
                            i10--;
                            if ((iArr[i11 >> 5] & (1 << (i11 & 31))) != 0) {
                                bigInteger2 = bigInteger2.add(a3);
                                i5--;
                                if (i10 == i5) {
                                    a3 = Conversions.b;
                                } else {
                                    a3 = a3.multiply(BigInteger.valueOf((long) (i5 + 1))).divide(BigInteger.valueOf((long) (i10 - i5)));
                                }
                            }
                        }
                        byte[] byteArray = bigInteger2.toByteArray();
                        if (byteArray.length != 1 && (bigInteger2.bitLength() & 7) == 0) {
                            int bitLength = bigInteger2.bitLength() >> 3;
                            byte[] bArr4 = new byte[bitLength];
                            System.arraycopy(byteArray, 1, bArr4, 0, bitLength);
                            byteArray = bArr4;
                        }
                        byte[] a4 = ByteUtils.a(ByteUtils.a(bArr2, byteArray), d);
                        int length2 = a4.length - f;
                        byte[][] b3 = ByteUtils.b(f, a4);
                        byte[] bArr5 = b3[0];
                        byte[] bArr6 = b3[1];
                        byte[] bArr7 = new byte[this.f6692a.f()];
                        this.f6692a.update(bArr6, 0, bArr6.length);
                        this.f6692a.c(0, bArr7);
                        for (int i12 = f - 1; i12 >= 0; i12--) {
                            bArr7[i12] = (byte) (bArr7[i12] ^ bArr5[i12]);
                        }
                        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
                        digestRandomGenerator.a(bArr7);
                        byte[] bArr8 = new byte[length2];
                        digestRandomGenerator.c(bArr8, length2);
                        for (int i13 = length2 - 1; i13 >= 0; i13--) {
                            bArr8[i13] = (byte) (bArr8[i13] ^ bArr6[i13]);
                        }
                        byte[] bArr9 = a;
                        byte[][] b4 = ByteUtils.b(length2 - bArr9.length, bArr8);
                        byte[] bArr10 = b4[0];
                        byte[] bArr11 = b4[1];
                        if (bArr11 != null && bArr11.length == bArr9.length) {
                            boolean z3 = true;
                            for (int length3 = bArr11.length - 1; length3 >= 0; length3--) {
                                if (bArr11[length3] == bArr9[length3]) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                z3 &= z;
                            }
                            z2 = z3;
                        }
                        if (z2) {
                            return bArr10;
                        }
                        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
                    }
                }
                throw new IllegalArgumentException("vector has wrong length or hamming weight");
            }
            throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public final byte[] c(byte[] bArr) {
        if (this.f6694a) {
            int f = this.f6692a.f();
            int i = this.b >> 3;
            int bitLength = (IntegerFunctions.a(this.f6690a, this.c).bitLength() - 1) >> 3;
            byte[] bArr2 = a;
            int length = ((i + bitLength) - f) - bArr2.length;
            if (bArr.length > length) {
                length = bArr.length;
            }
            int length2 = bArr2.length + length;
            int i2 = ((length2 + f) - i) - bitLength;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, length, bArr2.length);
            byte[] bArr4 = new byte[f];
            this.f6691a.nextBytes(bArr4);
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.a(bArr4);
            byte[] bArr5 = new byte[length2];
            digestRandomGenerator.c(bArr5, length2);
            for (int i3 = length2 - 1; i3 >= 0; i3--) {
                bArr5[i3] = (byte) (bArr5[i3] ^ bArr3[i3]);
            }
            byte[] bArr6 = new byte[this.f6692a.f()];
            this.f6692a.update(bArr5, 0, length2);
            this.f6692a.c(0, bArr6);
            while (true) {
                f--;
                if (f < 0) {
                    break;
                }
                bArr6[f] = (byte) (bArr6[f] ^ bArr4[f]);
            }
            byte[] a2 = ByteUtils.a(bArr6, bArr5);
            byte[] bArr7 = new byte[0];
            if (i2 > 0) {
                bArr7 = new byte[i2];
                System.arraycopy(a2, 0, bArr7, 0, i2);
            }
            byte[] bArr8 = new byte[bitLength];
            System.arraycopy(a2, i2, bArr8, 0, bitLength);
            byte[] bArr9 = new byte[i];
            System.arraycopy(a2, bitLength + i2, bArr9, 0, i);
            byte[] d = McElieceCCA2Primitives.b((McElieceCCA2PublicKeyParameters) this.f6693a, GF2Vector.a(this.b, bArr9), Conversions.a(this.f6690a, bArr8, this.c)).d();
            if (i2 > 0) {
                return ByteUtils.a(bArr7, d);
            }
            return d;
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
