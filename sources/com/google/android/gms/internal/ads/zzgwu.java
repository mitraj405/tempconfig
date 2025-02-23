package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwu extends zzgww {
    private final ByteBuffer zze;
    private final long zzf;
    private long zzg;
    private long zzh;
    private final long zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    public /* synthetic */ zzgwu(ByteBuffer byteBuffer, boolean z, zzgwt zzgwt) {
        super((zzgwv) null);
        this.zze = byteBuffer;
        long zze2 = zzhaz.zze(byteBuffer);
        this.zzf = zze2;
        this.zzg = ((long) byteBuffer.limit()) + zze2;
        long position = zze2 + ((long) byteBuffer.position());
        this.zzh = position;
        this.zzi = position;
    }

    private final int zzC() {
        return (int) (this.zzg - this.zzh);
    }

    private final void zzI() {
        long j = this.zzg + ((long) this.zzj);
        this.zzg = j;
        int i = (int) (j - this.zzi);
        int i2 = this.zzl;
        if (i > i2) {
            int i3 = i - i2;
            this.zzj = i3;
            this.zzg = j - ((long) i3);
            return;
        }
        this.zzj = 0;
    }

    public final boolean zzA() throws IOException {
        if (this.zzh == this.zzg) {
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
        return (int) (this.zzh - this.zzi);
    }

    public final int zzd(int i) throws zzgyn {
        if (i >= 0) {
            int zzc = i + zzc();
            int i2 = this.zzl;
            if (zzc <= i2) {
                this.zzl = zzc;
                zzI();
                return i2;
            }
            throw zzgyn.zzi();
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
        long j = this.zzh;
        if (this.zzg - j >= 4) {
            this.zzh = 4 + j;
            byte zza = zzhaz.zza(j) & UnsignedBytes.MAX_VALUE;
            byte zza2 = zzhaz.zza(1 + j) & UnsignedBytes.MAX_VALUE;
            byte zza3 = zzhaz.zza(2 + j) & UnsignedBytes.MAX_VALUE;
            return ((zzhaz.zza(j + 3) & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (zza2 << 8) | zza | (zza3 << Ascii.DLE);
        }
        throw zzgyn.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (com.google.android.gms.internal.ads.zzhaz.zza(r4) >= 0) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzi() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzh
            long r2 = r10.zzg
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x0087
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzhaz.zza(r0)
            if (r0 < 0) goto L_0x0017
            r10.zzh = r4
            return r0
        L_0x0017:
            long r6 = r10.zzg
            long r6 = r6 - r4
            r8 = 9
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x0087
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x002e
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0084
        L_0x002e:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x003d
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x003b:
            r6 = r4
            goto L_0x0084
        L_0x003d:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x004d
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0084
        L_0x004d:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x003b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L_0x0084
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L_0x003b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L_0x0084
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L_0x003b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 < 0) goto L_0x0087
        L_0x0084:
            r10.zzh = r6
            return r0
        L_0x0087:
            long r0 = r10.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwu.zzi():int");
    }

    public final int zzj() throws IOException {
        return zzh();
    }

    public final int zzk() throws IOException {
        return zzgww.zzD(zzi());
    }

    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzk = 0;
            return 0;
        }
        int zzi2 = zzi();
        this.zzk = zzi2;
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
        long j = this.zzh;
        if (this.zzg - j >= 8) {
            this.zzh = 8 + j;
            long zza = (long) zzhaz.zza(5 + j);
            long zza2 = (((long) zzhaz.zza(j)) & 255) | ((((long) zzhaz.zza(1 + j)) & 255) << 8) | ((((long) zzhaz.zza(2 + j)) & 255) << 16) | ((((long) zzhaz.zza(3 + j)) & 255) << 24) | ((((long) zzhaz.zza(4 + j)) & 255) << 32);
            return ((((long) zzhaz.zza(j + 7)) & 255) << 56) | zza2 | ((zza & 255) << 40) | ((((long) zzhaz.zza(6 + j)) & 255) << 48);
        }
        throw zzgyn.zzi();
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        long j3;
        byte b;
        long j4 = this.zzh;
        if (this.zzg != j4) {
            long j5 = j4 + 1;
            byte zza = zzhaz.zza(j4);
            if (zza >= 0) {
                this.zzh = j5;
                return (long) zza;
            } else if (this.zzg - j5 >= 9) {
                long j6 = j5 + 1;
                byte zza2 = zza ^ (zzhaz.zza(j5) << 7);
                if (zza2 < 0) {
                    b = zza2 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                } else {
                    long j7 = j6 + 1;
                    byte zza3 = zza2 ^ (zzhaz.zza(j6) << Ascii.SO);
                    if (zza3 >= 0) {
                        j = (long) (zza3 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                    } else {
                        j6 = j7 + 1;
                        byte zza4 = zza3 ^ (zzhaz.zza(j7) << Ascii.NAK);
                        if (zza4 < 0) {
                            b = zza4 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                        } else {
                            j7 = j6 + 1;
                            long zza5 = ((long) zza4) ^ (((long) zzhaz.zza(j6)) << 28);
                            if (zza5 >= 0) {
                                j3 = 266354560;
                            } else {
                                long j8 = j7 + 1;
                                long zza6 = zza5 ^ (((long) zzhaz.zza(j7)) << 35);
                                if (zza6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    j7 = j8 + 1;
                                    zza5 = zza6 ^ (((long) zzhaz.zza(j8)) << 42);
                                    if (zza5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        j8 = j7 + 1;
                                        zza6 = zza5 ^ (((long) zzhaz.zza(j7)) << 49);
                                        if (zza6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j7 = j8 + 1;
                                            j = (zza6 ^ (((long) zzhaz.zza(j8)) << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                long j9 = 1 + j7;
                                                if (((long) zzhaz.zza(j7)) >= 0) {
                                                    j6 = j9;
                                                    this.zzh = j6;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = zza6 ^ j2;
                                j6 = j8;
                                this.zzh = j6;
                                return j;
                            }
                            j = zza5 ^ j3;
                        }
                    }
                    j6 = j7;
                    this.zzh = j6;
                    return j;
                }
                j = (long) b;
                this.zzh = j6;
                return j;
            }
        }
        return zzr();
    }

    public final long zzr() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            long j2 = this.zzh;
            if (j2 != this.zzg) {
                this.zzh = 1 + j2;
                byte zza = zzhaz.zza(j2);
                j |= ((long) (zza & Ascii.DEL)) << i;
                if ((zza & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
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
        if (zzi2 > 0 && zzi2 <= zzC()) {
            byte[] bArr = new byte[zzi2];
            long j = (long) zzi2;
            zzhaz.zzo(this.zzh, bArr, 0, j);
            this.zzh += j;
            return new zzgwk(bArr);
        } else if (zzi2 == 0) {
            return zzgwm.zzb;
        } else {
            if (zzi2 < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
    }

    public final String zzw() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0 && zzi2 <= zzC()) {
            byte[] bArr = new byte[zzi2];
            long j = (long) zzi2;
            zzhaz.zzo(this.zzh, bArr, 0, j);
            String str = new String(bArr, zzgyl.zza);
            this.zzh += j;
            return str;
        } else if (zzi2 == 0) {
            return "";
        } else {
            if (zzi2 < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
    }

    public final String zzx() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0 && zzi2 <= zzC()) {
            String zzg2 = zzhbe.zzg(this.zze, (int) (this.zzh - this.zzf), zzi2);
            this.zzh += (long) zzi2;
            return zzg2;
        } else if (zzi2 == 0) {
            return "";
        } else {
            if (zzi2 <= 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
    }

    public final void zzy(int i) throws zzgyn {
        if (this.zzk != i) {
            throw zzgyn.zzb();
        }
    }

    public final void zzz(int i) {
        this.zzl = i;
        zzI();
    }
}
