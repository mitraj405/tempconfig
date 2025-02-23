package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxz extends zzbut {
    final /* synthetic */ zzdya zza;

    public zzdxz(zzdya zzdya) {
        this.zza = zzdya;
    }

    public final void zze(zzbb zzbb) {
        this.zza.zza.zzd(zzbb.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdya zzdya = this.zza;
        zzdya.zza.zzc(new zzdyq(autoCloseInputStream, zzdya.zze));
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvb zzbvb) {
        this.zza.zza.zzc(new zzdyq(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvb));
    }
}
