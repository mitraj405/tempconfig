package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;

public class IvAlgorithmParameters extends BaseAlgorithmParameters {
    public byte[] a;

    public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
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

    public String engineToString() {
        return "IV Parameters";
    }

    public final byte[] engineGetEncoded(String str) throws IOException {
        if (BaseAlgorithmParameters.a(str)) {
            return new DEROctetString(engineGetEncoded("RAW")).e();
        }
        if (str.equals("RAW")) {
            return Arrays.c(this.a);
        }
        return null;
    }

    public final void engineInit(byte[] bArr) throws IOException {
        if (bArr.length % 8 != 0 && bArr[0] == 4 && bArr[1] == bArr.length - 2) {
            bArr = ((ASN1OctetString) ASN1Primitive.k(bArr)).s();
        }
        this.a = Arrays.c(bArr);
    }

    public final void engineInit(byte[] bArr, String str) throws IOException {
        if (BaseAlgorithmParameters.a(str)) {
            try {
                engineInit(((ASN1OctetString) ASN1Primitive.k(bArr)).s());
            } catch (Exception e) {
                throw new IOException("Exception decoding: " + e);
            }
        } else if (str.equals("RAW")) {
            engineInit(bArr);
        } else {
            throw new IOException("Unknown parameters format in IV parameters object");
        }
    }
}
