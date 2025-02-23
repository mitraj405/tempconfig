package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

class LazyEncodedSequence extends ASN1Sequence {
    public byte[] a;

    public LazyEncodedSequence(byte[] bArr) throws IOException {
        this.a = bArr;
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] bArr = this.a;
        if (bArr != null) {
            aSN1OutputStream.d(48, bArr);
        } else {
            super.p().h(aSN1OutputStream);
        }
    }

    public final int i() throws IOException {
        byte[] bArr = this.a;
        if (bArr != null) {
            return StreamUtil.a(bArr.length) + 1 + this.a.length;
        }
        return super.p().i();
    }

    public final ASN1Primitive o() {
        if (this.a != null) {
            v();
        }
        return super.o();
    }

    public final ASN1Primitive p() {
        if (this.a != null) {
            v();
        }
        return super.p();
    }

    public final synchronized ASN1Encodable s(int i) {
        if (this.a != null) {
            v();
        }
        return super.s(i);
    }

    public final synchronized int size() {
        if (this.a != null) {
            v();
        }
        return super.size();
    }

    public final synchronized Enumeration t() {
        byte[] bArr = this.a;
        if (bArr == null) {
            return super.t();
        }
        return new LazyConstructionEnumeration(bArr);
    }

    public final void v() {
        LazyConstructionEnumeration lazyConstructionEnumeration = new LazyConstructionEnumeration(this.a);
        while (lazyConstructionEnumeration.hasMoreElements()) {
            this.a.addElement(lazyConstructionEnumeration.nextElement());
        }
        this.a = null;
    }
}
