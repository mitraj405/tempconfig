package org.spongycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.SPHINCS256KeyParams;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.spongycastle.util.Arrays;

public class BCSphincs256PrivateKey implements PrivateKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    public final ASN1ObjectIdentifier Z0;
    public final SPHINCSPrivateKeyParameters a;

    public BCSphincs256PrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SPHINCSPrivateKeyParameters sPHINCSPrivateKeyParameters) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = sPHINCSPrivateKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PrivateKey)) {
            return false;
        }
        BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) obj;
        if (!this.Z0.equals(bCSphincs256PrivateKey.Z0) || !Arrays.a(Arrays.c(this.a.a), Arrays.c(bCSphincs256PrivateKey.a.a))) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public final byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.h, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.Z0))), new DEROctetString(Arrays.c(this.a.a))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return (Arrays.t(Arrays.c(this.a.a)) * 37) + this.Z0.hashCode();
    }

    public BCSphincs256PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        SPHINCS256KeyParams sPHINCS256KeyParams;
        ASN1Encodable aSN1Encodable = privateKeyInfo.f5702a.a;
        if (aSN1Encodable instanceof SPHINCS256KeyParams) {
            sPHINCS256KeyParams = (SPHINCS256KeyParams) aSN1Encodable;
        } else {
            sPHINCS256KeyParams = aSN1Encodable != null ? new SPHINCS256KeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        this.Z0 = sPHINCS256KeyParams.f6654a.Z0;
        this.a = new SPHINCSPrivateKeyParameters(ASN1OctetString.q(privateKeyInfo.h()).s());
    }
}
