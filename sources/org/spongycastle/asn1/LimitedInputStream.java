package org.spongycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    public final InputStream a;
    public final int c;

    public LimitedInputStream(InputStream inputStream, int i) {
        this.a = inputStream;
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public final void b() {
        InputStream inputStream = this.a;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            IndefiniteLengthInputStream indefiniteLengthInputStream = (IndefiniteLengthInputStream) inputStream;
            indefiniteLengthInputStream.b = true;
            indefiniteLengthInputStream.c();
        }
    }
}
