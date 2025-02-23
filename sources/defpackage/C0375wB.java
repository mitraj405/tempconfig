package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: wB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0375wB implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ TransportContext a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Uploader f3392a;

    public /* synthetic */ C0375wB(Uploader uploader, TransportContext transportContext) {
        this.f3392a = uploader;
        this.a = transportContext;
    }

    public final Object execute() {
        return this.f3392a.lambda$logAndUpdateState$2(this.a);
    }
}
