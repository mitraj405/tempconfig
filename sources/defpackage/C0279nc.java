package defpackage;

import android.os.Handler;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import defpackage.C0258lc;

/* renamed from: nc  reason: default package and case insensitive filesystem */
/* compiled from: FingerprintDialogFragment */
public final class C0279nc implements Observer<CharSequence> {
    public final /* synthetic */ C0258lc a;

    public C0279nc(C0258lc lcVar) {
        this.a = lcVar;
    }

    public final void a(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        C0258lc lcVar = this.a;
        Handler handler = lcVar.a;
        C0258lc.a aVar = lcVar.f3086a;
        handler.removeCallbacks(aVar);
        TextView textView = lcVar.f3084a;
        if (textView != null) {
            textView.setText(charSequence);
        }
        lcVar.a.postDelayed(aVar, 2000);
    }
}
