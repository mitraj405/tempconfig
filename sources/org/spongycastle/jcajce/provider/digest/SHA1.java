package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class SHA1 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA1Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA1Digest((SHA1Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new SHA1Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA1", 160, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA1.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA-1", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            configurableProvider.b("Alg.Alias.MessageDigest.SHA", "SHA-1");
            StringBuilder sb = new StringBuilder("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f;
            C1058d.I(sb, aSN1ObjectIdentifier, configurableProvider, "SHA-1");
            DigestAlgorithmProvider.b(configurableProvider, "SHA1", str.concat("$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("SHA1", PKCSObjectIdentifiers.E, configurableProvider);
            DigestAlgorithmProvider.c("SHA1", IANAObjectIdentifiers.b, configurableProvider);
            configurableProvider.b("Mac.PBEWITHHMACSHA1", xx.E(str, "$SHA1Mac", configurableProvider, "Mac.PBEWITHHMACSHA", "$SHA1Mac"));
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            configurableProvider.b("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "PBEWITHHMACSHA1");
            C1058d.I(new StringBuilder("Alg.Alias.Mac."), aSN1ObjectIdentifier, configurableProvider, "PBEWITHHMACSHA");
            configurableProvider.b("SecretKeyFactory.PBEWITHHMACSHA1", str.concat("$PBEWithMacKeyFactory"));
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA", (ASN1ObjectIdentifier) null, false, 2, 1, 160, 0);
        }
    }

    public static class SHA1Mac extends BaseMac {
        public SHA1Mac() {
            super((Mac) new HMac(new SHA1Digest()));
        }
    }

    private SHA1() {
    }
}
