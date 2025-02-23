package defpackage;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: Vf  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Vf implements Xf, SynchronizationGuard.CriticalSection, BreadcrumbSource, Deferred.DeferredHandler, Continuation {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f600a;

    public /* synthetic */ Vf(Object obj, int i) {
        this.a = i;
        this.f600a = obj;
    }

    public final Object execute() {
        return Integer.valueOf(((EventStore) this.f600a).cleanUp());
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponentDeferredProxy) this.f600a).lambda$new$0(provider);
    }

    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        ((AnalyticsDeferredProxy) this.f600a).lambda$getDeferredBreadcrumbSource$0(breadcrumbHandler);
    }

    public final Object then(Task task) {
        int i = this.a;
        Object obj = this.f600a;
        switch (i) {
            case 4:
                return Utils.lambda$race$0((TaskCompletionSource) obj, task);
            default:
                return Boolean.valueOf(((FirebaseRemoteConfig) obj).processActivatePutTask(task));
        }
    }
}
