package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.util.Pack;

public abstract class XMSSAddress {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final long f6765a;
    public final int b;
    public final int c;

    public static abstract class Builder<T extends Builder> {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public long f6766a = 0;
        public int b = 0;
        public int c = 0;

        public Builder(int i) {
            this.a = i;
        }

        public abstract T a();

        public final T b(int i) {
            this.c = i;
            return a();
        }

        public final T c(int i) {
            this.b = i;
            return a();
        }

        public final T d(long j) {
            this.f6766a = j;
            return a();
        }
    }

    public XMSSAddress(Builder builder) {
        this.a = builder.b;
        this.f6765a = builder.f6766a;
        this.b = builder.a;
        this.c = builder.c;
    }

    public byte[] a() {
        byte[] bArr = new byte[32];
        Pack.c(this.a, bArr, 0);
        Pack.j(this.f6765a, bArr, 4);
        Pack.c(this.b, bArr, 12);
        Pack.c(this.c, bArr, 28);
        return bArr;
    }
}
