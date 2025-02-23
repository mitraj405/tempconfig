package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SkipjackEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Skipjack {

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Skipjack IV";
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new SkipjackEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Skipjack", 80, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super((org.spongycastle.crypto.Mac) new CBCBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class MacCFB8 extends BaseMac {
        public MacCFB8() {
            super((org.spongycastle.crypto.Mac) new CFBBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = Skipjack.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("KeyGenerator.SKIPJACK", xx.E(str, "$ECB", configurableProvider, "Cipher.SKIPJACK", "$KeyGen"));
            configurableProvider.b("Mac.SKIPJACKMAC", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.SKIPJACK", "$Mac"));
            configurableProvider.b("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            configurableProvider.b("Mac.SKIPJACKMAC/CFB8", str.concat("$MacCFB8"));
            configurableProvider.b("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }
    }

    private Skipjack() {
    }
}
