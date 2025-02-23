package org.spongycastle.crypto;

public interface CharToByteConverter {
    byte[] a(char[] cArr);

    String getType();
}
