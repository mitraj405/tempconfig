package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenr implements zzevn {
    final zzffg zza;
    private final long zzb;

    public zzenr(zzffg zzffg, long j) {
        Preconditions.checkNotNull(zzffg, "the targeting must not be null");
        this.zza = zzffg;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Bundle bundle = (Bundle) obj;
        zzl zzl = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzl.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        if (i != 0) {
            int i2 = i - 1;
            boolean z7 = true;
            if (i2 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i2 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzl.zzb));
            if (zzl.zzb != -1) {
                z = true;
            } else {
                z = false;
            }
            zzffu.zzf(bundle, "cust_age", format, z);
            zzffu.zzb(bundle, "extras", zzl.zzc);
            int i3 = zzl.zzd;
            if (i3 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzffu.zze(bundle, "cust_gender", i3, z2);
            zzffu.zzd(bundle, "kw", zzl.zze);
            int i4 = zzl.zzg;
            if (i4 != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzffu.zze(bundle, "tag_for_child_directed_treatment", i4, z3);
            if (zzl.zzf) {
                bundle.putBoolean("test_request", true);
            }
            bundle.putInt("ppt_p13n", zzl.zzy);
            if (zzl.zza < 2 || !zzl.zzh) {
                z4 = false;
            } else {
                z4 = true;
            }
            zzffu.zze(bundle, "d_imp_hdr", 1, z4);
            String str = zzl.zzi;
            if (zzl.zza < 2 || TextUtils.isEmpty(str)) {
                z5 = false;
            } else {
                z5 = true;
            }
            zzffu.zzf(bundle, "ppid", str, z5);
            Location location = zzl.zzk;
            if (location != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", location.getAccuracy() * 1000.0f);
                bundle2.putLong("lat", (long) (location.getLatitude() * 1.0E7d));
                bundle2.putLong("long", (long) (1.0E7d * location.getLongitude()));
                bundle2.putLong("time", location.getTime() * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzffu.zzc(bundle, "url", zzl.zzl);
            zzffu.zzd(bundle, "neighboring_content_urls", zzl.zzv);
            zzffu.zzb(bundle, "custom_targeting", zzl.zzn);
            zzffu.zzd(bundle, "category_exclusions", zzl.zzo);
            zzffu.zzc(bundle, "request_agent", zzl.zzp);
            zzffu.zzc(bundle, "request_pkg", zzl.zzq);
            boolean z8 = zzl.zzr;
            if (zzl.zza >= 7) {
                z6 = true;
            } else {
                z6 = false;
            }
            zzffu.zzg(bundle, "is_designed_for_families", z8, z6);
            if (zzl.zza >= 8) {
                int i5 = zzl.zzt;
                if (i5 == -1) {
                    z7 = false;
                }
                zzffu.zze(bundle, "tag_for_under_age_of_consent", i5, z7);
                zzffu.zzc(bundle, "max_ad_content_rating", zzl.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
