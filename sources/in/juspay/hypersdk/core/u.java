package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ u(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((DynamicUI) obj).loadData();
                return;
            case 1:
                ((DuiInterface) obj).lambda$requestKeyboardHide$9();
                return;
            default:
                SdkTracker.lambda$addToBootLogs$1((String) obj);
                return;
        }
    }
}
