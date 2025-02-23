package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.d;
import androidx.emoji2.text.h;

/* renamed from: bB  reason: default package and case insensitive filesystem */
/* compiled from: TypefaceEmojiSpan */
public final class C0144bB extends C0295pa {
    public C0144bB(C0287oa oaVar) {
        super(oaVar);
    }

    public final void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint paint2 = paint;
        d.a().getClass();
        C0287oa oaVar = this.f3171a;
        h hVar = oaVar.f3144a;
        Typeface typeface = hVar.a;
        Typeface typeface2 = paint.getTypeface();
        paint2.setTypeface(typeface);
        int i6 = oaVar.f3143a * 2;
        Canvas canvas2 = canvas;
        canvas2.drawText(hVar.f2030a, i6, 2, f, (float) i4, paint);
        paint2.setTypeface(typeface2);
    }
}
