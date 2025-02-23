package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.concurrent.Callable;

/* renamed from: zc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0424zc implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3458a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0424zc(int i, Object obj, Object obj2) {
        this.a = i;
        this.f3458a = obj;
        this.b = obj2;
    }

    public final Object call() {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.f3458a;
        switch (i) {
            case 0:
                return ((FirebaseRemoteConfig) obj2).lambda$setConfigSettingsAsync$5((FirebaseRemoteConfigSettings) obj);
            default:
                return ((ConfigCacheClient) obj2).lambda$put$0((ConfigContainer) obj);
        }
    }
}
