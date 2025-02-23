package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbar {
    /* access modifiers changed from: private */
    public zzbag zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    public zzbar(Context context) {
        this.zzc = context;
    }

    public static /* bridge */ /* synthetic */ void zze(zzbar zzbar) {
        synchronized (zzbar.zzd) {
            zzbag zzbag = zzbar.zza;
            if (zzbag != null) {
                zzbag.disconnect();
                zzbar.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }

    public final Future zzc(zzbah zzbah) {
        zzbal zzbal = new zzbal(this);
        zzbap zzbap = new zzbap(this, zzbah, zzbal);
        zzbaq zzbaq = new zzbaq(this, zzbal);
        synchronized (this.zzd) {
            zzbag zzbag = new zzbag(this.zzc, zzu.zzt().zzb(), zzbap, zzbaq);
            this.zza = zzbag;
            zzbag.checkAvailabilityAndConnect();
        }
        return zzbal;
    }
}
