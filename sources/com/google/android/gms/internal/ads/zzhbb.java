package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
abstract class zzhbb {
    public static final String zzc(ByteBuffer byteBuffer, int i, int i2) throws zzgyn {
        if ((((byteBuffer.limit() - i) - i2) | i | i2) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r11 < i3) {
                byte b = byteBuffer.get(r11);
                if (!zzhba.zzd(b)) {
                    break;
                }
                i = r11 + 1;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (r11 < i3) {
                int i6 = r11 + 1;
                byte b2 = byteBuffer.get(r11);
                if (zzhba.zzd(b2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) b2;
                    r11 = i6;
                    while (true) {
                        i5 = i7;
                        if (r11 >= i3) {
                            break;
                        }
                        byte b3 = byteBuffer.get(r11);
                        if (!zzhba.zzd(b3)) {
                            break;
                        }
                        r11++;
                        i7 = i5 + 1;
                        cArr[i5] = (char) b3;
                    }
                } else if (zzhba.zzf(b2)) {
                    if (i6 < i3) {
                        zzhba.zzc(b2, byteBuffer.get(i6), cArr, i5);
                        i5++;
                        r11 = i6 + 1;
                    } else {
                        throw zzgyn.zzd();
                    }
                } else if (zzhba.zze(b2)) {
                    if (i6 < i3 - 1) {
                        int i8 = i6 + 1;
                        zzhba.zzb(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                        i5++;
                        r11 = i8 + 1;
                    } else {
                        throw zzgyn.zzd();
                    }
                } else if (i6 < i3 - 2) {
                    int i9 = i6 + 1;
                    byte b4 = byteBuffer.get(i6);
                    int i10 = i9 + 1;
                    zzhba.zza(b2, b4, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                    i5 += 2;
                    r11 = i10 + 1;
                } else {
                    throw zzgyn.zzd();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    public abstract String zzb(byte[] bArr, int i, int i2) throws zzgyn;
}
