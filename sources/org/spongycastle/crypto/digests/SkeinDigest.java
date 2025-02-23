package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Memoable;

public class SkeinDigest implements ExtendedDigest, Memoable {
    public final SkeinEngine a;

    public SkeinDigest(int i, int i2) {
        SkeinEngine skeinEngine = new SkeinEngine(i, i2);
        this.a = skeinEngine;
        skeinEngine.d((SkeinParameters) null);
    }

    public final Memoable a() {
        return new SkeinDigest(this);
    }

    public final String b() {
        StringBuilder sb = new StringBuilder("Skein-");
        SkeinEngine skeinEngine = this.a;
        sb.append(skeinEngine.f5861a.f6057a * 8);
        sb.append("-");
        sb.append(skeinEngine.f5859a * 8);
        return sb.toString();
    }

    public final int c(int i, byte[] bArr) {
        return this.a.c(i, bArr);
    }

    public final void d(byte b) {
        SkeinEngine skeinEngine = this.a;
        byte[] bArr = skeinEngine.b;
        bArr[0] = b;
        skeinEngine.j(bArr, 0, 1);
    }

    public final void e(Memoable memoable) {
        this.a.e(((SkeinDigest) memoable).a);
    }

    public final int f() {
        return this.a.f5859a;
    }

    public final int h() {
        return this.a.f5861a.f6057a;
    }

    public final void reset() {
        SkeinEngine skeinEngine = this.a;
        long[] jArr = skeinEngine.f5865b;
        long[] jArr2 = skeinEngine.f5863a;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        skeinEngine.i(48);
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.a.j(bArr, i, i2);
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.a = new SkeinEngine(skeinDigest.a);
    }
}
