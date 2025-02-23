package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaep extends zzaet {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaep(zzadp zzadp) {
        super(zzadp);
    }

    public final boolean zza(zzek zzek) throws zzaes {
        String str;
        if (!this.zzc) {
            int zzm = zzek.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzad zzad = new zzad();
                zzad.zzX("audio/mpeg");
                zzad.zzy(1);
                zzad.zzY(i2);
                this.zza.zzl(zzad.zzad());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzad zzad2 = new zzad();
                if (i == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zzad2.zzX(str);
                zzad2.zzy(1);
                zzad2.zzY(8000);
                this.zza.zzl(zzad2.zzad());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzaes(lf.h("Audio format not supported: ", i));
            }
            this.zzc = true;
        } else {
            zzek.zzL(1);
        }
        return true;
    }

    public final boolean zzb(zzek zzek, long j) throws zzbo {
        if (this.zze == 2) {
            int zzb2 = zzek.zzb();
            this.zza.zzq(zzek, zzb2);
            this.zza.zzs(j, 1, zzb2, 0, (zzado) null);
            return true;
        }
        int zzm = zzek.zzm();
        if (zzm == 0 && !this.zzd) {
            int zzb3 = zzek.zzb();
            byte[] bArr = new byte[zzb3];
            zzek.zzG(bArr, 0, zzb3);
            zzabf zza = zzabg.zza(bArr);
            zzad zzad = new zzad();
            zzad.zzX("audio/mp4a-latm");
            zzad.zzz(zza.zzc);
            zzad.zzy(zza.zzb);
            zzad.zzY(zza.zza);
            zzad.zzL(Collections.singletonList(bArr));
            this.zza.zzl(zzad.zzad());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzm != 1) {
            return false;
        } else {
            int zzb4 = zzek.zzb();
            this.zza.zzq(zzek, zzb4);
            this.zza.zzs(j, 1, zzb4, 0, (zzado) null);
            return true;
        }
    }
}
