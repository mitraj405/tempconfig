package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzada {
    private final zzek zza = new zzek(10);

    public final zzbk zza(zzacl zzacl, zzaga zzaga) throws IOException {
        zzbk zzbk = null;
        int i = 0;
        while (true) {
            try {
                ((zzaby) zzacl).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int zzl = this.zza.zzl();
                int i2 = zzl + 10;
                if (zzbk == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzaby) zzacl).zzm(bArr, 10, zzl, false);
                    zzbk = zzagc.zza(bArr, i2, zzaga, new zzafe());
                } else {
                    ((zzaby) zzacl).zzl(zzl, false);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzacl.zzj();
        ((zzaby) zzacl).zzl(i, false);
        return zzbk;
    }
}
