package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public class SM3 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SM3Digest());
        }

        public final Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.a = new SM3Digest((SM3Digest) this.a);
            return digest;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SM3.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("MessageDigest.SM3", a.concat("$Digest"));
            configurableProvider.b("Alg.Alias.MessageDigest.SM3", "SM3");
            configurableProvider.b("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
        }
    }

    private SM3() {
    }
}
