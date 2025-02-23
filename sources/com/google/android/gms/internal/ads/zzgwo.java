package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwo extends zzgww {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk = Integer.MAX_VALUE;

    public /* synthetic */ zzgwo(byte[] bArr, int i, int i2, boolean z, zzgwn zzgwn) {
        super((zzgwv) null);
        this.zze = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzC() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    public final boolean zzA() throws IOException {
        if (this.zzh == this.zzf) {
            return true;
        }
        return false;
    }

    public final boolean zzB() throws IOException {
        if (zzq() != 0) {
            return true;
        }
        return false;
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    public final int zzc() {
        return this.zzh - this.zzi;
    }

    public final int zzd(int i) throws zzgyn {
        if (i >= 0) {
            int i2 = (this.zzh - this.zzi) + i;
            if (i2 >= 0) {
                int i3 = this.zzk;
                if (i2 <= i3) {
                    this.zzk = i2;
                    zzC();
                    return i3;
                }
                throw zzgyn.zzi();
            }
            throw zzgyn.zzg();
        }
        throw zzgyn.zzf();
    }

    public final int zze() throws IOException {
        return zzi();
    }

    public final int zzf() throws IOException {
        return zzh();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        int i = this.zzh;
        if (this.zzf - i >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i + 4;
            byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
            byte b2 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
            byte b3 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
            return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (b2 << 8) | b | (b3 << Ascii.DLE);
        }
        throw zzgyn.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] < 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzi() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzh = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x006a
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r5.zzh = r1
            return r0
        L_0x006d:
            long r0 = r5.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwo.zzi():int");
    }

    public final int zzj() throws IOException {
        return zzh();
    }

    public final int zzk() throws IOException {
        return zzgww.zzD(zzi());
    }

    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzj = 0;
            return 0;
        }
        int zzi2 = zzi();
        this.zzj = zzi2;
        if ((zzi2 >>> 3) != 0) {
            return zzi2;
        }
        throw zzgyn.zzc();
    }

    public final int zzm() throws IOException {
        return zzi();
    }

    public final long zzn() throws IOException {
        return zzp();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        int i = this.zzh;
        if (this.zzf - i >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i + 8;
            long j = (long) bArr[i + 2];
            long j2 = (long) bArr[i + 3];
            long j3 = (long) bArr[i + 4];
            long j4 = (long) bArr[i + 5];
            long j5 = (long) bArr[i + 6];
            long j6 = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((j & 255) << 16) | ((j2 & 255) << 24);
            return ((((long) bArr[i + 7]) & 255) << 56) | j6 | ((j3 & 255) << 32) | ((j4 & 255) << 40) | ((j5 & 255) << 48);
        }
        throw zzgyn.zzi();
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzh = i3;
                return (long) b2;
            } else if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << Ascii.SO);
                    if (b4 >= 0) {
                        j2 = (long) (b4 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << Ascii.NAK);
                        if (b5 < 0) {
                            b = b5 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                        } else {
                            i5 = i4 + 1;
                            long j5 = ((long) b5) ^ (((long) bArr[i4]) << 28);
                            if (j5 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i6 = i5 + 1;
                                long j6 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i6 + 1;
                                    j5 = j6 ^ (((long) bArr[i6]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i5 + 1;
                                        j6 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i6 + 1;
                                            j2 = (j6 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i6 = i5 + 1;
                                                if (((long) bArr[i5]) >= 0) {
                                                    j = j2;
                                                    i4 = i6;
                                                    this.zzh = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzh = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzh = i4;
                    return j;
                }
                j = (long) b;
                this.zzh = i4;
                return j;
            }
        }
        return zzr();
    }

    public final long zzr() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            int i2 = this.zzh;
            if (i2 != this.zzf) {
                byte[] bArr = this.zze;
                this.zzh = i2 + 1;
                byte b = bArr[i2];
                j |= ((long) (b & Ascii.DEL)) << i;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j;
                }
                i += 7;
            } else {
                throw zzgyn.zzi();
            }
        }
        throw zzgyn.zze();
    }

    public final long zzs() throws IOException {
        return zzp();
    }

    public final long zzt() throws IOException {
        return zzgww.zzF(zzq());
    }

    public final long zzu() throws IOException {
        return zzq();
    }

    public final zzgwm zzv() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                zzgwm zzv = zzgwm.zzv(this.zze, i2, zzi2);
                this.zzh += zzi2;
                return zzv;
            }
        }
        if (zzi2 == 0) {
            return zzgwm.zzb;
        }
        if (zzi2 > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (zzi2 <= i3 - i4) {
                int i5 = zzi2 + i4;
                this.zzh = i5;
                return new zzgwk(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (zzi2 <= 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    public final String zzw() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                String str = new String(this.zze, i2, zzi2, zzgyl.zza);
                this.zzh += zzi2;
                return str;
            }
        }
        if (zzi2 == 0) {
            return "";
        }
        if (zzi2 < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    public final String zzx() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                String zzh2 = zzhbe.zzh(this.zze, i2, zzi2);
                this.zzh += zzi2;
                return zzh2;
            }
        }
        if (zzi2 == 0) {
            return "";
        }
        if (zzi2 <= 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    public final void zzy(int i) throws zzgyn {
        if (this.zzj != i) {
            throw zzgyn.zzb();
        }
    }

    public final void zzz(int i) {
        this.zzk = i;
        zzC();
    }
}
