package com.cyberfend.cyfsecurity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar extends View {
    public static final /* synthetic */ int f = 0;
    public final float a = 20.0f;

    /* renamed from: a  reason: collision with other field name */
    public final Paint f2782a;

    /* renamed from: a  reason: collision with other field name */
    public final RectF f2783a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f2784a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2785a;
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public final Paint f2786b;
    public final int c = 100;
    public final int d = 270;
    public int e = 0;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            int i = CircleProgressBar.f;
            CircleProgressBar circleProgressBar = CircleProgressBar.this;
            int i2 = circleProgressBar.e;
            if (i2 < 9) {
                circleProgressBar.e = i2 + 1;
                circleProgressBar.b += 1.0f;
                circleProgressBar.postInvalidate();
                circleProgressBar.f2784a.postDelayed(circleProgressBar.f2785a, 100);
            }
        }
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Handler handler = new Handler();
        this.f2784a = handler;
        a aVar = new a();
        this.f2785a = aVar;
        this.f2783a = new RectF();
        Paint paint = new Paint(1);
        this.f2782a = paint;
        paint.setColor(context.getResources().getColor(C0275mr.akamaiCCAcolorProgressBackground));
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f2786b = paint2;
        paint2.setColor(context.getResources().getColor(C0275mr.akamaiCCAcolorProgressForeground));
        paint2.setStyle(Paint.Style.FILL);
        handler.postDelayed(aVar, 100);
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f2783a;
        canvas.drawOval(rectF, this.f2782a);
        Canvas canvas2 = canvas;
        canvas2.drawArc(rectF, (float) this.d, (this.b * 360.0f) / ((float) this.c), true, this.f2786b);
    }

    public final void onMeasure(int i, int i2) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.f2783a;
        float f2 = this.a;
        float f3 = (float) min;
        rectF.set((f2 / 2.0f) + 0.0f, (f2 / 2.0f) + 0.0f, f3 - (f2 / 2.0f), f3 - (f2 / 2.0f));
    }

    public synchronized void setProgress(float f2) {
        this.b = f2 * ((float) this.c);
        this.e = 0;
        this.f2784a.postDelayed(this.f2785a, 100);
        postInvalidate();
    }

    public void setProgressBarColor(int i) {
        this.f2786b.setColor(i);
        this.f2782a.setColor(Color.argb(Math.round(((float) Color.alpha(i)) * 0.25f), Color.red(i), Color.green(i), Color.blue(i)));
    }
}
