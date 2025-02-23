package defpackage;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: D5  reason: default package and case insensitive filesystem */
/* compiled from: CommonUtil */
public final class C0479D5 implements TextWatcher {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ int c;

    public C0479D5(Activity activity, int i) {
        this.c = i;
        this.a = activity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == this.c) {
            C0535I5.I(this.a);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
