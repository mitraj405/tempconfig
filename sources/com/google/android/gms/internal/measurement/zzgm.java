package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzgm extends ContentObserver {
    private final /* synthetic */ zzgk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgm(zzgk zzgk, Handler handler) {
        super((Handler) null);
        this.zza = zzgk;
    }

    public final void onChange(boolean z) {
        this.zza.zzd();
    }
}
