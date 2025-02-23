package org.spongycastle.util.encoders;

public class EncoderException extends IllegalStateException {
    public final Throwable a;

    public EncoderException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
