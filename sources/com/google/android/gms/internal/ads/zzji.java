package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzji implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzaay, zzpe, zzwl, zztg, zzhk, zzhg {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzjm zza;

    public /* synthetic */ zzji(zzjm zzjm, zzjh zzjh) {
        this.zza = zzjm;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzjm.zzK(this.zza, surfaceTexture);
        this.zza.zzaa(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzad((Object) null);
        this.zza.zzaa(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzaa(i, i2);
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzaa(i2, i3);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaa(0, 0);
    }

    public final void zza(Exception exc) {
        this.zza.zzq.zzv(exc);
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.zzq.zzw(str, j, j2);
    }

    public final void zzc(String str) {
        this.zza.zzq.zzx(str);
    }

    public final void zzd(zzhn zzhn) {
        this.zza.zzq.zzy(zzhn);
    }

    public final void zze(zzhn zzhn) {
        this.zza.zzq.zzz(zzhn);
    }

    public final void zzf(zzaf zzaf, zzho zzho) {
        this.zza.zzq.zzA(zzaf, zzho);
    }

    public final void zzg(long j) {
        this.zza.zzq.zzB(j);
    }

    public final void zzh(Exception exc) {
        this.zza.zzq.zzC(exc);
    }

    public final void zzi(zzpf zzpf) {
        this.zza.zzq.zzD(zzpf);
    }

    public final void zzj(zzpf zzpf) {
        this.zza.zzq.zzE(zzpf);
    }

    public final void zzk(int i, long j, long j2) {
        this.zza.zzq.zzF(i, j, j2);
    }

    public final void zzl(int i, long j) {
        this.zza.zzq.zzG(i, j);
    }

    public final void zzm(Object obj, long j) {
        this.zza.zzq.zzH(obj, j);
        zzjm zzjm = this.zza;
        if (zzjm.zzG == obj) {
            zzdz zzD = zzjm.zzl;
            zzD.zzd(26, new zzjg());
            zzD.zzc();
        }
    }

    public final void zzn(boolean z) {
        zzjm zzjm = this.zza;
        if (zzjm.zzN != z) {
            zzjm.zzN = z;
            zzdz zzD = this.zza.zzl;
            zzD.zzd(23, new zzje(z));
            zzD.zzc();
        }
    }

    public final void zzo(Exception exc) {
        this.zza.zzq.zzI(exc);
    }

    public final void zzp(String str, long j, long j2) {
        this.zza.zzq.zzJ(str, j, j2);
    }

    public final void zzq(String str) {
        this.zza.zzq.zzK(str);
    }

    public final void zzr(zzhn zzhn) {
        this.zza.zzq.zzL(zzhn);
    }

    public final void zzs(zzhn zzhn) {
        this.zza.zzq.zzM(zzhn);
    }

    public final void zzt(long j, int i) {
        this.zza.zzq.zzN(j, i);
    }

    public final void zzu(zzaf zzaf, zzho zzho) {
        this.zza.zzq.zzO(zzaf, zzho);
    }

    public final void zzv(zzcp zzcp) {
        zzdz zzD = this.zza.zzl;
        zzD.zzd(25, new zzjf(zzcp));
        zzD.zzc();
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }
}
