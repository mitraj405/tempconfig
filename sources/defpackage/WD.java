package defpackage;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: WD  reason: default package */
/* compiled from: WorkManagerTaskExecutor */
public final class WD implements TaskExecutor {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final Handler f633a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public final C0209gw f634a;

    /* renamed from: WD$a */
    /* compiled from: WorkManagerTaskExecutor */
    public class a implements Executor {
        public a() {
        }

        public final void execute(Runnable runnable) {
            WD.this.f633a.post(runnable);
        }
    }

    public WD(ExecutorService executorService) {
        this.f634a = new C0209gw(executorService);
    }

    public final a a() {
        return this.a;
    }

    public final C0209gw b() {
        return this.f634a;
    }

    public final void c(Runnable runnable) {
        this.f634a.execute(runnable);
    }
}
