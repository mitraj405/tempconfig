package org.spongycastle.util;

public class MemoableResetException extends ClassCastException {
    public MemoableResetException() {
        super("digestLength inappropriate in other");
    }
}
