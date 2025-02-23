package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: yB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0403yB implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TransportContext f3425a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Uploader f3426a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Iterable f3427a;

    public /* synthetic */ C0403yB(Uploader uploader, Iterable iterable, TransportContext transportContext, long j) {
        this.f3426a = uploader;
        this.f3427a = iterable;
        this.f3425a = transportContext;
        this.a = j;
    }

    public final Object execute() {
        return this.f3426a.lambda$logAndUpdateState$4(this.f3427a, this.f3425a, this.a);
    }
}
