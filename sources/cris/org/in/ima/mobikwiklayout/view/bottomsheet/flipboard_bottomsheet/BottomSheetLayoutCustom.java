package cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
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
import android.view.ViewAnimationUtils;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import cris.org.in.prs.ima.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class BottomSheetLayoutCustom extends BottomSheet {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public float f5312a;

    /* renamed from: a  reason: collision with other field name */
    public C0619OC f5313a;

    /* renamed from: a  reason: collision with other field name */
    public Animator f5314a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f5315a;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f5316a;

    /* renamed from: a  reason: collision with other field name */
    public View f5317a;

    /* renamed from: a  reason: collision with other field name */
    public final DecelerateInterpolator f5318a;

    /* renamed from: a  reason: collision with other field name */
    public g f5319a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f5320a;

    /* renamed from: a  reason: collision with other field name */
    public final CopyOnWriteArraySet<Xn> f5321a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5322a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public C0619OC f5323b;

    /* renamed from: b  reason: collision with other field name */
    public View f5324b;

    /* renamed from: b  reason: collision with other field name */
    public g f5325b;

    /* renamed from: b  reason: collision with other field name */
    public final CopyOnWriteArraySet<f> f5326b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f5327b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f5328c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5329c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f5330d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f5331d;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f5332e;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f5333f;
    public float g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f5334g;
    public final boolean h;

    public class a extends Property<BottomSheetLayoutCustom, Float> {
        public a() {
            super(Float.class, "sheetTranslation");
        }

        public final Object get(Object obj) {
            return Float.valueOf(((BottomSheetLayoutCustom) obj).f5312a);
        }

        public final void set(Object obj, Object obj2) {
            ((BottomSheetLayoutCustom) obj).setSheetTranslation(((Float) obj2).floatValue());
        }
    }

    public class b extends d {
        public b() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.a) {
                BottomSheetLayoutCustom.this.f5314a = null;
            }
        }
    }

    public class c extends d {
        public c() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.a) {
                BottomSheetLayoutCustom.this.f5314a = null;
            }
        }
    }

    public static class d extends AnimatorListenerAdapter {
        public boolean a;

        public final void onAnimationCancel(Animator animator) {
            this.a = true;
        }
    }

    public interface f {
        void a();
    }

    public enum g {
        HIDDEN,
        PEEKED,
        EXPANDED
    }

    public BottomSheetLayoutCustom(Context context) {
        super(context);
        this.f5315a = new Rect();
        this.f5319a = g.HIDDEN;
        this.f5322a = false;
        this.f5318a = new DecelerateInterpolator(1.6f);
        this.f5313a = new e();
        this.f5331d = true;
        this.f5332e = true;
        this.f5321a = new CopyOnWriteArraySet<>();
        this.f5326b = new CopyOnWriteArraySet<>();
        this.f5333f = true;
        this.f5328c = 0;
        this.h = getResources().getBoolean(R.bool.bottomsheet_is_tablet);
        getResources().getDimensionPixelSize(R.dimen.bottomsheet_default_sheet_width);
        this.f5330d = 0;
        f();
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
            i = (int) (((double) getHeight()) * 0.7d);
        } else {
            i = getSheetView().getHeight();
        }
        return (float) i;
    }

    /* access modifiers changed from: private */
    public void setSheetLayerTypeIfEnabled(int i) {
        if (this.f5332e) {
            getSheetView().setLayerType(i, (Paint) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSheetTranslation(float r5) {
        /*
            r4 = this;
            r4.f5312a = r5
            int r0 = r4.getHeight()
            double r0 = (double) r0
            double r2 = (double) r5
            double r2 = java.lang.Math.ceil(r2)
            double r0 = r0 - r2
            int r0 = (int) r0
            int r1 = r4.getWidth()
            android.graphics.Rect r2 = r4.f5315a
            r3 = 0
            r2.set(r3, r3, r1, r0)
            android.view.View r0 = r4.getSheetView()
            int r1 = r4.getHeight()
            float r1 = (float) r1
            float r1 = r1 - r5
            r0.setTranslationY(r1)
            OC r5 = r4.f5323b
            if (r5 == 0) goto L_0x0036
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            r5.a()
            goto L_0x0046
        L_0x0036:
            OC r5 = r4.f5313a
            if (r5 == 0) goto L_0x0046
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            r5.a()
        L_0x0046:
            boolean r5 = r4.f5331d
            if (r5 == 0) goto L_0x007b
            OC r5 = r4.f5323b
            r0 = 0
            if (r5 == 0) goto L_0x0059
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
            goto L_0x0066
        L_0x0059:
            OC r5 = r4.f5313a
            if (r5 == 0) goto L_0x006a
            r4.getMaxSheetTranslation()
            r4.getPeekSheetTranslation()
            r4.getContentView()
        L_0x0066:
            r5 = 1060320051(0x3f333333, float:0.7)
            goto L_0x006b
        L_0x006a:
            r5 = r0
        L_0x006b:
            android.view.View r1 = r4.f5317a
            r1.setAlpha(r5)
            android.view.View r1 = r4.f5317a
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r3 = 4
        L_0x0078:
            r1.setVisibility(r3)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.setSheetTranslation(float):void");
    }

    /* access modifiers changed from: private */
    public void setState(g gVar) {
        this.f5319a = gVar;
        Iterator<f> it = this.f5326b.iterator();
        while (it.hasNext()) {
            it.next().a();
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
                int left = childAt.getLeft();
                int top = childAt.getTop();
                int right = childAt.getRight();
                int bottom = childAt.getBottom();
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
        Animator animator = this.f5314a;
        if (animator != null) {
            animator.cancel();
        }
        setSheetLayerTypeIfEnabled(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{getMaxSheetTranslation()});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(this.f5318a);
        ofFloat.addListener(new b());
        ofFloat.start();
        this.f5314a = ofFloat;
        setState(g.EXPANDED);
    }

    public final void f() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.b = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = (float) viewConfiguration.getScaledTouchSlop();
        View view = new View(getContext());
        this.f5317a = view;
        view.setBackgroundColor(-16777216);
        this.f5317a.setAlpha(0.0f);
        this.f5317a.setVisibility(4);
        this.d = 0.0f;
        setFocusableInTouchMode(true);
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
        int i = point.x;
        this.f5328c = i;
        this.f5330d = i;
    }

    public final void g() {
        Animator animator = this.f5314a;
        if (animator != null) {
            animator.cancel();
        }
        setSheetLayerTypeIfEnabled(2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{getPeekSheetTranslation()});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(this.f5318a);
        ofFloat.addListener(new c());
        ofFloat.start();
        this.f5314a = ofFloat;
        setState(g.PEEKED);
    }

    public View getBottomView() {
        return this.f5324b;
    }

    public View getContentView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public boolean getInterceptContentTouch() {
        return this.f5333f;
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
        return this.f5322a;
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

    public g getState() {
        return this.f5319a;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5316a = VelocityTracker.obtain();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5316a.clear();
        Animator animator = this.f5314a;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r8.getY() < (((float) getHeight()) - r3)) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        if (r8 != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r0 = r1
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            android.view.View r3 = r7.f5324b
            if (r3 == 0) goto L_0x0015
            int r3 = r3.getHeight()
            float r3 = (float) r3
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x001a
            r7.f5334g = r2
        L_0x001a:
            boolean r4 = r7.f5333f
            if (r4 != 0) goto L_0x005a
            float r4 = r8.getY()
            int r5 = r7.getHeight()
            float r5 = (float) r5
            float r6 = r7.f5312a
            float r5 = r5 - r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0057
            float r4 = r8.getX()
            boolean r5 = r7.h
            if (r5 == 0) goto L_0x0045
            float r5 = (float) r2
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0043
            int r5 = r7.f5330d
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r4 = r2
            goto L_0x0046
        L_0x0045:
            r4 = r1
        L_0x0046:
            if (r4 == 0) goto L_0x0057
            float r8 = r8.getY()
            int r4 = r7.getHeight()
            float r4 = (float) r4
            float r4 = r4 - r3
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0057
            goto L_0x005a
        L_0x0057:
            r7.f5334g = r2
            goto L_0x006b
        L_0x005a:
            if (r0 == 0) goto L_0x0068
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r8 = r7.f5319a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r0 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.g.HIDDEN
            if (r8 == r0) goto L_0x0064
            r8 = r1
            goto L_0x0065
        L_0x0064:
            r8 = r2
        L_0x0065:
            if (r8 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r1 = r2
        L_0x0069:
            r7.f5334g = r1
        L_0x006b:
            boolean r8 = r7.f5334g
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        if (i == 4) {
            g gVar = this.f5319a;
            g gVar2 = g.HIDDEN;
            if (gVar != gVar2) {
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
                    if (this.f5319a != gVar2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        g gVar3 = this.f5319a;
                        if (gVar3 == g.EXPANDED && this.f5322a) {
                            g();
                        } else if (gVar3 == gVar2) {
                            this.f5320a = null;
                        } else {
                            this.f5320a = null;
                            View sheetView = getSheetView();
                            sheetView.removeOnLayoutChangeListener((View.OnLayoutChangeListener) null);
                            Animator animator = this.f5314a;
                            if (animator != null) {
                                animator.cancel();
                            }
                            AnimatorSet animatorSet = new AnimatorSet();
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, new float[]{getMaxSheetTranslation()});
                            animatorSet.setDuration(500);
                            animatorSet.setInterpolator(this.f5318a);
                            animatorSet.addListener(new b(this, sheetView));
                            animatorSet.playTogether(new Animator[]{ofFloat, ViewAnimationUtils.createCircularReveal(sheetView, (int) sheetView.getPivotX(), (int) sheetView.getPivotY(), (float) getHeight(), 0.0f)});
                            View view = this.f5324b;
                            if (view != null) {
                                super.removeView(view);
                                this.f5324b = null;
                            }
                            animatorSet.start();
                            this.f5314a = animatorSet;
                            this.f5330d = this.f5328c;
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
        this.f5315a.set(0, 0, width, (int) (((double) getHeight()) - Math.ceil((double) this.f5312a)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            r14 = this;
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r0 = r14.f5319a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r1 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.g.HIDDEN
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
            android.animation.Animator r0 = r14.f5314a
            if (r0 == 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r3
        L_0x0015:
            if (r0 == 0) goto L_0x0018
            return r3
        L_0x0018:
            boolean r0 = r14.f5334g
            if (r0 != 0) goto L_0x0021
            boolean r15 = r14.onInterceptTouchEvent(r15)
            return r15
        L_0x0021:
            int r0 = r15.getAction()
            if (r0 != 0) goto L_0x0044
            r14.f5327b = r3
            r14.f5329c = r3
            float r0 = r15.getY()
            r14.e = r0
            float r0 = r15.getX()
            r14.f = r0
            float r0 = r14.f5312a
            r14.g = r0
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r0 = r14.f5319a
            r14.f5325b = r0
            android.view.VelocityTracker r0 = r14.f5316a
            r0.clear()
        L_0x0044:
            android.view.VelocityTracker r0 = r14.f5316a
            r0.addMovement(r15)
            float r0 = r14.getMaxSheetTranslation()
            float r1 = r14.getPeekSheetTranslation()
            float r4 = r14.e
            float r5 = r15.getY()
            float r4 = r4 - r5
            float r5 = r14.f
            float r6 = r15.getX()
            float r5 = r5 - r6
            boolean r6 = r14.f5327b
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r7 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.g.PEEKED
            r8 = 3
            r9 = 0
            if (r6 != 0) goto L_0x00bc
            boolean r6 = r14.f5329c
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
            r14.f5327b = r6
            float r5 = java.lang.Math.abs(r5)
            float r6 = r14.c
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0086
            r5 = r2
            goto L_0x0087
        L_0x0086:
            r5 = r3
        L_0x0087:
            r14.f5329c = r5
            boolean r5 = r14.f5327b
            if (r5 == 0) goto L_0x00bc
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r4 = r14.f5319a
            if (r4 != r7) goto L_0x00ad
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r15)
            float r5 = r14.f5312a
            int r6 = r14.getHeight()
            float r6 = (float) r6
            float r5 = r5 - r6
            r4.offsetLocation(r9, r5)
            r4.setAction(r8)
            android.view.View r5 = r14.getSheetView()
            r5.dispatchTouchEvent(r4)
            r4.recycle()
        L_0x00ad:
            r14.f5329c = r3
            float r4 = r15.getY()
            r14.e = r4
            float r4 = r15.getX()
            r14.f = r4
            r4 = r9
        L_0x00bc:
            float r5 = r14.g
            float r5 = r5 + r4
            boolean r6 = r14.f5327b
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
            float r12 = r14.f5312a
            int r13 = r14.getHeight()
            float r13 = (float) r13
            float r12 = r12 - r13
            float r12 = r12 + r11
            boolean r6 = r14.d(r10, r12, r6)
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r10 = r14.f5319a
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r11 = cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.g.EXPANDED
            r12 = 2
            if (r10 != r11) goto L_0x0116
            if (r4 == 0) goto L_0x0116
            if (r6 != 0) goto L_0x0116
            float r4 = r15.getY()
            r14.e = r4
            float r4 = r14.f5312a
            r14.g = r4
            android.view.VelocityTracker r4 = r14.f5316a
            r4.clear()
            r14.setState(r7)
            r14.setSheetLayerTypeIfEnabled(r12)
            float r5 = r14.f5312a
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r15)
            r4.setAction(r8)
            android.view.View r6 = r14.getSheetView()
            r6.dispatchTouchEvent(r4)
            r4.recycle()
        L_0x0116:
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r4 = r14.f5319a
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
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r0 = r14.f5319a
            if (r0 != r11) goto L_0x0154
            float r0 = r14.f5312a
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r0 = r0 - r1
            r15.offsetLocation(r9, r0)
            android.view.View r0 = r14.getSheetView()
            r0.dispatchTouchEvent(r15)
            goto L_0x0211
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
            cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom$g r0 = r14.f5325b
            if (r0 != r11) goto L_0x0170
            r14.e()
            goto L_0x0173
        L_0x0170:
            r14.g()
        L_0x0173:
            int r15 = r15.getAction()
            if (r15 != r2) goto L_0x0211
            int r15 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r15 >= 0) goto L_0x0182
            r14.g()
            goto L_0x0211
        L_0x0182:
            android.view.VelocityTracker r15 = r14.f5316a
            r0 = 1000(0x3e8, float:1.401E-42)
            r15.computeCurrentVelocity(r0)
            android.view.VelocityTracker r15 = r14.f5316a
            float r15 = r15.getYVelocity()
            float r0 = java.lang.Math.abs(r15)
            float r1 = r14.b
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x01af
            float r15 = r14.f5312a
            int r0 = r14.getHeight()
            int r0 = r0 / r12
            float r0 = (float) r0
            int r15 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r15 <= 0) goto L_0x01aa
            r14.e()
            goto L_0x0211
        L_0x01aa:
            r14.g()
            goto L_0x0211
        L_0x01af:
            int r15 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r15 >= 0) goto L_0x01b7
            r14.e()
            goto L_0x0211
        L_0x01b7:
            r14.g()
            goto L_0x0211
        L_0x01bb:
            float r0 = r15.getY()
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r4 = r14.f5312a
            float r1 = r1 - r4
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            boolean r1 = r14.h
            if (r0 < 0) goto L_0x01e8
            float r0 = r15.getX()
            if (r1 == 0) goto L_0x01e2
            float r4 = (float) r3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x01e0
            int r4 = r14.f5330d
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
            if (r4 != r2) goto L_0x01f6
            if (r0 == 0) goto L_0x01f6
            boolean r0 = r14.f5333f
            if (r0 == 0) goto L_0x01f6
            return r3
        L_0x01f6:
            if (r1 == 0) goto L_0x01ff
            float r0 = r14.getX()
            float r1 = (float) r3
            float r9 = r0 - r1
        L_0x01ff:
            float r0 = r14.f5312a
            int r1 = r14.getHeight()
            float r1 = (float) r1
            float r0 = r0 - r1
            r15.offsetLocation(r9, r0)
            android.view.View r0 = r14.getSheetView()
            r0.dispatchTouchEvent(r15)
        L_0x0211:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBottomView(View view) {
        this.f5324b = view;
    }

    public void setContentView(View view) {
        super.addView(view, -1, generateDefaultLayoutParams());
        super.addView(this.f5317a, -1, generateDefaultLayoutParams());
    }

    public void setDefaultViewTransformer(C0619OC oc) {
        this.f5313a = oc;
    }

    public void setInterceptContentTouch(boolean z) {
        this.f5333f = z;
    }

    public void setPeekOnDismiss(boolean z) {
        this.f5322a = z;
    }

    public void setPeekSheetTranslation(float f2) {
        this.d = f2;
    }

    public void setShouldDimContentView(boolean z) {
        this.f5331d = z;
    }

    public void setUseHardwareLayerWhileAnimating(boolean z) {
        this.f5332e = z;
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

    public BottomSheetLayoutCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomSheetLayoutCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5315a = new Rect();
        this.f5319a = g.HIDDEN;
        this.f5322a = false;
        this.f5318a = new DecelerateInterpolator(1.6f);
        this.f5313a = new e();
        this.f5331d = true;
        this.f5332e = true;
        this.f5321a = new CopyOnWriteArraySet<>();
        this.f5326b = new CopyOnWriteArraySet<>();
        this.f5333f = true;
        this.f5328c = 0;
        this.h = getResources().getBoolean(R.bool.bottomsheet_is_tablet);
        getResources().getDimensionPixelSize(R.dimen.bottomsheet_default_sheet_width);
        this.f5330d = 0;
        f();
    }

    public static class e extends v3 {
        public final void a() {
        }
    }
}
