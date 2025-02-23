package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;

public class MotionButton extends AppCompatButton {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public Path f1586a;

    /* renamed from: a  reason: collision with other field name */
    public RectF f1587a;

    /* renamed from: a  reason: collision with other field name */
    public ViewOutlineProvider f1588a;
    public float b = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public final void getOutline(View view, Outline outline) {
            MotionButton motionButton = MotionButton.this;
            int width = motionButton.getWidth();
            int height = motionButton.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * motionButton.a) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public final void getOutline(View view, Outline outline) {
            MotionButton motionButton = MotionButton.this;
            outline.setRoundRect(0, 0, motionButton.getWidth(), motionButton.getHeight(), motionButton.b);
        }
    }

    public MotionButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == C0221hs.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.b;
    }

    public float getRoundPercent() {
        return this.a;
    }

    public void setRound(float f) {
        boolean z;
        if (Float.isNaN(f)) {
            this.b = f;
            float f2 = this.a;
            this.a = -1.0f;
            setRoundPercent(f2);
            return;
        }
        if (this.b != f) {
            z = true;
        } else {
            z = false;
        }
        this.b = f;
        if (f != 0.0f) {
            if (this.f1586a == null) {
                this.f1586a = new Path();
            }
            if (this.f1587a == null) {
                this.f1587a = new RectF();
            }
            if (this.f1588a == null) {
                b bVar = new b();
                this.f1588a = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1587a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1586a.reset();
            Path path = this.f1586a;
            RectF rectF = this.f1587a;
            float f3 = this.b;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z;
        if (this.a != f) {
            z = true;
        } else {
            z = false;
        }
        this.a = f;
        if (f != 0.0f) {
            if (this.f1586a == null) {
                this.f1586a = new Path();
            }
            if (this.f1587a == null) {
                this.f1587a = new RectF();
            }
            if (this.f1588a == null) {
                a aVar = new a();
                this.f1588a = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.a) / 2.0f;
            this.f1587a.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1586a.reset();
            this.f1586a.addRoundRect(this.f1587a, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }
}
