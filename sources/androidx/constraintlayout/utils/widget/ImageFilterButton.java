package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;

public class ImageFilterButton extends AppCompatImageButton {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public Path f1560a;

    /* renamed from: a  reason: collision with other field name */
    public RectF f1561a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1562a = null;

    /* renamed from: a  reason: collision with other field name */
    public LayerDrawable f1563a;

    /* renamed from: a  reason: collision with other field name */
    public ViewOutlineProvider f1564a;

    /* renamed from: a  reason: collision with other field name */
    public final ImageFilterView.c f1565a = new ImageFilterView.c();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1566a = true;

    /* renamed from: a  reason: collision with other field name */
    public final Drawable[] f1567a = new Drawable[2];
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f1568b = null;
    public float c = Float.NaN;
    public float d = Float.NaN;
    public float e = Float.NaN;
    public float f = Float.NaN;
    public float g = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public final void getOutline(View view, Outline outline) {
            ImageFilterButton imageFilterButton = ImageFilterButton.this;
            int width = imageFilterButton.getWidth();
            int height = imageFilterButton.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * imageFilterButton.b) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public final void getOutline(View view, Outline outline) {
            ImageFilterButton imageFilterButton = ImageFilterButton.this;
            outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), imageFilterButton.c);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    private void setOverlay(boolean z) {
        this.f1566a = z;
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1562a = obtainStyledAttributes.getDrawable(C0221hs.ImageFilterView_altSrc);
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
                } else if (index == C0221hs.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1566a));
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
            this.f1568b = drawable;
            Drawable drawable2 = this.f1562a;
            Drawable[] drawableArr = this.f1567a;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.f1568b = drawable3;
                if (drawable3 != null) {
                    Drawable mutate = drawable3.mutate();
                    this.f1568b = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable mutate2 = getDrawable().mutate();
            this.f1568b = mutate2;
            drawableArr[0] = mutate2;
            drawableArr[1] = this.f1562a.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1563a = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.a * 255.0f));
            if (!this.f1566a) {
                this.f1563a.getDrawable(0).setAlpha((int) ((1.0f - this.a) * 255.0f));
            }
            super.setImageDrawable(this.f1563a);
        }
    }

    public final void b() {
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

    public final void c() {
        if (!Float.isNaN(this.d) || !Float.isNaN(this.e) || !Float.isNaN(this.f) || !Float.isNaN(this.g)) {
            b();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f1565a.c;
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
        return this.f1565a.b;
    }

    public float getWarmth() {
        return this.f1565a.d;
    }

    public final void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        b();
    }

    public void setAltImageResource(int i) {
        Drawable mutate = r1.w(getContext(), i).mutate();
        this.f1562a = mutate;
        Drawable drawable = this.f1568b;
        Drawable[] drawableArr = this.f1567a;
        drawableArr[0] = drawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1563a = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a);
    }

    public void setBrightness(float f2) {
        ImageFilterView.c cVar = this.f1565a;
        cVar.a = f2;
        cVar.a(this);
    }

    public void setContrast(float f2) {
        ImageFilterView.c cVar = this.f1565a;
        cVar.c = f2;
        cVar.a(this);
    }

    public void setCrossfade(float f2) {
        this.a = f2;
        if (this.f1567a != null) {
            if (!this.f1566a) {
                this.f1563a.getDrawable(0).setAlpha((int) ((1.0f - this.a) * 255.0f));
            }
            this.f1563a.getDrawable(1).setAlpha((int) (this.a * 255.0f));
            super.setImageDrawable(this.f1563a);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f1562a == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1568b = mutate;
        Drawable[] drawableArr = this.f1567a;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1562a;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1563a = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a);
    }

    public void setImagePanX(float f2) {
        this.d = f2;
        c();
    }

    public void setImagePanY(float f2) {
        this.e = f2;
        c();
    }

    public void setImageResource(int i) {
        if (this.f1562a != null) {
            Drawable mutate = r1.w(getContext(), i).mutate();
            this.f1568b = mutate;
            Drawable[] drawableArr = this.f1567a;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f1562a;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1563a = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.a);
            return;
        }
        super.setImageResource(i);
    }

    public void setImageRotate(float f2) {
        this.g = f2;
        c();
    }

    public void setImageZoom(float f2) {
        this.f = f2;
        c();
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
            if (this.f1560a == null) {
                this.f1560a = new Path();
            }
            if (this.f1561a == null) {
                this.f1561a = new RectF();
            }
            if (this.f1564a == null) {
                b bVar = new b();
                this.f1564a = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1561a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1560a.reset();
            Path path = this.f1560a;
            RectF rectF = this.f1561a;
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
            if (this.f1560a == null) {
                this.f1560a = new Path();
            }
            if (this.f1561a == null) {
                this.f1561a = new RectF();
            }
            if (this.f1564a == null) {
                a aVar = new a();
                this.f1564a = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.b) / 2.0f;
            this.f1561a.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1560a.reset();
            this.f1560a.addRoundRect(this.f1561a, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageFilterView.c cVar = this.f1565a;
        cVar.b = f2;
        cVar.a(this);
    }

    public void setWarmth(float f2) {
        ImageFilterView.c cVar = this.f1565a;
        cVar.d = f2;
        cVar.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }
}
