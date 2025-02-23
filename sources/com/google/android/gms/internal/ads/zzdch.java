package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzdch {
    protected final Map zza = new HashMap();

    public zzdch(Set set) {
        zzp(set);
    }

    public final synchronized void zzk(zzdei zzdei) {
        zzo(zzdei.zza, zzdei.zzb);
    }

    public final synchronized void zzo(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzp(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzk((zzdei) it.next());
        }
    }

    public final synchronized void zzq(zzdcg zzdcg) {
        for (Map.Entry entry : this.zza.entrySet()) {
            ((Executor) entry.getValue()).execute(new zzdcf(zzdcg, entry.getKey()));
        }
    }
}
