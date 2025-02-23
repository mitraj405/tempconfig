package defpackage;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import in.juspay.hypersdk.core.PrefetchServices;

/* renamed from: l0  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0251l0 implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ C0251l0(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
                return;
            default:
                PrefetchServices.lambda$preFetch$0();
                return;
        }
    }
}
