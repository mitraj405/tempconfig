package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzau;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcvj implements zzful {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzffg zzc;

    public /* synthetic */ zzcvj(Context context, VersionInfoParcel versionInfoParcel, zzffg zzffg) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzffg;
    }

    public final Object apply(Object obj) {
        zzfel zzfel = (zzfel) obj;
        zzau zzau = new zzau(this.zza);
        zzau.zzp(zzfel.zzB);
        zzau.zzq(zzfel.zzC.toString());
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzn(this.zzc.zzf);
        return zzau;
    }
}
