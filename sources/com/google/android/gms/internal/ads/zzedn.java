package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedn implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzeds zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzedn(zzeds zzeds, zzm zzm) {
        this.zza = zzeds;
        this.zzb = zzm;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzm(this.zzb, dialogInterface);
    }
}
