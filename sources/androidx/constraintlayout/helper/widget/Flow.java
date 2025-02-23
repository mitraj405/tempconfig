package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    public d a;

    public Flow(Context context) {
        super(context);
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.a = new d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintLayout_Layout_android_orientation) {
                    this.a.W = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_padding) {
                    d dVar = this.a;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    dVar.C = dimensionPixelSize;
                    dVar.D = dimensionPixelSize;
                    dVar.E = dimensionPixelSize;
                    dVar.F = dimensionPixelSize;
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingStart) {
                    d dVar2 = this.a;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    dVar2.E = dimensionPixelSize2;
                    dVar2.G = dimensionPixelSize2;
                    dVar2.H = dimensionPixelSize2;
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingEnd) {
                    this.a.F = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingLeft) {
                    this.a.G = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingTop) {
                    this.a.C = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingRight) {
                    this.a.H = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_paddingBottom) {
                    this.a.D = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_wrapMode) {
                    this.a.U = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.a.K = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.a.L = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.a.M = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.a.O = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.a.N = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.a.P = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.a.h = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.a.j = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.a.l = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.a.k = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.a.m = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_verticalBias) {
                    this.a.i = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.a.S = obtainStyledAttributes.getInt(index, 2);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.a.T = obtainStyledAttributes.getInt(index, 2);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.a.Q = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_verticalGap) {
                    this.a.R = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.a.V = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.a = this.a;
        t();
    }

    public final void o(ConstraintSet.a aVar, Te te, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.o(aVar, te, layoutParams, sparseArray);
        if (te instanceof d) {
            d dVar = (d) te;
            int i = layoutParams.L;
            if (i != -1) {
                dVar.W = i;
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i, int i2) {
        u(this.a, i, i2);
    }

    public final void p(ConstraintWidget constraintWidget, boolean z) {
        d dVar = this.a;
        int i = dVar.E;
        if (i <= 0 && dVar.F <= 0) {
            return;
        }
        if (z) {
            dVar.G = dVar.F;
            dVar.H = i;
            return;
        }
        dVar.G = i;
        dVar.H = dVar.F;
    }

    public void setFirstHorizontalBias(float f) {
        this.a.j = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.a.M = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.a.k = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.a.N = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.a.S = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.a.h = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.a.Q = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.a.K = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.a.l = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.a.O = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.a.m = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.a.P = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.a.V = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.a.W = i;
        requestLayout();
    }

    public void setPadding(int i) {
        d dVar = this.a;
        dVar.C = i;
        dVar.D = i;
        dVar.E = i;
        dVar.F = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.a.D = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.a.G = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.a.H = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.a.C = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.a.T = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.a.i = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.a.R = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.a.L = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.a.U = i;
        requestLayout();
    }

    public final void u(h hVar, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (hVar != null) {
            hVar.V(mode, size, mode2, size2);
            setMeasuredDimension(hVar.I, hVar.J);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
