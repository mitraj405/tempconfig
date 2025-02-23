package org.spongycastle.asn1;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Arrays;

public abstract class ASN1BitString extends ASN1Primitive implements ASN1String {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5654a;
    public final int c;

    public ASN1BitString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data cannot be null");
        } else if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.f5654a = Arrays.c(bArr);
            this.c = i;
        }
    }

    public static byte[] q(int i, byte[] bArr) {
        byte[] c2 = Arrays.c(bArr);
        if (i > 0) {
            int length = bArr.length - 1;
            c2[length] = (byte) ((Constants.MAX_HOST_LENGTH << i) & c2[length]);
        }
        return c2;
    }

    public final String c() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).g(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                char[] cArr = a;
                stringBuffer.append(cArr[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i] & Ascii.SI]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new ASN1ParsingException(C0709Uj.g(e, new StringBuilder("Internal error encoding BitString: ")), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (org.spongycastle.asn1.ASN1BitString) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(org.spongycastle.asn1.ASN1Primitive r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof org.spongycastle.asn1.ASN1BitString
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.spongycastle.asn1.ASN1BitString r4 = (org.spongycastle.asn1.ASN1BitString) r4
            int r0 = r4.c
            int r2 = r3.c
            if (r2 != r0) goto L_0x001d
            byte[] r0 = r3.r()
            byte[] r4 = r4.r()
            boolean r4 = org.spongycastle.util.Arrays.a(r0, r4)
            if (r4 == 0) goto L_0x001d
            r1 = 1
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1BitString.g(org.spongycastle.asn1.ASN1Primitive):boolean");
    }

    public final int hashCode() {
        return Arrays.t(r()) ^ this.c;
    }

    public final ASN1Primitive o() {
        return new DERBitString(this.f5654a, this.c);
    }

    public final ASN1Primitive p() {
        return new DLBitString(this.f5654a, this.c);
    }

    public final byte[] r() {
        return q(this.c, this.f5654a);
    }

    public final byte[] s() {
        if (this.c == 0) {
            return Arrays.c(this.f5654a);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public final int t() {
        byte[] bArr = this.f5654a;
        int i = this.c;
        if (i > 0 && bArr.length <= 4) {
            bArr = q(i, bArr);
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 != bArr.length && i2 != 4) {
            i3 |= (bArr[i2] & UnsignedBytes.MAX_VALUE) << (i2 * 8);
            i2++;
        }
        return i3;
    }

    public String toString() {
        return c();
    }
}
