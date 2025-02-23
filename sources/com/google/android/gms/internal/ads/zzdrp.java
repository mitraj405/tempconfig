package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import com.facebook.ads.AdSDKNotificationListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.hyper.constants.LogCategory;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdrp implements zzdbl, zza, zzcxk, zzcwu {
    private final Context zza;
    private final zzffy zzb;
    private final zzdsk zzc;
    private final zzfex zzd;
    private final zzfel zze;
    private final zzedh zzf;
    private final String zzg;
    private Boolean zzh;
    private final boolean zzi = ((Boolean) zzba.zzc().zza(zzbbw.zzgg)).booleanValue();

    public zzdrp(Context context, zzffy zzffy, zzdsk zzdsk, zzfex zzfex, zzfel zzfel, zzedh zzedh, String str) {
        this.zza = context;
        this.zzb = zzffy;
        this.zzc = zzdsk;
        this.zzd = zzfex;
        this.zze = zzfel;
        this.zzf = zzedh;
        this.zzg = str;
    }

    private final zzdsj zzd(String str) {
        String str2;
        zzdsj zza2 = this.zzc.zza();
        zza2.zzd(this.zzd.zzb.zzb);
        zza2.zzc(this.zze);
        zza2.zzb(LogCategory.ACTION, str);
        zza2.zzb(FirebaseAnalytics.Param.AD_FORMAT, this.zzg.toUpperCase(Locale.ROOT));
        boolean z = false;
        if (!this.zze.zzt.isEmpty()) {
            zza2.zzb("ancn", (String) this.zze.zzt.get(0));
        }
        if (this.zze.zzai) {
            if (true != zzu.zzo().zzA(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str2);
            zza2.zzb("event_timestamp", String.valueOf(zzu.zzB().currentTimeMillis()));
            zza2.zzb("offline_ad", C0515Ga.AVLBLTY_ONLY);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            if (zzq.zzf(this.zzd.zza.zza) != 1) {
                z = true;
            }
            zza2.zzb("scar", String.valueOf(z));
            if (z) {
                zzl zzl = this.zzd.zza.zza.zzd;
                zza2.zzb("ragent", zzl.zzp);
                zza2.zzb("rtype", zzq.zzb(zzq.zzc(zzl)));
            }
        }
        return zza2;
    }

    private final void zze(zzdsj zzdsj) {
        if (this.zze.zzai) {
            this.zzf.zzd(new zzedj(zzu.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdsj.zze(), 2));
            return;
        }
        zzdsj.zzf();
    }

    private final boolean zzf() {
        String str;
        if (this.zzh == null) {
            synchronized (this) {
                if (this.zzh == null) {
                    String str2 = (String) zzba.zzc().zza(zzbbw.zzbj);
                    zzu.zzp();
                    try {
                        str = zzt.zzp(this.zza);
                    } catch (RemoteException unused) {
                        str = null;
                    }
                    boolean z = false;
                    if (!(str2 == null || str == null)) {
                        try {
                            z = Pattern.matches(str2, str);
                        } catch (RuntimeException e) {
                            zzu.zzo().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzh = Boolean.valueOf(z);
                }
            }
        }
        return this.zzh.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzai) {
            zze(zzd("click"));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzi) {
            zzdsj zzd2 = zzd("ifts");
            zzd2.zzb("reason", "adapter");
            int i = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i = zze4.zza;
                str = zze4.zzb;
            }
            if (i >= 0) {
                zzd2.zzb("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzd2.zzb("areec", zza2);
            }
            zzd2.zzf();
        }
    }

    public final void zzb() {
        if (this.zzi) {
            zzdsj zzd2 = zzd("ifts");
            zzd2.zzb("reason", "blocked");
            zzd2.zzf();
        }
    }

    public final void zzc(zzdgw zzdgw) {
        if (this.zzi) {
            zzdsj zzd2 = zzd("ifts");
            zzd2.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgw.getMessage())) {
                zzd2.zzb("msg", zzdgw.getMessage());
            }
            zzd2.zzf();
        }
    }

    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzf();
        }
    }

    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzf();
        }
    }

    public final void zzr() {
        if (zzf() || this.zze.zzai) {
            zze(zzd(AdSDKNotificationListener.IMPRESSION_EVENT));
        }
    }
}
