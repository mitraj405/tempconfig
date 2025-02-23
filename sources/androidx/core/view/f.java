package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* compiled from: ViewCompat */
public final class f {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final C0223iC f1837a = new C0223iC();

    /* renamed from: a  reason: collision with other field name */
    public static Field f1838a = null;

    /* renamed from: a  reason: collision with other field name */
    public static WeakHashMap<View, GC> f1839a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f1840a = false;

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f1841a = {Jr.accessibility_custom_action_0, Jr.accessibility_custom_action_1, Jr.accessibility_custom_action_2, Jr.accessibility_custom_action_3, Jr.accessibility_custom_action_4, Jr.accessibility_custom_action_5, Jr.accessibility_custom_action_6, Jr.accessibility_custom_action_7, Jr.accessibility_custom_action_8, Jr.accessibility_custom_action_9, Jr.accessibility_custom_action_10, Jr.accessibility_custom_action_11, Jr.accessibility_custom_action_12, Jr.accessibility_custom_action_13, Jr.accessibility_custom_action_14, Jr.accessibility_custom_action_15, Jr.accessibility_custom_action_16, Jr.accessibility_custom_action_17, Jr.accessibility_custom_action_18, Jr.accessibility_custom_action_19, Jr.accessibility_custom_action_20, Jr.accessibility_custom_action_21, Jr.accessibility_custom_action_22, Jr.accessibility_custom_action_23, Jr.accessibility_custom_action_24, Jr.accessibility_custom_action_25, Jr.accessibility_custom_action_26, Jr.accessibility_custom_action_27, Jr.accessibility_custom_action_28, Jr.accessibility_custom_action_29, Jr.accessibility_custom_action_30, Jr.accessibility_custom_action_31};

    /* compiled from: ViewCompat */
    public static abstract class b<T> {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Class<T> f1842a;
        public final int b;
        public final int c;

        public b(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.f1842a = cls;
            this.c = i2;
            this.b = i3;
        }

        public static boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean z2;
            if (bool == null || !bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            if (bool2 == null || !bool2.booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z == z2) {
                return true;
            }
            return false;
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public final T d(View view) {
            boolean z;
            if (Build.VERSION.SDK_INT >= this.b) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return b(view);
            }
            T tag = view.getTag(this.a);
            if (this.f1842a.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public final void e(View view, T t) {
            boolean z;
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            if (Build.VERSION.SDK_INT >= this.b) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c(view, t);
            } else if (f(d(view), t)) {
                View.AccessibilityDelegate d = f.d(view);
                if (d == null) {
                    accessibilityDelegateCompat = null;
                } else if (d instanceof AccessibilityDelegateCompat.a) {
                    accessibilityDelegateCompat = ((AccessibilityDelegateCompat.a) d).a;
                } else {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat(d);
                }
                if (accessibilityDelegateCompat == null) {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat();
                }
                f.o(view, accessibilityDelegateCompat);
                view.setTag(this.a, t);
                f.i(this.c, view);
            }
        }

        public abstract boolean f(T t, T t2);
    }

    /* compiled from: ViewCompat */
    public static class c {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: ViewCompat */
    public static class d {

        /* compiled from: ViewCompat */
        public class a implements View.OnApplyWindowInsetsListener {
            public final /* synthetic */ View a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ OnApplyWindowInsetsListener f1843a;

            /* renamed from: a  reason: collision with other field name */
            public WindowInsetsCompat f1844a = null;

            public a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
                this.a = view;
                this.f1843a = onApplyWindowInsetsListener;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompat i = WindowInsetsCompat.i(view, windowInsets);
                int i2 = Build.VERSION.SDK_INT;
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1843a;
                if (i2 < 30) {
                    d.a(windowInsets, this.a);
                    if (i.equals(this.f1844a)) {
                        return onApplyWindowInsetsListener.onApplyWindowInsets(view, i).h();
                    }
                }
                this.f1844a = i;
                WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, i);
                if (i2 >= 30) {
                    return onApplyWindowInsets.h();
                }
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                c.c(view);
                return onApplyWindowInsets.h();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(Jr.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets h = windowInsetsCompat.h();
            if (h != null) {
                return WindowInsetsCompat.i(view, view.computeSystemWindowInsets(h, rect));
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static boolean c(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public static boolean d(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public static boolean e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        public static boolean f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat j(View view) {
            WindowInsetsCompat.e eVar;
            if (WindowInsetsCompat.a.f1819a && view.isAttachedToWindow()) {
                try {
                    Object obj = WindowInsetsCompat.a.a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) WindowInsetsCompat.a.b.get(obj);
                        Rect rect2 = (Rect) WindowInsetsCompat.a.c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            int i = Build.VERSION.SDK_INT;
                            if (i >= 30) {
                                eVar = new WindowInsetsCompat.d();
                            } else if (i >= 29) {
                                eVar = new WindowInsetsCompat.c();
                            } else {
                                eVar = new WindowInsetsCompat.b();
                            }
                            eVar.e(bg.b(rect.left, rect.top, rect.right, rect.bottom));
                            eVar.g(bg.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
                            WindowInsetsCompat b = eVar.b();
                            b.f1818a.p(b);
                            b.f1818a.d(view.getRootView());
                            return b;
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.getMessage();
                }
            }
            return null;
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f) {
            view.setElevation(f);
        }

        public static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void u(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(Jr.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(Jr.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, onApplyWindowInsetsListener));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void x(View view, float f) {
            view.setZ(f);
        }

        public static boolean y(View view, int i) {
            return view.startNestedScroll(i);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: ViewCompat */
    public static class e {
        public static WindowInsetsCompat a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat i = WindowInsetsCompat.i((View) null, rootWindowInsets);
            WindowInsetsCompat.k kVar = i.f1818a;
            kVar.p(i);
            kVar.d(view.getRootView());
            return i;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i) {
            view.setScrollIndicators(i);
        }

        public static void d(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: androidx.core.view.f$f  reason: collision with other inner class name */
    /* compiled from: ViewCompat */
    public static class C0013f {
        public static void a(View view) {
            view.cancelDragAndDrop();
        }

        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        public static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        public static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        public static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* compiled from: ViewCompat */
    public static class g {
        public static void a(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        public static int d(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View i(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        public static void m(View view, int i) {
            view.setImportantForAutofill(i);
        }

        public static void n(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        public static void o(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* compiled from: ViewCompat */
    public static class h {
        public static void a(View view, m mVar) {
            int i = Jr.tag_unhandled_key_listeners;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i, simpleArrayMap);
            }
            Objects.requireNonNull(mVar);
            kC kCVar = new kC(mVar);
            simpleArrayMap.put(mVar, kCVar);
            view.addOnUnhandledKeyEventListener(kCVar);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, m mVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(Jr.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(mVar)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static <T> T f(View view, int i) {
            return view.requireViewById(i);
        }

        public static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, C0152c2 c2Var) {
            view.setAutofillId((AutofillId) null);
        }

        public static void j(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* compiled from: ViewCompat */
    public static class i {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        public static void e(View view, W6 w6) {
            view.setContentCaptureSession((ContentCaptureSession) null);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* compiled from: ViewCompat */
    public static class j {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static g c(View view) {
            WindowInsetsController m = view.getWindowInsetsController();
            if (m != null) {
                return new g(m);
            }
            return null;
        }

        public static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        public static void e(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        public static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* compiled from: ViewCompat */
    public static final class k {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat b(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo b = contentInfoCompat.a.b();
            Objects.requireNonNull(b);
            ContentInfo j = view.performReceiveContent(b);
            if (j == null) {
                return null;
            }
            if (j == b) {
                return contentInfoCompat;
            }
            return new ContentInfoCompat(new ContentInfoCompat.d(j));
        }

        public static void c(View view, String[] strArr, Vn vn) {
            if (vn == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new l(vn));
            }
        }
    }

    /* compiled from: ViewCompat */
    public static final class l implements OnReceiveContentListener {
        public final Vn a;

        public l(Vn vn) {
            this.a = vn;
        }

        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = new ContentInfoCompat(new ContentInfoCompat.d(contentInfo));
            ContentInfoCompat a2 = this.a.a(view, contentInfoCompat);
            if (a2 == null) {
                return null;
            }
            if (a2 == contentInfoCompat) {
                return contentInfo;
            }
            ContentInfo b = a2.a.b();
            Objects.requireNonNull(b);
            return b;
        }
    }

    /* compiled from: ViewCompat */
    public interface m {
        boolean a();
    }

    /* compiled from: ViewCompat */
    public static class n {
        public static final ArrayList<WeakReference<View>> a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        public SparseArray<WeakReference<View>> f1845a = null;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<KeyEvent> f1846a = null;

        /* renamed from: a  reason: collision with other field name */
        public WeakHashMap<View, Boolean> f1847a = null;

        public static boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(Jr.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((m) arrayList.get(size)).a()) {
                    return true;
                }
            }
            return false;
        }

        public final View a(View view, KeyEvent keyEvent) {
            View a2;
            WeakHashMap<View, Boolean> weakHashMap = this.f1847a;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                do {
                    childCount--;
                    if (childCount >= 0) {
                        a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                    }
                } while (a2 == null);
                return a2;
            }
            if (b(view, keyEvent)) {
                return view;
            }
            return null;
        }
    }

    @Deprecated
    public static GC a(View view) {
        if (f1839a == null) {
            f1839a = new WeakHashMap<>();
        }
        GC gc = f1839a.get(view);
        if (gc != null) {
            return gc;
        }
        GC gc2 = new GC(view);
        f1839a.put(view, gc2);
        return gc2;
    }

    public static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets h2 = windowInsetsCompat.h();
        if (h2 != null) {
            WindowInsets a2 = c.a(view, h2);
            if (!a2.equals(h2)) {
                return WindowInsetsCompat.i(view, a2);
            }
        }
        return windowInsetsCompat;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = n.a;
        int i2 = Jr.tag_unhandled_key_event_manager;
        n nVar = (n) view.getTag(i2);
        if (nVar == null) {
            nVar = new n();
            view.setTag(i2, nVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = nVar.f1847a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = n.a;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (nVar.f1847a == null) {
                        nVar.f1847a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = n.a;
                        View view2 = (View) arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            nVar.f1847a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                nVar.f1847a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a2 = nVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (nVar.f1845a == null) {
                    nVar.f1845a = new SparseArray<>();
                }
                nVar.f1845a.put(keyCode, new WeakReference(a2));
            }
        }
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return i.a(view);
        }
        if (f1840a) {
            return null;
        }
        if (f1838a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1838a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1840a = true;
                return null;
            }
        }
        try {
            Object obj = f1838a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1840a = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        boolean z;
        Object obj;
        int i2 = Jr.tag_accessibility_pane_title;
        if (Build.VERSION.SDK_INT >= 28) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            obj = h.b(view);
        } else {
            obj = view.getTag(i2);
            if (!CharSequence.class.isInstance(obj)) {
                obj = null;
            }
        }
        return (CharSequence) obj;
    }

    public static ArrayList f(View view) {
        int i2 = Jr.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static String[] g(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return k.a(view);
        }
        return (String[]) view.getTag(Jr.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static g h(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return j.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return new g(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void i(int i2, View view) {
        boolean z;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (e(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z = false;
            } else {
                z = true;
            }
            int i3 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                obtain.setContentChangeTypes(i2);
                if (z) {
                    obtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(e(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError unused) {
                    view.getParent().getClass();
                }
            }
        }
    }

    public static WindowInsetsCompat j(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets h2 = windowInsetsCompat.h();
        if (h2 != null) {
            WindowInsets b2 = c.b(view, h2);
            if (!b2.equals(h2)) {
                return WindowInsetsCompat.i(view, b2);
            }
        }
        return windowInsetsCompat;
    }

    public static ContentInfoCompat k(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(contentInfoCompat);
            view.getClass();
            view.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return k.b(view, contentInfoCompat);
        }
        Vn vn = (Vn) view.getTag(Jr.tag_on_receive_content_listener);
        Wn wn = f1837a;
        if (vn != null) {
            ContentInfoCompat a2 = vn.a(view, contentInfoCompat);
            if (a2 == null) {
                return null;
            }
            if (view instanceof Wn) {
                wn = (Wn) view;
            }
            return wn.onReceiveContent(a2);
        }
        if (view instanceof Wn) {
            wn = (Wn) view;
        }
        return wn.onReceiveContent(contentInfoCompat);
    }

    public static void l(int i2, View view) {
        ArrayList f = f(view);
        for (int i3 = 0; i3 < f.size(); i3++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) f.get(i3)).a() == i2) {
                f.remove(i3);
                return;
            }
        }
    }

    public static void m(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, String str, AccessibilityViewCommand accessibilityViewCommand) {
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        if (accessibilityViewCommand == null && str == null) {
            l(accessibilityActionCompat.a(), view);
            i(0, view);
            return;
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat((Object) null, accessibilityActionCompat.f1833a, str, accessibilityViewCommand, accessibilityActionCompat.f1835a);
        View.AccessibilityDelegate d2 = d(view);
        if (d2 == null) {
            accessibilityDelegateCompat = null;
        } else if (d2 instanceof AccessibilityDelegateCompat.a) {
            accessibilityDelegateCompat = ((AccessibilityDelegateCompat.a) d2).a;
        } else {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat(d2);
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        o(view, accessibilityDelegateCompat);
        l(accessibilityActionCompat2.a(), view);
        f(view).add(accessibilityActionCompat2);
        i(0, view);
    }

    public static void n(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            i.d(view, context, iArr, attributeSet, typedArray, i2, 0);
        }
    }

    public static void o(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (d(view) instanceof AccessibilityDelegateCompat.a)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static void p(View view, CharSequence charSequence) {
        boolean z;
        new c(Jr.tag_accessibility_pane_title).e(view, charSequence);
        a aVar = a;
        if (charSequence != null) {
            WeakHashMap<View, Boolean> weakHashMap = aVar.a;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z = false;
            } else {
                z = true;
            }
            weakHashMap.put(view, Boolean.valueOf(z));
            view.addOnAttachStateChangeListener(aVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                return;
            }
            return;
        }
        aVar.a.remove(view);
        view.removeOnAttachStateChangeListener(aVar);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
    }

    /* compiled from: ViewCompat */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap<View, Boolean> a = new WeakHashMap<>();

        public final void onGlobalLayout() {
            boolean z;
            int i;
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.a.entrySet()) {
                    View view = (View) next.getKey();
                    boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
                    if (!view.isShown() || view.getWindowVisibility() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (booleanValue != z) {
                        if (z) {
                            i = 16;
                        } else {
                            i = 32;
                        }
                        f.i(i, view);
                        next.setValue(Boolean.valueOf(z));
                    }
                }
            }
        }

        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
