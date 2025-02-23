package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: pa  reason: default package and case insensitive filesystem */
/* compiled from: EmojiSpan */
public abstract class C0295pa extends ReplacementSpan {
    public float a = 1.0f;

    /* renamed from: a  reason: collision with other field name */
    public final Paint.FontMetricsInt f3170a = new Paint.FontMetricsInt();

    /* renamed from: a  reason: collision with other field name */
    public final C0287oa f3171a;

    public C0295pa(C0287oa oaVar) {
        if (oaVar != null) {
            this.f3171a = oaVar;
            return;
        }
        throw new NullPointerException("metadata cannot be null");
    }

    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        short s;
        Paint.FontMetricsInt fontMetricsInt2 = this.f3170a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = ((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f;
        C0287oa oaVar = this.f3171a;
        kl c = oaVar.c();
        int a2 = c.a(14);
        short s2 = 0;
        if (a2 != 0) {
            s = c.f3207a.getShort(a2 + c.a);
        } else {
            s = 0;
        }
        this.a = abs / ((float) s);
        kl c2 = oaVar.c();
        int a3 = c2.a(14);
        if (a3 != 0) {
            c2.f3207a.getShort(a3 + c2.a);
        }
        kl c3 = oaVar.c();
        int a4 = c3.a(12);
        if (a4 != 0) {
            s2 = c3.f3207a.getShort(a4 + c3.a);
        }
        short s3 = (short) ((int) (((float) s2) * this.a));
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s3;
    }
}
