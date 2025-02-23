package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* renamed from: ld  reason: default package and case insensitive filesystem */
/* compiled from: ForwardingListener */
public abstract class C0259ld implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final View f3087a;

    /* renamed from: a  reason: collision with other field name */
    public a f3088a;

    /* renamed from: a  reason: collision with other field name */
    public b f3089a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3090a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f3091a = new int[2];
    public final int c;
    public final int d;
    public int e;

    /* renamed from: ld$a */
    /* compiled from: ForwardingListener */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            ViewParent parent = C0259ld.this.f3087a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: ld$b */
    /* compiled from: ForwardingListener */
    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            C0259ld ldVar = C0259ld.this;
            ldVar.a();
            View view = ldVar.f3087a;
            if (view.isEnabled() && !view.isLongClickable() && ldVar.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                ldVar.f3090a = true;
            }
        }
    }

    public C0259ld(View view) {
        this.f3087a = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.c = tapTimeout;
        this.d = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        b bVar = this.f3089a;
        View view = this.f3087a;
        if (bVar != null) {
            view.removeCallbacks(bVar);
        }
        a aVar = this.f3088a;
        if (aVar != null) {
            view.removeCallbacks(aVar);
        }
    }

    public abstract Fw b();

    public abstract boolean c();

    public boolean d() {
        Fw b2 = b();
        if (b2 == null || !b2.a()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r4 != 3) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            r12 = this;
            boolean r13 = r12.f3090a
            r0 = 3
            android.view.View r1 = r12.f3087a
            r2 = 1
            r3 = 0
            if (r13 == 0) goto L_0x006d
            Fw r4 = r12.b()
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.a()
            if (r5 != 0) goto L_0x0016
            goto L_0x005d
        L_0x0016:
            A9 r4 = r4.b()
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.isShown()
            if (r5 != 0) goto L_0x0023
            goto L_0x005d
        L_0x0023:
            android.view.MotionEvent r5 = android.view.MotionEvent.obtainNoHistory(r14)
            int[] r6 = r12.f3091a
            r1.getLocationOnScreen(r6)
            r1 = r6[r3]
            float r1 = (float) r1
            r7 = r6[r2]
            float r7 = (float) r7
            r5.offsetLocation(r1, r7)
            r4.getLocationOnScreen(r6)
            r1 = r6[r3]
            int r1 = -r1
            float r1 = (float) r1
            r6 = r6[r2]
            int r6 = -r6
            float r6 = (float) r6
            r5.offsetLocation(r1, r6)
            int r1 = r12.e
            boolean r1 = r4.b(r5, r1)
            r5.recycle()
            int r14 = r14.getActionMasked()
            if (r14 == r2) goto L_0x0056
            if (r14 == r0) goto L_0x0056
            r14 = r2
            goto L_0x0057
        L_0x0056:
            r14 = r3
        L_0x0057:
            if (r1 == 0) goto L_0x005d
            if (r14 == 0) goto L_0x005d
            r14 = r2
            goto L_0x005e
        L_0x005d:
            r14 = r3
        L_0x005e:
            if (r14 != 0) goto L_0x006a
            boolean r14 = r12.d()
            if (r14 != 0) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            r14 = r3
            goto L_0x011f
        L_0x006a:
            r14 = r2
            goto L_0x011f
        L_0x006d:
            boolean r4 = r1.isEnabled()
            if (r4 != 0) goto L_0x0075
            goto L_0x00fe
        L_0x0075:
            int r4 = r14.getActionMasked()
            if (r4 == 0) goto L_0x00d2
            if (r4 == r2) goto L_0x00ce
            r5 = 2
            if (r4 == r5) goto L_0x0084
            if (r4 == r0) goto L_0x00ce
            goto L_0x00fe
        L_0x0084:
            int r0 = r12.e
            int r0 = r14.findPointerIndex(r0)
            if (r0 < 0) goto L_0x00fe
            float r4 = r14.getX(r0)
            float r14 = r14.getY(r0)
            float r0 = r12.a
            float r5 = -r0
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x00bf
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x00bf
            int r5 = r1.getRight()
            int r6 = r1.getLeft()
            int r5 = r5 - r6
            float r5 = (float) r5
            float r5 = r5 + r0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x00bf
            int r4 = r1.getBottom()
            int r5 = r1.getTop()
            int r4 = r4 - r5
            float r4 = (float) r4
            float r4 = r4 + r0
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 >= 0) goto L_0x00bf
            r14 = r2
            goto L_0x00c0
        L_0x00bf:
            r14 = r3
        L_0x00c0:
            if (r14 != 0) goto L_0x00fe
            r12.a()
            android.view.ViewParent r14 = r1.getParent()
            r14.requestDisallowInterceptTouchEvent(r2)
            r14 = r2
            goto L_0x00ff
        L_0x00ce:
            r12.a()
            goto L_0x00fe
        L_0x00d2:
            int r14 = r14.getPointerId(r3)
            r12.e = r14
            ld$a r14 = r12.f3088a
            if (r14 != 0) goto L_0x00e3
            ld$a r14 = new ld$a
            r14.<init>()
            r12.f3088a = r14
        L_0x00e3:
            ld$a r14 = r12.f3088a
            int r0 = r12.c
            long r4 = (long) r0
            r1.postDelayed(r14, r4)
            ld$b r14 = r12.f3089a
            if (r14 != 0) goto L_0x00f6
            ld$b r14 = new ld$b
            r14.<init>()
            r12.f3089a = r14
        L_0x00f6:
            ld$b r14 = r12.f3089a
            int r0 = r12.d
            long r4 = (long) r0
            r1.postDelayed(r14, r4)
        L_0x00fe:
            r14 = r3
        L_0x00ff:
            if (r14 == 0) goto L_0x0109
            boolean r14 = r12.c()
            if (r14 == 0) goto L_0x0109
            r14 = r2
            goto L_0x010a
        L_0x0109:
            r14 = r3
        L_0x010a:
            if (r14 == 0) goto L_0x011f
            long r6 = android.os.SystemClock.uptimeMillis()
            r8 = 3
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r6
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r4, r6, r8, r9, r10, r11)
            r1.onTouchEvent(r0)
            r0.recycle()
        L_0x011f:
            r12.f3090a = r14
            if (r14 != 0) goto L_0x0127
            if (r13 == 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            r2 = r3
        L_0x0127:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0259ld.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f3090a = false;
        this.e = -1;
        a aVar = this.f3088a;
        if (aVar != null) {
            this.f3087a.removeCallbacks(aVar);
        }
    }

    public final void onViewAttachedToWindow(View view) {
    }
}
