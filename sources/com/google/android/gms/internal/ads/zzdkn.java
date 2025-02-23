package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdkn {
    private final zzdpl zza;
    private final zzdoa zzb;
    private final zzcop zzc;
    private final zzdjj zzd;

    public zzdkn(zzdpl zzdpl, zzdoa zzdoa, zzcop zzcop, zzdjj zzdjj) {
        this.zza = zzdpl;
        this.zzb = zzdoa;
        this.zzc = zzcop;
        this.zzd = zzdjj;
    }

    public final View zza() throws zzcev {
        zzcej zza2 = this.zza.zza(zzq.zzc(), (zzfel) null, (zzfeo) null);
        ((View) zza2).setVisibility(8);
        zza2.zzag("/sendMessageToSdk", new zzdki(this));
        zza2.zzag("/adMuted", new zzdkj(this));
        this.zzb.zzm(new WeakReference(zza2), "/loadHtml", new zzdkk(this));
        this.zzb.zzm(new WeakReference(zza2), "/showOverlay", new zzdkl(this));
        this.zzb.zzm(new WeakReference(zza2), "/hideOverlay", new zzdkm(this));
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(zzcej zzcej, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(zzcej zzcej, Map map) {
        this.zzd.zzg();
    }

    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put(FacebookMediationAdapter.KEY_ID, (String) map.get(FacebookMediationAdapter.KEY_ID));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    public final /* synthetic */ void zze(zzcej zzcej, Map map) {
        zzm.zzi("Showing native ads overlay.");
        zzcej.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    public final /* synthetic */ void zzf(zzcej zzcej, Map map) {
        zzm.zzi("Hiding native ads overlay.");
        zzcej.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
