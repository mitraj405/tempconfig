package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.SkeinMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class Skein {

    public static class DigestSkein1024 extends BCMessageDigest implements Cloneable {
        public DigestSkein1024(int i) {
            super(new SkeinDigest(UserMetadata.MAX_ATTRIBUTE_SIZE, i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class DigestSkein256 extends BCMessageDigest implements Cloneable {
        public DigestSkein256(int i) {
            super(new SkeinDigest(256, i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class DigestSkein512 extends BCMessageDigest implements Cloneable {
        public DigestSkein512(int i) {
            super(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class Digest_1024_1024 extends DigestSkein1024 {
        public Digest_1024_1024() {
            super(UserMetadata.MAX_ATTRIBUTE_SIZE);
        }
    }

    public static class Digest_1024_384 extends DigestSkein1024 {
        public Digest_1024_384() {
            super(384);
        }
    }

    public static class Digest_1024_512 extends DigestSkein1024 {
        public Digest_1024_512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class Digest_256_128 extends DigestSkein256 {
        public Digest_256_128() {
            super(128);
        }
    }

    public static class Digest_256_160 extends DigestSkein256 {
        public Digest_256_160() {
            super(160);
        }
    }

    public static class Digest_256_224 extends DigestSkein256 {
        public Digest_256_224() {
            super(224);
        }
    }

    public static class Digest_256_256 extends DigestSkein256 {
        public Digest_256_256() {
            super(256);
        }
    }

    public static class Digest_512_128 extends DigestSkein512 {
        public Digest_512_128() {
            super(128);
        }
    }

    public static class Digest_512_160 extends DigestSkein512 {
        public Digest_512_160() {
            super(160);
        }
    }

    public static class Digest_512_224 extends DigestSkein512 {
        public Digest_512_224() {
            super(224);
        }
    }

    public static class Digest_512_256 extends DigestSkein512 {
        public Digest_512_256() {
            super(256);
        }
    }

    public static class Digest_512_384 extends DigestSkein512 {
        public Digest_512_384() {
            super(384);
        }
    }

    public static class Digest_512_512 extends DigestSkein512 {
        public Digest_512_512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class HMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_1024() {
            super("HMACSkein-1024-1024", UserMetadata.MAX_ATTRIBUTE_SIZE, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_384() {
            super("HMACSkein-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_512() {
            super("HMACSkein-1024-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_128() {
            super("HMACSkein-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_160() {
            super("HMACSkein-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_224() {
            super("HMACSkein-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_256() {
            super("HMACSkein-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_128() {
            super("HMACSkein-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_160() {
            super("HMACSkein-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_224() {
            super("HMACSkein-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_256() {
            super("HMACSkein-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_384() {
            super("HMACSkein-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_512() {
            super("HMACSkein-512-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class HashMac_1024_1024 extends BaseMac {
        public HashMac_1024_1024() {
            super((Mac) new HMac(new SkeinDigest(UserMetadata.MAX_ATTRIBUTE_SIZE, UserMetadata.MAX_ATTRIBUTE_SIZE)));
        }
    }

    public static class HashMac_1024_384 extends BaseMac {
        public HashMac_1024_384() {
            super((Mac) new HMac(new SkeinDigest(UserMetadata.MAX_ATTRIBUTE_SIZE, 384)));
        }
    }

    public static class HashMac_1024_512 extends BaseMac {
        public HashMac_1024_512() {
            super((Mac) new HMac(new SkeinDigest(UserMetadata.MAX_ATTRIBUTE_SIZE, AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class HashMac_256_128 extends BaseMac {
        public HashMac_256_128() {
            super((Mac) new HMac(new SkeinDigest(256, 128)));
        }
    }

    public static class HashMac_256_160 extends BaseMac {
        public HashMac_256_160() {
            super((Mac) new HMac(new SkeinDigest(256, 160)));
        }
    }

    public static class HashMac_256_224 extends BaseMac {
        public HashMac_256_224() {
            super((Mac) new HMac(new SkeinDigest(256, 224)));
        }
    }

    public static class HashMac_256_256 extends BaseMac {
        public HashMac_256_256() {
            super((Mac) new HMac(new SkeinDigest(256, 256)));
        }
    }

    public static class HashMac_512_128 extends BaseMac {
        public HashMac_512_128() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, 128)));
        }
    }

    public static class HashMac_512_160 extends BaseMac {
        public HashMac_512_160() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, 160)));
        }
    }

    public static class HashMac_512_224 extends BaseMac {
        public HashMac_512_224() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, 224)));
        }
    }

    public static class HashMac_512_256 extends BaseMac {
        public HashMac_512_256() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, 256)));
        }
    }

    public static class HashMac_512_384 extends BaseMac {
        public HashMac_512_384() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, 384)));
        }
    }

    public static class HashMac_512_512 extends BaseMac {
        public HashMac_512_512() {
            super((Mac) new HMac(new SkeinDigest(AdRequest.MAX_CONTENT_URL_LENGTH, AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = Skein.class.getName();

        public static void d(ConfigurableProvider configurableProvider, int i, int i2) {
            String i3 = lf.i("Skein-MAC-", i, "-", i2);
            StringBuilder sb = new StringBuilder();
            String str = a;
            sb.append(str);
            sb.append("$SkeinMac_");
            sb.append(i);
            sb.append("_");
            sb.append(i2);
            configurableProvider.b("Mac." + i3, sb.toString());
            configurableProvider.b("Alg.Alias.Mac.Skein-MAC" + i + RemoteSettings.FORWARD_SLASH_STRING + i2, i3);
            StringBuilder sb2 = new StringBuilder("KeyGenerator.");
            sb2.append(i3);
            configurableProvider.b(sb2.toString(), str + "$SkeinMacKeyGenerator_" + i + "_" + i2);
            configurableProvider.b("Alg.Alias.KeyGenerator.Skein-MAC" + i + RemoteSettings.FORWARD_SLASH_STRING + i2, i3);
        }

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.Skein-256-160", xx.E(str, "$Digest_256_128", configurableProvider, "MessageDigest.Skein-256-128", "$Digest_256_160"));
            configurableProvider.b("MessageDigest.Skein-256-256", xx.E(str, "$Digest_256_224", configurableProvider, "MessageDigest.Skein-256-224", "$Digest_256_256"));
            configurableProvider.b("MessageDigest.Skein-512-160", xx.E(str, "$Digest_512_128", configurableProvider, "MessageDigest.Skein-512-128", "$Digest_512_160"));
            configurableProvider.b("MessageDigest.Skein-512-256", xx.E(str, "$Digest_512_224", configurableProvider, "MessageDigest.Skein-512-224", "$Digest_512_256"));
            configurableProvider.b("MessageDigest.Skein-512-512", xx.E(str, "$Digest_512_384", configurableProvider, "MessageDigest.Skein-512-384", "$Digest_512_512"));
            configurableProvider.b("MessageDigest.Skein-1024-512", xx.E(str, "$Digest_1024_384", configurableProvider, "MessageDigest.Skein-1024-384", "$Digest_1024_512"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-256-128", xx.E(str, "$Digest_1024_1024", configurableProvider, "MessageDigest.Skein-1024-1024", "$HashMac_256_128"), str.concat("$HMacKeyGenerator_256_128"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-256-160", str.concat("$HashMac_256_160"), str.concat("$HMacKeyGenerator_256_160"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-256-224", str.concat("$HashMac_256_224"), str.concat("$HMacKeyGenerator_256_224"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-256-256", str.concat("$HashMac_256_256"), str.concat("$HMacKeyGenerator_256_256"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-128", str.concat("$HashMac_512_128"), str.concat("$HMacKeyGenerator_512_128"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-160", str.concat("$HashMac_512_160"), str.concat("$HMacKeyGenerator_512_160"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-224", str.concat("$HashMac_512_224"), str.concat("$HMacKeyGenerator_512_224"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-256", str.concat("$HashMac_512_256"), str.concat("$HMacKeyGenerator_512_256"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-384", str.concat("$HashMac_512_384"), str.concat("$HMacKeyGenerator_512_384"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-512-512", str.concat("$HashMac_512_512"), str.concat("$HMacKeyGenerator_512_512"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-1024-384", str.concat("$HashMac_1024_384"), str.concat("$HMacKeyGenerator_1024_384"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-1024-512", str.concat("$HashMac_1024_512"), str.concat("$HMacKeyGenerator_1024_512"));
            DigestAlgorithmProvider.b(configurableProvider, "Skein-1024-1024", str.concat("$HashMac_1024_1024"), str.concat("$HMacKeyGenerator_1024_1024"));
            d(configurableProvider, 256, 128);
            d(configurableProvider, 256, 160);
            d(configurableProvider, 256, 224);
            d(configurableProvider, 256, 256);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, 128);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, 160);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, 224);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, 256);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, 384);
            d(configurableProvider, AdRequest.MAX_CONTENT_URL_LENGTH, AdRequest.MAX_CONTENT_URL_LENGTH);
            d(configurableProvider, UserMetadata.MAX_ATTRIBUTE_SIZE, 384);
            d(configurableProvider, UserMetadata.MAX_ATTRIBUTE_SIZE, AdRequest.MAX_CONTENT_URL_LENGTH);
            d(configurableProvider, UserMetadata.MAX_ATTRIBUTE_SIZE, UserMetadata.MAX_ATTRIBUTE_SIZE);
        }
    }

    public static class SkeinMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_1024() {
            super("Skein-MAC-1024-1024", UserMetadata.MAX_ATTRIBUTE_SIZE, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_384() {
            super("Skein-MAC-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_512() {
            super("Skein-MAC-1024-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_128() {
            super("Skein-MAC-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_160() {
            super("Skein-MAC-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_224() {
            super("Skein-MAC-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_256() {
            super("Skein-MAC-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_128() {
            super("Skein-MAC-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_160() {
            super("Skein-MAC-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_224() {
            super("Skein-MAC-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_256() {
            super("Skein-MAC-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_384() {
            super("Skein-MAC-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_512() {
            super("Skein-MAC-512-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class SkeinMac_1024_1024 extends BaseMac {
        public SkeinMac_1024_1024() {
            super((Mac) new SkeinMac(UserMetadata.MAX_ATTRIBUTE_SIZE, UserMetadata.MAX_ATTRIBUTE_SIZE));
        }
    }

    public static class SkeinMac_1024_384 extends BaseMac {
        public SkeinMac_1024_384() {
            super((Mac) new SkeinMac(UserMetadata.MAX_ATTRIBUTE_SIZE, 384));
        }
    }

    public static class SkeinMac_1024_512 extends BaseMac {
        public SkeinMac_1024_512() {
            super((Mac) new SkeinMac(UserMetadata.MAX_ATTRIBUTE_SIZE, AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class SkeinMac_256_128 extends BaseMac {
        public SkeinMac_256_128() {
            super((Mac) new SkeinMac(256, 128));
        }
    }

    public static class SkeinMac_256_160 extends BaseMac {
        public SkeinMac_256_160() {
            super((Mac) new SkeinMac(256, 160));
        }
    }

    public static class SkeinMac_256_224 extends BaseMac {
        public SkeinMac_256_224() {
            super((Mac) new SkeinMac(256, 224));
        }
    }

    public static class SkeinMac_256_256 extends BaseMac {
        public SkeinMac_256_256() {
            super((Mac) new SkeinMac(256, 256));
        }
    }

    public static class SkeinMac_512_128 extends BaseMac {
        public SkeinMac_512_128() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, 128));
        }
    }

    public static class SkeinMac_512_160 extends BaseMac {
        public SkeinMac_512_160() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, 160));
        }
    }

    public static class SkeinMac_512_224 extends BaseMac {
        public SkeinMac_512_224() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, 224));
        }
    }

    public static class SkeinMac_512_256 extends BaseMac {
        public SkeinMac_512_256() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, 256));
        }
    }

    public static class SkeinMac_512_384 extends BaseMac {
        public SkeinMac_512_384() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, 384));
        }
    }

    public static class SkeinMac_512_512 extends BaseMac {
        public SkeinMac_512_512() {
            super((Mac) new SkeinMac(AdRequest.MAX_CONTENT_URL_LENGTH, AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    private Skein() {
    }
}
