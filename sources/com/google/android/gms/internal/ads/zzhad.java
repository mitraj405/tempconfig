package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzhad extends zzgwm {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzgwm zzd;
    /* access modifiers changed from: private */
    public final zzgwm zze;
    private final int zzf;
    private final int zzg;

    public static zzgwm zzC(zzgwm zzgwm, zzgwm zzgwm2) {
        if (zzgwm2.zzd() == 0) {
            return zzgwm;
        }
        if (zzgwm.zzd() == 0) {
            return zzgwm2;
        }
        int zzd2 = zzgwm2.zzd() + zzgwm.zzd();
        if (zzd2 < 128) {
            return zzD(zzgwm, zzgwm2);
        }
        if (zzgwm instanceof zzhad) {
            zzhad zzhad = (zzhad) zzgwm;
            if (zzgwm2.zzd() + zzhad.zze.zzd() < 128) {
                return new zzhad(zzhad.zzd, zzD(zzhad.zze, zzgwm2));
            }
            if (zzhad.zzd.zzf() > zzhad.zze.zzf() && zzhad.zzg > zzgwm2.zzf()) {
                return new zzhad(zzhad.zzd, new zzhad(zzhad.zze, zzgwm2));
            }
        }
        if (zzd2 >= zzc(Math.max(zzgwm.zzf(), zzgwm2.zzf()) + 1)) {
            return new zzhad(zzgwm, zzgwm2);
        }
        return zzgzz.zza(new zzgzz((zzgzy) null), zzgwm, zzgwm2);
    }

    private static zzgwm zzD(zzgwm zzgwm, zzgwm zzgwm2) {
        int zzd2 = zzgwm.zzd();
        int zzd3 = zzgwm2.zzd();
        byte[] bArr = new byte[(zzd2 + zzd3)];
        zzgwm.zzz(bArr, 0, 0, zzd2);
        zzgwm2.zzz(bArr, 0, zzd2, zzd3);
        return new zzgwk(bArr);
    }

    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm)) {
            return false;
        }
        zzgwm zzgwm = (zzgwm) obj;
        if (this.zzc != zzgwm.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzr = zzr();
        int zzr2 = zzgwm.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        zzhab zzhab = new zzhab(this, (zzhaa) null);
        zzgwj zza2 = zzhab.next();
        zzhab zzhab2 = new zzhab(zzgwm, (zzhaa) null);
        zzgwj zza3 = zzhab2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzd2 = zza2.zzd() - i;
            int zzd3 = zza3.zzd() - i2;
            int min = Math.min(zzd2, zzd3);
            if (i == 0) {
                z = zza2.zzg(zza3, i2, min);
            } else {
                z = zza3.zzg(zza2, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 < i4) {
                if (min == zzd2) {
                    zza2 = zzhab.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == zzd3) {
                    zza3 = zzhab2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzgzx(this);
    }

    public final byte zza(int i) {
        zzgwm.zzy(i, this.zzc);
        return zzb(i);
    }

    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    public final int zzd() {
        return this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zze.zze(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public final int zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        if (this.zzc >= zzc(this.zzg)) {
            return true;
        }
        return false;
    }

    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    public final zzgwm zzk(int i, int i2) {
        int zzq = zzgwm.zzq(i, i2, this.zzc);
        if (zzq == 0) {
            return zzgwm.zzb;
        }
        if (zzq == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzgwm zzgwm = this.zzd;
        return new zzhad(zzgwm.zzk(i, zzgwm.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    public final zzgww zzl() {
        ArrayList arrayList = new ArrayList();
        zzhab zzhab = new zzhab(this, (zzhaa) null);
        while (zzhab.hasNext()) {
            arrayList.add(zzhab.next().zzn());
        }
        Iterator it = arrayList.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            i += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z |= true;
            } else if (byteBuffer.isDirect()) {
                z |= true;
            } else {
                z |= true;
            }
        }
        if (z) {
            return new zzgwq(arrayList, i, true, (zzgwp) null);
        }
        return zzgww.zzG(new zzgyo(arrayList), 4096);
    }

    public final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    public final ByteBuffer zzn() {
        throw null;
    }

    public final void zzo(zzgwd zzgwd) throws IOException {
        this.zzd.zzo(zzgwd);
        this.zze.zzo(zzgwd);
    }

    public final boolean zzp() {
        zzgwm zzgwm = this.zzd;
        zzgwm zzgwm2 = this.zze;
        if (zzgwm2.zzj(zzgwm.zzj(0, 0, this.zzf), 0, zzgwm2.zzd()) == 0) {
            return true;
        }
        return false;
    }

    public final zzgwh zzs() {
        return new zzgzx(this);
    }

    private zzhad(zzgwm zzgwm, zzgwm zzgwm2) {
        this.zzd = zzgwm;
        this.zze = zzgwm2;
        int zzd2 = zzgwm.zzd();
        this.zzf = zzd2;
        this.zzc = zzgwm2.zzd() + zzd2;
        this.zzg = Math.max(zzgwm.zzf(), zzgwm2.zzf()) + 1;
    }
}
