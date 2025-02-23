package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfxw<E> extends zzfxm<E> implements Set<E> {
    private transient zzfxr zza;

    public static int zzh(int i) {
        boolean z;
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        }
        if (max < 1073741824) {
            z = true;
        } else {
            z = false;
        }
        zzfuu.zzf(z, "collection too large");
        return Ints.MAX_POWER_OF_TWO;
    }

    public static zzfxv zzj(int i) {
        return new zzfxv(i);
    }

    public static zzfxw zzl(Collection collection) {
        if ((collection instanceof zzfxw) && !(collection instanceof SortedSet)) {
            zzfxw zzfxw = (zzfxw) collection;
            if (!zzfxw.zzf()) {
                return zzfxw;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzfxw zzm(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return zzfzj.zza;
        }
        if (length != 1) {
            return zzv(length, (Object[]) objArr.clone());
        }
        return new zzfzu(objArr[0]);
    }

    public static zzfxw zzn() {
        return zzfzj.zza;
    }

    public static zzfxw zzo(Object obj) {
        return new zzfzu(obj);
    }

    public static zzfxw zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzfxw zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzfxw zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfxw zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[11];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 5);
        return zzv(11, objArr2);
    }

    /* access modifiers changed from: private */
    public static zzfxw zzv(int i, Object... objArr) {
        if (i == 0) {
            return zzfzj.zza;
        }
        if (i != 1) {
            int zzh = zzh(i);
            Object[] objArr2 = new Object[zzh];
            int i2 = zzh - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zzfzb.zza(obj, i5);
                int hashCode = obj.hashCode();
                int zza2 = zzfxj.zza(hashCode);
                while (true) {
                    int i6 = zza2 & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zza2++;
                    } else {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                return new zzfzu(obj3);
            }
            if (zzh(i4) < zzh / 2) {
                return zzv(i4, objArr);
            }
            if (zzw(i4, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i4);
            }
            return new zzfzj(objArr, i3, objArr2, i2, i4);
        }
        Object obj4 = objArr[0];
        Objects.requireNonNull(obj4);
        return new zzfzu(obj4);
    }

    /* access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        if (i < (i2 >> 1) + (i2 >> 2)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfxw) || !zzu() || !((zzfxw) obj).zzu() || hashCode() == obj.hashCode()) {
            return zzfzt.zzd(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzfzt.zza(this);
    }

    public zzfxr zzd() {
        zzfxr zzfxr = this.zza;
        if (zzfxr != null) {
            return zzfxr;
        }
        zzfxr zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    /* renamed from: zze */
    public abstract zzfzx iterator();

    public zzfxr zzi() {
        Object[] array = toArray();
        int i = zzfxr.zzd;
        return zzfxr.zzj(array, array.length);
    }

    public boolean zzu() {
        return false;
    }
}
