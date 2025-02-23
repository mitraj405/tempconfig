package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.d;
import java.lang.ref.WeakReference;

/* renamed from: ra  reason: default package and case insensitive filesystem */
/* compiled from: EmojiTextWatcher */
public final class C0316ra implements TextWatcher {
    public final EditText a;

    /* renamed from: a  reason: collision with other field name */
    public a f3220a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3221a = false;
    public boolean b = true;

    /* renamed from: ra$a */
    /* compiled from: EmojiTextWatcher */
    public static class a extends d.e {
        public final WeakReference a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        public final void b() {
            C0316ra.a((EditText) this.a.get(), 1);
        }
    }

    public C0316ra(EditText editText) {
        this.a = editText;
    }

    public static void a(EditText editText, int i) {
        int i2;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            d a2 = d.a();
            if (editableText == null) {
                i2 = 0;
            } else {
                a2.getClass();
                i2 = editableText.length();
            }
            a2.f(0, i2, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r1 == false) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.widget.EditText r0 = r4.a
            boolean r1 = r0.isInEditMode()
            if (r1 != 0) goto L_0x0054
            boolean r1 = r4.b
            r2 = 1
            if (r1 == 0) goto L_0x001b
            boolean r1 = r4.f3221a
            r3 = 0
            if (r1 != 0) goto L_0x001c
            androidx.emoji2.text.d r1 = androidx.emoji2.text.d.a
            if (r1 == 0) goto L_0x0018
            r1 = r2
            goto L_0x0019
        L_0x0018:
            r1 = r3
        L_0x0019:
            if (r1 != 0) goto L_0x001c
        L_0x001b:
            r3 = r2
        L_0x001c:
            if (r3 == 0) goto L_0x001f
            goto L_0x0054
        L_0x001f:
            if (r7 > r8) goto L_0x0054
            boolean r7 = r5 instanceof android.text.Spannable
            if (r7 == 0) goto L_0x0054
            androidx.emoji2.text.d r7 = androidx.emoji2.text.d.a()
            int r7 = r7.b()
            if (r7 == 0) goto L_0x0040
            if (r7 == r2) goto L_0x0035
            r5 = 3
            if (r7 == r5) goto L_0x0040
            goto L_0x0054
        L_0x0035:
            android.text.Spannable r5 = (android.text.Spannable) r5
            androidx.emoji2.text.d r7 = androidx.emoji2.text.d.a()
            int r8 = r8 + r6
            r7.f(r6, r8, r5)
            goto L_0x0054
        L_0x0040:
            androidx.emoji2.text.d r5 = androidx.emoji2.text.d.a()
            ra$a r6 = r4.f3220a
            if (r6 != 0) goto L_0x004f
            ra$a r6 = new ra$a
            r6.<init>(r0)
            r4.f3220a = r6
        L_0x004f:
            ra$a r6 = r4.f3220a
            r5.g(r6)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0316ra.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
