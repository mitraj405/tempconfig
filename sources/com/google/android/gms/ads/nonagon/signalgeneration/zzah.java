package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzah implements zzgcf {
    final /* synthetic */ zzbtc zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzak zzc;

    public zzah(zzak zzak, zzbtc zzbtc, boolean z) {
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
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzr || this.zzb) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (this.zzc.zzP(uri)) {
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
