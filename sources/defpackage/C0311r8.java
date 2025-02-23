package defpackage;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

/* renamed from: r8  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0311r8 implements Provider {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f3217a;

    public /* synthetic */ C0311r8(Context context, String str) {
        this.a = context;
        this.f3217a = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.a, this.f3217a);
    }
}
