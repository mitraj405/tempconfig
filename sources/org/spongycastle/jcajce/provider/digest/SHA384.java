package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.OldHMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA384 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA384Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA384Digest((SHA384Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new SHA384Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA384", 384, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA384.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA-384", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA384", "SHA-384");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), NISTObjectIdentifiers.b, configurableProvider, "SHA-384");
            configurableProvider.b("Mac.PBEWITHHMACSHA384", xx.E(str, "$OldSHA384", configurableProvider, "Mac.OLDHMACSHA384", "$HashMac"));
            DigestAlgorithmProvider.b(configurableProvider, "SHA384", str.concat("$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("SHA384", PKCSObjectIdentifiers.H, configurableProvider);
        }
    }

    public static class OldSHA384 extends BaseMac {
        public OldSHA384() {
            super((Mac) new OldHMac(new SHA384Digest()));
        }
    }

    private SHA384() {
    }
}
