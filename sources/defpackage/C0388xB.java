package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import java.util.Map;

/* renamed from: xB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0388xB implements SynchronizationGuard.CriticalSection, Continuation {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3408a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0388xB(int i, Object obj, Object obj2) {
        this.a = i;
        this.f3408a = obj;
        this.b = obj2;
    }

    public final Object execute() {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.f3408a;
        switch (i) {
            case 0:
                return ((Uploader) obj2).lambda$logAndUpdateState$3((TransportContext) obj);
            default:
                return ((Uploader) obj2).lambda$logAndUpdateState$7((Map) obj);
        }
    }

    public final Object then(Task task) {
        return ((ConfigRealtimeHttpClient) this.f3408a).lambda$beginRealtimeHttpStream$1((Task) this.b, task);
    }
}
