package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzffe {
    /* access modifiers changed from: private */
    public zzl zza;
    /* access modifiers changed from: private */
    public zzq zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzfk zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList zzf;
    /* access modifiers changed from: private */
    public ArrayList zzg;
    /* access modifiers changed from: private */
    public zzbes zzh;
    /* access modifiers changed from: private */
    public zzw zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzcb zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzblh zzn;
    /* access modifiers changed from: private */
    public final zzfer zzo = new zzfer();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public boolean zzq = false;
    /* access modifiers changed from: private */
    public zzemk zzr;
    /* access modifiers changed from: private */
    public boolean zzs = false;
    /* access modifiers changed from: private */
    public Bundle zzt;
    /* access modifiers changed from: private */
    public zzcf zzu;

    public final zzffe zzA(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzffe zzB(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzffe zzC(int i) {
        this.zzm = i;
        return this;
    }

    public final zzffe zzD(zzbes zzbes) {
        this.zzh = zzbes;
        return this;
    }

    public final zzffe zzE(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzffe zzF(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzffe zzG(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzffe zzH(zzl zzl2) {
        this.zza = zzl2;
        return this;
    }

    public final zzffe zzI(zzfk zzfk) {
        this.zzd = zzfk;
        return this;
    }

    public final zzffg zzJ() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzffg(this, (zzfff) null);
    }

    public final String zzL() {
        return this.zzc;
    }

    public final boolean zzS() {
        return this.zzp;
    }

    public final boolean zzT() {
        return this.zzq;
    }

    public final zzffe zzV(zzcf zzcf) {
        this.zzu = zzcf;
        return this;
    }

    public final zzl zzf() {
        return this.zza;
    }

    public final zzq zzh() {
        return this.zzb;
    }

    public final zzfer zzp() {
        return this.zzo;
    }

    public final zzffe zzq(zzffg zzffg) {
        this.zzo.zza(zzffg.zzo.zza);
        this.zza = zzffg.zzd;
        this.zzb = zzffg.zze;
        this.zzu = zzffg.zzt;
        this.zzc = zzffg.zzf;
        this.zzd = zzffg.zza;
        this.zzf = zzffg.zzg;
        this.zzg = zzffg.zzh;
        this.zzh = zzffg.zzi;
        this.zzi = zzffg.zzj;
        zzr(zzffg.zzl);
        zzG(zzffg.zzm);
        this.zzp = zzffg.zzp;
        this.zzq = zzffg.zzq;
        this.zzr = zzffg.zzc;
        this.zzs = zzffg.zzr;
        this.zzt = zzffg.zzs;
        return this;
    }

    public final zzffe zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzffe zzs(zzq zzq2) {
        this.zzb = zzq2;
        return this;
    }

    public final zzffe zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzffe zzu(zzw zzw) {
        this.zzi = zzw;
        return this;
    }

    public final zzffe zzv(zzemk zzemk) {
        this.zzr = zzemk;
        return this;
    }

    public final zzffe zzw(zzblh zzblh) {
        this.zzn = zzblh;
        this.zzd = new zzfk(false, true, false);
        return this;
    }

    public final zzffe zzx(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzffe zzy(boolean z) {
        this.zzq = z;
        return this;
    }

    public final zzffe zzz(boolean z) {
        this.zzs = true;
        return this;
    }
}
