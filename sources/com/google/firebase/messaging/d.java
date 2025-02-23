package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements OnSuccessListener, Continuation {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2850a;

    public /* synthetic */ d(Object obj, int i) {
        this.a = i;
        this.f2850a = obj;
    }

    public final void onSuccess(Object obj) {
        int i = this.a;
        Object obj2 = this.f2850a;
        switch (i) {
            case 0:
                ((FirebaseMessaging) obj2).lambda$new$3((TopicsSubscriber) obj);
                return;
            default:
                ((FirebaseMessaging) obj2).lambda$setNotificationDelegationEnabled$6((Void) obj);
                return;
        }
    }

    public final Object then(Task task) {
        return ((GmsRpc) this.f2850a).lambda$extractResponseWhenComplete$0(task);
    }
}
