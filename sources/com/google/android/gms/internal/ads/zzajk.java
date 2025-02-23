package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzajk extends zzajo {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    public static boolean zzd(zzek zzek) {
        return zzk(zzek, zza);
    }

    private static boolean zzk(zzek zzek, byte[] bArr) {
        if (zzek.zzb() < 8) {
            return false;
        }
        int zzd = zzek.zzd();
        byte[] bArr2 = new byte[8];
        zzek.zzG(bArr2, 0, 8);
        zzek.zzK(zzd);
        return Arrays.equals(bArr2, bArr);
    }

    public final long zza(zzek zzek) {
        return zzg(zzade.zzd(zzek.zzM()));
    }

    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    public final boolean zzc(zzek zzek, long j, zzajl zzajl) throws zzbo {
        if (zzk(zzek, zza)) {
            byte[] copyOf = Arrays.copyOf(zzek.zzM(), zzek.zze());
            byte b = copyOf[9] & UnsignedBytes.MAX_VALUE;
            List zze = zzade.zze(copyOf);
            if (zzajl.zza == null) {
                zzad zzad = new zzad();
                zzad.zzX("audio/opus");
                zzad.zzy(b);
                zzad.zzY(48000);
                zzad.zzL(zze);
                zzajl.zza = zzad.zzad();
                return true;
            }
        } else if (zzk(zzek, zzb)) {
            zzdi.zzb(zzajl.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzek.zzL(8);
                zzbk zzb2 = zzadv.zzb(zzfxr.zzl(zzadv.zzc(zzek, false, false).zza));
                if (zzb2 != null) {
                    zzad zzb3 = zzajl.zza.zzb();
                    zzb3.zzQ(zzb2.zzd(zzajl.zza.zzk));
                    zzajl.zza = zzb3.zzad();
                }
            }
        } else {
            zzdi.zzb(zzajl.zza);
            return false;
        }
        return true;
    }
}
