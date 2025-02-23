package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* renamed from: E  reason: default package */
/* compiled from: ActionBarBackgroundDrawable */
public final class E extends Drawable {
    public final ActionBarContainer a;

    public E(ActionBarContainer actionBarContainer) {
        this.a = actionBarContainer;
    }

    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.a;
        if (actionBarContainer.f1097b) {
            Drawable drawable = actionBarContainer.f1098c;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.a;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.b;
        if (drawable3 != null && actionBarContainer.f1099c) {
            drawable3.draw(canvas);
        }
    }

    public final int getOpacity() {
        return 0;
    }

    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.a;
        if (!actionBarContainer.f1097b) {
            Drawable drawable = actionBarContainer.a;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        } else if (actionBarContainer.f1098c != null) {
            actionBarContainer.a.getOutline(outline);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
