package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzgy implements zzv {
    private final /* synthetic */ zzgt zza;

    public zzgy(zzgt zzgt) {
        this.zza = zzgt;
    }

    public final void zza(zzs zzs, String str, List<String> list, boolean z, boolean z2) {
        zzfy zzfy;
        int i = zzha.zza[zzs.ordinal()];
        if (i == 1) {
            zzfy = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    zzfy = this.zza.zzj().zzn();
                } else {
                    zzfy = this.zza.zzj().zzp();
                }
            } else if (z) {
                zzfy = this.zza.zzj().zzw();
            } else if (!z2) {
                zzfy = this.zza.zzj().zzv();
            } else {
                zzfy = this.zza.zzj().zzu();
            }
        } else if (z) {
            zzfy = this.zza.zzj().zzm();
        } else if (!z2) {
            zzfy = this.zza.zzj().zzh();
        } else {
            zzfy = this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzfy.zza(str, list.get(0));
        } else if (size == 2) {
            zzfy.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzfy.zza(str);
        } else {
            zzfy.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
