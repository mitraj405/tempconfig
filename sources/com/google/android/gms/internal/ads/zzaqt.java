package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaqt {
    public static double zza(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i = bArr[0] << Ascii.CAN;
        int i2 = bArr[1] << Ascii.DLE;
        return ((double) ((((i & Ascii.NUL) | (i2 & Ascii.NUL)) | (65280 & (bArr[2] << 8))) | (bArr[3] & UnsignedBytes.MAX_VALUE))) / 1.073741824E9d;
    }

    public static double zzb(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i = bArr[0] << Ascii.CAN;
        int i2 = bArr[1] << Ascii.DLE;
        return ((double) ((((i & Ascii.NUL) | (i2 & Ascii.NUL)) | (65280 & (bArr[2] << 8))) | (bArr[3] & UnsignedBytes.MAX_VALUE))) / 65536.0d;
    }

    public static int zzc(byte b) {
        if (b < 0) {
            return b + Ascii.NUL;
        }
        return b;
    }

    public static int zzd(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static long zze(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        if (j < 0) {
            return j + 4294967296L;
        }
        return j;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long zze = zze(byteBuffer) << 32;
        if (zze >= 0) {
            return zze(byteBuffer) + zze;
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
