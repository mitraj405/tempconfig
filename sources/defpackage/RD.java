package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* renamed from: RD  reason: default package */
/* compiled from: WorkForegroundRunnable */
public final class RD implements Runnable {
    public static final /* synthetic */ int c = 0;
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ListenableWorker f497a;

    /* renamed from: a  reason: collision with other field name */
    public final SettableFuture<Void> f498a = new SettableFuture<>();

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f499a;

    /* renamed from: a  reason: collision with other field name */
    public final C0214hE f500a;

    /* renamed from: a  reason: collision with other field name */
    public final C0227id f501a;

    /* renamed from: RD$a */
    /* compiled from: WorkForegroundRunnable */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ SettableFuture f502a;

        public a(SettableFuture settableFuture) {
            this.f502a = settableFuture;
        }

        public final void run() {
            this.f502a.j(RD.this.f497a.getForegroundInfoAsync());
        }
    }

    /* renamed from: RD$b */
    /* compiled from: WorkForegroundRunnable */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ SettableFuture f503a;

        public b(SettableFuture settableFuture) {
            this.f503a = settableFuture;
        }

        public final void run() {
            RD rd = RD.this;
            try {
                ForegroundInfo foregroundInfo = (ForegroundInfo) this.f503a.get();
                if (foregroundInfo != null) {
                    zi c = zi.c();
                    int i = RD.c;
                    Object[] objArr = new Object[1];
                    C0214hE hEVar = rd.f500a;
                    ListenableWorker listenableWorker = rd.f497a;
                    objArr[0] = hEVar.f2995b;
                    String.format("Updating notification for %s", objArr);
                    c.a(new Throwable[0]);
                    listenableWorker.setRunInForeground(true);
                    SettableFuture<Void> settableFuture = rd.f498a;
                    C0227id idVar = rd.f501a;
                    Context context = rd.a;
                    UUID id = listenableWorker.getId();
                    TD td = (TD) idVar;
                    td.getClass();
                    SettableFuture settableFuture2 = new SettableFuture();
                    td.a.c(new SD(td, settableFuture2, id, foregroundInfo, context));
                    settableFuture.j(settableFuture2);
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{rd.f500a.f2995b}));
            } catch (Throwable th) {
                rd.f498a.i(th);
            }
        }
    }

    static {
        zi.e("WorkForegroundRunnable");
    }

    @SuppressLint({"LambdaLast"})
    public RD(Context context, C0214hE hEVar, ListenableWorker listenableWorker, C0227id idVar, TaskExecutor taskExecutor) {
        this.a = context;
        this.f500a = hEVar;
        this.f497a = listenableWorker;
        this.f501a = idVar;
        this.f499a = taskExecutor;
    }

    @SuppressLint({"UnsafeExperimentalUsageError"})
    public final void run() {
        if (!this.f500a.f2992a || s3.b()) {
            this.f498a.h(null);
            return;
        }
        SettableFuture settableFuture = new SettableFuture();
        TaskExecutor taskExecutor = this.f499a;
        taskExecutor.a().execute(new a(settableFuture));
        settableFuture.addListener(new b(settableFuture), taskExecutor.a());
    }
}
