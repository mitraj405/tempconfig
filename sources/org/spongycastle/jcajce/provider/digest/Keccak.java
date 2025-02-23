package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.KeccakDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class Keccak {

    public static class Digest224 extends DigestKeccak {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestKeccak {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest288 extends DigestKeccak {
        public Digest288() {
            super(288);
        }
    }

    public static class Digest384 extends DigestKeccak {
        public Digest384() {
            super(384);
        }
    }

    public static class Digest512 extends DigestKeccak {
        public Digest512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class DigestKeccak extends BCMessageDigest implements Cloneable {
        public DigestKeccak(int i) {
            super(new KeccakDigest(i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new KeccakDigest((KeccakDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class HashMac224 extends BaseMac {
        public HashMac224() {
            super((Mac) new HMac(new KeccakDigest(224)));
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super((Mac) new HMac(new KeccakDigest(256)));
        }
    }

    public static class HashMac288 extends BaseMac {
        public HashMac288() {
            super((Mac) new HMac(new KeccakDigest(288)));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super((Mac) new HMac(new KeccakDigest(384)));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super((Mac) new HMac(new KeccakDigest((int) AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class KeyGenerator224 extends BaseKeyGenerator {
        public KeyGenerator224() {
            super("HMACKECCAK224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACKECCAK256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator288 extends BaseKeyGenerator {
        public KeyGenerator288() {
            super("HMACKECCAK288", 288, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACKECCAK384", 384, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACKECCAK512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = Keccak.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.KECCAK-288", xx.E(str, "$Digest224", configurableProvider, "MessageDigest.KECCAK-224", "$Digest288"));
            configurableProvider.b("MessageDigest.KECCAK-384", xx.E(str, "$Digest256", configurableProvider, "MessageDigest.KECCAK-256", "$Digest384"));
            DigestAlgorithmProvider.b(configurableProvider, "KECCAK224", xx.E(str, "$Digest512", configurableProvider, "MessageDigest.KECCAK-512", "$HashMac224"), str.concat("$KeyGenerator224"));
            DigestAlgorithmProvider.b(configurableProvider, "KECCAK256", str.concat("$HashMac256"), str.concat("$KeyGenerator256"));
            DigestAlgorithmProvider.b(configurableProvider, "KECCAK288", str.concat("$HashMac288"), str.concat("$KeyGenerator288"));
            DigestAlgorithmProvider.b(configurableProvider, "KECCAK384", str.concat("$HashMac384"), str.concat("$KeyGenerator384"));
            DigestAlgorithmProvider.b(configurableProvider, "KECCAK512", str.concat("$HashMac512"), str.concat("$KeyGenerator512"));
        }
    }

    private Keccak() {
    }
}
