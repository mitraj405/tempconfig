package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.HC256Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class HC256 {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new HC256Engine(), 32, -1, -1);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("HC256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = HC256.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyGenerator.HC256", xx.E(a, "$Base", configurableProvider, "Cipher.HC256", "$KeyGen"));
        }
    }

    private HC256() {
    }
}
