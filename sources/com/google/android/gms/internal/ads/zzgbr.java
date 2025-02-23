package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgbr extends zzgbt {
    public zzgbr(zzfxm zzfxm, boolean z) {
        super(zzfxm, z);
        zzv();
    }

    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        Object obj;
        ArrayList zza = zzfyh.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgbs zzgbs = (zzgbs) it.next();
            if (zzgbs != null) {
                obj = zzgbs.zza;
            } else {
                obj = null;
            }
            zza.add(obj);
        }
        return Collections.unmodifiableList(zza);
    }
}
