package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.SerpentEngine;
import org.spongycastle.crypto.engines.TnepresEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class Serpent {

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Serpent IV";
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new SerpentEngine();
                }
            });
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Serpent", 192, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        public static final String a = Serpent.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("KeyGenerator.Serpent", xx.E(str, "$ECB", configurableProvider, "Cipher.Serpent", "$KeyGen"));
            configurableProvider.b("Cipher.Tnepres", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.Serpent", "$TECB"));
            configurableProvider.b("AlgorithmParameters.Tnepres", xx.E(str, "$TKeyGen", configurableProvider, "KeyGenerator.Tnepres", "$TAlgParams"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.c, str.concat("$ECB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.g, str.concat("$ECB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.k, str.concat("$ECB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.d, str.concat("$CBC"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.h, str.concat("$CBC"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.l, str.concat("$CBC"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.f, str.concat("$CFB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.j, str.concat("$CFB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.n, str.concat("$CFB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.e, str.concat("$OFB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.i, str.concat("$OFB"));
            configurableProvider.c("Cipher", GNUObjectIdentifiers.m, str.concat("$OFB"));
            SymmetricAlgorithmProvider.c(configurableProvider, "SERPENT", str.concat("$SerpentGMAC"), str.concat("$KeyGen"));
            SymmetricAlgorithmProvider.c(configurableProvider, "TNEPRES", str.concat("$TSerpentGMAC"), str.concat("$TKeyGen"));
            SymmetricAlgorithmProvider.d(configurableProvider, "SERPENT", str.concat("$Poly1305"), str.concat("$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super((Mac) new org.spongycastle.crypto.macs.Poly1305(new TwofishEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Serpent", 256, new Poly1305KeyGenerator());
        }
    }

    public static class SerpentGMAC extends BaseMac {
        public SerpentGMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new SerpentEngine())));
        }
    }

    public static class TAlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "Tnepres IV";
        }
    }

    public static class TECB extends BaseBlockCipher {
        public TECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new TnepresEngine();
                }
            });
        }
    }

    public static class TKeyGen extends BaseKeyGenerator {
        public TKeyGen() {
            super("Tnepres", 192, new CipherKeyGenerator());
        }
    }

    public static class TSerpentGMAC extends BaseMac {
        public TSerpentGMAC() {
            super((Mac) new GMac(new GCMBlockCipher(new TnepresEngine())));
        }
    }

    private Serpent() {
    }
}
