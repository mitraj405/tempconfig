package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: u  reason: default package and case insensitive filesystem */
/* compiled from: AccessibilityClickableSpanCompat */
public final class C0346u extends ClickableSpan {
    public final AccessibilityNodeInfoCompat a;
    public final int c;
    public final int d;

    public C0346u(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2) {
        this.c = i;
        this.a = accessibilityNodeInfoCompat;
        this.d = i2;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.c);
        this.a.f1832a.performAction(this.d, bundle);
    }
}
