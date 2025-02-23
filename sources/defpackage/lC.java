package defpackage;

import android.animation.Animator;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.config.RemoteConfigManager;

/* renamed from: lC  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class lC implements SynchronizationGuard.CriticalSection, AccessibilityViewCommand, AnimatableView.Listener, Deferred.DeferredHandler, Continuation, OnFailureListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3081a;

    public /* synthetic */ lC(Object obj, int i) {
        this.a = i;
        this.f3081a = obj;
    }

    public final Integer a() {
        return Integer.valueOf(((ViewConfiguration) this.f3081a).getScaledMinimumFlingVelocity());
    }

    public final Object execute() {
        int i = this.a;
        Object obj = this.f3081a;
        switch (i) {
            case 1:
                return ((ClientHealthMetricsStore) obj).loadClientMetrics();
            default:
                return ((Uploader) obj).lambda$logAndUpdateState$6();
        }
    }

    public final void handle(Provider provider) {
        ((AnalyticsDeferredProxy) this.f3081a).lambda$init$2(provider);
    }

    public final void onAnimationEnd() {
        ((Animator) this.f3081a).start();
    }

    public final void onFailure(Exception exc) {
        ((RemoteConfigManager) this.f3081a).lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.f3081a).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    public final Object then(Task task) {
        int i = this.a;
        Object obj = this.f3081a;
        switch (i) {
            case 6:
                return Boolean.valueOf(((SessionReportingCoordinator) obj).onReportSendComplete(task));
            default:
                return Utils.lambda$race$1((TaskCompletionSource) obj, task);
        }
    }
}
