package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbrs extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbrs(zzbew zzbew) {
        zzbfd zzbfd;
        try {
            this.zzb = zzbew.zzg();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object next : zzbew.zzh()) {
                if (next instanceof IBinder) {
                    zzbfd = zzbfc.zzg((IBinder) next);
                } else {
                    zzbfd = null;
                }
                if (zzbfd != null) {
                    this.zza.add(new zzbru(zzbfd));
                }
            }
        } catch (RemoteException e2) {
            zzm.zzh("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
