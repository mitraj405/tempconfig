package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public class PBEPKCS12 {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = PBEPKCS12.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("AlgorithmParameters.PKCS12PBE", a.concat("$AlgParams"));
        }
    }

    private PBEPKCS12() {
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public PKCS12PBEParams a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.a.f5699a.s(), this.a.a.t().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
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
                this.a = new PKCS12PBEParams(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
        }

        public final String engineToString() {
            return "PKCS12 PBE Parameters";
        }

        public final byte[] engineGetEncoded(String str) {
            if (BaseAlgorithmParameters.a(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        public final void engineInit(byte[] bArr) throws IOException {
            this.a = PKCS12PBEParams.g(ASN1Primitive.k(bArr));
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
        }
    }
}
