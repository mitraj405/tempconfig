package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.d;

/* compiled from: DefaultGlyphChecker */
public final class b implements d.C0019d {
    public static final ThreadLocal<StringBuilder> a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public final TextPaint f2003a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f2003a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
