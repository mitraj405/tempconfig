package org.spongycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

public class NullDigest implements Digest {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    public final String b() {
        return "NULL";
    }

    public final int c(int i, byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
        reset();
        return byteArray.length;
    }

    public final void d(byte b) {
        this.a.write(b);
    }

    public final int f() {
        return this.a.size();
    }

    public final void reset() {
        this.a.reset();
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }
}
