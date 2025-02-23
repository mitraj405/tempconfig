package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA3 {

    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(384);
        }
    }

    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int i) {
            super(new SHA3Digest(i));
        }

        public final Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.a = new SHA3Digest((SHA3Digest) this.a);
            return bCMessageDigest;
        }
    }

    public static class HashMac224 extends HashMacSHA3 {
        public HashMac224() {
            super(224);
        }
    }

    public static class HashMac256 extends HashMacSHA3 {
        public HashMac256() {
            super(256);
        }
    }

    public static class HashMac384 extends HashMacSHA3 {
        public HashMac384() {
            super(384);
        }
    }

    public static class HashMac512 extends HashMacSHA3 {
        public HashMac512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class HashMacSHA3 extends BaseMac {
        public HashMacSHA3(int i) {
            super((Mac) new HMac(new SHA3Digest(i)));
        }
    }

    public static class KeyGenerator224 extends KeyGeneratorSHA3 {
        public KeyGenerator224() {
            super(224);
        }
    }

    public static class KeyGenerator256 extends KeyGeneratorSHA3 {
        public KeyGenerator256() {
            super(256);
        }
    }

    public static class KeyGenerator384 extends KeyGeneratorSHA3 {
        public KeyGenerator384() {
            super(384);
        }
    }

    public static class KeyGenerator512 extends KeyGeneratorSHA3 {
        public KeyGenerator512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class KeyGeneratorSHA3 extends BaseKeyGenerator {
        public KeyGeneratorSHA3(int i) {
            super(lf.h("HMACSHA3-", i), i, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = SHA3.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("MessageDigest.SHA3-256", xx.E(str, "$Digest224", configurableProvider, "MessageDigest.SHA3-224", "$Digest256"));
            configurableProvider.b("MessageDigest.SHA3-512", xx.E(str, "$Digest384", configurableProvider, "MessageDigest.SHA3-384", "$Digest512"));
            configurableProvider.c("MessageDigest", NISTObjectIdentifiers.g, str.concat("$Digest224"));
            configurableProvider.c("MessageDigest", NISTObjectIdentifiers.h, str.concat("$Digest256"));
            configurableProvider.c("MessageDigest", NISTObjectIdentifiers.i, str.concat("$Digest384"));
            configurableProvider.c("MessageDigest", NISTObjectIdentifiers.j, str.concat("$Digest512"));
            DigestAlgorithmProvider.b(configurableProvider, "SHA3-224", str.concat("$HashMac224"), str.concat("$KeyGenerator224"));
            DigestAlgorithmProvider.c("SHA3-224", NISTObjectIdentifiers.m, configurableProvider);
            DigestAlgorithmProvider.b(configurableProvider, "SHA3-256", str.concat("$HashMac256"), str.concat("$KeyGenerator256"));
            DigestAlgorithmProvider.c("SHA3-256", NISTObjectIdentifiers.n, configurableProvider);
            DigestAlgorithmProvider.b(configurableProvider, "SHA3-384", str.concat("$HashMac384"), str.concat("$KeyGenerator384"));
            DigestAlgorithmProvider.c("SHA3-384", NISTObjectIdentifiers.o, configurableProvider);
            DigestAlgorithmProvider.b(configurableProvider, "SHA3-512", str.concat("$HashMac512"), str.concat("$KeyGenerator512"));
            DigestAlgorithmProvider.c("SHA3-512", NISTObjectIdentifiers.p, configurableProvider);
        }
    }

    private SHA3() {
    }
}
