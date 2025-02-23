package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.PasswordConverter;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.ISO9797Alg3Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.PBKDF1Key;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DES {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("DES");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new DESEngine()), 64);
        }
    }

    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super((Mac) new CBCBlockCipherMac(new DESEngine()));
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super((Mac) new CMac(new DESEngine()));
        }
    }

    public static class DES64 extends BaseMac {
        public DES64() {
            super((Mac) new CBCBlockCipherMac(new DESEngine(), 64, (ISO7816d4Padding) null));
        }
    }

    public static class DES64with7816d4 extends BaseMac {
        public DES64with7816d4() {
            super((Mac) new CBCBlockCipherMac(new DESEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DES9797Alg3 extends BaseMac {
        public DES9797Alg3() {
            super((Mac) new ISO9797Alg3Mac(new DESEngine(), 64, (ISO7816d4Padding) null));
        }
    }

    public static class DES9797Alg3with7816d4 extends BaseMac {
        public DES9797Alg3with7816d4() {
            super((Mac) new ISO9797Alg3Mac(new DESEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DESCFB8 extends BaseMac {
        public DESCFB8() {
            super((Mac) new CFBBlockCipherMac(new DESEngine()));
        }
    }

    public static class DESPBEKeyFactory extends BaseSecretKeyFactory {
        public final boolean a = true;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public DESPBEKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, int i3) {
            super(str, aSN1ObjectIdentifier);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = 64;
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            CipherParameters cipherParameters;
            KeyParameter keyParameter;
            PasswordConverter passwordConverter;
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                byte[] salt = pBEKeySpec.getSalt();
                int i = this.c;
                if (salt != null) {
                    boolean z = this.a;
                    int i2 = this.e;
                    int i3 = this.d;
                    if (z) {
                        cipherParameters = PBE.Util.d(pBEKeySpec, i, i3, i2, this.f);
                    } else {
                        cipherParameters = PBE.Util.c(pBEKeySpec, i, i3, i2);
                    }
                    CipherParameters cipherParameters2 = cipherParameters;
                    if (cipherParameters2 instanceof ParametersWithIV) {
                        keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters2).a;
                    } else {
                        keyParameter = (KeyParameter) cipherParameters2;
                    }
                    DESParameters.b(keyParameter.a);
                    return new BCPBEKey(this.c, this.Z0, this.c, this.d, this.e, this.f, pBEKeySpec, cipherParameters2);
                } else if (i != 0 && i != 4) {
                    return new BCPBEKey(this.c, this.Z0, i, this.d, this.e, this.f, pBEKeySpec, (CipherParameters) null);
                } else {
                    char[] password = pBEKeySpec.getPassword();
                    if (i == 0) {
                        passwordConverter = PasswordConverter.a;
                    } else {
                        passwordConverter = PasswordConverter.b;
                    }
                    return new PBKDF1Key(password, passwordConverter);
                }
            } else {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new DESEngine());
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("DES", (ASN1ObjectIdentifier) null);
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DESKeySpec) {
                return new SecretKeySpec(((DESKeySpec) keySpec).getKey(), "DES");
            }
            return super.engineGenerateSecret(keySpec);
        }

        public final KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException {
            if (cls == null) {
                throw new InvalidKeySpecException("keySpec parameter is null");
            } else if (secretKey == null) {
                throw new InvalidKeySpecException("key parameter is null");
            } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
                return new SecretKeySpec(secretKey.getEncoded(), this.c);
            } else {
                if (DESKeySpec.class.isAssignableFrom(cls)) {
                    try {
                        return new DESKeySpec(secretKey.getEncoded());
                    } catch (Exception e) {
                        throw new InvalidKeySpecException(e.toString());
                    }
                } else {
                    throw new InvalidKeySpecException("Invalid KeySpec");
                }
            }
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("DES", 64, new DESKeyGenerator());
        }

        public final SecretKey engineGenerateKey() {
            boolean z = this.f6554a;
            CipherKeyGenerator cipherKeyGenerator = this.f6553a;
            if (z) {
                cipherKeyGenerator.b(new KeyGenerationParameters(this.a, new SecureRandom()));
                this.f6554a = false;
            }
            return new SecretKeySpec(cipherKeyGenerator.a(), this.f6552a);
        }

        public final void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = DES.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Cipher.DES", str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.b;
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider.b("Alg.Alias.KeyGenerator." + aSN1ObjectIdentifier.c, "DES");
            configurableProvider.b("Alg.Alias.KeyFactory." + aSN1ObjectIdentifier.c, "DES");
            configurableProvider.b("KeyGenerator.DES", xx.E(str, "$RFC3211", configurableProvider, "Cipher.DESRFC3211WRAP", "$KeyGenerator"));
            configurableProvider.b("Mac.DESCMAC", xx.E(str, "$KeyFactory", configurableProvider, "SecretKeyFactory.DES", "$CMAC"));
            configurableProvider.b("Mac.DESMAC", str.concat("$CBCMAC"));
            configurableProvider.b("Alg.Alias.Mac.DES", "DESMAC");
            configurableProvider.b("Mac.DESMAC/CFB8", str.concat("$DESCFB8"));
            configurableProvider.b("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
            configurableProvider.b("Mac.DESMAC64", str.concat("$DES64"));
            configurableProvider.b("Alg.Alias.Mac.DES64", "DESMAC64");
            configurableProvider.b("Mac.DESMAC64WITHISO7816-4PADDING", str.concat("$DES64with7816d4"));
            configurableProvider.b("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableProvider.b("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableProvider.b("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableProvider.b("Mac.DESWITHISO9797", str.concat("$DES9797Alg3"));
            configurableProvider.b("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
            configurableProvider.b("Mac.ISO9797ALG3MAC", str.concat("$DES9797Alg3"));
            configurableProvider.b("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
            configurableProvider.b("Mac.ISO9797ALG3WITHISO7816-4PADDING", str.concat("$DES9797Alg3with7816d4"));
            configurableProvider.b("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
            configurableProvider.b("AlgorithmParameters.DES", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableProvider.c("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "DES");
            C1058d.I(lf.o(str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.DES", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier, configurableProvider, "DES");
            configurableProvider.b("Cipher.PBEWITHMD5ANDDES", xx.E(str, "$PBEWithMD2", configurableProvider, "Cipher.PBEWITHMD2ANDDES", "$PBEWithMD5"));
            configurableProvider.b("Cipher.PBEWITHSHA1ANDDES", str.concat("$PBEWithSHA1"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.q;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier2, "PBEWITHMD2ANDDES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.s;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier3, "PBEWITHMD5ANDDES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.u;
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier4, "PBEWITHSHA1ANDDES");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            configurableProvider.b("SecretKeyFactory.PBEWITHMD5ANDDES", xx.E(str, "$PBEWithMD2KeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHMD2ANDDES", "$PBEWithMD5KeyFactory"));
            configurableProvider.b("SecretKeyFactory.PBEWITHSHA1ANDDES", str.concat("$PBEWithSHA1KeyFactory"));
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            configurableProvider.b("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier2, "PBEWITHMD2ANDDES");
            C1058d.I(C1058d.D(new StringBuilder("Alg.Alias.SecretKeyFactory."), aSN1ObjectIdentifier3, configurableProvider, "PBEWITHMD5ANDDES", "Alg.Alias.SecretKeyFactory."), aSN1ObjectIdentifier4, configurableProvider, "PBEWITHSHA1ANDDES");
        }
    }

    public static class PBEWithMD2 extends BaseBlockCipher {
        public PBEWithMD2() {
            super(new CBCBlockCipher(new DESEngine()), 0, 5, 64, 8);
        }
    }

    public static class PBEWithMD2KeyFactory extends DESPBEKeyFactory {
        public PBEWithMD2KeyFactory() {
            super("PBEwithMD2andDES", PKCSObjectIdentifiers.q, 0, 5, 64);
        }
    }

    public static class PBEWithMD5 extends BaseBlockCipher {
        public PBEWithMD5() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 8);
        }
    }

    public static class PBEWithMD5KeyFactory extends DESPBEKeyFactory {
        public PBEWithMD5KeyFactory() {
            super("PBEwithMD5andDES", PKCSObjectIdentifiers.s, 0, 0, 64);
        }
    }

    public static class PBEWithSHA1 extends BaseBlockCipher {
        public PBEWithSHA1() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 8);
        }
    }

    public static class PBEWithSHA1KeyFactory extends DESPBEKeyFactory {
        public PBEWithSHA1KeyFactory() {
            super("PBEwithSHA1andDES", PKCSObjectIdentifiers.u, 0, 1, 64);
        }
    }

    public static class RFC3211 extends BaseWrapCipher {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESEngine()), 8);
        }
    }

    private DES() {
    }
}
