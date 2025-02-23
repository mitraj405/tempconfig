package defpackage;

import android.app.Activity;
import in.juspay.hypersdk.safe.Godel;

/* renamed from: te  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1404te implements Runnable {
    public final /* synthetic */ Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Godel f6965a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    public /* synthetic */ C1404te(Godel godel, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f6965a = godel;
        this.a = activity;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
    }

    public final void run() {
        this.f6965a.lambda$onBrowserReady$1(this.a, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
