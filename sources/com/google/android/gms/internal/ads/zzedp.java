package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedp implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzeds zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzedp(zzeds zzeds, zzm zzm) {
        this.zza = zzeds;
        this.zzb = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzo(this.zzb, dialogInterface, i);
    }
}
