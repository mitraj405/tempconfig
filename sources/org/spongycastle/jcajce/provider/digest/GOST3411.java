package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.GOST3411_2012_256Digest;
import org.spongycastle.crypto.digests.GOST3411_2012_512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class GOST3411 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new GOST3411Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new GOST3411Digest((GOST3411Digest) this.a);
            return digest;
        }
    }

    public static class Digest2012_256 extends BCMessageDigest implements Cloneable {
        public Digest2012_256() {
            super(new GOST3411_2012_256Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest2012_256 digest2012_256 = (Digest2012_256) super.clone();
            digest2012_256.a = new GOST3411_2012_256Digest((GOST3411_2012_256Digest) this.a);
            return digest2012_256;
        }
    }

    public static class Digest2012_512 extends BCMessageDigest implements Cloneable {
        public Digest2012_512() {
            super(new GOST3411_2012_512Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest2012_512 digest2012_512 = (Digest2012_512) super.clone();
            digest2012_512.a = new GOST3411_2012_512Digest((GOST3411_2012_512Digest) this.a);
            return digest2012_512;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new GOST3411Digest()));
        }
    }

    public static class HashMac2012_256 extends BaseMac {
        public HashMac2012_256() {
            super((Mac) new HMac(new GOST3411_2012_256Digest()));
        }
    }

    public static class HashMac2012_512 extends BaseMac {
        public HashMac2012_512() {
            super((Mac) new HMac(new GOST3411_2012_512Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator2012_256 extends BaseKeyGenerator {
        public KeyGenerator2012_256() {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator2012_512 extends BaseKeyGenerator {
        public KeyGenerator2012_512() {
            super("HMACGOST3411", AdRequest.MAX_CONTENT_URL_LENGTH, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = GOST3411.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.GOST3411", str.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.GOST", "GOST3411");
            configurableProvider.b("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
            StringBuilder sb = new StringBuilder("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.a;
            C1058d.I(sb, aSN1ObjectIdentifier, configurableProvider, "GOST3411");
            DigestAlgorithmProvider.b(configurableProvider, "GOST3411", str.concat("$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("GOST3411", aSN1ObjectIdentifier, configurableProvider);
            configurableProvider.b("MessageDigest.GOST3411-2012-256", str.concat("$Digest2012_256"));
            configurableProvider.b("Alg.Alias.MessageDigest.GOST-2012-256", "GOST3411-2012-256");
            configurableProvider.b("Alg.Alias.MessageDigest.GOST-3411-2012-256", "GOST3411-2012-256");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), RosstandartObjectIdentifiers.a, configurableProvider, "GOST3411-2012-256");
            DigestAlgorithmProvider.b(configurableProvider, "GOST3411-2012-256", str.concat("$HashMac2012_256"), str.concat("$KeyGenerator2012_256"));
            DigestAlgorithmProvider.c("GOST3411-2012-256", RosstandartObjectIdentifiers.c, configurableProvider);
            configurableProvider.b("MessageDigest.GOST3411-2012-512", str.concat("$Digest2012_512"));
            configurableProvider.b("Alg.Alias.MessageDigest.GOST-2012-512", "GOST3411-2012-512");
            configurableProvider.b("Alg.Alias.MessageDigest.GOST-3411-2012-512", "GOST3411-2012-512");
            C1058d.I(new StringBuilder("Alg.Alias.MessageDigest."), RosstandartObjectIdentifiers.b, configurableProvider, "GOST3411-2012-512");
            DigestAlgorithmProvider.b(configurableProvider, "GOST3411-2012-512", str.concat("$HashMac2012_512"), str.concat("$KeyGenerator2012_512"));
            DigestAlgorithmProvider.c("GOST3411-2012-512", RosstandartObjectIdentifiers.d, configurableProvider);
            C1058d.I(lf.o(str, "$PBEWithMacKeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHHMACGOST3411", "Alg.Alias.SecretKeyFactory."), aSN1ObjectIdentifier, configurableProvider, "PBEWITHHMACGOST3411");
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacGOST3411", (ASN1ObjectIdentifier) null, false, 2, 6, 256, 0);
        }
    }

    private GOST3411() {
    }
}
