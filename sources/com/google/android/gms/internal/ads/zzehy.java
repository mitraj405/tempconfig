package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzehy {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final zzgdc zzc;
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private zzeio zzf;
    private int zzg = Integer.MAX_VALUE;
    private final String zzh;
    private final int zzi;
    private final zzein zzj;
    private zzfel zzk;
    private boolean zzl;

    public zzehy(zzfex zzfex, zzein zzein, zzgdc zzgdc) {
        this.zzl = false;
        this.zzi = zzfex.zzb.zzb.zzr;
        this.zzj = zzein;
        this.zzc = zzgdc;
        this.zzh = zzeiu.zzc(zzfex);
        List list = zzfex.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfel) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzeio zzeio = this.zzf;
        if (zzeio != null) {
            this.zzc.zzc(zzeio);
        } else {
            this.zzc.zzd(new zzeir(3, this.zzh));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List r0 = r4.zzb     // Catch:{ all -> 0x004b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004b }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x004b }
            com.google.android.gms.internal.ads.zzfel r1 = (com.google.android.gms.internal.ads.zzfel) r1     // Catch:{ all -> 0x004b }
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0022
            int r2 = r2.intValue()     // Catch:{ all -> 0x004b }
            goto L_0x0025
        L_0x0022:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x0025:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0035
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x004b }
            java.lang.String r1 = r1.zzat     // Catch:{ all -> 0x004b }
            boolean r1 = r3.contains(r1)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0007
        L_0x0035:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r3 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 >= r3) goto L_0x0040
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0040:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r2 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 <= r2) goto L_0x0007
        L_0x0048:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x004b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehy.zzf(boolean):boolean");
    }

    private final synchronized boolean zzg() {
        int i;
        for (zzfel zzfel : this.zzd) {
            Integer num = (Integer) this.zza.get(zzfel);
            if (num != null) {
                i = num.intValue();
            } else {
                i = Integer.MAX_VALUE;
            }
            if (Integer.valueOf(i).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzh() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            boolean r1 = r2.zzf(r0)     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0012
            boolean r1 = r2.zzg()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0012:
            monitor-exit(r2)
            return r0
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehy.zzh():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzi() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzl     // Catch:{ all -> 0x0042 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0027
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfel r0 = (com.google.android.gms.internal.ads.zzfel) r0     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.zzav     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0027
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            monitor-exit(r3)
            return r1
        L_0x0027:
            boolean r0 = r3.zzd()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0040
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0042 }
            int r2 = r3.zzi     // Catch:{ all -> 0x0042 }
            int r0 = r0.size()     // Catch:{ all -> 0x0042 }
            if (r0 >= r2) goto L_0x0040
            boolean r0 = r3.zzf(r1)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0040
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0040:
            monitor-exit(r3)
            return r1
        L_0x0042:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehy.zzi():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfel zza() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzi()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0046
            r0 = 0
        L_0x0008:
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            int r1 = r1.size()     // Catch:{ all -> 0x0049 }
            if (r0 >= r1) goto L_0x0046
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfel r1 = (com.google.android.gms.internal.ads.zzfel) r1     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r1.zzat     // Catch:{ all -> 0x0049 }
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.contains(r2)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0025
            int r0 = r0 + 1
            goto L_0x0008
        L_0x0025:
            boolean r3 = r1.zzav     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x002c
            r3 = 1
            r4.zzl = r3     // Catch:{ all -> 0x0049 }
        L_0x002c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x0037
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            r3.add(r2)     // Catch:{ all -> 0x0049 }
        L_0x0037:
            java.util.List r2 = r4.zzd     // Catch:{ all -> 0x0049 }
            r2.add(r1)     // Catch:{ all -> 0x0049 }
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r0 = r1.remove(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfel r0 = (com.google.android.gms.internal.ads.zzfel) r0     // Catch:{ all -> 0x0049 }
            monitor-exit(r4)
            return r0
        L_0x0046:
            monitor-exit(r4)
            r0 = 0
            return r0
        L_0x0049:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehy.zza():com.google.android.gms.internal.ads.zzfel");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(java.lang.Throwable r1, com.google.android.gms.internal.ads.zzfel r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            r1 = 0
            r0.zzl = r1     // Catch:{ all -> 0x0023 }
            java.util.List r1 = r0.zzd     // Catch:{ all -> 0x0023 }
            r1.remove(r2)     // Catch:{ all -> 0x0023 }
            java.util.Set r1 = r0.zze     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.zzat     // Catch:{ all -> 0x0023 }
            r1.remove(r2)     // Catch:{ all -> 0x0023 }
            boolean r1 = r0.zzd()     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            boolean r1 = r0.zzh()     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            r0.zze()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return
        L_0x0021:
            monitor-exit(r0)
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehy.zzb(java.lang.Throwable, com.google.android.gms.internal.ads.zzfel):void");
    }

    public final synchronized void zzc(zzeio zzeio, zzfel zzfel) {
        int i;
        this.zzl = false;
        this.zzd.remove(zzfel);
        if (zzd()) {
            zzeio.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfel);
        if (num != null) {
            i = num.intValue();
        } else {
            i = Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfel);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = valueOf.intValue();
        this.zzf = zzeio;
        this.zzk = zzfel;
        if (!zzh()) {
            zze();
        }
    }

    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
