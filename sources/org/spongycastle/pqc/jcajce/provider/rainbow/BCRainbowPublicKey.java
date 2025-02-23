package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.util.Arrays;

public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    public final short[] a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6820a;
    public final short[][] b;
    public final int c;

    public BCRainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.c = i;
        this.f6820a = sArr;
        this.b = sArr2;
        this.a = sArr3;
    }

    public final short[][] a() {
        short[][] sArr = this.b;
        short[][] sArr2 = new short[sArr.length][];
        for (int i = 0; i != sArr.length; i++) {
            sArr2[i] = Arrays.g(sArr[i]);
        }
        return sArr2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof BCRainbowPublicKey)) {
            BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
            if (this.c == bCRainbowPublicKey.c && RainbowUtil.h(this.f6820a, bCRainbowPublicKey.f6820a)) {
                if (RainbowUtil.h(this.b, bCRainbowPublicKey.a())) {
                    if (RainbowUtil.g(this.a, Arrays.g(bCRainbowPublicKey.a))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public final byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.a, DERNull.a), (ASN1Object) new RainbowPublicKey(this.c, this.f6820a, this.b, this.a)).f("DER");
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        int x = Arrays.x(this.f6820a);
        int x2 = Arrays.x(this.b);
        return Arrays.w(this.a) + ((x2 + ((x + (this.c * 37)) * 37)) * 37);
    }
}
