package org.spongycastle.util.encoders;

public class HexEncoder implements Encoder {
    public final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public final byte[] b = new byte[128];

    public HexEncoder() {
        byte[] bArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            bArr = this.b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.a;
            if (i < bArr2.length) {
                bArr[bArr2[i]] = (byte) i;
                i++;
            } else {
                bArr[65] = bArr[97];
                bArr[66] = bArr[98];
                bArr[67] = bArr[99];
                bArr[68] = bArr[100];
                bArr[69] = bArr[101];
                bArr[70] = bArr[102];
                return;
            }
        }
    }

    public static boolean a(char c) {
        if (c == 10 || c == 13 || c == 9 || c == ' ') {
            return true;
        }
        return false;
    }
}
