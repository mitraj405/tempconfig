package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigAutoFetch;

/* renamed from: z6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0417z6 implements Continuation {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ long f3449a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Task f3450a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConfigAutoFetch f3451a;
    public final /* synthetic */ Task b;

    public /* synthetic */ C0417z6(ConfigAutoFetch configAutoFetch, Task task, Task task2, long j, int i) {
        this.f3451a = configAutoFetch;
        this.f3450a = task;
        this.b = task2;
        this.f3449a = j;
        this.a = i;
    }

    public final Object then(Task task) {
        return this.f3451a.lambda$fetchLatestConfig$0(this.f3450a, this.b, this.f3449a, this.a, task);
    }
}
