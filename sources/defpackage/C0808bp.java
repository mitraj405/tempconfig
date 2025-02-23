package defpackage;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

/* renamed from: bp  reason: default package and case insensitive filesystem */
/* compiled from: PasswordHelper */
public final class C0808bp implements Runnable {
    public final /* synthetic */ C0760Yo a;

    public C0808bp(C0760Yo yo) {
        this.a = yo;
    }

    public final void run() {
        C0760Yo yo = this.a;
        Activity activity = yo.f3869a;
        int i = C0501Er.editTextPassword;
        activity.findViewById(i).dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0));
        yo.f3869a.findViewById(i).dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
        EditText editText = yo.f3871a;
        editText.setSelection(editText.getText().length());
    }
}
