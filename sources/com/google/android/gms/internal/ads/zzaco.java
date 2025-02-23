package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaco {
    public static int zza(zzacl zzacl, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int zzb = zzacl.zzb(bArr, i + i3, i2 - i3);
            if (zzb == -1) {
                break;
            }
            i3 += zzb;
        }
        return i3;
    }

    public static void zzb(boolean z, String str) throws zzbo {
        if (!z) {
            throw zzbo.zza(str, (Throwable) null);
        }
    }

    public static boolean zzc(zzacl zzacl, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzacl.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzacl zzacl, byte[] bArr, int i, int i2) throws IOException {
        try {
            ((zzaby) zzacl).zzn(bArr, i, i2, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacl zzacl, int i) throws IOException {
        try {
            ((zzaby) zzacl).zzo(i, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
