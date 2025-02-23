package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.perf.util.Constants;
import java.util.WeakHashMap;

/* compiled from: FastScroller */
public final class g extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] c = {16842919};
    public static final int[] d = new int[0];
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f2387a;

    /* renamed from: a  reason: collision with other field name */
    public final ValueAnimator f2388a;

    /* renamed from: a  reason: collision with other field name */
    public final Drawable f2389a;

    /* renamed from: a  reason: collision with other field name */
    public final StateListDrawable f2390a;

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f2391a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2392a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2393a = false;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f2394a = new int[2];
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public final int f2395b;

    /* renamed from: b  reason: collision with other field name */
    public final Drawable f2396b;

    /* renamed from: b  reason: collision with other field name */
    public final StateListDrawable f2397b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2398b = false;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f2399b = new int[2];

    /* renamed from: c  reason: collision with other field name */
    public final int f2400c;

    /* renamed from: d  reason: collision with other field name */
    public final int f2401d;
    public final int e;
    public final int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o;

    /* compiled from: FastScroller */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            g gVar = g.this;
            int i = gVar.o;
            ValueAnimator valueAnimator = gVar.f2388a;
            if (i == 1) {
                valueAnimator.cancel();
            } else if (i != 2) {
                return;
            }
            gVar.o = 3;
            valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
            valueAnimator.setDuration((long) 500);
            valueAnimator.start();
        }
    }

    /* compiled from: FastScroller */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            boolean z2;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            g gVar = g.this;
            int computeVerticalScrollRange = gVar.f2391a.computeVerticalScrollRange();
            int i3 = gVar.l;
            int i4 = computeVerticalScrollRange - i3;
            int i5 = gVar.f2387a;
            if (i4 <= 0 || i3 < i5) {
                z = false;
            } else {
                z = true;
            }
            gVar.f2393a = z;
            int computeHorizontalScrollRange = gVar.f2391a.computeHorizontalScrollRange();
            int i6 = gVar.k;
            if (computeHorizontalScrollRange - i6 <= 0 || i6 < i5) {
                z2 = false;
            } else {
                z2 = true;
            }
            gVar.f2398b = z2;
            boolean z3 = gVar.f2393a;
            if (z3 || z2) {
                if (z3) {
                    float f = (float) i3;
                    gVar.h = (int) ((((f / 2.0f) + ((float) computeVerticalScrollOffset)) * f) / ((float) computeVerticalScrollRange));
                    gVar.g = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (gVar.f2398b) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i6;
                    gVar.j = (int) ((((f3 / 2.0f) + f2) * f3) / ((float) computeHorizontalScrollRange));
                    gVar.i = Math.min(i6, (i6 * i6) / computeHorizontalScrollRange);
                }
                int i7 = gVar.m;
                if (i7 == 0 || i7 == 1) {
                    gVar.f(1);
                }
            } else if (gVar.m != 0) {
                gVar.f(0);
            }
        }
    }

    /* compiled from: FastScroller */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with other field name */
        public boolean f2402a = false;

        public c() {
        }

        public final void onAnimationCancel(Animator animator) {
            this.f2402a = true;
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.f2402a) {
                this.f2402a = false;
                return;
            }
            g gVar = g.this;
            if (((Float) gVar.f2388a.getAnimatedValue()).floatValue() == 0.0f) {
                gVar.o = 0;
                gVar.f(0);
                return;
            }
            gVar.o = 2;
            gVar.f2391a.invalidate();
        }
    }

    /* compiled from: FastScroller */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            g gVar = g.this;
            gVar.f2390a.setAlpha(floatValue);
            gVar.f2389a.setAlpha(floatValue);
            gVar.f2391a.invalidate();
        }
    }

    public g(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f2388a = ofFloat;
        this.o = 0;
        a aVar = new a();
        this.f2392a = aVar;
        b bVar = new b();
        this.f2390a = stateListDrawable;
        this.f2389a = drawable;
        this.f2397b = stateListDrawable2;
        this.f2396b = drawable2;
        this.f2400c = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f2401d = Math.max(i2, drawable.getIntrinsicWidth());
        this.e = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f2387a = i3;
        this.f2395b = i4;
        stateListDrawable.setAlpha(Constants.MAX_HOST_LENGTH);
        drawable.setAlpha(Constants.MAX_HOST_LENGTH);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.f2391a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.f2391a.removeOnItemTouchListener(this);
                this.f2391a.removeOnScrollListener(bVar);
                this.f2391a.removeCallbacks(aVar);
            }
            this.f2391a = recyclerView;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(this);
                this.f2391a.addOnItemTouchListener(this);
                this.f2391a.addOnScrollListener(bVar);
            }
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        int i2 = this.m;
        if (i2 == 1) {
            boolean e2 = e(motionEvent.getX(), motionEvent.getY());
            boolean d2 = d(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (e2 || d2)) {
                if (d2) {
                    this.n = 1;
                    this.b = (float) ((int) motionEvent.getX());
                } else if (e2) {
                    this.n = 2;
                    this.a = (float) ((int) motionEvent.getY());
                }
                f(2);
                return true;
            }
        } else if (i2 == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
        if (r9 >= 0) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        if (r5 >= 0) goto L_0x0114;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r12.m
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = r13.getAction()
            r1 = 1
            r2 = 2
            if (r0 != 0) goto L_0x0047
            float r0 = r13.getX()
            float r3 = r13.getY()
            boolean r0 = r12.e(r0, r3)
            float r3 = r13.getX()
            float r4 = r13.getY()
            boolean r3 = r12.d(r3, r4)
            if (r0 != 0) goto L_0x0029
            if (r3 == 0) goto L_0x011d
        L_0x0029:
            if (r3 == 0) goto L_0x0036
            r12.n = r1
            float r13 = r13.getX()
            int r13 = (int) r13
            float r13 = (float) r13
            r12.b = r13
            goto L_0x0042
        L_0x0036:
            if (r0 == 0) goto L_0x0042
            r12.n = r2
            float r13 = r13.getY()
            int r13 = (int) r13
            float r13 = (float) r13
            r12.a = r13
        L_0x0042:
            r12.f(r2)
            goto L_0x011d
        L_0x0047:
            int r0 = r13.getAction()
            r3 = 0
            if (r0 != r1) goto L_0x005e
            int r0 = r12.m
            if (r0 != r2) goto L_0x005e
            r13 = 0
            r12.a = r13
            r12.b = r13
            r12.f(r1)
            r12.n = r3
            goto L_0x011d
        L_0x005e:
            int r0 = r13.getAction()
            if (r0 != r2) goto L_0x011d
            int r0 = r12.m
            if (r0 != r2) goto L_0x011d
            r12.g()
            int r0 = r12.n
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = r12.f2395b
            if (r0 != r1) goto L_0x00c6
            float r0 = r13.getX()
            int[] r6 = r12.f2399b
            r6[r3] = r5
            int r7 = r12.k
            int r7 = r7 - r5
            r6[r1] = r7
            float r8 = (float) r5
            float r7 = (float) r7
            float r0 = java.lang.Math.min(r7, r0)
            float r0 = java.lang.Math.max(r8, r0)
            int r7 = r12.j
            float r7 = (float) r7
            float r7 = r7 - r0
            float r7 = java.lang.Math.abs(r7)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0097
            goto L_0x00c6
        L_0x0097:
            float r7 = r12.b
            androidx.recyclerview.widget.RecyclerView r8 = r12.f2391a
            int r8 = r8.computeHorizontalScrollRange()
            androidx.recyclerview.widget.RecyclerView r9 = r12.f2391a
            int r9 = r9.computeHorizontalScrollOffset()
            int r10 = r12.k
            r11 = r6[r1]
            r6 = r6[r3]
            int r11 = r11 - r6
            if (r11 != 0) goto L_0x00b0
        L_0x00ae:
            r6 = r3
            goto L_0x00bd
        L_0x00b0:
            float r6 = r0 - r7
            float r7 = (float) r11
            float r6 = r6 / r7
            int r8 = r8 - r10
            float r7 = (float) r8
            float r6 = r6 * r7
            int r6 = (int) r6
            int r9 = r9 + r6
            if (r9 >= r8) goto L_0x00ae
            if (r9 < 0) goto L_0x00ae
        L_0x00bd:
            if (r6 == 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView r7 = r12.f2391a
            r7.scrollBy(r6, r3)
        L_0x00c4:
            r12.b = r0
        L_0x00c6:
            int r0 = r12.n
            if (r0 != r2) goto L_0x011d
            float r13 = r13.getY()
            int[] r0 = r12.f2394a
            r0[r3] = r5
            int r2 = r12.l
            int r2 = r2 - r5
            r0[r1] = r2
            float r5 = (float) r5
            float r2 = (float) r2
            float r13 = java.lang.Math.min(r2, r13)
            float r13 = java.lang.Math.max(r5, r13)
            int r2 = r12.h
            float r2 = (float) r2
            float r2 = r2 - r13
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ee
            goto L_0x011d
        L_0x00ee:
            float r2 = r12.a
            androidx.recyclerview.widget.RecyclerView r4 = r12.f2391a
            int r4 = r4.computeVerticalScrollRange()
            androidx.recyclerview.widget.RecyclerView r5 = r12.f2391a
            int r5 = r5.computeVerticalScrollOffset()
            int r6 = r12.l
            r1 = r0[r1]
            r0 = r0[r3]
            int r1 = r1 - r0
            if (r1 != 0) goto L_0x0107
        L_0x0105:
            r0 = r3
            goto L_0x0114
        L_0x0107:
            float r0 = r13 - r2
            float r1 = (float) r1
            float r0 = r0 / r1
            int r4 = r4 - r6
            float r1 = (float) r4
            float r0 = r0 * r1
            int r0 = (int) r0
            int r5 = r5 + r0
            if (r5 >= r4) goto L_0x0105
            if (r5 < 0) goto L_0x0105
        L_0x0114:
            if (r0 == 0) goto L_0x011b
            androidx.recyclerview.widget.RecyclerView r1 = r12.f2391a
            r1.scrollBy(r3, r0)
        L_0x011b:
            r12.a = r13
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.g.c(android.view.MotionEvent):void");
    }

    public final boolean d(float f2, float f3) {
        if (f3 >= ((float) (this.l - this.e))) {
            int i2 = this.j;
            int i3 = this.i;
            if (f2 < ((float) (i2 - (i3 / 2))) || f2 > ((float) ((i3 / 2) + i2))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean e(float f2, float f3) {
        boolean z;
        RecyclerView recyclerView = this.f2391a;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (recyclerView.getLayoutDirection() == 1) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f2400c;
        if (z) {
            if (f2 > ((float) i2)) {
                return false;
            }
        } else if (f2 < ((float) (this.k - i2))) {
            return false;
        }
        int i3 = this.h;
        int i4 = this.g / 2;
        if (f3 < ((float) (i3 - i4)) || f3 > ((float) (i4 + i3))) {
            return false;
        }
        return true;
    }

    public final void f(int i2) {
        a aVar = this.f2392a;
        StateListDrawable stateListDrawable = this.f2390a;
        if (i2 == 2 && this.m != 2) {
            stateListDrawable.setState(c);
            this.f2391a.removeCallbacks(aVar);
        }
        if (i2 == 0) {
            this.f2391a.invalidate();
        } else {
            g();
        }
        if (this.m == 2 && i2 != 2) {
            stateListDrawable.setState(d);
            this.f2391a.removeCallbacks(aVar);
            this.f2391a.postDelayed(aVar, (long) 1200);
        } else if (i2 == 1) {
            this.f2391a.removeCallbacks(aVar);
            this.f2391a.postDelayed(aVar, (long) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.m = i2;
    }

    public final void g() {
        int i2 = this.o;
        ValueAnimator valueAnimator = this.f2388a;
        if (i2 != 0) {
            if (i2 == 3) {
                valueAnimator.cancel();
            } else {
                return;
            }
        }
        this.o = 1;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        valueAnimator.setDuration(500);
        valueAnimator.setStartDelay(0);
        valueAnimator.start();
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.k != this.f2391a.getWidth() || this.l != this.f2391a.getHeight()) {
            this.k = this.f2391a.getWidth();
            this.l = this.f2391a.getHeight();
            f(0);
        } else if (this.o != 0) {
            if (this.f2393a) {
                int i2 = this.k;
                int i3 = this.f2400c;
                int i4 = i2 - i3;
                int i5 = this.h;
                int i6 = this.g;
                int i7 = i5 - (i6 / 2);
                StateListDrawable stateListDrawable = this.f2390a;
                stateListDrawable.setBounds(0, 0, i3, i6);
                int i8 = this.l;
                int i9 = this.f2401d;
                Drawable drawable = this.f2389a;
                drawable.setBounds(0, 0, i9, i8);
                RecyclerView recyclerView2 = this.f2391a;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                boolean z = true;
                if (recyclerView2.getLayoutDirection() != 1) {
                    z = false;
                }
                if (z) {
                    drawable.draw(canvas);
                    canvas.translate((float) i3, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate((float) (-i3), (float) (-i7));
                } else {
                    canvas.translate((float) i4, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    stateListDrawable.draw(canvas);
                    canvas.translate((float) (-i4), (float) (-i7));
                }
            }
            if (this.f2398b) {
                int i10 = this.l;
                int i11 = this.e;
                int i12 = i10 - i11;
                int i13 = this.j;
                int i14 = this.i;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.f2397b;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.k;
                int i17 = this.f;
                Drawable drawable2 = this.f2396b;
                drawable2.setBounds(0, 0, i16, i17);
                canvas.translate(0.0f, (float) i12);
                drawable2.draw(canvas);
                canvas.translate((float) i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate((float) (-i15), (float) (-i12));
            }
        }
    }

    public final void b() {
    }
}
