package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import defpackage.d7;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: j1  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public final class j1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public j1(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        View view2;
        WindowInsetsCompat windowInsetsCompat2;
        int i;
        int i2;
        boolean z2;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i4;
        int e = windowInsetsCompat.e();
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.getClass();
        int e2 = windowInsetsCompat.e();
        ActionBarContextView actionBarContextView = appCompatDelegateImpl.f921a;
        int i5 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.f921a.getLayoutParams();
            boolean z3 = true;
            if (appCompatDelegateImpl.f921a.isShown()) {
                if (appCompatDelegateImpl.f904a == null) {
                    appCompatDelegateImpl.f904a = new Rect();
                    appCompatDelegateImpl.b = new Rect();
                }
                Rect rect = appCompatDelegateImpl.f904a;
                Rect rect2 = appCompatDelegateImpl.b;
                rect.set(windowInsetsCompat.c(), windowInsetsCompat.e(), windowInsetsCompat.d(), windowInsetsCompat.b());
                ViewGroup viewGroup = appCompatDelegateImpl.f906a;
                Method method = UC.a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, new Object[]{rect, rect2});
                    } catch (Exception unused) {
                    }
                }
                int i6 = rect.top;
                int i7 = rect.left;
                int i8 = rect.right;
                ViewGroup viewGroup2 = appCompatDelegateImpl.f906a;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                WindowInsetsCompat a2 = f.e.a(viewGroup2);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.c();
                }
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.d();
                }
                if (marginLayoutParams2.topMargin == i6 && marginLayoutParams2.leftMargin == i7 && marginLayoutParams2.rightMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams2.topMargin = i6;
                    marginLayoutParams2.leftMargin = i7;
                    marginLayoutParams2.rightMargin = i8;
                    z2 = true;
                }
                Context context = appCompatDelegateImpl.f902a;
                if (i6 <= 0 || appCompatDelegateImpl.f905a != null) {
                    View view3 = appCompatDelegateImpl.f905a;
                    if (!(view3 == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams()).height == (i4 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i && marginLayoutParams.rightMargin == i2))) {
                        marginLayoutParams.height = i4;
                        marginLayoutParams.leftMargin = i;
                        marginLayoutParams.rightMargin = i2;
                        appCompatDelegateImpl.f905a.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view4 = new View(context);
                    appCompatDelegateImpl.f905a = view4;
                    view4.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i;
                    layoutParams.rightMargin = i2;
                    appCompatDelegateImpl.f906a.addView(appCompatDelegateImpl.f905a, -1, layoutParams);
                }
                View view5 = appCompatDelegateImpl.f905a;
                if (view5 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && view5.getVisibility() != 0) {
                    View view6 = appCompatDelegateImpl.f905a;
                    if ((view6.getWindowSystemUiVisibility() & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0) {
                        z3 = false;
                    }
                    if (z3) {
                        int i9 = C0299pr.abc_decor_view_status_guard_light;
                        Object obj = d7.a;
                        i3 = d7.b.a(context, i9);
                    } else {
                        int i10 = C0299pr.abc_decor_view_status_guard;
                        Object obj2 = d7.a;
                        i3 = d7.b.a(context, i10);
                    }
                    view6.setBackgroundColor(i3);
                }
                if (!appCompatDelegateImpl.h && z) {
                    e2 = 0;
                }
                z3 = z2;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z = false;
            } else {
                z3 = false;
                z = false;
            }
            if (z3) {
                appCompatDelegateImpl.f921a.setLayoutParams(marginLayoutParams2);
            }
        }
        View view7 = appCompatDelegateImpl.f905a;
        if (view7 != null) {
            if (!z) {
                i5 = 8;
            }
            view7.setVisibility(i5);
        }
        if (e != e2) {
            windowInsetsCompat2 = windowInsetsCompat.g(windowInsetsCompat.c(), e2, windowInsetsCompat.d(), windowInsetsCompat.b());
            view2 = view;
        } else {
            view2 = view;
            windowInsetsCompat2 = windowInsetsCompat;
        }
        return f.j(view2, windowInsetsCompat2);
    }
}
