package defpackage;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: v8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class v8 implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ EventInternal a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TransportContext f3363a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DefaultScheduler f3364a;

    public /* synthetic */ v8(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f3364a = defaultScheduler;
        this.f3363a = transportContext;
        this.a = eventInternal;
    }

    public final Object execute() {
        return this.f3364a.lambda$schedule$0(this.f3363a, this.a);
    }
}
