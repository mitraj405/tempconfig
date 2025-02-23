package org.spongycastle.asn1;

import java.io.IOException;

public class BERSequenceParser implements ASN1SequenceParser {
    public final ASN1StreamParser a;

    public BERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    public final ASN1Primitive a() throws IOException {
        return new BERSequence(this.a.c());
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
