package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERUTF8String extends ASN1Primitive implements ASN1String {
    public final byte[] a;

    public DERUTF8String(byte[] bArr) {
        this.a = bArr;
    }

    public static DERUTF8String q(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof DERUTF8String)) {
            return (DERUTF8String) aSN1Encodable;
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (DERUTF8String) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public final String c() {
        return Strings.b(this.a);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTF8String)) {
            return false;
        }
        return Arrays.a(this.a, ((DERUTF8String) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(12, this.a);
    }

    public final int hashCode() {
        return Arrays.t(this.a);
    }

    public final int i() throws IOException {
        byte[] bArr = this.a;
        return StreamUtil.a(bArr.length) + 1 + bArr.length;
    }

    public final boolean n() {
        return false;
    }

    public final String toString() {
        return c();
    }

    public DERUTF8String(String str) {
        String str2 = Strings.a;
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Strings.f(byteArrayOutputStream, charArray);
            this.a = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }
}
