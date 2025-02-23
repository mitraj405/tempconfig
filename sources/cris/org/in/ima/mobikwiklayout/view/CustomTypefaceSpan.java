package cris.org.in.ima.mobikwiklayout.view;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {
    public final Typeface a;

    public CustomTypefaceSpan(Typeface typeface) {
        super("");
        this.a = typeface;
    }

    public static void b(Paint paint, Typeface typeface) {
        int i;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i = 0;
        } else {
            i = typeface2.getStyle();
        }
        int i2 = i & (~typeface.getStyle());
        if ((i2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public final void updateDrawState(TextPaint textPaint) {
        b(textPaint, this.a);
    }

    public final void updateMeasureState(TextPaint textPaint) {
        b(textPaint, this.a);
    }
}
