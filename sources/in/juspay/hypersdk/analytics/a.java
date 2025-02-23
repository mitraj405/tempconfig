package in.juspay.hypersdk.analytics;

import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ a(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                LogPusher.lambda$addLogsToPersistedQueue$3((JSONObject) obj);
                return;
            case 1:
                LogPusherExp.lambda$addLogsToPersistedQueue$2((JSONObject) obj);
                return;
            default:
                ((LogSessioniserExp) obj).pushToPusher();
                return;
        }
    }
}
