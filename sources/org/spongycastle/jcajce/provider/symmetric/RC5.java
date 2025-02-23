package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.RC532Engine;
import org.spongycastle.crypto.engines.RC564Engine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class RC5 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("RC5");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC5 parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "RC5 IV";
        }
    }

    public static class CBC32 extends BaseBlockCipher {
        public CBC32() {
            super(new CBCBlockCipher(new RC532Engine()), 64);
        }
    }

    public static class CFB8Mac32 extends BaseMac {
        public CFB8Mac32() {
            super((Mac) new CFBBlockCipherMac(new RC532Engine()));
        }
    }

    public static class ECB32 extends BaseBlockCipher {
        public ECB32() {
            super((BlockCipher) new RC532Engine());
        }
    }

    public static class ECB64 extends BaseBlockCipher {
        public ECB64() {
            super((BlockCipher) new RC564Engine());
        }
    }

    public static class KeyGen32 extends BaseKeyGenerator {
        public KeyGen32() {
            super("RC5", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen64 extends BaseKeyGenerator {
        public KeyGen64() {
            super("RC5-64", 256, new CipherKeyGenerator());
        }
    }

    public static class Mac32 extends BaseMac {
        public Mac32() {
            super((Mac) new CBCBlockCipherMac(new RC532Engine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = RC5.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Cipher.RC5", str.concat("$ECB32"));
            configurableProvider.b("Alg.Alias.Cipher.RC5-32", "RC5");
            configurableProvider.b("KeyGenerator.RC5", xx.E(str, "$ECB64", configurableProvider, "Cipher.RC5-64", "$KeyGen32"));
            configurableProvider.b("Alg.Alias.KeyGenerator.RC5-32", "RC5");
            configurableProvider.b("AlgorithmParameters.RC5", xx.E(str, "$KeyGen64", configurableProvider, "KeyGenerator.RC5-64", "$AlgParams"));
            configurableProvider.b("Mac.RC5MAC", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.RC5-64", "$Mac32"));
            configurableProvider.b("Alg.Alias.Mac.RC5", "RC5MAC");
            configurableProvider.b("Mac.RC5MAC/CFB8", str.concat("$CFB8Mac32"));
            configurableProvider.b("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
        }
    }

    private RC5() {
    }
}
