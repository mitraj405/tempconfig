package org.spongycastle.pqc.jcajce.provider.newhope;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.NHPrivateKey;
import org.spongycastle.util.Arrays;

public class BCNHPrivateKey implements NHPrivateKey {
    private static final long serialVersionUID = 1;
    public final NHPrivateKeyParameters a;

    public BCNHPrivateKey(NHPrivateKeyParameters nHPrivateKeyParameters) {
        this.a = nHPrivateKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPrivateKey)) {
            return false;
        }
        short[] g = Arrays.g(this.a.a);
        short[] g2 = Arrays.g(((BCNHPrivateKey) obj).a.a);
        if (g != g2) {
            if (g == null || g2 == null || g.length != g2.length) {
                return false;
            }
            for (int i = 0; i != g.length; i++) {
                if (g[i] != g2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public final byte[] getEncoded() {
        try {
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.k);
            short[] g = Arrays.g(this.a.a);
            byte[] bArr = new byte[(g.length * 2)];
            for (int i = 0; i != g.length; i++) {
                short s = g[i];
                int i2 = i * 2;
                bArr[i2] = (byte) s;
                bArr[i2 + 1] = (byte) (s >>> 8);
            }
            return new PrivateKeyInfo(algorithmIdentifier, new DEROctetString(bArr)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return Arrays.w(Arrays.g(this.a.a));
    }

    public BCNHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        byte[] s = ASN1OctetString.q(privateKeyInfo.h()).s();
        int length = s.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            sArr[i] = (short) (((s[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8) | (s[i2] & UnsignedBytes.MAX_VALUE));
        }
        this.a = new NHPrivateKeyParameters(sArr);
    }
}
