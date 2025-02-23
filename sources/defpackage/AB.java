package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: AB  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class AB implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TransportContext f9a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Uploader f10a;

    public /* synthetic */ AB(Uploader uploader, TransportContext transportContext, long j) {
        this.f10a = uploader;
        this.f9a = transportContext;
        this.a = j;
    }

    public final Object execute() {
        return this.f10a.lambda$logAndUpdateState$8(this.f9a, this.a);
    }
}
