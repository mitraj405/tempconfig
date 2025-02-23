package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaik {
    public final zzadp zza;
    public final zzaiy zzb = new zzaiy();
    public final zzek zzc = new zzek();
    public zzaiz zzd;
    public zzaih zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzek zzj = new zzek(1);
    private final zzek zzk = new zzek();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzaik(zzadp zzadp, zzaiz zzaiz, zzaih zzaih) {
        this.zza = zzadp;
        this.zzd = zzaiz;
        this.zze = zzaih;
        zzh(zzaiz, zzaih);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else if (this.zzb.zzj[this.zzf]) {
            i = 1;
        } else {
            i = 0;
        }
        if (zzf() != null) {
            return i | Ints.MAX_POWER_OF_TWO;
        }
        return i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzek zzek;
        boolean z;
        int i3;
        zzaix zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i4 = zzf2.zzd;
        if (i4 != 0) {
            zzek = this.zzb.zzn;
        } else {
            byte[] bArr = zzf2.zze;
            int i5 = zzet.zza;
            zzek zzek2 = this.zzk;
            int length = bArr.length;
            zzek2.zzI(bArr, length);
            zzek = this.zzk;
            i4 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        if (zzb2 || i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        zzek zzek3 = this.zzj;
        if (true != z) {
            i3 = 0;
        } else {
            i3 = 128;
        }
        zzek3.zzM()[0] = (byte) (i3 | i4);
        zzek3.zzK(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzek, i4, 1);
        if (!z) {
            return i4 + 1;
        }
        if (!zzb2) {
            this.zzc.zzH(8);
            zzek zzek4 = this.zzc;
            byte[] zzM = zzek4.zzM();
            zzM[0] = 0;
            zzM[1] = 1;
            zzM[2] = 0;
            zzM[3] = (byte) i2;
            zzM[4] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
            zzM[5] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
            zzM[6] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
            zzM[7] = (byte) (i & Constants.MAX_HOST_LENGTH);
            this.zza.zzr(zzek4, 8, 1);
            return i4 + 9;
        }
        int i6 = i4 + 1;
        zzek zzek5 = this.zzb.zzn;
        int zzq = zzek5.zzq();
        zzek5.zzL(-2);
        int i7 = (zzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzH(i7);
            byte[] zzM2 = this.zzc.zzM();
            zzek5.zzG(zzM2, 0, i7);
            int i8 = (((zzM2[2] & UnsignedBytes.MAX_VALUE) << 8) | (zzM2[3] & UnsignedBytes.MAX_VALUE)) + i2;
            zzM2[2] = (byte) ((i8 >> 8) & Constants.MAX_HOST_LENGTH);
            zzM2[3] = (byte) (i8 & Constants.MAX_HOST_LENGTH);
            zzek5 = this.zzc;
        }
        this.zza.zzr(zzek5, i7, 1);
        return i6 + i7;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzaiy zzaiy = this.zzb;
        return zzaiy.zzi[this.zzf];
    }

    public final zzaix zzf() {
        if (!this.zzl) {
            return null;
        }
        zzaiy zzaiy = this.zzb;
        zzaih zzaih = zzaiy.zza;
        int i = zzet.zza;
        int i2 = zzaih.zza;
        zzaix zzaix = zzaiy.zzm;
        if (zzaix == null) {
            zzaix = this.zzd.zza.zza(i2);
        }
        if (zzaix == null || !zzaix.zza) {
            return null;
        }
        return zzaix;
    }

    public final void zzh(zzaiz zzaiz, zzaih zzaih) {
        this.zzd = zzaiz;
        this.zze = zzaih;
        this.zza.zzl(zzaiz.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzaiy zzaiy = this.zzb;
        zzaiy.zzd = 0;
        zzaiy.zzp = 0;
        zzaiy.zzq = false;
        zzaiy.zzk = false;
        zzaiy.zzo = false;
        zzaiy.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
