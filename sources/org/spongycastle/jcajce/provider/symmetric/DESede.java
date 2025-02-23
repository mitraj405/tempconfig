package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.DESedeWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.DES;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DESede {

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
            super(new CBCBlockCipher(new DESedeEngine()), 64);
        }
    }

    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super((Mac) new CBCBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super((Mac) new CMac(new DESedeEngine()));
        }
    }

    public static class DESede64 extends BaseMac {
        public DESede64() {
            super((Mac) new CBCBlockCipherMac(new DESedeEngine(), 64, (ISO7816d4Padding) null));
        }
    }

    public static class DESede64with7816d4 extends BaseMac {
        public DESede64with7816d4() {
            super((Mac) new CBCBlockCipherMac(new DESedeEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DESedeCFB8 extends BaseMac {
        public DESedeCFB8() {
            super((Mac) new CFBBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new DESedeEngine());
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("DESede", (ASN1ObjectIdentifier) null);
        }

        public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DESedeKeySpec) {
                return new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESede");
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
                if (DESedeKeySpec.class.isAssignableFrom(cls)) {
                    byte[] encoded = secretKey.getEncoded();
                    try {
                        if (encoded.length != 16) {
                            return new DESedeKeySpec(encoded);
                        }
                        byte[] bArr = new byte[24];
                        System.arraycopy(encoded, 0, bArr, 0, 16);
                        System.arraycopy(encoded, 0, bArr, 16, 8);
                        return new DESedeKeySpec(bArr);
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
        public boolean b = false;

        public KeyGenerator() {
            super("DESede", 192, new DESedeKeyGenerator());
        }

        public final SecretKey engineGenerateKey() {
            boolean z = this.f6554a;
            CipherKeyGenerator cipherKeyGenerator = this.f6553a;
            if (z) {
                cipherKeyGenerator.b(new KeyGenerationParameters(this.a, new SecureRandom()));
                this.f6554a = false;
            }
            boolean z2 = this.b;
            String str = this.f6552a;
            if (z2) {
                return new SecretKeySpec(cipherKeyGenerator.a(), str);
            }
            byte[] a = cipherKeyGenerator.a();
            System.arraycopy(a, 0, a, 16, 8);
            return new SecretKeySpec(a, str);
        }

        public final void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
            this.b = true;
        }
    }

    public static class KeyGenerator3 extends BaseKeyGenerator {
        public KeyGenerator3() {
            super("DESede3", 192, new DESedeKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = DESede.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Cipher.DESEDE", str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.y;
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider.b("Cipher.DESEDEWRAP", str.concat("$Wrap"));
            configurableProvider.c("Cipher", PKCSObjectIdentifiers.c0, str.concat("$Wrap"));
            configurableProvider.b("Cipher.DESEDERFC3211WRAP", str.concat("$RFC3211"));
            configurableProvider.b("Alg.Alias.Cipher.DESEDERFC3217WRAP", "DESEDEWRAP");
            configurableProvider.b("Alg.Alias.Cipher.TDEA", "DESEDE");
            configurableProvider.b("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
            configurableProvider.b("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
            configurableProvider.b("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
            if (configurableProvider.d("SHA-1")) {
                configurableProvider.b("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", xx.E(str, "$PBEWithSHAAndDES3Key", configurableProvider, "Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "$BrokePBEWithSHAAndDES3Key"));
                configurableProvider.b("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", xx.E(str, "$OldPBEWithSHAAndDES3Key", configurableProvider, "Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "$PBEWithSHAAndDES2Key"));
                configurableProvider.b("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", str.concat("$BrokePBEWithSHAAndDES2Key"));
                configurableProvider.c("Alg.Alias.Cipher", PKCSObjectIdentifiers.Y, "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.c("Alg.Alias.Cipher", PKCSObjectIdentifiers.Z, "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHAAND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHAAND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            }
            StringBuilder o = lf.o(str, "$KeyGenerator", configurableProvider, "KeyGenerator.DESEDE", "KeyGenerator.");
            o.append(aSN1ObjectIdentifier);
            configurableProvider.b("KeyGenerator.DESEDEWRAP", xx.E(str, "$KeyGenerator3", configurableProvider, o.toString(), "$KeyGenerator"));
            configurableProvider.b("SecretKeyFactory.DESEDE", str.concat("$KeyFactory"));
            configurableProvider.c("SecretKeyFactory", OIWObjectIdentifiers.e, str.concat("$KeyFactory"));
            configurableProvider.b("Mac.DESEDEMAC", xx.E(str, "$CMAC", configurableProvider, "Mac.DESEDECMAC", "$CBCMAC"));
            configurableProvider.b("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            configurableProvider.b("Mac.DESEDEMAC/CFB8", str.concat("$DESedeCFB8"));
            configurableProvider.b("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            configurableProvider.b("Mac.DESEDEMAC64", str.concat("$DESede64"));
            configurableProvider.b("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            configurableProvider.b("Mac.DESEDEMAC64WITHISO7816-4PADDING", str.concat("$DESede64with7816d4"));
            configurableProvider.b("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.b("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.b("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.b("AlgorithmParameters.DESEDE", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableProvider.b("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, "DESEDE");
            C1058d.I(lf.o(str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.DESEDE", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier, configurableProvider, "DESEDE");
            configurableProvider.b("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", xx.E(str, "$PBEWithSHAAndDES3KeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "$PBEWithSHAAndDES2KeyFactory"));
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        }
    }

    public static class PBEWithSHAAndDES2Key extends BaseBlockCipher {
        public PBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 8);
        }
    }

    public static class PBEWithSHAAndDES2KeyFactory extends DES.DESPBEKeyFactory {
        public PBEWithSHAAndDES2KeyFactory() {
            super("PBEwithSHAandDES2Key-CBC", PKCSObjectIdentifiers.Z, 2, 1, 128);
        }
    }

    public static class PBEWithSHAAndDES3Key extends BaseBlockCipher {
        public PBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 192, 8);
        }
    }

    public static class PBEWithSHAAndDES3KeyFactory extends DES.DESPBEKeyFactory {
        public PBEWithSHAAndDES3KeyFactory() {
            super("PBEwithSHAandDES3Key-CBC", PKCSObjectIdentifiers.Y, 2, 1, 192);
        }
    }

    public static class RFC3211 extends BaseWrapCipher {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESedeEngine()), 8);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new DESedeWrapEngine(), 0);
        }
    }

    private DESede() {
    }
}
