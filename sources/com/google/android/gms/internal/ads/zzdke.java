package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.util.client.zzm;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdke implements zzbix {
    public final /* synthetic */ zzdkf zza;
    public final /* synthetic */ zzbgx zzb;

    public /* synthetic */ zzdke(zzdkf zzdkf, zzbgx zzbgx) {
        this.zza = zzdkf;
        this.zzb = zzbgx;
    }

    public final void zza(Object obj, Map map) {
        zzdkf zzdkf = this.zza;
        try {
            zzdkf.zzb = Long.valueOf(Long.parseLong((String) map.get(PaymentConstants.TIMESTAMP)));
        } catch (NumberFormatException unused) {
            zzm.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzbgx zzbgx = this.zzb;
        zzdkf.zza = (String) map.get(FacebookMediationAdapter.KEY_ID);
        String str = (String) map.get("asset_id");
        if (zzbgx == null) {
            zzm.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbgx.zzf(str);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
