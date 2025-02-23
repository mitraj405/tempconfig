package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbrm implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrn zza;

    public zzbrm(zzbrn zzbrn) {
        this.zza = zzbrn;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
