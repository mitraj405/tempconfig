package org.spongycastle.asn1;

public abstract class ASN1Null extends ASN1Primitive {
    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return -1;
    }

    public final String toString() {
        return "NULL";
    }
}
