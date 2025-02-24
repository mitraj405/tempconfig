package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzlg implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzno zzc;
    private final /* synthetic */ zzkx zzd;

    public zzlg(zzkx zzkx, zzo zzo, boolean z, zzno zzno) {
        this.zza = zzo;
        this.zzb = z;
        this.zzc = zzno;
        this.zzd = zzkx;
    }

    public final void run() {
        zzno zzno;
        zzfl zza2 = this.zzd.zzb;
        if (zza2 == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkx zzkx = this.zzd;
        if (this.zzb) {
            zzno = null;
        } else {
            zzno = this.zzc;
        }
        zzkx.zza(zza2, (AbstractSafeParcelable) zzno, this.zza);
        this.zzd.zzaq();
    }
}
