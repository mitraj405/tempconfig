package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.ChaCha7539Engine;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class ChaCha {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new ChaChaEngine(), 8, -1, -1);
        }
    }

    public static class Base7539 extends BaseStreamCipher {
        public Base7539() {
            super(new ChaCha7539Engine(), 12, -1, -1);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("ChaCha", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen7539 extends BaseKeyGenerator {
        public KeyGen7539() {
            super("ChaCha7539", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = ChaCha.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("KeyGenerator.CHACHA", xx.E(str, "$Base", configurableProvider, "Cipher.CHACHA", "$KeyGen"));
            configurableProvider.b("KeyGenerator.CHACHA7539", xx.E(str, "$Base7539", configurableProvider, "Cipher.CHACHA7539", "$KeyGen7539"));
        }
    }

    private ChaCha() {
    }
}
