package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeof implements zzevo {
    private final zzevo zza;
    private final zzffg zzb;
    private final Context zzc;
    private final zzbze zzd;

    public zzeof(zzeqg zzeqg, zzffg zzffg, Context context, zzbze zzbze) {
        this.zza = zzeqg;
        this.zzb = zzffg;
        this.zzc = context;
        this.zzd = zzbze;
    }

    public final int zza() {
        return 7;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zzm(this.zza.zzb(), new zzeoe(this), zzbzo.zzf);
    }

    public final /* synthetic */ zzeog zzc(zzevx zzevx) {
        boolean z;
        String str;
        String str2;
        int i;
        float f;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        zzq zzq = this.zzb.zze;
        zzq[] zzqArr = zzq.zzg;
        if (zzqArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzq zzq2 : zzqArr) {
                boolean z4 = zzq2.zzi;
                if (!z4 && !z2) {
                    str = zzq2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (!z3) {
                        z3 = true;
                        z = true;
                    } else {
                        z3 = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzq.zza;
            z = zzq.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            zzbze zzbze = this.zzd;
            f = displayMetrics.density;
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            str2 = zzbze.zzi().zzm();
        }
        StringBuilder sb = new StringBuilder();
        zzq[] zzqArr2 = zzq.zzg;
        if (zzqArr2 != null) {
            boolean z5 = false;
            for (zzq zzq3 : zzqArr2) {
                if (zzq3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i4 = zzq3.zze;
                    if (i4 == -1) {
                        if (f != 0.0f) {
                            i4 = (int) (((float) zzq3.zzf) / f);
                        } else {
                            i4 = -1;
                        }
                    }
                    sb.append(i4);
                    sb.append("x");
                    int i5 = zzq3.zzb;
                    if (i5 == -2) {
                        if (f != 0.0f) {
                            i5 = (int) (((float) zzq3.zzc) / f);
                        } else {
                            i5 = -2;
                        }
                    }
                    sb.append(i5);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzeog(zzq, str, z, sb.toString(), f, i, i2, str2, this.zzb.zzq);
    }
}
