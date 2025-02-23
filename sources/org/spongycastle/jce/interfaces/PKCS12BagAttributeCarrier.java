package org.spongycastle.jce.interfaces;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface PKCS12BagAttributeCarrier {
    ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    Enumeration e();

    void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable);
}
