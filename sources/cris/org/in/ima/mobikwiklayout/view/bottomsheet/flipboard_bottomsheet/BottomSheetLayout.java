package cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import cris.org.in.prs.ima.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class BottomSheetLayout extends BottomSheet {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public float f5289a;

    /* renamed from: a  reason: collision with other field name */
    public C0619OC f5290a;

    /* renamed from: a  reason: collision with other field name */
    public Animator f5291a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f5292a;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f5293a;

    /* renamed from: a  reason: collision with other field name */
    public View f5294a;

    /* renamed from: a  reason: collision with other field name */
    public final DecelerateInterpolator f5295a;

    /* renamed from: a  reason: collision with other field name */
    public h f5296a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f5297a;

    /* renamed from: a  reason: collision with other field name */
    public final CopyOnWriteArraySet<Xn> f5298a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5299a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public C0619OC f5300b;

    /* renamed from: b  reason: collision with other field name */
    public h f5301b;

    /* renamed from: b  reason: collision with other field name */
    public final CopyOnWriteArraySet<g> f5302b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f5303b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f5304c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5305c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f5306d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f5307d;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f5308e;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f5309f;
    public float g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f5310g;
    public final boolean h;

    public class a extends Property<BottomSheetLayout, Float> {
        public a() {
            super(Float.class, "sheetTranslation");
        }

        public final Object get(Object obj) {
            return Float.valueOf(((BottomSheetLayout) obj).f5289a);
        }

        public final void set(Object obj, Object obj2) {
            ((BottomSheetLayout) obj).setSheetTranslation(((Float) obj2).floatValue());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            BottomSheetLayout.this.e();
        }
    }

    public class c extends e {
        public c() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.a) {
                BottomSheetLayout.this.f5291a = null;
            }
        }
    }

    public class d extends e {
        public d() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.a) {
                BottomSheetLayout.this.f5291a = null;
            }
        }
    }

    public static class e extends AnimatorListenerAdapter {
        public boolean a;

        public final void onAnimationCancel(Animator animator) {
            this.a = true;
        }
    }

    public interface g {
        void a();
    }

    public enum h {
        HIDDEN,
        PEEKED,
        EXPANDED
    }

    public BottomSheetLayout(Context context) {
        super(context);
        this.f5292a = new Rect();
        this.f5296a = h.HIDDEN;
        this.f5299a = false;
        this.f5295a = new DecelerateInterpolator(1.6f);
        this.f5290a = new f();
        this.f5307d = true;
        this.f5308e = true;
        this.f5298a = new CopyOnWriteArraySet<>();
        this.f5302b = new CopyOnWriteArraySet<>();
        this.f5309f = true;
        this.f5304c = 0;
        this.h = getResources().getBoolean(R.bool.bottomsheet_is_tablet);
        getResources().getDimensionPixelSize(R.dimen.bottomsheet_default_sheet_width);
        this.f5306d = 0;
        g();
    }

    private float getDefaultPeekTranslation() {
        boolean z;
        int i;
        if (getSheetView() == null || getSheetView().getHeight() == getHeight()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = getHeight() / 3;
        } else {
            i = getSheetView().getHeight();
        }
        return (float) i;
    }

    /* access modifiers changed from: private */
    public void setSheetLayerTypeIfEnabled(int i) {
        if (this.f5308e) {
            getSheetView().setLayerType(i, (Paint) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSheetTranslation(float r5) {
        /*
            r4 = this;
            float r0 = r4.getMaxSheetTranslation()
            float r5 = java.lang.Math.min(r5, r0)
            r4.f5289a = r5
            int r5 = r4.getHeight()
            double r0 = (double) r5
            float r5 = r4.f5289a
            double r2 = (double) r5
            double r2 = java.lang.Math.ceil(r2)
            double r0 = r0 - r2
            int r5 = (int) r0
            int r0 = r4.getWidth()
            android.graphics.Rect r1 = r4.f5292a
            r2 = 0
            r1.set(r2, r2, r0, r5)
            android.view.View r5 = r4.getSheetView()
            int r0 = r4.getHeight()
            float r0 = (float) r0
            float r1 = r4.f5289a
            float r0 = r0 - r1
            r5.setTranslationY(r0)
            OC r5 = r4.f5300b
            if (r5 == 0) goto L_0x0042
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            r5.a()
            goto L_0x0052
        L_0x0042:
            OC r5 = r4.f5290a
            if (r5 == 0) goto L_0x0052
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            r5.a()
        L_0x0052:
            boolean r5 = r4.f5307d
            if (r5 == 0) goto L_0x0082
            OC r5 = r4.f5300b
            r0 = 0
            if (r5 == 0) goto L_0x0065
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            goto L_0x0072
        L_0x0065:
            OC r5 = r4.f5290a
            if (r5 == 0) goto L_0x0076
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
        L_0x0072:
            r5 = 1060320051(0x3f333333, float:0.7)
            goto L_0x0077
        L_0x0076:
            r5 = r0
        L_0x0077:
            android.view.View r1 = r4.f5294a
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r2 = 4
        L_0x007f:
            r1.setVisibility(r2)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.setSheetTranslation(float):void");
    }

    /* access modifiers changed from: private */
    public void setState(h hVar) {
        if (hVar != this.f5296a) {
            this.f5296a = hVar;
            Iterator<g> it = this.f5302b.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public final void addView(View view) {
        if (getChildCount() <= 0) {
            setContentView(view);
            return;
        }
        throw new IllegalArgumentException("You may not declare more then one child of bottom sheet. The sheet view must be added dynamically with showWithSheetView()");
    }

    public final boolean d(float f2, float f3, View view) {
        boolean z;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                int right = childAt.getRight() - view.getScrollX();
                int bottom = childAt.getBottom() - view.getScrollY();
                float f4 = (float) left;
                if (f2 <= f4 || f2 >= ((float) right) || f3 <= ((float) top) || f3 >= ((float) bottom)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && d(f2 - f4, f3 - ((float) top), childAt)) {
                    return true;
                }
            }
        }
        return view.canScrollVertically(-1);
    }

    public final void e() {
        if (this.f5296a == h.HIDDEN) {
            this.f5297a = null;
            return;
        }
        this.f5297a = null;
        View sheetView = getSheetView();
        sheetView.removeOnLayoutChangeListener((View.OnLayoutChangeListener) null);
        Animator animator = this.f5291a;
        if (animator != null) {
            animator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{0.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(this.f5295a);
        ofFloat.addListener(new a(this, sheetView));
        ofFloat.start();
        this.f5291a = ofFloat;
        this.f5306d = this.f5304c;
    }

    public final void f() {
        Animator animator = this.f5291a;
        if (animator != null) {
            animator.cancel();
        }
        setSheetLayerTypeIfEnabled(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{getMaxSheetTranslation()});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(this.f5295a);
        ofFloat.addListener(new c());
        ofFloat.start();
        this.f5291a = ofFloat;
        setState(h.EXPANDED);
    }

    public final void g() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.b = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = (float) viewConfiguration.getScaledTouchSlop();
        View view = new View(getContext());
        this.f5294a = view;
        view.setBackgroundColor(-16777216);
        this.f5294a.setAlpha(0.0f);
        this.f5294a.setVisibility(4);
        this.d = 0.0f;
        setFocusableInTouchMode(true);
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
        int i = point.x;
        this.f5304c = i;
        this.f5306d = i;
        this.f5294a.setOnClickListener(new b());
    }

    public View getContentView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public boolean getInterceptContentTouch() {
        return this.f5309f;
    }

    public float getMaxSheetTranslation() {
        boolean z;
        int i;
        if (getSheetView() == null || getSheetView().getHeight() == getHeight()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = getHeight() - getPaddingTop();
        } else {
            i = getSheetView().getHeight();
        }
        return (float) i;
    }

    public boolean getPeekOnDismiss() {
        return this.f5299a;
    }

    public float getPeekSheetTranslation() {
        float f2 = this.d;
        if (f2 == 0.0f) {
            return getDefaultPeekTranslation();
        }
        return f2;
    }

    public View getSheetView() {
        if (getChildCount() > 2) {
            return getChildAt(2);
        }
        return null;
    }

    public h getState() {
        return this.f5296a;
    }

    public final void h() {
        Animator animator = this.f5291a;
        if (animator != null) {
            animator.cancel();
        }
        setSheetLayerTypeIfEnabled(2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{getPeekSheetTranslation()});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(this.f5295a);
        ofFloat.addListener(new d());
        ofFloat.start();
        this.f5291a = ofFloat;
        setState(h.PEEKED);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5293a = VelocityTracker.obtain();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5293a.clear();
        Animator animator = this.f5291a;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        if (r7 != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        if (r7 != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r0 = r1
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x000f
            r6.f5310g = r2
        L_0x000f:
            boolean r3 = r6.f5309f
            if (r3 != 0) goto L_0x0041
            float r3 = r7.getY()
            int r4 = r6.getHeight()
            float r4 = (float) r4
            float r5 = r6.f5289a
            float r4 = r4 - r5
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x003e
            float r7 = r7.getX()
            boolean r3 = r6.h
            if (r3 == 0) goto L_0x003a
            float r3 = (float) r2
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0038
            int r3 = r6.f5306d
            float r3 = (float) r3
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r7 = r2
            goto L_0x003b
        L_0x003a:
            r7 = r1
        L_0x003b:
            if (r7 == 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r6.f5310g = r2
            goto L_0x0052
        L_0x0041:
            if (r0 == 0) goto L_0x004f
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r7 = r6.f5296a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r0 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.h.HIDDEN
            if (r7 == r0) goto L_0x004b
            r7 = r1
            goto L_0x004c
        L_0x004b:
            r7 = r2
        L_0x004c:
            if (r7 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r1 = r2
        L_0x0050:
            r6.f5310g = r1
        L_0x0052:
            boolean r7 = r6.f5310g
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            h hVar = this.f5296a;
            h hVar2 = h.HIDDEN;
            boolean z2 = false;
            if (hVar != hVar2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (this.f5296a != hVar2) {
                        z2 = true;
                    }
                    if (z2 && keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        if (this.f5296a != h.EXPANDED || !this.f5299a) {
                            e();
                        } else {
                            h();
                        }
                        return true;
                    }
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        this.f5292a.set(0, 0, width, (int) (((double) getHeight()) - Math.ceil((double) this.f5289a)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            r14 = this;
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r0 = r14.f5296a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r1 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.h.HIDDEN
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x000a
            r0 = r2
            goto L_0x000b
        L_0x000a:
            r0 = r3
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            return r3
        L_0x000e:
            android.animation.Animator r0 = r14.f5291a
            if (r0 == 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r3
        L_0x0015:
            if (r0 == 0) goto L_0x0018
            return r3
        L_0x0018:
            boolean r0 = r14.f5310g
            if (r0 != 0) goto L_0x0021
            boolean r15 = r14.onInterceptTouchEvent(r15)
            return r15
        L_0x0021:
            int r0 = r15.getAction()
            if (r0 != 0) goto L_0x0044
            r14.f5303b = r3
            r14.f5305c = r3
            float r0 = r15.getY()
            r14.e = r0
            float r0 = r15.getX()
            r14.f = r0
            float r0 = r14.f5289a
            r14.g = r0
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r0 = r14.f5296a
            r14.f5301b = r0
            android.view.VelocityTracker r0 = r14.f5293a
            r0.clear()
        L_0x0044:
            android.view.VelocityTracker r0 = r14.f5293a
            r0.addMovement(r15)
            float r0 = r14.getMaxSheetTranslation()
            float r1 = r14.getPeekSheetTranslation()
            float r4 = r14.e
            float r5 = r15.getY()
            float r4 = r4 - r5
            float r5 = r14.f
            float r6 = r15.getX()
            float r5 = r5 - r6
            boolean r6 = r14.f5303b
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r7 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.h.PEEKED
            r8 = 3
            r9 = 0
            if (r6 != 0) goto L_0x00bc
            boolean r6 = r14.f5305c
            if (r6 != 0) goto L_0x00bc
            float r6 = java.lang.Math.abs(r4)
            float r10 = r14.c
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x0077
            r6 = r2
            goto L_0x0078
        L_0x0077:
            r6 = r3
        L_0x0078:
            r14.f5303b = r6
            float r5 = java.lang.Math.abs(r5)
            float r6 = r14.c
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0086
            r5 = r2
            goto L_0x0087
        L_0x0086:
            r5 = r3
        L_0x0087:
            r14.f5305c = r5
            boolean r5 = r14.f5303b
            if (r5 == 0) goto L_0x00bc
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r4 = r14.f5296a
            if (r4 != r7) goto L_0x00ad
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r15)
            float r5 = r14.f5289a
            int r6 = r14.getHeight()
            float r6 = (float) r6
            float r5 = r5 - r6
            r4.offsetLocation(r9, r5)
            r4.setAction(r8)
            android.view.View r5 = r14.getSheetView()
            r5.dispatchTouchEvent(r4)
            r4.recycle()
        L_0x00ad:
            r14.f5305c = r3
            float r4 = r15.getY()
            r14.e = r4
            float r4 = r15.getX()
            r14.f = r4
            r4 = r9
        L_0x00bc:
            float r5 = r14.g
            float r5 = r5 + r4
            boolean r6 = r14.f5303b
            if (r6 == 0) goto L_0x01bb
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x00c9
            r4 = r2
            goto L_0x00ca
        L_0x00c9:
            r4 = r3
        L_0x00ca:
            android.view.View r6 = r14.getSheetView()
            float r10 = r15.getX()
            float r11 = r15.getY()
            float r12 = r14.f5289a
            int r13 = r14.getHeight()
            float r13 = (float) r13
            float r12 = r12 - r13
            float r12 = r12 + r11
            boolean r6 = r14.d(r10, r12, r6)
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r10 = r14.f5296a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r11 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.h.EXPANDED
            r12 = 2
            if (r10 != r11) goto L_0x0116
            if (r4 == 0) goto L_0x0116
            if (r6 != 0) goto L_0x0116
            float r4 = r15.getY()
            r14.e = r4
            float r4 = r14.f5289a
            r14.g = r4
            android.view.VelocityTracker r4 = r14.f5293a
            r4.clear()
            r14.setState(r7)
            r14.setSheetLayerTypeIfEnabled(r12)
            float r5 = r14.f5289a
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r15)
            r4.setAction(r8)
            android.view.View r6 = r14.getSheetView()
            r6.dispatchTouchEvent(r4)
            r4.recycle()
        L_0x0116:
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r4 = r14.f5296a
            if (r4 != r7) goto L_0x013c
            int r4 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x013c
            r14.setSheetTranslation(r0)
            float r5 = java.lang.Math.min(r0, r5)
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r15)
            r0.setAction(r3)
            android.view.View r4 = r14.getSheetView()
            r4.dispatchTouchEvent(r0)
            r0.recycle()
            r14.setState(r11)
            r14.setSheetLayerTypeIfEnabled(r3)
        L_0x013c:
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r0 = r14.f5296a
            if (r0 != r11) goto L_0x0154
            float r0 = r14.f5289a
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r0 = r0 - r1
            r15.offsetLocation(r9, r0)
            android.view.View r0 = r14.getSheetView()
            r0.dispatchTouchEvent(r15)
            goto L_0x0214
        L_0x0154:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x015f
            float r0 = r1 - r5
            r3 = 1082130432(0x40800000, float:4.0)
            float r0 = r0 / r3
            float r5 = r1 - r0
        L_0x015f:
            r14.setSheetTranslation(r5)
            int r0 = r15.getAction()
            if (r0 != r8) goto L_0x0173
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout$h r0 = r14.f5301b
            if (r0 != r11) goto L_0x0170
            r14.f()
            goto L_0x0173
        L_0x0170:
            r14.h()
        L_0x0173:
            int r15 = r15.getAction()
            if (r15 != r2) goto L_0x0214
            int r15 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r15 >= 0) goto L_0x0182
            r14.e()
            goto L_0x0214
        L_0x0182:
            android.view.VelocityTracker r15 = r14.f5293a
            r0 = 1000(0x3e8, float:1.401E-42)
            r15.computeCurrentVelocity(r0)
            android.view.VelocityTracker r15 = r14.f5293a
            float r15 = r15.getYVelocity()
            float r0 = java.lang.Math.abs(r15)
            float r1 = r14.b
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x01af
            float r15 = r14.f5289a
            int r0 = r14.getHeight()
            int r0 = r0 / r12
            float r0 = (float) r0
            int r15 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r15 <= 0) goto L_0x01aa
            r14.f()
            goto L_0x0214
        L_0x01aa:
            r14.h()
            goto L_0x0214
        L_0x01af:
            int r15 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r15 >= 0) goto L_0x01b7
            r14.f()
            goto L_0x0214
        L_0x01b7:
            r14.h()
            goto L_0x0214
        L_0x01bb:
            float r0 = r15.getY()
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r4 = r14.f5289a
            float r1 = r1 - r4
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            boolean r1 = r14.h
            if (r0 < 0) goto L_0x01e8
            float r0 = r15.getX()
            if (r1 == 0) goto L_0x01e2
            float r4 = (float) r3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x01e0
            int r4 = r14.f5306d
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x01e0
            goto L_0x01e2
        L_0x01e0:
            r0 = r3
            goto L_0x01e3
        L_0x01e2:
            r0 = r2
        L_0x01e3:
            if (r0 != 0) goto L_0x01e6
            goto L_0x01e8
        L_0x01e6:
            r0 = r3
            goto L_0x01e9
        L_0x01e8:
            r0 = r2
        L_0x01e9:
            int r4 = r15.getAction()
            if (r4 != r2) goto L_0x01f9
            if (r0 == 0) goto L_0x01f9
            boolean r0 = r14.f5309f
            if (r0 == 0) goto L_0x01f9
            r14.e()
            return r2
        L_0x01f9:
            if (r1 == 0) goto L_0x0202
            float r0 = r14.getX()
            float r1 = (float) r3
            float r9 = r0 - r1
        L_0x0202:
            float r0 = r14.f5289a
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r0 = r0 - r1
            r15.offsetLocation(r9, r0)
            android.view.View r0 = r14.getSheetView()
            r0.dispatchTouchEvent(r15)
        L_0x0214:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setContentView(View view) {
        super.addView(view, -1, generateDefaultLayoutParams());
        super.addView(this.f5294a, -1, generateDefaultLayoutParams());
    }

    public void setDefaultViewTransformer(C0619OC oc) {
        this.f5290a = oc;
    }

    public void setInterceptContentTouch(boolean z) {
        this.f5309f = z;
    }

    public void setPeekOnDismiss(boolean z) {
        this.f5299a = z;
    }

    public void setPeekSheetTranslation(float f2) {
        this.d = f2;
    }

    public void setShouldDimContentView(boolean z) {
        this.f5307d = z;
    }

    public void setUseHardwareLayerWhileAnimating(boolean z) {
        this.f5308e = z;
    }

    public final void addView(View view, int i) {
        addView(view);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addView(view);
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view);
    }

    public final void addView(View view, int i, int i2) {
        addView(view);
    }

    public BottomSheetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomSheetLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5292a = new Rect();
        this.f5296a = h.HIDDEN;
        this.f5299a = false;
        this.f5295a = new DecelerateInterpolator(1.6f);
        this.f5290a = new f();
        this.f5307d = true;
        this.f5308e = true;
        this.f5298a = new CopyOnWriteArraySet<>();
        this.f5302b = new CopyOnWriteArraySet<>();
        this.f5309f = true;
        this.f5304c = 0;
        this.h = getResources().getBoolean(R.bool.bottomsheet_is_tablet);
        getResources().getDimensionPixelSize(R.dimen.bottomsheet_default_sheet_width);
        this.f5306d = 0;
        g();
    }

    public static class f extends v3 {
        public final void a() {
        }
    }
}
