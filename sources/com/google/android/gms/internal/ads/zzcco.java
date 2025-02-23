package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcco implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final zzccn zza(zzcbk zzcbk) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzccn zzccn = (zzccn) it.next();
            if (zzccn.zza == zzcbk) {
                return zzccn;
            }
        }
        return null;
    }

    public final void zzb(zzccn zzccn) {
        this.zza.add(zzccn);
    }

    public final void zzc(zzccn zzccn) {
        this.zza.remove(zzccn);
    }

    public final boolean zzd(zzcbk zzcbk) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzccn zzccn = (zzccn) it.next();
            if (zzccn.zza == zzcbk) {
                arrayList.add(zzccn);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzccn) it2.next()).zzb.zzf();
        }
        return true;
    }
}
