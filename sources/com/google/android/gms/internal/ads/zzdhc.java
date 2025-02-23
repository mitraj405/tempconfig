package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdhc implements zzcwq, zzddv {
    private final zzbxw zza;
    private final Context zzb;
    private final zzbya zzc;
    private final View zzd;
    private String zze;
    private final zzbbc.zza.C0034zza zzf;

    public zzdhc(zzbxw zzbxw, Context context, zzbya zzbya, View view, zzbbc.zza.C0034zza zza2) {
        this.zza = zzbxw;
        this.zzb = context;
        this.zzc = zzbya;
        this.zzd = view;
        this.zzf = zza2;
    }

    public final void zza() {
        this.zza.zzb(false);
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzbya zzbya = this.zzc;
                Context context = this.zzb;
                zzbya.zzl(context, zzbya.zza(context), this.zza.zza(), zzbvn.zzc(), zzbvn.zzb());
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zzl() {
        String str;
        if (this.zzf != zzbbc.zza.C0034zza.APP_OPEN) {
            String zzc2 = this.zzc.zzc(this.zzb);
            this.zze = zzc2;
            zzbbc.zza.C0034zza zza2 = this.zzf;
            String valueOf = String.valueOf(zzc2);
            if (zza2 == zzbbc.zza.C0034zza.REWARD_BASED_VIDEO_AD) {
                str = "/Rewarded";
            } else {
                str = "/Interstitial";
            }
            this.zze = valueOf.concat(str);
        }
    }

    public final void zzb() {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzk() {
    }
}
