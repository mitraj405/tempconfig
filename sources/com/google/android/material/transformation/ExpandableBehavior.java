package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    /* access modifiers changed from: private */
    public int currentState = 0;

    public ExpandableBehavior() {
    }

    private boolean didStateChange(boolean z) {
        if (z) {
            int i = this.currentState;
            if (i == 0 || i == 2) {
                return true;
            }
            return false;
        } else if (this.currentState == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static <T extends ExpandableBehavior> T from(View view, Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).f1713a;
            if (behavior instanceof ExpandableBehavior) {
                return (ExpandableBehavior) cls.cast(behavior);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i;
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        if (expandableWidget.isExpanded()) {
            i = 1;
        } else {
            i = 2;
        }
        this.currentState = i;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    public abstract boolean onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r3 = findExpandableWidget(r3, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r3, final android.view.View r4, int r5) {
        /*
            r2 = this;
            java.util.WeakHashMap<android.view.View, GC> r5 = androidx.core.view.f.f1839a
            boolean r5 = r4.isLaidOut()
            if (r5 != 0) goto L_0x002f
            com.google.android.material.expandable.ExpandableWidget r3 = r2.findExpandableWidget(r3, r4)
            if (r3 == 0) goto L_0x002f
            boolean r5 = r3.isExpanded()
            boolean r5 = r2.didStateChange(r5)
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isExpanded()
            if (r5 == 0) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 2
        L_0x0021:
            r2.currentState = r5
            android.view.ViewTreeObserver r0 = r4.getViewTreeObserver()
            com.google.android.material.transformation.ExpandableBehavior$1 r1 = new com.google.android.material.transformation.ExpandableBehavior$1
            r1.<init>(r4, r5, r3)
            r0.addOnPreDrawListener(r1)
        L_0x002f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.ExpandableBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
