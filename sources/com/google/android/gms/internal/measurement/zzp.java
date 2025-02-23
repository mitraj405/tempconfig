package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzp extends zzal {
    private final /* synthetic */ zzo zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzp(zzm zzm, String str, zzo zzo) {
        super(str);
        this.zzk = zzo;
    }

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzg.zza("getValue", 2, list);
        zzaq zza = zzh.zza(list.get(0));
        zzaq zza2 = zzh.zza(list.get(1));
        String zza3 = this.zzk.zza(zza.zzf());
        if (zza3 != null) {
            return new zzas(zza3);
        }
        return zza2;
    }
}
