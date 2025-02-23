package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzftz {
    private final zzfvk zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzfua zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzf;
    private final Intent zzg;
    /* access modifiers changed from: private */
    public final IBinder.DeathRecipient zzh;
    private ServiceConnection zzi;
    /* access modifiers changed from: private */
    public IInterface zzj;

    public zzftz(Context context, zzfua zzfua, String str, Intent intent, zzftf zzftf) {
        this.zzb = context;
        this.zzc = zzfua;
        this.zzd = "OverlayDisplayService";
        this.zzg = intent;
        this.zza = zzfvo.zza(new zzftq("OverlayDisplayService"));
        this.zzh = new zzftr(this);
    }

    /* access modifiers changed from: private */
    public final void zzo(Runnable runnable) {
        ((Handler) this.zza.zza()).post(new zzfts(this, runnable));
    }

    public final IInterface zzc() {
        return this.zzj;
    }

    public final void zzi(Runnable runnable) {
        zzo(new zzftt(this, runnable));
    }

    public final /* synthetic */ void zzj(Runnable runnable) {
        if (this.zzj == null && !this.zzf) {
            this.zzc.zzc("Initiate binding to the service.", new Object[0]);
            synchronized (this.zze) {
                this.zze.add(runnable);
            }
            zzfty zzfty = new zzfty(this, (zzftx) null);
            this.zzi = zzfty;
            this.zzf = true;
            if (!this.zzb.bindService(this.zzg, zzfty, 1)) {
                this.zzc.zzc("Failed to bind to the service.", new Object[0]);
                this.zzf = false;
                synchronized (this.zze) {
                    this.zze.clear();
                }
            }
        } else if (this.zzf) {
            this.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            synchronized (this.zze) {
                this.zze.add(runnable);
            }
        } else {
            runnable.run();
        }
    }

    public final /* synthetic */ void zzk() {
        this.zzc.zzc("%s : Binder has died.", this.zzd);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    public final /* synthetic */ void zzl(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            this.zzc.zza("error caused by ", e);
        }
    }

    public final /* synthetic */ void zzm() {
        if (this.zzj != null) {
            this.zzc.zzc("Unbind from service.", new Object[0]);
            Context context = this.zzb;
            ServiceConnection serviceConnection = this.zzi;
            serviceConnection.getClass();
            context.unbindService(serviceConnection);
            this.zzf = false;
            this.zzj = null;
            this.zzi = null;
            synchronized (this.zze) {
                this.zze.clear();
            }
        }
    }

    public final void zzn() {
        zzo(new zzftu(this));
    }
}
