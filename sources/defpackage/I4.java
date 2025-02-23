package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;

/* renamed from: I4  reason: default package */
/* compiled from: CardViewApi21Impl */
public final class I4 implements CardViewImpl {
    public final void a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        fu fuVar = (fu) cardViewDelegate.d();
        fuVar.b(colorStateList);
        fuVar.invalidateSelf();
    }

    public final ColorStateList b(CardViewDelegate cardViewDelegate) {
        return ((fu) cardViewDelegate.d()).f2949a;
    }

    public final void c(CardViewDelegate cardViewDelegate) {
        float f;
        if (!cardViewDelegate.b()) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float f2 = ((fu) cardViewDelegate.d()).b;
        float f3 = ((fu) cardViewDelegate.d()).a;
        if (cardViewDelegate.a()) {
            f = (float) (((1.0d - gu.a) * ((double) f3)) + ((double) f2));
        } else {
            int i = gu.f2974a;
            f = f2;
        }
        int ceil = (int) Math.ceil((double) f);
        int ceil2 = (int) Math.ceil((double) gu.a(f2, f3, cardViewDelegate.a()));
        cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public final float d(CardViewDelegate cardViewDelegate) {
        return ((fu) cardViewDelegate.d()).a * 2.0f;
    }

    public final void e(CardViewDelegate cardViewDelegate, float f) {
        fu fuVar = (fu) cardViewDelegate.d();
        if (f != fuVar.a) {
            fuVar.a = f;
            fuVar.c((Rect) null);
            fuVar.invalidateSelf();
        }
    }

    public final float f(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.c().getElevation();
    }

    public final void g(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.c().setElevation(f);
    }

    public final void h(CardView.a aVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        aVar.e(new fu(f, colorStateList));
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(f2);
        k(aVar, f3);
    }

    public final void i(CardViewDelegate cardViewDelegate) {
        k(cardViewDelegate, ((fu) cardViewDelegate.d()).b);
    }

    public final float j(CardViewDelegate cardViewDelegate) {
        return ((fu) cardViewDelegate.d()).b;
    }

    public final void k(CardViewDelegate cardViewDelegate, float f) {
        fu fuVar = (fu) cardViewDelegate.d();
        boolean b = cardViewDelegate.b();
        boolean a = cardViewDelegate.a();
        if (!(f == fuVar.b && fuVar.f2955a == b && fuVar.f2957b == a)) {
            fuVar.b = f;
            fuVar.f2955a = b;
            fuVar.f2957b = a;
            fuVar.c((Rect) null);
            fuVar.invalidateSelf();
        }
        c(cardViewDelegate);
    }

    public final float l(CardViewDelegate cardViewDelegate) {
        return ((fu) cardViewDelegate.d()).a;
    }

    public final float m(CardViewDelegate cardViewDelegate) {
        return ((fu) cardViewDelegate.d()).a * 2.0f;
    }

    public final void n(CardViewDelegate cardViewDelegate) {
        k(cardViewDelegate, ((fu) cardViewDelegate.d()).b);
    }
}
