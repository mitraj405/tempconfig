package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;

/* renamed from: F6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class F6 implements Continuation {
    public final /* synthetic */ Task a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConfigRealtimeHttpClient f190a;
    public final /* synthetic */ Task b;

    public /* synthetic */ F6(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task, Task task2) {
        this.f190a = configRealtimeHttpClient;
        this.a = task;
        this.b = task2;
    }

    public final Object then(Task task) {
        return this.f190a.lambda$createRealtimeConnection$0(this.a, this.b, task);
    }
}
