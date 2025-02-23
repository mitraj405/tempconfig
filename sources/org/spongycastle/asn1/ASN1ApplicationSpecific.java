package org.spongycastle.asn1;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import org.spongycastle.util.Arrays;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    public final boolean a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5653a;
    public final int c;

    public ASN1ApplicationSpecific(byte[] bArr, int i, boolean z) {
        this.a = z;
        this.c = i;
        this.f5653a = Arrays.c(bArr);
    }

    public static ASN1ApplicationSpecific q(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return q(ASN1Primitive.k((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("Failed to construct object from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (org.spongycastle.asn1.ASN1ApplicationSpecific) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(org.spongycastle.asn1.ASN1Primitive r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof org.spongycastle.asn1.ASN1ApplicationSpecific
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.spongycastle.asn1.ASN1ApplicationSpecific r4 = (org.spongycastle.asn1.ASN1ApplicationSpecific) r4
            boolean r0 = r4.a
            boolean r2 = r3.a
            if (r2 != r0) goto L_0x001f
            int r0 = r3.c
            int r2 = r4.c
            if (r0 != r2) goto L_0x001f
            byte[] r0 = r3.f5653a
            byte[] r4 = r4.f5653a
            boolean r4 = org.spongycastle.util.Arrays.a(r0, r4)
            if (r4 == 0) goto L_0x001f
            r1 = 1
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1ApplicationSpecific.g(org.spongycastle.asn1.ASN1Primitive):boolean");
    }

    public void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        int i;
        if (this.a) {
            i = 96;
        } else {
            i = 64;
        }
        aSN1OutputStream.h(i, this.c);
        byte[] bArr = this.f5653a;
        aSN1OutputStream.f(bArr.length);
        aSN1OutputStream.a.write(bArr);
    }

    public final int hashCode() {
        return (this.c ^ this.a) ^ Arrays.t(this.f5653a) ? 1 : 0;
    }

    public final int i() throws IOException {
        int b = StreamUtil.b(this.c);
        byte[] bArr = this.f5653a;
        return b + StreamUtil.a(bArr.length) + bArr.length;
    }

    public final boolean n() {
        return this.a;
    }

    public final ASN1Primitive r() throws IOException {
        int i;
        byte[] e = e();
        if ((e[0] & Ascii.US) == 31) {
            byte b = e[1] & UnsignedBytes.MAX_VALUE;
            if ((b & Ascii.DEL) != 0) {
                i = 2;
                while (b >= 0 && (b & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                    byte b2 = e[i] & UnsignedBytes.MAX_VALUE;
                    i++;
                    b = b2;
                }
            } else {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
        } else {
            i = 1;
        }
        int length = (e.length - i) + 1;
        byte[] bArr = new byte[length];
        System.arraycopy(e, i, bArr, 1, length - 1);
        byte b3 = (byte) 16;
        bArr[0] = b3;
        if ((e[0] & 32) != 0) {
            bArr[0] = (byte) (b3 | 32);
        }
        return ASN1Primitive.k(bArr);
    }
}
