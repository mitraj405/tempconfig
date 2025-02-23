package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.util.Strings;

public final class OpenSSLPBKDF {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = OpenSSLPBKDF.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("SecretKeyFactory.PBKDF-OPENSSL", a.concat("$PBKDF"));
        }
    }

    public static class PBKDF extends BaseSecretKeyFactory {
        public PBKDF() {
            super("PBKDF-OpenSSL", (ASN1ObjectIdentifier) null);
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    throw new InvalidKeySpecException("missing required salt");
                } else if (pBEKeySpec.getIterationCount() <= 0) {
                    throw new InvalidKeySpecException("positive iteration count required: " + pBEKeySpec.getIterationCount());
                } else if (pBEKeySpec.getKeyLength() <= 0) {
                    throw new InvalidKeySpecException("positive key length required: " + pBEKeySpec.getKeyLength());
                } else if (pBEKeySpec.getPassword().length != 0) {
                    OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
                    char[] password = pBEKeySpec.getPassword();
                    String str = Strings.a;
                    int length = password.length;
                    byte[] bArr = new byte[length];
                    for (int i = 0; i != length; i++) {
                        bArr[i] = (byte) password[i];
                    }
                    openSSLPBEParametersGenerator.f(bArr, 1, pBEKeySpec.getSalt());
                    return new SecretKeySpec(openSSLPBEParametersGenerator.d(pBEKeySpec.getKeyLength()).a, "OpenSSLPBKDF");
                } else {
                    throw new IllegalArgumentException("password empty");
                }
            } else {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }
    }

    private OpenSSLPBKDF() {
    }
}
