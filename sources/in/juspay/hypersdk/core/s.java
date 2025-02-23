package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ s(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((DynamicUI) obj).createWebView();
                return;
            case 1:
                ((DuiInterface) obj).lambda$onDuiReady$2();
                return;
            default:
                ((InflateView) obj).lambda$dismissPopUp$11();
                return;
        }
    }
}
