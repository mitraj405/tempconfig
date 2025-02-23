package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: vB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0361vB implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TransportContext f3366a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Uploader f3367a;

    public /* synthetic */ C0361vB(Uploader uploader, TransportContext transportContext, int i) {
        this.f3367a = uploader;
        this.f3366a = transportContext;
        this.a = i;
    }

    public final Object execute() {
        return this.f3367a.lambda$upload$0(this.f3366a, this.a);
    }
}
