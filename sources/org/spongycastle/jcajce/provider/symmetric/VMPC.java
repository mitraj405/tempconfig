package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.VMPCEngine;
import org.spongycastle.crypto.macs.VMPCMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class VMPC {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new VMPCEngine(), 16, -1, -1);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("VMPC", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super((org.spongycastle.crypto.Mac) new VMPCMac());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = VMPC.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("KeyGenerator.VMPC", xx.E(str, "$Base", configurableProvider, "Cipher.VMPC", "$KeyGen"));
            configurableProvider.b("Mac.VMPCMAC", str.concat("$Mac"));
            configurableProvider.b("Alg.Alias.Mac.VMPC", "VMPCMAC");
            configurableProvider.b("Alg.Alias.Mac.VMPC-MAC", "VMPCMAC");
        }
    }

    private VMPC() {
    }
}
