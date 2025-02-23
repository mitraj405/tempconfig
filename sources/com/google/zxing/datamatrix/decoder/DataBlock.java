package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        boolean z;
        int i;
        int i2;
        int i3;
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i4 = 0;
        for (Version.ECB count : eCBlocks2) {
            i4 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i4];
        int i5 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            int i6 = 0;
            while (i6 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                dataBlockArr[i5] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i6++;
                i5++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i7 = length - 1;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = 0;
            while (i10 < i5) {
                dataBlockArr[i10].codewords[i9] = bArr[i8];
                i10++;
                i8++;
            }
        }
        if (version.getVersionNumber() == 24) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = 8;
        } else {
            i = i5;
        }
        int i11 = 0;
        while (i11 < i) {
            dataBlockArr[i11].codewords[i7] = bArr[i8];
            i11++;
            i8++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i12 = 0;
            while (i12 < i5) {
                if (z) {
                    i2 = (i12 + 8) % i5;
                } else {
                    i2 = i12;
                }
                if (!z || i2 <= 7) {
                    i3 = length;
                } else {
                    i3 = length - 1;
                }
                dataBlockArr[i2].codewords[i3] = bArr[i8];
                i12++;
                i8++;
            }
            length++;
        }
        if (i8 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
