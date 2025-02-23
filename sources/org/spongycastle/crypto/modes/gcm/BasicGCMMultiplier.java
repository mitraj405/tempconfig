package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Pack;

public class BasicGCMMultiplier implements GCMMultiplier {
    public int[] a;

    public final void a(byte[] bArr) {
        int[] a2 = GCMUtil.a(bArr);
        GCMUtil.b(a2, this.a);
        Pack.d(bArr, a2);
    }

    public final void b(byte[] bArr) {
        this.a = GCMUtil.a(bArr);
    }
}
