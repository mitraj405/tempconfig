package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehn implements zzehh {
    private final zzdhl zza;
    private final zzgcu zzb;
    private final zzdlr zzc;
    private final zzfgf zzd;
    private final zzdog zze;

    public zzehn(zzdhl zzdhl, zzgcu zzgcu, zzdlr zzdlr, zzfgf zzfgf, zzdog zzdog) {
        this.zza = zzdhl;
        this.zzb = zzgcu;
        this.zzc = zzdlr;
        this.zzd = zzfgf;
        this.zze = zzdog;
    }

    private final ListenableFuture zzg(zzfex zzfex, zzfel zzfel, JSONObject jSONObject) {
        zzdlr zzdlr = this.zzc;
        ListenableFuture zza2 = this.zzd.zza();
        ListenableFuture zza3 = zzdlr.zza(zzfex, zzfel, jSONObject);
        return zzgcj.zzc(zza2, zza3).zza(new zzehi(this, zza3, zza2, zzfex, zzfel, jSONObject), this.zzb);
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        return zzgcj.zzn(zzgcj.zzn(this.zzd.zza(), new zzehk(this, zzfel), this.zzb), new zzehl(this, zzfex, zzfel), this.zzb);
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        zzfeq zzfeq = zzfel.zzs;
        if (zzfeq == null || zzfeq.zzc == null) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ zzdiw zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfex zzfex, zzfel zzfel, JSONObject jSONObject) throws Exception {
        zzdjb zzdjb = (zzdjb) listenableFuture.get();
        zzdoa zzdoa = (zzdoa) listenableFuture2.get();
        zzdjc zzd2 = this.zza.zzd(new zzcsk(zzfex, zzfel, (String) null), new zzdjn(zzdjb), new zzdia(jSONObject, zzdoa));
        zzd2.zzh().zzb();
        zzd2.zzi().zza(zzdoa);
        zzd2.zzg().zza(zzdjb.zzs());
        zzd2.zzl().zza(this.zze, zzdjb.zzq());
        return zzd2.zza();
    }

    public final /* synthetic */ ListenableFuture zzd(zzdoa zzdoa, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgcj.zzh(zzdoa));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzgcj.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbnd("process json failed");
    }

    public final /* synthetic */ ListenableFuture zze(zzfel zzfel, zzdoa zzdoa) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhN)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfel.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgcj.zzn(zzdoa.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzehj(this, zzdoa), this.zzb);
    }

    public final /* synthetic */ ListenableFuture zzf(zzfex zzfex, zzfel zzfel, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgcj.zzg(new zzdwl(3));
        }
        if (zzfex.zza.zza.zzk <= 1) {
            return zzgcj.zzm(zzg(zzfex, zzfel, jSONArray.getJSONObject(0)), new zzehm(), this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfex.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfex.zza.zza.zzk);
        for (int i = 0; i < zzfex.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfex, zzfel, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzgcj.zzg(new zzdwl(3)));
            }
        }
        return zzgcj.zzh(arrayList);
    }
}
