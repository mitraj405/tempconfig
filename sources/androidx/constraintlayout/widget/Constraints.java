package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

public class Constraints extends ViewGroup {
    public ConstraintSet a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.a == null) {
            this.a = new ConstraintSet();
        }
        ConstraintSet constraintSet = this.a;
        constraintSet.getClass();
        int childCount = getChildCount();
        HashMap<Integer, ConstraintSet.a> hashMap = constraintSet.f1663b;
        hashMap.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!constraintSet.f1661a || id != -1) {
                if (!hashMap.containsKey(Integer.valueOf(id))) {
                    hashMap.put(Integer.valueOf(id), new ConstraintSet.a());
                }
                ConstraintSet.a aVar = hashMap.get(Integer.valueOf(id));
                if (aVar != null) {
                    if (childAt instanceof ConstraintHelper) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                        aVar.d(id, layoutParams);
                        if (constraintHelper instanceof Barrier) {
                            ConstraintSet.b bVar = aVar.f1665a;
                            bVar.W = 1;
                            Barrier barrier = (Barrier) constraintHelper;
                            bVar.U = barrier.getType();
                            bVar.f1682a = barrier.getReferencedIds();
                            bVar.V = barrier.getMargin();
                        }
                    }
                    aVar.d(id, layoutParams);
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        return this.a;
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public final boolean j;
        public final float k;
        public final float l;
        public final float m;
        public final float n;
        public final float o;
        public final float p;
        public final float q;
        public final float r;
        public final float s;
        public final float t;
        public final float u;
        public final float v;

        public LayoutParams() {
            this.k = 1.0f;
            this.j = false;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 1.0f;
            this.q = 1.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
            this.u = 0.0f;
            this.v = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.k = 1.0f;
            this.j = false;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 1.0f;
            this.q = 1.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
            this.u = 0.0f;
            this.v = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintSet_android_alpha) {
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                } else if (index == C0221hs.ConstraintSet_android_elevation) {
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    this.j = true;
                } else if (index == C0221hs.ConstraintSet_android_rotationX) {
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                } else if (index == C0221hs.ConstraintSet_android_rotationY) {
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                } else if (index == C0221hs.ConstraintSet_android_rotation) {
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
                } else if (index == C0221hs.ConstraintSet_android_scaleX) {
                    this.p = obtainStyledAttributes.getFloat(index, this.p);
                } else if (index == C0221hs.ConstraintSet_android_scaleY) {
                    this.q = obtainStyledAttributes.getFloat(index, this.q);
                } else if (index == C0221hs.ConstraintSet_android_transformPivotX) {
                    this.r = obtainStyledAttributes.getFloat(index, this.r);
                } else if (index == C0221hs.ConstraintSet_android_transformPivotY) {
                    this.s = obtainStyledAttributes.getFloat(index, this.s);
                } else if (index == C0221hs.ConstraintSet_android_translationX) {
                    this.t = obtainStyledAttributes.getFloat(index, this.t);
                } else if (index == C0221hs.ConstraintSet_android_translationY) {
                    this.u = obtainStyledAttributes.getFloat(index, this.u);
                } else if (index == C0221hs.ConstraintSet_android_translationZ) {
                    this.v = obtainStyledAttributes.getFloat(index, this.v);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
