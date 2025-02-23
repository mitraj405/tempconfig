package in.juspay.hypersdk.core;

import in.juspay.hyper.constants.LogCategory;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5491c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ a(AndroidInterface androidInterface, String str, String str2, String str3, String str4) {
        this.c = 0;
        this.a = androidInterface;
        this.f5491c = str;
        this.d = str2;
        this.e = str3;
        this.b = str4;
    }

    public final void run() {
        int i = this.c;
        String str = this.e;
        String str2 = this.d;
        String str3 = this.f5491c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((AndroidInterface) obj2).lambda$runInUI$7(str3, str2, str, (String) obj);
                return;
            case 1:
                ((AndroidInterface) obj2).lambda$render$0((JSONObject) obj, str3, str2, str);
                return;
            case 2:
                SdkTracker.bootLogs.add(SdkTracker.createExceptionLog(str3, str2, str, (String) obj, (Throwable) obj2));
                return;
            default:
                SdkTracker.bootLogs.add(SdkTracker.createLog(LogCategory.ACTION, str3, str2, str, (String) obj, obj2));
                return;
        }
    }

    public /* synthetic */ a(AndroidInterface androidInterface, JSONObject jSONObject, String str, String str2, String str3) {
        this.c = 1;
        this.a = androidInterface;
        this.b = jSONObject;
        this.f5491c = str;
        this.d = str2;
        this.e = str3;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, Object obj, int i) {
        this.c = i;
        this.f5491c = str;
        this.d = str2;
        this.e = str3;
        this.b = str4;
        this.a = obj;
    }
}
