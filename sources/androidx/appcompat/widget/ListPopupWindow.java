package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.facebook.ads.AdError;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class ListPopupWindow implements Fw {
    public static final Method a;
    public static final Method b;

    /* renamed from: a  reason: collision with other field name */
    public A9 f1196a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1197a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1198a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f1199a;

    /* renamed from: a  reason: collision with other field name */
    public View f1200a;

    /* renamed from: a  reason: collision with other field name */
    public AdapterView.OnItemClickListener f1201a;

    /* renamed from: a  reason: collision with other field name */
    public AdapterView.OnItemSelectedListener f1202a;

    /* renamed from: a  reason: collision with other field name */
    public ListAdapter f1203a;

    /* renamed from: a  reason: collision with other field name */
    public final PopupWindow f1204a;

    /* renamed from: a  reason: collision with other field name */
    public final c f1205a;

    /* renamed from: a  reason: collision with other field name */
    public d f1206a;

    /* renamed from: a  reason: collision with other field name */
    public final e f1207a;

    /* renamed from: a  reason: collision with other field name */
    public final f f1208a;

    /* renamed from: a  reason: collision with other field name */
    public final g f1209a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1210a;

    /* renamed from: b  reason: collision with other field name */
    public Rect f1211b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1212b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1213c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1214d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public final int i;

    public static class a {
        public static int a(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    public static class b {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            A9 a9 = ListPopupWindow.this.f1196a;
            if (a9 != null) {
                a9.setListSelectionHidden(true);
                a9.requestLayout();
            }
        }
    }

    public class d extends DataSetObserver {
        public d() {
        }

        public final void onChanged() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (listPopupWindow.a()) {
                listPopupWindow.show();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (action == 0 && (popupWindow = listPopupWindow.f1204a) != null && popupWindow.isShowing() && x >= 0 && x < listPopupWindow.f1204a.getWidth() && y >= 0 && y < listPopupWindow.f1204a.getHeight()) {
                listPopupWindow.f1199a.postDelayed(listPopupWindow.f1209a, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                listPopupWindow.f1199a.removeCallbacks(listPopupWindow.f1209a);
                return false;
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public final void run() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            A9 a9 = listPopupWindow.f1196a;
            if (a9 != null) {
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                if (a9.isAttachedToWindow() && listPopupWindow.f1196a.getCount() > listPopupWindow.f1196a.getChildCount() && listPopupWindow.f1196a.getChildCount() <= listPopupWindow.i) {
                    listPopupWindow.f1204a.setInputMethodMode(2);
                    listPopupWindow.show();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                b = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0220hr.listPopupWindowStyle);
    }

    public final boolean a() {
        return this.f1204a.isShowing();
    }

    public final A9 b() {
        return this.f1196a;
    }

    public final int c() {
        return this.e;
    }

    public final Drawable d() {
        return this.f1204a.getBackground();
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.f1204a;
        popupWindow.dismiss();
        popupWindow.setContentView((View) null);
        this.f1196a = null;
        this.f1199a.removeCallbacks(this.f1209a);
    }

    public final void f(int i2) {
        this.e = i2;
    }

    public final int g() {
        if (!this.f1210a) {
            return 0;
        }
        return this.f;
    }

    public final void h(int i2) {
        this.f = i2;
        this.f1210a = true;
    }

    public void i(ListAdapter listAdapter) {
        d dVar = this.f1206a;
        if (dVar == null) {
            this.f1206a = new d();
        } else {
            ListAdapter listAdapter2 = this.f1203a;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dVar);
            }
        }
        this.f1203a = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1206a);
        }
        A9 a9 = this.f1196a;
        if (a9 != null) {
            a9.setAdapter(this.f1203a);
        }
    }

    public A9 o(Context context, boolean z) {
        return new A9(context, z);
    }

    public final void p(int i2) {
        Drawable background = this.f1204a.getBackground();
        if (background != null) {
            Rect rect = this.f1198a;
            background.getPadding(rect);
            this.d = rect.left + rect.right + i2;
            return;
        }
        this.d = i2;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.f1204a.setBackgroundDrawable(drawable);
    }

    public final void show() {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        A9 a9;
        int i4;
        int i5;
        int i6;
        int i7;
        A9 a92 = this.f1196a;
        PopupWindow popupWindow = this.f1204a;
        Context context = this.f1197a;
        if (a92 == null) {
            A9 o = o(context, !this.f1214d);
            this.f1196a = o;
            o.setAdapter(this.f1203a);
            this.f1196a.setOnItemClickListener(this.f1201a);
            this.f1196a.setFocusable(true);
            this.f1196a.setFocusableInTouchMode(true);
            this.f1196a.setOnItemSelectedListener(new gi(this));
            this.f1196a.setOnScrollListener(this.f1207a);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1202a;
            if (onItemSelectedListener != null) {
                this.f1196a.setOnItemSelectedListener(onItemSelectedListener);
            }
            popupWindow.setContentView(this.f1196a);
        } else {
            ViewGroup viewGroup = (ViewGroup) popupWindow.getContentView();
        }
        Drawable background = popupWindow.getBackground();
        int i8 = 0;
        Rect rect = this.f1198a;
        if (background != null) {
            background.getPadding(rect);
            int i9 = rect.top;
            i2 = rect.bottom + i9;
            if (!this.f1210a) {
                this.f = -i9;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        if (popupWindow.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int a2 = a.a(popupWindow, this.f1200a, this.f, z);
        int i10 = this.c;
        if (i10 == -1) {
            i3 = a2 + i2;
        } else {
            int i11 = this.d;
            if (i11 == -2) {
                i6 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            } else if (i11 != -1) {
                i6 = View.MeasureSpec.makeMeasureSpec(i11, Ints.MAX_POWER_OF_TWO);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Ints.MAX_POWER_OF_TWO);
            }
            int a3 = this.f1196a.a(i6, a2 + 0);
            if (a3 > 0) {
                i7 = this.f1196a.getPaddingBottom() + this.f1196a.getPaddingTop() + i2 + 0;
            } else {
                i7 = 0;
            }
            i3 = a3 + i7;
        }
        if (popupWindow.getInputMethodMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Vp.d(popupWindow, this.g);
        if (popupWindow.isShowing()) {
            View view = this.f1200a;
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            if (view.isAttachedToWindow()) {
                int i12 = this.d;
                if (i12 == -1) {
                    i12 = -1;
                } else if (i12 == -2) {
                    i12 = this.f1200a.getWidth();
                }
                if (i10 == -1) {
                    if (z2) {
                        i10 = i3;
                    } else {
                        i10 = -1;
                    }
                    if (z2) {
                        if (this.d == -1) {
                            i5 = -1;
                        } else {
                            i5 = 0;
                        }
                        popupWindow.setWidth(i5);
                        popupWindow.setHeight(0);
                    } else {
                        if (this.d == -1) {
                            i8 = -1;
                        }
                        popupWindow.setWidth(i8);
                        popupWindow.setHeight(-1);
                    }
                } else if (i10 == -2) {
                    i10 = i3;
                }
                popupWindow.setOutsideTouchable(true);
                View view2 = this.f1200a;
                int i13 = this.e;
                int i14 = this.f;
                if (i12 < 0) {
                    i12 = -1;
                }
                if (i10 < 0) {
                    i4 = -1;
                } else {
                    i4 = i10;
                }
                popupWindow.update(view2, i13, i14, i12, i4);
                return;
            }
            return;
        }
        int i15 = this.d;
        if (i15 == -1) {
            i15 = -1;
        } else if (i15 == -2) {
            i15 = this.f1200a.getWidth();
        }
        if (i10 == -1) {
            i10 = -1;
        } else if (i10 == -2) {
            i10 = i3;
        }
        popupWindow.setWidth(i15);
        popupWindow.setHeight(i10);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(popupWindow, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        } else {
            b.b(popupWindow, true);
        }
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(this.f1208a);
        if (this.f1213c) {
            Vp.c(popupWindow, this.f1212b);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = b;
            if (method2 != null) {
                try {
                    method2.invoke(popupWindow, new Object[]{this.f1211b});
                } catch (Exception unused2) {
                }
            }
        } else {
            b.a(popupWindow, this.f1211b);
        }
        popupWindow.showAsDropDown(this.f1200a, this.e, this.f, this.h);
        this.f1196a.setSelection(-1);
        if ((!this.f1214d || this.f1196a.isInTouchMode()) && (a9 = this.f1196a) != null) {
            a9.setListSelectionHidden(true);
            a9.requestLayout();
        }
        if (!this.f1214d) {
            this.f1199a.post(this.f1205a);
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.c = -2;
        this.d = -2;
        this.g = AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE;
        this.h = 0;
        this.i = Integer.MAX_VALUE;
        this.f1209a = new g();
        this.f1208a = new f();
        this.f1207a = new e();
        this.f1205a = new c();
        this.f1198a = new Rect();
        this.f1197a = context;
        this.f1199a = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps.ListPopupWindow, i2, i3);
        this.e = obtainStyledAttributes.getDimensionPixelOffset(ps.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(ps.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1210a = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.f1204a = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (i == 1) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (listPopupWindow.f1204a.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && listPopupWindow.f1204a.getContentView() != null) {
                    Handler handler = listPopupWindow.f1199a;
                    g gVar = listPopupWindow.f1209a;
                    handler.removeCallbacks(gVar);
                    gVar.run();
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
