package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.momagic.B;

/* renamed from: uB  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0349uB implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f3316c;
    public final /* synthetic */ int d;

    public /* synthetic */ C0349uB(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        this.a = uploader;
        this.b = transportContext;
        this.d = i;
        this.f3316c = runnable;
    }

    public final void run() {
        int i = this.c;
        int i2 = this.d;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((Uploader) obj2).lambda$upload$1((TransportContext) obj, i2, (Runnable) this.f3316c);
                return;
            default:
                ((B.b) obj2).a(i2, (String) obj);
                return;
        }
    }

    public /* synthetic */ C0349uB(B.b bVar, int i, String str, Throwable th) {
        this.a = bVar;
        this.d = i;
        this.b = str;
        this.f3316c = th;
    }
}
