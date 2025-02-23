package org.spongycastle.jce;

import java.io.IOException;
import java.security.Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.X509Name;

public class X509Principal extends X509Name implements Principal {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X509Principal(byte[] bArr) throws IOException {
        super(ASN1Sequence.q(new ASN1InputStream(bArr).j()));
        try {
        } catch (IllegalArgumentException e) {
            throw new IOException("not an ASN.1 Sequence: " + e);
        }
    }

    public final byte[] e() {
        try {
            return f("DER");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public final String getName() {
        return toString();
    }

    public X509Principal(X509Name x509Name) {
        super((ASN1Sequence) x509Name.b());
    }

    public X509Principal(X500Name x500Name) {
        super((ASN1Sequence) x500Name.b());
    }
}
