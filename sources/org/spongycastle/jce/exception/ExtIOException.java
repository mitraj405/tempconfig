package org.spongycastle.jce.exception;

import java.io.IOException;

public class ExtIOException extends IOException implements ExtException {
    public final Throwable getCause() {
        return null;
    }
}
