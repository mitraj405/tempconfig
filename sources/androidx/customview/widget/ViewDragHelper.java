package androidx.customview.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.f;
import com.google.logging.type.LogSeverity;
import java.util.Arrays;
import java.util.WeakHashMap;

public final class ViewDragHelper {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final float f1875a;

    /* renamed from: a  reason: collision with other field name */
    public int f1876a;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f1877a;

    /* renamed from: a  reason: collision with other field name */
    public View f1878a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewGroup f1879a;

    /* renamed from: a  reason: collision with other field name */
    public final OverScroller f1880a;

    /* renamed from: a  reason: collision with other field name */
    public final Callback f1881a;

    /* renamed from: a  reason: collision with other field name */
    public final b f1882a = new b();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1883a;

    /* renamed from: a  reason: collision with other field name */
    public float[] f1884a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f1885a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f1886b;

    /* renamed from: b  reason: collision with other field name */
    public float[] f1887b;

    /* renamed from: b  reason: collision with other field name */
    public int[] f1888b;
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public float[] f1889c;

    /* renamed from: c  reason: collision with other field name */
    public int[] f1890c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public float[] f1891d;
    public int e;
    public final int f;
    public int g;

    public class a implements Interpolator {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            ViewDragHelper.this.r(0);
        }
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f1879a = viewGroup;
            this.f1881a = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f = i;
            this.e = i;
            this.f1886b = viewConfiguration.getScaledTouchSlop();
            this.f1875a = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.b = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1880a = new OverScroller(context, a);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public static ViewDragHelper i(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper viewDragHelper = new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
        viewDragHelper.f1886b = (int) ((1.0f / f2) * ((float) viewDragHelper.f1886b));
        return viewDragHelper;
    }

    public static boolean l(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final void a() {
        b();
        if (this.f1876a == 2) {
            OverScroller overScroller = this.f1880a;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            overScroller.abortAnimation();
            int currX2 = overScroller.getCurrX();
            int currY2 = overScroller.getCurrY();
            this.f1881a.onViewPositionChanged(this.f1878a, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        r(0);
    }

    public final void b() {
        this.c = -1;
        float[] fArr = this.f1884a;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1887b, 0.0f);
            Arrays.fill(this.f1889c, 0.0f);
            Arrays.fill(this.f1891d, 0.0f);
            Arrays.fill(this.f1885a, 0);
            Arrays.fill(this.f1888b, 0);
            Arrays.fill(this.f1890c, 0);
            this.d = 0;
        }
        VelocityTracker velocityTracker = this.f1877a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1877a = null;
        }
    }

    public final void c(int i, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f1879a;
        if (parent == viewGroup) {
            this.f1878a = view;
            this.c = i;
            this.f1881a.onViewCaptured(view, i);
            r(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public final boolean d(float f2, float f3, int i, int i2) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f1885a[i] & i2) != i2 || (this.g & i2) == 0 || (this.f1890c[i] & i2) == i2 || (this.f1888b[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f1886b;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1881a.onEdgeLock(i2)) {
            int[] iArr = this.f1890c;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f1888b[i] & i2) != 0 || abs <= ((float) this.f1886b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean e(float f2, float f3, View view) {
        boolean z;
        boolean z2;
        if (view == null) {
            return false;
        }
        Callback callback = this.f1881a;
        if (callback.getViewHorizontalDragRange(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (callback.getViewVerticalDragRange(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            float f4 = (f3 * f3) + (f2 * f2);
            int i = this.f1886b;
            if (f4 > ((float) (i * i))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.f1886b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.f1886b)) {
            return false;
        } else {
            return true;
        }
    }

    public final void f(int i) {
        float[] fArr = this.f1884a;
        if (fArr != null) {
            int i2 = this.d;
            boolean z = true;
            int i3 = 1 << i;
            if ((i3 & i2) == 0) {
                z = false;
            }
            if (z) {
                fArr[i] = 0.0f;
                this.f1887b[i] = 0.0f;
                this.f1889c[i] = 0.0f;
                this.f1891d[i] = 0.0f;
                this.f1885a[i] = 0;
                this.f1888b[i] = 0;
                this.f1890c[i] = 0;
                this.d = (~i3) & i2;
            }
        }
    }

    public final int g(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f1879a.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f) * 0.47123894f))) * f2) + f2;
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, LogSeverity.CRITICAL_VALUE);
    }

    public final boolean h() {
        if (this.f1876a == 2) {
            OverScroller overScroller = this.f1880a;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f1878a.getLeft();
            int top = currY - this.f1878a.getTop();
            if (left != 0) {
                View view = this.f1878a;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f1878a;
                WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
                view2.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1881a.onViewPositionChanged(this.f1878a, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f1879a.post(this.f1882a);
            }
        }
        if (this.f1876a == 2) {
            return true;
        }
        return false;
    }

    public final View j(int i, int i2) {
        ViewGroup viewGroup = this.f1879a;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(this.f1881a.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            android.view.View r0 = r10.f1878a
            int r2 = r0.getLeft()
            android.view.View r0 = r10.f1878a
            int r3 = r0.getTop()
            int r4 = r11 - r2
            int r5 = r12 - r3
            android.widget.OverScroller r1 = r10.f1880a
            r11 = 0
            if (r4 != 0) goto L_0x001e
            if (r5 != 0) goto L_0x001e
            r1.abortAnimation()
            r10.r(r11)
            return r11
        L_0x001e:
            android.view.View r12 = r10.f1878a
            float r0 = r10.b
            int r0 = (int) r0
            float r6 = r10.f1875a
            int r6 = (int) r6
            int r7 = java.lang.Math.abs(r13)
            if (r7 >= r0) goto L_0x002e
            r13 = r11
            goto L_0x0035
        L_0x002e:
            if (r7 <= r6) goto L_0x0035
            if (r13 <= 0) goto L_0x0034
            r13 = r6
            goto L_0x0035
        L_0x0034:
            int r13 = -r6
        L_0x0035:
            float r0 = r10.b
            int r0 = (int) r0
            int r7 = java.lang.Math.abs(r14)
            if (r7 >= r0) goto L_0x003f
            goto L_0x0046
        L_0x003f:
            if (r7 <= r6) goto L_0x0047
            if (r14 <= 0) goto L_0x0045
            r14 = r6
            goto L_0x0047
        L_0x0045:
            int r11 = -r6
        L_0x0046:
            r14 = r11
        L_0x0047:
            int r11 = java.lang.Math.abs(r4)
            int r0 = java.lang.Math.abs(r5)
            int r6 = java.lang.Math.abs(r13)
            int r7 = java.lang.Math.abs(r14)
            int r8 = r6 + r7
            int r9 = r11 + r0
            if (r13 == 0) goto L_0x0060
            float r11 = (float) r6
            float r6 = (float) r8
            goto L_0x0062
        L_0x0060:
            float r11 = (float) r11
            float r6 = (float) r9
        L_0x0062:
            float r11 = r11 / r6
            if (r14 == 0) goto L_0x0068
            float r0 = (float) r7
            float r6 = (float) r8
            goto L_0x006a
        L_0x0068:
            float r0 = (float) r0
            float r6 = (float) r9
        L_0x006a:
            float r0 = r0 / r6
            androidx.customview.widget.ViewDragHelper$Callback r6 = r10.f1881a
            int r7 = r6.getViewHorizontalDragRange(r12)
            int r13 = r10.g(r4, r13, r7)
            int r12 = r6.getViewVerticalDragRange(r12)
            int r12 = r10.g(r5, r14, r12)
            float r13 = (float) r13
            float r13 = r13 * r11
            float r11 = (float) r12
            float r11 = r11 * r0
            float r11 = r11 + r13
            int r6 = (int) r11
            r1.startScroll(r2, r3, r4, r5, r6)
            r11 = 2
            r10.r(r11)
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.k(int, int, int, int):boolean");
    }

    public final void m(MotionEvent motionEvent) {
        boolean z;
        int i;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f1877a == null) {
            this.f1877a = VelocityTracker.obtain();
        }
        this.f1877a.addMovement(motionEvent2);
        int i2 = 0;
        Callback callback = this.f1881a;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent2.getPointerId(0);
            View j = j((int) x, (int) y);
            p(x, y, pointerId);
            v(pointerId, j);
            int i3 = this.f1885a[pointerId] & this.g;
            if (i3 != 0) {
                callback.onEdgeTouched(i3, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1876a == 1) {
                n();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f1876a == 1) {
                    this.f1883a = true;
                    callback.onViewReleased(this.f1878a, 0.0f, 0.0f);
                    this.f1883a = false;
                    if (this.f1876a == 1) {
                        r(0);
                    }
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent2.getPointerId(actionIndex);
                float x2 = motionEvent2.getX(actionIndex);
                float y2 = motionEvent2.getY(actionIndex);
                p(x2, y2, pointerId2);
                if (this.f1876a == 0) {
                    v(pointerId2, j((int) x2, (int) y2));
                    int i4 = this.f1885a[pointerId2] & this.g;
                    if (i4 != 0) {
                        callback.onEdgeTouched(i4, pointerId2);
                        return;
                    }
                    return;
                }
                if (l(this.f1878a, (int) x2, (int) y2)) {
                    v(pointerId2, this.f1878a);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent2.getPointerId(actionIndex);
                if (this.f1876a == 1 && pointerId3 == this.c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent2.getPointerId(i2);
                        if (pointerId4 != this.c) {
                            View j2 = j((int) motionEvent2.getX(i2), (int) motionEvent2.getY(i2));
                            View view = this.f1878a;
                            if (j2 == view && v(pointerId4, view)) {
                                i = this.c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        n();
                    }
                }
                f(pointerId3);
            }
        } else if (this.f1876a == 1) {
            int i5 = this.c;
            if ((this.d & (1 << i5)) != 0) {
                i2 = 1;
            }
            if (i2 != 0) {
                int findPointerIndex = motionEvent2.findPointerIndex(i5);
                float x3 = motionEvent2.getX(findPointerIndex);
                float y3 = motionEvent2.getY(findPointerIndex);
                float[] fArr = this.f1889c;
                int i6 = this.c;
                int i7 = (int) (x3 - fArr[i6]);
                int i8 = (int) (y3 - this.f1891d[i6]);
                int left = this.f1878a.getLeft() + i7;
                int top = this.f1878a.getTop() + i8;
                int left2 = this.f1878a.getLeft();
                int top2 = this.f1878a.getTop();
                if (i7 != 0) {
                    left = callback.clampViewPositionHorizontal(this.f1878a, left, i7);
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    this.f1878a.offsetLeftAndRight(left - left2);
                }
                int i9 = left;
                if (i8 != 0) {
                    top = callback.clampViewPositionVertical(this.f1878a, top, i8);
                    WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
                    this.f1878a.offsetTopAndBottom(top - top2);
                }
                int i10 = top;
                if (!(i7 == 0 && i8 == 0)) {
                    this.f1881a.onViewPositionChanged(this.f1878a, i9, i10, i9 - left2, i10 - top2);
                }
                q(motionEvent);
            }
        } else {
            int pointerCount2 = motionEvent.getPointerCount();
            for (int i11 = 0; i11 < pointerCount2; i11++) {
                int pointerId5 = motionEvent2.getPointerId(i11);
                if ((this.d & (1 << pointerId5)) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    float x4 = motionEvent2.getX(i11);
                    float y4 = motionEvent2.getY(i11);
                    float f2 = x4 - this.f1884a[pointerId5];
                    float f3 = y4 - this.f1887b[pointerId5];
                    o(f2, f3, pointerId5);
                    if (this.f1876a != 1) {
                        View j3 = j((int) x4, (int) y4);
                        if (e(f2, f3, j3) && v(pointerId5, j3)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            q(motionEvent);
        }
    }

    public final void n() {
        VelocityTracker velocityTracker = this.f1877a;
        float f2 = this.f1875a;
        velocityTracker.computeCurrentVelocity(1000, f2);
        float xVelocity = this.f1877a.getXVelocity(this.c);
        float f3 = this.b;
        float abs = Math.abs(xVelocity);
        float f4 = 0.0f;
        if (abs < f3) {
            xVelocity = 0.0f;
        } else if (abs > f2) {
            if (xVelocity > 0.0f) {
                xVelocity = f2;
            } else {
                xVelocity = -f2;
            }
        }
        float yVelocity = this.f1877a.getYVelocity(this.c);
        float f5 = this.b;
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f5) {
            if (abs2 > f2) {
                if (yVelocity <= 0.0f) {
                    f2 = -f2;
                }
                f4 = f2;
            } else {
                f4 = yVelocity;
            }
        }
        this.f1883a = true;
        this.f1881a.onViewReleased(this.f1878a, xVelocity, f4);
        this.f1883a = false;
        if (this.f1876a == 1) {
            r(0);
        }
    }

    public final void o(float f2, float f3, int i) {
        boolean d2 = d(f2, f3, i, 1);
        if (d(f3, f2, i, 4)) {
            d2 |= true;
        }
        if (d(f2, f3, i, 2)) {
            d2 |= true;
        }
        if (d(f3, f2, i, 8)) {
            d2 |= true;
        }
        if (d2) {
            int[] iArr = this.f1888b;
            iArr[i] = iArr[i] | d2;
            this.f1881a.onEdgeDragStarted(d2 ? 1 : 0, i);
        }
    }

    public final void p(float f2, float f3, int i) {
        float[] fArr = this.f1884a;
        int i2 = 0;
        if (fArr == null || fArr.length <= i) {
            int i3 = i + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1887b;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1889c;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1891d;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1885a;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1888b;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1890c;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1884a = fArr2;
            this.f1887b = fArr3;
            this.f1889c = fArr4;
            this.f1891d = fArr5;
            this.f1885a = iArr;
            this.f1888b = iArr2;
            this.f1890c = iArr3;
        }
        float[] fArr9 = this.f1884a;
        this.f1889c[i] = f2;
        fArr9[i] = f2;
        float[] fArr10 = this.f1887b;
        this.f1891d[i] = f3;
        fArr10[i] = f3;
        int[] iArr7 = this.f1885a;
        int i4 = (int) f2;
        int i5 = (int) f3;
        ViewGroup viewGroup = this.f1879a;
        if (i4 < viewGroup.getLeft() + this.e) {
            i2 = 1;
        }
        if (i5 < viewGroup.getTop() + this.e) {
            i2 |= 4;
        }
        if (i4 > viewGroup.getRight() - this.e) {
            i2 |= 2;
        }
        if (i5 > viewGroup.getBottom() - this.e) {
            i2 |= 8;
        }
        iArr7[i] = i2;
        this.d |= 1 << i;
    }

    public final void q(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            boolean z = true;
            if ((this.d & (1 << pointerId)) == 0) {
                z = false;
            }
            if (z) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1889c[pointerId] = x;
                this.f1891d[pointerId] = y;
            }
        }
    }

    public final void r(int i) {
        this.f1879a.removeCallbacks(this.f1882a);
        if (this.f1876a != i) {
            this.f1876a = i;
            this.f1881a.onViewDragStateChanged(i);
            if (this.f1876a == 0) {
                this.f1878a = null;
            }
        }
    }

    public final boolean s(int i, int i2) {
        if (this.f1883a) {
            return k(i, i2, (int) this.f1877a.getXVelocity(this.c), (int) this.f1877a.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        if (r13 != r12) goto L_0x00e4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            int r3 = r18.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r17.b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f1877a
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f1877a = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f1877a
            r4.addMovement(r1)
            r4 = 1
            r6 = 2
            androidx.customview.widget.ViewDragHelper$Callback r7 = r0.f1881a
            if (r2 == 0) goto L_0x0101
            if (r2 == r4) goto L_0x00fc
            if (r2 == r6) goto L_0x0070
            r8 = 3
            if (r2 == r8) goto L_0x00fc
            r8 = 5
            if (r2 == r8) goto L_0x003e
            r6 = 6
            if (r2 == r6) goto L_0x0035
            goto L_0x00ff
        L_0x0035:
            int r1 = r1.getPointerId(r3)
            r0.f(r1)
            goto L_0x00ff
        L_0x003e:
            int r2 = r1.getPointerId(r3)
            float r8 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.p(r8, r1, r2)
            int r3 = r0.f1876a
            if (r3 != 0) goto L_0x005f
            int[] r1 = r0.f1885a
            r1 = r1[r2]
            int r3 = r0.g
            r1 = r1 & r3
            if (r1 == 0) goto L_0x00ff
            r7.onEdgeTouched(r1, r2)
            goto L_0x00ff
        L_0x005f:
            if (r3 != r6) goto L_0x00ff
            int r3 = (int) r8
            int r1 = (int) r1
            android.view.View r1 = r0.j(r3, r1)
            android.view.View r3 = r0.f1878a
            if (r1 != r3) goto L_0x00ff
            r0.v(r2, r1)
            goto L_0x00ff
        L_0x0070:
            float[] r2 = r0.f1884a
            if (r2 == 0) goto L_0x00ff
            float[] r2 = r0.f1887b
            if (r2 != 0) goto L_0x007a
            goto L_0x00ff
        L_0x007a:
            int r2 = r18.getPointerCount()
            r3 = 0
        L_0x007f:
            if (r3 >= r2) goto L_0x00f8
            int r6 = r1.getPointerId(r3)
            int r8 = r0.d
            int r9 = r4 << r6
            r8 = r8 & r9
            if (r8 == 0) goto L_0x008e
            r8 = r4
            goto L_0x008f
        L_0x008e:
            r8 = 0
        L_0x008f:
            if (r8 != 0) goto L_0x0092
            goto L_0x00f5
        L_0x0092:
            float r8 = r1.getX(r3)
            float r9 = r1.getY(r3)
            float[] r10 = r0.f1884a
            r10 = r10[r6]
            float r10 = r8 - r10
            float[] r11 = r0.f1887b
            r11 = r11[r6]
            float r11 = r9 - r11
            int r8 = (int) r8
            int r9 = (int) r9
            android.view.View r8 = r0.j(r8, r9)
            if (r8 == 0) goto L_0x00b6
            boolean r9 = r0.e(r10, r11, r8)
            if (r9 == 0) goto L_0x00b6
            r9 = r4
            goto L_0x00b7
        L_0x00b6:
            r9 = 0
        L_0x00b7:
            if (r9 == 0) goto L_0x00e4
            int r12 = r8.getLeft()
            int r13 = (int) r10
            int r14 = r12 + r13
            int r13 = r7.clampViewPositionHorizontal(r8, r14, r13)
            int r14 = r8.getTop()
            int r15 = (int) r11
            int r5 = r14 + r15
            int r5 = r7.clampViewPositionVertical(r8, r5, r15)
            int r15 = r7.getViewHorizontalDragRange(r8)
            int r16 = r7.getViewVerticalDragRange(r8)
            if (r15 == 0) goto L_0x00dd
            if (r15 <= 0) goto L_0x00e4
            if (r13 != r12) goto L_0x00e4
        L_0x00dd:
            if (r16 == 0) goto L_0x00f8
            if (r16 <= 0) goto L_0x00e4
            if (r5 != r14) goto L_0x00e4
            goto L_0x00f8
        L_0x00e4:
            r0.o(r10, r11, r6)
            int r5 = r0.f1876a
            if (r5 != r4) goto L_0x00ec
            goto L_0x00f8
        L_0x00ec:
            if (r9 == 0) goto L_0x00f5
            boolean r5 = r0.v(r6, r8)
            if (r5 == 0) goto L_0x00f5
            goto L_0x00f8
        L_0x00f5:
            int r3 = r3 + 1
            goto L_0x007f
        L_0x00f8:
            r17.q(r18)
            goto L_0x00ff
        L_0x00fc:
            r17.b()
        L_0x00ff:
            r5 = 0
            goto L_0x012e
        L_0x0101:
            float r2 = r18.getX()
            float r3 = r18.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.p(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.j(r2, r3)
            android.view.View r3 = r0.f1878a
            if (r2 != r3) goto L_0x0122
            int r3 = r0.f1876a
            if (r3 != r6) goto L_0x0122
            r0.v(r1, r2)
        L_0x0122:
            int[] r2 = r0.f1885a
            r2 = r2[r1]
            int r3 = r0.g
            r2 = r2 & r3
            if (r2 == 0) goto L_0x012e
            r7.onEdgeTouched(r2, r1)
        L_0x012e:
            int r1 = r0.f1876a
            if (r1 != r4) goto L_0x0133
            goto L_0x0134
        L_0x0133:
            r4 = r5
        L_0x0134:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.t(android.view.MotionEvent):boolean");
    }

    public final boolean u(View view, int i, int i2) {
        this.f1878a = view;
        this.c = -1;
        boolean k = k(i, i2, 0, 0);
        if (!k && this.f1876a == 0 && this.f1878a != null) {
            this.f1878a = null;
        }
        return k;
    }

    public final boolean v(int i, View view) {
        if (view == this.f1878a && this.c == i) {
            return true;
        }
        if (view == null || !this.f1881a.tryCaptureView(view, i)) {
            return false;
        }
        this.c = i;
        c(i, view);
        return true;
    }

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public abstract boolean tryCaptureView(View view, int i);

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }
    }
}
