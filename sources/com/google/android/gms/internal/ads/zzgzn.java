package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzn implements zzhae {
    private final zzgzj zza;
    private final zzhas zzb;
    private final boolean zzc;
    private final zzgxj zzd;

    private zzgzn(zzhas zzhas, zzgxj zzgxj, zzgzj zzgzj) {
        this.zzb = zzhas;
        this.zzc = zzgzj instanceof zzgxu;
        this.zzd = zzgxj;
        this.zza = zzgzj;
    }

    public static zzgzn zzc(zzhas zzhas, zzgxj zzgxj, zzgzj zzgzj) {
        return new zzgzn(zzhas, zzgxj, zzgzj);
    }

    public final int zza(Object obj) {
        int zzb2 = ((zzgxy) obj).zzt.zzb();
        if (this.zzc) {
            return zzb2 + ((zzgxu) obj).zza.zzd();
        }
        return zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = ((zzgxy) obj).zzt.hashCode();
        if (this.zzc) {
            return (hashCode * 53) + ((zzgxu) obj).zza.zza.hashCode();
        }
        return hashCode;
    }

    public final Object zze() {
        zzgzj zzgzj = this.zza;
        if (zzgzj instanceof zzgxy) {
            return ((zzgxy) zzgzj).zzbj();
        }
        return zzgzj.zzcZ().zzbs();
    }

    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzhag.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhag.zzp(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzgzw zzgzw, zzgxi zzgxi) throws IOException {
        this.zzb.zza(obj);
        zzgxu zzgxu = (zzgxu) obj;
        throw null;
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgwa zzgwa) throws IOException {
        zzgxy zzgxy = (zzgxy) obj;
        if (zzgxy.zzt == zzhat.zzc()) {
            zzgxy.zzt = zzhat.zzf();
        }
        zzgxu zzgxu = (zzgxu) obj;
        throw null;
    }

    public final void zzj(Object obj, zzhbh zzhbh) throws IOException {
        Iterator zzf = ((zzgxu) obj).zza.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzgxm zzgxm = (zzgxm) entry.getKey();
            if (zzgxm.zzc() != zzhbg.MESSAGE || zzgxm.zze() || zzgxm.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzgyr) {
                zzhbh.zzw(zzgxm.zza(), ((zzgyr) entry).zza().zzb());
            } else {
                zzhbh.zzw(zzgxm.zza(), entry.getValue());
            }
        }
        ((zzgxy) obj).zzt.zzk(zzhbh);
    }

    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzgxy) obj).zzt.equals(((zzgxy) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgxu) obj).zza.equals(((zzgxu) obj2).zza);
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        return ((zzgxu) obj).zza.zzi();
    }
}
