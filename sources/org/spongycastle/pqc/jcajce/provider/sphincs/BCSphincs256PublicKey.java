package org.spongycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.SPHINCS256KeyParams;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.spongycastle.util.Arrays;

public class BCSphincs256PublicKey implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    public final ASN1ObjectIdentifier Z0;
    public final SPHINCSPublicKeyParameters a;

    public BCSphincs256PublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = sPHINCSPublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PublicKey)) {
            return false;
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
        if (!this.Z0.equals(bCSphincs256PublicKey.Z0) || !Arrays.a(Arrays.c(this.a.a), Arrays.c(bCSphincs256PublicKey.a.a))) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public final byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.h, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.Z0))), Arrays.c(this.a.a)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        return (Arrays.t(Arrays.c(this.a.a)) * 37) + this.Z0.hashCode();
    }

    public BCSphincs256PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SPHINCS256KeyParams sPHINCS256KeyParams;
        ASN1Encodable aSN1Encodable = subjectPublicKeyInfo.f5753a.a;
        if (aSN1Encodable instanceof SPHINCS256KeyParams) {
            sPHINCS256KeyParams = (SPHINCS256KeyParams) aSN1Encodable;
        } else {
            sPHINCS256KeyParams = aSN1Encodable != null ? new SPHINCS256KeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        this.Z0 = sPHINCS256KeyParams.f6654a.Z0;
        this.a = new SPHINCSPublicKeyParameters(subjectPublicKeyInfo.a.r());
    }
}
