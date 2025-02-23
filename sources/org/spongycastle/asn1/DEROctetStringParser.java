package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    public final DefiniteLengthInputStream a;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.a = definiteLengthInputStream;
    }

    public final ASN1Primitive a() throws IOException {
        return new DEROctetString(this.a.c());
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new ASN1ParsingException(C0709Uj.g(e, new StringBuilder("IOException converting stream to byte array: ")), e);
        }
    }

    public final InputStream d() {
        return this.a;
    }
}
