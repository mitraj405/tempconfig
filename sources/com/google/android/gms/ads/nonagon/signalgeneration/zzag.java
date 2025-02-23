package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgcf;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzag implements zzgcf {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzbyq zzb;
    final /* synthetic */ zzbyj zzc;
    final /* synthetic */ zzfju zzd;
    final /* synthetic */ zzak zze;

    public zzag(zzak zzak, ListenableFuture listenableFuture, zzbyq zzbyq, zzbyj zzbyj, zzfju zzfju) {
        this.zza = listenableFuture;
        this.zzb = zzbyq;
        this.zzc = zzbyj;
        this.zzd = zzfju;
        this.zze = zzak;
    }

    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
            zzu.zzo().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            zzu.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfkf zzr = zzak.zzr(this.zza, this.zzb);
        if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
            zzfju zzfju = this.zzd;
            zzfju.zzh(th);
            zzfju.zzg(false);
            zzr.zza(zzfju);
            zzr.zzh();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzay zzay = (zzay) obj;
        zzfkf zzr = zzak.zzr(this.zza, this.zzb);
        this.zze.zzG.set(true);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzm.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                zzfju zzfju = this.zzd;
                zzfju.zzc("QueryInfo generation has been disabled.");
                zzfju.zzg(false);
                zzr.zza(zzfju);
                zzr.zzh();
            }
        } else if (zzay == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                this.zzd.zzg(true);
                if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (RemoteException e2) {
                zzfju zzfju2 = this.zzd;
                zzfju2.zzh(e2);
                zzfju2.zzg(false);
                zzm.zzh("", e2);
                zzu.zzo().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
                throw th;
            }
        } else {
            try {
                if (TextUtils.isEmpty(new JSONObject(zzay.zzb).optString("request_id", ""))) {
                    zzm.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzfju zzfju3 = this.zzd;
                    zzfju3.zzc("Request ID empty");
                    zzfju3.zzg(false);
                    if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                        zzr.zza(this.zzd);
                        zzr.zzh();
                        return;
                    }
                    return;
                }
                Bundle bundle = zzay.zzd;
                zzak zzak = this.zze;
                if (zzak.zzu && bundle != null && bundle.getInt(zzak.zzw, -1) == -1) {
                    zzak zzak2 = this.zze;
                    bundle.putInt(zzak2.zzw, zzak2.zzx.get());
                }
                zzak zzak3 = this.zze;
                if (zzak3.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(zzak3.zzv))) {
                    if (TextUtils.isEmpty(this.zze.zzz)) {
                        zzak zzak4 = this.zze;
                        zzt zzp = zzu.zzp();
                        zzak zzak5 = this.zze;
                        zzak4.zzz = zzp.zzc(zzak5.zzg, zzak5.zzy.afmaVersion);
                    }
                    zzak zzak6 = this.zze;
                    bundle.putString(zzak6.zzv, zzak6.zzz);
                }
                this.zzc.zzc(zzay.zza, zzay.zzb, bundle);
                this.zzd.zzg(true);
                if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (JSONException e3) {
                zzm.zzj("Failed to create JSON object from the request string.");
                zzbyj zzbyj = this.zzc;
                String obj2 = e3.toString();
                zzbyj.zzb("Internal error for request JSON: " + obj2);
                zzfju zzfju4 = this.zzd;
                zzfju4.zzh(e3);
                zzfju4.zzg(false);
                zzu.zzo().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            }
        }
    }
}
