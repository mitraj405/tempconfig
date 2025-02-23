package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdof {
    private final zzcwo zza;
    private final zzcxx zzb;
    private final zzcyk zzc;
    private final zzcyw zzd;
    private final zzdbn zze;
    private final zzdeo zzf;
    private final zzdsk zzg;
    private final zzfll zzh;
    private final zzedh zzi;
    private final zzcni zzj;

    public zzdof(zzcwo zzcwo, zzcxx zzcxx, zzcyk zzcyk, zzcyw zzcyw, zzdbn zzdbn, zzdeo zzdeo, zzdsk zzdsk, zzfll zzfll, zzedh zzedh, zzcni zzcni) {
        this.zza = zzcwo;
        this.zzb = zzcxx;
        this.zzc = zzcyk;
        this.zzd = zzcyw;
        this.zze = zzdbn;
        this.zzf = zzdeo;
        this.zzg = zzdsk;
        this.zzh = zzfll;
        this.zzi = zzedh;
        this.zzj = zzcni;
    }

    public final void zza(zzdog zzdog, zzcej zzcej) {
        zzdod zza2 = zzdog.zza;
        zzcxx zzcxx = this.zzb;
        Objects.requireNonNull(zzcxx);
        zza2.zzi(this.zza, this.zzc, this.zzd, this.zze, new zzdoe(zzcxx), this.zzf);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjm)).booleanValue() && zzcej != null && zzcej.zzN() != null) {
            zzcgb zzN = zzcej.zzN();
            zzN.zzI(this.zzj, this.zzi, this.zzh);
            zzN.zzK(this.zzj, this.zzi, this.zzg);
        }
    }
}
