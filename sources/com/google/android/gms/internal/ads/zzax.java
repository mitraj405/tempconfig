package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzax {
    public final Uri zza;
    public final String zzb = null;
    public final zzas zzc = null;
    public final zzal zzd = null;
    public final List zze;
    public final String zzf;
    public final zzfxr zzg;
    public final Object zzh;
    public final long zzi;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    public /* synthetic */ zzax(Uri uri, String str, zzas zzas, zzal zzal, List list, String str2, zzfxr zzfxr, Object obj, long j, zzaw zzaw) {
        this.zza = uri;
        int i = zzbn.zza;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfxr;
        zzfxo zzfxo = new zzfxo();
        if (zzfxr.size() <= 0) {
            zzfxo.zzi();
            this.zzh = null;
            this.zzi = -9223372036854775807L;
            return;
        }
        zzba zzba = (zzba) zzfxr.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzax = (zzax) obj;
        if (!this.zza.equals(zzax.zza) || !zzet.zzG((Object) null, (Object) null) || !zzet.zzG((Object) null, (Object) null) || !zzet.zzG((Object) null, (Object) null) || !this.zze.equals(zzax.zze) || !zzet.zzG((Object) null, (Object) null) || !this.zzg.equals(zzax.zzg) || !zzet.zzG((Object) null, (Object) null) || !zzet.zzG(-9223372036854775807L, -9223372036854775807L)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = this.zze.hashCode();
        return (int) ((((long) ((this.zzg.hashCode() + ((hashCode + (this.zza.hashCode() * 923521)) * 961)) * 31)) * 31) - Long.MAX_VALUE);
    }
}
