package org.spongycastle.jce.provider;

import org.spongycastle.jce.exception.ExtException;

public class AnnotatedException extends Exception implements ExtException {
    public final Throwable a;

    public AnnotatedException() {
        throw null;
    }

    public AnnotatedException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
