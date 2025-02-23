package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.AESWrapEngine;
import org.spongycastle.crypto.engines.AESWrapPadEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.engines.RFC5649WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.spec.AEADParameterSpec;

public final class AES {
    public static final HashMap a;

    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super((Mac) new CMac(new AESEngine()));
        }
    }

    public static class AESGMAC extends BaseMac {
        public AESGMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new AESEngine())));
        }
    }

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("AES");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenCCM extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("CCM");
                a.init(new CCMParameters(bArr, 12).e());
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenGCM extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a(CodePackage.GCM);
                a.init(new GCMParameters(bArr, 16).e());
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "AES IV";
        }
    }

    public static class AlgParamsCCM extends BaseAlgorithmParameters {
        public CCMParameters a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            boolean z;
            boolean z2 = true;
            if (cls != AlgorithmParameterSpec.class) {
                if (GcmSpecUtil.a == cls) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (cls == AEADParameterSpec.class) {
                        return new AEADParameterSpec(this.a.h(), this.a.c * 8);
                    }
                    if (cls == IvParameterSpec.class) {
                        return new IvParameterSpec(this.a.h());
                    }
                    throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: ".concat(cls.getName()));
                }
            }
            if (GcmSpecUtil.a == null) {
                z2 = false;
            }
            if (z2) {
                return GcmSpecUtil.b((DERSequence) this.a.b());
            }
            return new AEADParameterSpec(this.a.h(), this.a.c * 8);
        }

        public final byte[] engineGetEncoded() throws IOException {
            return this.a.e();
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (GcmSpecUtil.c(algorithmParameterSpec)) {
                this.a = CCMParameters.g(GcmSpecUtil.a(algorithmParameterSpec));
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.a = new CCMParameters(aEADParameterSpec.getIV(), aEADParameterSpec.a / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: ".concat(algorithmParameterSpec.getClass().getName()));
            }
        }

        public final String engineToString() {
            return "CCM";
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                return this.a.e();
            }
            throw new IOException("unknown format specified");
        }

        public final void engineInit(byte[] bArr) throws IOException {
            this.a = CCMParameters.g(bArr);
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                this.a = CCMParameters.g(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters {
        public GCMParameters a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            boolean z;
            boolean z2 = true;
            if (cls != AlgorithmParameterSpec.class) {
                if (GcmSpecUtil.a == cls) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (cls == AEADParameterSpec.class) {
                        return new AEADParameterSpec(this.a.h(), this.a.c * 8);
                    }
                    if (cls == IvParameterSpec.class) {
                        return new IvParameterSpec(this.a.h());
                    }
                    throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: ".concat(cls.getName()));
                }
            }
            if (GcmSpecUtil.a == null) {
                z2 = false;
            }
            if (z2) {
                return GcmSpecUtil.b((DERSequence) this.a.b());
            }
            return new AEADParameterSpec(this.a.h(), this.a.c * 8);
        }

        public final byte[] engineGetEncoded() throws IOException {
            return this.a.e();
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (GcmSpecUtil.c(algorithmParameterSpec)) {
                this.a = GcmSpecUtil.a(algorithmParameterSpec);
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.a = new GCMParameters(aEADParameterSpec.getIV(), aEADParameterSpec.a / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: ".concat(algorithmParameterSpec.getClass().getName()));
            }
        }

        public final String engineToString() {
            return CodePackage.GCM;
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                return this.a.e();
            }
            throw new IOException("unknown format specified");
        }

        public final void engineInit(byte[] bArr) throws IOException {
            this.a = GCMParameters.g(bArr);
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                this.a = GCMParameters.g(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESEngine()), 128);
        }
    }

    public static class CCM extends BaseBlockCipher {
        public CCM() {
            super(new CCMBlockCipher(new AESEngine()));
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new AESEngine();
                }
            });
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super((AEADBlockCipher) new GCMBlockCipher(new AESEngine()));
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("AES", (ASN1ObjectIdentifier) null);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(192);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(192);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        public static final String a = AES.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            String str = a;
            configurableProvider2.b("AlgorithmParameters.AES", str.concat("$AlgParams"));
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            StringBuilder sb = new StringBuilder("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.s;
            StringBuilder D = C1058d.D(sb, aSN1ObjectIdentifier, configurableProvider2, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.A;
            StringBuilder D2 = C1058d.D(D, aSN1ObjectIdentifier2, configurableProvider2, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.I;
            C1058d.I(D2, aSN1ObjectIdentifier3, configurableProvider2, "AES");
            StringBuilder o = lf.o(str, "$AlgParamsGCM", configurableProvider2, "AlgorithmParameters.GCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.w;
            StringBuilder D3 = C1058d.D(o, aSN1ObjectIdentifier4, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.E;
            StringBuilder D4 = C1058d.D(D3, aSN1ObjectIdentifier5, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.M;
            C1058d.I(D4, aSN1ObjectIdentifier6, configurableProvider2, CodePackage.GCM);
            StringBuilder o2 = lf.o(str, "$AlgParamsCCM", configurableProvider2, "AlgorithmParameters.CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.x;
            StringBuilder D5 = C1058d.D(o2, aSN1ObjectIdentifier7, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.F;
            StringBuilder D6 = C1058d.D(D5, aSN1ObjectIdentifier8, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.N;
            C1058d.I(D6, aSN1ObjectIdentifier9, configurableProvider2, "CCM");
            configurableProvider2.b("AlgorithmParameterGenerator.AES", str.concat("$AlgParamGen"));
            configurableProvider2.b("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            configurableProvider2.b("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            configurableProvider2.b("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            configurableProvider2.b("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "AES");
            C1058d.I(C1058d.D(new StringBuilder("Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier2, configurableProvider2, "AES", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier3, configurableProvider2, "AES");
            HashMap hashMap = AES.a;
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier6;
            configurableProvider2.e("Cipher.AES", hashMap);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = aSN1ObjectIdentifier5;
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier4;
            configurableProvider2.b("Cipher.AES", str.concat("$ECB"));
            configurableProvider2.b("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableProvider2.b("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableProvider2.b("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.r;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier13, str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.z;
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = aSN1ObjectIdentifier13;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier14, str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.H;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier16, str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier16;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier2, str.concat("$CBC"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier3, str.concat("$CBC"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NISTObjectIdentifiers.t;
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = aSN1ObjectIdentifier3;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier18, str.concat("$OFB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = NISTObjectIdentifiers.B;
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = aSN1ObjectIdentifier2;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier20, str.concat("$OFB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NISTObjectIdentifiers.J;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier22, str.concat("$OFB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = NISTObjectIdentifiers.u;
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier20;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier23, str.concat("$CFB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = NISTObjectIdentifiers.C;
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier14;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier25, str.concat("$CFB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = NISTObjectIdentifiers.K;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier27, str.concat("$CFB"));
            configurableProvider2.e("Cipher.AESWRAP", hashMap);
            configurableProvider2.b("Cipher.AESWRAP", str.concat("$Wrap"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = NISTObjectIdentifiers.v;
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier27;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier28, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier28;
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = NISTObjectIdentifiers.D;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier31, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier31;
            ASN1ObjectIdentifier aSN1ObjectIdentifier33 = NISTObjectIdentifiers.L;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier33, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier33;
            configurableProvider2.b("Alg.Alias.Cipher.AESKW", "AESWRAP");
            configurableProvider2.e("Cipher.AESWRAPPAD", hashMap);
            configurableProvider2.b("Cipher.AESWRAPPAD", str.concat("$WrapPad"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier35 = NISTObjectIdentifiers.y;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier35, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier36 = aSN1ObjectIdentifier35;
            ASN1ObjectIdentifier aSN1ObjectIdentifier37 = NISTObjectIdentifiers.G;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier37, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier38 = aSN1ObjectIdentifier37;
            ASN1ObjectIdentifier aSN1ObjectIdentifier39 = NISTObjectIdentifiers.O;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier39, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier40 = aSN1ObjectIdentifier39;
            configurableProvider2.b("Alg.Alias.Cipher.AESKWP", "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier41 = aSN1ObjectIdentifier25;
            configurableProvider2.b("Cipher.AESRFC5649WRAP", xx.E(str, "$RFC3211Wrap", configurableProvider2, "Cipher.AESRFC3211WRAP", "$RFC5649Wrap"));
            C1058d.I(C1058d.D(C1058d.D(lf.o(str, "$AlgParamGenCCM", configurableProvider2, "AlgorithmParameterGenerator.CCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier7, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier8, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier9, configurableProvider2, "CCM");
            configurableProvider2.e("Cipher.CCM", hashMap);
            configurableProvider2.b("Cipher.CCM", str.concat("$CCM"));
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier7, "CCM");
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier8, "CCM");
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier9, "CCM");
            ASN1ObjectIdentifier aSN1ObjectIdentifier42 = aSN1ObjectIdentifier12;
            ASN1ObjectIdentifier aSN1ObjectIdentifier43 = aSN1ObjectIdentifier11;
            ASN1ObjectIdentifier aSN1ObjectIdentifier44 = aSN1ObjectIdentifier10;
            C1058d.I(C1058d.D(C1058d.D(lf.o(str, "$AlgParamGenGCM", configurableProvider2, "AlgorithmParameterGenerator.GCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier42, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier43, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier44, configurableProvider2, CodePackage.GCM);
            configurableProvider2.e("Cipher.GCM", hashMap);
            configurableProvider2.b("Cipher.GCM", str.concat("$GCM"));
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier42, CodePackage.GCM);
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier43, CodePackage.GCM);
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier44, CodePackage.GCM);
            configurableProvider2.b("KeyGenerator.2.16.840.1.101.3.4.2", xx.E(str, "$KeyGen", configurableProvider2, "KeyGenerator.AES", "$KeyGen128"));
            configurableProvider2.b("KeyGenerator.2.16.840.1.101.3.4.42", xx.E(str, "$KeyGen192", configurableProvider2, "KeyGenerator.2.16.840.1.101.3.4.22", "$KeyGen256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier45 = aSN1ObjectIdentifier8;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier15, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier18, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier23, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier26, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier21, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier24, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier41, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier17, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier19, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier22, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier29, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier30, xx.E(str, "$KeyGen", configurableProvider2, "KeyGenerator.AESWRAP", "$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier32, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier34, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier42, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier43, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier44, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier7, str.concat("$KeyGen128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier46 = aSN1ObjectIdentifier45;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier46, str.concat("$KeyGen192"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier47 = aSN1ObjectIdentifier9;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier47, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier36, xx.E(str, "$KeyGen", configurableProvider2, "KeyGenerator.AESWRAPPAD", "$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier38, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier40, str.concat("$KeyGen256"));
            configurableProvider2.b("Mac.AESCCMMAC", xx.E(str, "$AESCMAC", configurableProvider2, "Mac.AESCMAC", "$AESCCMMAC"));
            configurableProvider2.b("Alg.Alias.Mac." + aSN1ObjectIdentifier7.c, "AESCCMMAC");
            configurableProvider2.b("Alg.Alias.Mac." + aSN1ObjectIdentifier46.c, "AESCCMMAC");
            configurableProvider2.b("Alg.Alias.Mac." + aSN1ObjectIdentifier47.c, "AESCCMMAC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier48 = BCObjectIdentifiers.a;
            String str2 = "Alg.Alias.Cipher";
            configurableProvider2.c(str2, aSN1ObjectIdentifier48, "PBEWITHSHAAND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier49 = BCObjectIdentifiers.b;
            configurableProvider2.c(str2, aSN1ObjectIdentifier49, "PBEWITHSHAAND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier50 = BCObjectIdentifiers.c;
            configurableProvider2.c(str2, aSN1ObjectIdentifier50, "PBEWITHSHAAND256BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier51 = BCObjectIdentifiers.d;
            configurableProvider2.c(str2, aSN1ObjectIdentifier51, "PBEWITHSHA256AND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier52 = BCObjectIdentifiers.e;
            configurableProvider2.c(str2, aSN1ObjectIdentifier52, "PBEWITHSHA256AND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier53 = BCObjectIdentifiers.f;
            configurableProvider2.c(str2, aSN1ObjectIdentifier53, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", xx.E(str, "$PBEWithSHA1AESCBC128", configurableProvider2, "Cipher.PBEWITHSHAAND128BITAES-CBC-BC", "$PBEWithSHA1AESCBC192"));
            configurableProvider2.b("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", xx.E(str, "$PBEWithSHA1AESCBC256", configurableProvider2, "Cipher.PBEWITHSHAAND256BITAES-CBC-BC", "$PBEWithSHA256AESCBC128"));
            configurableProvider2.b("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", xx.E(str, "$PBEWithSHA256AESCBC192", configurableProvider2, "Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", "$PBEWithSHA256AESCBC256"));
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", xx.E(str, "$PBEWithAESCBC", configurableProvider2, "Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "$PBEWithAESCBC"));
            configurableProvider2.b("SecretKeyFactory.AES", xx.E(str, "$PBEWithAESCBC", configurableProvider2, "Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "$KeyFactory"));
            configurableProvider2.c("SecretKeyFactory", NISTObjectIdentifiers.q, str.concat("$KeyFactory"));
            configurableProvider2.b("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", xx.E(str, "$PBEWithMD5And128BitAESCBCOpenSSL", configurableProvider2, "SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "$PBEWithMD5And192BitAESCBCOpenSSL"));
            configurableProvider2.b("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", xx.E(str, "$PBEWithMD5And256BitAESCBCOpenSSL", configurableProvider2, "SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "$PBEWithSHAAnd128BitAESBC"));
            configurableProvider2.b("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", xx.E(str, "$PBEWithSHAAnd192BitAESBC", configurableProvider2, "SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", "$PBEWithSHAAnd256BitAESBC"));
            configurableProvider2.b("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", xx.E(str, "$PBEWithSHA256And128BitAESBC", configurableProvider2, "SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", "$PBEWithSHA256And192BitAESBC"));
            configurableProvider2.b("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", str.concat("$PBEWithSHA256And256BitAESBC"));
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier48, "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier49, "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier50, "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier51, "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier52, "PBEWITHSHA256AND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier54 = aSN1ObjectIdentifier53;
            configurableProvider2.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier54, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            String str3 = "Alg.Alias.AlgorithmParameters.";
            configurableProvider2.b(str3 + aSN1ObjectIdentifier48.c, "PKCS12PBE");
            configurableProvider2.b(str3 + aSN1ObjectIdentifier49.c, "PKCS12PBE");
            configurableProvider2.b(str3 + aSN1ObjectIdentifier50.c, "PKCS12PBE");
            configurableProvider2.b(str3 + aSN1ObjectIdentifier51.c, "PKCS12PBE");
            configurableProvider2.b(str3 + aSN1ObjectIdentifier52.c, "PKCS12PBE");
            configurableProvider2.b(str3 + aSN1ObjectIdentifier54.c, "PKCS12PBE");
            String str4 = "AES";
            SymmetricAlgorithmProvider.c(configurableProvider2, str4, str.concat("$AESGMAC"), str.concat("$KeyGen128"));
            SymmetricAlgorithmProvider.d(configurableProvider2, str4, str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher {
        public PBEWithAESCBC() {
            super((BlockCipher) new CBCBlockCipher(new AESEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 192, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA1AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 128, 16);
        }
    }

    public static class PBEWithSHA1AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 192, 16);
        }
    }

    public static class PBEWithSHA1AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 256, 16);
        }
    }

    public static class PBEWithSHA256AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 128, 16);
        }
    }

    public static class PBEWithSHA256AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 192, 16);
        }
    }

    public static class PBEWithSHA256AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 256, 16);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 192, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 192, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 256, 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new AESEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESEngine()), 16);
        }
    }

    public static class RFC5649Wrap extends BaseWrapCipher {
        public RFC5649Wrap() {
            super(new RFC5649WrapEngine(new AESEngine()), 0);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine(), 0);
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new AESWrapPadEngine(), 0);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.SecretKey");
        hashMap.put("SupportedKeyFormats", "RAW");
    }

    private AES() {
    }

    public static class AESCCMMAC extends BaseMac {
        public AESCCMMAC() {
            super((Mac) new CCMMac(0));
        }

        public static class CCMMac implements Mac {
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public final CCMBlockCipher f6533a;

            private CCMMac() {
                this.f6533a = new CCMBlockCipher(new AESEngine());
                this.a = 8;
            }

            public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
                CCMBlockCipher cCMBlockCipher = this.f6533a;
                cCMBlockCipher.a(true, cipherParameters);
                this.a = cCMBlockCipher.h().length;
            }

            public final String b() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6533a.f6139a.b() + "/CCM");
                sb.append("Mac");
                return sb.toString();
            }

            public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
                try {
                    return this.f6533a.c(0, bArr);
                } catch (InvalidCipherTextException e) {
                    throw new IllegalStateException("exception on doFinal(): " + e.toString());
                }
            }

            public final void d(byte b) throws IllegalStateException {
                this.f6533a.f6141a.write(b);
            }

            public final int e() {
                return this.a;
            }

            public final void reset() {
                CCMBlockCipher cCMBlockCipher = this.f6533a;
                cCMBlockCipher.f6139a.reset();
                cCMBlockCipher.f6141a.reset();
                cCMBlockCipher.f6144b.reset();
            }

            public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
                this.f6533a.i(i, bArr, i2);
            }

            public /* synthetic */ CCMMac(int i) {
                this();
            }
        }
    }
}
