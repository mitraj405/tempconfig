package org.spongycastle.crypto.io;

import java.io.IOException;

public class CipherIOException extends IOException {
    private static final long serialVersionUID = 1;
    public final Throwable a;

    public CipherIOException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
