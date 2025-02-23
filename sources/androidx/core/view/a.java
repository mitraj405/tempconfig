package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SoftwareKeyboardControllerCompat */
public final class a {
    public final C0012a a;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    /* compiled from: SoftwareKeyboardControllerCompat */
    public static class C0012a extends c {
        public final View a;

        public C0012a(View view) {
            this.a = view;
        }

        public void a() {
            View view = this.a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        public void b() {
            View view;
            View view2 = this.a;
            if (view2 != null) {
                if (view2.isInEditMode() || view2.onCheckIsTextEditor()) {
                    view2.requestFocus();
                    view = view2;
                } else {
                    view = view2.getRootView().findFocus();
                }
                if (view == null) {
                    view = view2.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new C0140b6(view, 3));
                }
            }
        }
    }

    /* compiled from: SoftwareKeyboardControllerCompat */
    public static class c {
    }

    public a(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new b(view);
        } else {
            this.a = new C0012a(view);
        }
    }

    /* compiled from: SoftwareKeyboardControllerCompat */
    public static class b extends C0012a {
        public final WindowInsetsController a;
        public final View b;

        public b(View view) {
            super(view);
            this.b = view;
        }

        public final void a() {
            View view = this.b;
            WindowInsetsController windowInsetsController = this.a;
            if (windowInsetsController == null) {
                if (view != null) {
                    windowInsetsController = view.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                C0372vx vxVar = new C0372vx(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(vxVar);
                if (!atomicBoolean.get() && view != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(vxVar);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        public final void b() {
            View view = this.b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.a;
            if (windowInsetsController == null) {
                if (view != null) {
                    windowInsetsController = view.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.b();
            }
        }

        public b(WindowInsetsController windowInsetsController) {
            super((View) null);
            this.a = windowInsetsController;
        }
    }

    @Deprecated
    public a(WindowInsetsController windowInsetsController) {
        this.a = new b(windowInsetsController);
    }
}
