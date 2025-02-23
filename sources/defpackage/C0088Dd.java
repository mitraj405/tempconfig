package defpackage;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.emoji2.text.g;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.journeyapps.barcodescanner.a;
import cris.org.in.ima.activities.PinValidationActivity;
import in.juspay.hypersdk.safe.Godel;
import okhttp3.internal.ws.RealWebSocket;

/* renamed from: Dd  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0088Dd implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0088Dd(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        switch (this.c) {
            case 1:
                ((Toolbar) this.a).invalidateMenu();
                return;
            case 2:
                ((C0245kA) this.a).a();
                throw null;
            case 4:
                int i = ContentLoadingProgressBar.c;
                ((ContentLoadingProgressBar) this.a).setVisibility(8);
                return;
            case 5:
                ((g.b) this.a).c();
                return;
            case 6:
                ((AppStartTrace) this.a).recordPreDrawFrontOfQueue();
                return;
            case 7:
                int i2 = a.b;
                ((a) this.a).f3975a.finish();
                return;
            case 8:
                C0775a2 a2Var = C0775a2.this;
                a2Var.b = false;
                a2Var.a();
                return;
            case 9:
                PinValidationActivity.l((PinValidationActivity) this.a);
                return;
            case 10:
                ((Godel) this.a).resetWebView();
                return;
            default:
                ((RealWebSocket) this.a).lambda$new$0();
                return;
        }
    }
}
