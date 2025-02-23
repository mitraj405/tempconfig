package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzepp implements zzevn {
    private final Integer zza;

    private zzepp(Integer num) {
        this.zza = num;
    }

    public static /* bridge */ /* synthetic */ zzepp zzb(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue()) {
            return new zzepp((Integer) null);
        }
        zzu.zzp();
        int i = 0;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzjj)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbbw.zzji)).intValue() && i2 >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        i = SdkExtensions.getExtensionVersion(31);
                    }
                }
                return new zzepp(Integer.valueOf(i));
            }
            i = SdkExtensions.getExtensionVersion(1000000);
            return new zzepp(Integer.valueOf(i));
        } catch (Exception e) {
            zzu.zzo().zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
