package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzepf implements zzgbq {
    public final ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzgcj.zzh(new zzepi((String) null, -1));
        }
        return zzgcj.zzh(new zzepi(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
