package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class PSSSignatureSpi extends SignatureSpi {
    public byte a;

    /* renamed from: a  reason: collision with other field name */
    public int f6464a;

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameters f6465a;

    /* renamed from: a  reason: collision with other field name */
    public PSSParameterSpec f6466a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f6467a;

    /* renamed from: a  reason: collision with other field name */
    public Digest f6468a;

    /* renamed from: a  reason: collision with other field name */
    public ExtendedDigest f6469a;

    /* renamed from: a  reason: collision with other field name */
    public PSSSigner f6470a;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6471a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6472a;
    public final PSSParameterSpec b;

    public class NullPssDigest implements Digest {
        public final ByteArrayOutputStream a = new ByteArrayOutputStream();

        /* renamed from: a  reason: collision with other field name */
        public final Digest f6473a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f6474a = true;

        public NullPssDigest(Digest digest) {
            this.f6473a = digest;
        }

        public final String b() {
            return "NULL";
        }

        public final int c(int i, byte[] bArr) {
            byte[] byteArray = this.a.toByteArray();
            if (this.f6474a) {
                System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            } else {
                int length = byteArray.length;
                Digest digest = this.f6473a;
                digest.update(byteArray, 0, length);
                digest.c(i, bArr);
            }
            reset();
            this.f6474a = !this.f6474a;
            return byteArray.length;
        }

        public final void d(byte b) {
            this.a.write(b);
        }

        public final int f() {
            return this.f6473a.f();
        }

        public final void reset() {
            this.a.reset();
            this.f6473a.reset();
        }

        public final void update(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null, false);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT, false);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), 28, 1), false);
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1), false);
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1), false);
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1), false);
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1), false);
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1), false);
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1), false);
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1), false);
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1), false);
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1), false);
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null, true);
        }
    }

    public PSSSignatureSpi() {
        throw null;
    }

    public PSSSignatureSpi(RSABlindedEngine rSABlindedEngine, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.f6471a = new BCJcaJceHelper();
        this.f6467a = rSABlindedEngine;
        this.b = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.f6466a = PSSParameterSpec.DEFAULT;
        } else {
            this.f6466a = pSSParameterSpec;
        }
        this.f6469a = DigestFactory.a(this.f6466a.getDigestAlgorithm());
        this.f6464a = this.f6466a.getSaltLength();
        if (this.f6466a.getTrailerField() == 1) {
            this.a = -68;
            this.f6472a = z;
            if (z) {
                this.f6468a = new NullPssDigest(this.f6469a);
            } else {
                this.f6468a = this.f6469a;
            }
        } else {
            throw new IllegalArgumentException("unknown trailer field");
        }
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.f6465a == null && this.f6466a != null) {
            try {
                AlgorithmParameters b2 = this.f6471a.b("PSS");
                this.f6465a = b2;
                b2.init(this.f6466a);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f6465a;
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            PSSSigner pSSSigner = new PSSSigner(this.f6467a, this.f6468a, this.f6469a, this.f6464a, this.a);
            this.f6470a = pSSSigner;
            pSSSigner.c(true, new ParametersWithRandom(RSAUtil.a((RSAPrivateKey) privateKey), secureRandom));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            PSSSigner pSSSigner = new PSSSigner(this.f6467a, this.f6468a, this.f6469a, this.f6464a, this.a);
            this.f6470a = pSSSigner;
            pSSSigner.c(false, RSAUtil.b((RSAPublicKey) publicKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
            PSSParameterSpec pSSParameterSpec2 = this.b;
            if (pSSParameterSpec2 != null && !DigestFactory.b(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                throw new InvalidAlgorithmParameterException("parameter must be using " + pSSParameterSpec2.getDigestAlgorithm());
            } else if (!pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.g.c)) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            } else if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                if (DigestFactory.b(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    ExtendedDigest a2 = DigestFactory.a(mGF1ParameterSpec.getDigestAlgorithm());
                    if (a2 != null) {
                        this.f6465a = null;
                        this.f6466a = pSSParameterSpec;
                        this.f6469a = a2;
                        this.f6464a = pSSParameterSpec.getSaltLength();
                        if (this.f6466a.getTrailerField() == 1) {
                            this.a = -68;
                            if (this.f6472a) {
                                this.f6468a = new NullPssDigest(this.f6469a);
                            } else {
                                this.f6468a = this.f6469a;
                            }
                        } else {
                            throw new IllegalArgumentException("unknown trailer field");
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
                }
            } else {
                throw new InvalidAlgorithmParameterException("unknown MGF parameters");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
        }
    }

    public final byte[] engineSign() throws SignatureException {
        try {
            return this.f6470a.b();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    public final void engineUpdate(byte b2) throws SignatureException {
        this.f6470a.f6288a.d(b2);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f6470a.f(bArr);
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6470a.e(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            PSSSigner pSSSigner = new PSSSigner(this.f6467a, this.f6468a, this.f6469a, this.f6464a, this.a);
            this.f6470a = pSSSigner;
            pSSSigner.c(true, RSAUtil.a((RSAPrivateKey) privateKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
