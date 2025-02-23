package org.spongycastle.util.encoders;

public class Base64Encoder implements Encoder {
    public byte a = 61;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6858a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public final byte[] b = new byte[128];

    public Base64Encoder() {
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
            byte[] bArr2 = this.f6858a;
            if (i < bArr2.length) {
                bArr[bArr2[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    public static int a(int i, int i2, String str) {
        boolean z;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == 10 || charAt == 13 || charAt == 9 || charAt == ' ') {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            i++;
        }
        return i;
    }
}
