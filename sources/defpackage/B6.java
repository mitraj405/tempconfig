package defpackage;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

/* renamed from: B6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class B6 implements SuccessContinuation {
    public final /* synthetic */ ConfigCacheClient a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConfigContainer f42a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f43a;

    public /* synthetic */ B6(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        this.a = configCacheClient;
        this.f43a = z;
        this.f42a = configContainer;
    }

    public final Task then(Object obj) {
        return this.a.lambda$put$1(this.f43a, this.f42a, (Void) obj);
    }
}
