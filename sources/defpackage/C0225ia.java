package defpackage;

import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.a;
import androidx.emoji2.text.d;
import androidx.emoji2.text.e;
import androidx.emoji2.text.g;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: ia  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0225ia implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f3004c;

    public /* synthetic */ C0225ia(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
        this.f3004c = obj3;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                EmojiCompatInitializer.b bVar = (EmojiCompatInitializer.b) this.a;
                d.h hVar = (d.h) this.b;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f3004c;
                bVar.getClass();
                try {
                    g a2 = a.a(bVar.a);
                    if (a2 != null) {
                        g.b bVar2 = (g.b) a2.f2014a;
                        synchronized (bVar2.f2025a) {
                            bVar2.f2026a = threadPoolExecutor;
                        }
                        a2.f2014a.a(new e(hVar, threadPoolExecutor));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    hVar.a(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                Utils.lambda$callTask$3((Callable) this.a, (Executor) this.b, (TaskCompletionSource) this.f3004c);
                return;
            case 2:
                ((GaugeManager) this.a).lambda$stopCollectingGauges$3((String) this.b, (ApplicationProcessState) this.f3004c);
                return;
            default:
                ((TransportManager) this.a).lambda$log$2((TraceMetric) this.b, (ApplicationProcessState) this.f3004c);
                return;
        }
    }
}
