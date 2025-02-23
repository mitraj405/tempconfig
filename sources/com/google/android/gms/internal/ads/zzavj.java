package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzavj implements zzfqg {
    private final zzfoj zza;
    private final zzfpa zzb;
    private final zzavw zzc;
    private final zzavi zzd;
    private final zzaus zze;
    private final zzavy zzf;
    private final zzavq zzg;
    private final zzavh zzh;

    public zzavj(zzfoj zzfoj, zzfpa zzfpa, zzavw zzavw, zzavi zzavi, zzaus zzaus, zzavy zzavy, zzavq zzavq, zzavh zzavh) {
        this.zza = zzfoj;
        this.zzb = zzfpa;
        this.zzc = zzavw;
        this.zzd = zzavi;
        this.zze = zzaus;
        this.zzf = zzavy;
        this.zzg = zzavq;
        this.zzh = zzavh;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzfoj zzfoj = this.zza;
        zzasj zzb2 = this.zzb.zzb();
        hashMap.put("v", zzfoj.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzavq zzavq = this.zzg;
        if (zzavq != null) {
            hashMap.put("tcq", Long.valueOf(zzavq.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        zzavw zzavw = this.zzc;
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(zzavw.zza()));
        return zze2;
    }

    public final Map zzb() {
        Map zze2 = zze();
        zzasj zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze2.put("did", zza2.zzg());
        zze2.put("dst", Integer.valueOf(zza2.zzal() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzai()));
        zzaus zzaus = this.zze;
        if (zzaus != null) {
            zze2.put("nt", Long.valueOf(zzaus.zza()));
        }
        zzavy zzavy = this.zzf;
        if (zzavy != null) {
            zze2.put("vs", Long.valueOf(zzavy.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        zzavh zzavh = this.zzh;
        Map zze2 = zze();
        if (zzavh != null) {
            zze2.put("vst", zzavh.zza());
        }
        return zze2;
    }

    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
