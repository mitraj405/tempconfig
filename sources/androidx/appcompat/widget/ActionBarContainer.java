package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.f;
import java.util.WeakHashMap;

public class ActionBarContainer extends FrameLayout {
    public Drawable a;

    /* renamed from: a  reason: collision with other field name */
    public View f1093a;

    /* renamed from: a  reason: collision with other field name */
    public ScrollingTabContainerView f1094a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1095a;
    public Drawable b;

    /* renamed from: b  reason: collision with other field name */
    public View f1096b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f1097b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public Drawable f1098c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1099c;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.a;
        if (drawable != null && drawable.isStateful()) {
            this.a.setState(getDrawableState());
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1098c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1098c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1094a;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1098c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f1093a = findViewById(Gr.action_bar);
        this.f1096b = findViewById(Gr.action_context_bar);
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1095a || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            androidx.appcompat.widget.ScrollingTabContainerView r5 = r4.f1094a
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0013
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L_0x0013
            r1 = r9
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0033
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L_0x0033
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L_0x0033:
            boolean r6 = r4.f1097b
            if (r6 == 0) goto L_0x004b
            android.graphics.drawable.Drawable r5 = r4.f1098c
            if (r5 == 0) goto L_0x0048
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto L_0x00be
        L_0x0048:
            r9 = r0
            goto L_0x00be
        L_0x004b:
            android.graphics.drawable.Drawable r6 = r4.a
            if (r6 == 0) goto L_0x00a3
            android.view.View r6 = r4.f1093a
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0075
            android.graphics.drawable.Drawable r6 = r4.a
            android.view.View r7 = r4.f1093a
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f1093a
            int r8 = r8.getTop()
            android.view.View r0 = r4.f1093a
            int r0 = r0.getRight()
            android.view.View r2 = r4.f1093a
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x0075:
            android.view.View r6 = r4.f1096b
            if (r6 == 0) goto L_0x009d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x009d
            android.graphics.drawable.Drawable r6 = r4.a
            android.view.View r7 = r4.f1096b
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f1096b
            int r8 = r8.getTop()
            android.view.View r0 = r4.f1096b
            int r0 = r0.getRight()
            android.view.View r2 = r4.f1096b
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x009d:
            android.graphics.drawable.Drawable r6 = r4.a
            r6.setBounds(r0, r0, r0, r0)
        L_0x00a2:
            r0 = r9
        L_0x00a3:
            r4.f1099c = r1
            if (r1 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r6 = r4.b
            if (r6 == 0) goto L_0x0048
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        L_0x00be:
            if (r9 == 0) goto L_0x00c3
            r4.invalidate()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    public final void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        if (this.f1093a == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i4 = this.c) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1093a != null) {
            int mode = View.MeasureSpec.getMode(i2);
            ScrollingTabContainerView scrollingTabContainerView = this.f1094a;
            if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8 && mode != 1073741824) {
                View view = this.f1093a;
                boolean z2 = true;
                int i5 = 0;
                if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i5 = a(this.f1093a);
                } else {
                    View view2 = this.f1096b;
                    if (!(view2 == null || view2.getVisibility() == 8 || view2.getMeasuredHeight() == 0)) {
                        z2 = false;
                    }
                    if (!z2) {
                        i5 = a(this.f1096b);
                    }
                }
                if (mode == Integer.MIN_VALUE) {
                    i3 = View.MeasureSpec.getSize(i2);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f1094a) + i5, i3));
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1093a;
            if (view != null) {
                this.a.setBounds(view.getLeft(), this.f1093a.getTop(), this.f1093a.getRight(), this.f1093a.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1097b ? !(this.a == null && this.b == null) : this.f1098c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1098c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1098c);
        }
        this.f1098c = drawable;
        boolean z = this.f1097b;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f1098c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? this.a == null && this.b == null : this.f1098c == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z;
        Drawable drawable2;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1099c && (drawable2 = this.b) != null) {
                drawable2.setBounds(this.f1094a.getLeft(), this.f1094a.getTop(), this.f1094a.getRight(), this.f1094a.getBottom());
            }
        }
        if (!this.f1097b ? !(this.a == null && this.b == null) : this.f1098c != null) {
            z = false;
        } else {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f1094a;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f1094a = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        int i;
        this.f1095a = z;
        if (z) {
            i = 393216;
        } else {
            i = 262144;
        }
        setDescendantFocusability(i);
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1098c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.a;
        boolean z = this.f1097b;
        if ((drawable != drawable2 || z) && ((drawable != this.b || !this.f1099c) && ((drawable != this.f1098c || !z) && !super.verifyDrawable(drawable)))) {
            return false;
        }
        return true;
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        E e = new E(this);
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        setBackground(e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps.ActionBar);
        this.a = obtainStyledAttributes.getDrawable(ps.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(ps.ActionBar_backgroundStacked);
        this.c = obtainStyledAttributes.getDimensionPixelSize(ps.ActionBar_height, -1);
        boolean z = true;
        if (getId() == Gr.split_action_bar) {
            this.f1097b = true;
            this.f1098c = obtainStyledAttributes.getDrawable(ps.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1097b ? !(this.a == null && this.b == null) : this.f1098c != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }
}
