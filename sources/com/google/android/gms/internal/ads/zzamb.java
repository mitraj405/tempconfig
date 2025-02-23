package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamb implements zzamf {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzej zzc = new zzej(new byte[7], 7);
    private final zzek zzd = new zzek(Arrays.copyOf(zza, 10));
    private final String zze;
    private final int zzf;
    private String zzg;
    private zzadp zzh;
    private zzadp zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private zzadp zzv;
    private long zzw;

    public zzamb(boolean z, String str, int i) {
        zzh();
        this.zzo = -1;
        this.zzp = -1;
        this.zzs = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
    }

    public static boolean zzf(int i) {
        if ((i & 65526) == 65520) {
            return true;
        }
        return false;
    }

    private final void zzg() {
        this.zzn = false;
        zzh();
    }

    private final void zzh() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 256;
    }

    private final void zzi() {
        this.zzj = 3;
        this.zzk = 0;
    }

    private final void zzj(zzadp zzadp, long j, int i, int i2) {
        this.zzj = 4;
        this.zzk = i;
        this.zzv = zzadp;
        this.zzw = j;
        this.zzt = i2;
    }

    private final boolean zzk(zzek zzek, byte[] bArr, int i) {
        int min = Math.min(zzek.zzb(), i - this.zzk);
        zzek.zzG(bArr, this.zzk, min);
        int i2 = this.zzk + min;
        this.zzk = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & UnsignedBytes.MAX_VALUE) | Ascii.NUL);
    }

    private static final boolean zzm(zzek zzek, byte[] bArr, int i) {
        if (zzek.zzb() < i) {
            return false;
        }
        zzek.zzG(bArr, 0, i);
        return true;
    }

    public final void zza(zzek zzek) throws zzbo {
        int i;
        byte b;
        int i2;
        int i3;
        boolean z;
        int i4;
        zzek zzek2 = zzek;
        this.zzh.getClass();
        int i5 = zzet.zza;
        while (zzek.zzb() > 0) {
            int i6 = this.zzj;
            int i7 = 13;
            boolean z2 = false;
            int i8 = 2;
            if (i6 == 0) {
                byte[] zzM = zzek.zzM();
                int zzd2 = zzek.zzd();
                int zze2 = zzek.zze();
                while (true) {
                    if (zzd2 >= zze2) {
                        zzek2.zzK(zzd2);
                        break;
                    }
                    i = zzd2 + 1;
                    b = zzM[zzd2] & UnsignedBytes.MAX_VALUE;
                    if (this.zzl == 512 && zzl((byte) -1, (byte) b)) {
                        if (this.zzn) {
                            break;
                        }
                        int i9 = i - 2;
                        zzek2.zzK(i9 + 1);
                        if (zzm(zzek2, this.zzc.zza, 1)) {
                            this.zzc.zzl(4);
                            int zzd3 = this.zzc.zzd(1);
                            int i10 = this.zzo;
                            if (i10 == -1 || zzd3 == i10) {
                                if (this.zzp != -1) {
                                    if (!zzm(zzek2, this.zzc.zza, 1)) {
                                        break;
                                    }
                                    this.zzc.zzl(i8);
                                    if (this.zzc.zzd(4) == this.zzp) {
                                        zzek2.zzK(i9 + 2);
                                    }
                                }
                                if (!zzm(zzek2, this.zzc.zza, 4)) {
                                    break;
                                }
                                this.zzc.zzl(14);
                                int zzd4 = this.zzc.zzd(i7);
                                if (zzd4 >= 7) {
                                    byte[] zzM2 = zzek.zzM();
                                    int zze3 = zzek.zze();
                                    int i11 = i9 + zzd4;
                                    if (i11 < zze3) {
                                        byte b2 = zzM2[i11];
                                        if (b2 != -1) {
                                            if (b2 == 73) {
                                                int i12 = i11 + 1;
                                                if (i12 != zze3) {
                                                    if (zzM2[i12] == 68) {
                                                        int i13 = i11 + 2;
                                                        if (i13 != zze3) {
                                                            if (zzM2[i13] == 51) {
                                                                break;
                                                            }
                                                        } else {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            int i14 = i11 + 1;
                                            if (i14 == zze3) {
                                                break;
                                            }
                                            byte b3 = zzM2[i14];
                                            if (zzl((byte) -1, b3) && ((b3 & 8) >> 3) == zzd3) {
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    int i15 = this.zzl;
                    byte b4 = i15 | b;
                    if (b4 == 329) {
                        i2 = 2;
                        i3 = ViewUtils.EDGE_TO_EDGE_FLAGS;
                    } else if (b4 == 511) {
                        i2 = 2;
                        i3 = AdRequest.MAX_CONTENT_URL_LENGTH;
                    } else if (b4 != 836) {
                        if (b4 == 1075) {
                            this.zzj = 2;
                            this.zzk = 3;
                            this.zzt = 0;
                            this.zzd.zzK(0);
                            zzek2.zzK(i);
                            break;
                        } else if (i15 != 256) {
                            this.zzl = 256;
                            zzd2 = i - 1;
                            i7 = 13;
                            i8 = 2;
                        } else {
                            i2 = 2;
                            i8 = i2;
                            zzd2 = i;
                            i7 = 13;
                        }
                    } else {
                        i2 = 2;
                        i3 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    this.zzl = i3;
                    i8 = i2;
                    zzd2 = i;
                    i7 = 13;
                }
                this.zzq = (b & 8) >> 3;
                if (1 != ((b & 1) ^ 1)) {
                    z = false;
                } else {
                    z = true;
                }
                this.zzm = z;
                if (!this.zzn) {
                    this.zzj = 1;
                    this.zzk = 0;
                } else {
                    zzi();
                }
                zzek2.zzK(i);
            } else if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        int min = Math.min(zzek.zzb(), this.zzt - this.zzk);
                        this.zzv.zzq(zzek2, min);
                        int i16 = this.zzk + min;
                        this.zzk = i16;
                        if (i16 == this.zzt) {
                            if (this.zzu != -9223372036854775807L) {
                                z2 = true;
                            }
                            zzdi.zzf(z2);
                            this.zzv.zzs(this.zzu, 1, this.zzt, 0, (zzado) null);
                            this.zzu += this.zzw;
                            zzh();
                        }
                    } else {
                        if (true != this.zzm) {
                            i4 = 5;
                        } else {
                            i4 = 7;
                        }
                        if (zzk(zzek2, this.zzc.zza, i4)) {
                            this.zzc.zzl(0);
                            if (!this.zzr) {
                                int zzd5 = this.zzc.zzd(2) + 1;
                                if (zzd5 != 2) {
                                    zzea.zzf("AdtsReader", "Detected audio object type: " + zzd5 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzn(5);
                                int zzd6 = this.zzc.zzd(3);
                                int i17 = this.zzp;
                                byte[] bArr = {(byte) (((i17 >> 1) & 7) | 16), (byte) (((zzd6 << 3) & 120) | ((i17 << 7) & 128))};
                                zzabf zza2 = zzabg.zza(bArr);
                                zzad zzad = new zzad();
                                zzad.zzK(this.zzg);
                                zzad.zzX("audio/mp4a-latm");
                                zzad.zzz(zza2.zzc);
                                zzad.zzy(zza2.zzb);
                                zzad.zzY(zza2.zza);
                                zzad.zzL(Collections.singletonList(bArr));
                                zzad.zzO(this.zze);
                                zzad.zzV(this.zzf);
                                zzaf zzad2 = zzad.zzad();
                                this.zzs = 1024000000 / ((long) zzad2.zzA);
                                this.zzh.zzl(zzad2);
                                this.zzr = true;
                            } else {
                                this.zzc.zzn(10);
                            }
                            this.zzc.zzn(4);
                            int zzd7 = this.zzc.zzd(13) - 7;
                            if (this.zzm) {
                                zzd7 -= 2;
                            }
                            zzj(this.zzh, this.zzs, 0, zzd7);
                        }
                    }
                } else if (zzk(zzek2, this.zzd.zzM(), 10)) {
                    this.zzi.zzq(this.zzd, 10);
                    this.zzd.zzK(6);
                    zzj(this.zzi, 0, 10, 10 + this.zzd.zzl());
                }
            } else if (zzek.zzb() != 0) {
                zzej zzej = this.zzc;
                zzej.zza[0] = zzek.zzM()[zzek.zzd()];
                zzej.zzl(2);
                int zzd8 = this.zzc.zzd(4);
                int i18 = this.zzp;
                if (i18 == -1 || zzd8 == i18) {
                    if (!this.zzn) {
                        this.zzn = true;
                        this.zzo = this.zzq;
                        this.zzp = zzd8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zzg = zzans.zzb();
        zzadp zzw2 = zzacn.zzw(zzans.zza(), 1);
        this.zzh = zzw2;
        this.zzv = zzw2;
        if (this.zzb) {
            zzans.zzc();
            zzadp zzw3 = zzacn.zzw(zzans.zza(), 5);
            this.zzi = zzw3;
            zzad zzad = new zzad();
            zzad.zzK(zzans.zzb());
            zzad.zzX("application/id3");
            zzw3.zzl(zzad.zzad());
            return;
        }
        this.zzi = new zzacj();
    }

    public final void zzd(long j, int i) {
        this.zzu = j;
    }

    public final void zze() {
        this.zzu = -9223372036854775807L;
        zzg();
    }

    public final void zzc(boolean z) {
    }
}
