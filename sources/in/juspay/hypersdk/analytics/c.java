package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.analytics.LogSessioniser;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ c(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                LogSessioniser.LogSessioniserTimerTask.lambda$run$0();
                return;
            default:
                LogPusherExp.pushChannelFiles(LogConstants.DEFAULT_CHANNEL, LogPusherExp.channels.get(LogConstants.DEFAULT_CHANNEL));
                return;
        }
    }
}
