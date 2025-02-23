package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class ImageFilterView extends AppCompatImageView {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public Path f1569a;

    /* renamed from: a  reason: collision with other field name */
    public RectF f1570a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1571a = null;

    /* renamed from: a  reason: collision with other field name */
    public LayerDrawable f1572a;

    /* renamed from: a  reason: collision with other field name */
    public ViewOutlineProvider f1573a;

    /* renamed from: a  reason: collision with other field name */
    public final c f1574a = new c();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1575a = true;

    /* renamed from: a  reason: collision with other field name */
    public final Drawable[] f1576a = new Drawable[2];
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f1577b = null;
    public float c = Float.NaN;
    public float d = Float.NaN;
    public float e = Float.NaN;
    public float f = Float.NaN;
    public float g = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public final void getOutline(View view, Outline outline) {
            ImageFilterView imageFilterView = ImageFilterView.this;
            int width = imageFilterView.getWidth();
            int height = imageFilterView.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * imageFilterView.b) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public final void getOutline(View view, Outline outline) {
            ImageFilterView imageFilterView = ImageFilterView.this;
            outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), imageFilterView.c);
        }
    }

    public static class c {
        public float a = 1.0f;

        /* renamed from: a  reason: collision with other field name */
        public final ColorMatrix f1578a = new ColorMatrix();

        /* renamed from: a  reason: collision with other field name */
        public final float[] f1579a = new float[20];
        public float b = 1.0f;

        /* renamed from: b  reason: collision with other field name */
        public final ColorMatrix f1580b = new ColorMatrix();
        public float c = 1.0f;
        public float d = 1.0f;

        public final void a(ImageView imageView) {
            boolean z;
            float f;
            float f2;
            float f3;
            float f4;
            ColorMatrix colorMatrix = this.f1578a;
            colorMatrix.reset();
            float f5 = this.b;
            float f6 = 1.0f;
            int i = (f5 > 1.0f ? 1 : (f5 == 1.0f ? 0 : -1));
            float[] fArr = this.f1579a;
            boolean z2 = true;
            if (i != 0) {
                float f7 = 1.0f - f5;
                float f8 = 0.2999f * f7;
                float f9 = 0.587f * f7;
                float f10 = f7 * 0.114f;
                fArr[0] = f8 + f5;
                fArr[1] = f9;
                fArr[2] = f10;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = f8;
                fArr[6] = f9 + f5;
                fArr[7] = f10;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = f8;
                fArr[11] = f9;
                fArr[12] = f10 + f5;
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 0.0f;
                fArr[16] = 0.0f;
                fArr[17] = 0.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                colorMatrix.set(fArr);
                z = true;
            } else {
                z = false;
            }
            float f11 = this.c;
            int i2 = (f11 > 1.0f ? 1 : (f11 == 1.0f ? 0 : -1));
            ColorMatrix colorMatrix2 = this.f1580b;
            if (i2 != 0) {
                colorMatrix2.setScale(f11, f11, f11, 1.0f);
                colorMatrix.postConcat(colorMatrix2);
                z = true;
            }
            float f12 = this.d;
            if (f12 != 1.0f) {
                if (f12 <= 0.0f) {
                    f12 = 0.01f;
                }
                float f13 = (5000.0f / f12) / 100.0f;
                if (f13 > 66.0f) {
                    double d2 = (double) (f13 - 60.0f);
                    f = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                    f2 = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
                } else {
                    f2 = (((float) Math.log((double) f13)) * 99.4708f) - 161.11957f;
                    f = 255.0f;
                }
                if (f13 >= 66.0f) {
                    f3 = f2;
                    f4 = 255.0f;
                } else if (f13 > 19.0f) {
                    f3 = f2;
                    f4 = (((float) Math.log((double) (f13 - 10.0f))) * 138.51773f) - 305.0448f;
                } else {
                    f3 = f2;
                    f4 = 0.0f;
                }
                float min = Math.min(255.0f, Math.max(f, 0.0f));
                float min2 = Math.min(255.0f, Math.max(f3, 0.0f));
                float min3 = Math.min(255.0f, Math.max(f4, 0.0f));
                float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
                float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
                fArr[0] = min / min4;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = min2 / min5;
                fArr[7] = 0.0f;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = 0.0f;
                fArr[11] = 0.0f;
                fArr[12] = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 0.0f;
                fArr[16] = 0.0f;
                fArr[17] = 0.0f;
                f6 = 1.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                colorMatrix2.set(fArr);
                colorMatrix.postConcat(colorMatrix2);
                z = true;
            }
            float f14 = this.a;
            if (f14 != f6) {
                fArr[0] = f14;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f14;
                fArr[7] = 0.0f;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = 0.0f;
                fArr[11] = 0.0f;
                fArr[12] = f14;
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 0.0f;
                fArr[16] = 0.0f;
                fArr[17] = 0.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                colorMatrix2.set(fArr);
                colorMatrix.postConcat(colorMatrix2);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                return;
            }
            ImageView imageView2 = imageView;
            imageView.clearColorFilter();
        }
    }

    public ImageFilterView(Context context) {
        super(context);
    }

    private void setOverlay(boolean z) {
        this.f1575a = z;
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1571a = obtainStyledAttributes.getDrawable(C0221hs.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ImageFilterView_crossfade) {
                    this.a = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C0221hs.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1575a));
                } else if (index == C0221hs.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.d));
                } else if (index == C0221hs.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.e));
                } else if (index == C0221hs.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.g));
                } else if (index == C0221hs.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f1577b = drawable;
            Drawable drawable2 = this.f1571a;
            Drawable[] drawableArr = this.f1576a;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.f1577b = drawable3;
                if (drawable3 != null) {
                    Drawable mutate = drawable3.mutate();
                    this.f1577b = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable mutate2 = getDrawable().mutate();
            this.f1577b = mutate2;
            drawableArr[0] = mutate2;
            drawableArr[1] = this.f1571a.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1572a = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.a * 255.0f));
            if (!this.f1575a) {
                this.f1572a.getDrawable(0).setAlpha((int) ((1.0f - this.a) * 255.0f));
            }
            super.setImageDrawable(this.f1572a);
        }
    }

    public final void d() {
        float f2;
        float f3;
        float f4;
        float f5;
        if (!Float.isNaN(this.d) || !Float.isNaN(this.e) || !Float.isNaN(this.f) || !Float.isNaN(this.g)) {
            float f6 = 0.0f;
            if (Float.isNaN(this.d)) {
                f2 = 0.0f;
            } else {
                f2 = this.d;
            }
            if (Float.isNaN(this.e)) {
                f3 = 0.0f;
            } else {
                f3 = this.e;
            }
            if (Float.isNaN(this.f)) {
                f4 = 1.0f;
            } else {
                f4 = this.f;
            }
            if (!Float.isNaN(this.g)) {
                f6 = this.g;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            if (intrinsicWidth * height < intrinsicHeight * width) {
                f5 = width / intrinsicWidth;
            } else {
                f5 = height / intrinsicHeight;
            }
            float f7 = f4 * f5;
            matrix.postScale(f7, f7);
            float f8 = intrinsicWidth * f7;
            float f9 = f7 * intrinsicHeight;
            matrix.postTranslate(((((width - f8) * f2) + width) - f8) * 0.5f, ((((height - f9) * f3) + height) - f9) * 0.5f);
            matrix.postRotate(f6, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public final void e() {
        if (!Float.isNaN(this.d) || !Float.isNaN(this.e) || !Float.isNaN(this.f) || !Float.isNaN(this.g)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public float getBrightness() {
        return this.f1574a.a;
    }

    public float getContrast() {
        return this.f1574a.c;
    }

    public float getCrossfade() {
        return this.a;
    }

    public float getImagePanX() {
        return this.d;
    }

    public float getImagePanY() {
        return this.e;
    }

    public float getImageRotate() {
        return this.g;
    }

    public float getImageZoom() {
        return this.f;
    }

    public float getRound() {
        return this.c;
    }

    public float getRoundPercent() {
        return this.b;
    }

    public float getSaturation() {
        return this.f1574a.b;
    }

    public float getWarmth() {
        return this.f1574a.d;
    }

    public final void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        d();
    }

    public void setAltImageResource(int i) {
        Drawable mutate = r1.w(getContext(), i).mutate();
        this.f1571a = mutate;
        Drawable drawable = this.f1577b;
        Drawable[] drawableArr = this.f1576a;
        drawableArr[0] = drawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1572a = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a);
    }

    public void setBrightness(float f2) {
        c cVar = this.f1574a;
        cVar.a = f2;
        cVar.a(this);
    }

    public void setContrast(float f2) {
        c cVar = this.f1574a;
        cVar.c = f2;
        cVar.a(this);
    }

    public void setCrossfade(float f2) {
        this.a = f2;
        if (this.f1576a != null) {
            if (!this.f1575a) {
                this.f1572a.getDrawable(0).setAlpha((int) ((1.0f - this.a) * 255.0f));
            }
            this.f1572a.getDrawable(1).setAlpha((int) (this.a * 255.0f));
            super.setImageDrawable(this.f1572a);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f1571a == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1577b = mutate;
        Drawable[] drawableArr = this.f1576a;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1571a;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1572a = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a);
    }

    public void setImagePanX(float f2) {
        this.d = f2;
        e();
    }

    public void setImagePanY(float f2) {
        this.e = f2;
        e();
    }

    public void setImageResource(int i) {
        if (this.f1571a != null) {
            Drawable mutate = r1.w(getContext(), i).mutate();
            this.f1577b = mutate;
            Drawable[] drawableArr = this.f1576a;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f1571a;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1572a = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.a);
            return;
        }
        super.setImageResource(i);
    }

    public void setImageRotate(float f2) {
        this.g = f2;
        e();
    }

    public void setImageZoom(float f2) {
        this.f = f2;
        e();
    }

    public void setRound(float f2) {
        boolean z;
        if (Float.isNaN(f2)) {
            this.c = f2;
            float f3 = this.b;
            this.b = -1.0f;
            setRoundPercent(f3);
            return;
        }
        if (this.c != f2) {
            z = true;
        } else {
            z = false;
        }
        this.c = f2;
        if (f2 != 0.0f) {
            if (this.f1569a == null) {
                this.f1569a = new Path();
            }
            if (this.f1570a == null) {
                this.f1570a = new RectF();
            }
            if (this.f1573a == null) {
                b bVar = new b();
                this.f1573a = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1570a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1569a.reset();
            Path path = this.f1569a;
            RectF rectF = this.f1570a;
            float f4 = this.c;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z;
        if (this.b != f2) {
            z = true;
        } else {
            z = false;
        }
        this.b = f2;
        if (f2 != 0.0f) {
            if (this.f1569a == null) {
                this.f1569a = new Path();
            }
            if (this.f1570a == null) {
                this.f1570a = new RectF();
            }
            if (this.f1573a == null) {
                a aVar = new a();
                this.f1573a = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.b) / 2.0f;
            this.f1570a.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1569a.reset();
            this.f1569a.addRoundRect(this.f1570a, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        c cVar = this.f1574a;
        cVar.b = f2;
        cVar.a(this);
    }

    public void setWarmth(float f2) {
        c cVar = this.f1574a;
        cVar.d = f2;
        cVar.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
    }
}
