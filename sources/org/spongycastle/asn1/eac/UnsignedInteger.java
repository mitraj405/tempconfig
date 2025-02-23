package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;

public class UnsignedInteger extends ASN1Object {
    public final BigInteger a = null;
    public final int c;

    public UnsignedInteger(int i) {
        this.c = i;
    }

    public final ASN1Primitive b() {
        byte[] byteArray = this.a.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        return new DERTaggedObject(false, this.c, new DEROctetString(byteArray));
    }
}
