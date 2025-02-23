package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class BEROctetStringParser implements ASN1OctetStringParser {
    public final ASN1StreamParser a;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    public final ASN1Primitive a() throws IOException {
        return new BEROctetString(Streams.a(d()));
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new ASN1ParsingException(C0709Uj.g(e, new StringBuilder("IOException converting stream to byte array: ")), e);
        }
    }

    public final InputStream d() {
        return new ConstructedOctetStream(this.a);
    }
}
