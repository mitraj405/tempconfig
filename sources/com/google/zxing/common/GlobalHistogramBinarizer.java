package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets = new int[32];
    private byte[] luminances = EMPTY;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 > length / 16) {
            int i12 = i3 - 1;
            int i13 = -1;
            int i14 = i12;
            while (i12 > i6) {
                int i15 = i12 - i6;
                int i16 = (i2 - iArr[i12]) * (i3 - i12) * i15 * i15;
                if (i16 > i13) {
                    i14 = i12;
                    i13 = i16;
                }
                i12--;
            }
            return i14 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i = 1; i < 5; i++) {
            byte[] row = luminanceSource.getRow((height * i) / 5, this.luminances);
            int i2 = (width << 2) / 5;
            for (int i3 = width / 5; i3 < i2; i3++) {
                int i4 = (row[i3] & UnsignedBytes.MAX_VALUE) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i5 * width;
            for (int i7 = 0; i7 < width; i7++) {
                if ((matrix[i6 + i7] & UnsignedBytes.MAX_VALUE) < estimateBlackPoint) {
                    bitMatrix.set(i7, i5);
                }
            }
        }
        return bitMatrix;
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        for (int i2 = 0; i2 < width; i2++) {
            int i3 = (row[i2] & UnsignedBytes.MAX_VALUE) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i4 = 0; i4 < width; i4++) {
                if ((row[i4] & UnsignedBytes.MAX_VALUE) < estimateBlackPoint) {
                    bitArray.set(i4);
                }
            }
        } else {
            int i5 = 1;
            byte b = row[0] & UnsignedBytes.MAX_VALUE;
            byte b2 = row[1] & UnsignedBytes.MAX_VALUE;
            while (i5 < width - 1) {
                int i6 = i5 + 1;
                byte b3 = row[i6] & UnsignedBytes.MAX_VALUE;
                if ((((b2 << 2) - b) - b3) / 2 < estimateBlackPoint) {
                    bitArray.set(i5);
                }
                b = b2;
                i5 = i6;
                b2 = b3;
            }
        }
        return bitArray;
    }
}
