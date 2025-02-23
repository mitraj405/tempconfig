package defpackage;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;

/* renamed from: v  reason: default package and case insensitive filesystem */
/* compiled from: AccessibilityManagerCompat */
public final class C0358v implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final AccessibilityManagerCompat$TouchExplorationStateChangeListener a;

    public C0358v(AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        this.a = accessibilityManagerCompat$TouchExplorationStateChangeListener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0358v)) {
            return false;
        }
        return this.a.equals(((C0358v) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.a.onTouchExplorationStateChanged(z);
    }
}
