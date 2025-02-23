package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final /* synthetic */ class zzbod implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbod(zzboe zzboe, Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void run() {
        Context context = this.zza;
        zzbbw.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzan)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("measurementEnabled", ((Boolean) zzba.zzc().zza(zzbbw.zzac)).booleanValue());
            if (((Boolean) zzba.zzc().zza(zzbbw.zzaj)).booleanValue()) {
                bundle.putString("ad_storage", "denied");
                bundle.putString("analytics_storage", "denied");
            }
            try {
                ((zzcgi) zzq.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new zzboc())).zze(ObjectWrapper.wrap(context), new zzbob(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", this.zzb, bundle)));
            } catch (RemoteException | zzp | NullPointerException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
