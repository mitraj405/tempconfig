package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.common.primitives.Ints;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.a, MenuView {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder.Callback f1137a;

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder f1138a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1139a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMenuPresenter f1140a;

    /* renamed from: a  reason: collision with other field name */
    public OnMenuItemClickListener f1141a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1142a;
    public boolean b;
    public int c;
    public int d;
    public final int e;
    public final int f;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int a;
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with other field name */
        public boolean f1143a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with other field name */
        public boolean f1144b;
        @ViewDebug.ExportedProperty
        public boolean c;
        public boolean d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1143a = layoutParams.f1143a;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f1143a = false;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public interface a {
        boolean a();

        boolean b();
    }

    public class c implements MenuBuilder.Callback {
        public c() {
        }

        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.f1141a;
            if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.f1137a;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static LayoutParams b(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (layoutParams2.gravity <= 0) {
                layoutParams2.gravity = 16;
            }
            return layoutParams2;
        }
        LayoutParams layoutParams3 = new LayoutParams();
        layoutParams3.gravity = 16;
        return layoutParams3;
    }

    public final boolean a(MenuItemImpl menuItemImpl) {
        return this.f1138a.performItemAction(menuItemImpl, 0);
    }

    public final boolean c(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).a();
        }
        if (i <= 0 || !(childAt2 instanceof a)) {
            return z;
        }
        return z | ((a) childAt2).b();
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public Menu getMenu() {
        if (this.f1138a == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1138a = menuBuilder;
            menuBuilder.setCallback(new c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1140a = actionMenuPresenter;
            actionMenuPresenter.b = true;
            actionMenuPresenter.c = true;
            MenuPresenter.Callback callback = this.f1139a;
            if (callback == null) {
                callback = new b();
            }
            actionMenuPresenter.f1039a = callback;
            this.f1138a.addMenuPresenter(actionMenuPresenter, this.a);
            ActionMenuPresenter actionMenuPresenter2 = this.f1140a;
            actionMenuPresenter2.f1040a = this;
            this.f1138a = actionMenuPresenter2.f1038a;
        }
        return this.f1138a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f1140a;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f1132a;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (actionMenuPresenter.f1135a) {
            return actionMenuPresenter.a;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void initialize(MenuBuilder menuBuilder) {
        this.f1138a = menuBuilder;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1140a;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.f1140a.c()) {
                this.f1140a.b();
                this.f1140a.e();
            }
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1140a;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
            ActionMenuPresenter.a aVar = actionMenuPresenter.f1129a;
            if (aVar != null && aVar.b()) {
                aVar.f1077a.dismiss();
            }
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (!this.b) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = UC.a(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1143a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (c(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i6 = getPaddingLeft() + layoutParams.leftMargin;
                        i7 = i6 + measuredWidth;
                    } else {
                        i7 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i6 = i7 - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i6, i13, i7, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    c(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        if (i16 > 0) {
            i5 = paddingRight / i16;
        } else {
            i5 = 0;
        }
        int i17 = 0;
        int max = Math.max(0, i5);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            while (i17 < childCount) {
                View childAt3 = getChildAt(i17);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1143a) {
                    int i18 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
                i17++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i17 < childCount) {
            View childAt4 = getChildAt(i17);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1143a) {
                int i20 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = C1058d.q(measuredWidth4, layoutParams3.rightMargin, max, i20);
            }
            i17++;
        }
    }

    public final void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z6;
        int i9;
        int i10;
        boolean z7;
        int i11;
        ActionMenuItemView actionMenuItemView;
        boolean z8;
        int i12;
        boolean z9;
        MenuBuilder menuBuilder;
        boolean z10 = this.b;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        if (z10 != z) {
            this.d = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.b || (menuBuilder = this.f1138a) == null || size == this.d)) {
            this.d = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.b || childCount <= 0) {
            int i13 = i2;
            for (int i14 = 0; i14 < childCount; i14++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i14).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i15 = size2 - paddingRight;
        int i16 = this.e;
        int i17 = i15 / i16;
        int i18 = i15 % i16;
        if (i17 == 0) {
            setMeasuredDimension(i15, 0);
            return;
        }
        int i19 = (i18 / i17) + i16;
        int childCount2 = getChildCount();
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        boolean z11 = false;
        int i24 = 0;
        long j = 0;
        while (true) {
            i3 = this.f;
            if (i23 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i23);
            int i25 = size3;
            int i26 = i15;
            if (childAt.getVisibility() == 8) {
                i9 = mode;
                i10 = paddingBottom;
            } else {
                boolean z12 = childAt instanceof ActionMenuItemView;
                int i27 = i21 + 1;
                if (z12) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.d = false;
                layoutParams2.b = 0;
                layoutParams2.a = 0;
                layoutParams2.f1144b = false;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                if (!z12 || !((ActionMenuItemView) childAt).c()) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                layoutParams2.c = z7;
                if (layoutParams2.f1143a) {
                    i11 = 1;
                } else {
                    i11 = i17;
                }
                int i28 = i27;
                LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                i9 = mode;
                i10 = paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                if (z12) {
                    actionMenuItemView = (ActionMenuItemView) childAt;
                } else {
                    actionMenuItemView = null;
                }
                if (actionMenuItemView == null || !actionMenuItemView.c()) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (i11 <= 0 || (z8 && i11 < 2)) {
                    i12 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i11 * i19, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i12 = measuredWidth / i19;
                    if (measuredWidth % i19 != 0) {
                        i12++;
                    }
                    if (z8 && i12 < 2) {
                        i12 = 2;
                    }
                }
                if (layoutParams3.f1143a || !z8) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                layoutParams3.f1144b = z9;
                layoutParams3.a = i12;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19 * i12, Ints.MAX_POWER_OF_TWO), makeMeasureSpec);
                i22 = Math.max(i22, i12);
                if (layoutParams2.f1144b) {
                    i24++;
                }
                if (layoutParams2.f1143a) {
                    z11 = true;
                }
                i17 -= i12;
                i20 = Math.max(i20, childAt.getMeasuredHeight());
                if (i12 == 1) {
                    j |= (long) (1 << i23);
                }
                i21 = i28;
            }
            i23++;
            size3 = i25;
            i15 = i26;
            paddingBottom = i10;
            mode = i9;
        }
        int i29 = mode;
        int i30 = i15;
        int i31 = size3;
        if (!z11 || i21 != 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z13 = false;
        while (true) {
            if (i24 <= 0 || i17 <= 0) {
                z3 = z13;
            } else {
                int i32 = Integer.MAX_VALUE;
                int i33 = 0;
                int i34 = 0;
                long j2 = 0;
                while (i34 < childCount2) {
                    LayoutParams layoutParams4 = (LayoutParams) getChildAt(i34).getLayoutParams();
                    boolean z14 = z13;
                    if (layoutParams4.f1144b) {
                        int i35 = layoutParams4.a;
                        if (i35 < i32) {
                            j2 = 1 << i34;
                            i32 = i35;
                            i33 = 1;
                        } else if (i35 == i32) {
                            j2 |= 1 << i34;
                            i33++;
                        }
                    }
                    i34++;
                    z13 = z14;
                }
                z3 = z13;
                j |= j2;
                if (i33 > i17) {
                    break;
                }
                int i36 = i32 + 1;
                int i37 = 0;
                while (i37 < childCount2) {
                    View childAt2 = getChildAt(i37);
                    LayoutParams layoutParams5 = (LayoutParams) childAt2.getLayoutParams();
                    int i38 = i20;
                    int i39 = childMeasureSpec;
                    int i40 = childCount2;
                    long j3 = (long) (1 << i37);
                    if ((j2 & j3) != 0) {
                        if (!z2 || !layoutParams5.c) {
                            z6 = true;
                        } else {
                            z6 = true;
                            if (i17 == 1) {
                                childAt2.setPadding(i3 + i19, 0, i3, 0);
                            }
                        }
                        layoutParams5.a += z6 ? 1 : 0;
                        layoutParams5.d = z6;
                        i17--;
                    } else if (layoutParams5.a == i36) {
                        j |= j3;
                    }
                    i37++;
                    childMeasureSpec = i39;
                    i20 = i38;
                    childCount2 = i40;
                }
                z13 = true;
            }
        }
        z3 = z13;
        int i41 = i20;
        int i42 = childMeasureSpec;
        int i43 = childCount2;
        if (z11 || i21 != 1) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i17 <= 0 || j == 0 || (i17 >= i21 - 1 && !z4 && i22 <= 1)) {
            i4 = i43;
            z5 = z3;
        } else {
            float bitCount = (float) Long.bitCount(j);
            if (!z4) {
                if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).c) {
                    bitCount -= 0.5f;
                }
                int i44 = i43 - 1;
                if ((j & ((long) (1 << i44))) != 0 && !((LayoutParams) getChildAt(i44).getLayoutParams()).c) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i8 = (int) (((float) (i17 * i19)) / bitCount);
            } else {
                i8 = 0;
            }
            boolean z15 = z3;
            i4 = i43;
            for (int i45 = 0; i45 < i4; i45++) {
                if ((j & ((long) (1 << i45))) != 0) {
                    View childAt3 = getChildAt(i45);
                    LayoutParams layoutParams6 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams6.b = i8;
                        layoutParams6.d = true;
                        if (i45 == 0 && !layoutParams6.c) {
                            layoutParams6.leftMargin = (-i8) / 2;
                        }
                        z15 = true;
                    } else {
                        if (layoutParams6.f1143a) {
                            layoutParams6.b = i8;
                            layoutParams6.d = true;
                            layoutParams6.rightMargin = (-i8) / 2;
                            z15 = true;
                        } else {
                            if (i45 != 0) {
                                layoutParams6.leftMargin = i8 / 2;
                            }
                            if (i45 != i4 - 1) {
                                layoutParams6.rightMargin = i8 / 2;
                            }
                        }
                    }
                }
            }
            z5 = z15;
        }
        if (z5) {
            int i46 = 0;
            while (i46 < i4) {
                View childAt4 = getChildAt(i46);
                LayoutParams layoutParams7 = (LayoutParams) childAt4.getLayoutParams();
                if (!layoutParams7.d) {
                    i7 = i42;
                } else {
                    i7 = i42;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams7.a * i19) + layoutParams7.b, Ints.MAX_POWER_OF_TWO), i7);
                }
                i46++;
                i42 = i7;
            }
        }
        if (i29 != 1073741824) {
            i6 = i30;
            i5 = i41;
        } else {
            i5 = i31;
            i6 = i30;
        }
        setMeasuredDimension(i6, i5);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1140a.d = z;
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1139a = callback;
        this.f1137a = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1141a = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f1140a;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f1132a;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.f1135a = true;
        actionMenuPresenter.a = drawable;
    }

    public void setOverflowReserved(boolean z) {
        this.f1142a = z;
    }

    public void setPopupTheme(int i) {
        if (this.c != i) {
            this.c = i;
            if (i == 0) {
                this.a = getContext();
            } else {
                this.a = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1140a = actionMenuPresenter;
        actionMenuPresenter.f1040a = this;
        this.f1138a = actionMenuPresenter.f1038a;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.e = (int) (56.0f * f2);
        this.f = (int) (f2 * 4.0f);
        this.a = context;
        this.c = 0;
    }

    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public final LinearLayoutCompat.LayoutParams m9generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public final LinearLayoutCompat.LayoutParams m10generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class b implements MenuPresenter.Callback {
        public final boolean a(MenuBuilder menuBuilder) {
            return false;
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }
}
