package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class ASN1UTCTime extends ASN1Primitive {
    public final byte[] a;

    public ASN1UTCTime(byte[] bArr) {
        this.a = bArr;
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            return false;
        }
        return Arrays.a(this.a, ((ASN1UTCTime) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(23);
        byte[] bArr = this.a;
        int length = bArr.length;
        aSN1OutputStream.f(length);
        for (int i = 0; i != length; i++) {
            aSN1OutputStream.c(bArr[i]);
        }
    }

    public final int hashCode() {
        return Arrays.t(this.a);
    }

    public final int i() {
        int length = this.a.length;
        return StreamUtil.a(length) + 1 + length;
    }

    public final boolean n() {
        return false;
    }

    public final String q() {
        String a2 = Strings.a(this.a);
        if (a2.indexOf(45) >= 0 || a2.indexOf(43) >= 0) {
            int indexOf = a2.indexOf(45);
            if (indexOf < 0) {
                indexOf = a2.indexOf(43);
            }
            if (indexOf == a2.length() - 3) {
                a2 = a2.concat("00");
            }
            if (indexOf == 10) {
                return a2.substring(0, 10) + "00GMT" + a2.substring(10, 13) + ":" + a2.substring(13, 15);
            }
            return a2.substring(0, 12) + "GMT" + a2.substring(12, 15) + ":" + a2.substring(15, 17);
        } else if (a2.length() == 11) {
            return a2.substring(0, 10) + "00GMT+00:00";
        } else {
            return a2.substring(0, 12) + "GMT+00:00";
        }
    }

    public final String toString() {
        return Strings.a(this.a);
    }
}
