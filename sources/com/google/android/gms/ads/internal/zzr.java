package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzauo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzr extends AsyncTask {
    final /* synthetic */ zzt zza;

    public /* synthetic */ zzr(zzt zzt, zzq zzq) {
        this.zza = zzt;
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzt zzt = this.zza;
        String str = (String) obj;
        if (zzt.zzf != null && str != null) {
            zzt.zzf.loadUrl(str);
        }
    }

    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzt zzt = this.zza;
            zzt.zzh = (zzauo) zzt.zzc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            zzm.zzk("", e);
        } catch (TimeoutException e2) {
            zzm.zzk("", e2);
        }
        return this.zza.zzp();
    }
}
