package org.spongycastle.jcajce.provider.digest;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.digests.Blake2bDigest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public class Blake2b {

    public static class Blake2b160 extends BCMessageDigest implements Cloneable {
        public Blake2b160() {
            super(new Blake2bDigest(160));
        }

        public final Object clone() throws CloneNotSupportedException {
            Blake2b160 blake2b160 = (Blake2b160) super.clone();
            blake2b160.a = new Blake2bDigest((Blake2bDigest) this.a);
            return blake2b160;
        }
    }

    public static class Blake2b256 extends BCMessageDigest implements Cloneable {
        public Blake2b256() {
            super(new Blake2bDigest(256));
        }

        public final Object clone() throws CloneNotSupportedException {
            Blake2b256 blake2b256 = (Blake2b256) super.clone();
            blake2b256.a = new Blake2bDigest((Blake2bDigest) this.a);
            return blake2b256;
        }
    }

    public static class Blake2b384 extends BCMessageDigest implements Cloneable {
        public Blake2b384() {
            super(new Blake2bDigest(384));
        }

        public final Object clone() throws CloneNotSupportedException {
            Blake2b384 blake2b384 = (Blake2b384) super.clone();
            blake2b384.a = new Blake2bDigest((Blake2bDigest) this.a);
            return blake2b384;
        }
    }

    public static class Blake2b512 extends BCMessageDigest implements Cloneable {
        public Blake2b512() {
            super(new Blake2bDigest((int) AdRequest.MAX_CONTENT_URL_LENGTH));
        }

        public final Object clone() throws CloneNotSupportedException {
            Blake2b512 blake2b512 = (Blake2b512) super.clone();
            blake2b512.a = new Blake2bDigest((Blake2bDigest) this.a);
            return blake2b512;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        public static final String a = Blake2b.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            C1058d.I(lf.o(str, "$Blake2b512", configurableProvider, "MessageDigest.BLAKE2B-512", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.m, configurableProvider, "BLAKE2B-512");
            C1058d.I(lf.o(str, "$Blake2b384", configurableProvider, "MessageDigest.BLAKE2B-384", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.l, configurableProvider, "BLAKE2B-384");
            C1058d.I(lf.o(str, "$Blake2b256", configurableProvider, "MessageDigest.BLAKE2B-256", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.k, configurableProvider, "BLAKE2B-256");
            C1058d.I(lf.o(str, "$Blake2b160", configurableProvider, "MessageDigest.BLAKE2B-160", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.j, configurableProvider, "BLAKE2B-160");
        }
    }

    private Blake2b() {
    }
}
