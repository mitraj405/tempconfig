package org.spongycastle.crypto.tls;

import java.io.IOException;

public class TlsException extends IOException {
    public final Throwable getCause() {
        return null;
    }
}
