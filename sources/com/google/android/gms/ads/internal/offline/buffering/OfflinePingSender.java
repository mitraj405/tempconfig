package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class OfflinePingSender extends Worker {
    private final zzbsg zza;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzay.zza().zzm(context, new zzboi());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzh();
            return new ListenableWorker.Result.c();
        } catch (RemoteException unused) {
            return new ListenableWorker.Result.a();
        }
    }
}
