package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzhat {
    private static final zzhat zza = new zzhat(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhat(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhat zzc() {
        return zza;
    }

    public static zzhat zze(zzhat zzhat, zzhat zzhat2) {
        int i = zzhat.zzb + zzhat2.zzb;
        int[] copyOf = Arrays.copyOf(zzhat.zzc, i);
        System.arraycopy(zzhat2.zzc, 0, copyOf, zzhat.zzb, zzhat2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhat.zzd, i);
        System.arraycopy(zzhat2.zzd, 0, copyOf2, zzhat.zzb, zzhat2.zzb);
        return new zzhat(i, copyOf, copyOf2, true);
    }

    public static zzhat zzf() {
        return new zzhat();
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhat)) {
            return false;
        }
        zzhat zzhat = (zzhat) obj;
        int i = this.zzb;
        if (i == zzhat.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhat.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhat.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i3 = zzgxd.zzD(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzD = zzgxd.zzD(i8 << 3);
                    int zzd2 = ((zzgwm) this.zzd[i6]).zzd();
                    i5 = zzgxd.zzD(zzd2) + zzd2 + zzD + i5;
                } else if (i9 == 3) {
                    int zzD2 = zzgxd.zzD(i8 << 3);
                    i2 = zzD2 + zzD2;
                    i = ((zzhat) this.zzd[i6]).zza();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i3 = zzgxd.zzD(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzgyn.zza());
                }
                i5 = i3 + i5;
            } else {
                int i10 = i8 << 3;
                long longValue = ((Long) this.zzd[i6]).longValue();
                i2 = zzgxd.zzD(i10);
                i = zzgxd.zzE(longValue);
            }
            i5 = i + i2 + i5;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzD = zzgxd.zzD(8);
            int zzD2 = zzgxd.zzD(this.zzc[i3] >>> 3) + zzgxd.zzD(16);
            int zzD3 = zzgxd.zzD(24);
            int zzd2 = ((zzgwm) this.zzd[i3]).zzd();
            i2 = C1058d.q(zzD + zzD, zzD2, zzgxd.zzD(zzd2) + zzd2 + zzD3, i2);
        }
        this.zze = i2;
        return i2;
    }

    public final zzhat zzd(zzhat zzhat) {
        if (zzhat.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhat.zzb;
        zzn(i);
        System.arraycopy(zzhat.zzc, 0, this.zzc, this.zzb, zzhat.zzb);
        System.arraycopy(zzhat.zzd, 0, this.zzd, this.zzb, zzhat.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgzl.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhbh zzhbh) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzhbh.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhbh zzhbh) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhbh.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhbh.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhbh.zzd(i4, (zzgwm) obj);
                } else if (i3 == 3) {
                    zzhbh.zzF(i4);
                    ((zzhat) obj).zzl(zzhbh);
                    zzhbh.zzh(i4);
                } else if (i3 == 5) {
                    zzhbh.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzgyn.zza());
                }
            }
        }
    }

    public final boolean zzm(int i, zzgww zzgww) throws IOException {
        int zzl;
        zzg();
        int i2 = i & 7;
        if (i2 == 0) {
            zzj(i, Long.valueOf(zzgww.zzo()));
            return true;
        } else if (i2 == 1) {
            zzj(i, Long.valueOf(zzgww.zzn()));
            return true;
        } else if (i2 == 2) {
            zzj(i, zzgww.zzv());
            return true;
        } else if (i2 == 3) {
            zzhat zzhat = new zzhat();
            do {
                zzl = zzgww.zzl();
                if (zzl == 0 || !zzhat.zzm(zzl, zzgww)) {
                    zzgww.zzy(4 | ((i >>> 3) << 3));
                    zzj(i, zzhat);
                }
                zzl = zzgww.zzl();
                break;
            } while (!zzhat.zzm(zzl, zzgww));
            zzgww.zzy(4 | ((i >>> 3) << 3));
            zzj(i, zzhat);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzj(i, Integer.valueOf(zzgww.zzf()));
                return true;
            }
            throw zzgyn.zza();
        }
    }

    private zzhat() {
        this(0, new int[8], new Object[8], true);
    }
}
