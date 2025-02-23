package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzz {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgzz() {
    }

    public static /* bridge */ /* synthetic */ zzgwm zza(zzgzz zzgzz, zzgwm zzgwm, zzgwm zzgwm2) {
        zzgzz.zzb(zzgwm);
        zzgzz.zzb(zzgwm2);
        zzgwm zzgwm3 = (zzgwm) zzgzz.zza.pop();
        while (!zzgzz.zza.isEmpty()) {
            zzgwm3 = new zzhad((zzgwm) zzgzz.zza.pop(), zzgwm3);
        }
        return zzgwm3;
    }

    private final void zzb(zzgwm zzgwm) {
        if (zzgwm.zzh()) {
            int zzc = zzc(zzgwm.zzd());
            ArrayDeque arrayDeque = this.zza;
            int zzc2 = zzhad.zzc(zzc + 1);
            if (arrayDeque.isEmpty() || ((zzgwm) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzgwm);
                return;
            }
            int zzc3 = zzhad.zzc(zzc);
            zzgwm zzgwm2 = (zzgwm) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzgwm) this.zza.peek()).zzd() < zzc3) {
                zzgwm2 = new zzhad((zzgwm) this.zza.pop(), zzgwm2);
            }
            zzhad zzhad = new zzhad(zzgwm2, zzgwm);
            while (!this.zza.isEmpty()) {
                ArrayDeque arrayDeque2 = this.zza;
                if (((zzgwm) arrayDeque2.peek()).zzd() >= zzhad.zzc(zzc(zzhad.zzd()) + 1)) {
                    break;
                }
                zzhad = new zzhad((zzgwm) this.zza.pop(), zzhad);
            }
            this.zza.push(zzhad);
        } else if (zzgwm instanceof zzhad) {
            zzhad zzhad2 = (zzhad) zzgwm;
            zzb(zzhad2.zzd);
            zzb(zzhad2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgwm.getClass())));
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzhad.zza, i);
        if (binarySearch < 0) {
            return (-(binarySearch + 1)) - 1;
        }
        return binarySearch;
    }

    public /* synthetic */ zzgzz(zzgzy zzgzy) {
    }
}
