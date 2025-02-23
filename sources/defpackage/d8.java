package defpackage;

import butterknife.internal.DebouncingOnClickListener;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;

/* renamed from: d8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d8 implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ d8(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                DebouncingOnClickListener.enabled = true;
                return;
            case 1:
                LogPusher.lambda$static$0();
                return;
            case 2:
                LogPusher.lambda$startLogPusherTimer$1();
                return;
            case 3:
                LogPusherExp.pushCrashLogFile();
                return;
            case 4:
                LogSessioniser.lambda$startLogSessioniserOnLogCount$2();
                return;
            default:
                LogSessioniser.lambda$static$0();
                return;
        }
    }
}
