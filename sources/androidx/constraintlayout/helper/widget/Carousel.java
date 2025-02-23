package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    public MotionLayout a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<View> f1418a = new ArrayList<>();
    public float b = 0.9f;
    public float c = 2.0f;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1419c = false;
    public int d = 0;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = 4;
    public int k = 1;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            Carousel carousel = Carousel.this;
            carousel.a.setProgress(0.0f);
            carousel.getClass();
            carousel.getClass();
            int i = carousel.d;
            throw null;
        }
    }

    public interface b {
    }

    public Carousel(Context context) {
        super(context);
        new a();
    }

    public final void c(int i2) {
        int i3 = this.d;
        if (i2 == this.i) {
            this.d = i3 + 1;
        } else if (i2 == this.h) {
            this.d = i3 - 1;
        }
        if (this.f1419c) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.d;
    }

    public final void onAttachedToWindow() {
        androidx.constraintlayout.motion.widget.b bVar;
        androidx.constraintlayout.motion.widget.b bVar2;
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i2 = 0; i2 < this.c; i2++) {
                this.f1418a.add(motionLayout.getViewById(this.f1623a[i2]));
            }
            this.a = motionLayout;
            if (this.k == 2) {
                a.b l = motionLayout.l(this.g);
                if (!(l == null || (bVar2 = l.f1518a) == null)) {
                    bVar2.f1533c = 5;
                }
                a.b l2 = this.a.l(this.f);
                if (l2 != null && (bVar = l2.f1518a) != null) {
                    bVar.f1533c = 5;
                }
            }
        }
    }

    public final void v(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == C0221hs.Carousel_carousel_firstView) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                } else if (index == C0221hs.Carousel_carousel_backwardTransition) {
                    this.f = obtainStyledAttributes.getResourceId(index, this.f);
                } else if (index == C0221hs.Carousel_carousel_forwardTransition) {
                    this.g = obtainStyledAttributes.getResourceId(index, this.g);
                } else if (index == C0221hs.Carousel_carousel_emptyViewsBehavior) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == C0221hs.Carousel_carousel_previousState) {
                    this.h = obtainStyledAttributes.getResourceId(index, this.h);
                } else if (index == C0221hs.Carousel_carousel_nextState) {
                    this.i = obtainStyledAttributes.getResourceId(index, this.i);
                } else if (index == C0221hs.Carousel_carousel_touchUp_dampeningFactor) {
                    this.b = obtainStyledAttributes.getFloat(index, this.b);
                } else if (index == C0221hs.Carousel_carousel_touchUpMode) {
                    this.k = obtainStyledAttributes.getInt(index, this.k);
                } else if (index == C0221hs.Carousel_carousel_touchUp_velocityThreshold) {
                    this.c = obtainStyledAttributes.getFloat(index, this.c);
                } else if (index == C0221hs.Carousel_carousel_infinite) {
                    this.f1419c = obtainStyledAttributes.getBoolean(index, this.f1419c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new a();
        v(context, attributeSet);
    }

    public final void b() {
    }

    public void setAdapter(b bVar) {
    }

    public Carousel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new a();
        v(context, attributeSet);
    }
}
