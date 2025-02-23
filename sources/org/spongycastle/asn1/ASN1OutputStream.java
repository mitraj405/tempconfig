package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream {
    public final OutputStream a;

    public class ImplicitOutputStream extends ASN1OutputStream {
        public boolean a = true;

        public ImplicitOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public final void c(int i) throws IOException {
            if (this.a) {
                this.a = false;
            } else {
                ASN1OutputStream.super.c(i);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.a = outputStream;
    }

    public DEROutputStream a() {
        return new DEROutputStream(this.a);
    }

    public ASN1OutputStream b() {
        return new DLOutputStream(this.a);
    }

    public void c(int i) throws IOException {
        this.a.write(i);
    }

    public final void d(int i, byte[] bArr) throws IOException {
        c(i);
        f(bArr.length);
        this.a.write(bArr);
    }

    public final void e(ASN1Primitive aSN1Primitive) throws IOException {
        aSN1Primitive.h(new ImplicitOutputStream(this.a));
    }

    public final void f(int i) throws IOException {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            c((byte) (i3 | 128));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                c((byte) (i >> i4));
            }
            return;
        }
        c((byte) i);
    }

    public void g(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            aSN1Encodable.b().h(this);
            return;
        }
        throw new IOException("null object detected");
    }

    public final void h(int i, int i2) throws IOException {
        if (i2 < 31) {
            c(i | i2);
            return;
        }
        c(i | 31);
        if (i2 < 128) {
            c(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 4;
        bArr[4] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            i3--;
            bArr[i3] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        this.a.write(bArr, i3, 5 - i3);
    }
}
