package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgxn {
    private static final zzgxn zzb = new zzgxn(true);
    final zzhao zza = new zzhah();
    private boolean zzc;
    private boolean zzd;

    private zzgxn() {
    }

    public static int zza(zzhbf zzhbf, int i, Object obj) {
        int zzD = zzgxd.zzD(i << 3);
        if (zzhbf == zzhbf.GROUP) {
            zzgzj zzgzj = (zzgzj) obj;
            byte[] bArr = zzgyl.zzb;
            if (!(zzgzj instanceof zzgvw)) {
                zzD += zzD;
            } else {
                zzgvw zzgvw = (zzgvw) zzgzj;
                throw null;
            }
        }
        return zzD + zzb(zzhbf, obj);
    }

    public static int zzb(zzhbf zzhbf, Object obj) {
        int zzd2;
        int zzD;
        zzhbf zzhbf2 = zzhbf.DOUBLE;
        zzhbg zzhbg = zzhbg.INT;
        switch (zzhbf.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzgxd.zzf;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzgxd.zzf;
                return 4;
            case 2:
                return zzgxd.zzE(((Long) obj).longValue());
            case 3:
                return zzgxd.zzE(((Long) obj).longValue());
            case 4:
                return zzgxd.zzE((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzgxd.zzf;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzgxd.zzf;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzgxd.zzf;
                return 1;
            case 8:
                if (obj instanceof zzgwm) {
                    int i6 = zzgxd.zzf;
                    zzd2 = ((zzgwm) obj).zzd();
                    zzD = zzgxd.zzD(zzd2);
                    break;
                } else {
                    return zzgxd.zzC((String) obj);
                }
            case 9:
                int i7 = zzgxd.zzf;
                return ((zzgzj) obj).zzaY();
            case 10:
                if (obj instanceof zzgyt) {
                    int i8 = zzgxd.zzf;
                    zzd2 = ((zzgyt) obj).zza();
                    zzD = zzgxd.zzD(zzd2);
                    break;
                } else {
                    return zzgxd.zzz((zzgzj) obj);
                }
            case 11:
                if (!(obj instanceof zzgwm)) {
                    int i9 = zzgxd.zzf;
                    zzd2 = ((byte[]) obj).length;
                    zzD = zzgxd.zzD(zzd2);
                    break;
                } else {
                    int i10 = zzgxd.zzf;
                    zzd2 = ((zzgwm) obj).zzd();
                    zzD = zzgxd.zzD(zzd2);
                    break;
                }
            case 12:
                return zzgxd.zzD(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzgyc) {
                    return zzgxd.zzE((long) ((zzgyc) obj).zza());
                }
                return zzgxd.zzE((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i11 = zzgxd.zzf;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i12 = zzgxd.zzf;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzgxd.zzD((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzgxd.zzE((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzD + zzd2;
    }

    public static int zzc(zzgxm zzgxm, Object obj) {
        zzhbf zzb2 = zzgxm.zzb();
        int zza2 = zzgxm.zza();
        if (!zzgxm.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List<Object> list = (List) obj;
        int i = 0;
        if (!zzgxm.zzd()) {
            for (Object zza3 : list) {
                i += zza(zzb2, zza2, zza3);
            }
            return i;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            for (Object zzb3 : list) {
                i += zzb(zzb2, zzb3);
            }
            return zzgxd.zzD(i) + zzgxd.zzD(zza2 << 3) + i;
        }
    }

    public static zzgxn zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgxm zzgxm = (zzgxm) entry.getKey();
        if (zzgxm.zzc() != zzhbg.MESSAGE) {
            return true;
        }
        if (!zzgxm.zze()) {
            return zzk(entry.getValue());
        }
        for (Object zzk : (List) entry.getValue()) {
            if (!zzk(zzk)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgzk) {
            return ((zzgzk) obj).zzbw();
        }
        if (obj instanceof zzgyt) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        zzgxm zzgxm = (zzgxm) entry.getKey();
        Object value = entry.getValue();
        if (zzgxm.zzc() != zzhbg.MESSAGE || zzgxm.zze() || zzgxm.zzd()) {
            return zzc(zzgxm, value);
        }
        if (value instanceof zzgyt) {
            int zza2 = ((zzgxm) entry.getKey()).zza();
            int zzD = zzgxd.zzD(8);
            int zzD2 = zzgxd.zzD(zza2) + zzgxd.zzD(16);
            int zzD3 = zzgxd.zzD(24);
            int zza3 = ((zzgyt) value).zza();
            return zzD + zzD + zzD2 + zzgxd.zzD(zza3) + zza3 + zzD3;
        }
        int zza4 = ((zzgxm) entry.getKey()).zza();
        int zzD4 = zzgxd.zzD(8);
        int zzD5 = zzgxd.zzD(16);
        int zzD6 = zzgxd.zzD(24);
        return zzD4 + zzD4 + zzgxd.zzD(zza4) + zzD5 + zzgxd.zzz((zzgzj) value) + zzD6;
    }

    private static final void zzm(zzgxm zzgxm, Object obj) {
        boolean z;
        zzhbf zzb2 = zzgxm.zzb();
        byte[] bArr = zzgyl.zzb;
        obj.getClass();
        zzhbf zzhbf = zzhbf.DOUBLE;
        zzhbg zzhbg = zzhbg.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgwm) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgyc)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzgzj) || (obj instanceof zzgyt)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzgxm.zza()), zzgxm.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgxn zzgxn = new zzgxn();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzgxn.zzh((zzgxm) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgxn.zzh((zzgxm) entry.getKey(), entry.getValue());
        }
        zzgxn.zzd = this.zzd;
        return zzgxn;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgxn)) {
            return false;
        }
        return this.zza.equals(((zzgxn) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzl(this.zza.zzg(i2));
        }
        for (Map.Entry zzl : this.zza.zzc()) {
            i += zzl(zzl);
        }
        return i;
    }

    public final Iterator zzf() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzgys(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzgxy) {
                    ((zzgxy) zzg.getValue()).zzbW();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzgxm zzgxm, Object obj) {
        if (!zzgxm.zze()) {
            zzm(zzgxm, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzm(zzgxm, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgyt) {
            this.zzd = true;
        }
        this.zza.put(zzgxm, obj);
    }

    public final boolean zzi() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzj(this.zza.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry zzj : this.zza.zzc()) {
            if (!zzj(zzj)) {
                return false;
            }
        }
        return true;
    }

    private zzgxn(boolean z) {
        zzg();
        zzg();
    }
}
