package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2)) {
            return sizeOfBlackWhiteBlackRunBothWays / 7.0f;
        }
        return (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f)) / 2) + 7;
        int i = round & 3;
        if (i == 0) {
            return round + 1;
        }
        if (i == 2) {
            return round - 1;
        }
        if (i != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f;
        float f2;
        float f3;
        float f4 = ((float) i) - 3.5f;
        if (resultPoint4 != null) {
            f2 = resultPoint4.getX();
            f = resultPoint4.getY();
            f3 = f4 - 3.0f;
        } else {
            float x = resultPoint3.getX() + (resultPoint2.getX() - resultPoint.getX());
            f2 = x;
            f = resultPoint3.getY() + (resultPoint2.getY() - resultPoint.getY());
            f3 = f4;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f2, f, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        Detector detector;
        boolean z3;
        boolean z4 = true;
        if (Math.abs(i4 - i2) > Math.abs(i3 - i)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i14 = 2;
        int i15 = (-abs) / 2;
        int i16 = -1;
        if (i8 < i6) {
            i9 = 1;
        } else {
            i9 = -1;
        }
        if (i7 < i5) {
            i16 = 1;
        }
        int i17 = i6 + i9;
        int i18 = i8;
        int i19 = i7;
        int i20 = 0;
        while (true) {
            if (i18 == i17) {
                i10 = i17;
                i11 = i14;
                break;
            }
            if (z) {
                i12 = i19;
            } else {
                i12 = i18;
            }
            if (z) {
                i13 = i18;
            } else {
                i13 = i19;
            }
            if (i20 == z4) {
                z2 = z;
                z3 = z4;
                i10 = i17;
                detector = this;
            } else {
                detector = this;
                z2 = z;
                i10 = i17;
                z3 = false;
            }
            if (z3 == detector.image.get(i12, i13)) {
                if (i20 == 2) {
                    return MathUtils.distance(i18, i19, i8, i7);
                }
                i20++;
            }
            i15 += abs2;
            if (i15 > 0) {
                if (i19 == i5) {
                    i11 = 2;
                    break;
                }
                i19 += i16;
                i15 -= abs;
            }
            i18 += i9;
            i17 = i10;
            z = z2;
            z4 = true;
            i14 = 2;
        }
        if (i20 == i11) {
            return MathUtils.distance(i10, i5, i8, i7);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else if (i5 >= this.image.getWidth()) {
            f = ((float) ((this.image.getWidth() - 1) - i)) / ((float) (i5 - i));
            i5 = this.image.getWidth() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i7 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i7 < 0) {
            f2 = f3 / ((float) (i2 - i7));
        } else if (i7 >= this.image.getHeight()) {
            f2 = ((float) ((this.image.getHeight() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.image.getHeight() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i, i2, (int) ((((float) (i5 - i)) * f2) + ((float) i)), i6)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.image.getWidth() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.image.getHeight() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.common.DetectorResult processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo r11) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            com.google.zxing.qrcode.detector.FinderPattern r0 = r11.getTopLeft()
            com.google.zxing.qrcode.detector.FinderPattern r1 = r11.getTopRight()
            com.google.zxing.qrcode.detector.FinderPattern r11 = r11.getBottomLeft()
            float r2 = r10.calculateModuleSize(r0, r1, r11)
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 < 0) goto L_0x009e
            int r4 = computeDimension(r0, r1, r11, r2)
            com.google.zxing.qrcode.decoder.Version r5 = com.google.zxing.qrcode.decoder.Version.getProvisionalVersionForDimension(r4)
            int r6 = r5.getDimensionForVersion()
            int r6 = r6 + -7
            int[] r5 = r5.getAlignmentPatternCenters()
            int r5 = r5.length
            r7 = 4
            if (r5 <= 0) goto L_0x0073
            float r5 = r1.getX()
            float r8 = r0.getX()
            float r5 = r5 - r8
            float r8 = r11.getX()
            float r8 = r8 + r5
            float r5 = r1.getY()
            float r9 = r0.getY()
            float r5 = r5 - r9
            float r9 = r11.getY()
            float r9 = r9 + r5
            r5 = 1077936128(0x40400000, float:3.0)
            float r6 = (float) r6
            float r5 = r5 / r6
            float r3 = r3 - r5
            float r5 = r0.getX()
            float r6 = r0.getX()
            float r8 = r8 - r6
            float r8 = r8 * r3
            float r8 = r8 + r5
            int r5 = (int) r8
            float r6 = r0.getY()
            float r8 = r0.getY()
            float r9 = r9 - r8
            float r9 = r9 * r3
            float r9 = r9 + r6
            int r3 = (int) r9
            r6 = r7
        L_0x0066:
            r8 = 16
            if (r6 > r8) goto L_0x0073
            float r8 = (float) r6
            com.google.zxing.qrcode.detector.AlignmentPattern r2 = r10.findAlignmentInRegion(r2, r5, r3, r8)     // Catch:{ NotFoundException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            int r6 = r6 << 1
            goto L_0x0066
        L_0x0073:
            r2 = 0
        L_0x0074:
            com.google.zxing.common.PerspectiveTransform r3 = createTransform(r0, r1, r11, r2, r4)
            com.google.zxing.common.BitMatrix r5 = r10.image
            com.google.zxing.common.BitMatrix r3 = sampleGrid(r5, r3, r4)
            r4 = 3
            r5 = 2
            r6 = 0
            r8 = 1
            if (r2 != 0) goto L_0x008d
            com.google.zxing.ResultPoint[] r2 = new com.google.zxing.ResultPoint[r4]
            r2[r6] = r11
            r2[r8] = r0
            r2[r5] = r1
            goto L_0x0098
        L_0x008d:
            com.google.zxing.ResultPoint[] r7 = new com.google.zxing.ResultPoint[r7]
            r7[r6] = r11
            r7[r8] = r0
            r7[r5] = r1
            r7[r4] = r2
            r2 = r7
        L_0x0098:
            com.google.zxing.common.DetectorResult r11 = new com.google.zxing.common.DetectorResult
            r11.<init>(r3, r2)
            return r11
        L_0x009e:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo):com.google.zxing.common.DetectorResult");
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback2;
        if (map == null) {
            resultPointCallback2 = null;
        } else {
            resultPointCallback2 = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback2;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }
}
