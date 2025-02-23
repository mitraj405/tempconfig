package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfoe implements Continuation {
    public final /* synthetic */ zzara zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfoe(zzara zzara, int i) {
        this.zza = zzara;
        this.zzb = i;
    }

    public final Object then(Task task) {
        int i = zzfoh.zza;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        int i2 = this.zzb;
        zzfqi zza2 = ((zzfqj) task.getResult()).zza(((zzare) this.zza.zzbr()).zzaV());
        zza2.zza(i2);
        zza2.zzc();
        return Boolean.TRUE;
    }
}
