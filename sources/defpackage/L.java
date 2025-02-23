package defpackage;

import android.graphics.Canvas;
import android.os.Bundle;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.sessions.EventGDTLogger;
import com.google.firebase.sessions.SessionEvent;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.EventListener;

/* renamed from: L  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class L implements SynchronizationGuard.CriticalSection, CanvasCompat.CanvasOperation, AnalyticsEventLogger, Continuation, OnSuccessListener, SuccessContinuation, Transformer, EventListener.Factory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f376a;

    public /* synthetic */ L(Object obj, int i) {
        this.a = i;
        this.f376a = obj;
    }

    public final Object apply(Object obj) {
        return ((EventGDTLogger) this.f376a).encode((SessionEvent) obj);
    }

    public final EventListener create(Call call) {
        return EventListener.lambda$factory$0((EventListener) this.f376a, call);
    }

    public final Object execute() {
        return ((WorkInitializer) this.f376a).lambda$ensureContextsScheduled$0();
    }

    public final void logEvent(String str, Bundle bundle) {
        ((AnalyticsDeferredProxy) this.f376a).lambda$getAnalyticsEventLogger$1(str, bundle);
    }

    public final void onSuccess(Object obj) {
        ((RemoteConfigManager) this.f376a).lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
    }

    public final void run(Canvas canvas) {
        int i = this.a;
        Object obj = this.f376a;
        switch (i) {
            case 2:
                ((MaskableFrameLayout) obj).lambda$dispatchDraw$1(canvas);
                return;
            default:
                ((NavigationView) obj).lambda$dispatchDraw$0(canvas);
                return;
        }
    }

    public final Task then(Object obj) {
        return Tasks.forResult((ConfigFetchHandler.FetchResponse) this.f376a);
    }

    public final Object then(Task task) {
        int i = this.a;
        Object obj = this.f376a;
        switch (i) {
            case 5:
                return ((CountDownLatch) obj).countDown();
            default:
                return FirebaseRemoteConfig.lambda$ensureInitialized$0((Task) obj, task);
        }
    }
}
