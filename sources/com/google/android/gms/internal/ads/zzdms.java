package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdms implements zzaxw {
    public final /* synthetic */ zzcej zza;

    public /* synthetic */ zzdms(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final void zzdp(zzaxv zzaxv) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != zzaxv.zzj) {
            str = "0";
        } else {
            str = C0515Ga.AVLBLTY_ONLY;
        }
        hashMap.put("isVisible", str);
        this.zza.zzd("onAdVisibilityChanged", hashMap);
    }
}
