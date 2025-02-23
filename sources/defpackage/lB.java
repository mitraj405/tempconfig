package defpackage;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* renamed from: lB  reason: default package */
/* compiled from: UnprecomputeTextOnModificationSpannable */
public final class lB implements Spannable {
    public Spannable a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3080a = false;

    /* renamed from: lB$a */
    /* compiled from: UnprecomputeTextOnModificationSpannable */
    public static class a {
        public boolean a(Spannable spannable) {
            return spannable instanceof PrecomputedTextCompat;
        }
    }

    /* renamed from: lB$b */
    /* compiled from: UnprecomputeTextOnModificationSpannable */
    public static class b extends a {
        public final boolean a(Spannable spannable) {
            if ((spannable instanceof PrecomputedText) || (spannable instanceof PrecomputedTextCompat)) {
                return true;
            }
            return false;
        }
    }

    public lB(Spannable spannable) {
        this.a = spannable;
    }

    public final void a() {
        a aVar;
        Spannable spannable = this.a;
        if (!this.f3080a) {
            if (Build.VERSION.SDK_INT < 28) {
                aVar = new a();
            } else {
                aVar = new b();
            }
            if (aVar.a(spannable)) {
                this.a = new SpannableString(spannable);
            }
        }
        this.f3080a = true;
    }

    public final char charAt(int i) {
        return this.a.charAt(i);
    }

    public final IntStream chars() {
        return this.a.chars();
    }

    public final IntStream codePoints() {
        return this.a.codePoints();
    }

    public final int getSpanEnd(Object obj) {
        return this.a.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.a.getSpanFlags(obj);
    }

    public final int getSpanStart(Object obj) {
        return this.a.getSpanStart(obj);
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.a.getSpans(i, i2, cls);
    }

    public final int length() {
        return this.a.length();
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.a.nextSpanTransition(i, i2, cls);
    }

    public final void removeSpan(Object obj) {
        a();
        this.a.removeSpan(obj);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        a();
        this.a.setSpan(obj, i, i2, i3);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    public final String toString() {
        return this.a.toString();
    }

    public lB(CharSequence charSequence) {
        this.a = new SpannableString(charSequence);
    }
}
