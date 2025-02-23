package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.DSTU7564Digest;
import org.spongycastle.crypto.macs.DSTU7564Mac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class DSTU7564 {

    public static class Digest256 extends DigestDSTU7564 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestDSTU7564 {
        public Digest384() {
            super(384);
        }
    }

    public static class Digest512 extends DigestDSTU7564 {
        public Digest512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class DigestDSTU7564 extends BCMessageDigest implements Cloneable {
        public DigestDSTU7564(int i) {
            super(new DSTU7564Digest(i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new DSTU7564Digest((DSTU7564Digest) this.a);
            return bCMessageDigest;
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super((Mac) new DSTU7564Mac(256));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super((Mac) new DSTU7564Mac(384));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super((Mac) new DSTU7564Mac(AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACDSTU7564-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACDSTU7564-384", 384, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACDSTU7564-512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = DSTU7564.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.DSTU7564-384", xx.E(str, "$Digest256", configurableProvider, "MessageDigest.DSTU7564-256", "$Digest384"));
            configurableProvider.b("MessageDigest.DSTU7564-512", str.concat("$Digest512"));
            configurableProvider.c("MessageDigest", UAObjectIdentifiers.c, str.concat("$Digest256"));
            configurableProvider.c("MessageDigest", UAObjectIdentifiers.d, str.concat("$Digest384"));
            configurableProvider.c("MessageDigest", UAObjectIdentifiers.e, str.concat("$Digest512"));
            DigestAlgorithmProvider.b(configurableProvider, "DSTU7564-256", str.concat("$HashMac256"), str.concat("$KeyGenerator256"));
            DigestAlgorithmProvider.b(configurableProvider, "DSTU7564-384", str.concat("$HashMac384"), str.concat("$KeyGenerator384"));
            DigestAlgorithmProvider.b(configurableProvider, "DSTU7564-512", str.concat("$HashMac512"), str.concat("$KeyGenerator512"));
            DigestAlgorithmProvider.c("DSTU7564-256", UAObjectIdentifiers.f, configurableProvider);
            DigestAlgorithmProvider.c("DSTU7564-384", UAObjectIdentifiers.g, configurableProvider);
            DigestAlgorithmProvider.c("DSTU7564-512", UAObjectIdentifiers.h, configurableProvider);
        }
    }

    private DSTU7564() {
    }
}
