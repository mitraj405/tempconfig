package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbp;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeln extends zzbp {
    final zzffe zza;
    final zzdjk zzb = new zzdjk();
    private final Context zzc;
    private final zzcgj zzd;
    private zzbh zze;

    public zzeln(zzcgj zzcgj, Context context, String str) {
        zzffe zzffe = new zzffe();
        this.zza = zzffe;
        this.zzd = zzcgj;
        zzffe.zzt(str);
        this.zzc = context;
    }

    public final zzbn zze() {
        zzdjm zzg = this.zzb.zzg();
        this.zza.zzE(zzg.zzi());
        this.zza.zzF(zzg.zzh());
        zzffe zzffe = this.zza;
        if (zzffe.zzh() == null) {
            zzffe.zzs(zzq.zzc());
        }
        return new zzelo(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbgb zzbgb) {
        this.zzb.zza(zzbgb);
    }

    public final void zzg(zzbge zzbge) {
        this.zzb.zzb(zzbge);
    }

    public final void zzh(String str, zzbgk zzbgk, zzbgh zzbgh) {
        this.zzb.zzc(str, zzbgk, zzbgh);
    }

    public final void zzi(zzblq zzblq) {
        this.zzb.zzd(zzblq);
    }

    public final void zzj(zzbgo zzbgo, zzq zzq) {
        this.zzb.zze(zzbgo);
        this.zza.zzs(zzq);
    }

    public final void zzk(zzbgr zzbgr) {
        this.zzb.zzf(zzbgr);
    }

    public final void zzl(zzbh zzbh) {
        this.zze = zzbh;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzn(zzblh zzblh) {
        this.zza.zzw(zzblh);
    }

    public final void zzo(zzbes zzbes) {
        this.zza.zzD(zzbes);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzG(publisherAdViewOptions);
    }

    public final void zzq(zzcf zzcf) {
        this.zza.zzV(zzcf);
    }
}
