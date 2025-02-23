package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.common.primitives.Ints;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public AppCompatSpinner a;

    /* renamed from: a  reason: collision with other field name */
    public final LinearLayoutCompat f1218a;

    /* renamed from: a  reason: collision with other field name */
    public nv f1219a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1220a;
    public int c;
    public int d;
    public int e;
    public int f;

    public class a extends BaseAdapter {
        public a() {
        }

        public final int getCount() {
            return ScrollingTabContainerView.this.f1218a.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) ScrollingTabContainerView.this.f1218a.getChildAt(i)).f1221a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.getClass();
                b bVar = new b(scrollingTabContainerView.getContext(), (ActionBar.b) getItem(i));
                bVar.setBackgroundDrawable((Drawable) null);
                bVar.setLayoutParams(new AbsListView.LayoutParams(-1, scrollingTabContainerView.e));
                return bVar;
            }
            b bVar2 = (b) view;
            bVar2.f1221a = (ActionBar.b) getItem(i);
            bVar2.a();
            return view;
        }
    }

    public class b extends LinearLayout {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ActionBar.b f1221a;

        /* renamed from: a  reason: collision with other field name */
        public AppCompatImageView f1222a;

        /* renamed from: a  reason: collision with other field name */
        public AppCompatTextView f1223a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(android.content.Context r6, androidx.appcompat.app.ActionBar.b r7) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = defpackage.C0220hr.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 0
                r3 = 16842964(0x10100d4, float:2.3694152E-38)
                r1[r2] = r3
                r4.f1221a = r7
                androidx.appcompat.widget.TintTypedArray r7 = new androidx.appcompat.widget.TintTypedArray
                android.content.res.TypedArray r5 = r6.obtainStyledAttributes(r0, r1, r5, r2)
                r7.<init>(r6, r5)
                boolean r5 = r7.l(r2)
                if (r5 == 0) goto L_0x0029
                android.graphics.drawable.Drawable r5 = r7.e(r2)
                r4.setBackgroundDrawable(r5)
            L_0x0029:
                r7.n()
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
                r4.a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.b.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$b):void");
        }

        public final void a() {
            ActionBar.b bVar = this.f1221a;
            View b = bVar.b();
            CharSequence charSequence = null;
            if (b != null) {
                ViewParent parent = b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b);
                    }
                    addView(b);
                }
                this.a = b;
                AppCompatTextView appCompatTextView = this.f1223a;
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(8);
                }
                AppCompatImageView appCompatImageView = this.f1222a;
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(8);
                    this.f1222a.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.a;
            if (view != null) {
                removeView(view);
                this.a = null;
            }
            Drawable c = bVar.c();
            CharSequence d = bVar.d();
            if (c != null) {
                if (this.f1222a == null) {
                    AppCompatImageView appCompatImageView2 = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView2.setLayoutParams(layoutParams);
                    addView(appCompatImageView2, 0);
                    this.f1222a = appCompatImageView2;
                }
                this.f1222a.setImageDrawable(c);
                this.f1222a.setVisibility(0);
            } else {
                AppCompatImageView appCompatImageView3 = this.f1222a;
                if (appCompatImageView3 != null) {
                    appCompatImageView3.setVisibility(8);
                    this.f1222a.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (z) {
                if (this.f1223a == null) {
                    AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext(), (AttributeSet) null, C0220hr.actionBarTabTextStyle);
                    appCompatTextView2.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView2.setLayoutParams(layoutParams2);
                    addView(appCompatTextView2);
                    this.f1223a = appCompatTextView2;
                }
                this.f1223a.setText(d);
                this.f1223a.setVisibility(0);
            } else {
                AppCompatTextView appCompatTextView3 = this.f1223a;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setVisibility(8);
                    this.f1223a.setText((CharSequence) null);
                }
            }
            AppCompatImageView appCompatImageView4 = this.f1222a;
            if (appCompatImageView4 != null) {
                appCompatImageView4.setContentDescription(bVar.a());
            }
            if (!z) {
                charSequence = bVar.a();
            }
            C0234jA.a(this, charSequence);
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            if (scrollingTabContainerView.c > 0 && getMeasuredWidth() > (i3 = scrollingTabContainerView.c)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, Ints.MAX_POWER_OF_TWO), i2);
            }
        }

        public final void setSelected(boolean z) {
            boolean z2;
            if (isSelected() != z) {
                z2 = true;
            } else {
                z2 = false;
            }
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with other field name */
        public boolean f1225a = false;

        public c() {
        }

        public final void onAnimationCancel(Animator animator) {
            this.f1225a = true;
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.f1225a) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.getClass();
                scrollingTabContainerView.setVisibility(0);
            }
        }

        public final void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1225a = false;
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        new c();
        setHorizontalScrollBarEnabled(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, ps.ActionBar, C0220hr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(ps.ActionBar_height, 0);
        layoutDimension = !context.getResources().getBoolean(C0240jr.abc_action_bar_embed_tabs) ? Math.min(layoutDimension, context.getResources().getDimensionPixelSize(tr.abc_action_bar_stacked_max_height)) : layoutDimension;
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.d = context.getResources().getDimensionPixelSize(tr.abc_action_bar_stacked_tab_max_width);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, C0220hr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.f1218a = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    public final void a() {
        boolean z;
        AppCompatSpinner appCompatSpinner = this.a;
        if (appCompatSpinner == null || appCompatSpinner.getParent() != this) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            removeView(this.a);
            addView(this.f1218a, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.a.getSelectedItemPosition());
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        nv nvVar = this.f1219a;
        if (nvVar != null) {
            post(nvVar);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, ps.ActionBar, C0220hr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(ps.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(C0240jr.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(tr.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.d = context.getResources().getDimensionPixelSize(tr.abc_action_bar_stacked_tab_max_width);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nv nvVar = this.f1219a;
        if (nvVar != null) {
            removeCallbacks(nvVar);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((b) view).f1221a.e();
    }

    public final void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int mode = View.MeasureSpec.getMode(i);
        boolean z3 = true;
        if (mode == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        setFillViewport(z);
        LinearLayoutCompat linearLayoutCompat = this.f1218a;
        int childCount = linearLayoutCompat.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.c = -1;
        } else {
            if (childCount > 2) {
                this.c = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.e, Ints.MAX_POWER_OF_TWO);
        if (z || !this.f1220a) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            linearLayoutCompat.measure(0, makeMeasureSpec);
            if (linearLayoutCompat.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                AppCompatSpinner appCompatSpinner = this.a;
                if (appCompatSpinner == null || appCompatSpinner.getParent() != this) {
                    z3 = false;
                }
                if (!z3) {
                    if (this.a == null) {
                        AppCompatSpinner appCompatSpinner2 = new AppCompatSpinner(getContext(), (AttributeSet) null, C0220hr.actionDropDownStyle);
                        appCompatSpinner2.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                        appCompatSpinner2.setOnItemSelectedListener(this);
                        this.a = appCompatSpinner2;
                    }
                    removeView(linearLayoutCompat);
                    addView(this.a, new ViewGroup.LayoutParams(-2, -1));
                    if (this.a.getAdapter() == null) {
                        this.a.setAdapter((SpinnerAdapter) new a());
                    }
                    nv nvVar = this.f1219a;
                    if (nvVar != null) {
                        removeCallbacks(nvVar);
                        this.f1219a = null;
                    }
                    this.a.setSelection(this.f);
                }
            } else {
                a();
            }
        } else {
            a();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.f);
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f1220a = z;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        boolean z;
        this.f = i;
        LinearLayoutCompat linearLayoutCompat = this.f1218a;
        int childCount = linearLayoutCompat.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayoutCompat.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                View childAt2 = linearLayoutCompat.getChildAt(i);
                nv nvVar = this.f1219a;
                if (nvVar != null) {
                    removeCallbacks(nvVar);
                }
                nv nvVar2 = new nv(this, childAt2);
                this.f1219a = nvVar2;
                post(nvVar2);
            }
        }
        AppCompatSpinner appCompatSpinner = this.a;
        if (appCompatSpinner != null && i >= 0) {
            appCompatSpinner.setSelection(i);
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
