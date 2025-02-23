package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzady implements zzadi {
    final /* synthetic */ zzaeb zza;
    private final long zzb;

    public zzady(zzaeb zzaeb, long j) {
        this.zza = zzaeb;
        this.zzb = j;
    }

    public final long zza() {
        return this.zzb;
    }

    public final zzadg zzg(long j) {
        zzadg zza2 = this.zza.zzi[0].zza(j);
        int i = 1;
        while (true) {
            zzaeb zzaeb = this.zza;
            if (i >= zzaeb.zzi.length) {
                return zza2;
            }
            zzadg zza3 = zzaeb.zzi[i].zza(j);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
