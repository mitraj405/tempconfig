package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfgv implements zzfgu {
    private final ConcurrentHashMap zza;
    private final zzfhb zzb;
    private final zzfgx zzc = new zzfgx();

    public zzfgv(zzfhb zzfhb) {
        this.zza = new ConcurrentHashMap(zzfhb.zzd);
        this.zzb = zzfhb;
    }

    private final void zzf() {
        Parcelable.Creator<zzfhb> creator = zzfhb.CREATOR;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfH)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfhe) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfgt) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb2 = ((zzfgt) entry.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfgt) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzm.zze(sb.toString());
        }
    }

    public final zzfhb zza() {
        return this.zzb;
    }

    public final synchronized zzfhd zzb(zzfhe zzfhe) {
        zzfhd zzfhd;
        zzfgt zzfgt = (zzfgt) this.zza.get(zzfhe);
        if (zzfgt != null) {
            zzfhd = zzfgt.zze();
            if (zzfhd == null) {
                this.zzc.zze();
            }
            zzfhr zzf = zzfgt.zzf();
            if (zzfhd != null) {
                zzbbc.zzb.zzc zzd = zzbbc.zzb.zzd();
                zzbbc.zzb.zza.C0037zza zza2 = zzbbc.zzb.zza.zza();
                zza2.zzf(zzbbc.zzb.zzd.IN_MEMORY);
                zzbbc.zzb.zze.zza zzc2 = zzbbc.zzb.zze.zzc();
                zzc2.zzd(zzf.zza);
                zzc2.zze(zzf.zzb);
                zza2.zzg(zzc2);
                zzd.zzd(zza2);
                zzfhd.zza.zzb().zzc().zzi((zzbbc.zzb) zzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfhd = null;
        }
        return zzfhd;
    }

    @Deprecated
    public final zzfhe zzc(zzl zzl, String str, zzw zzw) {
        return new zzfhf(zzl, str, new zzbve(this.zzb.zza).zza().zzj, this.zzb.zzf, zzw);
    }

    public final synchronized boolean zzd(zzfhe zzfhe, zzfhd zzfhd) {
        boolean zzh;
        zzfgt zzfgt = (zzfgt) this.zza.get(zzfhe);
        zzfhd.zzd = zzu.zzB().currentTimeMillis();
        if (zzfgt == null) {
            zzfhb zzfhb = this.zzb;
            zzfgt zzfgt2 = new zzfgt(zzfhb.zzd, zzfhb.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzfhe zzfhe2 = null;
                if (i != 0) {
                    long j = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzfgt) entry.getValue()).zzc() < j) {
                                j = ((zzfgt) entry.getValue()).zzc();
                                zzfhe2 = (zzfhe) entry.getKey();
                            }
                        }
                        if (zzfhe2 != null) {
                            this.zza.remove(zzfhe2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzfgt) entry2.getValue()).zzd() < j) {
                                j = ((zzfgt) entry2.getValue()).zzd();
                                zzfhe2 = (zzfhe) entry2.getKey();
                            }
                        }
                        if (zzfhe2 != null) {
                            this.zza.remove(zzfhe2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfgt) entry3.getValue()).zza() < i3) {
                                i3 = ((zzfgt) entry3.getValue()).zza();
                                zzfhe2 = (zzfhe) entry3.getKey();
                            }
                        }
                        if (zzfhe2 != null) {
                            this.zza.remove(zzfhe2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfhe, zzfgt2);
            this.zzc.zzd();
            zzfgt = zzfgt2;
        }
        zzh = zzfgt.zzh(zzfhd);
        this.zzc.zzc();
        zzfgw zza2 = this.zzc.zza();
        zzfhr zzf = zzfgt.zzf();
        zzbbc.zzb.zzc zzd = zzbbc.zzb.zzd();
        zzbbc.zzb.zza.C0037zza zza3 = zzbbc.zzb.zza.zza();
        zza3.zzf(zzbbc.zzb.zzd.IN_MEMORY);
        zzbbc.zzb.zzg.zza zzc2 = zzbbc.zzb.zzg.zzc();
        zzc2.zze(zza2.zza);
        zzc2.zzf(zza2.zzb);
        zzc2.zzg(zzf.zzb);
        zza3.zzi(zzc2);
        zzd.zzd(zza3);
        zzfhd.zza.zzb().zzc().zzj((zzbbc.zzb) zzd.zzbr());
        zzf();
        return zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.zzb() >= r1.zzd) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzfhe r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r2.zza     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzfgt r3 = (com.google.android.gms.internal.ads.zzfgt) r3     // Catch:{ all -> 0x001c }
            r0 = 1
            if (r3 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzfhb r1 = r2.zzb     // Catch:{ all -> 0x001c }
            int r3 = r3.zzb()     // Catch:{ all -> 0x001c }
            int r1 = r1.zzd     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            if (r3 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            r3 = 0
            return r3
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgv.zze(com.google.android.gms.internal.ads.zzfhe):boolean");
    }
}
