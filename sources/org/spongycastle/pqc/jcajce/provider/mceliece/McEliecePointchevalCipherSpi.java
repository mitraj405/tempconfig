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
import org.spongycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McEliecePointchevalCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6811a;

    /* renamed from: a  reason: collision with other field name */
    public final McEliecePointchevalCipher f6812a;

    public static class McEliecePointcheval extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval() {
            super(new SHA1Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval224 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval224() {
            super(new SHA224Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval256 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval256() {
            super(new SHA256Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval384 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval384() {
            super(new SHA384Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval512 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval512() {
            super(new SHA512Digest(), new McEliecePointchevalCipher());
        }
    }

    public McEliecePointchevalCipherSpi(Digest digest, McEliecePointchevalCipher mcEliecePointchevalCipher) {
        this.f6811a = digest;
        this.f6812a = mcEliecePointchevalCipher;
        this.a = new ByteArrayOutputStream();
    }

    public final byte[] b(int i, byte[] bArr, int i2) throws BadPaddingException {
        l(i, bArr, i2);
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        int i3 = this.c;
        McEliecePointchevalCipher mcEliecePointchevalCipher = this.f6812a;
        if (i3 == 1) {
            return mcEliecePointchevalCipher.d(byteArray);
        }
        if (i3 != 2) {
            return null;
        }
        try {
            return mcEliecePointchevalCipher.c(byteArray);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public final int e(Key key) throws InvalidKeyException {
        Object obj;
        if (key instanceof PublicKey) {
            obj = McElieceCCA2KeysToParams.b((PublicKey) key);
        } else {
            obj = McElieceCCA2KeysToParams.a((PrivateKey) key);
        }
        this.f6812a.getClass();
        if (obj instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) obj).c;
        }
        if (obj instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) obj).c;
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final byte[] l(int i, byte[] bArr, int i2) {
        this.a.write(bArr, i, i2);
        return new byte[0];
    }

    public final void o(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        McElieceCCA2PrivateKeyParameters a2 = McElieceCCA2KeysToParams.a((PrivateKey) key);
        this.f6811a.reset();
        this.f6812a.a(false, a2);
    }

    public final void p(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceCCA2KeysToParams.b((PublicKey) key), secureRandom);
        this.f6811a.reset();
        this.f6812a.a(true, parametersWithRandom);
    }

    public final void m() {
    }

    public final void n() {
    }
}
