package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzaas implements Runnable {
    public final /* synthetic */ zzaax zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzaas(zzaax zzaax, Exception exc) {
        this.zza = zzaax;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
