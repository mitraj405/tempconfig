package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Enumeration;

class LazyConstructionEnumeration implements Enumeration {
    public final ASN1InputStream a;

    /* renamed from: a  reason: collision with other field name */
    public ASN1Primitive f5673a;

    public LazyConstructionEnumeration(byte[] bArr) {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(bArr), bArr.length, true);
        this.a = aSN1InputStream;
        try {
            this.f5673a = aSN1InputStream.j();
        } catch (IOException e) {
            throw new ASN1ParsingException("malformed DER construction: " + e, e);
        }
    }

    public final boolean hasMoreElements() {
        if (this.f5673a != null) {
            return true;
        }
        return false;
    }

    public final Object nextElement() {
        ASN1Primitive aSN1Primitive = this.f5673a;
        try {
            this.f5673a = this.a.j();
            return aSN1Primitive;
        } catch (IOException e) {
            throw new ASN1ParsingException("malformed DER construction: " + e, e);
        }
    }
}
