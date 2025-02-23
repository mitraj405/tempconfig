package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import defpackage.v9;

/* renamed from: h1  reason: default package */
/* compiled from: AppCompatCheckedTextViewHelper */
public final class h1 {
    public ColorStateList a = null;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f2980a = null;

    /* renamed from: a  reason: collision with other field name */
    public final CheckedTextView f2981a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2982a = false;
    public boolean b = false;
    public boolean c;

    public h1(CheckedTextView checkedTextView) {
        this.f2981a = checkedTextView;
    }

    public final void a() {
        CheckedTextView checkedTextView = this.f2981a;
        Drawable checkMarkDrawable = checkedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f2982a || this.b) {
            Drawable mutate = checkMarkDrawable.mutate();
            if (this.f2982a) {
                v9.a.h(mutate, this.a);
            }
            if (this.b) {
                v9.a.i(mutate, this.f2980a);
            }
            if (mutate.isStateful()) {
                mutate.setState(checkedTextView.getDrawableState());
            }
            checkedTextView.setCheckMarkDrawable(mutate);
        }
    }
}
