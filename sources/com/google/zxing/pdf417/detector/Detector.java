package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (bitMatrix.get(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else if (patternMatchVariance(iArr2, iArr) < MAX_AVG_VARIANCE) {
                    return new int[]{i6, i};
                } else {
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || patternMatchVariance(iArr2, iArr) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        int i7 = i;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i7) {
                z = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i8, i2, iArr, iArr2);
            if (findGuardPattern != null) {
                int i9 = i8;
                int[] iArr3 = findGuardPattern;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i6 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i4, i11, i2, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i6 = i11 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i10 = i11;
                }
                float f = (float) i6;
                resultPointArr[0] = new ResultPoint((float) iArr3[0], f);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], f);
                z = true;
                i8 = i6;
            } else {
                i8 += 5;
            }
        }
        int i12 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i7) {
                    i5 = i14;
                    break;
                }
                i5 = i14;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i13, i2, iArr, iArr2);
                if (findGuardPattern3 == null || Math.abs(iArr4[0] - findGuardPattern3[0]) >= 5 || Math.abs(iArr4[1] - findGuardPattern3[1]) >= 5) {
                    if (i5 > 25) {
                        break;
                    }
                    i14 = i5 + 1;
                } else {
                    iArr4 = findGuardPattern3;
                    i14 = 0;
                }
                i13++;
            }
            i12 = i13 - (i5 + 1);
            float f2 = (float) i12;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f2);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            i2 = (int) resultPoint.getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2) {
        float f;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = MAX_INDIVIDUAL_VARIANCE * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            if (f7 > f6) {
                f = f7 - f6;
            } else {
                f = f6 - f7;
            }
            if (f > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f;
        }
        return f5 / f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r3.hasNext() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r4 = (com.google.zxing.ResultPoint[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r7 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2 = (int) java.lang.Math.max((float) r2, r7.getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r4 = r4[3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r4 == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r2 = java.lang.Math.max(r2, (int) r4.getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r4 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r3 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0008:
            r4 = r3
        L_0x0009:
            int r5 = r9.getHeight()
            if (r2 >= r5) goto L_0x0077
            com.google.zxing.ResultPoint[] r3 = findVertices(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L_0x004f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L_0x004f
            if (r4 == 0) goto L_0x0077
            java.util.Iterator r3 = r0.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r3.next()
            com.google.zxing.ResultPoint[] r4 = (com.google.zxing.ResultPoint[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L_0x003d
            float r2 = (float) r2
            float r7 = r7.getY()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L_0x003d:
            r4 = r4[r5]
            if (r4 == 0) goto L_0x0023
            float r4 = r4.getY()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L_0x0023
        L_0x004b:
            int r2 = r2 + 5
            r3 = r1
            goto L_0x0008
        L_0x004f:
            r0.add(r3)
            if (r8 == 0) goto L_0x0077
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0065
            float r4 = r4.getX()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.getY()
            goto L_0x0073
        L_0x0065:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.getX()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.getY()
        L_0x0073:
            int r2 = (int) r2
            r3 = r4
            r4 = r6
            goto L_0x0009
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }
}
