package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ b(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                LogPusher.LogPushTimerTask.lambda$run$0();
                return;
            case 1:
                LogPusherExp.LogPushTimerTask.lambda$run$0();
                return;
            case 2:
                LogPusher.lambda$stopLogPusherOnTerminate$2();
                return;
            default:
                LogSessioniser.lambda$stopLogSessioniserOnTerminate$3();
                return;
        }
    }
}
