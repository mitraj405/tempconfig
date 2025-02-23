package defpackage;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.d;
import androidx.emoji2.text.f;

/* renamed from: na  reason: default package and case insensitive filesystem */
/* compiled from: EmojiKeyListener */
public final class C0278na implements KeyListener {
    public final KeyListener a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3111a;

    /* renamed from: na$a */
    /* compiled from: EmojiKeyListener */
    public static class a {
    }

    public C0278na(KeyListener keyListener) {
        a aVar = new a();
        this.a = keyListener;
        this.f3111a = aVar;
    }

    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.a.clearMetaKeyState(view, editable, i);
    }

    public final int getInputType() {
        return this.a.getInputType();
    }

    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        this.f3111a.getClass();
        Object obj = d.f2004a;
        if (i == 67) {
            z = f.a(editable, keyEvent, false);
        } else if (i != 112) {
            z = false;
        } else {
            z = f.a(editable, keyEvent, true);
        }
        if (z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || this.a.onKeyDown(view, editable, i, keyEvent)) {
            return true;
        }
        return false;
    }

    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.a.onKeyOther(view, editable, keyEvent);
    }

    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.a.onKeyUp(view, editable, i, keyEvent);
    }
}
