package defpackage;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

/* renamed from: vc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0364vc implements Runnable {
    public final /* synthetic */ TaskCompletionSource a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FirebaseMessaging f3370a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0364vc(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource, int i) {
        this.c = i;
        this.f3370a = firebaseMessaging;
        this.a = taskCompletionSource;
    }

    public final void run() {
        int i = this.c;
        TaskCompletionSource taskCompletionSource = this.a;
        FirebaseMessaging firebaseMessaging = this.f3370a;
        switch (i) {
            case 0:
                firebaseMessaging.lambda$deleteToken$9(taskCompletionSource);
                return;
            default:
                firebaseMessaging.lambda$getToken$7(taskCompletionSource);
                return;
        }
    }
}
