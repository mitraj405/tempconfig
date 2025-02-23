package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.PasswordConverter;
import org.spongycastle.jcajce.PBKDF2Key;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;

public class PBEPBKDF2 {
    public static final HashMap a;

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        public final int c;
        public final int d;

        public BasePBKDF2() {
            throw null;
        }

        public BasePBKDF2(int i, int i2) {
            super("PBKDF2", PKCSObjectIdentifiers.x);
            this.c = i;
            this.d = i2;
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            PasswordConverter passwordConverter;
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                byte[] salt = pBEKeySpec.getSalt();
                int i = this.c;
                if (salt == null) {
                    char[] password = pBEKeySpec.getPassword();
                    if (i == 1) {
                        passwordConverter = PasswordConverter.a;
                    } else {
                        passwordConverter = PasswordConverter.b;
                    }
                    return new PBKDF2Key(password, passwordConverter);
                } else if (pBEKeySpec.getIterationCount() <= 0) {
                    throw new InvalidKeySpecException("positive iteration count required: " + pBEKeySpec.getIterationCount());
                } else if (pBEKeySpec.getKeyLength() <= 0) {
                    throw new InvalidKeySpecException("positive key length required: " + pBEKeySpec.getKeyLength());
                } else if (pBEKeySpec.getPassword().length == 0) {
                    throw new IllegalArgumentException("password empty");
                } else if (pBEKeySpec instanceof PBKDF2KeySpec) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = ((PBKDF2KeySpec) pBEKeySpec).a.Z0;
                    Integer num = (Integer) PBEPBKDF2.a.get(aSN1ObjectIdentifier);
                    if (num != null) {
                        int intValue = num.intValue();
                        int keyLength = pBEKeySpec.getKeyLength();
                        return new BCPBEKey(this.c, this.Z0, this.c, intValue, keyLength, -1, pBEKeySpec, PBE.Util.c(pBEKeySpec, i, intValue, keyLength));
                    }
                    throw new InvalidKeySpecException("Invalid KeySpec: unknown PRF algorithm " + aSN1ObjectIdentifier);
                } else {
                    int i2 = this.d;
                    int keyLength2 = pBEKeySpec.getKeyLength();
                    return new BCPBEKey(this.c, this.Z0, this.c, i2, keyLength2, -1, pBEKeySpec, PBE.Util.c(pBEKeySpec, i, i2, keyLength2));
                }
            } else {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = PBEPBKDF2.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            StringBuilder o = lf.o(str, "$AlgParams", configurableProvider, "AlgorithmParameters.PBKDF2", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.x;
            C1058d.I(o, aSN1ObjectIdentifier, configurableProvider, "PBKDF2");
            configurableProvider.b("SecretKeyFactory.PBKDF2", str.concat("$PBKDF2withUTF8"));
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1", "PBKDF2");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
            configurableProvider.b("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "PBKDF2");
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHASCII", str.concat("$PBKDF2with8BIT"));
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII");
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHHMACSHA256", xx.E(str, "$PBKDF2withSHA224", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA224", "$PBKDF2withSHA256"));
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHHMACSHA512", xx.E(str, "$PBKDF2withSHA384", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA384", "$PBKDF2withSHA512"));
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHHMACSHA3-256", xx.E(str, "$PBKDF2withSHA3_224", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-224", "$PBKDF2withSHA3_256"));
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHHMACSHA3-512", xx.E(str, "$PBKDF2withSHA3_384", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-384", "$PBKDF2withSHA3_512"));
            configurableProvider.b("SecretKeyFactory.PBKDF2WITHHMACGOST3411", str.concat("$PBKDF2withGOST3411"));
        }
    }

    public static class PBKDF2with8BIT extends BasePBKDF2 {
        public PBKDF2with8BIT() {
            super(1, 1);
        }
    }

    public static class PBKDF2withGOST3411 extends BasePBKDF2 {
        public PBKDF2withGOST3411() {
            super(5, 6);
        }
    }

    public static class PBKDF2withSHA224 extends BasePBKDF2 {
        public PBKDF2withSHA224() {
            super(5, 7);
        }
    }

    public static class PBKDF2withSHA256 extends BasePBKDF2 {
        public PBKDF2withSHA256() {
            super(5, 4);
        }
    }

    public static class PBKDF2withSHA384 extends BasePBKDF2 {
        public PBKDF2withSHA384() {
            super(5, 8);
        }
    }

    public static class PBKDF2withSHA3_224 extends BasePBKDF2 {
        public PBKDF2withSHA3_224() {
            super(5, 10);
        }
    }

    public static class PBKDF2withSHA3_256 extends BasePBKDF2 {
        public PBKDF2withSHA3_256() {
            super(5, 11);
        }
    }

    public static class PBKDF2withSHA3_384 extends BasePBKDF2 {
        public PBKDF2withSHA3_384() {
            super(5, 12);
        }
    }

    public static class PBKDF2withSHA3_512 extends BasePBKDF2 {
        public PBKDF2withSHA3_512() {
            super(5, 13);
        }
    }

    public static class PBKDF2withSHA512 extends BasePBKDF2 {
        public PBKDF2withSHA512() {
            super(5, 9);
        }
    }

    public static class PBKDF2withUTF8 extends BasePBKDF2 {
        public PBKDF2withUTF8() {
            super(5, 1);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(CryptoProObjectIdentifiers.b, 6);
        hashMap.put(PKCSObjectIdentifiers.E, 1);
        hashMap.put(PKCSObjectIdentifiers.G, 4);
        hashMap.put(PKCSObjectIdentifiers.F, 7);
        hashMap.put(PKCSObjectIdentifiers.H, 8);
        hashMap.put(PKCSObjectIdentifiers.I, 9);
        hashMap.put(NISTObjectIdentifiers.n, 11);
        hashMap.put(NISTObjectIdentifiers.m, 10);
        hashMap.put(NISTObjectIdentifiers.o, 12);
        hashMap.put(NISTObjectIdentifiers.p, 13);
    }

    private PBEPBKDF2() {
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public PBKDF2Params a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.a.f5696a.s(), this.a.a.t().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
        }

        public final byte[] engineGetEncoded() {
            try {
                return this.a.f("DER");
            } catch (IOException e) {
                throw new RuntimeException("Oooops! " + e.toString());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.a = new PBKDF2Params(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount(), 0, (AlgorithmIdentifier) null);
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
        }

        public final String engineToString() {
            return "PBKDF2 Parameters";
        }

        public final byte[] engineGetEncoded(String str) {
            if (BaseAlgorithmParameters.a(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        public final void engineInit(byte[] bArr) throws IOException {
            this.a = PBKDF2Params.g(ASN1Primitive.k(bArr));
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }
    }
}
