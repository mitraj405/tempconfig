package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzein {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzeip zzb;
    /* access modifiers changed from: private */
    public final zzfll zzc;
    /* access modifiers changed from: private */
    public final LinkedHashMap zzd = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzeey zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    private long zzh;
    private long zzi;

    public zzein(Clock clock, zzeip zzeip, zzeey zzeey, zzfll zzfll) {
        this.zza = clock;
        this.zzb = zzeip;
        this.zze = ((Boolean) zzba.zzc().zza(zzbbw.zzgh)).booleanValue();
        this.zzf = zzeey;
        this.zzc = zzfll;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r3.zzc != 8) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(com.google.android.gms.internal.ads.zzfel r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.LinkedHashMap r0 = r2.zzd     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzeim r3 = (com.google.android.gms.internal.ads.zzeim) r3     // Catch:{ all -> 0x0018 }
            r0 = 0
            if (r3 != 0) goto L_0x000e
            monitor-exit(r2)
            return r0
        L_0x000e:
            int r3 = r3.zzc     // Catch:{ all -> 0x0018 }
            r1 = 8
            monitor-exit(r2)
            if (r3 != r1) goto L_0x0017
            r3 = 1
            return r3
        L_0x0017:
            return r0
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzein.zzq(com.google.android.gms.internal.ads.zzfel):boolean");
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    public final synchronized ListenableFuture zzf(zzfex zzfex, zzfel zzfel, ListenableFuture listenableFuture, zzflh zzflh) {
        zzfel zzfel2 = zzfel;
        ListenableFuture listenableFuture2 = listenableFuture;
        synchronized (this) {
            zzfeo zzfeo = zzfex.zzb.zzb;
            long elapsedRealtime = this.zza.elapsedRealtime();
            String str = zzfel2.zzw;
            if (str != null) {
                this.zzd.put(zzfel2, new zzeim(str, zzfel2.zzaf, 9, 0, (Integer) null));
                zzgcj.zzr(listenableFuture2, new zzeil(this, elapsedRealtime, zzfeo, zzfel, str, zzflh, zzfex), zzbzo.zzf);
            }
        }
        return listenableFuture2;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry value : this.zzd.entrySet()) {
            zzeim zzeim = (zzeim) value.getValue();
            if (zzeim.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzeim.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzfel zzfel) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzfel != null) {
            this.zzf.zze(zzfel);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfel zzfel = (zzfel) it.next();
            if (!TextUtils.isEmpty(zzfel.zzw)) {
                this.zzd.put(zzfel, new zzeim(zzfel.zzw, zzfel.zzaf, Integer.MAX_VALUE, 0, (Integer) null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzm(com.google.android.gms.internal.ads.zzfel r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.LinkedHashMap r0 = r1.zzd     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.internal.ads.zzeim r2 = (com.google.android.gms.internal.ads.zzeim) r2     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0015
            boolean r0 = r1.zzg     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0015
            r0 = 8
            r2.zzc = r0     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzein.zzm(com.google.android.gms.internal.ads.zzfel):void");
    }
}
