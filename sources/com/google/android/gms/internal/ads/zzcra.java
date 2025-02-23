package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcra extends zzcpk {
    private final zzbgu zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcra(zzcrt zzcrt, zzbgu zzbgu, Runnable runnable, Executor executor) {
        super(zzcrt);
        this.zzc = zzbgu;
        this.zzd = runnable;
        this.zze = executor;
    }

    public static /* synthetic */ void zzj(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final int zza() {
        return -1;
    }

    public final int zzc() {
        return 0;
    }

    public final View zzd() {
        return null;
    }

    public final zzdq zze() {
        return null;
    }

    public final zzfem zzf() {
        return null;
    }

    public final zzfem zzg() {
        return null;
    }

    public final void zzk() {
        this.zze.execute(new zzcqz(this, new zzcqy(new AtomicReference(this.zzd))));
    }

    public final /* synthetic */ void zzl(Runnable runnable) {
        try {
            if (!this.zzc.zze(ObjectWrapper.wrap(runnable))) {
                zzj(((zzcqy) runnable).zza);
            }
        } catch (RemoteException unused) {
            zzj(((zzcqy) runnable).zza);
        }
    }

    public final void zzh() {
    }

    public final void zzi(ViewGroup viewGroup, zzq zzq) {
    }
}
