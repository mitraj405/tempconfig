package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.HashMap;
import java.util.Map;

/* renamed from: C6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C6 implements Continuation {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConfigFetchHandler f74a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Map f75a;

    public /* synthetic */ C6(ConfigFetchHandler configFetchHandler, long j, HashMap hashMap) {
        this.f74a = configFetchHandler;
        this.a = j;
        this.f75a = hashMap;
    }

    public final Object then(Task task) {
        return this.f74a.lambda$fetch$0(this.a, this.f75a, task);
    }
}
