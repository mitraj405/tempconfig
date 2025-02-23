package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbhi {
    /* access modifiers changed from: private */
    public final zzg zza;
    /* access modifiers changed from: private */
    public final zzf zzb;
    private zzbfy zzc;

    public zzbhi(zzg zzg, zzf zzf) {
        this.zza = zzg;
        this.zzb = zzf;
    }

    /* access modifiers changed from: private */
    public final synchronized zzbfy zzf(zzbfx zzbfx) {
        zzbfy zzbfy = this.zzc;
        if (zzbfy != null) {
            return zzbfy;
        }
        zzbfy zzbfy2 = new zzbfy(zzbfx);
        this.zzc = zzbfy2;
        return zzbfy2;
    }

    public final zzbgh zzc() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbhf(this, (zzbhe) null);
    }

    public final zzbgk zzd() {
        return new zzbhh(this, (zzbhg) null);
    }
}
