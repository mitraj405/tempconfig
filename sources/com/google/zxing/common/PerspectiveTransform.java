package com.google.zxing.common;

public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a11 = f;
        this.a12 = f4;
        this.a13 = f7;
        this.a21 = f2;
        this.a22 = f5;
        this.a23 = f8;
        this.a31 = f3;
        this.a32 = f6;
        this.a33 = f9;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return squareToQuadrilateral(f9, f10, f11, f12, f13, f14, f15, f16).times(quadrilateralToSquare(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return squareToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new PerspectiveTransform(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new PerspectiveTransform((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }

    public PerspectiveTransform buildAdjoint() {
        float f = this.a22;
        float f2 = this.a33;
        float f3 = this.a23;
        float f4 = this.a32;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.a31;
        float f7 = this.a21;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.a13;
        float f11 = this.a12;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.a11;
        return new PerspectiveTransform(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    public PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        PerspectiveTransform perspectiveTransform2 = perspectiveTransform;
        float f = this.a11;
        float f2 = perspectiveTransform2.a11;
        float f3 = this.a21;
        float f4 = perspectiveTransform2.a12;
        float f5 = this.a31;
        float f6 = perspectiveTransform2.a13;
        float f7 = (f3 * f4) + (f * f2) + (f5 * f6);
        float f8 = perspectiveTransform2.a21;
        float f9 = perspectiveTransform2.a22;
        float f10 = perspectiveTransform2.a23;
        float f11 = (f3 * f9) + (f * f8) + (f5 * f10);
        float f12 = perspectiveTransform2.a31;
        float f13 = perspectiveTransform2.a32;
        float f14 = perspectiveTransform2.a33;
        float f15 = f5 * f14;
        float f16 = f15 + (f3 * f13) + (f * f12);
        float f17 = this.a12;
        float f18 = f16;
        float f19 = this.a22;
        float f20 = this.a32;
        float f21 = (f20 * f6) + (f19 * f4) + (f17 * f2);
        float f22 = (f20 * f10) + (f19 * f9) + (f17 * f8);
        float f23 = f20 * f14;
        float f24 = f23 + (f19 * f13) + (f17 * f12);
        float f25 = this.a13;
        float f26 = this.a23;
        float f27 = (f4 * f26) + (f2 * f25);
        float f28 = this.a33;
        float f29 = (f6 * f28) + f27;
        float f30 = f10 * f28;
        float f31 = f28 * f14;
        return new PerspectiveTransform(f7, f11, f18, f21, f22, f24, f29, f30 + (f9 * f26) + (f8 * f25), f31 + (f26 * f13) + (f25 * f12));
    }

    public void transformPoints(float[] fArr) {
        float[] fArr2 = fArr;
        float f = this.a11;
        float f2 = this.a12;
        float f3 = this.a13;
        float f4 = this.a21;
        float f5 = this.a22;
        float f6 = this.a23;
        float f7 = this.a31;
        float f8 = this.a32;
        float f9 = this.a33;
        int length = fArr2.length - 1;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr2[i];
            int i2 = i + 1;
            float f11 = fArr2[i2];
            float f12 = (f6 * f11) + (f3 * f10) + f9;
            fArr2[i] = (((f4 * f11) + (f * f10)) + f7) / f12;
            fArr2[i2] = (((f11 * f5) + (f10 * f2)) + f8) / f12;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float f = fArr[i];
            float f2 = fArr2[i];
            float f3 = (this.a23 * f2) + (this.a13 * f) + this.a33;
            fArr[i] = (((this.a21 * f2) + (this.a11 * f)) + this.a31) / f3;
            fArr2[i] = (((this.a22 * f2) + (this.a12 * f)) + this.a32) / f3;
        }
    }
}
