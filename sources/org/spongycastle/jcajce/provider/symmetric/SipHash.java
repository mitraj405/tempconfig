package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class SipHash {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SipHash", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac24 extends BaseMac {
        public Mac24() {
            super((Mac) new org.spongycastle.crypto.macs.SipHash());
        }
    }

    public static class Mac48 extends BaseMac {
        public Mac48() {
            super((Mac) new org.spongycastle.crypto.macs.SipHash(0));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = SipHash.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Mac.SIPHASH-2-4", str.concat("$Mac24"));
            configurableProvider.b("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
            configurableProvider.b("KeyGenerator.SIPHASH", xx.E(str, "$Mac48", configurableProvider, "Mac.SIPHASH-4-8", "$KeyGen"));
            configurableProvider.b("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
            configurableProvider.b("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
        }
    }

    private SipHash() {
    }
}
