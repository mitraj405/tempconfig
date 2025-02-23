package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.pkcs.DHParameter;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    public DHParameterSpec a;

    public final byte[] engineGetEncoded(String str) {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        return null;
    }

    public final AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == DHParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
        }
    }

    public final void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException(C0709Uj.i("Unknown parameter format ", str));
    }

    public final String engineToString() {
        return "Diffie-Hellman Parameters";
    }

    public final byte[] engineGetEncoded() {
        try {
            return new DHParameter(this.a.getL(), this.a.getP(), this.a.getG()).f("DER");
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding DHParameters");
        }
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            this.a = (DHParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
    }

    public final void engineInit(byte[] bArr) throws IOException {
        try {
            DHParameter h = DHParameter.h(bArr);
            if (h.i() != null) {
                this.a = new DHParameterSpec(h.k(), h.g(), h.i().intValue());
            } else {
                this.a = new DHParameterSpec(h.k(), h.g());
            }
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid DH Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid DH Parameter encoding.");
        }
    }
}
