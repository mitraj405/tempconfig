package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdz {
    private final zzdj zza;
    private final zzdt zzb;
    private final zzdx zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzdz(Looper looper, zzdj zzdj, zzdx zzdx) {
        this(new CopyOnWriteArraySet(), looper, zzdj, zzdx, true);
    }

    public static /* synthetic */ boolean zzg(zzdz zzdz, Message message) {
        Iterator it = zzdz.zzd.iterator();
        while (it.hasNext()) {
            ((zzdy) it.next()).zzb(zzdz.zzc);
            if (zzdz.zzb.zzg(0)) {
                return true;
            }
        }
        return true;
    }

    private final void zzh() {
        boolean z;
        if (this.zzi) {
            if (Thread.currentThread() == this.zzb.zza().getThread()) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzf(z);
        }
    }

    public final zzdz zza(Looper looper, zzdx zzdx) {
        return new zzdz(this.zzd, looper, this.zza, zzdx, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (!this.zzh) {
                this.zzd.add(new zzdy(obj));
            }
        }
    }

    public final void zzc() {
        zzh();
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzg(0)) {
                zzdt zzdt = this.zzb;
                zzdt.zzk(zzdt.zzb(0));
            }
            boolean z = !this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!z) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i, zzdw zzdw) {
        zzh();
        this.zzf.add(new zzdv(new CopyOnWriteArraySet(this.zzd), i, zzdw));
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzdy) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzdy zzdy = (zzdy) it.next();
            if (zzdy.zza.equals(obj)) {
                zzdy.zzc(this.zzc);
                this.zzd.remove(zzdy);
            }
        }
    }

    private zzdz(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdj zzdj, zzdx zzdx, boolean z) {
        this.zza = zzdj;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzdx;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzdj.zzb(looper, new zzdu(this));
        this.zzi = z;
    }
}
