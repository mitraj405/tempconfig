package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.XMSSAddress;
import org.spongycastle.util.Pack;

final class LTreeAddress extends XMSSAddress {
    public final int d;
    public final int e;
    public final int f;

    public LTreeAddress(Builder builder) {
        super(builder);
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    public final byte[] a() {
        byte[] a = super.a();
        Pack.c(this.d, a, 16);
        Pack.c(this.e, a, 20);
        Pack.c(this.f, a, 24);
        return a;
    }

    public static class Builder extends XMSSAddress.Builder<Builder> {
        public int d = 0;
        public int e = 0;
        public int f = 0;

        public Builder() {
            super(1);
        }

        public final XMSSAddress.Builder a() {
            return this;
        }
    }
}
