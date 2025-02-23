package org.spongycastle.crypto.io;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;

public class MacInputStream extends FilterInputStream {
    public final Mac a;

    public MacInputStream(DataInputStream dataInputStream, HMac hMac) {
        super(dataInputStream);
        this.a = hMac;
    }

    public final int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.a.d((byte) read);
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            this.a.update(bArr, i, read);
        }
        return read;
    }
}
