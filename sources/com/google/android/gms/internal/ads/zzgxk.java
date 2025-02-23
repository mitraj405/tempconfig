package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgxk extends zzgxj {
    public final void zza(Object obj) {
        ((zzgxu) obj).zza.zzg();
    }

    public final void zzb(zzhbh zzhbh, Map.Entry entry) throws IOException {
        zzgxv zzgxv = (zzgxv) entry.getKey();
        if (zzgxv.zzc) {
            zzhbf zzhbf = zzhbf.DOUBLE;
            switch (zzgxv.zzb.ordinal()) {
                case 0:
                    zzhag.zzt(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 1:
                    zzhag.zzx(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 2:
                    zzhag.zzA(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 3:
                    zzhag.zzI(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 4:
                    zzhag.zzz(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 5:
                    zzhag.zzw(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 6:
                    zzhag.zzv(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 7:
                    zzhag.zzr(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 8:
                    zzhag.zzG(zzgxv.zza, (List) entry.getValue(), zzhbh);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzhag.zzy(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgzt.zza().zzb(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzhag.zzB(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgzt.zza().zzb(list2.get(0).getClass()));
                        return;
                    }
                    return;
                case 11:
                    zzhag.zzs(zzgxv.zza, (List) entry.getValue(), zzhbh);
                    return;
                case 12:
                    zzhag.zzH(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 13:
                    zzhag.zzz(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 14:
                    zzhag.zzC(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 15:
                    zzhag.zzD(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 16:
                    zzhag.zzE(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                case 17:
                    zzhag.zzF(zzgxv.zza, (List) entry.getValue(), zzhbh, zzgxv.zzd);
                    return;
                default:
                    return;
            }
        } else {
            zzhbf zzhbf2 = zzhbf.DOUBLE;
            switch (zzgxv.zzb.ordinal()) {
                case 0:
                    zzhbh.zzf(zzgxv.zza, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    zzhbh.zzo(zzgxv.zza, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    zzhbh.zzt(zzgxv.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    zzhbh.zzK(zzgxv.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzhbh.zzr(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 5:
                    zzhbh.zzm(zzgxv.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    zzhbh.zzk(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    zzhbh.zzb(zzgxv.zza, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    zzhbh.zzG(zzgxv.zza, (String) entry.getValue());
                    return;
                case 9:
                    zzhbh.zzq(zzgxv.zza, entry.getValue(), zzgzt.zza().zzb(entry.getValue().getClass()));
                    return;
                case 10:
                    zzhbh.zzv(zzgxv.zza, entry.getValue(), zzgzt.zza().zzb(entry.getValue().getClass()));
                    return;
                case 11:
                    zzhbh.zzd(zzgxv.zza, (zzgwm) entry.getValue());
                    return;
                case 12:
                    zzhbh.zzI(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzhbh.zzr(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 14:
                    zzhbh.zzx(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzhbh.zzz(zzgxv.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    zzhbh.zzB(zzgxv.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    zzhbh.zzD(zzgxv.zza, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
        }
    }
}
