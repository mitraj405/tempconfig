package org.spongycastle.asn1;

import java.io.IOException;

public class DERBMPString extends ASN1Primitive implements ASN1String {
    public final char[] a;

    public DERBMPString(char[] cArr) {
        this.a = cArr;
    }

    public final String c() {
        return new String(this.a);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        char[] cArr = ((DERBMPString) aSN1Primitive).a;
        char[] cArr2 = this.a;
        if (cArr2 != cArr) {
            if (cArr2 == null || cArr == null || cArr2.length != cArr.length) {
                return false;
            }
            for (int i = 0; i != cArr2.length; i++) {
                if (cArr2[i] != cArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(30);
        char[] cArr = this.a;
        aSN1OutputStream.f(cArr.length * 2);
        for (int i = 0; i != cArr.length; i++) {
            char c = cArr[i];
            aSN1OutputStream.c((byte) (c >> 8));
            aSN1OutputStream.c((byte) c);
        }
    }

    public final int hashCode() {
        char[] cArr = this.a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    public final int i() {
        char[] cArr = this.a;
        return (cArr.length * 2) + StreamUtil.a(cArr.length * 2) + 1;
    }

    public final boolean n() {
        return false;
    }

    public final String toString() {
        return c();
    }

    public DERBMPString(String str) {
        this.a = str.toCharArray();
    }
}
