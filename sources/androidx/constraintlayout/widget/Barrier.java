package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

public class Barrier extends ConstraintHelper {
    public a a;
    public int d;
    public int e;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.a.l;
    }

    public int getMargin() {
        return this.a.D;
    }

    public int getType() {
        return this.d;
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.a = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == C0221hs.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.a.l = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == C0221hs.ConstraintLayout_Layout_barrierMargin) {
                    this.a.D = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.a = this.a;
        t();
    }

    public final void o(ConstraintSet.a aVar, Te te, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.o(aVar, te, layoutParams, sparseArray);
        if (te instanceof a) {
            a aVar2 = (a) te;
            boolean z = ((ConstraintWidgetContainer) te.f1349a).l;
            ConstraintSet.b bVar = aVar.f1665a;
            u(aVar2, bVar.U, z);
            aVar2.l = bVar.f1694f;
            aVar2.D = bVar.V;
        }
    }

    public final void p(ConstraintWidget constraintWidget, boolean z) {
        u(constraintWidget, this.d, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.a.l = z;
    }

    public void setDpMargin(int i) {
        this.a.D = (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.a.D = i;
    }

    public void setType(int i) {
        this.d = i;
    }

    public final void u(ConstraintWidget constraintWidget, int i, boolean z) {
        this.e = i;
        if (z) {
            int i2 = this.d;
            if (i2 == 5) {
                this.e = 1;
            } else if (i2 == 6) {
                this.e = 0;
            }
        } else {
            int i3 = this.d;
            if (i3 == 5) {
                this.e = 0;
            } else if (i3 == 6) {
                this.e = 1;
            }
        }
        if (constraintWidget instanceof a) {
            ((a) constraintWidget).C = this.e;
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
