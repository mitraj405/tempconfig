package in.juspay.hypernfc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.google.logging.type.LogSeverity;

public class Wave extends View {
    private final int[] alphas = {LogSeverity.INFO_VALUE, LogSeverity.INFO_VALUE, LogSeverity.INFO_VALUE};
    private int offSet = 0;
    private final Paint[] paints = new Paint[3];
    private final float[] radii = {0.0f, 0.0f, 0.0f};

    public Wave(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private ValueAnimator createRingAnimator(Paint paint) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(4000);
        ofFloat.setInterpolator(new C1324pD());
        ofFloat.addUpdateListener(new C0442d1(this, 1, paint));
        return ofFloat;
    }

    private void init() {
        for (int i = 0; i < 3; i++) {
            this.paints[i] = new Paint();
            this.paints[i].setColor(Color.parseColor("#D9D9D9"));
            this.paints[i].setStyle(Paint.Style.STROKE);
            this.paints[i].setStrokeWidth(25.0f);
            this.paints[i].setAlpha(this.alphas[i]);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$createRingAnimator$0(float f) {
        if (f < 0.5f) {
            return 2.0f * f * f;
        }
        float f2 = 1.0f - f;
        return 1.0f - ((2.0f * f2) * f2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createRingAnimator$1(Paint paint, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float width = ((1.5f * floatValue) * ((float) getWidth())) / 2.0f;
        paint.setAlpha((int) ((1.0f - floatValue) * 150.0f));
        for (int i = 0; i < 3; i++) {
            if (paint == this.paints[i]) {
                this.radii[i] = width;
            }
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = this.offSet;
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.drawCircle((float) width, (float) i, this.radii[i2], this.paints[i2]);
        }
    }

    public void startRippleAnimation(int i) {
        this.offSet = i;
        final ValueAnimator[] valueAnimatorArr = new ValueAnimator[3];
        for (int i2 = 0; i2 < 3; i2++) {
            valueAnimatorArr[i2] = createRingAnimator(this.paints[i2]);
        }
        for (final int i3 = 0; i3 < 2; i3++) {
            valueAnimatorArr[i3].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getCurrentPlayTime() >= 500) {
                        valueAnimatorArr[i3 + 1].start();
                        valueAnimatorArr[i3].removeUpdateListener(this);
                    }
                }
            });
        }
        valueAnimatorArr[0].start();
    }
}
