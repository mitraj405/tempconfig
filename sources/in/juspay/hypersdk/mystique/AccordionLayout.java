package in.juspay.hypersdk.mystique;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.Keep;

@Keep
public class AccordionLayout extends FrameLayout {
    private static final int COLLAPSE = 0;
    private static final int EXPAND = 1;
    private float alphaDelta = 1.0f;
    private int animationDuration = 300;
    private ValueAnimator animator;
    private Context context;
    /* access modifiers changed from: private */
    public float delta = 1.0f;
    private float parallaxDelta = 0.6f;
    private int parentScrollViewId = -1;
    /* access modifiers changed from: private */
    public boolean postLayout = false;
    private float target = 1.0f;

    public AccordionLayout(Context context2) {
        super(context2);
        this.context = context2;
    }

    private int getRelativeTop(View view, ScrollView scrollView) {
        ViewParent parent = view.getParent();
        if (parent == scrollView || !(parent instanceof View)) {
            return view.getTop();
        }
        return view.getTop() + getRelativeTop((View) parent, scrollView);
    }

    /* access modifiers changed from: private */
    public void scrollParent() {
        ScrollView scrollView;
        int i;
        if (this.target == 1.0f && this.parentScrollViewId != -1 && (getContext() instanceof Activity) && (scrollView = (ScrollView) ((Activity) getContext()).findViewById(this.parentScrollViewId)) != null) {
            int scrollY = scrollView.getScrollY();
            int height = scrollView.getHeight() + scrollY;
            int relativeTop = getRelativeTop(this, scrollView);
            int height2 = getHeight() + relativeTop;
            if (relativeTop < scrollY || height2 > height) {
                if (relativeTop < scrollY) {
                    i = relativeTop - scrollY;
                } else {
                    i = height2 - height;
                }
                scrollView.scrollTo(0, scrollView.getScrollY() + i);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int i4 = (int) (this.delta * ((float) measuredHeight));
        if (i4 < 0) {
            i4 = 0;
        }
        if (i4 == 0 && this.target == 0.0f) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        setVisibility(i3);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.setTranslationY((float) ((int) (((float) (i4 - measuredHeight)) * this.parallaxDelta)));
            float f = this.alphaDelta;
            if (f != 0.0f) {
                childAt.setAlpha(this.delta * f);
                if (this.target == 1.0f && this.delta == 1.0f) {
                    childAt.setAlpha(1.0f);
                }
            }
        }
        setMeasuredDimension(getMeasuredWidth(), i4);
        this.postLayout = true;
    }

    public void setDefaultExpand(boolean z) {
        float f;
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        this.target = f;
        this.delta = f;
        if (f == 0.0f) {
            setVisibility(8);
        }
    }

    public void setExpand(boolean z) {
        float f;
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        if (this.target != f) {
            this.target = f;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                if (this.target == 1.0f) {
                    setVisibility(0);
                }
                float f2 = this.target;
                float f3 = this.delta;
                float f4 = f2 - f3;
                if (f4 < 0.0f) {
                    f4 = f3 - f2;
                }
                int i = (int) (f4 * ((float) this.animationDuration));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f3, f2});
                this.animator = ofFloat;
                ofFloat.setDuration((long) i);
                this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
                this.postLayout = false;
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float unused = AccordionLayout.this.delta = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (AccordionLayout.this.postLayout) {
                            AccordionLayout.this.scrollParent();
                        }
                        AccordionLayout.this.requestLayout();
                    }
                });
                this.animator.start();
            } else if (z) {
                setVisibility(0);
                this.delta = f;
                scrollParent();
            } else {
                setVisibility(8);
            }
        }
    }

    public void setExpandAlpha(float f) {
        this.alphaDelta = f;
    }

    public void setExpandDuration(int i) {
        this.animationDuration = i;
    }

    public void setExpandParallax(float f) {
        this.parallaxDelta = f;
    }

    public void setScrollParent(int i) {
        this.parentScrollViewId = i;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        this.context = context2;
    }
}
