package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class RIPEMD160 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD160Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD160Digest((RIPEMD160Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new RIPEMD160Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD160", 160, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = RIPEMD160.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            C1058d.I(lf.o(str, "$Digest", configurableProvider, "MessageDigest.RIPEMD160", "Alg.Alias.MessageDigest."), TeleTrusTObjectIdentifiers.a, configurableProvider, "RIPEMD160");
            DigestAlgorithmProvider.b(configurableProvider, "RIPEMD160", str.concat("$HashMac"), str.concat("$KeyGenerator"));
            DigestAlgorithmProvider.c("RIPEMD160", IANAObjectIdentifiers.d, configurableProvider);
            configurableProvider.b("Mac.PBEWITHHMACRIPEMD160", xx.E(str, "$PBEWithHmacKeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHHMACRIPEMD160", "$PBEWithHmac"));
        }
    }

    public static class PBEWithHmac extends BaseMac {
        public PBEWithHmac() {
            super(new HMac(new RIPEMD160Digest()));
        }
    }

    public static class PBEWithHmacKeyFactory extends PBESecretKeyFactory {
        public PBEWithHmacKeyFactory() {
            super("PBEwithHmacRIPEMD160", (ASN1ObjectIdentifier) null, false, 2, 2, 160, 0);
        }
    }

    private RIPEMD160() {
    }
}
