package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.common.primitives.Ints;

public class MotionLabel extends View implements C0095Hc {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f1589a;

    /* renamed from: a  reason: collision with other field name */
    public BitmapShader f1590a;

    /* renamed from: a  reason: collision with other field name */
    public Matrix f1591a;

    /* renamed from: a  reason: collision with other field name */
    public final Paint f1592a = new Paint();

    /* renamed from: a  reason: collision with other field name */
    public Path f1593a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1594a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public RectF f1595a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1596a;

    /* renamed from: a  reason: collision with other field name */
    public final TextPaint f1597a = new TextPaint();

    /* renamed from: a  reason: collision with other field name */
    public ViewOutlineProvider f1598a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1599a = false;
    public float b = Float.NaN;

    /* renamed from: b  reason: collision with other field name */
    public Matrix f1600b;

    /* renamed from: b  reason: collision with other field name */
    public Paint f1601b;

    /* renamed from: b  reason: collision with other field name */
    public Rect f1602b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1603b = true;
    public float c = 48.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f1604c = 65535;

    /* renamed from: c  reason: collision with other field name */
    public String f1605c = "Hello World";

    /* renamed from: c  reason: collision with other field name */
    public boolean f1606c = false;
    public float d = Float.NaN;

    /* renamed from: d  reason: collision with other field name */
    public int f1607d = 65535;

    /* renamed from: d  reason: collision with other field name */
    public String f1608d;
    public float e = 0.0f;

    /* renamed from: e  reason: collision with other field name */
    public int f1609e;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f1610f;
    public float g;

    /* renamed from: g  reason: collision with other field name */
    public int f1611g = 1;
    public float h;

    /* renamed from: h  reason: collision with other field name */
    public int f1612h = 1;
    public float i = Float.NaN;

    /* renamed from: i  reason: collision with other field name */
    public int f1613i = 1;
    public float j = Float.NaN;

    /* renamed from: j  reason: collision with other field name */
    public int f1614j = 1;
    public float k = 0.0f;

    /* renamed from: k  reason: collision with other field name */
    public int f1615k = 8388659;
    public float l = 0.0f;

    /* renamed from: l  reason: collision with other field name */
    public int f1616l = 0;
    public float m;

    /* renamed from: m  reason: collision with other field name */
    public int f1617m = 0;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public final void getOutline(View view, Outline outline) {
            MotionLabel motionLabel = MotionLabel.this;
            int width = motionLabel.getWidth();
            int height = motionLabel.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * motionLabel.a) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public final void getOutline(View view, Outline outline) {
            MotionLabel motionLabel = MotionLabel.this;
            outline.setRoundRect(0, 0, motionLabel.getWidth(), motionLabel.getHeight(), motionLabel.b);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        c(context, (AttributeSet) null);
    }

    private float getHorizontalOffset() {
        float f2;
        float f3;
        if (Float.isNaN(this.d)) {
            f2 = 1.0f;
        } else {
            f2 = this.c / this.d;
        }
        String str = this.f1605c;
        float measureText = this.f1597a.measureText(str, 0, str.length()) * f2;
        if (Float.isNaN(this.g)) {
            f3 = (float) getMeasuredWidth();
        } else {
            f3 = this.g;
        }
        return ((this.k + 1.0f) * (((f3 - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - measureText)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2;
        float f3;
        if (Float.isNaN(this.d)) {
            f2 = 1.0f;
        } else {
            f2 = this.c / this.d;
        }
        Paint.FontMetrics fontMetrics = this.f1597a.getFontMetrics();
        if (Float.isNaN(this.h)) {
            f3 = (float) getMeasuredHeight();
        } else {
            f3 = this.h;
        }
        float paddingTop = (f3 - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f4 = fontMetrics.descent;
        float f5 = fontMetrics.ascent;
        return (((1.0f - this.l) * (paddingTop - ((f4 - f5) * f2))) / 2.0f) - (f2 * f5);
    }

    public final void a(float f2, float f3, float f4, float f5) {
        float f6;
        int i2 = (int) (f2 + 0.5f);
        this.f = f2 - ((float) i2);
        int i3 = (int) (f4 + 0.5f);
        int i4 = i3 - i2;
        int i5 = (int) (f5 + 0.5f);
        int i6 = (int) (0.5f + f3);
        int i7 = i5 - i6;
        float f7 = f4 - f2;
        this.g = f7;
        float f8 = f5 - f3;
        this.h = f8;
        if (this.f1600b != null) {
            this.g = f7;
            this.h = f8;
            d();
        }
        if (getMeasuredHeight() == i7 && getMeasuredWidth() == i4) {
            super.layout(i2, i6, i3, i5);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i4, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(i7, Ints.MAX_POWER_OF_TWO));
            super.layout(i2, i6, i3, i5);
        }
        if (this.f1606c) {
            Rect rect = this.f1602b;
            TextPaint textPaint = this.f1597a;
            if (rect == null) {
                this.f1601b = new Paint();
                this.f1602b = new Rect();
                this.f1601b.set(textPaint);
                this.m = this.f1601b.getTextSize();
            }
            this.g = f7;
            this.h = f8;
            Paint paint = this.f1601b;
            String str = this.f1605c;
            paint.getTextBounds(str, 0, str.length(), this.f1602b);
            int width = this.f1602b.width();
            float height = ((float) this.f1602b.height()) * 1.3f;
            float f9 = (f7 - ((float) this.f1612h)) - ((float) this.f1611g);
            float f10 = (f8 - ((float) this.f1614j)) - ((float) this.f1613i);
            float f11 = (float) width;
            if (f11 * f10 > height * f9) {
                textPaint.setTextSize((this.m * f9) / f11);
            } else {
                textPaint.setTextSize((this.m * f10) / height);
            }
            if (this.f1599a || !Float.isNaN(this.d)) {
                if (Float.isNaN(this.d)) {
                    f6 = 1.0f;
                } else {
                    f6 = this.c / this.d;
                }
                b(f6);
            }
        }
    }

    public final void b(float f2) {
        if (this.f1599a || f2 != 1.0f) {
            this.f1593a.reset();
            String str = this.f1605c;
            int length = str.length();
            TextPaint textPaint = this.f1597a;
            Rect rect = this.f1594a;
            textPaint.getTextBounds(str, 0, length, rect);
            textPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.f1593a);
            if (f2 != 1.0f) {
                C0175e8.a();
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.f1593a.transform(matrix);
            }
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.f1603b = false;
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Typeface typeface;
        Typeface typeface2;
        int i2;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0220hr.colorPrimary, typedValue, true);
        int i3 = typedValue.data;
        this.f1604c = i3;
        TextPaint textPaint = this.f1597a;
        textPaint.setColor(i3);
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == C0221hs.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == C0221hs.MotionLabel_android_fontFamily) {
                    this.f1608d = obtainStyledAttributes.getString(index);
                } else if (index == C0221hs.MotionLabel_scaleFromTextSize) {
                    this.d = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.d);
                } else if (index == C0221hs.MotionLabel_android_textSize) {
                    this.c = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.c);
                } else if (index == C0221hs.MotionLabel_android_textStyle) {
                    this.f1609e = obtainStyledAttributes.getInt(index, this.f1609e);
                } else if (index == C0221hs.MotionLabel_android_typeface) {
                    this.f1610f = obtainStyledAttributes.getInt(index, this.f1610f);
                } else if (index == C0221hs.MotionLabel_android_textColor) {
                    this.f1604c = obtainStyledAttributes.getColor(index, this.f1604c);
                } else if (index == C0221hs.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.b);
                    this.b = dimension;
                    setRound(dimension);
                } else if (index == C0221hs.MotionLabel_borderRoundPercent) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.a);
                    this.a = f2;
                    setRoundPercent(f2);
                } else if (index == C0221hs.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == C0221hs.MotionLabel_android_autoSizeTextType) {
                    this.f1616l = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0221hs.MotionLabel_textOutlineColor) {
                    this.f1607d = obtainStyledAttributes.getInt(index, this.f1607d);
                    this.f1599a = true;
                } else if (index == C0221hs.MotionLabel_textOutlineThickness) {
                    this.e = obtainStyledAttributes.getDimension(index, this.e);
                    this.f1599a = true;
                } else if (index == C0221hs.MotionLabel_textBackground) {
                    this.f1596a = obtainStyledAttributes.getDrawable(index);
                    this.f1599a = true;
                } else if (index == C0221hs.MotionLabel_textBackgroundPanX) {
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                } else if (index == C0221hs.MotionLabel_textBackgroundPanY) {
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                } else if (index == C0221hs.MotionLabel_textPanX) {
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                } else if (index == C0221hs.MotionLabel_textPanY) {
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                } else if (index == C0221hs.MotionLabel_textBackgroundRotate) {
                    this.q = obtainStyledAttributes.getFloat(index, this.q);
                } else if (index == C0221hs.MotionLabel_textBackgroundZoom) {
                    this.p = obtainStyledAttributes.getFloat(index, this.p);
                } else if (index == C0221hs.MotionLabel_textureHeight) {
                    this.i = obtainStyledAttributes.getDimension(index, this.i);
                } else if (index == C0221hs.MotionLabel_textureWidth) {
                    this.j = obtainStyledAttributes.getDimension(index, this.j);
                } else if (index == C0221hs.MotionLabel_textureEffect) {
                    this.f1617m = obtainStyledAttributes.getInt(index, this.f1617m);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1596a != null) {
            this.f1600b = new Matrix();
            int intrinsicWidth = this.f1596a.getIntrinsicWidth();
            int intrinsicHeight = this.f1596a.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.j)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.j;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (Float.isNaN(this.i)) {
                    intrinsicHeight = 128;
                } else {
                    intrinsicHeight = (int) this.i;
                }
            }
            if (this.f1617m != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.f1589a = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f1589a);
            this.f1596a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f1596a.setFilterBitmap(true);
            this.f1596a.draw(canvas);
            if (this.f1617m != 0) {
                Bitmap bitmap = this.f1589a;
                System.nanoTime();
                int width = bitmap.getWidth() / 2;
                int height = bitmap.getHeight() / 2;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                for (int i5 = 0; i5 < 4 && width >= 32 && height >= 32; i5++) {
                    width /= 2;
                    height /= 2;
                    createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
                }
                this.f1589a = createScaledBitmap;
            }
            Bitmap bitmap2 = this.f1589a;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f1590a = new BitmapShader(bitmap2, tileMode, tileMode);
        }
        this.f1611g = getPaddingLeft();
        this.f1612h = getPaddingRight();
        this.f1613i = getPaddingTop();
        this.f1614j = getPaddingBottom();
        String str = this.f1608d;
        int i6 = this.f1610f;
        int i7 = this.f1609e;
        if (str != null) {
            typeface = Typeface.create(str, i7);
            if (typeface != null) {
                setTypeface(typeface);
                textPaint.setColor(this.f1604c);
                textPaint.setStrokeWidth(this.e);
                textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                textPaint.setFlags(128);
                setTextSize(this.c);
                textPaint.setAntiAlias(true);
            }
        } else {
            typeface = null;
        }
        if (i6 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i6 == 2) {
            typeface = Typeface.SERIF;
        } else if (i6 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f3 = 0.0f;
        if (i7 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i7);
            } else {
                typeface2 = Typeface.create(typeface, i7);
            }
            setTypeface(typeface2);
            if (typeface2 != null) {
                i2 = typeface2.getStyle();
            } else {
                i2 = 0;
            }
            int i8 = (~i2) & i7;
            if ((i8 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            if ((i8 & 2) != 0) {
                f3 = -0.25f;
            }
            textPaint.setTextSkewX(f3);
        } else {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
        }
        textPaint.setColor(this.f1604c);
        textPaint.setStrokeWidth(this.e);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setFlags(128);
        setTextSize(this.c);
        textPaint.setAntiAlias(true);
    }

    public final void d() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8 = 0.0f;
        if (Float.isNaN(this.n)) {
            f2 = 0.0f;
        } else {
            f2 = this.n;
        }
        if (Float.isNaN(this.o)) {
            f3 = 0.0f;
        } else {
            f3 = this.o;
        }
        if (Float.isNaN(this.p)) {
            f4 = 1.0f;
        } else {
            f4 = this.p;
        }
        if (!Float.isNaN(this.q)) {
            f8 = this.q;
        }
        this.f1600b.reset();
        float width = (float) this.f1589a.getWidth();
        float height = (float) this.f1589a.getHeight();
        if (Float.isNaN(this.j)) {
            f5 = this.g;
        } else {
            f5 = this.j;
        }
        if (Float.isNaN(this.i)) {
            f6 = this.h;
        } else {
            f6 = this.i;
        }
        if (width * f6 < height * f5) {
            f7 = f5 / width;
        } else {
            f7 = f6 / height;
        }
        float f9 = f4 * f7;
        this.f1600b.postScale(f9, f9);
        float f10 = width * f9;
        float f11 = f5 - f10;
        float f12 = f9 * height;
        float f13 = f6 - f12;
        if (!Float.isNaN(this.i)) {
            f13 = this.i / 2.0f;
        }
        if (!Float.isNaN(this.j)) {
            f11 = this.j / 2.0f;
        }
        this.f1600b.postTranslate((((f2 * f11) + f5) - f10) * 0.5f, (((f3 * f13) + f6) - f12) * 0.5f);
        this.f1600b.postRotate(f8, f5 / 2.0f, f6 / 2.0f);
        this.f1590a.setLocalMatrix(this.f1600b);
    }

    public float getRound() {
        return this.b;
    }

    public float getRoundPercent() {
        return this.a;
    }

    public float getScaleFromTextSize() {
        return this.d;
    }

    public float getTextBackgroundPanX() {
        return this.n;
    }

    public float getTextBackgroundPanY() {
        return this.o;
    }

    public float getTextBackgroundRotate() {
        return this.q;
    }

    public float getTextBackgroundZoom() {
        return this.p;
    }

    public int getTextOutlineColor() {
        return this.f1607d;
    }

    public float getTextPanX() {
        return this.k;
    }

    public float getTextPanY() {
        return this.l;
    }

    public float getTextureHeight() {
        return this.i;
    }

    public float getTextureWidth() {
        return this.j;
    }

    public Typeface getTypeface() {
        return this.f1597a.getTypeface();
    }

    public final void layout(int i2, int i3, int i4, int i5) {
        float f2;
        super.layout(i2, i3, i4, i5);
        boolean isNaN = Float.isNaN(this.d);
        if (isNaN) {
            f2 = 1.0f;
        } else {
            f2 = this.c / this.d;
        }
        this.g = (float) (i4 - i2);
        this.h = (float) (i5 - i3);
        if (this.f1606c) {
            Rect rect = this.f1602b;
            TextPaint textPaint = this.f1597a;
            if (rect == null) {
                this.f1601b = new Paint();
                this.f1602b = new Rect();
                this.f1601b.set(textPaint);
                this.m = this.f1601b.getTextSize();
            }
            Paint paint = this.f1601b;
            String str = this.f1605c;
            paint.getTextBounds(str, 0, str.length(), this.f1602b);
            int width = this.f1602b.width();
            int height = (int) (((float) this.f1602b.height()) * 1.3f);
            float f3 = (this.g - ((float) this.f1612h)) - ((float) this.f1611g);
            float f4 = (this.h - ((float) this.f1614j)) - ((float) this.f1613i);
            if (isNaN) {
                float f5 = (float) width;
                float f6 = (float) height;
                if (f5 * f4 > f6 * f3) {
                    textPaint.setTextSize((this.m * f3) / f5);
                } else {
                    textPaint.setTextSize((this.m * f4) / f6);
                }
            } else {
                float f7 = (float) width;
                float f8 = (float) height;
                if (f7 * f4 > f8 * f3) {
                    f2 = f3 / f7;
                } else {
                    f2 = f4 / f8;
                }
            }
        }
        if (this.f1599a || !isNaN) {
            float f9 = (float) i2;
            float f10 = (float) i3;
            float f11 = (float) i4;
            float f12 = (float) i5;
            if (this.f1600b != null) {
                this.g = f11 - f9;
                this.h = f12 - f10;
                d();
            }
            b(f2);
        }
    }

    public final void onDraw(Canvas canvas) {
        float f2;
        if (Float.isNaN(this.d)) {
            f2 = 1.0f;
        } else {
            f2 = this.c / this.d;
        }
        super.onDraw(canvas);
        boolean z = this.f1599a;
        TextPaint textPaint = this.f1597a;
        if (z || f2 != 1.0f) {
            if (this.f1603b) {
                b(f2);
            }
            if (this.f1591a == null) {
                this.f1591a = new Matrix();
            }
            if (this.f1599a) {
                Paint paint = this.f1592a;
                paint.set(textPaint);
                this.f1591a.reset();
                float horizontalOffset = ((float) this.f1611g) + getHorizontalOffset();
                float verticalOffset = ((float) this.f1613i) + getVerticalOffset();
                this.f1591a.postTranslate(horizontalOffset, verticalOffset);
                this.f1591a.preScale(f2, f2);
                this.f1593a.transform(this.f1591a);
                if (this.f1590a != null) {
                    textPaint.setFilterBitmap(true);
                    textPaint.setShader(this.f1590a);
                } else {
                    textPaint.setColor(this.f1604c);
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setStrokeWidth(this.e);
                canvas.drawPath(this.f1593a, textPaint);
                if (this.f1590a != null) {
                    textPaint.setShader((Shader) null);
                }
                textPaint.setColor(this.f1607d);
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(this.e);
                canvas.drawPath(this.f1593a, textPaint);
                this.f1591a.reset();
                this.f1591a.postTranslate(-horizontalOffset, -verticalOffset);
                this.f1593a.transform(this.f1591a);
                textPaint.set(paint);
                return;
            }
            float horizontalOffset2 = ((float) this.f1611g) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.f1613i) + getVerticalOffset();
            this.f1591a.reset();
            this.f1591a.preTranslate(horizontalOffset2, verticalOffset2);
            this.f1593a.transform(this.f1591a);
            textPaint.setColor(this.f1604c);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint.setStrokeWidth(this.e);
            canvas.drawPath(this.f1593a, textPaint);
            this.f1591a.reset();
            this.f1591a.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.f1593a.transform(this.f1591a);
            return;
        }
        canvas.drawText(this.f1605c, this.f + ((float) this.f1611g) + getHorizontalOffset(), ((float) this.f1613i) + getVerticalOffset(), textPaint);
    }

    public final void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.f1606c = false;
        this.f1611g = getPaddingLeft();
        this.f1612h = getPaddingRight();
        this.f1613i = getPaddingTop();
        this.f1614j = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            String str = this.f1605c;
            int length = str.length();
            TextPaint textPaint = this.f1597a;
            Rect rect = this.f1594a;
            textPaint.getTextBounds(str, 0, length, rect);
            if (mode != 1073741824) {
                size = (int) (((float) rect.width()) + 0.99999f);
            }
            size += this.f1611g + this.f1612h;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) textPaint.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f1613i + this.f1614j + fontMetricsInt;
            }
        } else if (this.f1616l != 0) {
            this.f1606c = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i2) {
        if ((i2 & 8388615) == 0) {
            i2 |= 8388611;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        if (i2 != this.f1615k) {
            invalidate();
        }
        this.f1615k = i2;
        int i3 = i2 & 112;
        if (i3 == 48) {
            this.l = -1.0f;
        } else if (i3 != 80) {
            this.l = 0.0f;
        } else {
            this.l = 1.0f;
        }
        int i4 = i2 & 8388615;
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 8388611) {
                    if (i4 != 8388613) {
                        this.k = 0.0f;
                        return;
                    }
                }
            }
            this.k = 1.0f;
            return;
        }
        this.k = -1.0f;
    }

    public void setRound(float f2) {
        boolean z;
        if (Float.isNaN(f2)) {
            this.b = f2;
            float f3 = this.a;
            this.a = -1.0f;
            setRoundPercent(f3);
            return;
        }
        if (this.b != f2) {
            z = true;
        } else {
            z = false;
        }
        this.b = f2;
        if (f2 != 0.0f) {
            if (this.f1593a == null) {
                this.f1593a = new Path();
            }
            if (this.f1595a == null) {
                this.f1595a = new RectF();
            }
            if (this.f1598a == null) {
                b bVar = new b();
                this.f1598a = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1595a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1593a.reset();
            Path path = this.f1593a;
            RectF rectF = this.f1595a;
            float f4 = this.b;
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
        if (this.a != f2) {
            z = true;
        } else {
            z = false;
        }
        this.a = f2;
        if (f2 != 0.0f) {
            if (this.f1593a == null) {
                this.f1593a = new Path();
            }
            if (this.f1595a == null) {
                this.f1595a = new RectF();
            }
            if (this.f1598a == null) {
                a aVar = new a();
                this.f1598a = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.a) / 2.0f;
            this.f1595a.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1593a.reset();
            this.f1593a.addRoundRect(this.f1595a, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.d = f2;
    }

    public void setText(CharSequence charSequence) {
        this.f1605c = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.n = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.o = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.q = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.p = f2;
        d();
        invalidate();
    }

    public void setTextFillColor(int i2) {
        this.f1604c = i2;
        invalidate();
    }

    public void setTextOutlineColor(int i2) {
        this.f1607d = i2;
        this.f1599a = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.e = f2;
        this.f1599a = true;
        if (Float.isNaN(f2)) {
            this.e = 1.0f;
            this.f1599a = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.k = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.l = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        float f3;
        this.c = f2;
        C0175e8.a();
        if (!Float.isNaN(this.d)) {
            f2 = this.d;
        }
        this.f1597a.setTextSize(f2);
        if (Float.isNaN(this.d)) {
            f3 = 1.0f;
        } else {
            f3 = this.c / this.d;
        }
        b(f3);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.i = f2;
        d();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.j = f2;
        d();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        TextPaint textPaint = this.f1597a;
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
