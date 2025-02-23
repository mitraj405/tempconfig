package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzacv {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzacu zzk;
    private final zzbk zzl;

    private zzacv(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzacu zzacu, zzbk zzbk) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzi(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzh(i7);
        this.zzj = j;
        this.zzk = zzacu;
        this.zzl = zzbk;
    }

    private static int zzh(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 20) {
            return 5;
        }
        if (i != 24) {
            return -1;
        }
        return 6;
    }

    private static int zzi(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return Math.max(0, Math.min((j * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzaf zzc(byte[] bArr, zzbk zzbk) {
        bArr[4] = UnsignedBytes.MAX_POWER_OF_TWO;
        zzbk zzd2 = zzd(zzbk);
        zzad zzad = new zzad();
        zzad.zzX("audio/flac");
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzad.zzP(i);
        zzad.zzy(this.zzg);
        zzad.zzY(this.zze);
        zzad.zzR(zzet.zzl(this.zzh));
        zzad.zzL(Collections.singletonList(bArr));
        zzad.zzQ(zzd2);
        return zzad.zzad();
    }

    public final zzbk zzd(zzbk zzbk) {
        zzbk zzbk2 = this.zzl;
        if (zzbk2 == null) {
            return zzbk;
        }
        return zzbk2.zzd(zzbk);
    }

    public final zzacv zze(List list) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbk(list)));
    }

    public final zzacv zzf(zzacu zzacu) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzacu, this.zzl);
    }

    public final zzacv zzg(List list) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzadv.zzb(list)));
    }

    public zzacv(byte[] bArr, int i) {
        zzej zzej = new zzej(bArr, bArr.length);
        zzej.zzl(i * 8);
        this.zza = zzej.zzd(16);
        this.zzb = zzej.zzd(16);
        this.zzc = zzej.zzd(24);
        this.zzd = zzej.zzd(24);
        int zzd2 = zzej.zzd(20);
        this.zze = zzd2;
        this.zzf = zzi(zzd2);
        this.zzg = zzej.zzd(3) + 1;
        int zzd3 = zzej.zzd(5) + 1;
        this.zzh = zzd3;
        this.zzi = zzh(zzd3);
        this.zzj = zzej.zze(36);
        this.zzk = null;
        this.zzl = null;
    }
}
