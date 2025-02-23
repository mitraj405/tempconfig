package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzfh;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzeic implements zzeet {
    private static Bundle zzd(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        return new Bundle(bundle);
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzfel zzfel2 = zzfel;
        String optString = zzfel2.zzv.optString("pubid", "");
        zzffg zzffg = zzfex.zza.zza;
        zzffe zzffe = new zzffe();
        zzffe.zzq(zzffg);
        zzffe.zzt(optString);
        Bundle zzd = zzd(zzffg.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfel2.zzv.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfel2.zzv.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfel2.zzD.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfel2.zzD.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzl zzl = zzffg.zzd;
        int i = zzl.zzd;
        List list = zzl.zze;
        boolean z = zzl.zzf;
        int i2 = zzl.zzg;
        boolean z2 = zzl.zzh;
        String str = zzl.zzi;
        zzfh zzfh = zzl.zzj;
        String str2 = zzl.zzx;
        int i3 = zzl.zza;
        Location location = zzl.zzk;
        int i4 = zzl.zzy;
        zzffe.zzH(new zzl(i3, zzl.zzb, zzd2, i, list, z, i2, z2, str, zzfh, location, zzl.zzl, zzd, zzl.zzn, zzl.zzo, zzl.zzp, zzl.zzq, zzl.zzr, zzl.zzs, zzl.zzt, zzl.zzu, zzl.zzv, zzl.zzw, str2, i4, zzl.zzz));
        zzffg zzJ = zzffe.zzJ();
        Bundle bundle = new Bundle();
        zzfex zzfex2 = zzfex;
        zzfeo zzfeo = zzfex2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzfeo.zza));
        bundle2.putInt("refresh_interval", zzfeo.zzc);
        bundle2.putString("gws_query_id", zzfeo.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        zzffg zzffg2 = zzfex2.zza.zza;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", zzffg2.zzf);
        zzfel zzfel3 = zzfel;
        bundle3.putString("allocation_id", zzfel3.zzw);
        bundle3.putString("ad_source_name", zzfel3.zzF);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzfel3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzfel3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzfel3.zzp));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzfel3.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzfel3.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzfel3.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzfel3.zzi));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzfel3.zzj);
        bundle3.putString("valid_from_timestamp", zzfel3.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzfel3.zzP);
        bundle3.putString("recursive_server_response_data", zzfel3.zzao);
        if (zzfel3.zzl != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzfel3.zzl.zzb);
            bundle4.putString("rb_type", zzfel3.zzl.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzJ, bundle, zzfel3, zzfex2);
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        if (!TextUtils.isEmpty(zzfel.zzv.optString("pubid", ""))) {
            return true;
        }
        return false;
    }

    public abstract ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex);
}
