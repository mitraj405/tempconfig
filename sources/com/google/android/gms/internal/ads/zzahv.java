package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzahv extends zzahx {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzahv(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        List list = this.zzb;
        String zzf = zzahx.zzf(this.zzd);
        String arrays = Arrays.toString(list.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzahv zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzahv zzahv = (zzahv) this.zzc.get(i2);
            if (zzahv.zzd == i) {
                return zzahv;
            }
        }
        return null;
    }

    public final zzahw zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzahw zzahw = (zzahw) this.zzb.get(i2);
            if (zzahw.zzd == i) {
                return zzahw;
            }
        }
        return null;
    }

    public final void zzc(zzahv zzahv) {
        this.zzc.add(zzahv);
    }

    public final void zzd(zzahw zzahw) {
        this.zzb.add(zzahw);
    }
}
