package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public class Poly1305 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Poly1305", 256, new Poly1305KeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super((org.spongycastle.crypto.Mac) new org.spongycastle.crypto.macs.Poly1305());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = Poly1305.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyGenerator.POLY1305", xx.E(a, "$Mac", configurableProvider, "Mac.POLY1305", "$KeyGen"));
        }
    }

    private Poly1305() {
    }
}
