package defpackage;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import kotlin.jvm.functions.Function0;

/* renamed from: Hn  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Hn implements OnBackInvokedCallback {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f261a;

    public /* synthetic */ Hn(Object obj, int i) {
        this.a = i;
        this.f261a = obj;
    }

    public final void onBackInvoked() {
        switch (this.a) {
            case 0:
                Function0 function0 = (Function0) this.f261a;
                C1177ig.f(function0, "$onBackInvoked");
                function0.invoke();
                return;
            default:
                ((AppCompatDelegateImpl) this.f261a).N();
                return;
        }
    }
}
