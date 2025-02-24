package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public interface StatusListener {
        @KeepForSdk
        void onComplete(Status status);
    }

    @KeepForSdk
    public void addStatusListener(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit);

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }
}
