package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfnv extends AsyncTask {
    private zzfnw zza;
    protected final zzfnn zzd;

    public zzfnv(zzfnn zzfnn) {
        this.zzd = zzfnn;
    }

    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfnw zzfnw = this.zza;
        if (zzfnw != null) {
            zzfnw.zza(this);
        }
    }

    public final void zzb(zzfnw zzfnw) {
        this.zza = zzfnw;
    }
}
