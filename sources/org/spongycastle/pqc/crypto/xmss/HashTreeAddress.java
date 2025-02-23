package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.XMSSAddress;
import org.spongycastle.util.Pack;

final class HashTreeAddress extends XMSSAddress {
    public final int d;
    public final int e;

    public HashTreeAddress(Builder builder) {
        super(builder);
        this.d = builder.d;
        this.e = builder.e;
    }

    public final byte[] a() {
        byte[] a = super.a();
        Pack.c(0, a, 16);
        Pack.c(this.d, a, 20);
        Pack.c(this.e, a, 24);
        return a;
    }

    public static class Builder extends XMSSAddress.Builder<Builder> {
        public int d = 0;
        public int e = 0;

        public Builder() {
            super(2);
        }

        public final XMSSAddress e() {
            return new HashTreeAddress(this);
        }

        public final XMSSAddress.Builder a() {
            return this;
        }
    }
}
