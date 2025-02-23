package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzwz implements Comparator {
    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        return zzfxg.zzj().zzc((zzxs) Collections.max(list, new zzxq()), (zzxs) Collections.max(list2, new zzxq()), new zzxq()).zzb(list.size(), list2.size()).zzc((zzxs) Collections.max(list, new zzxr()), (zzxs) Collections.max(list2, new zzxr()), new zzxr()).zza();
    }
}
