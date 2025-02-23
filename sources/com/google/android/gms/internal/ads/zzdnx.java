package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdnx implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzdsk zzc;
    /* access modifiers changed from: private */
    public final zzedh zzd;
    /* access modifiers changed from: private */
    public final Executor zze;
    /* access modifiers changed from: private */
    public final zzauo zzf;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzg;
    /* access modifiers changed from: private */
    public final zzfll zzh;
    /* access modifiers changed from: private */
    public final zzeds zzi;
    /* access modifiers changed from: private */
    public final zzffk zzj;

    public zzdnx(Context context, Executor executor, zzauo zzauo, VersionInfoParcel versionInfoParcel, zza zza2, zzcew zzcew, zzedh zzedh, zzfll zzfll, zzdsk zzdsk, zzeds zzeds, zzffk zzffk) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzauo;
        this.zzg = versionInfoParcel;
        this.zza = zza2;
        this.zzd = zzedh;
        this.zzh = zzfll;
        this.zzc = zzdsk;
        this.zzi = zzeds;
        this.zzj = zzffk;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdoa zzdoa = new zzdoa(this);
        zzdoa.zzk();
        return zzdoa;
    }
}
