package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & 63);
    }

    public static zzaf zzc(zzek zzek, String str, String str2, zzy zzy) {
        zzej zzej = new zzej();
        zzej.zzj(zzek);
        int i = zzc[zzej.zzd(2)];
        zzej.zzn(8);
        int i2 = zze[zzej.zzd(3)];
        if (zzej.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzej.zzd(5)] * 1000;
        zzej.zzf();
        zzek.zzK(zzej.zzb());
        zzad zzad = new zzad();
        zzad.zzK(str);
        zzad.zzX("audio/ac3");
        zzad.zzy(i2);
        zzad.zzY(i);
        zzad.zzE(zzy);
        zzad.zzO(str2);
        zzad.zzx(i3);
        zzad.zzS(i3);
        return zzad.zzad();
    }

    public static zzaf zzd(zzek zzek, String str, String str2, zzy zzy) {
        String str3;
        zzej zzej = new zzej();
        zzej.zzj(zzek);
        int zzd2 = zzej.zzd(13) * 1000;
        zzej.zzn(3);
        int i = zzc[zzej.zzd(2)];
        zzej.zzn(10);
        int i2 = zze[zzej.zzd(3)];
        if (zzej.zzd(1) != 0) {
            i2++;
        }
        zzej.zzn(3);
        int zzd3 = zzej.zzd(4);
        zzej.zzn(1);
        if (zzd3 > 0) {
            zzej.zzn(6);
            if (zzej.zzd(1) != 0) {
                i2 += 2;
            }
            zzej.zzn(1);
        }
        if (zzej.zza() > 7) {
            zzej.zzn(7);
            if (zzej.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzej.zzf();
                zzek.zzK(zzej.zzb());
                zzad zzad = new zzad();
                zzad.zzK(str);
                zzad.zzX(str3);
                zzad.zzy(i2);
                zzad.zzY(i);
                zzad.zzE(zzy);
                zzad.zzO(str2);
                zzad.zzS(zzd2);
                return zzad.zzad();
            }
        }
        str3 = "audio/eac3";
        zzej.zzf();
        zzek.zzK(zzej.zzb());
        zzad zzad2 = new zzad();
        zzad2.zzK(str);
        zzad2.zzX(str3);
        zzad2.zzy(i2);
        zzad2.zzY(i);
        zzad2.zzE(zzy);
        zzad2.zzO(str2);
        zzad2.zzS(zzd2);
        return zzad2.zzad();
    }

    public static zzabi zze(zzej zzej) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        String str2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3;
        zzej zzej2 = zzej;
        int zzc2 = zzej.zzc();
        zzej2.zzn(40);
        int zzd2 = zzej2.zzd(5);
        zzej2.zzl(zzc2);
        int i13 = -1;
        if (zzd2 > 10) {
            zzej2.zzn(16);
            int zzd3 = zzej2.zzd(2);
            if (zzd3 == 0) {
                i13 = 0;
            } else if (zzd3 == 1) {
                i13 = 1;
            } else if (zzd3 == 2) {
                i13 = 2;
            }
            zzej2.zzn(3);
            int zzd4 = zzej2.zzd(11) + 1;
            int zzd5 = zzej2.zzd(2);
            if (zzd5 == 3) {
                i10 = zzd[zzej2.zzd(2)];
                i8 = 6;
                i9 = 3;
            } else {
                int zzd6 = zzej2.zzd(2);
                int i14 = zzb[zzd6];
                i9 = zzd6;
                i10 = zzc[zzd5];
                i8 = i14;
            }
            int i15 = zzd4 + zzd4;
            int i16 = (i15 * i10) / (i8 * 32);
            int zzd7 = zzej2.zzd(3);
            boolean zzp = zzej.zzp();
            i6 = zze[zzd7] + (zzp ? 1 : 0);
            zzej2.zzn(10);
            if (zzej.zzp()) {
                zzej2.zzn(8);
            }
            if (zzd7 == 0) {
                zzej2.zzn(5);
                if (zzej.zzp()) {
                    zzej2.zzn(8);
                }
                i11 = 0;
                zzd7 = 0;
            } else {
                i11 = zzd7;
            }
            if (i13 == 1) {
                if (zzej.zzp()) {
                    zzej2.zzn(16);
                }
                i12 = 1;
            } else {
                i12 = i13;
            }
            if (zzej.zzp()) {
                if (i11 > 2) {
                    zzej2.zzn(2);
                }
                if ((i11 & 1) != 0 && i11 > 2) {
                    zzej2.zzn(6);
                }
                if ((i11 & 4) != 0) {
                    zzej2.zzn(6);
                }
                if (zzp && zzej.zzp()) {
                    zzej2.zzn(5);
                }
                if (i12 == 0) {
                    if (zzej.zzp()) {
                        zzej2.zzn(6);
                    }
                    if (i11 == 0 && zzej.zzp()) {
                        zzej2.zzn(6);
                    }
                    if (zzej.zzp()) {
                        zzej2.zzn(6);
                    }
                    int zzd8 = zzej2.zzd(2);
                    if (zzd8 == 1) {
                        zzej2.zzn(5);
                    } else if (zzd8 == 2) {
                        zzej2.zzn(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzej2.zzd(5);
                        if (zzej.zzp()) {
                            zzej2.zzn(5);
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                zzej2.zzn(4);
                            }
                            if (zzej.zzp()) {
                                if (zzej.zzp()) {
                                    zzej2.zzn(4);
                                }
                                if (zzej.zzp()) {
                                    zzej2.zzn(4);
                                }
                            }
                        }
                        if (zzej.zzp()) {
                            zzej2.zzn(5);
                            if (zzej.zzp()) {
                                zzej2.zzn(7);
                                if (zzej.zzp()) {
                                    zzej2.zzn(8);
                                }
                            }
                        }
                        zzej2.zzn((zzd9 + 2) * 8);
                        zzej.zzf();
                    }
                    if (i11 < 2) {
                        if (zzej.zzp()) {
                            zzej2.zzn(14);
                        }
                        if (zzd7 == 0 && zzej.zzp()) {
                            zzej2.zzn(14);
                        }
                    }
                    if (zzej.zzp()) {
                        if (i9 == 0) {
                            zzej2.zzn(5);
                            i12 = 0;
                            i9 = 0;
                        } else {
                            for (int i17 = 0; i17 < i8; i17++) {
                                if (zzej.zzp()) {
                                    zzej2.zzn(5);
                                }
                            }
                        }
                    }
                    i12 = 0;
                }
            }
            if (zzej.zzp()) {
                zzej2.zzn(5);
                if (i11 == 2) {
                    zzej2.zzn(4);
                    i11 = 2;
                }
                if (i11 >= 6) {
                    zzej2.zzn(2);
                }
                if (zzej.zzp()) {
                    zzej2.zzn(8);
                }
                if (i11 == 0 && zzej.zzp()) {
                    zzej2.zzn(8);
                }
                if (zzd5 < 3) {
                    zzej.zzm();
                }
            }
            if (i12 == 0 && i9 != 3) {
                zzej.zzm();
            }
            if (i12 == 2 && (i9 == 3 || zzej.zzp())) {
                zzej2.zzn(6);
            }
            if (zzej.zzp() && zzej2.zzd(6) == 1 && zzej2.zzd(8) == 1) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
            str = str3;
            i5 = i13;
            i3 = i15;
            i4 = i10;
            i2 = i8 * 256;
            i = i16;
        } else {
            zzej2.zzn(32);
            int zzd10 = zzej2.zzd(2);
            if (zzd10 == 3) {
                str2 = null;
            } else {
                str2 = "audio/ac3";
            }
            int zzd11 = zzej2.zzd(6);
            int i18 = zzf[zzd11 / 2] * 1000;
            int zzf2 = zzf(zzd10, zzd11);
            zzej2.zzn(8);
            int zzd12 = zzej2.zzd(3);
            if (!((zzd12 & 1) == 0 || zzd12 == 1)) {
                zzej2.zzn(2);
            }
            if ((zzd12 & 4) != 0) {
                zzej2.zzn(2);
            }
            if (zzd12 == 2) {
                zzej2.zzn(2);
            }
            if (zzd10 < 3) {
                i7 = zzc[zzd10];
            } else {
                i7 = -1;
            }
            i6 = zze[zzd12] + (zzej.zzp() ? 1 : 0);
            i5 = -1;
            str = str2;
            i = i18;
            i3 = zzf2;
            i4 = i7;
            i2 = 1536;
        }
        return new zzabi(str, i5, i6, i4, i3, i2, i, (zzabh) null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        if (i4 == 32000) {
            return i6 * 6;
        }
        return i6 * 4;
    }
}
