package org.spongycastle.pqc.crypto.newhope;

class Reduce {
    public static short a(int i) {
        return (short) (((((i * 12287) & 262143) * 12289) + i) >>> 18);
    }
}
