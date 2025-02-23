package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwb {
    public static int zza(byte[] bArr, int i, zzgwa zzgwa) throws zzgyn {
        int zzh = zzh(bArr, i, zzgwa);
        int i2 = zzgwa.zza;
        if (i2 < 0) {
            throw zzgyn.zzf();
        } else if (i2 > bArr.length - zzh) {
            throw zzgyn.zzi();
        } else if (i2 == 0) {
            zzgwa.zzc = zzgwm.zzb;
            return zzh;
        } else {
            zzgwa.zzc = zzgwm.zzv(bArr, zzh, i2);
            return zzh + i2;
        }
    }

    public static int zzb(byte[] bArr, int i) {
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        byte b2 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        byte b3 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (b2 << 8) | b | (b3 << Ascii.DLE);
    }

    public static int zzc(zzhae zzhae, byte[] bArr, int i, int i2, int i3, zzgwa zzgwa) throws IOException {
        Object zze = zzhae.zze();
        int zzl = zzl(zze, zzhae, bArr, i, i2, i3, zzgwa);
        zzhae.zzf(zze);
        zzgwa.zzc = zze;
        return zzl;
    }

    public static int zzd(zzhae zzhae, byte[] bArr, int i, int i2, zzgwa zzgwa) throws IOException {
        Object zze = zzhae.zze();
        int zzm = zzm(zze, zzhae, bArr, i, i2, zzgwa);
        zzhae.zzf(zze);
        zzgwa.zzc = zze;
        return zzm;
    }

    public static int zze(zzhae zzhae, int i, byte[] bArr, int i2, int i3, zzgyk zzgyk, zzgwa zzgwa) throws IOException {
        int zzd = zzd(zzhae, bArr, i2, i3, zzgwa);
        zzgyk.add(zzgwa.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzgwa);
            if (i != zzgwa.zza) {
                break;
            }
            zzd = zzd(zzhae, bArr, zzh, i3, zzgwa);
            zzgyk.add(zzgwa.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zzgyk zzgyk, zzgwa zzgwa) throws IOException {
        zzgxz zzgxz = (zzgxz) zzgyk;
        int zzh = zzh(bArr, i, zzgwa);
        int i2 = zzgwa.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzgwa);
            zzgxz.zzi(zzgwa.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzgyn.zzi();
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzhat zzhat, zzgwa zzgwa) throws zzgyn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzk = zzk(bArr, i2, zzgwa);
                zzhat.zzj(i, Long.valueOf(zzgwa.zzb));
                return zzk;
            } else if (i4 == 1) {
                zzhat.zzj(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzh = zzh(bArr, i2, zzgwa);
                int i5 = zzgwa.zza;
                if (i5 < 0) {
                    throw zzgyn.zzf();
                } else if (i5 <= bArr.length - zzh) {
                    if (i5 == 0) {
                        zzhat.zzj(i, zzgwm.zzb);
                    } else {
                        zzhat.zzj(i, zzgwm.zzv(bArr, zzh, i5));
                    }
                    return zzh + i5;
                } else {
                    throw zzgyn.zzi();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzhat zzf = zzhat.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i2, zzgwa);
                    int i8 = zzgwa.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzh2;
                        break;
                    }
                    int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzgwa);
                    i7 = i8;
                    i2 = zzg;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzgyn.zzg();
                }
                zzhat.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzhat.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzgyn.zzc();
            }
        } else {
            throw zzgyn.zzc();
        }
    }

    public static int zzh(byte[] bArr, int i, zzgwa zzgwa) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgwa);
        }
        zzgwa.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzgwa zzgwa) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgwa.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Ascii.DEL) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgwa.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgwa.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgwa.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgwa.zza = i11;
                return i12;
            }
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzgyk zzgyk, zzgwa zzgwa) {
        zzgxz zzgxz = (zzgxz) zzgyk;
        int zzh = zzh(bArr, i2, zzgwa);
        zzgxz.zzi(zzgwa.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzgwa);
            if (i != zzgwa.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzgwa);
            zzgxz.zzi(zzgwa.zza);
        }
        return zzh;
    }

    public static int zzk(byte[] bArr, int i, zzgwa zzgwa) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgwa.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Ascii.DEL)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Ascii.DEL)) << i4;
            byte b3 = b2;
            i3 = i5;
            b = b3;
        }
        zzgwa.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzhae zzhae, byte[] bArr, int i, int i2, int i3, zzgwa zzgwa) throws IOException {
        int zzc = ((zzgzm) zzhae).zzc(obj, bArr, i, i2, i3, zzgwa);
        zzgwa.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzm(java.lang.Object r6, com.google.android.gms.internal.ads.zzhae r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzgwa r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.ads.zzgyn r6 = com.google.android.gms.internal.ads.zzgyn.zzi()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwb.zzm(java.lang.Object, com.google.android.gms.internal.ads.zzhae, byte[], int, int, com.google.android.gms.internal.ads.zzgwa):int");
    }

    public static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
