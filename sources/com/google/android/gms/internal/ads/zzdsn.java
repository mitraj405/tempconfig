package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdsn implements zzfjm {
    private final Map zza = new HashMap();
    private final zzdsf zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzdsn(zzdsf zzdsf, Set set, Clock clock) {
        this.zzb = zzdsf;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdsm zzdsm = (zzdsm) it.next();
            this.zzd.put(zzdsm.zzc, zzdsm);
        }
        this.zzc = clock;
    }

    private final void zze(zzfjf zzfjf, boolean z) {
        String str;
        zzfjf zzb2 = ((zzdsm) this.zzd.get(zzfjf)).zzb;
        if (this.zza.containsKey(zzb2)) {
            if (true != z) {
                str = "f.";
            } else {
                str = "s.";
            }
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue();
            zzdsf zzdsf = this.zzb;
            Map map = this.zzd;
            zzdsf.zzb().put("label.".concat(((zzdsm) map.get(zzfjf)).zza), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    public final void zzd(zzfjf zzfjf, String str) {
        if (this.zza.containsKey(zzfjf)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfjf)).longValue();
            zzdsf zzdsf = this.zzb;
            String valueOf = String.valueOf(str);
            zzdsf.zzb().put("task.".concat(valueOf), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjf)) {
            zze(zzfjf, true);
        }
    }

    public final void zzdD(zzfjf zzfjf, String str, Throwable th) {
        if (this.zza.containsKey(zzfjf)) {
            Clock clock = this.zzc;
            Map map = this.zza;
            zzdsf zzdsf = this.zzb;
            String valueOf = String.valueOf(str);
            zzdsf.zzb().put("task.".concat(valueOf), "f.".concat(String.valueOf(Long.toString(clock.elapsedRealtime() - ((Long) map.get(zzfjf)).longValue()))));
        }
        if (this.zzd.containsKey(zzfjf)) {
            zze(zzfjf, false);
        }
    }

    public final void zzdE(zzfjf zzfjf, String str) {
        this.zza.put(zzfjf, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    public final void zzdC(zzfjf zzfjf, String str) {
    }
}
