package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public static class Builder<A extends Api.AnyClient, ResultT> {
        /* access modifiers changed from: private */
        public RemoteCall<A, TaskCompletionSource<ResultT>> zaa;
        private boolean zab = true;
        private Feature[] zac;
        private int zad = 0;

        private Builder() {
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            boolean z;
            if (this.zaa != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zaa = new zacu(biConsumer);
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.zab = z;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i) {
            this.zad = i;
            return this;
        }

        public /* synthetic */ Builder(zacw zacw) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>((zacw) null);
    }

    @KeepForSdk
    public abstract void doExecute(A a, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    public final Feature[] zab() {
        return this.zaa;
    }

    @KeepForSdk
    public TaskApiCall(Feature[] featureArr, boolean z, int i) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = i;
    }
}
