package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzdfs {
    private final zzdgx zza;
    private final zzcej zzb;

    public zzdfs(zzdgx zzdgx, zzcej zzcej) {
        this.zza = zzdgx;
        this.zzb = zzcej;
    }

    public static final zzdei zzh(zzfjr zzfjr) {
        return new zzdei(zzfjr, zzbzo.zzf);
    }

    public static final zzdei zzi(zzdhc zzdhc) {
        return new zzdei(zzdhc, zzbzo.zzf);
    }

    public final View zza() {
        zzcej zzcej = this.zzb;
        if (zzcej == null) {
            return null;
        }
        return zzcej.zzG();
    }

    public final View zzb() {
        zzcej zzcej = this.zzb;
        if (zzcej != null) {
            return zzcej.zzG();
        }
        return null;
    }

    public final zzcej zzc() {
        return this.zzb;
    }

    public final zzdei zzd(Executor executor) {
        return new zzdei(new zzdfr(this.zzb), executor);
    }

    public final zzdgx zze() {
        return this.zza;
    }

    public Set zzf(zzcvn zzcvn) {
        return Collections.singleton(new zzdei(zzcvn, zzbzo.zzf));
    }

    public Set zzg(zzcvn zzcvn) {
        return Collections.singleton(new zzdei(zzcvn, zzbzo.zzf));
    }
}
