package defpackage;

import in.juspay.hypersdk.core.SdkTracker;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: uv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1431uv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Integer f6987a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Long f6988a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f6989a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONArray f6990a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f6991a;
    public final /* synthetic */ Long b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Object f6992b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ C1431uv(SdkTracker sdkTracker, String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5, JSONArray jSONArray, JSONObject jSONObject) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f6987a = num;
        this.f = str4;
        this.f6988a = l;
        this.b = l2;
        this.f6989a = obj;
        this.f6992b = obj2;
        this.g = str5;
        this.f6990a = jSONArray;
        this.f6991a = jSONObject;
    }

    public final void run() {
        this.a.lambda$trackApiCalls$10(this.c, this.d, this.e, this.f6987a, this.f, this.f6988a, this.b, this.f6989a, this.f6992b, this.g, this.f6990a, this.f6991a);
    }
}
