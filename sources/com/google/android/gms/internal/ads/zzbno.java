package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbd;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbno {
    static final zzbd zza = new zzbnm();
    static final zzbd zzb = new zzbnn();
    private final zzbna zzc;

    public zzbno(Context context, VersionInfoParcel versionInfoParcel, String str, zzfki zzfki) {
        this.zzc = new zzbna(context, versionInfoParcel, str, zza, zzb, zzfki);
    }

    public final zzbne zza(String str, zzbnh zzbnh, zzbng zzbng) {
        return new zzbns(this.zzc, str, zzbnh, zzbng);
    }

    public final zzbnx zzb() {
        return new zzbnx(this.zzc);
    }
}
