package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.BCStyle;

public class GeneralName extends ASN1Object implements ASN1Choice {
    public final ASN1Encodable a;
    public final int c;

    public GeneralName(X500Name x500Name) {
        this.a = x500Name;
        this.c = 4;
    }

    public static GeneralName g(Object obj) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (obj == null || (obj instanceof GeneralName)) {
            return (GeneralName) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
            int i = aSN1TaggedObject.c;
            switch (i) {
                case 0:
                    return new GeneralName(i, ASN1Sequence.r(aSN1TaggedObject, false));
                case 1:
                    return new GeneralName(i, DERIA5String.r(aSN1TaggedObject));
                case 2:
                    return new GeneralName(i, DERIA5String.r(aSN1TaggedObject));
                case 3:
                    throw new IllegalArgumentException(lf.h("unknown tag: ", i));
                case 4:
                    BCStyle bCStyle = X500Name.a;
                    return new GeneralName(i, X500Name.g(ASN1Sequence.r(aSN1TaggedObject, true)));
                case 5:
                    return new GeneralName(i, ASN1Sequence.r(aSN1TaggedObject, false));
                case 6:
                    return new GeneralName(i, DERIA5String.r(aSN1TaggedObject));
                case 7:
                    return new GeneralName(i, ASN1OctetString.r(aSN1TaggedObject, false));
                case 8:
                    ConcurrentHashMap concurrentHashMap = ASN1ObjectIdentifier.a;
                    ASN1Primitive r = aSN1TaggedObject.r();
                    if (r instanceof ASN1ObjectIdentifier) {
                        aSN1ObjectIdentifier = ASN1ObjectIdentifier.u(r);
                    } else {
                        aSN1ObjectIdentifier = ASN1ObjectIdentifier.s(ASN1OctetString.q(aSN1TaggedObject.r()).s());
                    }
                    return new GeneralName(i, aSN1ObjectIdentifier);
            }
        }
        if (obj instanceof byte[]) {
            try {
                return g(ASN1Primitive.k((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public final ASN1Primitive b() {
        ASN1Encodable aSN1Encodable = this.a;
        int i = this.c;
        if (i == 4) {
            return new DERTaggedObject(true, i, aSN1Encodable);
        }
        return new DERTaggedObject(false, i, aSN1Encodable);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.c;
        stringBuffer.append(i);
        stringBuffer.append(": ");
        ASN1Encodable aSN1Encodable = this.a;
        if (!(i == 1 || i == 2)) {
            if (i == 4) {
                stringBuffer.append(X500Name.g(aSN1Encodable).toString());
            } else if (i != 6) {
                stringBuffer.append(aSN1Encodable.toString());
            }
            return stringBuffer.toString();
        }
        stringBuffer.append(DERIA5String.q(aSN1Encodable).c());
        return stringBuffer.toString();
    }

    public GeneralName(int i, ASN1Object aSN1Object) {
        this.a = aSN1Object;
        this.c = i;
    }

    public GeneralName(String str) {
        this.c = 1;
        this.a = new DERIA5String(str);
    }
}
