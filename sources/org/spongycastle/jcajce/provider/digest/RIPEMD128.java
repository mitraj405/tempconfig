package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class RIPEMD128 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD128Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD128Digest((RIPEMD128Digest) this.a);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super((Mac) new HMac(new RIPEMD128Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = RIPEMD128.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            C1058d.I(lf.o(str, "$Digest", configurableProvider, "MessageDigest.RIPEMD128", "Alg.Alias.MessageDigest."), TeleTrusTObjectIdentifiers.b, configurableProvider, "RIPEMD128");
            DigestAlgorithmProvider.b(configurableProvider, "RIPEMD128", str.concat("$HashMac"), str.concat("$KeyGenerator"));
        }
    }

    private RIPEMD128() {
    }
}
