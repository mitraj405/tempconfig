package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzful;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzu implements zzful {
    public final /* synthetic */ zzak zza;
    public final /* synthetic */ List zzb;

    public /* synthetic */ zzu(zzak zzak, List list) {
        this.zza = zzak;
        this.zzb = list;
    }

    public final Object apply(Object obj) {
        return this.zza.zzB(this.zzb, (String) obj);
    }
}
