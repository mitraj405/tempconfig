package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzp {
    public static final zzp zza = new zzp();

    public final zzl zza(Context context, zzdx zzdx) {
        List list;
        Context context2;
        zzfh zzfh;
        String str;
        zzdx zzdx2 = zzdx;
        String zzk = zzdx.zzk();
        Set zzp = zzdx.zzp();
        if (!zzp.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zzp));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzs = zzdx2.zzs(context2);
        Bundle zzf = zzdx2.zzf(AdMobAdapter.class);
        String zzl = zzdx.zzl();
        SearchAdRequest zzi = zzdx.zzi();
        if (zzi != null) {
            zzfh = new zzfh(zzi);
        } else {
            zzfh = null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            str = zzf.zzr(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzr = zzdx.zzr();
        RequestConfiguration zzc = zzej.zzf().zzc();
        int max = Math.max(zzdx.zzb(), zzc.getTagForChildDirectedTreatment());
        String[] strArr = {null, zzc.getMaxAdContentRating()};
        return new zzl(8, -1, zzf, -1, list, zzs, max, false, zzl, zzfh, (Location) null, zzk, zzdx.zzg(), zzdx.zze(), Collections.unmodifiableList(new ArrayList(zzdx.zzo())), zzdx.zzm(), str, zzr, (zzc) null, zzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(strArr), new zzo()), zzdx.zzn(), zzdx.zza(), zzdx.zzj(), zzc.getPublisherPrivacyPersonalizationState().getValue(), zzdx.zzc());
    }
}
