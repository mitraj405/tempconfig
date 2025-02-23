package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

public final class AppCompatEmojiTextHelper {
    public final TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final C0304qa f1164a;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.a = textView;
        this.f1164a = new C0304qa(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1164a.a.a(inputFilterArr);
    }

    public final boolean b() {
        return this.f1164a.a.b();
    }

    /* JADX INFO: finally extract failed */
    public final void c(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, ps.AppCompatTextView, i, 0);
        try {
            int i2 = ps.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i2)) {
                z = obtainStyledAttributes.getBoolean(i2, true);
            }
            obtainStyledAttributes.recycle();
            e(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void d(boolean z) {
        this.f1164a.a.c(z);
    }

    public final void e(boolean z) {
        this.f1164a.a.d(z);
    }
}
