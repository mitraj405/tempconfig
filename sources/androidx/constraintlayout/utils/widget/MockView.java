package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;

public class MockView extends View {
    public final Paint a = new Paint();

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1581a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1582a = true;
    public final Paint b = new Paint();

    /* renamed from: b  reason: collision with other field name */
    public boolean f1583b = true;
    public int c = Color.argb(Constants.MAX_HOST_LENGTH, 0, 0, 0);

    /* renamed from: c  reason: collision with other field name */
    public final Paint f1584c = new Paint();

    /* renamed from: c  reason: collision with other field name */
    public String f1585c = null;
    public int d = Color.argb(Constants.MAX_HOST_LENGTH, LogSeverity.INFO_VALUE, LogSeverity.INFO_VALUE, LogSeverity.INFO_VALUE);
    public int e = Color.argb(Constants.MAX_HOST_LENGTH, 50, 50, 50);
    public int f = 4;

    public MockView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.MockView_mock_label) {
                    this.f1585c = obtainStyledAttributes.getString(index);
                } else if (index == C0221hs.MockView_mock_showDiagonals) {
                    this.f1582a = obtainStyledAttributes.getBoolean(index, this.f1582a);
                } else if (index == C0221hs.MockView_mock_diagonalsColor) {
                    this.c = obtainStyledAttributes.getColor(index, this.c);
                } else if (index == C0221hs.MockView_mock_labelBackgroundColor) {
                    this.e = obtainStyledAttributes.getColor(index, this.e);
                } else if (index == C0221hs.MockView_mock_labelColor) {
                    this.d = obtainStyledAttributes.getColor(index, this.d);
                } else if (index == C0221hs.MockView_mock_showLabel) {
                    this.f1583b = obtainStyledAttributes.getBoolean(index, this.f1583b);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1585c == null) {
            try {
                this.f1585c = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i2 = this.c;
        Paint paint = this.a;
        paint.setColor(i2);
        paint.setAntiAlias(true);
        int i3 = this.d;
        Paint paint2 = this.b;
        paint2.setColor(i3);
        paint2.setAntiAlias(true);
        this.f1584c.setColor(this.e);
        this.f = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * ((float) this.f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1582a) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f2, f3, this.a);
            Canvas canvas2 = canvas;
            float f4 = f2;
            canvas2.drawLine(0.0f, f3, f4, 0.0f, this.a);
            canvas2.drawLine(0.0f, 0.0f, f4, 0.0f, this.a);
            float f5 = f2;
            float f6 = f3;
            canvas2.drawLine(f5, 0.0f, f4, f6, this.a);
            float f7 = f3;
            canvas2.drawLine(f5, f7, 0.0f, f6, this.a);
            canvas2.drawLine(0.0f, f7, 0.0f, 0.0f, this.a);
        }
        String str = this.f1585c;
        if (str != null && this.f1583b) {
            int length = str.length();
            Paint paint = this.b;
            Rect rect = this.f1581a;
            paint.getTextBounds(str, 0, length, rect);
            float width2 = ((float) (width - rect.width())) / 2.0f;
            float height2 = (((float) (height - rect.height())) / 2.0f) + ((float) rect.height());
            rect.offset((int) width2, (int) height2);
            int i = rect.left;
            int i2 = this.f;
            rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
            canvas.drawRect(rect, this.f1584c);
            canvas.drawText(this.f1585c, width2, height2, paint);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
