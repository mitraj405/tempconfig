package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.primitives.Ints;
import defpackage.BC;
import defpackage.MC;
import defpackage.NC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: Vl  reason: default package */
/* compiled from: MotionController */
public final class Vl {
    public float a = Float.NaN;

    /* renamed from: a  reason: collision with other field name */
    public int f601a;

    /* renamed from: a  reason: collision with other field name */
    public D1 f602a;

    /* renamed from: a  reason: collision with other field name */
    public final Tl f603a = new Tl();

    /* renamed from: a  reason: collision with other field name */
    public final Xl f604a = new Xl();

    /* renamed from: a  reason: collision with other field name */
    public final Rect f605a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public View f606a;

    /* renamed from: a  reason: collision with other field name */
    public Interpolator f607a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<Xl> f608a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, NC> f609a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f610a = false;

    /* renamed from: a  reason: collision with other field name */
    public double[] f611a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f612a = new float[4];

    /* renamed from: a  reason: collision with other field name */
    public int[] f613a;

    /* renamed from: a  reason: collision with other field name */
    public Ah[] f614a;

    /* renamed from: a  reason: collision with other field name */
    public H7[] f615a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f616a;
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public int f617b = -1;

    /* renamed from: b  reason: collision with other field name */
    public final Tl f618b = new Tl();

    /* renamed from: b  reason: collision with other field name */
    public final Xl f619b = new Xl();

    /* renamed from: b  reason: collision with other field name */
    public View f620b = null;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<C0260lh> f621b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public HashMap<String, MC> f622b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f623b = false;

    /* renamed from: b  reason: collision with other field name */
    public double[] f624b;

    /* renamed from: b  reason: collision with other field name */
    public final float[] f625b = new float[1];

    /* renamed from: b  reason: collision with other field name */
    public int[] f626b;
    public float c = 1.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f627c = -1;

    /* renamed from: c  reason: collision with other field name */
    public HashMap<String, BC> f628c;
    public float d = Float.NaN;

    /* renamed from: d  reason: collision with other field name */
    public int f629d = -1;
    public int e = -1;

    public Vl(View view) {
        this.f606a = view;
        this.f601a = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getClass();
        }
    }

    public static void g(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((rect.height() + i4) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 3) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
            rect2.top = i3 - ((rect.height() + i6) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 4) {
            int i7 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
            rect2.top = (i7 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        }
    }

    public final void a(C0260lh lhVar) {
        this.f621b.add(lhVar);
    }

    public final float b(float f, float[] fArr) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.c;
            if (((double) f4) != 1.0d) {
                float f5 = this.b;
                if (f < f5) {
                    f = 0.0f;
                }
                if (f > f5 && ((double) f) < 1.0d) {
                    f = Math.min((f - f5) * f4, 1.0f);
                }
            }
        }
        T9 t9 = this.f604a.f680a;
        Iterator<Xl> it = this.f608a.iterator();
        float f6 = Float.NaN;
        while (it.hasNext()) {
            Xl next = it.next();
            T9 t92 = next.f680a;
            if (t92 != null) {
                float f7 = next.f679a;
                if (f7 < f) {
                    t9 = t92;
                    f2 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = next.f679a;
                }
            }
        }
        if (t9 != null) {
            if (!Float.isNaN(f6)) {
                f3 = f6;
            }
            float f8 = f3 - f2;
            double d2 = (double) ((f - f2) / f8);
            f = (((float) t9.a(d2)) * f8) + f2;
            if (fArr != null) {
                fArr[0] = (float) t9.b(d2);
            }
        }
        return f;
    }

    public final void c(double d2, float[] fArr, float[] fArr2) {
        double d3 = d2;
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f615a[0].c(d3, dArr);
        this.f615a[0].f(d3, dArr2);
        float f = 0.0f;
        Arrays.fill(fArr2, 0.0f);
        int[] iArr = this.f613a;
        Xl xl = this.f604a;
        float f2 = xl.c;
        float f3 = xl.d;
        float f4 = xl.e;
        float f5 = xl.f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i = 0;
        float f8 = 0.0f;
        while (i < iArr.length) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f2 = f9;
                f = f10;
            } else if (i2 == 2) {
                f3 = f9;
                f8 = f10;
            } else if (i2 == 3) {
                f4 = f9;
                f6 = f10;
            } else if (i2 == 4) {
                f5 = f9;
                f7 = f10;
            }
            i++;
            double d4 = d2;
            float[] fArr3 = fArr2;
        }
        float f11 = 2.0f;
        float f12 = (f6 / 2.0f) + f;
        float f13 = (f7 / 2.0f) + f8;
        Vl vl = xl.f681a;
        if (vl != null) {
            float[] fArr4 = new float[2];
            float[] fArr5 = new float[2];
            vl.c(d2, fArr4, fArr5);
            float f14 = fArr4[0];
            float f15 = fArr4[1];
            float f16 = fArr5[0];
            float f17 = fArr5[1];
            double d5 = (double) f2;
            double d6 = (double) f3;
            float cos = (float) ((((double) f15) - (Math.cos(d6) * d5)) - ((double) (f5 / 2.0f)));
            double d7 = (double) f16;
            double d8 = (double) f;
            double sin = (Math.sin(d6) * d8) + d7;
            double d9 = (double) f8;
            f13 = (float) ((Math.sin(d6) * d9) + (((double) f17) - (Math.cos(d6) * d8)));
            f3 = cos;
            f12 = (float) ((Math.cos(d6) * d9) + sin);
            f2 = (float) (((Math.sin(d6) * d5) + ((double) f14)) - ((double) (f4 / 2.0f)));
            f11 = 2.0f;
        }
        fArr[0] = (f4 / f11) + f2 + 0.0f;
        fArr[1] = (f5 / f11) + f3 + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = f13;
    }

    public final void d(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f625b;
        float b2 = b(f, fArr2);
        H7[] h7Arr = this.f615a;
        Xl xl = this.f604a;
        int i = 0;
        if (h7Arr != null) {
            double d2 = (double) b2;
            h7Arr[0].f(d2, this.f624b);
            this.f615a[0].c(d2, this.f611a);
            float f4 = fArr2[0];
            while (true) {
                dArr = this.f624b;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * ((double) f4);
                i++;
            }
            D1 d1 = this.f602a;
            if (d1 != null) {
                double[] dArr2 = this.f611a;
                if (dArr2.length > 0) {
                    d1.c(d2, dArr2);
                    this.f602a.f(d2, this.f624b);
                    int[] iArr = this.f613a;
                    double[] dArr3 = this.f624b;
                    double[] dArr4 = this.f611a;
                    xl.getClass();
                    Xl.j(f2, f3, fArr, iArr, dArr3, dArr4);
                    return;
                }
                return;
            }
            int[] iArr2 = this.f613a;
            double[] dArr5 = this.f611a;
            xl.getClass();
            Xl.j(f2, f3, fArr, iArr2, dArr, dArr5);
            return;
        }
        Xl xl2 = this.f619b;
        float f5 = xl2.c - xl.c;
        float f6 = xl2.d - xl.d;
        fArr[0] = (((xl2.e - xl.e) + f5) * f2) + ((1.0f - f2) * f5);
        fArr[1] = (((xl2.f - xl.f) + f6) * f3) + ((1.0f - f3) * f6);
    }

    public final boolean e(float f, long j, View view, nh nhVar) {
        boolean z;
        NC.d dVar;
        boolean z2;
        float f2;
        Vl vl;
        double d2;
        Xl xl;
        boolean z3;
        NC.d dVar2;
        float f3;
        float f4;
        float f5;
        boolean z4;
        boolean z5;
        float f6;
        View view2 = view;
        float b2 = b(f, (float[]) null);
        int i = this.e;
        float f7 = 1.0f;
        if (i != -1) {
            float f8 = 1.0f / ((float) i);
            float floor = ((float) Math.floor((double) (b2 / f8))) * f8;
            float f9 = (b2 % f8) / f8;
            if (!Float.isNaN(this.d)) {
                f9 = (f9 + this.d) % 1.0f;
            }
            Interpolator interpolator = this.f607a;
            if (interpolator != null) {
                f7 = interpolator.getInterpolation(f9);
            } else if (((double) f9) <= 0.5d) {
                f7 = 0.0f;
            }
            b2 = (f7 * f8) + floor;
        }
        float f10 = b2;
        HashMap<String, MC> hashMap = this.f622b;
        if (hashMap != null) {
            for (MC d3 : hashMap.values()) {
                d3.d(f10, view2);
            }
        }
        HashMap<String, NC> hashMap2 = this.f609a;
        if (hashMap2 != null) {
            dVar = null;
            z = false;
            for (NC next : hashMap2.values()) {
                if (next instanceof NC.d) {
                    dVar = (NC.d) next;
                } else {
                    z |= next.e(f10, j, view, nhVar);
                }
            }
        } else {
            dVar = null;
            z = false;
        }
        H7[] h7Arr = this.f615a;
        Xl xl2 = this.f604a;
        if (h7Arr != null) {
            double d4 = (double) f10;
            h7Arr[0].c(d4, this.f611a);
            this.f615a[0].f(d4, this.f624b);
            D1 d1 = this.f602a;
            if (d1 != null) {
                double[] dArr = this.f611a;
                if (dArr.length > 0) {
                    d1.c(d4, dArr);
                    this.f602a.f(d4, this.f624b);
                }
            }
            if (!this.f623b) {
                int[] iArr = this.f613a;
                double[] dArr2 = this.f611a;
                double[] dArr3 = this.f624b;
                boolean z6 = this.f610a;
                float f11 = xl2.c;
                float f12 = xl2.d;
                float f13 = xl2.e;
                float f14 = xl2.f;
                float f15 = f11;
                if (iArr.length != 0) {
                    f5 = f12;
                    if (xl2.f683a.length <= iArr[iArr.length - 1]) {
                        int i2 = iArr[iArr.length - 1] + 1;
                        xl2.f683a = new double[i2];
                        xl2.f684b = new double[i2];
                    }
                } else {
                    f5 = f12;
                }
                dVar2 = dVar;
                z3 = z;
                Arrays.fill(xl2.f683a, Double.NaN);
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    double[] dArr4 = xl2.f683a;
                    int i4 = iArr[i3];
                    dArr4[i4] = dArr2[i3];
                    xl2.f684b[i4] = dArr3[i3];
                }
                float f16 = Float.NaN;
                float f17 = 0.0f;
                int i5 = 0;
                float f18 = f14;
                float f19 = 0.0f;
                float f20 = 0.0f;
                float f21 = f15;
                float f22 = f5;
                f3 = f10;
                float f23 = 0.0f;
                float f24 = f13;
                float f25 = f22;
                while (true) {
                    double[] dArr5 = xl2.f683a;
                    z4 = z6;
                    if (i5 >= dArr5.length) {
                        break;
                    }
                    if (Double.isNaN(dArr5[i5])) {
                        f6 = f16;
                    } else {
                        double d5 = 0.0d;
                        if (!Double.isNaN(xl2.f683a[i5])) {
                            d5 = xl2.f683a[i5] + 0.0d;
                        }
                        f6 = f16;
                        float f26 = (float) d5;
                        float f27 = (float) xl2.f684b[i5];
                        if (i5 == 1) {
                            f16 = f6;
                            f17 = f27;
                            f21 = f26;
                        } else if (i5 == 2) {
                            f23 = f27;
                            f25 = f26;
                        } else if (i5 == 3) {
                            f20 = f27;
                            f24 = f26;
                        } else if (i5 == 4) {
                            f19 = f27;
                            f18 = f26;
                        } else if (i5 == 5) {
                            f16 = f26;
                        }
                        i5++;
                        z6 = z4;
                    }
                    f16 = f6;
                    i5++;
                    z6 = z4;
                }
                float f28 = f16;
                Vl vl2 = xl2.f681a;
                if (vl2 != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    vl2.c(d4, fArr, fArr2);
                    float f29 = fArr[0];
                    float f30 = fArr[1];
                    float f31 = fArr2[0];
                    float f32 = fArr2[1];
                    xl = xl2;
                    double d6 = (double) f29;
                    double d7 = (double) f21;
                    d2 = d4;
                    double d8 = (double) f25;
                    double[] dArr6 = dArr3;
                    float cos = (float) ((((double) f30) - (Math.cos(d8) * d7)) - ((double) (f18 / 2.0f)));
                    double d9 = (double) f17;
                    double sin = (Math.sin(d8) * d9) + ((double) f31);
                    float sin2 = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f24 / 2.0f)));
                    double d10 = (double) f23;
                    float cos2 = (float) ((Math.cos(d8) * d7 * d10) + sin);
                    float f33 = cos;
                    float sin3 = (float) ((Math.sin(d8) * d7 * d10) + (((double) f32) - (Math.cos(d8) * d9)));
                    double[] dArr7 = dArr6;
                    if (dArr7.length >= 2) {
                        dArr7[0] = (double) cos2;
                        dArr7[1] = (double) sin3;
                    }
                    if (!Float.isNaN(f28)) {
                        view2.setRotation((float) (Math.toDegrees(Math.atan2((double) sin3, (double) cos2)) + ((double) f28)));
                    }
                    f21 = sin2;
                    f25 = f33;
                } else {
                    float f34 = f28;
                    xl = xl2;
                    d2 = d4;
                    if (!Float.isNaN(f34)) {
                        view2.setRotation((float) (Math.toDegrees(Math.atan2((double) ((f19 / 2.0f) + f23), (double) ((f20 / 2.0f) + f17))) + ((double) f34) + ((double) 0.0f)));
                    }
                }
                if (view2 instanceof C0095Hc) {
                    ((C0095Hc) view2).a(f21, f25, f24 + f21, f25 + f18);
                } else {
                    float f35 = f21 + 0.5f;
                    int i6 = (int) f35;
                    float f36 = f25 + 0.5f;
                    int i7 = (int) f36;
                    int i8 = (int) (f35 + f24);
                    int i9 = (int) (f36 + f18);
                    int i10 = i8 - i6;
                    int i11 = i9 - i7;
                    if (i10 == view.getMeasuredWidth() && i11 == view.getMeasuredHeight()) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5 || z4) {
                        view2.measure(View.MeasureSpec.makeMeasureSpec(i10, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(i11, Ints.MAX_POWER_OF_TWO));
                    }
                    view2.layout(i6, i7, i8, i9);
                }
                vl = this;
                vl.f610a = false;
            } else {
                f3 = f10;
                xl = xl2;
                dVar2 = dVar;
                z3 = z;
                d2 = d4;
                vl = this;
            }
            if (vl.f629d != -1) {
                if (vl.f620b == null) {
                    vl.f620b = ((View) view.getParent()).findViewById(vl.f629d);
                }
                View view3 = vl.f620b;
                if (view3 != null) {
                    float bottom = ((float) (vl.f620b.getBottom() + view3.getTop())) / 2.0f;
                    float right = ((float) (vl.f620b.getRight() + vl.f620b.getLeft())) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view2.setPivotX(right - ((float) view.getLeft()));
                        view2.setPivotY(bottom - ((float) view.getTop()));
                    }
                }
            }
            HashMap<String, MC> hashMap3 = vl.f622b;
            if (hashMap3 != null) {
                for (Ex next2 : hashMap3.values()) {
                    if (next2 instanceof MC.d) {
                        double[] dArr8 = vl.f624b;
                        if (dArr8.length > 1) {
                            f4 = f3;
                            view2.setRotation(((MC.d) next2).a(f4) + ((float) Math.toDegrees(Math.atan2(dArr8[1], dArr8[0]))));
                            f3 = f4;
                        }
                    }
                    f4 = f3;
                    f3 = f4;
                }
            }
            f2 = f3;
            if (dVar2 != null) {
                double[] dArr9 = vl.f624b;
                view2.setRotation(dVar2.d(f2, j, view, nhVar) + ((float) Math.toDegrees(Math.atan2(dArr9[1], dArr9[0]))));
                z2 = z3 | dVar2.f694a;
            } else {
                z2 = z3;
            }
            int i12 = 1;
            while (true) {
                H7[] h7Arr2 = vl.f615a;
                if (i12 >= h7Arr2.length) {
                    break;
                }
                H7 h7 = h7Arr2[i12];
                float[] fArr3 = vl.f612a;
                h7.d(d2, fArr3);
                r1.P(xl.f682a.get(vl.f616a[i12 - 1]), view2, fArr3);
                i12++;
            }
            Tl tl = vl.f603a;
            if (tl.f559c == 0) {
                if (f2 <= 0.0f) {
                    view2.setVisibility(tl.f560d);
                } else {
                    int i13 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                    Tl tl2 = vl.f618b;
                    if (i13 >= 0) {
                        view2.setVisibility(tl2.f560d);
                    } else if (tl2.f560d != tl.f560d) {
                        view2.setVisibility(0);
                    }
                }
            }
            if (vl.f614a != null) {
                int i14 = 0;
                while (true) {
                    Ah[] ahArr = vl.f614a;
                    if (i14 >= ahArr.length) {
                        break;
                    }
                    ahArr[i14].h(f2, view2);
                    i14++;
                }
            }
        } else {
            f2 = f10;
            Xl xl3 = xl2;
            boolean z7 = z;
            vl = this;
            float f37 = xl3.c;
            Xl xl4 = vl.f619b;
            float a2 = lf.a(xl4.c, f37, f2, f37);
            float f38 = xl3.d;
            float a3 = lf.a(xl4.d, f38, f2, f38);
            float f39 = xl3.e;
            float f40 = xl4.e;
            float a4 = lf.a(f40, f39, f2, f39);
            float f41 = xl3.f;
            float f42 = xl4.f;
            float f43 = a2 + 0.5f;
            int i15 = (int) f43;
            float f44 = a3 + 0.5f;
            int i16 = (int) f44;
            int i17 = (int) (f43 + a4);
            int a5 = (int) (f44 + lf.a(f42, f41, f2, f41));
            int i18 = i17 - i15;
            int i19 = a5 - i16;
            if (!(f40 == f39 && f42 == f41 && !vl.f610a)) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i18, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(i19, Ints.MAX_POWER_OF_TWO));
                vl.f610a = false;
            }
            view2.layout(i15, i16, i17, a5);
            z2 = z7;
        }
        HashMap<String, BC> hashMap4 = vl.f628c;
        if (hashMap4 != null) {
            for (BC next3 : hashMap4.values()) {
                if (next3 instanceof BC.d) {
                    double[] dArr10 = vl.f624b;
                    view2.setRotation(((BC.d) next3).a(f2) + ((float) Math.toDegrees(Math.atan2(dArr10[1], dArr10[0]))));
                } else {
                    next3.e(f2, view2);
                }
            }
        }
        return z2;
    }

    public final void f(Xl xl) {
        xl.i((float) ((int) this.f606a.getX()), (float) ((int) this.f606a.getY()), (float) this.f606a.getWidth(), (float) this.f606a.getHeight());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x026b, code lost:
        r5 = r24;
        r7 = r25;
        r3 = r32;
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0273, code lost:
        r24 = r8;
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d8, code lost:
        r5 = r24;
        r7 = r25;
        r3 = r32;
        r24 = r8;
        r8 = r17;
        r25 = r19;
        r17 = r2;
        r19 = r18;
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x033f, code lost:
        r25 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0341, code lost:
        r19 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0384, code lost:
        r19 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03c3, code lost:
        r17 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03c5, code lost:
        switch(r17) {
            case 0: goto L_0x0426;
            case 1: goto L_0x0420;
            case 2: goto L_0x041a;
            case 3: goto L_0x0414;
            case 4: goto L_0x040e;
            case 5: goto L_0x0408;
            case 6: goto L_0x0402;
            case 7: goto L_0x03fc;
            case 8: goto L_0x03f6;
            case 9: goto L_0x03f0;
            case 10: goto L_0x03ea;
            case 11: goto L_0x03e4;
            case 12: goto L_0x03de;
            case 13: goto L_0x03d8;
            case 14: goto L_0x03d2;
            case 15: goto L_0x03cc;
            default: goto L_0x03c8;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03c8, code lost:
        r17 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03cc, code lost:
        r17 = new defpackage.MC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03d2, code lost:
        r17 = new defpackage.MC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03d8, code lost:
        r17 = new defpackage.MC.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03de, code lost:
        r17 = new defpackage.MC.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03e4, code lost:
        r17 = new defpackage.MC.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03ea, code lost:
        r17 = new defpackage.MC.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03f0, code lost:
        r17 = new defpackage.MC.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03f6, code lost:
        r17 = new defpackage.MC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03fc, code lost:
        r17 = new defpackage.MC.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0402, code lost:
        r17 = new defpackage.MC.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0408, code lost:
        r17 = new defpackage.MC.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x040e, code lost:
        r17 = new defpackage.MC.o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0414, code lost:
        r17 = new defpackage.MC.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x041a, code lost:
        r17 = new defpackage.MC.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0420, code lost:
        r17 = new defpackage.MC.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0426, code lost:
        r17 = new defpackage.MC.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x042b, code lost:
        r18 = r8;
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04d1, code lost:
        r15 = (java.lang.Integer) r4.get(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x059c, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x059e, code lost:
        r15 = r18;
        r13 = r19;
        r4 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05df, code lost:
        r15 = r18;
        r13 = r19;
        r4 = r25;
        r45 = r17;
        r17 = r1;
        r1 = r45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x05f6, code lost:
        r4 = r1;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0618, code lost:
        r17 = r4;
        r15 = r18;
        r13 = r19;
        r4 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x065f, code lost:
        r17 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0661, code lost:
        switch(r17) {
            case 0: goto L_0x06b1;
            case 1: goto L_0x06ab;
            case 2: goto L_0x06a5;
            case 3: goto L_0x069f;
            case 4: goto L_0x0699;
            case 5: goto L_0x0693;
            case 6: goto L_0x068d;
            case 7: goto L_0x0687;
            case 8: goto L_0x0681;
            case 9: goto L_0x067b;
            case 10: goto L_0x0675;
            case 11: goto L_0x066f;
            default: goto L_0x0664;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0664, code lost:
        r19 = r4;
        r17 = r5;
        r18 = r15;
        r4 = r49;
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x066f, code lost:
        r17 = new defpackage.NC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0675, code lost:
        r17 = new defpackage.NC.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x067b, code lost:
        r17 = new defpackage.NC.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0681, code lost:
        r17 = new defpackage.NC.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0687, code lost:
        r17 = new defpackage.NC.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x068d, code lost:
        r17 = new defpackage.NC.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0693, code lost:
        r17 = new defpackage.NC.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0699, code lost:
        r17 = new defpackage.NC.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x069f, code lost:
        r17 = new defpackage.NC.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06a5, code lost:
        r17 = new defpackage.NC.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x06ab, code lost:
        r17 = new defpackage.NC.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x06b1, code lost:
        r17 = new defpackage.NC.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06b6, code lost:
        r19 = r4;
        r18 = r15;
        r15 = r17;
        r17 = r5;
        r15.f691a = r49;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x07aa, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x07ac, code lost:
        r6 = r18;
        r5 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x07eb, code lost:
        r4 = r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x07ee, code lost:
        r6 = r18;
        r5 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x082c, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0830, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0842, code lost:
        r4 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x0843, code lost:
        switch(r4) {
            case 0: goto L_0x0a0b;
            case 1: goto L_0x09e5;
            case 2: goto L_0x09bf;
            case 3: goto L_0x0998;
            case 4: goto L_0x0971;
            case 5: goto L_0x094a;
            case 6: goto L_0x0923;
            case 7: goto L_0x08fc;
            case 8: goto L_0x08d5;
            case 9: goto L_0x08ae;
            case 10: goto L_0x0887;
            case 11: goto L_0x085c;
            default: goto L_0x0846;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0846, code lost:
        r4 = r48;
        r15 = r49;
        r17 = r0;
        r19 = r5;
        r18 = r6;
        r7 = r20;
        r8 = r25;
        r6 = r33;
        r0 = r46;
        r5 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x085c, code lost:
        r4 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0864, code lost:
        if (java.lang.Float.isNaN(r4.a) != false) goto L_0x0883;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0866, code lost:
        r17 = r6;
        r18 = r13;
        r36.b(r4.a, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0883, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0887, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0893, code lost:
        if (java.lang.Float.isNaN(r4.f) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0895, code lost:
        r36.b(r4.f, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x08ae, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x08ba, code lost:
        if (java.lang.Float.isNaN(r4.b) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x08bc, code lost:
        r36.b(r4.b, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x08d5, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x08e1, code lost:
        if (java.lang.Float.isNaN(r4.c) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x08e3, code lost:
        r36.b(r4.c, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x08fc, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0908, code lost:
        if (java.lang.Float.isNaN(r4.h) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x090a, code lost:
        r36.b(r4.h, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0923, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x092f, code lost:
        if (java.lang.Float.isNaN(r4.g) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x0931, code lost:
        r36.b(r4.g, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x094a, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0956, code lost:
        if (java.lang.Float.isNaN(r4.l) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0958, code lost:
        r36.b(r4.l, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0971, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x097d, code lost:
        if (java.lang.Float.isNaN(r4.k) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x097f, code lost:
        r36.b(r4.k, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0998, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x09a4, code lost:
        if (java.lang.Float.isNaN(r4.j) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x09a6, code lost:
        r36.b(r4.j, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x09bf, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x09cb, code lost:
        if (java.lang.Float.isNaN(r4.i) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x09cd, code lost:
        r36.b(r4.i, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x09e5, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x09f1, code lost:
        if (java.lang.Float.isNaN(r4.e) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x09f3, code lost:
        r36.b(r4.e, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0a0b, code lost:
        r4 = r50;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0a17, code lost:
        if (java.lang.Float.isNaN(r4.d) != false) goto L_0x0a30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0a19, code lost:
        r36.b(r4.d, r4.m, r4.n, r4.a, r4.f3486d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:0x0e58, code lost:
        r11 = r31;
        r13 = r32;
        r10 = r35;
        r9 = r36;
        r8 = r37;
        r7 = r38;
        r6 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x0e66, code lost:
        r19 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:532:0x0eb1, code lost:
        r48 = r0;
        r0 = r17;
        r15 = r19;
        r14 = r20;
        r11 = r31;
        r13 = r32;
        r10 = r35;
        r9 = r36;
        r8 = r37;
        r7 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:534:0x0ec8, code lost:
        r48 = r0;
        r0 = r17;
        r15 = r19;
        r14 = r20;
        r11 = r31;
        r13 = r32;
        r10 = r35;
        r9 = r36;
        r8 = r37;
        r17 = r7;
        r19 = r18;
        r7 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:544:0x0f26, code lost:
        r9 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:546:0x0f2b, code lost:
        r48 = r0;
        r0 = r17;
        r15 = r19;
        r14 = r20;
        r11 = r31;
        r13 = r32;
        r10 = r35;
        r17 = r9;
        r19 = r18;
        r9 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x0f51, code lost:
        r10 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x0f7b, code lost:
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:557:0x0fa5, code lost:
        r48 = r0;
        r0 = r17;
        r15 = r19;
        r14 = r20;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:567:0x0fff, code lost:
        r48 = r0;
        r0 = r17;
        r17 = r15;
        r15 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:572:0x1030, code lost:
        r19 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:580:0x1083, code lost:
        r17 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:581:0x1085, code lost:
        switch(r17) {
            case 0: goto L_0x10db;
            case 1: goto L_0x10d5;
            case 2: goto L_0x10cf;
            case 3: goto L_0x10c9;
            case 4: goto L_0x10c3;
            case 5: goto L_0x10bd;
            case 6: goto L_0x10b7;
            case 7: goto L_0x10b1;
            case 8: goto L_0x10ab;
            case 9: goto L_0x10a5;
            case 10: goto L_0x109f;
            case 11: goto L_0x1099;
            case 12: goto L_0x1093;
            case 13: goto L_0x108d;
            default: goto L_0x1088;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:582:0x1088, code lost:
        r17 = r0;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:583:0x108d, code lost:
        r17 = new defpackage.BC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:584:0x1093, code lost:
        r17 = new defpackage.BC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:585:0x1099, code lost:
        r17 = new defpackage.BC.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:586:0x109f, code lost:
        r17 = new defpackage.BC.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:587:0x10a5, code lost:
        r17 = new defpackage.BC.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:588:0x10ab, code lost:
        r17 = new defpackage.BC.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:589:0x10b1, code lost:
        r17 = new defpackage.BC.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:590:0x10b7, code lost:
        r17 = new defpackage.BC.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:591:0x10bd, code lost:
        r17 = new defpackage.BC.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:592:0x10c3, code lost:
        r17 = new defpackage.BC.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:593:0x10c9, code lost:
        r17 = new defpackage.BC.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:594:0x10cf, code lost:
        r17 = new defpackage.BC.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:595:0x10d5, code lost:
        r17 = new defpackage.BC.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:596:0x10db, code lost:
        r17 = new defpackage.BC.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:597:0x10e0, code lost:
        r45 = r17;
        r17 = r0;
        r0 = r45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:662:0x131e, code lost:
        r3 = r49;
        r0 = r16;
        r14 = r17;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:669:0x133d, code lost:
        r2 = r0;
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:682:0x136b, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:684:0x1370, code lost:
        r3 = r49;
        r15 = r2;
        r14 = r17;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:687:0x1382, code lost:
        r3 = r49;
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:688:0x1386, code lost:
        r13 = r19;
        r10 = r20;
        r8 = r24;
        r11 = r25;
        r4 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:694:0x13b9, code lost:
        r13 = r19;
        r10 = r20;
        r8 = r24;
        r11 = r25;
        r4 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:701:0x13f4, code lost:
        r14 = r17;
        r13 = r19;
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:705:0x141d, code lost:
        r11 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:718:0x1480, code lost:
        r15 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:719:0x1481, code lost:
        switch(r15) {
            case 0: goto L_0x14b5;
            case 1: goto L_0x14b2;
            case 2: goto L_0x14af;
            case 3: goto L_0x14ac;
            case 4: goto L_0x14a9;
            case 5: goto L_0x14a6;
            case 6: goto L_0x14a3;
            case 7: goto L_0x14a0;
            case 8: goto L_0x149d;
            case 9: goto L_0x149a;
            case 10: goto L_0x1497;
            case 11: goto L_0x1494;
            case 12: goto L_0x1491;
            case 13: goto L_0x148e;
            default: goto L_0x1484;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:720:0x1484, code lost:
        r15 = r30;
        r9.startsWith(r15);
        r34 = Float.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:721:0x148e, code lost:
        r15 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:722:0x1491, code lost:
        r15 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:723:0x1494, code lost:
        r15 = r1.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:724:0x1497, code lost:
        r15 = r1.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:725:0x149a, code lost:
        r15 = r1.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:726:0x149d, code lost:
        r15 = r1.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:727:0x14a0, code lost:
        r15 = r1.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:728:0x14a3, code lost:
        r15 = r1.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:729:0x14a6, code lost:
        r15 = r1.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:730:0x14a9, code lost:
        r15 = r1.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:731:0x14ac, code lost:
        r15 = r1.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:732:0x14af, code lost:
        r15 = r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:733:0x14b2, code lost:
        r15 = r1.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:734:0x14b5, code lost:
        r15 = r1.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:735:0x14b7, code lost:
        r34 = r15;
        r15 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:737:0x14bf, code lost:
        if (java.lang.Float.isNaN(r34) == false) goto L_0x14c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:738:0x14c1, code lost:
        r37 = r0;
        r0 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:739:0x14c6, code lost:
        r37 = r0;
        r0 = r21;
        r9 = r0.get(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:740:0x14d0, code lost:
        if (r9 != null) goto L_0x14ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:742:0x14ee, code lost:
        r21 = r0;
        r0 = r1.a;
        r36 = r2;
        r2 = r1.f3159d;
        r49 = r3;
        r3 = r1.f3157b;
        r16 = r4;
        r4 = r1.f3160e;
        r24 = r5;
        r40 = r6;
        r38 = r7;
        r17 = r1;
        r18 = r8;
        r9.f3194a.add(new defpackage.qh.b(r1.a, r1.b, r1.c, r34, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:743:0x1523, code lost:
        if (r4 == -1) goto L_0x1527;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:744:0x1525, code lost:
        r9.b = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:745:0x1527, code lost:
        r9.a = r2;
        r9.f3196b = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(int r47, int r48, long r49) {
        /*
            r46 = this;
            r0 = r46
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.f627c
            Xl r6 = r0.f604a
            r7 = -1
            if (r5 == r7) goto L_0x0024
            r6.f686d = r5
        L_0x0024:
            Tl r5 = r0.f603a
            float r7 = r5.a
            Tl r8 = r0.f618b
            float r9 = r8.a
            boolean r7 = defpackage.Tl.h(r7, r9)
            java.lang.String r9 = "alpha"
            if (r7 == 0) goto L_0x0037
            r2.add(r9)
        L_0x0037:
            float r7 = r5.b
            float r10 = r8.b
            boolean r7 = defpackage.Tl.h(r7, r10)
            java.lang.String r10 = "elevation"
            if (r7 == 0) goto L_0x0046
            r2.add(r10)
        L_0x0046:
            int r7 = r5.f560d
            int r11 = r8.f560d
            if (r7 == r11) goto L_0x0057
            int r12 = r5.f559c
            if (r12 != 0) goto L_0x0057
            if (r7 == 0) goto L_0x0054
            if (r11 != 0) goto L_0x0057
        L_0x0054:
            r2.add(r9)
        L_0x0057:
            float r7 = r5.c
            float r11 = r8.c
            boolean r7 = defpackage.Tl.h(r7, r11)
            java.lang.String r11 = "rotation"
            if (r7 == 0) goto L_0x0066
            r2.add(r11)
        L_0x0066:
            float r7 = r5.m
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r12 = "transitionPathRotate"
            if (r7 == 0) goto L_0x0078
            float r7 = r8.m
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x007b
        L_0x0078:
            r2.add(r12)
        L_0x007b:
            float r7 = r5.n
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r13 = "progress"
            if (r7 == 0) goto L_0x008d
            float r7 = r8.n
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x0090
        L_0x008d:
            r2.add(r13)
        L_0x0090:
            float r7 = r5.d
            float r14 = r8.d
            boolean r7 = defpackage.Tl.h(r7, r14)
            java.lang.String r14 = "rotationX"
            if (r7 == 0) goto L_0x009f
            r2.add(r14)
        L_0x009f:
            float r7 = r5.e
            float r15 = r8.e
            boolean r7 = defpackage.Tl.h(r7, r15)
            java.lang.String r15 = "rotationY"
            if (r7 == 0) goto L_0x00ae
            r2.add(r15)
        L_0x00ae:
            float r7 = r5.h
            r16 = r6
            float r6 = r8.h
            boolean r6 = defpackage.Tl.h(r7, r6)
            if (r6 == 0) goto L_0x00bf
            java.lang.String r6 = "transformPivotX"
            r2.add(r6)
        L_0x00bf:
            float r6 = r5.i
            float r7 = r8.i
            boolean r6 = defpackage.Tl.h(r6, r7)
            if (r6 == 0) goto L_0x00ce
            java.lang.String r6 = "transformPivotY"
            r2.add(r6)
        L_0x00ce:
            float r6 = r5.f
            float r7 = r8.f
            boolean r6 = defpackage.Tl.h(r6, r7)
            java.lang.String r7 = "scaleX"
            if (r6 == 0) goto L_0x00dd
            r2.add(r7)
        L_0x00dd:
            float r6 = r5.g
            r17 = r14
            float r14 = r8.g
            boolean r6 = defpackage.Tl.h(r6, r14)
            java.lang.String r14 = "scaleY"
            if (r6 == 0) goto L_0x00ee
            r2.add(r14)
        L_0x00ee:
            float r6 = r5.j
            r18 = r15
            float r15 = r8.j
            boolean r6 = defpackage.Tl.h(r6, r15)
            java.lang.String r15 = "translationX"
            if (r6 == 0) goto L_0x00ff
            r2.add(r15)
        L_0x00ff:
            float r6 = r5.k
            r19 = r15
            float r15 = r8.k
            boolean r6 = defpackage.Tl.h(r6, r15)
            java.lang.String r15 = "translationY"
            if (r6 == 0) goto L_0x0110
            r2.add(r15)
        L_0x0110:
            float r6 = r5.l
            float r8 = r8.l
            boolean r6 = defpackage.Tl.h(r6, r8)
            java.lang.String r8 = "translationZ"
            if (r6 == 0) goto L_0x011f
            r2.add(r8)
        L_0x011f:
            java.util.ArrayList<lh> r6 = r0.f621b
            r20 = r5
            java.util.ArrayList<Xl> r5 = r0.f608a
            r21 = 0
            if (r6 == 0) goto L_0x01b4
            java.util.Iterator r22 = r6.iterator()
            r23 = r21
        L_0x012f:
            boolean r24 = r22.hasNext()
            if (r24 == 0) goto L_0x01a9
            java.lang.Object r24 = r22.next()
            r25 = r15
            r15 = r24
            lh r15 = (defpackage.C0260lh) r15
            r24 = r8
            boolean r8 = r15 instanceof defpackage.C0395xh
            if (r8 == 0) goto L_0x0171
            xh r15 = (defpackage.C0395xh) r15
            Xl r8 = new Xl
            r32 = r13
            Xl r13 = r0.f604a
            r33 = r7
            Xl r7 = r0.f619b
            r26 = r8
            r27 = r47
            r28 = r48
            r29 = r15
            r30 = r13
            r31 = r7
            r26.<init>(r27, r28, r29, r30, r31)
            int r7 = java.util.Collections.binarySearch(r5, r8)
            int r7 = -r7
            r13 = -1
            int r7 = r7 + r13
            r5.add(r7, r8)
            int r7 = r15.c
            if (r7 == r13) goto L_0x01a0
            r0.f617b = r7
            goto L_0x01a0
        L_0x0171:
            r33 = r7
            r32 = r13
            boolean r7 = r15 instanceof defpackage.oh
            if (r7 == 0) goto L_0x017d
            r15.d(r3)
            goto L_0x01a0
        L_0x017d:
            boolean r7 = r15 instanceof defpackage.C0426zh
            if (r7 == 0) goto L_0x0185
            r15.d(r1)
            goto L_0x01a0
        L_0x0185:
            boolean r7 = r15 instanceof defpackage.Ah
            if (r7 == 0) goto L_0x019a
            if (r23 != 0) goto L_0x0190
            java.util.ArrayList r23 = new java.util.ArrayList
            r23.<init>()
        L_0x0190:
            r7 = r23
            Ah r15 = (defpackage.Ah) r15
            r7.add(r15)
            r23 = r7
            goto L_0x01a0
        L_0x019a:
            r15.f(r4)
            r15.d(r2)
        L_0x01a0:
            r8 = r24
            r15 = r25
            r13 = r32
            r7 = r33
            goto L_0x012f
        L_0x01a9:
            r33 = r7
            r24 = r8
            r32 = r13
            r25 = r15
            r7 = r23
            goto L_0x01be
        L_0x01b4:
            r33 = r7
            r24 = r8
            r32 = r13
            r25 = r15
            r7 = r21
        L_0x01be:
            r8 = 0
            if (r7 == 0) goto L_0x01cb
            Ah[] r8 = new defpackage.Ah[r8]
            java.lang.Object[] r7 = r7.toArray(r8)
            Ah[] r7 = (defpackage.Ah[]) r7
            r0.f614a = r7
        L_0x01cb:
            boolean r7 = r2.isEmpty()
            java.lang.String r8 = "waveOffset"
            java.lang.String r13 = "CUSTOM,"
            r22 = 10
            r23 = 9
            r26 = 8
            r27 = 5
            r28 = 4
            r29 = 3
            if (r7 != 0) goto L_0x04f1
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.f622b = r7
            java.util.Iterator r7 = r2.iterator()
        L_0x01ec:
            boolean r30 = r7.hasNext()
            if (r30 == 0) goto L_0x0470
            java.lang.Object r30 = r7.next()
            r15 = r30
            java.lang.String r15 = (java.lang.String) r15
            boolean r30 = r15.startsWith(r13)
            if (r30 == 0) goto L_0x025c
            r48 = r7
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            r30 = r3
            java.lang.String r3 = ","
            java.lang.String[] r3 = r15.split(r3)
            r31 = 1
            r3 = r3[r31]
            java.util.Iterator r31 = r6.iterator()
        L_0x0217:
            boolean r34 = r31.hasNext()
            if (r34 == 0) goto L_0x0240
            java.lang.Object r34 = r31.next()
            r35 = r2
            r2 = r34
            lh r2 = (defpackage.C0260lh) r2
            r34 = r5
            java.util.HashMap<java.lang.String, O6> r5 = r2.f3093a
            if (r5 != 0) goto L_0x022e
            goto L_0x023b
        L_0x022e:
            java.lang.Object r5 = r5.get(r3)
            O6 r5 = (defpackage.O6) r5
            if (r5 == 0) goto L_0x023b
            int r2 = r2.a
            r7.append(r2, r5)
        L_0x023b:
            r5 = r34
            r2 = r35
            goto L_0x0217
        L_0x0240:
            r35 = r2
            r34 = r5
            MC$b r2 = new MC$b
            r2.<init>(r15, r7)
            r5 = r24
            r7 = r25
            r3 = r32
            r24 = r8
            r25 = r19
            r8 = r2
            r19 = r18
            r2 = r33
            r18 = r17
            goto L_0x042f
        L_0x025c:
            r35 = r2
            r30 = r3
            r34 = r5
            r48 = r7
            int r2 = r15.hashCode()
            switch(r2) {
                case -1249320806: goto L_0x03a9;
                case -1249320805: goto L_0x0387;
                case -1225497657: goto L_0x0365;
                case -1225497656: goto L_0x034c;
                case -1225497655: goto L_0x032d;
                case -1001078227: goto L_0x030f;
                case -908189618: goto L_0x02ec;
                case -908189617: goto L_0x02d0;
                case -797520672: goto L_0x02c4;
                case -760884510: goto L_0x02b8;
                case -760884509: goto L_0x02ac;
                case -40300674: goto L_0x02a2;
                case -4379043: goto L_0x0298;
                case 37232917: goto L_0x028e;
                case 92909918: goto L_0x0284;
                case 156108012: goto L_0x0279;
                default: goto L_0x026b;
            }
        L_0x026b:
            r5 = r24
            r7 = r25
            r3 = r32
            r2 = r33
        L_0x0273:
            r24 = r8
            r8 = r17
            goto L_0x033f
        L_0x0279:
            boolean r2 = r15.equals(r8)
            if (r2 != 0) goto L_0x0280
            goto L_0x026b
        L_0x0280:
            r2 = 15
            goto L_0x02d8
        L_0x0284:
            boolean r2 = r15.equals(r9)
            if (r2 != 0) goto L_0x028b
            goto L_0x026b
        L_0x028b:
            r2 = 14
            goto L_0x02d8
        L_0x028e:
            boolean r2 = r15.equals(r12)
            if (r2 != 0) goto L_0x0295
            goto L_0x026b
        L_0x0295:
            r2 = 13
            goto L_0x02d8
        L_0x0298:
            boolean r2 = r15.equals(r10)
            if (r2 != 0) goto L_0x029f
            goto L_0x026b
        L_0x029f:
            r2 = 12
            goto L_0x02d8
        L_0x02a2:
            boolean r2 = r15.equals(r11)
            if (r2 != 0) goto L_0x02a9
            goto L_0x026b
        L_0x02a9:
            r2 = 11
            goto L_0x02d8
        L_0x02ac:
            java.lang.String r2 = "transformPivotY"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02b5
            goto L_0x026b
        L_0x02b5:
            r2 = r22
            goto L_0x02d8
        L_0x02b8:
            java.lang.String r2 = "transformPivotX"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02c1
            goto L_0x026b
        L_0x02c1:
            r2 = r23
            goto L_0x02d8
        L_0x02c4:
            java.lang.String r2 = "waveVariesBy"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02cd
            goto L_0x026b
        L_0x02cd:
            r2 = r26
            goto L_0x02d8
        L_0x02d0:
            boolean r2 = r15.equals(r14)
            if (r2 != 0) goto L_0x02d7
            goto L_0x026b
        L_0x02d7:
            r2 = 7
        L_0x02d8:
            r5 = r24
            r7 = r25
            r3 = r32
            r24 = r8
            r8 = r17
            r25 = r19
            r17 = r2
            r19 = r18
            r2 = r33
            goto L_0x03c5
        L_0x02ec:
            r2 = r33
            boolean r3 = r15.equals(r2)
            if (r3 != 0) goto L_0x02fc
            r5 = r24
            r7 = r25
            r3 = r32
            goto L_0x0273
        L_0x02fc:
            r3 = 6
            r5 = r24
            r7 = r25
            r24 = r8
            r8 = r17
            r25 = r19
            r17 = r3
            r19 = r18
            r3 = r32
            goto L_0x03c5
        L_0x030f:
            r3 = r32
            r2 = r33
            boolean r5 = r15.equals(r3)
            if (r5 != 0) goto L_0x031f
            r5 = r24
            r7 = r25
            goto L_0x0273
        L_0x031f:
            r5 = r24
            r7 = r25
            r24 = r8
            r8 = r17
            r25 = r19
            r17 = r27
            goto L_0x0384
        L_0x032d:
            r5 = r24
            r3 = r32
            r2 = r33
            boolean r7 = r15.equals(r5)
            r24 = r8
            r8 = r17
            if (r7 != 0) goto L_0x0345
            r7 = r25
        L_0x033f:
            r25 = r19
        L_0x0341:
            r19 = r18
            goto L_0x03c3
        L_0x0345:
            r7 = r25
            r17 = r28
            r25 = r19
            goto L_0x0384
        L_0x034c:
            r5 = r24
            r7 = r25
            r3 = r32
            r2 = r33
            boolean r24 = r15.equals(r7)
            if (r24 != 0) goto L_0x035c
            goto L_0x0273
        L_0x035c:
            r24 = r8
            r8 = r17
            r25 = r19
            r17 = r29
            goto L_0x0384
        L_0x0365:
            r5 = r24
            r7 = r25
            r3 = r32
            r2 = r33
            r24 = r8
            r8 = r19
            boolean r19 = r15.equals(r8)
            if (r19 != 0) goto L_0x037c
            r25 = r8
            r8 = r17
            goto L_0x0341
        L_0x037c:
            r19 = 2
            r25 = r8
            r8 = r17
            r17 = r19
        L_0x0384:
            r19 = r18
            goto L_0x03c5
        L_0x0387:
            r5 = r24
            r7 = r25
            r3 = r32
            r2 = r33
            r24 = r8
            r8 = r18
            r25 = r19
            boolean r18 = r15.equals(r8)
            if (r18 != 0) goto L_0x03a0
            r19 = r8
            r8 = r17
            goto L_0x03c3
        L_0x03a0:
            r18 = 1
            r19 = r8
            r8 = r17
            r17 = r18
            goto L_0x03c5
        L_0x03a9:
            r5 = r24
            r7 = r25
            r3 = r32
            r2 = r33
            r24 = r8
            r8 = r17
            r25 = r19
            r19 = r18
            boolean r17 = r15.equals(r8)
            if (r17 != 0) goto L_0x03c0
            goto L_0x03c3
        L_0x03c0:
            r17 = 0
            goto L_0x03c5
        L_0x03c3:
            r17 = -1
        L_0x03c5:
            switch(r17) {
                case 0: goto L_0x0426;
                case 1: goto L_0x0420;
                case 2: goto L_0x041a;
                case 3: goto L_0x0414;
                case 4: goto L_0x040e;
                case 5: goto L_0x0408;
                case 6: goto L_0x0402;
                case 7: goto L_0x03fc;
                case 8: goto L_0x03f6;
                case 9: goto L_0x03f0;
                case 10: goto L_0x03ea;
                case 11: goto L_0x03e4;
                case 12: goto L_0x03de;
                case 13: goto L_0x03d8;
                case 14: goto L_0x03d2;
                case 15: goto L_0x03cc;
                default: goto L_0x03c8;
            }
        L_0x03c8:
            r17 = r21
            goto L_0x042b
        L_0x03cc:
            MC$a r17 = new MC$a
            r17.<init>()
            goto L_0x042b
        L_0x03d2:
            MC$a r17 = new MC$a
            r17.<init>()
            goto L_0x042b
        L_0x03d8:
            MC$d r17 = new MC$d
            r17.<init>()
            goto L_0x042b
        L_0x03de:
            MC$c r17 = new MC$c
            r17.<init>()
            goto L_0x042b
        L_0x03e4:
            MC$h r17 = new MC$h
            r17.<init>()
            goto L_0x042b
        L_0x03ea:
            MC$f r17 = new MC$f
            r17.<init>()
            goto L_0x042b
        L_0x03f0:
            MC$e r17 = new MC$e
            r17.<init>()
            goto L_0x042b
        L_0x03f6:
            MC$a r17 = new MC$a
            r17.<init>()
            goto L_0x042b
        L_0x03fc:
            MC$l r17 = new MC$l
            r17.<init>()
            goto L_0x042b
        L_0x0402:
            MC$k r17 = new MC$k
            r17.<init>()
            goto L_0x042b
        L_0x0408:
            MC$g r17 = new MC$g
            r17.<init>()
            goto L_0x042b
        L_0x040e:
            MC$o r17 = new MC$o
            r17.<init>()
            goto L_0x042b
        L_0x0414:
            MC$n r17 = new MC$n
            r17.<init>()
            goto L_0x042b
        L_0x041a:
            MC$m r17 = new MC$m
            r17.<init>()
            goto L_0x042b
        L_0x0420:
            MC$j r17 = new MC$j
            r17.<init>()
            goto L_0x042b
        L_0x0426:
            MC$i r17 = new MC$i
            r17.<init>()
        L_0x042b:
            r18 = r8
            r8 = r17
        L_0x042f:
            if (r8 != 0) goto L_0x044b
            r33 = r2
            r32 = r3
            r17 = r18
            r18 = r19
            r8 = r24
            r19 = r25
            r3 = r30
            r2 = r35
            r24 = r5
            r25 = r7
            r5 = r34
            r7 = r48
            goto L_0x01ec
        L_0x044b:
            r8.f167a = r15
            r17 = r7
            java.util.HashMap<java.lang.String, MC> r7 = r0.f622b
            r7.put(r15, r8)
            r7 = r48
            r33 = r2
            r32 = r3
            r8 = r24
            r3 = r30
            r2 = r35
            r24 = r5
            r5 = r34
            r45 = r25
            r25 = r17
            r17 = r18
            r18 = r19
            r19 = r45
            goto L_0x01ec
        L_0x0470:
            r35 = r2
            r30 = r3
            r34 = r5
            r5 = r24
            r3 = r32
            r2 = r33
            r24 = r8
            r45 = r18
            r18 = r17
            r17 = r25
            r25 = r19
            r19 = r45
            if (r6 == 0) goto L_0x04a4
            java.util.Iterator r7 = r6.iterator()
        L_0x048e:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x04a4
            java.lang.Object r8 = r7.next()
            lh r8 = (defpackage.C0260lh) r8
            boolean r15 = r8 instanceof defpackage.mh
            if (r15 == 0) goto L_0x048e
            java.util.HashMap<java.lang.String, MC> r15 = r0.f622b
            r8.a(r15)
            goto L_0x048e
        L_0x04a4:
            java.util.HashMap<java.lang.String, MC> r7 = r0.f622b
            r8 = 0
            r15 = r20
            r15.a(r7, r8)
            java.util.HashMap<java.lang.String, MC> r7 = r0.f622b
            r8 = 100
            Tl r15 = r0.f618b
            r15.a(r7, r8)
            java.util.HashMap<java.lang.String, MC> r7 = r0.f622b
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x04bf:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0509
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r15 = r4.containsKey(r8)
            if (r15 == 0) goto L_0x04de
            java.lang.Object r15 = r4.get(r8)
            java.lang.Integer r15 = (java.lang.Integer) r15
            if (r15 == 0) goto L_0x04de
            int r15 = r15.intValue()
            goto L_0x04df
        L_0x04de:
            r15 = 0
        L_0x04df:
            r48 = r7
            java.util.HashMap<java.lang.String, MC> r7 = r0.f622b
            java.lang.Object r7 = r7.get(r8)
            Ex r7 = (defpackage.Ex) r7
            if (r7 == 0) goto L_0x04ee
            r7.c(r15)
        L_0x04ee:
            r7 = r48
            goto L_0x04bf
        L_0x04f1:
            r35 = r2
            r30 = r3
            r34 = r5
            r5 = r24
            r3 = r32
            r2 = r33
            r24 = r8
            r45 = r18
            r18 = r17
            r17 = r25
            r25 = r19
            r19 = r45
        L_0x0509:
            boolean r7 = r1.isEmpty()
            java.lang.String r8 = "CUSTOM"
            if (r7 != 0) goto L_0x0aad
            java.util.HashMap<java.lang.String, NC> r7 = r0.f609a
            if (r7 != 0) goto L_0x051c
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.f609a = r7
        L_0x051c:
            java.util.Iterator r1 = r1.iterator()
        L_0x0520:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x06dc
            java.lang.Object r7 = r1.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashMap<java.lang.String, NC> r15 = r0.f609a
            boolean r15 = r15.containsKey(r7)
            if (r15 == 0) goto L_0x0535
            goto L_0x0520
        L_0x0535:
            boolean r15 = r7.startsWith(r13)
            if (r15 == 0) goto L_0x058f
            android.util.SparseArray r15 = new android.util.SparseArray
            r15.<init>()
            r48 = r1
            java.lang.String r1 = ","
            java.lang.String[] r1 = r7.split(r1)
            r20 = 1
            r1 = r1[r20]
            java.util.Iterator r20 = r6.iterator()
        L_0x0550:
            boolean r31 = r20.hasNext()
            if (r31 == 0) goto L_0x0579
            java.lang.Object r31 = r20.next()
            r32 = r13
            r13 = r31
            lh r13 = (defpackage.C0260lh) r13
            r31 = r4
            java.util.HashMap<java.lang.String, O6> r4 = r13.f3093a
            if (r4 != 0) goto L_0x0567
            goto L_0x0574
        L_0x0567:
            java.lang.Object r4 = r4.get(r1)
            O6 r4 = (defpackage.O6) r4
            if (r4 == 0) goto L_0x0574
            int r13 = r13.a
            r15.append(r13, r4)
        L_0x0574:
            r4 = r31
            r13 = r32
            goto L_0x0550
        L_0x0579:
            r31 = r4
            r32 = r13
            NC$b r1 = new NC$b
            r1.<init>(r7, r15)
            r15 = r1
            r1 = r17
            r13 = r19
            r19 = r25
            r17 = r5
            r4 = r49
            goto L_0x06c2
        L_0x058f:
            r48 = r1
            r31 = r4
            r32 = r13
            int r1 = r7.hashCode()
            switch(r1) {
                case -1249320806: goto L_0x064d;
                case -1249320805: goto L_0x0638;
                case -1225497657: goto L_0x0621;
                case -1225497656: goto L_0x060d;
                case -1225497655: goto L_0x05fa;
                case -1001078227: goto L_0x05ed;
                case -908189618: goto L_0x05d7;
                case -908189617: goto L_0x05ce;
                case -40300674: goto L_0x05c4;
                case -4379043: goto L_0x05ba;
                case 37232917: goto L_0x05b0;
                case 92909918: goto L_0x05a6;
                default: goto L_0x059c;
            }
        L_0x059c:
            r1 = r17
        L_0x059e:
            r15 = r18
            r13 = r19
            r4 = r25
            goto L_0x065f
        L_0x05a6:
            boolean r1 = r7.equals(r9)
            if (r1 != 0) goto L_0x05ad
            goto L_0x059c
        L_0x05ad:
            r1 = 11
            goto L_0x05f6
        L_0x05b0:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x05b7
            goto L_0x059c
        L_0x05b7:
            r1 = r22
            goto L_0x05f6
        L_0x05ba:
            boolean r1 = r7.equals(r10)
            if (r1 != 0) goto L_0x05c1
            goto L_0x059c
        L_0x05c1:
            r1 = r23
            goto L_0x05f6
        L_0x05c4:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x05cb
            goto L_0x059c
        L_0x05cb:
            r1 = r26
            goto L_0x05f6
        L_0x05ce:
            boolean r1 = r7.equals(r14)
            if (r1 != 0) goto L_0x05d5
            goto L_0x059c
        L_0x05d5:
            r1 = 7
            goto L_0x05df
        L_0x05d7:
            boolean r1 = r7.equals(r2)
            if (r1 != 0) goto L_0x05de
            goto L_0x059c
        L_0x05de:
            r1 = 6
        L_0x05df:
            r15 = r18
            r13 = r19
            r4 = r25
            r45 = r17
            r17 = r1
            r1 = r45
            goto L_0x0661
        L_0x05ed:
            boolean r1 = r7.equals(r3)
            if (r1 != 0) goto L_0x05f4
            goto L_0x059c
        L_0x05f4:
            r1 = r27
        L_0x05f6:
            r4 = r1
            r1 = r17
            goto L_0x0618
        L_0x05fa:
            boolean r1 = r7.equals(r5)
            if (r1 != 0) goto L_0x0601
            goto L_0x059c
        L_0x0601:
            r1 = r17
            r15 = r18
            r13 = r19
            r4 = r25
            r17 = r28
            goto L_0x0661
        L_0x060d:
            r1 = r17
            boolean r4 = r7.equals(r1)
            if (r4 != 0) goto L_0x0616
            goto L_0x059e
        L_0x0616:
            r4 = r29
        L_0x0618:
            r17 = r4
            r15 = r18
            r13 = r19
            r4 = r25
            goto L_0x0661
        L_0x0621:
            r1 = r17
            r4 = r25
            boolean r13 = r7.equals(r4)
            if (r13 != 0) goto L_0x0630
            r15 = r18
            r13 = r19
            goto L_0x065f
        L_0x0630:
            r13 = 2
            r17 = r13
            r15 = r18
            r13 = r19
            goto L_0x0661
        L_0x0638:
            r1 = r17
            r13 = r19
            r4 = r25
            boolean r15 = r7.equals(r13)
            if (r15 != 0) goto L_0x0647
            r15 = r18
            goto L_0x065f
        L_0x0647:
            r15 = 1
            r17 = r15
            r15 = r18
            goto L_0x0661
        L_0x064d:
            r1 = r17
            r15 = r18
            r13 = r19
            r4 = r25
            boolean r17 = r7.equals(r15)
            if (r17 != 0) goto L_0x065c
            goto L_0x065f
        L_0x065c:
            r17 = 0
            goto L_0x0661
        L_0x065f:
            r17 = -1
        L_0x0661:
            switch(r17) {
                case 0: goto L_0x06b1;
                case 1: goto L_0x06ab;
                case 2: goto L_0x06a5;
                case 3: goto L_0x069f;
                case 4: goto L_0x0699;
                case 5: goto L_0x0693;
                case 6: goto L_0x068d;
                case 7: goto L_0x0687;
                case 8: goto L_0x0681;
                case 9: goto L_0x067b;
                case 10: goto L_0x0675;
                case 11: goto L_0x066f;
                default: goto L_0x0664;
            }
        L_0x0664:
            r19 = r4
            r17 = r5
            r18 = r15
            r4 = r49
            r15 = r21
            goto L_0x06c2
        L_0x066f:
            NC$a r17 = new NC$a
            r17.<init>()
            goto L_0x06b6
        L_0x0675:
            NC$d r17 = new NC$d
            r17.<init>()
            goto L_0x06b6
        L_0x067b:
            NC$c r17 = new NC$c
            r17.<init>()
            goto L_0x06b6
        L_0x0681:
            NC$f r17 = new NC$f
            r17.<init>()
            goto L_0x06b6
        L_0x0687:
            NC$j r17 = new NC$j
            r17.<init>()
            goto L_0x06b6
        L_0x068d:
            NC$i r17 = new NC$i
            r17.<init>()
            goto L_0x06b6
        L_0x0693:
            NC$e r17 = new NC$e
            r17.<init>()
            goto L_0x06b6
        L_0x0699:
            NC$m r17 = new NC$m
            r17.<init>()
            goto L_0x06b6
        L_0x069f:
            NC$l r17 = new NC$l
            r17.<init>()
            goto L_0x06b6
        L_0x06a5:
            NC$k r17 = new NC$k
            r17.<init>()
            goto L_0x06b6
        L_0x06ab:
            NC$h r17 = new NC$h
            r17.<init>()
            goto L_0x06b6
        L_0x06b1:
            NC$g r17 = new NC$g
            r17.<init>()
        L_0x06b6:
            r19 = r4
            r18 = r15
            r15 = r17
            r17 = r5
            r4 = r49
            r15.f691a = r4
        L_0x06c2:
            if (r15 != 0) goto L_0x06c5
            goto L_0x06cc
        L_0x06c5:
            r15.f693a = r7
            java.util.HashMap<java.lang.String, NC> r4 = r0.f609a
            r4.put(r7, r15)
        L_0x06cc:
            r5 = r17
            r25 = r19
            r4 = r31
            r17 = r1
            r19 = r13
            r13 = r32
            r1 = r48
            goto L_0x0520
        L_0x06dc:
            r31 = r4
            r32 = r13
            r1 = r17
            r13 = r19
            r19 = r25
            r17 = r5
            if (r6 == 0) goto L_0x0a67
            java.util.Iterator r4 = r6.iterator()
        L_0x06ee:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0a67
            java.lang.Object r5 = r4.next()
            lh r5 = (defpackage.C0260lh) r5
            boolean r7 = r5 instanceof defpackage.C0426zh
            if (r7 == 0) goto L_0x0a47
            zh r5 = (defpackage.C0426zh) r5
            java.util.HashMap<java.lang.String, NC> r7 = r0.f609a
            r5.getClass()
            java.util.Set r15 = r7.keySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x070d:
            boolean r20 = r15.hasNext()
            if (r20 == 0) goto L_0x0a47
            java.lang.Object r20 = r15.next()
            r48 = r4
            r4 = r20
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r20 = r7.get(r4)
            r36 = r20
            NC r36 = (defpackage.NC) r36
            if (r36 != 0) goto L_0x073a
            r4 = r5
            r33 = r6
            r20 = r7
            r25 = r8
            r49 = r15
            r0 = r17
            r17 = r18
            r5 = r19
        L_0x0736:
            r18 = r13
            goto L_0x0a30
        L_0x073a:
            boolean r20 = r4.startsWith(r8)
            if (r20 == 0) goto L_0x0799
            r20 = r7
            r7 = 7
            java.lang.String r4 = r4.substring(r7)
            java.util.HashMap<java.lang.String, O6> r7 = r5.f3093a
            java.lang.Object r4 = r7.get(r4)
            O6 r4 = (defpackage.O6) r4
            if (r4 == 0) goto L_0x0791
            r7 = r36
            NC$b r7 = (defpackage.NC.b) r7
            r49 = r15
            int r15 = r5.a
            r25 = r8
            float r8 = r5.m
            r33 = r6
            int r6 = r5.f3486d
            float r0 = r5.n
            r50 = r5
            android.util.SparseArray<O6> r5 = r7.a
            r5.append(r15, r4)
            android.util.SparseArray<float[]> r4 = r7.b
            r5 = 2
            float[] r5 = new float[r5]
            r36 = 0
            r5[r36] = r8
            r8 = 1
            r5[r8] = r0
            r4.append(r15, r5)
            int r0 = r7.f690a
            int r0 = java.lang.Math.max(r0, r6)
            r7.f690a = r0
            r0 = r46
            r4 = r48
            r15 = r49
            r5 = r50
            r7 = r20
            r8 = r25
            r6 = r33
            goto L_0x070d
        L_0x0791:
            r0 = r46
            r4 = r48
            r7 = r20
            goto L_0x070d
        L_0x0799:
            r50 = r5
            r33 = r6
            r20 = r7
            r25 = r8
            r49 = r15
            int r0 = r4.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x0833;
                case -1249320805: goto L_0x0822;
                case -1225497657: goto L_0x0815;
                case -1225497656: goto L_0x0809;
                case -1225497655: goto L_0x07fd;
                case -1001078227: goto L_0x07f3;
                case -908189618: goto L_0x07e3;
                case -908189617: goto L_0x07da;
                case -40300674: goto L_0x07d0;
                case -4379043: goto L_0x07c6;
                case 37232917: goto L_0x07bc;
                case 92909918: goto L_0x07b2;
                default: goto L_0x07aa;
            }
        L_0x07aa:
            r0 = r17
        L_0x07ac:
            r6 = r18
            r5 = r19
            goto L_0x0842
        L_0x07b2:
            boolean r0 = r4.equals(r9)
            if (r0 != 0) goto L_0x07b9
            goto L_0x07aa
        L_0x07b9:
            r0 = 11
            goto L_0x07eb
        L_0x07bc:
            boolean r0 = r4.equals(r12)
            if (r0 != 0) goto L_0x07c3
            goto L_0x07f9
        L_0x07c3:
            r0 = r22
            goto L_0x07eb
        L_0x07c6:
            boolean r0 = r4.equals(r10)
            if (r0 != 0) goto L_0x07cd
            goto L_0x07aa
        L_0x07cd:
            r0 = r23
            goto L_0x07eb
        L_0x07d0:
            boolean r0 = r4.equals(r11)
            if (r0 != 0) goto L_0x07d7
            goto L_0x07f9
        L_0x07d7:
            r0 = r26
            goto L_0x07eb
        L_0x07da:
            boolean r0 = r4.equals(r14)
            if (r0 != 0) goto L_0x07e1
            goto L_0x07aa
        L_0x07e1:
            r0 = 7
            goto L_0x07eb
        L_0x07e3:
            boolean r0 = r4.equals(r2)
            if (r0 != 0) goto L_0x07ea
            goto L_0x07f9
        L_0x07ea:
            r0 = 6
        L_0x07eb:
            r4 = r0
            r0 = r17
        L_0x07ee:
            r6 = r18
            r5 = r19
            goto L_0x0843
        L_0x07f3:
            boolean r0 = r4.equals(r3)
            if (r0 != 0) goto L_0x07fa
        L_0x07f9:
            goto L_0x07aa
        L_0x07fa:
            r0 = r27
            goto L_0x07eb
        L_0x07fd:
            r0 = r17
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0806
            goto L_0x0811
        L_0x0806:
            r4 = r28
            goto L_0x07ee
        L_0x0809:
            r0 = r17
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0812
        L_0x0811:
            goto L_0x07ac
        L_0x0812:
            r4 = r29
            goto L_0x07ee
        L_0x0815:
            r0 = r17
            r5 = r19
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0820
            goto L_0x082c
        L_0x0820:
            r4 = 2
            goto L_0x0830
        L_0x0822:
            r0 = r17
            r5 = r19
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x082f
        L_0x082c:
            r6 = r18
            goto L_0x0842
        L_0x082f:
            r4 = 1
        L_0x0830:
            r6 = r18
            goto L_0x0843
        L_0x0833:
            r0 = r17
            r6 = r18
            r5 = r19
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0840
            goto L_0x0842
        L_0x0840:
            r4 = 0
            goto L_0x0843
        L_0x0842:
            r4 = -1
        L_0x0843:
            switch(r4) {
                case 0: goto L_0x0a0b;
                case 1: goto L_0x09e5;
                case 2: goto L_0x09bf;
                case 3: goto L_0x0998;
                case 4: goto L_0x0971;
                case 5: goto L_0x094a;
                case 6: goto L_0x0923;
                case 7: goto L_0x08fc;
                case 8: goto L_0x08d5;
                case 9: goto L_0x08ae;
                case 10: goto L_0x0887;
                case 11: goto L_0x085c;
                default: goto L_0x0846;
            }
        L_0x0846:
            r4 = r48
            r15 = r49
            r17 = r0
            r19 = r5
            r18 = r6
            r7 = r20
            r8 = r25
            r6 = r33
            r0 = r46
            r5 = r50
            goto L_0x070d
        L_0x085c:
            r4 = r50
            float r7 = r4.a
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x0883
            int r7 = r4.a
            float r8 = r4.a
            float r15 = r4.m
            r17 = r6
            int r6 = r4.f3486d
            r18 = r13
            float r13 = r4.n
            r37 = r8
            r38 = r15
            r39 = r13
            r40 = r7
            r41 = r6
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x0883:
            r17 = r6
            goto L_0x0736
        L_0x0887:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.f
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.f
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x08ae:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.b
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.b
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x08d5:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.c
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.c
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x08fc:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.h
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.h
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x0923:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.g
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.g
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x094a:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.l
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.l
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x0971:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.k
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.k
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x0998:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.j
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.j
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x09bf:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.i
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.i
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x09e5:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.e
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.e
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
            goto L_0x0a30
        L_0x0a0b:
            r4 = r50
            r17 = r6
            r18 = r13
            float r6 = r4.d
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x0a30
            int r6 = r4.a
            float r7 = r4.d
            float r8 = r4.m
            int r13 = r4.f3486d
            float r15 = r4.n
            r37 = r7
            r38 = r8
            r39 = r15
            r40 = r6
            r41 = r13
            r36.b(r37, r38, r39, r40, r41)
        L_0x0a30:
            r15 = r49
            r19 = r5
            r13 = r18
            r7 = r20
            r8 = r25
            r6 = r33
            r5 = r4
            r18 = r17
            r4 = r48
            r17 = r0
            r0 = r46
            goto L_0x070d
        L_0x0a47:
            r48 = r4
            r33 = r6
            r25 = r8
            r0 = r17
            r17 = r18
            r5 = r19
            r18 = r13
            r4 = r48
            r19 = r5
            r13 = r18
            r8 = r25
            r6 = r33
            r18 = r17
            r17 = r0
            r0 = r46
            goto L_0x06ee
        L_0x0a67:
            r33 = r6
            r25 = r8
            r0 = r17
            r17 = r18
            r5 = r19
            r18 = r13
            r4 = r46
            java.util.HashMap<java.lang.String, NC> r6 = r4.f609a
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0a7f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0abd
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r8 = r31
            boolean r13 = r8.containsKey(r7)
            if (r13 == 0) goto L_0x0a9e
            java.lang.Object r13 = r8.get(r7)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            goto L_0x0a9f
        L_0x0a9e:
            r13 = 0
        L_0x0a9f:
            java.util.HashMap<java.lang.String, NC> r15 = r4.f609a
            java.lang.Object r7 = r15.get(r7)
            NC r7 = (defpackage.NC) r7
            r7.c(r13)
            r31 = r8
            goto L_0x0a7f
        L_0x0aad:
            r4 = r0
            r0 = r5
            r33 = r6
            r32 = r13
            r1 = r17
            r17 = r18
            r18 = r19
            r5 = r25
            r25 = r8
        L_0x0abd:
            int r6 = r34.size()
            int r6 = r6 + 2
            Xl[] r7 = new defpackage.Xl[r6]
            r8 = 0
            r7[r8] = r16
            int r13 = r6 + -1
            Xl r15 = r4.f619b
            r7[r13] = r15
            int r13 = r34.size()
            if (r13 <= 0) goto L_0x0adb
            int r13 = r4.f617b
            r15 = -1
            if (r13 != r15) goto L_0x0adb
            r4.f617b = r8
        L_0x0adb:
            java.util.Iterator r8 = r34.iterator()
            r13 = 1
        L_0x0ae0:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0af3
            java.lang.Object r15 = r8.next()
            Xl r15 = (defpackage.Xl) r15
            int r19 = r13 + 1
            r7[r13] = r15
            r13 = r19
            goto L_0x0ae0
        L_0x0af3:
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            Xl r13 = r4.f619b
            java.util.LinkedHashMap<java.lang.String, O6> r13 = r13.f682a
            java.util.Set r13 = r13.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0b04:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0b45
            java.lang.Object r15 = r13.next()
            java.lang.String r15 = (java.lang.String) r15
            r19 = r5
            r48 = r13
            r13 = r16
            java.util.LinkedHashMap<java.lang.String, O6> r5 = r13.f682a
            boolean r5 = r5.containsKey(r15)
            if (r5 == 0) goto L_0x0b3a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r16 = r13
            r13 = r32
            r5.<init>(r13)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            r13 = r35
            boolean r5 = r13.contains(r5)
            if (r5 != 0) goto L_0x0b3e
            r8.add(r15)
            goto L_0x0b3e
        L_0x0b3a:
            r16 = r13
            r13 = r35
        L_0x0b3e:
            r35 = r13
            r5 = r19
            r13 = r48
            goto L_0x0b04
        L_0x0b45:
            r19 = r5
            r5 = 0
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r5 = r8.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            r4.f616a = r5
            int r5 = r5.length
            int[] r5 = new int[r5]
            r4.f626b = r5
            r5 = 0
        L_0x0b58:
            java.lang.String[] r8 = r4.f616a
            int r13 = r8.length
            if (r5 >= r13) goto L_0x0b8f
            r8 = r8[r5]
            int[] r13 = r4.f626b
            r15 = 0
            r13[r5] = r15
            r13 = 0
        L_0x0b65:
            if (r13 >= r6) goto L_0x0b8c
            r15 = r7[r13]
            java.util.LinkedHashMap<java.lang.String, O6> r15 = r15.f682a
            boolean r15 = r15.containsKey(r8)
            if (r15 == 0) goto L_0x0b89
            r15 = r7[r13]
            java.util.LinkedHashMap<java.lang.String, O6> r15 = r15.f682a
            java.lang.Object r15 = r15.get(r8)
            O6 r15 = (defpackage.O6) r15
            if (r15 == 0) goto L_0x0b89
            int[] r8 = r4.f626b
            r13 = r8[r5]
            int r15 = r15.c()
            int r15 = r15 + r13
            r8[r5] = r15
            goto L_0x0b8c
        L_0x0b89:
            int r13 = r13 + 1
            goto L_0x0b65
        L_0x0b8c:
            int r5 = r5 + 1
            goto L_0x0b58
        L_0x0b8f:
            r5 = 0
            r5 = r7[r5]
            int r5 = r5.f686d
            r13 = -1
            if (r5 == r13) goto L_0x0b99
            r5 = 1
            goto L_0x0b9a
        L_0x0b99:
            r5 = 0
        L_0x0b9a:
            int r8 = r8.length
            int r8 = r8 + 18
            boolean[] r13 = new boolean[r8]
            r15 = 1
        L_0x0ba0:
            if (r15 >= r6) goto L_0x0c0f
            r20 = r1
            r1 = r7[r15]
            int r31 = r15 + -1
            r32 = r0
            r0 = r7[r31]
            r31 = r3
            float r3 = r1.c
            r35 = r2
            float r2 = r0.c
            boolean r2 = defpackage.Xl.f(r3, r2)
            float r3 = r1.d
            r36 = r14
            float r14 = r0.d
            boolean r3 = defpackage.Xl.f(r3, r14)
            r14 = 0
            boolean r14 = r13[r14]
            r37 = r11
            float r11 = r1.b
            r38 = r10
            float r10 = r0.b
            boolean r10 = defpackage.Xl.f(r11, r10)
            r10 = r10 | r14
            r11 = 0
            r13[r11] = r10
            r10 = 1
            boolean r11 = r13[r10]
            r2 = r2 | r3
            r2 = r2 | r5
            r3 = r11 | r2
            r13[r10] = r3
            r3 = 2
            boolean r10 = r13[r3]
            r2 = r2 | r10
            r13[r3] = r2
            boolean r2 = r13[r29]
            float r3 = r1.e
            float r10 = r0.e
            boolean r3 = defpackage.Xl.f(r3, r10)
            r2 = r2 | r3
            r13[r29] = r2
            boolean r2 = r13[r28]
            float r1 = r1.f
            float r0 = r0.f
            boolean r0 = defpackage.Xl.f(r1, r0)
            r0 = r0 | r2
            r13[r28] = r0
            int r15 = r15 + 1
            r1 = r20
            r3 = r31
            r0 = r32
            r2 = r35
            r14 = r36
            r11 = r37
            r10 = r38
            goto L_0x0ba0
        L_0x0c0f:
            r32 = r0
            r20 = r1
            r35 = r2
            r31 = r3
            r38 = r10
            r37 = r11
            r36 = r14
            r0 = 0
            r1 = 1
        L_0x0c1f:
            if (r1 >= r8) goto L_0x0c2a
            boolean r2 = r13[r1]
            if (r2 == 0) goto L_0x0c27
            int r0 = r0 + 1
        L_0x0c27:
            int r1 = r1 + 1
            goto L_0x0c1f
        L_0x0c2a:
            int[] r1 = new int[r0]
            r4.f613a = r1
            r1 = 2
            int r0 = java.lang.Math.max(r1, r0)
            double[] r1 = new double[r0]
            r4.f611a = r1
            double[] r0 = new double[r0]
            r4.f624b = r0
            r0 = 0
            r1 = 1
        L_0x0c3d:
            if (r1 >= r8) goto L_0x0c4d
            boolean r2 = r13[r1]
            if (r2 == 0) goto L_0x0c4a
            int[] r2 = r4.f613a
            int r3 = r0 + 1
            r2[r0] = r1
            r0 = r3
        L_0x0c4a:
            int r1 = r1 + 1
            goto L_0x0c3d
        L_0x0c4d:
            int[] r0 = r4.f613a
            int r0 = r0.length
            r1 = 2
            int[] r1 = new int[r1]
            r2 = 1
            r1[r2] = r0
            r0 = 0
            r1[r0] = r6
            java.lang.Class r0 = java.lang.Double.TYPE
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r1)
            double[][] r0 = (double[][]) r0
            double[] r1 = new double[r6]
            r2 = 0
        L_0x0c64:
            if (r2 >= r6) goto L_0x0cac
            r3 = r7[r2]
            r5 = r0[r2]
            int[] r8 = r4.f613a
            r10 = 6
            float[] r10 = new float[r10]
            float r11 = r3.b
            r13 = 0
            r10[r13] = r11
            float r11 = r3.c
            r13 = 1
            r10[r13] = r11
            float r11 = r3.d
            r13 = 2
            r10[r13] = r11
            float r11 = r3.e
            r10[r29] = r11
            float r11 = r3.f
            r10[r28] = r11
            float r3 = r3.g
            r10[r27] = r3
            r3 = 0
            r11 = 0
        L_0x0c8c:
            int r13 = r8.length
            if (r3 >= r13) goto L_0x0ca2
            r13 = r8[r3]
            r14 = 6
            if (r13 >= r14) goto L_0x0c9f
            int r14 = r11 + 1
            r13 = r10[r13]
            r48 = r14
            double r13 = (double) r13
            r5[r11] = r13
            r11 = r48
        L_0x0c9f:
            int r3 = r3 + 1
            goto L_0x0c8c
        L_0x0ca2:
            r3 = r7[r2]
            float r3 = r3.f679a
            double r10 = (double) r3
            r1[r2] = r10
            int r2 = r2 + 1
            goto L_0x0c64
        L_0x0cac:
            r2 = 0
        L_0x0cad:
            int[] r3 = r4.f613a
            int r5 = r3.length
            if (r2 >= r5) goto L_0x0ce2
            r3 = r3[r2]
            r5 = 6
            if (r3 >= r5) goto L_0x0cdf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String[] r5 = defpackage.Xl.a
            int[] r8 = r4.f613a
            r8 = r8[r2]
            r5 = r5[r8]
            java.lang.String r8 = " ["
            java.lang.String r3 = defpackage.C0709Uj.j(r3, r5, r8)
            r5 = 0
        L_0x0ccb:
            if (r5 >= r6) goto L_0x0cdf
            java.lang.StringBuilder r3 = defpackage.xx.J(r3)
            r8 = r0[r5]
            r10 = r8[r2]
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r5 = r5 + 1
            goto L_0x0ccb
        L_0x0cdf:
            int r2 = r2 + 1
            goto L_0x0cad
        L_0x0ce2:
            java.lang.String[] r2 = r4.f616a
            int r2 = r2.length
            int r2 = r2 + 1
            H7[] r2 = new defpackage.H7[r2]
            r4.f615a = r2
            r2 = 0
        L_0x0cec:
            java.lang.String[] r3 = r4.f616a
            int r5 = r3.length
            if (r2 >= r5) goto L_0x0db6
            r3 = r3[r2]
            r5 = 0
            r8 = 0
            r10 = r21
            r11 = r10
        L_0x0cf8:
            if (r5 >= r6) goto L_0x0d9a
            r13 = r7[r5]
            java.util.LinkedHashMap<java.lang.String, O6> r13 = r13.f682a
            boolean r13 = r13.containsKey(r3)
            if (r13 == 0) goto L_0x0d8e
            if (r11 != 0) goto L_0x0d2b
            double[] r10 = new double[r6]
            r11 = r7[r5]
            java.util.LinkedHashMap<java.lang.String, O6> r11 = r11.f682a
            java.lang.Object r11 = r11.get(r3)
            O6 r11 = (defpackage.O6) r11
            if (r11 != 0) goto L_0x0d16
            r11 = 0
            goto L_0x0d1a
        L_0x0d16:
            int r11 = r11.c()
        L_0x0d1a:
            r13 = 2
            int[] r13 = new int[r13]
            r14 = 1
            r13[r14] = r11
            r11 = 0
            r13[r11] = r6
            java.lang.Class r11 = java.lang.Double.TYPE
            java.lang.Object r11 = java.lang.reflect.Array.newInstance(r11, r13)
            double[][] r11 = (double[][]) r11
        L_0x0d2b:
            r13 = r7[r5]
            float r14 = r13.f679a
            double r14 = (double) r14
            r10[r8] = r14
            r14 = r11[r8]
            java.util.LinkedHashMap<java.lang.String, O6> r13 = r13.f682a
            java.lang.Object r13 = r13.get(r3)
            O6 r13 = (defpackage.O6) r13
            if (r13 != 0) goto L_0x0d47
            r48 = r3
            r40 = r9
            r49 = r10
            r50 = r11
            goto L_0x0d87
        L_0x0d47:
            int r15 = r13.c()
            r48 = r3
            r3 = 1
            if (r15 != r3) goto L_0x0d5f
            float r3 = r13.a()
            r49 = r10
            r50 = r11
            double r10 = (double) r3
            r3 = 0
            r14[r3] = r10
        L_0x0d5c:
            r40 = r9
            goto L_0x0d87
        L_0x0d5f:
            r49 = r10
            r50 = r11
            int r3 = r13.c()
            float[] r10 = new float[r3]
            r13.b(r10)
            r11 = 0
            r13 = 0
        L_0x0d6e:
            if (r11 >= r3) goto L_0x0d5c
            int r15 = r13 + 1
            r39 = r3
            r3 = r10[r11]
            r40 = r9
            r41 = r10
            double r9 = (double) r3
            r14[r13] = r9
            int r11 = r11 + 1
            r13 = r15
            r3 = r39
            r9 = r40
            r10 = r41
            goto L_0x0d6e
        L_0x0d87:
            int r8 = r8 + 1
            r10 = r49
            r11 = r50
            goto L_0x0d92
        L_0x0d8e:
            r48 = r3
            r40 = r9
        L_0x0d92:
            int r5 = r5 + 1
            r3 = r48
            r9 = r40
            goto L_0x0cf8
        L_0x0d9a:
            r40 = r9
            double[] r3 = java.util.Arrays.copyOf(r10, r8)
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r11, r8)
            double[][] r5 = (double[][]) r5
            H7[] r8 = r4.f615a
            int r2 = r2 + 1
            int r9 = r4.f617b
            H7 r3 = defpackage.H7.a(r9, r3, r5)
            r8[r2] = r3
            r9 = r40
            goto L_0x0cec
        L_0x0db6:
            r40 = r9
            H7[] r2 = r4.f615a
            int r3 = r4.f617b
            H7 r0 = defpackage.H7.a(r3, r1, r0)
            r1 = 0
            r2[r1] = r0
            r0 = r7[r1]
            int r0 = r0.f686d
            r2 = -1
            if (r0 == r2) goto L_0x0e04
            int[] r0 = new int[r6]
            double[] r2 = new double[r6]
            r3 = 2
            int[] r5 = new int[r3]
            r8 = 1
            r5[r8] = r3
            r5[r1] = r6
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
            double[][] r1 = (double[][]) r1
            r3 = 0
        L_0x0ddf:
            if (r3 >= r6) goto L_0x0dfd
            r5 = r7[r3]
            int r8 = r5.f686d
            r0[r3] = r8
            float r8 = r5.f679a
            double r8 = (double) r8
            r2[r3] = r8
            r8 = r1[r3]
            float r9 = r5.c
            double r9 = (double) r9
            r11 = 0
            r8[r11] = r9
            float r5 = r5.d
            double r9 = (double) r5
            r5 = 1
            r8[r5] = r9
            int r3 = r3 + 1
            goto L_0x0ddf
        L_0x0dfd:
            D1 r3 = new D1
            r3.<init>(r0, r2, r1)
            r4.f602a = r3
        L_0x0e04:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r4.f628c = r0
            if (r33 == 0) goto L_0x159f
            java.util.Iterator r0 = r30.iterator()
            r1 = 2143289344(0x7fc00000, float:NaN)
        L_0x0e13:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x122e
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = r25
            boolean r5 = r2.startsWith(r3)
            if (r5 == 0) goto L_0x0e47
            BC$b r5 = new BC$b
            r5.<init>()
            r48 = r0
            r0 = r5
            r15 = r19
            r14 = r20
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            r19 = r18
            goto L_0x10e6
        L_0x0e47:
            int r5 = r2.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x105f;
                case -1249320805: goto L_0x1033;
                case -1225497657: goto L_0x1008;
                case -1225497656: goto L_0x0fdd;
                case -1225497655: goto L_0x0fb8;
                case -1001078227: goto L_0x0f91;
                case -908189618: goto L_0x0f69;
                case -908189617: goto L_0x0f41;
                case -797520672: goto L_0x0f16;
                case -40300674: goto L_0x0f04;
                case -4379043: goto L_0x0ee2;
                case 37232917: goto L_0x0ea7;
                case 92909918: goto L_0x0e99;
                case 156108012: goto L_0x0e6a;
                default: goto L_0x0e4e;
            }
        L_0x0e4e:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r5 = r24
        L_0x0e58:
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
        L_0x0e66:
            r19 = r18
            goto L_0x1083
        L_0x0e6a:
            r5 = r24
            boolean r6 = r2.equals(r5)
            if (r6 != 0) goto L_0x0e7b
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            goto L_0x0e58
        L_0x0e7b:
            r6 = 13
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r17 = r6
            r19 = r18
            r6 = r40
            goto L_0x1085
        L_0x0e99:
            r5 = r24
            r6 = r40
            boolean r7 = r2.equals(r6)
            if (r7 != 0) goto L_0x0ea4
            goto L_0x0eb1
        L_0x0ea4:
            r7 = 12
            goto L_0x0ec8
        L_0x0ea7:
            r5 = r24
            r6 = r40
            boolean r7 = r2.equals(r12)
            if (r7 != 0) goto L_0x0ec6
        L_0x0eb1:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            goto L_0x0e66
        L_0x0ec6:
            r7 = 11
        L_0x0ec8:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r17 = r7
            r19 = r18
            r7 = r38
            goto L_0x1085
        L_0x0ee2:
            r5 = r24
            r7 = r38
            r6 = r40
            boolean r8 = r2.equals(r7)
            if (r8 != 0) goto L_0x0ef4
            r9 = r36
            r8 = r37
            goto L_0x0f51
        L_0x0ef4:
            r14 = r20
            r15 = r22
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            goto L_0x0fff
        L_0x0f04:
            r5 = r24
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r9 = r2.equals(r8)
            if (r9 != 0) goto L_0x0f13
            goto L_0x0f26
        L_0x0f13:
            r9 = r23
            goto L_0x0f2b
        L_0x0f16:
            r5 = r24
            r8 = r37
            r7 = r38
            r6 = r40
            java.lang.String r9 = "waveVariesBy"
            boolean r9 = r2.equals(r9)
            if (r9 != 0) goto L_0x0f29
        L_0x0f26:
            r9 = r36
            goto L_0x0f51
        L_0x0f29:
            r9 = r26
        L_0x0f2b:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r11 = r31
            r13 = r32
            r10 = r35
            r17 = r9
            r19 = r18
            r9 = r36
            goto L_0x1085
        L_0x0f41:
            r5 = r24
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r10 = r2.equals(r9)
            if (r10 != 0) goto L_0x0f54
        L_0x0f51:
            r10 = r35
            goto L_0x0f7b
        L_0x0f54:
            r10 = 7
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r11 = r31
            r13 = r32
            r17 = r10
            r19 = r18
            r10 = r35
            goto L_0x1085
        L_0x0f69:
            r5 = r24
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r11 = r2.equals(r10)
            if (r11 != 0) goto L_0x0f7e
        L_0x0f7b:
            r11 = r31
            goto L_0x0fa5
        L_0x0f7e:
            r11 = 6
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r13 = r32
            r17 = r11
            r19 = r18
            r11 = r31
            goto L_0x1085
        L_0x0f91:
            r5 = r24
            r11 = r31
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r13 = r2.equals(r11)
            if (r13 != 0) goto L_0x0fb1
        L_0x0fa5:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r13 = r32
            goto L_0x0e66
        L_0x0fb1:
            r14 = r20
            r15 = r27
            r13 = r32
            goto L_0x0fff
        L_0x0fb8:
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r14 = r2.equals(r13)
            if (r14 != 0) goto L_0x0fd8
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            goto L_0x0e66
        L_0x0fd8:
            r14 = r20
            r15 = r28
            goto L_0x0fff
        L_0x0fdd:
            r14 = r20
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r15 = r2.equals(r14)
            if (r15 != 0) goto L_0x0ffd
            r48 = r0
            r0 = r17
            r15 = r19
            goto L_0x0e66
        L_0x0ffd:
            r15 = r29
        L_0x0fff:
            r48 = r0
            r0 = r17
            r17 = r15
            r15 = r19
            goto L_0x1030
        L_0x1008:
            r15 = r19
            r14 = r20
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r19 = r2.equals(r15)
            if (r19 != 0) goto L_0x1028
            r48 = r0
            r0 = r17
            goto L_0x0e66
        L_0x1028:
            r19 = 2
            r48 = r0
            r0 = r17
            r17 = r19
        L_0x1030:
            r19 = r18
            goto L_0x1085
        L_0x1033:
            r48 = r0
            r0 = r18
            r15 = r19
            r14 = r20
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            boolean r18 = r2.equals(r0)
            if (r18 != 0) goto L_0x1056
            r19 = r0
            r0 = r17
            goto L_0x1083
        L_0x1056:
            r18 = 1
            r19 = r0
            r0 = r17
            r17 = r18
            goto L_0x1085
        L_0x105f:
            r48 = r0
            r0 = r17
            r15 = r19
            r14 = r20
            r5 = r24
            r11 = r31
            r13 = r32
            r10 = r35
            r9 = r36
            r8 = r37
            r7 = r38
            r6 = r40
            r19 = r18
            boolean r17 = r2.equals(r0)
            if (r17 != 0) goto L_0x1080
            goto L_0x1083
        L_0x1080:
            r17 = 0
            goto L_0x1085
        L_0x1083:
            r17 = -1
        L_0x1085:
            switch(r17) {
                case 0: goto L_0x10db;
                case 1: goto L_0x10d5;
                case 2: goto L_0x10cf;
                case 3: goto L_0x10c9;
                case 4: goto L_0x10c3;
                case 5: goto L_0x10bd;
                case 6: goto L_0x10b7;
                case 7: goto L_0x10b1;
                case 8: goto L_0x10ab;
                case 9: goto L_0x10a5;
                case 10: goto L_0x109f;
                case 11: goto L_0x1099;
                case 12: goto L_0x1093;
                case 13: goto L_0x108d;
                default: goto L_0x1088;
            }
        L_0x1088:
            r17 = r0
            r0 = r21
            goto L_0x10e6
        L_0x108d:
            BC$a r17 = new BC$a
            r17.<init>()
            goto L_0x10e0
        L_0x1093:
            BC$a r17 = new BC$a
            r17.<init>()
            goto L_0x10e0
        L_0x1099:
            BC$d r17 = new BC$d
            r17.<init>()
            goto L_0x10e0
        L_0x109f:
            BC$c r17 = new BC$c
            r17.<init>()
            goto L_0x10e0
        L_0x10a5:
            BC$f r17 = new BC$f
            r17.<init>()
            goto L_0x10e0
        L_0x10ab:
            BC$a r17 = new BC$a
            r17.<init>()
            goto L_0x10e0
        L_0x10b1:
            BC$j r17 = new BC$j
            r17.<init>()
            goto L_0x10e0
        L_0x10b7:
            BC$i r17 = new BC$i
            r17.<init>()
            goto L_0x10e0
        L_0x10bd:
            BC$e r17 = new BC$e
            r17.<init>()
            goto L_0x10e0
        L_0x10c3:
            BC$m r17 = new BC$m
            r17.<init>()
            goto L_0x10e0
        L_0x10c9:
            BC$l r17 = new BC$l
            r17.<init>()
            goto L_0x10e0
        L_0x10cf:
            BC$k r17 = new BC$k
            r17.<init>()
            goto L_0x10e0
        L_0x10d5:
            BC$h r17 = new BC$h
            r17.<init>()
            goto L_0x10e0
        L_0x10db:
            BC$g r17 = new BC$g
            r17.<init>()
        L_0x10e0:
            r45 = r17
            r17 = r0
            r0 = r45
        L_0x10e6:
            if (r0 != 0) goto L_0x1104
            r0 = r48
            r25 = r3
            r24 = r5
            r40 = r6
            r38 = r7
            r37 = r8
            r36 = r9
            r35 = r10
            r31 = r11
            r32 = r13
            r20 = r14
            r18 = r19
            r19 = r15
            goto L_0x0e13
        L_0x1104:
            r25 = r15
            int r15 = r0.b
            r20 = r14
            r14 = 1
            if (r15 != r14) goto L_0x110f
            r14 = 1
            goto L_0x1110
        L_0x110f:
            r14 = 0
        L_0x1110:
            if (r14 == 0) goto L_0x11ff
            boolean r14 = java.lang.Float.isNaN(r1)
            if (r14 == 0) goto L_0x11ff
            r1 = 2
            float[] r1 = new float[r1]
            r14 = 99
            float r14 = (float) r14
            r15 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 / r14
            r30 = 0
            r14 = 0
            r18 = 0
            r32 = r11
            r24 = r13
            r13 = r18
            r42 = r30
        L_0x112e:
            r11 = 100
            if (r13 >= r11) goto L_0x11f5
            float r11 = (float) r13
            float r11 = r11 * r15
            r18 = r9
            r49 = r10
            double r9 = (double) r11
            r35 = r9
            r9 = r16
            T9 r10 = r9.f680a
            java.util.Iterator r16 = r34.iterator()
            r37 = 0
            r38 = 2143289344(0x7fc00000, float:NaN)
        L_0x1147:
            boolean r39 = r16.hasNext()
            if (r39 == 0) goto L_0x1179
            java.lang.Object r39 = r16.next()
            r50 = r9
            r9 = r39
            Xl r9 = (defpackage.Xl) r9
            r44 = r15
            T9 r15 = r9.f680a
            if (r15 == 0) goto L_0x1174
            r39 = r15
            float r15 = r9.f679a
            int r40 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r40 >= 0) goto L_0x116a
            r37 = r15
            r10 = r39
            goto L_0x1174
        L_0x116a:
            boolean r15 = java.lang.Float.isNaN(r38)
            if (r15 == 0) goto L_0x1174
            float r9 = r9.f679a
            r38 = r9
        L_0x1174:
            r9 = r50
            r15 = r44
            goto L_0x1147
        L_0x1179:
            r50 = r9
            r44 = r15
            if (r10 == 0) goto L_0x119a
            boolean r9 = java.lang.Float.isNaN(r38)
            if (r9 == 0) goto L_0x1187
            r38 = 1065353216(0x3f800000, float:1.0)
        L_0x1187:
            float r11 = r11 - r37
            float r38 = r38 - r37
            float r11 = r11 / r38
            r15 = r8
            double r8 = (double) r11
            double r8 = r10.a(r8)
            float r8 = (float) r8
            float r8 = r8 * r38
            float r8 = r8 + r37
            double r8 = (double) r8
            goto L_0x119d
        L_0x119a:
            r15 = r8
            r8 = r35
        L_0x119d:
            H7[] r10 = r4.f615a
            r11 = 0
            r10 = r10[r11]
            double[] r11 = r4.f611a
            r10.c(r8, r11)
            Xl r10 = r4.f604a
            int[] r11 = r4.f613a
            r16 = r15
            double[] r15 = r4.f611a
            r41 = 0
            r35 = r10
            r36 = r8
            r38 = r11
            r39 = r15
            r40 = r1
            r35.h(r36, r38, r39, r40, r41)
            if (r13 <= 0) goto L_0x11d5
            double r8 = (double) r14
            r10 = 1
            r10 = r1[r10]
            double r10 = (double) r10
            double r10 = r30 - r10
            r14 = 0
            r15 = r1[r14]
            double r14 = (double) r15
            double r14 = r42 - r14
            double r10 = java.lang.Math.hypot(r10, r14)
            double r10 = r10 + r8
            float r8 = (float) r10
            r14 = 0
            goto L_0x11db
        L_0x11d5:
            r8 = 0
            r45 = r14
            r14 = r8
            r8 = r45
        L_0x11db:
            r9 = r1[r14]
            double r9 = (double) r9
            r11 = 1
            r11 = r1[r11]
            double r14 = (double) r11
            int r13 = r13 + 1
            r42 = r9
            r30 = r14
            r9 = r18
            r15 = r44
            r10 = r49
            r14 = r8
            r8 = r16
            r16 = r50
            goto L_0x112e
        L_0x11f5:
            r18 = r9
            r49 = r10
            r50 = r16
            r16 = r8
            r1 = r14
            goto L_0x120b
        L_0x11ff:
            r18 = r9
            r49 = r10
            r32 = r11
            r24 = r13
            r50 = r16
            r16 = r8
        L_0x120b:
            r0.f3193a = r2
            java.util.HashMap<java.lang.String, BC> r8 = r4.f628c
            r8.put(r2, r0)
            r0 = r48
            r35 = r49
            r40 = r6
            r38 = r7
            r37 = r16
            r36 = r18
            r18 = r19
            r19 = r25
            r31 = r32
            r16 = r50
            r25 = r3
            r32 = r24
            r24 = r5
            goto L_0x0e13
        L_0x122e:
            r5 = r24
            r3 = r25
            r24 = r32
            r49 = r35
            r16 = r37
            r7 = r38
            r6 = r40
            r25 = r19
            r32 = r31
            r19 = r18
            r18 = r36
            java.util.Iterator r0 = r33.iterator()
        L_0x1248:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1584
            java.lang.Object r1 = r0.next()
            lh r1 = (defpackage.C0260lh) r1
            boolean r2 = r1 instanceof defpackage.oh
            if (r2 == 0) goto L_0x154e
            oh r1 = (defpackage.oh) r1
            java.util.HashMap<java.lang.String, BC> r2 = r4.f628c
            r1.getClass()
            java.util.Set r8 = r2.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x1267:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x154e
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = r9.startsWith(r3)
            if (r10 == 0) goto L_0x130f
            r10 = 7
            java.lang.String r10 = r9.substring(r10)
            java.util.HashMap<java.lang.String, O6> r11 = r1.f3093a
            java.lang.Object r10 = r11.get(r10)
            O6 r10 = (defpackage.O6) r10
            if (r10 == 0) goto L_0x12f5
            int r11 = r10.f463a
            r13 = 2
            if (r11 == r13) goto L_0x128e
            goto L_0x1296
        L_0x128e:
            java.lang.Object r9 = r2.get(r9)
            BC r9 = (defpackage.BC) r9
            if (r9 != 0) goto L_0x129f
        L_0x1296:
            r48 = r0
            r21 = r2
            r30 = r3
            r50 = r8
            goto L_0x12d9
        L_0x129f:
            int r11 = r1.a
            int r13 = r1.f3159d
            java.lang.String r14 = r1.f3157b
            int r15 = r1.f3160e
            r48 = r0
            float r0 = r1.a
            r50 = r8
            float r8 = r1.b
            float r4 = r1.c
            float r37 = r10.a()
            r21 = r2
            java.util.ArrayList<qh$b> r2 = r9.f3194a
            r30 = r3
            qh$b r3 = new qh$b
            r33 = r3
            r34 = r0
            r35 = r8
            r36 = r4
            r38 = r11
            r33.<init>(r34, r35, r36, r37, r38)
            r2.add(r3)
            r0 = -1
            if (r15 == r0) goto L_0x12d2
            r9.b = r15
        L_0x12d2:
            r9.a = r13
            r9.c(r10)
            r9.f3196b = r14
        L_0x12d9:
            r40 = r6
            r38 = r7
            r37 = r16
            r14 = r17
            r36 = r18
            r13 = r19
            r10 = r20
            r18 = r24
            r11 = r25
            r15 = r30
            r16 = r32
            r17 = r1
            r24 = r5
            goto L_0x152b
        L_0x12f5:
            r48 = r0
            r50 = r8
            r0 = r2
            r15 = r3
            r37 = r16
            r14 = r17
            r2 = r18
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            r3 = r49
            goto L_0x14d2
        L_0x130f:
            r48 = r0
            r21 = r2
            r30 = r3
            r50 = r8
            int r0 = r9.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x1465;
                case -1249320805: goto L_0x1447;
                case -1225497657: goto L_0x1427;
                case -1225497656: goto L_0x1407;
                case -1225497655: goto L_0x13e4;
                case -1001078227: goto L_0x13c5;
                case -908189618: goto L_0x13a4;
                case -908189617: goto L_0x1378;
                case -40300674: goto L_0x1363;
                case -4379043: goto L_0x1355;
                case 37232917: goto L_0x134b;
                case 92909918: goto L_0x1341;
                case 156108012: goto L_0x1334;
                case 1530034690: goto L_0x1328;
                default: goto L_0x131e;
            }
        L_0x131e:
            r3 = r49
            r0 = r16
            r14 = r17
            r2 = r18
            goto L_0x1386
        L_0x1328:
            java.lang.String r0 = "wavePhase"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x1331
            goto L_0x131e
        L_0x1331:
            r0 = 13
            goto L_0x133d
        L_0x1334:
            boolean r0 = r9.equals(r5)
            if (r0 != 0) goto L_0x133b
            goto L_0x131e
        L_0x133b:
            r0 = 12
        L_0x133d:
            r2 = r0
            r0 = r16
            goto L_0x1370
        L_0x1341:
            boolean r0 = r9.equals(r6)
            if (r0 != 0) goto L_0x1348
            goto L_0x1351
        L_0x1348:
            r0 = 11
            goto L_0x133d
        L_0x134b:
            boolean r0 = r9.equals(r12)
            if (r0 != 0) goto L_0x1352
        L_0x1351:
            goto L_0x131e
        L_0x1352:
            r0 = r22
            goto L_0x133d
        L_0x1355:
            boolean r0 = r9.equals(r7)
            if (r0 != 0) goto L_0x135e
            r0 = r16
            goto L_0x136b
        L_0x135e:
            r0 = r16
            r2 = r23
            goto L_0x1370
        L_0x1363:
            r0 = r16
            boolean r2 = r9.equals(r0)
            if (r2 != 0) goto L_0x136e
        L_0x136b:
            r2 = r18
            goto L_0x1382
        L_0x136e:
            r2 = r26
        L_0x1370:
            r3 = r49
            r15 = r2
            r14 = r17
            r2 = r18
            goto L_0x13b9
        L_0x1378:
            r0 = r16
            r2 = r18
            boolean r3 = r9.equals(r2)
            if (r3 != 0) goto L_0x1392
        L_0x1382:
            r3 = r49
            r14 = r17
        L_0x1386:
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            goto L_0x1480
        L_0x1392:
            r3 = 7
            r15 = r3
            r14 = r17
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            r3 = r49
            goto L_0x1481
        L_0x13a4:
            r3 = r49
            r0 = r16
            r2 = r18
            boolean r4 = r9.equals(r3)
            if (r4 != 0) goto L_0x13b5
            r8 = r24
            r4 = r32
            goto L_0x13f4
        L_0x13b5:
            r4 = 6
            r15 = r4
            r14 = r17
        L_0x13b9:
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            goto L_0x1481
        L_0x13c5:
            r3 = r49
            r0 = r16
            r2 = r18
            r4 = r32
            boolean r8 = r9.equals(r4)
            if (r8 != 0) goto L_0x13d6
            r8 = r24
            goto L_0x13f4
        L_0x13d6:
            r14 = r17
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r15 = r27
            goto L_0x1481
        L_0x13e4:
            r3 = r49
            r0 = r16
            r2 = r18
            r8 = r24
            r4 = r32
            boolean r10 = r9.equals(r8)
            if (r10 != 0) goto L_0x13fb
        L_0x13f4:
            r14 = r17
            r13 = r19
            r10 = r20
            goto L_0x141d
        L_0x13fb:
            r14 = r17
            r13 = r19
            r10 = r20
            r11 = r25
            r15 = r28
            goto L_0x1481
        L_0x1407:
            r3 = r49
            r0 = r16
            r2 = r18
            r10 = r20
            r8 = r24
            r4 = r32
            boolean r11 = r9.equals(r10)
            r14 = r17
            r13 = r19
            if (r11 != 0) goto L_0x1421
        L_0x141d:
            r11 = r25
            goto L_0x1480
        L_0x1421:
            r11 = r25
            r15 = r29
            goto L_0x1481
        L_0x1427:
            r3 = r49
            r0 = r16
            r2 = r18
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            boolean r13 = r9.equals(r11)
            if (r13 != 0) goto L_0x1440
            r14 = r17
            r13 = r19
            goto L_0x1480
        L_0x1440:
            r13 = 2
            r15 = r13
            r14 = r17
            r13 = r19
            goto L_0x1481
        L_0x1447:
            r3 = r49
            r0 = r16
            r2 = r18
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            boolean r14 = r9.equals(r13)
            if (r14 != 0) goto L_0x1460
            r14 = r17
            goto L_0x1480
        L_0x1460:
            r14 = 1
            r15 = r14
            r14 = r17
            goto L_0x1481
        L_0x1465:
            r3 = r49
            r0 = r16
            r14 = r17
            r2 = r18
            r13 = r19
            r10 = r20
            r8 = r24
            r11 = r25
            r4 = r32
            boolean r15 = r9.equals(r14)
            if (r15 != 0) goto L_0x147e
            goto L_0x1480
        L_0x147e:
            r15 = 0
            goto L_0x1481
        L_0x1480:
            r15 = -1
        L_0x1481:
            switch(r15) {
                case 0: goto L_0x14b5;
                case 1: goto L_0x14b2;
                case 2: goto L_0x14af;
                case 3: goto L_0x14ac;
                case 4: goto L_0x14a9;
                case 5: goto L_0x14a6;
                case 6: goto L_0x14a3;
                case 7: goto L_0x14a0;
                case 8: goto L_0x149d;
                case 9: goto L_0x149a;
                case 10: goto L_0x1497;
                case 11: goto L_0x1494;
                case 12: goto L_0x1491;
                case 13: goto L_0x148e;
                default: goto L_0x1484;
            }
        L_0x1484:
            r15 = r30
            r9.startsWith(r15)
            r16 = 2143289344(0x7fc00000, float:NaN)
            r34 = r16
            goto L_0x14bb
        L_0x148e:
            float r15 = r1.c
            goto L_0x14b7
        L_0x1491:
            float r15 = r1.b
            goto L_0x14b7
        L_0x1494:
            float r15 = r1.e
            goto L_0x14b7
        L_0x1497:
            float r15 = r1.h
            goto L_0x14b7
        L_0x149a:
            float r15 = r1.f
            goto L_0x14b7
        L_0x149d:
            float r15 = r1.g
            goto L_0x14b7
        L_0x14a0:
            float r15 = r1.l
            goto L_0x14b7
        L_0x14a3:
            float r15 = r1.k
            goto L_0x14b7
        L_0x14a6:
            float r15 = r1.d
            goto L_0x14b7
        L_0x14a9:
            float r15 = r1.o
            goto L_0x14b7
        L_0x14ac:
            float r15 = r1.n
            goto L_0x14b7
        L_0x14af:
            float r15 = r1.m
            goto L_0x14b7
        L_0x14b2:
            float r15 = r1.j
            goto L_0x14b7
        L_0x14b5:
            float r15 = r1.i
        L_0x14b7:
            r34 = r15
            r15 = r30
        L_0x14bb:
            boolean r16 = java.lang.Float.isNaN(r34)
            if (r16 == 0) goto L_0x14c6
            r37 = r0
            r0 = r21
            goto L_0x14d2
        L_0x14c6:
            r37 = r0
            r0 = r21
            java.lang.Object r9 = r0.get(r9)
            BC r9 = (defpackage.BC) r9
            if (r9 != 0) goto L_0x14ee
        L_0x14d2:
            r18 = r2
            r49 = r3
            r32 = r4
            r24 = r8
            r20 = r10
            r25 = r11
            r19 = r13
            r17 = r14
            r3 = r15
            r16 = r37
            r4 = r46
            r8 = r50
            r2 = r0
            r0 = r48
            goto L_0x1267
        L_0x14ee:
            r21 = r0
            int r0 = r1.a
            r36 = r2
            int r2 = r1.f3159d
            r49 = r3
            java.lang.String r3 = r1.f3157b
            r16 = r4
            int r4 = r1.f3160e
            r24 = r5
            float r5 = r1.a
            r40 = r6
            float r6 = r1.b
            r38 = r7
            float r7 = r1.c
            r17 = r1
            java.util.ArrayList<qh$b> r1 = r9.f3194a
            r18 = r8
            qh$b r8 = new qh$b
            r30 = r8
            r31 = r5
            r32 = r6
            r33 = r7
            r35 = r0
            r30.<init>(r31, r32, r33, r34, r35)
            r1.add(r8)
            r0 = -1
            if (r4 == r0) goto L_0x1527
            r9.b = r4
        L_0x1527:
            r9.a = r2
            r9.f3196b = r3
        L_0x152b:
            r4 = r46
            r0 = r48
            r8 = r50
            r20 = r10
            r25 = r11
            r19 = r13
            r3 = r15
            r32 = r16
            r1 = r17
            r2 = r21
            r5 = r24
            r16 = r37
            r7 = r38
            r6 = r40
            r17 = r14
            r24 = r18
            r18 = r36
            goto L_0x1267
        L_0x154e:
            r48 = r0
            r15 = r3
            r40 = r6
            r38 = r7
            r37 = r16
            r14 = r17
            r36 = r18
            r13 = r19
            r10 = r20
            r18 = r24
            r11 = r25
            r16 = r32
            r24 = r5
            r4 = r46
            r0 = r48
            r20 = r10
            r25 = r11
            r19 = r13
            r17 = r14
            r3 = r15
            r32 = r16
            r5 = r24
            r16 = r37
            r7 = r38
            r6 = r40
            r24 = r18
            r18 = r36
            goto L_0x1248
        L_0x1584:
            r0 = r4
            java.util.HashMap<java.lang.String, BC> r1 = r0.f628c
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x158f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x15a0
            java.lang.Object r2 = r1.next()
            BC r2 = (defpackage.BC) r2
            r2.d()
            goto L_0x158f
        L_0x159f:
            r0 = r4
        L_0x15a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Vl.h(int, int, long):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        Xl xl = this.f604a;
        sb.append(xl.c);
        sb.append(" y: ");
        sb.append(xl.d);
        sb.append(" end: x: ");
        Xl xl2 = this.f619b;
        sb.append(xl2.c);
        sb.append(" y: ");
        sb.append(xl2.d);
        return sb.toString();
    }
}
