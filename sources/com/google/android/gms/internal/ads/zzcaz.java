package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcaz {
    private final Context zza;
    private final zzcbk zzb;
    private final ViewGroup zzc;
    private zzcay zzd;

    public zzcaz(Context context, ViewGroup viewGroup, zzcej zzcej) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcej;
        this.zzd = null;
    }

    public final zzcay zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcay zzcay = this.zzd;
        if (zzcay != null) {
            return zzcay.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcay zzcay = this.zzd;
        if (zzcay != null) {
            zzcay.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcbj zzcbj) {
        if (this.zzd == null) {
            zzbcd.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
            Context context = this.zza;
            zzcbk zzcbk = this.zzb;
            zzcay zzcay = new zzcay(context, zzcbk, i5, z, zzcbk.zzm().zza(), zzcbj);
            this.zzd = zzcay;
            this.zzc.addView(zzcay, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzd.zzF(i, i2, i3, i4);
            this.zzb.zzz(false);
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcay zzcay = this.zzd;
        if (zzcay != null) {
            zzcay.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcay zzcay = this.zzd;
        if (zzcay != null) {
            zzcay.zzu();
        }
    }

    public final void zzg(int i) {
        zzcay zzcay = this.zzd;
        if (zzcay != null) {
            zzcay.zzC(i);
        }
    }
}
