package defpackage;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* renamed from: z7  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0418z7 implements Deferred.DeferredHandler {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ StaticSessionData f3452a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f3453a;
    public final /* synthetic */ String b;

    public /* synthetic */ C0418z7(String str, String str2, long j, StaticSessionData staticSessionData) {
        this.f3453a = str;
        this.b = str2;
        this.a = j;
        this.f3452a = staticSessionData;
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f3453a, this.b, this.a, this.f3452a);
    }
}
