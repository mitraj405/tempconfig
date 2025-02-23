package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA224 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA224Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA224Digest((SHA224Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new SHA224Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA224", 224, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA224.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA-224", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA224", "SHA-224");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), NISTObjectIdentifiers.d, configurableProvider, "SHA-224");
            DigestAlgorithmProvider.b(configurableProvider, "SHA224", xx.E(str, "$HashMac", configurableProvider, "Mac.PBEWITHHMACSHA224", "$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("SHA224", PKCSObjectIdentifiers.F, configurableProvider);
        }
    }

    private SHA224() {
    }
}
