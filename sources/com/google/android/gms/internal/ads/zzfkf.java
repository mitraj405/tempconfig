package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfkf implements Runnable {
    private final List zza = new ArrayList();
    private final zzfki zzb;
    private String zzc;
    private zzfkl zzd = zzfkl.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zze;
    private zzfew zzf;
    private zze zzg;
    private Future zzh;
    private int zzi = 2;

    public zzfkf(zzfki zzfki) {
        this.zzb = zzfki;
    }

    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfkf zza(zzfju zzfju) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzfju.zzj();
            list.add(zzfju);
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            this.zzh = zzbzo.zzd.schedule(this, (long) ((Integer) zzba.zzc().zza(zzbbw.zzhT)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzfkf zzb(String str) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue() && zzfke.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfkf zzc(zze zze2) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzg = zze2;
        }
        return this;
    }

    public final synchronized zzfkf zzd(ArrayList arrayList) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner")) {
                if (!arrayList.contains(AdFormat.BANNER.name())) {
                    if (!arrayList.contains("interstitial")) {
                        if (!arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                            if (!arrayList.contains("native")) {
                                if (!arrayList.contains(AdFormat.NATIVE.name())) {
                                    if (!arrayList.contains("rewarded")) {
                                        if (!arrayList.contains(AdFormat.REWARDED.name())) {
                                            if (arrayList.contains("app_open_ad")) {
                                                this.zzi = 7;
                                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                                this.zzi = 6;
                                            }
                                        }
                                    }
                                    this.zzi = 5;
                                }
                            }
                            this.zzi = 8;
                        }
                    }
                    this.zzi = 4;
                }
            }
            this.zzi = 3;
        }
        return this;
    }

    public final synchronized zzfkf zze(String str) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzfkf zzf(Bundle bundle) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzd = zzq.zza(bundle);
        }
        return this;
    }

    public final synchronized zzfkf zzg(zzfew zzfew) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzf = zzfew;
        }
        return this;
    }

    public final synchronized void zzh() {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            for (zzfju zzfju : this.zza) {
                int i = this.zzi;
                if (i != 2) {
                    zzfju.zzn(i);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzfju.zze(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zze) && !zzfju.zzl()) {
                    zzfju.zzd(this.zze);
                }
                zzfew zzfew = this.zzf;
                if (zzfew != null) {
                    zzfju.zzb(zzfew);
                } else {
                    zze zze2 = this.zzg;
                    if (zze2 != null) {
                        zzfju.zza(zze2);
                    }
                }
                zzfju.zzf(this.zzd);
                this.zzb.zzb(zzfju.zzm());
            }
            this.zza.clear();
        }
    }

    public final synchronized zzfkf zzi(int i) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
