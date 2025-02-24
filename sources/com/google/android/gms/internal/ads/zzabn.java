package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabn {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final String zzk;

    private zzabn(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = f;
        this.zzk = str;
    }

    public static zzabn zza(zzek zzek) throws zzbo {
        String str;
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        try {
            zzek.zzL(4);
            int zzm = (zzek.zzm() & 3) + 1;
            if (zzm != 3) {
                ArrayList arrayList = new ArrayList();
                int zzm2 = zzek.zzm() & 31;
                for (int i8 = 0; i8 < zzm2; i8++) {
                    arrayList.add(zzb(zzek));
                }
                int zzm3 = zzek.zzm();
                for (int i9 = 0; i9 < zzm3; i9++) {
                    arrayList.add(zzb(zzek));
                }
                if (zzm2 > 0) {
                    zzfg zze2 = zzfh.zze((byte[]) arrayList.get(0), zzm + 1, ((byte[]) arrayList.get(0)).length);
                    int i10 = zze2.zze;
                    int i11 = zze2.zzf;
                    int i12 = zze2.zzj;
                    int i13 = zze2.zzk;
                    int i14 = zze2.zzl;
                    float f2 = zze2.zzg;
                    str = zzdk.zza(zze2.zza, zze2.zzb, zze2.zzc);
                    i2 = i13;
                    i = i14;
                    f = f2;
                    i5 = zze2.zzh + 8;
                    i4 = zze2.zzi + 8;
                    i3 = i12;
                    i7 = i10;
                    i6 = i11;
                } else {
                    i7 = -1;
                    i6 = -1;
                    i5 = -1;
                    i4 = -1;
                    i3 = -1;
                    i2 = -1;
                    i = -1;
                    str = null;
                    f = 1.0f;
                }
                return new zzabn(arrayList, zzm, i7, i6, i5, i4, i3, i2, i, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzbo.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzek zzek) {
        int zzq = zzek.zzq();
        int zzd2 = zzek.zzd();
        zzek.zzL(zzq);
        return zzdk.zzc(zzek.zzM(), zzd2, zzq);
    }
}
