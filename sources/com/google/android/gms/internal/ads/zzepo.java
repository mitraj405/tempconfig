package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzepo implements zzevo {
    private final zzgcu zza;
    private final VersionInfoParcel zzb;

    public zzepo(VersionInfoParcel versionInfoParcel, zzgcu zzgcu) {
        this.zzb = versionInfoParcel;
        this.zza = zzgcu;
    }

    public final int zza() {
        return 54;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepn(this));
    }

    public final /* synthetic */ zzepp zzc() throws Exception {
        return zzepp.zzb(this.zzb);
    }
}
