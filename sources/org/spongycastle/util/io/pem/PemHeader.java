package org.spongycastle.util.io.pem;

public class PemHeader {
    public final boolean equals(Object obj) {
        if (!(obj instanceof PemHeader)) {
            return false;
        }
        PemHeader pemHeader = (PemHeader) obj;
        if (pemHeader == this) {
            return true;
        }
        pemHeader.getClass();
        return true;
    }

    public final int hashCode() {
        return 32;
    }
}
