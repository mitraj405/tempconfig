package defpackage;

import in.juspay.hypersdk.analytics.LogSessioniserExp;

/* renamed from: vi  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1442vi implements Runnable {
    public final /* synthetic */ LogSessioniserExp a;
    public final /* synthetic */ int c;

    public /* synthetic */ C1442vi(LogSessioniserExp logSessioniserExp, int i) {
        this.c = i;
        this.a = logSessioniserExp;
    }

    public final void run() {
        int i = this.c;
        LogSessioniserExp logSessioniserExp = this.a;
        switch (i) {
            case 0:
                logSessioniserExp.lambda$stopLogSessioniserOnTerminate$0();
                return;
            default:
                logSessioniserExp.lambda$startPushing$2();
                return;
        }
    }
}
