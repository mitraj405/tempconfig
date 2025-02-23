package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            Worker worker = Worker.this;
            try {
                worker.mFuture.h(worker.doWork());
            } catch (Throwable th) {
                worker.mFuture.i(th);
            }
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = new SettableFuture<>();
        getBackgroundExecutor().execute(new a());
        return this.mFuture;
    }
}
