package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.dynamicanimation.animation.a;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    static final float GAP_RAMP_DOWN_THRESHOLD = 0.01f;
    private static final FloatPropertyCompat<DeterminateDrawable<?>> INDICATOR_LENGTH_IN_LEVEL = new FloatPropertyCompat<DeterminateDrawable<?>>("indicatorLevel") {
        public float getValue(DeterminateDrawable<?> determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        public void setValue(DeterminateDrawable<?> determinateDrawable, float f) {
            determinateDrawable.setIndicatorFraction(f / 10000.0f);
        }
    };
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private final DrawingDelegate.ActiveIndicator activeIndicator;
    private DrawingDelegate<S> drawingDelegate;
    private boolean skipAnimationOnLevelChange = false;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;

    public DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate2) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        this.activeIndicator = new DrawingDelegate.ActiveIndicator();
        SpringForce springForce2 = new SpringForce();
        this.springForce = springForce2;
        springForce2.b = (double) 1.0f;
        springForce2.f1995a = false;
        springForce2.a = Math.sqrt((double) SPRING_FORCE_STIFFNESS);
        springForce2.f1995a = false;
        SpringAnimation springAnimation2 = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = springAnimation2;
        springAnimation2.a = springForce2;
        setGrowFraction(1.0f);
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return createCircularDrawable(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return createLinearDrawable(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    /* access modifiers changed from: private */
    public float getIndicatorFraction() {
        return this.activeIndicator.endFraction;
    }

    /* access modifiers changed from: private */
    public void setIndicatorFraction(float f) {
        this.activeIndicator.endFraction = f;
        invalidateSelf();
    }

    public void addSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        ArrayList<DynamicAnimation.OnAnimationEndListener> arrayList = this.springAnimation.f1990a;
        if (!arrayList.contains(onAnimationEndListener)) {
            arrayList.add(onAnimationEndListener);
        }
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getBounds(), getGrowFraction(), isShowing(), isHiding());
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setAntiAlias(true);
            DrawingDelegate.ActiveIndicator activeIndicator2 = this.activeIndicator;
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.baseSpec;
            activeIndicator2.color = baseProgressIndicatorSpec.indicatorColors[0];
            int i = baseProgressIndicatorSpec.indicatorTrackGapSize;
            if (i > 0) {
                if (!(this.drawingDelegate instanceof LinearDrawingDelegate)) {
                    i = (int) ((C1354qp.w(getIndicatorFraction(), 0.0f, GAP_RAMP_DOWN_THRESHOLD) * ((float) i)) / GAP_RAMP_DOWN_THRESHOLD);
                }
                Canvas canvas2 = canvas;
                this.drawingDelegate.fillTrack(canvas2, this.paint, getIndicatorFraction(), 1.0f, this.baseSpec.trackColor, getAlpha(), i);
            } else {
                this.drawingDelegate.fillTrack(canvas, this.paint, 0.0f, 1.0f, baseProgressIndicatorSpec.trackColor, getAlpha(), 0);
            }
            this.drawingDelegate.fillIndicator(canvas, this.paint, this.activeIndicator, getAlpha());
            this.drawingDelegate.drawStopIndicator(canvas, this.paint, this.baseSpec.indicatorColors[0], getAlpha());
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public void jumpToCurrentState() {
        this.springAnimation.c();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    public boolean onLevelChange(int i) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimation.c();
            setIndicatorFraction(((float) i) / 10000.0f);
        } else {
            SpringAnimation springAnimation2 = this.springAnimation;
            springAnimation2.b = getIndicatorFraction() * 10000.0f;
            springAnimation2.f1991a = true;
            SpringAnimation springAnimation3 = this.springAnimation;
            float f = (float) i;
            if (springAnimation3.f1993b) {
                springAnimation3.e = f;
            } else {
                if (springAnimation3.a == null) {
                    springAnimation3.a = new SpringForce(f);
                }
                SpringForce springForce2 = springAnimation3.a;
                double d = (double) f;
                springForce2.h = d;
                double d2 = (double) ((float) d);
                if (d2 <= ((double) Float.MAX_VALUE)) {
                    float f2 = springAnimation3.c;
                    if (d2 >= ((double) f2)) {
                        double abs = Math.abs((double) (springAnimation3.d * 0.75f));
                        springForce2.c = abs;
                        springForce2.d = abs * 62.5d;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            boolean z = springAnimation3.f1993b;
                            if (!z && !z) {
                                springAnimation3.f1993b = true;
                                if (!springAnimation3.f1991a) {
                                    springAnimation3.b = springAnimation3.f1988a.getValue(springAnimation3.f1989a);
                                }
                                float f3 = springAnimation3.b;
                                if (f3 > Float.MAX_VALUE || f3 < f2) {
                                    throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                                }
                                ThreadLocal<a> threadLocal = a.a;
                                if (threadLocal.get() == null) {
                                    threadLocal.set(new a());
                                }
                                a aVar = threadLocal.get();
                                ArrayList<a.b> arrayList = aVar.f1999a;
                                if (arrayList.size() == 0) {
                                    if (aVar.f1998a == null) {
                                        aVar.f1998a = new a.d(aVar.f1997a);
                                    }
                                    a.d dVar = aVar.f1998a;
                                    dVar.a.postFrameCallback(dVar.f2001a);
                                }
                                if (!arrayList.contains(springAnimation3)) {
                                    arrayList.add(springAnimation3);
                                }
                            }
                        } else {
                            throw new AndroidRuntimeException("Animations may only be started on the main thread");
                        }
                    } else {
                        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                    }
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                }
            }
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        super.registerAnimationCallback(animatable2Compat$AnimationCallback);
    }

    public void removeSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        ArrayList<DynamicAnimation.OnAnimationEndListener> arrayList = this.springAnimation.f1990a;
        int indexOf = arrayList.indexOf(onAnimationEndListener);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public void setDrawingDelegate(DrawingDelegate<S> drawingDelegate2) {
        this.drawingDelegate = drawingDelegate2;
    }

    public void setLevelByFraction(float f) {
        setLevel((int) (f * 10000.0f));
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            SpringForce springForce2 = this.springForce;
            float f = SPRING_FORCE_STIFFNESS / systemAnimatorDurationScale;
            springForce2.getClass();
            if (f > 0.0f) {
                springForce2.a = Math.sqrt((double) f);
                springForce2.f1995a = false;
            } else {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
        }
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        return super.unregisterAnimationCallback(animatable2Compat$AnimationCallback);
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, CircularDrawingDelegate circularDrawingDelegate) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate);
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec, LinearDrawingDelegate linearDrawingDelegate) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2, boolean z3) {
        return super.setVisible(z, z2, z3);
    }
}
