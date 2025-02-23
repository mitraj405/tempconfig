package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdop extends zzcru {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdgx zze;
    private final zzddu zzf;
    private final zzcxd zzg;
    private final zzcyk zzh;
    private final zzcsp zzi;
    private final zzbwd zzj;
    private final zzfos zzk;
    private final zzfez zzl;
    private boolean zzm = false;

    public zzdop(zzcrt zzcrt, Context context, zzcej zzcej, zzdgx zzdgx, zzddu zzddu, zzcxd zzcxd, zzcyk zzcyk, zzcsp zzcsp, zzfel zzfel, zzfos zzfos, zzfez zzfez) {
        super(zzcrt);
        String str;
        int i;
        this.zzc = context;
        this.zze = zzdgx;
        this.zzd = new WeakReference(zzcej);
        this.zzf = zzddu;
        this.zzg = zzcxd;
        this.zzh = zzcyk;
        this.zzi = zzcsp;
        this.zzk = zzfos;
        zzbvz zzbvz = zzfel.zzl;
        if (zzbvz != null) {
            str = zzbvz.zza;
        } else {
            str = "";
        }
        if (zzbvz != null) {
            i = zzbvz.zzb;
        } else {
            i = 1;
        }
        this.zzj = new zzbwx(str, i);
        this.zzl = zzfez;
    }

    public final void finalize() throws Throwable {
        try {
            zzcej zzcej = (zzcej) this.zzd.get();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzga)).booleanValue()) {
                if (!this.zzm && zzcej != null) {
                    zzbzo.zze.execute(new zzdoo(zzcej));
                }
            } else if (zzcej != null) {
                zzcej.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwd zzc() {
        return this.zzj;
    }

    public final zzfez zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcej zzcej = (zzcej) this.zzd.get();
        if (zzcej == null || zzcej.zzaG()) {
            return false;
        }
        return true;
    }

    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzat)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzG(this.zzc)) {
                zzm.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzba.zzc().zza(zzbbw.zzau)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzm.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfgi.zzd(10, (String) null, (zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdgw e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
