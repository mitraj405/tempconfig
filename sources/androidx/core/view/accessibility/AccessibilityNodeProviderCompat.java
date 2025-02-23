package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public final Object a;

    public static class a extends AccessibilityNodeProvider {
        public final AccessibilityNodeProviderCompat a;

        public a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.a = accessibilityNodeProviderCompat;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat a2 = this.a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.f1832a;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            this.a.getClass();
            return null;
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            AccessibilityNodeInfoCompat b = this.a.b(i);
            if (b == null) {
                return null;
            }
            return b.f1832a;
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.c(i, i2, bundle);
        }
    }

    public static class b extends a {
        public b(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.getClass();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.a = new b(this);
    }

    public AccessibilityNodeInfoCompat a(int i) {
        return null;
    }

    public AccessibilityNodeInfoCompat b(int i) {
        return null;
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.a = accessibilityNodeProvider;
    }
}
