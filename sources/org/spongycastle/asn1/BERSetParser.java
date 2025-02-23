package org.spongycastle.asn1;

import java.io.IOException;

public class BERSetParser implements ASN1SetParser {
    public final ASN1StreamParser a;

    public BERSetParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    public final ASN1Primitive a() throws IOException {
        return new BERSet(this.a.c());
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
