package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RC2CBCParameter;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.RC2Engine;
import org.spongycastle.crypto.engines.RC2WrapEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.util.Arrays;

public final class RC2 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public RC2ParameterSpec a = null;

        public final AlgorithmParameters engineGenerateParameters() {
            if (this.a == null) {
                byte[] bArr = new byte[8];
                if (this.a == null) {
                    this.a = new SecureRandom();
                }
                this.a.nextBytes(bArr);
                try {
                    AlgorithmParameters a2 = a("RC2");
                    a2.init(new IvParameterSpec(bArr));
                    return a2;
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                try {
                    AlgorithmParameters a3 = a("RC2");
                    a3.init(this.a);
                    return a3;
                } catch (Exception e2) {
                    throw new RuntimeException(e2.getMessage());
                }
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                this.a = (RC2ParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC2 parameter generation.");
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public static final short[] a = {189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
        public static final short[] b = {93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};

        /* renamed from: a  reason: collision with other field name */
        public int f6537a = 58;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6538a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            int i;
            Class<AlgorithmParameterSpec> cls2 = AlgorithmParameterSpec.class;
            if ((cls == RC2ParameterSpec.class || cls == cls2) && (i = this.f6537a) != -1) {
                if (i < 256) {
                    return new RC2ParameterSpec(b[this.f6537a], this.f6538a);
                }
                return new RC2ParameterSpec(this.f6537a, this.f6538a);
            } else if (cls == IvParameterSpec.class || cls == cls2) {
                return new IvParameterSpec(this.f6538a);
            } else {
                throw new InvalidParameterSpecException("unknown parameter spec passed to RC2 parameters object.");
            }
        }

        public final byte[] engineGetEncoded() {
            return Arrays.c(this.f6538a);
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6538a = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
                if (effectiveKeyBits != -1) {
                    if (effectiveKeyBits < 256) {
                        this.f6537a = a[effectiveKeyBits];
                    } else {
                        this.f6537a = effectiveKeyBits;
                    }
                }
                this.f6538a = rC2ParameterSpec.getIV();
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec or RC2ParameterSpec required to initialise a RC2 parameters algorithm parameters object");
            }
        }

        public final String engineToString() {
            return "RC2 Parameters";
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                int i = this.f6537a;
                if (i == -1) {
                    return new RC2CBCParameter(engineGetEncoded()).e();
                }
                return new RC2CBCParameter(i, engineGetEncoded()).e();
            } else if (str.equals("RAW")) {
                return engineGetEncoded();
            } else {
                return null;
            }
        }

        public final void engineInit(byte[] bArr) throws IOException {
            this.f6538a = Arrays.c(bArr);
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            RC2CBCParameter rC2CBCParameter;
            BigInteger bigInteger;
            if (BaseAlgorithmParameters.a(str)) {
                ASN1Primitive k = ASN1Primitive.k(bArr);
                BigInteger bigInteger2 = null;
                if (k instanceof RC2CBCParameter) {
                    rC2CBCParameter = (RC2CBCParameter) k;
                } else {
                    rC2CBCParameter = k != null ? new RC2CBCParameter(ASN1Sequence.q(k)) : null;
                }
                ASN1Integer aSN1Integer = rC2CBCParameter.a;
                if (aSN1Integer == null) {
                    bigInteger = null;
                } else {
                    bigInteger = aSN1Integer.t();
                }
                if (bigInteger != null) {
                    ASN1Integer aSN1Integer2 = rC2CBCParameter.a;
                    if (aSN1Integer2 != null) {
                        bigInteger2 = aSN1Integer2.t();
                    }
                    this.f6537a = bigInteger2.intValue();
                }
                this.f6538a = rC2CBCParameter.f5703a.s();
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new RC2Engine()), 64);
        }
    }

    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super((Mac) new CBCBlockCipherMac(new RC2Engine()));
        }
    }

    public static class CFB8MAC extends BaseMac {
        public CFB8MAC() {
            super((Mac) new CFBBlockCipherMac(new RC2Engine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new RC2Engine());
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("RC2", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = RC2.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("AlgorithmParameterGenerator.1.2.840.113549.3.2", xx.E(str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.RC2", "$AlgParamGen"));
            configurableProvider.b("KeyGenerator.1.2.840.113549.3.2", xx.E(str, "$KeyGenerator", configurableProvider, "KeyGenerator.RC2", "$KeyGenerator"));
            configurableProvider.b("AlgorithmParameters.1.2.840.113549.3.2", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.RC2", "$AlgParams"));
            configurableProvider.b("Cipher.RC2WRAP", xx.E(str, "$ECB", configurableProvider, "Cipher.RC2", "$Wrap"));
            configurableProvider.c("Alg.Alias.Cipher", PKCSObjectIdentifiers.d0, "RC2WRAP");
            configurableProvider.c("Cipher", PKCSObjectIdentifiers.z, str.concat("$CBC"));
            configurableProvider.b("Mac.RC2MAC", str.concat("$CBCMAC"));
            configurableProvider.b("Alg.Alias.Mac.RC2", "RC2MAC");
            configurableProvider.b("Mac.RC2MAC/CFB8", str.concat("$CFB8MAC"));
            configurableProvider.b("Alg.Alias.Mac.RC2/CFB8", "RC2MAC/CFB8");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDRC2-CBC", "PBEWITHMD2ANDRC2");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.r;
            configurableProvider.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier, "PBEWITHMD2ANDRC2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.t;
            configurableProvider.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier2, "PBEWITHMD5ANDRC2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.v;
            configurableProvider.c("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier3, "PBEWITHSHA1ANDRC2");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
            configurableProvider.b("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
            configurableProvider.b("SecretKeyFactory.PBEWITHMD5ANDRC2", xx.E(str, "$PBEWithMD2KeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHMD2ANDRC2", "$PBEWithMD5KeyFactory"));
            configurableProvider.b("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", xx.E(str, "$PBEWithSHA1KeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHSHA1ANDRC2", "$PBEWithSHAAnd128BitKeyFactory"));
            configurableProvider.b("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", str.concat("$PBEWithSHAAnd40BitKeyFactory"));
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier, "PBEWITHMD2ANDRC2");
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier2, "PBEWITHMD5ANDRC2");
            configurableProvider.c("Alg.Alias.Cipher", aSN1ObjectIdentifier3, "PBEWITHSHA1ANDRC2");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
            configurableProvider.c("Alg.Alias.Cipher", PKCSObjectIdentifiers.a0, "PBEWITHSHAAND128BITRC2-CBC");
            configurableProvider.c("Alg.Alias.Cipher", PKCSObjectIdentifiers.b0, "PBEWITHSHAAND40BITRC2-CBC");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
            configurableProvider.b("Cipher.PBEWITHSHA1ANDRC2", str.concat("$PBEWithSHA1AndRC2"));
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHAANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            configurableProvider.b("Cipher.PBEWITHSHAAND40BITRC2-CBC", xx.E(str, "$PBEWithSHAAnd128BitRC2", configurableProvider, "Cipher.PBEWITHSHAAND128BITRC2-CBC", "$PBEWithSHAAnd40BitRC2"));
            configurableProvider.b("Cipher.PBEWITHMD5ANDRC2", str.concat("$PBEWithMD5AndRC2"));
            configurableProvider.b("Alg.Alias.Cipher.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
        }
    }

    public static class PBEWithMD2KeyFactory extends PBESecretKeyFactory {
        public PBEWithMD2KeyFactory() {
            super("PBEwithMD2andRC2", PKCSObjectIdentifiers.r, true, 0, 5, 64, 64);
        }
    }

    public static class PBEWithMD5AndRC2 extends BaseBlockCipher {
        public PBEWithMD5AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()), 0, 0, 64, 8);
        }
    }

    public static class PBEWithMD5KeyFactory extends PBESecretKeyFactory {
        public PBEWithMD5KeyFactory() {
            super("PBEwithMD5andRC2", PKCSObjectIdentifiers.t, true, 0, 0, 64, 64);
        }
    }

    public static class PBEWithSHA1AndRC2 extends BaseBlockCipher {
        public PBEWithSHA1AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()), 0, 1, 64, 8);
        }
    }

    public static class PBEWithSHA1KeyFactory extends PBESecretKeyFactory {
        public PBEWithSHA1KeyFactory() {
            super("PBEwithSHA1andRC2", PKCSObjectIdentifiers.v, true, 0, 1, 64, 64);
        }
    }

    public static class PBEWithSHAAnd128BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitKeyFactory() {
            super("PBEwithSHAand128BitRC2-CBC", PKCSObjectIdentifiers.a0, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAnd128BitRC2 extends BaseBlockCipher {
        public PBEWithSHAAnd128BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()), 2, 1, 128, 8);
        }
    }

    public static class PBEWithSHAAnd40BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd40BitKeyFactory() {
            super("PBEwithSHAand40BitRC2-CBC", PKCSObjectIdentifiers.b0, true, 2, 1, 40, 64);
        }
    }

    public static class PBEWithSHAAnd40BitRC2 extends BaseBlockCipher {
        public PBEWithSHAAnd40BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()), 2, 1, 40, 8);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new RC2WrapEngine(), 0);
        }
    }

    private RC2() {
    }
}
