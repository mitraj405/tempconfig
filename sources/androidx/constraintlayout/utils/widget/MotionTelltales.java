package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

public class MotionTelltales extends MockView {
    public float a = 0.25f;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f1618a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    public MotionLayout f1619a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f1620a = new float[2];
    public final Paint d = new Paint();
    public int g = 0;
    public int h = -65281;

    public MotionTelltales(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.MotionTelltales_telltales_tailColor) {
                    this.h = obtainStyledAttributes.getColor(index, this.h);
                } else if (index == C0221hs.MotionTelltales_telltales_velocityMode) {
                    this.g = obtainStyledAttributes.getInt(index, this.g);
                } else if (index == C0221hs.MotionTelltales_telltales_tailScale) {
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                }
            }
            obtainStyledAttributes.recycle();
        }
        int i2 = this.h;
        Paint paint = this.d;
        paint.setColor(i2);
        paint.setStrokeWidth(5.0f);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void onDraw(Canvas canvas) {
        float[] fArr;
        int i;
        float f;
        Matrix matrix;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        float[] fArr2;
        int i6;
        Ex ex;
        Ex ex2;
        Ex ex3;
        Ex ex4;
        int i7;
        Ex ex5;
        BC bc;
        BC bc2;
        BC bc3;
        BC bc4;
        BC bc5;
        Vl vl;
        double[] dArr;
        float[] fArr3;
        C0145bC bCVar;
        int i8;
        super.onDraw(canvas);
        Matrix matrix2 = getMatrix();
        Matrix matrix3 = this.f1618a;
        matrix2.invert(matrix3);
        if (this.f1619a == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f1619a = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i9 = 5;
        float[] fArr4 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        MotionTelltales motionTelltales = this;
        int i10 = 0;
        while (i10 < i9) {
            float f3 = fArr4[i10];
            int i11 = 0;
            while (i11 < i9) {
                float f4 = fArr4[i11];
                MotionLayout motionLayout = motionTelltales.f1619a;
                float[] fArr5 = motionTelltales.f1620a;
                int i12 = motionTelltales.g;
                float f5 = motionLayout.a;
                float f6 = motionLayout.d;
                if (motionLayout.f1435a != null) {
                    float signum = Math.signum(motionLayout.e - f6);
                    float interpolation = motionLayout.f1435a.getInterpolation(motionLayout.d + 1.0E-5f);
                    fArr = fArr4;
                    float interpolation2 = motionLayout.f1435a.getInterpolation(motionLayout.d);
                    f5 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / motionLayout.b;
                    f6 = interpolation2;
                } else {
                    fArr = fArr4;
                }
                Wl wl = motionLayout.f1435a;
                if (wl instanceof Wl) {
                    f5 = wl.a();
                }
                float f7 = f5;
                Vl vl2 = motionLayout.f1451a.get(motionTelltales);
                if ((i12 & 1) == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float[] fArr6 = vl2.f625b;
                    float b = vl2.b(f6, fArr6);
                    HashMap<String, MC> hashMap = vl2.f622b;
                    BC bc6 = null;
                    int i13 = i12;
                    if (hashMap == null) {
                        i6 = i11;
                        ex = null;
                    } else {
                        ex = hashMap.get("translationX");
                        i6 = i11;
                    }
                    HashMap<String, MC> hashMap2 = vl2.f622b;
                    i4 = i10;
                    if (hashMap2 == null) {
                        i3 = height;
                        ex2 = null;
                    } else {
                        ex2 = hashMap2.get("translationY");
                        i3 = height;
                    }
                    HashMap<String, MC> hashMap3 = vl2.f622b;
                    i2 = width;
                    if (hashMap3 == null) {
                        matrix = matrix3;
                        ex3 = null;
                    } else {
                        ex3 = hashMap3.get("rotation");
                        matrix = matrix3;
                    }
                    HashMap<String, MC> hashMap4 = vl2.f622b;
                    if (hashMap4 == null) {
                        f = f7;
                        ex4 = null;
                    } else {
                        ex4 = hashMap4.get("scaleX");
                        f = f7;
                    }
                    HashMap<String, MC> hashMap5 = vl2.f622b;
                    float[] fArr7 = fArr6;
                    if (hashMap5 == null) {
                        i7 = width2;
                        ex5 = null;
                    } else {
                        ex5 = hashMap5.get("scaleY");
                        i7 = width2;
                    }
                    HashMap<String, BC> hashMap6 = vl2.f628c;
                    if (hashMap6 == null) {
                        bc = null;
                    } else {
                        bc = hashMap6.get("translationX");
                    }
                    HashMap<String, BC> hashMap7 = vl2.f628c;
                    if (hashMap7 == null) {
                        bc2 = null;
                    } else {
                        bc2 = hashMap7.get("translationY");
                    }
                    HashMap<String, BC> hashMap8 = vl2.f628c;
                    if (hashMap8 == null) {
                        bc3 = null;
                    } else {
                        bc3 = hashMap8.get("rotation");
                    }
                    HashMap<String, BC> hashMap9 = vl2.f628c;
                    if (hashMap9 == null) {
                        bc4 = null;
                    } else {
                        bc4 = hashMap9.get("scaleX");
                    }
                    HashMap<String, BC> hashMap10 = vl2.f628c;
                    if (hashMap10 != null) {
                        bc6 = hashMap10.get("scaleY");
                    }
                    BC bc7 = bc6;
                    C0145bC bCVar2 = new C0145bC();
                    float[] fArr8 = fArr5;
                    bCVar2.e = 0.0f;
                    bCVar2.d = 0.0f;
                    bCVar2.c = 0.0f;
                    bCVar2.b = 0.0f;
                    bCVar2.a = 0.0f;
                    if (ex3 != null) {
                        vl = vl2;
                        bc5 = bc2;
                        bCVar2.e = (float) ex3.f166a.e((double) b);
                        bCVar2.f = ex3.a(b);
                    } else {
                        vl = vl2;
                        bc5 = bc2;
                    }
                    if (ex != null) {
                        f2 = f4;
                        bCVar2.c = (float) ex.f166a.e((double) b);
                    } else {
                        f2 = f4;
                    }
                    if (ex2 != null) {
                        bCVar2.d = (float) ex2.f166a.e((double) b);
                    }
                    if (ex4 != null) {
                        bCVar2.a = (float) ex4.f166a.e((double) b);
                    }
                    if (ex5 != null) {
                        bCVar2.b = (float) ex5.f166a.e((double) b);
                    }
                    if (bc3 != null) {
                        bCVar2.e = bc3.b(b);
                    }
                    if (bc != null) {
                        bCVar2.c = bc.b(b);
                    }
                    BC bc8 = bc5;
                    if (bc5 != null) {
                        bCVar2.d = bc8.b(b);
                    }
                    if (bc4 != null) {
                        bCVar2.a = bc4.b(b);
                    }
                    if (bc7 != null) {
                        bCVar2.b = bc7.b(b);
                    }
                    Vl vl3 = vl;
                    D1 d1 = vl3.f602a;
                    C0145bC bCVar3 = bCVar2;
                    Xl xl = vl3.f604a;
                    if (d1 != null) {
                        double[] dArr2 = vl3.f611a;
                        if (dArr2.length > 0) {
                            double d2 = (double) b;
                            d1.c(d2, dArr2);
                            vl3.f602a.f(d2, vl3.f624b);
                            int[] iArr = vl3.f613a;
                            double[] dArr3 = vl3.f624b;
                            double[] dArr4 = vl3.f611a;
                            xl.getClass();
                            i8 = i13;
                            bCVar = bCVar3;
                            fArr3 = fArr8;
                            i5 = i6;
                            Xl.j(f2, f3, fArr8, iArr, dArr3, dArr4);
                        } else {
                            fArr3 = fArr8;
                            i8 = i13;
                            i5 = i6;
                            bCVar = bCVar3;
                        }
                        bCVar.a(f2, f3, i7, height2, fArr3);
                        i = i8;
                        fArr2 = fArr3;
                    } else {
                        float[] fArr9 = fArr8;
                        i = i13;
                        i5 = i6;
                        BC bc9 = bc7;
                        if (vl3.f615a != null) {
                            float[] fArr10 = fArr7;
                            double b2 = (double) vl3.b(b, fArr10);
                            vl3.f615a[0].f(b2, vl3.f624b);
                            vl3.f615a[0].c(b2, vl3.f611a);
                            float f8 = fArr10[0];
                            int i14 = 0;
                            while (true) {
                                dArr = vl3.f624b;
                                if (i14 >= dArr.length) {
                                    break;
                                }
                                dArr[i14] = dArr[i14] * ((double) f8);
                                i14++;
                            }
                            int[] iArr2 = vl3.f613a;
                            double[] dArr5 = vl3.f611a;
                            xl.getClass();
                            int[] iArr3 = iArr2;
                            fArr2 = fArr9;
                            Xl.j(f2, f3, fArr9, iArr3, dArr, dArr5);
                            bCVar3.a(f2, f3, i7, height2, fArr2);
                        } else {
                            Xl xl2 = vl3.f619b;
                            BC bc10 = bc4;
                            float f9 = xl2.c - xl.c;
                            BC bc11 = bc8;
                            float f10 = xl2.d - xl.d;
                            BC bc12 = bc;
                            fArr9[0] = (((xl2.e - xl.e) + f9) * f2) + ((1.0f - f2) * f9);
                            fArr9[1] = (((xl2.f - xl.f) + f10) * f3) + ((1.0f - f3) * f10);
                            C0145bC bCVar4 = bCVar3;
                            bCVar4.e = 0.0f;
                            bCVar4.d = 0.0f;
                            bCVar4.c = 0.0f;
                            bCVar4.b = 0.0f;
                            bCVar4.a = 0.0f;
                            if (ex3 != null) {
                                bCVar4.e = (float) ex3.f166a.e((double) b);
                                bCVar4.f = ex3.a(b);
                            }
                            if (ex != null) {
                                bCVar4.c = (float) ex.f166a.e((double) b);
                            }
                            if (ex2 != null) {
                                bCVar4.d = (float) ex2.f166a.e((double) b);
                            }
                            if (ex4 != null) {
                                bCVar4.a = (float) ex4.f166a.e((double) b);
                            }
                            if (ex5 != null) {
                                bCVar4.b = (float) ex5.f166a.e((double) b);
                            }
                            if (bc3 != null) {
                                bCVar4.e = bc3.b(b);
                            }
                            if (bc12 != null) {
                                bCVar4.c = bc12.b(b);
                            }
                            if (bc11 != null) {
                                bCVar4.d = bc11.b(b);
                            }
                            if (bc10 != null) {
                                bCVar4.a = bc10.b(b);
                            }
                            if (bc9 != null) {
                                bCVar4.b = bc9.b(b);
                            }
                            fArr2 = fArr9;
                            bCVar4.a(f2, f3, i7, height2, fArr2);
                        }
                    }
                } else {
                    i2 = width;
                    matrix = matrix3;
                    i3 = height;
                    f = f7;
                    i4 = i10;
                    i = i12;
                    fArr2 = fArr5;
                    f2 = f4;
                    i5 = i11;
                    vl2.d(f6, f2, f3, fArr2);
                }
                if (i < 2) {
                    fArr2[0] = fArr2[0] * f;
                    fArr2[1] = fArr2[1] * f;
                }
                float[] fArr11 = this.f1620a;
                matrix3 = matrix;
                matrix3.mapVectors(fArr11);
                int i15 = i2;
                float f11 = ((float) i15) * f2;
                int i16 = i3;
                float f12 = ((float) i16) * f3;
                float f13 = fArr11[0];
                float f14 = this.a;
                matrix3.mapVectors(fArr11);
                canvas.drawLine(f11, f12, f11 - (f13 * f14), f12 - (fArr11[1] * f14), this.d);
                i11 = i5 + 1;
                motionTelltales = this;
                width = i15;
                height = i16;
                fArr4 = fArr;
                i10 = i4;
                i9 = 5;
            }
            int i17 = height;
            int i18 = width;
            i10++;
            height = i17;
            fArr4 = fArr4;
            i9 = 5;
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f1585c = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
