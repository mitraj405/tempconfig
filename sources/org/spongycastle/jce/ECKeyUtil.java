package org.spongycastle.jce;

public class ECKeyUtil {

    public static class UnexpectedException extends RuntimeException {
        public final Throwable getCause() {
            return null;
        }
    }
}
