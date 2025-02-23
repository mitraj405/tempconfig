package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import com.paytm.pgsdk.sdknative.a;

/* renamed from: Ru  reason: default package */
/* compiled from: SavedCardFragment */
public final class Ru implements TextWatcher {
    public final /* synthetic */ a a;

    public Ru(a aVar) {
        this.a = aVar;
    }

    public final void afterTextChanged(Editable editable) {
        this.a.f4128c.setVisibility(8);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
