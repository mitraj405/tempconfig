package org.spongycastle.asn1;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Properties;

public class ASN1Integer extends ASN1Primitive {
    public final byte[] a;

    public ASN1Integer() {
        throw null;
    }

    public ASN1Integer(long j) {
        this.a = BigInteger.valueOf(j).toByteArray();
    }

    public static ASN1Integer q(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Integer) ASN1Primitive.k((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public static ASN1Integer r(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive r = aSN1TaggedObject.r();
        if (z || (r instanceof ASN1Integer)) {
            return q(r);
        }
        return new ASN1Integer(ASN1OctetString.q(aSN1TaggedObject.r()).s(), true);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        return Arrays.a(this.a, ((ASN1Integer) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(2, this.a);
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & UnsignedBytes.MAX_VALUE) << (i % 4);
            i++;
        }
    }

    public final int i() {
        byte[] bArr = this.a;
        return StreamUtil.a(bArr.length) + 1 + bArr.length;
    }

    public final boolean n() {
        return false;
    }

    public final BigInteger s() {
        return new BigInteger(1, this.a);
    }

    public final BigInteger t() {
        return new BigInteger(this.a);
    }

    public final String toString() {
        return t().toString();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.a = bigInteger.toByteArray();
    }

    public ASN1Integer(byte[] bArr, boolean z) {
        byte b;
        if (!Properties.b("org.spongycastle.asn1.allow_unsafe_integer")) {
            boolean z2 = false;
            if (bArr.length > 1 && (((b = bArr[0]) == 0 && (bArr[1] & UnsignedBytes.MAX_POWER_OF_TWO) == 0) || (b == -1 && (bArr[1] & UnsignedBytes.MAX_POWER_OF_TWO) != 0))) {
                z2 = true;
            }
            if (z2) {
                throw new IllegalArgumentException("malformed integer");
            }
        }
        this.a = z ? Arrays.c(bArr) : bArr;
    }
}
