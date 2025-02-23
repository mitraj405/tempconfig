package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzalv implements zzajv {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzalv(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[(size + size)];
        for (int i = 0; i < list.size(); i++) {
            zzalk zzalk = (zzalk) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzalk.zzb;
            jArr[i2 + 1] = zzalk.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = copyOf;
        Arrays.sort(copyOf);
    }

    public final int zza() {
        return this.zzc.length;
    }

    public final long zzb(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        if (i >= this.zzc.length) {
            z2 = false;
        }
        zzdi.zzd(z2);
        return this.zzc[i];
    }

    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.zza.size(); i++) {
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzalk zzalk = (zzalk) this.zza.get(i);
                zzdb zzdb = zzalk.zza;
                if (zzdb.zze == -3.4028235E38f) {
                    arrayList2.add(zzalk);
                } else {
                    arrayList.add(zzdb);
                }
            }
        }
        Collections.sort(arrayList2, new zzalu());
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcz zzb2 = ((zzalk) arrayList2.get(i3)).zza.zzb();
            zzb2.zze((float) (-1 - i3), 1);
            arrayList.add(zzb2.zzp());
        }
        return arrayList;
    }
}
