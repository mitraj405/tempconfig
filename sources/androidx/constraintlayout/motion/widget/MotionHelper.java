package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements MotionLayout.i {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1431a = false;
    public boolean b = false;

    /* renamed from: b  reason: collision with other field name */
    public View[] f1432b;

    public MotionHelper(Context context) {
        super(context);
    }

    public float getProgress() {
        return this.a;
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.MotionHelper_onShow) {
                    this.f1431a = obtainStyledAttributes.getBoolean(index, this.f1431a);
                } else if (index == C0221hs.MotionHelper_onHide) {
                    this.b = obtainStyledAttributes.getBoolean(index, this.b);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(View view, float f) {
    }

    public void setProgress(float f) {
        this.a = f;
        int i = 0;
        if (this.c > 0) {
            this.f1432b = m((ConstraintLayout) getParent());
            while (i < this.c) {
                setProgress(this.f1432b[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f);
            }
            i++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        n(attributeSet);
    }

    public final void a() {
    }

    public void b() {
    }

    public final void d() {
    }

    public void c(int i) {
    }

    public void u(MotionLayout motionLayout, HashMap<View, Vl> hashMap) {
    }
}
