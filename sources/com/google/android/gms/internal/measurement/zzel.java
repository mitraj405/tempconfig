package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.2 */
final class zzel extends zzdq.zza {
    private final /* synthetic */ zzdq.zzc zzc;
    private final /* synthetic */ zzdq zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzel(zzdq zzdq, zzdq.zzc zzc2) {
        super(zzdq);
        this.zzc = zzc2;
        this.zzd = zzdq;
    }

    public final void zza() throws RemoteException {
        ((zzdb) Preconditions.checkNotNull(this.zzd.zzj)).setEventInterceptor(this.zzc);
    }
}
