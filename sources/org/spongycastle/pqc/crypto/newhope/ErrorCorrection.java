package org.spongycastle.pqc.crypto.newhope;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import org.spongycastle.util.Arrays;

class ErrorCorrection {
    public static int a(int i, int i2, int i3, int[] iArr) {
        int i4 = (i3 * 2730) >> 25;
        int i5 = i4 - ((12288 - (i3 - (i4 * 12289))) >> 31);
        iArr[i] = (i5 >> 1) + (i5 & 1);
        int i6 = i5 - 1;
        iArr[i2] = (i6 >> 1) + (i6 & 1);
        int i7 = i3 - ((iArr[i] * 2) * 12289);
        int i8 = i7 >> 31;
        return (i7 ^ i8) - i8;
    }

    public static int b(int i) {
        int i2 = (i * 2730) >> 27;
        int i3 = i2 - ((49155 - (i - (49156 * i2))) >> 31);
        int i4 = (((i3 >> 1) + (i3 & 1)) * 98312) - i;
        int i5 = i4 >> 31;
        return (i4 ^ i5) - i5;
    }

    public static void c(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.p(bArr, (byte) 0);
        for (int i = 0; i < 256; i++) {
            int i2 = i + 0;
            int i3 = i + ViewUtils.EDGE_TO_EDGE_FLAGS;
            short s = sArr2[i3];
            int i4 = ((sArr[i2] * 8) + 196624) - (((sArr2[i2] * 2) + s) * 12289);
            int i5 = i + 256;
            int i6 = ((sArr[i5] * 8) + 196624) - (((sArr2[i5] * 2) + s) * 12289);
            int i7 = i + AdRequest.MAX_CONTENT_URL_LENGTH;
            int i8 = ((sArr[i7] * 8) + 196624) - (((sArr2[i7] * 2) + s) * 12289);
            int i9 = ((sArr[i3] * 8) + 196624) - (s * 12289);
            int i10 = i >>> 3;
            bArr[i10] = (byte) ((((short) (((((b(i4) + b(i6)) + b(i8)) + b(i9)) - 98312) >>> 31)) << (i & 7)) | bArr[i10]);
        }
    }
}
