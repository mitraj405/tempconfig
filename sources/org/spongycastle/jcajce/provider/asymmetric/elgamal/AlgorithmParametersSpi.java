package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class AlgorithmParametersSpi extends BaseAlgorithmParameters {
    public ElGamalParameterSpec a;

    public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == ElGamalParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.a;
        }
        if (cls == DHParameterSpec.class) {
            ElGamalParameterSpec elGamalParameterSpec = this.a;
            return new DHParameterSpec(elGamalParameterSpec.a, elGamalParameterSpec.b);
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }

    public final byte[] engineGetEncoded() {
        ElGamalParameterSpec elGamalParameterSpec = this.a;
        try {
            return new ElGamalParameter(elGamalParameterSpec.a, elGamalParameterSpec.b).f("DER");
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding ElGamalParameters");
        }
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (!z && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
        } else if (z) {
            this.a = (ElGamalParameterSpec) algorithmParameterSpec;
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.a = new ElGamalParameterSpec(dHParameterSpec.getP(), dHParameterSpec.getG());
        }
    }

    public final String engineToString() {
        return "ElGamal Parameters";
    }

    public final void engineInit(byte[] bArr) throws IOException {
        try {
            ElGamalParameter g = ElGamalParameter.g(ASN1Primitive.k(bArr));
            this.a = new ElGamalParameterSpec(g.a.s(), g.b.s());
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
        }
    }

    public final byte[] engineGetEncoded(String str) {
        if (BaseAlgorithmParameters.a(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    public final void engineInit(byte[] bArr, String str) throws IOException {
        if (BaseAlgorithmParameters.a(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(str));
    }
}
