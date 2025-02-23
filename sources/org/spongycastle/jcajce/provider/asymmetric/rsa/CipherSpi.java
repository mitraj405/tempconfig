package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameters f6456a;

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameterSpec f6457a;

    /* renamed from: a  reason: collision with other field name */
    public AsymmetricBlockCipher f6458a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6459a = false;
    public final BCJcaJceHelper b = new BCJcaJceHelper();

    /* renamed from: b  reason: collision with other field name */
    public boolean f6460b = false;

    public static class ISO9796d1Padding extends CipherSpi {
        public ISO9796d1Padding() {
            super((AsymmetricBlockCipher) new ISO9796d1Encoding(new RSABlindedEngine()));
        }
    }

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super((AsymmetricBlockCipher) new RSABlindedEngine());
        }
    }

    public static class OAEPPadding extends CipherSpi {
        public OAEPPadding() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super((AsymmetricBlockCipher) new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f6458a = asymmetricBlockCipher;
    }

    public final byte[] a() throws BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        try {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] c = this.f6458a.c(0, byteArray, byteArray.length);
            byteArrayOutputStream.reset();
            return c;
        } catch (InvalidCipherTextException e) {
            throw new BadBlockException("unable to decrypt block", e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new BadBlockException("unable to decrypt block", e2);
        } catch (Throwable th) {
            byteArrayOutputStream.reset();
            throw th;
        }
    }

    public final void b(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        ExtendedDigest a2 = DigestFactory.a(mGF1ParameterSpec.getDigestAlgorithm());
        if (a2 != null) {
            this.f6458a = new OAEPEncoding(new RSABlindedEngine(), a2, a2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.f6457a = oAEPParameterSpec;
            return;
        }
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr, i, i2);
        }
        if (this.f6458a instanceof RSABlindedEngine) {
            if (byteArrayOutputStream.size() > this.f6458a.d() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (byteArrayOutputStream.size() > this.f6458a.d()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return a();
    }

    public final int engineGetBlockSize() {
        try {
            return this.f6458a.d();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    public final int engineGetKeySize(Key key) {
        if (key instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey) {
            return ((RSAPublicKey) key).getModulus().bitLength();
        }
        throw new IllegalArgumentException("not an RSA key!");
    }

    public final int engineGetOutputSize(int i) {
        try {
            return this.f6458a.b();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.f6456a == null && this.f6457a != null) {
            try {
                AlgorithmParameters b2 = this.b.b("OAEP");
                this.f6456a = b2;
                b2.init(this.f6457a);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f6456a;
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom;
        ParametersWithRandom parametersWithRandom2;
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof OAEPParameterSpec)) {
            if (key instanceof RSAPublicKey) {
                if (!this.f6460b || i != 1) {
                    parametersWithRandom = RSAUtil.b((RSAPublicKey) key);
                } else {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
            } else if (!(key instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to RSA");
            } else if (!this.f6459a || i != 1) {
                parametersWithRandom = RSAUtil.a((RSAPrivateKey) key);
            } else {
                throw new InvalidKeyException("mode 2 requires RSAPublicKey");
            }
            if (algorithmParameterSpec != null) {
                OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                this.f6457a = algorithmParameterSpec;
                if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.g.c)) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                    ExtendedDigest a2 = DigestFactory.a(oAEPParameterSpec.getDigestAlgorithm());
                    if (a2 != null) {
                        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                        ExtendedDigest a3 = DigestFactory.a(mGF1ParameterSpec.getDigestAlgorithm());
                        if (a3 != null) {
                            this.f6458a = new OAEPEncoding(new RSABlindedEngine(), a2, a3, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
                        } else {
                            throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + oAEPParameterSpec.getDigestAlgorithm());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unkown MGF parameters");
                }
            }
            if (!(this.f6458a instanceof RSABlindedEngine)) {
                if (secureRandom != null) {
                    parametersWithRandom2 = new ParametersWithRandom(parametersWithRandom, secureRandom);
                } else {
                    parametersWithRandom2 = new ParametersWithRandom(parametersWithRandom, new SecureRandom());
                }
                parametersWithRandom = parametersWithRandom2;
            }
            this.a.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException(C1058d.y("unknown opmode ", i, " passed to RSA"));
                        }
                    }
                }
                this.f6458a.a(false, parametersWithRandom);
                return;
            }
            this.f6458a.a(true, parametersWithRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown parameter type: ".concat(algorithmParameterSpec.getClass().getName()));
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        String g = Strings.g(str);
        if (!g.equals("NONE") && !g.equals("ECB")) {
            if (g.equals(C0515Ga.AVLBLTY_ONLY)) {
                this.f6460b = true;
                this.f6459a = false;
            } else if (g.equals(C0515Ga.FARE_ONLY)) {
                this.f6460b = false;
                this.f6459a = true;
            } else {
                throw new NoSuchAlgorithmException("can't support mode ".concat(str));
            }
        }
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        String g = Strings.g(str);
        if (g.equals("NOPADDING")) {
            this.f6458a = new RSABlindedEngine();
        } else if (g.equals("PKCS1PADDING")) {
            this.f6458a = new PKCS1Encoding(new RSABlindedEngine());
        } else if (g.equals("ISO9796-1PADDING")) {
            this.f6458a = new ISO9796d1Encoding(new RSABlindedEngine());
        } else if (g.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPPADDING")) {
            b(OAEPParameterSpec.DEFAULT);
        } else if (g.equals("OAEPWITHSHA1ANDMGF1PADDING") || g.equals("OAEPWITHSHA-1ANDMGF1PADDING")) {
            b(OAEPParameterSpec.DEFAULT);
        } else if (g.equals("OAEPWITHSHA224ANDMGF1PADDING") || g.equals("OAEPWITHSHA-224ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA256ANDMGF1PADDING") || g.equals("OAEPWITHSHA-256ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA384ANDMGF1PADDING") || g.equals("OAEPWITHSHA-384ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA512ANDMGF1PADDING") || g.equals("OAEPWITHSHA-512ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT));
        } else {
            throw new NoSuchPaddingException(str.concat(" unavailable with RSA."));
        }
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        byteArrayOutputStream.write(bArr, i, i2);
        if (this.f6458a instanceof RSABlindedEngine) {
            if (byteArrayOutputStream.size() <= this.f6458a.d() + 1) {
                return null;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (byteArrayOutputStream.size() <= this.f6458a.d()) {
            return null;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    public CipherSpi(OAEPParameterSpec oAEPParameterSpec) {
        try {
            b(oAEPParameterSpec);
        } catch (NoSuchPaddingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        byteArrayOutputStream.write(bArr, i, i2);
        if (this.f6458a instanceof RSABlindedEngine) {
            if (byteArrayOutputStream.size() <= this.f6458a.d() + 1) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (byteArrayOutputStream.size() <= this.f6458a.d()) {
            return 0;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr, i, i2);
        }
        if (this.f6458a instanceof RSABlindedEngine) {
            if (byteArrayOutputStream.size() > this.f6458a.d() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (byteArrayOutputStream.size() > this.f6458a.d()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        byte[] a2 = a();
        for (int i4 = 0; i4 != a2.length; i4++) {
            bArr2[i3 + i4] = a2[i4];
        }
        return a2.length;
    }

    public CipherSpi(boolean z, boolean z2, PKCS1Encoding pKCS1Encoding) {
        this.f6459a = z;
        this.f6460b = z2;
        this.f6458a = pKCS1Encoding;
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString(), e);
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.f6456a = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Eeeek! " + e.toString(), e);
        }
    }
}
