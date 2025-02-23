package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzhag {
    public static final /* synthetic */ int zza = 0;
    private static final zzhas zzb = new zzhau();

    static {
        int i = zzgzt.zza;
    }

    public static void zzA(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzu(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzhbh zzhbh, zzhae zzhae) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzgxe) zzhbh).zzv(i, list.get(i2), zzhae);
            }
        }
    }

    public static void zzC(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzy(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzA(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzC(i, list, z);
        }
    }

    public static void zzF(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzE(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzhbh zzhbh) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzH(i, list);
        }
    }

    public static void zzH(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzJ(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzL(i, list, z);
        }
    }

    public static boolean zzJ(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            i = 0;
            while (i2 < size) {
                i += zzgxd.zzE((long) zzgxz.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgxd.zzE((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgxd.zzD(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgxd.zzD(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            i = 0;
            while (i2 < size) {
                i += zzgxd.zzE((long) zzgxz.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgxd.zzE((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            i = 0;
            while (i2 < size) {
                i += zzgxd.zzE(zzgyy.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgxd.zzE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(int i, Object obj, zzhae zzhae) {
        int i2 = i << 3;
        if (obj instanceof zzgyu) {
            int zzD = zzgxd.zzD(i2);
            int zza2 = ((zzgyu) obj).zza();
            return zzgxd.zzD(zza2) + zza2 + zzD;
        }
        return zzgxd.zzA((zzgzj) obj, zzhae) + zzgxd.zzD(i2);
    }

    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            i = 0;
            while (i2 < size) {
                int zzd = zzgxz.zzd(i2);
                i += zzgxd.zzD((zzd >> 31) ^ (zzd + zzd));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzgxd.zzD((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzgyy.zza(i2);
                i += zzgxd.zzE((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzgxd.zzE((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            i = 0;
            while (i2 < size) {
                i += zzgxd.zzD(zzgxz.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgxd.zzD(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            i = 0;
            while (i2 < size) {
                i += zzgxd.zzE(zzgyy.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgxd.zzE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzhas zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, List list, zzgye zzgye, Object obj2, zzhas zzhas) {
        if (zzgye == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzgye.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, intValue, obj2, zzhas);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzgye.zza(intValue2)) {
                    obj2 = zzo(obj, i, intValue2, obj2, zzhas);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i, int i2, Object obj2, zzhas zzhas) {
        if (obj2 == null) {
            obj2 = zzhas.zza(obj);
        }
        zzhas.zzh(obj2, i, (long) i2);
        return obj2;
    }

    public static void zzp(zzgxj zzgxj, Object obj, Object obj2) {
        if (!((zzgxu) obj2).zza.zza.isEmpty()) {
            zzgxu zzgxu = (zzgxu) obj;
            throw null;
        }
    }

    public static void zzq(zzhas zzhas, Object obj, Object obj2) {
        zzgxy zzgxy = (zzgxy) obj;
        zzhat zzhat = zzgxy.zzt;
        zzhat zzhat2 = ((zzgxy) obj2).zzt;
        if (!zzhat.zzc().equals(zzhat2)) {
            if (zzhat.zzc().equals(zzhat)) {
                zzhat = zzhat.zze(zzhat, zzhat2);
            } else {
                zzhat.zzd(zzhat2);
            }
        }
        zzgxy.zzt = zzhat;
    }

    public static void zzr(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzc(i, list, z);
        }
    }

    public static void zzs(int i, List list, zzhbh zzhbh) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zze(i, list);
        }
    }

    public static void zzt(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzg(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzj(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzl(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzn(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzp(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzhbh zzhbh, zzhae zzhae) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzgxe) zzhbh).zzq(i, list.get(i2), zzhae);
            }
        }
    }

    public static void zzz(int i, List list, zzhbh zzhbh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhbh.zzs(i, list, z);
        }
    }
}
