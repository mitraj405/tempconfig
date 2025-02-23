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
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McElieceFujisakiCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6807a;

    /* renamed from: a  reason: collision with other field name */
    public final McElieceFujisakiCipher f6808a;

    public static class McElieceFujisaki extends McElieceFujisakiCipherSpi {
        public McElieceFujisaki() {
            super(new SHA1Digest(), new McElieceFujisakiCipher());
        }
    }

    public McElieceFujisakiCipherSpi(SHA1Digest sHA1Digest, McElieceFujisakiCipher mcElieceFujisakiCipher) {
        this.f6807a = sHA1Digest;
        this.f6808a = mcElieceFujisakiCipher;
    }

    public final byte[] b(int i, byte[] bArr, int i2) throws BadPaddingException {
        l(i, bArr, i2);
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        int i3 = this.c;
        McElieceFujisakiCipher mcElieceFujisakiCipher = this.f6808a;
        if (i3 == 1) {
            return mcElieceFujisakiCipher.d(byteArray);
        }
        if (i3 == 2) {
            try {
                return mcElieceFujisakiCipher.c(byteArray);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        } else {
            throw new IllegalStateException("unknown mode in doFinal");
        }
    }

    public final int e(Key key) throws InvalidKeyException {
        Object obj;
        if (key instanceof PublicKey) {
            obj = McElieceCCA2KeysToParams.b((PublicKey) key);
        } else {
            obj = McElieceCCA2KeysToParams.a((PrivateKey) key);
        }
        this.f6808a.getClass();
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
        this.f6807a.reset();
        this.f6808a.a(false, a2);
    }

    public final void p(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceCCA2KeysToParams.b((PublicKey) key), secureRandom);
        this.f6807a.reset();
        this.f6808a.a(true, parametersWithRandom);
    }

    public final void m() {
    }

    public final void n() {
    }
}
