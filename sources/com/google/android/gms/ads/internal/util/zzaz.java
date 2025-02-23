package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzfqt;
import com.google.android.gms.internal.ads.zzfqu;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaz extends zzapw {
    private final Context zzb;

    private zzaz(Context context, zzapv zzapv) {
        super(zzapv);
        this.zzb = context;
    }

    public static zzapk zzb(Context context) {
        zzapk zzapk = new zzapk(new zzaqd(new File(zzfqu.zza(zzfqt.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzaqi((zzaqh) null, (SSLSocketFactory) null)), 4);
        zzapk.zzd();
        return zzapk;
    }

    public final zzapd zza(zzaph zzaph) throws zzapq {
        if (zzaph.zza() == 0) {
            if (Pattern.matches((String) zzba.zzc().zza(zzbbw.zzdX), zzaph.zzk())) {
                Context context = this.zzb;
                zzay.zzb();
                if (zzf.zzt(context, 13400000)) {
                    zzapd zza = new zzbku(this.zzb).zza(zzaph);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaph.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaph.zzk())));
                }
            }
        }
        return super.zza(zzaph);
    }
}
