package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzemk implements AppEventListener, zzczo, zzcye, zzcwt, zzcxk, zza, zzcwq, zzczb, zzcxg, zzdeq {
    final zzdsk zza;
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) zzba.zzc().zza(zzbbw.zzhX)).intValue());
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);

    public zzemk(zzdsk zzdsk) {
        this.zza = zzdsk;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            for (Pair zzelv : this.zzb) {
                zzfbq.zza(this.zzd, new zzelv(zzelv));
            }
            this.zzb.clear();
            this.zzh.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
            zzfbq.zza(this.zzc, new zzemi());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzh     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003b
            java.util.concurrent.BlockingQueue r0 = r3.zzb     // Catch:{ all -> 0x0047 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzdsk r0 = r3.zza     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzdsj r0 = r0.zza()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "dae_action"
            r0.zzb(r1, r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "dae_name"
            r0.zzb(r1, r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "dae_data"
            r0.zzb(r4, r5)     // Catch:{ all -> 0x0047 }
            r0.zzf()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0039:
            monitor-exit(r3)
            return
        L_0x003b:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzemc r1 = new com.google.android.gms.internal.ads.zzemc     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzfbq.zza(r0, r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0047:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemk.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zza() {
        zzfbq.zza(this.zzc, new zzels());
        zzfbq.zza(this.zzg, new zzelt());
    }

    public final void zzb() {
        zzfbq.zza(this.zzc, new zzemd());
    }

    public final void zzc() {
        zzfbq.zza(this.zzc, new zzemf());
        zzfbq.zza(this.zzg, new zzemg());
        zzfbq.zza(this.zzg, new zzemh());
    }

    public final void zzdB(zze zze2) {
        zzfbq.zza(this.zzc, new zzelw(zze2));
        zzfbq.zza(this.zzc, new zzelx(zze2));
        zzfbq.zza(this.zzf, new zzely(zze2));
        this.zzh.set(false);
        this.zzb.clear();
    }

    public final void zzdG() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
            zzfbq.zza(this.zzc, new zzemi());
        }
        zzfbq.zza(this.zzg, new zzelu());
    }

    public final void zzdf() {
        zzfbq.zza(this.zzc, new zzeme());
    }

    public final void zzdo(zzfex zzfex) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    public final synchronized zzbh zzg() {
        return (zzbh) this.zzc.get();
    }

    public final void zzh(zzs zzs) {
        zzfbq.zza(this.zze, new zzemj(zzs));
    }

    public final synchronized zzcb zzi() {
        return (zzcb) this.zzd.get();
    }

    public final void zzj(zzbh zzbh) {
        this.zzc.set(zzbh);
    }

    public final void zzk(zzbk zzbk) {
        this.zzf.set(zzbk);
    }

    public final void zzl(zzdg zzdg) {
        this.zze.set(zzdg);
    }

    public final void zzm(zzcb zzcb) {
        this.zzd.set(zzcb);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(zzci zzci) {
        this.zzg.set(zzci);
    }

    public final void zzq(zze zze2) {
        zzfbq.zza(this.zzg, new zzemb(zze2));
    }

    public final void zzr() {
        zzfbq.zza(this.zzc, new zzelr());
    }

    public final synchronized void zzs() {
        zzfbq.zza(this.zzc, new zzelz());
        zzfbq.zza(this.zzf, new zzema());
        this.zzj.set(true);
        zzo();
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzdn(zzbvb zzbvb) {
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
    }
}
