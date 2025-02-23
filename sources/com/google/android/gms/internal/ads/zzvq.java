package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzvq {
    private final zzek zza = new zzek(32);
    private zzvp zzb;
    private zzvp zzc;
    private zzvp zzd;
    private long zze;
    private final zzyk zzf;

    public zzvq(zzyk zzyk) {
        this.zzf = zzyk;
        zzvp zzvp = new zzvp(0, 65536);
        this.zzb = zzvp;
        this.zzc = zzvp;
        this.zzd = zzvp;
    }

    private final int zzi(int i) {
        zzvp zzvp = this.zzd;
        if (zzvp.zzc == null) {
            zzyd zzb2 = this.zzf.zzb();
            zzvp zzvp2 = new zzvp(this.zzd.zzb, 65536);
            zzvp.zzc = zzb2;
            zzvp.zzd = zzvp2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvp zzj(zzvp zzvp, long j) {
        while (j >= zzvp.zzb) {
            zzvp = zzvp.zzd;
        }
        return zzvp;
    }

    private static zzvp zzk(zzvp zzvp, long j, ByteBuffer byteBuffer, int i) {
        zzvp zzj = zzj(zzvp, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvp zzl(zzvp zzvp, long j, byte[] bArr, int i) {
        zzvp zzj = zzj(zzvp, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvp zzm(zzvp zzvp, zzhd zzhd, zzvs zzvs, zzek zzek) {
        zzvp zzvp2;
        boolean z;
        zzhd zzhd2 = zzhd;
        zzvs zzvs2 = zzvs;
        zzek zzek2 = zzek;
        if (zzhd.zzk()) {
            long j = zzvs2.zzb;
            int i = 1;
            zzek2.zzH(1);
            zzvp zzl = zzl(zzvp, j, zzek.zzM(), 1);
            long j2 = j + 1;
            byte b = zzek.zzM()[0];
            byte b2 = b & UnsignedBytes.MAX_POWER_OF_TWO;
            byte b3 = b & Ascii.DEL;
            zzha zzha = zzhd2.zzb;
            byte[] bArr = zzha.zza;
            if (bArr == null) {
                zzha.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            if (b2 != 0) {
                z = true;
            } else {
                z = false;
            }
            zzvp2 = zzl(zzl, j2, zzha.zza, b3);
            long j3 = j2 + ((long) b3);
            if (z) {
                zzek2.zzH(2);
                zzvp2 = zzl(zzvp2, j3, zzek.zzM(), 2);
                j3 += 2;
                i = zzek.zzq();
            }
            int i2 = i;
            int[] iArr = zzha.zzd;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzha.zze;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i2 * 6;
                zzek2.zzH(i3);
                zzvp2 = zzl(zzvp2, j3, zzek.zzM(), i3);
                j3 += (long) i3;
                zzek2.zzK(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = zzek.zzq();
                    iArr4[i4] = zzek.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzvs2.zza - ((int) (j3 - zzvs2.zzb));
            }
            zzado zzado = zzvs2.zzc;
            int i5 = zzet.zza;
            zzha.zzc(i2, iArr2, iArr4, zzado.zzb, zzha.zza, zzado.zza, zzado.zzc, zzado.zzd);
            long j4 = zzvs2.zzb;
            int i6 = (int) (j3 - j4);
            zzvs2.zzb = j4 + ((long) i6);
            zzvs2.zza -= i6;
        } else {
            zzvp2 = zzvp;
        }
        if (zzhd.zze()) {
            zzek2.zzH(4);
            zzvp zzl2 = zzl(zzvp2, zzvs2.zzb, zzek.zzM(), 4);
            int zzp = zzek.zzp();
            zzvs2.zzb += 4;
            zzvs2.zza -= 4;
            zzhd2.zzi(zzp);
            zzvp zzk = zzk(zzl2, zzvs2.zzb, zzhd2.zzc, zzp);
            zzvs2.zzb += (long) zzp;
            int i7 = zzvs2.zza - zzp;
            zzvs2.zza = i7;
            ByteBuffer byteBuffer = zzhd2.zzf;
            if (byteBuffer == null || byteBuffer.capacity() < i7) {
                zzhd2.zzf = ByteBuffer.allocate(i7);
            } else {
                zzhd2.zzf.clear();
            }
            return zzk(zzk, zzvs2.zzb, zzhd2.zzf, zzvs2.zza);
        }
        zzhd2.zzi(zzvs2.zza);
        return zzk(zzvp2, zzvs2.zzb, zzhd2.zzc, zzvs2.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzvp zzvp = this.zzd;
        if (j == zzvp.zzb) {
            this.zzd = zzvp.zzd;
        }
    }

    public final int zza(zzp zzp, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzvp zzvp = this.zzd;
        int zza2 = zzp.zza(zzvp.zzc.zza, zzvp.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvp zzvp;
        if (j != -1) {
            while (true) {
                zzvp = this.zzb;
                if (j < zzvp.zzb) {
                    break;
                }
                this.zzf.zzc(zzvp.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvp.zza) {
                this.zzc = zzvp;
            }
        }
    }

    public final void zzd(zzhd zzhd, zzvs zzvs) {
        zzm(this.zzc, zzhd, zzvs, this.zza);
    }

    public final void zze(zzhd zzhd, zzvs zzvs) {
        this.zzc = zzm(this.zzc, zzhd, zzvs, this.zza);
    }

    public final void zzf() {
        zzvp zzvp = this.zzb;
        if (zzvp.zzc != null) {
            this.zzf.zzd(zzvp);
            zzvp.zzb();
        }
        this.zzb.zze(0, 65536);
        zzvp zzvp2 = this.zzb;
        this.zzc = zzvp2;
        this.zzd = zzvp2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzek zzek, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzvp zzvp = this.zzd;
            zzek.zzG(zzvp.zzc.zza, zzvp.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
