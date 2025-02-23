package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.CamelliaWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
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

public final class Camellia {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("Camellia");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Camellia IV";
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new CamelliaEngine()), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new CamelliaEngine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new CamelliaEngine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("Camellia", i, new CipherKeyGenerator());
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
        public static final String a = Camellia.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("AlgorithmParameters.CAMELLIA", str.concat("$AlgParams"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NTTObjectIdentifiers.a;
            configurableProvider.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "CAMELLIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NTTObjectIdentifiers.b;
            configurableProvider.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier2, "CAMELLIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NTTObjectIdentifiers.c;
            configurableProvider.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier3, "CAMELLIA");
            configurableProvider.b("AlgorithmParameterGenerator.CAMELLIA", str.concat("$AlgParamGen"));
            configurableProvider.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier, "CAMELLIA");
            configurableProvider.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier2, "CAMELLIA");
            configurableProvider.c("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier3, "CAMELLIA");
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, xx.E(str, "$ECB", configurableProvider, "Cipher.CAMELLIA", "$CBC"));
            configurableProvider.c("Cipher", aSN1ObjectIdentifier2, str.concat("$CBC"));
            configurableProvider.c("Cipher", aSN1ObjectIdentifier3, str.concat("$CBC"));
            configurableProvider.b("Cipher.CAMELLIAWRAP", xx.E(str, "$RFC3211Wrap", configurableProvider, "Cipher.CAMELLIARFC3211WRAP", "$Wrap"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.d;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier4, "CAMELLIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.e;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier5, "CAMELLIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.f;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier6, "CAMELLIAWRAP");
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier4, xx.E(str, "$KeyGen", configurableProvider, "KeyGenerator.CAMELLIA", "$KeyGen128"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier5, str.concat("$KeyGen192"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier6, str.concat("$KeyGen256"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier, str.concat("$KeyGen128"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier2, str.concat("$KeyGen192"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier3, str.concat("$KeyGen256"));
            SymmetricAlgorithmProvider.c(configurableProvider, "CAMELLIA", str.concat("$GMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.d(configurableProvider, "CAMELLIA", str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new CamelliaEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Camellia", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new CamelliaEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new CamelliaWrapEngine(), 0);
        }
    }

    private Camellia() {
    }
}
