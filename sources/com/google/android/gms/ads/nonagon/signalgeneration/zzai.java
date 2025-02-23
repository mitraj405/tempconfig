package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzai implements zzgcf {
    final /* synthetic */ zzbtc zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzak zzc;

    public zzai(zzak zzak, zzbtc zzbtc, boolean z) {
        this.zza = zzbtc;
        this.zzb = z;
        this.zzc = zzak;
    }

    public final void zza(Throwable th) {
        try {
            zzbtc zzbtc = this.zza;
            String message = th.getMessage();
            zzbtc.zze("Internal error: " + message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<Uri> list = (List) obj;
        try {
            zzak.zzH(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzs || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzO(uri)) {
                        zzak zzak = this.zzc;
                        this.zzc.zzq.zzc(zzak.zzZ(uri, zzak.zzA, C0515Ga.AVLBLTY_ONLY).toString(), (zzfkf) null);
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbbw.zzgJ)).booleanValue()) {
                            this.zzc.zzq.zzc(uri.toString(), (zzfkf) null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
