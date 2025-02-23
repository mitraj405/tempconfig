package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import defpackage.fo;
import java.util.Collections;

public class DiagnosticsReceiver extends BroadcastReceiver {
    static {
        zi.e("DiagnosticsRcvr");
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            zi.c().a(new Throwable[0]);
            try {
                VD e = VD.e(context);
                fo a = new fo.a(DiagnosticsWorker.class).a();
                e.getClass();
                e.d(Collections.singletonList(a));
            } catch (IllegalStateException e2) {
                zi.c().b(e2);
            }
        }
    }
}
