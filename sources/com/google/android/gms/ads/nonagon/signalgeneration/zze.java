package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zze {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdsp zzd;
    private final ExecutorService zze;

    public zze(Context context, zzdsp zzdsp, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdsp;
        this.zze = executorService;
    }

    private final void zzh(boolean z) {
        Map map = this.zzb;
        Boolean valueOf = Boolean.valueOf(z);
        if (!map.containsKey(valueOf)) {
            this.zzb.put(valueOf, new ArrayList());
            this.zze.submit(new zzc(this, z));
        }
    }

    private final void zzi(zzg zzg, Pair pair, boolean z) {
        zzg.zzd();
        QueryInfo zzb2 = zzg.zzb();
        if (zzb2 != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(zzb2);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzg.zzc());
        }
        zzdsp zzdsp = this.zzd;
        Pair[] pairArr = new Pair[7];
        boolean z2 = false;
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzu.zzB().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        if (zzg.zzb() != null) {
            z2 = true;
        }
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(z2));
        zzq.zzd(zzdsp, (zzdsf) null, "sgpcr", pairArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final synchronized void zzd(boolean z, boolean z2) {
        Boolean valueOf;
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        bundle.putBoolean("accept_3p_cookie", z);
        Map map = this.zza;
        Boolean valueOf2 = Boolean.valueOf(z);
        zzg zzg = (zzg) map.get(valueOf2);
        int i = 0;
        if (z2) {
            if (zzg != null) {
                i = zzg.zza() + 1;
            }
        }
        int i2 = i;
        zzg zzg2 = (zzg) this.zza.get(valueOf2);
        if (zzg2 == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(zzg2.zzf());
        }
        zzf zzf = new zzf(this, z, i2, valueOf, this.zzd);
        AdRequest build = ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkg)).booleanValue()) {
            this.zze.submit(new zzd(this, build, zzf));
        } else {
            QueryInfo.generate(this.zzc, AdFormat.BANNER, build, zzf);
        }
    }

    public final /* synthetic */ Object zza(AdRequest adRequest, zzf zzf) throws Exception {
        QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequest, zzf);
        return Boolean.TRUE;
    }

    public final synchronized void zzb() {
        zzh(true);
        zzh(false);
    }

    public final /* synthetic */ void zzc(boolean z) {
        zzd(z, false);
    }

    public final /* synthetic */ void zze(Object obj, Pair pair) {
        CookieManager zza2;
        boolean z = false;
        if ((obj instanceof WebView) && (zza2 = zzu.zzq().zza(this.zzc)) != null) {
            z = zza2.acceptThirdPartyCookies((WebView) obj);
        }
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzg zzg = (zzg) map.get(valueOf);
        if (zzg == null || zzg.zze()) {
            List list = (List) this.zzb.get(valueOf);
            if (list == null) {
                list = new ArrayList();
                this.zzb.put(valueOf, list);
            }
            list.add(pair);
            return;
        }
        zzi(zzg, pair, true);
    }

    public final synchronized void zzf(boolean z, zzg zzg) {
        Integer num;
        boolean z2;
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzg zzg2 = (zzg) map.get(valueOf);
        if (zzg2 == null || zzg2.zze() || zzg2.zzb() == null || zzg.zzb() != null) {
            this.zza.put(valueOf, zzg);
        }
        if (zzg.zzb() != null) {
            num = (Integer) zzba.zzc().zza(zzbbw.zziY);
        } else {
            num = (Integer) zzba.zzc().zza(zzbbw.zziZ);
        }
        int intValue = num.intValue();
        if (zzg.zzb() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzbzo.zzd.schedule(new zzb(this, z, z2), (long) intValue, TimeUnit.SECONDS);
        List<Pair> list = (List) this.zzb.get(valueOf);
        this.zzb.put(valueOf, new ArrayList());
        if (list != null) {
            for (Pair zzi : list) {
                zzi(zzg, zzi, false);
            }
        }
    }

    public final synchronized void zzg(Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbzo.zze.execute(new zza(this, obj, new Pair(queryInfoGenerationCallback, Long.valueOf(zzu.zzB().currentTimeMillis()))));
    }
}
