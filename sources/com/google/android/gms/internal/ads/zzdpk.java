package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdpk {
    private final zzcwo zza;
    private final zzdeo zzb;
    /* access modifiers changed from: private */
    public final zzcxx zzc;
    private final zzcyk zzd;
    private final zzcyw zze;
    private final zzdbn zzf;
    private final Executor zzg;
    private final zzdek zzh;
    private final zzcof zzi;
    private final zzb zzj;
    private final zzbxl zzk;
    private final zzauo zzl;
    /* access modifiers changed from: private */
    public final zzdbe zzm;
    private final zzedh zzn;
    private final zzfll zzo;
    private final zzdsk zzp;
    private final zzcni zzq;
    private final zzdpq zzr;

    public zzdpk(zzcwo zzcwo, zzcxx zzcxx, zzcyk zzcyk, zzcyw zzcyw, zzdbn zzdbn, Executor executor, zzdek zzdek, zzcof zzcof, zzb zzb2, zzbxl zzbxl, zzauo zzauo, zzdbe zzdbe, zzedh zzedh, zzfll zzfll, zzdsk zzdsk, zzdeo zzdeo, zzcni zzcni, zzdpq zzdpq) {
        this.zza = zzcwo;
        this.zzc = zzcxx;
        this.zzd = zzcyk;
        this.zze = zzcyw;
        this.zzf = zzdbn;
        this.zzg = executor;
        this.zzh = zzdek;
        this.zzi = zzcof;
        this.zzj = zzb2;
        this.zzk = zzbxl;
        this.zzl = zzauo;
        this.zzm = zzdbe;
        this.zzn = zzedh;
        this.zzo = zzfll;
        this.zzp = zzdsk;
        this.zzb = zzdeo;
        this.zzq = zzcni;
        this.zzr = zzdpq;
    }

    public static final ListenableFuture zzj(zzcej zzcej, String str, String str2) {
        zzbzt zzbzt = new zzbzt();
        zzcej.zzN().zzB(new zzdpb(zzbzt));
        zzcej.zzae(str, str2, (String) null);
        return zzbzt;
    }

    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    public final /* synthetic */ void zzg(zzcej zzcej, zzcej zzcej2, Map map) {
        this.zzi.zzh(zzcej);
    }

    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzcej zzcej, boolean z, zzbja zzbja) {
        zzauk zzc2;
        zzcej zzcej2 = zzcej;
        zzcgb zzN = zzcej.zzN();
        zzdpc zzdpc = r4;
        zzdpc zzdpc2 = new zzdpc(this);
        zzdpd zzdpd = r4;
        zzdpd zzdpd2 = new zzdpd(this);
        zzdpe zzdpe = r4;
        zzdpe zzdpe2 = new zzdpe(this);
        zzdpj zzdpj = r4;
        zzdpj zzdpj2 = new zzdpj(this);
        zzbxl zzbxl = this.zzk;
        zzedh zzedh = this.zzn;
        zzfll zzfll = this.zzo;
        zzcyk zzcyk = this.zzd;
        zzdsk zzdsk = this.zzp;
        zzN.zzR(zzdpc, zzcyk, this.zze, zzdpd, zzdpe, z, zzbja, this.zzj, zzdpj, zzbxl, zzedh, zzfll, zzdsk, (zzbjr) null, this.zzb, (zzbjq) null, (zzbjk) null, (zzbiy) null, this.zzq);
        zzcej zzcej3 = zzcej;
        zzcej3.setOnTouchListener(new zzdpf(this));
        zzcej3.setOnClickListener(new zzdpg(this));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcq)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzo((View) zzcej3);
        }
        this.zzh.zzo(zzcej3, this.zzg);
        this.zzh.zzo(new zzdph(zzcej3), this.zzg);
        this.zzh.zza((View) zzcej3);
        zzcej3.zzag("/trackActiveViewUnit", new zzdpi(this, zzcej3));
        this.zzi.zzi(zzcej3);
    }
}
