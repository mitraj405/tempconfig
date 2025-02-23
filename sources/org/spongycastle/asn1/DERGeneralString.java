package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERGeneralString extends ASN1Primitive implements ASN1String {
    public final byte[] a;

    public DERGeneralString(byte[] bArr) {
        this.a = bArr;
    }

    public final String c() {
        return Strings.a(this.a);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERGeneralString)) {
            return false;
        }
        return Arrays.a(this.a, ((DERGeneralString) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(27, this.a);
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

    public final String toString() {
        return c();
    }
}
