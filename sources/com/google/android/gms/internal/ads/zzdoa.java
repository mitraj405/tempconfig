package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdoa {
    /* access modifiers changed from: private */
    public final zzdnn zza = new zzdnn();
    private final zza zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzdsk zzd;
    private final Executor zze;
    private final zzauo zzf;
    private final VersionInfoParcel zzg;
    private final zzbjn zzh = new zzbjn();
    /* access modifiers changed from: private */
    public final zzedh zzi;
    /* access modifiers changed from: private */
    public final zzfll zzj;
    private final zzeds zzk;
    private final zzffk zzl;
    private ListenableFuture zzm;

    public zzdoa(zzdnx zzdnx) {
        this.zzc = zzdnx.zzb;
        this.zze = zzdnx.zze;
        this.zzf = zzdnx.zzf;
        this.zzg = zzdnx.zzg;
        this.zzb = zzdnx.zza;
        this.zzi = zzdnx.zzd;
        this.zzj = zzdnx.zzh;
        this.zzd = zzdnx.zzc;
        this.zzk = zzdnx.zzi;
        this.zzl = zzdnx.zzj;
    }

    public final /* synthetic */ zzcej zza(zzcej zzcej) {
        zzcej zzcej2 = zzcej;
        zzcej2.zzag("/result", this.zzh);
        zzcgb zzN = zzcej.zzN();
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzc, (zzbxl) null, (zzbue) null);
        zzdnn zzdnn = this.zza;
        zzN.zzR((com.google.android.gms.ads.internal.client.zza) null, zzdnn, zzdnn, zzdnn, zzdnn, false, (zzbja) null, zzb2, (zzbrr) null, (zzbxl) null, this.zzi, this.zzj, this.zzd, (zzbjr) null, (zzdeq) null, (zzbjq) null, (zzbjk) null, (zzbiy) null, (zzcni) null);
        return zzcej2;
    }

    public final /* synthetic */ ListenableFuture zzf(String str, JSONObject jSONObject, zzcej zzcej) throws Exception {
        return this.zzh.zzb(zzcej, str, jSONObject);
    }

    public final synchronized ListenableFuture zzg(String str, JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzgcj.zzh((Object) null);
        }
        return zzgcj.zzn(listenableFuture, new zzdno(this, str, jSONObject), this.zze);
    }

    public final synchronized void zzh(zzfel zzfel, zzfeo zzfeo, zzcni zzcni) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgcj.zzr(listenableFuture, new zzdnu(this, zzfel, zzfeo, zzcni), this.zze);
        }
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgcj.zzr(listenableFuture, new zzdnq(this), this.zze);
            this.zzm = null;
        }
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgcj.zzr(listenableFuture, new zzdnt(this, "sendMessageToNativeJs", map), this.zze);
        }
    }

    public final synchronized void zzk() {
        zzbbn zzbbn = zzbbw.zzdr;
        ListenableFuture zzm2 = zzgcj.zzm(zzgcj.zzk(new zzceu(this.zzc, this.zzf, this.zzg, this.zzb, this.zzk, this.zzl, (String) zzba.zzc().zza(zzbbn)), zzbzo.zze), new zzdnp(this), this.zze);
        this.zzm = zzm2;
        zzbzr.zza(zzm2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbix zzbix) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgcj.zzr(listenableFuture, new zzdnr(this, str, zzbix), this.zze);
        }
    }

    public final void zzm(WeakReference weakReference, String str, zzbix zzbix) {
        zzl(str, new zzdnz(this, weakReference, str, zzbix, (zzdny) null));
    }

    public final synchronized void zzn(String str, zzbix zzbix) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgcj.zzr(listenableFuture, new zzdns(this, str, zzbix), this.zze);
        }
    }
}
