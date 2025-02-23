package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERIA5String extends ASN1Primitive implements ASN1String {
    public final byte[] a;

    public DERIA5String() {
        throw null;
    }

    public DERIA5String(byte[] bArr) {
        this.a = bArr;
    }

    public static DERIA5String q(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof DERIA5String)) {
            return (DERIA5String) aSN1Encodable;
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (DERIA5String) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public static DERIA5String r(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Primitive r = aSN1TaggedObject.r();
        if (r instanceof DERIA5String) {
            return q(r);
        }
        return new DERIA5String(((ASN1OctetString) r).s());
    }

    public final String c() {
        return Strings.a(this.a);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERIA5String)) {
            return false;
        }
        return Arrays.a(this.a, ((DERIA5String) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(22, this.a);
    }

    public final int hashCode() {
        return Arrays.t(this.a);
    }

    public final int i() {
        byte[] bArr = this.a;
        return StreamUtil.a(bArr.length) + 1 + bArr.length;
    }

    public final boolean n() {
        return false;
    }

    public String toString() {
        return c();
    }

    public DERIA5String(String str) {
        if (str != null) {
            this.a = Strings.d(str);
            return;
        }
        throw new NullPointerException("string cannot be null");
    }
}
