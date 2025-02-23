package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzach {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 640, ViewUtils.EDGE_TO_EDGE_FLAGS, 896, UserMetadata.MAX_ATTRIBUTE_SIZE, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        int i;
        zzej zzg2 = zzg(bArr);
        zzg2.zzn(42);
        if (true != zzg2.zzp()) {
            i = 8;
        } else {
            i = 12;
        }
        return zzg2.zzd(i) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzej zzg2 = zzg(bArr);
        zzg2.zzn(32);
        return zzf(zzg2, zzj, true) + 1;
    }

    public static zzaf zzc(byte[] bArr, String str, String str2, int i, zzy zzy) {
        int i2;
        int i3;
        zzej zzg2 = zzg(bArr);
        zzg2.zzn(60);
        int i4 = zzb[zzg2.zzd(6)];
        int i5 = zzc[zzg2.zzd(4)];
        int zzd2 = zzg2.zzd(5);
        if (zzd2 >= 29) {
            i2 = -1;
        } else {
            i2 = (zzd[zzd2] * 1000) / 2;
        }
        zzg2.zzn(10);
        if (zzg2.zzd(2) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i6 = i4 + i3;
        zzad zzad = new zzad();
        zzad.zzK(str);
        zzad.zzX("audio/vnd.dts");
        zzad.zzx(i2);
        zzad.zzy(i6);
        zzad.zzY(i5);
        zzad.zzE((zzy) null);
        zzad.zzO(str2);
        zzad.zzV(i);
        return zzad.zzad();
    }

    public static zzacg zzd(byte[] bArr) throws zzbo {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        int i6;
        zzej zzg2 = zzg(bArr);
        zzg2.zzn(40);
        int zzd2 = zzg2.zzd(2);
        boolean zzp = zzg2.zzp();
        if (true != zzp) {
            i = 16;
        } else {
            i = 20;
        }
        if (true != zzp) {
            i2 = 8;
        } else {
            i2 = 12;
        }
        zzg2.zzn(i2);
        int zzd3 = zzg2.zzd(i) + 1;
        boolean zzp2 = zzg2.zzp();
        int i7 = 0;
        if (zzp2) {
            i3 = zzg2.zzd(2);
            int zzd4 = zzg2.zzd(3) + 1;
            if (zzg2.zzp()) {
                zzg2.zzn(36);
            }
            int zzd5 = zzg2.zzd(3) + 1;
            int zzd6 = zzg2.zzd(3) + 1;
            if (zzd5 == 1 && zzd6 == 1) {
                int i8 = zzd2 + 1;
                int zzd7 = zzg2.zzd(i8);
                for (int i9 = 0; i9 < i8; i9++) {
                    if (((zzd7 >> i9) & 1) == 1) {
                        zzg2.zzn(8);
                    }
                }
                int i10 = zzd4 * AdRequest.MAX_CONTENT_URL_LENGTH;
                if (zzg2.zzp()) {
                    zzg2.zzn(2);
                    int zzd8 = (zzg2.zzd(2) + 1) << 2;
                    int zzd9 = zzg2.zzd(2) + 1;
                    while (i7 < zzd9) {
                        zzg2.zzn(zzd8);
                        i7++;
                    }
                }
                i7 = i10;
            } else {
                throw zzbo.zzc("Multiple audio presentations or assets not supported");
            }
        } else {
            i3 = -1;
        }
        zzg2.zzn(i);
        zzg2.zzn(12);
        if (zzp2) {
            if (zzg2.zzp()) {
                zzg2.zzn(4);
            }
            if (zzg2.zzp()) {
                zzg2.zzn(24);
            }
            if (zzg2.zzp()) {
                zzg2.zzo(zzg2.zzd(10) + 1);
            }
            zzg2.zzn(5);
            int i11 = zze[zzg2.zzd(4)];
            i5 = zzg2.zzd(8) + 1;
            i4 = i11;
        } else {
            i4 = -2147483647;
            i5 = -1;
        }
        if (zzp2) {
            if (i3 == 0) {
                i6 = 32000;
            } else if (i3 == 1) {
                i6 = 44100;
            } else if (i3 == 2) {
                i6 = 48000;
            } else {
                throw zzbo.zza("Unsupported reference clock code in DTS HD header: " + i3, (Throwable) null);
            }
            j = zzet.zzt((long) i7, 1000000, (long) i6, RoundingMode.FLOOR);
        } else {
            j = -9223372036854775807L;
        }
        return new zzacg("audio/vnd.dts.hd;profile=lbr", i5, i4, zzd3, j, 0, (zzacf) null);
    }

    public static zzacg zze(byte[] bArr, AtomicInteger atomicInteger) throws zzbo {
        char c;
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2 = bArr;
        zzej zzg2 = zzg(bArr);
        int zzd2 = zzg2.zzd(32);
        int zzf2 = zzf(zzg2, zzf, true) + 1;
        if (zzd2 == 1078008818) {
            c = 1;
        } else {
            c = 0;
        }
        if (c == 0) {
            j = -9223372036854775807L;
            i = -2147483647;
        } else if (zzg2.zzp()) {
            int i5 = zzf2 - 2;
            if ((((char) (bArr2[i5] << 8)) | (bArr2[zzf2 - 1] & 255)) == zzet.zzd(bArr2, 0, i5, 65535)) {
                int zzd3 = zzg2.zzd(2);
                if (zzd3 == 0) {
                    i3 = AdRequest.MAX_CONTENT_URL_LENGTH;
                } else if (zzd3 == 1) {
                    i3 = 480;
                } else if (zzd3 == 2) {
                    i3 = 384;
                } else {
                    throw zzbo.zza("Unsupported base duration index in DTS UHD header: " + zzd3, (Throwable) null);
                }
                int zzd4 = zzg2.zzd(3) + 1;
                int zzd5 = zzg2.zzd(2);
                if (zzd5 == 0) {
                    i4 = 32000;
                } else if (zzd5 == 1) {
                    i4 = 44100;
                } else if (zzd5 == 2) {
                    i4 = 48000;
                } else {
                    throw zzbo.zza("Unsupported clock rate index in DTS UHD header: " + zzd5, (Throwable) null);
                }
                if (zzg2.zzp()) {
                    zzg2.zzn(36);
                }
                i = (1 << zzg2.zzd(2)) * i4;
                j = zzet.zzt((long) (i3 * zzd4), 1000000, (long) i4, RoundingMode.FLOOR);
            } else {
                throw zzbo.zza("CRC check failed", (Throwable) null);
            }
        } else {
            throw zzbo.zzc("Only supports full channel mask-based audio presentation");
        }
        int i6 = i;
        long j2 = j;
        int i7 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            i7 += zzf(zzg2, zzg, true);
        }
        for (int i8 = 0; i8 <= 0; i8++) {
            if (c != 0) {
                atomicInteger.set(zzf(zzg2, zzh, true));
            } else {
                AtomicInteger atomicInteger2 = atomicInteger;
            }
            if (atomicInteger.get() != 0) {
                i2 = zzf(zzg2, zzi, true);
            } else {
                i2 = 0;
            }
            i7 += i2;
        }
        return new zzacg("audio/vnd.dts.uhd;profile=p2", 2, i6, zzf2 + i7, j2, 0, (zzacf) null);
    }

    private static int zzf(zzej zzej, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzej.zzp(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return zzej.zzd(iArr[i]) + i3;
    }

    private static zzej zzg(byte[] bArr) {
        byte b = bArr[0];
        if (b == Byte.MAX_VALUE || b == 100 || b == 64 || b == 113) {
            return new zzej(bArr, bArr.length);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = copyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b3 = copyOf[i];
                int i2 = i + 1;
                copyOf[i] = copyOf[i2];
                copyOf[i2] = b3;
            }
        }
        int length = copyOf.length;
        zzej zzej = new zzej(copyOf, length);
        if (copyOf[0] == 31) {
            zzej zzej2 = new zzej(copyOf, length);
            while (zzej2.zza() >= 16) {
                zzej2.zzn(2);
                zzej.zzg(zzej2.zzd(14), 14);
            }
        }
        zzej.zzk(copyOf, copyOf.length);
        return zzej;
    }
}
