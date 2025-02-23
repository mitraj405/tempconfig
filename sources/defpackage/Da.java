package defpackage;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;

/* renamed from: Da  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Da implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f119c;

    public /* synthetic */ Da(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
        this.f119c = obj3;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.f119c;
        Object obj2 = this.b;
        Object obj3 = this.a;
        switch (i) {
            case 0:
                ((EnhancedIntentService) obj3).lambda$processIntent$0((Intent) obj2, (TaskCompletionSource) obj);
                return;
            default:
                ((TransportManager) obj3).lambda$log$3((NetworkRequestMetric) obj2, (ApplicationProcessState) obj);
                return;
        }
    }
}
