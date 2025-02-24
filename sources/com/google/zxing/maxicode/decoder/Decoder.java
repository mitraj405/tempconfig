package com.google.zxing.maxicode.decoder;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    private void correctErrors(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5;
        int i6 = i2 + i3;
        if (i4 == 0) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        int[] iArr = new int[(i6 / i5)];
        for (int i7 = 0; i7 < i6; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i5] = bArr[i7 + i] & UnsignedBytes.MAX_VALUE;
            }
        }
        try {
            this.rsDecoder.decode(iArr, i3 / i5);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i5];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] readCodewords = new BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(readCodewords, 0, 10, 10, 0);
        byte b = readCodewords[0] & Ascii.SI;
        if (b == 2 || b == 3 || b == 4) {
            byte[] bArr2 = readCodewords;
            correctErrors(bArr2, 20, 84, 40, 1);
            correctErrors(bArr2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (b == 5) {
            byte[] bArr3 = readCodewords;
            correctErrors(bArr3, 20, 68, 56, 1);
            correctErrors(bArr3, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw FormatException.getFormatInstance();
        }
        System.arraycopy(readCodewords, 0, bArr, 0, 10);
        System.arraycopy(readCodewords, 20, bArr, 10, bArr.length - 10);
        return DecodedBitStreamParser.decode(bArr, b);
    }
}
