package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class SSL3Mac implements Mac {
    public static final byte[] a;
    public static final byte[] b;

    static {
        byte[] bArr = new byte[48];
        Arrays.p(bArr, (byte) 54);
        a = bArr;
        byte[] bArr2 = new byte[48];
        Arrays.p(bArr2, (byte) 92);
        b = bArr2;
    }

    public SSL3Mac() {
        throw null;
    }

    public final void a(CipherParameters cipherParameters) {
        Arrays.c(((KeyParameter) cipherParameters).a);
        throw null;
    }

    public final String b() {
        throw null;
    }

    public final int c(int i, byte[] bArr) {
        throw null;
    }

    public final void d(byte b2) {
        throw null;
    }

    public final int e() {
        throw null;
    }

    public final void reset() {
        throw null;
    }

    public final void update(byte[] bArr, int i, int i2) {
        throw null;
    }
}
