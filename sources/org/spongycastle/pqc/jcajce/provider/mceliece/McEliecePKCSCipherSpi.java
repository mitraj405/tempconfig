package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.mceliece.McElieceCipher;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher;

public class McEliecePKCSCipherSpi extends AsymmetricBlockCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final McElieceCipher a;

    public static class McEliecePKCS extends McEliecePKCSCipherSpi {
        public McEliecePKCS() {
            super(new McElieceCipher());
        }
    }

    public McEliecePKCSCipherSpi(McElieceCipher mcElieceCipher) {
        this.a = mcElieceCipher;
    }

    public final int e(Key key) throws InvalidKeyException {
        Object obj;
        if (key instanceof PublicKey) {
            obj = McElieceKeysToParams.b((PublicKey) key);
        } else {
            obj = McElieceKeysToParams.a((PrivateKey) key);
        }
        this.a.getClass();
        if (obj instanceof McEliecePublicKeyParameters) {
            return ((McEliecePublicKeyParameters) obj).c;
        }
        if (obj instanceof McEliecePrivateKeyParameters) {
            return ((McEliecePrivateKeyParameters) obj).c;
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final void m(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        McEliecePrivateKeyParameters a2 = McElieceKeysToParams.a((PrivateKey) key);
        McElieceCipher mcElieceCipher = this.a;
        mcElieceCipher.a(false, a2);
        this.d = mcElieceCipher.d;
        this.e = mcElieceCipher.e;
    }

    public final void n(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceKeysToParams.b((PublicKey) key), secureRandom);
        McElieceCipher mcElieceCipher = this.a;
        mcElieceCipher.a(true, parametersWithRandom);
        this.d = mcElieceCipher.d;
        this.e = mcElieceCipher.e;
    }

    public final byte[] o(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        try {
            return this.a.c(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] p(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        try {
            return this.a.d(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
