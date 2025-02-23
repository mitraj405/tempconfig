package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbrg implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrh zza;

    public zzbrg(zzbrh zzbrh) {
        this.zza = zzbrh;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("Operation denied by user.");
    }
}
