package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nsri.NSRIObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.ARIAEngine;
import org.spongycastle.crypto.engines.ARIAWrapEngine;
import org.spongycastle.crypto.engines.ARIAWrapPadEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.spec.AEADParameterSpec;

public final class ARIA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("ARIA");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for ARIA parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "ARIA IV";
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
            super(new CBCBlockCipher(new ARIAEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new ARIAEngine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new ARIAEngine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("ARIA", i, new CipherKeyGenerator());
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
        public static final String a = ARIA.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            String str = a;
            configurableProvider2.b("AlgorithmParameters.ARIA", str.concat("$AlgParams"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NSRIObjectIdentifiers.b;
            configurableProvider2.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NSRIObjectIdentifiers.f;
            configurableProvider2.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier2, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NSRIObjectIdentifiers.j;
            configurableProvider2.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier3, "ARIA");
            configurableProvider2.b("AlgorithmParameterGenerator.ARIA", str.concat("$AlgParamGen"));
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier, "ARIA");
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier2, "ARIA");
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier3, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NSRIObjectIdentifiers.d;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier4, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NSRIObjectIdentifiers.h;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier5, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NSRIObjectIdentifiers.l;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier6, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NSRIObjectIdentifiers.c;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier7, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NSRIObjectIdentifiers.g;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier8, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NSRIObjectIdentifiers.k;
            configurableProvider2.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier9, "ARIA");
            configurableProvider2.b("Cipher.ARIA", str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NSRIObjectIdentifiers.a;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier10, str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NSRIObjectIdentifiers.e;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier11, str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NSRIObjectIdentifiers.i;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier12, str.concat("$ECB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier2, str.concat("$CBC"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier3, str.concat("$CBC"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier7, str.concat("$CFB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier8, str.concat("$CFB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier9, str.concat("$CFB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier4, str.concat("$OFB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier5, str.concat("$OFB"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier6, str.concat("$OFB"));
            configurableProvider2.b("Cipher.ARIAWRAP", xx.E(str, "$RFC3211Wrap", configurableProvider2, "Cipher.ARIARFC3211WRAP", "$Wrap"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NSRIObjectIdentifiers.s;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier13, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier6;
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NSRIObjectIdentifiers.t;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier15, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier5;
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NSRIObjectIdentifiers.u;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier17, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier4;
            configurableProvider2.b("Alg.Alias.Cipher.ARIAKW", "ARIAWRAP");
            configurableProvider2.b("Cipher.ARIAWRAPPAD", str.concat("$WrapPad"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = NSRIObjectIdentifiers.v;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier19, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier9;
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = NSRIObjectIdentifiers.w;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier21, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier8;
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = NSRIObjectIdentifiers.x;
            configurableProvider2.c("Alg.Alias.Cipher", aSN1ObjectIdentifier23, "ARIAWRAPPAD");
            configurableProvider2.b("Alg.Alias.Cipher.ARIAKWP", "ARIAWRAPPAD");
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier13, xx.E(str, "$KeyGen", configurableProvider2, "KeyGenerator.ARIA", "$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier15, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier17, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier19, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier21, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier23, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier10, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier11, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier12, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier2, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier3, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier7, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier22, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier20, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier18, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier16, str.concat("$KeyGen192"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier14, str.concat("$KeyGen256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = NSRIObjectIdentifiers.p;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier24, str.concat("$KeyGen128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = NSRIObjectIdentifiers.q;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier25, str.concat("$KeyGen192"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = NSRIObjectIdentifiers.r;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier26, str.concat("$KeyGen256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = NSRIObjectIdentifiers.m;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier27, str.concat("$KeyGen128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = NSRIObjectIdentifiers.n;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier28, str.concat("$KeyGen192"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = NSRIObjectIdentifiers.o;
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier29, str.concat("$KeyGen256"));
            C1058d.I(C1058d.D(C1058d.D(lf.o(str, "$AlgParamGenCCM", configurableProvider2, "AlgorithmParameterGenerator.ARIACCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier24, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier25, configurableProvider2, "CCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier26, configurableProvider2, "CCM");
            String str2 = "Alg.Alias.Cipher";
            configurableProvider2.c(str2, aSN1ObjectIdentifier24, "CCM");
            configurableProvider2.c(str2, aSN1ObjectIdentifier25, "CCM");
            configurableProvider2.c(str2, aSN1ObjectIdentifier26, "CCM");
            C1058d.I(C1058d.D(C1058d.D(lf.o(str, "$AlgParamGenGCM", configurableProvider2, "AlgorithmParameterGenerator.ARIAGCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier27, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier28, configurableProvider2, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier29, configurableProvider2, CodePackage.GCM);
            configurableProvider2.c(str2, aSN1ObjectIdentifier27, CodePackage.GCM);
            configurableProvider2.c(str2, aSN1ObjectIdentifier28, CodePackage.GCM);
            configurableProvider2.c(str2, aSN1ObjectIdentifier29, CodePackage.GCM);
            String str3 = "ARIA";
            SymmetricAlgorithmProvider.c(configurableProvider2, str3, str.concat("$GMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.d(configurableProvider2, str3, str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new ARIAEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-ARIA", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new ARIAEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new ARIAWrapEngine(), 0);
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new ARIAWrapPadEngine(), 0);
        }
    }

    private ARIA() {
    }
}
