package defpackage;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* renamed from: u9  reason: default package and case insensitive filesystem */
/* compiled from: DrawableClickListener */
public abstract class C1421u9 implements View.OnTouchListener {
    public final Drawable a = null;
    public final int c = 10;

    /* renamed from: u9$a */
    /* compiled from: DrawableClickListener */
    public static abstract class a extends C1421u9 {
        public a(EditText editText) {
            super(editText);
        }
    }

    public C1421u9(EditText editText) {
        Drawable[] compoundDrawables = editText.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length == 4) {
            this.a = compoundDrawables[2];
        }
    }

    public abstract void a();

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Drawable drawable;
        boolean z;
        if (motionEvent.getAction() == 0 && (drawable = this.a) != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int width = (view.getWidth() - view.getPaddingRight()) - drawable.getBounds().width();
            int i = this.c;
            if (x < width - i || x > (view.getWidth() - view.getPaddingRight()) + i || y < view.getPaddingTop() - i || y > (view.getHeight() - view.getPaddingBottom()) + i) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                a();
                return true;
            }
        }
        return false;
    }
}
