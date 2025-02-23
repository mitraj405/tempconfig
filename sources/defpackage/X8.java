package defpackage;

import android.view.KeyEvent;
import android.view.View;

/* renamed from: X8  reason: default package */
/* compiled from: DialogPlus */
public final class X8 implements View.OnKeyListener {
    public final /* synthetic */ C0704U8 a;

    public X8(C0704U8 u8) {
        this.a = u8;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        C0704U8 u8 = this.a;
        u8.getClass();
        if (u8.f3804a) {
            u8.b();
        }
        return true;
    }
}
