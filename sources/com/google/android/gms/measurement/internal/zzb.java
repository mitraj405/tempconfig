package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzb extends zzf {
    private final Map<String, Long> zza = new ArrayMap();
    private final Map<String, Integer> zzb = new ArrayMap();
    private long zzc;

    public zzb(zzhj zzhj) {
        super(zzhj);
    }

    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzax zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfq zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzfp zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzfr zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzgh zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzhc zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zziv zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzks zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzmh zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zznp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public static /* synthetic */ void zzb(zzb zzb2, String str, long j) {
        zzb2.zzt();
        Preconditions.checkNotEmpty(str);
        Integer num = zzb2.zzb.get(str);
        if (num != null) {
            zzkp zza2 = zzb2.zzn().zza(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzb2.zzb.remove(str);
                Long l = zzb2.zza.get(str);
                if (l == null) {
                    zzb2.zzj().zzg().zza("First ad unit exposure time was never set");
                } else {
                    zzb2.zza.remove(str);
                    zzb2.zza(str, j - l.longValue(), zza2);
                }
                if (zzb2.zzb.isEmpty()) {
                    long j2 = zzb2.zzc;
                    if (j2 == 0) {
                        zzb2.zzj().zzg().zza("First ad exposure time was never set");
                        return;
                    }
                    zzb2.zza(j - j2, zza2);
                    zzb2.zzc = 0;
                    return;
                }
                return;
            }
            zzb2.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzb2.zzj().zzg().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static /* synthetic */ void zza(zzb zzb2, String str, long j) {
        zzb2.zzt();
        Preconditions.checkNotEmpty(str);
        if (zzb2.zzb.isEmpty()) {
            zzb2.zzc = j;
        }
        Integer num = zzb2.zzb.get(str);
        if (num != null) {
            zzb2.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzb2.zzb.size() >= 100) {
            zzb2.zzj().zzu().zza("Too many ads visible");
        } else {
            zzb2.zzb.put(str, 1);
            zzb2.zza.put(str, Long.valueOf(j));
        }
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb((Runnable) new zza(this, str, j));
        }
    }

    private final void zza(long j, zzkp zzkp) {
        if (zzkp == null) {
            zzj().zzp().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzj().zzp().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zznp.zza(zzkp, bundle, true);
            zzm().zzc("am", "_xa", bundle);
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb((Runnable) new zzd(this, str, j));
        }
    }

    private final void zza(String str, long j, zzkp zzkp) {
        if (zzkp == null) {
            zzj().zzp().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzj().zzp().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zznp.zza(zzkp, bundle, true);
            zzm().zzc("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }

    public final void zza(long j) {
        zzkp zza2 = zzn().zza(false);
        for (String next : this.zza.keySet()) {
            zza(next, j - this.zza.get(next).longValue(), zza2);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zza2);
        }
        zzb(j);
    }
}
