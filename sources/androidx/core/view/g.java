package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: WindowInsetsControllerCompat */
public final class g {
    public final e a;

    /* compiled from: WindowInsetsControllerCompat */
    public static class a extends e {
        public final Window a;

        /* renamed from: a  reason: collision with other field name */
        public final a f1848a;

        public a(Window window, a aVar) {
            this.a = window;
            this.f1848a = aVar;
        }

        public final void a() {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((8 & i) != 0) {
                    if (i == 1) {
                        f(4);
                    } else if (i == 2) {
                        f(2);
                    } else if (i == 8) {
                        this.f1848a.a.a();
                    }
                }
            }
        }

        public final void e() {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((8 & i) != 0) {
                    if (i == 1) {
                        g(4);
                        this.a.clearFlags(UserMetadata.MAX_ATTRIBUTE_SIZE);
                    } else if (i == 2) {
                        g(2);
                    } else if (i == 8) {
                        this.f1848a.a.b();
                    }
                }
            }
        }

        public final void f(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public final void g(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }
    }

    /* compiled from: WindowInsetsControllerCompat */
    public static class b extends a {
        public b(Window window, a aVar) {
            super(window, aVar);
        }

        public final boolean b() {
            if ((this.a.getDecorView().getSystemUiVisibility() & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0) {
                return true;
            }
            return false;
        }

        public final void d(boolean z) {
            if (z) {
                Window window = this.a;
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                f(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                return;
            }
            g(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        }
    }

    /* compiled from: WindowInsetsControllerCompat */
    public static class c extends b {
        public c(Window window, a aVar) {
            super(window, aVar);
        }

        public final void c(boolean z) {
            if (z) {
                Window window = this.a;
                window.clearFlags(134217728);
                window.addFlags(Integer.MIN_VALUE);
                f(16);
                return;
            }
            g(16);
        }
    }

    /* compiled from: WindowInsetsControllerCompat */
    public static class e {
        public void a() {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z) {
            throw null;
        }

        public void d(boolean z) {
            throw null;
        }

        public void e() {
            throw null;
        }
    }

    @Deprecated
    public g(WindowInsetsController windowInsetsController) {
        this.a = new d(windowInsetsController, new a(windowInsetsController));
    }

    /* compiled from: WindowInsetsControllerCompat */
    public static class d extends e {
        public final Window a;

        /* renamed from: a  reason: collision with other field name */
        public final WindowInsetsController f1849a;

        /* renamed from: a  reason: collision with other field name */
        public final a f1850a;

        public d(Window window, a aVar) {
            this(window.getInsetsController(), aVar);
            this.a = window;
        }

        public final void a() {
            this.f1850a.a.a();
            this.f1849a.hide(0);
        }

        public final boolean b() {
            WindowInsetsController windowInsetsController = this.f1849a;
            windowInsetsController.setSystemBarsAppearance(0, 0);
            if ((windowInsetsController.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
            return false;
        }

        public final void c(boolean z) {
            WindowInsetsController windowInsetsController = this.f1849a;
            Window window = this.a;
            if (z) {
                if (window != null) {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                }
                windowInsetsController.setSystemBarsAppearance(16, 16);
                return;
            }
            if (window != null) {
                View decorView2 = window.getDecorView();
                decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -17);
            }
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }

        public final void d(boolean z) {
            WindowInsetsController windowInsetsController = this.f1849a;
            Window window = this.a;
            if (z) {
                if (window != null) {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | UserMetadata.MAX_INTERNAL_KEY_SIZE);
                }
                windowInsetsController.setSystemBarsAppearance(8, 8);
                return;
            }
            if (window != null) {
                View decorView2 = window.getDecorView();
                decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -8193);
            }
            windowInsetsController.setSystemBarsAppearance(0, 8);
        }

        public final void e() {
            this.f1850a.a.b();
            this.f1849a.show(0);
        }

        public d(WindowInsetsController windowInsetsController, a aVar) {
            new SimpleArrayMap();
            this.f1849a = windowInsetsController;
            this.f1850a = aVar;
        }
    }

    public g(Window window, View view) {
        a aVar = new a(view);
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(window, aVar);
        } else {
            this.a = new c(window, aVar);
        }
    }
}
