package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McElieceKobaraImaiCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final ByteArrayOutputStream a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6809a;

    /* renamed from: a  reason: collision with other field name */
    public final McElieceKobaraImaiCipher f6810a;

    public static class McElieceKobaraImai extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai() {
            super(new SHA1Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai224 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai224() {
            super(new SHA224Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai256 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai256() {
            super(new SHA256Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai384 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai384() {
            super(new SHA384Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai512 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai512() {
            super(new SHA512Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public McElieceKobaraImaiCipherSpi() {
        this.a = new ByteArrayOutputStream();
        this.a = new ByteArrayOutputStream();
    }

    public final byte[] b(int i, byte[] bArr, int i2) throws BadPaddingException {
        l(i, bArr, i2);
        int i3 = this.c;
        McElieceKobaraImaiCipher mcElieceKobaraImaiCipher = this.f6810a;
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        if (i3 == 1) {
            byteArrayOutputStream.write(1);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.reset();
            return mcElieceKobaraImaiCipher.c(byteArray);
        } else if (i3 == 2) {
            try {
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.reset();
                byte[] b = mcElieceKobaraImaiCipher.b(byteArray2);
                int length = b.length - 1;
                while (length >= 0 && b[length] == 0) {
                    length--;
                }
                if (b[length] == 1) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(b, 0, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("invalid ciphertext");
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        } else {
            throw new IllegalStateException("unknown mode in doFinal");
        }
    }

    public final int e(Key key) throws InvalidKeyException {
        boolean z = key instanceof PublicKey;
        McElieceKobaraImaiCipher mcElieceKobaraImaiCipher = this.f6810a;
        if (z) {
            McElieceCCA2PublicKeyParameters b = McElieceCCA2KeysToParams.b((PublicKey) key);
            mcElieceKobaraImaiCipher.getClass();
            if (b instanceof McElieceCCA2PublicKeyParameters) {
                return b.c;
            }
            if (b instanceof McElieceCCA2PrivateKeyParameters) {
                return ((McElieceCCA2PrivateKeyParameters) b).c;
            }
            throw new IllegalArgumentException("unsupported type");
        } else if (key instanceof PrivateKey) {
            McElieceCCA2PrivateKeyParameters a2 = McElieceCCA2KeysToParams.a((PrivateKey) key);
            mcElieceKobaraImaiCipher.getClass();
            if (a2 instanceof McElieceCCA2PublicKeyParameters) {
                return ((McElieceCCA2PublicKeyParameters) a2).c;
            }
            if (a2 instanceof McElieceCCA2PrivateKeyParameters) {
                return a2.c;
            }
            throw new IllegalArgumentException("unsupported type");
        } else {
            throw new InvalidKeyException();
        }
    }

    public final byte[] l(int i, byte[] bArr, int i2) {
        this.a.write(bArr, i, i2);
        return new byte[0];
    }

    public final void o(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.a.reset();
        McElieceCCA2PrivateKeyParameters a2 = McElieceCCA2KeysToParams.a((PrivateKey) key);
        this.f6809a.reset();
        this.f6810a.a(false, a2);
    }

    public final void p(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.a.reset();
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceCCA2KeysToParams.b((PublicKey) key), secureRandom);
        this.f6809a.reset();
        this.f6810a.a(true, parametersWithRandom);
    }

    public McElieceKobaraImaiCipherSpi(Digest digest, McElieceKobaraImaiCipher mcElieceKobaraImaiCipher) {
        this.a = new ByteArrayOutputStream();
        this.f6809a = digest;
        this.f6810a = mcElieceKobaraImaiCipher;
        this.a = new ByteArrayOutputStream();
    }

    public final void m() {
    }

    public final void n() {
    }
}
