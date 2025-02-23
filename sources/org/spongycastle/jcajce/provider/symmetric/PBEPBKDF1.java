package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PBEParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public class PBEPBKDF1 {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = PBEPBKDF1.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            C1058d.I(C1058d.D(C1058d.D(C1058d.D(C1058d.D(lf.o(a, "$AlgParams", configurableProvider, "AlgorithmParameters.PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.q, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.s, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.t, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.u, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.v, configurableProvider, "PBKDF1");
        }
    }

    private PBEPBKDF1() {
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public PBEParameter a;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.a.f5694a.s(), this.a.a.t().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF1 PBE parameters object.");
        }

        public final byte[] engineGetEncoded() {
            try {
                return this.a.f("DER");
            } catch (IOException e) {
                throw new RuntimeException("Oooops! " + e.toString());
            }
        }

        public final void engineInit(byte[] bArr) throws IOException {
            PBEParameter pBEParameter;
            if (bArr instanceof PBEParameter) {
                pBEParameter = (PBEParameter) bArr;
            } else {
                pBEParameter = bArr != null ? new PBEParameter(ASN1Sequence.q(bArr)) : null;
            }
            this.a = pBEParameter;
        }

        public final String engineToString() {
            return "PBKDF1 Parameters";
        }

        public final byte[] engineGetEncoded(String str) {
            if (BaseAlgorithmParameters.a(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.a = new PBEParameter(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF1 PBE parameters algorithm parameters object");
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
