package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.SM4Engine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class SM4 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("SM4");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SM4 parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "SM4 IV";
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super((Mac) new CMac(new SM4Engine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new SM4Engine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new SM4Engine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SM4", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        public static final String a = SM4.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("AlgorithmParameterGenerator.SM4", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.SM4", "$AlgParamGen"));
            configurableProvider.b("KeyGenerator.SM4", xx.E(str, "$ECB", configurableProvider, "Cipher.SM4", "$KeyGen"));
            SymmetricAlgorithmProvider.b(configurableProvider, "SM4", str.concat("$CMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.c(configurableProvider, "SM4", str.concat("$GMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.d(configurableProvider, "SM4", str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new SM4Engine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SM4", 256, new Poly1305KeyGenerator());
        }
    }

    private SM4() {
    }
}
