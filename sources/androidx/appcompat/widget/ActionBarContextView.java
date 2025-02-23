package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.core.view.f;
import com.google.common.primitives.Ints;
import java.util.WeakHashMap;

public class ActionBarContextView extends C0242k {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f1100a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f1101a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1102a;
    public View b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f1103b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1104b;
    public View c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1105c;
    public final int d;
    public final int e;
    public final int f;

    public class a implements View.OnClickListener {
        public final /* synthetic */ ActionMode a;

        public a(ActionMode actionMode) {
            this.a = actionMode;
        }

        public final void onClick(View view) {
            this.a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void f(ActionMode actionMode) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f, this, false);
            this.a = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.a);
        }
        View findViewById = this.a.findViewById(Gr.action_mode_close_button);
        this.b = findViewById;
        findViewById.setOnClickListener(new a(actionMode));
        MenuBuilder c2 = actionMode.c();
        ActionMenuPresenter actionMenuPresenter = this.f3044a;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
            ActionMenuPresenter.a aVar = actionMenuPresenter.f1129a;
            if (aVar != null && aVar.b()) {
                aVar.f1077a.dismiss();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f3044a = actionMenuPresenter2;
        actionMenuPresenter2.b = true;
        actionMenuPresenter2.c = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c2.addMenuPresenter(this.f3044a, this.f3043a);
        ActionMenuPresenter actionMenuPresenter3 = this.f3044a;
        MenuView menuView = actionMenuPresenter3.f1040a;
        if (menuView == null) {
            MenuView menuView2 = (MenuView) actionMenuPresenter3.f1037a.inflate(actionMenuPresenter3.c, this, false);
            actionMenuPresenter3.f1040a = menuView2;
            menuView2.initialize(actionMenuPresenter3.f1038a);
            actionMenuPresenter3.updateMenuView(true);
        }
        MenuView menuView3 = actionMenuPresenter3.f1040a;
        if (menuView != menuView3) {
            ((ActionMenuView) menuView3).setPresenter(actionMenuPresenter3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) menuView3;
        this.f3045a = actionMenuView;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        actionMenuView.setBackground((Drawable) null);
        addView(this.f3045a, layoutParams);
    }

    public final void g() {
        int i;
        if (this.f1100a == null) {
            LayoutInflater.from(getContext()).inflate(Vr.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1100a = linearLayout;
            this.f1101a = (TextView) linearLayout.findViewById(Gr.action_bar_title);
            this.f1103b = (TextView) this.f1100a.findViewById(Gr.action_bar_subtitle);
            int i2 = this.d;
            if (i2 != 0) {
                this.f1101a.setTextAppearance(getContext(), i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                this.f1103b.setTextAppearance(getContext(), i3);
            }
        }
        this.f1101a.setText(this.f1102a);
        this.f1103b.setText(this.f1104b);
        boolean z = !TextUtils.isEmpty(this.f1102a);
        boolean z2 = !TextUtils.isEmpty(this.f1104b);
        TextView textView = this.f1103b;
        int i4 = 0;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout2 = this.f1100a;
        if (!z && !z2) {
            i4 = 8;
        }
        linearLayout2.setVisibility(i4);
        if (this.f1100a.getParent() == null) {
            addView(this.f1100a);
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1104b;
    }

    public CharSequence getTitle() {
        return this.f1102a;
    }

    public final void h() {
        removeAllViews();
        this.c = null;
        this.f3045a = null;
        this.f3044a = null;
        View view = this.b;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f3044a;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
            ActionMenuPresenter.a aVar = this.f3044a.f1129a;
            if (aVar != null && aVar.b()) {
                aVar.f1077a.dismiss();
            }
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean a2 = UC.a(this);
        if (a2) {
            i5 = (i3 - i) - getPaddingRight();
        } else {
            i5 = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.a;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            if (a2) {
                i7 = marginLayoutParams.rightMargin;
            } else {
                i7 = marginLayoutParams.leftMargin;
            }
            if (a2) {
                i8 = marginLayoutParams.leftMargin;
            } else {
                i8 = marginLayoutParams.rightMargin;
            }
            if (a2) {
                i9 = i5 - i7;
            } else {
                i9 = i5 + i7;
            }
            int d2 = C0242k.d(i9, paddingTop, paddingTop2, this.a, a2) + i9;
            if (a2) {
                i10 = d2 - i8;
            } else {
                i10 = d2 + i8;
            }
            i5 = i10;
        }
        LinearLayout linearLayout = this.f1100a;
        if (!(linearLayout == null || this.c != null || linearLayout.getVisibility() == 8)) {
            i5 += C0242k.d(i5, paddingTop, paddingTop2, this.f1100a, a2);
        }
        View view2 = this.c;
        if (view2 != null) {
            C0242k.d(i5, paddingTop, paddingTop2, view2, a2);
        }
        if (a2) {
            i6 = getPaddingLeft();
        } else {
            i6 = (i3 - i) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f3045a;
        if (actionMenuView != null) {
            C0242k.d(i6, paddingTop, paddingTop2, actionMenuView, !a2);
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int i5 = Ints.MAX_POWER_OF_TWO;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i6 = this.c;
            if (i6 <= 0) {
                i6 = View.MeasureSpec.getSize(i2);
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i7 = i6 - paddingBottom;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
            View view = this.a;
            if (view != null) {
                int c2 = C0242k.c(view, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
                paddingLeft = c2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f3045a;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = C0242k.c(this.f3045a, paddingLeft, makeMeasureSpec);
            }
            LinearLayout linearLayout = this.f1100a;
            if (linearLayout != null && this.c == null) {
                if (this.f1105c) {
                    this.f1100a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f1100a.getMeasuredWidth();
                    if (measuredWidth <= paddingLeft) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    LinearLayout linearLayout2 = this.f1100a;
                    if (z) {
                        i4 = 0;
                    } else {
                        i4 = 8;
                    }
                    linearLayout2.setVisibility(i4);
                } else {
                    paddingLeft = C0242k.c(linearLayout, paddingLeft, makeMeasureSpec);
                }
            }
            View view2 = this.c;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i8 = layoutParams.width;
                if (i8 != -2) {
                    i3 = 1073741824;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                if (i8 >= 0) {
                    paddingLeft = Math.min(i8, paddingLeft);
                }
                int i9 = layoutParams.height;
                if (i9 == -2) {
                    i5 = Integer.MIN_VALUE;
                }
                if (i9 >= 0) {
                    i7 = Math.min(i9, i7);
                }
                this.c.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(i7, i5));
            }
            if (this.c <= 0) {
                int childCount = getChildCount();
                int i10 = 0;
                for (int i11 = 0; i11 < childCount; i11++) {
                    int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingBottom;
                    if (measuredHeight > i10) {
                        i10 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i10);
                return;
            }
            setMeasuredDimension(size, i6);
        } else {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
    }

    public void setContentHeight(int i) {
        this.c = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.c;
        if (view2 != null) {
            removeView(view2);
        }
        this.c = view;
        if (!(view == null || (linearLayout = this.f1100a) == null)) {
            removeView(linearLayout);
            this.f1100a = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1104b = charSequence;
        g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1102a = charSequence;
        g();
        f.p(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1105c) {
            requestLayout();
        }
        this.f1105c = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps.ActionMode, i, 0);
        TintTypedArray tintTypedArray = new TintTypedArray(context, obtainStyledAttributes);
        Drawable e2 = tintTypedArray.e(ps.ActionMode_background);
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        setBackground(e2);
        this.d = tintTypedArray.i(ps.ActionMode_titleTextStyle, 0);
        this.e = tintTypedArray.i(ps.ActionMode_subtitleTextStyle, 0);
        this.c = obtainStyledAttributes.getLayoutDimension(ps.ActionMode_height, 0);
        this.f = tintTypedArray.i(ps.ActionMode_closeItemLayout, Vr.abc_action_mode_close_item_material);
        tintTypedArray.n();
    }
}
