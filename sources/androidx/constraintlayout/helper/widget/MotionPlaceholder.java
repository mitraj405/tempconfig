package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    public MotionPlaceholder(Context context) {
        super(context);
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.a = new g();
        t();
    }

    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i, int i2) {
        u((h) null, i, i2);
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

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void s(Re re, SparseArray sparseArray) {
    }
}
