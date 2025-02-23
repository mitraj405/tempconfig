package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzerz implements Callable {
    public /* synthetic */ zzerz(zzesa zzesa) {
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzu.zzp();
        zzayv zzg = zzu.zzo().zzi().zzg();
        Bundle bundle = null;
        if (zzg != null && (!zzu.zzo().zzi().zzP() || !zzu.zzo().zzi().zzQ())) {
            if (zzg.zzh()) {
                zzg.zzg();
            }
            zzayl zza = zzg.zza();
            if (zza != null) {
                str2 = zza.zzd();
                str = zza.zze();
                str3 = zza.zzf();
                if (str2 != null) {
                    zzu.zzo().zzi().zzx(str2);
                }
                if (str3 != null) {
                    zzu.zzo().zzi().zzz(str3);
                }
            } else {
                str2 = zzu.zzo().zzi().zzj();
                str3 = zzu.zzo().zzi().zzk();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzu.zzo().zzi().zzQ()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzu.zzo().zzi().zzP()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzesb(bundle);
    }
}
