package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.K7;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzegi implements zzeet {
    private final Context zza;
    private final zzdgp zzb;
    private final Executor zzc;
    private final zzfek zzd;

    public zzegi(Context context, Executor executor, zzdgp zzdgp, zzfek zzfek) {
        this.zza = context;
        this.zzb = zzdgp;
        this.zzc = executor;
        this.zzd = zzfek;
    }

    private static String zzd(zzfel zzfel) {
        try {
            return zzfel.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        Uri uri;
        String zzd2 = zzd(zzfel);
        if (zzd2 != null) {
            uri = Uri.parse(zzd2);
        } else {
            uri = null;
        }
        return zzgcj.zzn(zzgcj.zzh((Object) null), new zzegg(this, uri, zzfex, zzfel), this.zzc);
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        Context context = this.zza;
        if (!(context instanceof Activity) || !zzbct.zzg(context) || TextUtils.isEmpty(zzd(zzfel))) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ ListenableFuture zzc(Uri uri, zzfex zzfex, zzfel zzfel, Object obj) throws Exception {
        try {
            Intent intent = new K7.d().a().a;
            intent.setData(uri);
            zzc zzc2 = new zzc(intent, (zzy) null);
            zzbzt zzbzt = new zzbzt();
            zzdfp zze = this.zzb.zze(new zzcsk(zzfex, zzfel, (String) null), new zzdfs(new zzegh(zzbzt), (zzcej) null));
            zzbzt.zzc(new AdOverlayInfoParcel(zzc2, (zza) null, zze.zza(), (zzaa) null, new VersionInfoParcel(0, 0, false), (zzcej) null, (zzdeq) null));
            this.zzd.zza();
            return zzgcj.zzh(zze.zzg());
        } catch (Throwable th) {
            zzm.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
