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
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.misc.CAST5CBCParameters;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CAST5Engine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.util.Arrays;

public final class CAST5 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a = a("CAST5");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for CAST5 parameter generation.");
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new CAST5Engine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new CAST5Engine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("CAST5", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = CAST5.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("AlgorithmParameters.CAST5", str.concat("$AlgParams"));
            configurableProvider.b("Alg.Alias.AlgorithmParameters.1.2.840.113533.7.66.10", "CAST5");
            configurableProvider.b("AlgorithmParameterGenerator.CAST5", str.concat("$AlgParamGen"));
            configurableProvider.b("Alg.Alias.AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "CAST5");
            configurableProvider.b("Cipher.CAST5", str.concat("$ECB"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.d;
            configurableProvider.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC"));
            configurableProvider.b("KeyGenerator.CAST5", str.concat("$KeyGen"));
            configurableProvider.c("Alg.Alias.KeyGenerator", aSN1ObjectIdentifier, "CAST5");
        }
    }

    private CAST5() {
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public int a = 128;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6534a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6534a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }

        public final byte[] engineGetEncoded() {
            byte[] bArr = this.f6534a;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6534a = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
        }

        public final String engineToString() {
            return "CAST5 Parameters";
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                return new CAST5CBCParameters(engineGetEncoded(), this.a).e();
            }
            if (str.equals("RAW")) {
                return engineGetEncoded();
            }
            return null;
        }

        public final void engineInit(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[bArr.length];
            this.f6534a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            CAST5CBCParameters cAST5CBCParameters;
            if (BaseAlgorithmParameters.a(str)) {
                ASN1Primitive j = new ASN1InputStream(bArr).j();
                if (j instanceof CAST5CBCParameters) {
                    cAST5CBCParameters = (CAST5CBCParameters) j;
                } else {
                    cAST5CBCParameters = j != null ? new CAST5CBCParameters(ASN1Sequence.q(j)) : null;
                }
                this.a = cAST5CBCParameters.a.t().intValue();
                this.f6534a = Arrays.c(cAST5CBCParameters.f5688a.s());
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }
}
