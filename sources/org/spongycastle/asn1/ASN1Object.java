package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Encodable;

public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public abstract ASN1Primitive b();

    public byte[] e() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).g(this);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable)) {
            return false;
        }
        return b().equals(((ASN1Encodable) obj).b());
    }

    public final byte[] f(String str) throws IOException {
        if (str.equals("DER")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DEROutputStream(byteArrayOutputStream).g(this);
            return byteArrayOutputStream.toByteArray();
        } else if (!str.equals("DL")) {
            return e();
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            new DLOutputStream(byteArrayOutputStream2).g(this);
            return byteArrayOutputStream2.toByteArray();
        }
    }

    public int hashCode() {
        return b().hashCode();
    }
}
