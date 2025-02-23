package defpackage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

/* renamed from: Yt  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Yt implements OnSuccessListener {
    public final /* synthetic */ Task a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RolloutsStateSubscriptionsHandler f716a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RolloutsStateSubscriber f717a;

    public /* synthetic */ Yt(RolloutsStateSubscriptionsHandler rolloutsStateSubscriptionsHandler, Task task, RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.f716a = rolloutsStateSubscriptionsHandler;
        this.a = task;
        this.f717a = rolloutsStateSubscriber;
    }

    public final void onSuccess(Object obj) {
        this.f716a.lambda$registerRolloutsStateSubscriber$1(this.a, this.f717a, (ConfigContainer) obj);
    }
}
