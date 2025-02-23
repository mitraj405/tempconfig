package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    public final byte[] a;

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.a = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public static ASN1OctetString q(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return q(ASN1Primitive.k((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct OCTET STRING from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive b = ((ASN1Encodable) obj).b();
                if (b instanceof ASN1OctetString) {
                    return (ASN1OctetString) b;
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public static ASN1OctetString r(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive r = aSN1TaggedObject.r();
        if (z || (r instanceof ASN1OctetString)) {
            return q(r);
        }
        ASN1Sequence q = ASN1Sequence.q(r);
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[q.size()];
        Enumeration t = q.t();
        int i = 0;
        while (t.hasMoreElements()) {
            aSN1OctetStringArr[i] = (ASN1OctetString) t.nextElement();
            i++;
        }
        return new BEROctetString(aSN1OctetStringArr);
    }

    public final InputStream d() {
        return new ByteArrayInputStream(this.a);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        return Arrays.a(this.a, ((ASN1OctetString) aSN1Primitive).a);
    }

    public final int hashCode() {
        return Arrays.t(s());
    }

    public final ASN1Primitive o() {
        return new DEROctetString(this.a);
    }

    public final ASN1Primitive p() {
        return new DEROctetString(this.a);
    }

    public byte[] s() {
        return this.a;
    }

    public final String toString() {
        return "#".concat(Strings.a(Hex.c(this.a)));
    }

    public final ASN1Primitive a() {
        return this;
    }
}
