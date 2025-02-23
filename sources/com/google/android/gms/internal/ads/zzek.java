package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzek {
    private static final char[] zza = {13, 10};
    private static final char[] zzb = {10};
    private static final zzfxw zzc = zzfxw.zzr(zzfuj.zza, zzfuj.zzc, zzfuj.zzf, zzfuj.zzd, zzfuj.zze);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzek(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
    }

    private final char zzN(Charset charset, char[] cArr) {
        int zzO = zzO(charset);
        if (zzO != 0) {
            int i = zzO >> 16;
            for (char c : cArr) {
                char c2 = (char) i;
                if (c == c2) {
                    this.zze += (char) zzO;
                    return c2;
                }
            }
        }
        return 0;
    }

    private final int zzO(Charset charset) {
        byte b;
        char zzb2;
        int i = 1;
        if (charset.equals(zzfuj.zzc) || charset.equals(zzfuj.zza)) {
            int i2 = this.zzf;
            int i3 = this.zze;
            if (i2 - i3 > 0) {
                b = (byte) zzgam.zza((long) (this.zzd[i3] & UnsignedBytes.MAX_VALUE));
                return (zzgam.zza((long) b) << 16) + i;
            }
        }
        if (charset.equals(zzfuj.zzf) || charset.equals(zzfuj.zzd)) {
            int i4 = this.zzf;
            int i5 = this.zze;
            if (i4 - i5 >= 2) {
                byte[] bArr = this.zzd;
                zzb2 = zzgam.zzb(bArr[i5], bArr[i5 + 1]);
                b = (byte) zzb2;
                i = 2;
                return (zzgam.zza((long) b) << 16) + i;
            }
        }
        if (!charset.equals(zzfuj.zze)) {
            return 0;
        }
        int i6 = this.zzf;
        int i7 = this.zze;
        if (i6 - i7 < 2) {
            return 0;
        }
        byte[] bArr2 = this.zzd;
        zzb2 = zzgam.zzb(bArr2[i7 + 1], bArr2[i7]);
        b = (byte) zzb2;
        i = 2;
        return (zzgam.zza((long) b) << 16) + i;
    }

    public final String zzA(int i, Charset charset) {
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String str = new String(bArr, i2, i, charset);
        this.zze = i2 + i;
        return str;
    }

    public final Charset zzB() {
        int i = this.zzf;
        int i2 = this.zze;
        int i3 = i - i2;
        if (i3 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.zze = i2 + 3;
                return zzfuj.zzc;
            }
        }
        if (i3 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b = bArr2[i2];
        if (b == -2) {
            if (bArr2[i2 + 1] != -1) {
                return null;
            }
            this.zze = i2 + 2;
            return zzfuj.zzd;
        } else if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        } else {
            this.zze = i2 + 2;
            return zzfuj.zze;
        }
    }

    public final short zzC() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        this.zze = i2 + 1;
        return (short) (((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8) | b);
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        this.zze = i2 + 1;
        return (short) ((bArr[i2] & UnsignedBytes.MAX_VALUE) | (b << 8));
    }

    public final void zzE(int i) {
        byte[] bArr = this.zzd;
        if (i > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i);
        }
    }

    public final void zzF(zzej zzej, int i) {
        zzG(zzej.zza, 0, i);
        zzej.zzl(0);
    }

    public final void zzG(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zzd, this.zze, bArr, i, i2);
        this.zze += i2;
    }

    public final void zzH(int i) {
        byte[] bArr = this.zzd;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzI(bArr, i);
    }

    public final void zzI(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
        this.zze = 0;
    }

    public final void zzJ(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzd.length) {
            z = true;
        }
        zzdi.zzd(z);
        this.zzf = i;
    }

    public final void zzK(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzf) {
            z = true;
        }
        zzdi.zzd(z);
        this.zze = i;
    }

    public final void zzL(int i) {
        zzK(this.zze + i);
    }

    public final byte[] zzM() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzdi.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        return (char) (zzO(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & UnsignedBytes.MAX_VALUE;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = i2 + 1;
        byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        int i4 = i3 + 1;
        byte b3 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        this.zze = i4 + 1;
        return (bArr[i4] & UnsignedBytes.MAX_VALUE) | (b << Ascii.CAN) | (b2 << Ascii.DLE) | (b3 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = i2 + 1;
        byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        this.zze = i3 + 1;
        return (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((b << Ascii.CAN) >> 8) | (b2 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = i2 + 1;
        byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        int i4 = i3 + 1;
        byte b3 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        this.zze = i4 + 1;
        return ((bArr[i4] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | b | (b2 << 8) | (b3 << Ascii.DLE);
    }

    public final int zzj() {
        int zzi = zzi();
        if (zzi >= 0) {
            return zzi;
        }
        throw new IllegalStateException(lf.h("Top bit not zero: ", zzi));
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        this.zze = i2 + 1;
        return ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8) | b;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        this.zze = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        this.zze = i2 + 1 + 2;
        return b2 | (b << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = i2 + 1;
        byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        this.zze = i3 + 1;
        return (bArr[i3] & UnsignedBytes.MAX_VALUE) | (b << Ascii.DLE) | (b2 << 8);
    }

    public final int zzp() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException(lf.h("Top bit not zero: ", zzg));
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        this.zze = i2 + 1;
        return (bArr[i2] & UnsignedBytes.MAX_VALUE) | (b << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        long j = (long) bArr[i];
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        int i6 = i5 + 1;
        long j5 = (long) bArr[i5];
        int i7 = i6 + 1;
        long j6 = (long) bArr[i6];
        int i8 = i7 + 1;
        long j7 = j;
        long j8 = (long) bArr[i7];
        this.zze = i8 + 1;
        long j9 = (j8 & 255) << 48;
        return ((((long) bArr[i8]) & 255) << 56) | j9 | (j7 & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        long j = (long) bArr[i];
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        this.zze = i4 + 1;
        return ((((long) bArr[i4]) & 255) << 24) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        long j = (long) bArr[i];
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        int i6 = i5 + 1;
        long j5 = (long) bArr[i5];
        int i7 = i6 + 1;
        long j6 = (long) bArr[i6];
        int i8 = i7 + 1;
        long j7 = j6;
        long j8 = (long) bArr[i7];
        this.zze = i8 + 1;
        return (((long) bArr[i8]) & 255) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j7 & 255) << 16) | ((j8 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        long j = (long) bArr[i];
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        this.zze = i4 + 1;
        return (((long) bArr[i4]) & 255) | ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8);
    }

    public final long zzv() {
        long zzt = zzt();
        if (zzt >= 0) {
            return zzt;
        }
        throw new IllegalStateException(C0709Uj.h("Top bit not zero: ", zzt));
    }

    public final long zzw() {
        int i;
        int i2;
        long j = (long) this.zzd[this.zze];
        int i3 = 7;
        while (true) {
            i = 0;
            i2 = 1;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i != 0) {
            while (i2 < i) {
                byte b = this.zzd[this.zze + i2];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & 63));
                    i2++;
                } else {
                    throw new NumberFormatException(C0709Uj.h("Invalid UTF-8 sequence continuation byte: ", j));
                }
            }
            this.zze += i;
            return j;
        }
        throw new NumberFormatException(C0709Uj.h("Invalid UTF-8 sequence first byte: ", j));
    }

    public final String zzx(char c) {
        int i = this.zzf;
        int i2 = this.zze;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.zzf && this.zzd[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zzd;
        int i3 = this.zze;
        String zzB = zzet.zzB(bArr, i3, i2 - i3);
        this.zze = i2;
        if (i2 < this.zzf) {
            this.zze = i2 + 1;
        }
        return zzB;
    }

    public final String zzy(Charset charset) {
        zzdi.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        if (this.zzf - this.zze == 0) {
            return null;
        }
        Charset charset2 = zzfuj.zza;
        if (!charset.equals(charset2)) {
            zzB();
        }
        int i = 1;
        if (!charset.equals(zzfuj.zzc) && !charset.equals(charset2)) {
            i = 2;
            if (!charset.equals(zzfuj.zzf) && !charset.equals(zzfuj.zze) && !charset.equals(zzfuj.zzd)) {
                throw new IllegalArgumentException("Unsupported charset: ".concat(String.valueOf(charset)));
            }
        }
        int i2 = this.zze;
        while (true) {
            int i3 = this.zzf;
            if (i2 >= i3 - (i - 1)) {
                i2 = i3;
                break;
            } else if ((charset.equals(zzfuj.zzc) || charset.equals(zzfuj.zza)) && zzet.zzM(this.zzd[i2])) {
                break;
            } else {
                if (charset.equals(zzfuj.zzf) || charset.equals(zzfuj.zzd)) {
                    byte[] bArr = this.zzd;
                    if (bArr[i2] == 0 && zzet.zzM(bArr[i2 + 1])) {
                        break;
                    }
                }
                if (charset.equals(zzfuj.zze)) {
                    byte[] bArr2 = this.zzd;
                    if (bArr2[i2 + 1] == 0 && zzet.zzM(bArr2[i2])) {
                        break;
                    }
                }
                i2 += i;
            }
        }
        String zzA = zzA(i2 - this.zze, charset);
        if (this.zze != this.zzf && zzN(charset, zza) == 13) {
            zzN(charset, zzb);
        }
        return zzA;
    }

    public final String zzz(int i) {
        int i2;
        if (i == 0) {
            return "";
        }
        int i3 = this.zze;
        int i4 = (i3 + i) - 1;
        if (i4 >= this.zzf || this.zzd[i4] != 0) {
            i2 = i;
        } else {
            i2 = i - 1;
        }
        String zzB = zzet.zzB(this.zzd, i3, i2);
        this.zze += i;
        return zzB;
    }

    public zzek() {
        this.zzd = zzet.zzf;
    }

    public zzek(int i) {
        this.zzd = new byte[i];
        this.zzf = i;
    }

    public zzek(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}
