package com.google.android.gms.measurement.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzfv implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfw zzf;

    public zzfv(zzfw zzfw, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzfw;
    }

    public final void run() {
        zzgh zzn = this.zzf.zzu.zzn();
        if (!zzn.zzaf()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zze().zzy()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            this.zzf.zzb = 97001;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        char zza2 = this.zzf.zza;
        long zzb2 = this.zzf.zzb;
        String zza3 = zzfw.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(C0515Ga.FARE_ONLY);
        sb.append(charAt);
        sb.append(zza2);
        sb.append(zzb2);
        String j = C0709Uj.j(sb, ":", zza3);
        if (j.length() > 1024) {
            j = this.zzb.substring(0, UserMetadata.MAX_ATTRIBUTE_SIZE);
        }
        zzgl zzgl = zzn.zzb;
        if (zzgl != null) {
            zzgl.zza(j, 1);
        }
    }
}
