package defpackage;

import android.widget.EditText;

/* renamed from: ja  reason: default package and case insensitive filesystem */
/* compiled from: EmojiEditTextHelper */
public final class C0237ja {
    public final a a;

    /* renamed from: ja$a */
    /* compiled from: EmojiEditTextHelper */
    public static class a extends b {
        public final EditText a;

        /* renamed from: a  reason: collision with other field name */
        public final C0316ra f3033a;

        public a(EditText editText) {
            this.a = editText;
            C0316ra raVar = new C0316ra(editText);
            this.f3033a = raVar;
            editText.addTextChangedListener(raVar);
            if (C0247ka.f3052a == null) {
                synchronized (C0247ka.f3051a) {
                    if (C0247ka.f3052a == null) {
                        C0247ka.f3052a = new C0247ka();
                    }
                }
            }
            editText.setEditableFactory(C0247ka.f3052a);
        }
    }

    /* renamed from: ja$b */
    /* compiled from: EmojiEditTextHelper */
    public static class b {
    }

    public C0237ja(EditText editText) {
        if (editText != null) {
            this.a = new a(editText);
            return;
        }
        throw new NullPointerException("editText cannot be null");
    }
}
