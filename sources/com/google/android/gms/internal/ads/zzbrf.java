package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbrf implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrh zza;

    public zzbrf(zzbrh zzbrh) {
        this.zza = zzbrh;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbrh zzbrh = this.zza;
        Intent zzb = zzbrh.zzb();
        zzu.zzp();
        zzt.zzT(zzbrh.zzb, zzb);
    }
}
