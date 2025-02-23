package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedo implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzeds zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzm zzc;

    public /* synthetic */ zzedo(zzeds zzeds, Activity activity, zzm zzm) {
        this.zza = zzeds;
        this.zzb = activity;
        this.zzc = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzn(this.zzb, this.zzc, dialogInterface, i);
    }
}
