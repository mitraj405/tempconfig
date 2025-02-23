package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbfy {
    private final zzbfx zza;

    public zzbfy(zzbfx zzbfx) {
        Context context;
        this.zza = zzbfx;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbfx.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzm.zzh("", e);
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzs(ObjectWrapper.wrap(new MediaView(context)));
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
        }
    }

    public final zzbfx zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }
}
