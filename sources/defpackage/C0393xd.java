package defpackage;

import androidx.transition.Transition;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.A4;

/* renamed from: xd  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0393xd implements A4.a, Continuation {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0393xd(Transition transition, Runnable runnable) {
        this.a = null;
        this.c = transition;
        this.b = runnable;
    }

    public final void onCancel() {
        Runnable runnable = (Runnable) this.a;
        Transition transition = (Transition) this.c;
        Runnable runnable2 = (Runnable) this.b;
        if (runnable == null) {
            transition.cancel();
            runnable2.run();
            return;
        }
        runnable.run();
    }

    public final Object then(Task task) {
        return ((FirebaseRemoteConfig) this.a).lambda$activate$2((Task) this.b, (Task) this.c, task);
    }

    public /* synthetic */ C0393xd(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.a = firebaseRemoteConfig;
        this.b = task;
        this.c = task2;
    }
}
