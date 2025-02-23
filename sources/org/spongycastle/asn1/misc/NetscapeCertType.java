package org.spongycastle.asn1.misc;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.asn1.DERBitString;

public class NetscapeCertType extends DERBitString {
    public NetscapeCertType(DERBitString dERBitString) {
        super(dERBitString.r(), dERBitString.c);
    }

    public final String toString() {
        return "NetscapeCertType: 0x" + Integer.toHexString(this.f5654a[0] & UnsignedBytes.MAX_VALUE);
    }
}
