package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.SEEDEngine;
import org.spongycastle.crypto.engines.SEEDWrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class SEED {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("SEED");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SEED parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "SEED IV";
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SEEDEngine()), 128);
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super((Mac) new CMac(new SEEDEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new SEEDEngine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new SEEDEngine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SEED", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        public static final String a = SEED.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            StringBuilder o = lf.o(str, "$AlgParams", configurableProvider, "AlgorithmParameters.SEED", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = KISAObjectIdentifiers.a;
            C1058d.I(o, aSN1ObjectIdentifier, configurableProvider, "SEED");
            C1058d.I(lf.o(str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.SEED", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier, configurableProvider, "SEED");
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, xx.E(str, "$ECB", configurableProvider, "Cipher.SEED", "$CBC"));
            configurableProvider.b("Cipher.SEEDWRAP", str.concat("$Wrap"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = KISAObjectIdentifiers.c;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier2, "SEEDWRAP");
            configurableProvider.b("Alg.Alias.Cipher.SEEDKW", "SEEDWRAP");
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier, xx.E(str, "$KeyGen", configurableProvider, "KeyGenerator.SEED", "$KeyGen"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier2, str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.b(configurableProvider, "SEED", str.concat("$CMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.c(configurableProvider, "SEED", str.concat("$GMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.d(configurableProvider, "SEED", str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new SEEDEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SEED", 256, new Poly1305KeyGenerator());
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new SEEDWrapEngine(), 0);
        }
    }

    private SEED() {
    }
}
