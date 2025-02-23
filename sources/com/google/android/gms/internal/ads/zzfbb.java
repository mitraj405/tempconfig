package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfbb implements zzgbq {
    public final /* synthetic */ zzfhd zza;
    public final /* synthetic */ zzctc zzb;

    public /* synthetic */ zzfbb(zzfbd zzfbd, zzfhd zzfhd, zzctc zzctc) {
        this.zza = zzfhd;
        this.zzb = zzctc;
    }

    public final ListenableFuture zza(Object obj) {
        zzfex zzfex = (zzfex) obj;
        this.zza.zzb = zzfex;
        Iterator it = zzfex.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator it2 = ((zzfel) it.next()).zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return this.zzb.zzi(zzgcj.zzh(zzfex));
            }
        }
        return zzgcj.zzh((Object) null);
    }
}
