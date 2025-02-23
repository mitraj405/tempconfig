package defpackage;

import in.juspay.hypersdk.core.SdkTracker;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: qv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1357qv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Long f6929a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f6930a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f6931a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONArray f6932a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f6933a;
    public final /* synthetic */ Long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    public /* synthetic */ C1357qv(SdkTracker sdkTracker, String str, String str2, Throwable th, String str3, String str4, String str5, Long l, Long l2, Object obj, String str6, String str7, JSONArray jSONArray, JSONObject jSONObject) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.f6931a = th;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.f6929a = l;
        this.b = l2;
        this.f6930a = obj;
        this.h = str6;
        this.i = str7;
        this.f6932a = jSONArray;
        this.f6933a = jSONObject;
    }

    public final void run() {
        this.a.lambda$trackAndLogApiException$16(this.c, this.d, this.f6931a, this.e, this.f, this.g, this.f6929a, this.b, this.f6930a, this.h, this.i, this.f6932a, this.f6933a);
    }
}
