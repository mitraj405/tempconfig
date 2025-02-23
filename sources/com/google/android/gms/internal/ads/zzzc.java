package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzzc {
    private static final Comparator zza = new zzyy();
    private static final Comparator zzb = new zzyz();
    private final ArrayList zzc = new ArrayList();
    private final zzzb[] zzd = new zzzb[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzzc(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = (float) this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzzb zzzb = (zzzb) this.zzc.get(i2);
            i += zzzb.zzb;
            if (((float) i) >= 0.5f * f2) {
                return zzzb.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzzb) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzzb zzzb;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzb[] zzzbArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzb = zzzbArr[i3];
        } else {
            zzzb = new zzzb((zzza) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzb.zza = i4;
        zzzb.zzb = i;
        zzzb.zzc = f;
        this.zzc.add(zzzb);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzzb zzzb2 = (zzzb) this.zzc.get(0);
                int i7 = zzzb2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzzb[] zzzbArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzzbArr2[i8] = zzzb2;
                    }
                } else {
                    zzzb2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
