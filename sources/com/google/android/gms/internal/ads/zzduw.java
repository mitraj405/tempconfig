package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzduw implements zzcwt, zzczo, zzcyi {
    private final zzdvi zza;
    private final String zzb;
    private final String zzc;
    private int zzd;
    private zzduv zze;
    private zzcwj zzf;
    private zze zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    public zzduw(zzdvi zzdvi, zzffg zzffg, String str) {
        this.zza = zzdvi;
        this.zzc = str;
        this.zzb = zzffg.zzf;
        this.zzd = 0;
        this.zze = zzduv.AD_REQUESTED;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("errorDomain", zze2.zzc);
        jSONObject2.put("errorCode", zze2.zza);
        jSONObject2.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        if (zze3 == null) {
            jSONObject = null;
        } else {
            jSONObject = zzh(zze3);
        }
        jSONObject2.put("underlyingError", jSONObject);
        return jSONObject2;
    }

    private final JSONObject zzi(zzcwj zzcwj) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzcwj.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzcwj.zzc());
        jSONObject2.put("responseId", zzcwj.zzi());
        if (((Boolean) zzba.zzc().zza(zzbbw.zzir)).booleanValue()) {
            String zzd2 = zzcwj.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                zzm.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject2.put("adResponseBody", this.zzj);
        }
        JSONObject jSONObject3 = this.zzk;
        if (jSONObject3 != null) {
            jSONObject2.put("adResponseHeaders", jSONObject3);
        }
        JSONObject jSONObject4 = this.zzl;
        if (jSONObject4 != null) {
            jSONObject2.put("transactionExtras", jSONObject4);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zziu)).booleanValue()) {
            jSONObject2.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzu zzu : zzcwj.zzj()) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("adapterClassName", zzu.zza);
            jSONObject5.put("latencyMillis", zzu.zzb);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzis)).booleanValue()) {
                jSONObject5.put("credentials", zzay.zzb().zzi(zzu.zzd));
            }
            zze zze2 = zzu.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject5.put("error", jSONObject);
            jSONArray.put(jSONObject5);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zzcru zzcru) {
        if (this.zza.zzq()) {
            this.zzf = zzcru.zzm();
            this.zze = zzduv.AD_LOADED;
            if (((Boolean) zzba.zzc().zza(zzbbw.zziy)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteConfigConstants.ResponseFieldKey.STATE, this.zze);
        jSONObject2.put("format", zzfel.zza(this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbbw.zziy)).booleanValue()) {
            jSONObject2.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject2.put("shown", this.zzn);
            }
        }
        zzcwj zzcwj = this.zzf;
        if (zzcwj != null) {
            jSONObject = zzi(zzcwj);
        } else {
            zze zze2 = this.zzg;
            JSONObject jSONObject3 = null;
            if (!(zze2 == null || (iBinder = zze2.zze) == null)) {
                zzcwj zzcwj2 = (zzcwj) iBinder;
                jSONObject3 = zzi(zzcwj2);
                if (zzcwj2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObject3.put("errors", jSONArray);
                }
            }
            jSONObject = jSONObject3;
        }
        jSONObject2.put("responseInfo", jSONObject);
        return jSONObject2;
    }

    public final void zzdB(zze zze2) {
        if (this.zza.zzq()) {
            this.zze = zzduv.AD_LOAD_FAILED;
            this.zzg = zze2;
            if (((Boolean) zzba.zzc().zza(zzbbw.zziy)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final void zzdn(zzbvb zzbvb) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zziy)).booleanValue() && this.zza.zzq()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzdo(zzfex zzfex) {
        if (this.zza.zzq()) {
            int i = 0;
            if (!zzfex.zzb.zza.isEmpty()) {
                this.zzd = ((zzfel) zzfex.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzfex.zzb.zzb.zzl)) {
                this.zzh = zzfex.zzb.zzb.zzl;
            }
            if (!TextUtils.isEmpty(zzfex.zzb.zzb.zzm)) {
                this.zzi = zzfex.zzb.zzb.zzm;
            }
            if (zzfex.zzb.zzb.zzp.length() > 0) {
                this.zzl = zzfex.zzb.zzb.zzp;
            }
            if (!((Boolean) zzba.zzc().zza(zzbbw.zziu)).booleanValue()) {
                return;
            }
            if (!this.zza.zzs()) {
                this.zzo = true;
                return;
            }
            if (!TextUtils.isEmpty(zzfex.zzb.zzb.zzn)) {
                this.zzj = zzfex.zzb.zzb.zzn;
            }
            if (zzfex.zzb.zzb.zzo.length() > 0) {
                this.zzk = zzfex.zzb.zzb.zzo;
            }
            zzdvi zzdvi = this.zza;
            JSONObject jSONObject = this.zzk;
            if (jSONObject != null) {
                i = jSONObject.toString().length();
            }
            if (!TextUtils.isEmpty(this.zzj)) {
                i += this.zzj.length();
            }
            zzdvi.zzk((long) i);
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        if (this.zze != zzduv.AD_REQUESTED) {
            return true;
        }
        return false;
    }
}
