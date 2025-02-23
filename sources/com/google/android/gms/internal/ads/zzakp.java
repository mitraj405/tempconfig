package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzakp implements zzaka {
    private final zzek zza = new zzek();
    private final zzek zzb = new zzek();
    private final zzako zzc = new zzako();
    private Inflater zzd;

    public final void zza(byte[] bArr, int i, int i2, zzajz zzajz, zzdn zzdn) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        zzek zzek = this.zza;
        if (zzek.zzb() > 0 && zzek.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzet.zzI(zzek, this.zzb, this.zzd)) {
                zzek zzek2 = this.zzb;
                zzek.zzI(zzek2.zzM(), zzek2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzek zzek3 = this.zza;
            if (zzek3.zzb() >= 3) {
                zzako zzako = this.zzc;
                int zze = zzek3.zze();
                int zzm = zzek3.zzm();
                int zzq = zzek3.zzq();
                int zzd2 = zzek3.zzd() + zzq;
                zzdb zzdb = null;
                if (zzd2 > zze) {
                    zzek3.zzK(zze);
                } else {
                    if (zzm != 128) {
                        switch (zzm) {
                            case 20:
                                zzako.zzd(zzako, zzek3, zzq);
                                break;
                            case 21:
                                zzako.zzb(zzako, zzek3, zzq);
                                break;
                            case 22:
                                zzako.zzc(zzako, zzek3, zzq);
                                break;
                        }
                    } else {
                        zzdb zza2 = zzako.zza();
                        zzako.zze();
                        zzdb = zza2;
                    }
                    zzek3.zzK(zzd2);
                }
                if (zzdb != null) {
                    arrayList.add(zzdb);
                }
            } else {
                zzdn.zza(new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }

    public final /* synthetic */ void zzb() {
    }
}
