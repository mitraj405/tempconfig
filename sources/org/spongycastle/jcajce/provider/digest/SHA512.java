package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.OldHMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA512 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA512Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA512Digest((SHA512Digest) this.a);
            return digest;
        }
    }

    public static class DigestT extends BCMessageDigest implements Cloneable {
        public DigestT(int i) {
            super(new SHA512tDigest(i));
        }

        public final Object clone() throws CloneNotSupportedException {
            DigestT digestT = (DigestT) super.clone();
            digestT.a = new SHA512tDigest((SHA512tDigest) this.a);
            return digestT;
        }
    }

    public static class DigestT224 extends DigestT {
        public DigestT224() {
            super(224);
        }
    }

    public static class DigestT256 extends DigestT {
        public DigestT256() {
            super(256);
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new SHA512Digest()));
        }
    }

    public static class HashMacT224 extends BaseMac {
        public HashMacT224() {
            super((Mac) new HMac(new SHA512tDigest(224)));
        }
    }

    public static class HashMacT256 extends BaseMac {
        public HashMacT256() {
            super((Mac) new HMac(new SHA512tDigest(256)));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA512", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT224 extends BaseKeyGenerator {
        public KeyGeneratorT224() {
            super("HMACSHA512/224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT256 extends BaseKeyGenerator {
        public KeyGeneratorT256() {
            super("HMACSHA512/256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA512.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA-512", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA512", "SHA-512");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), NISTObjectIdentifiers.c, configurableProvider, "SHA-512");
            configurableProvider.b("MessageDigest.SHA-512/224", str.concat("$DigestT224"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), NISTObjectIdentifiers.e, configurableProvider, "SHA-512/224");
            configurableProvider.b("MessageDigest.SHA-512/256", str.concat("$DigestT256"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA512256", "SHA-512/256");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), NISTObjectIdentifiers.f, configurableProvider, "SHA-512/256");
            configurableProvider.b("Mac.PBEWITHHMACSHA512", xx.E(str, "$OldSHA512", configurableProvider, "Mac.OLDHMACSHA512", "$HashMac"));
            DigestAlgorithmProvider.b(configurableProvider, "SHA512", str.concat("$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("SHA512", PKCSObjectIdentifiers.I, configurableProvider);
            DigestAlgorithmProvider.b(configurableProvider, "SHA512/224", str.concat("$HashMacT224"), str.concat("$KeyGeneratorT224"));
            DigestAlgorithmProvider.b(configurableProvider, "SHA512/256", str.concat("$HashMacT256"), str.concat("$KeyGeneratorT256"));
        }
    }

    public static class OldSHA512 extends BaseMac {
        public OldSHA512() {
            super((Mac) new OldHMac(new SHA512Digest()));
        }
    }

    private SHA512() {
    }
}
