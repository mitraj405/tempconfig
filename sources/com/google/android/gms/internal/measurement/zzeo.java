package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.2 */
final class zzeo extends zzdq.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzdc zzd;
    private final /* synthetic */ zzdq zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzeo(zzdq zzdq, Bundle bundle, zzdc zzdc) {
        super(zzdq);
        this.zzc = bundle;
        this.zzd = zzdc;
        this.zze = zzdq;
    }

    public final void zza() throws RemoteException {
        ((zzdb) Preconditions.checkNotNull(this.zze.zzj)).performAction(this.zzc, this.zzd, this.zza);
    }

    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
