package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.2 */
final class zzfa extends zzdq.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzdq.zzd zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfa(zzdq.zzd zzd2, Activity activity) {
        super(zzdq.this);
        this.zzc = activity;
        this.zzd = zzd2;
    }

    public final void zza() throws RemoteException {
        ((zzdb) Preconditions.checkNotNull(zzdq.this.zzj)).onActivityStarted(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
