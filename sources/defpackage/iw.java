package defpackage;

import android.content.Context;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import in.juspay.hypersdk.core.JsInterface;
import org.json.JSONObject;

/* renamed from: iw  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class iw implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f3023c;

    public /* synthetic */ iw(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
        this.f3023c = obj3;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.f3023c;
        Object obj2 = this.b;
        Object obj3 = this.a;
        switch (i) {
            case 0:
                ((SessionManager) obj3).lambda$setApplicationContext$0((Context) obj2, (PerfSession) obj);
                return;
            case 1:
                ((GaugeManager) obj3).lambda$startCollectingGauges$2((String) obj2, (ApplicationProcessState) obj);
                return;
            case 2:
                ((TransportManager) obj3).lambda$log$4((GaugeMetric) obj2, (ApplicationProcessState) obj);
                return;
            default:
                ((JsInterface) obj3).lambda$setAnalyticsHeader$2((JSONObject) obj2, (String) obj);
                return;
        }
    }
}
