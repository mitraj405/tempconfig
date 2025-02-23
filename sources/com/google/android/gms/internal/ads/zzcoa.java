package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcoa {
    private final String zza;
    private final zzbnx zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcof zzd;
    private final zzbix zze = new zzcnx(this);
    private final zzbix zzf = new zzcnz(this);

    public zzcoa(String str, zzbnx zzbnx, Executor executor) {
        this.zza = str;
        this.zzb = zzbnx;
        this.zzc = executor;
    }

    public static /* bridge */ /* synthetic */ boolean zzg(zzcoa zzcoa, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(zzcoa.zza)) {
            return false;
        }
        return true;
    }

    public final void zzc(zzcof zzcof) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcof;
    }

    public final void zzd(zzcej zzcej) {
        zzcej.zzag("/updateActiveView", this.zze);
        zzcej.zzag("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcej zzcej) {
        zzcej.zzaz("/updateActiveView", this.zze);
        zzcej.zzaz("/untrackActiveViewUnit", this.zzf);
    }
}
