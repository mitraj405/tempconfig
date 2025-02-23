package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzcpr {
    private final zzcrs zza;
    private final View zzb;
    private final zzfem zzc;
    private final zzcej zzd;

    public zzcpr(View view, zzcej zzcej, zzcrs zzcrs, zzfem zzfem) {
        this.zzb = view;
        this.zzd = zzcej;
        this.zza = zzcrs;
        this.zzc = zzfem;
    }

    public static final zzdei zzf(Context context, VersionInfoParcel versionInfoParcel, zzfel zzfel, zzffg zzffg) {
        return new zzdei(new zzcpp(context, versionInfoParcel, zzfel, zzffg), zzbzo.zzf);
    }

    public static final Set zzg(zzcrj zzcrj) {
        return Collections.singleton(new zzdei(zzcrj, zzbzo.zzf));
    }

    public static final zzdei zzh(zzcrh zzcrh) {
        return new zzdei(zzcrh, zzbzo.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcej zzb() {
        return this.zzd;
    }

    public final zzcrs zzc() {
        return this.zza;
    }

    public zzcyc zzd(Set set) {
        return new zzcyc(set);
    }

    public final zzfem zze() {
        return this.zzc;
    }
}
