package defpackage;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import in.juspay.hypersdk.core.InflateView;
import java.util.Map;

/* renamed from: zB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0420zB implements SynchronizationGuard.CriticalSection, Continuation, SwipeRefreshLayout.f {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0420zB(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final void a() {
        ((InflateView) this.a).lambda$parseKeys$4((String) this.b);
    }

    public final Object execute() {
        return ((Uploader) this.a).lambda$logAndUpdateState$5((Iterable) this.b);
    }

    public final Object then(Task task) {
        return ((ConfigFetchHandler) this.a).lambda$fetchNowWithTypeAndAttemptNumber$1((Map) this.b, task);
    }
}
