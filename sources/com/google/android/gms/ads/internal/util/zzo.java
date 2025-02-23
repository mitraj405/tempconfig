package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzbcs;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzhfv;
import defpackage.K7;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzo implements zzbcs {
    final /* synthetic */ zzbct zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    public zzo(zzt zzt, zzbct zzbct, Context context, Uri uri) {
        this.zza = zzbct;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        K7 a = new K7.d(this.zza.zza()).a();
        String zza2 = zzhfv.zza(this.zzb);
        Intent intent = a.a;
        intent.setPackage(zza2);
        Context context = this.zzb;
        intent.setData(this.zzc);
        Object obj = d7.a;
        context.startActivity(intent, a.f333a);
        this.zza.zzf((Activity) this.zzb);
    }
}
