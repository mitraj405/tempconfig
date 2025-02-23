package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;
import java.util.Map;

/* renamed from: D6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class D6 implements Continuation {
    public final /* synthetic */ Task a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConfigFetchHandler f113a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f114a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Map f115a;
    public final /* synthetic */ Task b;

    public /* synthetic */ D6(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Map map) {
        this.f113a = configFetchHandler;
        this.a = task;
        this.b = task2;
        this.f114a = date;
        this.f115a = map;
    }

    public final Object then(Task task) {
        return this.f113a.lambda$fetchIfCacheExpiredAndNotThrottled$2(this.a, this.b, this.f114a, this.f115a, task);
    }
}
