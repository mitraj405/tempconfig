package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.common.primitives.Ints;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: A9  reason: default package */
/* compiled from: DropDownListView */
public class A9 extends ListView {
    public d a;

    /* renamed from: a  reason: collision with other field name */
    public f f3a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f4a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public hi f5a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6a;
    public final boolean b;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public boolean f7c;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g;

    /* renamed from: A9$a */
    /* compiled from: DropDownListView */
    public static class a {
        public static void a(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    /* renamed from: A9$b */
    /* compiled from: DropDownListView */
    public static class b {
        public static final Method a;

        /* renamed from: a  reason: collision with other field name */
        public static final boolean f8a = true;
        public static final Method b;
        public static final Method c;

        static {
            Class<AdapterView> cls = AdapterView.class;
            Class<AbsListView> cls2 = AbsListView.class;
            try {
                Class cls3 = Integer.TYPE;
                Class cls4 = Float.TYPE;
                Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
                a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
                b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
                c = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: A9$c */
    /* compiled from: DropDownListView */
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z) {
            absListView.setSelectedChildViewEnabled(z);
        }
    }

    /* renamed from: A9$d */
    /* compiled from: DropDownListView */
    public static class d extends x9 {
        public boolean a = true;

        public d(Drawable drawable) {
            super(drawable);
        }

        public final void draw(Canvas canvas) {
            if (this.a) {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f, float f2) {
            if (this.a) {
                super.setHotspot(f, f2);
            }
        }

        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public final boolean setState(int[] iArr) {
            if (this.a) {
                return super.setState(iArr);
            }
            return false;
        }

        public final boolean setVisible(boolean z, boolean z2) {
            if (this.a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: A9$e */
    /* compiled from: DropDownListView */
    public static class e {
        public static final Field a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            a = field;
        }
    }

    /* renamed from: A9$f */
    /* compiled from: DropDownListView */
    public class f implements Runnable {
        public f() {
        }

        public final void run() {
            A9 a9 = A9.this;
            a9.f3a = null;
            a9.drawableStateChanged();
        }
    }

    public A9(Context context, boolean z) {
        super(context, (AttributeSet) null, C0220hr.dropDownListViewStyle);
        this.b = z;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a = z;
        }
    }

    public final int a(int i, int i2) {
        int i3;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i4 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i4;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i5 = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i7 = layoutParams.height;
            if (i7 > 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(i7, Ints.MAX_POWER_OF_TWO);
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i3);
            view.forceLayout();
            if (i6 > 0) {
                i4 += dividerHeight;
            }
            i4 += view.getMeasuredHeight();
            if (i4 >= i2) {
                return i2;
            }
        }
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.view.MotionEvent r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            int r3 = r17.getActionMasked()
            r4 = 1
            r5 = 0
            if (r3 == r4) goto L_0x0017
            r0 = 2
            if (r3 == r0) goto L_0x0015
            r0 = 3
            if (r3 == r0) goto L_0x001e
            r0 = r4
            goto L_0x0141
        L_0x0015:
            r0 = r4
            goto L_0x0018
        L_0x0017:
            r0 = r5
        L_0x0018:
            int r6 = r17.findPointerIndex(r18)
            if (r6 >= 0) goto L_0x0021
        L_0x001e:
            r0 = r5
            goto L_0x0141
        L_0x0021:
            float r7 = r2.getX(r6)
            int r7 = (int) r7
            float r6 = r2.getY(r6)
            int r6 = (int) r6
            int r8 = r1.pointToPosition(r7, r6)
            r9 = -1
            if (r8 != r9) goto L_0x0035
            r5 = r4
            goto L_0x0141
        L_0x0035:
            int r0 = r16.getFirstVisiblePosition()
            int r0 = r8 - r0
            android.view.View r10 = r1.getChildAt(r0)
            float r7 = (float) r7
            float r6 = (float) r6
            r1.f7c = r4
            defpackage.A9.a.a(r1, r7, r6)
            boolean r0 = r16.isPressed()
            if (r0 != 0) goto L_0x004f
            r1.setPressed(r4)
        L_0x004f:
            r16.layoutChildren()
            int r0 = r1.g
            if (r0 == r9) goto L_0x006c
            int r11 = r16.getFirstVisiblePosition()
            int r0 = r0 - r11
            android.view.View r0 = r1.getChildAt(r0)
            if (r0 == 0) goto L_0x006c
            if (r0 == r10) goto L_0x006c
            boolean r11 = r0.isPressed()
            if (r11 == 0) goto L_0x006c
            r0.setPressed(r5)
        L_0x006c:
            r1.g = r8
            int r0 = r10.getLeft()
            float r0 = (float) r0
            float r0 = r7 - r0
            int r11 = r10.getTop()
            float r11 = (float) r11
            float r11 = r6 - r11
            defpackage.A9.a.a(r10, r0, r11)
            boolean r0 = r10.isPressed()
            if (r0 != 0) goto L_0x0088
            r10.setPressed(r4)
        L_0x0088:
            android.graphics.drawable.Drawable r11 = r16.getSelector()
            if (r11 == 0) goto L_0x0092
            if (r8 == r9) goto L_0x0092
            r12 = r4
            goto L_0x0093
        L_0x0092:
            r12 = r5
        L_0x0093:
            if (r12 == 0) goto L_0x0098
            r11.setVisible(r5, r5)
        L_0x0098:
            int r0 = r10.getLeft()
            int r13 = r10.getTop()
            int r14 = r10.getRight()
            int r15 = r10.getBottom()
            android.graphics.Rect r5 = r1.f4a
            r5.set(r0, r13, r14, r15)
            int r0 = r5.left
            int r13 = r1.c
            int r0 = r0 - r13
            r5.left = r0
            int r0 = r5.top
            int r13 = r1.d
            int r0 = r0 - r13
            r5.top = r0
            int r0 = r5.right
            int r13 = r1.e
            int r0 = r0 + r13
            r5.right = r0
            int r0 = r5.bottom
            int r13 = r1.f
            int r0 = r0 + r13
            r5.bottom = r0
            boolean r0 = defpackage.s3.c()
            if (r0 == 0) goto L_0x00d4
            boolean r0 = defpackage.A9.c.a(r16)
            goto L_0x00e3
        L_0x00d4:
            java.lang.reflect.Field r0 = defpackage.A9.e.a
            if (r0 == 0) goto L_0x00e2
            boolean r0 = r0.getBoolean(r1)     // Catch:{ IllegalAccessException -> 0x00dd }
            goto L_0x00e3
        L_0x00dd:
            r0 = move-exception
            r13 = r0
            r13.printStackTrace()
        L_0x00e2:
            r0 = 0
        L_0x00e3:
            boolean r13 = r10.isEnabled()
            if (r13 == r0) goto L_0x0109
            r0 = r0 ^ r4
            boolean r13 = defpackage.s3.c()
            if (r13 == 0) goto L_0x00f4
            defpackage.A9.c.b(r1, r0)
            goto L_0x0104
        L_0x00f4:
            java.lang.reflect.Field r13 = defpackage.A9.e.a
            if (r13 == 0) goto L_0x0104
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x0100 }
            r13.set(r1, r0)     // Catch:{ IllegalAccessException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0104:
            if (r8 == r9) goto L_0x0109
            r16.refreshDrawableState()
        L_0x0109:
            if (r12 == 0) goto L_0x0124
            float r0 = r5.exactCenterX()
            float r5 = r5.exactCenterY()
            int r12 = r16.getVisibility()
            if (r12 != 0) goto L_0x011b
            r12 = r4
            goto L_0x011c
        L_0x011b:
            r12 = 0
        L_0x011c:
            r13 = 0
            r11.setVisible(r12, r13)
            defpackage.v9.a.e(r11, r0, r5)
            goto L_0x0125
        L_0x0124:
            r13 = 0
        L_0x0125:
            android.graphics.drawable.Drawable r0 = r16.getSelector()
            if (r0 == 0) goto L_0x0130
            if (r8 == r9) goto L_0x0130
            defpackage.v9.a.e(r0, r7, r6)
        L_0x0130:
            r1.setSelectorEnabled(r13)
            r16.refreshDrawableState()
            if (r3 != r4) goto L_0x013f
            long r5 = r1.getItemIdAtPosition(r8)
            r1.performItemClick(r10, r8, r5)
        L_0x013f:
            r0 = r4
            r5 = 0
        L_0x0141:
            if (r0 == 0) goto L_0x0145
            if (r5 == 0) goto L_0x015e
        L_0x0145:
            r3 = 0
            r1.f7c = r3
            r1.setPressed(r3)
            r16.drawableStateChanged()
            int r5 = r1.g
            int r6 = r16.getFirstVisiblePosition()
            int r5 = r5 - r6
            android.view.View r5 = r1.getChildAt(r5)
            if (r5 == 0) goto L_0x015e
            r5.setPressed(r3)
        L_0x015e:
            if (r0 == 0) goto L_0x0175
            hi r3 = r1.f5a
            if (r3 != 0) goto L_0x016b
            hi r3 = new hi
            r3.<init>(r1)
            r1.f5a = r3
        L_0x016b:
            hi r3 = r1.f5a
            boolean r5 = r3.f2722e
            r3.f2722e = r4
            r3.onTouch(r1, r2)
            goto L_0x0183
        L_0x0175:
            hi r2 = r1.f5a
            if (r2 == 0) goto L_0x0183
            boolean r3 = r2.f2722e
            if (r3 == 0) goto L_0x0180
            r2.d()
        L_0x0180:
            r3 = 0
            r2.f2722e = r3
        L_0x0183:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.A9.b(android.view.MotionEvent, int):boolean");
    }

    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f4a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public final void drawableStateChanged() {
        if (this.f3a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            Drawable selector = getSelector();
            if (selector != null && this.f7c && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
    }

    public final boolean hasFocus() {
        if (this.b || super.hasFocus()) {
            return true;
        }
        return false;
    }

    public final boolean hasWindowFocus() {
        if (this.b || super.hasWindowFocus()) {
            return true;
        }
        return false;
    }

    public final boolean isFocused() {
        if (this.b || super.isFocused()) {
            return true;
        }
        return false;
    }

    public final boolean isInTouchMode() {
        if ((!this.b || !this.f6a) && !super.isInTouchMode()) {
            return false;
        }
        return true;
    }

    public final void onDetachedFromWindow() {
        this.f3a = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f3a == null) {
            f fVar = new f();
            this.f3a = fVar;
            post(fVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i < 30 || !b.f8a) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            b.a.invoke(this, new Object[]{Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1});
                            b.b.invoke(this, new Object[]{Integer.valueOf(pointToPosition)});
                            b.c.invoke(this, new Object[]{Integer.valueOf(pointToPosition)});
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f7c && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f3a;
        if (fVar != null) {
            A9 a9 = A9.this;
            a9.f3a = null;
            a9.removeCallbacks(fVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f6a = z;
    }

    public void setSelector(Drawable drawable) {
        d dVar;
        if (drawable != null) {
            dVar = new d(drawable);
        } else {
            dVar = null;
        }
        this.a = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.c = rect.left;
        this.d = rect.top;
        this.e = rect.right;
        this.f = rect.bottom;
    }
}
