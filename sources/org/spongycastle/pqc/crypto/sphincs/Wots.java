package org.spongycastle.pqc.crypto.sphincs;

class Wots {
    public static void a(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        for (int i5 = 0; i5 < 32; i5++) {
            bArr[i5 + i] = bArr2[i5 + i2];
        }
        int i6 = 0;
        while (i6 < i4 && i6 < 16) {
            int i7 = (i6 * 32) + i3;
            byte[] bArr4 = new byte[32];
            for (int i8 = 0; i8 < 32; i8++) {
                bArr4[i8] = (byte) (bArr[i + i8] ^ bArr3[i7 + i8]);
            }
            hashFunctions.b(i, 0, bArr, bArr4);
            i6++;
        }
    }
}
