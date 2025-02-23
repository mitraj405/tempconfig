package org.spongycastle.asn1;

import java.io.IOException;

public interface InMemoryRepresentable {
    ASN1Primitive a() throws IOException;
}
