package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.firebase.perf.util.Constants;

/* renamed from: l5  reason: default package */
/* compiled from: CircularProgressDrawable */
public final class l5 extends Drawable implements Animatable {
    public static final LinearInterpolator a = new LinearInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static final FastOutSlowInInterpolator f3055a = new FastOutSlowInInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f3056a = {-16777216};

    /* renamed from: a  reason: collision with other field name */
    public float f3057a;

    /* renamed from: a  reason: collision with other field name */
    public ValueAnimator f3058a;

    /* renamed from: a  reason: collision with other field name */
    public final Resources f3059a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3060a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3061a;
    public float b;

    /* renamed from: l5$a */
    /* compiled from: CircularProgressDrawable */
    public static class a {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f3062a;

        /* renamed from: a  reason: collision with other field name */
        public final Paint f3063a;

        /* renamed from: a  reason: collision with other field name */
        public Path f3064a;

        /* renamed from: a  reason: collision with other field name */
        public final RectF f3065a = new RectF();

        /* renamed from: a  reason: collision with other field name */
        public boolean f3066a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f3067a;
        public float b;

        /* renamed from: b  reason: collision with other field name */
        public int f3068b;

        /* renamed from: b  reason: collision with other field name */
        public final Paint f3069b;
        public float c;

        /* renamed from: c  reason: collision with other field name */
        public int f3070c;

        /* renamed from: c  reason: collision with other field name */
        public final Paint f3071c;
        public float d;

        /* renamed from: d  reason: collision with other field name */
        public int f3072d;
        public float e;

        /* renamed from: e  reason: collision with other field name */
        public int f3073e;
        public float f;
        public float g;
        public float h;
        public float i;

        public a() {
            Paint paint = new Paint();
            this.f3063a = paint;
            Paint paint2 = new Paint();
            this.f3069b = paint2;
            Paint paint3 = new Paint();
            this.f3071c = paint3;
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 5.0f;
            this.h = 1.0f;
            this.f3072d = Constants.MAX_HOST_LENGTH;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public final void a(int i2) {
            this.f3062a = i2;
            this.f3073e = this.f3067a[i2];
        }
    }

    public l5(Context context) {
        context.getClass();
        this.f3059a = context.getResources();
        a aVar = new a();
        this.f3060a = aVar;
        aVar.f3067a = f3056a;
        aVar.a(0);
        aVar.d = 2.5f;
        aVar.f3063a.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new j5(this, aVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(a);
        ofFloat.addListener(new k5(this, aVar));
        this.f3058a = ofFloat;
    }

    public static void d(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int[] iArr = aVar.f3067a;
            int i = aVar.f3062a;
            int i2 = iArr[i];
            int i3 = iArr[(i + 1) % iArr.length];
            int i4 = (i2 >> 24) & Constants.MAX_HOST_LENGTH;
            int i5 = (i2 >> 16) & Constants.MAX_HOST_LENGTH;
            int i6 = (i2 >> 8) & Constants.MAX_HOST_LENGTH;
            int i7 = i2 & Constants.MAX_HOST_LENGTH;
            aVar.f3073e = ((i4 + ((int) (((float) (((i3 >> 24) & Constants.MAX_HOST_LENGTH) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & Constants.MAX_HOST_LENGTH) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & Constants.MAX_HOST_LENGTH) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & Constants.MAX_HOST_LENGTH) - i7)))));
            return;
        }
        aVar.f3073e = aVar.f3067a[aVar.f3062a];
    }

    public final void a(float f, a aVar, boolean z) {
        float f2;
        float f3;
        if (this.f3061a) {
            d(f, aVar);
            float floor = (float) (Math.floor((double) (aVar.g / 0.8f)) + 1.0d);
            float f4 = aVar.e;
            float f5 = aVar.f;
            aVar.a = (((f5 - 0.01f) - f4) * f) + f4;
            aVar.b = f5;
            float f6 = aVar.g;
            aVar.c = lf.a(floor, f6, f, f6);
        } else if (f != 1.0f || z) {
            float f7 = aVar.g;
            int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
            FastOutSlowInInterpolator fastOutSlowInInterpolator = f3055a;
            if (i < 0) {
                f2 = aVar.e;
                f3 = (fastOutSlowInInterpolator.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + f2;
            } else {
                float f8 = aVar.e + 0.79f;
                float f9 = f8;
                f2 = f8 - (((1.0f - fastOutSlowInInterpolator.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = f9;
            }
            aVar.a = f2;
            aVar.b = f3;
            aVar.c = (0.20999998f * f) + f7;
            this.f3057a = (f + this.b) * 216.0f;
        }
    }

    public final void b(float f, float f2, float f3, float f4) {
        float f5 = this.f3059a.getDisplayMetrics().density;
        float f6 = f2 * f5;
        a aVar = this.f3060a;
        aVar.d = f6;
        aVar.f3063a.setStrokeWidth(f6);
        aVar.i = f * f5;
        aVar.a(0);
        aVar.f3068b = (int) (f3 * f5);
        aVar.f3070c = (int) (f4 * f5);
    }

    public final void c(int i) {
        if (i == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3057a, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.f3060a;
        RectF rectF = aVar.f3065a;
        float f = aVar.i;
        float f2 = (aVar.d / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) aVar.f3068b) * aVar.h) / 2.0f, aVar.d / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f2, ((float) bounds.centerY()) - f2, ((float) bounds.centerX()) + f2, ((float) bounds.centerY()) + f2);
        float f3 = aVar.a;
        float f4 = aVar.c;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((aVar.b + f4) * 360.0f) - f5;
        Paint paint = aVar.f3063a;
        paint.setColor(aVar.f3073e);
        paint.setAlpha(aVar.f3072d);
        float f7 = aVar.d / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.f3071c);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, paint);
        if (aVar.f3066a) {
            Path path = aVar.f3064a;
            if (path == null) {
                Path path2 = new Path();
                aVar.f3064a = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            aVar.f3064a.moveTo(0.0f, 0.0f);
            aVar.f3064a.lineTo(((float) aVar.f3068b) * aVar.h, 0.0f);
            Path path3 = aVar.f3064a;
            float f9 = aVar.h;
            path3.lineTo((((float) aVar.f3068b) * f9) / 2.0f, ((float) aVar.f3070c) * f9);
            aVar.f3064a.offset((rectF.centerX() + (Math.min(rectF.width(), rectF.height()) / 2.0f)) - ((((float) aVar.f3068b) * aVar.h) / 2.0f), (aVar.d / 2.0f) + rectF.centerY());
            aVar.f3064a.close();
            Paint paint2 = aVar.f3069b;
            paint2.setColor(aVar.f3073e);
            paint2.setAlpha(aVar.f3072d);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.f3064a, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    public final int getAlpha() {
        return this.f3060a.f3072d;
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        return this.f3058a.isRunning();
    }

    public final void setAlpha(int i) {
        this.f3060a.f3072d = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3060a.f3063a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void start() {
        this.f3058a.cancel();
        a aVar = this.f3060a;
        float f = aVar.a;
        aVar.e = f;
        float f2 = aVar.b;
        aVar.f = f2;
        aVar.g = aVar.c;
        if (f2 != f) {
            this.f3061a = true;
            this.f3058a.setDuration(666);
            this.f3058a.start();
            return;
        }
        aVar.a(0);
        aVar.e = 0.0f;
        aVar.f = 0.0f;
        aVar.g = 0.0f;
        aVar.a = 0.0f;
        aVar.b = 0.0f;
        aVar.c = 0.0f;
        this.f3058a.setDuration(1332);
        this.f3058a.start();
    }

    public final void stop() {
        this.f3058a.cancel();
        this.f3057a = 0.0f;
        a aVar = this.f3060a;
        if (aVar.f3066a) {
            aVar.f3066a = false;
        }
        aVar.a(0);
        aVar.e = 0.0f;
        aVar.f = 0.0f;
        aVar.g = 0.0f;
        aVar.a = 0.0f;
        aVar.b = 0.0f;
        aVar.c = 0.0f;
        invalidateSelf();
    }
}
