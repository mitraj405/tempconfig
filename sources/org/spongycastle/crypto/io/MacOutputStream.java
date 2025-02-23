package org.spongycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;

public class MacOutputStream extends OutputStream {
    public final Mac a;

    public MacOutputStream(HMac hMac) {
        this.a = hMac;
    }

    public final void write(int i) throws IOException {
        this.a.d((byte) i);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.update(bArr, i, i2);
    }
}
