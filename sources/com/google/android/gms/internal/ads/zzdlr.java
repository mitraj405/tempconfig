package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdlr {
    private final zzgcu zza;
    private final zzdme zzb;
    private final zzdmj zzc;

    public zzdlr(zzgcu zzgcu, zzdme zzdme, zzdmj zzdmj) {
        this.zza = zzgcu;
        this.zzb = zzdme;
        this.zzc = zzdmj;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel, JSONObject jSONObject) {
        ListenableFuture zzn;
        zzfex zzfex2 = zzfex;
        zzfel zzfel2 = zzfel;
        JSONObject jSONObject2 = jSONObject;
        ListenableFuture zzb2 = this.zza.zzb(new zzdlp(this, zzfex2, zzfel2, jSONObject2));
        ListenableFuture zzf = this.zzb.zzf(jSONObject2, "images");
        zzfeo zzfeo = zzfex2.zzb.zzb;
        zzdme zzdme = this.zzb;
        ListenableFuture zzg = zzdme.zzg(jSONObject2, "images", zzfel2, zzfeo);
        ListenableFuture zze = zzdme.zze(jSONObject2, "secondary_image");
        ListenableFuture zze2 = zzdme.zze(jSONObject2, "app_icon");
        ListenableFuture zzd = zzdme.zzd(jSONObject2, "attribution");
        ListenableFuture zzh = this.zzb.zzh(jSONObject2, zzfel2, zzfex2.zzb.zzb);
        ListenableFuture zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzn = zzgcj.zzh((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzgcj.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzgcj.zzh((Object) null);
                } else {
                    zzn = zzgcj.zzn(zzgcj.zzh((Object) null), new zzdlt(this.zzb, optString), zzbzo.zze);
                }
            }
        }
        ListenableFuture listenableFuture = zzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb2);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza2);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzgcj.zza(arrayList).zza(new zzdlq(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, listenableFuture, zza2), this.zza);
    }
}
