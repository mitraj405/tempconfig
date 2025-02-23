package org.spongycastle.asn1.x509;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;

public class KeyUsage extends ASN1Object {
    public final DERBitString a;

    public KeyUsage() {
        this.a = new DERBitString();
    }

    public static KeyUsage g(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof KeyUsage) {
            return (KeyUsage) aSN1Primitive;
        }
        if (aSN1Primitive != null) {
            return new KeyUsage(DERBitString.u(aSN1Primitive));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final String toString() {
        byte[] r = this.a.r();
        if (r.length == 1) {
            return "KeyUsage: 0x" + Integer.toHexString(r[0] & UnsignedBytes.MAX_VALUE);
        }
        return "KeyUsage: 0x" + Integer.toHexString((r[0] & UnsignedBytes.MAX_VALUE) | ((r[1] & UnsignedBytes.MAX_VALUE) << 8));
    }

    public KeyUsage(DERBitString dERBitString) {
        this.a = dERBitString;
    }
}
