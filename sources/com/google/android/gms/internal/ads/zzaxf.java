package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzaxf implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzgdc zza;

    public /* synthetic */ zzaxf(zzgdc zzgdc) {
        this.zza = zzgdc;
    }

    public final void onChecksumsReady(List list) {
        zzgdc zzgdc = this.zza;
        if (list == null) {
            zzgdc.zzc((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzgdc.zzc(zzavs.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzgdc.zzc((Object) null);
        } catch (Throwable unused) {
            zzgdc.zzc((Object) null);
        }
    }
}
