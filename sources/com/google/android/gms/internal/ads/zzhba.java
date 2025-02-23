package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzhba {
    public static /* bridge */ /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (!zzg(b2)) {
            if ((((b2 + 112) + (b << Ascii.FS)) >> 30) == 0 && !zzg(b3) && !zzg(b4)) {
                byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & 63) << Ascii.FF) | ((b3 & 63) << 6) | (b4 & 63);
                cArr[i] = (char) ((b5 >>> 10) + 55232);
                cArr[i + 1] = (char) ((b5 & UnsignedBytes.MAX_VALUE) + Ascii.NUL);
                return;
            }
        }
        throw zzgyn.zzd();
    }

    public static /* bridge */ /* synthetic */ void zzb(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!zzg(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zzg(b3)) {
                cArr[i] = (char) (((b & Ascii.SI) << Ascii.FF) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw zzgyn.zzd();
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zzg(b2)) {
            throw zzgyn.zzd();
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        if (b >= 0) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zze(byte b) {
        if (b < -16) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zzf(byte b) {
        if (b < -32) {
            return true;
        }
        return false;
    }

    private static boolean zzg(byte b) {
        if (b > -65) {
            return true;
        }
        return false;
    }
}
