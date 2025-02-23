package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* compiled from: Placeholder */
public final class g extends h {
    public final void V(int i, int i2, int i3, int i4) {
        boolean z = false;
        int i5 = this.G + this.H + 0;
        int i6 = this.C + this.D + 0;
        if (this.B > 0) {
            i5 += this.c[0].u();
            i6 += this.c[0].o();
        }
        int max = Math.max(this.u, i5);
        int max2 = Math.max(this.v, i6);
        if (i != 1073741824) {
            if (i == Integer.MIN_VALUE) {
                i2 = Math.min(max, i2);
            } else if (i == 0) {
                i2 = max;
            } else {
                i2 = 0;
            }
        }
        if (i3 != 1073741824) {
            if (i3 == Integer.MIN_VALUE) {
                i4 = Math.min(max2, i4);
            } else if (i3 == 0) {
                i4 = max2;
            } else {
                i4 = 0;
            }
        }
        this.I = i2;
        this.J = i4;
        R(i2);
        O(i4);
        if (this.B > 0) {
            z = true;
        }
        this.l = z;
    }

    public final void e(ei eiVar, boolean z) {
        super.e(eiVar, z);
        if (this.B > 0) {
            ConstraintWidget constraintWidget = this.c[0];
            constraintWidget.H();
            constraintWidget.g = 0.5f;
            constraintWidget.f = 0.5f;
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.h(type, this, type, 0);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.h(type2, this, type2, 0);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.h(type3, this, type3, 0);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.h(type4, this, type4, 0);
        }
    }
}
