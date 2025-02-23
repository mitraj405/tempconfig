package org.spongycastle.asn1;

import java.io.IOException;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    public final ASN1StreamParser a;
    public final int c;

    public BERApplicationSpecificParser(int i, ASN1StreamParser aSN1StreamParser) {
        this.c = i;
        this.a = aSN1StreamParser;
    }

    public final ASN1Primitive a() throws IOException {
        return new BERApplicationSpecific(this.c, this.a.c());
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
