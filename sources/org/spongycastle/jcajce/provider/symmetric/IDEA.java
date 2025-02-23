package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.misc.IDEACBCPar;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.IDEAEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.util.Arrays;

public final class IDEA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("IDEA");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public byte[] a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        public final byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.a = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }

        public final String engineToString() {
            return "IDEA Parameters";
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                return new IDEACBCPar(engineGetEncoded("RAW")).e();
            }
            if (!str.equals("RAW")) {
                return null;
            }
            byte[] bArr = this.a;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public final void engineInit(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[bArr.length];
            this.a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equals("RAW")) {
                engineInit(bArr);
            } else if (str.equals("ASN.1")) {
                ASN1OctetString aSN1OctetString = new IDEACBCPar((ASN1Sequence) new ASN1InputStream(bArr).j()).a;
                engineInit(aSN1OctetString != null ? Arrays.c(aSN1OctetString.s()) : null);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new IDEAEngine()), 64);
        }
    }

    public static class CFB8Mac extends BaseMac {
        public CFB8Mac() {
            super((org.spongycastle.crypto.Mac) new CFBBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new IDEAEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("IDEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super((org.spongycastle.crypto.Mac) new CBCBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = IDEA.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", xx.E(str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.IDEA", "$AlgParamGen"));
            configurableProvider.b("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.IDEA", "$AlgParams"));
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            configurableProvider.b("Cipher.IDEA", str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.e;
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider.b("KeyGenerator.IDEA", xx.E(str, "$PBEWithSHAAndIDEA", configurableProvider, "Cipher.PBEWITHSHAANDIDEA-CBC", "$KeyGen"));
            configurableProvider.c("KeyGenerator", aSN1ObjectIdentifier, str.concat("$KeyGen"));
            configurableProvider.b("Mac.IDEAMAC", xx.E(str, "$PBEWithSHAAndIDEAKeyGen", configurableProvider, "SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", "$Mac"));
            configurableProvider.b("Alg.Alias.Mac.IDEA", "IDEAMAC");
            configurableProvider.b("Mac.IDEAMAC/CFB8", str.concat("$CFB8Mac"));
            configurableProvider.b("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }
    }

    public static class PBEWithSHAAndIDEA extends BaseBlockCipher {
        public PBEWithSHAAndIDEA() {
            super((BlockCipher) new CBCBlockCipher(new IDEAEngine()));
        }
    }

    public static class PBEWithSHAAndIDEAKeyGen extends PBESecretKeyFactory {
        public PBEWithSHAAndIDEAKeyGen() {
            super("PBEwithSHAandIDEA-CBC", (ASN1ObjectIdentifier) null, true, 2, 1, 128, 64);
        }
    }

    private IDEA() {
    }
}
