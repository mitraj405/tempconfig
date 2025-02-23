package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfw {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public /* synthetic */ zzfw(zzfy zzfy, zzfv zzfv) {
        this.zza = zzfy.zza;
        this.zzb = zzfy.zzd;
        this.zzc = zzfy.zze;
        this.zzd = zzfy.zzf;
        this.zze = zzfy.zzg;
    }

    public final zzfw zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzfw zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzfw zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzfw zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzfy zze() {
        if (this.zza != null) {
            return new zzfy(this.zza, 0, 1, (byte[]) null, this.zzb, this.zzc, this.zzd, (String) null, this.zze, (Object) null, (zzfx) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }

    public zzfw() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1;
    }
}
