package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzux extends zztq {
    private static final zzbc zza;
    private final zzuk[] zzb;
    private final zzcc[] zzc;
    private final ArrayList zzd;
    private int zze = -1;
    private long[][] zzf;
    private zzuw zzg;
    private final zztt zzh;

    static {
        zzam zzam = new zzam();
        zzam.zza("MergingMediaSource");
        zza = zzam.zzc();
    }

    public zzux(boolean z, boolean z2, zztt zztt, zzuk... zzukArr) {
        this.zzb = zzukArr;
        this.zzh = zztt;
        this.zzd = new ArrayList(Arrays.asList(zzukArr));
        this.zzc = new zzcc[zzukArr.length];
        this.zzf = new long[0][];
        new HashMap();
        zzfyx.zzb(8).zzb(2).zza();
    }

    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzuk zzuk, zzcc zzcc) {
        int i;
        if (this.zzg == null) {
            if (this.zze == -1) {
                i = zzcc.zzb();
                this.zze = i;
            } else {
                int zzb2 = zzcc.zzb();
                int i2 = this.zze;
                if (zzb2 != i2) {
                    this.zzg = new zzuw(0);
                    return;
                }
                i = i2;
            }
            if (this.zzf.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i;
                this.zzf = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.zzd.remove(zzuk);
            this.zzc[((Integer) obj).intValue()] = zzcc;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }

    public final void zzG(zzug zzug) {
        zzuv zzuv = (zzuv) zzug;
        int i = 0;
        while (true) {
            zzuk[] zzukArr = this.zzb;
            if (i < zzukArr.length) {
                zzukArr[i].zzG(zzuv.zzn(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzug zzI(zzui zzui, zzyk zzyk, long j) {
        zzcc[] zzccArr = this.zzc;
        int length = this.zzb.length;
        zzug[] zzugArr = new zzug[length];
        int zza2 = zzccArr[0].zza(zzui.zza);
        for (int i = 0; i < length; i++) {
            zzugArr[i] = this.zzb[i].zzI(zzui.zza(this.zzc[i].zzf(zza2)), zzyk, j - this.zzf[zza2][i]);
        }
        return new zzuv(this.zzh, this.zzf[zza2], zzugArr);
    }

    public final zzbc zzJ() {
        zzuk[] zzukArr = this.zzb;
        if (zzukArr.length > 0) {
            return zzukArr[0].zzJ();
        }
        return zza;
    }

    public final void zzn(zzgu zzgu) {
        super.zzn(zzgu);
        int i = 0;
        while (true) {
            zzuk[] zzukArr = this.zzb;
            if (i < zzukArr.length) {
                zzB(Integer.valueOf(i), zzukArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zze = -1;
        this.zzg = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzt(zzbc zzbc) {
        this.zzb[0].zzt(zzbc);
    }

    public final /* bridge */ /* synthetic */ zzui zzy(Object obj, zzui zzui) {
        if (((Integer) obj).intValue() == 0) {
            return zzui;
        }
        return null;
    }

    public final void zzz() throws IOException {
        zzuw zzuw = this.zzg;
        if (zzuw == null) {
            super.zzz();
            return;
        }
        throw zzuw;
    }
}
