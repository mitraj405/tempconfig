package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbwq implements RewardItem {
    private final zzbwd zza;

    public zzbwq(zzbwd zzbwd) {
        this.zza = zzbwd;
    }

    public final int getAmount() {
        zzbwd zzbwd = this.zza;
        if (zzbwd != null) {
            try {
                return zzbwd.zze();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzbwd zzbwd = this.zza;
        if (zzbwd != null) {
            try {
                return zzbwd.zzf();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
