package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.f;

/* renamed from: k  reason: default package and case insensitive filesystem */
/* compiled from: AbsActionBarView */
public abstract class C0242k extends ViewGroup {
    public GC a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3043a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMenuPresenter f3044a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMenuView f3045a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3046a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3047a;
    public boolean b;
    public int c;

    /* renamed from: k$a */
    /* compiled from: AbsActionBarView */
    public class a implements IC {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3049a = false;

        public a() {
        }

        public final void a() {
            C0242k.super.setVisibility(0);
            this.f3049a = false;
        }

        public final void onAnimationCancel() {
            this.f3049a = true;
        }

        public final void onAnimationEnd() {
            if (!this.f3049a) {
                C0242k kVar = C0242k.this;
                kVar.a = null;
                C0242k.super.setVisibility(this.a);
            }
        }
    }

    public C0242k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int c(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - 0);
    }

    public static int d(int i, int i2, int i3, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        if (z) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public final GC e(int i, long j) {
        GC gc = this.a;
        if (gc != null) {
            gc.b();
        }
        a aVar = this.f3046a;
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            GC a2 = f.a(this);
            a2.a(1.0f);
            a2.c(j);
            C0242k.this.a = a2;
            aVar.a = i;
            a2.d(aVar);
            return a2;
        }
        GC a3 = f.a(this);
        a3.a(0.0f);
        a3.c(j);
        C0242k.this.a = a3;
        aVar.a = i;
        a3.d(aVar);
        return a3;
    }

    public int getAnimatedVisibility() {
        if (this.a != null) {
            return this.f3046a.a;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.c;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, ps.ActionBar, C0220hr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(ps.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f3044a;
        if (actionMenuPresenter != null) {
            Configuration configuration2 = actionMenuPresenter.b.getResources().getConfiguration();
            int i2 = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
                i = 5;
            } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
                i = 4;
            } else if (i2 >= 360) {
                i = 3;
            } else {
                i = 2;
            }
            actionMenuPresenter.h = i;
            MenuBuilder menuBuilder = actionMenuPresenter.f1038a;
            if (menuBuilder != null) {
                menuBuilder.onItemsChanged(true);
            }
        }
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.b = false;
        }
        if (!this.b) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.b = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.b = false;
        }
        return true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3047a = false;
        }
        if (!this.f3047a) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f3047a = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3047a = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.c = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            GC gc = this.a;
            if (gc != null) {
                gc.b();
            }
            super.setVisibility(i);
        }
    }

    public C0242k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3046a = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0220hr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f3043a = context;
        } else {
            this.f3043a = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
