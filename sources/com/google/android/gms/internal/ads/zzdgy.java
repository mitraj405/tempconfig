package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdgy implements zzcye, zzp, zzcxk {
    zzeeo zza;
    private final Context zzb;
    private final zzcej zzc;
    private final zzfel zzd;
    private final VersionInfoParcel zze;
    private final zzbbc.zza.C0034zza zzf;
    private final zzeem zzg;

    public zzdgy(Context context, zzcej zzcej, zzfel zzfel, VersionInfoParcel versionInfoParcel, zzbbc.zza.C0034zza zza2, zzeem zzeem) {
        this.zzb = context;
        this.zzc = zzcej;
        this.zzd = zzfel;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
        this.zzg = zzeem;
    }

    private final boolean zzg() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() || !this.zzg.zzd()) {
            return false;
        }
        return true;
    }

    public final void zzdr() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeG)).booleanValue() && this.zzc != null) {
            if (this.zza == null && !zzg()) {
                return;
            }
            if (this.zza != null) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzg.zzb();
            }
        }
    }

    public final void zzdu(int i) {
        this.zza = null;
    }

    public final void zzr() {
        if (zzg()) {
            this.zzg.zzb();
        } else if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzeG)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzs() {
        zzeek zzeek;
        zzeel zzeel;
        zzeel zzeel2;
        zzbbc.zza.C0034zza zza2;
        if ((((Boolean) zzba.zzc().zza(zzbbw.zzeJ)).booleanValue() || (zza2 = this.zzf) == zzbbc.zza.C0034zza.REWARD_BASED_VIDEO_AD || zza2 == zzbbc.zza.C0034zza.INTERSTITIAL || zza2 == zzbbc.zza.C0034zza.APP_OPEN) && this.zzd.zzT && this.zzc != null) {
            if (!zzu.zzA().zzl(this.zzb)) {
                return;
            }
            if (zzg()) {
                this.zzg.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            zzffj zzffj = this.zzd.zzV;
            String zza3 = zzffj.zza();
            if (zzffj.zzc() == 1) {
                zzeek = zzeek.VIDEO;
                zzeel = zzeel.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzY == 2) {
                    zzeel2 = zzeel.UNSPECIFIED;
                } else {
                    zzeel2 = zzeel.BEGIN_TO_RENDER;
                }
                zzeel = zzeel2;
                zzeek = zzeek.HTML_DISPLAY;
            }
            zzeeo zza4 = zzu.zzA().zza(str, this.zzc.zzG(), "", "javascript", zza3, zzeel, zzeek, this.zzd.zzal);
            this.zza = zza4;
            zzcej zzcej = this.zzc;
            if (zza4 != null) {
                zzflq zza5 = zza4.zza();
                if (((Boolean) zzba.zzc().zza(zzbbw.zzeB)).booleanValue()) {
                    zzu.zzA().zzj(zza5, this.zzc.zzG());
                    for (View zzg2 : this.zzc.zzV()) {
                        zzu.zzA().zzg(zza5, zzg2);
                    }
                } else {
                    zzu.zzA().zzj(zza5, (View) zzcej);
                }
                this.zzc.zzat(this.zza);
                zzu.zzA().zzk(zza5);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final void zzdt() {
    }
}
