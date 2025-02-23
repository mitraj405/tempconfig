package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.internal.ads.zzbte;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ AdFormat zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ QueryInfoGenerationCallback zze;

    public /* synthetic */ zza(Context context, AdFormat adFormat, AdRequest adRequest, String str, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = adRequest;
        this.zzd = str;
        this.zze = queryInfoGenerationCallback;
    }

    public final void run() {
        zzdx zzdx;
        AdRequest adRequest = this.zzc;
        if (adRequest == null) {
            zzdx = null;
        } else {
            zzdx = adRequest.zza();
        }
        QueryInfoGenerationCallback queryInfoGenerationCallback = this.zze;
        String str = this.zzd;
        new zzbte(this.zza, this.zzb, zzdx, str).zzb(queryInfoGenerationCallback);
    }
}
