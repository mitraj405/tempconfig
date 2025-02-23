package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ReactiveGuide extends View implements SharedValues.a {
    public boolean a = false;
    public boolean b = true;
    public int c = -1;
    public int d = 0;

    public ReactiveGuide(Context context) {
        super(context);
        super.setVisibility(8);
        a((AttributeSet) null);
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                } else if (index == C0221hs.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.a = obtainStyledAttributes.getBoolean(index, this.a);
                } else if (index == C0221hs.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.d = obtainStyledAttributes.getResourceId(index, this.d);
                } else if (index == C0221hs.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.b = obtainStyledAttributes.getBoolean(index, this.b);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.c != -1) {
            ConstraintLayout.getSharedValues().a(this.c, this);
        }
    }

    public int getApplyToConstraintSetId() {
        return this.d;
    }

    public int getAttributeId() {
        return this.c;
    }

    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z) {
        this.a = z;
    }

    public void setApplyToConstraintSetId(int i) {
        this.d = i;
    }

    public void setAttributeId(int i) {
        HashSet hashSet;
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i2 = this.c;
        if (!(i2 == -1 || (hashSet = sharedValues.a.get(Integer.valueOf(i2))) == null)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValues.a aVar = (SharedValues.a) weakReference.get();
                if (aVar == null || aVar == this) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
        this.c = i;
        if (i != -1) {
            sharedValues.a(i, this);
        }
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1626a = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1630b = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.a = f;
        setLayoutParams(layoutParams);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
        a(attributeSet);
    }

    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    public void setVisibility(int i) {
    }
}
