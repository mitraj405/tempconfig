package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzffg {
    public final zzfk zza;
    public final zzblh zzb;
    public final zzemk zzc;
    public final zzl zzd;
    public final zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbes zzi;
    public final zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzcb zzn;
    public final zzfet zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final zzcf zzt;

    public /* synthetic */ zzffg(zzffe zzffe, zzfff zzfff) {
        zzfk zzfk;
        zzbes zzbes;
        this.zze = zzffe.zzb;
        this.zzf = zzffe.zzc;
        this.zzt = zzffe.zzu;
        int i = zzffe.zza.zza;
        long j = zzffe.zza.zzb;
        Bundle bundle = zzffe.zza.zzc;
        int i2 = zzffe.zza.zzd;
        List list = zzffe.zza.zze;
        boolean z = zzffe.zza.zzf;
        int i3 = zzffe.zza.zzg;
        boolean z2 = true;
        if (!zzffe.zza.zzh && !zzffe.zze) {
            z2 = false;
        }
        this.zzd = new zzl(i, j, bundle, i2, list, z, i3, z2, zzffe.zza.zzi, zzffe.zza.zzj, zzffe.zza.zzk, zzffe.zza.zzl, zzffe.zza.zzm, zzffe.zza.zzn, zzffe.zza.zzo, zzffe.zza.zzp, zzffe.zza.zzq, zzffe.zza.zzr, zzffe.zza.zzs, zzffe.zza.zzt, zzffe.zza.zzu, zzffe.zza.zzv, zzt.zza(zzffe.zza.zzw), zzffe.zza.zzx, zzffe.zza.zzy, zzffe.zza.zzz);
        if (zzffe.zzd != null) {
            zzfk = zzffe.zzd;
        } else if (zzffe.zzh != null) {
            zzfk = zzffe.zzh.zzf;
        } else {
            zzfk = null;
        }
        this.zza = zzfk;
        this.zzg = zzffe.zzf;
        this.zzh = zzffe.zzg;
        if (zzffe.zzf == null) {
            zzbes = null;
        } else if (zzffe.zzh == null) {
            zzbes = new zzbes(new NativeAdOptions.Builder().build());
        } else {
            zzbes = zzffe.zzh;
        }
        this.zzi = zzbes;
        this.zzj = zzffe.zzi;
        this.zzk = zzffe.zzm;
        this.zzl = zzffe.zzj;
        this.zzm = zzffe.zzk;
        this.zzn = zzffe.zzl;
        this.zzb = zzffe.zzn;
        this.zzo = new zzfet(zzffe.zzo, (zzfes) null);
        this.zzp = zzffe.zzp;
        this.zzq = zzffe.zzq;
        this.zzc = zzffe.zzr;
        this.zzr = zzffe.zzs;
        this.zzs = zzffe.zzt;
    }

    public final zzbgu zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        zzbbn zzbbn = zzbbw.zzcP;
        return this.zzf.matches((String) zzba.zzc().zza(zzbbn));
    }
}
