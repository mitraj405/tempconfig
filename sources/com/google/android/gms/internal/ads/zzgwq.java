package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwq extends zzgww {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    public /* synthetic */ zzgwq(Iterable iterable, int i, boolean z, zzgwp zzgwp) {
        super((zzgwv) null);
        this.zzh = i;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i == 0) {
            this.zzg = zzgyl.zzc;
            this.zzm = 0;
            this.zzn = 0;
            this.zzo = 0;
            return;
        }
        zzM();
    }

    private final int zzI() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzJ() throws zzgyn {
        if (this.zzf.hasNext()) {
            zzM();
            return;
        }
        throw zzgyn.zzi();
    }

    private final void zzK(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= zzI()) {
            int i3 = i2;
            while (i3 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzJ();
                }
                int min = Math.min(i3, (int) (this.zzo - this.zzm));
                long j = (long) min;
                zzhaz.zzo(this.zzm, bArr, (long) (i2 - i3), j);
                i3 -= min;
                this.zzm += j;
            }
        } else if (i2 > 0) {
            throw zzgyn.zzi();
        }
    }

    private final void zzL() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzj;
        if (i > i2) {
            int i3 = i - i2;
            this.zzi = i3;
            this.zzh = i - i3;
            return;
        }
        this.zzi = 0;
    }

    private final void zzM() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = (long) byteBuffer.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = (long) this.zzg.limit();
        long zze2 = zzhaz.zze(this.zzg);
        this.zzm += zze2;
        this.zzn += zze2;
        this.zzo += zze2;
    }

    public final boolean zzA() throws IOException {
        if ((((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh)) {
            return true;
        }
        return false;
    }

    public final boolean zzB() throws IOException {
        if (zzr() != 0) {
            return true;
        }
        return false;
    }

    public final long zzC() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzh2 = zzh();
            j |= ((long) (zzh2 & Ascii.DEL)) << i;
            if ((zzh2 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw zzgyn.zze();
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzc() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    public final int zzd(int i) throws zzgyn {
        if (i >= 0) {
            int zzc = i + zzc();
            int i2 = this.zzj;
            if (zzc <= i2) {
                this.zzj = zzc;
                zzL();
                return i2;
            }
            throw zzgyn.zzi();
        }
        throw zzgyn.zzf();
    }

    public final int zze() throws IOException {
        return zzp();
    }

    public final int zzf() throws IOException {
        return zzi();
    }

    public final int zzg() throws IOException {
        return zzp();
    }

    public final byte zzh() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzJ();
        }
        long j = this.zzm;
        this.zzm = 1 + j;
        return zzhaz.zza(j);
    }

    public final int zzi() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 4) {
            this.zzm = 4 + j2;
            return (zzhaz.zza(j2) & UnsignedBytes.MAX_VALUE) | ((zzhaz.zza(1 + j2) & UnsignedBytes.MAX_VALUE) << 8) | ((zzhaz.zza(2 + j2) & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((zzhaz.zza(j2 + 3) & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
        }
        return (zzh() & UnsignedBytes.MAX_VALUE) | ((zzh() & UnsignedBytes.MAX_VALUE) << 8) | ((zzh() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((zzh() & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
    }

    public final int zzj() throws IOException {
        return zzi();
    }

    public final int zzk() throws IOException {
        return zzgww.zzD(zzp());
    }

    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzk = 0;
            return 0;
        }
        int zzp = zzp();
        this.zzk = zzp;
        if ((zzp >>> 3) != 0) {
            return zzp;
        }
        throw zzgyn.zzc();
    }

    public final int zzm() throws IOException {
        return zzp();
    }

    public final long zzn() throws IOException {
        return zzq();
    }

    public final long zzo() throws IOException {
        return zzr();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzhaz.zza(r4) >= 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzp() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x008c
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzhaz.zza(r0)
            if (r0 < 0) goto L_0x001a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L_0x001a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x008c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0033
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0089
        L_0x0033:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0042
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x0040:
            r6 = r4
            goto L_0x0089
        L_0x0042:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0052
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0089
        L_0x0052:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 < 0) goto L_0x008c
        L_0x0089:
            r10.zzm = r6
            return r0
        L_0x008c:
            long r0 = r10.zzC()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwq.zzp():int");
    }

    public final long zzq() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 8) {
            this.zzm = 8 + j2;
            byte zza = zzhaz.zza(j2 + 4);
            long j3 = j2;
            byte zza2 = zzhaz.zza(j3 + 5);
            long zza3 = ((long) zzhaz.zza(j2)) & 255;
            byte zza4 = zzhaz.zza(j3 + 6);
            long zza5 = (((long) zzhaz.zza(1 + j2)) & 255) << 8;
            byte zza6 = zzhaz.zza(j3 + 7);
            return ((((long) zza) & 255) << 32) | zza3 | zza5 | ((((long) zzhaz.zza(j2 + 2)) & 255) << 16) | ((((long) zzhaz.zza(3 + j2)) & 255) << 24) | ((((long) zza2) & 255) << 40) | ((((long) zza4) & 255) << 48) | ((((long) zza6) & 255) << 56);
        }
        long zzh2 = (((long) zzh()) & 255) << 8;
        return (((long) zzh()) & 255) | zzh2 | ((((long) zzh()) & 255) << 16) | ((((long) zzh()) & 255) << 24) | ((((long) zzh()) & 255) << 32) | ((((long) zzh()) & 255) << 40) | ((((long) zzh()) & 255) << 48) | ((((long) zzh()) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long j;
        long j2;
        long j3;
        byte b;
        long j4 = this.zzm;
        if (this.zzo != j4) {
            long j5 = j4 + 1;
            byte zza = zzhaz.zza(j4);
            if (zza >= 0) {
                this.zzm++;
                return (long) zza;
            } else if (this.zzo - this.zzm >= 10) {
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
                                                    this.zzm = j6;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = zza6 ^ j2;
                                j6 = j8;
                                this.zzm = j6;
                                return j;
                            }
                            j = zza5 ^ j3;
                        }
                    }
                    j6 = j7;
                    this.zzm = j6;
                    return j;
                }
                j = (long) b;
                this.zzm = j6;
                return j;
            }
        }
        return zzC();
    }

    public final long zzs() throws IOException {
        return zzq();
    }

    public final long zzt() throws IOException {
        return zzgww.zzF(zzr());
    }

    public final long zzu() throws IOException {
        return zzr();
    }

    public final zzgwm zzv() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzp];
                zzhaz.zzo(j2, bArr, 0, j3);
                this.zzm += j3;
                return new zzgwk(bArr);
            }
        }
        if (zzp > 0 && zzp <= zzI()) {
            byte[] bArr2 = new byte[zzp];
            zzK(bArr2, 0, zzp);
            return new zzgwk(bArr2);
        } else if (zzp == 0) {
            return zzgwm.zzb;
        } else {
            if (zzp < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
    }

    public final String zzw() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzp];
                zzhaz.zzo(j2, bArr, 0, j3);
                String str = new String(bArr, zzgyl.zza);
                this.zzm += j3;
                return str;
            }
        }
        if (zzp > 0 && zzp <= zzI()) {
            byte[] bArr2 = new byte[zzp];
            zzK(bArr2, 0, zzp);
            return new String(bArr2, zzgyl.zza);
        } else if (zzp == 0) {
            return "";
        } else {
            if (zzp < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
    }

    public final String zzx() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                String zzg2 = zzhbe.zzg(this.zzg, (int) (j2 - this.zzn), zzp);
                this.zzm += j3;
                return zzg2;
            }
        }
        if (zzp >= 0 && zzp <= zzI()) {
            byte[] bArr = new byte[zzp];
            zzK(bArr, 0, zzp);
            return zzhbe.zzh(bArr, 0, zzp);
        } else if (zzp == 0) {
            return "";
        } else {
            if (zzp <= 0) {
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
        this.zzj = i;
        zzL();
    }
}
