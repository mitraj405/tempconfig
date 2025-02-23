package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
class zzgwk extends zzgwj {
    protected final byte[] zza;

    public zzgwk(byte[] bArr) {
        super((zzgwi) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm) || zzd() != ((zzgwm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgwk)) {
            return obj.equals(this);
        }
        zzgwk zzgwk = (zzgwk) obj;
        int zzr = zzr();
        int zzr2 = zzgwk.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgwk, 0, zzd());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    public final boolean zzg(zzgwm zzgwm, int i, int i2) {
        if (i2 <= zzgwm.zzd()) {
            int i3 = i + i2;
            if (i3 > zzgwm.zzd()) {
                int zzd = zzgwm.zzd();
                StringBuilder C = C1058d.C("Ran off end of other: ", i, ", ", i2, ", ");
                C.append(zzd);
                throw new IllegalArgumentException(C.toString());
            } else if (!(zzgwm instanceof zzgwk)) {
                return zzgwm.zzk(i, i3).equals(zzk(0, i2));
            } else {
                zzgwk zzgwk = (zzgwk) zzgwm;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgwk.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzgwk.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i2 + zzd2);
        }
    }

    public final int zzi(int i, int i2, int i3) {
        return zzgyl.zzb(i, this.zza, zzc() + i2, i3);
    }

    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhbe.zzf(i, this.zza, zzc, i3 + zzc);
    }

    public final zzgwm zzk(int i, int i2) {
        int zzq = zzgwm.zzq(i, i2, zzd());
        if (zzq == 0) {
            return zzgwm.zzb;
        }
        return new zzgwg(this.zza, zzc() + i, zzq);
    }

    public final zzgww zzl() {
        return zzgww.zzH(this.zza, zzc(), zzd(), true);
    }

    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    public final void zzo(zzgwd zzgwd) throws IOException {
        zzgwd.zza(this.zza, zzc(), zzd());
    }

    public final boolean zzp() {
        int zzc = zzc();
        return zzhbe.zzi(this.zza, zzc, zzd() + zzc);
    }
}
