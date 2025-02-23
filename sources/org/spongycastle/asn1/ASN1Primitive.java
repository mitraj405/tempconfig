package org.spongycastle.asn1;

import java.io.IOException;

public abstract class ASN1Primitive extends ASN1Object {
    public static ASN1Primitive k(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        try {
            ASN1Primitive j = aSN1InputStream.j();
            if (aSN1InputStream.available() == 0) {
                return j;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable) || !g(((ASN1Encodable) obj).b())) {
            return false;
        }
        return true;
    }

    public abstract boolean g(ASN1Primitive aSN1Primitive);

    public abstract void h(ASN1OutputStream aSN1OutputStream) throws IOException;

    public abstract int hashCode();

    public abstract int i() throws IOException;

    public abstract boolean n();

    public final ASN1Primitive b() {
        return this;
    }

    public ASN1Primitive o() {
        return this;
    }

    public ASN1Primitive p() {
        return this;
    }
}
