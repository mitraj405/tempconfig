package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString extends BEROctetString {
    public final byte[] s() {
        return this.a;
    }

    public final Enumeration t() {
        int i;
        Vector vector = new Vector();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                return vector.elements();
            }
            int i3 = i2 + 1000;
            if (i3 > bArr.length) {
                i = bArr.length;
            } else {
                i = i3;
            }
            int i4 = i - i2;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, i4);
            vector.addElement(new DEROctetString(bArr2));
            i2 = i3;
        }
    }
}
