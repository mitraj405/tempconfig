package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzgbt extends zzgbi {
    private List zza;

    public zzgbt(zzfxm zzfxm, boolean z) {
        super(zzfxm, z, true);
        List list;
        if (zzfxm.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzfyh.zza(zzfxm.size());
        }
        for (int i = 0; i < zzfxm.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    public abstract Object zzG(List list);

    public final void zzf(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgbs(obj));
        }
    }

    public final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    public final void zzy(int i) {
        super.zzy(i);
        this.zza = null;
    }
}
