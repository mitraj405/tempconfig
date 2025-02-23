package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.util.Arrays;

public class MacData extends ASN1Object {
    public static final BigInteger b = BigInteger.valueOf(1);
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final DigestInfo f5692a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5693a;

    public MacData(ASN1Sequence aSN1Sequence) {
        DigestInfo digestInfo;
        ASN1Encodable s = aSN1Sequence.s(0);
        if (s instanceof DigestInfo) {
            digestInfo = (DigestInfo) s;
        } else {
            digestInfo = s != null ? new DigestInfo(ASN1Sequence.q(s)) : null;
        }
        this.f5692a = digestInfo;
        this.f5693a = Arrays.c(((ASN1OctetString) aSN1Sequence.s(1)).s());
        if (aSN1Sequence.size() == 3) {
            this.a = ((ASN1Integer) aSN1Sequence.s(2)).t();
        } else {
            this.a = b;
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5692a);
        aSN1EncodableVector.a(new DEROctetString(this.f5693a));
        BigInteger bigInteger = b;
        BigInteger bigInteger2 = this.a;
        if (!bigInteger2.equals(bigInteger)) {
            aSN1EncodableVector.a(new ASN1Integer(bigInteger2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public MacData(DigestInfo digestInfo, byte[] bArr, int i) {
        this.f5692a = digestInfo;
        this.f5693a = Arrays.c(bArr);
        this.a = BigInteger.valueOf((long) i);
    }
}
