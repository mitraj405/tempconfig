package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.f;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new a();
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new b();
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        public final AccessibilityNodeInfoCompat a(int i) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i).f1832a));
        }

        public final AccessibilityNodeInfoCompat b(int i) {
            int i2;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (i == 2) {
                i2 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId;
            } else {
                i2 = exploreByTouchHelper.mKeyboardFocusedVirtualViewId;
            }
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        public final boolean c(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i, i2, bundle);
        }
    }

    public class a implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
        public final void a(Object obj, Rect rect) {
            ((AccessibilityNodeInfoCompat) obj).f(rect);
        }
    }

    public class b implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        public final int a(SparseArrayCompat sparseArrayCompat) {
            return sparseArrayCompat.c;
        }

        public final AccessibilityNodeInfoCompat b(SparseArrayCompat sparseArrayCompat, int i) {
            return (AccessibilityNodeInfoCompat) sparseArrayCompat.f1330a[i];
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        if (i == Integer.MIN_VALUE || !onPerformActionForVirtualView(i, 16, (Bundle) null)) {
            return false;
        }
        return true;
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            return createEventForChild(i, i2);
        }
        return createEventForHost(i2);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.g());
        AccessibilityNodeInfo accessibilityNodeInfo = obtainAccessibilityNodeInfo.f1832a;
        obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(accessibilityNodeInfo.isScrollable());
        obtain.setPassword(accessibilityNodeInfo.isPassword());
        obtain.setEnabled(accessibilityNodeInfo.isEnabled());
        obtain.setChecked(accessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            obtain.setSource(this.mHost, i);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        boolean z;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        accessibilityNodeInfoCompat.j(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        accessibilityNodeInfoCompat.i(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.mHost;
        accessibilityNodeInfoCompat.a = -1;
        obtain.setParent(view);
        onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.g() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompat.f(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(this.mHost.getContext().getPackageName());
                View view2 = this.mHost;
                accessibilityNodeInfoCompat.b = i;
                obtain.setSource(view2, i);
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    obtain.setAccessibilityFocused(true);
                    accessibilityNodeInfoCompat.a(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    accessibilityNodeInfoCompat.a(64);
                }
                if (this.mKeyboardFocusedVirtualViewId == i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    accessibilityNodeInfoCompat.a(2);
                } else if (obtain.isFocusable()) {
                    accessibilityNodeInfoCompat.a(1);
                }
                obtain.setFocused(z);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                obtain.getBoundsInScreen(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(rect)) {
                    accessibilityNodeInfoCompat.f(this.mTempScreenRect);
                    if (accessibilityNodeInfoCompat.a != -1) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                        for (int i2 = accessibilityNodeInfoCompat.a; i2 != -1; i2 = accessibilityNodeInfoCompat2.a) {
                            View view3 = this.mHost;
                            accessibilityNodeInfoCompat2.a = -1;
                            accessibilityNodeInfoCompat2.f1832a.setParent(view3, -1);
                            accessibilityNodeInfoCompat2.i(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i2, accessibilityNodeInfoCompat2);
                            accessibilityNodeInfoCompat2.f(this.mTempParentRect);
                            Rect rect2 = this.mTempScreenRect;
                            Rect rect3 = this.mTempParentRect;
                            rect2.offset(rect3.left, rect3.top);
                        }
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        Rect rect4 = this.mTempScreenRect;
                        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f1832a;
                        accessibilityNodeInfo.setBoundsInScreen(rect4);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            accessibilityNodeInfo.setVisibleToUser(true);
                        }
                    }
                }
                return accessibilityNodeInfoCompat;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.mHost);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
        View view = this.mHost;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                accessibilityNodeInfoCompat.f1832a.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.d(((Integer) arrayList.get(i)).intValue(), createNodeForChild(((Integer) arrayList.get(i)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).f(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int keyToDirection(int i) {
        if (i == 19) {
            return 33;
        }
        if (i == 21) {
            return 17;
        }
        if (i != 22) {
            return 130;
        }
        return 66;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e4, code lost:
        if (r6 < ((r19 * r19) + ((r18 * 13) * r18))) goto L_0x00e6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00f0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean moveFocus(int r22, android.graphics.Rect r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            androidx.collection.SparseArrayCompat r3 = r21.getAllNodes()
            int r4 = r0.mKeyboardFocusedVirtualViewId
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r6) goto L_0x0013
            r4 = r5
            goto L_0x0019
        L_0x0013:
            java.lang.Object r4 = r3.c(r4, r5)
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r4 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r4
        L_0x0019:
            r7 = 1
            r8 = 0
            r9 = -1
            r10 = 2
            if (r1 == r7) goto L_0x00fa
            if (r1 == r10) goto L_0x00fa
            r10 = 130(0x82, float:1.82E-43)
            r11 = 66
            r12 = 33
            r13 = 17
            if (r1 == r13) goto L_0x003a
            if (r1 == r12) goto L_0x003a
            if (r1 == r11) goto L_0x003a
            if (r1 != r10) goto L_0x0032
            goto L_0x003a
        L_0x0032:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1.<init>(r2)
            throw r1
        L_0x003a:
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            int r15 = r0.mKeyboardFocusedVirtualViewId
            if (r15 == r6) goto L_0x0047
            r0.getBoundsInParent(r15, r14)
            goto L_0x0052
        L_0x0047:
            if (r2 == 0) goto L_0x004d
            r14.set(r2)
            goto L_0x0052
        L_0x004d:
            android.view.View r2 = r0.mHost
            guessPreviouslyFocusedRect(r2, r1, r14)
        L_0x0052:
            androidx.customview.widget.FocusStrategy$CollectionAdapter<androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat>, androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r2 = SPARSE_VALUES_ADAPTER
            androidx.customview.widget.FocusStrategy$BoundsAdapter<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r15 = NODE_ADAPTER
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>(r14)
            if (r1 == r13) goto L_0x0088
            if (r1 == r12) goto L_0x007f
            if (r1 == r11) goto L_0x0075
            if (r1 != r10) goto L_0x006d
            int r10 = r14.height()
            int r10 = r10 + r7
            int r10 = -r10
            r5.offset(r8, r10)
            goto L_0x0090
        L_0x006d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1.<init>(r2)
            throw r1
        L_0x0075:
            int r10 = r14.width()
            int r10 = r10 + r7
            int r10 = -r10
            r5.offset(r10, r8)
            goto L_0x0090
        L_0x007f:
            int r10 = r14.height()
            int r10 = r10 + r7
            r5.offset(r8, r10)
            goto L_0x0090
        L_0x0088:
            int r10 = r14.width()
            int r10 = r10 + r7
            r5.offset(r10, r8)
        L_0x0090:
            int r10 = r2.a(r3)
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r12 = r8
            r16 = 0
        L_0x009c:
            if (r12 >= r10) goto L_0x00f6
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r13 = r2.b(r3, r12)
            if (r13 != r4) goto L_0x00a5
            goto L_0x00f0
        L_0x00a5:
            r15.a(r13, r11)
            boolean r17 = androidx.customview.widget.FocusStrategy.c(r1, r14, r11)
            if (r17 != 0) goto L_0x00af
            goto L_0x00e8
        L_0x00af:
            boolean r17 = androidx.customview.widget.FocusStrategy.c(r1, r14, r5)
            if (r17 != 0) goto L_0x00b6
            goto L_0x00e6
        L_0x00b6:
            boolean r17 = androidx.customview.widget.FocusStrategy.a(r1, r14, r11, r5)
            if (r17 == 0) goto L_0x00bd
            goto L_0x00e6
        L_0x00bd:
            boolean r17 = androidx.customview.widget.FocusStrategy.a(r1, r14, r5, r11)
            if (r17 == 0) goto L_0x00c4
            goto L_0x00e8
        L_0x00c4:
            int r17 = androidx.customview.widget.FocusStrategy.d(r1, r14, r11)
            int r18 = androidx.customview.widget.FocusStrategy.e(r1, r14, r11)
            int r19 = r17 * 13
            int r19 = r19 * r17
            int r18 = r18 * r18
            int r6 = r18 + r19
            int r18 = androidx.customview.widget.FocusStrategy.d(r1, r14, r5)
            int r19 = androidx.customview.widget.FocusStrategy.e(r1, r14, r5)
            int r20 = r18 * 13
            int r20 = r20 * r18
            int r19 = r19 * r19
            int r8 = r19 + r20
            if (r6 >= r8) goto L_0x00e8
        L_0x00e6:
            r6 = r7
            goto L_0x00e9
        L_0x00e8:
            r6 = 0
        L_0x00e9:
            if (r6 == 0) goto L_0x00f0
            r5.set(r11)
            r16 = r13
        L_0x00f0:
            int r12 = r12 + 1
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 0
            goto L_0x009c
        L_0x00f6:
            r1 = r16
            goto L_0x0162
        L_0x00fa:
            android.view.View r2 = r0.mHost
            java.util.WeakHashMap<android.view.View, GC> r5 = androidx.core.view.f.f1839a
            int r2 = r2.getLayoutDirection()
            if (r2 != r7) goto L_0x0106
            r2 = r7
            goto L_0x0107
        L_0x0106:
            r2 = 0
        L_0x0107:
            androidx.customview.widget.FocusStrategy$CollectionAdapter<androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat>, androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r5 = SPARSE_VALUES_ADAPTER
            androidx.customview.widget.FocusStrategy$BoundsAdapter<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r6 = NODE_ADAPTER
            int r8 = r5.a(r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r8)
            r12 = 0
        L_0x0115:
            if (r12 >= r8) goto L_0x0121
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r13 = r5.b(r3, r12)
            r11.add(r13)
            int r12 = r12 + 1
            goto L_0x0115
        L_0x0121:
            androidx.customview.widget.FocusStrategy$a r5 = new androidx.customview.widget.FocusStrategy$a
            r5.<init>(r2, r6)
            java.util.Collections.sort(r11, r5)
            if (r1 == r7) goto L_0x0149
            if (r1 != r10) goto L_0x0141
            int r1 = r11.size()
            if (r4 != 0) goto L_0x0135
            r2 = r9
            goto L_0x0139
        L_0x0135:
            int r2 = r11.lastIndexOf(r4)
        L_0x0139:
            int r2 = r2 + r7
            if (r2 >= r1) goto L_0x015c
            java.lang.Object r5 = r11.get(r2)
            goto L_0x015d
        L_0x0141:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}."
            r1.<init>(r2)
            throw r1
        L_0x0149:
            int r1 = r11.size()
            if (r4 != 0) goto L_0x0150
            goto L_0x0154
        L_0x0150:
            int r1 = r11.indexOf(r4)
        L_0x0154:
            int r1 = r1 + r9
            if (r1 < 0) goto L_0x015c
            java.lang.Object r5 = r11.get(r1)
            goto L_0x015d
        L_0x015c:
            r5 = 0
        L_0x015d:
            r16 = r5
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r16 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r16
            goto L_0x00f6
        L_0x0162:
            if (r1 != 0) goto L_0x0167
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x017e
        L_0x0167:
            r3.getClass()
            r8 = 0
        L_0x016b:
            int r2 = r3.c
            if (r8 >= r2) goto L_0x017a
            java.lang.Object[] r2 = r3.f1330a
            r2 = r2[r8]
            if (r2 != r1) goto L_0x0177
            r9 = r8
            goto L_0x017a
        L_0x0177:
            int r8 = r8 + 1
            goto L_0x016b
        L_0x017a:
            int[] r1 = r3.f1329a
            r6 = r1[r9]
        L_0x017e:
            boolean r1 = r0.requestKeyboardFocusForVirtualView(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.moveFocus(int, android.graphics.Rect):boolean");
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i);
        }
        if (i2 == 64) {
            return requestAccessibilityFocus(i);
        }
        if (i2 != 128) {
            return onPerformActionForVirtualView(i, i2, bundle);
        }
        return clearAccessibilityFocus(i);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        View view = this.mHost;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        return view.performAccessibilityAction(i, bundle);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 != i) {
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            if (virtualViewAt != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        } else {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && moveFocus(keyToDirection, (Rect) null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, (Rect) null);
            }
            return false;
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return performActionForChild(i, i2, bundle);
        }
        return performActionForHost(i2, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i, 2048);
            createEvent.setContentChangeTypes(i2);
            parent.requestSendAccessibilityEvent(this.mHost, createEvent);
        }
    }

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }
}
