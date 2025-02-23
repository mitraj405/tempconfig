package defpackage;

import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;

/* renamed from: ui  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1425ui implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ C1425ui(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                LogSessioniser.lambda$startLogSessioniser$1();
                return;
            default:
                LogPusherExp.stopLogPusherOnTerminate();
                return;
        }
    }
}
