package org.spongycastle.crypto;

public class CryptoException extends Exception {
    public final Throwable a;

    public CryptoException() {
    }

    public final Throwable getCause() {
        return this.a;
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }
}
