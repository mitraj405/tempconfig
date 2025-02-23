package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdud implements Runnable {
    public final /* synthetic */ zzbzt zza;

    public /* synthetic */ zzdud(zzdun zzdun, zzbzt zzbzt) {
        this.zza = zzbzt;
    }

    public final void run() {
        String zzc = zzu.zzo().zzi().zzh().zzc();
        boolean isEmpty = TextUtils.isEmpty(zzc);
        zzbzt zzbzt = this.zza;
        if (!isEmpty) {
            zzbzt.zzc(zzc);
        } else {
            zzbzt.zzd(new Exception());
        }
    }
}
