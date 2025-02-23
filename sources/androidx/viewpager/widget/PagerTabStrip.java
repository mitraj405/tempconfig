package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.google.firebase.perf.util.Constants;
import defpackage.d7;

public class PagerTabStrip extends PagerTitleStrip {
    public final Paint a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2551a;
    public float b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2552c;
    public boolean d;
    public boolean e;
    public int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public final int o;
    public final int p;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f2556a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f2556a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void c(float f, boolean z, int i2) {
        int height = getHeight();
        TextView textView = this.f2559b;
        int left = textView.getLeft();
        int i3 = this.m;
        int i4 = height - this.i;
        Rect rect = this.f2551a;
        rect.set(left - i3, i4, textView.getRight() + i3, height);
        super.c(f, z, i2);
        this.n = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i3, i4, textView.getRight() + i3, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f2552c;
    }

    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.l);
    }

    public int getTabIndicatorColor() {
        return this.h;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f2559b;
        int left = textView.getLeft();
        int i2 = this.m;
        int right = textView.getRight() + i2;
        Paint paint = this.a;
        paint.setColor((this.n << 24) | (this.h & 16777215));
        float f = (float) right;
        float f2 = (float) height;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) (left - i2), (float) (height - this.i), f, f2, paint);
        if (this.f2552c) {
            paint.setColor((this.h & 16777215) | -16777216);
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.o), (float) (getWidth() - getPaddingRight()), f2, paint);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.e) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.b = x;
            this.c = y;
            this.e = false;
        } else if (action == 1) {
            TextView textView = this.f2559b;
            int left = textView.getLeft();
            int i2 = this.m;
            if (x < ((float) (left - i2))) {
                ViewPager viewPager = this.f2556a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x > ((float) (textView.getRight() + i2))) {
                ViewPager viewPager2 = this.f2556a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else if (action == 2) {
            float abs = Math.abs(x - this.b);
            int i3 = this.p;
            if (abs > ((float) i3) || Math.abs(y - this.c) > ((float) i3)) {
                this.e = true;
            }
        }
        return true;
    }

    public void setBackgroundColor(int i2) {
        boolean z;
        super.setBackgroundColor(i2);
        if (!this.d) {
            if ((i2 & -16777216) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f2552c = z;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        boolean z;
        super.setBackgroundDrawable(drawable);
        if (!this.d) {
            if (drawable == null) {
                z = true;
            } else {
                z = false;
            }
            this.f2552c = z;
        }
    }

    public void setBackgroundResource(int i2) {
        boolean z;
        super.setBackgroundResource(i2);
        if (!this.d) {
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f2552c = z;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f2552c = z;
        this.d = true;
        invalidate();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.j;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(int i2) {
        this.h = i2;
        this.a.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        Context context = getContext();
        Object obj = d7.a;
        setTabIndicatorColor(d7.b.a(context, i2));
    }

    public void setTextSpacing(int i2) {
        int i3 = this.k;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.a = paint;
        this.f2551a = new Rect();
        this.n = Constants.MAX_HOST_LENGTH;
        this.f2552c = false;
        this.d = false;
        int i2 = this.g;
        this.h = i2;
        paint.setColor(i2);
        float f = context.getResources().getDisplayMetrics().density;
        this.i = (int) ((3.0f * f) + 0.5f);
        this.j = (int) ((6.0f * f) + 0.5f);
        this.k = (int) (64.0f * f);
        this.m = (int) ((16.0f * f) + 0.5f);
        this.o = (int) ((1.0f * f) + 0.5f);
        this.l = (int) ((f * 32.0f) + 0.5f);
        this.p = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f2554a.setFocusable(true);
        this.f2554a.setOnClickListener(new a());
        this.f2561c.setFocusable(true);
        this.f2561c.setOnClickListener(new b());
        if (getBackground() == null) {
            this.f2552c = true;
        }
    }
}
