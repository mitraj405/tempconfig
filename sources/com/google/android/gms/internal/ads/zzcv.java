package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcv {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzcv(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = ((float) i) / ((float) i3);
        this.zzf = i / LogSeverity.WARNING_VALUE;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final int zzg(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = Constants.MAX_HOST_LENGTH;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = this.zzb * i;
                i8 += Math.abs(sArr[i10 + i9] - sArr[(i10 + i2) + i9]);
            }
            int i11 = i8 * i6;
            int i12 = i4 * i2;
            if (i11 < i12) {
                i4 = i8;
            }
            if (i11 < i12) {
                i6 = i2;
            }
            int i13 = i8 * i5;
            int i14 = i7 * i2;
            if (i13 > i14) {
                i7 = i8;
            }
            if (i13 > i14) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] zzl2 = zzl(this.zzl, this.zzm, i2);
        this.zzl = zzl2;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, zzl2, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 >= i3) {
                    break;
                }
                i6 += sArr[(i3 * i4) + (i7 * i) + i5];
                i5++;
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private static void zzj(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i7])) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final void zzk() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f = this.zzc / this.zzd;
        double d = (double) f;
        int i11 = (d > 1.00001d ? 1 : (d == 1.00001d ? 0 : -1));
        int i12 = this.zzm;
        if (i11 > 0 || d < 0.99999d) {
            int i13 = this.zzk;
            if (i13 >= this.zzh) {
                int i14 = 0;
                do {
                    int i15 = this.zzr;
                    if (i15 > 0) {
                        int min = Math.min(this.zzh, i15);
                        zzh(this.zzj, i14, min);
                        this.zzr -= min;
                        i14 += min;
                    } else {
                        short[] sArr = this.zzj;
                        int i16 = this.zza;
                        if (i16 > 4000) {
                            i5 = i16 / 4000;
                        } else {
                            i5 = 1;
                        }
                        if (this.zzb == 1 && i5 == 1) {
                            i6 = zzg(sArr, i14, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i14, i5);
                            int zzg2 = zzg(this.zzi, 0, this.zzf / i5, this.zzg / i5);
                            if (i5 != 1) {
                                int i17 = zzg2 * i5;
                                int i18 = i5 * 4;
                                int i19 = this.zzf;
                                int i20 = i17 - i18;
                                if (i20 >= i19) {
                                    i19 = i20;
                                }
                                int i21 = i17 + i18;
                                int i22 = this.zzg;
                                if (i21 > i22) {
                                    i21 = i22;
                                }
                                if (this.zzb == 1) {
                                    i6 = zzg(sArr, i14, i19, i21);
                                } else {
                                    zzi(sArr, i14, 1);
                                    i6 = zzg(this.zzi, 0, i19, i21);
                                }
                            } else {
                                i6 = zzg2;
                            }
                        }
                        int i23 = this.zzu;
                        int i24 = this.zzv;
                        if (i23 == 0 || (i10 = this.zzs) == 0 || i24 > i23 * 3 || i23 + i23 <= this.zzt * 3) {
                            i7 = i6;
                        } else {
                            i7 = i10;
                        }
                        int i25 = i14 + i7;
                        this.zzt = i23;
                        this.zzs = i6;
                        float f2 = (float) i7;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzj;
                            float f3 = -1.0f + f;
                            if (f >= 2.0f) {
                                i9 = (int) (f2 / f3);
                            } else {
                                this.zzr = (int) (((2.0f - f) * f2) / f3);
                                i9 = i7;
                            }
                            short[] zzl2 = zzl(this.zzl, this.zzm, i9);
                            this.zzl = zzl2;
                            int i26 = i9;
                            zzj(i9, this.zzb, zzl2, this.zzm, sArr2, i14, sArr2, i25);
                            this.zzm += i26;
                            i14 = i7 + i26 + i14;
                        } else {
                            int i27 = i7;
                            short[] sArr3 = this.zzj;
                            float f4 = 1.0f - f;
                            if (f < 0.5f) {
                                i8 = (int) ((f2 * f) / f4);
                            } else {
                                this.zzr = (int) ((((f + f) - 4.0f) * f2) / f4);
                                i8 = i27;
                            }
                            int i28 = i27 + i8;
                            short[] zzl3 = zzl(this.zzl, this.zzm, i28);
                            this.zzl = zzl3;
                            int i29 = this.zzb;
                            System.arraycopy(sArr3, i14 * i29, zzl3, this.zzm * i29, i29 * i27);
                            zzj(i8, this.zzb, this.zzl, this.zzm + i27, sArr3, i25, sArr3, i14);
                            this.zzm += i28;
                            i14 += i8;
                        }
                    }
                } while (this.zzh + i14 <= i13);
                int i30 = this.zzk - i14;
                short[] sArr4 = this.zzj;
                int i31 = this.zzb;
                System.arraycopy(sArr4, i14 * i31, sArr4, 0, i31 * i30);
                this.zzk = i30;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        float f5 = this.zze * this.zzd;
        if (f5 != 1.0f && this.zzm != i12) {
            int i32 = this.zza;
            int i33 = (int) (((float) i32) / f5);
            while (true) {
                if (i33 <= 16384 && i32 <= 16384) {
                    break;
                }
                i33 /= 2;
                i32 /= 2;
            }
            int i34 = this.zzm - i12;
            short[] zzl4 = zzl(this.zzn, this.zzo, i34);
            this.zzn = zzl4;
            short[] sArr5 = this.zzl;
            int i35 = this.zzb;
            System.arraycopy(sArr5, i12 * i35, zzl4, this.zzo * i35, i35 * i34);
            this.zzm = i12;
            this.zzo += i34;
            int i36 = 0;
            while (true) {
                i = this.zzo;
                i2 = i - 1;
                if (i36 >= i2) {
                    break;
                }
                while (true) {
                    i3 = this.zzp + 1;
                    int i37 = i3 * i33;
                    i4 = this.zzq;
                    if (i37 <= i4 * i32) {
                        break;
                    }
                    this.zzl = zzl(this.zzl, this.zzm, 1);
                    int i38 = 0;
                    while (true) {
                        int i39 = this.zzb;
                        if (i38 >= i39) {
                            break;
                        }
                        short[] sArr6 = this.zzl;
                        int i40 = this.zzm * i39;
                        short[] sArr7 = this.zzn;
                        int i41 = (i36 * i39) + i38;
                        short s = sArr7[i41];
                        short s2 = sArr7[i41 + i39];
                        int i42 = this.zzp;
                        int i43 = i42 * i33;
                        int i44 = (i42 + 1) * i33;
                        int i45 = i44 - (this.zzq * i32);
                        int i46 = i44 - i43;
                        sArr6[i40 + i38] = (short) ((((i46 - i45) * s2) + (s * i45)) / i46);
                        i38++;
                    }
                    this.zzq++;
                    this.zzm++;
                }
                this.zzp = i3;
                if (i3 == i32) {
                    this.zzp = 0;
                    if (i4 == i33) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzdi.zzf(z);
                    this.zzq = 0;
                }
                i36++;
            }
            if (i2 != 0) {
                short[] sArr8 = this.zzn;
                int i47 = this.zzb;
                System.arraycopy(sArr8, i2 * i47, sArr8, 0, (i - i2) * i47);
                this.zzo -= i2;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        if (i + i2 <= i4) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int zza() {
        int i = this.zzm * this.zzb;
        return i + i;
    }

    public final int zzb() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i = this.zzm - min;
        this.zzm = i;
        int i2 = this.zzb;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zze() {
        int i;
        int i2 = this.zzk;
        int i3 = this.zzm;
        float f = this.zzc;
        float f2 = this.zze;
        float f3 = this.zzd;
        int i4 = i3 + ((int) ((((((float) i2) / (f / f3)) + ((float) this.zzo)) / (f2 * f3)) + 0.5f));
        int i5 = this.zzh;
        this.zzj = zzl(this.zzj, i2, i5 + i5 + i2);
        int i6 = 0;
        while (true) {
            int i7 = this.zzh;
            int i8 = this.zzb;
            i = i7 + i7;
            if (i6 >= i * i8) {
                break;
            }
            this.zzj[(i8 * i2) + i6] = 0;
            i6++;
        }
        this.zzk += i;
        zzk();
        if (this.zzm > i4) {
            this.zzm = i4;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = remaining / i;
        int i3 = i * i2;
        short[] zzl2 = zzl(this.zzj, this.zzk, i2);
        this.zzj = zzl2;
        shortBuffer.get(zzl2, this.zzk * this.zzb, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }
}
