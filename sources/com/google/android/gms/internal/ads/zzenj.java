package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenj implements zzevn {
    private final boolean zza;

    public zzenj(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        String str;
        Bundle bundle = (Bundle) obj;
        if (true != this.zza) {
            str = "0";
        } else {
            str = C0515Ga.AVLBLTY_ONLY;
        }
        bundle.putString("adid_p", str);
    }
}
