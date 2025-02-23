package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class CsiParamDefaults_Factory implements zzhfc<CsiParamDefaults> {
    private final zzhfu zza;
    private final zzhfu zzb;

    public CsiParamDefaults_Factory(zzhfu<Context> zzhfu, zzhfu<VersionInfoParcel> zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public static CsiParamDefaults_Factory create(zzhfu<Context> zzhfu, zzhfu<VersionInfoParcel> zzhfu2) {
        return new CsiParamDefaults_Factory(zzhfu, zzhfu2);
    }

    public static CsiParamDefaults newInstance(Context context, VersionInfoParcel versionInfoParcel) {
        return new CsiParamDefaults(context, versionInfoParcel);
    }

    /* renamed from: get */
    public CsiParamDefaults zzb() {
        return newInstance((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
