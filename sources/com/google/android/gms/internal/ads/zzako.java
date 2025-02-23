package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.google.firebase.perf.util.Constants;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzako {
    private final zzek zza = new zzek();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public static /* bridge */ /* synthetic */ void zzb(zzako zzako, zzek zzek, int i) {
        int zzo;
        if (i >= 4) {
            zzek.zzL(3);
            int i2 = i - 4;
            if ((zzek.zzm() & 128) != 0) {
                if (i2 >= 7 && (zzo = zzek.zzo()) >= 4) {
                    zzako.zzh = zzek.zzq();
                    zzako.zzi = zzek.zzq();
                    zzako.zza.zzH(zzo - 4);
                    i2 -= 7;
                } else {
                    return;
                }
            }
            zzek zzek2 = zzako.zza;
            int zzd2 = zzek2.zzd();
            int zze2 = zzek2.zze();
            if (zzd2 < zze2 && i2 > 0) {
                int min = Math.min(i2, zze2 - zzd2);
                zzek.zzG(zzek2.zzM(), zzd2, min);
                zzako.zza.zzK(zzd2 + min);
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzc(zzako zzako, zzek zzek, int i) {
        if (i >= 19) {
            zzako.zzd = zzek.zzq();
            zzako.zze = zzek.zzq();
            zzek.zzL(11);
            zzako.zzf = zzek.zzq();
            zzako.zzg = zzek.zzq();
        }
    }

    public static /* bridge */ /* synthetic */ void zzd(zzako zzako, zzek zzek, int i) {
        zzako zzako2 = zzako;
        if (i % 5 == 2) {
            zzek.zzL(2);
            int i2 = 0;
            Arrays.fill(zzako2.zzb, 0);
            int i3 = i / 5;
            int i4 = 0;
            while (i4 < i3) {
                int zzm = zzek.zzm();
                int zzm2 = zzek.zzm();
                int zzm3 = zzek.zzm();
                int zzm4 = zzek.zzm();
                double d = (double) zzm2;
                double d2 = (double) (zzm3 - 128);
                double d3 = (double) (zzm4 - 128);
                zzako2.zzb[zzm] = Math.max(0, Math.min((int) ((d3 * 1.772d) + d), Constants.MAX_HOST_LENGTH)) | (zzek.zzm() << 24) | (Math.max(i2, Math.min((int) ((1.402d * d2) + d), Constants.MAX_HOST_LENGTH)) << 16) | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), Constants.MAX_HOST_LENGTH)) << 8);
                i4++;
                i2 = 0;
            }
            zzako2.zzc = true;
        }
    }

    public final zzdb zza() {
        int i;
        int i2;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzek zzek = this.zza;
        if (zzek.zze() == 0 || zzek.zzd() != zzek.zze() || !this.zzc) {
            return null;
        }
        zzek.zzK(0);
        int i3 = this.zzh * this.zzi;
        int[] iArr = new int[i3];
        int i4 = 0;
        while (i4 < i3) {
            int zzm = this.zza.zzm();
            if (zzm != 0) {
                i2 = i4 + 1;
                iArr[i4] = this.zzb[zzm];
            } else {
                int zzm2 = this.zza.zzm();
                if (zzm2 != 0) {
                    int i5 = zzm2 & 63;
                    if ((zzm2 & 64) != 0) {
                        i5 = (i5 << 8) | this.zza.zzm();
                    }
                    if ((zzm2 & 128) == 0) {
                        i = this.zzb[0];
                    } else {
                        i = this.zzb[this.zza.zzm()];
                    }
                    i2 = i5 + i4;
                    Arrays.fill(iArr, i4, i2, i);
                }
            }
            i4 = i2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcz zzcz = new zzcz();
        zzcz.zzc(createBitmap);
        zzcz.zzh(((float) this.zzf) / ((float) this.zzd));
        zzcz.zzi(0);
        zzcz.zze(((float) this.zzg) / ((float) this.zze), 0);
        zzcz.zzf(0);
        zzcz.zzk(((float) this.zzh) / ((float) this.zzd));
        zzcz.zzd(((float) this.zzi) / ((float) this.zze));
        return zzcz.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
