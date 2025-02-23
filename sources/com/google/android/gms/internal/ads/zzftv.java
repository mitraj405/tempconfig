package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftv implements Runnable {
    public final /* synthetic */ zzfty zza;
    public final /* synthetic */ IBinder zzb;

    public /* synthetic */ zzftv(zzfty zzfty, IBinder iBinder) {
        this.zza = zzfty;
        this.zzb = iBinder;
    }

    public final void run() {
        zzfty zzfty = this.zza;
        zzfty.zza.zzj = zzfsi.zzb(this.zzb);
        zzfty.zza.zzc.zzc("linkToDeath", new Object[0]);
        try {
            IInterface zzb2 = zzfty.zza.zzj;
            zzb2.getClass();
            zzb2.asBinder().linkToDeath(zzfty.zza.zzh, 0);
        } catch (RemoteException e) {
            zzfty.zza.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
        zzfty.zza.zzf = false;
        synchronized (zzfty.zza.zze) {
            for (Runnable run : zzfty.zza.zze) {
                run.run();
            }
            zzfty.zza.zze.clear();
        }
    }
}
