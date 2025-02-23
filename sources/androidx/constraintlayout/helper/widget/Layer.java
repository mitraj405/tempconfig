package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Layer extends ConstraintHelper {
    public float a = Float.NaN;

    /* renamed from: a  reason: collision with other field name */
    public ConstraintLayout f1426a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1427a = true;
    public float b = Float.NaN;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1428b;

    /* renamed from: b  reason: collision with other field name */
    public View[] f1429b = null;
    public float c = Float.NaN;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1430c;
    public float d = 1.0f;
    public float e = 1.0f;
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = 0.0f;
    public float m = 0.0f;

    public Layer(Context context) {
        super(context);
    }

    public final void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == C0221hs.ConstraintLayout_Layout_android_visibility) {
                    this.f1428b = true;
                } else if (index == C0221hs.ConstraintLayout_Layout_android_elevation) {
                    this.f1430c = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1426a = (ConstraintLayout) getParent();
        if (this.f1428b || this.f1430c) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.c; i2++) {
                View viewById = this.f1426a.getViewById(this.f1623a[i2]);
                if (viewById != null) {
                    if (this.f1428b) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f1430c && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void q() {
        v();
        this.f = Float.NaN;
        this.g = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).f1627a;
        constraintWidget.R(0);
        constraintWidget.O(0);
        u();
        layout(((int) this.j) - getPaddingLeft(), ((int) this.k) - getPaddingTop(), getPaddingRight() + ((int) this.h), getPaddingBottom() + ((int) this.i));
        w();
    }

    public final void r(ConstraintLayout constraintLayout) {
        this.f1426a = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.c = rotation;
        } else if (!Float.isNaN(this.c)) {
            this.c = rotation;
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        h();
    }

    public void setPivotX(float f2) {
        this.a = f2;
        w();
    }

    public void setPivotY(float f2) {
        this.b = f2;
        w();
    }

    public void setRotation(float f2) {
        this.c = f2;
        w();
    }

    public void setScaleX(float f2) {
        this.d = f2;
        w();
    }

    public void setScaleY(float f2) {
        this.e = f2;
        w();
    }

    public void setTranslationX(float f2) {
        this.l = f2;
        w();
    }

    public void setTranslationY(float f2) {
        this.m = f2;
        w();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        h();
    }

    public final void u() {
        if (this.f1426a != null) {
            if (!this.f1427a && !Float.isNaN(this.f) && !Float.isNaN(this.g)) {
                return;
            }
            if (Float.isNaN(this.a) || Float.isNaN(this.b)) {
                View[] m2 = m(this.f1426a);
                int left = m2[0].getLeft();
                int top = m2[0].getTop();
                int right = m2[0].getRight();
                int bottom = m2[0].getBottom();
                for (int i2 = 0; i2 < this.c; i2++) {
                    View view = m2[i2];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.h = (float) right;
                this.i = (float) bottom;
                this.j = (float) left;
                this.k = (float) top;
                if (Float.isNaN(this.a)) {
                    this.f = (float) ((left + right) / 2);
                } else {
                    this.f = this.a;
                }
                if (Float.isNaN(this.b)) {
                    this.g = (float) ((top + bottom) / 2);
                } else {
                    this.g = this.b;
                }
            } else {
                this.g = this.b;
                this.f = this.a;
            }
        }
    }

    public final void v() {
        int i2;
        if (this.f1426a != null && (i2 = this.c) != 0) {
            View[] viewArr = this.f1429b;
            if (viewArr == null || viewArr.length != i2) {
                this.f1429b = new View[i2];
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                this.f1429b[i3] = this.f1426a.getViewById(this.f1623a[i3]);
            }
        }
    }

    public final void w() {
        double d2;
        if (this.f1426a != null) {
            if (this.f1429b == null) {
                v();
            }
            u();
            if (Float.isNaN(this.c)) {
                d2 = 0.0d;
            } else {
                d2 = Math.toRadians((double) this.c);
            }
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            float f2 = this.d;
            float f3 = f2 * cos;
            float f4 = this.e;
            float f5 = (-f4) * sin;
            float f6 = f2 * sin;
            float f7 = f4 * cos;
            for (int i2 = 0; i2 < this.c; i2++) {
                View view = this.f1429b[i2];
                int left = view.getLeft();
                int top = view.getTop();
                float right = ((float) ((view.getRight() + left) / 2)) - this.f;
                float bottom = ((float) ((view.getBottom() + top) / 2)) - this.g;
                view.setTranslationX((((f5 * bottom) + (f3 * right)) - right) + this.l);
                view.setTranslationY((((f7 * bottom) + (right * f6)) - bottom) + this.m);
                view.setScaleY(this.e);
                view.setScaleX(this.d);
                if (!Float.isNaN(this.c)) {
                    view.setRotation(this.c);
                }
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
