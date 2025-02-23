package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.HC128Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class HC128 {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new HC128Engine(), 16, -1, -1);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("HC128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = HC128.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyGenerator.HC128", xx.E(a, "$Base", configurableProvider, "Cipher.HC128", "$KeyGen"));
        }
    }

    private HC128() {
    }
}
