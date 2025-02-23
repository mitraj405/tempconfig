package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.TLSKeyMaterialSpec;
import org.spongycastle.util.Strings;

public class TLSKDF {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = TLSKDF.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("SecretKeyFactory.TLS11KDF", xx.E(str, "$TLS10", configurableProvider, "SecretKeyFactory.TLS10KDF", "$TLS11"));
            configurableProvider.b("SecretKeyFactory.TLS12WITHSHA384KDF", xx.E(str, "$TLS12withSHA256", configurableProvider, "SecretKeyFactory.TLS12WITHSHA256KDF", "$TLS12withSHA384"));
            configurableProvider.b("SecretKeyFactory.TLS12WITHSHA512KDF", str.concat("$TLS12withSHA512"));
        }
    }

    public static final class TLS10 extends TLSKeyMaterialFactory {
        public TLS10() {
            super("TLS10KDF");
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                new HMac(new MD5Digest());
                new HMac(new SHA1Digest());
                ((TLSKeyMaterialSpec) keySpec).getClass();
                Strings.d((String) null);
                throw null;
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS11 extends TLSKeyMaterialFactory {
        public TLS11() {
            super("TLS11KDF");
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                new HMac(new MD5Digest());
                new HMac(new SHA1Digest());
                ((TLSKeyMaterialSpec) keySpec).getClass();
                Strings.d((String) null);
                throw null;
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class TLS12 extends TLSKeyMaterialFactory {
        public final Mac a;

        public TLS12(String str, HMac hMac) {
            super(str);
            this.a = hMac;
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                ((TLSKeyMaterialSpec) keySpec).getClass();
                Strings.d((String) null);
                throw null;
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS12withSHA256 extends TLS12 {
        public TLS12withSHA256() {
            super("TLS12withSHA256KDF", new HMac(new SHA256Digest()));
        }
    }

    public static final class TLS12withSHA384 extends TLS12 {
        public TLS12withSHA384() {
            super("TLS12withSHA384KDF", new HMac(new SHA384Digest()));
        }
    }

    public static final class TLS12withSHA512 extends TLS12 {
        public TLS12withSHA512() {
            super("TLS12withSHA512KDF", new HMac(new SHA512Digest()));
        }
    }

    public static class TLSKeyMaterialFactory extends BaseSecretKeyFactory {
        public TLSKeyMaterialFactory(String str) {
            super(str, (ASN1ObjectIdentifier) null);
        }
    }
}
