package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzejg extends zzekh {
    private final zzdez zza;

    public zzejg(zzcwo zzcwo, zzdeo zzdeo, zzcxi zzcxi, zzcxx zzcxx, zzcyc zzcyc, zzcxd zzcxd, zzdbn zzdbn, zzdfl zzdfl, zzcyw zzcyw, zzdez zzdez, zzdbj zzdbj) {
        super(zzcwo, zzdeo, zzcxi, zzcxx, zzcyc, zzdbn, zzcyw, zzdfl, zzdbj, zzcxd);
        this.zza = zzdez;
    }

    public final void zzs(zzbvz zzbvz) {
        this.zza.zza(zzbvz);
    }

    public final void zzt(zzbwd zzbwd) throws RemoteException {
        this.zza.zza(new zzbvz(zzbwd.zzf(), zzbwd.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
