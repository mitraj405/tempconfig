package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbc {
    public final String zza;
    public final zzax zzb;
    public final zzav zzc;
    public final zzbh zzd;
    public final zzap zze;
    public final zzaz zzf;

    static {
        new zzam().zzc();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzbc(String str, zzar zzar, zzax zzax, zzav zzav, zzbh zzbh, zzaz zzaz, zzbb zzbb) {
        this.zza = str;
        this.zzb = zzax;
        this.zzc = zzav;
        this.zzd = zzbh;
        this.zze = zzar;
        this.zzf = zzaz;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbc)) {
            return false;
        }
        zzbc zzbc = (zzbc) obj;
        if (!zzet.zzG(this.zza, zzbc.zza) || !this.zze.equals(zzbc.zze) || !zzet.zzG(this.zzb, zzbc.zzb) || !zzet.zzG(this.zzc, zzbc.zzc) || !zzet.zzG(this.zzd, zzbc.zzd) || !zzet.zzG(this.zzf, zzbc.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() * 31;
        zzax zzax = this.zzb;
        if (zzax != null) {
            i = zzax.hashCode();
        } else {
            i = 0;
        }
        int hashCode2 = this.zzc.hashCode();
        int hashCode3 = this.zze.hashCode();
        return (this.zzd.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + i) * 31)) * 31)) * 31)) * 31;
    }
}
