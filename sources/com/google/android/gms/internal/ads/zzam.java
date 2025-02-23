package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzam {
    private String zza;
    private Uri zzb;
    private final zzan zzc = new zzan();
    private final List zzd;
    private final zzfxr zze;
    private final zzat zzf;
    private final zzaz zzg;

    public zzam() {
        zzfxr.zzm();
        this.zzd = Collections.emptyList();
        this.zze = zzfxr.zzm();
        this.zzf = new zzat();
        this.zzg = zzaz.zza;
    }

    public final zzam zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzam zzb(Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzbc zzc() {
        zzax zzax;
        Uri uri = this.zzb;
        if (uri != null) {
            zzax = new zzax(uri, (String) null, (zzas) null, (zzal) null, this.zzd, (String) null, this.zze, (Object) null, -9223372036854775807L, (zzaw) null);
        } else {
            zzax = null;
        }
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzbc(str, new zzar(this.zzc, (zzaq) null), zzax, new zzav(this.zzf, (zzau) null), zzbh.zza, this.zzg, (zzbb) null);
    }
}
