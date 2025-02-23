package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: mC  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0269mC implements Deferred.DeferredHandler, Continuation, SuccessContinuation {
    public final /* synthetic */ Object a;

    public /* synthetic */ C0269mC(Object obj) {
        this.a = obj;
    }

    public final void handle(Provider provider) {
        RemoteConfigDeferredProxy.lambda$setupListener$0((CrashlyticsRemoteConfigListener) this.a, provider);
    }

    public final Task then(Object obj) {
        return ((FirebaseRemoteConfig) this.a).lambda$fetchAndActivate$1((Void) obj);
    }

    public final Object then(Task task) {
        return Utils.lambda$callTask$2((TaskCompletionSource) this.a, task);
    }
}
