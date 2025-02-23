package org.spongycastle.util.encoders;

public class DecoderException extends IllegalStateException {
    public final Throwable a;

    public DecoderException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
