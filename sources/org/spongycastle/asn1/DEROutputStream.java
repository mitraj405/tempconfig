package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream extends ASN1OutputStream {
    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public final void g(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            aSN1Encodable.b().o().h(this);
            return;
        }
        throw new IOException("null object detected");
    }

    public final DEROutputStream a() {
        return this;
    }

    public final ASN1OutputStream b() {
        return this;
    }
}
