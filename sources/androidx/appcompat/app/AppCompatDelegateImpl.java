package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.TintTypedArray;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.ki;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;

public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static final SimpleArrayMap<String, Integer> a = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f899a = {16842836};
    public static final boolean s = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean t = true;

    /* renamed from: a  reason: collision with other field name */
    public GC f900a = null;

    /* renamed from: a  reason: collision with other field name */
    public Iy f901a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f902a;

    /* renamed from: a  reason: collision with other field name */
    public Configuration f903a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f904a;

    /* renamed from: a  reason: collision with other field name */
    public View f905a;

    /* renamed from: a  reason: collision with other field name */
    public ViewGroup f906a;

    /* renamed from: a  reason: collision with other field name */
    public Window f907a;

    /* renamed from: a  reason: collision with other field name */
    public PopupWindow f908a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f909a;

    /* renamed from: a  reason: collision with other field name */
    public OnBackInvokedCallback f910a;

    /* renamed from: a  reason: collision with other field name */
    public OnBackInvokedDispatcher f911a;

    /* renamed from: a  reason: collision with other field name */
    public PanelFeatureState f912a;

    /* renamed from: a  reason: collision with other field name */
    public final a f913a = new a();

    /* renamed from: a  reason: collision with other field name */
    public b f914a;

    /* renamed from: a  reason: collision with other field name */
    public f f915a;

    /* renamed from: a  reason: collision with other field name */
    public g f916a;

    /* renamed from: a  reason: collision with other field name */
    public i f917a;

    /* renamed from: a  reason: collision with other field name */
    public k f918a;

    /* renamed from: a  reason: collision with other field name */
    public h f919a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMode f920a;

    /* renamed from: a  reason: collision with other field name */
    public ActionBarContextView f921a;

    /* renamed from: a  reason: collision with other field name */
    public final C0199g1 f922a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f923a;

    /* renamed from: a  reason: collision with other field name */
    public C0252l1 f924a;

    /* renamed from: a  reason: collision with other field name */
    public C0267m8 f925a;

    /* renamed from: a  reason: collision with other field name */
    public v1 f926a;

    /* renamed from: a  reason: collision with other field name */
    public PanelFeatureState[] f927a;
    public Rect b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f928b = true;
    public final Object c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f929c;
    public final int d = -100;

    /* renamed from: d  reason: collision with other field name */
    public boolean f930d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f931e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f932f;
    public int g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f933g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    public static final class PanelFeatureState {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public Bundle f934a;

        /* renamed from: a  reason: collision with other field name */
        public View f935a;

        /* renamed from: a  reason: collision with other field name */
        public j f936a;

        /* renamed from: a  reason: collision with other field name */
        public MenuBuilder f937a;

        /* renamed from: a  reason: collision with other field name */
        public androidx.appcompat.view.menu.d f938a;

        /* renamed from: a  reason: collision with other field name */
        public C0190f7 f939a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f940a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public View f941b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f942b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f943c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f944d = false;
        public boolean e;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public Bundle a;

            /* renamed from: a  reason: collision with other field name */
            public boolean f945a;
            public int c;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.b(parcel, classLoader);
                }

                public final Object[] newArray(int i) {
                    return new SavedState[i];
                }

                public final Object createFromParcel(Parcel parcel) {
                    return SavedState.b(parcel, (ClassLoader) null);
                }
            }

            public static SavedState b(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.c = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f945a = z;
                if (z) {
                    savedState.a = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.c);
                parcel.writeInt(this.f945a ? 1 : 0);
                if (this.f945a) {
                    parcel.writeBundle(this.a);
                }
            }
        }

        public PanelFeatureState(int i) {
            this.a = i;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.g & 1) != 0) {
                appCompatDelegateImpl.F(0);
            }
            if ((appCompatDelegateImpl.g & 4096) != 0) {
                appCompatDelegateImpl.F(108);
            }
            appCompatDelegateImpl.q = false;
            appCompatDelegateImpl.g = 0;
        }
    }

    public final class b implements MenuPresenter.Callback {
        public b() {
        }

        public final boolean a(MenuBuilder menuBuilder) {
            Window.Callback K = AppCompatDelegateImpl.this.K();
            if (K == null) {
                return true;
            }
            K.onMenuOpened(108, menuBuilder);
            return true;
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.B(menuBuilder);
        }
    }

    public class c implements ActionMode.Callback {

        /* renamed from: a  reason: collision with other field name */
        public final ActionMode.Callback f946a;

        public class a extends C1488xu {
            public a() {
            }

            public final void onAnimationEnd() {
                c cVar = c.this;
                AppCompatDelegateImpl.this.f921a.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f908a;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f921a.getParent() instanceof View) {
                    WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                    f.c.c((View) appCompatDelegateImpl.f921a.getParent());
                }
                appCompatDelegateImpl.f921a.h();
                appCompatDelegateImpl.f900a.d((IC) null);
                appCompatDelegateImpl.f900a = null;
                ViewGroup viewGroup = appCompatDelegateImpl.f906a;
                WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
                f.c.c(viewGroup);
            }
        }

        public c(b.a aVar) {
            this.f946a = aVar;
        }

        public final void a(ActionMode actionMode) {
            this.f946a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f908a != null) {
                appCompatDelegateImpl.f907a.getDecorView().removeCallbacks(appCompatDelegateImpl.f924a);
            }
            if (appCompatDelegateImpl.f921a != null) {
                GC gc = appCompatDelegateImpl.f900a;
                if (gc != null) {
                    gc.b();
                }
                GC a2 = androidx.core.view.f.a(appCompatDelegateImpl.f921a);
                a2.a(0.0f);
                appCompatDelegateImpl.f900a = a2;
                a2.d(new a());
            }
            C0199g1 g1Var = appCompatDelegateImpl.f922a;
            if (g1Var != null) {
                g1Var.onSupportActionModeFinished(appCompatDelegateImpl.f920a);
            }
            appCompatDelegateImpl.f920a = null;
            ViewGroup viewGroup = appCompatDelegateImpl.f906a;
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.c.c(viewGroup);
            appCompatDelegateImpl.S();
        }

        public final boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f946a.b(actionMode, menuItem);
        }

        public final boolean c(ActionMode actionMode, MenuBuilder menuBuilder) {
            ViewGroup viewGroup = AppCompatDelegateImpl.this.f906a;
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.c.c(viewGroup);
            return this.f946a.c(actionMode, menuBuilder);
        }

        public final boolean d(ActionMode actionMode, MenuBuilder menuBuilder) {
            return this.f946a.d(actionMode, menuBuilder);
        }
    }

    public static class d {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        public static ki b(Configuration configuration) {
            return ki.a(configuration.getLocales().toLanguageTags());
        }

        public static void c(ki kiVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(kiVar.f3053a.c()));
        }

        public static void d(Configuration configuration, ki kiVar) {
            configuration.setLocales(LocaleList.forLanguageTags(kiVar.f3053a.c()));
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            Hn hn = new Hn(appCompatDelegateImpl, 1);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, hn);
            return hn;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class f extends DD {

        /* renamed from: a  reason: collision with other field name */
        public boolean f947a;
        public boolean b;
        public boolean c;

        public f(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public final void a(Window.Callback callback) {
            try {
                this.f947a = true;
                callback.onContentChanged();
                this.f947a = false;
            } catch (Throwable th) {
                this.f947a = false;
                throw th;
            }
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.b) {
                return this.a.dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.E(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
            if (r0 != false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            if (r7 != false) goto L_0x0067;
         */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
            /*
                r6 = this;
                boolean r0 = super.dispatchKeyShortcutEvent(r7)
                r1 = 1
                if (r0 != 0) goto L_0x006e
                int r0 = r7.getKeyCode()
                androidx.appcompat.app.AppCompatDelegateImpl r2 = androidx.appcompat.app.AppCompatDelegateImpl.this
                r2.L()
                androidx.appcompat.app.h r3 = r2.f919a
                r4 = 0
                if (r3 == 0) goto L_0x003b
                androidx.appcompat.app.h$d r3 = r3.f967a
                if (r3 != 0) goto L_0x001a
                goto L_0x0037
            L_0x001a:
                androidx.appcompat.view.menu.MenuBuilder r3 = r3.f979a
                if (r3 == 0) goto L_0x0037
                int r5 = r7.getDeviceId()
                android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
                int r5 = r5.getKeyboardType()
                if (r5 == r1) goto L_0x002e
                r5 = r1
                goto L_0x002f
            L_0x002e:
                r5 = r4
            L_0x002f:
                r3.setQwertyMode(r5)
                boolean r0 = r3.performShortcut(r0, r7, r4)
                goto L_0x0038
            L_0x0037:
                r0 = r4
            L_0x0038:
                if (r0 == 0) goto L_0x003b
                goto L_0x0067
            L_0x003b:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.f912a
                if (r0 == 0) goto L_0x0050
                int r3 = r7.getKeyCode()
                boolean r0 = r2.P(r0, r3, r7)
                if (r0 == 0) goto L_0x0050
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r7 = r2.f912a
                if (r7 == 0) goto L_0x0067
                r7.f942b = r1
                goto L_0x0067
            L_0x0050:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.f912a
                if (r0 != 0) goto L_0x0069
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.J(r4)
                r2.Q(r0, r7)
                int r3 = r7.getKeyCode()
                boolean r7 = r2.P(r0, r3, r7)
                r0.f940a = r4
                if (r7 == 0) goto L_0x0069
            L_0x0067:
                r7 = r1
                goto L_0x006a
            L_0x0069:
                r7 = r4
            L_0x006a:
                if (r7 == 0) goto L_0x006d
                goto L_0x006e
            L_0x006d:
                r1 = r4
            L_0x006e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.f.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        public final void onContentChanged() {
            if (this.f947a) {
                this.a.onContentChanged();
            }
        }

        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public final View onCreatePanelView(int i) {
            return super.onCreatePanelView(i);
        }

        public final boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.L();
                h hVar = appCompatDelegateImpl.f919a;
                if (hVar != null) {
                    hVar.b(true);
                }
            } else {
                appCompatDelegateImpl.getClass();
            }
            return true;
        }

        public final void onPanelClosed(int i, Menu menu) {
            if (this.c) {
                this.a.onPanelClosed(i, menu);
                return;
            }
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.L();
                h hVar = appCompatDelegateImpl.f919a;
                if (hVar != null) {
                    hVar.b(false);
                }
            } else if (i == 0) {
                PanelFeatureState J = appCompatDelegateImpl.J(i);
                if (J.f943c) {
                    appCompatDelegateImpl.C(J, false);
                }
            } else {
                appCompatDelegateImpl.getClass();
            }
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.J(0).f937a;
            if (menuBuilder != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0184, code lost:
            if (r10.isLaidOut() != false) goto L_0x0188;
         */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0097  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10, int r11) {
            /*
                r9 = this;
                androidx.appcompat.app.AppCompatDelegateImpl r0 = androidx.appcompat.app.AppCompatDelegateImpl.this
                boolean r1 = r0.f928b
                if (r1 == 0) goto L_0x01f5
                if (r11 == 0) goto L_0x000a
                goto L_0x01f5
            L_0x000a:
                androidx.appcompat.view.b$a r11 = new androidx.appcompat.view.b$a
                android.content.Context r1 = r0.f902a
                r11.<init>(r1, r10)
                androidx.appcompat.view.ActionMode r10 = r0.f920a
                if (r10 == 0) goto L_0x0018
                r10.a()
            L_0x0018:
                androidx.appcompat.app.AppCompatDelegateImpl$c r10 = new androidx.appcompat.app.AppCompatDelegateImpl$c
                r10.<init>(r11)
                r0.L()
                androidx.appcompat.app.h r1 = r0.f919a
                r2 = 0
                r3 = 1
                r4 = 0
                g1 r5 = r0.f922a
                if (r1 == 0) goto L_0x0073
                androidx.appcompat.app.h$d r6 = r1.f967a
                if (r6 == 0) goto L_0x0030
                r6.a()
            L_0x0030:
                androidx.appcompat.widget.ActionBarOverlayLayout r6 = r1.f971a
                r6.setHideOnContentScrollEnabled(r2)
                androidx.appcompat.widget.ActionBarContextView r6 = r1.f970a
                r6.h()
                androidx.appcompat.app.h$d r6 = new androidx.appcompat.app.h$d
                androidx.appcompat.widget.ActionBarContextView r7 = r1.f970a
                android.content.Context r7 = r7.getContext()
                r6.<init>(r7, r10)
                androidx.appcompat.view.menu.MenuBuilder r7 = r6.f979a
                r7.stopDispatchingItemsChanged()
                androidx.appcompat.view.ActionMode$Callback r8 = r6.f978a     // Catch:{ all -> 0x006e }
                boolean r8 = r8.d(r6, r7)     // Catch:{ all -> 0x006e }
                r7.startDispatchingItemsChanged()
                if (r8 == 0) goto L_0x0063
                r1.f967a = r6
                r6.g()
                androidx.appcompat.widget.ActionBarContextView r7 = r1.f970a
                r7.f(r6)
                r1.a(r3)
                goto L_0x0064
            L_0x0063:
                r6 = r4
            L_0x0064:
                r0.f920a = r6
                if (r6 == 0) goto L_0x0073
                if (r5 == 0) goto L_0x0073
                r5.onSupportActionModeStarted(r6)
                goto L_0x0073
            L_0x006e:
                r10 = move-exception
                r7.startDispatchingItemsChanged()
                throw r10
            L_0x0073:
                androidx.appcompat.view.ActionMode r1 = r0.f920a
                if (r1 != 0) goto L_0x01e9
                GC r1 = r0.f900a
                if (r1 == 0) goto L_0x007e
                r1.b()
            L_0x007e:
                androidx.appcompat.view.ActionMode r1 = r0.f920a
                if (r1 == 0) goto L_0x0085
                r1.a()
            L_0x0085:
                if (r5 == 0) goto L_0x0090
                boolean r1 = r0.o
                if (r1 != 0) goto L_0x0090
                androidx.appcompat.view.ActionMode r1 = r5.onWindowStartingSupportActionMode(r10)     // Catch:{ AbstractMethodError -> 0x0090 }
                goto L_0x0091
            L_0x0090:
                r1 = r4
            L_0x0091:
                if (r1 == 0) goto L_0x0097
                r0.f920a = r1
                goto L_0x01d9
            L_0x0097:
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                if (r1 != 0) goto L_0x0147
                boolean r1 = r0.i
                android.content.Context r6 = r0.f902a
                if (r1 == 0) goto L_0x011b
                android.util.TypedValue r1 = new android.util.TypedValue
                r1.<init>()
                android.content.res.Resources$Theme r7 = r6.getTheme()
                int r8 = defpackage.C0220hr.actionBarTheme
                r7.resolveAttribute(r8, r1, r3)
                int r8 = r1.resourceId
                if (r8 == 0) goto L_0x00d0
                android.content.res.Resources r8 = r6.getResources()
                android.content.res.Resources$Theme r8 = r8.newTheme()
                r8.setTo(r7)
                int r7 = r1.resourceId
                r8.applyStyle(r7, r3)
                f7 r7 = new f7
                r7.<init>(r6, r2)
                android.content.res.Resources$Theme r6 = r7.getTheme()
                r6.setTo(r8)
                r6 = r7
            L_0x00d0:
                androidx.appcompat.widget.ActionBarContextView r7 = new androidx.appcompat.widget.ActionBarContextView
                r7.<init>(r6)
                r0.f921a = r7
                android.widget.PopupWindow r7 = new android.widget.PopupWindow
                int r8 = defpackage.C0220hr.actionModePopupWindowStyle
                r7.<init>(r6, r4, r8)
                r0.f908a = r7
                r8 = 2
                defpackage.Vp.d(r7, r8)
                android.widget.PopupWindow r7 = r0.f908a
                androidx.appcompat.widget.ActionBarContextView r8 = r0.f921a
                r7.setContentView(r8)
                android.widget.PopupWindow r7 = r0.f908a
                r8 = -1
                r7.setWidth(r8)
                android.content.res.Resources$Theme r7 = r6.getTheme()
                int r8 = defpackage.C0220hr.actionBarSize
                r7.resolveAttribute(r8, r1, r3)
                int r1 = r1.data
                android.content.res.Resources r6 = r6.getResources()
                android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
                int r1 = android.util.TypedValue.complexToDimensionPixelSize(r1, r6)
                androidx.appcompat.widget.ActionBarContextView r6 = r0.f921a
                r6.setContentHeight(r1)
                android.widget.PopupWindow r1 = r0.f908a
                r6 = -2
                r1.setHeight(r6)
                l1 r1 = new l1
                r1.<init>(r0)
                r0.f924a = r1
                goto L_0x0147
            L_0x011b:
                android.view.ViewGroup r1 = r0.f906a
                int r7 = defpackage.Gr.action_mode_bar_stub
                android.view.View r1 = r1.findViewById(r7)
                androidx.appcompat.widget.ViewStubCompat r1 = (androidx.appcompat.widget.ViewStubCompat) r1
                if (r1 == 0) goto L_0x0147
                r0.L()
                androidx.appcompat.app.h r7 = r0.f919a
                if (r7 == 0) goto L_0x0133
                android.content.Context r7 = r7.d()
                goto L_0x0134
            L_0x0133:
                r7 = r4
            L_0x0134:
                if (r7 != 0) goto L_0x0137
                goto L_0x0138
            L_0x0137:
                r6 = r7
            L_0x0138:
                android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
                r1.setLayoutInflater(r6)
                android.view.View r1 = r1.a()
                androidx.appcompat.widget.ActionBarContextView r1 = (androidx.appcompat.widget.ActionBarContextView) r1
                r0.f921a = r1
            L_0x0147:
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                if (r1 == 0) goto L_0x01d9
                GC r1 = r0.f900a
                if (r1 == 0) goto L_0x0152
                r1.b()
            L_0x0152:
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                r1.h()
                androidx.appcompat.view.a r1 = new androidx.appcompat.view.a
                androidx.appcompat.widget.ActionBarContextView r6 = r0.f921a
                android.content.Context r6 = r6.getContext()
                androidx.appcompat.widget.ActionBarContextView r7 = r0.f921a
                r1.<init>(r6, r7, r10)
                androidx.appcompat.view.menu.MenuBuilder r6 = r1.f988a
                boolean r10 = r10.d(r1, r6)
                if (r10 == 0) goto L_0x01d7
                r1.g()
                androidx.appcompat.widget.ActionBarContextView r10 = r0.f921a
                r10.f(r1)
                r0.f920a = r1
                boolean r10 = r0.f929c
                if (r10 == 0) goto L_0x0187
                android.view.ViewGroup r10 = r0.f906a
                if (r10 == 0) goto L_0x0187
                java.util.WeakHashMap<android.view.View, GC> r1 = androidx.core.view.f.f1839a
                boolean r10 = r10.isLaidOut()
                if (r10 == 0) goto L_0x0187
                goto L_0x0188
            L_0x0187:
                r3 = r2
            L_0x0188:
                r10 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x01a6
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                r2 = 0
                r1.setAlpha(r2)
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                GC r1 = androidx.core.view.f.a(r1)
                r1.a(r10)
                r0.f900a = r1
                m1 r10 = new m1
                r10.<init>(r0)
                r1.d(r10)
                goto L_0x01c7
            L_0x01a6:
                androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
                r1.setAlpha(r10)
                androidx.appcompat.widget.ActionBarContextView r10 = r0.f921a
                r10.setVisibility(r2)
                androidx.appcompat.widget.ActionBarContextView r10 = r0.f921a
                android.view.ViewParent r10 = r10.getParent()
                boolean r10 = r10 instanceof android.view.View
                if (r10 == 0) goto L_0x01c7
                androidx.appcompat.widget.ActionBarContextView r10 = r0.f921a
                android.view.ViewParent r10 = r10.getParent()
                android.view.View r10 = (android.view.View) r10
                java.util.WeakHashMap<android.view.View, GC> r1 = androidx.core.view.f.f1839a
                androidx.core.view.f.c.c(r10)
            L_0x01c7:
                android.widget.PopupWindow r10 = r0.f908a
                if (r10 == 0) goto L_0x01d9
                android.view.Window r10 = r0.f907a
                android.view.View r10 = r10.getDecorView()
                l1 r1 = r0.f924a
                r10.post(r1)
                goto L_0x01d9
            L_0x01d7:
                r0.f920a = r4
            L_0x01d9:
                androidx.appcompat.view.ActionMode r10 = r0.f920a
                if (r10 == 0) goto L_0x01e2
                if (r5 == 0) goto L_0x01e2
                r5.onSupportActionModeStarted(r10)
            L_0x01e2:
                r0.S()
                androidx.appcompat.view.ActionMode r10 = r0.f920a
                r0.f920a = r10
            L_0x01e9:
                r0.S()
                androidx.appcompat.view.ActionMode r10 = r0.f920a
                if (r10 == 0) goto L_0x01f4
                androidx.appcompat.view.b r4 = r11.e(r10)
            L_0x01f4:
                return r4
            L_0x01f5:
                android.view.ActionMode r10 = super.onWindowStartingActionMode(r10, r11)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.f.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
        }
    }

    public class g extends h {
        public final PowerManager a;

        public g(Context context) {
            super();
            this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public final int c() {
            if (this.a.isPowerSaveMode()) {
                return 2;
            }
            return 1;
        }

        public final void d() {
            AppCompatDelegateImpl.this.x(true, true);
        }
    }

    public abstract class h {
        public a a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public final void onReceive(Context context, Intent intent) {
                h.this.d();
            }
        }

        public h() {
        }

        public final void a() {
            a aVar = this.a;
            if (aVar != null) {
                try {
                    AppCompatDelegateImpl.this.f902a.unregisterReceiver(aVar);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public final void e() {
            a();
            IntentFilter b = b();
            if (b != null && b.countActions() != 0) {
                if (this.a == null) {
                    this.a = new a();
                }
                AppCompatDelegateImpl.this.f902a.registerReceiver(this.a, b);
            }
        }
    }

    public class i extends h {
        public final OA a;

        public i(OA oa) {
            super();
            this.a = oa;
        }

        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00da  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int c() {
            /*
                r22 = this;
                r0 = r22
                OA r1 = r0.a
                OA$a r2 = r1.f468a
                long r3 = r2.a
                long r5 = java.lang.System.currentTimeMillis()
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                r4 = 1
                r5 = 0
                if (r3 <= 0) goto L_0x0014
                r3 = r4
                goto L_0x0015
            L_0x0014:
                r3 = r5
            L_0x0015:
                if (r3 == 0) goto L_0x001b
                boolean r1 = r2.f471a
                goto L_0x00ed
            L_0x001b:
                android.content.Context r3 = r1.f469a
                java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
                int r6 = defpackage.r1.k(r3, r6)
                r7 = 0
                android.location.LocationManager r1 = r1.f470a
                if (r6 != 0) goto L_0x0035
                java.lang.String r6 = "network"
                boolean r8 = r1.isProviderEnabled(r6)     // Catch:{ Exception -> 0x0035 }
                if (r8 == 0) goto L_0x0035
                android.location.Location r6 = r1.getLastKnownLocation(r6)     // Catch:{ Exception -> 0x0035 }
                goto L_0x0036
            L_0x0035:
                r6 = r7
            L_0x0036:
                java.lang.String r8 = "android.permission.ACCESS_FINE_LOCATION"
                int r3 = defpackage.r1.k(r3, r8)
                if (r3 != 0) goto L_0x004b
                java.lang.String r3 = "gps"
                boolean r8 = r1.isProviderEnabled(r3)     // Catch:{ Exception -> 0x004b }
                if (r8 == 0) goto L_0x004b
                android.location.Location r1 = r1.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x004b }
                r7 = r1
            L_0x004b:
                if (r7 == 0) goto L_0x005c
                if (r6 == 0) goto L_0x005c
                long r8 = r7.getTime()
                long r10 = r6.getTime()
                int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r1 <= 0) goto L_0x005f
                goto L_0x005e
            L_0x005c:
                if (r7 == 0) goto L_0x005f
            L_0x005e:
                r6 = r7
            L_0x005f:
                if (r6 == 0) goto L_0x00da
                long r14 = java.lang.System.currentTimeMillis()
                NA r1 = defpackage.NA.a
                if (r1 != 0) goto L_0x0070
                NA r1 = new NA
                r1.<init>()
                defpackage.NA.a = r1
            L_0x0070:
                NA r1 = defpackage.NA.a
                r16 = 86400000(0x5265c00, double:4.2687272E-316)
                long r12 = r14 - r16
                double r8 = r6.getLatitude()
                double r10 = r6.getLongitude()
                r7 = r1
                r7.a(r8, r10, r12)
                double r8 = r6.getLatitude()
                double r10 = r6.getLongitude()
                r12 = r14
                r7.a(r8, r10, r12)
                int r3 = r1.f437a
                if (r3 != r4) goto L_0x0094
                r5 = r4
            L_0x0094:
                long r12 = r1.b
                long r10 = r1.f438a
                long r16 = r16 + r14
                double r8 = r6.getLatitude()
                double r18 = r6.getLongitude()
                r7 = r1
                r20 = r10
                r10 = r18
                r18 = r12
                r12 = r16
                r7.a(r8, r10, r12)
                long r6 = r1.b
                r8 = -1
                int r1 = (r18 > r8 ? 1 : (r18 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x00d1
                int r1 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r1 != 0) goto L_0x00bb
                goto L_0x00d1
            L_0x00bb:
                int r1 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
                r8 = 0
                if (r1 <= 0) goto L_0x00c3
                long r6 = r6 + r8
                goto L_0x00cc
            L_0x00c3:
                int r1 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                if (r1 <= 0) goto L_0x00ca
                long r6 = r20 + r8
                goto L_0x00cc
            L_0x00ca:
                long r6 = r18 + r8
            L_0x00cc:
                r8 = 60000(0xea60, double:2.9644E-319)
                long r6 = r6 + r8
                goto L_0x00d5
            L_0x00d1:
                r6 = 43200000(0x2932e00, double:2.1343636E-316)
                long r6 = r6 + r14
            L_0x00d5:
                r2.f471a = r5
                r2.a = r6
                goto L_0x00ec
            L_0x00da:
                java.util.Calendar r1 = java.util.Calendar.getInstance()
                r2 = 11
                int r1 = r1.get(r2)
                r2 = 6
                if (r1 < r2) goto L_0x00eb
                r2 = 22
                if (r1 < r2) goto L_0x00ec
            L_0x00eb:
                r5 = r4
            L_0x00ec:
                r1 = r5
            L_0x00ed:
                if (r1 == 0) goto L_0x00f0
                r4 = 2
            L_0x00f0:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.c():int");
        }

        public final void d() {
            AppCompatDelegateImpl.this.x(true, true);
        }
    }

    public class j extends ContentFrameLayout {
        public j(C0190f7 f7Var) {
            super(f7Var);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.E(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            boolean z;
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.C(appCompatDelegateImpl.J(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(r1.w(getContext(), i));
        }
    }

    public final class k implements MenuPresenter.Callback {
        public k() {
        }

        public final boolean a(MenuBuilder menuBuilder) {
            Window.Callback K;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f932f || (K = appCompatDelegateImpl.K()) == null || appCompatDelegateImpl.o) {
                return true;
            }
            K.onMenuOpened(108, menuBuilder);
            return true;
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            boolean z2;
            int i;
            PanelFeatureState panelFeatureState;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            int i2 = 0;
            if (rootMenu != menuBuilder) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                menuBuilder = rootMenu;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.f927a;
            if (panelFeatureStateArr != null) {
                i = panelFeatureStateArr.length;
            } else {
                i = 0;
            }
            while (true) {
                if (i2 < i) {
                    panelFeatureState = panelFeatureStateArr[i2];
                    if (panelFeatureState != null && panelFeatureState.f937a == menuBuilder) {
                        break;
                    }
                    i2++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState == null) {
                return;
            }
            if (z2) {
                appCompatDelegateImpl.A(panelFeatureState.a, panelFeatureState, rootMenu);
                appCompatDelegateImpl.C(panelFeatureState, true);
                return;
            }
            appCompatDelegateImpl.C(panelFeatureState, z);
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, C0199g1 g1Var, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer orDefault;
        AppCompatActivity appCompatActivity;
        this.f902a = context;
        this.f922a = g1Var;
        this.c = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.d = appCompatActivity.j().e();
            }
        }
        if (this.d == -100 && (orDefault = simpleArrayMap.getOrDefault(this.c.getClass().getName(), null)) != null) {
            this.d = orDefault.intValue();
            (simpleArrayMap = a).remove(this.c.getClass().getName());
        }
        if (window != null) {
            y(window);
        }
        o1.d();
    }

    public static Configuration D(Context context, int i2, ki kiVar, Configuration configuration, boolean z) {
        int i3;
        if (i2 == 1) {
            i3 = 16;
        } else if (i2 == 2) {
            i3 = 32;
        } else if (z) {
            i3 = 0;
        } else {
            i3 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        if (kiVar != null) {
            d.d(configuration2, kiVar);
        }
        return configuration2;
    }

    public static ki z(Context context) {
        ki kiVar;
        ki kiVar2;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 33 || (kiVar = AppCompatDelegate.f896a) == null) {
            return null;
        }
        ki b2 = d.b(context.getApplicationContext().getResources().getConfiguration());
        li liVar = kiVar.f3053a;
        if (liVar.isEmpty()) {
            kiVar2 = ki.a;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            while (true) {
                if (i2 >= b2.f3053a.size() + liVar.size()) {
                    break;
                }
                if (i2 < liVar.size()) {
                    locale = liVar.b(i2);
                } else {
                    locale = b2.f3053a.b(i2 - liVar.size());
                }
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            kiVar2 = new ki(new mi(ki.b.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        if (kiVar2.f3053a.isEmpty()) {
            return b2;
        }
        return kiVar2;
    }

    /* JADX INFO: finally extract failed */
    public final void A(int i2, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f927a;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.f937a;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f943c) && !this.o) {
            f fVar = this.f915a;
            Window.Callback callback = this.f907a.getCallback();
            fVar.getClass();
            try {
                fVar.c = true;
                callback.onPanelClosed(i2, menuBuilder);
                fVar.c = false;
            } catch (Throwable th) {
                fVar.c = false;
                throw th;
            }
        }
    }

    public final void B(MenuBuilder menuBuilder) {
        if (!this.k) {
            this.k = true;
            this.f925a.f();
            Window.Callback K = K();
            if (K != null && !this.o) {
                K.onPanelClosed(108, menuBuilder);
            }
            this.k = false;
        }
    }

    public final void C(PanelFeatureState panelFeatureState, boolean z) {
        j jVar;
        C0267m8 m8Var;
        if (!z || panelFeatureState.a != 0 || (m8Var = this.f925a) == null || !m8Var.a()) {
            WindowManager windowManager = (WindowManager) this.f902a.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f943c || (jVar = panelFeatureState.f936a) == null)) {
                windowManager.removeView(jVar);
                if (z) {
                    A(panelFeatureState.a, panelFeatureState, (MenuBuilder) null);
                }
            }
            panelFeatureState.f940a = false;
            panelFeatureState.f942b = false;
            panelFeatureState.f943c = false;
            panelFeatureState.f935a = null;
            panelFeatureState.f944d = true;
            if (this.f912a == panelFeatureState) {
                this.f912a = null;
            }
            if (panelFeatureState.a == 0) {
                S();
                return;
            }
            return;
        }
        B(panelFeatureState.f937a);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean E(android.view.KeyEvent r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.c
            boolean r1 = r0 instanceof androidx.core.view.KeyEventDispatcher.Component
            r2 = 1
            if (r1 != 0) goto L_0x000b
            boolean r0 = r0 instanceof androidx.appcompat.app.f
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            android.view.Window r0 = r6.f907a
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x001a
            boolean r0 = androidx.core.view.KeyEventDispatcher.a(r0, r7)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r0 = r7.getKeyCode()
            r1 = 82
            r3 = 0
            if (r0 != r1) goto L_0x003d
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = r6.f915a
            android.view.Window r4 = r6.f907a
            android.view.Window$Callback r4 = r4.getCallback()
            r0.getClass()
            r0.b = r2     // Catch:{ all -> 0x0039 }
            boolean r4 = r4.dispatchKeyEvent(r7)     // Catch:{ all -> 0x0039 }
            r0.b = r3
            if (r4 == 0) goto L_0x003d
            return r2
        L_0x0039:
            r7 = move-exception
            r0.b = r3
            throw r7
        L_0x003d:
            int r0 = r7.getKeyCode()
            int r4 = r7.getAction()
            if (r4 != 0) goto L_0x0049
            r4 = r2
            goto L_0x004a
        L_0x0049:
            r4 = r3
        L_0x004a:
            r5 = 4
            if (r4 == 0) goto L_0x0074
            if (r0 == r5) goto L_0x0066
            if (r0 == r1) goto L_0x0053
            goto L_0x00fb
        L_0x0053:
            int r0 = r7.getRepeatCount()
            if (r0 != 0) goto L_0x00fc
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.J(r3)
            boolean r1 = r0.f943c
            if (r1 != 0) goto L_0x00fc
            r6.Q(r0, r7)
            goto L_0x00fc
        L_0x0066:
            int r7 = r7.getFlags()
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            r6.l = r2
            goto L_0x00fb
        L_0x0074:
            if (r0 == r5) goto L_0x00f4
            if (r0 == r1) goto L_0x007a
            goto L_0x00fb
        L_0x007a:
            androidx.appcompat.view.ActionMode r0 = r6.f920a
            if (r0 == 0) goto L_0x0080
            goto L_0x00fc
        L_0x0080:
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.J(r3)
            m8 r1 = r6.f925a
            android.content.Context r4 = r6.f902a
            if (r1 == 0) goto L_0x00ba
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x00ba
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r4)
            boolean r1 = r1.hasPermanentMenuKey()
            if (r1 != 0) goto L_0x00ba
            m8 r1 = r6.f925a
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x00b3
            boolean r1 = r6.o
            if (r1 != 0) goto L_0x00da
            boolean r7 = r6.Q(r0, r7)
            if (r7 == 0) goto L_0x00da
            m8 r7 = r6.f925a
            boolean r7 = r7.e()
            goto L_0x00e0
        L_0x00b3:
            m8 r7 = r6.f925a
            boolean r7 = r7.c()
            goto L_0x00e0
        L_0x00ba:
            boolean r1 = r0.f943c
            if (r1 != 0) goto L_0x00dc
            boolean r5 = r0.f942b
            if (r5 == 0) goto L_0x00c3
            goto L_0x00dc
        L_0x00c3:
            boolean r1 = r0.f940a
            if (r1 == 0) goto L_0x00da
            boolean r1 = r0.e
            if (r1 == 0) goto L_0x00d2
            r0.f940a = r3
            boolean r1 = r6.Q(r0, r7)
            goto L_0x00d3
        L_0x00d2:
            r1 = r2
        L_0x00d3:
            if (r1 == 0) goto L_0x00da
            r6.O(r0, r7)
            r7 = r2
            goto L_0x00e0
        L_0x00da:
            r7 = r3
            goto L_0x00e0
        L_0x00dc:
            r6.C(r0, r2)
            r7 = r1
        L_0x00e0:
            if (r7 == 0) goto L_0x00fc
            android.content.Context r7 = r4.getApplicationContext()
            java.lang.String r0 = "audio"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.media.AudioManager r7 = (android.media.AudioManager) r7
            if (r7 == 0) goto L_0x00fc
            r7.playSoundEffect(r3)
            goto L_0x00fc
        L_0x00f4:
            boolean r7 = r6.N()
            if (r7 == 0) goto L_0x00fb
            goto L_0x00fc
        L_0x00fb:
            r2 = r3
        L_0x00fc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.E(android.view.KeyEvent):boolean");
    }

    public final void F(int i2) {
        PanelFeatureState J = J(i2);
        if (J.f937a != null) {
            Bundle bundle = new Bundle();
            J.f937a.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                J.f934a = bundle;
            }
            J.f937a.stopDispatchingItemsChanged();
            J.f937a.clear();
        }
        J.e = true;
        J.f944d = true;
        if ((i2 == 108 || i2 == 0) && this.f925a != null) {
            PanelFeatureState J2 = J(0);
            J2.f940a = false;
            Q(J2, (KeyEvent) null);
        }
    }

    public final void G() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.f929c) {
            int[] iArr = ps.AppCompatTheme;
            Context context2 = this.f902a;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            int i2 = ps.AppCompatTheme_windowActionBar;
            if (obtainStyledAttributes.hasValue(i2)) {
                if (obtainStyledAttributes.getBoolean(ps.AppCompatTheme_windowNoTitle, false)) {
                    r(1);
                } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                    r(108);
                }
                if (obtainStyledAttributes.getBoolean(ps.AppCompatTheme_windowActionBarOverlay, false)) {
                    r(109);
                }
                if (obtainStyledAttributes.getBoolean(ps.AppCompatTheme_windowActionModeOverlay, false)) {
                    r(10);
                }
                this.i = obtainStyledAttributes.getBoolean(ps.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                H();
                this.f907a.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (this.j) {
                    viewGroup = this.h ? (ViewGroup) from.inflate(Vr.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(Vr.abc_screen_simple, (ViewGroup) null);
                } else if (this.i) {
                    viewGroup = (ViewGroup) from.inflate(Vr.abc_dialog_title_material, (ViewGroup) null);
                    this.f933g = false;
                    this.f932f = false;
                } else if (this.f932f) {
                    TypedValue typedValue = new TypedValue();
                    context2.getTheme().resolveAttribute(C0220hr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new C0190f7(context2, typedValue.resourceId);
                    } else {
                        context = context2;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(Vr.abc_screen_toolbar, (ViewGroup) null);
                    C0267m8 m8Var = (C0267m8) viewGroup.findViewById(Gr.decor_content_parent);
                    this.f925a = m8Var;
                    m8Var.setWindowCallback(K());
                    if (this.f933g) {
                        this.f925a.g(109);
                    }
                    if (this.f930d) {
                        this.f925a.g(2);
                    }
                    if (this.f931e) {
                        this.f925a.g(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    j1 j1Var = new j1(this);
                    WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                    f.d.u(viewGroup, j1Var);
                    if (this.f925a == null) {
                        this.f909a = (TextView) viewGroup.findViewById(Gr.title);
                    }
                    Method method = UC.a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(Gr.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f907a.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                        }
                    }
                    this.f907a.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new C0244k1(this));
                    this.f906a = viewGroup;
                    Object obj = this.c;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f923a;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        C0267m8 m8Var2 = this.f925a;
                        if (m8Var2 != null) {
                            m8Var2.setWindowTitle(charSequence);
                        } else {
                            h hVar = this.f919a;
                            if (hVar != null) {
                                hVar.h(charSequence);
                            } else {
                                TextView textView = this.f909a;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f906a.findViewById(16908290);
                    View decorView = this.f907a.getDecorView();
                    contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(ps.AppCompatTheme);
                    obtainStyledAttributes2.getValue(ps.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(ps.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    int i3 = ps.AppCompatTheme_windowFixedWidthMajor;
                    if (obtainStyledAttributes2.hasValue(i3)) {
                        obtainStyledAttributes2.getValue(i3, contentFrameLayout2.getFixedWidthMajor());
                    }
                    int i4 = ps.AppCompatTheme_windowFixedWidthMinor;
                    if (obtainStyledAttributes2.hasValue(i4)) {
                        obtainStyledAttributes2.getValue(i4, contentFrameLayout2.getFixedWidthMinor());
                    }
                    int i5 = ps.AppCompatTheme_windowFixedHeightMajor;
                    if (obtainStyledAttributes2.hasValue(i5)) {
                        obtainStyledAttributes2.getValue(i5, contentFrameLayout2.getFixedHeightMajor());
                    }
                    int i6 = ps.AppCompatTheme_windowFixedHeightMinor;
                    if (obtainStyledAttributes2.hasValue(i6)) {
                        obtainStyledAttributes2.getValue(i6, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.f929c = true;
                    PanelFeatureState J = J(0);
                    if (!this.o && J.f937a == null) {
                        this.g |= 4096;
                        if (!this.q) {
                            View decorView2 = this.f907a.getDecorView();
                            WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
                            decorView2.postOnAnimation(this.f913a);
                            this.q = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
                sb.append(this.f932f);
                sb.append(", windowActionBarOverlay: ");
                sb.append(this.f933g);
                sb.append(", android:windowIsFloating: ");
                sb.append(this.i);
                sb.append(", windowActionModeOverlay: ");
                sb.append(this.h);
                sb.append(", windowNoTitle: ");
                throw new IllegalArgumentException(xx.G(sb, this.j, " }"));
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void H() {
        if (this.f907a == null) {
            Object obj = this.c;
            if (obj instanceof Activity) {
                y(((Activity) obj).getWindow());
            }
        }
        if (this.f907a == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final h I(Context context) {
        if (this.f917a == null) {
            if (OA.a == null) {
                Context applicationContext = context.getApplicationContext();
                OA.a = new OA(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
            }
            this.f917a = new i(OA.a);
        }
        return this.f917a;
    }

    public final PanelFeatureState J(int i2) {
        PanelFeatureState[] panelFeatureStateArr = this.f927a;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f927a = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final Window.Callback K() {
        return this.f907a.getCallback();
    }

    public final void L() {
        G();
        if (this.f932f && this.f919a == null) {
            Object obj = this.c;
            if (obj instanceof Activity) {
                this.f919a = new h(this.f933g, (Activity) obj);
            } else if (obj instanceof Dialog) {
                this.f919a = new h((Dialog) obj);
            }
            h hVar = this.f919a;
            if (hVar != null) {
                hVar.f(this.r);
            }
        }
    }

    public final int M(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        if (this.f916a == null) {
                            this.f916a = new g(context);
                        }
                        return this.f916a.c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return I(context).c();
            }
        }
        return i2;
    }

    public final boolean N() {
        boolean z;
        boolean z2 = this.l;
        this.l = false;
        PanelFeatureState J = J(0);
        if (J.f943c) {
            if (!z2) {
                C(J, true);
            }
            return true;
        }
        androidx.appcompat.view.ActionMode actionMode = this.f920a;
        if (actionMode != null) {
            actionMode.a();
            return true;
        }
        L();
        h hVar = this.f919a;
        if (hVar != null) {
            DecorToolbar decorToolbar = hVar.f972a;
            if (decorToolbar == null || !decorToolbar.o()) {
                z = false;
            } else {
                hVar.f972a.i();
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0152, code lost:
        if (r2 != null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0176, code lost:
        if (r2.f1066a.getCount() > 0) goto L_0x0178;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r18, android.view.KeyEvent r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1.f943c
            if (r2 != 0) goto L_0x01e0
            boolean r2 = r0.o
            if (r2 == 0) goto L_0x000e
            goto L_0x01e0
        L_0x000e:
            android.content.Context r2 = r0.f902a
            r3 = 0
            r4 = 1
            int r5 = r1.a
            if (r5 != 0) goto L_0x002b
            android.content.res.Resources r6 = r2.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.screenLayout
            r6 = r6 & 15
            r7 = 4
            if (r6 != r7) goto L_0x0027
            r6 = r4
            goto L_0x0028
        L_0x0027:
            r6 = r3
        L_0x0028:
            if (r6 == 0) goto L_0x002b
            return
        L_0x002b:
            android.view.Window$Callback r6 = r17.K()
            if (r6 == 0) goto L_0x003d
            androidx.appcompat.view.menu.MenuBuilder r7 = r1.f937a
            boolean r6 = r6.onMenuOpened(r5, r7)
            if (r6 != 0) goto L_0x003d
            r0.C(r1, r4)
            return
        L_0x003d:
            java.lang.String r6 = "window"
            java.lang.Object r6 = r2.getSystemService(r6)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            if (r6 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r7 = r17.Q(r18, r19)
            if (r7 != 0) goto L_0x004f
            return
        L_0x004f:
            androidx.appcompat.app.AppCompatDelegateImpl$j r7 = r1.f936a
            r8 = -2
            if (r7 == 0) goto L_0x006b
            boolean r9 = r1.f944d
            if (r9 == 0) goto L_0x0059
            goto L_0x006b
        L_0x0059:
            android.view.View r2 = r1.f941b
            if (r2 == 0) goto L_0x01b7
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 == 0) goto L_0x01b7
            int r2 = r2.width
            r7 = -1
            if (r2 != r7) goto L_0x01b7
            r10 = r7
            goto L_0x01b8
        L_0x006b:
            if (r7 != 0) goto L_0x00e5
            r17.L()
            androidx.appcompat.app.h r7 = r0.f919a
            if (r7 == 0) goto L_0x0079
            android.content.Context r7 = r7.d()
            goto L_0x007a
        L_0x0079:
            r7 = 0
        L_0x007a:
            if (r7 != 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r2 = r7
        L_0x007e:
            android.util.TypedValue r7 = new android.util.TypedValue
            r7.<init>()
            android.content.res.Resources r9 = r2.getResources()
            android.content.res.Resources$Theme r9 = r9.newTheme()
            android.content.res.Resources$Theme r10 = r2.getTheme()
            r9.setTo(r10)
            int r10 = defpackage.C0220hr.actionBarPopupTheme
            r9.resolveAttribute(r10, r7, r4)
            int r10 = r7.resourceId
            if (r10 == 0) goto L_0x009e
            r9.applyStyle(r10, r4)
        L_0x009e:
            int r10 = defpackage.C0220hr.panelMenuListTheme
            r9.resolveAttribute(r10, r7, r4)
            int r7 = r7.resourceId
            if (r7 == 0) goto L_0x00ab
            r9.applyStyle(r7, r4)
            goto L_0x00b0
        L_0x00ab:
            int r7 = defpackage.C0185es.Theme_AppCompat_CompactMenu
            r9.applyStyle(r7, r4)
        L_0x00b0:
            f7 r7 = new f7
            r7.<init>(r2, r3)
            android.content.res.Resources$Theme r2 = r7.getTheme()
            r2.setTo(r9)
            r1.f939a = r7
            int[] r2 = defpackage.ps.AppCompatTheme
            android.content.res.TypedArray r2 = r7.obtainStyledAttributes(r2)
            int r7 = defpackage.ps.AppCompatTheme_panelBackground
            int r7 = r2.getResourceId(r7, r3)
            r1.b = r7
            int r7 = defpackage.ps.AppCompatTheme_android_windowAnimationStyle
            int r7 = r2.getResourceId(r7, r3)
            r1.d = r7
            r2.recycle()
            androidx.appcompat.app.AppCompatDelegateImpl$j r2 = new androidx.appcompat.app.AppCompatDelegateImpl$j
            f7 r7 = r1.f939a
            r2.<init>(r7)
            r1.f936a = r2
            r2 = 81
            r1.c = r2
            goto L_0x00f4
        L_0x00e5:
            boolean r2 = r1.f944d
            if (r2 == 0) goto L_0x00f4
            int r2 = r7.getChildCount()
            if (r2 <= 0) goto L_0x00f4
            androidx.appcompat.app.AppCompatDelegateImpl$j r2 = r1.f936a
            r2.removeAllViews()
        L_0x00f4:
            android.view.View r2 = r1.f941b
            if (r2 == 0) goto L_0x00fb
            r1.f935a = r2
            goto L_0x0154
        L_0x00fb:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.f937a
            if (r2 != 0) goto L_0x0100
            goto L_0x0156
        L_0x0100:
            androidx.appcompat.app.AppCompatDelegateImpl$k r2 = r0.f918a
            if (r2 != 0) goto L_0x010b
            androidx.appcompat.app.AppCompatDelegateImpl$k r2 = new androidx.appcompat.app.AppCompatDelegateImpl$k
            r2.<init>()
            r0.f918a = r2
        L_0x010b:
            androidx.appcompat.app.AppCompatDelegateImpl$k r2 = r0.f918a
            androidx.appcompat.view.menu.d r7 = r1.f938a
            if (r7 != 0) goto L_0x0123
            androidx.appcompat.view.menu.d r7 = new androidx.appcompat.view.menu.d
            f7 r9 = r1.f939a
            int r10 = defpackage.Vr.abc_list_menu_item_layout
            r7.<init>(r9, r10)
            r1.f938a = r7
            r7.f1065a = r2
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.f937a
            r2.addMenuPresenter(r7)
        L_0x0123:
            androidx.appcompat.view.menu.d r2 = r1.f938a
            androidx.appcompat.app.AppCompatDelegateImpl$j r7 = r1.f936a
            androidx.appcompat.view.menu.ExpandedMenuView r9 = r2.f1063a
            if (r9 != 0) goto L_0x014e
            android.view.LayoutInflater r9 = r2.f1062a
            int r10 = defpackage.Vr.abc_expanded_menu_layout
            android.view.View r7 = r9.inflate(r10, r7, r3)
            androidx.appcompat.view.menu.ExpandedMenuView r7 = (androidx.appcompat.view.menu.ExpandedMenuView) r7
            r2.f1063a = r7
            androidx.appcompat.view.menu.d$a r7 = r2.f1066a
            if (r7 != 0) goto L_0x0142
            androidx.appcompat.view.menu.d$a r7 = new androidx.appcompat.view.menu.d$a
            r7.<init>()
            r2.f1066a = r7
        L_0x0142:
            androidx.appcompat.view.menu.ExpandedMenuView r7 = r2.f1063a
            androidx.appcompat.view.menu.d$a r9 = r2.f1066a
            r7.setAdapter(r9)
            androidx.appcompat.view.menu.ExpandedMenuView r7 = r2.f1063a
            r7.setOnItemClickListener(r2)
        L_0x014e:
            androidx.appcompat.view.menu.ExpandedMenuView r2 = r2.f1063a
            r1.f935a = r2
            if (r2 == 0) goto L_0x0156
        L_0x0154:
            r2 = r4
            goto L_0x0157
        L_0x0156:
            r2 = r3
        L_0x0157:
            if (r2 == 0) goto L_0x01de
            android.view.View r2 = r1.f935a
            if (r2 != 0) goto L_0x015e
            goto L_0x017a
        L_0x015e:
            android.view.View r2 = r1.f941b
            if (r2 == 0) goto L_0x0163
            goto L_0x0178
        L_0x0163:
            androidx.appcompat.view.menu.d r2 = r1.f938a
            androidx.appcompat.view.menu.d$a r7 = r2.f1066a
            if (r7 != 0) goto L_0x0170
            androidx.appcompat.view.menu.d$a r7 = new androidx.appcompat.view.menu.d$a
            r7.<init>()
            r2.f1066a = r7
        L_0x0170:
            androidx.appcompat.view.menu.d$a r2 = r2.f1066a
            int r2 = r2.getCount()
            if (r2 <= 0) goto L_0x017a
        L_0x0178:
            r2 = r4
            goto L_0x017b
        L_0x017a:
            r2 = r3
        L_0x017b:
            if (r2 != 0) goto L_0x017e
            goto L_0x01de
        L_0x017e:
            android.view.View r2 = r1.f935a
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 != 0) goto L_0x018b
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            r2.<init>(r8, r8)
        L_0x018b:
            int r7 = r1.b
            androidx.appcompat.app.AppCompatDelegateImpl$j r9 = r1.f936a
            r9.setBackgroundResource(r7)
            android.view.View r7 = r1.f935a
            android.view.ViewParent r7 = r7.getParent()
            boolean r9 = r7 instanceof android.view.ViewGroup
            if (r9 == 0) goto L_0x01a3
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            android.view.View r9 = r1.f935a
            r7.removeView(r9)
        L_0x01a3:
            androidx.appcompat.app.AppCompatDelegateImpl$j r7 = r1.f936a
            android.view.View r9 = r1.f935a
            r7.addView(r9, r2)
            android.view.View r2 = r1.f935a
            boolean r2 = r2.hasFocus()
            if (r2 != 0) goto L_0x01b7
            android.view.View r2 = r1.f935a
            r2.requestFocus()
        L_0x01b7:
            r10 = r8
        L_0x01b8:
            r1.f942b = r3
            android.view.WindowManager$LayoutParams r2 = new android.view.WindowManager$LayoutParams
            r11 = -2
            r12 = 0
            r13 = 0
            r14 = 1002(0x3ea, float:1.404E-42)
            r15 = 8519680(0x820000, float:1.1938615E-38)
            r16 = -3
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            int r3 = r1.c
            r2.gravity = r3
            int r3 = r1.d
            r2.windowAnimations = r3
            androidx.appcompat.app.AppCompatDelegateImpl$j r3 = r1.f936a
            r6.addView(r3, r2)
            r1.f943c = r4
            if (r5 != 0) goto L_0x01dd
            r17.S()
        L_0x01dd:
            return
        L_0x01de:
            r1.f944d = r4
        L_0x01e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.O(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean P(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f940a || Q(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f937a) != null) {
            return menuBuilder.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    public final boolean Q(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z;
        int i2;
        boolean z2;
        C0267m8 m8Var;
        C0267m8 m8Var2;
        C0267m8 m8Var3;
        Resources.Theme theme;
        C0267m8 m8Var4;
        if (this.o) {
            return false;
        }
        if (panelFeatureState.f940a) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f912a;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            C(panelFeatureState2, false);
        }
        Window.Callback K = K();
        int i3 = panelFeatureState.a;
        if (K != null) {
            panelFeatureState.f941b = K.onCreatePanelView(i3);
        }
        if (i3 == 0 || i3 == 108) {
            z = true;
        } else {
            z = false;
        }
        if (z && (m8Var4 = this.f925a) != null) {
            m8Var4.setMenuPrepared();
        }
        if (panelFeatureState.f941b == null) {
            MenuBuilder menuBuilder = panelFeatureState.f937a;
            if (menuBuilder == null || panelFeatureState.e) {
                if (menuBuilder == null) {
                    Context context = this.f902a;
                    if ((i3 == 0 || i3 == 108) && this.f925a != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(C0220hr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(C0220hr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(C0220hr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            C0190f7 f7Var = new C0190f7(context, 0);
                            f7Var.getTheme().setTo(theme);
                            context = f7Var;
                        }
                    }
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    menuBuilder2.setCallback(this);
                    MenuBuilder menuBuilder3 = panelFeatureState.f937a;
                    if (menuBuilder2 != menuBuilder3) {
                        if (menuBuilder3 != null) {
                            menuBuilder3.removeMenuPresenter(panelFeatureState.f938a);
                        }
                        panelFeatureState.f937a = menuBuilder2;
                        androidx.appcompat.view.menu.d dVar = panelFeatureState.f938a;
                        if (dVar != null) {
                            menuBuilder2.addMenuPresenter(dVar);
                        }
                    }
                    if (panelFeatureState.f937a == null) {
                        return false;
                    }
                }
                if (z && (m8Var3 = this.f925a) != null) {
                    if (this.f914a == null) {
                        this.f914a = new b();
                    }
                    m8Var3.setMenu(panelFeatureState.f937a, this.f914a);
                }
                panelFeatureState.f937a.stopDispatchingItemsChanged();
                if (!K.onCreatePanelMenu(i3, panelFeatureState.f937a)) {
                    MenuBuilder menuBuilder4 = panelFeatureState.f937a;
                    if (menuBuilder4 != null) {
                        if (menuBuilder4 != null) {
                            menuBuilder4.removeMenuPresenter(panelFeatureState.f938a);
                        }
                        panelFeatureState.f937a = null;
                    }
                    if (z && (m8Var2 = this.f925a) != null) {
                        m8Var2.setMenu((Menu) null, this.f914a);
                    }
                    return false;
                }
                panelFeatureState.e = false;
            }
            panelFeatureState.f937a.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.f934a;
            if (bundle != null) {
                panelFeatureState.f937a.restoreActionViewStates(bundle);
                panelFeatureState.f934a = null;
            }
            if (!K.onPreparePanel(0, panelFeatureState.f941b, panelFeatureState.f937a)) {
                if (z && (m8Var = this.f925a) != null) {
                    m8Var.setMenu((Menu) null, this.f914a);
                }
                panelFeatureState.f937a.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i2 = keyEvent.getDeviceId();
            } else {
                i2 = -1;
            }
            if (KeyCharacterMap.load(i2).getKeyboardType() != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            panelFeatureState.f937a.setQwertyMode(z2);
            panelFeatureState.f937a.startDispatchingItemsChanged();
        }
        panelFeatureState.f940a = true;
        panelFeatureState.f942b = false;
        this.f912a = panelFeatureState;
        return true;
    }

    public final void R() {
        if (this.f929c) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void S() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f911a != null && (J(0).f943c || this.f920a != null)) {
                z = true;
            }
            if (z && this.f910a == null) {
                this.f910a = e.b(this.f911a, this);
            } else if (!z && (onBackInvokedCallback = this.f910a) != null) {
                e.c(this.f911a, onBackInvokedCallback);
            }
        }
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        G();
        ((ViewGroup) this.f906a.findViewById(16908290)).addView(view, layoutParams);
        this.f915a.a(this.f907a.getCallback());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x01fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x0207 */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Context b(android.content.Context r11) {
        /*
            r10 = this;
            r0 = 1
            r10.m = r0
            int r1 = r10.d
            r2 = -100
            if (r1 == r2) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            int r1 = androidx.appcompat.app.AppCompatDelegate.c
        L_0x000c:
            int r1 = r10.M(r11, r1)
            boolean r2 = androidx.appcompat.app.AppCompatDelegate.j(r11)
            r3 = 0
            if (r2 == 0) goto L_0x0073
            boolean r2 = androidx.appcompat.app.AppCompatDelegate.j(r11)
            if (r2 != 0) goto L_0x001e
            goto L_0x0073
        L_0x001e:
            boolean r2 = defpackage.s3.c()
            if (r2 == 0) goto L_0x0033
            boolean r2 = androidx.appcompat.app.AppCompatDelegate.f897a
            if (r2 != 0) goto L_0x0073
            androidx.appcompat.app.g$a r2 = androidx.appcompat.app.AppCompatDelegate.a
            i1 r4 = new i1
            r4.<init>(r11, r3)
            r2.execute(r4)
            goto L_0x0073
        L_0x0033:
            java.lang.Object r2 = androidx.appcompat.app.AppCompatDelegate.b
            monitor-enter(r2)
            ki r4 = androidx.appcompat.app.AppCompatDelegate.f896a     // Catch:{ all -> 0x0070 }
            if (r4 != 0) goto L_0x0059
            ki r4 = androidx.appcompat.app.AppCompatDelegate.f898b     // Catch:{ all -> 0x0070 }
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = androidx.appcompat.app.g.b(r11)     // Catch:{ all -> 0x0070 }
            ki r4 = defpackage.ki.a(r4)     // Catch:{ all -> 0x0070 }
            androidx.appcompat.app.AppCompatDelegate.f898b = r4     // Catch:{ all -> 0x0070 }
        L_0x0048:
            ki r4 = androidx.appcompat.app.AppCompatDelegate.f898b     // Catch:{ all -> 0x0070 }
            li r4 = r4.f3053a     // Catch:{ all -> 0x0070 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0054
            monitor-exit(r2)     // Catch:{ all -> 0x0070 }
            goto L_0x0073
        L_0x0054:
            ki r4 = androidx.appcompat.app.AppCompatDelegate.f898b     // Catch:{ all -> 0x0070 }
            androidx.appcompat.app.AppCompatDelegate.f896a = r4     // Catch:{ all -> 0x0070 }
            goto L_0x006e
        L_0x0059:
            ki r5 = androidx.appcompat.app.AppCompatDelegate.f898b     // Catch:{ all -> 0x0070 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0070 }
            if (r4 != 0) goto L_0x006e
            ki r4 = androidx.appcompat.app.AppCompatDelegate.f896a     // Catch:{ all -> 0x0070 }
            androidx.appcompat.app.AppCompatDelegate.f898b = r4     // Catch:{ all -> 0x0070 }
            li r4 = r4.f3053a     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r4.c()     // Catch:{ all -> 0x0070 }
            androidx.appcompat.app.g.a(r11, r4)     // Catch:{ all -> 0x0070 }
        L_0x006e:
            monitor-exit(r2)     // Catch:{ all -> 0x0070 }
            goto L_0x0073
        L_0x0070:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0070 }
            throw r11
        L_0x0073:
            ki r2 = z(r11)
            boolean r4 = t
            r5 = 0
            if (r4 == 0) goto L_0x008b
            boolean r4 = r11 instanceof android.view.ContextThemeWrapper
            if (r4 == 0) goto L_0x008b
            android.content.res.Configuration r4 = D(r11, r1, r2, r5, r3)
            r6 = r11
            android.view.ContextThemeWrapper r6 = (android.view.ContextThemeWrapper) r6     // Catch:{ IllegalStateException -> 0x008b }
            r6.applyOverrideConfiguration(r4)     // Catch:{ IllegalStateException -> 0x008b }
            return r11
        L_0x008b:
            boolean r4 = r11 instanceof defpackage.C0190f7
            if (r4 == 0) goto L_0x009a
            android.content.res.Configuration r4 = D(r11, r1, r2, r5, r3)
            r6 = r11
            f7 r6 = (defpackage.C0190f7) r6     // Catch:{ IllegalStateException -> 0x009a }
            r6.a(r4)     // Catch:{ IllegalStateException -> 0x009a }
            return r11
        L_0x009a:
            boolean r4 = s
            if (r4 != 0) goto L_0x009f
            return r11
        L_0x009f:
            android.content.res.Configuration r4 = new android.content.res.Configuration
            r4.<init>()
            r6 = -1
            r4.uiMode = r6
            r6 = 0
            r4.fontScale = r6
            android.content.Context r4 = r11.createConfigurationContext(r4)
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            android.content.res.Resources r7 = r11.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            int r8 = r7.uiMode
            r4.uiMode = r8
            boolean r8 = r4.equals(r7)
            if (r8 != 0) goto L_0x01bd
            android.content.res.Configuration r8 = new android.content.res.Configuration
            r8.<init>()
            r8.fontScale = r6
            int r6 = r4.diff(r7)
            if (r6 != 0) goto L_0x00d7
            goto L_0x01be
        L_0x00d7:
            float r6 = r4.fontScale
            float r9 = r7.fontScale
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 == 0) goto L_0x00e1
            r8.fontScale = r9
        L_0x00e1:
            int r6 = r4.mcc
            int r9 = r7.mcc
            if (r6 == r9) goto L_0x00e9
            r8.mcc = r9
        L_0x00e9:
            int r6 = r4.mnc
            int r9 = r7.mnc
            if (r6 == r9) goto L_0x00f1
            r8.mnc = r9
        L_0x00f1:
            androidx.appcompat.app.AppCompatDelegateImpl.d.a(r4, r7, r8)
            int r6 = r4.touchscreen
            int r9 = r7.touchscreen
            if (r6 == r9) goto L_0x00fc
            r8.touchscreen = r9
        L_0x00fc:
            int r6 = r4.keyboard
            int r9 = r7.keyboard
            if (r6 == r9) goto L_0x0104
            r8.keyboard = r9
        L_0x0104:
            int r6 = r4.keyboardHidden
            int r9 = r7.keyboardHidden
            if (r6 == r9) goto L_0x010c
            r8.keyboardHidden = r9
        L_0x010c:
            int r6 = r4.navigation
            int r9 = r7.navigation
            if (r6 == r9) goto L_0x0114
            r8.navigation = r9
        L_0x0114:
            int r6 = r4.navigationHidden
            int r9 = r7.navigationHidden
            if (r6 == r9) goto L_0x011c
            r8.navigationHidden = r9
        L_0x011c:
            int r6 = r4.orientation
            int r9 = r7.orientation
            if (r6 == r9) goto L_0x0124
            r8.orientation = r9
        L_0x0124:
            int r6 = r4.screenLayout
            r6 = r6 & 15
            int r9 = r7.screenLayout
            r9 = r9 & 15
            if (r6 == r9) goto L_0x0133
            int r6 = r8.screenLayout
            r6 = r6 | r9
            r8.screenLayout = r6
        L_0x0133:
            int r6 = r4.screenLayout
            r6 = r6 & 192(0xc0, float:2.69E-43)
            int r9 = r7.screenLayout
            r9 = r9 & 192(0xc0, float:2.69E-43)
            if (r6 == r9) goto L_0x0142
            int r6 = r8.screenLayout
            r6 = r6 | r9
            r8.screenLayout = r6
        L_0x0142:
            int r6 = r4.screenLayout
            r6 = r6 & 48
            int r9 = r7.screenLayout
            r9 = r9 & 48
            if (r6 == r9) goto L_0x0151
            int r6 = r8.screenLayout
            r6 = r6 | r9
            r8.screenLayout = r6
        L_0x0151:
            int r6 = r4.screenLayout
            r6 = r6 & 768(0x300, float:1.076E-42)
            int r9 = r7.screenLayout
            r9 = r9 & 768(0x300, float:1.076E-42)
            if (r6 == r9) goto L_0x0160
            int r6 = r8.screenLayout
            r6 = r6 | r9
            r8.screenLayout = r6
        L_0x0160:
            int r6 = r4.colorMode
            r6 = r6 & 3
            int r9 = r7.colorMode
            r9 = r9 & 3
            if (r6 == r9) goto L_0x016f
            int r6 = r8.colorMode
            r6 = r6 | r9
            r8.colorMode = r6
        L_0x016f:
            int r6 = r4.colorMode
            r6 = r6 & 12
            int r9 = r7.colorMode
            r9 = r9 & 12
            if (r6 == r9) goto L_0x017e
            int r6 = r8.colorMode
            r6 = r6 | r9
            r8.colorMode = r6
        L_0x017e:
            int r6 = r4.uiMode
            r6 = r6 & 15
            int r9 = r7.uiMode
            r9 = r9 & 15
            if (r6 == r9) goto L_0x018d
            int r6 = r8.uiMode
            r6 = r6 | r9
            r8.uiMode = r6
        L_0x018d:
            int r6 = r4.uiMode
            r6 = r6 & 48
            int r9 = r7.uiMode
            r9 = r9 & 48
            if (r6 == r9) goto L_0x019c
            int r6 = r8.uiMode
            r6 = r6 | r9
            r8.uiMode = r6
        L_0x019c:
            int r6 = r4.screenWidthDp
            int r9 = r7.screenWidthDp
            if (r6 == r9) goto L_0x01a4
            r8.screenWidthDp = r9
        L_0x01a4:
            int r6 = r4.screenHeightDp
            int r9 = r7.screenHeightDp
            if (r6 == r9) goto L_0x01ac
            r8.screenHeightDp = r9
        L_0x01ac:
            int r6 = r4.smallestScreenWidthDp
            int r9 = r7.smallestScreenWidthDp
            if (r6 == r9) goto L_0x01b4
            r8.smallestScreenWidthDp = r9
        L_0x01b4:
            int r4 = r4.densityDpi
            int r6 = r7.densityDpi
            if (r4 == r6) goto L_0x01be
            r8.densityDpi = r6
            goto L_0x01be
        L_0x01bd:
            r8 = r5
        L_0x01be:
            android.content.res.Configuration r1 = D(r11, r1, r2, r8, r0)
            f7 r2 = new f7
            int r4 = defpackage.C0185es.Theme_AppCompat_Empty
            r2.<init>(r11, r4)
            r2.a(r1)
            android.content.res.Resources$Theme r11 = r11.getTheme()     // Catch:{ NullPointerException -> 0x01d4 }
            if (r11 == 0) goto L_0x01d4
            r11 = r0
            goto L_0x01d5
        L_0x01d4:
            r11 = r3
        L_0x01d5:
            if (r11 == 0) goto L_0x020e
            android.content.res.Resources$Theme r11 = r2.getTheme()
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r1 < r4) goto L_0x01e5
            defpackage.It.a(r11)
            goto L_0x020e
        L_0x01e5:
            java.lang.Object r1 = defpackage.Ht.a
            monitor-enter(r1)
            boolean r4 = defpackage.Ht.f263a     // Catch:{ all -> 0x020b }
            if (r4 != 0) goto L_0x01fd
            java.lang.Class<android.content.res.Resources$Theme> r4 = android.content.res.Resources.Theme.class
            java.lang.String r6 = "rebase"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x01fb }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x01fb }
            defpackage.Ht.f262a = r4     // Catch:{ NoSuchMethodException -> 0x01fb }
            r4.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x01fb }
        L_0x01fb:
            defpackage.Ht.f263a = r0     // Catch:{ all -> 0x020b }
        L_0x01fd:
            java.lang.reflect.Method r0 = defpackage.Ht.f262a     // Catch:{ all -> 0x020b }
            if (r0 == 0) goto L_0x0209
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0207 }
            r0.invoke(r11, r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0207 }
            goto L_0x0209
        L_0x0207:
            defpackage.Ht.f262a = r5     // Catch:{ all -> 0x020b }
        L_0x0209:
            monitor-exit(r1)     // Catch:{ all -> 0x020b }
            goto L_0x020e
        L_0x020b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x020b }
            throw r11
        L_0x020e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(android.content.Context):android.content.Context");
    }

    public final <T extends View> T c(int i2) {
        G();
        return this.f907a.findViewById(i2);
    }

    public final Context d() {
        return this.f902a;
    }

    public final int e() {
        return this.d;
    }

    public final MenuInflater f() {
        Context context;
        if (this.f901a == null) {
            L();
            h hVar = this.f919a;
            if (hVar != null) {
                context = hVar.d();
            } else {
                context = this.f902a;
            }
            this.f901a = new Iy(context);
        }
        return this.f901a;
    }

    public final h g() {
        L();
        return this.f919a;
    }

    public final void h() {
        LayoutInflater from = LayoutInflater.from(this.f902a);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    public final void i() {
        if (this.f919a != null) {
            L();
            this.f919a.getClass();
            this.g |= 1;
            if (!this.q) {
                View decorView = this.f907a.getDecorView();
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                decorView.postOnAnimation(this.f913a);
                this.q = true;
            }
        }
    }

    public final void k() {
        if (this.f932f && this.f929c) {
            L();
            h hVar = this.f919a;
            if (hVar != null) {
                hVar.g(hVar.f962a.getResources().getBoolean(C0240jr.abc_action_bar_embed_tabs));
            }
        }
        o1 a2 = o1.a();
        Context context = this.f902a;
        synchronized (a2) {
            Dt dt = a2.f3135a;
            synchronized (dt) {
                LongSparseArray longSparseArray = dt.b.get(context);
                if (longSparseArray != null) {
                    longSparseArray.a();
                }
            }
        }
        this.f903a = new Configuration(this.f902a.getResources().getConfiguration());
        x(false, false);
    }

    public final void l() {
        String str;
        this.m = true;
        x(false, true);
        H();
        Object obj = this.c;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                str = tm.c(activity, activity.getComponentName());
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                h hVar = this.f919a;
                if (hVar == null) {
                    this.r = true;
                } else {
                    hVar.f(true);
                }
            }
            synchronized (AppCompatDelegate.f895a) {
                AppCompatDelegate.q(this);
                AppCompatDelegate.f893a.add(new WeakReference(this));
            }
        }
        this.f903a = new Configuration(this.f902a.getResources().getConfiguration());
        this.n = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.c
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = androidx.appcompat.app.AppCompatDelegate.f895a
            monitor-enter(r0)
            androidx.appcompat.app.AppCompatDelegate.q(r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            goto L_0x0011
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        L_0x0011:
            boolean r0 = r3.q
            if (r0 == 0) goto L_0x0020
            android.view.Window r0 = r3.f907a
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.AppCompatDelegateImpl$a r1 = r3.f913a
            r0.removeCallbacks(r1)
        L_0x0020:
            r0 = 1
            r3.o = r0
            int r0 = r3.d
            r1 = -100
            if (r0 == r1) goto L_0x004d
            java.lang.Object r0 = r3.c
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x004d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x004d
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = a
            java.lang.Object r1 = r3.c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x005c
        L_0x004d:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = a
            java.lang.Object r1 = r3.c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x005c:
            androidx.appcompat.app.AppCompatDelegateImpl$i r0 = r3.f917a
            if (r0 == 0) goto L_0x0063
            r0.a()
        L_0x0063:
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = r3.f916a
            if (r0 == 0) goto L_0x006a
            r0.a()
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m():void");
    }

    public final void n() {
        L();
        h hVar = this.f919a;
        if (hVar != null) {
            hVar.h = true;
        }
    }

    public final void o() {
        x(true, false);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.f926a == null) {
            int[] iArr = ps.AppCompatTheme;
            Context context2 = this.f902a;
            String string = context2.obtainStyledAttributes(iArr).getString(ps.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f926a = new v1();
            } else {
                try {
                    this.f926a = (v1) context2.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    this.f926a = new v1();
                }
            }
        }
        v1 v1Var = this.f926a;
        int i2 = C0117aC.a;
        return v1Var.createView(view, str, context, attributeSet, false, false, true, false);
    }

    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        int i2;
        int i3;
        PanelFeatureState panelFeatureState;
        Window.Callback K = K();
        if (K != null && !this.o) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.f927a;
            if (panelFeatureStateArr != null) {
                i3 = panelFeatureStateArr.length;
                i2 = 0;
            } else {
                i3 = 0;
                i2 = 0;
            }
            while (true) {
                if (i2 < i3) {
                    panelFeatureState = panelFeatureStateArr[i2];
                    if (panelFeatureState != null && panelFeatureState.f937a == rootMenu) {
                        break;
                    }
                    i2++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                return K.onMenuItemSelected(panelFeatureState.a, menuItem);
            }
        }
        return false;
    }

    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        C0267m8 m8Var = this.f925a;
        if (m8Var == null || !m8Var.d() || (ViewConfiguration.get(this.f902a).hasPermanentMenuKey() && !this.f925a.b())) {
            PanelFeatureState J = J(0);
            J.f944d = true;
            C(J, false);
            O(J, (KeyEvent) null);
            return;
        }
        Window.Callback K = K();
        if (this.f925a.a()) {
            this.f925a.c();
            if (!this.o) {
                K.onPanelClosed(108, J(0).f937a);
            }
        } else if (K != null && !this.o) {
            if (this.q && (1 & this.g) != 0) {
                View decorView = this.f907a.getDecorView();
                a aVar = this.f913a;
                decorView.removeCallbacks(aVar);
                aVar.run();
            }
            PanelFeatureState J2 = J(0);
            MenuBuilder menuBuilder2 = J2.f937a;
            if (menuBuilder2 != null && !J2.e && K.onPreparePanel(0, J2.f941b, menuBuilder2)) {
                K.onMenuOpened(108, J2.f937a);
                this.f925a.e();
            }
        }
    }

    public final void p() {
        L();
        h hVar = this.f919a;
        if (hVar != null) {
            hVar.h = false;
            HC hc = hVar.f960a;
            if (hc != null) {
                hc.a();
            }
        }
    }

    public final boolean r(int i2) {
        if (i2 == 8) {
            i2 = 108;
        } else if (i2 == 9) {
            i2 = 109;
        }
        if (this.j && i2 == 108) {
            return false;
        }
        if (this.f932f && i2 == 1) {
            this.f932f = false;
        }
        if (i2 == 1) {
            R();
            this.j = true;
            return true;
        } else if (i2 == 2) {
            R();
            this.f930d = true;
            return true;
        } else if (i2 == 5) {
            R();
            this.f931e = true;
            return true;
        } else if (i2 == 10) {
            R();
            this.h = true;
            return true;
        } else if (i2 == 108) {
            R();
            this.f932f = true;
            return true;
        } else if (i2 != 109) {
            return this.f907a.requestFeature(i2);
        } else {
            R();
            this.f933g = true;
            return true;
        }
    }

    public final void s(int i2) {
        G();
        ViewGroup viewGroup = (ViewGroup) this.f906a.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f902a).inflate(i2, viewGroup);
        this.f915a.a(this.f907a.getCallback());
    }

    public final void t(View view) {
        G();
        ViewGroup viewGroup = (ViewGroup) this.f906a.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f915a.a(this.f907a.getCallback());
    }

    public final void u(View view, ViewGroup.LayoutParams layoutParams) {
        G();
        ViewGroup viewGroup = (ViewGroup) this.f906a.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f915a.a(this.f907a.getCallback());
    }

    public final void v(int i2) {
        this.e = i2;
    }

    public final void w(CharSequence charSequence) {
        this.f923a = charSequence;
        C0267m8 m8Var = this.f925a;
        if (m8Var != null) {
            m8Var.setWindowTitle(charSequence);
            return;
        }
        h hVar = this.f919a;
        if (hVar != null) {
            hVar.h(charSequence);
            return;
        }
        TextView textView = this.f909a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean x(boolean r13, boolean r14) {
        /*
            r12 = this;
            boolean r0 = r12.o
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = -100
            int r2 = r12.d
            if (r2 == r0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            int r2 = androidx.appcompat.app.AppCompatDelegate.c
        L_0x000f:
            android.content.Context r0 = r12.f902a
            int r3 = r12.M(r0, r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 33
            r6 = 0
            if (r4 >= r5) goto L_0x0021
            ki r5 = z(r0)
            goto L_0x0022
        L_0x0021:
            r5 = r6
        L_0x0022:
            if (r14 != 0) goto L_0x0032
            if (r5 == 0) goto L_0x0032
            android.content.res.Resources r14 = r0.getResources()
            android.content.res.Configuration r14 = r14.getConfiguration()
            ki r5 = androidx.appcompat.app.AppCompatDelegateImpl.d.b(r14)
        L_0x0032:
            android.content.res.Configuration r14 = D(r0, r3, r5, r6, r1)
            boolean r3 = r12.p
            r7 = 1
            java.lang.Object r8 = r12.c
            if (r3 != 0) goto L_0x0068
            boolean r3 = r8 instanceof android.app.Activity
            if (r3 == 0) goto L_0x0068
            android.content.pm.PackageManager r3 = r0.getPackageManager()
            if (r3 != 0) goto L_0x0049
            r3 = r1
            goto L_0x006c
        L_0x0049:
            r9 = 29
            if (r4 < r9) goto L_0x0050
            r4 = 269221888(0x100c0000, float:2.7610132E-29)
            goto L_0x0052
        L_0x0050:
            r4 = 786432(0xc0000, float:1.102026E-39)
        L_0x0052:
            android.content.ComponentName r9 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0066 }
            java.lang.Class r10 = r8.getClass()     // Catch:{ NameNotFoundException -> 0x0066 }
            r9.<init>(r0, r10)     // Catch:{ NameNotFoundException -> 0x0066 }
            android.content.pm.ActivityInfo r3 = r3.getActivityInfo(r9, r4)     // Catch:{ NameNotFoundException -> 0x0066 }
            if (r3 == 0) goto L_0x0068
            int r3 = r3.configChanges     // Catch:{ NameNotFoundException -> 0x0066 }
            r12.f = r3     // Catch:{ NameNotFoundException -> 0x0066 }
            goto L_0x0068
        L_0x0066:
            r12.f = r1
        L_0x0068:
            r12.p = r7
            int r3 = r12.f
        L_0x006c:
            android.content.res.Configuration r4 = r12.f903a
            if (r4 != 0) goto L_0x0078
            android.content.res.Resources r4 = r0.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
        L_0x0078:
            int r9 = r4.uiMode
            r9 = r9 & 48
            int r10 = r14.uiMode
            r10 = r10 & 48
            ki r4 = androidx.appcompat.app.AppCompatDelegateImpl.d.b(r4)
            if (r5 != 0) goto L_0x0088
            r14 = r6
            goto L_0x008c
        L_0x0088:
            ki r14 = androidx.appcompat.app.AppCompatDelegateImpl.d.b(r14)
        L_0x008c:
            if (r9 == r10) goto L_0x0091
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x0092
        L_0x0091:
            r5 = r1
        L_0x0092:
            if (r14 == 0) goto L_0x009e
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x009e
            r4 = r5 | 4
            r5 = r4 | 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            int r4 = ~r3
            r4 = r4 & r5
            if (r4 == 0) goto L_0x00dd
            if (r13 == 0) goto L_0x00dd
            boolean r13 = r12.m
            if (r13 == 0) goto L_0x00dd
            boolean r13 = s
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r12.n
            if (r13 == 0) goto L_0x00dd
        L_0x00b0:
            boolean r13 = r8 instanceof android.app.Activity
            if (r13 == 0) goto L_0x00dd
            r13 = r8
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r4 = r13.isChild()
            if (r4 != 0) goto L_0x00dd
            int r4 = defpackage.J.a
            int r4 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r4 < r9) goto L_0x00c9
            r13.recreate()
            goto L_0x00db
        L_0x00c9:
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r9 = r13.getMainLooper()
            r4.<init>(r9)
            b6 r9 = new b6
            r11 = 2
            r9.<init>(r13, r11)
            r4.post(r9)
        L_0x00db:
            r13 = r7
            goto L_0x00de
        L_0x00dd:
            r13 = r1
        L_0x00de:
            if (r13 != 0) goto L_0x014c
            if (r5 == 0) goto L_0x014c
            r13 = r5 & r3
            if (r13 != r5) goto L_0x00e8
            r13 = r7
            goto L_0x00e9
        L_0x00e8:
            r13 = r1
        L_0x00e9:
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Configuration r4 = new android.content.res.Configuration
            android.content.res.Configuration r9 = r3.getConfiguration()
            r4.<init>(r9)
            android.content.res.Configuration r9 = r3.getConfiguration()
            int r9 = r9.uiMode
            r9 = r9 & -49
            r9 = r9 | r10
            r4.uiMode = r9
            if (r14 == 0) goto L_0x0106
            androidx.appcompat.app.AppCompatDelegateImpl.d.d(r4, r14)
        L_0x0106:
            r3.updateConfiguration(r4, r6)
            int r3 = r12.e
            if (r3 == 0) goto L_0x0119
            r0.setTheme(r3)
            android.content.res.Resources$Theme r3 = r0.getTheme()
            int r6 = r12.e
            r3.applyStyle(r6, r7)
        L_0x0119:
            if (r13 == 0) goto L_0x014d
            boolean r13 = r8 instanceof android.app.Activity
            if (r13 == 0) goto L_0x014d
            r13 = r8
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r3 = r13 instanceof androidx.lifecycle.LifecycleOwner
            if (r3 == 0) goto L_0x0140
            r3 = r13
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.lifecycle.Lifecycle$State r3 = r3.b()
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.CREATED
            int r3 = r3.compareTo(r6)
            if (r3 < 0) goto L_0x013a
            r1 = r7
        L_0x013a:
            if (r1 == 0) goto L_0x014d
            r13.onConfigurationChanged(r4)
            goto L_0x014d
        L_0x0140:
            boolean r1 = r12.n
            if (r1 == 0) goto L_0x014d
            boolean r1 = r12.o
            if (r1 != 0) goto L_0x014d
            r13.onConfigurationChanged(r4)
            goto L_0x014d
        L_0x014c:
            r7 = r13
        L_0x014d:
            if (r7 == 0) goto L_0x0166
            boolean r13 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r13 == 0) goto L_0x0166
            r13 = r5 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x015d
            r13 = r8
            androidx.appcompat.app.AppCompatActivity r13 = (androidx.appcompat.app.AppCompatActivity) r13
            r13.getClass()
        L_0x015d:
            r13 = r5 & 4
            if (r13 == 0) goto L_0x0166
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.getClass()
        L_0x0166:
            if (r7 == 0) goto L_0x0179
            if (r14 == 0) goto L_0x0179
            android.content.res.Resources r13 = r0.getResources()
            android.content.res.Configuration r13 = r13.getConfiguration()
            ki r13 = androidx.appcompat.app.AppCompatDelegateImpl.d.b(r13)
            androidx.appcompat.app.AppCompatDelegateImpl.d.c(r13)
        L_0x0179:
            if (r2 != 0) goto L_0x0183
            androidx.appcompat.app.AppCompatDelegateImpl$h r13 = r12.I(r0)
            r13.e()
            goto L_0x018a
        L_0x0183:
            androidx.appcompat.app.AppCompatDelegateImpl$i r13 = r12.f917a
            if (r13 == 0) goto L_0x018a
            r13.a()
        L_0x018a:
            r13 = 3
            if (r2 != r13) goto L_0x019e
            androidx.appcompat.app.AppCompatDelegateImpl$g r13 = r12.f916a
            if (r13 != 0) goto L_0x0198
            androidx.appcompat.app.AppCompatDelegateImpl$g r13 = new androidx.appcompat.app.AppCompatDelegateImpl$g
            r13.<init>(r0)
            r12.f916a = r13
        L_0x0198:
            androidx.appcompat.app.AppCompatDelegateImpl$g r13 = r12.f916a
            r13.e()
            goto L_0x01a5
        L_0x019e:
            androidx.appcompat.app.AppCompatDelegateImpl$g r13 = r12.f916a
            if (r13 == 0) goto L_0x01a5
            r13.a()
        L_0x01a5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.x(boolean, boolean):boolean");
    }

    public final void y(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.f907a == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof f)) {
                f fVar = new f(callback);
                this.f915a = fVar;
                window.setCallback(fVar);
                Context context = this.f902a;
                TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes((AttributeSet) null, f899a));
                Drawable f2 = tintTypedArray.f(0);
                if (f2 != null) {
                    window.setBackgroundDrawable(f2);
                }
                tintTypedArray.n();
                this.f907a = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.f911a) == null) {
                    if (!(onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f910a) == null)) {
                        e.c(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.f910a = null;
                    }
                    Object obj = this.c;
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            this.f911a = e.a(activity);
                            S();
                            return;
                        }
                    }
                    this.f911a = null;
                    S();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }
}
