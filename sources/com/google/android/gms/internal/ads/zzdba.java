package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdba implements AppEventListener, OnAdMetadataChangedListener, zzcwq, zza, zzczb, zzcxk, zzcyp, zzp, zzcxg, zzdeq {
    private final zzday zza = new zzday(this, (zzdax) null);
    /* access modifiers changed from: private */
    public zzemk zzb;
    /* access modifiers changed from: private */
    public zzemo zzc;
    /* access modifiers changed from: private */
    public zzfaj zzd;
    /* access modifiers changed from: private */
    public zzfdo zze;

    private static void zzn(Object obj, zzdaz zzdaz) {
        if (obj != null) {
            zzdaz.zza(obj);
        }
    }

    public final void onAdClicked() {
        zzn(this.zzb, new zzczq());
        zzn(this.zzc, new zzczr());
    }

    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzczw());
    }

    public final void onAppEvent(String str, String str2) {
        zzn(this.zzb, new zzdac(str, str2));
    }

    public final void zza() {
        zzn(this.zzb, new zzdav());
        zzn(this.zze, new zzdaw());
    }

    public final void zzb() {
        zzn(this.zzb, new zzdao());
        zzn(this.zze, new zzdap());
    }

    public final void zzc() {
        zzn(this.zzb, new zzczx());
        zzn(this.zze, new zzczy());
    }

    public final void zzdG() {
        zzn(this.zzb, new zzdal());
        zzn(this.zzc, new zzdaq());
        zzn(this.zze, new zzdar());
        zzn(this.zzd, new zzdas());
    }

    public final void zzdH() {
        zzn(this.zzd, new zzdaj());
    }

    public final void zzdf() {
        zzn(this.zzb, new zzdad());
    }

    public final void zzdk() {
        zzn(this.zzd, new zzczv());
    }

    public final void zzdq() {
        zzn(this.zzd, new zzdai());
    }

    public final void zzdr() {
        zzn(this.zzd, new zzdae());
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
        zzn(this.zzb, new zzczz(zzbvn, str, str2));
        zzn(this.zze, new zzdab(zzbvn, str, str2));
    }

    public final void zzdt() {
        zzn(this.zzd, new zzdak());
    }

    public final void zzdu(int i) {
        zzn(this.zzd, new zzdam(i));
    }

    public final void zze() {
        zzn(this.zzb, new zzczp());
        zzn(this.zze, new zzdaa());
    }

    public final void zzf() {
        zzn(this.zzb, new zzczs());
        zzn(this.zze, new zzczt());
    }

    public final void zzg() {
        zzn(this.zzd, new zzdan());
    }

    public final void zzh(zzs zzs) {
        zzn(this.zzb, new zzdaf(zzs));
        zzn(this.zze, new zzdag(zzs));
        zzn(this.zzd, new zzdah(zzs));
    }

    public final zzday zzi() {
        return this.zza;
    }

    public final void zzq(zze zze2) {
        zzn(this.zze, new zzdat(zze2));
        zzn(this.zzb, new zzdau(zze2));
    }

    public final void zzr() {
        zzn(this.zzb, new zzczu());
    }
}
