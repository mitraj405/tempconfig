package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzane {
    private final zzamf zza;
    private final zzer zzb;
    private final zzej zzc = new zzej(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzane(zzamf zzamf, zzer zzer) {
        this.zza = zzamf;
        this.zzb = zzer;
    }

    public final void zza(zzek zzek) throws zzbo {
        long j;
        long j2;
        zzek zzek2 = zzek;
        zzek2.zzG(this.zzc.zza, 0, 3);
        this.zzc.zzl(0);
        this.zzc.zzn(8);
        this.zzd = this.zzc.zzp();
        this.zze = this.zzc.zzp();
        this.zzc.zzn(6);
        zzej zzej = this.zzc;
        zzek2.zzG(zzej.zza, 0, zzej.zzd(8));
        this.zzc.zzl(0);
        if (this.zzd) {
            this.zzc.zzn(4);
            long zzd2 = (long) this.zzc.zzd(3);
            this.zzc.zzn(1);
            int zzd3 = this.zzc.zzd(15) << 15;
            this.zzc.zzn(1);
            long zzd4 = (long) this.zzc.zzd(15);
            this.zzc.zzn(1);
            if (this.zzf || !this.zze) {
                j2 = zzd2;
            } else {
                this.zzc.zzn(4);
                this.zzc.zzn(1);
                this.zzc.zzn(1);
                j2 = zzd2;
                this.zzc.zzn(1);
                this.zzb.zzb(((long) (this.zzc.zzd(15) << 15)) | (((long) this.zzc.zzd(3)) << 30) | ((long) this.zzc.zzd(15)));
                this.zzf = true;
            }
            j = this.zzb.zzb((j2 << 30) | ((long) zzd3) | zzd4);
        } else {
            j = 0;
        }
        this.zza.zzd(j, 4);
        this.zza.zza(zzek2);
        this.zza.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
