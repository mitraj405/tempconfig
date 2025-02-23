package org.spongycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    public final ASN1StreamParser a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5666a;
    public final int c;

    public BERTaggedObjectParser(boolean z, int i, ASN1StreamParser aSN1StreamParser) {
        this.f5666a = z;
        this.c = i;
        this.a = aSN1StreamParser;
    }

    public final ASN1Primitive a() throws IOException {
        return this.a.b(this.c, this.f5666a);
    }

    public final ASN1Primitive b() {
        try {
            return a();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
}
