package io.github.inflationx.calligraphy3;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CalligraphyTypefaceSpan extends MetricAffectingSpan {
    private final Typeface typeface;

    public CalligraphyTypefaceSpan(Typeface typeface2) {
        if (typeface2 != null) {
            this.typeface = typeface2;
            return;
        }
        throw new IllegalArgumentException("typeface is null");
    }

    private void apply(Paint paint) {
        int i;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 != null) {
            i = typeface2.getStyle();
        } else {
            i = 0;
        }
        int i2 = i & (~this.typeface.getStyle());
        if ((i2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }
}
