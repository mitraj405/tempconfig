package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.ads.AdRequest;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Threefish {

    public static class AlgParams_1024 extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Threefish-1024 IV";
        }
    }

    public static class AlgParams_256 extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Threefish-256 IV";
        }
    }

    public static class AlgParams_512 extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Threefish-512 IV";
        }
    }

    public static class CMAC_1024 extends BaseMac {
        public CMAC_1024() {
            super((Mac) new CMac(new ThreefishEngine(UserMetadata.MAX_ATTRIBUTE_SIZE)));
        }
    }

    public static class CMAC_256 extends BaseMac {
        public CMAC_256() {
            super((Mac) new CMac(new ThreefishEngine(256)));
        }
    }

    public static class CMAC_512 extends BaseMac {
        public CMAC_512() {
            super((Mac) new CMac(new ThreefishEngine(AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class ECB_1024 extends BaseBlockCipher {
        public ECB_1024() {
            super((BlockCipher) new ThreefishEngine(UserMetadata.MAX_ATTRIBUTE_SIZE));
        }
    }

    public static class ECB_256 extends BaseBlockCipher {
        public ECB_256() {
            super((BlockCipher) new ThreefishEngine(256));
        }
    }

    public static class ECB_512 extends BaseBlockCipher {
        public ECB_512() {
            super((BlockCipher) new ThreefishEngine(AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class KeyGen_1024 extends BaseKeyGenerator {
        public KeyGen_1024() {
            super("Threefish-1024", UserMetadata.MAX_ATTRIBUTE_SIZE, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_256 extends BaseKeyGenerator {
        public KeyGen_256() {
            super("Threefish-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_512 extends BaseKeyGenerator {
        public KeyGen_512() {
            super("Threefish-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = Threefish.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Mac.Threefish-512CMAC", xx.E(str, "$CMAC_256", configurableProvider, "Mac.Threefish-256CMAC", "$CMAC_512"));
            configurableProvider.b("Cipher.Threefish-256", xx.E(str, "$CMAC_1024", configurableProvider, "Mac.Threefish-1024CMAC", "$ECB_256"));
            configurableProvider.b("Cipher.Threefish-1024", xx.E(str, "$ECB_512", configurableProvider, "Cipher.Threefish-512", "$ECB_1024"));
            configurableProvider.b("KeyGenerator.Threefish-512", xx.E(str, "$KeyGen_256", configurableProvider, "KeyGenerator.Threefish-256", "$KeyGen_512"));
            configurableProvider.b("AlgorithmParameters.Threefish-256", xx.E(str, "$KeyGen_1024", configurableProvider, "KeyGenerator.Threefish-1024", "$AlgParams_256"));
            configurableProvider.b("AlgorithmParameters.Threefish-1024", xx.E(str, "$AlgParams_512", configurableProvider, "AlgorithmParameters.Threefish-512", "$AlgParams_1024"));
        }
    }

    private Threefish() {
    }
}
