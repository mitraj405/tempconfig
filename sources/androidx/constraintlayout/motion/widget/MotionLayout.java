package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.helper.widget.MotionEffect;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.widget.NestedScrollView;
import com.google.common.primitives.Ints;
import defpackage.D2;
import defpackage.Ux;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements C0382wm {
    public static boolean k;
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public long f1433a = 0;

    /* renamed from: a  reason: collision with other field name */
    public P8 f1434a;

    /* renamed from: a  reason: collision with other field name */
    public Wl f1435a;

    /* renamed from: a  reason: collision with other field name */
    public Matrix f1436a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1437a;

    /* renamed from: a  reason: collision with other field name */
    public final RectF f1438a;

    /* renamed from: a  reason: collision with other field name */
    public View f1439a;

    /* renamed from: a  reason: collision with other field name */
    public Interpolator f1440a = null;

    /* renamed from: a  reason: collision with other field name */
    public final d f1441a = new d();

    /* renamed from: a  reason: collision with other field name */
    public e f1442a;

    /* renamed from: a  reason: collision with other field name */
    public final f f1443a;

    /* renamed from: a  reason: collision with other field name */
    public h f1444a;

    /* renamed from: a  reason: collision with other field name */
    public i f1445a;

    /* renamed from: a  reason: collision with other field name */
    public j f1446a;

    /* renamed from: a  reason: collision with other field name */
    public a f1447a;

    /* renamed from: a  reason: collision with other field name */
    public final cy f1448a = new cy();

    /* renamed from: a  reason: collision with other field name */
    public Runnable f1449a = null;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<MotionHelper> f1450a = null;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<View, Vl> f1451a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public CopyOnWriteArrayList<i> f1452a = null;

    /* renamed from: a  reason: collision with other field name */
    public final nh f1453a = new nh(0);

    /* renamed from: a  reason: collision with other field name */
    public boolean f1454a = true;
    public float b = 1.0f;

    /* renamed from: b  reason: collision with other field name */
    public long f1455b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<MotionHelper> f1456b = null;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1457b;
    public float c = 0.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f1458c = -1;

    /* renamed from: c  reason: collision with other field name */
    public long f1459c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<MotionHelper> f1460c = null;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1461c = false;
    public float d = 0.0f;

    /* renamed from: d  reason: collision with other field name */
    public int f1462d = -1;

    /* renamed from: d  reason: collision with other field name */
    public long f1463d = -1;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<Integer> f1464d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1465d = false;
    public float e = 0.0f;

    /* renamed from: e  reason: collision with other field name */
    public int f1466e = -1;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1467e = false;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f1468f = 0;

    /* renamed from: f  reason: collision with other field name */
    public boolean f1469f = false;
    public float g;

    /* renamed from: g  reason: collision with other field name */
    public int f1470g = 0;

    /* renamed from: g  reason: collision with other field name */
    public boolean f1471g = false;
    public float h;

    /* renamed from: h  reason: collision with other field name */
    public int f1472h = 0;

    /* renamed from: h  reason: collision with other field name */
    public boolean f1473h = false;
    public float i = 0.0f;

    /* renamed from: i  reason: collision with other field name */
    public int f1474i;

    /* renamed from: i  reason: collision with other field name */
    public boolean f1475i;
    public float j = 0.0f;

    /* renamed from: j  reason: collision with other field name */
    public int f1476j;

    /* renamed from: j  reason: collision with other field name */
    public boolean f1477j;

    /* renamed from: k  reason: collision with other field name */
    public float f1478k;

    /* renamed from: k  reason: collision with other field name */
    public int f1479k = 0;
    public int l = 0;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            MotionLayout.this.f1444a.a();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        public final void run() {
            this.a.setNestedScrollingEnabled(true);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            MotionLayout.this.f1444a.a();
        }
    }

    public class d extends Wl {
        public float a = 0.0f;
        public float b = 0.0f;
        public float c;

        public d() {
        }

        public final float a() {
            return MotionLayout.this.a;
        }

        public final float getInterpolation(float f) {
            float f2 = this.a;
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            MotionLayout motionLayout = MotionLayout.this;
            if (i > 0) {
                float f3 = this.c;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                motionLayout.a = f2 - (f3 * f);
                return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.b;
            }
            float f4 = this.c;
            if ((-f2) / f4 < f) {
                f = (-f2) / f4;
            }
            motionLayout.a = (f4 * f) + f2;
            return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.b;
        }
    }

    public class e {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final Paint f1481a;

        /* renamed from: a  reason: collision with other field name */
        public Path f1482a;

        /* renamed from: a  reason: collision with other field name */
        public final Rect f1483a = new Rect();

        /* renamed from: a  reason: collision with other field name */
        public float[] f1485a;

        /* renamed from: a  reason: collision with other field name */
        public final int[] f1486a;
        public final int b = 1;

        /* renamed from: b  reason: collision with other field name */
        public final Paint f1487b;

        /* renamed from: b  reason: collision with other field name */
        public final float[] f1488b;
        public final Paint c;

        /* renamed from: c  reason: collision with other field name */
        public final float[] f1489c;
        public final Paint d;
        public final Paint e;

        public e() {
            Paint paint = new Paint();
            this.f1481a = paint;
            paint.setAntiAlias(true);
            paint.setColor(-21965);
            paint.setStrokeWidth(2.0f);
            paint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f1487b = paint2;
            paint2.setAntiAlias(true);
            paint2.setColor(-2067046);
            paint2.setStrokeWidth(2.0f);
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.c = paint3;
            paint3.setAntiAlias(true);
            paint3.setColor(-13391360);
            paint3.setStrokeWidth(2.0f);
            paint3.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.d = paint4;
            paint4.setAntiAlias(true);
            paint4.setColor(-13391360);
            paint4.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f1489c = new float[8];
            Paint paint5 = new Paint();
            this.e = paint5;
            paint5.setAntiAlias(true);
            paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
            this.f1488b = new float[100];
            this.f1486a = new int[50];
        }

        public final void a(Canvas canvas, int i, int i2, Vl vl) {
            int i3;
            int i4;
            int i5;
            float f;
            float f2;
            Paint paint;
            Canvas canvas2 = canvas;
            int i6 = i;
            Vl vl2 = vl;
            Paint paint2 = this.c;
            int[] iArr = this.f1486a;
            int i7 = 4;
            if (i6 == 4) {
                boolean z = false;
                boolean z2 = false;
                for (int i8 = 0; i8 < this.a; i8++) {
                    int i9 = iArr[i8];
                    if (i9 == 1) {
                        z = true;
                    }
                    if (i9 == 0) {
                        z2 = true;
                    }
                }
                if (z) {
                    float[] fArr = this.f1485a;
                    canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], paint2);
                }
                if (z2) {
                    b(canvas);
                }
            }
            if (i6 == 2) {
                float[] fArr2 = this.f1485a;
                canvas.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], paint2);
            }
            if (i6 == 3) {
                b(canvas);
            }
            canvas2.drawLines(this.f1485a, this.f1481a);
            View view = vl2.f606a;
            if (view != null) {
                i4 = view.getWidth();
                i3 = vl2.f606a.getHeight();
            } else {
                i4 = 0;
                i3 = 0;
            }
            int i10 = 1;
            while (i10 < i2 - 1) {
                if (i6 == i7 && iArr[i10 - 1] == 0) {
                    i5 = i10;
                } else {
                    int i11 = i10 * 2;
                    float[] fArr3 = this.f1488b;
                    float f3 = fArr3[i11];
                    float f4 = fArr3[i11 + 1];
                    this.f1482a.reset();
                    this.f1482a.moveTo(f3, f4 + 10.0f);
                    this.f1482a.lineTo(f3 + 10.0f, f4);
                    this.f1482a.lineTo(f3, f4 - 10.0f);
                    this.f1482a.lineTo(f3 - 10.0f, f4);
                    this.f1482a.close();
                    int i12 = i10 - 1;
                    Xl xl = vl2.f608a.get(i12);
                    Paint paint3 = this.e;
                    if (i6 == i7) {
                        int i13 = iArr[i12];
                        if (i13 == 1) {
                            d(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else if (i13 == 0) {
                            c(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else if (i13 == 2) {
                            paint = paint3;
                            f2 = f4;
                            f = f3;
                            i5 = i10;
                            e(canvas, f3 - 0.0f, f4 - 0.0f, i4, i3);
                            canvas2.drawPath(this.f1482a, paint);
                        }
                        paint = paint3;
                        f2 = f4;
                        f = f3;
                        i5 = i10;
                        canvas2.drawPath(this.f1482a, paint);
                    } else {
                        paint = paint3;
                        f2 = f4;
                        f = f3;
                        i5 = i10;
                    }
                    if (i6 == 2) {
                        d(canvas2, f - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == 3) {
                        c(canvas2, f - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == 6) {
                        e(canvas, f - 0.0f, f2 - 0.0f, i4, i3);
                    }
                    canvas2.drawPath(this.f1482a, paint);
                }
                i10 = i5 + 1;
                i7 = 4;
            }
            float[] fArr4 = this.f1485a;
            if (fArr4.length > 1) {
                float f5 = fArr4[0];
                float f6 = fArr4[1];
                Paint paint4 = this.f1487b;
                canvas2.drawCircle(f5, f6, 8.0f, paint4);
                float[] fArr5 = this.f1485a;
                canvas2.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint4);
            }
        }

        public final void b(Canvas canvas) {
            float[] fArr = this.f1485a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            float min = Math.min(f, f3);
            float max = Math.max(f2, f4);
            float max2 = Math.max(f, f3);
            float max3 = Math.max(f2, f4);
            Paint paint = this.c;
            canvas.drawLine(min, max, max2, max3, paint);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), paint);
        }

        public final void c(Canvas canvas, float f, float f2) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f1485a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d))) / 100.0f);
            Paint paint = this.d;
            f(paint, str);
            Rect rect = this.f1483a;
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (rect.width() / 2))) + min, f2 - 20.0f, paint);
            float min3 = Math.min(f3, f5);
            Rect rect2 = rect;
            Paint paint2 = this.c;
            canvas.drawLine(f, f2, min3, f2, paint2);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            f(paint, str2);
            canvas2.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - ((float) (rect2.height() / 2))), paint);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), paint2);
        }

        public final void d(Canvas canvas, float f, float f2) {
            float f3 = f;
            float f4 = f2;
            float[] fArr = this.f1485a;
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f5 - f7), (double) (f6 - f8));
            float f9 = f7 - f5;
            float f10 = f8 - f6;
            float f11 = (((f4 - f6) * f10) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f12 = f5 + (f9 * f11);
            float f13 = f6 + (f11 * f10);
            Path path = new Path();
            path.moveTo(f, f4);
            path.lineTo(f12, f13);
            float hypot2 = (float) Math.hypot((double) (f12 - f3), (double) (f13 - f4));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            Paint paint = this.d;
            f(paint, str);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f1483a.width() / 2)), -20.0f, paint);
            canvas.drawLine(f3, f4, f12, f13, this.c);
        }

        public final void e(Canvas canvas, float f, float f2, int i, int i2) {
            Canvas canvas2 = canvas;
            StringBuilder sb = new StringBuilder("");
            MotionLayout motionLayout = MotionLayout.this;
            sb.append(((float) ((int) (((double) (((f - ((float) (i / 2))) * 100.0f) / ((float) (motionLayout.getWidth() - i)))) + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            Paint paint = this.d;
            f(paint, sb2);
            Rect rect = this.f1483a;
            canvas2.drawText(sb2, ((f / 2.0f) - ((float) (rect.width() / 2))) + 0.0f, f2 - 20.0f, paint);
            float min = Math.min(0.0f, 1.0f);
            Paint paint2 = this.c;
            canvas.drawLine(f, f2, min, f2, paint2);
            String str = "" + (((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (motionLayout.getHeight() - i2)))) + 0.5d))) / 100.0f);
            f(paint, str);
            canvas2.drawText(str, f + 5.0f, 0.0f - ((f2 / 2.0f) - ((float) (rect.height() / 2))), paint);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), paint2);
        }

        public final void f(Paint paint, String str) {
            paint.getTextBounds(str, 0, str.length(), this.f1483a);
        }
    }

    public class f {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ConstraintWidgetContainer f1490a = new ConstraintWidgetContainer();

        /* renamed from: a  reason: collision with other field name */
        public ConstraintSet f1492a = null;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public ConstraintWidgetContainer f1493b = new ConstraintWidgetContainer();

        /* renamed from: b  reason: collision with other field name */
        public ConstraintSet f1494b = null;

        public f() {
        }

        public static void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.b;
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.b.clear();
            constraintWidgetContainer2.j(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.core.widgets.a) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.a();
                } else if (next instanceof androidx.constraintlayout.core.widgets.e) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.e();
                } else if (next instanceof androidx.constraintlayout.core.widgets.d) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.d();
                } else if (next instanceof androidx.constraintlayout.core.widgets.g) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.g();
                } else if (next instanceof Re) {
                    constraintWidget = new Te();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.b.add(constraintWidget);
                ConstraintWidget constraintWidget2 = constraintWidget.f1349a;
                if (constraintWidget2 != null) {
                    ((AD) constraintWidget2).b.remove(constraintWidget);
                    constraintWidget.G();
                }
                constraintWidget.f1349a = constraintWidgetContainer2;
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                ((ConstraintWidget) hashMap.get(next2)).j(next2, hashMap);
            }
        }

        public static ConstraintWidget d(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.f1351a == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = arrayList.get(i);
                if (constraintWidget.f1351a == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public final void a() {
            SparseArray sparseArray;
            HashMap<View, Vl> hashMap;
            Interpolator interpolator;
            MotionLayout motionLayout = MotionLayout.this;
            int childCount = motionLayout.getChildCount();
            HashMap<View, Vl> hashMap2 = motionLayout.f1451a;
            hashMap2.clear();
            SparseArray sparseArray2 = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i = 0; i < childCount; i++) {
                View childAt = motionLayout.getChildAt(i);
                Vl vl = new Vl(childAt);
                int id = childAt.getId();
                iArr[i] = id;
                sparseArray2.put(id, vl);
                hashMap2.put(childAt, vl);
            }
            int i2 = 0;
            while (i2 < childCount) {
                View childAt2 = motionLayout.getChildAt(i2);
                Vl vl2 = hashMap2.get(childAt2);
                if (vl2 == null) {
                    hashMap = hashMap2;
                    sparseArray = sparseArray2;
                } else {
                    ConstraintSet constraintSet = this.f1492a;
                    Rect rect = vl2.f605a;
                    if (constraintSet != null) {
                        ConstraintWidget d = d(this.f1490a, childAt2);
                        if (d != null) {
                            Rect a2 = MotionLayout.a(motionLayout, d);
                            ConstraintSet constraintSet2 = this.f1492a;
                            int width = motionLayout.getWidth();
                            int height = motionLayout.getHeight();
                            int i3 = constraintSet2.f1658a;
                            if (i3 != 0) {
                                Vl.g(a2, rect, i3, width, height);
                            }
                            Xl xl = vl2.f604a;
                            xl.f679a = 0.0f;
                            xl.b = 0.0f;
                            vl2.f(xl);
                            hashMap = hashMap2;
                            sparseArray = sparseArray2;
                            xl.i((float) a2.left, (float) a2.top, (float) a2.width(), (float) a2.height());
                            ConstraintSet.a h = constraintSet2.h(vl2.f601a);
                            xl.a(h);
                            ConstraintSet.c cVar = h.f1666a;
                            vl2.a = cVar.f1697a;
                            vl2.f603a.i(a2, constraintSet2, i3, vl2.f601a);
                            vl2.f629d = h.f1668a.f1708a;
                            vl2.e = cVar.e;
                            vl2.d = cVar.c;
                            Context context = vl2.f606a.getContext();
                            int i4 = cVar.f;
                            String str = cVar.f1702b;
                            int i5 = cVar.g;
                            if (i4 == -2) {
                                interpolator = AnimationUtils.loadInterpolator(context, i5);
                            } else if (i4 == -1) {
                                interpolator = new Ul(T9.c(str));
                            } else if (i4 == 0) {
                                interpolator = new AccelerateDecelerateInterpolator();
                            } else if (i4 == 1) {
                                interpolator = new AccelerateInterpolator();
                            } else if (i4 == 2) {
                                interpolator = new DecelerateInterpolator();
                            } else if (i4 == 4) {
                                interpolator = new BounceInterpolator();
                            } else if (i4 != 5) {
                                interpolator = null;
                            } else {
                                interpolator = new OvershootInterpolator();
                            }
                            vl2.f607a = interpolator;
                        } else {
                            hashMap = hashMap2;
                            sparseArray = sparseArray2;
                            if (motionLayout.f1472h != 0) {
                                C0175e8.b();
                                C0175e8.d(childAt2);
                                childAt2.getClass();
                            }
                        }
                    } else {
                        hashMap = hashMap2;
                        sparseArray = sparseArray2;
                    }
                    if (this.f1494b != null) {
                        ConstraintWidget d2 = d(this.f1493b, childAt2);
                        if (d2 != null) {
                            Rect a3 = MotionLayout.a(motionLayout, d2);
                            ConstraintSet constraintSet3 = this.f1494b;
                            int width2 = motionLayout.getWidth();
                            int height2 = motionLayout.getHeight();
                            int i6 = constraintSet3.f1658a;
                            if (i6 != 0) {
                                Vl.g(a3, rect, i6, width2, height2);
                            } else {
                                rect = a3;
                            }
                            Xl xl2 = vl2.f619b;
                            xl2.f679a = 1.0f;
                            xl2.b = 1.0f;
                            vl2.f(xl2);
                            xl2.i((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
                            xl2.a(constraintSet3.h(vl2.f601a));
                            vl2.f618b.i(rect, constraintSet3, i6, vl2.f601a);
                        } else if (motionLayout.f1472h != 0) {
                            C0175e8.b();
                            C0175e8.d(childAt2);
                            childAt2.getClass();
                        }
                    }
                }
                i2++;
                hashMap2 = hashMap;
                sparseArray2 = sparseArray;
            }
            SparseArray sparseArray3 = sparseArray2;
            int i7 = 0;
            while (i7 < childCount) {
                SparseArray sparseArray4 = sparseArray3;
                Vl vl3 = (Vl) sparseArray4.get(iArr[i7]);
                int i8 = vl3.f604a.f687e;
                if (i8 != -1) {
                    Vl vl4 = (Vl) sparseArray4.get(i8);
                    vl3.f604a.l(vl4, vl4.f604a);
                    vl3.f619b.l(vl4, vl4.f619b);
                }
                i7++;
                sparseArray3 = sparseArray4;
            }
        }

        public final void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            MotionLayout motionLayout = MotionLayout.this;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            if (motionLayout.f1462d == motionLayout.getStartState()) {
                ConstraintWidgetContainer constraintWidgetContainer = this.f1493b;
                ConstraintSet constraintSet = this.f1494b;
                if (constraintSet == null || constraintSet.f1658a == 0) {
                    i6 = i;
                } else {
                    i6 = i2;
                }
                if (constraintSet == null || constraintSet.f1658a == 0) {
                    i7 = i2;
                } else {
                    i7 = i;
                }
                motionLayout.resolveSystem(constraintWidgetContainer, optimizationLevel, i6, i7);
                ConstraintSet constraintSet2 = this.f1492a;
                if (constraintSet2 != null) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f1490a;
                    int i9 = constraintSet2.f1658a;
                    if (i9 == 0) {
                        i8 = i;
                    } else {
                        i8 = i2;
                    }
                    if (i9 == 0) {
                        i = i2;
                    }
                    motionLayout.resolveSystem(constraintWidgetContainer2, optimizationLevel, i8, i);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.f1492a;
            if (constraintSet3 != null) {
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f1490a;
                int i10 = constraintSet3.f1658a;
                if (i10 == 0) {
                    i4 = i;
                } else {
                    i4 = i2;
                }
                if (i10 == 0) {
                    i5 = i2;
                } else {
                    i5 = i;
                }
                motionLayout.resolveSystem(constraintWidgetContainer3, optimizationLevel, i4, i5);
            }
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f1493b;
            ConstraintSet constraintSet4 = this.f1494b;
            if (constraintSet4 == null || constraintSet4.f1658a == 0) {
                i3 = i;
            } else {
                i3 = i2;
            }
            if (constraintSet4 == null || constraintSet4.f1658a == 0) {
                i = i2;
            }
            motionLayout.resolveSystem(constraintWidgetContainer4, optimizationLevel, i3, i);
        }

        public final void e(ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f1492a = constraintSet;
            this.f1494b = constraintSet2;
            this.f1490a = new ConstraintWidgetContainer();
            this.f1493b = new ConstraintWidgetContainer();
            ConstraintWidgetContainer constraintWidgetContainer = this.f1490a;
            MotionLayout motionLayout = MotionLayout.this;
            D2.b bVar = motionLayout.mLayoutWidget.f1393a;
            constraintWidgetContainer.f1393a = bVar;
            constraintWidgetContainer.f1395a.f395a = bVar;
            ConstraintWidgetContainer constraintWidgetContainer2 = this.f1493b;
            D2.b bVar2 = motionLayout.mLayoutWidget.f1393a;
            constraintWidgetContainer2.f1393a = bVar2;
            constraintWidgetContainer2.f1395a.f395a = bVar2;
            this.f1490a.b.clear();
            this.f1493b.b.clear();
            c(motionLayout.mLayoutWidget, this.f1490a);
            c(motionLayout.mLayoutWidget, this.f1493b);
            if (((double) motionLayout.d) > 0.5d) {
                if (constraintSet != null) {
                    g(this.f1490a, constraintSet);
                }
                g(this.f1493b, constraintSet2);
            } else {
                g(this.f1493b, constraintSet2);
                if (constraintSet != null) {
                    g(this.f1490a, constraintSet);
                }
            }
            this.f1490a.l = motionLayout.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer3 = this.f1490a;
            constraintWidgetContainer3.f1394a.c(constraintWidgetContainer3);
            this.f1493b.l = motionLayout.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f1493b;
            constraintWidgetContainer4.f1394a.c(constraintWidgetContainer4);
            ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
            if (layoutParams != null) {
                int i = layoutParams.width;
                ConstraintWidget.a aVar = ConstraintWidget.a.WRAP_CONTENT;
                if (i == -2) {
                    this.f1490a.P(aVar);
                    this.f1493b.P(aVar);
                }
                if (layoutParams.height == -2) {
                    this.f1490a.Q(aVar);
                    this.f1493b.Q(aVar);
                }
            }
        }

        public final void f() {
            boolean z;
            int i;
            boolean z2;
            boolean z3;
            HashMap<View, Vl> hashMap;
            int i2;
            float f;
            boolean z4;
            float f2;
            float f3;
            boolean z5;
            MotionLayout motionLayout = MotionLayout.this;
            int i3 = motionLayout.f1468f;
            int i4 = motionLayout.f1470g;
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            motionLayout.q = mode;
            motionLayout.r = mode2;
            motionLayout.getOptimizationLevel();
            b(i3, i4);
            int i5 = 0;
            boolean z6 = true;
            if ((motionLayout.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                b(i3, i4);
                motionLayout.m = this.f1490a.u();
                motionLayout.n = this.f1490a.o();
                motionLayout.o = this.f1493b.u();
                int o = this.f1493b.o();
                motionLayout.p = o;
                if (motionLayout.m == motionLayout.o && motionLayout.n == o) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                motionLayout.f1471g = z5;
            }
            int i6 = motionLayout.m;
            int i7 = motionLayout.n;
            int i8 = motionLayout.q;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                i6 = (int) ((motionLayout.f1478k * ((float) (motionLayout.o - i6))) + ((float) i6));
            }
            int i9 = i6;
            int i10 = motionLayout.r;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                i = (int) ((motionLayout.f1478k * ((float) (motionLayout.p - i7))) + ((float) i7));
            } else {
                i = i7;
            }
            ConstraintWidgetContainer constraintWidgetContainer = this.f1490a;
            if (constraintWidgetContainer.m || this.f1493b.m) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (constraintWidgetContainer.n || this.f1493b.n) {
                z3 = true;
            } else {
                z3 = false;
            }
            motionLayout.resolveMeasuredDimension(i3, i4, i9, i, z2, z3);
            int childCount = motionLayout.getChildCount();
            motionLayout.f1443a.a();
            motionLayout.f1461c = true;
            SparseArray sparseArray = new SparseArray();
            int i11 = 0;
            while (true) {
                hashMap = motionLayout.f1451a;
                if (i11 >= childCount) {
                    break;
                }
                View childAt = motionLayout.getChildAt(i11);
                sparseArray.put(childAt.getId(), hashMap.get(childAt));
                i11++;
            }
            int width = motionLayout.getWidth();
            int height = motionLayout.getHeight();
            a.b bVar = motionLayout.f1447a.f1507a;
            if (bVar != null) {
                i2 = bVar.h;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    Vl vl = hashMap.get(motionLayout.getChildAt(i12));
                    if (vl != null) {
                        vl.f627c = i2;
                    }
                }
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = new int[hashMap.size()];
            int i13 = 0;
            for (int i14 = 0; i14 < childCount; i14++) {
                Vl vl2 = hashMap.get(motionLayout.getChildAt(i14));
                int i15 = vl2.f604a.f687e;
                if (i15 != -1) {
                    sparseBooleanArray.put(i15, true);
                    iArr[i13] = vl2.f604a.f687e;
                    i13++;
                }
            }
            if (motionLayout.f1460c != null) {
                for (int i16 = 0; i16 < i13; i16++) {
                    Vl vl3 = hashMap.get(motionLayout.findViewById(iArr[i16]));
                    if (vl3 != null) {
                        motionLayout.f1447a.f(vl3);
                    }
                }
                Iterator<MotionHelper> it = motionLayout.f1460c.iterator();
                while (it.hasNext()) {
                    it.next().u(motionLayout, hashMap);
                }
                for (int i17 = 0; i17 < i13; i17++) {
                    Vl vl4 = hashMap.get(motionLayout.findViewById(iArr[i17]));
                    if (vl4 != null) {
                        vl4.h(width, height, motionLayout.getNanoTime());
                    }
                }
            } else {
                for (int i18 = 0; i18 < i13; i18++) {
                    Vl vl5 = hashMap.get(motionLayout.findViewById(iArr[i18]));
                    if (vl5 != null) {
                        motionLayout.f1447a.f(vl5);
                        vl5.h(width, height, motionLayout.getNanoTime());
                    }
                }
            }
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt2 = motionLayout.getChildAt(i19);
                Vl vl6 = hashMap.get(childAt2);
                if (!sparseBooleanArray.get(childAt2.getId()) && vl6 != null) {
                    motionLayout.f1447a.f(vl6);
                    vl6.h(width, height, motionLayout.getNanoTime());
                }
            }
            a.b bVar2 = motionLayout.f1447a.f1507a;
            if (bVar2 != null) {
                f = bVar2.a;
            } else {
                f = 0.0f;
            }
            if (f != 0.0f) {
                if (((double) f) < 0.0d) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                float abs = Math.abs(f);
                float f4 = -3.4028235E38f;
                float f5 = Float.MAX_VALUE;
                float f6 = -3.4028235E38f;
                float f7 = Float.MAX_VALUE;
                int i20 = 0;
                while (true) {
                    if (i20 >= childCount) {
                        z6 = false;
                        break;
                    }
                    Vl vl7 = hashMap.get(motionLayout.getChildAt(i20));
                    if (!Float.isNaN(vl7.a)) {
                        break;
                    }
                    Xl xl = vl7.f619b;
                    float f8 = xl.c;
                    float f9 = xl.d;
                    if (z4) {
                        f3 = f9 - f8;
                    } else {
                        f3 = f9 + f8;
                    }
                    f7 = Math.min(f7, f3);
                    f6 = Math.max(f6, f3);
                    i20++;
                }
                if (z6) {
                    for (int i21 = 0; i21 < childCount; i21++) {
                        Vl vl8 = hashMap.get(motionLayout.getChildAt(i21));
                        if (!Float.isNaN(vl8.a)) {
                            f5 = Math.min(f5, vl8.a);
                            f4 = Math.max(f4, vl8.a);
                        }
                    }
                    while (i5 < childCount) {
                        Vl vl9 = hashMap.get(motionLayout.getChildAt(i5));
                        if (!Float.isNaN(vl9.a)) {
                            vl9.c = 1.0f / (1.0f - abs);
                            if (z4) {
                                vl9.b = abs - (((f4 - vl9.a) / (f4 - f5)) * abs);
                            } else {
                                vl9.b = abs - (((vl9.a - f5) * abs) / (f4 - f5));
                            }
                        }
                        i5++;
                    }
                    return;
                }
                while (i5 < childCount) {
                    Vl vl10 = hashMap.get(motionLayout.getChildAt(i5));
                    Xl xl2 = vl10.f619b;
                    float f10 = xl2.c;
                    float f11 = xl2.d;
                    if (z4) {
                        f2 = f11 - f10;
                    } else {
                        f2 = f11 + f10;
                    }
                    vl10.c = 1.0f / (1.0f - abs);
                    vl10.b = abs - (((f2 - f7) * abs) / (f6 - f7));
                    i5++;
                }
            }
        }

        public final void g(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            ConstraintSet.a aVar;
            ConstraintSet.a aVar2;
            ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
            ConstraintSet constraintSet2 = constraintSet;
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer2);
            MotionLayout motionLayout = MotionLayout.this;
            sparseArray.put(motionLayout.getId(), constraintWidgetContainer2);
            if (!(constraintSet2 == null || constraintSet2.f1658a == 0)) {
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f1493b;
                int optimizationLevel = motionLayout.getOptimizationLevel();
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(motionLayout.getHeight(), Ints.MAX_POWER_OF_TWO);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(motionLayout.getWidth(), Ints.MAX_POWER_OF_TWO);
                boolean z = MotionLayout.k;
                motionLayout.resolveSystem(constraintWidgetContainer3, optimizationLevel, makeMeasureSpec, makeMeasureSpec2);
            }
            Iterator<ConstraintWidget> it = constraintWidgetContainer2.b.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.f1391k = true;
                sparseArray.put(((View) next.f1351a).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer2.b.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.f1351a;
                int id = view.getId();
                HashMap<Integer, ConstraintSet.a> hashMap = constraintSet2.f1663b;
                if (hashMap.containsKey(Integer.valueOf(id)) && (aVar2 = hashMap.get(Integer.valueOf(id))) != null) {
                    aVar2.a(layoutParams);
                }
                next2.R(constraintSet2.h(view.getId()).f1665a.f1679a);
                next2.O(constraintSet2.h(view.getId()).f1665a.f1683b);
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) view;
                    int id2 = constraintHelper.getId();
                    HashMap<Integer, ConstraintSet.a> hashMap2 = constraintSet2.f1663b;
                    if (hashMap2.containsKey(Integer.valueOf(id2)) && (aVar = hashMap2.get(Integer.valueOf(id2))) != null && (next2 instanceof Te)) {
                        constraintHelper.o(aVar, (Te) next2, layoutParams, sparseArray);
                    }
                    if (view instanceof Barrier) {
                        ((Barrier) view).t();
                    }
                }
                layoutParams.resolveLayoutDirection(motionLayout.getLayoutDirection());
                MotionLayout motionLayout2 = MotionLayout.this;
                boolean z2 = MotionLayout.k;
                View view2 = view;
                motionLayout2.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet2.h(view2.getId()).f1667a.f1706b == 1) {
                    next2.w = view2.getVisibility();
                } else {
                    next2.w = constraintSet2.h(view2.getId()).f1667a.f1704a;
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer2.b.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof androidx.constraintlayout.core.widgets.h) {
                    Re re = (Re) next3;
                    ((ConstraintHelper) next3.f1351a).s(re, sparseArray);
                    androidx.constraintlayout.core.widgets.h hVar = (androidx.constraintlayout.core.widgets.h) re;
                    for (int i = 0; i < hVar.B; i++) {
                        ConstraintWidget constraintWidget = hVar.c[i];
                        if (constraintWidget != null) {
                            constraintWidget.f1390j = true;
                        }
                    }
                }
            }
        }
    }

    public static class g {
        public static final g a = new g();

        /* renamed from: a  reason: collision with other field name */
        public VelocityTracker f1495a;
    }

    public class h {
        public float a = Float.NaN;

        /* renamed from: a  reason: collision with other field name */
        public int f1496a = -1;
        public float b = Float.NaN;

        /* renamed from: b  reason: collision with other field name */
        public int f1498b = -1;

        public h() {
        }

        public final void a() {
            int i = this.f1496a;
            MotionLayout motionLayout = MotionLayout.this;
            if (!(i == -1 && this.f1498b == -1)) {
                if (i == -1) {
                    int i2 = this.f1498b;
                    if (!motionLayout.isAttachedToWindow()) {
                        if (motionLayout.f1444a == null) {
                            motionLayout.f1444a = new h();
                        }
                        motionLayout.f1444a.f1498b = i2;
                    } else {
                        motionLayout.t(i2, -1);
                    }
                } else {
                    int i3 = this.f1498b;
                    if (i3 == -1) {
                        motionLayout.setState(i, -1, -1);
                    } else {
                        motionLayout.setTransition(i, i3);
                    }
                }
                motionLayout.setState(j.SETUP);
            }
            if (!Float.isNaN(this.b)) {
                motionLayout.setProgress(this.a, this.b);
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.f1496a = -1;
                this.f1498b = -1;
            } else if (!Float.isNaN(this.a)) {
                motionLayout.setProgress(this.a);
            }
        }
    }

    public interface i {
        void a();

        void b();

        void c(int i);

        void d();
    }

    public enum j {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        new HashMap();
        this.f1437a = new Rect();
        this.f1475i = false;
        this.f1446a = j.UNDEFINED;
        this.f1443a = new f();
        this.f1477j = false;
        this.f1438a = new RectF();
        this.f1439a = null;
        this.f1436a = null;
        this.f1464d = new ArrayList<>();
        n((AttributeSet) null);
    }

    public static Rect a(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        motionLayout.getClass();
        int w = constraintWidget.w();
        Rect rect = motionLayout.f1437a;
        rect.top = w;
        rect.left = constraintWidget.v();
        rect.right = constraintWidget.u() + rect.left;
        rect.bottom = constraintWidget.o() + rect.top;
        return rect;
    }

    /* JADX WARNING: Removed duplicated region for block: B:183:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchDraw(android.graphics.Canvas r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r2 = r0.f1460c
            if (r2 == 0) goto L_0x001c
            java.util.Iterator r2 = r2.iterator()
        L_0x000c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x001c
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.MotionHelper r3 = (androidx.constraintlayout.motion.widget.MotionHelper) r3
            r3.getClass()
            goto L_0x000c
        L_0x001c:
            r2 = 0
            r0.h(r2)
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            r4 = 0
            if (r3 == 0) goto L_0x0056
            androidx.constraintlayout.motion.widget.d r3 = r3.f1508a
            if (r3 == 0) goto L_0x0056
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c$a> r5 = r3.b
            if (r5 != 0) goto L_0x002e
            goto L_0x0056
        L_0x002e:
            java.util.Iterator r5 = r5.iterator()
        L_0x0032:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0042
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.motion.widget.c$a r6 = (androidx.constraintlayout.motion.widget.c.a) r6
            r6.a()
            goto L_0x0032
        L_0x0042:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c$a> r5 = r3.b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c$a> r6 = r3.c
            r5.removeAll(r6)
            r6.clear()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c$a> r5 = r3.b
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0056
            r3.b = r4
        L_0x0056:
            super.dispatchDraw(r34)
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            if (r3 != 0) goto L_0x005e
            return
        L_0x005e:
            int r3 = r0.f1472h
            r4 = 1
            r3 = r3 & r4
            r5 = 1093664768(0x41300000, float:11.0)
            r6 = 1092616192(0x41200000, float:10.0)
            if (r3 != r4) goto L_0x0121
            boolean r3 = r33.isInEditMode()
            if (r3 != 0) goto L_0x0121
            int r3 = r0.f1479k
            int r3 = r3 + r4
            r0.f1479k = r3
            long r7 = r33.getNanoTime()
            long r9 = r0.f1463d
            r11 = -1
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x009e
            long r9 = r7 - r9
            r11 = 200000000(0xbebc200, double:9.8813129E-316)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a0
            int r3 = r0.f1479k
            float r3 = (float) r3
            float r9 = (float) r9
            r10 = 814313567(0x3089705f, float:1.0E-9)
            float r9 = r9 * r10
            float r3 = r3 / r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r9
            int r3 = (int) r3
            float r3 = (float) r3
            float r3 = r3 / r9
            r0.i = r3
            r0.f1479k = r2
            r0.f1463d = r7
            goto L_0x00a0
        L_0x009e:
            r0.f1463d = r7
        L_0x00a0:
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r7 = 1109917696(0x42280000, float:42.0)
            r3.setTextSize(r7)
            float r7 = r33.getProgress()
            r8 = 1148846080(0x447a0000, float:1000.0)
            float r7 = r7 * r8
            int r7 = (int) r7
            float r7 = (float) r7
            float r7 = r7 / r6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            float r9 = r0.i
            r8.append(r9)
            java.lang.String r9 = " fps "
            r8.append(r9)
            int r9 = r0.f1458c
            java.lang.String r9 = defpackage.C0175e8.e(r9, r0)
            r8.append(r9)
            java.lang.String r9 = " -> "
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.StringBuilder r8 = defpackage.xx.J(r8)
            int r9 = r0.f1466e
            java.lang.String r9 = defpackage.C0175e8.e(r9, r0)
            r8.append(r9)
            java.lang.String r9 = " (progress: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = " ) state="
            r8.append(r7)
            int r7 = r0.f1462d
            r9 = -1
            if (r7 != r9) goto L_0x00f7
            java.lang.String r7 = "undefined"
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r7 = defpackage.C0175e8.e(r7, r0)
        L_0x00fb:
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r8 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setColor(r8)
            int r8 = r33.getHeight()
            int r8 = r8 + -29
            float r8 = (float) r8
            r1.drawText(r7, r5, r8, r3)
            r8 = -7864184(0xffffffffff880088, float:NaN)
            r3.setColor(r8)
            int r8 = r33.getHeight()
            int r8 = r8 + -30
            float r8 = (float) r8
            r1.drawText(r7, r6, r8, r3)
        L_0x0121:
            int r3 = r0.f1472h
            if (r3 <= r4) goto L_0x0513
            androidx.constraintlayout.motion.widget.MotionLayout$e r3 = r0.f1442a
            if (r3 != 0) goto L_0x0130
            androidx.constraintlayout.motion.widget.MotionLayout$e r3 = new androidx.constraintlayout.motion.widget.MotionLayout$e
            r3.<init>()
            r0.f1442a = r3
        L_0x0130:
            androidx.constraintlayout.motion.widget.MotionLayout$e r3 = r0.f1442a
            java.util.HashMap<android.view.View, Vl> r7 = r0.f1451a
            androidx.constraintlayout.motion.widget.a r8 = r0.f1447a
            int r8 = r8.c()
            int r9 = r0.f1472h
            r3.getClass()
            if (r7 == 0) goto L_0x0513
            int r10 = r7.size()
            if (r10 != 0) goto L_0x0149
            goto L_0x0515
        L_0x0149:
            r34.save()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
            boolean r11 = r10.isInEditMode()
            android.graphics.Paint r12 = r3.f1481a
            r13 = 2
            if (r11 != 0) goto L_0x0197
            r11 = r9 & 1
            if (r11 != r13) goto L_0x0197
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            android.content.Context r13 = r10.getContext()
            android.content.res.Resources r13 = r13.getResources()
            int r14 = r10.f1466e
            java.lang.String r13 = r13.getResourceName(r14)
            r11.append(r13)
            java.lang.String r13 = ":"
            r11.append(r13)
            float r13 = r10.getProgress()
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            int r13 = r10.getHeight()
            int r13 = r13 + -30
            float r13 = (float) r13
            android.graphics.Paint r14 = r3.d
            r1.drawText(r11, r6, r13, r14)
            int r6 = r10.getHeight()
            int r6 = r6 + -29
            float r6 = (float) r6
            r1.drawText(r11, r5, r6, r12)
        L_0x0197:
            java.util.Collection r5 = r7.values()
            java.util.Iterator r5 = r5.iterator()
            r7 = r1
            r6 = r3
        L_0x01a1:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x050f
            java.lang.Object r10 = r5.next()
            Vl r10 = (defpackage.Vl) r10
            Xl r11 = r10.f604a
            int r11 = r11.f685c
            java.util.ArrayList<Xl> r13 = r10.f608a
            java.util.Iterator r14 = r13.iterator()
        L_0x01b7:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x01ca
            java.lang.Object r15 = r14.next()
            Xl r15 = (defpackage.Xl) r15
            int r15 = r15.f685c
            int r11 = java.lang.Math.max(r11, r15)
            goto L_0x01b7
        L_0x01ca:
            Xl r14 = r10.f619b
            int r14 = r14.f685c
            int r11 = java.lang.Math.max(r11, r14)
            if (r9 <= 0) goto L_0x01d7
            if (r11 != 0) goto L_0x01d7
            r11 = r4
        L_0x01d7:
            if (r11 != 0) goto L_0x01da
            goto L_0x01a1
        L_0x01da:
            float[] r4 = r6.f1488b
            if (r4 == 0) goto L_0x024d
            H7[] r14 = r10.f615a
            r14 = r14[r2]
            double[] r15 = r14.g()
            int[] r14 = r6.f1486a
            if (r14 == 0) goto L_0x0209
            java.util.Iterator r16 = r13.iterator()
        L_0x01ee:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x0209
            java.lang.Object r17 = r16.next()
            r21 = r5
            r5 = r17
            Xl r5 = (defpackage.Xl) r5
            int r17 = r2 + 1
            int r5 = r5.f688f
            r14[r2] = r5
            r2 = r17
            r5 = r21
            goto L_0x01ee
        L_0x0209:
            r21 = r5
            r2 = 0
            r5 = 0
        L_0x020d:
            int r14 = r15.length
            if (r2 >= r14) goto L_0x0246
            H7[] r14 = r10.f615a
            r16 = 0
            r14 = r14[r16]
            r0 = r15[r2]
            r22 = r9
            double[] r9 = r10.f611a
            r14.c(r0, r9)
            Xl r14 = r10.f604a
            r0 = r15[r2]
            int[] r9 = r10.f613a
            r23 = r3
            double[] r3 = r10.f611a
            r24 = r15
            r15 = r0
            r17 = r9
            r18 = r3
            r19 = r4
            r20 = r5
            r14.h(r15, r17, r18, r19, r20)
            int r5 = r5 + 2
            int r2 = r2 + 1
            r0 = r33
            r1 = r34
            r9 = r22
            r3 = r23
            r15 = r24
            goto L_0x020d
        L_0x0246:
            r23 = r3
            r22 = r9
            int r5 = r5 / 2
            goto L_0x0254
        L_0x024d:
            r23 = r3
            r21 = r5
            r22 = r9
            r5 = 0
        L_0x0254:
            r6.a = r5
            r0 = 1
            if (r11 < r0) goto L_0x04f9
            int r0 = r8 / 16
            float[] r1 = r6.f1485a
            if (r1 == 0) goto L_0x0264
            int r1 = r1.length
            int r2 = r0 * 2
            if (r1 == r2) goto L_0x0271
        L_0x0264:
            int r1 = r0 * 2
            float[] r1 = new float[r1]
            r6.f1485a = r1
            android.graphics.Path r1 = new android.graphics.Path
            r1.<init>()
            r6.f1482a = r1
        L_0x0271:
            int r1 = r6.b
            float r2 = (float) r1
            r7.translate(r2, r2)
            r2 = 1996488704(0x77000000, float:2.5961484E33)
            r12.setColor(r2)
            android.graphics.Paint r3 = r6.e
            r3.setColor(r2)
            android.graphics.Paint r4 = r6.f1487b
            r4.setColor(r2)
            android.graphics.Paint r5 = r6.c
            r5.setColor(r2)
            float[] r2 = r6.f1485a
            int r6 = r0 + -1
            float r6 = (float) r6
            r7 = 1065353216(0x3f800000, float:1.0)
            float r7 = r7 / r6
            java.util.HashMap<java.lang.String, MC> r6 = r10.f622b
            java.lang.String r9 = "translationX"
            if (r6 != 0) goto L_0x029b
            r6 = 0
            goto L_0x02a1
        L_0x029b:
            java.lang.Object r6 = r6.get(r9)
            Ex r6 = (defpackage.Ex) r6
        L_0x02a1:
            java.util.HashMap<java.lang.String, MC> r14 = r10.f622b
            java.lang.String r15 = "translationY"
            if (r14 != 0) goto L_0x02a9
            r14 = 0
            goto L_0x02af
        L_0x02a9:
            java.lang.Object r14 = r14.get(r15)
            Ex r14 = (defpackage.Ex) r14
        L_0x02af:
            r24 = r8
            java.util.HashMap<java.lang.String, BC> r8 = r10.f628c
            if (r8 != 0) goto L_0x02b7
            r8 = 0
            goto L_0x02bd
        L_0x02b7:
            java.lang.Object r8 = r8.get(r9)
            BC r8 = (defpackage.BC) r8
        L_0x02bd:
            java.util.HashMap<java.lang.String, BC> r9 = r10.f628c
            if (r9 != 0) goto L_0x02c3
            r9 = 0
            goto L_0x02c9
        L_0x02c3:
            java.lang.Object r9 = r9.get(r15)
            BC r9 = (defpackage.BC) r9
        L_0x02c9:
            r15 = 0
        L_0x02ca:
            r16 = 2143289344(0x7fc00000, float:NaN)
            r17 = r14
            Xl r14 = r10.f604a
            if (r15 >= r0) goto L_0x03ce
            r25 = r0
            float r0 = (float) r15
            float r0 = r0 * r7
            r26 = r7
            float r7 = r10.c
            r18 = 1065353216(0x3f800000, float:1.0)
            int r18 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x0301
            r27 = r1
            float r1 = r10.b
            int r18 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r18 >= 0) goto L_0x02e9
            r0 = 0
        L_0x02e9:
            int r18 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r28 = r3
            r29 = r4
            if (r18 <= 0) goto L_0x0307
            double r3 = (double) r0
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x0307
            float r0 = r0 - r1
            float r0 = r0 * r7
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r0, r1)
            goto L_0x0307
        L_0x0301:
            r27 = r1
            r28 = r3
            r29 = r4
        L_0x0307:
            double r3 = (double) r0
            T9 r1 = r14.f680a
            java.util.Iterator r7 = r13.iterator()
            r14 = 0
        L_0x030f:
            boolean r18 = r7.hasNext()
            if (r18 == 0) goto L_0x033c
            java.lang.Object r18 = r7.next()
            r19 = r3
            r3 = r18
            Xl r3 = (defpackage.Xl) r3
            T9 r4 = r3.f680a
            if (r4 == 0) goto L_0x0339
            r18 = r4
            float r4 = r3.f679a
            int r30 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r30 >= 0) goto L_0x032f
            r14 = r4
            r1 = r18
            goto L_0x0339
        L_0x032f:
            boolean r4 = java.lang.Float.isNaN(r16)
            if (r4 == 0) goto L_0x0339
            float r3 = r3.f679a
            r16 = r3
        L_0x0339:
            r3 = r19
            goto L_0x030f
        L_0x033c:
            r19 = r3
            if (r1 == 0) goto L_0x0359
            boolean r3 = java.lang.Float.isNaN(r16)
            if (r3 == 0) goto L_0x0348
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x0348:
            float r3 = r0 - r14
            float r16 = r16 - r14
            float r3 = r3 / r16
            double r3 = (double) r3
            double r3 = r1.a(r3)
            float r1 = (float) r3
            float r1 = r1 * r16
            float r1 = r1 + r14
            double r3 = (double) r1
            goto L_0x035b
        L_0x0359:
            r3 = r19
        L_0x035b:
            H7[] r1 = r10.f615a
            r7 = 0
            r1 = r1[r7]
            double[] r7 = r10.f611a
            r1.c(r3, r7)
            D1 r1 = r10.f602a
            if (r1 == 0) goto L_0x0371
            double[] r7 = r10.f611a
            int r14 = r7.length
            if (r14 <= 0) goto L_0x0371
            r1.c(r3, r7)
        L_0x0371:
            Xl r14 = r10.f604a
            int[] r1 = r10.f613a
            double[] r7 = r10.f611a
            int r30 = r15 * 2
            r31 = r13
            r13 = r17
            r32 = r15
            r15 = r3
            r17 = r1
            r18 = r7
            r19 = r2
            r20 = r30
            r14.h(r15, r17, r18, r19, r20)
            if (r8 == 0) goto L_0x0397
            r1 = r2[r30]
            float r3 = r8.a(r0)
            float r3 = r3 + r1
            r2[r30] = r3
            goto L_0x03a2
        L_0x0397:
            if (r6 == 0) goto L_0x03a2
            r1 = r2[r30]
            float r3 = r6.a(r0)
            float r3 = r3 + r1
            r2[r30] = r3
        L_0x03a2:
            if (r9 == 0) goto L_0x03b0
            int r30 = r30 + 1
            r1 = r2[r30]
            float r0 = r9.a(r0)
            float r0 = r0 + r1
            r2[r30] = r0
            goto L_0x03bd
        L_0x03b0:
            if (r13 == 0) goto L_0x03bd
            int r30 = r30 + 1
            r1 = r2[r30]
            float r0 = r13.a(r0)
            float r0 = r0 + r1
            r2[r30] = r0
        L_0x03bd:
            int r15 = r32 + 1
            r14 = r13
            r0 = r25
            r7 = r26
            r1 = r27
            r3 = r28
            r4 = r29
            r13 = r31
            goto L_0x02ca
        L_0x03ce:
            r27 = r1
            r28 = r3
            r29 = r4
            r1 = r23
            int r0 = r1.a
            r2 = r34
            r1.a(r2, r11, r0, r10)
            r0 = -21965(0xffffffffffffaa33, float:NaN)
            r12.setColor(r0)
            r0 = -2067046(0xffffffffffe0759a, float:NaN)
            r3 = r29
            r3.setColor(r0)
            r3 = r28
            r3.setColor(r0)
            r0 = -13391360(0xffffffffff33aa00, float:-2.388145E38)
            r5.setColor(r0)
            r0 = r27
            int r0 = -r0
            float r0 = (float) r0
            r2.translate(r0, r0)
            int r0 = r1.a
            r1.a(r2, r11, r0, r10)
            r0 = 5
            if (r11 != r0) goto L_0x04f3
            android.graphics.Path r0 = r1.f1482a
            r0.reset()
            r0 = 0
        L_0x040a:
            r3 = 50
            if (r0 > r3) goto L_0x04d2
            float r4 = (float) r0
            float r3 = (float) r3
            float r4 = r4 / r3
            r3 = 0
            float r3 = r10.b(r4, r3)
            H7[] r4 = r10.f615a
            r5 = 0
            r4 = r4[r5]
            double r5 = (double) r3
            double[] r3 = r10.f611a
            r4.c(r5, r3)
            int[] r3 = r10.f613a
            double[] r4 = r10.f611a
            float r5 = r14.c
            float r6 = r14.d
            float r7 = r14.e
            float r8 = r14.f
            r9 = 0
        L_0x042e:
            int r11 = r3.length
            if (r9 >= r11) goto L_0x044f
            r13 = r10
            r10 = r4[r9]
            float r10 = (float) r10
            r11 = r3[r9]
            r15 = 1
            if (r11 == r15) goto L_0x044a
            r15 = 2
            if (r11 == r15) goto L_0x0448
            r15 = 3
            if (r11 == r15) goto L_0x0446
            r15 = 4
            if (r11 == r15) goto L_0x0444
            goto L_0x044b
        L_0x0444:
            r8 = r10
            goto L_0x044b
        L_0x0446:
            r7 = r10
            goto L_0x044b
        L_0x0448:
            r6 = r10
            goto L_0x044b
        L_0x044a:
            r5 = r10
        L_0x044b:
            int r9 = r9 + 1
            r10 = r13
            goto L_0x042e
        L_0x044f:
            r13 = r10
            Vl r3 = r14.f681a
            if (r3 == 0) goto L_0x047a
            r3 = 0
            double r3 = (double) r3
            double r9 = (double) r5
            double r5 = (double) r6
            double r17 = java.lang.Math.sin(r5)
            double r17 = r17 * r9
            double r17 = r17 + r3
            r11 = 1073741824(0x40000000, float:2.0)
            float r11 = r7 / r11
            r19 = r13
            r15 = r14
            double r13 = (double) r11
            double r13 = r17 - r13
            float r11 = (float) r13
            double r5 = java.lang.Math.cos(r5)
            double r5 = r5 * r9
            double r3 = r3 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r5 = r8 / r5
            double r5 = (double) r5
            double r3 = r3 - r5
            float r6 = (float) r3
            r5 = r11
            goto L_0x047d
        L_0x047a:
            r19 = r13
            r15 = r14
        L_0x047d:
            float r7 = r7 + r5
            float r8 = r8 + r6
            java.lang.Float.isNaN(r16)
            java.lang.Float.isNaN(r16)
            r3 = 0
            float r5 = r5 + r3
            float r6 = r6 + r3
            float r7 = r7 + r3
            float r8 = r8 + r3
            float[] r3 = r1.f1489c
            r4 = 0
            r3[r4] = r5
            r4 = 1
            r3[r4] = r6
            r4 = 2
            r3[r4] = r7
            r9 = 3
            r3[r9] = r6
            r10 = 4
            r3[r10] = r7
            r7 = 5
            r3[r7] = r8
            r7 = 6
            r3[r7] = r5
            r10 = 7
            r3[r10] = r8
            android.graphics.Path r8 = r1.f1482a
            r8.moveTo(r5, r6)
            android.graphics.Path r5 = r1.f1482a
            r4 = r3[r4]
            r6 = r3[r9]
            r5.lineTo(r4, r6)
            android.graphics.Path r4 = r1.f1482a
            r5 = 4
            r5 = r3[r5]
            r6 = 5
            r6 = r3[r6]
            r4.lineTo(r5, r6)
            android.graphics.Path r4 = r1.f1482a
            r5 = r3[r7]
            r3 = r3[r10]
            r4.lineTo(r5, r3)
            android.graphics.Path r3 = r1.f1482a
            r3.close()
            int r0 = r0 + 1
            r14 = r15
            r10 = r19
            goto L_0x040a
        L_0x04d2:
            r0 = 0
            r3 = 1
            r4 = 1140850688(0x44000000, float:512.0)
            r12.setColor(r4)
            r4 = 1073741824(0x40000000, float:2.0)
            r2.translate(r4, r4)
            android.graphics.Path r4 = r1.f1482a
            r2.drawPath(r4, r12)
            r4 = -1073741824(0xffffffffc0000000, float:-2.0)
            r2.translate(r4, r4)
            r4 = -65536(0xffffffffffff0000, float:NaN)
            r12.setColor(r4)
            android.graphics.Path r4 = r1.f1482a
            r2.drawPath(r4, r12)
            goto L_0x04f5
        L_0x04f3:
            r0 = 0
            r3 = 1
        L_0x04f5:
            r6 = r1
            r7 = r2
            r4 = r3
            goto L_0x0502
        L_0x04f9:
            r2 = r34
            r24 = r8
            r1 = r23
            r3 = 0
            r4 = r0
            r0 = r3
        L_0x0502:
            r3 = r1
            r1 = r2
            r5 = r21
            r9 = r22
            r8 = r24
            r2 = r0
            r0 = r33
            goto L_0x01a1
        L_0x050f:
            r2 = r1
            r34.restore()
        L_0x0513:
            r0 = r33
        L_0x0515:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r0.f1460c
            if (r1 == 0) goto L_0x052d
            java.util.Iterator r1 = r1.iterator()
        L_0x051d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x052d
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.motion.widget.MotionHelper r2 = (androidx.constraintlayout.motion.widget.MotionHelper) r2
            r2.getClass()
            goto L_0x051d
        L_0x052d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    public final void f(float f2) {
        a aVar = this.f1447a;
        if (aVar != null) {
            float f3 = this.d;
            float f4 = this.c;
            if (f3 != f4 && this.f1457b) {
                this.d = f4;
            }
            float f5 = this.d;
            if (f5 != f2) {
                this.f1465d = false;
                this.e = f2;
                this.b = ((float) aVar.c()) / 1000.0f;
                setProgress(this.e);
                this.f1435a = null;
                this.f1440a = this.f1447a.e();
                this.f1457b = false;
                this.f1433a = getNanoTime();
                this.f1461c = true;
                this.c = f5;
                this.d = f5;
                invalidate();
            }
        }
    }

    public final void g(boolean z) {
        float f2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Vl vl = this.f1451a.get(getChildAt(i2));
            if (vl != null && "button".equals(C0175e8.d(vl.f606a)) && vl.f614a != null) {
                int i3 = 0;
                while (true) {
                    Ah[] ahArr = vl.f614a;
                    if (i3 >= ahArr.length) {
                        break;
                    }
                    Ah ah = ahArr[i3];
                    if (z) {
                        f2 = -100.0f;
                    } else {
                        f2 = 100.0f;
                    }
                    ah.h(f2, vl.f606a);
                    i3++;
                }
            }
        }
    }

    public int[] getConstraintSetIds() {
        a aVar = this.f1447a;
        if (aVar == null) {
            return null;
        }
        SparseArray<ConstraintSet> sparseArray = aVar.f1502a;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = sparseArray.keyAt(i2);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.f1462d;
    }

    public ArrayList<a.b> getDefinedTransitions() {
        a aVar = this.f1447a;
        if (aVar == null) {
            return null;
        }
        return aVar.f1509a;
    }

    public P8 getDesignTool() {
        if (this.f1434a == null) {
            this.f1434a = new P8();
        }
        return this.f1434a;
    }

    public int getEndState() {
        return this.f1466e;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.d;
    }

    public a getScene() {
        return this.f1447a;
    }

    public int getStartState() {
        return this.f1458c;
    }

    public float getTargetPosition() {
        return this.e;
    }

    public Bundle getTransitionState() {
        if (this.f1444a == null) {
            this.f1444a = new h();
        }
        h hVar = this.f1444a;
        MotionLayout motionLayout = MotionLayout.this;
        hVar.f1498b = motionLayout.f1466e;
        hVar.f1496a = motionLayout.f1458c;
        hVar.b = motionLayout.getVelocity();
        hVar.a = motionLayout.getProgress();
        h hVar2 = this.f1444a;
        hVar2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", hVar2.a);
        bundle.putFloat("motion.velocity", hVar2.b);
        bundle.putInt("motion.StartState", hVar2.f1496a);
        bundle.putInt("motion.EndState", hVar2.f1498b);
        return bundle;
    }

    public long getTransitionTimeMs() {
        a aVar = this.f1447a;
        if (aVar != null) {
            this.b = ((float) aVar.c()) / 1000.0f;
        }
        return (long) (this.b * 1000.0f);
    }

    public float getVelocity() {
        return this.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0116 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            long r1 = r0.f1455b
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r22.getNanoTime()
            r0.f1455b = r1
        L_0x0010:
            float r1 = r0.d
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.f1462d = r4
        L_0x0020:
            boolean r3 = r0.f1469f
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.f1461c
            if (r3 == 0) goto L_0x0237
            if (r23 != 0) goto L_0x0032
            float r3 = r0.e
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0237
        L_0x0032:
            float r3 = r0.e
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r22.getNanoTime()
            Wl r3 = r0.f1435a
            boolean r10 = r3 instanceof defpackage.Wl
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.f1455b
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.b
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.d
            float r12 = r12 + r10
            boolean r13 = r0.f1457b
            if (r13 == 0) goto L_0x005b
            float r12 = r0.e
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.e
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.e
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.e
            r0.f1461c = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.d = r12
            r0.c = r12
            r0.f1455b = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x00ff
            if (r14 != 0) goto L_0x00ff
            boolean r14 = r0.f1465d
            if (r14 == 0) goto L_0x00e2
            long r4 = r0.f1433a
            long r4 = r8 - r4
            float r4 = (float) r4
            float r4 = r4 * r11
            float r3 = r3.getInterpolation(r4)
            Wl r4 = r0.f1435a
            r5 = 2
            cy r10 = r0.f1448a
            if (r4 != r10) goto L_0x00a4
            ay r4 = r10.f2861a
            boolean r4 = r4.a()
            if (r4 == 0) goto L_0x00a2
            r4 = r5
            goto L_0x00a5
        L_0x00a2:
            r4 = r6
            goto L_0x00a5
        L_0x00a4:
            r4 = r7
        L_0x00a5:
            r0.d = r3
            r0.f1455b = r8
            Wl r8 = r0.f1435a
            boolean r9 = r8 instanceof defpackage.Wl
            if (r9 == 0) goto L_0x0103
            float r8 = r8.a()
            r0.a = r8
            float r9 = java.lang.Math.abs(r8)
            float r10 = r0.b
            float r9 = r9 * r10
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 > 0) goto L_0x00c4
            if (r4 != r5) goto L_0x00c4
            r0.f1461c = r7
        L_0x00c4:
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d4
            r5 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.d = r5
            r0.f1461c = r7
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x00d4:
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0103
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x0103
            r0.d = r2
            r0.f1461c = r7
            r3 = r2
            goto L_0x0103
        L_0x00e2:
            float r3 = r3.getInterpolation(r12)
            Wl r4 = r0.f1435a
            boolean r5 = r4 instanceof defpackage.Wl
            if (r5 == 0) goto L_0x00f3
            float r4 = r4.a()
            r0.a = r4
            goto L_0x00fd
        L_0x00f3:
            float r12 = r12 + r10
            float r4 = r4.getInterpolation(r12)
            float r4 = r4 - r3
            float r4 = r4 * r1
            float r4 = r4 / r10
            r0.a = r4
        L_0x00fd:
            r12 = r3
            goto L_0x0101
        L_0x00ff:
            r0.a = r10
        L_0x0101:
            r4 = r7
            r3 = r12
        L_0x0103:
            float r5 = r0.a
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x0112
            androidx.constraintlayout.motion.widget.MotionLayout$j r5 = androidx.constraintlayout.motion.widget.MotionLayout.j.MOVING
            r0.setState(r5)
        L_0x0112:
            androidx.constraintlayout.motion.widget.MotionLayout$j r5 = androidx.constraintlayout.motion.widget.MotionLayout.j.FINISHED
            if (r4 == r6) goto L_0x013b
            if (r13 <= 0) goto L_0x011e
            float r4 = r0.e
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0128
        L_0x011e:
            int r4 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x012c
            float r4 = r0.e
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x012c
        L_0x0128:
            float r3 = r0.e
            r0.f1461c = r7
        L_0x012c:
            r4 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0136
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x013b
        L_0x0136:
            r0.f1461c = r7
            r0.setState(r5)
        L_0x013b:
            int r4 = r22.getChildCount()
            r0.f1469f = r7
            long r8 = r22.getNanoTime()
            r0.f1478k = r3
            android.view.animation.Interpolator r10 = r0.f1440a
            if (r10 != 0) goto L_0x014d
            r10 = r3
            goto L_0x0151
        L_0x014d:
            float r10 = r10.getInterpolation(r3)
        L_0x0151:
            android.view.animation.Interpolator r11 = r0.f1440a
            if (r11 == 0) goto L_0x0169
            float r12 = r0.b
            float r12 = r1 / r12
            float r12 = r12 + r3
            float r11 = r11.getInterpolation(r12)
            r0.a = r11
            android.view.animation.Interpolator r12 = r0.f1440a
            float r12 = r12.getInterpolation(r3)
            float r11 = r11 - r12
            r0.a = r11
        L_0x0169:
            r11 = r7
        L_0x016a:
            if (r11 >= r4) goto L_0x0193
            android.view.View r12 = r0.getChildAt(r11)
            java.util.HashMap<android.view.View, Vl> r15 = r0.f1451a
            java.lang.Object r15 = r15.get(r12)
            r16 = r15
            Vl r16 = (defpackage.Vl) r16
            if (r16 == 0) goto L_0x018f
            boolean r15 = r0.f1469f
            nh r7 = r0.f1453a
            r17 = r10
            r18 = r8
            r20 = r12
            r21 = r7
            boolean r7 = r16.e(r17, r18, r20, r21)
            r7 = r7 | r15
            r0.f1469f = r7
        L_0x018f:
            int r11 = r11 + 1
            r7 = 0
            goto L_0x016a
        L_0x0193:
            if (r13 <= 0) goto L_0x019b
            float r4 = r0.e
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x01a5
        L_0x019b:
            int r4 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x01a7
            float r4 = r0.e
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x01a7
        L_0x01a5:
            r4 = r6
            goto L_0x01a8
        L_0x01a7:
            r4 = 0
        L_0x01a8:
            boolean r7 = r0.f1469f
            if (r7 != 0) goto L_0x01b5
            boolean r7 = r0.f1461c
            if (r7 != 0) goto L_0x01b5
            if (r4 == 0) goto L_0x01b5
            r0.setState(r5)
        L_0x01b5:
            boolean r7 = r0.f1471g
            if (r7 == 0) goto L_0x01bc
            r22.requestLayout()
        L_0x01bc:
            boolean r7 = r0.f1469f
            r4 = r4 ^ r6
            r4 = r4 | r7
            r0.f1469f = r4
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x01df
            int r4 = r0.f1458c
            r7 = -1
            if (r4 == r7) goto L_0x01df
            int r7 = r0.f1462d
            if (r7 == r4) goto L_0x01df
            r0.f1462d = r4
            androidx.constraintlayout.motion.widget.a r7 = r0.f1447a
            androidx.constraintlayout.widget.ConstraintSet r4 = r7.b(r4)
            r4.a(r0)
            r0.setState(r5)
            r7 = r6
            goto L_0x01e0
        L_0x01df:
            r7 = 0
        L_0x01e0:
            double r8 = (double) r3
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x01fc
            int r4 = r0.f1462d
            int r8 = r0.f1466e
            if (r4 == r8) goto L_0x01fc
            r0.f1462d = r8
            androidx.constraintlayout.motion.widget.a r4 = r0.f1447a
            androidx.constraintlayout.widget.ConstraintSet r4 = r4.b(r8)
            r4.a(r0)
            r0.setState(r5)
            r7 = r6
        L_0x01fc:
            boolean r4 = r0.f1469f
            if (r4 != 0) goto L_0x0219
            boolean r4 = r0.f1461c
            if (r4 == 0) goto L_0x0205
            goto L_0x0219
        L_0x0205:
            if (r13 <= 0) goto L_0x020d
            r4 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0215
        L_0x020d:
            int r4 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x021c
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x021c
        L_0x0215:
            r0.setState(r5)
            goto L_0x021c
        L_0x0219:
            r22.invalidate()
        L_0x021c:
            boolean r4 = r0.f1469f
            if (r4 != 0) goto L_0x0237
            boolean r4 = r0.f1461c
            if (r4 != 0) goto L_0x0237
            if (r13 <= 0) goto L_0x022c
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0234
        L_0x022c:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0237
            int r1 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0237
        L_0x0234:
            r22.o()
        L_0x0237:
            float r1 = r0.d
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x024b
            int r1 = r0.f1462d
            int r2 = r0.f1466e
            if (r1 == r2) goto L_0x0246
            goto L_0x0247
        L_0x0246:
            r6 = r7
        L_0x0247:
            r0.f1462d = r2
        L_0x0249:
            r7 = r6
            goto L_0x025a
        L_0x024b:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x025a
            int r1 = r0.f1462d
            int r2 = r0.f1458c
            if (r1 == r2) goto L_0x0256
            goto L_0x0257
        L_0x0256:
            r6 = r7
        L_0x0257:
            r0.f1462d = r2
            goto L_0x0249
        L_0x025a:
            boolean r1 = r0.f1477j
            r1 = r1 | r7
            r0.f1477j = r1
            if (r7 == 0) goto L_0x0268
            boolean r1 = r0.f1473h
            if (r1 != 0) goto L_0x0268
            r22.requestLayout()
        L_0x0268:
            float r1 = r0.d
            r0.c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.h(boolean):void");
    }

    public final void i() {
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if ((this.f1445a != null || ((copyOnWriteArrayList = this.f1452a) != null && !copyOnWriteArrayList.isEmpty())) && this.j != this.c) {
            if (this.l != -1) {
                i iVar = this.f1445a;
                if (iVar != null) {
                    iVar.a();
                }
                CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.f1452a;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<i> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                }
            }
            this.l = -1;
            this.j = this.c;
            i iVar2 = this.f1445a;
            if (iVar2 != null) {
                iVar2.b();
            }
            CopyOnWriteArrayList<i> copyOnWriteArrayList3 = this.f1452a;
            if (copyOnWriteArrayList3 != null) {
                Iterator<i> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().b();
                }
            }
        }
    }

    public final boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public final void j() {
        int i2;
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if ((this.f1445a != null || ((copyOnWriteArrayList = this.f1452a) != null && !copyOnWriteArrayList.isEmpty())) && this.l == -1) {
            this.l = this.f1462d;
            ArrayList<Integer> arrayList = this.f1464d;
            if (!arrayList.isEmpty()) {
                i2 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.f1462d;
            if (!(i2 == i3 || i3 == -1)) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        p();
        Runnable runnable = this.f1449a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void k(int i2, float f2, float f3, float f4, float[] fArr) {
        View viewById = getViewById(i2);
        Vl vl = this.f1451a.get(viewById);
        if (vl != null) {
            vl.d(f2, f3, f4, fArr);
            viewById.getY();
        } else if (viewById != null) {
            viewById.getContext().getResources().getResourceName(i2);
        }
    }

    public final a.b l(int i2) {
        Iterator<a.b> it = this.f1447a.f1509a.iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next.f1516a == i2) {
                return next;
            }
        }
        return null;
    }

    public final void loadLayoutDescription(int i2) {
        a.b bVar;
        if (i2 != 0) {
            try {
                a aVar = new a(getContext(), this, i2);
                this.f1447a = aVar;
                int i3 = -1;
                if (this.f1462d == -1) {
                    this.f1462d = aVar.h();
                    this.f1458c = this.f1447a.h();
                    a.b bVar2 = this.f1447a.f1507a;
                    if (bVar2 != null) {
                        i3 = bVar2.b;
                    }
                    this.f1466e = i3;
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    if (display != null) {
                        display.getRotation();
                    }
                    a aVar2 = this.f1447a;
                    if (aVar2 != null) {
                        ConstraintSet b2 = aVar2.b(this.f1462d);
                        this.f1447a.n(this);
                        ArrayList<MotionHelper> arrayList = this.f1460c;
                        if (arrayList != null) {
                            Iterator<MotionHelper> it = arrayList.iterator();
                            while (it.hasNext()) {
                                it.next().getClass();
                            }
                        }
                        if (b2 != null) {
                            b2.b(this);
                        }
                        this.f1458c = this.f1462d;
                    }
                    o();
                    h hVar = this.f1444a;
                    if (hVar == null) {
                        a aVar3 = this.f1447a;
                        if (aVar3 != null && (bVar = aVar3.f1507a) != null && bVar.g == 4) {
                            s();
                            setState(j.SETUP);
                            setState(j.MOVING);
                        }
                    } else if (this.f1475i) {
                        post(new a());
                    } else {
                        hVar.a();
                    }
                } else {
                    this.f1447a = null;
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        } else {
            this.f1447a = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(float r8, float r9, android.view.MotionEvent r10, android.view.View r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r11
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r11.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r11.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.m(r4, r5, r10, r3)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x00a9
            int r2 = r11.getRight()
            float r2 = (float) r2
            float r2 = r2 + r8
            int r3 = r11.getLeft()
            float r3 = (float) r3
            float r2 = r2 - r3
            int r3 = r11.getBottom()
            float r3 = (float) r3
            float r3 = r3 + r9
            int r4 = r11.getTop()
            float r4 = (float) r4
            float r3 = r3 - r4
            android.graphics.RectF r4 = r7.f1438a
            r4.set(r8, r9, r2, r3)
            int r2 = r10.getAction()
            if (r2 != 0) goto L_0x006a
            float r2 = r10.getX()
            float r3 = r10.getY()
            boolean r2 = r4.contains(r2, r3)
            if (r2 == 0) goto L_0x00a9
        L_0x006a:
            float r8 = -r8
            float r9 = -r9
            android.graphics.Matrix r2 = r11.getMatrix()
            boolean r3 = r2.isIdentity()
            if (r3 == 0) goto L_0x0083
            r10.offsetLocation(r8, r9)
            boolean r11 = r11.onTouchEvent(r10)
            float r8 = -r8
            float r9 = -r9
            r10.offsetLocation(r8, r9)
            goto L_0x00a6
        L_0x0083:
            android.view.MotionEvent r10 = android.view.MotionEvent.obtain(r10)
            r10.offsetLocation(r8, r9)
            android.graphics.Matrix r8 = r7.f1436a
            if (r8 != 0) goto L_0x0095
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            r7.f1436a = r8
        L_0x0095:
            android.graphics.Matrix r8 = r7.f1436a
            r2.invert(r8)
            android.graphics.Matrix r8 = r7.f1436a
            r10.transform(r8)
            boolean r11 = r11.onTouchEvent(r10)
            r10.recycle()
        L_0x00a6:
            if (r11 == 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r1 = r0
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.m(float, float, android.view.MotionEvent, android.view.View):boolean");
    }

    public final void n(AttributeSet attributeSet) {
        a aVar;
        a aVar2;
        int i2;
        k = isInEditMode();
        int i3 = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == C0221hs.MotionLayout_layoutDescription) {
                    this.f1447a = new a(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == C0221hs.MotionLayout_currentState) {
                    this.f1462d = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == C0221hs.MotionLayout_motionProgress) {
                    this.e = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f1461c = true;
                } else if (index == C0221hs.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == C0221hs.MotionLayout_showPaths) {
                    if (this.f1472h == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i2 = 2;
                        } else {
                            i2 = 0;
                        }
                        this.f1472h = i2;
                    }
                } else if (index == C0221hs.MotionLayout_motionDebug) {
                    this.f1472h = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (!z) {
                this.f1447a = null;
            }
        }
        if (!(this.f1472h == 0 || (aVar2 = this.f1447a) == null)) {
            int h2 = aVar2.h();
            a aVar3 = this.f1447a;
            ConstraintSet b2 = aVar3.b(aVar3.h());
            C0175e8.c(getContext(), h2);
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (b2.i(childAt.getId()) == null) {
                    C0175e8.d(childAt);
                }
            }
            Integer[] numArr = (Integer[]) b2.f1663b.keySet().toArray(new Integer[0]);
            int length = numArr.length;
            int[] iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = numArr[i6].intValue();
            }
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                C0175e8.c(getContext(), i8);
                findViewById(iArr[i7]);
                int i9 = b2.h(i8).f1665a.f1683b;
                int i10 = b2.h(i8).f1665a.f1679a;
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            Iterator<a.b> it = this.f1447a.f1509a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                a.b bVar = this.f1447a.f1507a;
                int i11 = next.c;
                int i12 = next.b;
                C0175e8.c(getContext(), i11);
                C0175e8.c(getContext(), i12);
                sparseIntArray.get(i11);
                sparseIntArray2.get(i12);
                sparseIntArray.put(i11, i12);
                sparseIntArray2.put(i12, i11);
                this.f1447a.b(i11);
                this.f1447a.b(i12);
            }
        }
        if (this.f1462d == -1 && (aVar = this.f1447a) != null) {
            this.f1462d = aVar.h();
            this.f1458c = this.f1447a.h();
            a.b bVar2 = this.f1447a.f1507a;
            if (bVar2 != null) {
                i3 = bVar2.b;
            }
            this.f1466e = i3;
        }
    }

    public final void o() {
        a.b bVar;
        b bVar2;
        View findViewById;
        View findViewById2;
        a aVar = this.f1447a;
        if (aVar != null) {
            if (aVar.a(this.f1462d, this)) {
                requestLayout();
                return;
            }
            int i2 = this.f1462d;
            KeyEvent.Callback callback = null;
            if (i2 != -1) {
                a aVar2 = this.f1447a;
                ArrayList<a.b> arrayList = aVar2.f1509a;
                Iterator<a.b> it = arrayList.iterator();
                while (it.hasNext()) {
                    a.b next = it.next();
                    if (next.f1522b.size() > 0) {
                        Iterator<a.b.C0006a> it2 = next.f1522b.iterator();
                        while (it2.hasNext()) {
                            int i3 = it2.next().c;
                            if (!(i3 == -1 || (findViewById2 = findViewById(i3)) == null)) {
                                findViewById2.setOnClickListener((View.OnClickListener) null);
                            }
                        }
                    }
                }
                ArrayList<a.b> arrayList2 = aVar2.f1514b;
                Iterator<a.b> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    a.b next2 = it3.next();
                    if (next2.f1522b.size() > 0) {
                        Iterator<a.b.C0006a> it4 = next2.f1522b.iterator();
                        while (it4.hasNext()) {
                            int i4 = it4.next().c;
                            if (!(i4 == -1 || (findViewById = findViewById(i4)) == null)) {
                                findViewById.setOnClickListener((View.OnClickListener) null);
                            }
                        }
                    }
                }
                Iterator<a.b> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    a.b next3 = it5.next();
                    if (next3.f1522b.size() > 0) {
                        Iterator<a.b.C0006a> it6 = next3.f1522b.iterator();
                        while (it6.hasNext()) {
                            it6.next().a(this, i2, next3);
                        }
                    }
                }
                Iterator<a.b> it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    a.b next4 = it7.next();
                    if (next4.f1522b.size() > 0) {
                        Iterator<a.b.C0006a> it8 = next4.f1522b.iterator();
                        while (it8.hasNext()) {
                            it8.next().a(this, i2, next4);
                        }
                    }
                }
            }
            if (this.f1447a.p() && (bVar = this.f1447a.f1507a) != null && (bVar2 = bVar.f1518a) != null) {
                int i5 = bVar2.f1535d;
                if (i5 != -1) {
                    MotionLayout motionLayout = bVar2.f1526a;
                    KeyEvent.Callback findViewById3 = motionLayout.findViewById(i5);
                    if (findViewById3 == null) {
                        C0175e8.c(motionLayout.getContext(), bVar2.f1535d);
                    }
                    callback = findViewById3;
                }
                if (callback instanceof NestedScrollView) {
                    NestedScrollView nestedScrollView = (NestedScrollView) callback;
                    nestedScrollView.setOnTouchListener(new qA());
                    nestedScrollView.setOnScrollChangeListener(new C0312rA());
                }
            }
        }
    }

    public final void onAttachedToWindow() {
        a.b bVar;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        a aVar = this.f1447a;
        if (!(aVar == null || (i2 = this.f1462d) == -1)) {
            ConstraintSet b2 = aVar.b(i2);
            this.f1447a.n(this);
            ArrayList<MotionHelper> arrayList = this.f1460c;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
            if (b2 != null) {
                b2.b(this);
            }
            this.f1458c = this.f1462d;
        }
        o();
        h hVar = this.f1444a;
        if (hVar == null) {
            a aVar2 = this.f1447a;
            if (aVar2 != null && (bVar = aVar2.f1507a) != null && bVar.g == 4) {
                s();
                setState(j.SETUP);
                setState(j.MOVING);
            }
        } else if (this.f1475i) {
            post(new c());
        } else {
            hVar.a();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        int i2;
        RectF b2;
        MotionLayout motionLayout;
        int currentState;
        ConstraintSet constraintSet;
        boolean z;
        int i3;
        c cVar;
        a aVar = this.f1447a;
        if (aVar == null || !this.f1454a) {
            return false;
        }
        d dVar = aVar.f1508a;
        if (!(dVar == null || (currentState = motionLayout.getCurrentState()) == -1)) {
            HashSet<View> hashSet = dVar.f1559a;
            ArrayList<c> arrayList = dVar.f1558a;
            if (hashSet == null) {
                dVar.f1559a = new HashSet<>();
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    int childCount = motionLayout.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = motionLayout.getChildAt(i4);
                        if (next.c(childAt)) {
                            childAt.getId();
                            dVar.f1559a.add(childAt);
                        }
                    }
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<c.a> arrayList2 = dVar.b;
            int i5 = 2;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<c.a> it2 = dVar.b.iterator();
                while (it2.hasNext()) {
                    c.a next2 = it2.next();
                    if (action != 1) {
                        if (action != 2) {
                            next2.getClass();
                        } else {
                            View view = next2.f1550a.f606a;
                            Rect rect2 = next2.f1551a;
                            view.getHitRect(rect2);
                            if (!rect2.contains((int) x, (int) y) && !next2.f1555a) {
                                next2.b();
                            }
                        }
                    } else if (!next2.f1555a) {
                        next2.b();
                    }
                }
            }
            if (action == 0 || action == 1) {
                a aVar2 = (motionLayout = dVar.a).f1447a;
                if (aVar2 == null) {
                    constraintSet = null;
                } else {
                    constraintSet = aVar2.b(currentState);
                }
                Iterator<c> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    c next3 = it3.next();
                    int i6 = next3.b;
                    if (i6 != 1 ? i6 != i5 ? !(i6 == 3 && action == 0) : action != 1 : action != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Iterator<View> it4 = dVar.f1559a.iterator();
                        while (it4.hasNext()) {
                            View next4 = it4.next();
                            if (next3.c(next4)) {
                                next4.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    cVar = next3;
                                    i3 = i5;
                                    next3.a(dVar, dVar.a, currentState, constraintSet, next4);
                                } else {
                                    cVar = next3;
                                    i3 = i5;
                                }
                                next3 = cVar;
                                i5 = i3;
                            }
                        }
                    }
                }
            }
        }
        a.b bVar2 = this.f1447a.f1507a;
        if (bVar2 == null || !(!bVar2.f1523b) || (bVar = bVar2.f1518a) == null) {
            return false;
        }
        if ((motionEvent.getAction() == 0 && (b2 = bVar.b(this, new RectF())) != null && !b2.contains(motionEvent.getX(), motionEvent.getY())) || (i2 = bVar.f1536e) == -1) {
            return false;
        }
        View view2 = this.f1439a;
        if (view2 == null || view2.getId() != i2) {
            this.f1439a = findViewById(i2);
        }
        View view3 = this.f1439a;
        if (view3 == null) {
            return false;
        }
        RectF rectF = this.f1438a;
        rectF.set((float) view3.getLeft(), (float) this.f1439a.getTop(), (float) this.f1439a.getRight(), (float) this.f1439a.getBottom());
        if (!rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        if (!m((float) this.f1439a.getLeft(), (float) this.f1439a.getTop(), motionEvent, this.f1439a)) {
            return onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f1473h = true;
        try {
            if (this.f1447a == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (!(this.f1474i == i6 && this.f1476j == i7)) {
                q();
                h(true);
            }
            this.f1474i = i6;
            this.f1476j = i7;
            this.f1473h = false;
        } finally {
            this.f1473h = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r10 != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            if (r3 != 0) goto L_0x000e
            super.onMeasure(r18, r19)
            return
        L_0x000e:
            int r3 = r0.f1468f
            r4 = 1
            r5 = 0
            if (r3 != r1) goto L_0x001b
            int r3 = r0.f1470g
            if (r3 == r2) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r3 = r5
            goto L_0x001c
        L_0x001b:
            r3 = r4
        L_0x001c:
            boolean r6 = r0.f1477j
            if (r6 == 0) goto L_0x0029
            r0.f1477j = r5
            r17.o()
            r17.p()
            r3 = r4
        L_0x0029:
            boolean r6 = r0.mDirtyHierarchy
            if (r6 == 0) goto L_0x002e
            r3 = r4
        L_0x002e:
            r0.f1468f = r1
            r0.f1470g = r2
            androidx.constraintlayout.motion.widget.a r6 = r0.f1447a
            int r6 = r6.h()
            androidx.constraintlayout.motion.widget.a r7 = r0.f1447a
            androidx.constraintlayout.motion.widget.a$b r7 = r7.f1507a
            r8 = -1
            if (r7 != 0) goto L_0x0041
            r7 = r8
            goto L_0x0043
        L_0x0041:
            int r7 = r7.b
        L_0x0043:
            androidx.constraintlayout.motion.widget.MotionLayout$f r9 = r0.f1443a
            if (r3 != 0) goto L_0x0055
            int r10 = r9.a
            if (r6 != r10) goto L_0x0052
            int r10 = r9.b
            if (r7 == r10) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r10 = r5
            goto L_0x0053
        L_0x0052:
            r10 = r4
        L_0x0053:
            if (r10 == 0) goto L_0x0074
        L_0x0055:
            int r10 = r0.f1458c
            if (r10 == r8) goto L_0x0074
            super.onMeasure(r18, r19)
            androidx.constraintlayout.motion.widget.a r1 = r0.f1447a
            androidx.constraintlayout.widget.ConstraintSet r1 = r1.b(r6)
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            androidx.constraintlayout.widget.ConstraintSet r2 = r2.b(r7)
            r9.e(r1, r2)
            r9.f()
            r9.a = r6
            r9.b = r7
            r1 = r5
            goto L_0x007a
        L_0x0074:
            if (r3 == 0) goto L_0x0079
            super.onMeasure(r18, r19)
        L_0x0079:
            r1 = r4
        L_0x007a:
            boolean r2 = r0.f1471g
            if (r2 != 0) goto L_0x0080
            if (r1 == 0) goto L_0x00cf
        L_0x0080:
            int r1 = r17.getPaddingTop()
            int r2 = r17.getPaddingBottom()
            int r2 = r2 + r1
            int r1 = r17.getPaddingLeft()
            int r3 = r17.getPaddingRight()
            int r3 = r3 + r1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.u()
            int r1 = r1 + r3
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.o()
            int r3 = r3 + r2
            int r2 = r0.q
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r6) goto L_0x00a8
            if (r2 != 0) goto L_0x00b7
        L_0x00a8:
            int r1 = r0.m
            float r2 = (float) r1
            float r7 = r0.f1478k
            int r8 = r0.o
            int r8 = r8 - r1
            float r1 = (float) r8
            float r7 = r7 * r1
            float r7 = r7 + r2
            int r1 = (int) r7
            r17.requestLayout()
        L_0x00b7:
            int r2 = r0.r
            if (r2 == r6) goto L_0x00bd
            if (r2 != 0) goto L_0x00cc
        L_0x00bd:
            int r2 = r0.n
            float r3 = (float) r2
            float r6 = r0.f1478k
            int r7 = r0.p
            int r7 = r7 - r2
            float r2 = (float) r7
            float r6 = r6 * r2
            float r6 = r6 + r3
            int r3 = (int) r6
            r17.requestLayout()
        L_0x00cc:
            r0.setMeasuredDimension(r1, r3)
        L_0x00cf:
            float r1 = r0.e
            float r2 = r0.d
            float r1 = r1 - r2
            float r1 = java.lang.Math.signum(r1)
            long r2 = r17.getNanoTime()
            Wl r6 = r0.f1435a
            boolean r7 = r6 instanceof defpackage.cy
            r8 = 814313567(0x3089705f, float:1.0E-9)
            r9 = 0
            if (r7 != 0) goto L_0x00f1
            long r10 = r0.f1455b
            long r10 = r2 - r10
            float r7 = (float) r10
            float r7 = r7 * r1
            float r7 = r7 * r8
            float r10 = r0.b
            float r7 = r7 / r10
            goto L_0x00f2
        L_0x00f1:
            r7 = r9
        L_0x00f2:
            float r10 = r0.d
            float r10 = r10 + r7
            boolean r7 = r0.f1457b
            if (r7 == 0) goto L_0x00fb
            float r10 = r0.e
        L_0x00fb:
            int r7 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0105
            float r11 = r0.e
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x010f
        L_0x0105:
            int r11 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0112
            float r11 = r0.e
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x0112
        L_0x010f:
            float r10 = r0.e
            goto L_0x0113
        L_0x0112:
            r4 = r5
        L_0x0113:
            if (r6 == 0) goto L_0x0129
            if (r4 != 0) goto L_0x0129
            boolean r4 = r0.f1465d
            if (r4 == 0) goto L_0x0125
            long r10 = r0.f1433a
            long r2 = r2 - r10
            float r2 = (float) r2
            float r2 = r2 * r8
            float r10 = r6.getInterpolation(r2)
            goto L_0x0129
        L_0x0125:
            float r10 = r6.getInterpolation(r10)
        L_0x0129:
            if (r7 <= 0) goto L_0x0131
            float r2 = r0.e
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x013b
        L_0x0131:
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 > 0) goto L_0x013d
            float r1 = r0.e
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x013d
        L_0x013b:
            float r10 = r0.e
        L_0x013d:
            r0.f1478k = r10
            int r1 = r17.getChildCount()
            long r2 = r17.getNanoTime()
            android.view.animation.Interpolator r4 = r0.f1440a
            if (r4 != 0) goto L_0x014c
            goto L_0x0150
        L_0x014c:
            float r10 = r4.getInterpolation(r10)
        L_0x0150:
            if (r5 >= r1) goto L_0x016d
            android.view.View r15 = r0.getChildAt(r5)
            java.util.HashMap<android.view.View, Vl> r4 = r0.f1451a
            java.lang.Object r4 = r4.get(r15)
            r11 = r4
            Vl r11 = (defpackage.Vl) r11
            if (r11 == 0) goto L_0x016a
            nh r4 = r0.f1453a
            r12 = r10
            r13 = r2
            r16 = r4
            r11.e(r12, r13, r15, r16)
        L_0x016a:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x016d:
            boolean r1 = r0.f1471g
            if (r1 == 0) goto L_0x0174
            r17.requestLayout()
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onMeasure(int, int):void");
    }

    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        a.b bVar;
        boolean z;
        boolean z2;
        ? r1;
        b bVar2;
        float f2;
        float f3;
        b bVar3;
        b bVar4;
        b bVar5;
        int i5;
        View view2 = view;
        int i6 = i2;
        int i7 = i3;
        a aVar = this.f1447a;
        if (aVar != null && (bVar = aVar.f1507a) != null && z) {
            int i8 = -1;
            if (!(!bVar.f1523b) || (bVar5 = bVar.f1518a) == null || (i5 = bVar5.f1536e) == -1 || view.getId() == i5) {
                a.b bVar6 = aVar.f1507a;
                if (bVar6 == null || (bVar4 = bVar6.f1518a) == null) {
                    z2 = false;
                } else {
                    z2 = bVar4.f1534c;
                }
                if (z2) {
                    b bVar7 = bVar.f1518a;
                    if (!(bVar7 == null || (bVar7.f1539h & 4) == 0)) {
                        i8 = i7;
                    }
                    float f4 = this.c;
                    if ((f4 == 1.0f || f4 == 0.0f) && view2.canScrollVertically(i8)) {
                        return;
                    }
                }
                b bVar8 = bVar.f1518a;
                if (!(bVar8 == null || (bVar8.f1539h & 1) == 0)) {
                    float f5 = (float) i6;
                    float f6 = (float) i7;
                    a.b bVar9 = aVar.f1507a;
                    if (bVar9 == null || (bVar3 = bVar9.f1518a) == null) {
                        f3 = 0.0f;
                    } else {
                        bVar3.f1526a.k(bVar3.f1535d, bVar3.f1526a.getProgress(), bVar3.f1530b, bVar3.f1524a, bVar3.f1528a);
                        float f7 = bVar3.c;
                        int i9 = (f7 > 0.0f ? 1 : (f7 == 0.0f ? 0 : -1));
                        float[] fArr = bVar3.f1528a;
                        if (i9 != 0) {
                            if (fArr[0] == 0.0f) {
                                fArr[0] = 1.0E-7f;
                            }
                            f3 = (f5 * f7) / fArr[0];
                        } else {
                            if (fArr[1] == 0.0f) {
                                fArr[1] = 1.0E-7f;
                            }
                            f3 = (f6 * bVar3.d) / fArr[1];
                        }
                    }
                    float f8 = this.d;
                    if ((f8 <= 0.0f && f3 < 0.0f) || (f8 >= 1.0f && f3 > 0.0f)) {
                        view2.setNestedScrollingEnabled(false);
                        view2.post(new b(view2));
                        return;
                    }
                }
                float f9 = this.c;
                long nanoTime = getNanoTime();
                float f10 = (float) i6;
                this.f = f10;
                float f11 = (float) i7;
                this.g = f11;
                this.h = (float) (((double) (nanoTime - this.f1459c)) * 1.0E-9d);
                this.f1459c = nanoTime;
                a.b bVar10 = aVar.f1507a;
                if (!(bVar10 == null || (bVar2 = bVar10.f1518a) == null)) {
                    MotionLayout motionLayout = bVar2.f1526a;
                    float progress = motionLayout.getProgress();
                    if (!bVar2.f1532b) {
                        bVar2.f1532b = true;
                        motionLayout.setProgress(progress);
                    }
                    bVar2.f1526a.k(bVar2.f1535d, progress, bVar2.f1530b, bVar2.f1524a, bVar2.f1528a);
                    float f12 = bVar2.c;
                    float[] fArr2 = bVar2.f1528a;
                    if (((double) Math.abs((bVar2.d * fArr2[1]) + (f12 * fArr2[0]))) < 0.01d) {
                        fArr2[0] = 0.01f;
                        fArr2[1] = 0.01f;
                    }
                    float f13 = bVar2.c;
                    if (f13 != 0.0f) {
                        f2 = (f10 * f13) / fArr2[0];
                    } else {
                        f2 = (f11 * bVar2.d) / fArr2[1];
                    }
                    float max = Math.max(Math.min(progress + f2, 1.0f), 0.0f);
                    if (max != motionLayout.getProgress()) {
                        motionLayout.setProgress(max);
                    }
                }
                if (f9 != this.c) {
                    iArr[0] = i6;
                    r1 = 1;
                    iArr[1] = i7;
                } else {
                    r1 = 1;
                }
                h(false);
                if (iArr[0] != 0 || iArr[r1] != 0) {
                    this.f1467e = r1;
                }
            }
        }
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        this.f1459c = getNanoTime();
        this.h = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
    }

    public final void onRtlPropertiesChanged(int i2) {
        b bVar;
        a aVar = this.f1447a;
        if (aVar != null) {
            boolean isRtl = isRtl();
            aVar.c = isRtl;
            a.b bVar2 = aVar.f1507a;
            if (bVar2 != null && (bVar = bVar2.f1518a) != null) {
                bVar.c(isRtl);
            }
        }
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        a.b bVar;
        b bVar2;
        a aVar = this.f1447a;
        if (aVar == null || (bVar = aVar.f1507a) == null || (bVar2 = bVar.f1518a) == null || (bVar2.f1539h & 2) != 0) {
            return false;
        }
        return true;
    }

    public final void onStopNestedScroll(View view, int i2) {
        b bVar;
        float f2;
        boolean z;
        a aVar = this.f1447a;
        if (aVar != null) {
            float f3 = this.h;
            float f4 = 0.0f;
            if (f3 != 0.0f) {
                float f5 = this.f / f3;
                float f6 = this.g / f3;
                a.b bVar2 = aVar.f1507a;
                if (bVar2 != null && (bVar = bVar2.f1518a) != null) {
                    boolean z2 = false;
                    bVar.f1532b = false;
                    MotionLayout motionLayout = bVar.f1526a;
                    float progress = motionLayout.getProgress();
                    bVar.f1526a.k(bVar.f1535d, progress, bVar.f1530b, bVar.f1524a, bVar.f1528a);
                    float f7 = bVar.c;
                    float[] fArr = bVar.f1528a;
                    float f8 = fArr[0];
                    float f9 = bVar.d;
                    float f10 = fArr[1];
                    if (f7 != 0.0f) {
                        f2 = (f5 * f7) / f8;
                    } else {
                        f2 = (f6 * f9) / f10;
                    }
                    if (!Float.isNaN(f2)) {
                        progress += f2 / 3.0f;
                    }
                    if (progress != 0.0f) {
                        if (progress != 1.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        int i3 = bVar.f1533c;
                        if (i3 != 3) {
                            z2 = true;
                        }
                        if (z2 && z) {
                            if (((double) progress) >= 0.5d) {
                                f4 = 1.0f;
                            }
                            motionLayout.r(f4, f2, i3);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        if (r8.contains(r14.getX(), r14.getY()) == false) goto L_0x0108;
     */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x056a  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x07c9  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x07e2  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x07ee  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x07f0  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x07f3  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x07f8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            if (r2 == 0) goto L_0x07fa
            boolean r3 = r0.f1454a
            if (r3 == 0) goto L_0x07fa
            boolean r2 = r2.p()
            if (r2 == 0) goto L_0x07fa
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            androidx.constraintlayout.motion.widget.a$b r3 = r2.f1507a
            r4 = 1
            if (r3 == 0) goto L_0x0023
            boolean r3 = r3.f1523b
            r3 = r3 ^ r4
            if (r3 != 0) goto L_0x0023
            boolean r1 = super.onTouchEvent(r34)
            return r1
        L_0x0023:
            int r3 = r33.getCurrentState()
            android.graphics.RectF r5 = new android.graphics.RectF
            r5.<init>()
            androidx.constraintlayout.motion.widget.MotionLayout$g r6 = r2.f1505a
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r2.f1506a
            if (r6 != 0) goto L_0x003f
            r7.getClass()
            androidx.constraintlayout.motion.widget.MotionLayout$g r6 = androidx.constraintlayout.motion.widget.MotionLayout.g.a
            android.view.VelocityTracker r8 = android.view.VelocityTracker.obtain()
            r6.f1495a = r8
            r2.f1505a = r6
        L_0x003f:
            androidx.constraintlayout.motion.widget.MotionLayout$g r6 = r2.f1505a
            android.view.VelocityTracker r6 = r6.f1495a
            if (r6 == 0) goto L_0x0048
            r6.addMovement(r1)
        L_0x0048:
            r6 = 2
            r9 = -1
            if (r3 == r9) goto L_0x0232
            int r12 = r34.getAction()
            if (r12 == 0) goto L_0x01cb
            if (r12 == r6) goto L_0x0056
            goto L_0x0232
        L_0x0056:
            boolean r12 = r2.f1511a
            if (r12 == 0) goto L_0x005c
            goto L_0x0232
        L_0x005c:
            float r12 = r34.getRawY()
            float r13 = r2.b
            float r12 = r12 - r13
            float r13 = r34.getRawX()
            float r14 = r2.a
            float r13 = r13 - r14
            double r14 = (double) r13
            r16 = 0
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x0076
            double r14 = (double) r12
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x0236
        L_0x0076:
            android.view.MotionEvent r14 = r2.f1504a
            if (r14 != 0) goto L_0x007c
            goto L_0x0236
        L_0x007c:
            if (r3 == r9) goto L_0x0192
            Ux r15 = r2.f1501a
            if (r15 == 0) goto L_0x0089
            int r15 = r15.a(r3)
            if (r15 == r9) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r15 = r3
        L_0x008a:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r9 = r2.f1509a
            java.util.Iterator r9 = r9.iterator()
        L_0x0095:
            boolean r18 = r9.hasNext()
            if (r18 == 0) goto L_0x00b1
            java.lang.Object r18 = r9.next()
            r6 = r18
            androidx.constraintlayout.motion.widget.a$b r6 = (androidx.constraintlayout.motion.widget.a.b) r6
            int r4 = r6.c
            if (r4 == r15) goto L_0x00ab
            int r4 = r6.b
            if (r4 != r15) goto L_0x00ae
        L_0x00ab:
            r11.add(r6)
        L_0x00ae:
            r4 = 1
            r6 = 2
            goto L_0x0095
        L_0x00b1:
            android.graphics.RectF r4 = new android.graphics.RectF
            r4.<init>()
            java.util.Iterator r6 = r11.iterator()
            r9 = 0
            r11 = 0
        L_0x00bc:
            boolean r15 = r6.hasNext()
            if (r15 == 0) goto L_0x018e
            java.lang.Object r15 = r6.next()
            androidx.constraintlayout.motion.widget.a$b r15 = (androidx.constraintlayout.motion.widget.a.b) r15
            boolean r8 = r15.f1523b
            if (r8 == 0) goto L_0x00ce
            goto L_0x0174
        L_0x00ce:
            androidx.constraintlayout.motion.widget.b r8 = r15.f1518a
            if (r8 == 0) goto L_0x0174
            boolean r10 = r2.c
            r8.c(r10)
            androidx.constraintlayout.motion.widget.b r8 = r15.f1518a
            android.graphics.RectF r8 = r8.b(r7, r4)
            if (r8 == 0) goto L_0x00f0
            float r10 = r14.getX()
            r19 = r6
            float r6 = r14.getY()
            boolean r6 = r8.contains(r10, r6)
            if (r6 != 0) goto L_0x00f2
            goto L_0x0108
        L_0x00f0:
            r19 = r6
        L_0x00f2:
            androidx.constraintlayout.motion.widget.b r6 = r15.f1518a
            android.graphics.RectF r6 = r6.a(r7, r4)
            if (r6 == 0) goto L_0x0114
            float r8 = r14.getX()
            float r10 = r14.getY()
            boolean r6 = r6.contains(r8, r10)
            if (r6 != 0) goto L_0x0114
        L_0x0108:
            r20 = r4
            r6 = r5
            r22 = r11
            r21 = r12
            r8 = r13
            r23 = r14
            goto L_0x0180
        L_0x0114:
            androidx.constraintlayout.motion.widget.b r6 = r15.f1518a
            float r8 = r6.c
            float r8 = r8 * r13
            float r10 = r6.d
            float r10 = r10 * r12
            float r10 = r10 + r8
            boolean r6 = r6.f1527a
            if (r6 == 0) goto L_0x0158
            float r6 = r14.getX()
            androidx.constraintlayout.motion.widget.b r8 = r15.f1518a
            r8.getClass()
            r8 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 - r8
            float r10 = r14.getY()
            r20 = r4
            androidx.constraintlayout.motion.widget.b r4 = r15.f1518a
            r4.getClass()
            float r10 = r10 - r8
            float r4 = r13 + r6
            float r8 = r12 + r10
            r22 = r11
            r21 = r12
            double r11 = (double) r8
            r8 = r13
            r23 = r14
            double r13 = (double) r4
            double r11 = java.lang.Math.atan2(r11, r13)
            double r13 = (double) r6
            r6 = r5
            double r4 = (double) r10
            double r4 = java.lang.Math.atan2(r13, r4)
            double r11 = r11 - r4
            float r4 = (float) r11
            r5 = 1092616192(0x41200000, float:10.0)
            float r10 = r4 * r5
            goto L_0x0162
        L_0x0158:
            r20 = r4
            r6 = r5
            r22 = r11
            r21 = r12
            r8 = r13
            r23 = r14
        L_0x0162:
            int r4 = r15.b
            if (r4 != r3) goto L_0x0169
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x016c
        L_0x0169:
            r4 = 1066192077(0x3f8ccccd, float:1.1)
        L_0x016c:
            float r4 = r4 * r10
            int r5 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0180
            r9 = r4
            r11 = r15
            goto L_0x0182
        L_0x0174:
            r20 = r4
            r19 = r6
            r22 = r11
            r21 = r12
            r8 = r13
            r23 = r14
            r6 = r5
        L_0x0180:
            r11 = r22
        L_0x0182:
            r5 = r6
            r13 = r8
            r6 = r19
            r4 = r20
            r12 = r21
            r14 = r23
            goto L_0x00bc
        L_0x018e:
            r6 = r5
            r22 = r11
            goto L_0x0195
        L_0x0192:
            r6 = r5
            androidx.constraintlayout.motion.widget.a$b r11 = r2.f1507a
        L_0x0195:
            if (r11 == 0) goto L_0x0232
            r0.setTransition((androidx.constraintlayout.motion.widget.a.b) r11)
            androidx.constraintlayout.motion.widget.a$b r3 = r2.f1507a
            androidx.constraintlayout.motion.widget.b r3 = r3.f1518a
            android.graphics.RectF r3 = r3.b(r7, r6)
            if (r3 == 0) goto L_0x01b8
            android.view.MotionEvent r4 = r2.f1504a
            float r4 = r4.getX()
            android.view.MotionEvent r5 = r2.f1504a
            float r5 = r5.getY()
            boolean r3 = r3.contains(r4, r5)
            if (r3 != 0) goto L_0x01b8
            r3 = 1
            goto L_0x01b9
        L_0x01b8:
            r3 = 0
        L_0x01b9:
            r2.f1515b = r3
            androidx.constraintlayout.motion.widget.a$b r3 = r2.f1507a
            androidx.constraintlayout.motion.widget.b r3 = r3.f1518a
            float r4 = r2.a
            float r5 = r2.b
            r3.e = r4
            r3.f = r5
            r4 = 0
            r3.f1532b = r4
            goto L_0x0232
        L_0x01cb:
            r6 = r5
            r4 = 0
            float r3 = r34.getRawX()
            r2.a = r3
            float r3 = r34.getRawY()
            r2.b = r3
            r2.f1504a = r1
            r2.f1511a = r4
            androidx.constraintlayout.motion.widget.a$b r1 = r2.f1507a
            androidx.constraintlayout.motion.widget.b r1 = r1.f1518a
            if (r1 == 0) goto L_0x0236
            android.graphics.RectF r1 = r1.a(r7, r6)
            if (r1 == 0) goto L_0x0202
            android.view.MotionEvent r3 = r2.f1504a
            float r3 = r3.getX()
            android.view.MotionEvent r4 = r2.f1504a
            float r4 = r4.getY()
            boolean r1 = r1.contains(r3, r4)
            if (r1 != 0) goto L_0x0202
            r1 = 0
            r2.f1504a = r1
            r1 = 1
            r2.f1511a = r1
            goto L_0x0236
        L_0x0202:
            androidx.constraintlayout.motion.widget.a$b r1 = r2.f1507a
            androidx.constraintlayout.motion.widget.b r1 = r1.f1518a
            android.graphics.RectF r1 = r1.b(r7, r6)
            if (r1 == 0) goto L_0x0222
            android.view.MotionEvent r3 = r2.f1504a
            float r3 = r3.getX()
            android.view.MotionEvent r4 = r2.f1504a
            float r4 = r4.getY()
            boolean r1 = r1.contains(r3, r4)
            if (r1 != 0) goto L_0x0222
            r1 = 1
            r2.f1515b = r1
            goto L_0x0225
        L_0x0222:
            r1 = 0
            r2.f1515b = r1
        L_0x0225:
            androidx.constraintlayout.motion.widget.a$b r1 = r2.f1507a
            androidx.constraintlayout.motion.widget.b r1 = r1.f1518a
            float r3 = r2.a
            float r2 = r2.b
            r1.e = r3
            r1.f = r2
            goto L_0x0236
        L_0x0232:
            boolean r3 = r2.f1511a
            if (r3 == 0) goto L_0x023a
        L_0x0236:
            r2 = r0
            r0 = 0
            goto L_0x07e4
        L_0x023a:
            androidx.constraintlayout.motion.widget.a$b r3 = r2.f1507a
            if (r3 == 0) goto L_0x07ac
            androidx.constraintlayout.motion.widget.b r3 = r3.f1518a
            if (r3 == 0) goto L_0x07ac
            boolean r4 = r2.f1515b
            if (r4 != 0) goto L_0x07ac
            androidx.constraintlayout.motion.widget.MotionLayout$g r4 = r2.f1505a
            boolean r5 = r3.f1527a
            androidx.constraintlayout.motion.widget.MotionLayout$j r6 = androidx.constraintlayout.motion.widget.MotionLayout.j.FINISHED
            r19 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            float[] r15 = r3.f1528a
            androidx.constraintlayout.motion.widget.MotionLayout r10 = r3.f1526a
            if (r5 == 0) goto L_0x058f
            android.view.VelocityTracker r5 = r4.f1495a
            if (r5 == 0) goto L_0x025e
            r5.addMovement(r1)
        L_0x025e:
            int r5 = r34.getAction()
            if (r5 == 0) goto L_0x0579
            r22 = 1135869952(0x43b40000, float:360.0)
            int[] r11 = r3.f1529a
            r24 = 1073741824(0x40000000, float:2.0)
            r7 = 1
            if (r5 == r7) goto L_0x040c
            r7 = 2
            if (r5 == r7) goto L_0x0272
            goto L_0x034f
        L_0x0272:
            r34.getRawY()
            r34.getRawX()
            int r5 = r10.getWidth()
            float r5 = (float) r5
            float r5 = r5 / r24
            int r6 = r10.getHeight()
            float r6 = (float) r6
            float r6 = r6 / r24
            int r7 = r3.f1538g
            r8 = -1
            if (r7 == r8) goto L_0x02ba
            android.view.View r5 = r10.findViewById(r7)
            r10.getLocationOnScreen(r11)
            r6 = 0
            r7 = r11[r6]
            float r6 = (float) r7
            int r7 = r5.getLeft()
            int r8 = r5.getRight()
            int r8 = r8 + r7
            float r7 = (float) r8
            float r7 = r7 / r24
            float r6 = r6 + r7
            r7 = 1
            r8 = r11[r7]
            float r7 = (float) r8
            int r8 = r5.getTop()
            int r5 = r5.getBottom()
            int r5 = r5 + r8
            float r5 = (float) r5
            float r5 = r5 / r24
            float r5 = r5 + r7
            r32 = r6
            r6 = r5
            r5 = r32
            goto L_0x02fb
        L_0x02ba:
            int r7 = r3.f1535d
            r8 = -1
            if (r7 == r8) goto L_0x02fb
            java.util.HashMap<android.view.View, Vl> r8 = r10.f1451a
            android.view.View r7 = r10.findViewById(r7)
            java.lang.Object r7 = r8.get(r7)
            Vl r7 = (defpackage.Vl) r7
            Xl r7 = r7.f604a
            int r7 = r7.f687e
            android.view.View r7 = r10.findViewById(r7)
            if (r7 != 0) goto L_0x02d6
            goto L_0x02fb
        L_0x02d6:
            r10.getLocationOnScreen(r11)
            r5 = 0
            r6 = r11[r5]
            float r5 = (float) r6
            int r6 = r7.getLeft()
            int r8 = r7.getRight()
            int r8 = r8 + r6
            float r6 = (float) r8
            float r6 = r6 / r24
            float r5 = r5 + r6
            r6 = 1
            r8 = r11[r6]
            float r6 = (float) r8
            int r8 = r7.getTop()
            int r7 = r7.getBottom()
            int r7 = r7 + r8
            float r7 = (float) r7
            float r7 = r7 / r24
            float r6 = r6 + r7
        L_0x02fb:
            float r7 = r34.getRawX()
            float r7 = r7 - r5
            float r8 = r34.getRawY()
            float r8 = r8 - r6
            float r9 = r34.getRawY()
            float r9 = r9 - r6
            double r11 = (double) r9
            float r9 = r34.getRawX()
            float r9 = r9 - r5
            double r13 = (double) r9
            double r11 = java.lang.Math.atan2(r11, r13)
            float r9 = r3.f
            float r9 = r9 - r6
            double r13 = (double) r9
            float r6 = r3.e
            float r6 = r6 - r5
            double r5 = (double) r6
            double r5 = java.lang.Math.atan2(r13, r5)
            double r5 = r11 - r5
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r5 = r5 * r13
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r5 = r5 / r13
            float r5 = (float) r5
            r6 = 1134886912(0x43a50000, float:330.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0339
            float r5 = r5 - r22
            goto L_0x0341
        L_0x0339:
            r6 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0341
            float r5 = r5 + r22
        L_0x0341:
            float r6 = java.lang.Math.abs(r5)
            double r13 = (double) r6
            int r6 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r6 > 0) goto L_0x0353
            boolean r6 = r3.f1532b
            if (r6 == 0) goto L_0x034f
            goto L_0x0353
        L_0x034f:
            r31 = r2
            goto L_0x058a
        L_0x0353:
            float r6 = r10.getProgress()
            boolean r9 = r3.f1532b
            if (r9 != 0) goto L_0x0361
            r9 = 1
            r3.f1532b = r9
            r10.setProgress(r6)
        L_0x0361:
            int r9 = r3.f1535d
            r13 = -1
            if (r9 == r13) goto L_0x038b
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r3.f1526a
            float r14 = r3.f1530b
            float r0 = r3.f1524a
            r31 = r2
            float[] r2 = r3.f1528a
            r25 = r13
            r26 = r9
            r27 = r6
            r28 = r14
            r29 = r0
            r30 = r2
            r25.k(r26, r27, r28, r29, r30)
            r0 = 1
            r2 = r15[r0]
            double r13 = (double) r2
            double r13 = java.lang.Math.toDegrees(r13)
            float r2 = (float) r13
            r15[r0] = r2
            goto L_0x0390
        L_0x038b:
            r31 = r2
            r0 = 1
            r15[r0] = r22
        L_0x0390:
            float r2 = r3.i
            float r5 = r5 * r2
            r2 = r15[r0]
            float r5 = r5 / r2
            float r5 = r5 + r6
            r0 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r5, r0)
            r5 = 0
            float r2 = java.lang.Math.max(r2, r5)
            float r6 = r10.getProgress()
            int r9 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x03fb
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x03b2
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x03ba
        L_0x03b2:
            if (r9 != 0) goto L_0x03b6
            r0 = 1
            goto L_0x03b7
        L_0x03b6:
            r0 = 0
        L_0x03b7:
            r10.g(r0)
        L_0x03ba:
            r10.setProgress(r2)
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x03c6
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
        L_0x03c6:
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x03cf
            float r0 = r0.getXVelocity()
            goto L_0x03d0
        L_0x03cf:
            r0 = 0
        L_0x03d0:
            android.view.VelocityTracker r2 = r4.f1495a
            if (r2 == 0) goto L_0x03d9
            float r2 = r2.getYVelocity()
            goto L_0x03da
        L_0x03d9:
            r2 = 0
        L_0x03da:
            double r4 = (double) r2
            double r13 = (double) r0
            double r15 = java.lang.Math.hypot(r4, r13)
            double r4 = java.lang.Math.atan2(r4, r13)
            double r4 = r4 - r11
            double r4 = java.lang.Math.sin(r4)
            double r4 = r4 * r15
            double r6 = (double) r7
            double r8 = (double) r8
            double r6 = java.lang.Math.hypot(r6, r8)
            double r4 = r4 / r6
            float r0 = (float) r4
            double r4 = (double) r0
            double r4 = java.lang.Math.toDegrees(r4)
            float r0 = (float) r4
            r10.a = r0
            goto L_0x03fe
        L_0x03fb:
            r0 = r5
            r10.a = r0
        L_0x03fe:
            float r0 = r34.getRawX()
            r3.e = r0
            float r0 = r34.getRawY()
            r3.f = r0
            goto L_0x058a
        L_0x040c:
            r31 = r2
            r0 = 0
            r3.f1532b = r0
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x041a
            r2 = 16
            r0.computeCurrentVelocity(r2)
        L_0x041a:
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x0423
            float r0 = r0.getXVelocity()
            goto L_0x0424
        L_0x0423:
            r0 = 0
        L_0x0424:
            android.view.VelocityTracker r2 = r4.f1495a
            if (r2 == 0) goto L_0x042d
            float r2 = r2.getYVelocity()
            goto L_0x042e
        L_0x042d:
            r2 = 0
        L_0x042e:
            float r4 = r10.getProgress()
            int r5 = r10.getWidth()
            float r5 = (float) r5
            float r5 = r5 / r24
            int r7 = r10.getHeight()
            float r7 = (float) r7
            float r7 = r7 / r24
            int r8 = r3.f1538g
            r13 = -1
            if (r8 == r13) goto L_0x046a
            android.view.View r5 = r10.findViewById(r8)
            r10.getLocationOnScreen(r11)
            r7 = 0
            r8 = r11[r7]
            float r7 = (float) r8
            int r8 = r5.getLeft()
            int r13 = r5.getRight()
            int r13 = r13 + r8
            float r8 = (float) r13
            float r8 = r8 / r24
            float r8 = r8 + r7
            r7 = 1
            r11 = r11[r7]
            float r7 = (float) r11
            int r11 = r5.getTop()
            int r5 = r5.getBottom()
            goto L_0x04a3
        L_0x046a:
            int r8 = r3.f1535d
            r13 = -1
            if (r8 == r13) goto L_0x04a9
            java.util.HashMap<android.view.View, Vl> r5 = r10.f1451a
            android.view.View r7 = r10.findViewById(r8)
            java.lang.Object r5 = r5.get(r7)
            Vl r5 = (defpackage.Vl) r5
            Xl r5 = r5.f604a
            int r5 = r5.f687e
            android.view.View r5 = r10.findViewById(r5)
            r10.getLocationOnScreen(r11)
            r7 = 0
            r8 = r11[r7]
            float r7 = (float) r8
            int r8 = r5.getLeft()
            int r13 = r5.getRight()
            int r13 = r13 + r8
            float r8 = (float) r13
            float r8 = r8 / r24
            float r8 = r8 + r7
            r7 = 1
            r11 = r11[r7]
            float r7 = (float) r11
            int r11 = r5.getTop()
            int r5 = r5.getBottom()
        L_0x04a3:
            int r5 = r5 + r11
            float r5 = (float) r5
            float r5 = r5 / r24
            float r7 = r7 + r5
            r5 = r8
        L_0x04a9:
            float r8 = r34.getRawX()
            float r8 = r8 - r5
            float r5 = r34.getRawY()
            float r5 = r5 - r7
            double r13 = (double) r5
            r11 = r10
            double r9 = (double) r8
            double r9 = java.lang.Math.atan2(r13, r9)
            double r9 = java.lang.Math.toDegrees(r9)
            int r13 = r3.f1535d
            r14 = -1
            if (r13 == r14) goto L_0x04e6
            androidx.constraintlayout.motion.widget.MotionLayout r14 = r3.f1526a
            float r7 = r3.f1530b
            float r12 = r3.f1524a
            float[] r1 = r3.f1528a
            r25 = r14
            r26 = r13
            r27 = r4
            r28 = r7
            r29 = r12
            r30 = r1
            r25.k(r26, r27, r28, r29, r30)
            r1 = 1
            r7 = r15[r1]
            double r12 = (double) r7
            double r12 = java.lang.Math.toDegrees(r12)
            float r7 = (float) r12
            r15[r1] = r7
            goto L_0x04e9
        L_0x04e6:
            r1 = 1
            r15[r1] = r22
        L_0x04e9:
            float r2 = r2 + r5
            double r1 = (double) r2
            float r0 = r0 + r8
            double r7 = (double) r0
            double r0 = java.lang.Math.atan2(r1, r7)
            double r0 = java.lang.Math.toDegrees(r0)
            double r0 = r0 - r9
            float r0 = (float) r0
            r1 = 1115291648(0x427a0000, float:62.5)
            float r0 = r0 * r1
            boolean r1 = java.lang.Float.isNaN(r0)
            if (r1 != 0) goto L_0x050d
            r1 = 1077936128(0x40400000, float:3.0)
            float r12 = r0 * r1
            float r1 = r3.i
            float r12 = r12 * r1
            r1 = 1
            r2 = r15[r1]
            float r12 = r12 / r2
            float r12 = r12 + r4
            goto L_0x050e
        L_0x050d:
            r12 = r4
        L_0x050e:
            r1 = 0
            int r2 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x056a
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x056a
            int r1 = r3.f1533c
            r2 = 3
            if (r1 == r2) goto L_0x056a
            float r2 = r3.i
            float r0 = r0 * r2
            r2 = 1
            r5 = r15[r2]
            float r0 = r0 / r5
            double r7 = (double) r12
            r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x052e
            r2 = 0
            goto L_0x0530
        L_0x052e:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0530:
            r5 = 6
            if (r1 != r5) goto L_0x0540
            float r1 = r4 + r0
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x053e
            float r0 = java.lang.Math.abs(r0)
        L_0x053e:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0540:
            int r1 = r3.f1533c
            r5 = 7
            if (r1 != r5) goto L_0x0553
            float r1 = r4 + r0
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0552
            float r0 = java.lang.Math.abs(r0)
            float r0 = -r0
        L_0x0552:
            r2 = 0
        L_0x0553:
            int r1 = r3.f1533c
            r3 = 1077936128(0x40400000, float:3.0)
            float r0 = r0 * r3
            r11.r(r2, r0, r1)
            r0 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0566
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x058a
        L_0x0566:
            r11.setState(r6)
            goto L_0x058a
        L_0x056a:
            r0 = 0
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x0575
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x058a
        L_0x0575:
            r11.setState(r6)
            goto L_0x058a
        L_0x0579:
            r31 = r2
            float r0 = r34.getRawX()
            r3.e = r0
            float r0 = r34.getRawY()
            r3.f = r0
            r0 = 0
            r3.f1532b = r0
        L_0x058a:
            r1 = r34
        L_0x058c:
            r0 = 0
            goto L_0x07b0
        L_0x058f:
            r31 = r2
            r11 = r10
            android.view.VelocityTracker r0 = r4.f1495a
            r1 = r34
            if (r0 == 0) goto L_0x059b
            r0.addMovement(r1)
        L_0x059b:
            int r0 = r34.getAction()
            if (r0 == 0) goto L_0x079c
            r2 = 1
            if (r0 == r2) goto L_0x06c1
            r2 = 2
            if (r0 == r2) goto L_0x05a8
            goto L_0x058c
        L_0x05a8:
            float r0 = r34.getRawY()
            float r2 = r3.f
            float r0 = r0 - r2
            float r2 = r34.getRawX()
            float r5 = r3.e
            float r2 = r2 - r5
            float r5 = r3.c
            float r5 = r5 * r2
            float r6 = r3.d
            float r6 = r6 * r0
            float r6 = r6 + r5
            float r5 = java.lang.Math.abs(r6)
            float r6 = r3.j
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x05cb
            boolean r5 = r3.f1532b
            if (r5 == 0) goto L_0x058c
        L_0x05cb:
            float r5 = r11.getProgress()
            boolean r6 = r3.f1532b
            if (r6 != 0) goto L_0x05d9
            r6 = 1
            r3.f1532b = r6
            r11.setProgress(r5)
        L_0x05d9:
            int r6 = r3.f1535d
            r7 = -1
            if (r6 == r7) goto L_0x05f8
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.f1526a
            float r8 = r3.f1530b
            float r9 = r3.f1524a
            float[] r10 = r3.f1528a
            r25 = r7
            r26 = r6
            r27 = r5
            r28 = r8
            r29 = r9
            r30 = r10
            r25.k(r26, r27, r28, r29, r30)
            r7 = 0
            r8 = 1
            goto L_0x0611
        L_0x05f8:
            int r6 = r11.getWidth()
            int r7 = r11.getHeight()
            int r6 = java.lang.Math.min(r6, r7)
            float r6 = (float) r6
            float r7 = r3.d
            float r7 = r7 * r6
            r8 = 1
            r15[r8] = r7
            float r7 = r3.c
            float r6 = r6 * r7
            r7 = 0
            r15[r7] = r6
        L_0x0611:
            float r6 = r3.c
            r9 = r15[r7]
            float r6 = r6 * r9
            float r7 = r3.d
            r9 = r15[r8]
            float r7 = r7 * r9
            float r7 = r7 + r6
            float r6 = r3.i
            float r7 = r7 * r6
            float r6 = java.lang.Math.abs(r7)
            double r6 = (double) r6
            int r6 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            r7 = 1008981770(0x3c23d70a, float:0.01)
            if (r6 >= 0) goto L_0x0631
            r6 = 0
            r15[r6] = r7
            r15[r8] = r7
            goto L_0x0632
        L_0x0631:
            r6 = 0
        L_0x0632:
            float r9 = r3.c
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x063d
            r0 = r15[r6]
            float r2 = r2 / r0
            goto L_0x0641
        L_0x063d:
            r2 = r15[r8]
            float r2 = r0 / r2
        L_0x0641:
            float r5 = r5 + r2
            r0 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r5, r0)
            float r0 = java.lang.Math.max(r2, r10)
            int r2 = r3.f1533c
            r5 = 6
            if (r2 != r5) goto L_0x0655
            float r0 = java.lang.Math.max(r0, r7)
        L_0x0655:
            int r2 = r3.f1533c
            r5 = 7
            if (r2 != r5) goto L_0x0661
            r2 = 1065185444(0x3f7d70a4, float:0.99)
            float r0 = java.lang.Math.min(r0, r2)
        L_0x0661:
            float r2 = r11.getProgress()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x06b0
            r5 = 0
            int r6 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r6 == 0) goto L_0x0674
            r5 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x067c
        L_0x0674:
            if (r6 != 0) goto L_0x0678
            r2 = 1
            goto L_0x0679
        L_0x0678:
            r2 = 0
        L_0x0679:
            r11.g(r2)
        L_0x067c:
            r11.setProgress(r0)
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x0688
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
        L_0x0688:
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x0691
            float r0 = r0.getXVelocity()
            goto L_0x0692
        L_0x0691:
            r0 = 0
        L_0x0692:
            android.view.VelocityTracker r2 = r4.f1495a
            if (r2 == 0) goto L_0x069b
            float r2 = r2.getYVelocity()
            goto L_0x069c
        L_0x069b:
            r2 = 0
        L_0x069c:
            float r4 = r3.c
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x06a8
            r4 = 0
            r2 = r15[r4]
            float r0 = r0 / r2
            goto L_0x06ad
        L_0x06a8:
            r0 = 1
            r4 = r15[r0]
            float r0 = r2 / r4
        L_0x06ad:
            r11.a = r0
            goto L_0x06b3
        L_0x06b0:
            r5 = 0
            r11.a = r5
        L_0x06b3:
            float r0 = r34.getRawX()
            r3.e = r0
            float r0 = r34.getRawY()
            r3.f = r0
            goto L_0x058c
        L_0x06c1:
            r0 = 0
            r3.f1532b = r0
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x06cd
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
        L_0x06cd:
            android.view.VelocityTracker r0 = r4.f1495a
            if (r0 == 0) goto L_0x06d6
            float r0 = r0.getXVelocity()
            goto L_0x06d7
        L_0x06d6:
            r0 = 0
        L_0x06d7:
            android.view.VelocityTracker r2 = r4.f1495a
            if (r2 == 0) goto L_0x06e0
            float r2 = r2.getYVelocity()
            goto L_0x06e1
        L_0x06e0:
            r2 = 0
        L_0x06e1:
            float r4 = r11.getProgress()
            int r5 = r3.f1535d
            r8 = -1
            if (r5 == r8) goto L_0x0704
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.f1526a
            float r9 = r3.f1530b
            float r10 = r3.f1524a
            float[] r12 = r3.f1528a
            r25 = r8
            r26 = r5
            r27 = r4
            r28 = r9
            r29 = r10
            r30 = r12
            r25.k(r26, r27, r28, r29, r30)
            r8 = 0
            r9 = 1
            goto L_0x071d
        L_0x0704:
            int r5 = r11.getWidth()
            int r8 = r11.getHeight()
            int r5 = java.lang.Math.min(r5, r8)
            float r5 = (float) r5
            float r8 = r3.d
            float r8 = r8 * r5
            r9 = 1
            r15[r9] = r8
            float r8 = r3.c
            float r5 = r5 * r8
            r8 = 0
            r15[r8] = r5
        L_0x071d:
            float r5 = r3.c
            r10 = r15[r8]
            r8 = r15[r9]
            r9 = 0
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x072a
            float r0 = r0 / r10
            goto L_0x072c
        L_0x072a:
            float r0 = r2 / r8
        L_0x072c:
            boolean r2 = java.lang.Float.isNaN(r0)
            if (r2 != 0) goto L_0x0738
            r2 = 1077936128(0x40400000, float:3.0)
            float r2 = r0 / r2
            float r2 = r2 + r4
            goto L_0x0739
        L_0x0738:
            r2 = r4
        L_0x0739:
            r5 = 0
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x078c
            r5 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x078c
            int r5 = r3.f1533c
            r7 = 3
            if (r5 == r7) goto L_0x078c
            double r7 = (double) r2
            r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0752
            r2 = 0
            goto L_0x0754
        L_0x0752:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0754:
            r7 = 6
            if (r5 != r7) goto L_0x0764
            float r2 = r4 + r0
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0762
            float r0 = java.lang.Math.abs(r0)
        L_0x0762:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0764:
            int r5 = r3.f1533c
            r7 = 7
            if (r5 != r7) goto L_0x0777
            float r2 = r4 + r0
            r5 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0776
            float r0 = java.lang.Math.abs(r0)
            float r0 = -r0
        L_0x0776:
            r2 = 0
        L_0x0777:
            int r3 = r3.f1533c
            r11.r(r2, r0, r3)
            r0 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0787
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x058c
        L_0x0787:
            r11.setState(r6)
            goto L_0x058c
        L_0x078c:
            r0 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0797
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x058c
        L_0x0797:
            r11.setState(r6)
            goto L_0x058c
        L_0x079c:
            float r0 = r34.getRawX()
            r3.e = r0
            float r0 = r34.getRawY()
            r3.f = r0
            r0 = 0
            r3.f1532b = r0
            goto L_0x07b0
        L_0x07ac:
            r31 = r2
            goto L_0x058c
        L_0x07b0:
            float r2 = r34.getRawX()
            r3 = r31
            r3.a = r2
            float r2 = r34.getRawY()
            r3.b = r2
            int r1 = r34.getAction()
            r2 = 1
            if (r1 != r2) goto L_0x07e2
            androidx.constraintlayout.motion.widget.MotionLayout$g r1 = r3.f1505a
            if (r1 == 0) goto L_0x07e2
            android.view.VelocityTracker r2 = r1.f1495a
            if (r2 == 0) goto L_0x07d4
            r2.recycle()
            r2 = 0
            r1.f1495a = r2
            goto L_0x07d5
        L_0x07d4:
            r2 = 0
        L_0x07d5:
            r3.f1505a = r2
            r2 = r33
            int r1 = r2.f1462d
            r4 = -1
            if (r1 == r4) goto L_0x07e4
            r3.a(r1, r2)
            goto L_0x07e4
        L_0x07e2:
            r2 = r33
        L_0x07e4:
            androidx.constraintlayout.motion.widget.a r1 = r2.f1447a
            androidx.constraintlayout.motion.widget.a$b r1 = r1.f1507a
            int r3 = r1.j
            r4 = 4
            r3 = r3 & r4
            if (r3 == 0) goto L_0x07f0
            r10 = 1
            goto L_0x07f1
        L_0x07f0:
            r10 = r0
        L_0x07f1:
            if (r10 == 0) goto L_0x07f8
            androidx.constraintlayout.motion.widget.b r0 = r1.f1518a
            boolean r0 = r0.f1532b
            return r0
        L_0x07f8:
            r0 = 1
            return r0
        L_0x07fa:
            r2 = r0
            boolean r0 = super.onTouchEvent(r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1452a == null) {
                this.f1452a = new CopyOnWriteArrayList<>();
            }
            this.f1452a.add(motionHelper);
            if (motionHelper.f1431a) {
                if (this.f1450a == null) {
                    this.f1450a = new ArrayList<>();
                }
                this.f1450a.add(motionHelper);
            }
            if (motionHelper.b) {
                if (this.f1456b == null) {
                    this.f1456b = new ArrayList<>();
                }
                this.f1456b.add(motionHelper);
            }
            if (motionHelper instanceof MotionEffect) {
                if (this.f1460c == null) {
                    this.f1460c = new ArrayList<>();
                }
                this.f1460c.add(motionHelper);
            }
        }
    }

    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f1450a;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f1456b;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void p() {
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if (this.f1445a != null || ((copyOnWriteArrayList = this.f1452a) != null && !copyOnWriteArrayList.isEmpty())) {
            ArrayList<Integer> arrayList = this.f1464d;
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                i iVar = this.f1445a;
                if (iVar != null) {
                    iVar.c(next.intValue());
                }
                CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.f1452a;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<i> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().c(next.intValue());
                    }
                }
            }
            arrayList.clear();
        }
    }

    public final void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = null;
    }

    public final void q() {
        this.f1443a.f();
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r1 != 7) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if ((((r4 * r6) - (((r5 * r6) * r6) / 2.0f)) + r1) > 1.0f) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        if ((((((r5 * r3) * r3) / 2.0f) + (r4 * r3)) + r1) < 0.0f) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(float r16, float r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r4 = r17
            r1 = r18
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            if (r2 != 0) goto L_0x000c
            return
        L_0x000c:
            float r2 = r0.d
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0013
            return
        L_0x0013:
            r2 = 1
            r0.f1465d = r2
            long r5 = r15.getNanoTime()
            r0.f1433a = r5
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            int r3 = r3.c()
            float r3 = (float) r3
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r3 / r5
            r0.b = r5
            r0.e = r8
            r0.f1461c = r2
            cy r9 = r0.f1448a
            r10 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 7
            r7 = 6
            r11 = 2
            r12 = 0
            if (r1 == 0) goto L_0x00c9
            if (r1 == r2) goto L_0x00c9
            if (r1 == r11) goto L_0x00c9
            r13 = 4
            androidx.constraintlayout.motion.widget.MotionLayout$d r14 = r0.f1441a
            if (r1 == r13) goto L_0x00b7
            r13 = 5
            if (r1 == r13) goto L_0x004a
            if (r1 == r7) goto L_0x00c9
            if (r1 == r6) goto L_0x00c9
            goto L_0x0160
        L_0x004a:
            float r1 = r0.d
            androidx.constraintlayout.motion.widget.a r5 = r0.f1447a
            float r5 = r5.g()
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            r7 = 1073741824(0x40000000, float:2.0)
            if (r6 <= 0) goto L_0x0066
            float r6 = r4 / r5
            float r11 = r4 * r6
            float r5 = r5 * r6
            float r5 = r5 * r6
            float r5 = r5 / r7
            float r11 = r11 - r5
            float r11 = r11 + r1
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            goto L_0x0075
        L_0x0066:
            float r3 = -r4
            float r3 = r3 / r5
            float r6 = r4 * r3
            float r5 = r5 * r3
            float r5 = r5 * r3
            float r5 = r5 / r7
            float r5 = r5 + r6
            float r5 = r5 + r1
            int r1 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r2 = r12
        L_0x0075:
            if (r2 == 0) goto L_0x0089
            float r1 = r0.d
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            float r2 = r2.g()
            r14.a = r4
            r14.b = r1
            r14.c = r2
            r0.f1435a = r14
            goto L_0x0160
        L_0x0089:
            cy r1 = r0.f1448a
            float r2 = r0.d
            float r5 = r0.b
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            float r6 = r3.g()
            androidx.constraintlayout.motion.widget.a r3 = r0.f1447a
            androidx.constraintlayout.motion.widget.a$b r3 = r3.f1507a
            if (r3 == 0) goto L_0x00a3
            androidx.constraintlayout.motion.widget.b r3 = r3.f1518a
            if (r3 == 0) goto L_0x00a3
            float r3 = r3.g
            r7 = r3
            goto L_0x00a4
        L_0x00a3:
            r7 = r10
        L_0x00a4:
            r3 = r16
            r4 = r17
            r1.b(r2, r3, r4, r5, r6, r7)
            r0.a = r10
            int r1 = r0.f1462d
            r0.e = r8
            r0.f1462d = r1
            r0.f1435a = r9
            goto L_0x0160
        L_0x00b7:
            float r1 = r0.d
            androidx.constraintlayout.motion.widget.a r2 = r0.f1447a
            float r2 = r2.g()
            r14.a = r4
            r14.b = r1
            r14.c = r2
            r0.f1435a = r14
            goto L_0x0160
        L_0x00c9:
            if (r1 == r2) goto L_0x00d4
            if (r1 != r6) goto L_0x00ce
            goto L_0x00d4
        L_0x00ce:
            if (r1 == r11) goto L_0x00d2
            if (r1 != r7) goto L_0x00d5
        L_0x00d2:
            r8 = r3
            goto L_0x00d5
        L_0x00d4:
            r8 = r10
        L_0x00d5:
            androidx.constraintlayout.motion.widget.a r1 = r0.f1447a
            androidx.constraintlayout.motion.widget.a$b r2 = r1.f1507a
            if (r2 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.b r3 = r2.f1518a
            if (r3 == 0) goto L_0x00e2
            int r3 = r3.f1541j
            goto L_0x00e3
        L_0x00e2:
            r3 = r12
        L_0x00e3:
            if (r3 != 0) goto L_0x0102
            float r2 = r0.d
            float r6 = r1.g()
            androidx.constraintlayout.motion.widget.a r1 = r0.f1447a
            androidx.constraintlayout.motion.widget.a$b r1 = r1.f1507a
            if (r1 == 0) goto L_0x00f9
            androidx.constraintlayout.motion.widget.b r1 = r1.f1518a
            if (r1 == 0) goto L_0x00f9
            float r1 = r1.g
            r7 = r1
            goto L_0x00fa
        L_0x00f9:
            r7 = r10
        L_0x00fa:
            r1 = r9
            r3 = r8
            r4 = r17
            r1.b(r2, r3, r4, r5, r6, r7)
            goto L_0x0158
        L_0x0102:
            float r1 = r0.d
            if (r2 == 0) goto L_0x010d
            androidx.constraintlayout.motion.widget.b r3 = r2.f1518a
            if (r3 == 0) goto L_0x010d
            float r3 = r3.l
            goto L_0x010e
        L_0x010d:
            r3 = r10
        L_0x010e:
            if (r2 == 0) goto L_0x0117
            androidx.constraintlayout.motion.widget.b r4 = r2.f1518a
            if (r4 == 0) goto L_0x0117
            float r4 = r4.m
            goto L_0x0118
        L_0x0117:
            r4 = r10
        L_0x0118:
            if (r2 == 0) goto L_0x0121
            androidx.constraintlayout.motion.widget.b r5 = r2.f1518a
            if (r5 == 0) goto L_0x0121
            float r5 = r5.k
            goto L_0x0122
        L_0x0121:
            r5 = r10
        L_0x0122:
            if (r2 == 0) goto L_0x012b
            androidx.constraintlayout.motion.widget.b r6 = r2.f1518a
            if (r6 == 0) goto L_0x012b
            float r6 = r6.n
            goto L_0x012c
        L_0x012b:
            r6 = r10
        L_0x012c:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.motion.widget.b r2 = r2.f1518a
            if (r2 == 0) goto L_0x0135
            int r2 = r2.f1540i
            goto L_0x0136
        L_0x0135:
            r2 = r12
        L_0x0136:
            Gx r7 = r9.a
            if (r7 != 0) goto L_0x0141
            Gx r7 = new Gx
            r7.<init>()
            r9.a = r7
        L_0x0141:
            Gx r7 = r9.a
            r9.f2861a = r7
            double r13 = (double) r8
            r7.c = r13
            double r13 = (double) r5
            r7.a = r13
            r7.f241b = r1
            double r4 = (double) r4
            r7.b = r4
            r7.d = r3
            r7.e = r6
            r7.f240a = r2
            r7.f239a = r10
        L_0x0158:
            int r1 = r0.f1462d
            r0.e = r8
            r0.f1462d = r1
            r0.f1435a = r9
        L_0x0160:
            r0.f1457b = r12
            long r1 = r15.getNanoTime()
            r0.f1433a = r1
            r15.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.r(float, float, int):void");
    }

    public final void requestLayout() {
        a aVar;
        a.b bVar;
        if (!this.f1471g && this.f1462d == -1 && (aVar = this.f1447a) != null && (bVar = aVar.f1507a) != null) {
            int i2 = bVar.i;
            if (i2 != 0) {
                if (i2 == 2) {
                    int childCount = getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        this.f1451a.get(getChildAt(i3)).f610a = true;
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public final void s() {
        f(1.0f);
        this.f1449a = null;
    }

    public void setDebugMode(int i2) {
        this.f1472h = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.f1475i = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.f1454a = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.f1447a != null) {
            setState(j.MOVING);
            Interpolator e2 = this.f1447a.e();
            if (e2 != null) {
                setProgress(e2.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.f1456b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1456b.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.f1450a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1450a.get(i2).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.f1444a == null) {
                this.f1444a = new h();
            }
            h hVar = this.f1444a;
            hVar.a = f2;
            hVar.b = f3;
            return;
        }
        setProgress(f2);
        setState(j.MOVING);
        this.a = f3;
        float f4 = 0.0f;
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            if (i2 > 0) {
                f4 = 1.0f;
            }
            f(f4);
        } else if (f2 != 0.0f && f2 != 1.0f) {
            if (f2 > 0.5f) {
                f4 = 1.0f;
            }
            f(f4);
        }
    }

    public void setScene(a aVar) {
        b bVar;
        this.f1447a = aVar;
        boolean isRtl = isRtl();
        aVar.c = isRtl;
        a.b bVar2 = aVar.f1507a;
        if (!(bVar2 == null || (bVar = bVar2.f1518a) == null)) {
            bVar.c(isRtl);
        }
        q();
    }

    public void setStartState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.f1444a == null) {
                this.f1444a = new h();
            }
            h hVar = this.f1444a;
            hVar.f1496a = i2;
            hVar.f1498b = i2;
            return;
        }
        this.f1462d = i2;
    }

    public void setState(j jVar) {
        j jVar2 = j.FINISHED;
        if (jVar != jVar2 || this.f1462d != -1) {
            j jVar3 = this.f1446a;
            this.f1446a = jVar;
            j jVar4 = j.MOVING;
            if (jVar3 == jVar4 && jVar == jVar4) {
                i();
            }
            int ordinal = jVar3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (jVar == jVar4) {
                    i();
                }
                if (jVar == jVar2) {
                    j();
                }
            } else if (ordinal == 2 && jVar == jVar2) {
                j();
            }
        }
    }

    public void setTransition(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.f1444a == null) {
                this.f1444a = new h();
            }
            h hVar = this.f1444a;
            hVar.f1496a = i2;
            hVar.f1498b = i3;
            return;
        }
        a aVar = this.f1447a;
        if (aVar != null) {
            this.f1458c = i2;
            this.f1466e = i3;
            aVar.o(i2, i3);
            this.f1443a.e(this.f1447a.b(i2), this.f1447a.b(i3));
            q();
            this.d = 0.0f;
            f(0.0f);
        }
    }

    public void setTransitionDuration(int i2) {
        a aVar = this.f1447a;
        if (aVar != null) {
            a.b bVar = aVar.f1507a;
            if (bVar != null) {
                bVar.f = Math.max(i2, 8);
            } else {
                aVar.f1500a = i2;
            }
        }
    }

    public void setTransitionListener(i iVar) {
        this.f1445a = iVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1444a == null) {
            this.f1444a = new h();
        }
        h hVar = this.f1444a;
        hVar.getClass();
        hVar.a = bundle.getFloat("motion.progress");
        hVar.b = bundle.getFloat("motion.velocity");
        hVar.f1496a = bundle.getInt("motion.StartState");
        hVar.f1498b = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.f1444a.a();
        }
    }

    public final void t(int i2, int i3) {
        float f2;
        Ux ux;
        a aVar = this.f1447a;
        if (!(aVar == null || (ux = aVar.f1501a) == null)) {
            int i4 = this.f1462d;
            float f3 = (float) -1;
            Ux.a aVar2 = ux.f584a.get(i2);
            if (aVar2 == null) {
                i4 = i2;
            } else {
                int i5 = (f3 > -1.0f ? 1 : (f3 == -1.0f ? 0 : -1));
                ArrayList<Ux.b> arrayList = aVar2.f585a;
                int i6 = aVar2.b;
                if (i5 != 0 && i5 != 0) {
                    Iterator<Ux.b> it = arrayList.iterator();
                    Ux.b bVar = null;
                    while (true) {
                        if (it.hasNext()) {
                            Ux.b next = it.next();
                            if (next.a(f3, f3)) {
                                if (i4 == next.f586a) {
                                    break;
                                }
                                bVar = next;
                            }
                        } else if (bVar != null) {
                            i4 = bVar.f586a;
                        }
                    }
                } else if (i6 != i4) {
                    Iterator<Ux.b> it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (i4 == it2.next().f586a) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                i4 = i6;
            }
            if (i4 != -1) {
                i2 = i4;
            }
        }
        int i7 = this.f1462d;
        if (i7 != i2) {
            if (this.f1458c == i2) {
                f(0.0f);
                if (i3 > 0) {
                    this.b = ((float) i3) / 1000.0f;
                }
            } else if (this.f1466e == i2) {
                f(1.0f);
                if (i3 > 0) {
                    this.b = ((float) i3) / 1000.0f;
                }
            } else {
                this.f1466e = i2;
                if (i7 != -1) {
                    setTransition(i7, i2);
                    f(1.0f);
                    this.d = 0.0f;
                    s();
                    if (i3 > 0) {
                        this.b = ((float) i3) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.f1465d = false;
                this.e = 1.0f;
                this.c = 0.0f;
                this.d = 0.0f;
                this.f1455b = getNanoTime();
                this.f1433a = getNanoTime();
                this.f1457b = false;
                this.f1435a = null;
                if (i3 == -1) {
                    this.b = ((float) this.f1447a.c()) / 1000.0f;
                }
                this.f1458c = -1;
                this.f1447a.o(-1, this.f1466e);
                SparseArray sparseArray = new SparseArray();
                if (i3 == 0) {
                    this.b = ((float) this.f1447a.c()) / 1000.0f;
                } else if (i3 > 0) {
                    this.b = ((float) i3) / 1000.0f;
                }
                int childCount = getChildCount();
                HashMap<View, Vl> hashMap = this.f1451a;
                hashMap.clear();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    hashMap.put(childAt, new Vl(childAt));
                    sparseArray.put(childAt.getId(), hashMap.get(childAt));
                }
                this.f1461c = true;
                ConstraintSet b2 = this.f1447a.b(i2);
                f fVar = this.f1443a;
                fVar.e((ConstraintSet) null, b2);
                q();
                fVar.a();
                int childCount2 = getChildCount();
                for (int i9 = 0; i9 < childCount2; i9++) {
                    View childAt2 = getChildAt(i9);
                    Vl vl = hashMap.get(childAt2);
                    if (vl != null) {
                        Xl xl = vl.f604a;
                        xl.f679a = 0.0f;
                        xl.b = 0.0f;
                        xl.i(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                        Tl tl = vl.f603a;
                        tl.getClass();
                        childAt2.getX();
                        childAt2.getY();
                        childAt2.getWidth();
                        childAt2.getHeight();
                        tl.f(childAt2);
                    }
                }
                int width = getWidth();
                int height = getHeight();
                if (this.f1460c != null) {
                    for (int i10 = 0; i10 < childCount; i10++) {
                        Vl vl2 = hashMap.get(getChildAt(i10));
                        if (vl2 != null) {
                            this.f1447a.f(vl2);
                        }
                    }
                    Iterator<MotionHelper> it3 = this.f1460c.iterator();
                    while (it3.hasNext()) {
                        it3.next().u(this, hashMap);
                    }
                    for (int i11 = 0; i11 < childCount; i11++) {
                        Vl vl3 = hashMap.get(getChildAt(i11));
                        if (vl3 != null) {
                            vl3.h(width, height, getNanoTime());
                        }
                    }
                } else {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        Vl vl4 = hashMap.get(getChildAt(i12));
                        if (vl4 != null) {
                            this.f1447a.f(vl4);
                            vl4.h(width, height, getNanoTime());
                        }
                    }
                }
                a.b bVar2 = this.f1447a.f1507a;
                if (bVar2 != null) {
                    f2 = bVar2.a;
                } else {
                    f2 = 0.0f;
                }
                if (f2 != 0.0f) {
                    float f4 = Float.MAX_VALUE;
                    float f5 = -3.4028235E38f;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        Xl xl2 = hashMap.get(getChildAt(i13)).f619b;
                        float f6 = xl2.d + xl2.c;
                        f4 = Math.min(f4, f6);
                        f5 = Math.max(f5, f6);
                    }
                    for (int i14 = 0; i14 < childCount; i14++) {
                        Vl vl5 = hashMap.get(getChildAt(i14));
                        Xl xl3 = vl5.f619b;
                        float f7 = xl3.c;
                        float f8 = xl3.d;
                        vl5.c = 1.0f / (1.0f - f2);
                        vl5.b = f2 - ((((f7 + f8) - f4) * f2) / (f5 - f4));
                    }
                }
                this.c = 0.0f;
                this.d = 0.0f;
                this.f1461c = true;
                invalidate();
            }
        }
    }

    public final String toString() {
        Context context = getContext();
        return C0175e8.c(context, this.f1458c) + "->" + C0175e8.c(context, this.f1466e) + " (pos:" + this.d + " Dpos/Dt:" + this.a;
    }

    public final void u(int i2, ConstraintSet constraintSet) {
        a aVar = this.f1447a;
        if (aVar != null) {
            aVar.f1502a.put(i2, constraintSet);
        }
        this.f1443a.e(this.f1447a.b(this.f1458c), this.f1447a.b(this.f1466e));
        q();
        if (this.f1462d == i2) {
            constraintSet.b(this);
        }
    }

    public final void v(int i2, View... viewArr) {
        ConstraintSet constraintSet;
        a aVar = this.f1447a;
        if (aVar != null) {
            d dVar = aVar.f1508a;
            dVar.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator<c> it = dVar.f1558a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a == i2) {
                    for (View view : viewArr) {
                        if (next.b(view)) {
                            arrayList.add(view);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                        MotionLayout motionLayout = dVar.a;
                        int currentState = motionLayout.getCurrentState();
                        if (next.d == 2) {
                            next.a(dVar, dVar.a, currentState, (ConstraintSet) null, viewArr2);
                        } else if (currentState == -1) {
                            motionLayout.toString();
                        } else {
                            a aVar2 = motionLayout.f1447a;
                            if (aVar2 == null) {
                                constraintSet = null;
                            } else {
                                constraintSet = aVar2.b(currentState);
                            }
                            ConstraintSet constraintSet2 = constraintSet;
                            if (constraintSet2 != null) {
                                next.a(dVar, dVar.a, currentState, constraintSet2, viewArr2);
                            }
                        }
                        arrayList.clear();
                    }
                }
            }
        }
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!(!this.f1467e && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.f1467e = false;
    }

    public void setState(int i2, int i3, int i4) {
        setState(j.SETUP);
        this.f1462d = i2;
        this.f1458c = -1;
        this.f1466e = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.b((float) i3, (float) i4, i2);
            return;
        }
        a aVar = this.f1447a;
        if (aVar != null) {
            aVar.b(i2).b(this);
        }
    }

    public void setProgress(float f2) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (!isAttachedToWindow()) {
            if (this.f1444a == null) {
                this.f1444a = new h();
            }
            this.f1444a.a = f2;
            return;
        }
        j jVar = j.FINISHED;
        j jVar2 = j.MOVING;
        if (i2 <= 0) {
            if (this.d == 1.0f && this.f1462d == this.f1466e) {
                setState(jVar2);
            }
            this.f1462d = this.f1458c;
            if (this.d == 0.0f) {
                setState(jVar);
            }
        } else if (f2 >= 1.0f) {
            if (this.d == 0.0f && this.f1462d == this.f1458c) {
                setState(jVar2);
            }
            this.f1462d = this.f1466e;
            if (this.d == 1.0f) {
                setState(jVar);
            }
        } else {
            this.f1462d = -1;
            setState(jVar2);
        }
        if (this.f1447a != null) {
            this.f1457b = true;
            this.e = f2;
            this.c = f2;
            this.f1455b = -1;
            this.f1433a = -1;
            this.f1435a = null;
            this.f1461c = true;
            invalidate();
        }
    }

    public void setTransition(int i2) {
        float f2;
        if (this.f1447a != null) {
            a.b l2 = l(i2);
            this.f1458c = l2.c;
            this.f1466e = l2.b;
            if (!isAttachedToWindow()) {
                if (this.f1444a == null) {
                    this.f1444a = new h();
                }
                h hVar = this.f1444a;
                hVar.f1496a = this.f1458c;
                hVar.f1498b = this.f1466e;
                return;
            }
            int i3 = this.f1462d;
            if (i3 == this.f1458c) {
                f2 = 0.0f;
            } else {
                f2 = i3 == this.f1466e ? 1.0f : Float.NaN;
            }
            a aVar = this.f1447a;
            aVar.f1507a = l2;
            b bVar = l2.f1518a;
            if (bVar != null) {
                bVar.c(aVar.c);
            }
            this.f1443a.e(this.f1447a.b(this.f1458c), this.f1447a.b(this.f1466e));
            q();
            if (this.d != f2) {
                if (f2 == 0.0f) {
                    g(true);
                    this.f1447a.b(this.f1458c).b(this);
                } else if (f2 == 1.0f) {
                    g(false);
                    this.f1447a.b(this.f1466e).b(this);
                }
            }
            this.d = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                C0175e8.b();
                f(0.0f);
                return;
            }
            setProgress(f2);
        }
    }

    public void setTransition(a.b bVar) {
        int i2;
        long j2;
        b bVar2;
        a aVar = this.f1447a;
        aVar.f1507a = bVar;
        if (!(bVar == null || (bVar2 = bVar.f1518a) == null)) {
            bVar2.c(aVar.c);
        }
        setState(j.SETUP);
        int i3 = this.f1462d;
        a.b bVar3 = this.f1447a.f1507a;
        int i4 = -1;
        if (bVar3 == null) {
            i2 = -1;
        } else {
            i2 = bVar3.b;
        }
        if (i3 == i2) {
            this.d = 1.0f;
            this.c = 1.0f;
            this.e = 1.0f;
        } else {
            this.d = 0.0f;
            this.c = 0.0f;
            this.e = 0.0f;
        }
        boolean z = true;
        if ((bVar.j & 1) == 0) {
            z = false;
        }
        if (z) {
            j2 = -1;
        } else {
            j2 = getNanoTime();
        }
        this.f1455b = j2;
        int h2 = this.f1447a.h();
        a aVar2 = this.f1447a;
        a.b bVar4 = aVar2.f1507a;
        if (bVar4 != null) {
            i4 = bVar4.b;
        }
        if (h2 != this.f1458c || i4 != this.f1466e) {
            this.f1458c = h2;
            this.f1466e = i4;
            aVar2.o(h2, i4);
            ConstraintSet b2 = this.f1447a.b(this.f1458c);
            ConstraintSet b3 = this.f1447a.b(this.f1466e);
            f fVar = this.f1443a;
            fVar.e(b2, b3);
            int i5 = this.f1458c;
            int i6 = this.f1466e;
            fVar.a = i5;
            fVar.b = i6;
            fVar.f();
            q();
        }
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new HashMap();
        this.f1437a = new Rect();
        this.f1475i = false;
        this.f1446a = j.UNDEFINED;
        this.f1443a = new f();
        this.f1477j = false;
        this.f1438a = new RectF();
        this.f1439a = null;
        this.f1436a = null;
        this.f1464d = new ArrayList<>();
        n(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new HashMap();
        this.f1437a = new Rect();
        this.f1475i = false;
        this.f1446a = j.UNDEFINED;
        this.f1443a = new f();
        this.f1477j = false;
        this.f1438a = new RectF();
        this.f1439a = null;
        this.f1436a = null;
        this.f1464d = new ArrayList<>();
        n(attributeSet);
    }
}
