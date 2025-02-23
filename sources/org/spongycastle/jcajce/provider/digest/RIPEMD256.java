package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.RIPEMD256Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class RIPEMD256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD256Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD256Digest((RIPEMD256Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new RIPEMD256Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = RIPEMD256.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            C1058d.I(lf.o(str, "$Digest", configurableProvider, "MessageDigest.RIPEMD256", "Alg.Alias.MessageDigest."), TeleTrusTObjectIdentifiers.c, configurableProvider, "RIPEMD256");
            DigestAlgorithmProvider.b(configurableProvider, "RIPEMD256", str.concat("$HashMac"), str.concat("$KeyGenerator"));
        }
    }

    private RIPEMD256() {
    }
}
