package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaam {
    private final zzaah zza;
    private final zzaaf zzb = new zzaaf();
    private final zzeq zzc = new zzeq(10);
    private final zzeq zzd = new zzeq(10);
    private final zzec zze = new zzec(16);
    private zzcp zzf;
    private zzcp zzg = zzcp.zza;
    private long zzh;
    private long zzi = -9223372036854775807L;
    private final zzzi zzj;

    public zzaam(zzzi zzzi, zzaah zzaah) {
        this.zzj = zzzi;
        this.zza = zzaah;
    }

    private static Object zzf(zzeq zzeq) {
        boolean z;
        if (zzeq.zza() > 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        while (zzeq.zza() > 1) {
            zzeq.zzb();
        }
        Object zzb2 = zzeq.zzb();
        zzb2.getClass();
        return zzb2;
    }

    public final void zza() {
        this.zze.zzc();
        this.zzi = -9223372036854775807L;
        zzeq zzeq = this.zzd;
        if (zzeq.zza() > 0) {
            this.zzd.zzd(0, Long.valueOf(((Long) zzf(zzeq)).longValue()));
        }
        if (this.zzf == null) {
            zzeq zzeq2 = this.zzc;
            if (zzeq2.zza() > 0) {
                this.zzf = (zzcp) zzf(zzeq2);
                return;
            }
            return;
        }
        this.zzc.zze();
    }

    public final void zzb(long j, long j2) {
        this.zzd.zzd(j, Long.valueOf(j2));
    }

    public final void zzc(long j, long j2) throws zzhw {
        zzaf zzaf;
        zzec zzec = this.zze;
        if (!zzec.zzd()) {
            zzeq zzeq = this.zzd;
            long zza2 = zzec.zza();
            Long l = (Long) zzeq.zzc(zza2);
            if (!(l == null || l.longValue() == this.zzh)) {
                this.zzh = l.longValue();
                this.zza.zzf();
            }
            int zza3 = this.zza.zza(zza2, j, j2, this.zzh, false, this.zzb);
            if (zza3 == 0 || zza3 == 1) {
                this.zzi = zza2;
                long longValue = Long.valueOf(this.zze.zzb()).longValue();
                zzcp zzcp = (zzcp) this.zzc.zzc(longValue);
                if (zzcp != null && !zzcp.equals(zzcp.zza) && !zzcp.equals(this.zzg)) {
                    this.zzg = zzcp;
                    zzzi zzzi = this.zzj;
                    zzad zzad = new zzad();
                    zzad.zzac(zzcp.zzb);
                    zzad.zzI(zzcp.zzc);
                    zzad.zzX("video/raw");
                    zzzi.zza.zzi = zzad.zzad();
                    Iterator it = zzzi.zza.zzg.iterator();
                    while (it.hasNext()) {
                        ((zzzj) it.next()).zzc(zzzi.zza, zzcp);
                    }
                }
                zzzi zzzi2 = this.zzj;
                long j3 = this.zzh;
                if (this.zza.zzo()) {
                    zzzt zzzt = zzzi2.zza;
                    if (zzzt.zzl != null) {
                        Iterator it2 = zzzt.zzg.iterator();
                        while (it2.hasNext()) {
                            ((zzzj) it2.next()).zza(zzzi2.zza);
                        }
                    }
                }
                zzzt zzzt2 = zzzi2.zza;
                if (zzzt2.zzj != null) {
                    if (zzzt2.zzi == null) {
                        zzaf = new zzad().zzad();
                    } else {
                        zzaf = zzzt2.zzi;
                    }
                    zzzt zzzt3 = zzzi2.zza;
                    zzaae zzf2 = zzzt3.zzj;
                    zzdi.zzb(zzzt3.zzh);
                    zzf2.zza(longValue - j3, System.nanoTime(), zzaf, (MediaFormat) null);
                }
                zzdi.zzb((Object) null);
                throw null;
            } else if (zza3 == 2 || zza3 == 3 || zza3 == 4) {
                this.zzi = zza2;
                this.zze.zzb();
                zzzi zzzi3 = this.zzj;
                Iterator it3 = zzzi3.zza.zzg.iterator();
                while (it3.hasNext()) {
                    ((zzzj) it3.next()).zzb(zzzi3.zza);
                }
                zzdi.zzb((Object) null);
                throw null;
            }
        }
    }

    public final void zzd(float f) {
        boolean z;
        if (f > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        this.zza.zzm(f);
    }

    public final boolean zze(long j) {
        long j2 = this.zzi;
        if (j2 == -9223372036854775807L || j2 < j) {
            return false;
        }
        return true;
    }
}
