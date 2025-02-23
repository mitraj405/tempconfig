package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class SHA256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA256Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA256Digest((SHA256Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new SHA256Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA256.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA-256", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SHA256", "SHA-256");
            StringBuilder sb = new StringBuilder("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.a;
            C1058d.I(sb, aSN1ObjectIdentifier, configurableProvider, "SHA-256");
            configurableProvider.b("SecretKeyFactory.PBEWITHHMACSHA256", str.concat("$PBEWithMacKeyFactory"));
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            configurableProvider.b("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "PBEWITHHMACSHA256");
            DigestAlgorithmProvider.b(configurableProvider, "SHA256", xx.E(str, "$HashMac", configurableProvider, "Mac.PBEWITHHMACSHA256", "$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("SHA256", PKCSObjectIdentifiers.G, configurableProvider);
            DigestAlgorithmProvider.c("SHA256", aSN1ObjectIdentifier, configurableProvider);
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA256", (ASN1ObjectIdentifier) null, false, 2, 4, 256, 0);
        }
    }

    private SHA256() {
    }
}
