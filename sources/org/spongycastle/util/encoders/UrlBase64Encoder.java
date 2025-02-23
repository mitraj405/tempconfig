package org.spongycastle.util.encoders;

public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr;
        byte[] bArr2 = this.f6858a;
        bArr2[bArr2.length - 2] = 45;
        bArr2[bArr2.length - 1] = 95;
        this.a = 46;
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
            byte[] bArr3 = this.f6858a;
            if (i < bArr3.length) {
                bArr[bArr3[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }
}
