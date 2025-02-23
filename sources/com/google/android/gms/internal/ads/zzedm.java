package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedm implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzeds zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzedm(zzeds zzeds, zzm zzm) {
        this.zza = zzeds;
        this.zzb = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzl(this.zzb, dialogInterface, i);
    }
}
