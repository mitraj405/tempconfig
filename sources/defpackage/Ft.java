package defpackage;

import android.graphics.Typeface;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.v1.TraceMetric;
import defpackage.Et;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.core.DuiInterface;
import in.juspay.hypersdk.core.JBridge;
import in.juspay.hypersdk.core.Renderer;
import in.juspay.services.HyperServices;
import org.json.JSONObject;

/* renamed from: Ft  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ft implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ Ft(int i, Object obj, Object obj2) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((Et.e) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                return;
            case 1:
                Callables.lambda$threadRenaming$3((Supplier) obj2, (Runnable) obj);
                return;
            case 2:
                ((AppStartTrace) obj2).lambda$logExperimentTrace$0((TraceMetric.Builder) obj);
                return;
            case 3:
                O3 o3 = (O3) obj2;
                C1287nq nqVar = (C1287nq) obj;
                if (o3.f3734a) {
                    o3.f3729a.b(new C0428zq(7, o3, nqVar));
                    return;
                }
                return;
            case 4:
                LogPusherExp.lambda$addLogLines$3((String) obj2, (String) obj);
                return;
            case 5:
                ((DuiInterface) obj2).lambda$requestKeyboardShow$7((String) obj);
                return;
            case 6:
                ((JBridge) obj2).lambda$showJuspayLoader$0((String) obj);
                return;
            case 7:
                ((Renderer) obj2).lambda$initCache$0((String[]) obj);
                return;
            default:
                ((HyperServices) obj2).lambda$initiate$1((JSONObject) obj);
                return;
        }
    }
}
