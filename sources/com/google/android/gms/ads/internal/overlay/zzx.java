package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzfsy;
import com.google.android.gms.internal.ads.zzfsz;
import com.google.android.gms.internal.ads.zzfta;
import com.google.android.gms.internal.ads.zzftb;
import com.google.android.gms.internal.ads.zzftk;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftn;
import com.google.android.gms.internal.ads.zzfto;
import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzfuc;
import in.juspay.hyper.constants.LogCategory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzx {
    private String zza = null;
    private String zzb = null;
    private zzcej zzc = null;
    private zzfta zzd = null;
    private boolean zze = false;
    private zzftn zzf;

    private final zzftp zzl() {
        zzfto zzc2 = zzftp.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzw(this);
        }
    }

    public final synchronized void zza(zzcej zzcej, Context context) {
        this.zzc = zzcej;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(LogCategory.ACTION, "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzfta zzfta;
        if (!this.zze || (zzfta = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfta.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzc() {
        zzfta zzfta;
        if (!this.zze || (zzfta = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfsy zzc2 = zzfsz.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzfta.zzb(zzc2.zzc(), this.zzf);
    }

    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    public final void zze(String str, Map map) {
        zzbzo.zze.execute(new zzv(this, str, map));
    }

    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put(LogCategory.ACTION, str2);
            zze("onError", hashMap);
        }
    }

    public final void zzg() {
        zzfta zzfta;
        if (!this.zze || (zzfta = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfta.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }

    public final /* synthetic */ void zzh(String str, Map map) {
        zzcej zzcej = this.zzc;
        if (zzcej != null) {
            zzcej.zzd(str, map);
        }
    }

    public final void zzi(zzftm zzftm) {
        if (!TextUtils.isEmpty(zzftm.zzb())) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue()) {
                this.zza = zzftm.zzb();
            }
        }
        switch (zzftm.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put("error", String.valueOf(zzftm.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzcej zzcej, zzftk zzftk) {
        if (zzcej == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcej;
        if (this.zze || zzk(zzcej.getContext())) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue()) {
                this.zzb = zzftk.zzh();
            }
            zzm();
            zzfta zzfta = this.zzd;
            if (zzfta != null) {
                zzfta.zzd(zzftk, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfuc.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzftb.zza(context);
        } catch (NullPointerException e) {
            zze.zza("Error connecting LMD Overlay service");
            zzu.zzo().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
