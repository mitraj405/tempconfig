package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdsu {
    private final zzg zza;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final String zze;
    private final zzdsp zzf;

    public zzdsu(String str, zzdsp zzdsp) {
        this.zze = str;
        this.zzf = zzdsp;
        this.zza = zzu.zzo().zzi();
    }

    private final Map zzg() {
        String str;
        Map zza2 = this.zzf.zza();
        zza2.put("tms", Long.toString(zzu.zzB().elapsedRealtime(), 10));
        if (this.zza.zzS()) {
            str = "";
        } else {
            str = this.zze;
        }
        zza2.put("tid", str);
        return zza2;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbP)).booleanValue()) {
            Map zzg = zzg();
            zzg.put(LogCategory.ACTION, "aaia");
            zzg.put("aair", "MalformedJson");
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbP)).booleanValue()) {
            Map zzg = zzg();
            zzg.put(LogCategory.ACTION, "adapter_init_finished");
            zzg.put("ancn", str);
            zzg.put("rqe", str2);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbP)).booleanValue()) {
            Map zzg = zzg();
            zzg.put(LogCategory.ACTION, "adapter_init_started");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbP)).booleanValue()) {
            Map zzg = zzg();
            zzg.put(LogCategory.ACTION, "adapter_init_finished");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbP     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0014
            goto L_0x0045
        L_0x0014:
            boolean r0 = r3.zzd     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0045
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0047 }
            java.util.List r1 = r3.zzb     // Catch:{ all -> 0x0047 }
            r1.add(r0)     // Catch:{ all -> 0x0047 }
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0047 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0047 }
        L_0x002e:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0047 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzdsp r2 = r3.zzf     // Catch:{ all -> 0x0047 }
            r2.zzf(r1)     // Catch:{ all -> 0x0047 }
            goto L_0x002e
        L_0x0040:
            r0 = 1
            r3.zzd = r0     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0045:
            monitor-exit(r3)
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsu.zze():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbP     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x002f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            boolean r0 = r3.zzc     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x002d
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x002f }
            java.util.List r1 = r3.zzb     // Catch:{ all -> 0x002f }
            r1.add(r0)     // Catch:{ all -> 0x002f }
            r0 = 1
            r3.zzc = r0     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsu.zzf():void");
    }
}
