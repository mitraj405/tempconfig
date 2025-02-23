package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzekh extends zzbor {
    private final zzcwo zza;
    private final zzdeo zzb;
    private final zzcxi zzc;
    private final zzcxx zzd;
    private final zzcyc zze;
    private final zzdbn zzf;
    private final zzcyw zzg;
    private final zzdfl zzh;
    private final zzdbj zzi;
    private final zzcxd zzj;

    public zzekh(zzcwo zzcwo, zzdeo zzdeo, zzcxi zzcxi, zzcxx zzcxx, zzcyc zzcyc, zzdbn zzdbn, zzcyw zzcyw, zzdfl zzdfl, zzdbj zzdbj, zzcxd zzcxd) {
        this.zza = zzcwo;
        this.zzb = zzdeo;
        this.zzc = zzcxi;
        this.zzd = zzcxx;
        this.zze = zzcyc;
        this.zzf = zzdbn;
        this.zzg = zzcyw;
        this.zzh = zzdfl;
        this.zzi = zzdbj;
        this.zzj = zzcxd;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdG();
    }

    public final void zzf() {
        this.zzg.zzdu(4);
    }

    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new zze(i, "", AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzfgi.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzs();
    }

    public final void zzp() {
        this.zzg.zzdr();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }

    public void zzu() throws RemoteException {
    }

    public final void zzg(int i) {
    }

    public final void zzh(zze zze2) {
    }

    public void zzs(zzbvz zzbvz) {
    }

    public void zzt(zzbwd zzbwd) throws RemoteException {
    }

    public final void zzi(int i, String str) {
    }

    public final void zzr(zzbfx zzbfx, String str) {
    }
}
