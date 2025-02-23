package org.spongycastle.asn1;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import org.spongycastle.util.Arrays;

public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean a = new ASN1Boolean(false);
    public static final ASN1Boolean b = new ASN1Boolean(true);

    /* renamed from: b  reason: collision with other field name */
    public static final byte[] f5655b = {-1};
    public static final byte[] c = {0};

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5656a;

    public ASN1Boolean(byte[] bArr) {
        if (bArr.length == 1) {
            byte b2 = bArr[0];
            if (b2 == 0) {
                this.f5656a = c;
            } else if ((b2 & UnsignedBytes.MAX_VALUE) == 255) {
                this.f5656a = f5655b;
            } else {
                this.f5656a = Arrays.c(bArr);
            }
        } else {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
    }

    public static ASN1Boolean q(byte[] bArr) {
        if (bArr.length == 1) {
            byte b2 = bArr[0];
            if (b2 == 0) {
                return a;
            }
            if ((b2 & UnsignedBytes.MAX_VALUE) == 255) {
                return b;
            }
            return new ASN1Boolean(bArr);
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean r(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof ASN1Boolean)) {
            return (ASN1Boolean) aSN1Encodable;
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (ASN1Boolean) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct boolean from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public static ASN1Boolean s(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Primitive r = aSN1TaggedObject.r();
        if (r instanceof ASN1Boolean) {
            return r(r);
        }
        return q(((ASN1OctetString) r).s());
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Boolean) || this.f5656a[0] != ((ASN1Boolean) aSN1Primitive).f5656a[0]) {
            return false;
        }
        return true;
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(1, this.f5656a);
    }

    public final int hashCode() {
        return this.f5656a[0];
    }

    public final int i() {
        return 3;
    }

    public final boolean n() {
        return false;
    }

    public final boolean t() {
        if (this.f5656a[0] != 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        if (this.f5656a[0] != 0) {
            return "TRUE";
        }
        return "FALSE";
    }

    public ASN1Boolean(boolean z) {
        this.f5656a = z ? f5655b : c;
    }
}
