package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdww implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdww(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* synthetic */ Object zzb() {
        CookieManager zza2 = zzu.zzq().zza((Context) this.zzb.zzb());
        zzfjf zzfjf = zzfjf.WEBVIEW_COOKIE;
        return zzfiv.zza(new zzdwt(zza2), zzfjf, (zzfjl) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfiw(new zzdwu())).zza();
    }
}
