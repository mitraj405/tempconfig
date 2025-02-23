package defpackage;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.d;
import java.lang.ref.WeakReference;

/* renamed from: ma  reason: default package and case insensitive filesystem */
/* compiled from: EmojiInputFilter */
public final class C0270ma implements InputFilter {
    public final TextView a;

    /* renamed from: a  reason: collision with other field name */
    public a f3100a;

    /* renamed from: ma$a */
    /* compiled from: EmojiInputFilter */
    public static class a extends d.e {
        public final WeakReference a;
        public final WeakReference b;

        public a(TextView textView, C0270ma maVar) {
            this.a = new WeakReference(textView);
            this.b = new WeakReference(maVar);
        }

        public final void b() {
            boolean z;
            int i;
            InputFilter[] filters;
            TextView textView = (TextView) this.a.get();
            InputFilter inputFilter = (InputFilter) this.b.get();
            if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= filters.length) {
                        break;
                    } else if (filters[i2] == inputFilter) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = false;
            if (z && textView.isAttachedToWindow()) {
                CharSequence text = textView.getText();
                d a2 = d.a();
                if (text == null) {
                    i = 0;
                } else {
                    a2.getClass();
                    i = text.length();
                }
                CharSequence f = a2.f(0, i, text);
                if (text != f) {
                    int selectionStart = Selection.getSelectionStart(f);
                    int selectionEnd = Selection.getSelectionEnd(f);
                    textView.setText(f);
                    if (f instanceof Spannable) {
                        Spannable spannable = (Spannable) f;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                        } else if (selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionEnd);
                        }
                    }
                }
            }
        }
    }

    public C0270ma(TextView textView) {
        this.a = textView;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b = d.a().b();
        if (b != 0) {
            boolean z = true;
            if (b == 1) {
                if (i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) {
                    z = false;
                }
                if (!z || charSequence == null) {
                    return charSequence;
                }
                if (!(i == 0 && i2 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return d.a().f(0, charSequence.length(), charSequence);
            } else if (b != 3) {
                return charSequence;
            }
        }
        d a2 = d.a();
        if (this.f3100a == null) {
            this.f3100a = new a(textView, this);
        }
        a2.g(this.f3100a);
        return charSequence;
    }
}
