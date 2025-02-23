package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdmw {
    private final zzffg zza;
    private final Executor zzb;
    private final zzdpl zzc;
    private final zzdog zzd;
    private final Context zze;
    private final zzdsk zzf;
    private final zzfll zzg;
    private final zzedh zzh;

    public zzdmw(zzffg zzffg, Executor executor, zzdpl zzdpl, Context context, zzdsk zzdsk, zzfll zzfll, zzedh zzedh, zzdog zzdog) {
        this.zza = zzffg;
        this.zzb = executor;
        this.zzc = zzdpl;
        this.zze = context;
        this.zzf = zzdsk;
        this.zzg = zzfll;
        this.zzh = zzedh;
        this.zzd = zzdog;
    }

    private final void zzh(zzcej zzcej) {
        zzj(zzcej);
        zzcej.zzag("/video", zzbiw.zzl);
        zzcej.zzag("/videoMeta", zzbiw.zzm);
        zzcej.zzag("/precache", new zzccw());
        zzcej.zzag("/delayPageLoaded", zzbiw.zzp);
        zzcej.zzag("/instrument", zzbiw.zzn);
        zzcej.zzag("/log", zzbiw.zzg);
        zzcej.zzag("/click", new zzbhv((zzdeq) null, (zzcni) null));
        if (this.zza.zzb != null) {
            zzcej.zzN().zzE(true);
            zzcej.zzag("/open", new zzbjj((zzb) null, (zzbrk) null, (zzedh) null, (zzdsk) null, (zzcni) null));
        } else {
            zzcej.zzN().zzE(false);
        }
        if (zzu.zzn().zzp(zzcej.getContext())) {
            Map hashMap = new HashMap();
            if (zzcej.zzD() != null) {
                hashMap = zzcej.zzD().zzaw;
            }
            zzcej.zzag("/logScionEvent", new zzbjd(zzcej.getContext(), hashMap));
        }
    }

    private final void zzi(zzcej zzcej, zzbzs zzbzs) {
        if (!(this.zza.zza == null || zzcej.zzq() == null)) {
            zzcej.zzq().zzs(this.zza.zza);
        }
        zzbzs.zzb();
    }

    private static final void zzj(zzcej zzcej) {
        zzcej.zzag("/videoClicked", zzbiw.zzh);
        zzcej.zzN().zzG(true);
        zzcej.zzag("/getNativeAdViewSignals", zzbiw.zzs);
        zzcej.zzag("/getNativeClickMeta", zzbiw.zzt);
    }

    public final ListenableFuture zza(JSONObject jSONObject) {
        return zzgcj.zzn(zzgcj.zzn(zzgcj.zzh((Object) null), new zzdmn(this), this.zzb), new zzdmm(this, jSONObject), this.zzb);
    }

    public final ListenableFuture zzb(String str, String str2, zzfel zzfel, zzfeo zzfeo, zzq zzq) {
        return zzgcj.zzn(zzgcj.zzh((Object) null), new zzdml(this, zzq, zzfel, zzfeo, str, str2), this.zzb);
    }

    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, zzcej zzcej) throws Exception {
        zzbzs zza2 = zzbzs.zza(zzcej);
        if (this.zza.zzb != null) {
            zzcej.zzaj(zzcgd.zzd());
        } else {
            zzcej.zzaj(zzcgd.zze());
        }
        zzcej.zzN().zzB(new zzdmo(this, zzcej, zza2));
        zzcej.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    public final /* synthetic */ ListenableFuture zzd(zzq zzq, zzfel zzfel, zzfeo zzfeo, String str, String str2, Object obj) throws Exception {
        zzcej zza2 = this.zzc.zza(zzq, zzfel, zzfeo);
        zzbzs zza3 = zzbzs.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzaj(zzcgd.zzd());
        } else {
            zzdod zzb2 = this.zzd.zzb();
            zzdod zzdod = zzb2;
            zzcgb zzN = zza2.zzN();
            zzb zzb3 = r14;
            zzb zzb4 = new zzb(this.zze, (zzbxl) null, (zzbue) null);
            zzN.zzR(zzb2, zzdod, zzb2, zzb2, zzb2, false, (zzbja) null, zzb3, (zzbrr) null, (zzbxl) null, this.zzh, this.zzg, this.zzf, (zzbjr) null, zzb2, (zzbjq) null, (zzbjk) null, (zzbiy) null, (zzcni) null);
            zzj(zza2);
        }
        zza2.zzN().zzB(new zzdmp(this, zza2, zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    public final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcej zza2 = this.zzc.zza(zzq.zzc(), (zzfel) null, (zzfeo) null);
        zzbzs zza3 = zzbzs.zza(zza2);
        zzh(zza2);
        zza2.zzN().zzH(new zzdmq(zza3));
        zza2.loadUrl((String) zzba.zzc().zza(zzbbw.zzds));
        return zza3;
    }

    public final /* synthetic */ void zzf(zzcej zzcej, zzbzs zzbzs, boolean z, int i, String str, String str2) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzdA)).booleanValue()) {
            zzi(zzcej, zzbzs);
        } else if (z) {
            zzi(zzcej, zzbzs);
        } else {
            zzbzs.zzd(new zzeir(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
        }
    }

    public final /* synthetic */ void zzg(zzcej zzcej, zzbzs zzbzs, boolean z, int i, String str, String str2) {
        if (z) {
            if (!(this.zza.zza == null || zzcej.zzq() == null)) {
                zzcej.zzq().zzs(this.zza.zza);
            }
            zzbzs.zzb();
            return;
        }
        zzbzs.zzd(new zzeir(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
