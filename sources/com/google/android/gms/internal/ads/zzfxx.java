package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfxx {
    public static Object zza(Iterable iterable, Object obj) {
        zzfzm zzfzm = new zzfzm((zzfzn) iterable);
        if (zzfzm.hasNext()) {
            return zzfzm.next();
        }
        return obj;
    }

    public static boolean zzb(Iterable iterable, zzfuv zzfuv) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            zzfuv.getClass();
            boolean z = false;
            while (it.hasNext()) {
                if (zzfuv.zza(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        zzfuv.getClass();
        return zzd((List) iterable, zzfuv);
    }

    private static void zzc(List list, zzfuv zzfuv, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfuv.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 >= i) {
                list.remove(i2);
            } else {
                return;
            }
        }
    }

    private static boolean zzd(List list, zzfuv zzfuv) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfuv.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (UnsupportedOperationException unused) {
                        zzc(list, zzfuv, i2, i);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        zzc(list, zzfuv, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        if (i != i2) {
            return true;
        }
        return false;
    }
}
