package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.d;

/* renamed from: la  reason: default package and case insensitive filesystem */
/* compiled from: EmojiInputConnection */
public final class C0257la extends InputConnectionWrapper {
    public final TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3082a;

    /* renamed from: la$a */
    /* compiled from: EmojiInputConnection */
    public static class a {
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            if (java.lang.Character.isHighSurrogate(r5) != false) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
            if (r11 != false) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
            if (java.lang.Character.isLowSurrogate(r5) != false) goto L_0x0090;
         */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x007c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
            /*
                java.lang.Object r0 = androidx.emoji2.text.d.f2004a
                r0 = 0
                if (r8 == 0) goto L_0x00fb
                if (r7 != 0) goto L_0x0009
                goto L_0x00fb
            L_0x0009:
                if (r9 < 0) goto L_0x00fb
                if (r10 >= 0) goto L_0x000f
                goto L_0x00fb
            L_0x000f:
                int r1 = android.text.Selection.getSelectionStart(r8)
                int r2 = android.text.Selection.getSelectionEnd(r8)
                r3 = 1
                r4 = -1
                if (r1 == r4) goto L_0x0022
                if (r2 == r4) goto L_0x0022
                if (r1 == r2) goto L_0x0020
                goto L_0x0022
            L_0x0020:
                r5 = r0
                goto L_0x0023
            L_0x0022:
                r5 = r3
            L_0x0023:
                if (r5 == 0) goto L_0x0027
                goto L_0x00fb
            L_0x0027:
                if (r11 == 0) goto L_0x00b1
                int r9 = java.lang.Math.max(r9, r0)
                int r11 = r8.length()
                if (r1 < 0) goto L_0x0068
                if (r11 >= r1) goto L_0x0036
                goto L_0x0068
            L_0x0036:
                if (r9 >= 0) goto L_0x0039
                goto L_0x0068
            L_0x0039:
                r11 = r0
            L_0x003a:
                if (r9 != 0) goto L_0x003d
                goto L_0x0069
            L_0x003d:
                int r1 = r1 + -1
                if (r1 >= 0) goto L_0x0046
                if (r11 == 0) goto L_0x0044
                goto L_0x0068
            L_0x0044:
                r1 = r0
                goto L_0x0069
            L_0x0046:
                char r5 = r8.charAt(r1)
                if (r11 == 0) goto L_0x0056
                boolean r11 = java.lang.Character.isHighSurrogate(r5)
                if (r11 != 0) goto L_0x0053
                goto L_0x0068
            L_0x0053:
                int r9 = r9 + -1
                goto L_0x0039
            L_0x0056:
                boolean r6 = java.lang.Character.isSurrogate(r5)
                if (r6 != 0) goto L_0x005f
                int r9 = r9 + -1
                goto L_0x003a
            L_0x005f:
                boolean r11 = java.lang.Character.isHighSurrogate(r5)
                if (r11 == 0) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r11 = r3
                goto L_0x003a
            L_0x0068:
                r1 = r4
            L_0x0069:
                int r9 = java.lang.Math.max(r10, r0)
                int r10 = r8.length()
                if (r2 < 0) goto L_0x00ab
                if (r10 >= r2) goto L_0x0076
                goto L_0x00ab
            L_0x0076:
                if (r9 >= 0) goto L_0x0079
                goto L_0x00ab
            L_0x0079:
                r11 = r0
            L_0x007a:
                if (r9 != 0) goto L_0x007e
                r10 = r2
                goto L_0x00ac
            L_0x007e:
                if (r2 < r10) goto L_0x0083
                if (r11 == 0) goto L_0x00ac
                goto L_0x00ab
            L_0x0083:
                char r5 = r8.charAt(r2)
                if (r11 == 0) goto L_0x0095
                boolean r11 = java.lang.Character.isLowSurrogate(r5)
                if (r11 != 0) goto L_0x0090
                goto L_0x00ab
            L_0x0090:
                int r9 = r9 + -1
                int r2 = r2 + 1
                goto L_0x0079
            L_0x0095:
                boolean r6 = java.lang.Character.isSurrogate(r5)
                if (r6 != 0) goto L_0x00a0
                int r9 = r9 + -1
                int r2 = r2 + 1
                goto L_0x007a
            L_0x00a0:
                boolean r11 = java.lang.Character.isLowSurrogate(r5)
                if (r11 == 0) goto L_0x00a7
                goto L_0x00ab
            L_0x00a7:
                int r2 = r2 + 1
                r11 = r3
                goto L_0x007a
            L_0x00ab:
                r10 = r4
            L_0x00ac:
                if (r1 == r4) goto L_0x00fb
                if (r10 != r4) goto L_0x00bf
                goto L_0x00fb
            L_0x00b1:
                int r1 = r1 - r9
                int r1 = java.lang.Math.max(r1, r0)
                int r2 = r2 + r10
                int r9 = r8.length()
                int r10 = java.lang.Math.min(r2, r9)
            L_0x00bf:
                java.lang.Class<pa> r9 = defpackage.C0295pa.class
                java.lang.Object[] r9 = r8.getSpans(r1, r10, r9)
                pa[] r9 = (defpackage.C0295pa[]) r9
                if (r9 == 0) goto L_0x00fb
                int r11 = r9.length
                if (r11 <= 0) goto L_0x00fb
                int r11 = r9.length
                r2 = r0
            L_0x00ce:
                if (r2 >= r11) goto L_0x00e5
                r4 = r9[r2]
                int r5 = r8.getSpanStart(r4)
                int r4 = r8.getSpanEnd(r4)
                int r1 = java.lang.Math.min(r5, r1)
                int r10 = java.lang.Math.max(r4, r10)
                int r2 = r2 + 1
                goto L_0x00ce
            L_0x00e5:
                int r9 = java.lang.Math.max(r1, r0)
                int r11 = r8.length()
                int r10 = java.lang.Math.min(r10, r11)
                r7.beginBatchEdit()
                r8.delete(r9, r10)
                r7.endBatchEdit()
                r0 = r3
            L_0x00fb:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0257la.a.a(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0257la(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        boolean z;
        int i;
        a aVar = new a();
        this.a = editText;
        this.f3082a = aVar;
        boolean z2 = true;
        if (d.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            d a2 = d.a();
            if ((a2.b() != 1 ? false : z2) && editorInfo != null) {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                d.a aVar2 = a2.f2009a;
                aVar2.getClass();
                Bundle bundle = editorInfo.extras;
                ll llVar = aVar2.f2012a.f2029a;
                int a3 = llVar.a(4);
                if (a3 != 0) {
                    i = llVar.f3207a.getInt(a3 + llVar.a);
                } else {
                    i = 0;
                }
                bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i);
                Bundle bundle2 = editorInfo.extras;
                aVar2.a.getClass();
                bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
            }
        }
    }

    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.f3082a.getClass();
        if (a.a(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2)) {
            return true;
        }
        return false;
    }

    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.f3082a.getClass();
        if (a.a(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2)) {
            return true;
        }
        return false;
    }
}
