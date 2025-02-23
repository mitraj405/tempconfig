package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public static abstract class Result {

        public static final class a extends Result {
            public final Data a = Data.a;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((a) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode() + (a.class.getName().hashCode() * 31);
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.a + '}';
            }
        }

        public static final class b extends Result {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                return b.class.getName().hashCode();
            }

            public final String toString() {
                return "Retry";
            }
        }

        public static final class c extends Result {
            public final Data a;

            public c() {
                this(Data.a);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((c) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode() + (c.class.getName().hashCode() * 31);
            }

            public final String toString() {
                return "Success {mOutputData=" + this.a + '}';
            }

            public c(Data data) {
                this.a = data;
            }
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f2645a;
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.i(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public final UUID getId() {
        return this.mWorkerParams.f2644a;
    }

    public final Data getInputData() {
        return this.mWorkerParams.f2638a;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f2640a.a;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.a;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f2643a;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.f2641a;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f2640a.f2646a;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f2640a.b;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.f2639a;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        C0227id idVar = this.mWorkerParams.f2642a;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        TD td = (TD) idVar;
        td.getClass();
        SettableFuture settableFuture = new SettableFuture();
        td.a.c(new SD(td, settableFuture, id, foregroundInfo, applicationContext));
        return settableFuture;
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        Dq dq = this.mWorkerParams.f2637a;
        getApplicationContext();
        UUID id = getId();
        C0178eE eEVar = (C0178eE) dq;
        eEVar.getClass();
        SettableFuture settableFuture = new SettableFuture();
        eEVar.f2882a.c(new C0167dE(eEVar, id, data, settableFuture));
        return settableFuture;
    }

    public void setRunInForeground(boolean z) {
        this.mRunInForeground = z;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public void onStopped() {
    }
}
