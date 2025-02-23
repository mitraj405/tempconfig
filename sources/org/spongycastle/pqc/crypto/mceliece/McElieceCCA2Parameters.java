package org.spongycastle.pqc.crypto.mceliece;

public class McElieceCCA2Parameters extends McElieceParameters {
    public final String c;

    public McElieceCCA2Parameters() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2Parameters(int i, int i2, String str) {
        super(i, i2);
        this.c = str;
    }
}
