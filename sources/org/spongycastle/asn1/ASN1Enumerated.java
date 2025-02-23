package org.spongycastle.asn1;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Properties;

public class ASN1Enumerated extends ASN1Primitive {
    public static final ASN1Enumerated[] a = new ASN1Enumerated[12];

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5657a;

    public ASN1Enumerated(int i) {
        this.f5657a = BigInteger.valueOf((long) i).toByteArray();
    }

    public static ASN1Enumerated q(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof ASN1Enumerated)) {
            return (ASN1Enumerated) aSN1Encodable;
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (ASN1Enumerated) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        return Arrays.a(this.f5657a, ((ASN1Enumerated) aSN1Primitive).f5657a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(10, this.f5657a);
    }

    public final int hashCode() {
        return Arrays.t(this.f5657a);
    }

    public final int i() {
        byte[] bArr = this.f5657a;
        return StreamUtil.a(bArr.length) + 1 + bArr.length;
    }

    public final boolean n() {
        return false;
    }

    public final BigInteger r() {
        return new BigInteger(this.f5657a);
    }

    public ASN1Enumerated(byte[] bArr) {
        byte b;
        if (!Properties.b("org.spongycastle.asn1.allow_unsafe_integer")) {
            boolean z = false;
            if (bArr.length > 1 && (((b = bArr[0]) == 0 && (bArr[1] & UnsignedBytes.MAX_POWER_OF_TWO) == 0) || (b == -1 && (bArr[1] & UnsignedBytes.MAX_POWER_OF_TWO) != 0))) {
                z = true;
            }
            if (z) {
                throw new IllegalArgumentException("malformed enumerated");
            }
        }
        this.f5657a = Arrays.c(bArr);
    }
}
